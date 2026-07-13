package org.finos.fluxnova.bpm.engine.impl.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.finos.fluxnova.bpm.engine.ProcessEngineException;
import org.junit.Test;

public class ReflectUtilSecurityTest {

  @Test
  public void shouldRejectSingleDotPathSegment() {
    assertThatThrownBy(() -> ReflectUtil.validateResourceName("config/./engine.xml"))
        .isInstanceOf(ProcessEngineException.class)
        .hasMessageContaining("path traversal");
  }

  @Test
  public void shouldRejectBareDot() {
    assertThatThrownBy(() -> ReflectUtil.validateResourceName("."))
        .isInstanceOf(ProcessEngineException.class)
        .hasMessageContaining("path traversal");
  }

  @Test
  public void shouldRejectWindowsTraversal() {
    assertThatThrownBy(() -> ReflectUtil.validateResourceName("config\\..\\secret.xml"))
        .isInstanceOf(ProcessEngineException.class)
        .hasMessageContaining("path traversal");
  }

  @Test
  public void shouldRejectNullResourceName() {
    assertThatThrownBy(() -> ReflectUtil.validateResourceName(null))
        .isInstanceOf(ProcessEngineException.class)
        .hasMessageContaining("must not be null");
  }
}
