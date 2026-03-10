package org.finos.fluxnova.ai.mcp.server.registry;

import org.finos.fluxnova.ai.mcp.server.model.ToolHandler;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ToolConfigTest {

    @Test
    void shouldCreateValidConfig() {
        ToolHandler handler = args -> Map.of("result", "success");
        Map<String, ToolConfig.ParameterSpec> params = Map.of(
                "param1", new ToolConfig.ParameterSpec("string", true)
        );

        ToolConfig config = new ToolConfig("TestTool", "Test description", params, handler);

        assertEquals("TestTool", config.name());
        assertEquals("Test description", config.description());
        assertEquals(1, config.parameters().size());
        assertNotNull(config.handler());
    }

    @Test
    void shouldCreateConfigWithoutParameters() {
        ToolHandler handler = args -> "result";

        ToolConfig config = new ToolConfig("SimpleTool", "Simple tool", handler);

        assertEquals("SimpleTool", config.name());
        assertTrue(config.parameters().isEmpty());
    }

    @Test
    void shouldCreateImmutableParametersMap() {
        ToolHandler handler = args -> "result";
        Map<String, ToolConfig.ParameterSpec> params = Map.of(
                "param1", new ToolConfig.ParameterSpec("string", true)
        );

        ToolConfig config = new ToolConfig("Tool", "Desc", params, handler);

        assertThrows(UnsupportedOperationException.class,
                () -> config.parameters().put("param2", new ToolConfig.ParameterSpec("int", false)));
    }

    @Test
    void shouldThrowExceptionForNullName() {
        ToolHandler handler = args -> "result";
        assertThrows(NullPointerException.class,
                () -> new ToolConfig(null, "Desc", handler));
    }

    @Test
    void shouldThrowExceptionForBlankName() {
        ToolHandler handler = args -> "result";
        assertThrows(IllegalArgumentException.class,
                () -> new ToolConfig("", "Desc", handler));
    }

    @Test
    void shouldThrowExceptionForNullDescription() {
        ToolHandler handler = args -> "result";
        assertThrows(NullPointerException.class,
                () -> new ToolConfig("Tool", null, handler));
    }

    @Test
    void shouldThrowExceptionForNullHandler() {
        assertThrows(NullPointerException.class,
                () -> new ToolConfig("Tool", "Desc", null));
    }

    // ParameterSpec tests
    @Test
    void shouldCreateRequiredParameterSpec() {
        ToolConfig.ParameterSpec spec = ToolConfig.ParameterSpec.required("string");

        assertEquals("string", spec.type());
        assertTrue(spec.required());
    }

    @Test
    void shouldCreateOptionalParameterSpec() {
        ToolConfig.ParameterSpec spec = ToolConfig.ParameterSpec.optional("integer");

        assertEquals("integer", spec.type());
        assertFalse(spec.required());
    }

    @Test
    void shouldThrowExceptionForNullParameterType() {
        assertThrows(NullPointerException.class,
                () -> new ToolConfig.ParameterSpec(null, true));
    }

    @Test
    void shouldThrowExceptionForBlankParameterType() {
        assertThrows(IllegalArgumentException.class,
                () -> new ToolConfig.ParameterSpec("", true));
    }
}
