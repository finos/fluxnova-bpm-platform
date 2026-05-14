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
package org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor;

/**
 * SPI for preprocessing scripts before they are evaluated by a script engine.
 */
public interface ScriptPreprocessor {

  /**
   * Preprocesses the script before execution.
   *
   * @param request encapsulates script text and execution context
   * @return processed script text; returning {@code null} indicates no replacement and lets
   *         the caller continue with the original script
   */
  String process(ScriptPreprocessorRequest request);

  /**
   * Returns a stable, human-readable name for this preprocessor implementation.
   *
   * @return the preprocessor name
   */
  String getName();
}
