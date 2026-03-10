package org.finos.fluxnova.ai.mcp.server.registry;

import org.finos.fluxnova.ai.mcp.server.model.ToolHandler;

import java.util.Map;
import java.util.Objects;

/**
 * Configuration for an MCP tool.
 * Contains all metadata and the handler needed to register and execute a tool.
 */
public record ToolConfig(
        String name,
        String description,
        Map<String, ParameterSpec> parameters,
        ToolHandler handler
) {
    /**
     * Specification for a tool parameter.
     */
    public record ParameterSpec(
            String type,
            boolean required
    ) {
        public ParameterSpec {
            Objects.requireNonNull(type, "parameter type cannot be null");
            if (type.isBlank()) {
                throw new IllegalArgumentException("parameter type cannot be blank");
            }
        }

        /**
         * Creates a required parameter spec
         */
        public static ParameterSpec required(String type) {
            return new ParameterSpec(type, true);
        }

        /**
         * Creates an optional parameter spec
         */
        public static ParameterSpec optional(String type) {
            return new ParameterSpec(type, false);
        }
    }

    /**
     * Compact constructor with validation
     */
    public ToolConfig {
        Objects.requireNonNull(name, "tool name cannot be null");
        Objects.requireNonNull(description, "tool description cannot be null");
        Objects.requireNonNull(handler, "tool handler cannot be null");

        if (name.isBlank()) {
            throw new IllegalArgumentException("tool name cannot be blank");
        }

        parameters = parameters != null ? Map.copyOf(parameters) : Map.of();
    }

    /**
     * Convenience constructor without parameters
     */
    public ToolConfig(String name, String description, ToolHandler handler) {
        this(name, description, Map.of(), handler);
    }
}
