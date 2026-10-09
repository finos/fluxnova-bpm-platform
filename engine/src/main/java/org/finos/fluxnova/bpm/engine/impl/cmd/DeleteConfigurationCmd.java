package org.finos.fluxnova.bpm.engine.impl.cmd;

import static org.finos.fluxnova.bpm.engine.impl.util.EnsureUtil.ensureNotNull;

import java.io.Serializable;

import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.exception.NotFoundException;
import org.finos.fluxnova.bpm.engine.exception.NotValidException;
import org.finos.fluxnova.bpm.engine.impl.identity.Authentication;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ConfigurationEntity;
import org.finos.fluxnova.bpm.engine.impl.util.ClockUtil;

/**
 * Soft-deletes a configuration by marking the active entry {@link Configuration#STATUS_INACTIVE}.
 */
public class DeleteConfigurationCmd implements Command<Void>, Serializable {

  private static final long serialVersionUID = 1L;

  protected String configurationId;

  public DeleteConfigurationCmd(String configurationId) {
    this.configurationId = configurationId;
  }

  public Void execute(CommandContext commandContext) {
    ensureNotNull(NotValidException.class, "configurationId is mandatory", "configurationId", configurationId);

    ConfigurationEntity configuration = commandContext.getConfigurationManager()
        .findConfigurationById(configurationId);
    if (configuration == null) {
      throw new NotFoundException("Configuration with id '" + configurationId + "' does not exist");
    }
    if (!Configuration.STATUS_ACTIVE.equals(configuration.getStatus())) {
      throw new BadUserRequestException("Configuration with id '" + configurationId
          + "' cannot be deleted because its status is '" + configuration.getStatus() + "'");
    }

    Authentication authentication = commandContext.getAuthentication();
    configuration.setStatus(Configuration.STATUS_INACTIVE);
    configuration.setUpdatedBy(authentication == null ? null : authentication.getUserId());
    configuration.setUpdatedAt(ClockUtil.getCurrentTime());

    return null;
  }

}
