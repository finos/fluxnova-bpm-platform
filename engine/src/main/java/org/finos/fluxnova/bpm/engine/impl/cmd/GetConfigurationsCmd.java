package org.finos.fluxnova.bpm.engine.impl.cmd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ConfigurationManager;

/**
 * Returns the configurations applicable to a scope.
 *
 * <p>For a tenant, active global configurations are returned with any active tenant
 * entry replacing the global entry of the same key. With {@code includeInactive},
 * all tenant and global entries are returned without merging.</p>
 */
public class GetConfigurationsCmd implements Command<List<Configuration>>, Serializable {

  private static final long serialVersionUID = 1L;

  protected static final Comparator<Configuration> CONFIGURATION_ORDER = Comparator
      .comparing(Configuration::getConfigKey)
      .thenComparing(Configuration::getTenantId, Comparator.nullsFirst(Comparator.naturalOrder()))
      .thenComparingInt(Configuration::getVersion);

  protected String tenantId;
  protected boolean includeInactive;

  public GetConfigurationsCmd(String tenantId, boolean includeInactive) {
    this.tenantId = tenantId;
    this.includeInactive = includeInactive;
  }

  public List<Configuration> execute(CommandContext commandContext) {
    ConfigurationManager configurationManager = commandContext.getConfigurationManager();
    List<Configuration> globalConfigurations = configurationManager.findConfigurations(null, includeInactive);
    if (tenantId == null) {
      return globalConfigurations;
    }

    List<Configuration> tenantConfigurations = configurationManager.findConfigurations(tenantId, includeInactive);
    List<Configuration> result;
    if (includeInactive) {
      result = new ArrayList<Configuration>(globalConfigurations);
      result.addAll(tenantConfigurations);
    } else {
      Map<String, Configuration> effective = new LinkedHashMap<String, Configuration>();
      for (Configuration configuration : globalConfigurations) {
        effective.put(configuration.getConfigKey(), configuration);
      }
      for (Configuration configuration : tenantConfigurations) {
        effective.put(configuration.getConfigKey(), configuration);
      }
      result = new ArrayList<Configuration>(effective.values());
    }
    result.sort(CONFIGURATION_ORDER);
    return result;
  }
}
