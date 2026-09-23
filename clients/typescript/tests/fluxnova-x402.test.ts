import { describe, it, expect } from 'vitest';
import { FluxnovaX402Connector, FluxnovaX402Worker } from '../src/index.js';

describe('FINOS Fluxnova x402 Connector & Worker', () => {
  const testPolicy = {
    maxSingleSpendUsd: '0.05',
    maxCumulativeSpendUsd: '0.15',
    payerAddress: '7X62YXQKALGOENTERPRISETESTNETNP64'
  };

  it('correctly parses RFC 9110 HTTP 402 challenges from WWW-Authenticate header', () => {
    const connector = new FluxnovaX402Connector(testPolicy);
    const challenge = connector.parseChallenge({
      'www-authenticate': 'x402 resource="https://api.example.com/score", amount="0.02", asset="USDC", recipient="RECIPIENT_MERCHANT_KEY", nonce="12345"'
    });

    expect(challenge).not.toBeNull();
    expect(challenge?.amount).toBe('0.02');
    expect(challenge?.asset).toBe('USDC');
    expect(challenge?.recipient).toBe('RECIPIENT_MERCHANT_KEY');
    expect(challenge?.nonce).toBe('12345');
  });

  it('enforces spend caps and rejects transactions exceeding maxSingleSpendUsd', () => {
    const connector = new FluxnovaX402Connector(testPolicy);
    expect(() => {
      connector.verifyBudget('proc_instance_1', '0.06');
    }).toThrow(/exceeds allowed maximum of \$0.0500/);
  });

  it('enforces cumulative budget ceiling across multiple transactions within a process instance', async () => {
    const connector = new FluxnovaX402Connector(testPolicy);
    // Spend 1: $0.05 (allowed)
    connector.verifyBudget('proc_instance_1', '0.05');
    // Simulate settlement 1
    await connector.settleChallenge('proc_instance_1', {
      resource: 'res1',
      amount: '0.05',
      asset: 'USDC',
      network: 'algorand',
      recipient: 'addr1',
      nonce: 'n1'
    });

    // Spend 2: $0.05 (total $0.10, allowed)
    await connector.settleChallenge('proc_instance_1', {
      resource: 'res2',
      amount: '0.05',
      asset: 'USDC',
      network: 'algorand',
      recipient: 'addr1',
      nonce: 'n2'
    });

    // Spend 3: $0.05 (total $0.15, at cap)
    await connector.settleChallenge('proc_instance_1', {
      resource: 'res3',
      amount: '0.05',
      asset: 'USDC',
      network: 'algorand',
      recipient: 'addr1',
      nonce: 'n3'
    });

    // Spend 4: $0.01 (total would be $0.16 > $0.15 limit -> throws)
    expect(() => {
      connector.verifyBudget('proc_instance_1', '0.01');
    }).toThrow(/exceeds allowed instance budget of \$0.1500/);
  });

  it('generates cryptographic SCITT L1 anchor and converts to Fluxnova process variables', async () => {
    const connector = new FluxnovaX402Connector(testPolicy);
    const { token, receipt } = await connector.settleChallenge('proc_instance_2', {
      resource: 'https://agent.finos.org/audit',
      amount: '0.01',
      asset: 'USDC',
      network: 'algorand',
      recipient: 'MERCHANT_WALLET',
      nonce: 'audit_nonce_99'
    });

    expect(token).toContain('x402_sig_');
    expect(receipt.status).toBe('settled');
    expect(receipt.scittAnchor).toMatch(/^x402ev\/1:sha256:[a-f0-9]{64}$/);

    const variables = connector.toProcessVariables(receipt);
    expect(variables.x402_settlement_status.value).toBe('settled');
    expect(variables.x402_settlement_amount.value).toBe('0.01');
    expect(variables.x402_settlement_scitt_anchor.value).toBe(receipt.scittAnchor);
  });

  it('FluxnovaX402Worker autonomously handles 402 challenge-retry loop', async () => {
    let callCount = 0;
    const mockHttpClient = async (url: string, init?: RequestInit): Promise<Response> => {
      callCount++;
      if (callCount === 1) {
        // First call: return 402 Payment Required
        return new Response(JSON.stringify({
          error: 'Payment Required',
          amount: '0.025',
          recipient: 'AGENT_NODE_ACCOUNT',
          asset: 'USDC',
          network: 'algorand'
        }), {
          status: 402,
          headers: {
            'content-type': 'application/json',
            'www-authenticate': 'x402 resource="https://ai.example.com", amount="0.025", asset="USDC", recipient="AGENT_NODE_ACCOUNT", nonce="round_1"'
          }
        });
      } else {
        // Second call: check that authorization header is present
        const auth = (init?.headers as Record<string, string>)?.['Authorization'];
        if (!auth || !auth.startsWith('x402 ')) {
          return new Response('Unauthorized', { status: 401 });
        }
        return new Response(JSON.stringify({
          decision: 'APPROVED',
          riskScore: 12,
          notes: 'Model evaluated cleanly'
        }), {
          status: 200,
          headers: { 'content-type': 'application/json' }
        });
      }
    };

    const worker = new FluxnovaX402Worker({
      engineUrl: 'http://localhost:8080/engine-rest',
      workerId: 'worker_test_1',
      topic: 'ai_risk_score',
      spendPolicy: testPolicy,
      httpClient: mockHttpClient
    });

    const result = await worker.executeTask(
      {
        id: 'task_101',
        workerId: 'worker_test_1',
        topicName: 'ai_risk_score',
        processInstanceId: 'proc_abc_1',
        variables: {}
      },
      'https://ai.example.com/evaluate'
    );

    expect(callCount).toBe(2);
    expect(result.status).toBe('completed');
    expect(result.data.decision).toBe('APPROVED');
    expect(result.receipt?.amount).toBe('0.025');
    expect(result.variables.x402_settlement_status.value).toBe('settled');
    expect(result.variables.x402_settlement_scitt_anchor.value).toMatch(/^x402ev\/1:sha256:/);
  });
});
