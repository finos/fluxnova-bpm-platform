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
package org.finos.fluxnova.bpm.engine.test.standalone.deploy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.atomic.AtomicInteger;

import org.finos.fluxnova.bpm.engine.FormService;
import org.finos.fluxnova.bpm.engine.RepositoryService;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.form.FluxnovaFormRef;
import org.finos.fluxnova.bpm.engine.form.TaskFormData;
import org.finos.fluxnova.bpm.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.finos.fluxnova.bpm.engine.impl.bpmn.parser.AbstractBpmnParseListener;
import org.finos.fluxnova.bpm.engine.impl.bpmn.parser.BpmnParseListener;
import org.finos.fluxnova.bpm.engine.impl.core.variable.mapping.IoMapping;
import org.finos.fluxnova.bpm.engine.impl.el.Expression;
import org.finos.fluxnova.bpm.engine.impl.el.ExpressionManager;
import org.finos.fluxnova.bpm.engine.impl.el.JuelExpressionManager;
import org.finos.fluxnova.bpm.engine.impl.form.FormDefinition;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ProcessInstanceWithVariablesImpl;
import org.finos.fluxnova.bpm.engine.impl.pvm.process.ActivityImpl;
import org.finos.fluxnova.bpm.engine.impl.pvm.process.ProcessDefinitionImpl;
import org.finos.fluxnova.bpm.engine.impl.pvm.process.ScopeImpl;
import org.finos.fluxnova.bpm.engine.impl.task.TaskDefinition;
import org.finos.fluxnova.bpm.engine.impl.util.xml.Element;
import org.finos.fluxnova.bpm.engine.repository.DeploymentWithDefinitions;
import org.finos.fluxnova.bpm.engine.repository.ProcessDefinition;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.util.ProcessEngineBootstrapRule;
import org.finos.fluxnova.bpm.engine.test.util.ProcessEngineTestRule;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.finos.fluxnova.bpm.model.bpmn.Bpmn;
import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

/**
 * @author Frederik Heremans
 */
public class BPMNParseListenerTest {

  @ClassRule
  public static ProcessEngineBootstrapRule bootstrapRule = new ProcessEngineBootstrapRule(
      "org/finos/fluxnova/bpm/engine/test/standalone/deploy/bpmn.parse.listener.camunda.cfg.xml");

  protected ProcessEngineRule engineRule = new ProvidedProcessEngineRule(bootstrapRule);
  protected ProcessEngineTestRule engineTestRule = new ProcessEngineTestRule(engineRule);

  @Rule
  public RuleChain ruleChain = RuleChain.outerRule(engineRule).around(engineTestRule);

  protected RuntimeService runtimeService;
  protected RepositoryService repositoryService;

  @Before
  public void setUp() {
    runtimeService = engineRule.getRuntimeService();
    repositoryService = engineRule.getRepositoryService();
  }

  @After
  public void tearDown() {
    DelegatingBpmnParseListener.DELEGATE = null;
  }

  @Test
  public void testAlterProcessDefinitionKeyWhenDeploying() throws Exception {
    // given
    DelegatingBpmnParseListener.DELEGATE = new TestBPMNParseListener();

    // when
    engineTestRule.deploy("org/finos/fluxnova/bpm/engine/test/standalone/deploy/"
        + "BPMNParseListenerTest.testAlterProcessDefinitionKeyWhenDeploying.bpmn20.xml");

    // then
    // Check if process-definition has different key
    assertEquals(0, repositoryService.createProcessDefinitionQuery().processDefinitionKey("oneTaskProcess").count());
    assertEquals(1, repositoryService.createProcessDefinitionQuery().processDefinitionKey("oneTaskProcess-modified").count());
  }

