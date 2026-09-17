/*
 * Copyright 2025 FINOS
 *
 * The source files in this repository are made available under the Apache License Version 2.0.
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 * Fluxnova uses and includes third-party dependencies published under various licenses.
 * By downloading and using Fluxnova artifacts, you agree to their terms and conditions.
 */
package org.finos.fluxnova.bpm.engine.test.bpmn.parse;

import static org.junit.jupiter.api.Assertions.*;

import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.util.PluggableProcessEngineTest;
import org.junit.jupiter.api.Test;

/**
 * Tests that blank and whitespace-only resultVariable values are normalized to null
 * across all BPMN task and event types (serviceTask, scriptTask, businessRuleTask,
 * messageThrowEvent, endMessageEvent).
 * Hence No variable is created in the process instance or historic variable table for these cases.
 *
 * @author Integration Test
 */
public class BlankResultVariableParseTest extends PluggableProcessEngineTest {

  protected static final String BLANK_RESULT_VARIABLE_BPMN = "org/finos/fluxnova/bpm/engine/test/bpmn/parse/BlankResultVariableParseTest.bpmn20.xml";

  protected void assertNoHistoricVariableWithName(ProcessInstance processInstance, String variableName) {
    assertEquals(0L, historyService.createHistoricVariableInstanceQuery()
        .processInstanceId(processInstance.getId())
        .variableName(variableName)
        .count());
  }

  /**
   * Verifies a blank resultVariable name is not used to create a variable in serviceTask.
   */
  @Deployment(resources = BLANK_RESULT_VARIABLE_BPMN)
  @Test
  public void testServiceTaskWithBlankResultVariable() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("serviceTaskBlankResultProcess");

    assertNull(runtimeService.getVariable(processInstance.getId(), ""));
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    testRule.assertProcessEnded(processInstance.getId());
  }

  /**
   * Verifies a space-only resultVariable name is not used to create a variable in serviceTask.
   */
  @Deployment(resources = BLANK_RESULT_VARIABLE_BPMN)
  @Test
  public void testServiceTaskWithSpaceResultVariable() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("serviceTaskSpaceResultProcess");

    assertNull(runtimeService.getVariable(processInstance.getId(), "  "));
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    testRule.assertProcessEnded(processInstance.getId());
  }

  /**
   * Verifies a blank resultVariable name is not used to create a variable in scriptTask.
   */
  @Deployment(resources = BLANK_RESULT_VARIABLE_BPMN)
  @Test
  public void testScriptTaskWithBlankResultVariable() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("scriptTaskBlankResultProcess");

    assertNull(runtimeService.getVariable(processInstance.getId(), ""));
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    testRule.assertProcessEnded(processInstance.getId());
  }

  /**
   * Verifies a space-only resultVariable name is not used to create a variable in scriptTask.
   */
  @Deployment(resources = BLANK_RESULT_VARIABLE_BPMN)
  @Test
  public void testScriptTaskWithSpaceResultVariable() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("scriptTaskSpaceResultProcess");

    assertNull(runtimeService.getVariable(processInstance.getId(), "  "));
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    testRule.assertProcessEnded(processInstance.getId());
  }

  /**
   * Verifies a blank resultVariable name is not used to create a variable in businessRuleTask.
   */
  @Deployment(resources = BLANK_RESULT_VARIABLE_BPMN)
  @Test
  public void testBusinessRuleTaskWithBlankResultVariable() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("businessRuleTaskBlankResultProcess");

    assertNull(runtimeService.getVariable(processInstance.getId(), ""));
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    testRule.assertProcessEnded(processInstance.getId());
  }

  /**
   * Verifies a blank resultVariable name is not used to create a variable in messageThrowEvent.
   */
  @Deployment(resources = BLANK_RESULT_VARIABLE_BPMN)
  @Test
  public void testMessageThrowEventWithBlankResultVariable() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("messageThrowEventBlankResultProcess");

    assertNull(runtimeService.getVariable(processInstance.getId(), ""));
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    testRule.assertProcessEnded(processInstance.getId());
  }

  /**
   * Verifies a blank resultVariable name is not used to create a variable in endMessageEvent.
   */
  @Deployment(resources = BLANK_RESULT_VARIABLE_BPMN)
  @Test
  public void testEndMessageEventWithBlankResultVariable() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("endMessageEventBlankResultProcess");

    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    assertNoHistoricVariableWithName(processInstance, "");
    testRule.assertProcessEnded(processInstance.getId());
  }

}

