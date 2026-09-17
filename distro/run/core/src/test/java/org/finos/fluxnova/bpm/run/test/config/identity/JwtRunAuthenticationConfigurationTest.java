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
package org.finos.fluxnova.bpm.run.test.config.identity;

import org.finos.fluxnova.bpm.engine.rest.security.auth.impl.JwtAuthenticationProvider;
import org.finos.fluxnova.bpm.run.FluxnovaBpmRun;
import org.finos.fluxnova.bpm.run.test.AbstractRestTest;
import org.finos.fluxnova.bpm.spring.boot.starter.rest.JwtAuthenticationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Verifies that when {@code fluxnova.bpm.run.auth.authentication=jwt} is configured,
 * the distro/run REST filter is wired with a {@link JwtAuthenticationProvider} and the
 * standalone {@code jwtAuthenticationFilter} auto-configuration bean is suppressed.
 */
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@SpringBootTest(classes = { FluxnovaBpmRun.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = { "test-jwt-auth-enabled" })
class JwtRunAuthenticationConfigurationTest extends AbstractRestTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private JwtAuthenticationProperties jwtAuthenticationProperties;

  // -------------------------------------------------------------------------
  // Bean wiring
  // -------------------------------------------------------------------------

  @Test
  void jwtPropertiesAreLoaded() {
    assertThat(jwtAuthenticationProperties.getJwksUrl())
        .isEqualTo("https://idp.example.com/.well-known/jwks.json");
    assertThat(jwtAuthenticationProperties.getIssuer())
        .isEqualTo("https://idp.example.com");
    assertThat(jwtAuthenticationProperties.getAudience())
        .isEqualTo("test-api");
    assertThat(jwtAuthenticationProperties.getUserClaimName())
        .isEqualTo("preferred_username");
    assertThat(jwtAuthenticationProperties.getGroupsClaimName())
        .isEqualTo("groups");
  }

  @Test
  void runOwnsTheAuthFilterNotStarterRest() {
    // distro/run registers its filter as "processEngineAuthenticationFilter"
    assertThat(applicationContext.containsBean("processEngineAuthenticationFilter")).isTrue();
    // the starter-rest auto-configuration filter must be suppressed by @ConditionalOnMissingBean
    assertThat(applicationContext.containsBean("jwtAuthenticationFilter")).isFalse();
  }

  // -------------------------------------------------------------------------
  // HTTP behaviour — unauthenticated requests must be rejected
  // -------------------------------------------------------------------------

  @Test
  void requestWithoutTokenIsRejected() {
    ResponseEntity<List> response = testRestTemplate.exchange(
        "/engine-rest/task", HttpMethod.GET, HttpEntity.EMPTY, List.class);

    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.UNAUTHORIZED);
  }

  @Test
  void unauthenticatedResponseIncludesBearerChallenge() {
    ResponseEntity<List> response = testRestTemplate.exchange(
        "/engine-rest/task", HttpMethod.GET, HttpEntity.EMPTY, List.class);

    assertThat(response.getHeaders().getFirst("WWW-Authenticate"))
        .startsWith("Bearer");
  }
}
