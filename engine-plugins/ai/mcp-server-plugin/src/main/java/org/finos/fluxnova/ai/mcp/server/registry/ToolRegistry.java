package org.finos.fluxnova.ai.mcp.server.registry;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.server.McpServerFeatures.SyncToolSpecification;
import io.modelcontextprotocol.server.McpSyncServer;
import io.modelcontextprotocol.spec.McpSchema.CallToolResult;
import io.modelcontextprotocol.spec.McpSchema.JsonSchema;
import io.modelcontextprotocol.spec.McpSchema.TextContent;
import io.modelcontextprotocol.spec.McpSchema.Tool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Registry for managing MCP tools.
 * Handles registration, unregistration, and lifecycle of tools with the MCP server.
 *
 * <p>This is the primary integration point between the MCP server layer and tool
 * providers such as the mcp-process-start-event plugin.</p>
 */
@Service
public class ToolRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(ToolRegistry.class);

    private final McpSyncServer mcpServer;
    private final ObjectMapper objectMapper;
    private final Map<String, ToolConfig> registeredTools;

    public ToolRegistry(McpSyncServer mcpServer, ObjectMapper objectMapper) {
        this.mcpServer = Objects.requireNonNull(mcpServer, "mcpServer cannot be null");
        this.objectMapper = Objects.requireNonNull(objectMapper, "objectMapper cannot be null");
        this.registeredTools = new ConcurrentHashMap<>();
    }

    /**
     * Registers a tool with the MCP server.
     *
     * @param config the tool configuration
     * @return true if registration was successful, false otherwise
     */
    public boolean register(ToolConfig config) {
        Objects.requireNonNull(config, "tool config cannot be null");

        try {
            if (registeredTools.containsKey(config.name())) {
                LOG.warn("MCP - Tool '{}' is already registered. Unregistering old version first.", config.name());
                unregister(config.name());
            }

            Tool tool = buildTool(config);
            SyncToolSpecification spec = buildToolSpecification(tool, config);

            mcpServer.addTool(spec);
            registeredTools.put(config.name(), config);
            mcpServer.notifyToolsListChanged();

            LOG.info("MCP - Successfully registered tool: {}", config.name());
            return true;

        } catch (Exception e) {
            LOG.error("MCP - Failed to register tool: {}", config.name(), e);
            return false;
        }
    }

    /**
     * Unregisters a tool from the MCP server.
     *
     * @param toolName the name of the tool to unregister
     * @return true if unregistration was successful, false otherwise
     */
    public boolean unregister(String toolName) {
        Objects.requireNonNull(toolName, "tool name cannot be null");

        try {
            if (!registeredTools.containsKey(toolName)) {
                LOG.warn("MCP - Tool '{}' is not registered", toolName);
                return false;
            }

            mcpServer.removeTool(toolName);
            registeredTools.remove(toolName);
            mcpServer.notifyToolsListChanged();

            LOG.info("MCP - Successfully unregistered tool: {}", toolName);
            return true;

        } catch (Exception e) {
            LOG.error("MCP - Failed to unregister tool: {}", toolName, e);
            return false;
        }
    }

    /**
     * Gets all registered tool names.
     *
     * @return set of registered tool names
     */
    public Set<String> getRegisteredToolNames() {
        return Collections.unmodifiableSet(registeredTools.keySet());
    }

    /**
     * Gets a registered tool configuration.
     *
     * @param toolName the tool name
     * @return the tool configuration, or null if not found
     */
    public ToolConfig getToolConfig(String toolName) {
        return registeredTools.get(toolName);
    }

    /**
     * Checks if a tool is registered.
     *
     * @param toolName the tool name
     * @return true if the tool is registered
     */
    public boolean isRegistered(String toolName) {
        return registeredTools.containsKey(toolName);
    }

    /**
     * Gets the count of registered tools.
     *
     * @return number of registered tools
     */
    public int getToolCount() {
        return registeredTools.size();
    }

    /**
     * Unregisters all tools.
     */
    public void unregisterAll() {
        LOG.info("MCP - Unregistering all {} tools", registeredTools.size());

        List<String> toolNames = new ArrayList<>(registeredTools.keySet());
        for (String toolName : toolNames) {
            unregister(toolName);
        }
    }

    /**
     * Builds an MCP Tool from a ToolConfig.
     */
    private Tool buildTool(ToolConfig config) {
        JsonSchema schema = buildJsonSchema(config.parameters());

        return new Tool(
                config.name(),
                null,  // href - not used
                config.description(),
                schema,
                null,  // annotations - not used
                null,  // _meta - not used
                null   // additionalProperties - not used
        );
    }

    /**
     * Builds a JSON schema for tool parameters.
     */
    private JsonSchema buildJsonSchema(Map<String, ToolConfig.ParameterSpec> parameters) {
        if (parameters.isEmpty()) {
            return new JsonSchema(
                    "object",
                    Map.of(),
                    null,
                    null,
                    null,
                    null
            );
        }

        Map<String, Object> properties = new HashMap<>();
        List<String> required = new ArrayList<>();

        parameters.forEach((name, spec) -> {
            properties.put(name, Map.of(
                    "type", spec.type(),
                    "description", "Parameter: " + name
            ));

            if (spec.required()) {
                required.add(name);
            }
        });

        return new JsonSchema(
                "object",
                properties,
                required.isEmpty() ? null : required,
                null,  // additionalProperties
                null,  // _meta
                null   // other properties
        );
    }

    /**
     * Builds a tool specification with the execution handler.
     */
    private SyncToolSpecification buildToolSpecification(Tool tool, ToolConfig config) {
        return new SyncToolSpecification(
                tool,
                (exchange, arguments) -> {
                    try {
                        LOG.debug("MCP - Executing tool '{}' with arguments: {}", config.name(), arguments);

                        Map<String, Object> args = arguments != null ? arguments : Map.of();
                        Object result = config.handler().execute(args);

                        String resultText = formatResult(result);

                        LOG.debug("MCP - Tool '{}' executed successfully", config.name());
                        return new CallToolResult(
                                List.of(new TextContent(resultText)),
                                false  // isError
                        );

                    } catch (Exception e) {
                        LOG.error("MCP - Tool '{}' execution failed", config.name(), e);
                        return new CallToolResult(
                                List.of(new TextContent("Error executing tool: " + e.getMessage())),
                                true  // isError
                        );
                    }
                }
        );
    }

    /**
     * Formats the tool execution result as a string.
     */
    private String formatResult(Object result) {
        if (result == null) {
            return "null";
        }

        if (result instanceof String) {
            return (String) result;
        }

        try {
            return objectMapper.writeValueAsString(result);
        } catch (Exception e) {
            LOG.warn("MCP - Failed to serialize result to JSON, using toString()", e);
            return result.toString();
        }
    }
}
