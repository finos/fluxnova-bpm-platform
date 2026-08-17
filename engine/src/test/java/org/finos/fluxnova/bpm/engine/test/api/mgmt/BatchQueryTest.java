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
package org.finos.fluxnova.bpm.engine.test.api.mgmt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.finos.fluxnova.bpm.engine.test.api.runtime.TestOrderingUtil.batchById;
import static org.finos.fluxnova.bpm.engine.test.api.runtime.TestOrderingUtil.inverted;
import static org.finos.fluxnova.bpm.engine.test.api.runtime.TestOrderingUtil.verifySorting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.finos.fluxnova.bpm.engine.HistoryService;
import org.finos.fluxnova.bpm.engine.ManagementService;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.batch.Batch;
import org.finos.fluxnova.bpm.engine.batch.BatchQuery;
import org.finos.fluxnova.bpm.engine.exception.NotValidException;
import org.finos.fluxnova.bpm.engine.exception.NullValueException;
import org.finos.fluxnova.bpm.engine.impl.util.ClockUtil;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.api.runtime.migration.MigrationTestRule;
import org.finos.fluxnova.bpm.engine.test.api.runtime.migration.batch.BatchMigrationHelper;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.finos.fluxnova.bpm.engine.test.util.ChainedExtension;

/**
 * @author Thorben Lindhauer
 *
 */
public class BatchQueryTest {

  protected ProcessEngineRule engineRule = new ProvidedProcessEngineRule();
  protected MigrationTestRule migrationRule = new MigrationTestRule(engineRule);
  protected BatchMigrationHelper helper = new BatchMigrationHelper(engineRule, migrationRule);

  @RegisterExtension
  public ChainedExtension ruleChain = ChainedExtension.outerExtension(engineRule).around(migrationRule);

  protected RuntimeService runtimeService;
  protected ManagementService managementService;
  protected HistoryService historyService;

  @BeforeEach
  public void initServices() {
    runtimeService = engineRule.getRuntimeService();
    managementService = engineRule.getManagementService();
    historyService = engineRule.getHistoryService();
  }

  @AfterEach
  public void removeBatches() {
    helper.removeAllRunningAndHistoricBatches();
    ClockUtil.reset();
  }

  @Test
  public void testBatchQuery() {
    // given
    Batch batch1 = helper.migrateProcessInstancesAsync(1);
    Batch batch2 = helper.migrateProcessInstancesAsync(1);

    // when
    List<Batch> list = managementService.createBatchQuery().list();

    // then
    org.junit.jupiter.api.Assertions.assertEquals(2, list.size());

    List<String> batchIds = new ArrayList<>();
    for (Batch resultBatch : list) {
      batchIds.add(resultBatch.getId());
    }

    org.junit.jupiter.api.Assertions.assertTrue(batchIds.contains(batch1.getId()));
    org.junit.jupiter.api.Assertions.assertTrue(batchIds.contains(batch2.getId()));
  }

  @Test
  public void testBatchQueryResult() {
    // given
    ClockUtil.setCurrentTime(new Date());
    Batch batch = helper.migrateProcessInstancesAsync(1);

    // when
    Batch resultBatch = managementService.createBatchQuery().singleResult();

    // then
    org.junit.jupiter.api.Assertions.assertNotNull(batch);

    org.junit.jupiter.api.Assertions.assertEquals(batch.getId(), resultBatch.getId());
    org.junit.jupiter.api.Assertions.assertEquals(batch.getBatchJobDefinitionId(), resultBatch.getBatchJobDefinitionId());
    org.junit.jupiter.api.Assertions.assertEquals(batch.getMonitorJobDefinitionId(), resultBatch.getMonitorJobDefinitionId());
    org.junit.jupiter.api.Assertions.assertEquals(batch.getSeedJobDefinitionId(), resultBatch.getSeedJobDefinitionId());
    org.junit.jupiter.api.Assertions.assertEquals(batch.getTenantId(), resultBatch.getTenantId());
    org.junit.jupiter.api.Assertions.assertEquals(batch.getType(), resultBatch.getType());
    org.junit.jupiter.api.Assertions.assertEquals(batch.getBatchJobsPerSeed(), resultBatch.getBatchJobsPerSeed());
    org.junit.jupiter.api.Assertions.assertEquals(batch.getInvocationsPerBatchJob(), resultBatch.getInvocationsPerBatchJob());
    org.junit.jupiter.api.Assertions.assertEquals(batch.getTotalJobs(), resultBatch.getTotalJobs());
    org.junit.jupiter.api.Assertions.assertEquals(batch.getJobsCreated(), resultBatch.getJobsCreated());
    org.junit.jupiter.api.Assertions.assertEquals(batch.isSuspended(), resultBatch.isSuspended());
    Assertions.assertThat(batch.getStartTime()).isEqualToIgnoringMillis(resultBatch.getStartTime());
    Assertions.assertThat(batch.getStartTime()).isEqualToIgnoringMillis(ClockUtil.getCurrentTime());
  }

