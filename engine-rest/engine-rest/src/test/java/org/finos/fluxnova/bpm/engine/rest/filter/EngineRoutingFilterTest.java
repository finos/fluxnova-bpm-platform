/*
 * Copyright FINOS Services GmbH and/or licensed to FINOS Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. FINOS licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.finos.fluxnova.bpm.engine.rest.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import java.util.Map;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.rest.impl.NamedProcessEngineRestServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

/**
 * Unit tests for {@link EngineRoutingFilter}.
 *
 * <p>The filter is tested via a thin subclass that overrides {@code getEngineFromHeader} and
 * {@code isDefaultEngine}, so we never touch static {@code ProcessEngines} state.
 */
public class EngineRoutingFilterTest {

  private static final String ENGINE_NAME = "engine-a";
  private static final String NAMED_ENGINE_PATH = NamedProcessEngineRestServiceImpl.PATH; // "/engine"

  private ProcessEngine mockEngine;
  private ProcessEngine mockDefaultEngine;

  private TestableEngineRoutingFilter filter;

  private HttpServletRequest request;
  private HttpServletResponse response;
  private FilterChain chain;
  private RequestDispatcher dispatcher;

  @BeforeEach
  public void setUp() throws Exception {
    mockEngine = mock(ProcessEngine.class);
    when(mockEngine.getName()).thenReturn(ENGINE_NAME);

    mockDefaultEngine = mock(ProcessEngine.class);
    when(mockDefaultEngine.getName()).thenReturn("default");

    filter = new TestableEngineRoutingFilter(Map.of(ENGINE_NAME, mockEngine), mockDefaultEngine);
    filter.init(buildFilterConfig(EngineRoutingFilter.DEFAULT_ENGINE_HEADER_NAME));

    request = mock(HttpServletRequest.class);
    response = mock(HttpServletResponse.class);
    chain = mock(FilterChain.class);
    dispatcher = mock(RequestDispatcher.class);
  }

  @Test
  public void defaultHeaderIsUsedWhenNoInitParamIsSet() throws Exception {
    TestableEngineRoutingFilter f = new TestableEngineRoutingFilter(mockEngine, mockDefaultEngine);
    f.init(buildFilterConfig(null));
    assertThat(f.getEngineHeaderName()).isEqualTo(EngineRoutingFilter.DEFAULT_ENGINE_HEADER_NAME);
  }

  @Test
  public void customHeaderIsUsedWhenInitParamIsSet() throws Exception {
    TestableEngineRoutingFilter f = new TestableEngineRoutingFilter(mockEngine, mockDefaultEngine);
    f.init(buildFilterConfig("x-my-engine"));
    assertThat(f.getEngineHeaderName()).isEqualTo("x-my-engine");
  }

  @Test
  public void requestIsForwardedToNamedEnginePathWhenHeaderMatchesNonDefaultEngine()
      throws Exception {
    when(request.getHeader(EngineRoutingFilter.DEFAULT_ENGINE_HEADER_NAME)).thenReturn(ENGINE_NAME);
    stubRequestPath(request, "", "/engine-rest", "/process-definition");
    when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    when(request.getDispatcherType()).thenReturn(DispatcherType.REQUEST);

    filter.doFilter(request, response, chain);

    ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
    verify(request).getRequestDispatcher(pathCaptor.capture());
    verify(dispatcher).forward(request, response);
    verifyNoInteractions(chain);

    assertThat(pathCaptor.getValue())
        .isEqualTo("/engine-rest" + NAMED_ENGINE_PATH + "/" + ENGINE_NAME + "/process-definition");
  }

  @Test
  public void chainIsCalledWhenNoEngineHeaderIsPresent() throws Exception {
    when(request.getHeader(EngineRoutingFilter.DEFAULT_ENGINE_HEADER_NAME)).thenReturn(null);
    stubRequestPath(request, "", "/engine-rest", "/process-definition");
    when(request.getDispatcherType()).thenReturn(DispatcherType.REQUEST);

    filter.doFilter(request, response, chain);

    verify(chain).doFilter(request, response);
    verify(request, never()).getRequestDispatcher(anyString());
  }

  @Test
  public void chainIsCalledWhenEngineHeaderIsBlank() throws Exception {
    when(request.getHeader(EngineRoutingFilter.DEFAULT_ENGINE_HEADER_NAME)).thenReturn("  ");
    stubRequestPath(request, "", "/engine-rest", "/process-definition");
    when(request.getDispatcherType()).thenReturn(DispatcherType.REQUEST);

    filter.doFilter(request, response, chain);

    verify(chain).doFilter(request, response);
    verify(request, never()).getRequestDispatcher(anyString());
  }

  @Test
  public void chainIsCalledWhenEngineIsDefault() throws Exception {
    TestableEngineRoutingFilter f = new TestableEngineRoutingFilter(
        Map.of("default", mockDefaultEngine), mockDefaultEngine);
    f.init(buildFilterConfig(null));

    when(request.getHeader(EngineRoutingFilter.DEFAULT_ENGINE_HEADER_NAME)).thenReturn("default");
    stubRequestPath(request, "", "/engine-rest", "/process-definition");
    when(request.getDispatcherType()).thenReturn(DispatcherType.REQUEST);

    f.doFilter(request, response, chain);

    verify(chain).doFilter(request, response);
    verify(request, never()).getRequestDispatcher(anyString());
  }