  @Test
  public void testAlterActivityBehaviors() throws Exception {

    // given
    DelegatingBpmnParseListener.DELEGATE = new TestBPMNParseListener();

    // when
    engineTestRule.deploy("org/finos/fluxnova/bpm/engine/test/standalone/deploy/"
        + "BPMNParseListenerTest.testAlterActivityBehaviors.bpmn20.xml");

    // then
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("oneTaskWithIntermediateThrowEvent-modified");
    ProcessDefinitionImpl processDefinition = ((ProcessInstanceWithVariablesImpl) processInstance).getExecutionEntity().getProcessDefinition();

    ActivityImpl cancelThrowEvent = processDefinition.findActivity("CancelthrowEvent");
    assertTrue(cancelThrowEvent.getActivityBehavior() instanceof TestBPMNParseListener.TestCompensationEventActivityBehavior);

    ActivityImpl startEvent = processDefinition.findActivity("theStart");
    assertTrue(startEvent.getActivityBehavior() instanceof TestBPMNParseListener.TestNoneStartEventActivityBehavior);

    ActivityImpl endEvent = processDefinition.findActivity("theEnd");
    assertTrue(endEvent.getActivityBehavior() instanceof TestBPMNParseListener.TestNoneEndEventActivityBehavior);
  }

  @Test
  public void shouldModifyFormKeyViaTaskDefinition() {
    // given
    String originalFormKey = "some-form-key";
    String modifiedFormKey = "another-form-key";

    BpmnModelInstance model = Bpmn.createExecutableProcess("process")
      .startEvent()
        .userTask("task").fluxnovaFormKey(originalFormKey)
      .endEvent()
      .done();

    DelegatingBpmnParseListener.DELEGATE = new AbstractBpmnParseListener() {
      @Override
      public void parseUserTask(Element userTaskElement, ScopeImpl scope, ActivityImpl activity) {
        UserTaskActivityBehavior activityBehavior = (UserTaskActivityBehavior) activity.getActivityBehavior();
        TaskDefinition taskDefinition = activityBehavior.getTaskDefinition();

        ExpressionManager expressionManager = new JuelExpressionManager();
        Expression formKeyExpression = expressionManager.createExpression(modifiedFormKey);

        taskDefinition.setFormKey(formKeyExpression);
      }
    };

    // when
    DeploymentWithDefinitions deployment = engineTestRule.deploy(model);

    // then
    ProcessDefinition processDefinition = deployment.getDeployedProcessDefinitions().get(0);

    FormService formService = engineRule.getFormService();
    String formKey = formService.getTaskFormKey(processDefinition.getId(), "task");
    assertThat(formKey).isEqualTo(modifiedFormKey);

    runtimeService.startProcessInstanceByKey("process");
    Task task = engineRule.getTaskService().createTaskQuery().singleResult();
    TaskFormData formData = formService.getTaskFormData(task.getId());
    assertThat(formData.getFormKey()).isEqualTo(modifiedFormKey);
  }

  @Test
  public void shouldModifyFormRefViaTaskDefinition() {
    // given
    String originalFormRef = "some-form-ref";
    String originalFormRefBinding = "deployment";

    String modifiedFormRef = "another-form-ref";
    String modifiedFormRefBinding = "version";
    Integer modifiedFormRefVersion = 20;

    BpmnModelInstance model = Bpmn.createExecutableProcess("process")
        .startEvent()
          .userTask("task")
            .fluxnovaFormRef(originalFormRef)
            .fluxnovaFormRefBinding(originalFormRefBinding)
          .endEvent()
        .done();

    DelegatingBpmnParseListener.DELEGATE = new AbstractBpmnParseListener() {
      @Override
      public void parseUserTask(Element userTaskElement, ScopeImpl scope, ActivityImpl activity) {
        UserTaskActivityBehavior activityBehavior = (UserTaskActivityBehavior) activity.getActivityBehavior();
        TaskDefinition taskDefinition = activityBehavior.getTaskDefinition();
        FormDefinition formDefinition = taskDefinition.getFormDefinition();

        ExpressionManager expressionManager = new JuelExpressionManager();

        Expression formRefExpression = expressionManager.createExpression(modifiedFormRef);
        formDefinition.setFluxnovaFormDefinitionKey(formRefExpression);

        formDefinition.setFluxnovaFormDefinitionBinding(modifiedFormRefBinding);

        Expression formVersionExpression = expressionManager.createExpression(modifiedFormRefVersion.toString());
        formDefinition.setFluxnovaFormDefinitionVersion(formVersionExpression);
      }
    };

    // when
    engineTestRule.deploy(model);

    // then
    runtimeService.startProcessInstanceByKey("process");
    Task task = engineRule.getTaskService().createTaskQuery().singleResult();

    FormService formService = engineRule.getFormService();
    TaskFormData formData = formService.getTaskFormData(task.getId());
    FluxnovaFormRef formRef = formData.getFluxnovaFormRef();
    assertThat(formRef.getKey()).isEqualTo(modifiedFormRef);
    assertThat(formRef.getBinding()).isEqualTo(modifiedFormRefBinding);
    assertThat(formRef.getVersion()).isEqualTo(modifiedFormRefVersion);
  }

