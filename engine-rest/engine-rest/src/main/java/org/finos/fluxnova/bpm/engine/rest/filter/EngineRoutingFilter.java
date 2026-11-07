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

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEngines;
import org.finos.fluxnova.bpm.engine.rest.impl.NamedProcessEngineRestServiceImpl;
import org.finos.fluxnova.bpm.engine.rest.util.EngineUtil;

/**
 * A servlet filter that routes requests to a named process engine based on a configurable HTTP
 * request header. When a request arrives without an engine name in the path and the header value
 * maps to a non-default process engine, the request is forwarded to the engine-specific path
 * (e.g. {@code /engine/{name}/...}).
 *
 * <p>The header name is configurable via the {@value #FXN_ENGINE_HEADER_KEY} filter init
 * parameter. If not configured, it falls back to {@value #DEFAULT_ENGINE_HEADER_NAME}, but
 * <strong>consumers are expected to override this</strong> with a header name appropriate for
 * their deployment (e.g. {@code x-tenant-id}).
 *
 * <p>Example {@code web.xml} configuration:
 * <pre>{@code
 * <filter>
 *   <filter-name>EngineRoutingFilter</filter-name>
 *   <filter-class>org.finos.fluxnova.bpm.engine.rest.filter.EngineRoutingFilter</filter-class>
 *   <init-param>
 *     <param-name>engineHeaderName</param-name>
 *     <param-value>x-tenant-id</param-value>  <!-- override with your own header name -->
 *   </init-param>
 * </filter>
 * <filter-mapping>
 *   <filter-name>EngineRoutingFilter</filter-name>
 *   <url-pattern>/*</url-pattern>
 * </filter-mapping>
 * }</pre>
 */
public class EngineRoutingFilter implements Filter {

  private static final Logger LOG = Logger.getLogger(EngineRoutingFilter.class.getName());

  /** Filter init-param name used to configure the engine routing header. */
  public static final String FXN_ENGINE_HEADER_KEY = "engineHeaderName";

  /**
   * The initial value used for the engine routing header name if no
   * {@value #FXN_ENGINE_HEADER_KEY} init-param is found. This is not intended to be a
   * permanent value — consuming applications should override it via {@code web.xml} with a header
   * name that matches their own conventions (e.g. {@code x-tenant-id}).
   */
  public static final String DEFAULT_ENGINE_HEADER_NAME = "x-fxn-engine";

  /**
   * The path of the named-engine listing endpoint. Requests to this path are never rewritten
   * because the path does not support an engine name segment.
   */
  protected static final String ENGINES_ENDPOINT = NamedProcessEngineRestServiceImpl.PATH;

  /**
   * Pattern used to detect whether a request URL already contains a named-engine path segment
   * ({@code /engine/<name>} or {@code /engine/<name>/...}).
   */
  protected static final Pattern ENGINE_REQUEST_URL_PATTERN =
      Pattern.compile("^" + NamedProcessEngineRestServiceImpl.PATH + "/([^/]+)(/|$)");

