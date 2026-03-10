package org.finos.fluxnova.ai.mcp.server.plugin;

import org.finos.fluxnova.ai.mcp.server.registry.ToolRegistry;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Fluxnova ProcessEnginePlugin that exposes the engine as an MCP server.
 *
 * <p>This plugin registers itself with the Fluxnova process engine and provides a
 * {@link ToolRegistry} that other plugins (e.g. mcp-process-start-event)
 * can use to register MCP tools.</p>
 *
 * <p>To activate this plugin, add it to your Fluxnova engine configuration:
 * <pre>{@code
 * <plugins>
 *   <plugin>
 *     <class>org.finos.fluxnova.ai.mcp.server.plugin.FluxnovaMcpServerPlugin</class>
 *   </plugin>
 * </plugins>
 * }</pre>
 * or include the JAR on the classpath to use Spring Boot auto-configuration.
 */
public class McpServerFluxnovaPlugin implements ProcessEnginePlugin {

    private static final Logger LOG = LoggerFactory.getLogger(McpServerFluxnovaPlugin.class);

    private final ToolRegistry toolRegistry;

    public McpServerFluxnovaPlugin(ToolRegistry toolRegistry) {
        this.toolRegistry = toolRegistry;
    }

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        LOG.info("MCP - Server Plugin - Initializing. MCP server layer is active.");
    }

    @Override
    public void postInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        LOG.debug("MCP - Server Plugin - Post-initialization complete.");
    }

    @Override
    public void postProcessEngineBuild(ProcessEngine processEngine) {
        LOG.info("MCP - Server Plugin ready - {} tool(s) currently registered.",
                toolRegistry.getToolCount());
    }

    public ToolRegistry getToolRegistry() {
        return toolRegistry;
    }
}
