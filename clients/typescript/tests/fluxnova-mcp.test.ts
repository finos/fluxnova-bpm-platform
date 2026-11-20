import { describe, it, expect, beforeEach } from 'vitest';
import { FluxnovaMcpServer } from '../src/index.js';

describe('FINOS Fluxnova Model Context Protocol (MCP) Server', () => {
  let server: FluxnovaMcpServer;

  beforeEach(() => {
    server = new FluxnovaMcpServer();
  });

  it('exposes all 5 standardized Fluxnova tools in listTools', () => {
    const tools = server.listTools();
    expect(tools.length).toBe(5);

    const names = tools.map(t => t.name);
    expect(names).toContain('fluxnova_list_tasks');
    expect(names).toContain('fluxnova_claim_task');
    expect(names).toContain('fluxnova_complete_task');
    expect(names).toContain('fluxnova_evaluate_dmn');
    expect(names).toContain('fluxnova_start_process');
  });

  it('triggers a banking process instance via fluxnova_start_process', async () => {
    const res = await server.handleToolCall({
      jsonrpc: '2.0',
      id: 1,
      method: 'tools/call',
      params: {
        name: 'fluxnova_start_process',
        arguments: {
          processDefinitionKey: 'commercial-wire-approval',
          businessKey: 'WIRE-2026-0921-88',
          variables: { transferAmount: 250000, currency: 'USD' }
        }
      }
    });

    expect(res.error).toBeUndefined();
    const contentText = res.result?.content[0].text || '';
    const data = JSON.parse(contentText);
    expect(data.businessKey).toBe('WIRE-2026-0921-88');
    expect(data.status).toBe('active');
    expect(data.processInstanceId).toMatch(/^inst_/);
  });

  it('filters and claims tasks with concurrency protection', async () => {
    // Seed test tasks
    server.seedTask({
      id: 'task_low',
      name: 'Verify Address',
      assignee: null,
      created: new Date().toISOString(),
      priority: 20,
      processInstanceId: 'inst_1',
      processDefinitionId: 'kyc-check:1',
      taskDefinitionKey: 'step_addr',
      status: 'pending',
      variables: {}
    });

    server.seedTask({
      id: 'task_high',
      name: 'Approve Fraud Alert',
      assignee: null,
      created: new Date().toISOString(),
      priority: 85,
      processInstanceId: 'inst_2',
      processDefinitionId: 'fraud-review:1',
      taskDefinitionKey: 'step_alert',
      status: 'pending',
      variables: { flaggedIp: '192.0.2.1' }
    });

    // List tasks with priority >= 50
    const listRes = await server.handleToolCall({
      jsonrpc: '2.0',
      id: 2,
      method: 'tools/call',
      params: {
        name: 'fluxnova_list_tasks',
        arguments: { minPriority: 50 }
      }
    });

    const tasks = JSON.parse(listRes.result?.content[0].text || '[]');
    expect(tasks.length).toBe(1);
    expect(tasks[0].id).toBe('task_high');

    // Claim task by Agent-Claude-1
    const claimRes = await server.handleToolCall({
      jsonrpc: '2.0',
      id: 3,
      method: 'tools/call',
      params: {
        name: 'fluxnova_claim_task',
        arguments: { taskId: 'task_high', agentId: 'Agent-Claude-1' }
      }
    });

    expect(claimRes.error).toBeUndefined();
    const claimData = JSON.parse(claimRes.result?.content[0].text || '{}');
    expect(claimData.task.status).toBe('claimed');
    expect(claimData.task.claimedBy).toBe('Agent-Claude-1');

    // Attempt second claim by Agent-Gemini-2 -> fails
    const conflictRes = await server.handleToolCall({
      jsonrpc: '2.0',
      id: 4,
      method: 'tools/call',
      params: {
        name: 'fluxnova_claim_task',
        arguments: { taskId: 'task_high', agentId: 'Agent-Gemini-2' }
      }
    });

    expect(conflictRes.result?.isError).toBe(true);
    expect(conflictRes.result?.content[0].text).toContain('already claimed by agent');
  });

  it('completes tasks and evaluates DMN decision rules deterministically', async () => {
    server.seedTask({
      id: 'task_decision_1',
      name: 'Credit Risk Analysis',
      assignee: 'Agent-Analyst-3',
      created: new Date().toISOString(),
      priority: 60,
      processInstanceId: 'inst_credit_9',
      processDefinitionId: 'underwriting:1',
      taskDefinitionKey: 'evaluate_risk',
      status: 'claimed',
      claimedBy: 'Agent-Analyst-3',
      variables: {}
    });

    // Evaluate DMN rule table
    const dmnRes = await server.handleToolCall({
      jsonrpc: '2.0',
      id: 5,
      method: 'tools/call',
      params: {
        name: 'fluxnova_evaluate_dmn',
        arguments: {
          decisionKey: 'credit-risk-tier',
          variables: { creditScore: 780, loanAmount: 30000 }
        }
      }
    });

    const dmnData = JSON.parse(dmnRes.result?.content[0].text || '{}');
    expect(dmnData.outputs.decision).toBe('AUTOMATIC_APPROVE');
    expect(dmnData.outputs.maxAuthorizedAmount).toBe(30000);

    // Complete task with DMN output
    const completeRes = await server.handleToolCall({
      jsonrpc: '2.0',
      id: 6,
      method: 'tools/call',
      params: {
        name: 'fluxnova_complete_task',
        arguments: {
          taskId: 'task_decision_1',
          agentId: 'Agent-Analyst-3',
          variables: {
            underwritingDecision: dmnData.outputs.decision,
            approvedAmount: dmnData.outputs.maxAuthorizedAmount,
            completedByModel: 'claude-3-5-sonnet'
          }
        }
      }
    });

    expect(completeRes.error).toBeUndefined();
    const completeData = JSON.parse(completeRes.result?.content[0].text || '{}');
    expect(completeData.success).toBe(true);
    expect(completeData.updatedVariables.underwritingDecision).toBe('AUTOMATIC_APPROVE');
  });

  it('returns -32601 for unrecognized tool names', async () => {
    const res = await server.handleToolCall({
      jsonrpc: '2.0',
      id: 99,
      method: 'tools/call',
      params: {
        name: 'fluxnova_unknown_tool',
        arguments: {}
      }
    });

    expect(res.error?.code).toBe(-32601);
  });
});
