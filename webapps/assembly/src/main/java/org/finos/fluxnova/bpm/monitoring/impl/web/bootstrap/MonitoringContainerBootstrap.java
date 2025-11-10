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
package org.finos.fluxnova.bpm.monitoring.impl.web.bootstrap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.finos.fluxnova.bpm.monitoring.Monitoring;
import org.finos.fluxnova.bpm.monitoring.impl.DefaultMonitoringRuntimeDelegate;
import org.finos.fluxnova.bpm.container.RuntimeContainerDelegate;
import org.finos.fluxnova.bpm.engine.rest.util.WebApplicationUtil;

/**
 * A servlet context listener that bootstraps monitoring on a
 * running Camunda Platform.
 *
 * @author nico.rehwaldt
 */
public class MonitoringContainerBootstrap implements ServletContextListener {

  private MonitoringEnvironment environment;

  @Override
  public void contextInitialized(ServletContextEvent sce) {

    environment = createMonitoringEnvironment();
    environment.setup();

    WebApplicationUtil.setApplicationServer(sce.getServletContext().getServerInfo());

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {

    environment.tearDown();
  }

  protected MonitoringEnvironment createMonitoringEnvironment() {
    return new MonitoringEnvironment();
  }

  protected static class MonitoringEnvironment {

    public void tearDown() {
      Monitoring.setMonitoringRuntimeDelegate(null);
    }

    public void setup() {
      Monitoring.setMonitoringRuntimeDelegate(new DefaultMonitoringRuntimeDelegate());
    }

    protected RuntimeContainerDelegate getContainerRuntimeDelegate() {
      return RuntimeContainerDelegate.INSTANCE.get();
    }
  }
}
