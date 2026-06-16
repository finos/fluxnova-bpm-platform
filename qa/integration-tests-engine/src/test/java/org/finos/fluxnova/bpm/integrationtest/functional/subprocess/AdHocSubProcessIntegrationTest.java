package org.finos.fluxnova.bpm.integrationtest.functional.subprocess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.runtime.Execution;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.integrationtest.util.AbstractFoxPlatformIntegrationTest;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class AdHocSubProcessIntegrationTest extends AbstractFoxPlatformIntegrationTest {

  @Deployment
  public static WebArchive processArchive() {
    return initWebArchiveDeployment()
        .addAsResource("org/finos/fluxnova/bpm/integrationtest/functional/subprocess/AdHocSubProcessIntegrationTest.basic.bpmn20.xml")
        .addAsResource("org/finos/fluxnova/bpm/integrationtest/functional/subprocess/AdHocSubProcessIntegrationTest.idle.bpmn20.xml");
  }

  @Test
  public void shouldTriggerAdHocActivitiesAndCompleteSubProcess() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessIdle");

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    assertNotNull(adHocExecution);

    Map<String, Map<String, Object>> activityVariables = new HashMap<String, Map<String, Object>>();
    activityVariables.put("taskA", Collections.<String, Object>singletonMap("assignee", "kermit"));
    activityVariables.put("taskB", Collections.<String, Object>singletonMap("priority", 42));

    runtimeService.triggerAdHocActivities(adHocExecution.getId(), Arrays.asList("taskA", "taskB"), activityVariables);

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
    assertEquals("kermit", runtimeService.getVariableLocal(taskA.getExecutionId(), "assignee"));
    assertEquals(42, runtimeService.getVariableLocal(taskB.getExecutionId(), "priority"));

    taskService.complete(taskA.getId());
    taskService.complete(taskB.getId());

    Task taskAfter = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult();

    assertNotNull(taskAfter);

    taskService.complete(taskAfter.getId());

    assertEquals(0, runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .count());
  }

  @Test
  public void shouldCompleteIdleAdHocSubProcessWithVariables() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessIdle");

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    assertNotNull(adHocExecution);

    runtimeService.completeAdHocSubProcess(adHocExecution.getId(), Collections.<String, Object>singletonMap("completionReason", "manual"));

    assertEquals("manual", runtimeService.getVariable(processInstance.getId(), "completionReason"));

    Task taskAfter = taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult();

    assertNotNull(taskAfter);

    taskService.complete(taskAfter.getId());

    assertEquals(0, runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .count());
  }

    @Test
    public void shouldCompleteAdHocSubProcessAndCancelActiveTasksWhenCancelRemainingIsTrue() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessBasicCancelRemaining");

    Execution adHocExecution = runtimeService.createExecutionQuery()
      .processInstanceId(processInstance.getId())
      .activityId("adHocSubProcess")
      .singleResult();

    assertNotNull(adHocExecution);

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

    runtimeService.completeAdHocSubProcess(adHocExecution.getId());

    assertNull(taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskA")
      .singleResult());
    assertNull(taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskB")
      .singleResult());

    Task taskAfter = taskService.createTaskQuery()
      .processInstanceId(processInstance.getId())
      .taskDefinitionKey("taskAfter")
      .singleResult();

    assertNotNull(taskAfter);

    taskService.complete(taskAfter.getId());

    assertEquals(0, runtimeService.createExecutionQuery()
      .processInstanceId(processInstance.getId())
      .count());
    }

  @Test
  public void shouldRejectTriggeringDownstreamActivity() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("adHocSubProcessIdle");

    Execution adHocExecution = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult();

    assertNotNull(adHocExecution);

    try {
      runtimeService.triggerAdHocActivities(adHocExecution.getId(), Arrays.asList("taskAfter"), null);
      fail("Expected BadUserRequestException");
    } catch (BadUserRequestException e) {
      assertNotNull(e);
    }

    assertNotNull(runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("adHocSubProcess")
        .singleResult());
    assertNull(taskService.createTaskQuery()
        .processInstanceId(processInstance.getId())
        .taskDefinitionKey("taskAfter")
        .singleResult());
  }
}