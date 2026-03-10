package org.finos.fluxnova.ai.mcp.process.plugin;

import org.finos.fluxnova.ai.mcp.process.engine.McpParseListener;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Fluxnova ProcessEnginePlugin that scans BPMN processes for MCP-annotated start events
 * and registers them as tools on the MCP server.
 *
 * <p>This plugin depends on {@code mcp-server-plugin} being active, which
 * provides the {@code ToolRegistry} that discovered tools are registered into.</p>
 *
 * <p>On engine initialisation the plugin registers a {@link McpParseListener} with the
 * BPMN parser so that every newly deployed process is scanned automatically. Processes
 * that were already deployed before the application started are picked up by the
 * {@code McpStartupScanner} which runs once the Spring context is ready.</p>
 *
 * <p>Add this plugin alongside the server plugin in your Fluxnova configuration:
 * <pre>{@code
 * <plugins>
 *   <plugin>
 *     <class>org.finos.fluxnova.ai.mcp.server.plugin.FluxnovaMcpServerPlugin</class>
 *   </plugin>
 *   <plugin>
 *     <class>org.finos.fluxnova.ai.mcp.process.plugin.FluxnovaMcpProcessStartEventPlugin</class>
 *   </plugin>
 * </plugins>
 * }</pre>
 * or include both JARs on the classpath to use Spring Boot auto-configuration.
 */
public class McpProcessStartEventPlugin implements ProcessEnginePlugin {

    private static final Logger LOG = LoggerFactory.getLogger(McpProcessStartEventPlugin.class);

    private final McpParseListener parseListener;

    public McpProcessStartEventPlugin(McpParseListener parseListener) {
        this.parseListener = parseListener;
    }

    @Override
    public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        LOG.info("MCP - Process Start Event Plugin - Registering BPMN parse listener");

        LOG.debug("MCP - Parse listeners BEFORE adding: {}",
                processEngineConfiguration.getCustomPostBPMNParseListeners().size());
        processEngineConfiguration.getCustomPostBPMNParseListeners().add(parseListener);
        LOG.debug("MCP - Parse listeners AFTER adding: {}",
                processEngineConfiguration.getCustomPostBPMNParseListeners().size());

        LOG.info("MCP - Process Start Event Plugin initialized - BPMN parse listener registered");
    }

    @Override
    public void postInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
        LOG.debug("MCP - Process Start Event Plugin - Post-initialization complete");
    }

    @Override
    public void postProcessEngineBuild(ProcessEngine processEngine) {
        LOG.info("MCP - Process Start Event Plugin ready - Process engine built");
    }
}
