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

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;

/**
 * Configuration properties for selecting the REST API authentication mode.
 *
 * <p>All properties are bound under the {@code fluxnova.bpm.auth} prefix, for example:
 *
 * <pre>
 * FLUXNOVA_BPM_AUTH_ENABLED=true
 * FLUXNOVA_BPM_AUTH_TYPE=basic
 * </pre>
 *
 * <p>or:
 *
 * <pre>
 * FLUXNOVA_BPM_AUTH_ENABLED=true
 * FLUXNOVA_BPM_AUTH_TYPE=jwt
 * FLUXNOVA_BPM_JWT_JWKS_URL=https://login.microsoftonline.com/{tenant}/discovery/v2.0/keys
 * FLUXNOVA_BPM_JWT_ISSUER=https://login.microsoftonline.com/{tenant}/v2.0
 * FLUXNOVA_BPM_JWT_AUDIENCE=api://your-client-id
 * </pre>
 */
@ConfigurationProperties(prefix = RestAuthenticationProperties.PREFIX)
public class RestAuthenticationProperties {

  public static final String PREFIX = "fluxnova.bpm.auth";
  public static final String BASIC_AUTH = "basic";
  public static final String JWT_AUTH = "jwt";
  public static final List<String> AUTH_TYPES = Arrays.asList(BASIC_AUTH, JWT_AUTH);

  private boolean enabled = false;
  private String type = BASIC_AUTH;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    if (type != null && !AUTH_TYPES.contains(type)) {
      throw new RuntimeException("Please provide a valid authentication type. The available ones are: " + AUTH_TYPES);
    }
    this.type = type;
  }
}
