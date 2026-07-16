package org.finos.fluxnova.bpm.engine.impl.scripting;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.finos.fluxnova.bpm.engine.ScriptEvaluationException;
import org.finos.fluxnova.bpm.engine.delegate.VariableScope;
import org.junit.Test;

public class DynamicExecutableScriptValidationTest {

  @Test
  public void shouldRejectNullSourceBeforeEvaluation() throws ScriptException {
    ScriptEngine engine = mock(ScriptEngine.class);
    Bindings bindings = mock(Bindings.class);
    DynamicExecutableScript script = new TestDynamicExecutableScript(null);

    assertThatThrownBy(() -> script.evaluate(engine, null, bindings))
        .isInstanceOf(ScriptEvaluationException.class)
        .hasMessage("Script source must not be null");

    verify(engine, never()).eval(any(Reader.class), any(Bindings.class));
  }

  @Test
  public void shouldRejectOversizedSourceBeforeEvaluation() throws ScriptException {
    ScriptEngine engine = mock(ScriptEngine.class);
    Bindings bindings = mock(Bindings.class);
    String source = repeat('x', ScriptEvaluationUtil.MAX_SCRIPT_SOURCE_LENGTH + 1);
    DynamicExecutableScript script = new TestDynamicExecutableScript(source);

    assertThatThrownBy(() -> script.evaluate(engine, null, bindings))
        .isInstanceOf(ScriptEvaluationException.class)
        .hasMessageContaining("exceeds maximum permitted length");

    verify(engine, never()).eval(any(Reader.class), any(Bindings.class));
  }

  private static String repeat(char character, int count) {
    char[] characters = new char[count];
    java.util.Arrays.fill(characters, character);
    return new String(characters);
  }

  private static class TestDynamicExecutableScript extends DynamicExecutableScript {

    private final String source;

    TestDynamicExecutableScript(String source) {
      super(null, "javascript");
      this.source = source;
    }

    @Override
    public String getScriptSource(VariableScope variableScope) {
      return source;
    }
  }
}
