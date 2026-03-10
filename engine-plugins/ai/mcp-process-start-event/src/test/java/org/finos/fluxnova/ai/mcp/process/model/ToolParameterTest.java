package org.finos.fluxnova.ai.mcp.process.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToolParameterTest {

    @Test
    void shouldCreateValidParameter() {
        ToolParameter param = new ToolParameter("customerId", "String", false);

        assertEquals("customerId", param.name());
        assertEquals("String", param.type());
        assertFalse(param.optional());
    }

    @Test
    void shouldCreateOptionalParameter() {
        ToolParameter param = new ToolParameter("businessKey", "String", true);

        assertTrue(param.optional());
    }

    @Test
    void shouldUseBackwardCompatibleConstructor() {
        ToolParameter param = new ToolParameter("id", "Integer");

        assertEquals("id", param.name());
        assertEquals("Integer", param.type());
        assertFalse(param.optional());
    }

    @Test
    void shouldNormalizeType() {
        ToolParameter param = new ToolParameter("value", "STRING", false);

        assertEquals("string", param.normalizedType());
    }

    @Test
    void shouldCheckType() {
        ToolParameter param = new ToolParameter("count", "Integer", false);

        assertTrue(param.isType("integer"));
        assertTrue(param.isType("INTEGER"));
        assertFalse(param.isType("string"));
    }

    @Test
    void shouldThrowExceptionForNullName() {
        assertThrows(NullPointerException.class, () -> new ToolParameter(null, "String", false));
    }

    @Test
    void shouldThrowExceptionForNullType() {
        assertThrows(NullPointerException.class, () -> new ToolParameter("name", null, false));
    }

    @Test
    void shouldThrowExceptionForBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new ToolParameter("", "String", false));
    }

    @Test
    void shouldThrowExceptionForBlankType() {
        assertThrows(IllegalArgumentException.class, () -> new ToolParameter("name", "", false));
    }
}
