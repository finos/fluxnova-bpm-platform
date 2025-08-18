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
package org.finos.flowave.bpm.engine.test.api.multitenancy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import org.finos.flowave.bpm.engine.ProcessEngineException;
import org.finos.flowave.bpm.engine.runtime.ProcessInstance;
import org.finos.flowave.bpm.engine.test.util.PluggableProcessEngineTest;
import org.finos.flowave.bpm.model.bpmn.Bpmn;
import org.finos.flowave.bpm.model.bpmn.BpmnModelInstance;
import org.junit.Test;

public class MultiTenancyBusinessRuleTaskTest extends PluggableProcessEngineTest {

  protected static final String TENANT_ONE = "tenant1";
  protected static final String TENANT_TWO = "tenant2";

  protected static final String DMN_FILE = "org/finos/flowave/bpm/engine/test/api/multitenancy/simpleDecisionTable.dmn";
  protected static final String DMN_FILE_VERSION_TWO = "org/finos/flowave/bpm/engine/test/api/multitenancy/simpleDecisionTable_v2.dmn";

  protected static final String RESULT_OF_VERSION_ONE = "A";
  protected static final String RESULT_OF_VERSION_TWO = "C";

  public static final String DMN_FILE_VERSION_TAG = "org/finos/flowave/bpm/engine/test/dmn/businessruletask/DmnBusinessRuleTaskTest.testDecisionVersionTagOkay.dmn11.xml";
  public static final String DMN_FILE_VERSION_TAG_TWO = "org/finos/flowave/bpm/engine/test/dmn/businessruletask/DmnBusinessRuleTaskTest.testDecisionVersionTagOkay_v2.dmn11.xml";

  protected static final String RESULT_OF_VERSION_TAG_ONE = "A";
  protected static final String RESULT_OF_VERSION_TAG_TWO = "C";

