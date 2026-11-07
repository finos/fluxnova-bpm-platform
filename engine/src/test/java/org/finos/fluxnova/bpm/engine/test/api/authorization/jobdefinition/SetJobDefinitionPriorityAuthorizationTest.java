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
package org.finos.fluxnova.bpm.engine.test.api.authorization.jobdefinition;

import static org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationScenario.scenario;
import static org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationSpec.grant;

import java.util.Collection;

import org.finos.fluxnova.bpm.engine.authorization.Permissions;
import org.finos.fluxnova.bpm.engine.authorization.Resources;
import org.finos.fluxnova.bpm.engine.management.JobDefinition;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationScenario;
import org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationTestRule;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.finos.fluxnova.bpm.engine.test.util.ChainedExtension;

/**
 * @author Thorben Lindhauer
 *
 */
public class SetJobDefinitionPriorityAuthorizationTest {

  public ProcessEngineRule engineRule = new ProvidedProcessEngineRule();
  public AuthorizationTestRule authRule = new AuthorizationTestRule(engineRule);

  @RegisterExtension
  public ChainedExtension chain = ChainedExtension.outerExtension(engineRule).around(authRule);
  public AuthorizationScenario scenario;

  public static Collection<AuthorizationScenario[]> scenarios() {
    return AuthorizationTestRule.asParameters(
      scenario()
        .withoutAuthorizations()
        .failsDueToRequired(
          grant(Resources.PROCESS_DEFINITION, "processDefinitionKey", "userId", Permissions.UPDATE)),
      scenario()
        .withAuthorizations(
          grant(Resources.PROCESS_DEFINITION, "processDefinitionKey", "userId", Permissions.UPDATE))
        .succeeds(),
      scenario()
        .withAuthorizations(
          grant(Resources.PROCESS_DEFINITION, "*", "userId", Permissions.UPDATE))
        .succeeds()
      );
  }

  @BeforeEach
  public void setUp() {
    authRule.createUserAndGroup("userId", "groupId");
  }

  @AfterEach
  public void tearDown() {
    authRule.deleteUsersAndGroups();
  }

  @ParameterizedTest(name = "Scenario {index}")
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/api/authorization/oneIncidentProcess.bpmn20.xml")
  @MethodSource("scenarios")
  public void testSetJobDefinitionPriority(AuthorizationScenario scenario) {

    initSetJobDefinitionPriorityAuthorizationTest(scenario);

    // given
    JobDefinition jobDefinition = engineRule.getManagementService().createJobDefinitionQuery().singleResult();

    // when
    authRule
      .init(scenario)
      .withUser("userId")
      .bindResource("processDefinitionKey", "process")
      .start();

    engineRule.getManagementService().setOverridingJobPriorityForJobDefinition(jobDefinition.getId(), 42);

    // then
    if (authRule.assertScenario(scenario)) {
      JobDefinition updatedJobDefinition = engineRule.getManagementService().createJobDefinitionQuery().singleResult();
      Assertions.assertEquals(42, (long) updatedJobDefinition.getOverridingJobPriority());
    }

  }

  @ParameterizedTest(name = "Scenario {index}")
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/api/authorization/oneIncidentProcess.bpmn20.xml")
  @MethodSource("scenarios")
  public void testResetJobDefinitionPriority(AuthorizationScenario scenario) {
    initSetJobDefinitionPriorityAuthorizationTest(scenario);
    // given
    JobDefinition jobDefinition = engineRule.getManagementService().createJobDefinitionQuery().singleResult();
    engineRule.getManagementService().setOverridingJobPriorityForJobDefinition(jobDefinition.getId(), 42);

    // when
    authRule
      .init(scenario)
      .withUser("userId")
      .bindResource("processDefinitionKey", "process")
      .start();

    engineRule.getManagementService().clearOverridingJobPriorityForJobDefinition(jobDefinition.getId());

    // then
    if (authRule.assertScenario(scenario)) {
      JobDefinition updatedJobDefinition = engineRule.getManagementService().createJobDefinitionQuery().singleResult();
      Assertions.assertNull(updatedJobDefinition.getOverridingJobPriority());
    }
  }

  public void initSetJobDefinitionPriorityAuthorizationTest(AuthorizationScenario scenario) {
    this.scenario = scenario;
  }

}
