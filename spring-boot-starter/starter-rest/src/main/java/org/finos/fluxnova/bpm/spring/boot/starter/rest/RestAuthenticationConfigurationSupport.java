/*
 * Copyright Fluxnova and/or licensed to Fluxnova
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Fluxnova licenses this file to you under the Apache License,
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
package org.finos.fluxnova.bpm.spring.boot.starter.rest;

import org.finos.fluxnova.bpm.engine.rest.security.auth.ProcessEngineAuthenticationFilter;
import org.finos.fluxnova.bpm.engine.rest.security.auth.impl.HttpBasicAuthenticationProvider;
import org.finos.fluxnova.bpm.engine.rest.security.auth.impl.JwtAuthenticationPlugin;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

public final class RestAuthenticationConfigurationSupport {

  private RestAuthenticationConfigurationSupport() {
  }

  public static JwtAuthenticationPlugin createJwtAuthenticationPlugin(JwtAuthenticationProperties props) {
    JwtAuthenticationPlugin plugin = new JwtAuthenticationPlugin();
    plugin.setJwksUrl(props.getJwksUrl());
    plugin.setIssuer(props.getIssuer());
    plugin.setAudience(props.getAudience());
    plugin.setHeaderName(props.getHeaderName());
    plugin.setHeaderPrefix(props.getHeaderPrefix());
    plugin.setUserClaimName(props.getUserClaimName());
    if (props.getGroupsClaimName() != null && !props.getGroupsClaimName().isEmpty()) {
      plugin.setGroupsClaimName(props.getGroupsClaimName());
    }
    plugin.initializeProvider();
    return plugin;
  }

  public static ProcessEngineAuthenticationFilter createJwtAuthenticationFilter(JwtAuthenticationPlugin plugin) {
    ProcessEngineAuthenticationFilter filter = new ProcessEngineAuthenticationFilter();
    filter.setAuthenticationProvider(plugin.getAuthenticationProvider());
    return filter;
  }

  public static ProcessEngineAuthenticationFilter createBasicAuthenticationFilter() {
    return new ProcessEngineAuthenticationFilter();
  }

  public static void applyBasicAuthenticationProvider(FilterRegistrationBean<?> registration) {
    registration.addInitParameter(
        ProcessEngineAuthenticationFilter.AUTHENTICATION_PROVIDER_PARAM,
        HttpBasicAuthenticationProvider.class.getName());
  }
}
