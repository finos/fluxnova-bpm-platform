package org.finos.fluxnova.bpm.engine.test.bpmn.subprocess;

import static org.finos.fluxnova.bpm.engine.test.util.ExecutionAssert.assertThat;
import static org.finos.fluxnova.bpm.engine.test.util.ExecutionAssert.describeExecutionTree;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.ParseException;
import org.finos.fluxnova.bpm.engine.runtime.Execution;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.util.ExecutionTree;
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

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testMissingActiveTasksCollectionFailsAdHocStart.bpmn20.xml")
  @Test
  public void testMissingActiveTasksCollectionLeavesAdHocSubProcessActive() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBasic");

    assertEquals(0, taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .count());

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    assertNotNull(adHocExecution);
    assertNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());
  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testParallelActivationRespectsActiveTasksList.bpmn20.xml")
  @Test
  public void testEmptyActiveTasksCollectionLeavesAdHocSubProcessActive() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
        "adHocSubProcessBasic",
    Collections.singletonMap("initialTaskIds", Collections.emptyList()));

    assertEquals(0, taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .count());

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    assertNotNull(adHocExecution);
    assertNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());
  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.modelIdleNoInitialTasks.bpmn20.xml")
  @Test
  public void testTriggerAdHocActivitiesAfterIdleStartActivatesTasks() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBasic");

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    runtimeService.triggerAdHocActivities(adHocExecution.getId(), Arrays.asList("taskA", "taskB"), null);

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

    taskService.complete(taskA.getId());
    taskService.complete(taskB.getId());

    assertNull(runtimeService.createExecutionQuery()
      .processInstanceId(processInstance.getId())
      .activityId("adHocSubProcess")
      .singleResult());

    assertNotNull(taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskAfter")
      .singleResult());

  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.modelIdleNoInitialTasks.bpmn20.xml")
  @Test
  public void testCompleteAdHocSubProcessAfterIdleStart() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBasic");

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    if (adHocExecution != null) {
      runtimeService.completeAdHocSubProcess(adHocExecution.getId());
    }

    assertNull(runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult());

    assertNotNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());
  }

    @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.modelIdleNoInitialTasks.bpmn20.xml")
    @Test
    public void testCompleteAdHocSubProcessWithVariablesAfterIdleStart() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBasic");

    Execution adHocExecution = runtimeService.createExecutionQuery()
      .processInstanceId(processInstance.getId())
      .activityId("adHocSubProcess")
      .singleResult();

    assertNotNull(adHocExecution);

    runtimeService.completeAdHocSubProcess(adHocExecution.getId(),
      Collections.singletonMap("completionReason", "manual"));

    assertEquals("manual", runtimeService.getVariable(processInstance.getId(), "completionReason"));

    assertNull(runtimeService.createExecutionQuery()
      .processInstanceId(processInstance.getId())
      .activityId("adHocSubProcess")
      .singleResult());

    assertNotNull(taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskAfter")
      .singleResult());
    }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testCompleteAdHocSubProcessCancelsActivitiesWhenCancelRemainingInstancesTrue.bpmn20.xml")
  @Test
  public void testCompleteAdHocSubProcessCancelsActivitiesWhenCancelRemainingInstancesTrue() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBasic");

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    assertNotNull(adHocExecution);

    runtimeService.completeAdHocSubProcess(adHocExecution.getId());

    assertNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult());

    assertNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult());

    assertNotNull(taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskAfter")
      .singleResult());

  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testCompleteAdHocSubProcessFailsWhenActivitiesAreActiveAndCancelRemainingInstancesFalse.bpmn20.xml")
  @Test
  public void testCompleteAdHocSubProcessFailsWhenActivitiesAreActiveAndCancelRemainingInstancesFalse() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessNoCancelRemaining");

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    assertNotNull(adHocExecution);

    try {
      runtimeService.completeAdHocSubProcess(adHocExecution.getId());
      fail("Expected BadUserRequestException");
    } catch (BadUserRequestException e) {
      testRule.assertTextPresent("has active child activities and cannot be completed", e.getMessage());
    }

    assertNotNull(runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult());
  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testAdHocCommandsFailForNonAdHocExecution.bpmn20.xml")
  @Test
  public void testCompleteAdHocSubProcessFailsForNonAdHocExecution() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("simpleUserTaskProcess");

    Execution execution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("userTask")
        .singleResult();

    try {
      runtimeService.completeAdHocSubProcess(execution.getId());
      fail("Expected BadUserRequestException");
    } catch (BadUserRequestException e) {
      testRule.assertTextPresent("is not waiting in an adHocSubProcess", e.getMessage());
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

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testCamundaAliasActiveTasksCollectionStartsConfiguredTasks.bpmn20.xml")
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
      runtimeService.triggerAdHocActivities(adHocExecution.getId(), Collections.singletonList("doesNotExist"), null);
      fail("Expected BadUserRequestException");
    } catch (BadUserRequestException e) {
      testRule.assertTextPresent("adHoc activity 'doesNotExist' does not exist in adHocSubProcess adHocSubProcess", e.getMessage());
    }
  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testTriggerMultipleAdHocActivitiesWithActivityVariables.bpmn20.xml")
  @Test
  public void testTriggerMultipleAdHocActivitiesWithActivityVariables() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessWithThreeTasks");

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    Map<String, Map<String, Object>> activityVariables = new LinkedHashMap<>();
    Map<String, Object> taskBVariables = new HashMap<>();
    taskBVariables.put("assigneeHint", "john");
    Map<String, Object> taskCVariables = new HashMap<>();
    taskCVariables.put("assigneeHint", "mary");
    activityVariables.put("taskB", taskBVariables);
    activityVariables.put("taskC", taskCVariables);

    runtimeService.triggerAdHocActivities(adHocExecution.getId(), Arrays.asList("taskB", "taskC"), activityVariables);

    Task taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();

    Task taskC = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskC")
        .singleResult();

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();

    assertNotNull(taskA);
    assertNotNull(taskB);
    assertNotNull(taskC);

    assertEquals("john", runtimeService.getVariableLocal(taskB.getExecutionId(), "assigneeHint"));
    assertEquals("mary", runtimeService.getVariableLocal(taskC.getExecutionId(), "assigneeHint"));
    assertNull(runtimeService.getVariableLocal(taskA.getExecutionId(), "assigneeHint"));
  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testTriggerMultipleAdHocActivitiesWithActivityVariables.bpmn20.xml")
  @Test
  public void testTriggerMultipleAdHocActivitiesFailsAllWhenOneIsInvalid() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessWithThreeTasks");

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    try {
      runtimeService.triggerAdHocActivities(adHocExecution.getId(), Arrays.asList("taskB", "doesNotExist"), null);
      fail("Expected BadUserRequestException");
    } catch (BadUserRequestException e) {
      testRule.assertTextPresent("adHoc activity 'doesNotExist' does not exist", e.getMessage());
    }

    Task taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();
    Task taskC = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskC")
        .singleResult();

    assertNull(taskB);
    assertNull(taskC);
  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testAdHocCommandsFailForNonAdHocExecution.bpmn20.xml")
  @Test
  public void testTriggerAdHocActivityFailsForNonAdHocExecution() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("simpleUserTaskProcess");

    Execution execution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("userTask")
        .singleResult();

    try {
      runtimeService.triggerAdHocActivities(execution.getId(), Collections.singletonList("taskA"), null);
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
      runtimeService.triggerAdHocActivities(adHocExecution.getId(), Collections.singletonList("taskC"), null);
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

  @Deployment
  @Test
  public void testBoundaryErrorEventOnAdHocSubProcess() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBoundaryError");

    Task boundaryTask = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("boundaryTask")
        .singleResult();

    Task adHocTask = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();

    Task taskAfter = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult();

    assertNotNull(boundaryTask);
    assertNull(adHocTask);
    assertNull(taskAfter);

    taskService.complete(boundaryTask.getId());
    assertEquals(0, runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
  }

  @Deployment
  @Test
  public void testMultiInstanceParallelAdHocSubProcessStartsAllInstances() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessMultiInstanceParallel");

    List<Task> adHocTasks = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .orderByTaskName()
        .asc()
        .list();

    assertEquals(4, adHocTasks.size());

    long taskACount = adHocTasks.stream().filter(t -> "taskA".equals(t.getTaskDefinitionKey())).count();
    long taskBCount = adHocTasks.stream().filter(t -> "taskB".equals(t.getTaskDefinitionKey())).count();
    assertEquals(2, taskACount);
    assertEquals(2, taskBCount);

    for (Task task : adHocTasks) {
      taskService.complete(task.getId());
    }

    Task taskAfter = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult();

    assertNotNull(taskAfter);
  }

  @Deployment
  @Test
  public void testMultiInstanceSequentialAdHocSubProcessStartsOneInstanceAtATime() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessMultiInstanceSequential");

    List<Task> firstInstanceTasks = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .orderByTaskName()
        .asc()
        .list();

    assertEquals(2, firstInstanceTasks.size());

    long firstInstanceTaskACount = firstInstanceTasks.stream().filter(t -> "taskA".equals(t.getTaskDefinitionKey())).count();
    long firstInstanceTaskBCount = firstInstanceTasks.stream().filter(t -> "taskB".equals(t.getTaskDefinitionKey())).count();
    assertEquals(1, firstInstanceTaskACount);
    assertEquals(1, firstInstanceTaskBCount);

    for (Task task : firstInstanceTasks) {
      taskService.complete(task.getId());
    }

    List<Task> secondInstanceTasks = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .orderByTaskName()
        .asc()
        .list();

    assertEquals(2, secondInstanceTasks.size());

    long secondInstanceTaskACount = secondInstanceTasks.stream().filter(t -> "taskA".equals(t.getTaskDefinitionKey())).count();
    long secondInstanceTaskBCount = secondInstanceTasks.stream().filter(t -> "taskB".equals(t.getTaskDefinitionKey())).count();
    assertEquals(1, secondInstanceTaskACount);
    assertEquals(1, secondInstanceTaskBCount);

    for (Task task : secondInstanceTasks) {
      taskService.complete(task.getId());
    }

    Task taskAfter = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult();

    assertNotNull(taskAfter);
  }

    @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testAutoCompleteAttributeFalseKeepsAdHocSubProcessOpen.bpmn20.xml")
    @Test
    public void testAutoCompleteAttributeFalseKeepsAdHocSubProcessOpen() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessAutoCompleteAttributeFalse");

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

    taskService.complete(taskA.getId());
    taskService.complete(taskB.getId());

    Execution adHocExecution = runtimeService.createExecutionQuery()
      .processInstanceId(processInstance.getId())
      .activityId("adHocSubProcess")
      .singleResult();

    assertNotNull(adHocExecution);
    assertNull(taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskAfter")
      .singleResult());

    runtimeService.completeAdHocSubProcess(adHocExecution.getId());

    assertNotNull(taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskAfter")
      .singleResult());
    }

    @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testCamundaAliasAutoCompleteAttributeFalseKeepsAdHocSubProcessOpen.bpmn20.xml")
    @Test
    public void testCamundaAliasAutoCompleteAttributeFalseKeepsAdHocSubProcessOpen() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessAutoCompleteAttributeFalseAlias");

    Task taskA = taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskA")
      .singleResult();

    assertNotNull(taskA);

    taskService.complete(taskA.getId());

    Execution adHocExecution = runtimeService.createExecutionQuery()
      .processInstanceId(processInstance.getId())
      .activityId("adHocSubProcess")
      .singleResult();

    assertNotNull(adHocExecution);
    assertNull(taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskAfter")
      .singleResult());

    runtimeService.completeAdHocSubProcess(adHocExecution.getId());

    assertNotNull(taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskAfter")
      .singleResult());
    }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testAutoCompleteAttributeTrueAutoCompletesAdHocSubProcess.bpmn20.xml")
  @Test
  public void testAutoCompleteAttributeTrueAutoCompletesAdHocSubProcess() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessAutoCompleteAttributeTrue");

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

    taskService.complete(taskA.getId());
    taskService.complete(taskB.getId());

    assertNull(runtimeService.createExecutionQuery()
      .processInstanceId(processInstance.getId())
      .activityId("adHocSubProcess")
      .singleResult());

    assertNotNull(taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskAfter")
      .singleResult());
  }

  @Test
    public void testAutoCompletePropertyFailsParse() {
    String resource = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/"
        + "AdHocSubProcessTest.testInvalidAutoCompletePropertyFailsParse.bpmn20.xml";

    try {
      repositoryService.createDeployment()
          .name(resource)
          .addClasspathResource(resource)
          .deploy();
      fail("Expected ParseException");
    } catch (ParseException e) {
      testRule.assertTextPresent(
          "Unsupported ad-hoc extension property 'autoComplete'; use extension attribute 'autoComplete' on the adHocSubProcess element",
          e.getMessage());
    }
  }

  @Test
  public void testInvalidAutoCompleteAttributeFailsParse() {
    String resource = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/"
        + "AdHocSubProcessTest.testInvalidAutoCompleteAttributeFailsParse.bpmn20.xml";

    try {
      repositoryService.createDeployment()
          .name(resource)
          .addClasspathResource(resource)
          .deploy();
      fail("Expected ParseException");
    } catch (ParseException e) {
      testRule.assertTextPresent(
          "Invalid value 'maybe' for ad-hoc extension attribute 'autoComplete'; expected boolean value",
          e.getMessage());
    }
  }

  @Deployment
  @Test
  public void testMultiInstanceParallelAdHocSubProcessWithIoMappedTasks() {
    // regression test: tasks with camunda:inputOutput inside a parallel multi-instance ad hoc subprocess
    // were failing at process start because the task was marked scope due to its IO mapping, creating a
    // mismatch between the scope hierarchy and the execution hierarchy
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
        "adHocSubProcessMultiInstanceParallelWithIoMappedTasks");

    List<Task> adHocTasks = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .list();

    assertEquals(2, adHocTasks.size());

    for (Task task : adHocTasks) {
      taskService.complete(task.getId());
    }

    assertEquals(0, runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
  }

  @Deployment
  @Test
  public void testCompletionConditionCancelsRemainingIoMappedTasks() {
    // regression test: completing a task with a variable that satisfies the completion condition
    // while other IO-mapped tasks are still active caused an ACT_FK_VAR_EXE foreign key violation,
    // because the ad hoc scope execution was deleted while variables still referenced it
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
        "adHocSubProcessCompletionConditionWithIoMappedTasks");

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();
    assertNotNull(taskA);

    // complete Task_A -> flows to Task_B (Task_C still active)
    taskService.complete(taskA.getId());

    Task taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();
    assertNotNull(taskB);

    // completing Task_B with approved=true satisfies the completion condition,
    // which cancels the still-active Task_C and leaves the subprocess
    taskService.complete(taskB.getId(), Collections.singletonMap("approved", true));

    assertEquals(0, runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
  }

  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testCompletionConditionCancelsRemainingIoMappedTasks.bpmn20.xml")
  @Test
  public void testCompletionConditionOnMidChainTaskCompletionCancelsRemaining() {
    // completing a task that has an outgoing sequence flow (taskA -> taskB) with a variable
    // that satisfies the completion condition must complete the subprocess immediately:
    // taskB is never created and the still-active taskC is canceled
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
        "adHocSubProcessCompletionConditionWithIoMappedTasks");

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();
    assertNotNull(taskA);

    taskService.complete(taskA.getId(), Collections.singletonMap("approved", true));

    // eager completion: taskB must never be created (not created-then-canceled)
    assertNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult());

    assertEquals(0, runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
  }

  @Deployment
  @Test
  public void testAutoCompleteFalseStillHonorsCompletionCondition() {
    // with autoComplete=false, an explicit completion condition is still honored:
    // completing the mid-chain taskA with approved=true completes the subprocess (taskB never created)
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
        "adHocSubProcessCompletionConditionAutoCompleteFalse",
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

    assertNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult());

    assertNotNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());
  }

  @Deployment
  @Test
  public void testAutoCompleteFalseKeepsScopeOpenAfterActivitiesComplete() {
    // with autoComplete=false and no completion condition, the scope stays open after all
    // started activities complete until explicit completion is requested
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessAutoCompleteFalse");

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

    taskService.complete(taskA.getId());
    taskService.complete(taskB.getId());

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    assertNotNull(adHocExecution);
    assertNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());

    runtimeService.completeAdHocSubProcess(adHocExecution.getId());

    assertNull(runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult());

    assertNotNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());
  }

  @Deployment
  @Test
  public void testMultiInstanceParallelInputMappedCompletionConditionCompletesPerInstance() {
    // process-level 'approved' is input-mapped onto each parallel MI instance of the ad hoc
    // subprocess, so each instance has its own copy: approving inside one instance completes
    // only that instance (canceling its remaining tasks) and leaves the sibling untouched
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessMiInputMappedCompletion");

    List<Task> taskAs = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .list();
    assertEquals(2, taskAs.size());

    // mid-chain completion: taskA flows to taskB, but approval completes the instance eagerly
    taskService.complete(taskAs.get(0).getId(), Collections.singletonMap("approved", true));

    List<Task> remaining = taskService.createTaskQuery().processInstanceId(processInstance.getId()).list();
    // first instance fully gone (its taskC canceled, taskB never created);
    // second instance untouched with its taskA and taskC
    assertEquals(2, remaining.size());
    assertEquals(1, remaining.stream().filter(t -> "taskA".equals(t.getTaskDefinitionKey())).count());
    assertEquals(1, remaining.stream().filter(t -> "taskC".equals(t.getTaskDefinitionKey())).count());

    // approving the second instance completes the whole process
    Task secondTaskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();
    taskService.complete(secondTaskA.getId(), Collections.singletonMap("approved", true));

    assertEquals(0, runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
  }

  /**
   * When parallel ad-hoc activities drain down to a single remaining one, the ad-hoc
   * scope must stay a distinct scope execution with the remaining activity running as a
   * concurrent child. Historically {@code tryPruneLastConcurrentChild()} folded that last
   * child into the scope execution, which destroyed the parent subprocess scope that
   * agentic child execution listeners rely on. This test pins the un-pruned tree shape.
   */
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testTriggerAdHocActivityAndCompleteSubProcess.bpmn20.xml")
  @Test
  public void testLastRemainingActivityKeepsAdHocScopeAsConcurrentParent() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBasic");

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();

    taskService.complete(taskA.getId());

    // taskB is now the only remaining ad-hoc activity
    assertNotNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult());

    assertAdHocScopeHasSingleConcurrentChild(processInstance, "taskB");
  }

  /**
   * A single starter activity runs as a concurrent child of the ad-hoc scope and completes
   * end-to-end. Note: the historical prune fired only from {@code concurrentChildExecutionEnded}
   * (when a sibling ended), so a lone starter never triggered it - this case documents the
   * baseline single-activity invariant rather than discriminating the prune removal.
   */
  @Deployment
  @Test
  public void testSingleStarterActivityRunsAsConcurrentChildAndCompletes() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessSingleStarter");

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();

    assertNotNull(taskA);

    assertAdHocScopeHasSingleConcurrentChild(processInstance, "taskA");

    taskService.complete(taskA.getId());

    // the un-pruned single child still completes the subprocess and flows downstream
    assertNull(runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult());
    assertEquals(0, runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("taskA")
        .count());
    assertNotNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());
  }

  /**
   * Draining two parallel activities down to one and then to zero must still auto-complete
   * the subprocess. With the prune removed, the final activity now ends via
   * {@code concurrentChildExecutionEnded} with no children left, rather than via the
   * folded-scope path; this guards that completion path.
   */
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testAutoCompleteAttributeTrueAutoCompletesAdHocSubProcess.bpmn20.xml")
  @Test
  public void testDrainToSingleConcurrentChildThenAutoCompletes() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessAutoCompleteAttributeTrue");

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();

    taskService.complete(taskA.getId());

    // one activity left: scope preserved as a distinct concurrent parent
    assertAdHocScopeHasSingleConcurrentChild(processInstance, "taskB");

    Task taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();

    taskService.complete(taskB.getId());

    // last child ends -> subprocess auto-completes, no leaked executions
    assertNull(runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult());
    assertEquals(0, runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("taskB")
        .count());
    assertNotNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());
  }

  /**
   * With a completion condition that is already met but instances preserved
   * ({@code cancelRemainingInstances=false}), the open scope must keep the single remaining
   * activity as a concurrent child and defer leaving until that child finishes.
   */
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/subprocess/AdHocSubProcessTest.testCompletionConditionDefersUntilActiveActivitiesFinish.bpmn20.xml")
  @Test
  public void testDeferredCompletionKeepsSingleConcurrentChild() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(
        "adHocSubProcessWithDeferredCompletion",
        Collections.singletonMap("approved", false));

    Task taskA = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskA")
        .singleResult();

    // condition becomes true, but taskB is still active -> scope must stay open
    taskService.complete(taskA.getId(), Collections.singletonMap("approved", true));

    assertNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());

    assertAdHocScopeHasSingleConcurrentChild(processInstance, "taskB");

    Task taskB = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskB")
        .singleResult();

    taskService.complete(taskB.getId());

    assertNotNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());
  }

  /**
   * Asserts that the ad-hoc subprocess scope is preserved as a distinct scope execution
   * whose only child is a concurrent (non-scope) execution at {@code expectedChildActivityId}.
   * This is exactly the shape that {@code tryPruneLastConcurrentChild()} would have collapsed.
   */
  protected void assertAdHocScopeHasSingleConcurrentChild(ProcessInstance processInstance,
      String expectedChildActivityId) {
    ExecutionTree executionTree = ExecutionTree.forExecution(processInstance.getId(), processEngine);

    assertThat(executionTree).matches(
        describeExecutionTree(null).scope()
            .child("adHocSubProcess").scope()
              .child(expectedChildActivityId).concurrent().noScope()
            .done());
  }
}


