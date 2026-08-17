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
package org.finos.fluxnova.bpm.engine.test.api.authorization.batch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationSpec.grant;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.finos.fluxnova.bpm.engine.EntityTypes;
import org.finos.fluxnova.bpm.engine.HistoryService;
import org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration;
import org.finos.fluxnova.bpm.engine.authorization.BatchPermissions;
import org.finos.fluxnova.bpm.engine.authorization.Permissions;
import org.finos.fluxnova.bpm.engine.authorization.Resources;
import org.finos.fluxnova.bpm.engine.batch.Batch;
import org.finos.fluxnova.bpm.engine.batch.history.HistoricBatch;
import org.finos.fluxnova.bpm.engine.history.HistoricProcessInstance;
import org.finos.fluxnova.bpm.engine.test.RequiredHistoryLevel;
import org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationScenario;
import org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationScenarioWithCount;
import org.finos.fluxnova.bpm.engine.test.api.authorization.util.AuthorizationTestRule;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.finos.fluxnova.bpm.engine.test.util.ChainedExtension;

/**
 * @author Askar Akhmerov
 */
@RequiredHistoryLevel(ProcessEngineConfiguration.HISTORY_AUDIT)
public class DeleteHistoricProcessInstancesBatchAuthorizationTest extends AbstractBatchAuthorizationTest {

  protected static final long BATCH_OPERATIONS = 3;
  @RegisterExtension
  public ChainedExtension ruleChain = ChainedExtension.outerExtension(engineRule).around(authRule).around(testHelper);
  public AuthorizationScenarioWithCount scenario;

  protected HistoryService historyService;

  @BeforeEach
  public void setupHistoricService() {
    historyService = engineRule.getHistoryService();
  }

  @AfterEach
  public void cleanBatch() {
    super.cleanBatch();
    List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().list();

    if (list.size() > 0) {
      List<String> instances = new ArrayList<>();
      for (HistoricProcessInstance hpi : list) {
        instances.add(hpi.getId());
      }
      historyService.deleteHistoricProcessInstances(instances);
    }
  }

  public static Collection<AuthorizationScenario[]> scenarios() {
    return AuthorizationTestRule.asParameters(
        AuthorizationScenarioWithCount.scenario()
            .withCount(1L)
            .withAuthorizations(
                grant(Resources.BATCH, "*", "userId", Permissions.CREATE),
                grant(Resources.PROCESS_DEFINITION, "Process_1", "userId", Permissions.READ_HISTORY, Permissions.DELETE_HISTORY),
                grant(Resources.PROCESS_DEFINITION, "Process_2", "userId", Permissions.READ_HISTORY)
            )
            .failsDueToRequired(
                grant(Resources.PROCESS_DEFINITION, "Process_2", "userId", Permissions.DELETE_HISTORY)
            ),
        AuthorizationScenarioWithCount.scenario()
            .withCount(0L)
            .withAuthorizations(
                grant(Resources.BATCH, "*", "userId", Permissions.CREATE),
                grant(Resources.PROCESS_DEFINITION, "Process_1", "userId", Permissions.READ_HISTORY, Permissions.DELETE_HISTORY),
                grant(Resources.PROCESS_DEFINITION, "Process_2", "userId", Permissions.READ_HISTORY, Permissions.DELETE_HISTORY)
            ),
        AuthorizationScenarioWithCount.scenario()
            .withCount(0L)
            .withAuthorizations(
                grant(Resources.BATCH, "*", "userId", BatchPermissions.CREATE_BATCH_DELETE_FINISHED_PROCESS_INSTANCES),
                grant(Resources.PROCESS_DEFINITION, "Process_1", "userId", Permissions.READ_HISTORY, Permissions.DELETE_HISTORY),
                grant(Resources.PROCESS_DEFINITION, "Process_2", "userId", Permissions.READ_HISTORY, Permissions.DELETE_HISTORY)
            ).succeeds()
    );
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testWithTwoInvocationsProcessInstancesList(AuthorizationScenarioWithCount scenario) {
    initDeleteHistoricProcessInstancesBatchAuthorizationTest(scenario);
    engineRule.getProcessEngineConfiguration().setInvocationsPerBatchJob(2);
    setupAndExecuteHistoricProcessInstancesListTest();

    // then
    assertScenario();

    assertThat(historyService.createHistoricProcessInstanceQuery().count()).isEqualTo(getScenario().getCount());
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Scenario {index}")
  public void testProcessInstancesList(AuthorizationScenarioWithCount scenario) {
    initDeleteHistoricProcessInstancesBatchAuthorizationTest(scenario);
    setupAndExecuteHistoricProcessInstancesListTest();
    // then
    assertScenario();
  }

  protected void setupAndExecuteHistoricProcessInstancesListTest() {
    //given
    List<String> processInstanceIds = Arrays.asList(processInstance.getId(), processInstance2.getId());
    runtimeService.deleteProcessInstances(processInstanceIds, null, true, false);

    List<String> historicProcessInstances = new ArrayList<>();
    for (HistoricProcessInstance hpi : historyService.createHistoricProcessInstanceQuery().list()) {
      historicProcessInstances.add(hpi.getId());
    }

    authRule
        .init(scenario)
        .withUser("userId")
        .bindResource("Process_1", sourceDefinition.getKey())
        .bindResource("Process_2", sourceDefinition2.getKey())
        .start();

    // when
    batch = historyService.deleteHistoricProcessInstancesAsync(
        historicProcessInstances, TEST_REASON);

    executeSeedAndBatchJobs();
  }

  @Override
  public AuthorizationScenarioWithCount getScenario() {
    return scenario;
  }

  protected void assertScenario() {
    if (authRule.assertScenario(getScenario())) {
      Batch batch = engineRule.getManagementService().createBatchQuery().singleResult();
      assertEquals("userId", batch.getCreateUserId());

      if (testHelper.isHistoryLevelFull()) {
        assertThat(engineRule.getHistoryService().createUserOperationLogQuery().entityType(EntityTypes.PROCESS_INSTANCE).count()).isEqualTo(BATCH_OPERATIONS);
        HistoricBatch historicBatch = engineRule.getHistoryService().createHistoricBatchQuery().list().get(0);
        assertEquals("userId", historicBatch.getCreateUserId());
      }
      assertThat(historyService.createHistoricProcessInstanceQuery().count()).isEqualTo(0L);
    }
  }

  public void initDeleteHistoricProcessInstancesBatchAuthorizationTest(AuthorizationScenarioWithCount scenario) {
    this.scenario = scenario;
  }
}
