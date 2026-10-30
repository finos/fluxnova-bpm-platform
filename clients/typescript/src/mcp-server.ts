/**
 * Model Context Protocol (MCP) Server for FINOS Fluxnova BPMN
 *
 * Implements standard JSON-RPC 2.0 protocol for LLMs and autonomous AI agents
 * to inspect, claim, and complete tasks within enterprise banking workflows.
 */

import type {
  DmnRuleEvaluationResult,
  FluxnovaTaskRecord,
  McpToolCallRequest,
  McpToolCallResponse,
  McpToolDefinition
} from './types.js';

export class FluxnovaMcpServer {
  private tasks = new Map<string, FluxnovaTaskRecord>();
  private engineUrl?: string;

  constructor(options?: { engineUrl?: string }) {
    this.engineUrl = options?.engineUrl;
  }

  /**
   * Returns registered tool definitions according to MCP specification
   */
  public listTools(): McpToolDefinition[] {
    return [
      {
        name: 'fluxnova_list_tasks',
        description: 'Query active tasks waiting for human or autonomous agent resolution in the Fluxnova BPMN engine.',
        inputSchema: {
          type: 'object',
          properties: {
            processDefinitionKey: { type: 'string', description: 'Filter by process definition key (e.g. loan-origination)' },
            status: { type: 'string', enum: ['pending', 'claimed', 'completed'], description: 'Filter by task status' },
            minPriority: { type: 'number', description: 'Minimum priority score (e.g. 50)' }
          }
        }
      },
      {
        name: 'fluxnova_claim_task',
        description: 'Atomically claim/lock a task so other agents or workers cannot perform redundant execution.',
        inputSchema: {
          type: 'object',
          properties: {
            taskId: { type: 'string', description: 'Unique task identifier' },
            agentId: { type: 'string', description: 'Identifier of the claiming AI agent' }
          },
          required: ['taskId', 'agentId']
        }
      },
      {
        name: 'fluxnova_complete_task',
        description: 'Submit task payload, decisions, and variables back to the Fluxnova BPMN engine to advance workflow state.',
        inputSchema: {
          type: 'object',
          properties: {
            taskId: { type: 'string', description: 'Unique task identifier' },
            agentId: { type: 'string', description: 'Identifier of the completing AI agent' },
            variables: { type: 'object', description: 'Map of BPMN process variables to set or update upon completion' }
          },
          required: ['taskId', 'agentId', 'variables']
        }
      },
      {
        name: 'fluxnova_evaluate_dmn',
        description: 'Execute a deterministic DMN (Decision Model and Notation) rule table against input features.',
        inputSchema: {
          type: 'object',
          properties: {
            decisionKey: { type: 'string', description: 'DMN decision key (e.g. credit-risk-tier)' },
            variables: { type: 'object', description: 'Input variables to evaluate against decision rules' }
          },
          required: ['decisionKey', 'variables']
        }
      },
      {
        name: 'fluxnova_start_process',
        description: 'Trigger a new instance of an authorized Fluxnova banking process with initial parameters.',
        inputSchema: {
          type: 'object',
          properties: {
            processDefinitionKey: { type: 'string', description: 'Key of the process definition to start' },
            businessKey: { type: 'string', description: 'Unique business transaction identifier' },
            variables: { type: 'object', description: 'Initial process instance variables' }
          },
          required: ['processDefinitionKey', 'businessKey']
        }
      }
    ];
  }

  /**
   * Dispatches an MCP tools/call request
   */
  public async handleToolCall(request: McpToolCallRequest): Promise<McpToolCallResponse> {
    const { name, arguments: args = {} } = request.params;

    try {
      let resultData: any;

      switch (name) {
        case 'fluxnova_list_tasks':
          resultData = this.handleListTasks(args);
          break;
        case 'fluxnova_claim_task':
          resultData = this.handleClaimTask(args);
          break;
        case 'fluxnova_complete_task':
          resultData = this.handleCompleteTask(args);
          break;
        case 'fluxnova_evaluate_dmn':
          resultData = this.handleEvaluateDmn(args);
          break;
        case 'fluxnova_start_process':
          resultData = this.handleStartProcess(args);
          break;
        default:
          return {
            jsonrpc: '2.0',
            id: request.id,
            error: {
              code: -32601,
              message: `Method '${name}' not found`
            }
          };
      }

      return {
        jsonrpc: '2.0',
        id: request.id,
        result: {
          content: [
            {
              type: 'text',
              text: typeof resultData === 'string' ? resultData : JSON.stringify(resultData, null, 2)
            }
          ]
        }
      };
    } catch (err: any) {
      return {
        jsonrpc: '2.0',
        id: request.id,
        result: {
          isError: true,
          content: [
            {
              type: 'text',
              text: `Error: ${err?.message || String(err)}`
            }
          ]
        }
      };
    }
  }

