/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
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
package org.finos.fluxnova.bpm.webapp.impl.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * A {@link Filter} implementation that can be used to realize basic templating.
 *
 * @author nico.rehwaldt
 */
public abstract class AbstractTemplateFilter implements Filter {

  private FilterConfig filterConfig;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    this.filterConfig = filterConfig;
  }

  @Override
  public void destroy() {
    filterConfig = null;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    applyFilter((HttpServletRequest) request, (HttpServletResponse) response, chain);
  }

  /**
   * Apply the filter to the given request/response.
   *
   * This method must be provided by subclasses to perform actual work.
   *
   * @param request
   * @param response
   * @param chain
   *
   * @throws IOException
   * @throws ServletException
   */
  protected abstract void applyFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;

  /**
   * Returns true if the given web resource exists.
   *
   * @param name
   * @return
   */
  protected boolean hasWebResource(String name) {
    String safeName;
    try {
      safeName = sanitizeResourcePath(name);
    }
    catch (IllegalArgumentException e) {
      return false;
    }

    try {
      URL resource = filterConfig.getServletContext().getResource(safeName);
      return resource != null;
    }
    catch (MalformedURLException e) {
      return false;
    }
  }

  /**
   * Returns the string contents of a web resource with the given name.
   *
   * The resource must be static and text based.
   *
   * @param name the name of the resource
   *
   * @return the resource contents
   *
   * @throws IOException
   */
  protected String getWebResourceContents(String name) throws IOException {
    String safeName;
    try {
      safeName = sanitizeResourcePath(name);
    }
    catch (IllegalArgumentException e) {
      throw new IOException(e.getMessage());
    }

    InputStream is = null;

    try {
      is = filterConfig.getServletContext().getResourceAsStream(safeName);

      BufferedReader reader = new BufferedReader(new InputStreamReader(is));

      StringWriter writer = new StringWriter();
      String line = null;

      while ((line = reader.readLine()) != null) {
        writer.write(line);
        writer.append("\n");
      }

      return writer.toString();
    } finally {
      if (is != null) {
        try { is.close(); } catch (IOException e) { }
      }
    }
  }

  private static String sanitizeResourcePath(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Resource name must not be null");
    }

    String decoded;
    try {
      decoded = URLDecoder.decode(name, StandardCharsets.UTF_8);
    }
    catch (IllegalArgumentException e) {
      throw new IllegalArgumentException(
          "Resource name contains malformed encoding: " + name);
    }

    String normalized = decoded.replace('\\', '/');
    for (String segment : normalized.split("/", -1)) {
      if ("..".equals(segment)) {
        throw new IllegalArgumentException(
            "Resource name contains illegal path traversal sequence: " + name);
      }
    }

    return normalized;
  }
}
