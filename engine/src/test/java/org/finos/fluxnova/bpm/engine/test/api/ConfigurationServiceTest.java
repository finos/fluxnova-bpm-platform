package org.finos.fluxnova.bpm.engine.test.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.ConfigurationService;
import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.exception.NotFoundException;
import org.finos.fluxnova.bpm.engine.exception.NotValidException;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ConfigurationEntity;
import org.finos.fluxnova.bpm.engine.test.util.PluggableProcessEngineTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConfigurationServiceTest extends PluggableProcessEngineTest {

  protected ConfigurationService configurationService;
  protected List<String> configurationIds = new ArrayList<String>();

  @BeforeEach
  public void setUpConfigurationService() {
    configurationService = processEngine.getConfigurationService();
  }

  @AfterEach
  public void removeConfigurations() {
    processEngineConfiguration.getCommandExecutorTxRequired().execute(commandContext -> {
      for (String configurationId : configurationIds) {
        ConfigurationEntity configuration = commandContext.getConfigurationManager()
            .findConfigurationById(configurationId);
        if (configuration != null) {
          commandContext.getDbEntityManager().delete(configuration);
        }
      }
      return null;
    });
  }

  @Test
  public void shouldFilterConfigurationsByScopeAndStatus() {
    String keyPrefix = "configuration-test-" + UUID.randomUUID();

    ConfigurationEntity globalActive = insertConfiguration(
        keyPrefix + "-global-active", null, Configuration.STATUS_ACTIVE);
    ConfigurationEntity globalDeleted = insertConfiguration(
        keyPrefix + "-global-deleted", null, Configuration.STATUS_DELETED);
    ConfigurationEntity tenantActive = insertConfiguration(
        keyPrefix + "-tenant-active", "tenant-a", Configuration.STATUS_ACTIVE);
    ConfigurationEntity tenantDeleted = insertConfiguration(
        keyPrefix + "-tenant-deleted", "tenant-a", Configuration.STATUS_DELETED);

    assertThat(configurationService.getConfigurations(null, false))
        .extracting(Configuration::getId)
        .contains(globalActive.getId())
        .doesNotContain(globalDeleted.getId(), tenantActive.getId(), tenantDeleted.getId());

    assertThat(configurationService.getConfigurations(null, true))
        .extracting(Configuration::getId)
        .contains(globalActive.getId(), globalDeleted.getId())
        .doesNotContain(tenantActive.getId(), tenantDeleted.getId());

    assertThat(configurationService.getConfigurations("tenant-a", false))
        .extracting(Configuration::getId)
        .contains(tenantActive.getId(), globalActive.getId())
        .doesNotContain(globalDeleted.getId(), tenantDeleted.getId());

    assertThat(configurationService.getConfigurations("tenant-a", true))
        .extracting(Configuration::getId)
        .contains(tenantActive.getId(), tenantDeleted.getId(), globalActive.getId(), globalDeleted.getId());
  }

  @Test
  public void shouldOverrideGlobalConfigurationWithTenantConfiguration() {
    String key = "configuration-test-" + UUID.randomUUID();
    ConfigurationEntity global = insertConfiguration(key, null, Configuration.STATUS_ACTIVE);
    Configuration tenant = configurationService.createConfiguration(key, "tenant-value", "tenant-a");
    configurationIds.add(tenant.getId());

    List<String> tenantView = new ArrayList<String>();
    for (Configuration configuration : configurationService.getConfigurations("tenant-a", false)) {
      if (key.equals(configuration.getConfigKey())) {
        tenantView.add(configuration.getId());
      }
    }
    assertThat(tenantView).containsExactly(tenant.getId());

    List<String> otherTenantView = new ArrayList<String>();
    for (Configuration configuration : configurationService.getConfigurations("tenant-b", false)) {
      if (key.equals(configuration.getConfigKey())) {
        otherTenantView.add(configuration.getId());
      }
    }
    assertThat(otherTenantView).containsExactly(global.getId());

    List<String> history = new ArrayList<String>();
    for (Configuration configuration : configurationService.getConfigurations("tenant-a", true)) {
      if (key.equals(configuration.getConfigKey())) {
        history.add(configuration.getId());
      }
    }
    assertThat(history).containsExactly(global.getId(), tenant.getId());
  }

  @Test
  public void shouldRetrieveConfigurationById() {
    ConfigurationEntity configuration = insertConfiguration(
        "configuration-test-" + UUID.randomUUID(), null, Configuration.STATUS_DELETED);

    assertThat(configurationService.getConfiguration(configuration.getId()).getId())
        .isEqualTo(configuration.getId());
  }

  @Test
  public void shouldCreateNewVersionAndDeactivatePreviousOnUpdate() {
    ConfigurationEntity original = insertConfiguration(
        "configuration-test-" + UUID.randomUUID(), "tenant-a", Configuration.STATUS_ACTIVE);

    Configuration updated = configurationService.updateConfiguration(original.getId(), "new-value");
    configurationIds.add(updated.getId());

    assertThat(updated.getId()).isNotEqualTo(original.getId());
    assertThat(updated.getConfigKey()).isEqualTo(original.getConfigKey());
    assertThat(updated.getTenantId()).isEqualTo("tenant-a");
    assertThat(updated.getConfigValue()).isEqualTo("new-value");
    assertThat(updated.getVersion()).isEqualTo(2);
    assertThat(updated.getStatus()).isEqualTo(Configuration.STATUS_ACTIVE);

    Configuration previous = configurationService.getConfiguration(original.getId());
    assertThat(previous.getStatus()).isEqualTo(Configuration.STATUS_INACTIVE);
    assertThat(previous.getConfigValue()).isEqualTo("config-value");
    assertThat(previous.getVersion()).isEqualTo(1);

    assertThat(configurationService.getConfigurations("tenant-a", false))
        .extracting(Configuration::getId)
        .contains(updated.getId())
        .doesNotContain(original.getId());
  }

  @Test
  public void shouldIncrementVersionAcrossSuccessiveGlobalUpdates() {
    ConfigurationEntity original = insertConfiguration(
        "configuration-test-" + UUID.randomUUID(), null, Configuration.STATUS_ACTIVE);

    Configuration second = configurationService.updateConfiguration(original.getId(), "value-2");
    configurationIds.add(second.getId());
    Configuration third = configurationService.updateConfiguration(second.getId(), "value-3");
    configurationIds.add(third.getId());

    assertThat(third.getVersion()).isEqualTo(3);
    assertThat(third.getTenantId()).isNull();
    assertThat(configurationService.getConfiguration(second.getId()).getStatus())
        .isEqualTo(Configuration.STATUS_INACTIVE);
    List<Integer> versions = new ArrayList<Integer>();
    for (Configuration configuration : configurationService.getConfigurations(null, true)) {
      if (configuration.getConfigKey().equals(original.getConfigKey())) {
        versions.add(configuration.getVersion());
      }
    }
    assertThat(versions).containsExactlyInAnyOrder(1, 2, 3);
  }

  @Test
  public void shouldRejectUpdatingInactiveConfiguration() {
    ConfigurationEntity original = insertConfiguration(
        "configuration-test-" + UUID.randomUUID(), "tenant-a", Configuration.STATUS_ACTIVE);
    Configuration updated = configurationService.updateConfiguration(original.getId(), "new-value");
    configurationIds.add(updated.getId());

    assertThatThrownBy(() -> configurationService.updateConfiguration(original.getId(), "other-value"))
        .isInstanceOf(BadUserRequestException.class)
        .hasMessageContaining("INACTIVE");
  }

  @Test
  public void shouldRejectUpdatingUnknownConfiguration() {
    assertThatThrownBy(() -> configurationService.updateConfiguration("missing-id", "value"))
        .isInstanceOf(NotFoundException.class);
  }

  @Test
  public void shouldRejectBlankConfigurationValueOnUpdate() {
    ConfigurationEntity original = insertConfiguration(
        "configuration-test-" + UUID.randomUUID(), "tenant-a", Configuration.STATUS_ACTIVE);

    assertThatThrownBy(() -> configurationService.updateConfiguration(original.getId(), " "))
        .isInstanceOf(NotValidException.class);
    assertThat(configurationService.getConfiguration(original.getId()).getStatus())
        .isEqualTo(Configuration.STATUS_ACTIVE);
  }

  @Test
  public void shouldDeactivateConfigurationOnDelete() {
    ConfigurationEntity configuration = insertConfiguration(
        "configuration-test-" + UUID.randomUUID(), "tenant-a", Configuration.STATUS_ACTIVE);

    configurationService.deleteConfiguration(configuration.getId());

    Configuration deleted = configurationService.getConfiguration(configuration.getId());
    assertThat(deleted.getStatus()).isEqualTo(Configuration.STATUS_INACTIVE);
    assertThat(deleted.getVersion()).isEqualTo(1);
    assertThat(deleted.getConfigValue()).isEqualTo("config-value");
    assertThat(configurationService.getConfigurations("tenant-a", false))
        .extracting(Configuration::getId)
        .doesNotContain(configuration.getId());
    assertThat(configurationService.getConfigurations("tenant-a", true))
        .extracting(Configuration::getId)
        .contains(configuration.getId());
  }

  @Test
  public void shouldAllowRecreatingConfigurationAfterDelete() {
    ConfigurationEntity configuration = insertConfiguration(
        "configuration-test-" + UUID.randomUUID(), null, Configuration.STATUS_ACTIVE);
    configurationService.deleteConfiguration(configuration.getId());

    Configuration recreated = configurationService.createConfiguration(
        configuration.getConfigKey(), "recreated-value", null);
    configurationIds.add(recreated.getId());

    assertThat(recreated.getStatus()).isEqualTo(Configuration.STATUS_ACTIVE);
  }

  @Test
  public void shouldRejectDeletingInactiveConfiguration() {
    ConfigurationEntity configuration = insertConfiguration(
        "configuration-test-" + UUID.randomUUID(), "tenant-a", Configuration.STATUS_ACTIVE);
    configurationService.deleteConfiguration(configuration.getId());

    assertThatThrownBy(() -> configurationService.deleteConfiguration(configuration.getId()))
        .isInstanceOf(BadUserRequestException.class)
        .hasMessageContaining("INACTIVE");
  }

  @Test
  public void shouldRejectDeletingUnknownConfiguration() {
    assertThatThrownBy(() -> configurationService.deleteConfiguration("missing-id"))
        .isInstanceOf(NotFoundException.class);
  }

  protected ConfigurationEntity insertConfiguration(String configKey, String tenantId, String status) {
    ConfigurationEntity configuration = processEngineConfiguration.getCommandExecutorTxRequired()
        .execute(commandContext -> {
          Date now = new Date();
          ConfigurationEntity entity = new ConfigurationEntity(configKey, "config-value", tenantId);
          entity.setVersion(1);
          entity.setStatus(status);
          entity.setCreatedAt(now);
          entity.setUpdatedAt(now);
          commandContext.getConfigurationManager().insertConfiguration(entity);
          return entity;
        });
    configurationIds.add(configuration.getId());
    return configuration;
  }
}
