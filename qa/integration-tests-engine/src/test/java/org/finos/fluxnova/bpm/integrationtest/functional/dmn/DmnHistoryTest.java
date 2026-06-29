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
package org.finos.fluxnova.bpm.integrationtest.functional.dmn;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.finos.fluxnova.bpm.engine.history.HistoricDecisionInstance;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.variable.VariableMap;
import org.finos.fluxnova.bpm.engine.variable.Variables;
import org.finos.fluxnova.bpm.integrationtest.util.AbstractFoxPlatformIntegrationTest;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author Philipp Ossler
 */
@ExtendWith(ArquillianExtension.class)
public class DmnHistoryTest extends AbstractFoxPlatformIntegrationTest {

  @Deployment
  public static WebArchive processArchive() {

    return initWebArchiveDeployment()
        .addAsResource("org/finos/fluxnova/bpm/integrationtest/functional/dmn/BusinessRuleProcess.bpmn20.xml", "BusinessRuleProcess.bpmn20.xml")
        .addAsResource("org/finos/fluxnova/bpm/integrationtest/functional/dmn/Example.dmn11.xml", "Example.dmn11.xml");

  }

  @Test
  public void testHistoricDecisionInstance() {

    VariableMap variables = Variables.createVariables().putValue("status", "bronze").putValue("sum", 100);
    ProcessInstance pi = runtimeService.startProcessInstanceByKey("testProcess", variables);

    HistoricDecisionInstance historicDecisionInstance = historyService.createHistoricDecisionInstanceQuery().includeInputs().includeOutputs().singleResult();
    assertNotNull(historicDecisionInstance);
    assertEquals("decision", historicDecisionInstance.getDecisionDefinitionKey());
    assertEquals("Check Order", historicDecisionInstance.getDecisionDefinitionName());

    assertEquals(2, historicDecisionInstance.getInputs().size());
    assertEquals(2, historicDecisionInstance.getOutputs().size());

    Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
    taskService.complete(task.getId());
  }

}
