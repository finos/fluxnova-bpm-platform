# Fluxnova AI Extension

Parent project for the Fluxnova AI plugin suite.

## Modules

| Capability |Module                                                        | Purpose |
|------------|--------------------------------------------------------------|---------|
| MCP        |[`mcp-server-plugin`](mcp-server-plugin/README.md)            | Registers the Fluxnova engine as an MCP server and provides a `ToolRegistry` for other plugins |
| MCP        |[`mcp-process-start-event`](mcp-process-start-event/README.md) | Scans BPMN processes for MCP-annotated start events and exposes them as MCP tools |

## MCP Capability
Exposes a Fluxnova process engine as an [MCP (Model Context Protocol)](https://modelcontextprotocol.io/) server so that AI assistants and LLM clients can discover and invoke business processes as tools.

### Architecture

```
┌─────────────────────────────────────────────────────┐
│                 MCP Client (AI / LLM)               │
└────────────────────────┬────────────────────────────┘
                         │ MCP Protocol
┌────────────────────────▼────────────────────────────┐
│           mcp-server-plugin                │
│  ┌──────────────┐   ┌───────────────────────────┐  │
│  │ McpSyncServer│   │       ToolRegistry         │  │
│  │ (Spring AI)  │◄──│  register / unregister()  │  │
│  └──────────────┘   └───────────────┬───────────┘  │
└─────────────────────────────────────│───────────────┘
                                      │ uses
┌─────────────────────────────────────▼───────────────┐
│        mcp-process-start-event             │
│  ┌─────────────────┐   ┌─────────────────────────┐ │
│  │ McpParseListener│   │    McpStartupScanner    │ │
│  │ (on deployment) │   │    (on startup)         │ │
│  └────────┬────────┘   └──────────┬──────────────┘ │
│           │                       │                 │
│  ┌────────▼───────────────────────▼──────────────┐ │
│  │   BpmnStartEventToolExtractor + ToolFactory    │ │
│  └────────────────────────┬───────────────────────┘ │
└───────────────────────────│─────────────────────────┘
                            │ startProcessInstanceByKey
┌───────────────────────────▼─────────────────────────┐
│                 Fluxnova BPM Engine                  │
└──────────────────────────────────────────────────────┘
```

### Quick Start

#### 1. Add both plugins to your Fluxnova application

```xml
<dependencies>
    <!-- Provides the MCP server layer -->
    <dependency>
        <groupId>org.finos.fluxnova.bpm</groupId>
        <artifactId>fluxnova-engine-plugins-ai-mcp-server</artifactId>
    </dependency>

    <!-- Scans BPMN start events and registers them as MCP tools -->
    <dependency>
        <groupId>org.finos.fluxnova.bpm</groupId>
        <artifactId>fluxnova-engine-plugins-ai-mcp-start-event</artifactId>
        <version>2.0.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

With Spring Boot, both plugins auto-configure. No further setup is needed.

#### 2. Configure Spring AI MCP server

```properties
spring.ai.mcp.server.name=fluxnova-mcp-server
spring.ai.mcp.server.version=1.0.0
spring.ai.mcp.server.protocol=streamable
spring.ai.mcp.server.type=sync
```

#### 3. Annotate a BPMN start event

```xml
<bpmn:definitions
    xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL"
    xmlns:mcp="http://fluxnova.finos.org/schema/1.0/ai/mcp">

  <bpmn:process id="kycProcess" isExecutable="true">
    <bpmn:startEvent id="start"
                     mcp:toolName="KYC Review Tool"
                     mcp:description="Initiates KYC check on customer">
      <bpmn:extensionElements>
        <mcp:parameters>
          <mcp:parameter paramName="customerName" paramType="string"/>
          <mcp:parameter paramName="customerId"   paramType="string"/>
        </mcp:parameters>
      </bpmn:extensionElements>
    </bpmn:startEvent>
  </bpmn:process>
</bpmn:definitions>
```

#### 4. Connect an MCP client

Point any MCP-compatible client (Claude Desktop, a custom LLM agent, MCP Inspector) at the Spring AI MCP server endpoint. The tool `KYC Review Tool` will appear in the tool list and can be called directly.

MCP call:
```json
{
  "customerName": "John Doe",
  "customerId": "12345",
  "businessKey": "KYC-2024-001"
}
```

Response:
```json
{
  "processInstanceId": "abc123",
  "businessKey": "KYC-2024-001",
  "message": "Process started successfully"
}
```

### MCP Attributes Reference

| Attribute | Required | Default | Description |
|-----------|----------|---------|-------------|
| `mcp:toolName` | Yes | — | Name shown to the MCP client. Must be unique across all processes. |
| `mcp:description` | No | `""` | Human-readable description shown to the AI assistant. |
| `mcp:propagateBusinessKey` | No | `true` | If `true`, adds a `businessKey` parameter to the tool. |

#### Parameter elements

```xml
<mcp:parameter paramName="myParam" paramType="string"/>
```

Supported `paramType` values: `string`, `number`, `boolean`, `object`, `array`

## Business Key Propagation

By default each tool includes a `businessKey` parameter that is passed to `startProcessInstanceByKey`. When a parent process starts a child process via MCP, inject the business key explicitly in the prompt, e.g. `"BusinessKey is ABC-123"`. Strategic support for automatic LLM invocation context propagation is planned for a future Fluxnova release.

## Enabling Debug Logging

```yaml
logging:
  level:
    org.finos.fluxnova.ai.mcp: DEBUG
```

### Troubleshooting

**Tool not registering?**
- Verify `mcp:toolName` attribute is present on the start event
- Check the namespace declaration: `xmlns:mcp="http://fluxnova.finos.org/schema/1.0/ai/mcp"`
- Look for `Registered MCP tool` in the application logs

**Parameters not working?**
- Use `paramName` and `paramType` as plain XML attributes (not namespace-prefixed)
- Supported types: `string`, `number`, `boolean`, `object`, `array`

**Testing with MCP Inspector:**
```bash
npx @modelcontextprotocol/inspector
```
Connect to your Fluxnova server endpoint, then invoke the process via the Tools menu.

## Building

```bash
mvn clean install
```

### Requirements

- Java 21+
- Fluxnova BPM Engine 2.0.0+
- Spring Boot 3.5.x
- Spring AI 1.1.2
