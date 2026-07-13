package org.finos.fluxnova.bpm.engine.impl.scripting;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import javax.script.Bindings;
import javax.script.ScriptEngine;

import org.finos.fluxnova.bpm.engine.ScriptEvaluationException;
import org.finos.fluxnova.bpm.engine.delegate.Expression;
import org.finos.fluxnova.bpm.engine.delegate.VariableScope;
import org.junit.Test;

public class ExecutableScriptSecurityTest {

  private final ScriptEngine engine = mock(ScriptEngine.class);
  private final VariableScope variableScope = mock(VariableScope.class);
  private final Bindings bindings = mock(Bindings.class);

  @Test
  public void shouldRejectOversizedDynamicScript() {
    String oversized = repeat('x', 1_000_001);
    DynamicExecutableScript script = dynamicScript(oversized);

    assertThatThrownBy(() -> script.execute(engine, variableScope, bindings))
        .isInstanceOf(ScriptEvaluationException.class)
        .hasMessageContaining("exceeds the maximum allowed");
  }

  @Test
  public void shouldRejectNullByteInDynamicScript() {
    DynamicExecutableScript script = dynamicScript("print('safe')\0print('unsafe')");

    assertThatThrownBy(() -> script.execute(engine, variableScope, bindings))
        .isInstanceOf(ScriptEvaluationException.class)
        .hasMessageContaining("illegal null bytes");
  }

  @Test
  public void shouldRejectNullDynamicScript() {
    DynamicExecutableScript script = dynamicScript(null);

    assertThatThrownBy(() -> script.execute(engine, variableScope, bindings))
        .isInstanceOf(ScriptEvaluationException.class)
        .hasMessageContaining("must not be null");
  }

  @Test
  public void shouldRejectNullByteInSourceScriptBeforeCompilation() {
    SourceExecutableScript script = new SourceExecutableScript("javascript", "print('safe')\0print('unsafe')");

    assertThatThrownBy(() -> script.execute(engine, variableScope, bindings))
        .isInstanceOf(ScriptEvaluationException.class)
        .hasMessageContaining("illegal null bytes");
  }

  private DynamicExecutableScript dynamicScript(final String source) {
    return new DynamicExecutableScript(mock(Expression.class), "javascript") {
      @Override
      public String getScriptSource(VariableScope scope) {
        return source;
      }
    };
  }

  private static String repeat(char value, int count) {
    StringBuilder result = new StringBuilder(count);
    for (int i = 0; i < count; i++) {
      result.append(value);
    }
    return result.toString();
  }
}
