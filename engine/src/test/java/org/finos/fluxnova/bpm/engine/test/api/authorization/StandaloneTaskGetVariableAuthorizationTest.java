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
package org.finos.fluxnova.bpm.engine.test.api.authorization;

import static org.finos.fluxnova.bpm.engine.authorization.Resources.TASK;
import static org.finos.fluxnova.bpm.engine.authorization.TaskPermissions.READ_VARIABLE;
import static org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationScenario.scenario;
import static org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationSpec.grant;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.finos.fluxnova.bpm.engine.AuthorizationService;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.TaskService;
import org.finos.fluxnova.bpm.engine.authorization.Authorization;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationScenario;
import org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationTestRule;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.finos.fluxnova.bpm.engine.variable.VariableMap;
import org.finos.fluxnova.bpm.engine.variable.Variables;
import org.finos.fluxnova.bpm.engine.variable.value.TypedValue;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.finos.fluxnova.bpm.engine.test.util.ChainedExtension;

/**
 * @author Yana.Vasileva
 *
 */
public class StandaloneTaskGetVariableAuthorizationTest {

  public ProcessEngineRule engineRule = new ProvidedProcessEngineRule();
  public AuthorizationTestRule authRule = new AuthorizationTestRule(engineRule);

  @RegisterExtension
  public ChainedExtension chain = ChainedExtension.outerExtension(engineRule).around(authRule);
  public AuthorizationScenario scenario;

  protected ProcessEngineConfigurationImpl processEngineConfiguration;
  protected TaskService taskService;
  protected RuntimeService runtimeService;

  protected static final String userId = "userId";
  protected String taskId = "myTask";
  protected static final String VARIABLE_NAME = "aVariableName";
  protected static final String VARIABLE_VALUE = "aVariableValue";
  protected static final String PROCESS_KEY = "oneTaskProcess";
  protected boolean ensureSpecificVariablePermission;

  public static Collection<AuthorizationScenario[]> scenarios() {
    return AuthorizationTestRule.asParameters(
      scenario()
        .withoutAuthorizations()
        .failsDueToRequired(
          grant(TASK, "taskId", userId, READ_VARIABLE)),
      scenario()
        .withAuthorizations(
          grant(TASK, "taskId", userId, READ_VARIABLE)),
      scenario()
        .withAuthorizations(
          grant(TASK, "*", userId, READ_VARIABLE))
        .succeeds()
      );
  }

  @BeforeEach
  public void setUp() {
    processEngineConfiguration = engineRule.getProcessEngineConfiguration();
    taskService = engineRule.getTaskService();
    runtimeService = engineRule.getRuntimeService();

    authRule.createUserAndGroup("userId", "groupId");
    ensureSpecificVariablePermission = processEngineConfiguration.isEnforceSpecificVariablePermission();
    // prerequisite of the whole test suite
    processEngineConfiguration.setEnforceSpecificVariablePermission(true);
  }

