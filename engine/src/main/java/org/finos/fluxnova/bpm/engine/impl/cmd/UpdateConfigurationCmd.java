package org.finos.fluxnova.bpm.engine.impl.cmd;

import static org.finos.fluxnova.bpm.engine.impl.util.EnsureUtil.ensureNotNull;

import java.io.Serializable;
import java.util.Date;

import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.exception.NotFoundException;
import org.finos.fluxnova.bpm.engine.exception.NotValidException;
import org.finos.fluxnova.bpm.engine.impl.identity.Authentication;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ConfigurationEntity;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ConfigurationManager;
import org.finos.fluxnova.bpm.engine.impl.util.ClockUtil;

/**
 * Updates a configuration by deactivating the current entry and inserting a new
 * active version with the same key and tenant scope.
 */
public class UpdateConfigurationCmd implements Command<Configuration>, Serializable {

  private static final long serialVersionUID = 1L;

  protected String configurationId;
  protected String configValue;

  public UpdateConfigurationCmd(String configurationId, String configValue) {
    this.configurationId = configurationId;
    this.configValue = configValue;
  }

  public Configuration execute(CommandContext commandContext) {
    ensureNotNull(NotValidException.class, "configurationId is mandatory", "configurationId", configurationId);
    ensureNotNull(NotValidException.class, "configValue is mandatory", "configValue", configValue);
    if (configValue.trim().isEmpty()) {
      throw new NotValidException("configValue must not be blank");
    }

    ConfigurationManager configurationManager = commandContext.getConfigurationManager();
    ConfigurationEntity current = configurationManager.findConfigurationById(configurationId);
    if (current == null) {
      throw new NotFoundException("Configuration with id '" + configurationId + "' does not exist");
    }
    if (!Configuration.STATUS_ACTIVE.equals(current.getStatus())) {
      throw new BadUserRequestException("Configuration with id '" + configurationId
          + "' cannot be updated because its status is '" + current.getStatus() + "'");
    }

    Date now = ClockUtil.getCurrentTime();
    Authentication authentication = commandContext.getAuthentication();
    String userId = authentication == null ? null : authentication.getUserId();

    int nextVersion = configurationManager.findMaxConfigurationVersion(
        current.getConfigKey(), current.getTenantId()) + 1;

    current.setStatus(Configuration.STATUS_INACTIVE);
    current.setUpdatedBy(userId);
    current.setUpdatedAt(now);
    configurationManager.flushConfiguration(current);

    ConfigurationEntity next = new ConfigurationEntity(
        current.getConfigKey(), configValue, current.getTenantId());
    next.setVersion(nextVersion);
    next.setStatus(Configuration.STATUS_ACTIVE);
    next.setCreatedBy(userId);
    next.setCreatedAt(now);
    next.setUpdatedBy(userId);
    next.setUpdatedAt(now);
    configurationManager.insertConfiguration(next);

    return next;
  }

}