  @Test
  public void shouldCheckWithoutTenant() {
    // given
    BpmnModelInstance model = Bpmn.createExecutableProcess("process-tenantId")
        .startEvent()
          .subProcess()
          .embeddedSubProcess()
            .startEvent()
            .endEvent()
          .subProcessDone()
        .endEvent()
        .done();

    DelegatingBpmnParseListener.DELEGATE = createBpmnParseListenerAndAssertTenantId(null);

    // when
    engineTestRule.deploy(model);
  }

  @Test
  public void shouldCheckWithTenant() {
    // given
    BpmnModelInstance model = Bpmn.createExecutableProcess("process-tenantId")
        .startEvent()
          .subProcess()
          .embeddedSubProcess()
            .startEvent()
            .endEvent()
          .subProcessDone()
        .endEvent()
        .done();

    DelegatingBpmnParseListener.DELEGATE = createBpmnParseListenerAndAssertTenantId("parseListenerTenantId");

    // when
    engineTestRule.deployForTenant("parseListenerTenantId", model);
  }

  @Test
  public void shouldInvokeParseIoMapping() {
    // given
    AtomicInteger invokeTimes = new AtomicInteger();
    DelegatingBpmnParseListener.DELEGATE = new AbstractBpmnParseListener() {
      @Override
      public void parseIoMapping(Element extensionElements, ActivityImpl activity, IoMapping inputOutput) {
        invokeTimes.incrementAndGet();
      }

    };

    // when
    engineTestRule.deploy("org/finos/fluxnova/bpm/engine/test/standalone/deploy/"
        + "BPMNParseListenerTest.shouldInvokeParseIoMapping.bpmn20.xml");

    // then
    assertEquals(1, invokeTimes.get());
  }

  // helper ////////////////////////////////////////////////////////////////////////////////////////////////////////////

  protected BpmnParseListener createBpmnParseListenerAndAssertTenantId(String tenantId) {
    return new AbstractBpmnParseListener() {
      protected void checkTenantId(ProcessDefinitionImpl processDefinitionImpl) {
        // then
        ProcessDefinitionEntity processDefinition = (ProcessDefinitionEntity) processDefinitionImpl;
        assertThat(processDefinition.getTenantId()).isEqualTo(tenantId);
      }

      @Override
      public void parseProcess(Element processElement, ProcessDefinitionEntity processDefinition) {
        checkTenantId(processDefinition);
      }

      @Override
      public void parseStartEvent(Element startEventElement, ScopeImpl scope, ActivityImpl startEventActivity) {
        checkTenantId(startEventActivity.getProcessDefinition());
      }

      @Override
      public void parseEndEvent(Element endEventElement, ScopeImpl scope, ActivityImpl activity) {
        checkTenantId(activity.getProcessDefinition());
      }

      @Override
      public void parseSubProcess(Element subProcessElement, ScopeImpl scope, ActivityImpl activity) {
        checkTenantId(activity.getProcessDefinition());
      }
    };
  }

}