  // --- Seed / Task Management for Local & Test Environments ---

  public seedTask(task: FluxnovaTaskRecord): void {
    this.tasks.set(task.id, task);
  }

  public getTask(taskId: string): FluxnovaTaskRecord | undefined {
    return this.tasks.get(taskId);
  }

  // --- Internal Handlers ---

  private handleListTasks(args: Record<string, any>): FluxnovaTaskRecord[] {
    let result = Array.from(this.tasks.values());

    if (args.status) {
      result = result.filter(t => t.status === args.status);
    }
    if (args.minPriority !== undefined) {
      result = result.filter(t => t.priority >= args.minPriority);
    }
    if (args.processDefinitionKey) {
      result = result.filter(t => t.processDefinitionId.startsWith(args.processDefinitionKey));
    }

    return result;
  }

  private handleClaimTask(args: Record<string, any>): { success: boolean; task: FluxnovaTaskRecord } {
    const { taskId, agentId } = args;
    if (!taskId || !agentId) {
      throw new Error('taskId and agentId are required');
    }

    const task = this.tasks.get(taskId);
    if (!task) {
      throw new Error(`Task with ID '${taskId}' not found`);
    }

    if (task.status === 'claimed' && task.claimedBy !== agentId) {
      throw new Error(`Task '${taskId}' is already claimed by agent '${task.claimedBy}'`);
    }
    if (task.status === 'completed') {
      throw new Error(`Task '${taskId}' is already completed`);
    }

    task.status = 'claimed';
    task.claimedBy = agentId;
    task.assignee = agentId;
    this.tasks.set(taskId, task);

    return { success: true, task };
  }

  private handleCompleteTask(args: Record<string, any>): { success: boolean; taskId: string; updatedVariables: Record<string, any> } {
    const { taskId, agentId, variables } = args;
    if (!taskId || !agentId || !variables) {
      throw new Error('taskId, agentId, and variables are required');
    }

    const task = this.tasks.get(taskId);
    if (!task) {
      throw new Error(`Task with ID '${taskId}' not found`);
    }

    if (task.status === 'claimed' && task.claimedBy !== agentId) {
      throw new Error(`Agent '${agentId}' cannot complete task claimed by '${task.claimedBy}'`);
    }

    task.status = 'completed';
    task.variables = { ...task.variables, ...variables };
    this.tasks.set(taskId, task);

    return {
      success: true,
      taskId,
      updatedVariables: task.variables
    };
  }

  private handleEvaluateDmn(args: Record<string, any>): DmnRuleEvaluationResult {
    const { decisionKey, variables } = args;
    if (!decisionKey || !variables) {
      throw new Error('decisionKey and variables are required');
    }

    // Standard deterministic banking risk matrix emulation
    const score = Number(variables.creditScore || variables.riskScore || 700);
    const amount = Number(variables.loanAmount || 10000);

    let decision = 'REFER';
    let maxAuthorizedAmount = 0;

    if (score >= 720 && amount <= 50000) {
      decision = 'AUTOMATIC_APPROVE';
      maxAuthorizedAmount = amount;
    } else if (score < 600) {
      decision = 'AUTOMATIC_DECLINE';
      maxAuthorizedAmount = 0;
    } else {
      decision = 'MANUAL_UNDERWRITING';
      maxAuthorizedAmount = Math.min(amount, 25000);
    }

    return {
      ruleId: `rule_${decisionKey}_1`,
      decisionKey,
      inputs: variables,
      outputs: {
        decision,
        maxAuthorizedAmount,
        evaluatedAt: new Date().toISOString()
      }
    };
  }

  private handleStartProcess(args: Record<string, any>): { processInstanceId: string; businessKey: string; status: string } {
    const { processDefinitionKey, businessKey, variables = {} } = args;
    if (!processDefinitionKey || !businessKey) {
      throw new Error('processDefinitionKey and businessKey are required');
    }

    const processInstanceId = `inst_${Date.now()}_${Math.floor(Math.random() * 10000)}`;

    // Create an initial user task for demonstration
    const initialTaskId = `task_${Date.now()}_1`;
    this.tasks.set(initialTaskId, {
      id: initialTaskId,
      name: `Review Case for ${businessKey}`,
      assignee: null,
      created: new Date().toISOString(),
      priority: 50,
      processInstanceId,
      processDefinitionId: `${processDefinitionKey}:1`,
      taskDefinitionKey: 'user_review_task',
      status: 'pending',
      variables
    });

    return {
      processInstanceId,
      businessKey,
      status: 'active'
    };
  }
}