  @AfterEach
  public void tearDown() {
    authRule.deleteUsersAndGroups();
    taskService.deleteTask(taskId, true);
    processEngineConfiguration.setEnforceSpecificVariablePermission(ensureSpecificVariablePermission);
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariable(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    // given
    createTask(taskId);

    taskService.setVariables(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    Object variable = taskService.getVariable(taskId, VARIABLE_NAME);

    // then
    if (authRule.assertScenario(scenario)) {
      assertEquals(VARIABLE_VALUE, variable);
      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariableLocal(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    // given
    createTask(taskId);

    taskService.setVariablesLocal(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    Object variable = taskService.getVariableLocal(taskId, VARIABLE_NAME);

    // then
    if (authRule.assertScenario(scenario)) {
      assertEquals(VARIABLE_VALUE, variable);
      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariableTyped(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    // given
    createTask(taskId);

    taskService.setVariables(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    TypedValue typedValue = taskService.getVariableTyped(taskId, VARIABLE_NAME);

    // then
    if (authRule.assertScenario(scenario)) {
      assertNotNull(typedValue);
      assertEquals(VARIABLE_VALUE, typedValue.getValue());
      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariableLocalTyped(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    // given
    createTask(taskId);

    taskService.setVariablesLocal(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    TypedValue typedValue = taskService.getVariableLocalTyped(taskId, VARIABLE_NAME);

    // then
    if (authRule.assertScenario(scenario)) {
      assertNotNull(typedValue);
      assertEquals(VARIABLE_VALUE, typedValue.getValue());
      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariables(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    // given
    createTask(taskId);

    taskService.setVariables(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    Map<String, Object> variables = taskService.getVariables(taskId);

    // then
    if (authRule.assertScenario(scenario)) {
      verifyGetVariables(variables);

      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariablesLocal(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    // given
    createTask(taskId);

    taskService.setVariablesLocal(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    Map<String, Object> variables = taskService.getVariablesLocal(taskId);

    // then
    if (authRule.assertScenario(scenario)) {
      verifyGetVariables(variables);

      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariablesTyped(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    createTask(taskId);

    taskService.setVariables(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    VariableMap variables = taskService.getVariablesTyped(taskId);

    // then
    if (authRule.assertScenario(scenario)) {
      verifyGetVariables(variables);

      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariablesLocalTyped(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    createTask(taskId);

    taskService.setVariablesLocal(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    VariableMap variables = taskService.getVariablesLocalTyped(taskId);

    // then
    if (authRule.assertScenario(scenario)) {
      verifyGetVariables(variables);

      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariablesByName(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    // given
    createTask(taskId);

    taskService.setVariables(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    Map<String, Object> variables = taskService.getVariables(taskId, Arrays.asList(VARIABLE_NAME));

    // then
    if (authRule.assertScenario(scenario)) {
      verifyGetVariables(variables);

      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariablesLocalByName(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    // given
    createTask(taskId);

    taskService.setVariablesLocal(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    Map<String, Object> variables = taskService.getVariablesLocal(taskId, Arrays.asList(VARIABLE_NAME));

    // then
    if (authRule.assertScenario(scenario)) {
      verifyGetVariables(variables);

      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariablesTypedByName(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    createTask(taskId);

    taskService.setVariables(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    VariableMap variables = taskService.getVariablesTyped(taskId, Arrays.asList(VARIABLE_NAME), false);

    // then
    if (authRule.assertScenario(scenario)) {
      verifyGetVariables(variables);

      deleteAuthorizations();
    }
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testGetVariablesLocalTypedByName(AuthorizationScenario scenario) {
    initStandaloneTaskGetVariableAuthorizationTest(scenario);
    createTask(taskId);

    taskService.setVariablesLocal(taskId, getVariables());

    // when
    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("taskId", taskId)
        .start();

    VariableMap variables = taskService.getVariablesLocalTyped(taskId, Arrays.asList(VARIABLE_NAME), false);

    // then
    if (authRule.assertScenario(scenario)) {
      verifyGetVariables(variables);

      deleteAuthorizations();
    }
  }

  protected void createTask(final String taskId) {
    Task task = taskService.newTask(taskId);
    taskService.saveTask(task);
  }

  protected VariableMap getVariables() {
    return Variables.createVariables().putValue(VARIABLE_NAME, VARIABLE_VALUE);
  }

  protected void deleteAuthorizations() {
    AuthorizationService authorizationService = engineRule.getAuthorizationService();
    for (Authorization authorization : authorizationService.createAuthorizationQuery().list()) {
      authorizationService.deleteAuthorization(authorization.getId());
    }
  }

  protected void verifyGetVariables(Map<String, Object> variables) {
    assertNotNull(variables);
    assertFalse(variables.isEmpty());
    assertEquals(1, variables.size());
    assertEquals(VARIABLE_VALUE, variables.get(VARIABLE_NAME));
  }

  public void initStandaloneTaskGetVariableAuthorizationTest(AuthorizationScenario scenario) {
    this.scenario = scenario;
  }

}
