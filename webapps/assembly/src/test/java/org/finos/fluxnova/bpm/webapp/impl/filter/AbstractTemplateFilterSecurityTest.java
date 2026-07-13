package org.finos.fluxnova.bpm.webapp.impl.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class AbstractTemplateFilterSecurityTest {

  private TestFilter filter;

  @Before
  public void setUp() throws ServletException {
    FilterConfig filterConfig = mock(FilterConfig.class);
    ServletContext servletContext = mock(ServletContext.class);
    org.mockito.Mockito.when(filterConfig.getServletContext()).thenReturn(servletContext);

    filter = new TestFilter();
    filter.init(filterConfig);
  }

  @Test
  public void shouldRejectTraversalWhenCheckingResourceExistence() {
    assertThat(filter.hasResource("../../WEB-INF/web.xml")).isFalse();
    assertThat(filter.hasResource("..\\..\\WEB-INF\\web.xml")).isFalse();
  }

  @Test
  public void shouldRejectNullWhenCheckingResourceExistence() {
    assertThat(filter.hasResource(null)).isFalse();
  }

  @Test
  public void shouldRejectTraversalWhenReadingResource() {
    assertThatThrownBy(() -> filter.readResource("../WEB-INF/web.xml"))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("Path traversal detected");
  }

  @Test
  public void shouldRejectNullWhenReadingResource() {
    assertThatThrownBy(() -> filter.readResource(null))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("must not be null");
  }

  private static class TestFilter extends AbstractTemplateFilter {
    @Override
    protected void applyFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
      // no-op
    }

    boolean hasResource(String name) {
      return hasWebResource(name);
    }

    String readResource(String name) throws IOException {
      return getWebResourceContents(name);
    }
  }
}
