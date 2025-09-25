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
package org.finos.fluxnova.bpm.run;

import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.finos.fluxnova.bpm.engine.impl.plugin.AdministratorAuthorizationPlugin;
import org.finos.fluxnova.bpm.identity.impl.ldap.plugin.LdapIdentityProviderPlugin;
import org.finos.fluxnova.bpm.run.property.FluxnovaBpmRunAdministratorAuthorizationProperties;
import org.finos.fluxnova.bpm.run.property.FluxnovaBpmRunLdapProperties;
import org.finos.fluxnova.bpm.run.property.FluxnovaBpmRunProperties;
import org.finos.fluxnova.bpm.spring.boot.starter.FluxnovaBpmAutoConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@EnableConfigurationProperties(FluxnovaBpmRunProperties.class)
@Configuration
@AutoConfigureAfter({ FluxnovaBpmAutoConfiguration.class })
public class FluxnovaBpmRunConfiguration {

  @Bean
  @ConditionalOnProperty(name = "enabled", havingValue = "true", prefix = FluxnovaBpmRunLdapProperties.PREFIX)
  public LdapIdentityProviderPlugin ldapIdentityProviderPlugin(FluxnovaBpmRunProperties properties) {
    return properties.getLdap();
  }

  @Bean
  @ConditionalOnProperty(name = "enabled", havingValue = "true", prefix = FluxnovaBpmRunAdministratorAuthorizationProperties.PREFIX)
  public AdministratorAuthorizationPlugin administratorAuthorizationPlugin(FluxnovaBpmRunProperties properties) {
    return properties.getAdminAuth();
  }

  @Bean
  public ProcessEngineConfigurationImpl processEngineConfigurationImpl(List<ProcessEnginePlugin> processEnginePluginsFromContext,
                                                                       FluxnovaBpmRunProperties properties,
                                                                       FluxnovaBpmRunDeploymentConfiguration deploymentConfig) {
    String normalizedDeploymentDir = deploymentConfig.getNormalizedDeploymentDir();
    boolean deployChangedOnly = properties.getDeployment().isDeployChangedOnly();
    var processEnginePluginsFromYaml = properties.getProcessEnginePlugins();

    return new FluxnovaBpmRunProcessEngineConfiguration(normalizedDeploymentDir, deployChangedOnly,
        processEnginePluginsFromContext, processEnginePluginsFromYaml);
  }

  @Bean
  public FluxnovaBpmRunDeploymentConfiguration fluxnovaDeploymentConfiguration(@Value("${camunda.deploymentDir:#{null}}") String deploymentDir) {
    return new FluxnovaBpmRunDeploymentConfiguration(deploymentDir);
  }

}
