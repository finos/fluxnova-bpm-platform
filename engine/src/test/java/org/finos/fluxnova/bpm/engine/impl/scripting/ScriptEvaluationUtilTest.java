package org.finos.fluxnova.bpm.engine.impl.scripting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.Reader;

import javax.script.Bindings;
import javax.script.ScriptEngine;

import org.finos.fluxnova.bpm.engine.ScriptEvaluationException;
import org.junit.Test;

public class ScriptEvaluationUtilTest {

  @Test
  public void shouldRejectNullScriptSource() {
    assertThatThrownBy(() -> ScriptEvaluationUtil.validateScriptSource(null))
        .isInstanceOf(ScriptEvaluationException.class)
        .hasMessage("Script source must not be null");
  }

  @Test
  public void shouldRejectScriptSourceAboveMaximumLength() {
    String source = repeat('x', ScriptEvaluationUtil.MAX_SCRIPT_SOURCE_LENGTH + 1);

    assertThatThrownBy(() -> ScriptEvaluationUtil.validateScriptSource(source))
        .isInstanceOf(ScriptEvaluationException.class)
        .hasMessageContaining("exceeds maximum permitted length");
  }

  @Test
  public void shouldAcceptScriptSourceAtMaximumLength() {
    String source = repeat('x', ScriptEvaluationUtil.MAX_SCRIPT_SOURCE_LENGTH);

    ScriptEvaluationUtil.validateScriptSource(source);
  }

  @Test
  public void shouldEvaluateUsingReaderOverload() throws Exception {
    ScriptEngine engine = mock(ScriptEngine.class);
    Bindings bindings = mock(Bindings.class);
    Object expected = new Object();
    when(engine.eval(any(Reader.class), org.mockito.ArgumentMatchers.eq(bindings)))
        .thenReturn(expected);

    Object actual = ScriptEvaluationUtil.evaluate(engine, "1 + 1", bindings);

    assertThat(actual).isSameAs(expected);
    verify(engine).eval(any(Reader.class), org.mockito.ArgumentMatchers.eq(bindings));
  }

  private static String repeat(char character, int count) {
    char[] characters = new char[count];
    java.util.Arrays.fill(characters, character);
    return new String(characters);
  }
}
