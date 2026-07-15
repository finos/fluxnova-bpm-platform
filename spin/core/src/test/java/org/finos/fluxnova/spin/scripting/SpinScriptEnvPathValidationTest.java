package org.finos.fluxnova.spin.scripting;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.finos.fluxnova.spin.SpinScriptException;
import org.junit.Test;

public class SpinScriptEnvPathValidationTest {

  @Test
  public void shouldLoadKnownScriptEnvironment() {
    assertThat(SpinScriptEnv.loadScriptEnv("javascript", "js")).isNotEmpty();
  }

  @Test
  public void shouldRejectEncodedTraversalSegment() {
    assertThatThrownBy(() -> SpinScriptEnv.loadScriptEnv("%2e%2e", "js"))
        .isInstanceOf(SpinScriptException.class);
  }

  @Test
  public void shouldRejectBackslashTraversalSegment() {
    assertThatThrownBy(() -> SpinScriptEnv.loadScriptEnv("..\\ignored", "js"))
        .isInstanceOf(SpinScriptException.class);
  }

  @Test
  public void shouldRejectMalformedEncoding() {
    assertThatThrownBy(() -> SpinScriptEnv.loadScriptEnv("%ZZ", "js"))
        .isInstanceOf(SpinScriptException.class);
  }
}
