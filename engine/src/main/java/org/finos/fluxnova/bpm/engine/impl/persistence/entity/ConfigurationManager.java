package org.finos.fluxnova.bpm.engine.impl.persistence.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.impl.persistence.AbstractManager;

public class ConfigurationManager extends AbstractManager {

  public void insertConfiguration(ConfigurationEntity configuration) {
    getDbEntityManager().insert(configuration);
  }

  public ConfigurationEntity findConfigurationById(String configurationId) {
    return getDbEntityManager().selectById(ConfigurationEntity.class, configurationId);
  }

  public List<Configuration> findConfigurations(String tenantId, boolean includeInactive) {
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("tenantId", tenantId);
    parameters.put("includeInactive", includeInactive);
    return getDbEntityManager().selectList("selectConfigurations", parameters);
  }

  /**
   * Immediately writes pending changes of the given configuration to the database.
   * Required when an entry must be deactivated before a new active entry is inserted,
   * because the engine otherwise flushes inserts before updates.
   */
  public void flushConfiguration(ConfigurationEntity configuration) {
    getDbEntityManager().flushEntity(configuration);
  }

  /**
   * Returns the highest version stored for the given key and scope, or {@code 0}
   * if none exists. A {@code null} tenant id addresses the global scope.
   */
  public int findMaxConfigurationVersion(String configKey, String tenantId) {
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("configKey", configKey);
    parameters.put("tenantId", tenantId);

    Number maxVersion = (Number) getDbEntityManager().selectOne("selectMaxConfigurationVersion", parameters);
    return maxVersion == null ? 0 : maxVersion.intValue();
  }

  /**
   * Checks whether an {@link Configuration#STATUS_ACTIVE} entry already exists for the
   * given scope. A {@code null} tenant id addresses the global scope.
   */
  public boolean existsActiveConfiguration(String configKey, String tenantId) {
    Map<String, Object> parameters = new HashMap<String, Object>();
    parameters.put("configKey", configKey);
    parameters.put("tenantId", tenantId);
    parameters.put("status", Configuration.STATUS_ACTIVE);

    Long count = (Long) getDbEntityManager().selectOne("selectActiveConfigurationCount", parameters);
    return count != null && count > 0;
  }

}
