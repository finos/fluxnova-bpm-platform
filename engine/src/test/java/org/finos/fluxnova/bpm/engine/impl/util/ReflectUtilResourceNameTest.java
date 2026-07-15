package org.finos.fluxnova.bpm.engine.impl.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.finos.fluxnova.bpm.engine.ProcessEngineException;
import org.junit.Test;

public class ReflectUtilResourceNameTest {

  @Test
  public void shouldDecodeAndNormalizeResourceName() {
    assertThat(ReflectUtil.validateResourceName("folder%2Fsubfolder\\file.txt"))
        .isEqualTo("folder/subfolder/file.txt");
  }

  @Test
  public void shouldRejectNullResourceName() {
    assertThatThrownBy(() -> ReflectUtil.validateResourceName(null))
        .isInstanceOf(ProcessEngineException.class)
        .hasMessage("Resource name must not be null");
  }

  @Test
  public void shouldRejectMalformedEncoding() {
    assertThatThrownBy(() -> ReflectUtil.validateResourceName("folder/%ZZ/file.txt"))
        .isInstanceOf(ProcessEngineException.class)
        .hasMessageContaining("malformed encoding");
  }

  @Test
  public void shouldRejectLiteralTraversalSegment() {
    assertThatThrownBy(() -> ReflectUtil.validateResourceName("folder/../file.txt"))
        .isInstanceOf(ProcessEngineException.class)
        .hasMessageContaining("path traversal sequence");
  }

  @Test
  public void shouldRejectEncodedTraversalSegment() {
    assertThatThrownBy(() -> ReflectUtil.validateResourceName("folder/%2e%2e/file.txt"))
        .isInstanceOf(ProcessEngineException.class)
        .hasMessageContaining("path traversal sequence");
  }

  @Test
  public void shouldRejectBackslashTraversalSegment() {
    assertThatThrownBy(() -> ReflectUtil.validateResourceName("folder\\..\\file.txt"))
        .isInstanceOf(ProcessEngineException.class)
        .hasMessageContaining("path traversal sequence");
  }
}
