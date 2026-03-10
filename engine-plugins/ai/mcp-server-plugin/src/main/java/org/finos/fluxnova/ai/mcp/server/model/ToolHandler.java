package org.finos.fluxnova.ai.mcp.server.model;

import java.util.Map;

/**
 * Functional interface for handling MCP tool invocations.
 * Implementations execute the actual business logic when a tool is called.
 */
@FunctionalInterface
public interface ToolHandler {

    /**
     * Executes the tool with the provided arguments.
     *
     * @param arguments the arguments passed to the tool invocation
     * @return the result of the tool execution (typically a Map or String)
     * @throws Exception if the tool execution fails
     */
    Object execute(Map<String, Object> arguments) throws Exception;
}
