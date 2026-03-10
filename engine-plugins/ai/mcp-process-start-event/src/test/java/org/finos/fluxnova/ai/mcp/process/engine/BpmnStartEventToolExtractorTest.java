package org.finos.fluxnova.ai.mcp.process.engine;

import org.finos.fluxnova.ai.mcp.process.model.ToolDefinition;
import org.finos.fluxnova.bpm.engine.impl.util.xml.Element;
import org.finos.fluxnova.bpm.engine.impl.util.xml.Namespace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class BpmnStartEventToolExtractorTest {

    private BpmnStartEventToolExtractor extractor;

    @Mock
    private Element startEventElement;

    @Mock
    private Element extensionElements;

    @Mock
    private Element parametersElement;

    @Mock
    private Element parameterElement;

    private static final Namespace MCP_NAMESPACE = new Namespace("`http://fluxnova.finos.org/schema/1.0/ai/mcp`", "mcp");

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        extractor = new BpmnStartEventToolExtractor();
    }

    @Test
    void shouldExtractToolDefinitionWithParameters() {
        when(startEventElement.attributeNS(any(Namespace.class), eq("toolName"))).thenReturn("GetWeather");
        when(startEventElement.attributeNS(any(Namespace.class), eq("description"))).thenReturn("Fetches weather data");
        when(startEventElement.attributeNS(any(Namespace.class), eq("propagateBusinessKey"))).thenReturn("true");

        when(startEventElement.element("extensionElements")).thenReturn(extensionElements);
        when(extensionElements.elementNS(any(Namespace.class), eq("parameters"))).thenReturn(parametersElement);
        when(parametersElement.elementsNS(any(Namespace.class), eq("parameter"))).thenReturn(List.of(parameterElement));

        when(parameterElement.attribute("paramName")).thenReturn("location");
        when(parameterElement.attribute("paramType")).thenReturn("String");

        ToolDefinition result = extractor.extract(startEventElement, "weather-process");

        assertNotNull(result);
        assertEquals("weather-process", result.processId());
        assertEquals("GetWeather", result.toolName());
        assertEquals("Fetches weather data", result.description());
        assertEquals(2, result.parameters().size()); // location + businessKey
        assertTrue(result.propagateBusinessKey());
    }

    @Test
    void shouldReturnNullWhenNoToolName() {
        when(startEventElement.attributeNS(any(Namespace.class), eq("toolName"))).thenReturn(null);

        ToolDefinition result = extractor.extract(startEventElement, "process-1");

        assertNull(result);
    }

    @Test
    void shouldReturnNullWhenBlankToolName() {
        when(startEventElement.attributeNS(any(Namespace.class), eq("toolName"))).thenReturn("  ");

        ToolDefinition result = extractor.extract(startEventElement, "process-1");

        assertNull(result);
    }

    @Test
    void shouldUseEmptyDescriptionWhenNull() {
        when(startEventElement.attributeNS(any(Namespace.class), eq("toolName"))).thenReturn("Tool1");
        when(startEventElement.attributeNS(any(Namespace.class), eq("description"))).thenReturn(null);
        when(startEventElement.element("extensionElements")).thenReturn(null);

        ToolDefinition result = extractor.extract(startEventElement, "process-1");

        assertNotNull(result);
        assertEquals("", result.description());
    }

    @Test
    void shouldDefaultPropagateBusinessKeyToTrue() {
        when(startEventElement.attributeNS(any(Namespace.class), eq("toolName"))).thenReturn("Tool1");
        when(startEventElement.attributeNS(any(Namespace.class), eq("propagateBusinessKey"))).thenReturn(null);
        when(startEventElement.element("extensionElements")).thenReturn(null);

        ToolDefinition result = extractor.extract(startEventElement, "process-1");

        assertTrue(result.propagateBusinessKey());
    }

    @Test
    void shouldNotAddBusinessKeyWhenPropagateIsFalse() {
        when(startEventElement.attributeNS(any(Namespace.class), eq("toolName"))).thenReturn("Tool1");
        when(startEventElement.attributeNS(any(Namespace.class), eq("propagateBusinessKey"))).thenReturn("false");
        when(startEventElement.element("extensionElements")).thenReturn(null);

        ToolDefinition result = extractor.extract(startEventElement, "process-1");

        assertFalse(result.propagateBusinessKey());
        assertEquals(0, result.parameters().size());
    }

    @Test
    void shouldHandleNoExtensionElements() {
        when(startEventElement.attributeNS(any(Namespace.class), eq("toolName"))).thenReturn("Tool1");
        when(startEventElement.element("extensionElements")).thenReturn(null);

        ToolDefinition result = extractor.extract(startEventElement, "process-1");

        assertNotNull(result);
        assertEquals(1, result.parameters().size()); // Only businessKey
    }

    @Test
    void shouldSkipInvalidParameters() {
        when(startEventElement.attributeNS(any(Namespace.class), eq("toolName"))).thenReturn("Tool1");
        when(startEventElement.element("extensionElements")).thenReturn(extensionElements);
        when(extensionElements.elementNS(any(Namespace.class), eq("parameters"))).thenReturn(parametersElement);

        Element invalidParam = mock(Element.class);
        when(invalidParam.attribute("paramName")).thenReturn("");
        when(invalidParam.attribute("paramType")).thenReturn("String");

        when(parametersElement.elementsNS(any(Namespace.class), eq("parameter"))).thenReturn(List.of(invalidParam));

        ToolDefinition result = extractor.extract(startEventElement, "process-1");

        assertEquals(1, result.parameters().size()); // Only businessKey
    }

    @Test
    void shouldReturnNullOnException() {
        when(startEventElement.attributeNS(any(Namespace.class), eq("toolName"))).thenThrow(new RuntimeException("Test exception"));

        ToolDefinition result = extractor.extract(startEventElement, "process-1");

        assertNull(result);
    }
}
