package org.finos.fluxnova.bpm.engine;

import java.util.List;

import org.finos.fluxnova.bpm.engine.configuration.Configuration;

/**
 * <p>Service which provides access to process configurations: key/value pairs
 * which are either global or scoped to a single tenant.</p>
 */
public interface ConfigurationService {

  /**
   * <p>Creates a new configuration entry.</p>
   *
   * <p>If {@code tenantId} is {@code null} the entry is created as a global
   * configuration which applies to all tenants.</p>
   *
   * @param configKey the configuration key, must not be {@code null}
   * @param configValue the configuration value, must not be {@code null}
   * @param tenantId the tenant to scope the entry to, or {@code null} for a global entry
   * @return the newly created configuration
   *
   * @throws org.finos.fluxnova.bpm.engine.exception.NotValidException
   *          if {@code configKey} or {@code configValue} is {@code null}
   * @throws BadUserRequestException
   *          if an active configuration with the same key already exists in the same scope
   */
  Configuration createConfiguration(String configKey, String configValue, String tenantId);

  /**
   * <p>Returns the configuration with the given id.</p>
   *
   * @param configurationId the id of the configuration, must not be {@code null}
   * @return the configuration, or {@code null} if no configuration exists for that id
   */
  Configuration getConfiguration(String configurationId);

  /**
   * Returns the configurations applicable to the requested scope.
   *
   * <p>If {@code tenantId} is {@code null}, the global default configurations
   * are returned. For a tenant, active global configurations are returned with
   * any active tenant entry replacing the global entry of the same key.</p>
   *
   * <p>If {@code includeInactive} is {@code true}, all entries of every status
   * are returned without merging: the global entries and, when {@code tenantId}
   * is set, the tenant's entries.</p>
   *
   * @param tenantId the tenant scope, or {@code null} for global defaults
   * @param includeInactive whether to include inactive configurations
   * @return configurations ordered by key, then global before tenant, then version
   */
  List<Configuration> getConfigurations(String tenantId, boolean includeInactive);

  /**
   * <p>Updates the value of an active configuration by creating a new version.</p>
   *
   * <p>The existing entry is marked {@link Configuration#STATUS_INACTIVE} and a new
   * {@link Configuration#STATUS_ACTIVE} entry with the same key and tenant scope is
   * created. Its version is one greater than the highest existing version for that
   * key and scope.</p>
   *
   * @param configurationId the id of the active configuration to update
   * @param configValue the new configuration value, must not be blank
   * @return the newly created active configuration version
   *
   * @throws org.finos.fluxnova.bpm.engine.exception.NotValidException
   *          if {@code configurationId} or {@code configValue} is missing or blank
   * @throws org.finos.fluxnova.bpm.engine.exception.NotFoundException
   *          if no configuration exists for {@code configurationId}
   * @throws BadUserRequestException
   *          if the configuration is not active
   */
  Configuration updateConfiguration(String configurationId, String configValue);

  /**
   * <p>Soft-deletes an active configuration by marking it
   * {@link Configuration#STATUS_INACTIVE}. The entry is retained and can still be
   * retrieved by id or with {@code includeInactive}.</p>
   *
   * @param configurationId the id of the active configuration to delete
   *
   * @throws org.finos.fluxnova.bpm.engine.exception.NotValidException
   *          if {@code configurationId} is {@code null}
   * @throws org.finos.fluxnova.bpm.engine.exception.NotFoundException
   *          if no configuration exists for {@code configurationId}
   * @throws BadUserRequestException
   *          if the configuration is not active
   */
  void deleteConfiguration(String configurationId);

}
