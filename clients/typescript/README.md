# FINOS Fluxnova TypeScript Client

> Official TypeScript / Node.js Client with x402 HTTP Connector and Model Context Protocol (MCP) Worker for FINOS Fluxnova BPMN Platforms.

[![License: Apache-2.0](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![FINOS](https://img.shields.io/badge/FINOS-Project-green.svg)](https://finos.org)

## Overview

When enterprise banking workflows running on Fluxnova BPM engines (Fidelity, Deutsche Bank, NatWest, Capital One, BMO) delegate tasks to autonomous AI agents, external risk scoring APIs, or confidential inference nodes, there is traditionally **no native micro-metering or automated settlement layer**.

The `@finos/fluxnova-client` provides:

1. **Automated RFC 9110 HTTP 402 Negotiation**: Intercepts `402 Payment Required` challenges from external AI agents and paid APIs.
2. **Deterministic Spend Allowances**: Enforces hard ceilings on single-transaction spend (`maxSingleSpendUsd`) and cumulative process instance budgets (`maxCumulativeSpendUsd`), neutralizing the *"Token Panic / Runaway Agent Loop"* risk identified by the Linux Foundation & FINOS.
3. **SCITT L1 Receipt Anchoring**: Automatically records an immutable Layer-1 transparency receipt anchor (`x402ev/1:sha256:...`) directly into the BPMN process instance execution variables for regulatory auditability.
4. **Model Context Protocol (MCP) Server**: Exposes 5 standardized JSON-RPC tools for AI assistants (Claude, Gemini) to inspect and complete workflow tasks under human-in-the-loop governance.

## Installation

```bash
npm install @finos/fluxnova-client
```

## Quickstart: External Task Worker with x402 Spend Bounds

```typescript
import { FluxnovaX402Worker } from '@finos/fluxnova-client';

const worker = new FluxnovaX402Worker({
  engineUrl: 'http://localhost:8080/engine-rest',
  workerId: 'credit-risk-agent-worker',
  topic: 'ai-credit-assessment',
  spendPolicy: {
    maxSingleSpendUsd: '0.10',
    maxCumulativeSpendUsd: '2.00',
    payerAddress: '7X62YXQK...NP64'
  }
});

// Executes step, negotiates 402 challenge, and yields SCITT receipt
const result = await worker.executeTask(task, 'https://risk-agent.bank.com/assess');
console.log(result.variables.x402_settlement_scitt_anchor);
// -> "x402ev/1:sha256:4a8c9..."
```

## License

Apache-2.0. Copyright FINOS & Corrente Labs, Inc.
