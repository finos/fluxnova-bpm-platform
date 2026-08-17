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

import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.ScriptPreprocessor;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.ScriptPreprocessorRequest;

/**
 * Shared factory methods for {@link ScriptPreprocessor} test doubles used by
 * script engine integration tests.
 */
final class ScriptPreprocessorTestHelper {

  private ScriptPreprocessorTestHelper() {
  }

  /**
   * Creates a preprocessor that replaces all occurrences of {@code source} with
   * {@code replacement} in the script text.
   *
   * @param source the text to replace
   * @param replacement the replacement text
   * @return a replacing preprocessor
   */
  static ScriptPreprocessor replacingPreprocessor(String source, String replacement) {
    return new ScriptPreprocessor() {
      @Override
      public String process(ScriptPreprocessorRequest request) {
        return request.getScript().replace(source, replacement);
      }

      @Override
      public String getName() {
        return "replacingPreprocessor[" + source + " -> " + replacement + "]";
      }
    };
  }

  /**
   * Creates a preprocessor that always returns {@code null}, triggering fallback
   * to the original script.
   *
   * @return a null-returning preprocessor
   */
  static ScriptPreprocessor nullReturningPreprocessor() {
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

  /**
   * Creates a preprocessor that always throws a {@link RuntimeException},
   * triggering exception-safe fallback to the original script.
   *
   * @return a throwing preprocessor
   */
  static ScriptPreprocessor throwingPreprocessor() {
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

  /**
   * Resets script preprocessing configuration to a known default.
   */
  static void resetScriptPreprocessing(ProcessEngineConfigurationImpl config) {
    config.setEnableScriptPreprocessing(false);
    config.setScriptPreprocessors(null);
  }
}
