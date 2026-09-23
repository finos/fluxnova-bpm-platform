/**
 * Fluxnova x402 External Task Worker
 *
 * Implements the Camunda/Fluxnova External Task protocol (fetchAndLock, complete, handleFailure)
 * equipped with autonomous x402 micro-settlement capabilities.
 */

import { FluxnovaX402Connector } from './connector.js';
import type {
  FluxnovaExternalTask,
  FluxnovaProcessVariables,
  SettlementReceipt,
  SpendPolicy
} from './types.js';

export interface WorkerOptions {
  engineUrl: string;
  workerId: string;
  topic: string;
  lockDurationMs?: number;
  spendPolicy: SpendPolicy;
  httpClient?: (url: string, init?: RequestInit) => Promise<Response>;
}

export class FluxnovaX402Worker {
  private options: Required<Omit<WorkerOptions, 'httpClient'>> & {
    httpClient: (url: string, init?: RequestInit) => Promise<Response>;
  };
  private connector: FluxnovaX402Connector;
  private isRunning = false;

  constructor(options: WorkerOptions) {
    this.options = {
      engineUrl: options.engineUrl.replace(/\/$/, ''),
      workerId: options.workerId,
      topic: options.topic,
      lockDurationMs: options.lockDurationMs || 30000,
      spendPolicy: options.spendPolicy,
      httpClient: options.httpClient || fetch
    };
    this.connector = new FluxnovaX402Connector(options.spendPolicy);
  }

  /**
   * Executes a single task step: calls target endpoint, handles 402 challenge,
   * retries with proof, and yields result with process variables.
   */
  public async executeTask(
    task: FluxnovaExternalTask,
    targetUrl: string,
    requestInit: RequestInit = {}
  ): Promise<{
    status: 'completed' | 'failed';
    data?: any;
    receipt?: SettlementReceipt;
    variables: FluxnovaProcessVariables;
    error?: string;
  }> {
    try {
      let headers: Record<string, string> = {
        'Content-Type': 'application/json',
        ...(requestInit.headers as Record<string, string> || {})
      };

      // Step 1: Initial call to target agent or service
      let res = await this.options.httpClient(targetUrl, {
        ...requestInit,
        headers
      });

      let receipt: SettlementReceipt | undefined;

      // Step 2: Detect HTTP 402 Payment Required
      if (res.status === 402) {
        const resHeaders: Record<string, string> = {};
        res.headers.forEach((v, k) => {
          resHeaders[k.toLowerCase()] = v;
        });

        let bodyJson: any = null;
        try {
          bodyJson = await res.json();
        } catch {
          // not JSON
        }

        const challenge = this.connector.parseChallenge(resHeaders, bodyJson);
        if (!challenge) {
          throw new Error('Received 402 Payment Required but failed to parse x402 challenge');
        }

        // Step 3: Negotiate challenge and settle micropayment
        const settlement = await this.connector.settleChallenge(task.processInstanceId, challenge);
        receipt = settlement.receipt;

        // Step 4: Retry request with signed authorization
        headers['Authorization'] = `x402 ${settlement.token}`;
        headers['X-Payment'] = settlement.token;

        res = await this.options.httpClient(targetUrl, {
          ...requestInit,
          headers
        });
      }

      if (!res.ok) {
        throw new Error(`Target returned status ${res.status}: ${res.statusText}`);
      }

      const responseData = await res.json().catch(() => ({ status: 'ok' }));

      // Step 5: Construct enriched process variables including L1 SCITT receipt
      const resultVariables: FluxnovaProcessVariables = {
        task_output: { type: 'Json', value: JSON.stringify(responseData) },
        ...(receipt ? this.connector.toProcessVariables(receipt) : {})
      };

      return {
        status: 'completed',
        data: responseData,
        receipt,
        variables: resultVariables
      };
    } catch (err: any) {
      return {
        status: 'failed',
        error: err?.message || String(err),
        variables: {
          x402_settlement_status: { type: 'String', value: 'failed' },
          x402_settlement_error: { type: 'String', value: err?.message || String(err) }
        }
      };
    }
  }

  public getConnector(): FluxnovaX402Connector {
    return this.connector;
  }
}
