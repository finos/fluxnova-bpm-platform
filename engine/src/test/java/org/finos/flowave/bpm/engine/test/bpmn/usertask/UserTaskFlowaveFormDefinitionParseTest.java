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
package org.finos.flowave.bpm.engine.test.bpmn.usertask;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertNotNull;

import org.finos.flowave.bpm.engine.ParseException;
import org.finos.flowave.bpm.engine.RepositoryService;
import org.finos.flowave.bpm.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.finos.flowave.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.flowave.bpm.engine.impl.form.FormDefinition;
import org.finos.flowave.bpm.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.finos.flowave.bpm.engine.impl.pvm.process.ActivityImpl;
import org.finos.flowave.bpm.engine.impl.task.TaskDefinition;
import org.finos.flowave.bpm.engine.impl.test.TestHelper;
import org.finos.flowave.bpm.engine.repository.ProcessDefinition;
import org.finos.flowave.bpm.engine.test.Deployment;
import org.finos.flowave.bpm.engine.test.ProcessEngineRule;
import org.finos.flowave.bpm.engine.test.util.ProcessEngineTestRule;
import org.finos.flowave.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

public class UserTaskFlowaveFormDefinitionParseTest {

  public ProcessEngineRule engineRule = new ProvidedProcessEngineRule();
  public ProcessEngineTestRule testRule = new ProcessEngineTestRule(engineRule);

  @Rule
  public RuleChain chain = RuleChain.outerRule(engineRule).around(testRule);

  public RepositoryService repositoryService;
  public ProcessEngineConfigurationImpl processEngineConfiguration;

  @Before
  public void setup() {
    repositoryService = engineRule.getRepositoryService();
    processEngineConfiguration = engineRule.getProcessEngineConfiguration();
  }

  @After
  public void tearDown() {
    for (org.finos.flowave.bpm.engine.repository.Deployment deployment : repositoryService.createDeploymentQuery().list()) {
      repositoryService.deleteDeployment(deployment.getId(), true);
    }
  }

  protected ActivityImpl findActivityInDeployedProcessDefinition(String activityId) {
    ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().singleResult();
    assertNotNull(processDefinition);

    ProcessDefinitionEntity cachedProcessDefinition = processEngineConfiguration.getDeploymentCache()
        .getProcessDefinitionCache().get(processDefinition.getId());
    return cachedProcessDefinition.findActivity(activityId);
  }

  @Test
  @Deployment
  public void shouldParseFlowaveFormDefinitionVersionBinding() {
    // given a deployed process with a UserTask containing a Camunda Form definition with version binding
    // then
    TaskDefinition taskDefinition = findUserTaskDefinition("UserTask");
    FormDefinition formDefinition = taskDefinition.getFormDefinition();

    assertThat(taskDefinition.getFlowaveFormDefinitionKey().getExpressionText()).isEqualTo("formId");
    assertThat(formDefinition.getFlowaveFormDefinitionKey().getExpressionText()).isEqualTo("formId");

    assertThat(taskDefinition.getFlowaveFormDefinitionBinding()).isEqualTo("version");
    assertThat(formDefinition.getFlowaveFormDefinitionBinding()).isEqualTo("version");

    assertThat(taskDefinition.getFlowaveFormDefinitionVersion().getExpressionText()).isEqualTo("1");
    assertThat(formDefinition.getFlowaveFormDefinitionVersion().getExpressionText()).isEqualTo("1");
  }

  @Test
  @Deployment
  public void shouldParseFlowaveFormDefinitionLatestBinding() {
    // given a deployed process with a UserTask containing a Camunda Form definition with latest binding
    // then
    TaskDefinition taskDefinition = findUserTaskDefinition("UserTask");
    FormDefinition formDefinition = taskDefinition.getFormDefinition();

    assertThat(taskDefinition.getFlowaveFormDefinitionKey().getExpressionText()).isEqualTo("formId");
    assertThat(formDefinition.getFlowaveFormDefinitionKey().getExpressionText()).isEqualTo("formId");

    assertThat(taskDefinition.getFlowaveFormDefinitionBinding()).isEqualTo("latest");
    assertThat(formDefinition.getFlowaveFormDefinitionBinding()).isEqualTo("latest");
  }

