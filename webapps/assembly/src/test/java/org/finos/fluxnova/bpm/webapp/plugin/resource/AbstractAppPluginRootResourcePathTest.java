package org.finos.fluxnova.bpm.webapp.plugin.resource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import org.finos.fluxnova.bpm.webapp.AppRuntimeDelegate;
import org.finos.fluxnova.bpm.webapp.plugin.spi.AppPlugin;
import org.junit.Before;
import org.junit.Test;

public class AbstractAppPluginRootResourcePathTest {

  private ServletContext servletContext;
  private TestResource resource;

  @Before
  public void setUp() {
    servletContext = mock(ServletContext.class);
    resource = new TestResource(mock(AppRuntimeDelegate.class));
    resource.servletContext = servletContext;
  }

  @Test
  public void shouldUseDecodedAndNormalizedWebResourcePath() {
    InputStream expected = new ByteArrayInputStream(new byte[0]);
    when(servletContext.getResourceAsStream("/plugin/assets/app/plugin.js"))
        .thenReturn(expected);

    InputStream actual = resource.web("plugin%2Fassets", "app\\plugin.js");

    assertThat(actual).isSameAs(expected);
    verify(servletContext).getResourceAsStream("/plugin/assets/app/plugin.js");
  }

  @Test
  public void shouldRejectEncodedTraversalBeforeWebLookup() {
    assertBadRequest(() -> resource.web("plugin/%2e%2e", "plugin.js"));

    verify(servletContext, never()).getResourceAsStream(
        org.mockito.ArgumentMatchers.anyString());
  }

  @Test
  public void shouldRejectMalformedEncodingBeforeWebLookup() {
    assertBadRequest(() -> resource.web("plugin/%ZZ", "plugin.js"));

    verify(servletContext, never()).getResourceAsStream(
        org.mockito.ArgumentMatchers.anyString());
  }

  private static void assertBadRequest(Runnable invocation) {
    try {
      invocation.run();
      org.junit.Assert.fail("Expected WebApplicationException");
    }
    catch (WebApplicationException e) {
      assertThat(e.getResponse().getStatus())
          .isEqualTo(Status.BAD_REQUEST.getStatusCode());
    }
  }

  private static class TestResource extends AbstractAppPluginRootResource<AppPlugin> {

    TestResource(AppRuntimeDelegate<AppPlugin> runtimeDelegate) {
      super("test", runtimeDelegate);
    }

    InputStream web(String assetDirectory, String fileName) {
      return getWebResourceAsStream(assetDirectory, fileName);
    }
  }
}
