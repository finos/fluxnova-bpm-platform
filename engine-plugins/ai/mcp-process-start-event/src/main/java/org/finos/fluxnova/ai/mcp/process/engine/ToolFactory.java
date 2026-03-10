package org.finos.fluxnova.ai.mcp.process.engine;

import org.finos.fluxnova.ai.mcp.process.model.ToolDefinition;
import org.finos.fluxnova.ai.mcp.process.model.ToolParameter;
import org.finos.fluxnova.ai.mcp.server.registry.ToolConfig;
import org.finos.fluxnova.ai.mcp.server.registry.ToolRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Factory for creating and registering MCP tools from tool definitions.
 * Bridges the gap between BPMN process definitions and the MCP ToolRegistry.
 */
public class ToolFactory {
    private static final Logger LOG = LoggerFactory.getLogger(ToolFactory.class);

    private final ProcessStarter processStarter;
    private final ToolRegistry toolRegistry;

    public ToolFactory(ProcessStarter processStarter, ToolRegistry toolRegistry) {
        this.processStarter = processStarter;
        this.toolRegistry = toolRegistry;
    }

    /**
     * Creates an MCP tool from a definition and registers it.
     *
     * @param definition the tool definition extracted from BPMN
     */
    public void createAndRegister(ToolDefinition definition) {
        try {
            Map<String, ToolConfig.ParameterSpec> paramSpecs = buildParameterSpecs(definition.parameters());

            ToolConfig config = new ToolConfig(
                    definition.toolName(),
                    definition.description(),
                    paramSpecs,
                    args -> processStarter.startProcess(definition, args)
            );

            toolRegistry.register(config);
            LOG.info("MCP - Registered MCP tool '{}' for process '{}'",
                    definition.toolName(), definition.processId());

        } catch (Exception e) {
            LOG.error("MCP - Failed to create and register tool '{}' for process '{}'",
                    definition.toolName(), definition.processId(), e);
        }
    }

    /**
     * Converts tool parameters to parameter specifications for the registry.
     */
    private Map<String, ToolConfig.ParameterSpec> buildParameterSpecs(List<ToolParameter> parameters) {
        Map<String, ToolConfig.ParameterSpec> specs = new HashMap<>();

        for (ToolParameter param : parameters) {
            specs.put(
                    param.name(),
                    new ToolConfig.ParameterSpec(param.normalizedType(), !param.optional())
            );
        }

        return specs;
    }
}
