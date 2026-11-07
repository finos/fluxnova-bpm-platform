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
package org.finos.fluxnova.bpm.engine.test.jobexecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.finos.fluxnova.bpm.engine.impl.persistence.entity.AcquirableJobEntity;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.util.ClockTestUtil;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class JobExecutorAcquireJobsDefaultTest extends AbstractJobExecutorAcquireJobsTest {
  public boolean ensureJobDueDateSet;
  public Date currentTime;

  public static Collection<Object[]> scenarios() throws ParseException {
    return Arrays.asList(new Object[][] {
      { false, null },
      { true, ClockTestUtil.setClockToDateWithoutMilliseconds() }
    });
  }

  @MethodSource("scenarios")
  @ParameterizedTest(name = "Job DueDate is set: {0}")
  public void testProcessEngineConfiguration(boolean ensureJobDueDateSet, Date currentTime) {
    initJobExecutorAcquireJobsDefaultTest(ensureJobDueDateSet, currentTime);
    assertFalse(configuration.isJobExecutorPreferTimerJobs());
    assertFalse(configuration.isJobExecutorAcquireByDueDate());
    assertEquals(ensureJobDueDateSet, configuration.isEnsureJobDueDateNotNull());
  }

  @ParameterizedTest(name = "Job DueDate is set: {0}")
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/jobexecutor/simpleAsyncProcess.bpmn20.xml")
  @MethodSource("scenarios")
  public void testJobDueDateValue(boolean ensureJobDueDateSet, Date currentTime) {
    initJobExecutorAcquireJobsDefaultTest(ensureJobDueDateSet, currentTime);
    // when
    runtimeService.startProcessInstanceByKey("simpleAsyncProcess");
    List<AcquirableJobEntity> jobList = findAcquirableJobs();

    // then
    assertEquals(1, jobList.size());
    assertEquals(currentTime, jobList.get(0).getDuedate());
  }

  public void initJobExecutorAcquireJobsDefaultTest(boolean ensureJobDueDateSet, Date currentTime) {
    this.ensureJobDueDateSet = ensureJobDueDateSet;
    this.currentTime = currentTime;
    rule.getProcessEngineConfiguration().setEnsureJobDueDateNotNull(ensureJobDueDateSet);
  }
}
