package org.finos.fluxnova.ai.mcp.process.model;

import java.util.List;
import java.util.Objects;

/**
 * Represents a tool definition extracted from a BPMN process.
 * This is a pure domain model containing the metadata needed to register
 * an MCP tool that can start a Fluxnova process.
 */
public record ToolDefinition(
        String processId,
        String toolName,
        String description,
        List<ToolParameter> parameters,
        boolean propagateBusinessKey
) {
    /**
     * Compact constructor with validation
     */
    public ToolDefinition {
        Objects.requireNonNull(processId, "processId cannot be null");
        Objects.requireNonNull(toolName, "toolName cannot be null");
        Objects.requireNonNull(description, "description cannot be null");
        parameters = parameters != null ? List.copyOf(parameters) : List.of();
    }

}
