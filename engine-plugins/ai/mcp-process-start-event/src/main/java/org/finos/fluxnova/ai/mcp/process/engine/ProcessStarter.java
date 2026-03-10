package org.finos.fluxnova.ai.mcp.process.engine;

import org.finos.fluxnova.ai.mcp.process.model.ToolDefinition;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Handles starting Fluxnova process instances from MCP tool invocations.
 */
public class ProcessStarter {
    private static final Logger LOG = LoggerFactory.getLogger(ProcessStarter.class);

    private final RuntimeService runtimeService;

    public ProcessStarter(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    /**
     * Starts a Fluxnova process instance with the provided arguments.
     *
     * @param definition the tool definition
     * @param arguments the arguments passed to the tool
     * @return a map containing the process instance details
     */
    public Map<String, Object> startProcess(ToolDefinition definition, Map<String, Object> arguments) {
        try {
            LOG.info("MCP - Starting process '{}' via MCP tool '{}' with args: {}",
                    definition.processId(), definition.toolName(), arguments);

            String businessKey = arguments.get("businessKey") != null
                    ? arguments.get("businessKey").toString()
                    : null;

            ProcessInstance instance = runtimeService.startProcessInstanceByKey(
                    definition.processId(),
                    businessKey,
                    arguments
            );

            LOG.info("MCP - Process instance created: {} for tool '{}' with business key '{}'",
                    instance.getId(), definition.toolName(), businessKey);

            return Map.of(
                    "processInstanceId", instance.getId(),
                    "businessKey", businessKey != null ? businessKey : "",
                    "message", "Process started successfully"
            );

        } catch (Exception e) {
            LOG.error("MCP - Failed to start process '{}' via tool '{}'",
                    definition.processId(), definition.toolName(), e);
            throw new RuntimeException("Failed to start process: " + e.getMessage(), e);
        }
    }
}
