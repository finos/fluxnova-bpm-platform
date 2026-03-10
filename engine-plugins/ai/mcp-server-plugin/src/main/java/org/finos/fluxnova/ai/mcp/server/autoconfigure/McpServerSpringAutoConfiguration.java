package org.finos.fluxnova.ai.mcp.server.autoconfigure;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.server.McpSyncServer;
import org.finos.fluxnova.ai.mcp.server.plugin.McpServerFluxnovaPlugin;
import org.finos.fluxnova.ai.mcp.server.registry.ToolRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;

/**
 * Spring Boot auto-configuration for the Fluxnova MCP Server Plugin.
 *
 * <p>Activates when {@link McpSyncServer} is on the classpath,
 * creating a {@link ToolRegistry} and {@link McpServerFluxnovaPlugin} bean.</p>
 */
@AutoConfiguration
@ConditionalOnClass({McpSyncServer.class})
public class McpServerSpringAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(McpServerSpringAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public ToolRegistry toolRegistry(McpSyncServer mcpServer, ObjectMapper objectMapper) {
        log.info("MCP - Server - Auto-configuring ToolRegistry bean");
        return new ToolRegistry(mcpServer, objectMapper);
    }

    @Bean
    @ConditionalOnMissingBean
    public McpServerFluxnovaPlugin fluxnovaMcpServerPlugin(ToolRegistry toolRegistry) {
        log.info("MCP - Server - Auto-configuring FluxnovaMcpServerPlugin bean");
        return new McpServerFluxnovaPlugin(toolRegistry);
    }
}
