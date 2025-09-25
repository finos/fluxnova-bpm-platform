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
package org.finos.fluxnova.bpm.engine.test.bpmn.usertask;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertNotNull;

import org.finos.fluxnova.bpm.engine.ParseException;
import org.finos.fluxnova.bpm.engine.RepositoryService;
import org.finos.fluxnova.bpm.engine.impl.bpmn.behavior.UserTaskActivityBehavior;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.form.FormDefinition;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.finos.fluxnova.bpm.engine.impl.pvm.process.ActivityImpl;
import org.finos.fluxnova.bpm.engine.impl.task.TaskDefinition;
import org.finos.fluxnova.bpm.engine.impl.test.TestHelper;
import org.finos.fluxnova.bpm.engine.repository.ProcessDefinition;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.util.ProcessEngineTestRule;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

public class UserTaskFluxnovaFormDefinitionParseTest {

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
    for (org.finos.fluxnova.bpm.engine.repository.Deployment deployment : repositoryService.createDeploymentQuery().list()) {
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
  public void shouldParseFluxnovaFormDefinitionVersionBinding() {
    // given a deployed process with a UserTask containing a Camunda Form definition with version binding
    // then
    TaskDefinition taskDefinition = findUserTaskDefinition("UserTask");
    FormDefinition formDefinition = taskDefinition.getFormDefinition();

    assertThat(taskDefinition.getFluxnovaFormDefinitionKey().getExpressionText()).isEqualTo("formId");
    assertThat(formDefinition.getFluxnovaFormDefinitionKey().getExpressionText()).isEqualTo("formId");

    assertThat(taskDefinition.getFluxnovaFormDefinitionBinding()).isEqualTo("version");
    assertThat(formDefinition.getFluxnovaFormDefinitionBinding()).isEqualTo("version");

    assertThat(taskDefinition.getFluxnovaFormDefinitionVersion().getExpressionText()).isEqualTo("1");
    assertThat(formDefinition.getFluxnovaFormDefinitionVersion().getExpressionText()).isEqualTo("1");
  }

  @Test
  @Deployment
  public void shouldParseFluxnovaFormDefinitionLatestBinding() {
    // given a deployed process with a UserTask containing a Camunda Form definition with latest binding
    // then
    TaskDefinition taskDefinition = findUserTaskDefinition("UserTask");
    FormDefinition formDefinition = taskDefinition.getFormDefinition();

    assertThat(taskDefinition.getFluxnovaFormDefinitionKey().getExpressionText()).isEqualTo("formId");
    assertThat(formDefinition.getFluxnovaFormDefinitionKey().getExpressionText()).isEqualTo("formId");

    assertThat(taskDefinition.getFluxnovaFormDefinitionBinding()).isEqualTo("latest");
    assertThat(formDefinition.getFluxnovaFormDefinitionBinding()).isEqualTo("latest");
  }

  @Test
  @Deployment
  public void shouldParseFluxnovaFormDefinitionDeploymentBinding() {
    // given a deployed process with a UserTask containing a Camunda Form definition with deployment binding
    // then
    TaskDefinition taskDefinition = findUserTaskDefinition("UserTask");
    FormDefinition formDefinition = taskDefinition.getFormDefinition();

    assertThat(taskDefinition.getFluxnovaFormDefinitionKey().getExpressionText()).isEqualTo("formId");
    assertThat(formDefinition.getFluxnovaFormDefinitionKey().getExpressionText()).isEqualTo("formId");

    assertThat(taskDefinition.getFluxnovaFormDefinitionBinding()).isEqualTo("deployment");
    assertThat(formDefinition.getFluxnovaFormDefinitionBinding()).isEqualTo("deployment");
  }

  @Test
  @Deployment
  public void shouldParseTwoUserTasksWithFluxnovaFormDefinition() {
    // given a deployed process with two UserTask containing a Camunda Form definition with deployment binding
    // then
    TaskDefinition taskDefinition1 = findUserTaskDefinition("UserTask_1");
    FormDefinition formDefinition1 = taskDefinition1.getFormDefinition();

    assertThat(taskDefinition1.getFluxnovaFormDefinitionKey().getExpressionText()).isEqualTo("formId_1");
    assertThat(formDefinition1.getFluxnovaFormDefinitionKey().getExpressionText()).isEqualTo("formId_1");

    assertThat(taskDefinition1.getFluxnovaFormDefinitionBinding()).isEqualTo("deployment");
    assertThat(formDefinition1.getFluxnovaFormDefinitionBinding()).isEqualTo("deployment");

    TaskDefinition taskDefinition2 = findUserTaskDefinition("UserTask_2");
    FormDefinition formDefinition2 = taskDefinition2.getFormDefinition();
    assertThat(taskDefinition2.getFluxnovaFormDefinitionKey().getExpressionText()).isEqualTo("formId_2");
    assertThat(formDefinition2.getFluxnovaFormDefinitionKey().getExpressionText()).isEqualTo("formId_2");

    assertThat(taskDefinition2.getFluxnovaFormDefinitionBinding()).isEqualTo("version");
    assertThat(formDefinition2.getFluxnovaFormDefinitionBinding()).isEqualTo("version");

    assertThat(taskDefinition2.getFluxnovaFormDefinitionVersion().getExpressionText()).isEqualTo("2");
    assertThat(formDefinition2.getFluxnovaFormDefinitionVersion().getExpressionText()).isEqualTo("2");
  }

  @Test
  public void shouldNotParseFluxnovaFormDefinitionUnsupportedBinding() {
    // given a deployed process with a UserTask containing a Camunda Form definition with unsupported binding
    String resource = TestHelper.getBpmnProcessDefinitionResource(getClass(), "shouldNotParseFluxnovaFormDefinitionUnsupportedBinding");

    // when/then expect parse exception
    assertThatThrownBy(() -> repositoryService.createDeployment().name(resource).addClasspathResource(resource).deploy())
      .isInstanceOf(ParseException.class)
      .hasMessageContaining("Invalid element definition: value for formRefBinding attribute has to be one of [deployment, latest, version] but was unsupported");
  }

  @Test
  public void shouldNotParseFluxnovaFormDefinitionAndFormKey() {
    // given a deployed process with a UserTask containing a Camunda Form definition and formKey
    String resource = TestHelper.getBpmnProcessDefinitionResource(getClass(), "shouldNotParseFluxnovaFormDefinitionAndFormKey");

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
