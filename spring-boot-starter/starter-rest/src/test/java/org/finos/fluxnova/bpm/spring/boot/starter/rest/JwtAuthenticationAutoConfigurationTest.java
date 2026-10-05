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

import org.finos.fluxnova.bpm.engine.rest.security.auth.ProcessEngineAuthenticationFilter;
import org.finos.fluxnova.bpm.engine.rest.security.auth.impl.HttpBasicAuthenticationProvider;
import org.finos.fluxnova.bpm.engine.rest.security.auth.impl.JwtAuthenticationPlugin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Tests for {@link JwtAuthenticationAutoConfiguration} using {@link ApplicationContextRunner}
 * so the full Spring Boot context is never started — only the authentication beans are tested
 * in isolation.
 */
class JwtAuthenticationAutoConfigurationTest {

  private static final String JWKS_URL  = "https://idp.example.com/.well-known/jwks.json";
  private static final String ISSUER    = "https://idp.example.com";
  private static final String AUDIENCE  = "test-api";

  private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
      .withConfiguration(AutoConfigurations.of(JwtAuthenticationAutoConfiguration.class));

  // -------------------------------------------------------------------------
  // Disabled by default
  // -------------------------------------------------------------------------

  @Test
  void noBeansCreatedWhenNotEnabled() {
    contextRunner.run(ctx -> {
      assertThat(ctx).doesNotHaveBean(JwtAuthenticationPlugin.class);
      assertThat(ctx).doesNotHaveBean("basicAuthenticationFilter");
      assertThat(ctx).doesNotHaveBean("jwtAuthenticationFilter");
    });
  }

  @Test
  void noBeansCreatedWhenExplicitlyDisabled() {
    contextRunner
        .withPropertyValues("fluxnova.bpm.auth.enabled=false")
        .run(ctx -> {
          assertThat(ctx).doesNotHaveBean(JwtAuthenticationPlugin.class);
          assertThat(ctx).doesNotHaveBean("basicAuthenticationFilter");
          assertThat(ctx).doesNotHaveBean("jwtAuthenticationFilter");
        });
  }

  @Test
  void basicAuthenticationFilterCreatedWhenEnabledWithDefaultType() {
    contextRunner
        .withPropertyValues("fluxnova.bpm.auth.enabled=true")
        .run(ctx -> {
          assertThat(ctx).doesNotHaveBean(JwtAuthenticationPlugin.class);
          assertThat(ctx).hasBean("basicAuthenticationFilter");
          FilterRegistrationBean<?> registration = ctx.getBean("basicAuthenticationFilter", FilterRegistrationBean.class);
          assertThat(registration.getInitParameters()).containsEntry(
              ProcessEngineAuthenticationFilter.AUTHENTICATION_PROVIDER_PARAM,
              HttpBasicAuthenticationProvider.class.getName());
        });
  }

  @Test
  void basicAuthenticationFilterCreatedWhenExplicitlySelected() {
    contextRunner
        .withPropertyValues(
            "fluxnova.bpm.auth.enabled=true",
            "fluxnova.bpm.auth.type=basic")
        .run(ctx -> assertThat(ctx).hasBean("basicAuthenticationFilter"));
  }

  @Test
  void pluginBeanCreatedWhenJwtModeSelected() {
    contextRunner
        .withPropertyValues(
            "fluxnova.bpm.auth.enabled=true",
            "fluxnova.bpm.auth.type=jwt",
            "fluxnova.bpm.jwt.jwks-url=" + JWKS_URL,
            "fluxnova.bpm.jwt.issuer=" + ISSUER,
            "fluxnova.bpm.jwt.audience=" + AUDIENCE)
        .run(ctx -> assertThat(ctx).hasSingleBean(JwtAuthenticationPlugin.class));
  }

  @Test
  void filterBeanCreatedWhenJwtModeSelected() {
    contextRunner
        .withPropertyValues(
            "fluxnova.bpm.auth.enabled=true",
            "fluxnova.bpm.auth.type=jwt",
            "fluxnova.bpm.jwt.jwks-url=" + JWKS_URL,
            "fluxnova.bpm.jwt.issuer=" + ISSUER,
            "fluxnova.bpm.jwt.audience=" + AUDIENCE)
        .run(ctx -> assertThat(ctx).hasBean("jwtAuthenticationFilter"));
  }

