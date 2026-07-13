package org.finos.fluxnova.bpm.webapp.plugin.resource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import javax.servlet.ServletContext;

import org.finos.fluxnova.bpm.engine.rest.exception.RestException;
import org.finos.fluxnova.bpm.webapp.AppRuntimeDelegate;
import org.finos.fluxnova.bpm.webapp.plugin.spi.AppPlugin;
import org.junit.Before;
import org.junit.Test;

public class AbstractAppPluginRootResourceSecurityTest {

  private TestResource resource;
  private ServletContext servletContext;
  private AppPlugin plugin;

  @Before
  public void setUp() {
    resource = new TestResource(mock(AppRuntimeDelegate.class));
    servletContext = mock(ServletContext.class);
    plugin = mock(AppPlugin.class);
    resource.servletContext = servletContext;
  }

  @Test
  public void shouldAllowNormalWebResourcePath() {
    resource.webResource("app", "plugin.js");
    verify(servletContext).getResourceAsStream("/app/plugin.js");
  }

  @Test
  public void shouldRejectUnixTraversalInAssetDirectory() {
    assertThatThrownBy(() -> resource.webResource("../WEB-INF", "web.xml"))
        .isInstanceOf(RestException.class)
        .hasMessageContaining("Path traversal detected");
  }

  @Test
  public void shouldRejectWindowsTraversalInFileName() {
    assertThatThrownBy(() -> resource.classpathResource(plugin, "app", "..\\secret.txt"))
        .isInstanceOf(RestException.class)
        .hasMessageContaining("Path traversal detected");
  }

  @Test
  public void shouldRejectNullPathSegment() {
    assertThatThrownBy(() -> resource.webResource(null, "plugin.js"))
        .isInstanceOf(RestException.class)
        .hasMessageContaining("must not be null");
  }

  private static class TestResource extends AbstractAppPluginRootResource<AppPlugin> {
    TestResource(AppRuntimeDelegate<AppPlugin> runtimeDelegate) {
      super("test", runtimeDelegate);
    }

    void webResource(String directory, String file) {
      getWebResourceAsStream(directory, file);
    }

    void classpathResource(AppPlugin plugin, String directory, String file) {
      getClasspathResourceAsStream(plugin, directory, file);
    }
  }
}
