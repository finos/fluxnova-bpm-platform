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

import static org.junit.Assert.assertEquals;

import java.util.Collections;

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

/**
 * Integration tests for script preprocessing and script compilation interactions in BPMN
 * script tasks.
 *
 * <p>This suite validates observable runtime behavior across the full preprocessing/compilation
 * flag matrix and key preprocessing edge cases. Each test executes an actual BPMN process model
 * in the container-managed engine and asserts process variables, rather than asserting internal
 * engine objects.</p>
 *
 * <p>Coverage includes:</p>
 * <ul>
 *   <li>preprocessing enabled/disabled with compilation enabled,</li>
 *   <li>preprocessing enabled/disabled with compilation disabled,</li>
 *   <li>ordered application of chained preprocessors,</li>
 *   <li>fallback when a preprocessor returns {@code null}, and</li>
 *   <li>behavior with an explicitly empty preprocessor list.</li>
 * </ul>
 *
 * <p>Variable-binding-specific scenarios are covered in
 * {@link ScriptPreprocessorIntegrationTest}.</p>
 */
@RunWith(Arquillian.class)
public class ScriptPreprocessingCompilationTest extends AbstractFoxPlatformIntegrationTest {

  /** Process definition key for the model deployed by this test class. */
  private static final String PROCESS_KEY = "scriptPreprocessingCompilationProcess";
  /** Script language configured for the BPMN script task. */
  private static final String SCRIPT_LANG = "groovy";
  /** Variable used by all tests to read script execution output. */
  private static final String RESULT_VAR  = "result";

  /** Baseline script body; writes {@code "foo"} into the result variable. */
  private static final String BASE_SCRIPT = "execution.setVariable('result', 'foo')";

  /** Source value replaced by the first preprocessor. */
  private static final String TEST_FOO = "'foo'";
  /** Intermediate value produced by the first preprocessor. */
  private static final String TEST_BAR = "'bar'";
  /** Final value produced by the second preprocessor in chaining scenarios. */
  private static final String TEST_BAZ = "'baz'";

  /**
   * Builds the Arquillian deployment for this class.
   *
   * @return web archive containing helper classes and the BPMN model under test
   */
  @Deployment
  public static WebArchive createProcessApplication() {
    BpmnModelInstance model = Bpmn.createExecutableProcess(PROCESS_KEY)
        .fluxnovaHistoryTimeToLive(180)
        .startEvent()
        .scriptTask()
          .scriptFormat(SCRIPT_LANG)
          .scriptText(BASE_SCRIPT)
        .userTask()
        .done();
    return initWebArchiveDeployment()
        .addClass(ScriptPreprocessorTestHelper.class)
        .addAsResource(new StringAsset(Bpmn.convertToString(model)), "process.bpmn20.xml");
  }

  /** Resets preprocessing configuration before each test to guarantee isolation. */
  @Before
  public void setUp() {
    ScriptPreprocessorTestHelper.resetScriptPreprocessing(processEngineConfiguration);
  }

  /** Restores preprocessing configuration after each test to prevent state leakage. */
  @After
  public void tearDown() {
    ScriptPreprocessorTestHelper.resetScriptPreprocessing(processEngineConfiguration);
  }

  /**
   * Scenario 1: both preprocessing and compilation are enabled.
   * Verifies that, with both flags enabled, preprocessing transforms the script and the
   * transformed script result is observed at runtime.
   */
  @Test
  public void preprocessingAndCompilationEnabled_returnsPreprocessedResult() {
    processEngineConfiguration.setEnableScriptPreprocessing(true);
    processEngineConfiguration.setEnableScriptCompilation(true);
    processEngineConfiguration.addScriptPreprocessor(
        ScriptPreprocessorTestHelper.replacingPreprocessor(TEST_FOO, TEST_BAR));

    String pid = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();

    assertEquals("bar", runtimeService.getVariable(pid, RESULT_VAR));
  }

