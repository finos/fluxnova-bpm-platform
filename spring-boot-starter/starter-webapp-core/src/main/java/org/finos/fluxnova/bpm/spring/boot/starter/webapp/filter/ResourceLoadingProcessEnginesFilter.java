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
package org.finos.fluxnova.bpm.spring.boot.starter.webapp.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.finos.fluxnova.bpm.spring.boot.starter.property.WebappProperty;

import org.finos.fluxnova.bpm.webapp.impl.engine.ProcessEnginesFilter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringUtils;

public class ResourceLoadingProcessEnginesFilter extends ProcessEnginesFilter implements ResourceLoaderDependingFilter {

  protected static final String DEFAULT_REDIRECT_APP = "tasklist";

  protected ResourceLoader resourceLoader;
  protected WebappProperty webappProperty;

  @Override
  protected void applyFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
    String contextPath = request.getContextPath();
    String requestUri = request.getRequestURI().substring(contextPath.length());
    String applicationPath = webappProperty.getApplicationPath();

    requestUri = trimChar(requestUri, '/');
    String appPath = trimChar(applicationPath, '/');
    if (requestUri.equals(appPath)) {
      // only redirect from index ("/") if index redirect is enabled
      if(!requestUri.isEmpty() || webappProperty.isIndexRedirectEnabled()) {
        response.sendRedirect("%s%s/app/%s/".formatted(contextPath, applicationPath, DEFAULT_REDIRECT_APP));
        return;
      }
    }

    super.applyFilter(request, response, chain);
  }

  @Override
  protected String getWebResourceContents(String name) throws IOException {
    String safeName;
    try {
      safeName = validateResourceName(name);
    }
    catch (IllegalArgumentException e) {
      throw new IOException(e.getMessage());
    }

    InputStream is = null;
    try {
      Resource resource = resourceLoader.getResource(
          "classpath:" + joinClasspathResource(webappProperty.getWebjarClasspath(), safeName));
      is = resource.getInputStream();

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
        try {
          is.close();
        } catch (IOException e) {
        }
      }
    }
  }

  /**
   * @return the resourceLoader
   */
  public ResourceLoader getResourceLoader() {
    return resourceLoader;
  }

  /**
   * @param resourceLoader
   *          the resourceLoader to set
   */
  public void setResourceLoader(ResourceLoader resourceLoader) {
    this.resourceLoader = resourceLoader;
  }

  /**
   * @return the webappProperty
   */
  public WebappProperty getWebappProperty() {
        return webappProperty;
    }

  /**
   * @param webappProperty
   *          webappProperty to set
   */
  public void setWebappProperty(WebappProperty webappProperty) {
    this.webappProperty = webappProperty;
  }

  /**
   * @param input - String to trim
   * @param charachter - Char to trim
   * @return the trimmed String
   */
  protected String trimChar(String input, char charachter) {
    input = StringUtils.trimLeadingCharacter(input, charachter);
    input = StringUtils.trimTrailingCharacter(input, charachter);

    return input;
  }

  private static final Path RESOURCE_ROOT = Paths.get("/webjar-resource-root").normalize().toAbsolutePath();

  private static String joinClasspathResource(String classpathRoot, String relativeResourceName) {
    if (classpathRoot.endsWith("/")) {
      return classpathRoot + relativeResourceName;
    }

    return classpathRoot + "/" + relativeResourceName;
  }

  private static String validateResourceName(String name) {
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

    if (decoded.indexOf('\0') >= 0) {
      throw new IllegalArgumentException(
          "Resource name contains illegal null byte: " + name);
    }

    String normalized = decoded.replace('\\', '/');
    String relative = normalized.startsWith("/") ? normalized.substring(1) : normalized;

    for (String segment : relative.split("/")) {
      if ("..".equals(segment)) {
        throw new IllegalArgumentException(
            "Resource name contains illegal path traversal sequence: " + name);
      }
    }

    Path resolved = RESOURCE_ROOT.resolve(relative).normalize().toAbsolutePath();
    if (!resolved.startsWith(RESOURCE_ROOT)) {
      throw new IllegalArgumentException(
          "Resource name contains illegal path traversal sequence: " + name);
    }

    String safeRelative = RESOURCE_ROOT.relativize(resolved).toString().replace('\\', '/');
    return safeRelative;
  }
}
