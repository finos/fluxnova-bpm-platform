package org.finos.fluxnova.ai.mcp.process.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ToolDefinitionTest {

    @Test
    void shouldCreateValidDefinition() {
        List<ToolParameter> params = List.of(
                new ToolParameter("location", "String", false)
        );

        ToolDefinition def = new ToolDefinition(
                "weather-process",
                "GetWeather",
                "Fetches weather data",
                params,
                true
        );

        assertEquals("weather-process", def.processId());
        assertEquals("GetWeather", def.toolName());
        assertEquals("Fetches weather data", def.description());
        assertEquals(1, def.parameters().size());
        assertTrue(def.propagateBusinessKey());
    }

    @Test
    void shouldUseDefaultPropagateBusinessKey() {
        ToolDefinition def = new ToolDefinition(
                "process-1",
                "Tool1",
                "Description",
                List.of(),
                true
        );

        assertTrue(def.propagateBusinessKey());
    }

    @Test
    void shouldCreateImmutableParametersList() {
        List<ToolParameter> params = List.of(
                new ToolParameter("param1", "String", false)
        );

        ToolDefinition def = new ToolDefinition(
                "process-1",
                "Tool1",
                "Description",
                params,
                true
        );

        assertThrows(UnsupportedOperationException.class,
                () -> def.parameters().add(new ToolParameter("param2", "String", false)));
    }

    @Test
    void shouldHandleNullParameters() {
        ToolDefinition def = new ToolDefinition(
                "process-1",
                "Tool1",
                "Description",
                null,
                true
        );

        assertNotNull(def.parameters());
        assertTrue(def.parameters().isEmpty());
    }

    @Test
    void shouldThrowExceptionForNullProcessId() {
        assertThrows(NullPointerException.class,
                () -> new ToolDefinition(null, "Tool1", "Desc", List.of(), true));
    }

    @Test
    void shouldThrowExceptionForNullToolName() {
        assertThrows(NullPointerException.class,
                () -> new ToolDefinition("process-1", null, "Desc", List.of(), true));
    }

    @Test
    void shouldThrowExceptionForNullDescription() {
        assertThrows(NullPointerException.class,
                () -> new ToolDefinition("process-1", "Tool1", null, List.of(), true));
    }
}
