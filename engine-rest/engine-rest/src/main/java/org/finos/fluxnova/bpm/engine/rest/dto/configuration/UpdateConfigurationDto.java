package org.finos.fluxnova.bpm.engine.rest.dto.configuration;

/**
 * Request DTO for updating the value of an existing process configuration entry.
 */
public class UpdateConfigurationDto {

  /** Required. The new configuration value. Must not be blank. */
  private String configValue;

  public String getConfigValue() {
    return configValue;
  }

  public void setConfigValue(String configValue) {
    this.configValue = configValue;
  }
}
