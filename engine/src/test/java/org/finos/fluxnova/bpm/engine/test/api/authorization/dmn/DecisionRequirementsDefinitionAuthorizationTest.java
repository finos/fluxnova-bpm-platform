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
package org.finos.fluxnova.bpm.engine.test.api.authorization.dmn;

import static org.finos.fluxnova.bpm.engine.authorization.Resources.DECISION_REQUIREMENTS_DEFINITION;
import static org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationScenario.scenario;
import static org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationSpec.grant;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.InputStream;
import java.util.Collection;

import org.finos.fluxnova.bpm.engine.RepositoryService;
import org.finos.fluxnova.bpm.engine.authorization.Permissions;
import org.finos.fluxnova.bpm.engine.repository.DecisionRequirementsDefinition;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationScenario;
import org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationTestRule;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.finos.fluxnova.bpm.engine.test.util.ChainedExtension;

/**
 * 
 * @author Deivarayan Azhagappan
 *
 */

public class DecisionRequirementsDefinitionAuthorizationTest {

  protected static final String DMN_FILE = "org/finos/fluxnova/bpm/engine/test/dmn/deployment/drdDish.dmn11.xml";
  protected static final String DRD_FILE = "org/finos/fluxnova/bpm/engine/test/dmn/deployment/drdDish.png";
 
  protected static final String DEFINITION_KEY = "dish";
 
  public ProcessEngineRule engineRule = new ProvidedProcessEngineRule();
  public AuthorizationTestRule authRule = new AuthorizationTestRule(engineRule);

  protected RepositoryService repositoryService;

  @RegisterExtension
  public ChainedExtension chain = ChainedExtension.outerExtension(engineRule).around(authRule);
  public AuthorizationScenario scenario;

  public static Collection<AuthorizationScenario[]> scenarios() {
    return AuthorizationTestRule.asParameters(
      scenario()
        .withoutAuthorizations()
        .failsDueToRequired(
          grant(DECISION_REQUIREMENTS_DEFINITION, DEFINITION_KEY, "userId", Permissions.READ)),
      scenario()
        .withAuthorizations(
          grant(DECISION_REQUIREMENTS_DEFINITION, DEFINITION_KEY, "userId", Permissions.READ))
          .succeeds(),
      scenario()
          .withAuthorizations(
            grant(DECISION_REQUIREMENTS_DEFINITION, "*", "userId", Permissions.READ))
            .succeeds()
      );
  }

  @BeforeEach
  public void setUp() throws Exception {
    authRule.createUserAndGroup("userId", "groupId");
    repositoryService = engineRule.getRepositoryService();
  }

  @AfterEach
  public void tearDown() {
    authRule.deleteUsersAndGroups();
  }

  @ParameterizedTest(name = "Scenario {index}")
  @Deployment(resources = {DMN_FILE})
  @MethodSource("scenarios")
  public void getDecisionRequirementsDefinition(AuthorizationScenario scenario) {

    initDecisionRequirementsDefinitionAuthorizationTest(scenario);

    String decisionRequirementsDefinitionId = repositoryService
      .createDecisionRequirementsDefinitionQuery()
      .decisionRequirementsDefinitionKey(DEFINITION_KEY)
      .singleResult().getId();
    
    // when
    authRule.init(scenario).withUser("userId").bindResource("decisionRequirementsDefinitionKey", DEFINITION_KEY).start();

    DecisionRequirementsDefinition decisionRequirementsDefinition = repositoryService.getDecisionRequirementsDefinition(decisionRequirementsDefinitionId);

    if (authRule.assertScenario(scenario)) {
      assertNotNull(decisionRequirementsDefinition);
    }
  }

  @ParameterizedTest(name = "Scenario {index}")
  @Deployment(resources = {DMN_FILE})
  @MethodSource("scenarios")
  public void getDecisionRequirementsModel(AuthorizationScenario scenario) {

    initDecisionRequirementsDefinitionAuthorizationTest(scenario);

    // given
    String decisionRequirementsDefinitionId = repositoryService
      .createDecisionRequirementsDefinitionQuery()
      .decisionRequirementsDefinitionKey(DEFINITION_KEY)
      .singleResult().getId();

    // when
    authRule.init(scenario).withUser("userId").bindResource("decisionRequirementsDefinitionKey", DEFINITION_KEY).start();

    InputStream decisionRequirementsModel = repositoryService.getDecisionRequirementsModel(decisionRequirementsDefinitionId);

    if (authRule.assertScenario(scenario)) {
      assertNotNull(decisionRequirementsModel);
    }
  }

  @ParameterizedTest(name = "Scenario {index}")
  @Deployment(resources = {DMN_FILE, DRD_FILE})
  @MethodSource("scenarios")
  public void getDecisionRequirementsDiagram(AuthorizationScenario scenario) {

    initDecisionRequirementsDefinitionAuthorizationTest(scenario);

    // given
    String decisionRequirementsDefinitionId = repositoryService
      .createDecisionRequirementsDefinitionQuery()
      .decisionRequirementsDefinitionKey(DEFINITION_KEY)
      .singleResult().getId();

    // when
    authRule.init(scenario).withUser("userId").bindResource("decisionRequirementsDefinitionKey", DEFINITION_KEY).start();

    InputStream decisionRequirementsDiagram = repositoryService.getDecisionRequirementsDiagram(decisionRequirementsDefinitionId);

    if (authRule.assertScenario(scenario)) {
      assertNotNull(decisionRequirementsDiagram);
    }
  }

  public void initDecisionRequirementsDefinitionAuthorizationTest(AuthorizationScenario scenario) {
    this.scenario = scenario;
  }
}
