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
package org.finos.fluxnova.bpm.engine.test.api.runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.finos.fluxnova.bpm.engine.EntityTypes;
import org.finos.fluxnova.bpm.engine.ExternalTaskService;
import org.finos.fluxnova.bpm.engine.HistoryService;
import org.finos.fluxnova.bpm.engine.ManagementService;
import org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.batch.Batch;
import org.finos.fluxnova.bpm.engine.batch.history.HistoricBatch;
import org.finos.fluxnova.bpm.engine.externaltask.ExternalTask;
import org.finos.fluxnova.bpm.engine.history.UserOperationLogEntry;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.RequiredHistoryLevel;
import org.finos.fluxnova.bpm.engine.test.util.ProcessEngineTestRule;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.finos.fluxnova.bpm.engine.test.util.ChainedExtension;

/**
 * 
 * @author Tobias Metzke
 *
 */
@RequiredHistoryLevel(ProcessEngineConfiguration.HISTORY_FULL)
public class ExternalTaskUserOperationLogTest {

  protected ProcessEngineRule rule = new ProvidedProcessEngineRule();
  protected ProcessEngineTestRule testRule = new ProcessEngineTestRule(rule);

  @RegisterExtension
  public ChainedExtension ruleChain = ChainedExtension.outerExtension(rule).around(testRule);

  private static String PROCESS_DEFINITION_KEY = "oneExternalTaskProcess";
  private static String PROCESS_DEFINITION_KEY_2 = "twoExternalTaskWithPriorityProcess";

  protected RuntimeService runtimeService;
  protected ExternalTaskService externalTaskService;

  @BeforeEach
  public void initServices() {
    runtimeService = rule.getRuntimeService();
    externalTaskService = rule.getExternalTaskService();
  }
  
  @AfterEach
  public void removeAllRunningAndHistoricBatches() {
    HistoryService historyService = rule.getHistoryService();
    ManagementService managementService = rule.getManagementService();
    for (Batch batch : managementService.createBatchQuery().list()) {
      managementService.deleteBatch(batch.getId(), true);
    }
    // remove history of completed batches
    for (HistoricBatch historicBatch : historyService.createHistoricBatchQuery().list()) {
      historyService.deleteHistoricBatch(historicBatch.getId());
    }
  }

  @Test
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/api/externaltask/oneExternalTaskProcess.bpmn20.xml")
  public void testSetRetriesLogCreationForOneExternalTaskId() {
    // given
    runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
    rule.getIdentityService().setAuthenticatedUserId("userId");

    // when
    ExternalTask externalTask = externalTaskService.createExternalTaskQuery().singleResult();
    externalTaskService.setRetries(externalTask.getId(), 5);
    rule.getIdentityService().clearAuthentication();
    // then
    List<UserOperationLogEntry> opLogEntries = rule.getHistoryService().createUserOperationLogQuery().list();
    Assertions.assertEquals(1, opLogEntries.size());

    Map<String, UserOperationLogEntry> entries = asMap(opLogEntries);

    UserOperationLogEntry retriesEntry = entries.get("retries");
    Assertions.assertNotNull(retriesEntry);
    Assertions.assertEquals(EntityTypes.EXTERNAL_TASK, retriesEntry.getEntityType());
    Assertions.assertEquals("SetExternalTaskRetries", retriesEntry.getOperationType());
    Assertions.assertEquals(externalTask.getId(), retriesEntry.getExternalTaskId());
    Assertions.assertEquals(externalTask.getProcessInstanceId(), retriesEntry.getProcessInstanceId());
    Assertions.assertEquals(externalTask.getProcessDefinitionId(), retriesEntry.getProcessDefinitionId());
    Assertions.assertEquals(externalTask.getProcessDefinitionKey(), retriesEntry.getProcessDefinitionKey());
    Assertions.assertNull(retriesEntry.getOrgValue());
    Assertions.assertEquals("5", retriesEntry.getNewValue());
    Assertions.assertEquals(UserOperationLogEntry.CATEGORY_OPERATOR, retriesEntry.getCategory());
  }

