/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.finos.fluxnova.bpm.monitoring.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.finos.fluxnova.bpm.monitoring.MonitoringRuntimeDelegate;
import org.finos.fluxnova.bpm.monitoring.db.CommandExecutor;
import org.finos.fluxnova.bpm.monitoring.db.QueryService;
import org.finos.fluxnova.bpm.monitoring.impl.db.CommandExecutorImpl;
import org.finos.fluxnova.bpm.monitoring.impl.db.QueryServiceImpl;
import org.finos.fluxnova.bpm.monitoring.impl.plugin.DefaultPluginRegistry;
import org.finos.fluxnova.bpm.monitoring.plugin.PluginRegistry;
import org.finos.fluxnova.bpm.monitoring.plugin.spi.MonitoringPlugin;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEngineException;
import org.finos.fluxnova.bpm.engine.impl.ProcessEngineImpl;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.webapp.impl.AbstractAppRuntimeDelegate;

/**
 * <p>This is the default {@link CockpitRuntimeDelegate} implementation that provides
 * the camunda monitoring plugin services (i.e. {@link QueryService} and
 * {@link CommandExecutor}).</p>
 *
 * @author roman.smirnov
 * @author nico.rehwaldt
 */
public class DefaultMonitoringRuntimeDelegate extends AbstractAppRuntimeDelegate<MonitoringPlugin> implements MonitoringRuntimeDelegate {

  private  Map<String, CommandExecutor> commandExecutors;

  public DefaultMonitoringRuntimeDelegate() {
    super(MonitoringPlugin.class);
    this.commandExecutors = new HashMap<String, CommandExecutor>();
  }

  @Override
  public QueryService getQueryService(String processEngineName) {
    CommandExecutor commandExecutor = getCommandExecutor(processEngineName);
    return new QueryServiceImpl(commandExecutor);
  }

  @Override
  public CommandExecutor getCommandExecutor(String processEngineName) {

    CommandExecutor commandExecutor = commandExecutors.get(processEngineName);
    if (commandExecutor == null) {
      commandExecutor = createCommandExecutor(processEngineName);
      commandExecutors.put(processEngineName, commandExecutor);
    }

    return commandExecutor;
  }

  /**
   * Deprecated: use {@link #getAppPluginRegistry()}
   */
  @Deprecated
  public PluginRegistry getPluginRegistry() {
    return new DefaultPluginRegistry(pluginRegistry);
  }

  /**
   * Returns the list of mapping files that should be used to create the
   * session factory for this runtime.
   *
   * @return
   */
  protected List<String> getMappingFiles() {
    List<MonitoringPlugin> monitoringPlugins = pluginRegistry.getPlugins();

    List<String> mappingFiles = new ArrayList<String>();
    for (MonitoringPlugin plugin: monitoringPlugins) {
      mappingFiles.addAll(plugin.getMappingFiles());
    }

    return mappingFiles;
  }

  /**
   * Create command executor for the engine with the given name
   *
   * @param processEngineName
   * @return
   */
  protected CommandExecutor createCommandExecutor(String processEngineName) {

    ProcessEngine processEngine = getProcessEngine(processEngineName);
    if (processEngine == null) {
      throw new ProcessEngineException("No process engine with name " + processEngineName + " found.");
    }

    ProcessEngineConfigurationImpl processEngineConfiguration = ((ProcessEngineImpl)processEngine).getProcessEngineConfiguration();
    List<String> mappingFiles = getMappingFiles();

    return new CommandExecutorImpl(processEngineConfiguration, mappingFiles);
  }

}
