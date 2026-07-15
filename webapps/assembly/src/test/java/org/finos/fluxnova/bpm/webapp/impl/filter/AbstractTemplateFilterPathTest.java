package org.finos.fluxnova.bpm.webapp.impl.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class AbstractTemplateFilterPathTest {

  private ServletContext servletContext;
  private TestFilter filter;

  @Before
  public void setUp() throws Exception {
    servletContext = mock(ServletContext.class);
    FilterConfig filterConfig = mock(FilterConfig.class);
    when(filterConfig.getServletContext()).thenReturn(servletContext);

    filter = new TestFilter();
    filter.init(filterConfig);
  }

  @Test
  public void shouldUseDecodedResourceNameWhenCheckingExistence() throws Exception {
    URL resource = new URL("file:/app/index.html");
    when(servletContext.getResource("/app/index.html")).thenReturn(resource);

    assertThat(filter.exists("/app%2Findex.html")).isTrue();
    verify(servletContext).getResource("/app/index.html");
  }

  @Test
  public void shouldReturnFalseForEncodedTraversal() throws Exception {
    assertThat(filter.exists("/app/%2e%2e/index.html")).isFalse();
    verify(servletContext, never()).getResource(org.mockito.ArgumentMatchers.anyString());
  }

  @Test
  public void shouldUseNormalizedResourceNameWhenReading() throws Exception {
    when(servletContext.getResourceAsStream("/app/index.html")).thenReturn(
        new ByteArrayInputStream("content".getBytes(StandardCharsets.UTF_8)));

    assertThat(filter.read("/app\\index.html")).isEqualTo("content\n");
    verify(servletContext).getResourceAsStream("/app/index.html");
  }

  @Test
  public void shouldRejectMalformedEncodingBeforeReading() {
    assertThatThrownBy(() -> filter.read("/app/%ZZ/index.html"))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("malformed encoding");
  }

  private static class TestFilter extends AbstractTemplateFilter {

    boolean exists(String name) {
      return hasWebResource(name);
    }

    String read(String name) throws IOException {
      return getWebResourceContents(name);
    }

    @Override
    protected void applyFilter(
        HttpServletRequest request,
        HttpServletResponse response,
        FilterChain chain) throws IOException, ServletException {
      // not used
    }
  }
}
