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
package org.finos.flowave.bpm.spring.boot.starter;

import static org.finos.flowave.bpm.spring.boot.starter.jdbc.HistoryLevelDeterminatorJdbcTemplateImpl.createHistoryLevelDeterminator;

import java.util.List;

import org.finos.flowave.bpm.engine.impl.cfg.CompositeProcessEnginePlugin;
import org.finos.flowave.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.flowave.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.finos.flowave.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.FlowaveAuthorizationConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.FlowaveDatasourceConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.FlowaveDeploymentConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.FlowaveFailedJobConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.FlowaveHistoryConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.FlowaveHistoryLevelAutoHandlingConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.FlowaveJobConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.FlowaveMetricsConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.FlowaveProcessEngineConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.condition.NeedsHistoryAutoConfigurationCondition;
import org.finos.flowave.bpm.spring.boot.starter.configuration.id.IdGeneratorConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.custom.CreateAdminUserConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.custom.CreateFilterConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.DefaultAuthorizationConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.DefaultDatasourceConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.DefaultDeploymentConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.DefaultFailedJobConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.DefaultHistoryConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.DefaultHistoryLevelAutoHandlingConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.DefaultJobConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.DefaultJobConfiguration.JobConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.DefaultMetricsConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.DefaultProcessEngineConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.configuration.impl.GenericPropertiesConfiguration;
import org.finos.flowave.bpm.spring.boot.starter.event.EventPublisherPlugin;
import org.finos.flowave.bpm.spring.boot.starter.jdbc.HistoryLevelDeterminator;
import org.finos.flowave.bpm.spring.boot.starter.property.FlowaveBpmProperties;
import org.finos.flowave.bpm.spring.boot.starter.telemetry.FlowaveIntegrationDeterminator;
import org.finos.flowave.bpm.spring.boot.starter.util.FlowaveSpringBootUtil;
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
public class FlowaveBpmConfiguration {

  @Bean
  @ConditionalOnMissingBean(ProcessEngineConfigurationImpl.class)
  public ProcessEngineConfigurationImpl processEngineConfigurationImpl(List<ProcessEnginePlugin> processEnginePlugins) {
    final SpringProcessEngineConfiguration configuration = FlowaveSpringBootUtil.springProcessEngineConfiguration();
    configuration.getProcessEnginePlugins().add(new CompositeProcessEnginePlugin(processEnginePlugins));
    return configuration;
  }

  @Bean
  @ConditionalOnMissingBean(DefaultProcessEngineConfiguration.class)
  public static FlowaveProcessEngineConfiguration flowaveProcessEngineConfiguration() {
    return new DefaultProcessEngineConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FlowaveDatasourceConfiguration.class)
  public static FlowaveDatasourceConfiguration flowaveDatasourceConfiguration() {
    return new DefaultDatasourceConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FlowaveJobConfiguration.class)
  @ConditionalOnProperty(prefix = "flowave.bpm.job-execution", name = "enabled", havingValue = "true", matchIfMissing = true)
  public static FlowaveJobConfiguration flowaveJobConfiguration() {
    return new DefaultJobConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FlowaveHistoryConfiguration.class)
  public static FlowaveHistoryConfiguration flowaveHistoryConfiguration() {
    return new DefaultHistoryConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FlowaveMetricsConfiguration.class)
  public static FlowaveMetricsConfiguration flowaveMetricsConfiguration() {
    return new DefaultMetricsConfiguration();
  }

  //TODO to be removed within CAM-8108
  @Bean(name = "historyLevelAutoConfiguration")
  @ConditionalOnMissingBean(FlowaveHistoryLevelAutoHandlingConfiguration.class)
  @ConditionalOnProperty(prefix = "flowave.bpm", name = "history-level", havingValue = "auto", matchIfMissing = false)
  @Conditional(NeedsHistoryAutoConfigurationCondition.class)
  public static FlowaveHistoryLevelAutoHandlingConfiguration historyLevelAutoHandlingConfiguration() {
    return new DefaultHistoryLevelAutoHandlingConfiguration();
  }

  //TODO to be removed within CAM-8108
  @Bean(name = "historyLevelDeterminator")
  @ConditionalOnMissingBean(name = { "camundaBpmJdbcTemplate", "historyLevelDeterminator" })
  @ConditionalOnBean(name = "historyLevelAutoConfiguration")
  public static HistoryLevelDeterminator historyLevelDeterminator(FlowaveBpmProperties camundaBpmProperties, JdbcTemplate jdbcTemplate) {
    return createHistoryLevelDeterminator(camundaBpmProperties, jdbcTemplate);
  }

  //TODO to be removed within CAM-8108
  @Bean(name = "historyLevelDeterminator")
  @ConditionalOnBean(name = { "camundaBpmJdbcTemplate", "historyLevelAutoConfiguration", "historyLevelDeterminator" })
  @ConditionalOnMissingBean(name = "historyLevelDeterminator")
  public static HistoryLevelDeterminator historyLevelDeterminatorMultiDatabase(FlowaveBpmProperties camundaBpmProperties,
      @Qualifier("camundaBpmJdbcTemplate") JdbcTemplate jdbcTemplate) {
    return createHistoryLevelDeterminator(camundaBpmProperties, jdbcTemplate);
  }

  @Bean
  @ConditionalOnMissingBean(FlowaveAuthorizationConfiguration.class)
  public static FlowaveAuthorizationConfiguration flowaveAuthorizationConfiguration() {
    return new DefaultAuthorizationConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FlowaveDeploymentConfiguration.class)
  public static FlowaveDeploymentConfiguration flowaveDeploymentConfiguration() {
    return new DefaultDeploymentConfiguration();
  }

  @Bean
  public GenericPropertiesConfiguration genericPropertiesConfiguration() {
    return new GenericPropertiesConfiguration();
  }

  @Bean
  @ConditionalOnProperty(prefix = "flowave.bpm.admin-user", name = "id")
  public CreateAdminUserConfiguration createAdminUserConfiguration() {
    return new CreateAdminUserConfiguration();
  }

  @Bean
  @ConditionalOnMissingBean(FlowaveFailedJobConfiguration.class)
  public static FlowaveFailedJobConfiguration failedJobConfiguration() {
    return new DefaultFailedJobConfiguration();
  }

  @Bean
  @ConditionalOnProperty(prefix = "flowave.bpm.filter", name = "create")
  public CreateFilterConfiguration createFilterConfiguration() {
    return new CreateFilterConfiguration();
  }

  @Bean
  public EventPublisherPlugin eventPublisherPlugin(FlowaveBpmProperties properties, ApplicationEventPublisher publisher) {
    return new EventPublisherPlugin(properties.getEventing(), publisher);
  }

  @Bean
  public FlowaveIntegrationDeterminator flowaveIntegrationDeterminator() {
    return new FlowaveIntegrationDeterminator();
  }
}
