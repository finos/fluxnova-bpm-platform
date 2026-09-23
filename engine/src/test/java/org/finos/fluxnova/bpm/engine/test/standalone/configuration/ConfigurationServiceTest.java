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
package org.finos.fluxnova.bpm.engine.test.standalone.configuration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.ConfigurationService;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration;
import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.exception.NotValidException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Verifies that the configuration schema, MyBatis mapping and service wiring work
 * together against a real (in memory) database.
 */
class ConfigurationServiceTest {

  private static ProcessEngine processEngine;
  private static ConfigurationService configurationService;

  @BeforeAll
  static void setUp() {
    processEngine = ProcessEngineConfiguration
        .createStandaloneInMemProcessEngineConfiguration()
        .setProcessEngineName("configuration-test-engine")
        .setJdbcUrl("jdbc:h2:mem:configuration-test;DB_CLOSE_DELAY=1000")
        .buildProcessEngine();

    configurationService = processEngine.getConfigurationService();
  }

  @AfterAll
  static void tearDown() {
    if (processEngine != null) {
      processEngine.close();
    }
  }

  @Test
  void shouldCreateAndRetrieveGlobalConfiguration() {
    Configuration configuration = configurationService.createConfiguration("global.key", "global-value", null);

    assertThat(configuration.getId()).isNotNull();
    assertThat(configuration.getTenantId()).isNull();
    assertThat(configuration.getVersion()).isEqualTo(1);
    assertThat(configuration.getStatus()).isEqualTo(Configuration.STATUS_ACTIVE);
    assertThat(configuration.getCreatedAt()).isNotNull();

    Configuration persisted = configurationService.getConfiguration(configuration.getId());
    assertThat(persisted).isNotNull();
    assertThat(persisted.getConfigKey()).isEqualTo("global.key");
    assertThat(persisted.getConfigValue()).isEqualTo("global-value");
    assertThat(persisted.getTenantId()).isNull();
  }

  @Test
  void shouldAllowSameKeyForDifferentTenants() {
    configurationService.createConfiguration("shared.key", "value-a", "tenant-a");
    configurationService.createConfiguration("shared.key", "value-b", "tenant-b");
    Configuration global = configurationService.createConfiguration("shared.key", "value-global", null);

    assertThat(configurationService.getConfiguration(global.getId()).getConfigValue()).isEqualTo("value-global");
  }

  @Test
  void shouldRejectDuplicateKeyForSameScope() {
    configurationService.createConfiguration("duplicate.key", "value", "tenant-dup");

    assertThatThrownBy(() -> configurationService.createConfiguration("duplicate.key", "other", "tenant-dup"))
        .isInstanceOf(BadUserRequestException.class);
  }

  @Test
  void shouldRejectDuplicateGlobalKey() {
    configurationService.createConfiguration("duplicate.global.key", "value", null);

    assertThatThrownBy(() -> configurationService.createConfiguration("duplicate.global.key", "other", null))
        .isInstanceOf(BadUserRequestException.class);
  }

  @Test
  void shouldEnforceDuplicateGlobalKeyAtDatabaseLevel() throws SQLException {
    insertConfiguration("db-global-1", "duplicate.db.global.key", null);

    assertThatThrownBy(() -> insertConfiguration("db-global-2", "duplicate.db.global.key", null))
        .isInstanceOf(SQLException.class);
  }

  @Test
  void shouldAllowDeletedConfigurationsWithSameScopeAtDatabaseLevel() throws SQLException {
    insertConfiguration("db-deleted-1", "deleted.db.global.key", null, Configuration.STATUS_DELETED);
    insertConfiguration("db-deleted-2", "deleted.db.global.key", null, Configuration.STATUS_DELETED);
    insertConfiguration("db-active-1", "deleted.db.global.key", null, Configuration.STATUS_ACTIVE);

    assertThatThrownBy(() -> insertConfiguration("db-active-2", "deleted.db.global.key", null, Configuration.STATUS_ACTIVE))
        .isInstanceOf(SQLException.class);
  }

  @Test
  void shouldRejectMissingConfigKey() {
    assertThatThrownBy(() -> configurationService.createConfiguration(null, "value", null))
        .isInstanceOf(NotValidException.class);
  }

  @Test
  void shouldReturnNullForUnknownId() {
    assertThat(configurationService.getConfiguration("unknown-id")).isNull();
  }

  protected void insertConfiguration(String id, String configKey, String tenantId) throws SQLException {
    insertConfiguration(id, configKey, tenantId, Configuration.STATUS_ACTIVE);
  }

  protected void insertConfiguration(String id, String configKey, String tenantId, String status) throws SQLException {
    try (Connection connection = processEngine.getProcessEngineConfiguration().getDataSource().getConnection();
        PreparedStatement statement = connection.prepareStatement(
            "insert into ACT_GE_CONFIGURATION (ID_, CONFIG_KEY_, TENANT_ID_, CONFIG_VALUE_, VERSION_, STATUS_) "
                + "values (?, ?, ?, ?, ?, ?)")) {

      statement.setString(1, id);
      statement.setString(2, configKey);
      statement.setString(3, tenantId);
      statement.setString(4, "value");
      statement.setInt(5, 1);
      statement.setString(6, status);
      statement.executeUpdate();
    }
  }
}
