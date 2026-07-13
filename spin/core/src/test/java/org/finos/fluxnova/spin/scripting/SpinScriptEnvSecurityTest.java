package org.finos.fluxnova.spin.scripting;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class SpinScriptEnvSecurityTest {

  @Test
  public void shouldRejectTraversalInLanguage() {
    assertThatThrownBy(() -> SpinScriptEnv.loadScriptEnv("../javascript", "js"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Path traversal detected");
  }

  @Test
  public void shouldRejectPathSeparatorInExtension() {
    assertThatThrownBy(() -> SpinScriptEnv.loadScriptEnv("javascript", "../js"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Path traversal detected");
  }

  @Test
  public void shouldRejectNullInput() {
    assertThatThrownBy(() -> SpinScriptEnv.loadScriptEnv(null, "js"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("Path traversal detected");
  }
}
