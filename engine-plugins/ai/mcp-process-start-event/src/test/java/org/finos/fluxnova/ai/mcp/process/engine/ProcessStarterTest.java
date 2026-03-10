package org.finos.fluxnova.ai.mcp.process.engine;

import org.finos.fluxnova.ai.mcp.process.model.ToolDefinition;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProcessStarterTest {

    private ProcessStarter processStarter;

    @Mock
    private RuntimeService runtimeService;

    @Mock
    private ProcessInstance processInstance;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        processStarter = new ProcessStarter(runtimeService);
    }

    @Test
    void shouldStartProcessWithBusinessKey() {
        ToolDefinition definition = new ToolDefinition("weather-process", "GetWeather", "Description", List.of(), true);
        Map<String, Object> arguments = Map.of("businessKey", "BK-123", "location", "London");

        when(processInstance.getId()).thenReturn("instance-123");
        when(runtimeService.startProcessInstanceByKey(eq("weather-process"), eq("BK-123"), eq(arguments))).thenReturn(processInstance);

        Map<String, Object> result = processStarter.startProcess(definition, arguments);

        assertEquals("instance-123", result.get("processInstanceId"));
        assertEquals("BK-123", result.get("businessKey"));
        assertEquals("Process started successfully", result.get("message"));

        verify(runtimeService).startProcessInstanceByKey("weather-process", "BK-123", arguments);
    }

    @Test
    void shouldStartProcessWithoutBusinessKey() {
        ToolDefinition definition = new ToolDefinition("simple-process", "SimpleTool", "Description", List.of(), false);
        Map<String, Object> arguments = Map.of("param1", "value1");

        when(processInstance.getId()).thenReturn("instance-456");
        when(runtimeService.startProcessInstanceByKey(eq("simple-process"), isNull(), eq(arguments))).thenReturn(processInstance);

        Map<String, Object> result = processStarter.startProcess(definition, arguments);

        assertEquals("instance-456", result.get("processInstanceId"));
        assertEquals("", result.get("businessKey"));

        verify(runtimeService).startProcessInstanceByKey("simple-process", null, arguments);
    }

    @Test
    void shouldThrowExceptionOnFailure() {
        ToolDefinition definition = new ToolDefinition("failing-process", "FailTool", "Description", List.of(), true);
        Map<String, Object> arguments = Map.of();

        when(runtimeService.startProcessInstanceByKey(anyString(), anyString(), anyMap())).thenThrow(new RuntimeException("Process start failed"));

        RuntimeException exception = assertThrows(RuntimeException.class, () -> processStarter.startProcess(definition, arguments));

        assertTrue(exception.getMessage().contains("Failed to start process"));
    }
}