  @Test
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/api/externaltask/oneExternalTaskProcess.bpmn20.xml")
  public void testSetRetriesLogCreationSync() {
    // given
    runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
    runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
    
    List<ExternalTask> list = externalTaskService.createExternalTaskQuery().list();
    List<String> externalTaskIds = new ArrayList<String>();

    for (ExternalTask task : list) {
      externalTaskIds.add(task.getId());
    }

    // when
    rule.getIdentityService().setAuthenticatedUserId("userId");
    externalTaskService.setRetries(externalTaskIds, 5);
    rule.getIdentityService().clearAuthentication();
    // then
    List<UserOperationLogEntry> opLogEntries = rule.getHistoryService().createUserOperationLogQuery().list();
    Assertions.assertEquals(3, opLogEntries.size());

    Map<String, UserOperationLogEntry> entries = asMap(opLogEntries);

    UserOperationLogEntry asyncEntry = entries.get("async");
    Assertions.assertNotNull(asyncEntry);
    Assertions.assertEquals(EntityTypes.EXTERNAL_TASK, asyncEntry.getEntityType());
    Assertions.assertEquals("SetExternalTaskRetries", asyncEntry.getOperationType());
    Assertions.assertNull(asyncEntry.getExternalTaskId());
    Assertions.assertNull(asyncEntry.getProcessDefinitionId());
    Assertions.assertNull(asyncEntry.getProcessDefinitionKey());
    Assertions.assertNull(asyncEntry.getProcessInstanceId());
    Assertions.assertNull(asyncEntry.getOrgValue());
    Assertions.assertEquals("false", asyncEntry.getNewValue());
    Assertions.assertEquals(UserOperationLogEntry.CATEGORY_OPERATOR, asyncEntry.getCategory());

    UserOperationLogEntry numInstancesEntry = entries.get("nrOfInstances");
    Assertions.assertNotNull(numInstancesEntry);
    Assertions.assertEquals(EntityTypes.EXTERNAL_TASK, numInstancesEntry.getEntityType());
    Assertions.assertEquals("SetExternalTaskRetries", numInstancesEntry.getOperationType());
    Assertions.assertNull(numInstancesEntry.getExternalTaskId());
    Assertions.assertNull(numInstancesEntry.getProcessDefinitionId());
    Assertions.assertNull(numInstancesEntry.getProcessDefinitionKey());
    Assertions.assertNull(numInstancesEntry.getProcessInstanceId());
    Assertions.assertNull(numInstancesEntry.getOrgValue());
    Assertions.assertEquals("2", numInstancesEntry.getNewValue());
    Assertions.assertEquals(UserOperationLogEntry.CATEGORY_OPERATOR, numInstancesEntry.getCategory());

    UserOperationLogEntry retriesEntry = entries.get("retries");
    Assertions.assertNotNull(retriesEntry);
    Assertions.assertEquals(EntityTypes.EXTERNAL_TASK, retriesEntry.getEntityType());
    Assertions.assertEquals("SetExternalTaskRetries", retriesEntry.getOperationType());
    Assertions.assertNull(retriesEntry.getExternalTaskId());
    Assertions.assertNull(retriesEntry.getProcessDefinitionId());
    Assertions.assertNull(retriesEntry.getProcessDefinitionKey());
    Assertions.assertNull(retriesEntry.getProcessInstanceId());
    Assertions.assertNull(retriesEntry.getOrgValue());
    Assertions.assertEquals("5", retriesEntry.getNewValue());
    Assertions.assertEquals(asyncEntry.getOperationId(), retriesEntry.getOperationId());
    Assertions.assertEquals(UserOperationLogEntry.CATEGORY_OPERATOR, retriesEntry.getCategory());
  }

  @Test
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/api/externaltask/oneExternalTaskProcess.bpmn20.xml")
  public void testSetRetriesLogCreationAsync() {
    // given
    runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
    runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);

    // when
    rule.getIdentityService().setAuthenticatedUserId("userId");
    externalTaskService.setRetriesAsync(null, externalTaskService.createExternalTaskQuery(), 5);
    rule.getIdentityService().clearAuthentication();
    // then
    List<UserOperationLogEntry> opLogEntries = rule.getHistoryService().createUserOperationLogQuery().list();
    Assertions.assertEquals(3, opLogEntries.size());

    Map<String, UserOperationLogEntry> entries = asMap(opLogEntries);

    UserOperationLogEntry asyncEntry = entries.get("async");
    Assertions.assertNotNull(asyncEntry);
    Assertions.assertEquals(EntityTypes.EXTERNAL_TASK, asyncEntry.getEntityType());
    Assertions.assertEquals("SetExternalTaskRetries", asyncEntry.getOperationType());
    Assertions.assertNull(asyncEntry.getExternalTaskId());
    Assertions.assertNull(asyncEntry.getProcessDefinitionId());
    Assertions.assertNull(asyncEntry.getProcessDefinitionKey());
    Assertions.assertNull(asyncEntry.getProcessInstanceId());
    Assertions.assertNull(asyncEntry.getOrgValue());
    Assertions.assertEquals("true", asyncEntry.getNewValue());
    Assertions.assertEquals(UserOperationLogEntry.CATEGORY_OPERATOR, asyncEntry.getCategory());

    UserOperationLogEntry numInstancesEntry = entries.get("nrOfInstances");
    Assertions.assertNotNull(numInstancesEntry);
    Assertions.assertEquals(EntityTypes.EXTERNAL_TASK, numInstancesEntry.getEntityType());
    Assertions.assertEquals("SetExternalTaskRetries", numInstancesEntry.getOperationType());
    Assertions.assertNull(numInstancesEntry.getExternalTaskId());
    Assertions.assertNull(numInstancesEntry.getProcessDefinitionId());
    Assertions.assertNull(numInstancesEntry.getProcessDefinitionKey());
    Assertions.assertNull(numInstancesEntry.getProcessInstanceId());
    Assertions.assertNull(numInstancesEntry.getOrgValue());
    Assertions.assertEquals("2", numInstancesEntry.getNewValue());
    Assertions.assertEquals(UserOperationLogEntry.CATEGORY_OPERATOR, numInstancesEntry.getCategory());