  @Test
  @Deployment
  public void shouldParseFlowaveFormDefinitionDeploymentBinding() {
    // given a deployed process with a UserTask containing a Camunda Form definition with deployment binding
    // then
    TaskDefinition taskDefinition = findUserTaskDefinition("UserTask");
    FormDefinition formDefinition = taskDefinition.getFormDefinition();

    assertThat(taskDefinition.getFlowaveFormDefinitionKey().getExpressionText()).isEqualTo("formId");
    assertThat(formDefinition.getFlowaveFormDefinitionKey().getExpressionText()).isEqualTo("formId");

    assertThat(taskDefinition.getFlowaveFormDefinitionBinding()).isEqualTo("deployment");
    assertThat(formDefinition.getFlowaveFormDefinitionBinding()).isEqualTo("deployment");
  }

  @Test
  @Deployment
  public void shouldParseTwoUserTasksWithFlowaveFormDefinition() {
    // given a deployed process with two UserTask containing a Camunda Form definition with deployment binding
    // then
    TaskDefinition taskDefinition1 = findUserTaskDefinition("UserTask_1");
    FormDefinition formDefinition1 = taskDefinition1.getFormDefinition();

    assertThat(taskDefinition1.getFlowaveFormDefinitionKey().getExpressionText()).isEqualTo("formId_1");
    assertThat(formDefinition1.getFlowaveFormDefinitionKey().getExpressionText()).isEqualTo("formId_1");

    assertThat(taskDefinition1.getFlowaveFormDefinitionBinding()).isEqualTo("deployment");
    assertThat(formDefinition1.getFlowaveFormDefinitionBinding()).isEqualTo("deployment");

    TaskDefinition taskDefinition2 = findUserTaskDefinition("UserTask_2");
    FormDefinition formDefinition2 = taskDefinition2.getFormDefinition();
    assertThat(taskDefinition2.getFlowaveFormDefinitionKey().getExpressionText()).isEqualTo("formId_2");
    assertThat(formDefinition2.getFlowaveFormDefinitionKey().getExpressionText()).isEqualTo("formId_2");

    assertThat(taskDefinition2.getFlowaveFormDefinitionBinding()).isEqualTo("version");
    assertThat(formDefinition2.getFlowaveFormDefinitionBinding()).isEqualTo("version");

    assertThat(taskDefinition2.getFlowaveFormDefinitionVersion().getExpressionText()).isEqualTo("2");
    assertThat(formDefinition2.getFlowaveFormDefinitionVersion().getExpressionText()).isEqualTo("2");
  }

  @Test
  public void shouldNotParseFlowaveFormDefinitionUnsupportedBinding() {
    // given a deployed process with a UserTask containing a Camunda Form definition with unsupported binding
    String resource = TestHelper.getBpmnProcessDefinitionResource(getClass(), "shouldNotParseCamundaFormDefinitionUnsupportedBinding");

    // when/then expect parse exception
    assertThatThrownBy(() -> repositoryService.createDeployment().name(resource).addClasspathResource(resource).deploy())
      .isInstanceOf(ParseException.class)
      .hasMessageContaining("Invalid element definition: value for formRefBinding attribute has to be one of [deployment, latest, version] but was unsupported");
  }

  @Test
  public void shouldNotParseFlowaveFormDefinitionAndFormKey() {
    // given a deployed process with a UserTask containing a Camunda Form definition and formKey
    String resource = TestHelper.getBpmnProcessDefinitionResource(getClass(), "shouldNotParseCamundaFormDefinitionAndFormKey");

    // when/then expect parse exception
    assertThatThrownBy(() -> repositoryService.createDeployment().name(resource).addClasspathResource(resource).deploy())
      .isInstanceOf(ParseException.class)
      .hasMessageContaining("Invalid element definition: only one of the attributes formKey and formRef is allowed.");
  }

  private TaskDefinition findUserTaskDefinition(String activityId) {
    ActivityImpl userTask = findActivityInDeployedProcessDefinition(activityId);
    assertThat(userTask).isNotNull();

    TaskDefinition taskDefinition = ((UserTaskActivityBehavior) userTask.getActivityBehavior()).getTaskDecorator()
        .getTaskDefinition();
    return taskDefinition;
  }
}
