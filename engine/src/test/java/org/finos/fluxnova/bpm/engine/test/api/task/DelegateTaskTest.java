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
package org.finos.fluxnova.bpm.engine.test.api.task;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.TaskService;
import org.finos.fluxnova.bpm.engine.delegate.DelegateTask;
import org.finos.fluxnova.bpm.engine.delegate.TaskListener;
import org.finos.fluxnova.bpm.engine.impl.util.ClockUtil;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.util.ProcessEngineTestRule;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.finos.fluxnova.bpm.model.bpmn.Bpmn;
import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;

/**
 * @author Falko Menge
 */
public class DelegateTaskTest {

  public ProcessEngineRule engineRule = new ProvidedProcessEngineRule();
  public ProcessEngineTestRule testRule = new ProcessEngineTestRule(engineRule);

  private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
  private final static String FOLLOW_UP_DATE_STRING = "2019-01-01T01:00:00";

  private static Date FOLLOW_UP_DATE;

  static {
    try {
      FOLLOW_UP_DATE = DATE_FORMAT.parse(FOLLOW_UP_DATE_STRING);
    } catch (ParseException e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

  private RuntimeService runtimeService;
  private TaskService taskService;

  @Rule
  public RuleChain ruleChain = RuleChain.outerRule(engineRule).around(testRule);

  @Before
  public void init() {
    runtimeService = engineRule.getRuntimeService();
    taskService = engineRule.getTaskService();
  }

  @Test
  @Deployment
  public void testGetCandidates() {
    runtimeService.startProcessInstanceByKey("DelegateTaskTest.testGetCandidates");

    Task task = taskService.createTaskQuery().singleResult();
    assertNotNull(task);

    @SuppressWarnings("unchecked")
    Set<String> candidateUsers = (Set<String>) taskService.getVariable(task.getId(), DelegateTaskTestTaskListener.VARNAME_CANDIDATE_USERS);
    assertEquals(2, candidateUsers.size());
    assertTrue(candidateUsers.contains("kermit"));
    assertTrue(candidateUsers.contains("gonzo"));

    @SuppressWarnings("unchecked")
    Set<String> candidateGroups = (Set<String>) taskService.getVariable(task.getId(), DelegateTaskTestTaskListener.VARNAME_CANDIDATE_GROUPS);
    assertEquals(2, candidateGroups.size());
    assertTrue(candidateGroups.contains("management"));
    assertTrue(candidateGroups.contains("accountancy"));
  }

  @Test
  public void testGetFollowUpDate() {
    // given
    BpmnModelInstance modelInstance = Bpmn.createExecutableProcess("process")
        .fluxnovaHistoryTimeToLive(180)
        .startEvent()
      .userTask()
        .fluxnovaFollowUpDate(FOLLOW_UP_DATE_STRING)
        .fluxnovaTaskListenerClass("create", GetFollowUpDateListener.class)
      .endEvent()
      .done();

    testRule.deploy(modelInstance);

    // when
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("process");

    // then
    String processInstanceId = processInstance.getId();
    Date followUpDate = (Date) runtimeService.getVariable(processInstanceId, "followUp");

    assertThat(followUpDate).isNotNull();
    assertThat(followUpDate).isEqualTo(FOLLOW_UP_DATE);
  }

  @Test
  public void testSetFollowUpDate() {
    // given
    BpmnModelInstance modelInstance = Bpmn.createExecutableProcess("process")
        .fluxnovaHistoryTimeToLive(180)
        .startEvent()
      .userTask()
        .fluxnovaTaskListenerClass("create", SetFollowUpDateListener.class)
      .endEvent()
      .done();

    testRule.deploy(modelInstance);

    // when
    runtimeService.startProcessInstanceByKey("process");

    // then
    Task task = taskService.createTaskQuery().singleResult();
    Date followUpDate = task.getFollowUpDate();

    assertThat(followUpDate).isNotNull();
    assertThat(followUpDate).isEqualTo(FOLLOW_UP_DATE);
  }

  @Test
  public void testLastUpdated() {
    // given
    BpmnModelInstance modelInstance = Bpmn.createExecutableProcess("process")
        .fluxnovaHistoryTimeToLive(180)
        .startEvent()
        .userTask()
          .fluxnovaTaskListenerClass(TaskListener.EVENTNAME_UPDATE, LastUpdateListener.class)
        .endEvent()
        .done();

    testRule.deploy(modelInstance);
    String processInstanceId = runtimeService.startProcessInstanceByKey("process").getProcessInstanceId();
    Date beforeUpdate = new Date(ClockUtil.getCurrentTime().getTime() - 1000L);
    Task task = taskService.createTaskQuery().singleResult();
    task.setPriority(0);

    // when
    taskService.saveTask(task);

    // then

    Date lastUpdated = (Date) runtimeService.getVariable(processInstanceId, "lastUpdated");
    assertThat(lastUpdated).isNotNull();
    assertThat(lastUpdated).isAfter(beforeUpdate);
  }

  public static class GetFollowUpDateListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
      Date followUpDate = delegateTask.getFollowUpDate();
      assertThat(followUpDate).isNotNull();

      delegateTask.setVariable("followUp", followUpDate);
    }

  }

  public static class SetFollowUpDateListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
      delegateTask.setFollowUpDate(FOLLOW_UP_DATE);
    }

  }

  public static class LastUpdateListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
      Date lastUpdated = delegateTask.getLastUpdated();

      delegateTask.setVariable("lastUpdated", lastUpdated);
    }

  }

}
