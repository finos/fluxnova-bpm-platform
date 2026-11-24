package org.finos.fluxnova.bpm.engine.spring.configuration;

import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.delegate.DelegateExecution;
import org.finos.fluxnova.bpm.engine.exception.NotFoundException;

/**
 * Stateless configuration lookup for process expressions. A null tenant selects
 * global defaults; a tenant selects active overrides with global fallback.
 */
public class ConfigurationLookup {

  // Object preserves null tenant arguments that JUEL would coerce to empty strings.
  public String getValue(DelegateExecution execution, String key, Object tenantId) {
    if (key == null || key.isBlank()) {
      throw new IllegalArgumentException("configKey must be a non-blank string");
    }
    if (tenantId != null && (!(tenantId instanceof String text) || text.isBlank())) {
      throw new IllegalArgumentException("tenantId must be a non-blank string");
    }
    String tenant = (String) tenantId;

    for (Configuration configuration : execution.getProcessEngine()
        .getConfigurationService().getConfigurations(tenant, false)) {
      if (key.equals(configuration.getConfigKey())) {
        return configuration.getConfigValue();
      }
    }

    throw new NotFoundException("No active configuration found for key '" + key
        + "' in " + (tenant == null ? "global scope" : "tenant '" + tenant + "'"));
  }
}
