package org.finos.fluxnova.bpm.engine.impl.scripting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import javax.script.CompiledScript;

import org.finos.fluxnova.bpm.engine.ScriptEvaluationException;
import org.junit.Test;

public class SourceExecutableScriptValidationTest {

  @Test
  public void shouldRejectNullReplacementWithoutChangingState() {
    SourceExecutableScript script = initializedScript();
    CompiledScript compiledScript = script.compiledScript;

    assertThatThrownBy(() -> script.setScriptSource(null))
        .isInstanceOf(ScriptEvaluationException.class)
        .hasMessage("Script source must not be null");

    assertThat(script.getScriptSource()).isEqualTo("original");
    assertThat(script.compiledScript).isSameAs(compiledScript);
    assertThat(script.isShouldBeCompiled()).isFalse();
  }

  @Test
  public void shouldRejectOversizedReplacementWithoutChangingState() {
    SourceExecutableScript script = initializedScript();
    CompiledScript compiledScript = script.compiledScript;
    String source = repeat('x', ScriptEvaluationUtil.MAX_SCRIPT_SOURCE_LENGTH + 1);

    assertThatThrownBy(() -> script.setScriptSource(source))
        .isInstanceOf(ScriptEvaluationException.class)
        .hasMessageContaining("exceeds maximum permitted length");

    assertThat(script.getScriptSource()).isEqualTo("original");
    assertThat(script.compiledScript).isSameAs(compiledScript);
    assertThat(script.isShouldBeCompiled()).isFalse();
  }

  @Test
  public void shouldAcceptValidReplacementAndInvalidateCompilation() {
    SourceExecutableScript script = initializedScript();

    script.setScriptSource("replacement");

    assertThat(script.getScriptSource()).isEqualTo("replacement");
    assertThat(script.compiledScript).isNull();
    assertThat(script.isShouldBeCompiled()).isTrue();
  }

  private static SourceExecutableScript initializedScript() {
    SourceExecutableScript script = new SourceExecutableScript("javascript", "original");
    script.compiledScript = mock(CompiledScript.class);
    script.shouldBeCompiled = false;
    return script;
  }

  private static String repeat(char character, int count) {
    char[] characters = new char[count];
    java.util.Arrays.fill(characters, character);
    return new String(characters);
  }
}