  @Test
  public void chainIsCalledWhenEngineNameIsAlreadyInPath() throws Exception {
    when(request.getHeader(EngineRoutingFilter.DEFAULT_ENGINE_HEADER_NAME)).thenReturn(ENGINE_NAME);
    String pathWithEngine = NAMED_ENGINE_PATH + "/" + ENGINE_NAME + "/process-definition";
    when(request.getContextPath()).thenReturn("");
    when(request.getServletPath()).thenReturn("/engine-rest");
    when(request.getPathInfo()).thenReturn(pathWithEngine);
    when(request.getRequestURI()).thenReturn("/engine-rest" + pathWithEngine);
    when(request.getDispatcherType()).thenReturn(DispatcherType.REQUEST);

    filter.doFilter(request, response, chain);

    verify(chain).doFilter(request, response);
    verify(request, never()).getRequestDispatcher(anyString());
  }

  @Test
  public void chainIsCalledWhenRequestTargetsEnginesListingEndpoint() throws Exception {
    when(request.getHeader(EngineRoutingFilter.DEFAULT_ENGINE_HEADER_NAME)).thenReturn(ENGINE_NAME);
    when(request.getContextPath()).thenReturn("");
    when(request.getServletPath()).thenReturn("/engine-rest");
    when(request.getPathInfo()).thenReturn(NAMED_ENGINE_PATH);
    when(request.getRequestURI()).thenReturn("/engine-rest" + NAMED_ENGINE_PATH);
    when(request.getDispatcherType()).thenReturn(DispatcherType.REQUEST);

    filter.doFilter(request, response, chain);

    verify(chain).doFilter(request, response);
    verify(request, never()).getRequestDispatcher(anyString());
  }

  @Test
  public void chainIsCalledImmediatelyOnForwardDispatchToPreventInfiniteLoop() throws Exception {
    when(request.getHeader(EngineRoutingFilter.DEFAULT_ENGINE_HEADER_NAME)).thenReturn(ENGINE_NAME);
    when(request.getDispatcherType()).thenReturn(DispatcherType.FORWARD);
    stubRequestPath(request, "", "/engine-rest",
        NAMED_ENGINE_PATH + "/" + ENGINE_NAME + "/process-definition");

    filter.doFilter(request, response, chain);

    verify(chain).doFilter(request, response);
    verify(request, never()).getRequestDispatcher(anyString());
  }

  @Test
  public void requestIsForwardedWithQueryStringInPathInfo() throws Exception {
    when(request.getHeader(EngineRoutingFilter.DEFAULT_ENGINE_HEADER_NAME)).thenReturn(ENGINE_NAME);
    when(request.getContextPath()).thenReturn("");
    when(request.getServletPath()).thenReturn("/engine-rest");
    when(request.getPathInfo()).thenReturn("/process-definition?keyLike=whatever");
    when(request.getRequestURI()).thenReturn("/engine-rest/process-definition");
    when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
    when(request.getDispatcherType()).thenReturn(DispatcherType.REQUEST);

    filter.doFilter(request, response, chain);

    ArgumentCaptor<String> pathCaptor = ArgumentCaptor.forClass(String.class);
    verify(request).getRequestDispatcher(pathCaptor.capture());
    verify(dispatcher).forward(request, response);
    verifyNoInteractions(chain);

    assertThat(pathCaptor.getValue())
        .isEqualTo("/engine-rest" + NAMED_ENGINE_PATH + "/" + ENGINE_NAME
            + "/process-definition?keyLike=whatever");
  }

  // -----------------------------------------------------------------------
  // Helpers
  // -----------------------------------------------------------------------

  private static void stubRequestPath(
      HttpServletRequest req, String contextPath, String servletPath, String pathInfo) {
    when(req.getContextPath()).thenReturn(contextPath);
    when(req.getServletPath()).thenReturn(servletPath);
    when(req.getPathInfo()).thenReturn(pathInfo);
    when(req.getRequestURI()).thenReturn(contextPath + servletPath + pathInfo);
  }

  private static FilterConfig buildFilterConfig(String headerParamValue) {
    FilterConfig fc = mock(FilterConfig.class);
    when(fc.getInitParameter(EngineRoutingFilter.FXN_ENGINE_HEADER_KEY))
        .thenReturn(headerParamValue);
    return fc;
  }

  /**
   * Subclass that overrides the two methods that would otherwise reach into static
   * {@code ProcessEngines} state.
   */
  private static class TestableEngineRoutingFilter extends EngineRoutingFilter {

    private final Map<String, ProcessEngine> enginesByHeaderValue;
    private final ProcessEngine defaultEngine;

    TestableEngineRoutingFilter(Map<String, ProcessEngine> enginesByHeaderValue,
                                ProcessEngine defaultEngine) {
      this.enginesByHeaderValue = enginesByHeaderValue;
      this.defaultEngine = defaultEngine;
    }

    TestableEngineRoutingFilter(ProcessEngine engine, ProcessEngine defaultEngine) {
      this(Map.of(engine.getName(), engine), defaultEngine);
    }

    @Override
    protected ProcessEngine getEngineFromHeader(HttpServletRequest req) {
      String header = req.getHeader(getEngineHeaderName());
      if (header == null || header.trim().isEmpty()) {
        return null;
      }
      return enginesByHeaderValue.get(header.trim());
    }

    @Override
    protected boolean isDefaultEngine(ProcessEngine engine) {
      return engine == defaultEngine;
    }
  }
}

