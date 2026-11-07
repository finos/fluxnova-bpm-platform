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

import org.finos.fluxnova.bpm.engine.impl.core.model.BaseCallableElement;
import org.finos.fluxnova.bpm.engine.impl.core.variable.mapping.value.ConstantValueProvider;
import org.finos.fluxnova.bpm.engine.impl.dmn.result.SingleEntryDecisionResultMapper;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.finos.fluxnova.bpm.engine.impl.util.DecisionEvaluationUtil;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.util.PluggableProcessEngineTest;
import org.junit.jupiter.api.Test;

/**
 * Tests that blank and whitespace-only resultVariable values are normalized to null
 * across all BPMN task and event types (serviceTask, scriptTask, businessRuleTask,
 * messageThrowEvent, endMessageEvent).
 * Hence No variable is created in the process instance or historic variable table for these cases.
 */
public class BlankResultVariableParseTest extends PluggableProcessEngineTest {

  protected static final String BLANK_RESULT_VARIABLE_BPMN = "org/finos/fluxnova/bpm/engine/test/bpmn/parse/BlankResultVariableParseTest.bpmn20.xml";
  protected static final String DECISION_OKAY_DMN = "org/finos/fluxnova/bpm/engine/test/dmn/businessruletask/DmnBusinessRuleTaskTest.testDecisionOkay.dmn11.xml";

  protected void assertNoHistoricVariableWithName(ProcessInstance processInstance, String variableName) {
    assertEquals(0L, historyService.createHistoricVariableInstanceQuery()
        .processInstanceId(processInstance.getId())
        .variableName(variableName)
        .count());
  }

  protected void assertNoHistoricVariableForProcess(ProcessInstance processInstance) {
    assertEquals(0L, historyService.createHistoricVariableInstanceQuery()
        .processInstanceId(processInstance.getId())
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
    assertTrue(runtimeService.getVariables(processInstance.getId()).isEmpty());
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    assertNoHistoricVariableForProcess(processInstance);
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
    assertTrue(runtimeService.getVariables(processInstance.getId()).isEmpty());
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    assertNoHistoricVariableForProcess(processInstance);
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
    assertTrue(runtimeService.getVariables(processInstance.getId()).isEmpty());
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    assertNoHistoricVariableForProcess(processInstance);
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
    assertTrue(runtimeService.getVariables(processInstance.getId()).isEmpty());
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    assertNoHistoricVariableForProcess(processInstance);
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
    assertTrue(runtimeService.getVariables(processInstance.getId()).isEmpty());
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    assertNoHistoricVariableForProcess(processInstance);
    testRule.assertProcessEnded(processInstance.getId());
  }

  /**
   * Verifies {@link DecisionEvaluationUtil} ignores a whitespace-only resultVariable
   * when evaluating a DMN-backed businessRuleTask.
   */
  @Deployment(resources = { BLANK_RESULT_VARIABLE_BPMN, DECISION_OKAY_DMN })
  @Test
  public void testDecisionEvaluationUtilWithWhitespaceResultVariable() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("businessRuleTaskDecisionRefWhitespaceResultProcess");
    String executionId = runtimeService.createExecutionQuery()
        .processInstanceId(processInstance.getId())
        .activityId("dmnRule_userTask")
        .singleResult()
        .getId();

    processEngineConfiguration.getCommandExecutorTxRequired().execute((Command<Void>) commandContext -> {
      ExecutionEntity execution = commandContext.getExecutionManager().findExecutionById(executionId);
      BaseCallableElement callableElement = new BaseCallableElement();
      callableElement.setDefinitionKeyValueProvider(new ConstantValueProvider("testDecision"));

      try {
        DecisionEvaluationUtil.evaluateDecision(
            execution,
            execution.getProcessDefinitionTenantId(),
            callableElement,
            "  ",
            new SingleEntryDecisionResultMapper());
      } catch (Exception e) {
        throw new RuntimeException(e);
      }

      assertNotNull(execution.getVariableLocal(DecisionEvaluationUtil.DECISION_RESULT_VARIABLE));
      assertNull(execution.getVariableLocal("  "));
      return null;
    });

    assertNull(runtimeService.getVariable(processInstance.getId(), "  "));
    assertTrue(runtimeService.getVariables(processInstance.getId()).isEmpty());
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    assertNoHistoricVariableForProcess(processInstance);
    assertNoHistoricVariableWithName(processInstance, "  ");
    testRule.assertProcessEnded(processInstance.getId());
  }

  /**
   * Verifies the decisionRef-based businessRuleTask handles a whitespace-only resultVariable
   * during normal process execution.
   */
  @Deployment(resources = { BLANK_RESULT_VARIABLE_BPMN, DECISION_OKAY_DMN })
  @Test
  public void testBusinessRuleTaskDecisionRefWithWhitespaceResultVariable() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("businessRuleTaskDecisionRefWhitespaceResultProcess");

    assertNull(runtimeService.getVariable(processInstance.getId(), "  "));
    assertTrue(runtimeService.getVariables(processInstance.getId()).isEmpty());
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    assertNoHistoricVariableForProcess(processInstance);
    assertNoHistoricVariableWithName(processInstance, "  ");
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
    assertTrue(runtimeService.getVariables(processInstance.getId()).isEmpty());
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    assertNoHistoricVariableForProcess(processInstance);
    assertNoHistoricVariableWithName(processInstance, "");
    testRule.assertProcessEnded(processInstance.getId());
  }

  /**
   * Verifies a blank resultVariable name is not used to create a variable in endMessageEvent.
   */
  @Deployment(resources = BLANK_RESULT_VARIABLE_BPMN)
  @Test
  public void testEndMessageEventWithBlankResultVariable() {
    ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("endMessageEventBlankResultProcess");

    assertTrue(runtimeService.getVariables(processInstance.getId()).isEmpty());
    taskService.complete(taskService.createTaskQuery().singleResult().getId());
    assertNoHistoricVariableForProcess(processInstance);
    assertNoHistoricVariableWithName(processInstance, "");
    testRule.assertProcessEnded(processInstance.getId());
  }

}

