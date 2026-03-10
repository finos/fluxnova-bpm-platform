package org.finos.fluxnova.ai.mcp.server.registry;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.server.McpServerFeatures.SyncToolSpecification;
import io.modelcontextprotocol.server.McpSyncServer;
import org.finos.fluxnova.ai.mcp.server.model.ToolHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ToolRegistryTest {

    private ToolRegistry toolRegistry;

    @Mock
    private McpSyncServer mcpServer;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        objectMapper = new ObjectMapper();
        toolRegistry = new ToolRegistry(mcpServer, objectMapper);
    }

    @Test
    void shouldRegisterTool() {
        ToolHandler handler = args -> Map.of("result", "success");
        ToolConfig config = new ToolConfig("TestTool", "Test description", handler);

        boolean result = toolRegistry.register(config);

        assertTrue(result);
        assertTrue(toolRegistry.isRegistered("TestTool"));
        assertEquals(1, toolRegistry.getToolCount());

        verify(mcpServer).addTool(any(SyncToolSpecification.class));
        verify(mcpServer).notifyToolsListChanged();
    }

    @Test
    void shouldUnregisterExistingToolBeforeReregistering() {
        ToolHandler handler = args -> "result";
        ToolConfig config1 = new ToolConfig("Tool1", "First version", handler);
        ToolConfig config2 = new ToolConfig("Tool1", "Second version", handler);

        toolRegistry.register(config1);
        toolRegistry.register(config2);

        verify(mcpServer).removeTool("Tool1");
        verify(mcpServer, times(2)).addTool(any(SyncToolSpecification.class));
    }

    @Test
    void shouldUnregisterTool() {
        ToolHandler handler = args -> "result";
        ToolConfig config = new ToolConfig("Tool1", "Description", handler);

        toolRegistry.register(config);
        boolean result = toolRegistry.unregister("Tool1");

        assertTrue(result);
        assertFalse(toolRegistry.isRegistered("Tool1"));
        assertEquals(0, toolRegistry.getToolCount());

        verify(mcpServer).removeTool("Tool1");
        verify(mcpServer, times(2)).notifyToolsListChanged();
    }

    @Test
    void shouldReturnFalseWhenUnregisteringNonExistentTool() {
        boolean result = toolRegistry.unregister("NonExistent");

        assertFalse(result);
        verify(mcpServer, never()).removeTool(anyString());
    }

    @Test
    void shouldGetToolConfig() {
        ToolHandler handler = args -> "result";
        ToolConfig config = new ToolConfig("Tool1", "Description", handler);

        toolRegistry.register(config);
        ToolConfig retrieved = toolRegistry.getToolConfig("Tool1");

        assertNotNull(retrieved);
        assertEquals("Tool1", retrieved.name());
    }

    @Test
    void shouldReturnNullForNonExistentTool() {
        ToolConfig config = toolRegistry.getToolConfig("NonExistent");

        assertNull(config);
    }

    @Test
    void shouldGetRegisteredToolNames() {
        ToolHandler handler = args -> "result";
        toolRegistry.register(new ToolConfig("Tool1", "Desc1", handler));
        toolRegistry.register(new ToolConfig("Tool2", "Desc2", handler));

        var names = toolRegistry.getRegisteredToolNames();

        assertEquals(2, names.size());
        assertTrue(names.contains("Tool1"));
        assertTrue(names.contains("Tool2"));
    }

    @Test
    void shouldUnregisterAllTools() {
        ToolHandler handler = args -> "result";
        toolRegistry.register(new ToolConfig("Tool1", "Desc1", handler));
        toolRegistry.register(new ToolConfig("Tool2", "Desc2", handler));

        toolRegistry.unregisterAll();

        assertEquals(0, toolRegistry.getToolCount());
        verify(mcpServer, times(2)).removeTool(anyString());
    }

    @Test
    void shouldBuildJsonSchemaWithRequiredParameters() {
        ToolHandler handler = args -> "result";
        Map<String, ToolConfig.ParameterSpec> params = Map.of(
                "param1", ToolConfig.ParameterSpec.required("string"),
                "param2", ToolConfig.ParameterSpec.optional("integer")
        );

        ToolConfig config = new ToolConfig("Tool1", "Description", params, handler);
        toolRegistry.register(config);

        ArgumentCaptor<SyncToolSpecification> specCaptor =
                ArgumentCaptor.forClass(SyncToolSpecification.class);
        verify(mcpServer).addTool(specCaptor.capture());

        var tool = specCaptor.getValue().tool();
        assertNotNull(tool.inputSchema());
        assertEquals("object", tool.inputSchema().type());
    }

    @Test
    void shouldThrowExceptionForNullConfig() {
        assertThrows(NullPointerException.class,
                () -> toolRegistry.register(null));
    }

    @Test
    void shouldThrowExceptionForNullToolName() {
        assertThrows(NullPointerException.class,
                () -> toolRegistry.unregister(null));
    }

    @Test
    void shouldReturnFalseOnRegistrationException() {
        ToolHandler handler = args -> "result";
        ToolConfig config = new ToolConfig("Tool1", "Description", handler);

        doThrow(new RuntimeException("MCP error"))
                .when(mcpServer).addTool(any(SyncToolSpecification.class));

        boolean result = toolRegistry.register(config);

        assertFalse(result);
    }
}
