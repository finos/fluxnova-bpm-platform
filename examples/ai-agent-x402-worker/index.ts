/**
 * FINOS Fluxnova BPMN Platform — Governed AI Agent External Task Example
 *
 * Demonstrates:
 * 1. Fetching an external task from Fluxnova BPMN workflow.
 * 2. Invoking an external AI model inference endpoint.
 * 3. Handling RFC 9110 HTTP 402 Payment Required negotiation.
 * 4. Enforcing process spend policy bounds (single-spend & cumulative).
 * 5. Committing cryptographic SCITT L1 receipts into Fluxnova process variables.
 *
 * (C) 2026 Corrente Applied Cryptography Group / FINOS Community (Apache-2.0)
 */

import { FluxnovaX402Worker } from '../../clients/typescript/src/index.js';
import type { FluxnovaExternalTask } from '../../clients/typescript/src/types.js';

async function main() {
  console.log('='.repeat(72));
  console.log('🏛️  FINOS FLUXNOVA BPMN — GOVERNED AI AGENT EXTERNAL TASK WORKER');
  console.log('   Enforcing deterministic spend bounds & verifiable SCITT receipts');
  console.log('='.repeat(72));
  console.log();

  // 1. Configure Enterprise Spend Policy
  const spendPolicy = {
    maxSingleSpendUsd: '0.10',
    maxCumulativeSpendUsd: '1.00',
    payerAddress: '7X62YXQKALGOENTERPRISETESTNETNP64',
    allowedRails: ['algorand' as const, 'base' as const, 'simulated' as const]
  };

  console.log('📋 Loaded Process Spend Policy:');
  console.log(`   - Max Single Task Spend:     $${spendPolicy.maxSingleSpendUsd}`);
  console.log(`   - Max Cumulative Spend:      $${spendPolicy.maxCumulativeSpendUsd}`);
  console.log(`   - Payer Institutional Vault: ${spendPolicy.payerAddress}`);
  console.log();

  // Mock AI Inference Service state
  let paymentReceived = false;
  const mockAiEndpoint = 'https://ai-inference.internal.bank/v1/credit-assessment';

  // Custom HTTP Client simulating HTTP 402 AI Agent Endpoint
  const mockHttpClient = async (url: string, init?: RequestInit): Promise<Response> => {
    const auth = (init?.headers as Record<string, string>)?.['Authorization'] || '';

    if (!paymentReceived && !auth.startsWith('x402')) {
      // Step 2: Return HTTP 402 Payment Required
      return new Response(JSON.stringify({
        error: 'Payment Required',
        detail: 'Inference requires $0.05 fee for neural credit risk evaluation'
      }), {
        status: 402,
        statusText: 'Payment Required',
        headers: {
          'Content-Type': 'application/json',
          'WWW-Authenticate': 'x402 resource="' + mockAiEndpoint + '", amount="0.05", asset="USDC", network="algorand", recipient="AI_MERCHANT_AGENT_VAULT", nonce="mock-nonce-44819"'
        }
      });
    }

    // Step 4: After payment authorization, perform neural inference
    paymentReceived = true;
    return new Response(JSON.stringify({
      borrowerId: 'CORP-8842-US',
      riskScore: 745,
      ratingGrade: 'AA-',
      recommendation: 'APPROVE',
      confidence: 0.942,
      modelAttestation: 'corbel.enclave.tdx:quote-sha256-verified',
      timestamp: new Date().toISOString()
    }), {
      status: 200,
      statusText: 'OK',
      headers: { 'Content-Type': 'application/json' }
    });
  };

  // 2. Instantiate Fluxnova x402 Worker
  const worker = new FluxnovaX402Worker({
    engineUrl: 'http://localhost:8080/engine-rest',
    workerId: 'risk-agent-worker-01',
    topic: 'ai-credit-assessment',
    spendPolicy,
    httpClient: mockHttpClient
  });

  // Simulated task locked from BPMN Engine
  const sampleTask: FluxnovaExternalTask = {
    id: 'task-loan-9941',
    workerId: 'risk-agent-worker-01',
    topicName: 'ai-credit-assessment',
    processInstanceId: 'proc-inst-credit-2026-001',
    processDefinitionId: 'Process_AiCreditRiskAssessment:1',
    activityId: 'Task_AiCreditAssessment',
    variables: {
      borrowerId: { type: 'String', value: 'CORP-8842-US' },
      loanAmount: { type: 'Double', value: 250000.0 },
      requestedTenorMonths: { type: 'Integer', value: 36 }
    }
  };

  console.log(`⚡ Received External Task: [${sampleTask.id}] on topic [${sampleTask.topicName}]`);
  console.log(`   Process Instance: ${sampleTask.processInstanceId}`);
  console.log(`   Borrower: ${sampleTask.variables.borrowerId.value}, Loan: $${sampleTask.variables.loanAmount.value}`);
  console.log();

  // 3. Execute Task with Governed Micropayment Negotiation
  console.log('🔄 Executing task via FluxnovaX402Worker...');
  const result = await worker.executeTask(sampleTask, mockAiEndpoint, {
    method: 'POST',
    body: JSON.stringify({
      borrowerId: sampleTask.variables.borrowerId.value,
      loanAmount: sampleTask.variables.loanAmount.value
    })
  });

  if (result.status === 'completed') {
    console.log('✅ Task Successfully Executed & Completed!');
    console.log();
    console.log('📊 AI Inference Output:');
    console.log(`   - Risk Score:     ${result.data.riskScore} (${result.data.ratingGrade})`);
    console.log(`   - Recommendation: ${result.data.recommendation}`);
    console.log(`   - Confidence:     ${(result.data.confidence * 100).toFixed(1)}%`);
    console.log();
    console.log('🔒 Cryptographic Settlement Audit (Bound to BPMN Engine Variables):');
    console.log(`   - Cost:           $${result.variables['x402_settlement_cost_usd']?.value}`);
    console.log(`   - Status:         ${result.variables['x402_settlement_status']?.value}`);
    console.log(`   - Tx Hash:        ${result.variables['x402_settlement_tx_hash']?.value}`);
    console.log(`   - SCITT Anchor:   ${result.variables['x402_settlement_scitt_anchor']?.value}`);
    console.log();
  } else {
    console.error('❌ Task Execution Failed:', result.error);
    process.exit(1);
  }

  // 4. Test Policy Rejection (Simulating a Rogue / Overpriced Endpoint)
  console.log('-'.repeat(72));
  console.log('🛡️  Testing Spend Bound Enforcement Against Rogue AI Agent ($0.50 requested)...');
  const rogueHttpClient = async (): Promise<Response> => {
    return new Response(JSON.stringify({ error: 'Payment Required' }), {
      status: 402,
      statusText: 'Payment Required',
      headers: {
        'WWW-Authenticate': 'x402 resource="https://rogue-ai.example.com", amount="0.50", asset="USDC", network="algorand", recipient="ROGUE", nonce="123"'
      }
    });
  };

  const guardedWorker = new FluxnovaX402Worker({
    engineUrl: 'http://localhost:8080/engine-rest',
    workerId: 'risk-agent-worker-01',
    topic: 'ai-credit-assessment',
    spendPolicy,
    httpClient: rogueHttpClient
  });

  const rogueResult = await guardedWorker.executeTask(sampleTask, 'https://rogue-ai.example.com');
  if (rogueResult.status === 'failed') {
    console.log('✅ Rogue Transaction Successfully Blocked by Spend Policy:');
    console.log(`   Reason: "${rogueResult.error}"`);
    console.log(`   Fluxnova State: Task failed cleanly, preventing treasury drain.`);
  } else {
    console.error('❌ Error: Spend policy failed to block rogue transaction!');
    process.exit(1);
  }

  console.log();
  console.log('='.repeat(72));
  console.log('🏁 All Fluxnova x402 Enterprise Governance Checks Verified.');
  console.log('='.repeat(72));
}

main().catch(console.error);
