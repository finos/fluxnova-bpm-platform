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
package org.finos.fluxnova.bpm.monitoring.impl.plugin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.finos.fluxnova.bpm.monitoring.impl.plugin.resources.MonitoringPluginsRootResource;
import org.finos.fluxnova.bpm.monitoring.impl.plugin.resources.BaseRootResource;
import org.finos.fluxnova.bpm.monitoring.plugin.spi.impl.AbstractMonitoringPlugin;

/**
 *
 * @author nico.rehwaldt
 */
public class MonitoringPlugins extends AbstractMonitoringPlugin {

  public static final String ID = "monitoringPlugins";

  private static final String[] MAPPING_FILES = {
          "org/finos/fluxnova/bpm/monitoring/plugin/base/queries/processDefinition.xml",
          "org/finos/fluxnova/bpm/monitoring/plugin/base/queries/processInstance.xml",
          "org/finos/fluxnova/bpm/monitoring/plugin/base/queries/incident.xml"
  };

  @Override
  public List<String> getMappingFiles() {
    return Arrays.asList(MAPPING_FILES);
  }

  @Override
  public String getId() {
    return ID;
  }

  @Override
  public Set<Class<?>> getResourceClasses() {
    HashSet<Class<?>> classes = new HashSet<Class<?>>();

    classes.add(MonitoringPluginsRootResource.class);
    classes.add(BaseRootResource.class);

    return classes;
  }

  @Override
  public String getAssetDirectory() {
    return "plugin/monitoring";
  }

}
