package org.finos.fluxnova.bpm.spring.boot.starter.webapp.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.finos.fluxnova.bpm.spring.boot.starter.property.WebappProperty;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class ResourceLoadingProcessEnginesFilterPathTest {

  private ResourceLoader resourceLoader;
  private WebappProperty webappProperty;
  private TestFilter filter;

  @Before
  public void setUp() {
    resourceLoader = mock(ResourceLoader.class);
    webappProperty = mock(WebappProperty.class);
    when(webappProperty.getWebjarClasspath()).thenReturn("webapp/");

    filter = new TestFilter();
    filter.setResourceLoader(resourceLoader);
    filter.setWebappProperty(webappProperty);
  }

  @Test
  public void shouldUseDecodedAndNormalizedResourceName() throws Exception {
    Resource resource = mock(Resource.class);
    when(resourceLoader.getResource("classpath:webapp/app/config.js")).thenReturn(resource);
    when(resource.getInputStream()).thenReturn(
        new ByteArrayInputStream("content".getBytes(StandardCharsets.UTF_8)));

    assertThat(filter.read("app%2Fconfig.js")).isEqualTo("content\n");
    verify(resourceLoader).getResource("classpath:webapp/app/config.js");
  }

  @Test
  public void shouldRejectEncodedTraversalBeforeLookup() {
    assertThatThrownBy(() -> filter.read("app/%2e%2e/config.js"))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("path traversal sequence");

    verify(resourceLoader, never()).getResource(org.mockito.ArgumentMatchers.anyString());
  }

  @Test
  public void shouldRejectMalformedEncodingBeforeLookup() {
    assertThatThrownBy(() -> filter.read("app/%ZZ/config.js"))
        .isInstanceOf(IOException.class)
        .hasMessageContaining("malformed encoding");

    verify(resourceLoader, never()).getResource(org.mockito.ArgumentMatchers.anyString());
  }

  private static class TestFilter extends ResourceLoadingProcessEnginesFilter {
    String read(String name) throws IOException {
      return getWebResourceContents(name);
    }
  }
}
