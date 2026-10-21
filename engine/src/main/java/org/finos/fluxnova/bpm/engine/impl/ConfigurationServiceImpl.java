package org.finos.fluxnova.bpm.engine.impl;

import java.util.List;

import org.finos.fluxnova.bpm.engine.ConfigurationService;
import org.finos.fluxnova.bpm.engine.configuration.Configuration;
import org.finos.fluxnova.bpm.engine.impl.cmd.CreateConfigurationCmd;
import org.finos.fluxnova.bpm.engine.impl.cmd.DeleteConfigurationCmd;
import org.finos.fluxnova.bpm.engine.impl.cmd.GetConfigurationCmd;
import org.finos.fluxnova.bpm.engine.impl.cmd.GetConfigurationsCmd;
import org.finos.fluxnova.bpm.engine.impl.cmd.UpdateConfigurationCmd;

public class ConfigurationServiceImpl extends ServiceImpl implements ConfigurationService {

  public Configuration createConfiguration(String configKey, String configValue, String tenantId) {
    return commandExecutor.execute(new CreateConfigurationCmd(configKey, configValue, tenantId));
  }

  public Configuration getConfiguration(String configurationId) {
    return commandExecutor.execute(new GetConfigurationCmd(configurationId));
  }

  public List<Configuration> getConfigurations(String tenantId, boolean includeInactive) {
    return commandExecutor.execute(new GetConfigurationsCmd(tenantId, includeInactive));
  }

  public Configuration updateConfiguration(String configurationId, String configValue) {
    return commandExecutor.execute(new UpdateConfigurationCmd(configurationId, configValue));
  }

  public void deleteConfiguration(String configurationId) {
    commandExecutor.execute(new DeleteConfigurationCmd(configurationId));
  }

}
