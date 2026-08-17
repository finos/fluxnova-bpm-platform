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

import org.finos.fluxnova.bpm.engine.delegate.VariableScope;

/**
 * Immutable request object passed to a {@link ScriptPreprocessor}.
 * It contains the current script content together with execution context metadata.
 */
public final class ScriptPreprocessorRequest {

  private final String script;
  private final String language;
  private final VariableScope variableScope;

  /**
   * Creates a preprocessing request.
   *
   * @param script the current script content; may be {@code null}
   * @param language the script language; may be {@code null}
   * @param variableScope the current variable scope; may be {@code null}
   */
  public ScriptPreprocessorRequest(String script, String language, VariableScope variableScope) {
    this.script = script;
    this.language = language;
    this.variableScope = variableScope;
  }

  /**
   * @return the current script content, or {@code null} if none is available
   */
  public String getScript() {
    return script;
  }

  /**
   * @return the script language, or {@code null} if unknown
   */
  public String getLanguage() {
    return language;
  }

  /**
   * @return the current variable scope, or {@code null} if no scope is associated
   */
  public VariableScope getVariableScope() {
    return variableScope;
  }
}