  /**
   * Scenario 2: preprocessing disabled, compilation enabled.
   * Verifies that disabling preprocessing preserves original script behavior even when
   * compilation remains enabled.
   */
  @Test
  public void preprocessingDisabled_compilationEnabled_returnsOriginalResult() {
    processEngineConfiguration.setEnableScriptPreprocessing(false);
    processEngineConfiguration.setEnableScriptCompilation(true);
    processEngineConfiguration.addScriptPreprocessor(
        ScriptPreprocessorTestHelper.replacingPreprocessor(TEST_FOO, TEST_BAR));

    String pid = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();

    assertEquals("foo", runtimeService.getVariable(pid, RESULT_VAR));
  }

  /**
   * Scenario 3: preprocessing enabled, compilation disabled.
   * Verifies that preprocessing still applies when compilation is disabled and the interpreted
   * execution path is used.
   */
  @Test
  public void preprocessingEnabled_compilationDisabled_returnsPreprocessedResult() {
    processEngineConfiguration.setEnableScriptPreprocessing(true);
    processEngineConfiguration.setEnableScriptCompilation(false);
    processEngineConfiguration.addScriptPreprocessor(
        ScriptPreprocessorTestHelper.replacingPreprocessor(TEST_FOO, TEST_BAR));

    String pid = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();

    assertEquals("bar", runtimeService.getVariable(pid, RESULT_VAR));
  }

  /**
   * Scenario 4: both preprocessing and compilation are disabled.
   * Verifies baseline interpreted execution when both preprocessing and compilation are disabled.
   */
  @Test
  public void preprocessingAndCompilationDisabled_returnsOriginalResult() {
    processEngineConfiguration.setEnableScriptPreprocessing(false);
    processEngineConfiguration.setEnableScriptCompilation(false);

    String pid = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();

    assertEquals("foo", runtimeService.getVariable(pid, RESULT_VAR));
  }

  /**
   * Scenario 5: chained preprocessors with compilation enabled.
   * Verifies that multiple preprocessors are applied in registration order.
   * <p>Expected flow: {@code 'foo' -> 'bar' -> 'baz'}.</p>
   */
  @Test
  public void chainingPreprocessors_appliedInOrder_returnsFinalResult() {
    processEngineConfiguration.setEnableScriptPreprocessing(true);
    processEngineConfiguration.setEnableScriptCompilation(true);
    // p1: 'foo' → 'bar'   p2: 'bar' → 'baz'
    processEngineConfiguration.addScriptPreprocessor(
        ScriptPreprocessorTestHelper.replacingPreprocessor(TEST_FOO, TEST_BAR));
    processEngineConfiguration.addScriptPreprocessor(
        ScriptPreprocessorTestHelper.replacingPreprocessor(TEST_BAR, TEST_BAZ));

    String pid = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();

    assertEquals("baz", runtimeService.getVariable(pid, RESULT_VAR));
  }

  /**
   * Scenario 6: null-returning preprocessor with compilation enabled.
   * Verifies null-safe fallback behavior with compilation enabled: when preprocessing yields
   * {@code null}, the engine executes the original script.
   */
  @Test
  public void nullReturningPreprocessor_compilationEnabled_fallsBackToOriginalScript() {
    processEngineConfiguration.setEnableScriptPreprocessing(true);
    processEngineConfiguration.setEnableScriptCompilation(true);
    processEngineConfiguration.addScriptPreprocessor(
        ScriptPreprocessorTestHelper.nullReturningPreprocessor());

    String pid = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();

    assertEquals("foo", runtimeService.getVariable(pid, RESULT_VAR));
  }

  /**
   * Scenario 7: explicit empty preprocessor list with compilation enabled.
   * Verifies that an explicit empty preprocessor list behaves like "no preprocessors" and keeps
   * original script output when compilation is enabled.
   */
  @Test
  public void emptyPreprocessorList_compilationEnabled_returnsOriginalResult() {
    processEngineConfiguration.setEnableScriptPreprocessing(true);
    processEngineConfiguration.setEnableScriptCompilation(true);
    processEngineConfiguration.setScriptPreprocessors(Collections.emptyList());

    String pid = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();

    assertEquals("foo", runtimeService.getVariable(pid, RESULT_VAR));
  }
}
