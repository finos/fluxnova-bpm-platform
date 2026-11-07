package org.finos.fluxnova.bpm.engine.rest.dto.configuration;

/**
 * Request DTO for creating a new process configuration entry.
 */
public class CreateConfigurationDto {

  /** Required. The configuration key. Must not be blank. */
  private String configKey;

  /** Required. The configuration value. Must not be blank. */
  private String configValue;

  /**
   * Optional. When omitted or blank the entry is scoped as a global
   * configuration (no tenant restriction).
   */
  private String tenantId;

  public String getConfigKey() {
    return configKey;
  }

  public void setConfigKey(String configKey) {
    this.configKey = configKey;
  }

  public String getConfigValue() {
    return configValue;
  }

  public void setConfigValue(String configValue) {
    this.configValue = configValue;
  }

  public String getTenantId() {
    return tenantId;
  }

  public void setTenantId(String tenantId) {
    this.tenantId = tenantId;
  }
}
