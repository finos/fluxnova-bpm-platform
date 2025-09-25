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
package org.finos.fluxnova.bpm.spring.boot.starter;

import org.finos.fluxnova.bpm.engine.AuthorizationService;
import org.finos.fluxnova.bpm.engine.CaseService;
import org.finos.fluxnova.bpm.engine.DecisionService;
import org.finos.fluxnova.bpm.engine.ExternalTaskService;
import org.finos.fluxnova.bpm.engine.FilterService;
import org.finos.fluxnova.bpm.engine.FormService;
import org.finos.fluxnova.bpm.engine.HistoryService;
import org.finos.fluxnova.bpm.engine.IdentityService;
import org.finos.fluxnova.bpm.engine.ManagementService;
import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.RepositoryService;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.TaskService;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;
import org.finos.fluxnova.bpm.engine.impl.jobexecutor.JobExecutor;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.PropertyEntity;
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractFluxnovaAutoConfigurationIT {

  @Autowired
  protected RuntimeService runtimeService;

  @Autowired
  protected RepositoryService repositoryService;

  @Autowired
  protected FormService formService;

  @Autowired
  protected TaskService taskService;

  @Autowired
  protected HistoryService historyService;

  @Autowired
  protected IdentityService identityService;

  @Autowired
  protected ManagementService managementService;

  @Autowired
  protected AuthorizationService authorizationService;

  @Autowired
  protected CaseService caseService;

  @Autowired
  protected FilterService filterService;

  @Autowired
  protected ExternalTaskService externalTaskService;

  @Autowired
  protected DecisionService decisionService;

  @Autowired(required = false)
  protected JobExecutor jobExecutor;

  @Autowired
  protected ProcessEngine processEngine;

  @After
  public void cleanup() {
    //remove history level from database
    ((ProcessEngineConfigurationImpl)processEngine.getProcessEngineConfiguration()).getCommandExecutorTxRequired().execute(new Command<Void>() {
      @Override
      public Void execute(CommandContext commandContext) {
        final PropertyEntity historyLevel = commandContext.getPropertyManager().findPropertyById("historyLevel");
        if (historyLevel != null) {
          commandContext.getDbEntityManager().delete(historyLevel);
        }
        return null;
      }
    });
  }

}