  @Test
  public void testEvaluateDecisionWithDeploymentBinding() {

    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("deployment")
          .flowaveMapDecisionResult("singleEntry")
          .flowaveResultVariable("decisionVar")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

    testRule.deployForTenant(TENANT_ONE, process, DMN_FILE);
    testRule.deployForTenant(TENANT_TWO, process, DMN_FILE_VERSION_TWO);

    ProcessInstance processInstanceOne = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold")
      .processDefinitionTenantId(TENANT_ONE).execute();

    ProcessInstance processInstanceTwo = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold")
      .processDefinitionTenantId(TENANT_TWO).execute();

    assertThat((String)runtimeService.getVariable(processInstanceOne.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_ONE);
    assertThat((String)runtimeService.getVariable(processInstanceTwo.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_TWO);
  }

  @Test
  public void testEvaluateDecisionWithLatestBindingSameVersion() {

    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("latest")
          .flowaveMapDecisionResult("singleEntry")
          .flowaveResultVariable("decisionVar")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

    testRule.deployForTenant(TENANT_ONE, process, DMN_FILE);
    testRule.deployForTenant(TENANT_TWO, process, DMN_FILE_VERSION_TWO);

    ProcessInstance processInstanceOne = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold")
      .processDefinitionTenantId(TENANT_ONE).execute();

    ProcessInstance processInstanceTwo = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold")
      .processDefinitionTenantId(TENANT_TWO).execute();

    assertThat((String)runtimeService.getVariable(processInstanceOne.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_ONE);
    assertThat((String)runtimeService.getVariable(processInstanceTwo.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_TWO);
  }

  @Test
  public void testEvaluateDecisionWithLatestBindingDifferentVersions() {

    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("latest")
          .flowaveMapDecisionResult("singleEntry")
          .flowaveResultVariable("decisionVar")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

    testRule.deployForTenant(TENANT_ONE, process, DMN_FILE);

    testRule.deployForTenant(TENANT_TWO, process, DMN_FILE);
    testRule.deployForTenant(TENANT_TWO, DMN_FILE_VERSION_TWO);

    ProcessInstance processInstanceOne = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold")
      .processDefinitionTenantId(TENANT_ONE).execute();

    ProcessInstance processInstanceTwo = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold")
      .processDefinitionTenantId(TENANT_TWO).execute();

    assertThat((String)runtimeService.getVariable(processInstanceOne.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_ONE);
    assertThat((String)runtimeService.getVariable(processInstanceTwo.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_TWO);
  }

  @Test
  public void testEvaluateDecisionWithVersionBinding() {

    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("version")
          .flowaveDecisionRefVersion("1")
          .flowaveMapDecisionResult("singleEntry")
          .flowaveResultVariable("decisionVar")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

    testRule.deployForTenant(TENANT_ONE, process, DMN_FILE);
    testRule.deployForTenant(TENANT_ONE, DMN_FILE_VERSION_TWO);

    testRule.deployForTenant(TENANT_TWO, process, DMN_FILE_VERSION_TWO);
    testRule.deployForTenant(TENANT_TWO, DMN_FILE);

    ProcessInstance processInstanceOne = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold")
      .processDefinitionTenantId(TENANT_ONE).execute();

    ProcessInstance processInstanceTwo = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold")
      .processDefinitionTenantId(TENANT_TWO).execute();

    assertThat((String)runtimeService.getVariable(processInstanceOne.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_ONE);
    assertThat((String)runtimeService.getVariable(processInstanceTwo.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_TWO);
  }

  @Test
  public void testEvaluateDecisionWithVersionTagBinding() {
    // given
    testRule.deployForTenant(TENANT_ONE, DMN_FILE_VERSION_TAG);
    testRule.deploy(Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefTenantId(TENANT_ONE)
          .flowaveDecisionRefBinding("versionTag")
          .flowaveDecisionRefVersionTag("0.0.2")
          .flowaveMapDecisionResult("singleEntry")
          .flowaveResultVariable("decisionVar")
        .endEvent()
          .flowaveAsyncBefore()
        .done());

    // when
    ProcessInstance processInstance = runtimeService.createProcessInstanceByKey("process")
        .setVariable("status", "gold")
        .execute();

    // then
    assertThat((String)runtimeService.getVariable(processInstance.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_TAG_ONE);
  }

  @Test
  public void testEvaluateDecisionWithVersionTagBinding_ResolveTenantFromDefinition() {
    // given
    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("versionTag")
          .flowaveDecisionRefVersionTag("0.0.2")
          .flowaveMapDecisionResult("singleEntry")
          .flowaveResultVariable("decisionVar")
        .endEvent()
          .flowaveAsyncBefore()
        .done();

    testRule.deployForTenant(TENANT_ONE, process, DMN_FILE_VERSION_TAG);
    testRule.deployForTenant(TENANT_TWO, process, DMN_FILE_VERSION_TAG_TWO);

    ProcessInstance processInstanceOne = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold")
      .processDefinitionTenantId(TENANT_ONE).execute();

    ProcessInstance processInstanceTwo = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold")
      .processDefinitionTenantId(TENANT_TWO).execute();

    assertThat((String)runtimeService.getVariable(processInstanceOne.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_TAG_ONE);
    assertThat((String)runtimeService.getVariable(processInstanceTwo.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_TAG_TWO);
  }

  @Test
  public void testFailEvaluateDecisionFromOtherTenantWithDeploymentBinding() {

    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("deployment")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

    testRule.deployForTenant(TENANT_ONE, process);
    testRule.deployForTenant(TENANT_TWO, DMN_FILE);

    try {
      runtimeService.createProcessInstanceByKey("process")
        .processDefinitionTenantId(TENANT_ONE)
        .execute();

      fail("expected exception");
    } catch (ProcessEngineException e) {
      assertThat(e.getMessage()).contains("no decision definition deployed with key = 'decision'");
    }
  }

  @Test
  public void testFailEvaluateDecisionFromOtherTenantWithLatestBinding() {

    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("latest")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

    testRule.deployForTenant(TENANT_ONE, process);
    testRule.deployForTenant(TENANT_TWO, DMN_FILE);

    try {
      runtimeService.createProcessInstanceByKey("process")
        .processDefinitionTenantId(TENANT_ONE)
        .execute();

      fail("expected exception");
    } catch (ProcessEngineException e) {
      assertThat(e.getMessage()).contains("no decision definition deployed with key 'decision'");
    }
  }

  @Test
  public void testFailEvaluateDecisionFromOtherTenantWithVersionBinding() {

    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("version")
          .flowaveDecisionRefVersion("2")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

    testRule.deployForTenant(TENANT_ONE, process, DMN_FILE);

    testRule.deployForTenant(TENANT_TWO, DMN_FILE);
    testRule.deployForTenant(TENANT_TWO, DMN_FILE);

    try {
      runtimeService.createProcessInstanceByKey("process")
        .processDefinitionTenantId(TENANT_ONE)
        .execute();

      fail("expected exception");
    } catch (ProcessEngineException e) {
      assertThat(e.getMessage()).contains("no decision definition deployed with key = 'decision', version = '2' and tenant-id 'tenant1'");
    }
  }

  @Test
  public void testFailEvaluateDecisionFromOtherTenantWithVersionTagBinding() {
    // given
    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
        .flowaveDecisionRef("decision")
        .flowaveDecisionRefBinding("versionTag")
        .flowaveDecisionRefVersionTag("0.0.2")
        .flowaveMapDecisionResult("singleEntry")
        .flowaveResultVariable("result")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

    testRule.deployForTenant(TENANT_ONE, process);

    testRule.deployForTenant(TENANT_TWO, DMN_FILE_VERSION_TAG);

    try {
      // when
      runtimeService.createProcessInstanceByKey("process")
        .processDefinitionTenantId(TENANT_ONE)
        .execute();

      fail("expected exception");
    } catch (ProcessEngineException e) {
      // then
      assertThat(e.getMessage()).contains("no decision definition deployed with key = 'decision', versionTag = '0.0.2' and tenant-id 'tenant1': decisionDefinition is null");
    }
  }

  @Test
  public void testEvaluateDecisionTenantIdConstant() {

    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("latest")
          .flowaveDecisionRefTenantId(TENANT_ONE)
          .flowaveMapDecisionResult("singleEntry")
          .flowaveResultVariable("decisionVar")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

    testRule.deployForTenant(TENANT_ONE, DMN_FILE);
    testRule.deployForTenant(TENANT_TWO, DMN_FILE_VERSION_TWO);
   testRule.deploy(process);

    ProcessInstance processInstanceOne = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold").execute();

    assertThat((String)runtimeService.getVariable(processInstanceOne.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_ONE);
  }

  @Test
  public void testEvaluateDecisionWithoutTenantIdConstant() {

    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("latest")
          .flowaveDecisionRefTenantId("${null}")
          .flowaveMapDecisionResult("singleEntry")
          .flowaveResultVariable("decisionVar")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

   testRule.deploy(DMN_FILE);
    testRule.deployForTenant(TENANT_ONE, process);
    testRule.deployForTenant(TENANT_TWO, DMN_FILE_VERSION_TWO);

    ProcessInstance processInstanceOne = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold").execute();

    assertThat((String)runtimeService.getVariable(processInstanceOne.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_ONE);
  }

  @Test
  public void testEvaluateDecisionTenantIdExpression() {

    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
        .startEvent()
        .businessRuleTask()
          .flowaveDecisionRef("decision")
          .flowaveDecisionRefBinding("latest")
          .flowaveDecisionRefTenantId("${'"+TENANT_ONE+"'}")
          .flowaveMapDecisionResult("singleEntry")
          .flowaveResultVariable("decisionVar")
        .flowaveAsyncAfter()
        .endEvent()
        .done();

    testRule.deployForTenant(TENANT_ONE, DMN_FILE);
    testRule.deployForTenant(TENANT_TWO, DMN_FILE_VERSION_TWO);
   testRule.deploy(process);

    ProcessInstance processInstanceOne = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold").execute();

    assertThat((String)runtimeService.getVariable(processInstanceOne.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_ONE);
  }

  @Test
  public void testEvaluateDecisionTenantIdCompositeExpression() {
    // given
    BpmnModelInstance process = Bpmn.createExecutableProcess("process")
      .startEvent()
      .businessRuleTask()
      .flowaveDecisionRef("decision")
      .flowaveDecisionRefBinding("latest")
      .flowaveDecisionRefTenantId("tenant${'1'}")
      .flowaveMapDecisionResult("singleEntry")
      .flowaveResultVariable("decisionVar")
      .flowaveAsyncAfter()
      .endEvent()
      .done();
    testRule.deployForTenant(TENANT_ONE, DMN_FILE);
    testRule.deployForTenant(TENANT_TWO, DMN_FILE_VERSION_TWO);
   testRule.deploy(process);

    // when
    ProcessInstance processInstanceOne = runtimeService.createProcessInstanceByKey("process")
      .setVariable("status", "gold").execute();

    // then
    assertThat((String)runtimeService.getVariable(processInstanceOne.getId(), "decisionVar")).isEqualTo(RESULT_OF_VERSION_ONE);
  }

}
