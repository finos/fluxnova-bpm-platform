/**
 * Type definitions for @correntelabs/fluxnova-x402
 * FINOS Fluxnova BPMN & x402 Micropayment Integration
 */

export interface FluxnovaVariable {
  type: 'String' | 'Integer' | 'Long' | 'Double' | 'Boolean' | 'Json';
  value: any;
  valueInfo?: Record<string, any>;
}

export interface FluxnovaProcessVariables {
  [key: string]: FluxnovaVariable;
}

export interface FluxnovaExternalTask {
  id: string;
  workerId: string;
  topicName: string;
  processInstanceId: string;
  processDefinitionId?: string;
  activityId?: string;
  retries?: number;
  errorMessage?: string;
  variables: FluxnovaProcessVariables;
}

export interface SpendPolicy {
  /** Maximum allowable single transaction amount (USD decimal string e.g. "0.05") */
  maxSingleSpendUsd: string;
  /** Maximum cumulative spend per process instance (USD decimal string e.g. "5.00") */
  maxCumulativeSpendUsd: string;
  /** Allowed settlement payment rails */
  allowedRails?: ('algorand' | 'flare' | 'base' | 'xrpl' | 'simulated')[];
  /** Payer address or account abstraction identifier */
  payerAddress: string;
  /** Private key or signer delegate for micro-allowances */
  signer?: (challenge: X402Challenge) => Promise<string>;
}

export interface X402Challenge {
  resource: string;
  amount: string;
  asset: string;
  network: string;
  recipient: string;
  nonce: string;
  scheme?: string;
  rawHeaders?: Record<string, string>;
}

export interface SettlementReceipt {
  status: 'settled' | 'pending' | 'failed';
  txHash: string;
  network: string;
  amount: string;
  asset: string;
  payer: string;
  recipient: string;
  scittAnchor: string; // e.g., "x402ev/1:sha256:..."
  timestamp: string;
}

export interface ConnectorResponse<T = any> {
  statusCode: number;
  data: T;
  headers: Record<string, string>;
  receipt?: SettlementReceipt;
  retryCount: number;
}
