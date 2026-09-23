/**
 * Fluxnova x402 HTTP Connector
 *
 * Plugs into FINOS Fluxnova BPMN external workers and service connectors to
 * automatically negotiate RFC 9110 HTTP 402 challenges, enforce enterprise spend
 * allowances, and commit cryptographic settlement receipts to workflow state.
 */

import { createHash } from 'node:crypto';
import type {
  ConnectorResponse,
  FluxnovaProcessVariables,
  SettlementReceipt,
  SpendPolicy,
  X402Challenge,
} from './types.js';

export class FluxnovaX402Connector {
  private policy: SpendPolicy;
  private cumulativeSpend = new Map<string, number>();

  constructor(policy: SpendPolicy) {
    this.policy = policy;
  }

  /**
   * Parse an RFC 9110 HTTP 402 challenge from WWW-Authenticate or custom headers
   */
  public parseChallenge(headers: Record<string, string>, responseBody?: any): X402Challenge | null {
    const authHeader = headers['www-authenticate'] || headers['WWW-Authenticate'] || '';
    const paymentRequiredHeader = headers['payment-required'] || headers['Payment-Required'] || '';

    // If body contains standard x402 challenge payload
    if (responseBody && responseBody.amount && responseBody.recipient) {
      return {
        resource: responseBody.resource || responseBody.url || '',
        amount: responseBody.amount.toString(),
        asset: responseBody.asset || 'USDC',
        network: responseBody.network || 'algorand',
        recipient: responseBody.recipient,
        nonce: responseBody.nonce || Date.now().toString(),
        scheme: responseBody.scheme || 'x402'
      };
    }

    if (authHeader.startsWith('x402 ') || authHeader.startsWith('X402 ')) {
      const parts = authHeader.substring(5).split(',').map(s => s.trim());
      const dict: Record<string, string> = {};
      for (const part of parts) {
        const [k, v] = part.split('=');
        if (k && v) {
          dict[k.trim()] = v.replace(/^"|"$/g, '').trim();
        }
      }
      return {
        resource: dict.resource || '',
        amount: dict.amount || '0.01',
        asset: dict.asset || 'USDC',
        network: dict.network || 'algorand',
        recipient: dict.recipient || dict.payTo || '',
        nonce: dict.nonce || Date.now().toString(),
        scheme: 'x402',
        rawHeaders: headers
      };
    }

    if (paymentRequiredHeader) {
      try {
        const parsed = JSON.parse(paymentRequiredHeader);
        return {
          resource: parsed.resource || '',
          amount: parsed.amount || '0.01',
          asset: parsed.asset || 'USDC',
          network: parsed.network || 'algorand',
          recipient: parsed.recipient || parsed.payTo || '',
          nonce: parsed.nonce || Date.now().toString()
        };
      } catch {
        // Not JSON
      }
    }

    return null;
  }

  /**
   * Enforces enterprise spending caps per transaction and per process instance
   */
  public verifyBudget(processInstanceId: string, amountUsdStr: string): void {
    const amount = parseFloat(amountUsdStr);
    const maxSingle = parseFloat(this.policy.maxSingleSpendUsd);
    const maxCumulative = parseFloat(this.policy.maxCumulativeSpendUsd);

    if (isNaN(amount) || amount <= 0) {
      throw new Error(`Invalid spend amount: ${amountUsdStr}`);
    }

    if (amount > maxSingle) {
      throw new Error(
        `[SpendPolicyViolation] Single transaction amount $${amount.toFixed(4)} exceeds allowed maximum of $${maxSingle.toFixed(4)}`
      );
    }

    const currentTotal = this.cumulativeSpend.get(processInstanceId) || 0;
    const newTotal = Math.round((currentTotal + amount) * 1000000) / 1000000;

    if (newTotal > maxCumulative) {
      throw new Error(
        `[SpendPolicyViolation] Cumulative process spend $${newTotal.toFixed(4)} exceeds allowed instance budget of $${maxCumulative.toFixed(4)}`
      );
    }
  }

  /**
   * Execute micro-settlement for an authorized challenge
   */
  public async settleChallenge(
    processInstanceId: string,
    challenge: X402Challenge
  ): Promise<{ token: string; receipt: SettlementReceipt }> {
    this.verifyBudget(processInstanceId, challenge.amount);

    let authorizationToken: string;
    if (this.policy.signer) {
      authorizationToken = await this.policy.signer(challenge);
    } else {
      // Deterministic signature/token for automated testing and simulation
      const rawPayload = `${challenge.nonce}:${challenge.amount}:${challenge.recipient}:${this.policy.payerAddress}`;
      authorizationToken = `x402_sig_${createHash('sha256').update(rawPayload).digest('hex')}`;
    }

    const txHash = `tx_${createHash('sha256').update(authorizationToken + Date.now()).digest('hex').substring(0, 32)}`;
    const scittDigest = createHash('sha256')
      .update(`${txHash}:${challenge.amount}:${challenge.recipient}:${processInstanceId}`)
      .digest('hex');

    const receipt: SettlementReceipt = {
      status: 'settled',
      txHash,
      network: challenge.network,
      amount: challenge.amount,
      asset: challenge.asset,
      payer: this.policy.payerAddress,
      recipient: challenge.recipient,
      scittAnchor: `x402ev/1:sha256:${scittDigest}`,
      timestamp: new Date().toISOString()
    };

    // Commit to in-memory spend accumulator
    const current = this.cumulativeSpend.get(processInstanceId) || 0;
    this.cumulativeSpend.set(
      processInstanceId,
      Math.round((current + parseFloat(challenge.amount)) * 1000000) / 1000000
    );

    return { token: authorizationToken, receipt };
  }

  /**
   * Converts a settlement receipt into Fluxnova BPMN process variables
   */
  public toProcessVariables(receipt: SettlementReceipt): FluxnovaProcessVariables {
    return {
      x402_settlement_status: { type: 'String', value: receipt.status },
      x402_settlement_tx: { type: 'String', value: receipt.txHash },
      x402_settlement_network: { type: 'String', value: receipt.network },
      x402_settlement_amount: { type: 'String', value: receipt.amount },
      x402_settlement_scitt_anchor: { type: 'String', value: receipt.scittAnchor },
      x402_settlement_timestamp: { type: 'String', value: receipt.timestamp }
    };
  }

  /**
   * Resets or inspects process instance spend
   */
  public getSpend(processInstanceId: string): number {
    return this.cumulativeSpend.get(processInstanceId) || 0;
  }
}
