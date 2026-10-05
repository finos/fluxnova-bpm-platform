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
package org.finos.fluxnova.bpm.spring.boot.starter.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for JWT-based REST API authentication.
 *
 * <p>All properties are bound under the {@code fluxnova.bpm.jwt} prefix, which means
 * they can be supplied as environment variables using Spring Boot's relaxed binding:
 *
 * <pre>
 * FLUXNOVA_BPM_AUTH_ENABLED=true
 * FLUXNOVA_BPM_AUTH_TYPE=jwt
 * FLUXNOVA_BPM_JWT_JWKS_URL=https://login.microsoftonline.com/{tenant}/discovery/v2.0/keys
 * FLUXNOVA_BPM_JWT_ISSUER=https://login.microsoftonline.com/{tenant}/v2.0
 * FLUXNOVA_BPM_JWT_AUDIENCE=api://your-client-id
 * FLUXNOVA_BPM_JWT_USER_CLAIM_NAME=preferred_username
 * FLUXNOVA_BPM_JWT_GROUPS_CLAIM_NAME=groups
 * </pre>
 *
 * <p>Or as application.yml / application.properties:
 *
 * <pre>
 * fluxnova:
 *   bpm:
 *     auth:
 *       enabled: true
 *       type: jwt
 *     jwt:
 *       jwks-url: https://login.microsoftonline.com/{tenant}/discovery/v2.0/keys
 *       issuer: https://login.microsoftonline.com/{tenant}/v2.0
 *       audience: api://your-client-id
 *       user-claim-name: preferred_username
 *       groups-claim-name: groups
 * </pre>
 */
@ConfigurationProperties(prefix = JwtAuthenticationProperties.PREFIX)
public class JwtAuthenticationProperties {

  public static final String PREFIX = "fluxnova.bpm.jwt";

  /** JWKS endpoint URL used to fetch public keys for signature verification. Required when enabled. */
  private String jwksUrl;

  /** Expected {@code iss} (issuer) claim value. Required when enabled. */
  private String issuer;

  /** Expected {@code aud} (audience) claim value. Required when enabled. */
  private String audience;

  /** HTTP header name that carries the JWT token. Defaults to {@code Authorization}. */
  private String headerName = "Authorization";

  /** Token prefix in the header value (e.g. {@code "Bearer"}). Use an empty string for no prefix. A trailing space is added automatically. Defaults to {@code "Bearer"}. */
  private String headerPrefix = "Bearer";

  /** JWT claim whose value is used as the authenticated user identity. Defaults to {@code sub}. */
  private String userClaimName = "sub";

  /** JWT claim whose value is used to extract group memberships. Optional — leave blank to disable. */
  private String groupsClaimName;

  public String getJwksUrl() {
    return jwksUrl;
  }

  public void setJwksUrl(String jwksUrl) {
    this.jwksUrl = jwksUrl;
  }

  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public String getAudience() {
    return audience;
  }

  public void setAudience(String audience) {
    this.audience = audience;
  }

  public String getHeaderName() {
    return headerName;
  }

  public void setHeaderName(String headerName) {
    this.headerName = headerName;
  }

  public String getHeaderPrefix() {
    return headerPrefix;
  }

  public void setHeaderPrefix(String headerPrefix) {
    this.headerPrefix = headerPrefix;
  }

  public String getUserClaimName() {
    return userClaimName;
  }

  public void setUserClaimName(String userClaimName) {
    this.userClaimName = userClaimName;
  }

  public String getGroupsClaimName() {
    return groupsClaimName;
  }

  public void setGroupsClaimName(String groupsClaimName) {
    this.groupsClaimName = groupsClaimName;
  }
}