  private String engineHeaderName = DEFAULT_ENGINE_HEADER_NAME;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    String configured = filterConfig.getInitParameter(FXN_ENGINE_HEADER_KEY);
    if (configured != null && !configured.trim().isEmpty()) {
      engineHeaderName = configured.trim();
    }
    LOG.log(Level.INFO, "EngineRoutingFilter initialised - engine routing header: {0}", engineHeaderName);
  }

  @Override
  public void destroy() {
    // nothing to clean up
  }

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {

    if (DispatcherType.FORWARD.equals(req.getDispatcherType())) {
      chain.doFilter(req, res);
      return;
    }

    HttpServletRequest httpReq = (HttpServletRequest) req;
    ProcessEngine engineFromHeader = getEngineFromHeader(httpReq);

    if (shouldRewritePath(httpReq, engineFromHeader)) {
      String engineSpecificPath = buildEngineSpecificPath(httpReq, engineFromHeader);
      LOG.fine("EngineRoutingFilter: forwarding " + sanitizeForLog(httpReq.getPathInfo())
          + " -> " + sanitizeForLog(engineSpecificPath)
          + " (engine: " + engineFromHeader.getName() + ")");
      httpReq.getRequestDispatcher(engineSpecificPath).forward(req, res);
    } else {
      LOG.fine("EngineRoutingFilter: not rewriting " + sanitizeForLog(httpReq.getPathInfo()));
      chain.doFilter(req, res);
    }
  }

  /**
   * Returns the process engine that corresponds to the header value, or {@code null} if the
   * header is absent, blank, or no matching engine is registered.
   */
  protected ProcessEngine getEngineFromHeader(HttpServletRequest req) {
    String headerValue = req.getHeader(engineHeaderName);
    if (headerValue == null || headerValue.trim().isEmpty()) {
      return null;
    }
    try {
      return EngineUtil.lookupProcessEngine(headerValue.trim());
    } catch (Exception e) {
      LOG.log(Level.FINE, e,
          () -> "EngineRoutingFilter: no engine found for header value '" + headerValue + "'");
      return null;
    }
  }

  /**
   * Returns {@code true} when the request should be rewritten to the named-engine path.
   *
   * <p>Rewriting is skipped when:
   * <ul>
   *   <li>no engine was resolved from the header,</li>
   *   <li>the resolved engine is the default engine,</li>
   *   <li>the request path already contains an engine name segment, or</li>
   *   <li>the request targets the engine-listing endpoint itself.</li>
   * </ul>
   */
  protected boolean shouldRewritePath(HttpServletRequest httpReq, ProcessEngine engineFromHeader) {
    return engineFromHeader != null
        && !isDefaultEngine(engineFromHeader)
        && doesRequestSupportEngineNameInPath(httpReq)
        && !isEngineNameInPath(httpReq);
  }

  /**
   * Returns {@code true} when the request URL does not already carry an engine name segment.
   * Requests to the bare {@value #ENGINES_ENDPOINT} listing path are excluded because they do not
   * support an engine-name sub-path.
   */
  protected boolean doesRequestSupportEngineNameInPath(HttpServletRequest httpReq) {
    // Excludes the /engine listing endpoint, which doesn't support adding an engine name
    String requestUri = httpReq.getRequestURI();
    if (requestUri == null) {
      return false;
    }
    String contextPath = httpReq.getContextPath() == null ? "" : httpReq.getContextPath();
    String servletPath = httpReq.getServletPath() == null ? "" : httpReq.getServletPath();
    String relativePath = requestUri.substring(contextPath.length() + servletPath.length());
    return !ENGINES_ENDPOINT.equalsIgnoreCase(relativePath);
  }

  /**
   * Returns {@code true} when the request path already contains a named-engine segment,
   * i.e. matches {@code /engine/<name>} or {@code /engine/<name>/...}.
   */
  protected boolean isEngineNameInPath(HttpServletRequest httpReq) {
    return extractEngineNameFromPath(httpReq) != null;
  }

  /**
   * Extracts the engine name from a request path that follows the pattern
   * {@code /engine/<name>/...} or {@code /engine/<name>}, or returns {@code null} if the path
   * does not match.
   */
  protected String extractEngineNameFromPath(HttpServletRequest httpReq) {
    String contextPath = httpReq.getContextPath() == null ? "" : httpReq.getContextPath();
    String servletPath = httpReq.getServletPath() == null ? "" : httpReq.getServletPath();
    String requestUri = httpReq.getRequestURI();
    if (requestUri == null) {
      return null;
    }
    String relativeUrl = requestUri.substring(contextPath.length() + servletPath.length());
    Matcher matcher = ENGINE_REQUEST_URL_PATTERN.matcher(relativeUrl);
    return matcher.find() ? matcher.group(1) : null;
  }

  protected static final String DEFAULT_ENGINE_NAME = ProcessEngines.NAME_DEFAULT;

  /**
   * Returns {@code true} when {@code engine} is the JVM-default process engine or is named
   * {@value #DEFAULT_ENGINE_NAME}. Requests routed to the default engine do not need the
   * {@code /engine/<name>} path prefix, so the header can simply be omitted.
   */
  protected boolean isDefaultEngine(ProcessEngine engine) {
    return engine == ProcessEngines.getDefaultProcessEngine()
        || DEFAULT_ENGINE_NAME.equals(engine.getName());
  }

  /**
   * Builds the forwarding path for the given named engine, e.g.
   * {@code <servletPath>/engine/<engineName><pathInfo>}.
   */
  protected String buildEngineSpecificPath(HttpServletRequest httpReq, ProcessEngine engine) {
    String servletPath = httpReq.getServletPath() == null ? "" : httpReq.getServletPath();
    String pathInfo = httpReq.getPathInfo() == null ? "" : httpReq.getPathInfo();
    return servletPath
        + NamedProcessEngineRestServiceImpl.PATH
        + "/"
        + engine.getName()
        + pathInfo;
  }

  /**
   * Sanitizes a string for safe inclusion in log messages by removing line-breaking characters.
   */
  private String sanitizeForLog(String value) {
    if (value == null) {
      return null;
    }
    return value.replace('\r', ' ').replace('\n', ' ');
  }

  /** For testing.  Returns the currently configured engine routing header name. */
  public String getEngineHeaderName() {
    return engineHeaderName;
  }
}