    UserOperationLogEntry retriesEntry = entries.get("retries");
    Assertions.assertNotNull(retriesEntry);
    Assertions.assertEquals(EntityTypes.EXTERNAL_TASK, retriesEntry.getEntityType());
    Assertions.assertEquals("SetExternalTaskRetries", retriesEntry.getOperationType());
    Assertions.assertNull(retriesEntry.getExternalTaskId());
    Assertions.assertNull(retriesEntry.getProcessDefinitionId());
    Assertions.assertNull(retriesEntry.getProcessDefinitionKey());
    Assertions.assertNull(retriesEntry.getProcessInstanceId());
    Assertions.assertNull(retriesEntry.getOrgValue());
    Assertions.assertEquals("5", retriesEntry.getNewValue());
    Assertions.assertEquals(asyncEntry.getOperationId(), retriesEntry.getOperationId());
    Assertions.assertEquals(UserOperationLogEntry.CATEGORY_OPERATOR, retriesEntry.getCategory());
  }
  
  @Test
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/api/externaltask/externalTaskPriorityExpression.bpmn20.xml")
  public void testSetPriorityLogCreation() {
    // given
    runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY_2, Collections.<String, Object>singletonMap("priority", 14));
    ExternalTask externalTask = externalTaskService.createExternalTaskQuery().priorityHigherThanOrEquals(1).singleResult();
    
    // when
    rule.getIdentityService().setAuthenticatedUserId("userId");
    externalTaskService.setPriority(externalTask.getId(), 78L);
    rule.getIdentityService().clearAuthentication();
    
    // then
    List<UserOperationLogEntry> opLogEntries = rule.getHistoryService().createUserOperationLogQuery().list();
    Assertions.assertEquals(1, opLogEntries.size());

    UserOperationLogEntry entry = opLogEntries.get(0);
    Assertions.assertNotNull(entry);
    Assertions.assertEquals(EntityTypes.EXTERNAL_TASK, entry.getEntityType());
    Assertions.assertEquals(UserOperationLogEntry.OPERATION_TYPE_SET_PRIORITY, entry.getOperationType());
    Assertions.assertEquals(externalTask.getId(), entry.getExternalTaskId());
    Assertions.assertEquals(externalTask.getProcessInstanceId(), entry.getProcessInstanceId());
    Assertions.assertEquals(externalTask.getProcessDefinitionId(), entry.getProcessDefinitionId());
    Assertions.assertEquals(externalTask.getProcessDefinitionKey(), entry.getProcessDefinitionKey());
    Assertions.assertEquals("priority", entry.getProperty());
    Assertions.assertEquals("14", entry.getOrgValue());
    Assertions.assertEquals("78", entry.getNewValue());
    Assertions.assertEquals(UserOperationLogEntry.CATEGORY_OPERATOR, entry.getCategory());
  }
  
  @Test
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/api/externaltask/oneExternalTaskProcess.bpmn20.xml")
  public void testUnlockLogCreation() {
    // given
    runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY);
    ExternalTask externalTask = externalTaskService.createExternalTaskQuery().singleResult();
    externalTaskService.fetchAndLock(1, "aWorker").topic(externalTask.getTopicName(), 3000L).execute();
    
    // when
    rule.getIdentityService().setAuthenticatedUserId("userId");
    externalTaskService.unlock(externalTask.getId());
    rule.getIdentityService().clearAuthentication();
    
    // then
    List<UserOperationLogEntry> opLogEntries = rule.getHistoryService().createUserOperationLogQuery().list();
    Assertions.assertEquals(1, opLogEntries.size());

    UserOperationLogEntry entry = opLogEntries.get(0);
    Assertions.assertNotNull(entry);
    Assertions.assertEquals(EntityTypes.EXTERNAL_TASK, entry.getEntityType());
    Assertions.assertEquals(UserOperationLogEntry.OPERATION_TYPE_UNLOCK, entry.getOperationType());
    Assertions.assertEquals(externalTask.getId(), entry.getExternalTaskId());
    Assertions.assertEquals(externalTask.getProcessInstanceId(), entry.getProcessInstanceId());
    Assertions.assertEquals(externalTask.getProcessDefinitionId(), entry.getProcessDefinitionId());
    Assertions.assertEquals(externalTask.getProcessDefinitionKey(), entry.getProcessDefinitionKey());
    Assertions.assertNull(entry.getProperty());
    Assertions.assertNull(entry.getOrgValue());
    Assertions.assertNull(entry.getNewValue());
    Assertions.assertEquals(UserOperationLogEntry.CATEGORY_OPERATOR, entry.getCategory());
  }

  protected Map<String, UserOperationLogEntry> asMap(List<UserOperationLogEntry> logEntries) {
    Map<String, UserOperationLogEntry> map = new HashMap<String, UserOperationLogEntry>();

    for (UserOperationLogEntry entry : logEntries) {

      UserOperationLogEntry previousValue = map.put(entry.getProperty(), entry);
      if (previousValue != null) {
        Assertions.fail("expected only entry for every property");
      }
    }

    return map;
  }
}