  @Test
  public void testBatchQueryById() {
    // given
    Batch batch1 = helper.migrateProcessInstancesAsync(1);
    helper.migrateProcessInstancesAsync(1);

    // when
    Batch resultBatch = managementService.createBatchQuery().batchId(batch1.getId()).singleResult();

    // then
    org.junit.jupiter.api.Assertions.assertNotNull(resultBatch);
    org.junit.jupiter.api.Assertions.assertEquals(batch1.getId(), resultBatch.getId());
  }

  @Test
  public void testBatchQueryByIdNull() {
    try {
      managementService.createBatchQuery().batchId(null).singleResult();
      org.junit.jupiter.api.Assertions.fail("exception expected");
    }
    catch (NullValueException e) {
      assertThat(e.getMessage()).contains("Batch id is null");
    }
  }

  @Test
  public void testBatchQueryByType() {
    // given
    Batch batch1 = helper.migrateProcessInstancesAsync(1);
    helper.migrateProcessInstancesAsync(1);

    // when
    long count = managementService.createBatchQuery().type(batch1.getType()).count();

    // then
    org.junit.jupiter.api.Assertions.assertEquals(2, count);
  }

  @Test
  public void testBatchQueryByNonExistingType() {
    // given
    helper.migrateProcessInstancesAsync(1);

    // when
    long count = managementService.createBatchQuery().type("foo").count();

    // then
    org.junit.jupiter.api.Assertions.assertEquals(0, count);
  }

  @Test
  public void testBatchQueryByTypeNull() {
    try {
      managementService.createBatchQuery().type(null).singleResult();
      org.junit.jupiter.api.Assertions.fail("exception expected");
    }
    catch (NullValueException e) {
      assertThat(e.getMessage()).contains("Type is null");
    }
  }

  @Test
  public void testBatchQueryCount() {
    // given
    helper.migrateProcessInstancesAsync(1);
    helper.migrateProcessInstancesAsync(1);

    // when
    long count = managementService.createBatchQuery().count();

    // then
    org.junit.jupiter.api.Assertions.assertEquals(2, count);
  }

  @Test
  public void testBatchQueryOrderByIdAsc() {
    // given
    helper.migrateProcessInstancesAsync(1);
    helper.migrateProcessInstancesAsync(1);

    // when
    List<Batch> orderedBatches = managementService.createBatchQuery().orderById().asc().list();

    // then
    verifySorting(orderedBatches, batchById());
  }

  @Test
  public void testBatchQueryOrderByIdDec() {
    // given
    helper.migrateProcessInstancesAsync(1);
    helper.migrateProcessInstancesAsync(1);

    // when
    List<Batch> orderedBatches = managementService.createBatchQuery().orderById().desc().list();

    // then
    verifySorting(orderedBatches, inverted(batchById()));
  }

  @Test
  public void testBatchQueryOrderingPropertyWithoutOrder() {
    try {
      managementService.createBatchQuery().orderById().singleResult();
      org.junit.jupiter.api.Assertions.fail("exception expected");
    }
    catch (NotValidException e) {
      assertThat(e.getMessage()).contains("Invalid query: "
          + "call asc() or desc() after using orderByXX()");
    }
  }

  @Test
  public void testBatchQueryOrderWithoutOrderingProperty() {
    try {
      managementService.createBatchQuery().asc().singleResult();
      org.junit.jupiter.api.Assertions.fail("exception expected");
    }
    catch (NotValidException e) {
      assertThat(e.getMessage()).contains("You should call any of the orderBy methods "
          + "first before specifying a direction");
    }
  }

  @Test
  public void testBatchQueryBySuspendedBatches() {
    // given
    Batch batch1 = helper.migrateProcessInstancesAsync(1);
    Batch batch2 = helper.migrateProcessInstancesAsync(1);
    helper.migrateProcessInstancesAsync(1);

    // when
    managementService.suspendBatchById(batch1.getId());
    managementService.suspendBatchById(batch2.getId());
    managementService.activateBatchById(batch1.getId());

    // then
    BatchQuery query = managementService.createBatchQuery().suspended();
    org.junit.jupiter.api.Assertions.assertEquals(1, query.count());
    org.junit.jupiter.api.Assertions.assertEquals(1, query.list().size());
    org.junit.jupiter.api.Assertions.assertEquals(batch2.getId(), query.singleResult().getId());
  }

  @Test
  public void testBatchQueryByActiveBatches() {
    // given
    Batch batch1 = helper.migrateProcessInstancesAsync(1);
    Batch batch2 = helper.migrateProcessInstancesAsync(1);
    Batch batch3 = helper.migrateProcessInstancesAsync(1);

    // when
    managementService.suspendBatchById(batch1.getId());
    managementService.suspendBatchById(batch2.getId());
    managementService.activateBatchById(batch1.getId());

    // then
    BatchQuery query = managementService.createBatchQuery().active();
    org.junit.jupiter.api.Assertions.assertEquals(2, query.count());
    org.junit.jupiter.api.Assertions.assertEquals(2, query.list().size());

    List<String> foundIds = new ArrayList<>();
    for (Batch batch : query.list()) {
      foundIds.add(batch.getId());
    }
    assertThat(foundIds).contains(
      batch1.getId(),
      batch3.getId()
    );
  }

}
