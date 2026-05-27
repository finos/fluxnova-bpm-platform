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
package org.finos.fluxnova.bpm.integrationtest.functional.scriptengine;

import java.util.HashMap;
import java.util.Map;

import org.finos.fluxnova.bpm.integrationtest.util.AbstractFoxPlatformIntegrationTest;
import org.finos.fluxnova.bpm.model.bpmn.Bpmn;
import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Integration tests for script preprocessing in BPMN script tasks that rely on
 * process-variable bindings.
 *
 * <p>This suite validates end-to-end behaviour in the container-managed runtime,
 * including BPMN execution, script evaluation, variable resolution, and preprocessor
 * invocation/fallback. The tests intentionally focus on variable-binding scenarios,
 * as these require real engine integration and are not sufficiently represented by
 * unit-level script evaluation tests.</p>
 *
 * <p>Coverage includes:</p>
 * <ul>
 *   <li>baseline execution with preprocessing disabled,</li>
 *   <li>successful script transformation when preprocessing is enabled,</li>
 *   <li>safe fallback when a preprocessor returns {@code null}, and</li>
 *   <li>safe fallback when a preprocessor throws an exception.</li>
 * </ul>
 */
@RunWith(Arquillian.class)
public class ScriptPreprocessorIntegrationTest extends AbstractFoxPlatformIntegrationTest {

  /** Process definition used for variable-binding scenarios. */
  private static final String VAR_PROCESS_KEY = "scriptPreprocessorVarBindingProcess";
  /** Script engine identifier used by BPMN script tasks in this suite. */
  private static final String SCRIPT_LANGUAGE = "groovy";
  /** Process variable receiving script evaluation output. */
  private static final String RESULT_VARIABLE = "result";

  /**
   * Builds the Arquillian deployment for this test class.
   *
   * @return web archive containing helper classes and BPMN model resources
   */
  @Deployment
  public static WebArchive createProcessApplication() {
    return initWebArchiveDeployment()
        .addClass(ScriptPreprocessorTestHelper.class)
        .addAsResource(createVarBindingProcess(), "varBindingProcess.bpmn20.xml");
  }

  /** Restores script preprocessing settings before each test for isolation. */
  @Before
  public void beforeEach() {
    ScriptPreprocessorTestHelper.resetScriptPreprocessing(processEngineConfiguration);
  }

  /** Restores script preprocessing settings after each test to avoid state leakage. */
  @After
  public void afterEach() {
    ScriptPreprocessorTestHelper.resetScriptPreprocessing(processEngineConfiguration);
  }

  /**
   * Validates baseline script execution with variable bindings when preprocessing is disabled.
   *
   * <p>The script computes {@code x + y} and stores the result in {@code result}.</p>
   */
  @Test
  public void shouldEvaluateScriptWithVariableBindingsWhenPreprocessingDisabled() {
    processEngineConfiguration.setEnableScriptPreprocessing(false);

    Map<String, Object> vars = new HashMap<>();
    vars.put("x", 4);
    vars.put("y", 6);

    String processInstanceId = runtimeService.startProcessInstanceByKey(VAR_PROCESS_KEY, vars).getId();

    assertEquals(10, runtimeService.getVariable(processInstanceId, RESULT_VARIABLE));
  }

  /**
   * Validates that preprocessing transforms scripts before execution when variable bindings
   * are present.
   *
   * <p>The test rewrites {@code x + y} to {@code x * y} and verifies the transformed result.</p>
   */
  @Test
  public void shouldApplyPreprocessorToScriptWithVariableBindings() {
    processEngineConfiguration.setEnableScriptPreprocessing(true);
    processEngineConfiguration.addScriptPreprocessor(
        ScriptPreprocessorTestHelper.replacingPreprocessor("x + y", "x * y"));

    Map<String, Object> vars = new HashMap<>();
    vars.put("x", 4);
    vars.put("y", 6);

    String processInstanceId = runtimeService.startProcessInstanceByKey(VAR_PROCESS_KEY, vars).getId();

    assertEquals(24, runtimeService.getVariable(processInstanceId, RESULT_VARIABLE));
  }

  /**
   * Validates null-safe fallback: when a preprocessor returns {@code null}, the engine executes
   * the original script with the same variable bindings.
   */
  @Test
  public void shouldFallBackToOriginalScriptWithVariableBindingsWhenPreprocessorReturnsNull() {
    processEngineConfiguration.setEnableScriptPreprocessing(true);
    processEngineConfiguration.addScriptPreprocessor(ScriptPreprocessorTestHelper.nullReturningPreprocessor());

    Map<String, Object> vars = new HashMap<>();
    vars.put("x", 3);
    vars.put("y", 7);

    String processInstanceId = runtimeService.startProcessInstanceByKey(VAR_PROCESS_KEY, vars).getId();

    assertEquals(10, runtimeService.getVariable(processInstanceId, RESULT_VARIABLE));
  }

  /**
   * Validates exception-safe fallback: when a preprocessor throws, the engine executes the
   * original script with the same variable bindings.
   */
  @Test
  public void shouldFallBackToOriginalScriptWithVariableBindingsWhenPreprocessorThrows() {
    processEngineConfiguration.setEnableScriptPreprocessing(true);
    processEngineConfiguration.addScriptPreprocessor(ScriptPreprocessorTestHelper.throwingPreprocessor());

    Map<String, Object> vars = new HashMap<>();
    vars.put("x", 3);
    vars.put("y", 7);

    String processInstanceId = runtimeService.startProcessInstanceByKey(VAR_PROCESS_KEY, vars).getId();

    assertEquals(10, runtimeService.getVariable(processInstanceId, RESULT_VARIABLE));
  }

  /**
   * Creates the BPMN model used by this suite.
   *
   * <p>The model contains a single script task that evaluates {@code x + y} and writes the
   * result to {@code result}, followed by a user task to keep the process state observable
   * for assertions.</p>
   */
  private static StringAsset createVarBindingProcess() {
    BpmnModelInstance modelInstance = Bpmn.createExecutableProcess(VAR_PROCESS_KEY)
        .fluxnovaHistoryTimeToLive(180)
        .startEvent()
        .scriptTask()
          .scriptFormat(SCRIPT_LANGUAGE)
          .scriptText("execution.setVariable('result', x + y)")
        .userTask()
        .done();
    return new StringAsset(Bpmn.convertToString(modelInstance));
  }

}
