package org.finos.fluxnova.ai.mcp.process.engine;

import org.finos.fluxnova.ai.mcp.process.model.ToolDefinition;
import org.finos.fluxnova.ai.mcp.process.model.ToolParameter;
import org.finos.fluxnova.ai.mcp.server.registry.ToolConfig;
import org.finos.fluxnova.ai.mcp.server.registry.ToolRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ToolFactoryTest {

    private ToolFactory toolFactory;

    @Mock
    private ProcessStarter processStarter;

    @Mock
    private ToolRegistry toolRegistry;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        toolFactory = new ToolFactory(processStarter, toolRegistry);
    }

    @Test
    void shouldCreateAndRegisterTool() {
        List<ToolParameter> params = List.of(
                new ToolParameter("location", "String", false),
                new ToolParameter("units", "String", true)
        );

        ToolDefinition definition = new ToolDefinition(
                "weather-process",
                "GetWeather",
                "Fetches weather data",
                params,
                true
        );

        when(toolRegistry.register(any(ToolConfig.class))).thenReturn(true);

        toolFactory.createAndRegister(definition);

        ArgumentCaptor<ToolConfig> configCaptor = ArgumentCaptor.forClass(ToolConfig.class);
        verify(toolRegistry).register(configCaptor.capture());

        ToolConfig config = configCaptor.getValue();
        assertEquals("GetWeather", config.name());
        assertEquals("Fetches weather data", config.description());
        assertEquals(2, config.parameters().size());

        assertTrue(config.parameters().get("location").required());
        assertFalse(config.parameters().get("units").required());
    }

    @Test
    void shouldHandleEmptyParameters() {
        ToolDefinition definition = new ToolDefinition(
                "simple-process",
                "SimpleTool",
                "Simple tool",
                List.of(),
                false
        );

        when(toolRegistry.register(any(ToolConfig.class))).thenReturn(true);

        toolFactory.createAndRegister(definition);

        ArgumentCaptor<ToolConfig> configCaptor = ArgumentCaptor.forClass(ToolConfig.class);
        verify(toolRegistry).register(configCaptor.capture());

        ToolConfig config = configCaptor.getValue();
        assertTrue(config.parameters().isEmpty());
    }

    @Test
    void shouldNormalizeParameterTypes() {
        List<ToolParameter> params = List.of(
                new ToolParameter("count", "INTEGER", false)
        );

        ToolDefinition definition = new ToolDefinition(
                "process-1",
                "Tool1",
                "Description",
                params,
                true
        );

        when(toolRegistry.register(any(ToolConfig.class))).thenReturn(true);

        toolFactory.createAndRegister(definition);

        ArgumentCaptor<ToolConfig> configCaptor = ArgumentCaptor.forClass(ToolConfig.class);
        verify(toolRegistry).register(configCaptor.capture());

        ToolConfig config = configCaptor.getValue();
        assertEquals("integer", config.parameters().get("count").type());
    }

    @Test
    void shouldNotThrowOnRegistrationFailure() {
        ToolDefinition definition = new ToolDefinition(
                "process-1",
                "Tool1",
                "Description",
                List.of(),
                true
        );

        when(toolRegistry.register(any(ToolConfig.class)))
                .thenThrow(new RuntimeException("Registration failed"));

        assertDoesNotThrow(() -> toolFactory.createAndRegister(definition));
    }
}
