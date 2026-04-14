package org.finos.fluxnova.bpm.engine.test.bpmn.subprocess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.runtime.Execution;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.util.PluggableProcessEngineTest;
import org.junit.Test;

public class AdHocSubProcessTest extends PluggableProcessEngineTest {

  @Deployment
  @Test
  public void testTriggerAdHocActivityAndCompleteSubProcess() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBasic");

    List<Task> adHocTasks = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .orderByTaskName()
        .asc()
        .list();

    assertEquals(2, adHocTasks.size());

    // find tasks by definition key instead of relying on order
    Task taskA = adHocTasks.stream()
        .filter(t -> "taskA".equals(t.getTaskDefinitionKey()))
        .findFirst()
        .orElse(null);
    Task taskB = adHocTasks.stream()
        .filter(t -> "taskB".equals(t.getTaskDefinitionKey()))
        .findFirst()
        .orElse(null);

    assertNotNull(taskA);
    assertNotNull(taskB);

    taskService.complete(taskA.getId());
    taskService.complete(taskB.getId());

    Task taskAfter = taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskAfter")
      .singleResult();

    assertNotNull(taskAfter);
  }

  @Deployment
  @Test
  public void testParallelActivationRespectsActiveTasksList() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
        "adHocSubProcessBasic",
                Collections.singletonMap("initialTaskIds", Collections.singletonList("taskB")));

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();

    Task taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();

    assertNull(taskA);
    assertNotNull(taskB);

    taskService.complete(taskB.getId());

    Task taskAfter = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult();

    assertNotNull(taskAfter);
  }

    @Deployment
  @Test
    public void testMissingActiveTasksCollectionFailsAdHocStart() {
    try {
      runtimeService.startProcessInstanceByKey("adHocSubProcessBasic");
      fail("Expected BadUserRequestException");
    } catch (BadUserRequestException e) {
            testRule.assertTextPresent(
                    "activeTasksCollection extension property must be provided for adHocSubProcess 'adHocSubProcess'",
                    e.getMessage());
    }
  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testStarterActivitiesFlowToDownstreamTask.bpmn20.xml")
  @Test
  public void testStarterActivitiesFlowToDownstreamTask() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessWithDownstreamFlow");

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();

    Task taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();

    Task taskC = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskC")
        .singleResult();

    assertNotNull(taskA);
    assertNotNull(taskB);
    assertNull(taskC);

    taskService.complete(taskA.getId());

    taskC = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskC")
        .singleResult();

    assertNotNull(taskC);

    taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();

    assertNotNull(taskB);

    taskService.complete(taskB.getId());
    taskService.complete(taskC.getId());

    Task taskAfter = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult();

    assertNotNull(taskAfter);
  }

    @Deployment
  @Test
    public void testNonStarterConfiguredTasksFailAdHocStart() {
    try {
            runtimeService.startProcessInstanceByKey("adHocSubProcessWithDownstreamFlow");
      fail("Expected BadUserRequestException");
    } catch (BadUserRequestException e) {
            testRule.assertTextPresent(
                    "activeTasksCollection contains non-startable activities in adHocSubProcess 'adHocSubProcess': [taskC]",
                    e.getMessage());
    }
  }

    @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testTriggerAdHocActivityWithUnknownActivityId.bpmn20.xml")
    @Test
    public void testCamundaAliasActiveTasksCollectionStartsConfiguredTasks() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBasic");

        Task taskA = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .taskDefinitionKey("taskA")
                .singleResult();

        Task taskB = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .taskDefinitionKey("taskB")
                .singleResult();

        assertNotNull(taskA);
        assertNull(taskB);
    }

    @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testTriggerAdHocActivityWithUnknownActivityId.bpmn20.xml")
    @Test
    public void testTriggerAdHocActivityWithUnknownActivityId() {
                ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBasic");

        Execution adHocExecution = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId())
                .activityId("adHocSubProcess")
                .singleResult();

        try {
            runtimeService.triggerAdHocActivity(adHocExecution.getId(), "doesNotExist");
            fail("Expected BadUserRequestException");
        } catch (BadUserRequestException e) {
            testRule.assertTextPresent("adHoc activity 'doesNotExist' does not exist in adHocSubProcess adHocSubProcess", e.getMessage());
        }
    }

    @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testTriggerAdHocActivityFailsForNonAdHocExecution.bpmn20.xml")
    @Test
    public void testTriggerAdHocActivityFailsForNonAdHocExecution() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("simpleUserTaskProcess");

        Execution execution = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId())
                .activityId("userTask")
                .singleResult();

        try {
            runtimeService.triggerAdHocActivity(execution.getId(), "taskA");
            fail("Expected BadUserRequestException");
        } catch (BadUserRequestException e) {
            testRule.assertTextPresent("is not waiting in an adHocSubProcess", e.getMessage());
        }
    }

    @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testStarterActivitiesFlowToDownstreamTask.bpmn20.xml")
    @Test
    public void testTriggerAdHocActivityFailsForNonStarterActivity() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessWithDownstreamFlow");

        Execution adHocExecution = runtimeService.createExecutionQuery()
                .processInstanceId(processInstance.getId())
                .activityId("adHocSubProcess")
                .singleResult();

        try {
            runtimeService.triggerAdHocActivity(adHocExecution.getId(), "taskC");
            fail("Expected BadUserRequestException");
        } catch (BadUserRequestException e) {
            testRule.assertTextPresent("adHoc activity 'taskC' is not startable in adHocSubProcess adHocSubProcess", e.getMessage());
        }
    }

  @Deployment
  @Test
  public void testCompletionConditionCancelsRemainingActivities() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
        "adHocSubProcessWithCompletionCondition",
                Collections.singletonMap("approved", false));

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();

    Task taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();

    assertNotNull(taskA);
    assertNotNull(taskB);

    // Completing taskA with approved=true triggers completion condition
    // which cancels taskB (due to cancelRemainingInstances="true")
    taskService.complete(taskA.getId(), Collections.singletonMap("approved", true));

    assertNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult());

    Task taskAfter = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult();

    assertNotNull(taskAfter);

    Task remainingTasks = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
    assertEquals("taskAfter", remainingTasks.getTaskDefinitionKey());

    taskService.complete(taskAfter.getId());
    assertTrue(runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count() == 0);
  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testCompletionConditionDefersUntilActiveActivitiesFinish.bpmn20.xml")
  @Test
  public void testCompletionConditionDefersUntilActiveActivitiesFinish() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
        "adHocSubProcessWithDeferredCompletion",
                Collections.singletonMap("approved", false));

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();

    Task taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();

    assertNotNull(taskA);
    assertNotNull(taskB);

    taskService.complete(taskA.getId(), Collections.singletonMap("approved", true));

    Task taskAfter = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult();

    assertNull(taskAfter);

    taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();

    assertNotNull(taskB);

    taskService.complete(taskB.getId());

    taskAfter = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult();

    assertNotNull(taskAfter);
  }
}
