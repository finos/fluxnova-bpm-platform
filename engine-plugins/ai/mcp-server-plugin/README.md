# mcp-server-plugin

A Fluxnova `ProcessEnginePlugin` that exposes the engine as an [MCP (Model Context Protocol)](https://modelcontextprotocol.io/) server. This plugin provides the foundational MCP server layer — primarily the `ToolRegistry` — that other plugins use to register callable tools.

## Responsibilities

- Starts and manages the Spring AI `McpSyncServer`
- Provides `ToolRegistry`, the shared API for registering and unregistering MCP tools
- Registers `FluxnovaMcpServerPlugin` with the Fluxnova engine lifecycle
- Notifies connected MCP clients when the tool list changes

This plugin has **no knowledge of BPMN processes**. It is a pure MCP server layer. For example, you can use [`mcp-process-start-event`](../mcp-process-start-event/README.md) to populate it with process-derived tools.

## Installation

### Spring Boot (auto-configuration)

Add the dependency. Auto-configuration activates automatically when `McpSyncServer` is on the classpath.

```xml
<dependency>
    <groupId>org.finos.fluxnova.bpm</groupId>
    <artifactId>fluxnova-engine-plugins-ai-mcp-server</artifactId>
</dependency>
```

### Manual Fluxnova engine configuration

```xml

<bpm-platform xmlns="http://www.camunda.org/schema/1.0/BpmPlatform">
    <process-engine name="default">
        <plugins>
            <plugin>
                <class>org.finos.fluxnova.ai.mcp.server.plugin.McpServerFluxnovaPlugin</class>
            </plugin>
        </plugins>
    </process-engine>
</bpm-platform>
```

## Registering a Custom Tool

Obtain the `ToolRegistry` bean and register any `ToolConfig`:

```java
@Autowired
private ToolRegistry toolRegistry;

public void registerMyTool() {
    ToolConfig config = new ToolConfig(
        "MyCustomTool",
        "Does something useful",
        Map.of(
            "input", ToolConfig.ParameterSpec.required("string"),
            "verbose", ToolConfig.ParameterSpec.optional("boolean")
        ),
        args -> {
            String input = (String) args.get("input");
            // ... execute business logic ...
            return Map.of("result", "processed: " + input);
        }
    );

    toolRegistry.register(config);
}
```

### Unregistering a tool

```java
toolRegistry.unregister("MyCustomTool");
```

### Checking registration state

```java
boolean active = toolRegistry.isRegistered("MyCustomTool");
int count = toolRegistry.getToolCount();
Set<String> names = toolRegistry.getRegisteredToolNames();
```
## MCP Server Plugin Startup Initialization Flow
```
Spring Boot Application starts
      │
      ▼
@AutoConfiguration triggers McpServerSpringAutoConfiguration
      │
      ├─────────────────────────────────────┐
      │                                     │
      ▼                                     ▼
@ConditionalOnClass checks:          @ConditionalOnMissingBean
  - McpSyncServer present                 checks
      │                                       │
      │                                       │
      ▼                                       ▼
Conditions met                    ToolRegistry bean created
      │                           (McpSyncServer + ObjectMapper)
      │                                       │
      │                                       ▼
      │                           McpServerFluxnovaPlugin bean created
      │                           (ToolRegistry injected)
      │                                       │
      └───────────────┬───────────────────────┘
                      │
                      ▼
      Fluxnova ProcessEngine initialization
                      │
                      ▼
      Plugin.preInit() called
                      │
                      ▼
      LOG: "MCP Server Plugin - Initializing"
                      │
                      ▼
      Plugin.postInit() called
                      │
                      ▼
      Plugin.postProcessEngineBuild() called
                      │
                      ▼
      LOG: "MCP Server Plugin ready - X tool(s) registered"
                      │
                      ▼
      ToolRegistry available for other plugins
      (e.g., mcp-process-start-event)

```
## Tool Execution Flow

```
MCP Client calls tool
      │
      ▼
McpSyncServer receives call_tool request
      │
      ▼
ToolRegistry looks up ToolConfig by name
      │
      ▼
ToolConfig.handler().execute(arguments)
      │
      ▼
Result serialised to JSON and returned to client
```

## Configuration

The plugin activates automatically via Spring Boot auto-configuration. The underlying MCP server transport (SSE, stdio, WebMVC) is configured through standard Spring AI properties in `application.properties` / `application.yml`:

```yaml
# examples only, any valid Spring AI config will work
spring:
  ai:
    mcp:
      server:
        name: my-fluxnova-server
        version: 1.0.0
        protocol: streamable
        stdio: false
        type: sync
```

## Key Classes

| Class | Package | Role |
|-------|---------|------|
| `McpServerFluxnovaPlugin` | `...server.plugin` | ProcessEnginePlugin entry point |
| `ToolRegistry` | `...server.registry` | Register/unregister MCP tools |
| `ToolConfig` | `...server.registry` | Immutable tool descriptor |
| `ToolHandler` | `...server.model` | Functional interface for tool execution |
| `McpServerSpringAutoConfiguration` | `...server.autoconfigure` | Spring Boot auto-configuration |
