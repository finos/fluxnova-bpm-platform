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
package org.finos.fluxnova.bpm.engine.test.standalone.scripting;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicReference;

import javax.script.ScriptEngine;

import org.finos.fluxnova.bpm.engine.ProcessEngine;
import org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.context.Context;
import org.finos.fluxnova.bpm.engine.impl.scripting.ScriptFactory;
import org.finos.fluxnova.bpm.engine.impl.scripting.SourceExecutableScript;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.ScriptPreprocessor;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.ScriptPreprocessorRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for the script preprocessing SPI within {@link SourceExecutableScript}.
 *
 * <p>Verifies that preprocessing is applied when enabled, bypassed when disabled,
 * falls back to the original script when the preprocessor returns {@code null} or throws,
 * and that multiple chained preprocessors are applied in order.</p>
 *
 * <p>These tests build a {@link ProcessEngine} from the default engine configuration in
 * {@link #setUp()} and execute scripts through the normal {@code preprocessScript -> evaluate}
 * path. This provides realistic engine-level coverage of preprocessing behavior without
 * requiring dedicated integration-test container setup.</p>
 */
public class ScriptPreprocessingTest {

  protected static final String SCRIPT_LANGUAGE = "groovy";
  protected static final String ORIGINAL_SCRIPT = "1 + 1";
  protected static final String PREPROCESSED_SCRIPT = "1 + 2";

  protected ProcessEngineConfigurationImpl configuration;
  protected ScriptFactory scriptFactory;
  protected ProcessEngine processEngine;

  @Before
  public void setUp() {
    processEngine = ProcessEngineConfiguration
        .createProcessEngineConfigurationFromResourceDefault()
        .buildProcessEngine();
    configuration = (ProcessEngineConfigurationImpl) processEngine.getProcessEngineConfiguration();
    scriptFactory = configuration.getScriptFactory();

    configuration.setEnableScriptPreprocessing(false);
    configuration.setScriptPreprocessors(null);

    Context.setProcessEngineConfiguration(configuration);
  }

  @After
  public void tearDown() {
    configuration.setEnableScriptPreprocessing(false);
    configuration.setScriptPreprocessors(null);
    Context.removeProcessEngineConfiguration();
    processEngine.close();
  }

  // -------------------------------------------------------------------------
  // Preprocessing disabled (default)
  // -------------------------------------------------------------------------

  @Test
  public void shouldReturnOriginalScriptWhenPreprocessingDisabled() {
    // given
    AtomicReference<String> capturedScript = new AtomicReference<>();
    configuration.setEnableScriptPreprocessing(false);
    configuration.addScriptPreprocessor(capturingPreprocessor(capturedScript, PREPROCESSED_SCRIPT));

    SourceExecutableScript script = createScript(ORIGINAL_SCRIPT);

    // when
    Object result = executeScript(script);

    // then — preprocessing bypassed; original script evaluated
    assertThat(capturedScript.get()).isNull();
    assertThat(result).isEqualTo(2);
  }

  // -------------------------------------------------------------------------
  // Preprocessing enabled
  // -------------------------------------------------------------------------

  @Test
  public void shouldApplyPreprocessorWhenEnabled() {
    // given
    AtomicReference<String> capturedScript = new AtomicReference<>();
    configuration.setEnableScriptPreprocessing(true);
    configuration.addScriptPreprocessor(capturingPreprocessor(capturedScript, PREPROCESSED_SCRIPT));

    SourceExecutableScript script = createScript(ORIGINAL_SCRIPT);

    // when
    Object result = executeScript(script);

    // then — preprocessor called; modified script evaluated
    assertThat(capturedScript.get()).isEqualTo(ORIGINAL_SCRIPT);
    assertThat(result).isEqualTo(3);
  }

  @Test
  public void shouldFallBackToOriginalScriptWhenPreprocessorReturnsNull() {
    // given
    configuration.setEnableScriptPreprocessing(true);
    configuration.addScriptPreprocessor(nullReturningPreprocessor());

    SourceExecutableScript script = createScript(ORIGINAL_SCRIPT);

    // when
    Object result = executeScript(script);

    // then — null return means no replacement; original script evaluated
    assertThat(result).isEqualTo(2);
  }

  @Test
  public void shouldFallBackToOriginalScriptWhenPreprocessorThrows() {
    // given
    configuration.setEnableScriptPreprocessing(true);
    configuration.addScriptPreprocessor(throwingPreprocessor());

    SourceExecutableScript script = createScript(ORIGINAL_SCRIPT);

    // when
    Object result = executeScript(script);

    // then — exception swallowed; original script evaluated safely
    assertThat(result).isEqualTo(2);
  }

  @Test
  public void shouldApplyPreprocessorsInOrderWhenMultipleConfigured() {
    // given — first appends "-a"; second captures what it receives to verify ordering
    AtomicReference<String> inputToSecond = new AtomicReference<>();
    configuration.setEnableScriptPreprocessing(true);
    configuration.addScriptPreprocessor(appendingPreprocessor("-a"));
    configuration.addScriptPreprocessor(capturingPreprocessor(inputToSecond, PREPROCESSED_SCRIPT));

    SourceExecutableScript script = createScript(ORIGINAL_SCRIPT);

    // when
    Object result = executeScript(script);

    // then — second preprocessor received output of first
    assertThat(inputToSecond.get()).isEqualTo("1 + 1-a");
    assertThat(result).isEqualTo(3);
  }

  // -------------------------------------------------------------------------
  // Test helpers
  // -------------------------------------------------------------------------

  protected SourceExecutableScript createScript(String source) {
    return (SourceExecutableScript) scriptFactory.createScriptFromSource(SCRIPT_LANGUAGE, source);
  }

  protected Object executeScript(SourceExecutableScript script) {
    ScriptEngine engine = configuration.getScriptingEngines().getScriptEngineForLanguage(SCRIPT_LANGUAGE);
    return script.evaluate(engine, null, engine.createBindings());
  }

  private ScriptPreprocessor capturingPreprocessor(AtomicReference<String> capture, String output) {
    return new ScriptPreprocessor() {
      @Override
      public String process(ScriptPreprocessorRequest request) {
        capture.set(request.getScript());
        return output;
      }

      @Override
      public String getName() {
        return "capturingPreprocessor";
      }
    };
  }

  private ScriptPreprocessor nullReturningPreprocessor() {
    return new ScriptPreprocessor() {
      @Override
      public String process(ScriptPreprocessorRequest request) {
        return null;
      }

      @Override
      public String getName() {
        return "nullReturningPreprocessor";
      }
    };
  }

  private ScriptPreprocessor throwingPreprocessor() {
    return new ScriptPreprocessor() {
      @Override
      public String process(ScriptPreprocessorRequest request) {
        throw new RuntimeException("Simulated preprocessing failure");
      }

      @Override
      public String getName() {
        return "throwingPreprocessor";
      }
    };
  }

  private ScriptPreprocessor appendingPreprocessor(String suffix) {
    return new ScriptPreprocessor() {
      @Override
      public String process(ScriptPreprocessorRequest request) {
        return request.getScript() + suffix;
      }

      @Override
      public String getName() {
        return "appendingPreprocessor[" + suffix + "]";
      }
    };
  }
}
