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
import org.finos.fluxnova.bpm.engine.rest.security.auth.impl.JwtAuthenticationPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Spring Boot auto-configuration for REST API authentication.
 *
 * <p>Basic authentication can be enabled with:
 *
 * <pre>
 * FLUXNOVA_BPM_AUTH_ENABLED=true
 * FLUXNOVA_BPM_AUTH_TYPE=basic
 * </pre>
 *
 * <p>JWT authentication can be enabled with:
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
 */
@Configuration
@EnableConfigurationProperties({ RestAuthenticationProperties.class, JwtAuthenticationProperties.class })
@AutoConfigureAfter(FluxnovaBpmRestJerseyAutoConfiguration.class)
public class JwtAuthenticationAutoConfiguration {

  private static final Logger LOG = LoggerFactory.getLogger(JwtAuthenticationAutoConfiguration.class);

  /**
   * Creates and initialises the {@link JwtAuthenticationPlugin} from the bound properties.
   * The plugin validates the required fields and sets up the underlying
   * {@link org.finos.fluxnova.bpm.engine.rest.security.auth.impl.JwtAuthenticationProvider}.
   */
  @Bean
  @Conditional(JwtAuthenticationEnabledCondition.class)
  public JwtAuthenticationPlugin jwtAuthenticationPlugin(JwtAuthenticationProperties props) {
    LOG.info("REST API authentication enabled with type 'jwt'.");
    return RestAuthenticationConfigurationSupport.createJwtAuthenticationPlugin(props);
  }

  /**
   * Registers the {@link ProcessEngineAuthenticationFilter} with the JWT provider
   * on the {@code /engine-rest/*} URL pattern.
   *
   * <p>The filter is ordered at {@code 1} so it runs before any other application filters.
   * If you need to change the order or URL pattern, define your own
   * {@code FilterRegistrationBean<ProcessEngineAuthenticationFilter>} bean — Spring Boot
   * will use yours instead via {@code @ConditionalOnMissingBean}.
   *
   * <p>Suppressed when {@code distro/run} is present and has already registered its own
   * {@code processEngineAuthenticationFilter} bean (e.g. via
   * {@code fluxnova.bpm.run.auth.enabled=true, authentication=jwt}).
   */
  @Bean
  @ConditionalOnMissingBean(name = "processEngineAuthenticationFilter")
  @Conditional(JwtAuthenticationEnabledCondition.class)
  public FilterRegistrationBean<ProcessEngineAuthenticationFilter> jwtAuthenticationFilter(
      JwtAuthenticationPlugin jwtAuthenticationPlugin) {
    ProcessEngineAuthenticationFilter filter =
        RestAuthenticationConfigurationSupport.createJwtAuthenticationFilter(jwtAuthenticationPlugin);

    FilterRegistrationBean<ProcessEngineAuthenticationFilter> registration =
        new FilterRegistrationBean<>(filter);
    registration.addUrlPatterns("/engine-rest/*");
    registration.setOrder(1);
    return registration;
  }

  @Bean
  @ConditionalOnMissingBean(name = "processEngineAuthenticationFilter")
  @Conditional(BasicAuthenticationEnabledCondition.class)
  public FilterRegistrationBean<ProcessEngineAuthenticationFilter> basicAuthenticationFilter() {
    LOG.info("REST API authentication enabled with type 'basic'.");
    ProcessEngineAuthenticationFilter filter =
        RestAuthenticationConfigurationSupport.createBasicAuthenticationFilter();

    FilterRegistrationBean<ProcessEngineAuthenticationFilter> registration =
        new FilterRegistrationBean<>(filter);
    registration.addUrlPatterns("/engine-rest/*");
    registration.setOrder(1);
    RestAuthenticationConfigurationSupport.applyBasicAuthenticationProvider(registration);
    return registration;
  }
}

class JwtAuthenticationEnabledCondition implements Condition {

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    return RestAuthenticationConditionSupport.isStarterAuthEnabled(context)
        && RestAuthenticationProperties.JWT_AUTH.equals(RestAuthenticationConditionSupport.getStarterAuthType(context));
  }
}

class BasicAuthenticationEnabledCondition implements Condition {

  @Override
  public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
    return RestAuthenticationConditionSupport.isStarterAuthEnabled(context)
        && RestAuthenticationProperties.BASIC_AUTH.equals(RestAuthenticationConditionSupport.getStarterAuthType(context));
  }
}

final class RestAuthenticationConditionSupport {

  private RestAuthenticationConditionSupport() {
  }

  static boolean isStarterAuthEnabled(ConditionContext context) {
    return context.getEnvironment().getProperty(RestAuthenticationProperties.PREFIX + ".enabled", Boolean.class, false);
  }

  static String getStarterAuthType(ConditionContext context) {
    return context.getEnvironment().getProperty(
        RestAuthenticationProperties.PREFIX + ".type",
        RestAuthenticationProperties.BASIC_AUTH);
  }
}