  @Test
  void pluginPicksUpCustomUserClaim() {
    contextRunner
        .withPropertyValues(
            "fluxnova.bpm.auth.enabled=true",
            "fluxnova.bpm.auth.type=jwt",
            "fluxnova.bpm.jwt.jwks-url=" + JWKS_URL,
            "fluxnova.bpm.jwt.issuer=" + ISSUER,
            "fluxnova.bpm.jwt.audience=" + AUDIENCE,
            "fluxnova.bpm.jwt.user-claim-name=preferred_username")
        .run(ctx -> {
          JwtAuthenticationPlugin plugin = ctx.getBean(JwtAuthenticationPlugin.class);
          assertThat(plugin.getUserClaimName()).isEqualTo("preferred_username");
        });
  }

  @Test
  void pluginPicksUpGroupsClaim() {
    contextRunner
        .withPropertyValues(
            "fluxnova.bpm.auth.enabled=true",
            "fluxnova.bpm.auth.type=jwt",
            "fluxnova.bpm.jwt.jwks-url=" + JWKS_URL,
            "fluxnova.bpm.jwt.issuer=" + ISSUER,
            "fluxnova.bpm.jwt.audience=" + AUDIENCE,
            "fluxnova.bpm.jwt.groups-claim-name=groups")
        .run(ctx -> {
          JwtAuthenticationPlugin plugin = ctx.getBean(JwtAuthenticationPlugin.class);
          assertThat(plugin.getGroupsClaimName()).isEqualTo("groups");
        });
  }

  @Test
  void failsWhenJwksUrlMissingInJwtMode() {
    contextRunner
        .withPropertyValues(
            "fluxnova.bpm.auth.enabled=true",
            "fluxnova.bpm.auth.type=jwt",
            "fluxnova.bpm.jwt.issuer=" + ISSUER,
            "fluxnova.bpm.jwt.audience=" + AUDIENCE)
        .run(ctx -> assertThat(ctx).hasFailed().getFailure().hasMessageContaining("jwksUrl"));
  }

  @Test
  void failsWhenIssuerMissingInJwtMode() {
    contextRunner
        .withPropertyValues(
            "fluxnova.bpm.auth.enabled=true",
            "fluxnova.bpm.auth.type=jwt",
            "fluxnova.bpm.jwt.jwks-url=" + JWKS_URL,
            "fluxnova.bpm.jwt.audience=" + AUDIENCE)
        .run(ctx -> assertThat(ctx).hasFailed().getFailure().hasMessageContaining("issuer"));
  }

  @Test
  void failsWhenAudienceMissingInJwtMode() {
    contextRunner
        .withPropertyValues(
            "fluxnova.bpm.auth.enabled=true",
            "fluxnova.bpm.auth.type=jwt",
            "fluxnova.bpm.jwt.jwks-url=" + JWKS_URL,
            "fluxnova.bpm.jwt.issuer=" + ISSUER)
        .run(ctx -> assertThat(ctx).hasFailed().getFailure().hasMessageContaining("audience"));
  }

  @Test
  void failsWhenAuthenticationTypeIsInvalid() {
    contextRunner
        .withPropertyValues(
            "fluxnova.bpm.auth.enabled=true",
            "fluxnova.bpm.auth.type=saml")
        .run(ctx -> assertThat(ctx).hasFailed().getFailure().hasMessageContaining("Could not bind properties"));
  }

  @Test
  void jwtFilterSuppressedWhenProcessEngineAuthFilterAlreadyPresent() {
    contextRunner
        .withPropertyValues(
            "fluxnova.bpm.auth.enabled=true",
            "fluxnova.bpm.auth.type=jwt",
            "fluxnova.bpm.jwt.jwks-url=" + JWKS_URL,
            "fluxnova.bpm.jwt.issuer=" + ISSUER,
            "fluxnova.bpm.jwt.audience=" + AUDIENCE)
        .withUserConfiguration(ExistingAuthFilterConfig.class)
        .run(ctx -> {
          assertThat(ctx).hasSingleBean(JwtAuthenticationPlugin.class);
          assertThat(ctx).doesNotHaveBean("jwtAuthenticationFilter");
        });
  }

  @Test
  void basicFilterSuppressedWhenProcessEngineAuthFilterAlreadyPresent() {
    contextRunner
        .withPropertyValues("fluxnova.bpm.auth.enabled=true")
        .withUserConfiguration(ExistingAuthFilterConfig.class)
        .run(ctx -> assertThat(ctx).doesNotHaveBean("basicAuthenticationFilter"));
  }

  /** Simulates the bean that distro/run registers when auth is enabled. */
  @Configuration
  static class ExistingAuthFilterConfig {
    @Bean
    FilterRegistrationBean<ProcessEngineAuthenticationFilter> processEngineAuthenticationFilter() {
      return new FilterRegistrationBean<>(new ProcessEngineAuthenticationFilter());
    }
  }
}
