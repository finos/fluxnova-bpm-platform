package org.finos.fluxnova.ai.mcp.process.autoconfigure;

import org.finos.fluxnova.ai.mcp.process.engine.*;
import org.finos.fluxnova.ai.mcp.process.plugin.McpProcessStartEventPlugin;

import org.finos.fluxnova.ai.mcp.server.autoconfigure.McpServerSpringAutoConfiguration;
import org.finos.fluxnova.ai.mcp.server.registry.ToolRegistry;
import org.finos.fluxnova.bpm.engine.RepositoryService;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * Spring Boot auto-configuration for the Fluxnova MCP Process Start Event Plugin.
 *
 * <p>Activates when a {@link ToolRegistry} bean is present (provided by
 * {@code mcp-server-plugin}), wiring up the BPMN scanning and
 * tool-registration pipeline.</p>
 */
@Configuration
@AutoConfigureAfter(McpServerSpringAutoConfiguration.class)
@ConditionalOnBean(ToolRegistry.class)
public class McpProcessStartEventAutoConfiguration {

    private static final Logger log = LoggerFactory.getLogger(McpProcessStartEventAutoConfiguration.class);

    @Bean
    @ConditionalOnMissingBean
    public BpmnStartEventToolExtractor bpmnToolExtractor() {
        return new BpmnStartEventToolExtractor();
    }

    @Bean
    @ConditionalOnMissingBean
    public ProcessStarter processStarter(@Lazy RuntimeService runtimeService) {
        return new ProcessStarter(runtimeService);
    }

    @Bean
    @ConditionalOnMissingBean
    public ToolFactory toolFactory(ProcessStarter processStarter, ToolRegistry toolRegistry) {
        return new ToolFactory(processStarter, toolRegistry);
    }

    @Bean
    @ConditionalOnMissingBean
    public McpParseListener mcpParseListener(BpmnStartEventToolExtractor extractor, ToolFactory factory) {
        return new McpParseListener(extractor, factory);
    }

    @Bean
    @ConditionalOnMissingBean
    public McpProcessStartEventPlugin fluxnovaMcpProcessStartEventPlugin(McpParseListener parseListener) {
        log.info("MCP - Process Start Event - Auto-configuring FluxnovaMcpProcessStartEventPlugin bean");
        return new McpProcessStartEventPlugin(parseListener);
    }

    @Bean
    @ConditionalOnMissingBean
    public McpStartupScanner mcpStartupScanner(
            RepositoryService repositoryService,
            BpmnStartEventToolExtractor extractor,
            ToolFactory factory) {
        return new McpStartupScanner(repositoryService, extractor, factory);
    }

    @Bean
    public ApplicationRunner mcpToolRegistrationRunner(McpStartupScanner scanner) {
        return args -> {
            log.info("MCP - Process Start Event - Starting tool registration from existing processes");
            scanner.scanAndRegisterExistingProcesses();
        };
    }
}
