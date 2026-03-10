package org.finos.fluxnova.ai.mcp.process.model;

import java.util.Objects;

/**
 * Represents a parameter definition for an MCP tool.
 * Maps to the mcp:Parameter element in BPMN XML.
 */
public record ToolParameter(
        String name,
        String type,
        boolean optional
) {
    /**
     * Compact constructor with validation
     */
    public ToolParameter {
        Objects.requireNonNull(name, "parameter name cannot be null");
        Objects.requireNonNull(type, "parameter type cannot be null");

        if (name.isBlank()) {
            throw new IllegalArgumentException("parameter name cannot be blank");
        }
        if (type.isBlank()) {
            throw new IllegalArgumentException("parameter type cannot be blank");
        }
    }

    /**
     * Convenience constructor for required parameters (backward compatibility)
     */
    public ToolParameter(String name, String type) {
        this(name, type, false);
    }

    /**
     * Normalizes the type to lowercase for consistency
     */
    public String normalizedType() {
        return type.toLowerCase();
    }

    /**
     * Checks if this parameter is of a specific type
     */
    public boolean isType(String expectedType) {
        return normalizedType().equals(expectedType.toLowerCase());
    }
}
