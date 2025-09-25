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
package org.finos.fluxnova.bpm.spring.boot.starter;

import static org.finos.fluxnova.bpm.spring.boot.starter.jdbc.HistoryLevelDeterminatorJdbcTemplateImpl.createHistoryLevelDeterminator;

import java.util.List;

import org.finos.fluxnova.bpm.engine.impl.cfg.CompositeProcessEnginePlugin;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.finos.fluxnova.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.FluxnovaAuthorizationConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.FluxnovaDatasourceConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.FluxnovaDeploymentConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.FluxnovaFailedJobConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.FluxnovaHistoryConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.FluxnovaHistoryLevelAutoHandlingConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.FluxnovaJobConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.FluxnovaMetricsConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.FluxnovaProcessEngineConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.condition.NeedsHistoryAutoConfigurationCondition;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.id.IdGeneratorConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.custom.CreateAdminUserConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.custom.CreateFilterConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.DefaultAuthorizationConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.DefaultDatasourceConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.DefaultDeploymentConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.DefaultFailedJobConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.DefaultHistoryConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.DefaultHistoryLevelAutoHandlingConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.DefaultJobConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.DefaultJobConfiguration.JobConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.DefaultMetricsConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.DefaultProcessEngineConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.configuration.impl.GenericPropertiesConfiguration;
import org.finos.fluxnova.bpm.spring.boot.starter.event.EventPublisherPlugin;
import org.finos.fluxnova.bpm.spring.boot.starter.jdbc.HistoryLevelDeterminator;
import org.finos.fluxnova.bpm.spring.boot.starter.property.FluxnovaBpmProperties;
import org.finos.fluxnova.bpm.spring.boot.starter.telemetry.FluxnovaIntegrationDeterminator;
import org.finos.fluxnova.bpm.spring.boot.starter.util.FluxnovaSpringBootUtil;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

@Import({
    JobConfiguration.class,
    IdGeneratorConfiguration.class
})
public class FluxnovaBpmConfiguration {

  @Bean
  @ConditionalOnMissingBean(ProcessEngineConfigurationImpl.class)
  public ProcessEngineConfigurationImpl processEngineConfigurationImpl(List<ProcessEnginePlugin> processEnginePlugins) {
    final SpringProcessEngineConfiguration configuration = FluxnovaSpringBootUtil.springProcessEngineConfiguration();
    configuration.getProcessEnginePlugins().add(new CompositeProcessEnginePlugin(processEnginePlugins));
    return configuration;
  }

  @Bean
  @ConditionalOnMissingBean(DefaultProcessEngineConfiguration.class)
  public static FluxnovaProcessEngineConfiguration fluxnovaProcessEngineConfiguration() {
    return new DefaultProcessEngineConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FluxnovaDatasourceConfiguration.class)
  public static FluxnovaDatasourceConfiguration fluxnovaDatasourceConfiguration() {
    return new DefaultDatasourceConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FluxnovaJobConfiguration.class)
  @ConditionalOnProperty(prefix = "fluxnova.bpm.job-execution", name = "enabled", havingValue = "true", matchIfMissing =
      true)
  public static FluxnovaJobConfiguration fluxnovaJobConfiguration() {
    return new DefaultJobConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FluxnovaHistoryConfiguration.class)
  public static FluxnovaHistoryConfiguration fluxnovaHistoryConfiguration() {
    return new DefaultHistoryConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FluxnovaMetricsConfiguration.class)
  public static FluxnovaMetricsConfiguration fluxnovaMetricsConfiguration() {
    return new DefaultMetricsConfiguration();
  }

  //TODO to be removed within CAM-8108
  @Bean(name = "historyLevelAutoConfiguration")
  @ConditionalOnMissingBean(FluxnovaHistoryLevelAutoHandlingConfiguration.class)
  @ConditionalOnProperty(prefix = "fluxnova.bpm", name = "history-level", havingValue = "auto", matchIfMissing = false)
  @Conditional(NeedsHistoryAutoConfigurationCondition.class)
  public static FluxnovaHistoryLevelAutoHandlingConfiguration historyLevelAutoHandlingConfiguration() {
    return new DefaultHistoryLevelAutoHandlingConfiguration();
  }

  //TODO to be removed within CAM-8108
  @Bean(name = "historyLevelDeterminator")
  @ConditionalOnMissingBean(name = { "camundaBpmJdbcTemplate", "historyLevelDeterminator" })
  @ConditionalOnBean(name = "historyLevelAutoConfiguration")
  public static HistoryLevelDeterminator historyLevelDeterminator(FluxnovaBpmProperties camundaBpmProperties, JdbcTemplate jdbcTemplate) {
    return createHistoryLevelDeterminator(camundaBpmProperties, jdbcTemplate);
  }

  //TODO to be removed within CAM-8108
  @Bean(name = "historyLevelDeterminator")
  @ConditionalOnBean(name = { "camundaBpmJdbcTemplate", "historyLevelAutoConfiguration", "historyLevelDeterminator" })
  @ConditionalOnMissingBean(name = "historyLevelDeterminator")
  public static HistoryLevelDeterminator historyLevelDeterminatorMultiDatabase(FluxnovaBpmProperties camundaBpmProperties,
                                                                               @Qualifier("camundaBpmJdbcTemplate") JdbcTemplate jdbcTemplate) {
    return createHistoryLevelDeterminator(camundaBpmProperties, jdbcTemplate);
  }

  @Bean
  @ConditionalOnMissingBean(FluxnovaAuthorizationConfiguration.class)
  public static FluxnovaAuthorizationConfiguration fluxnovaAuthorizationConfiguration() {
    return new DefaultAuthorizationConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FluxnovaDeploymentConfiguration.class)
  public static FluxnovaDeploymentConfiguration fluxnovaDeploymentConfiguration() {
    return new DefaultDeploymentConfiguration();
  }

  @Bean
  public GenericPropertiesConfiguration genericPropertiesConfiguration() {
    return new GenericPropertiesConfiguration();
  }

  @Bean
  @ConditionalOnProperty(prefix = "fluxnova.bpm.admin-user", name = "id")
  public CreateAdminUserConfiguration createAdminUserConfiguration() {
    return new CreateAdminUserConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FluxnovaFailedJobConfiguration.class)
  public static FluxnovaFailedJobConfiguration failedJobConfiguration() {
    return new DefaultFailedJobConfiguration();
  }

  @Bean
  @ConditionalOnProperty(prefix = "fluxnova.bpm.filter", name = "create")
  public CreateFilterConfiguration createFilterConfiguration() {
    return new CreateFilterConfiguration();
  }

  @Bean
  public EventPublisherPlugin eventPublisherPlugin(FluxnovaBpmProperties properties, ApplicationEventPublisher publisher) {
    return new EventPublisherPlugin(properties.getEventing(), publisher);
  }

  @Bean
  public FluxnovaIntegrationDeterminator fluxnovaIntegrationDeterminator() {
    return new FluxnovaIntegrationDeterminator();
  }
}
