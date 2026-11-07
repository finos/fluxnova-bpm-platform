package org.finos.fluxnova.bpm.engine.impl.cmd;

import static org.finos.fluxnova.bpm.engine.impl.util.EnsureUtil.ensureNotNull;

import java.io.Serializable;

import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;

public class GetConfigurationCmd implements Command<Configuration>, Serializable {

  private static final long serialVersionUID = 1L;

  protected String configurationId;

  public GetConfigurationCmd(String configurationId) {
    this.configurationId = configurationId;
  }

  public Configuration execute(CommandContext commandContext) {
    ensureNotNull("configurationId", configurationId);

    return commandContext
        .getConfigurationManager()
        .findConfigurationById(configurationId);
  }

}
