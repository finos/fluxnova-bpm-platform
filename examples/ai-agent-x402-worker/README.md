# Example: Autonomous AI Agent with x402 Spend Bounds

This example demonstrates how an enterprise bank running FINOS Fluxnova delegates a credit risk evaluation task to an external autonomous AI agent with **strict single-transaction and cumulative process spend ceilings**.

## Workflow Architecture

1. **BPMN Engine**: Generates an external task on topic `ai-credit-assessment`.
2. **Fluxnova Worker**: Polls the topic and invokes the external AI agent API.
3. **HTTP 402 Negotiation**: The agent returns `HTTP 402 Payment Required` with a \$0.05 fee.
4. **Spend Guard Enforcement**:
   - The worker verifies the \$0.05 fee does not exceed `maxSingleSpendUsd` (\$0.10).
   - The worker verifies the cumulative spend does not exceed `maxCumulativeSpendUsd` (\$1.00).
5. **Execution & Audit Binding**: The worker settles the challenge and commits the SCITT L1 audit receipt (`x402ev/1:sha256:...`) to the process instance execution variables.

## Running the Example

```bash
cd clients/typescript
npm install
npm run build
npx tsx ../../examples/ai-agent-x402-worker/index.ts
```
