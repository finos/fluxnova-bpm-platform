package org.finos.fluxnova.bpm.spring.boot.starter.webapp.filter;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.IOException;

import org.junit.Test;

public class ResourceLoadingProcessEnginesFilterSecurityTest {

  @Test
  public void shouldRejectUnixTraversal() {
    TestFilter filter = new TestFilter();
    assertThatThrownBy(() -> filter.readResource("../../application.properties"))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("Path traversal detected");
  }

  @Test
  public void shouldRejectWindowsTraversal() {
    TestFilter filter = new TestFilter();
    assertThatThrownBy(() -> filter.readResource("..\\..\\application.properties"))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("Path traversal detected");
  }

  @Test
  public void shouldRejectNullResourceName() {
    TestFilter filter = new TestFilter();
    assertThatThrownBy(() -> filter.readResource(null))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("must not be null");
  }

  private static class TestFilter extends ResourceLoadingProcessEnginesFilter {
    String readResource(String name) throws IOException {
      return getWebResourceContents(name);
    }
  }
}
