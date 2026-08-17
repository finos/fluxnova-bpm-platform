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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.finos.fluxnova.bpm.engine.impl.ProcessEngineLogger;
import org.finos.fluxnova.bpm.engine.impl.scripting.ScriptLogger;

/**
 * Composite {@link ScriptPreprocessor} that applies configured preprocessors sequentially.
 */
public class CompositeScriptPreprocessor implements ScriptPreprocessor {

  private static final ScriptLogger LOG = ProcessEngineLogger.SCRIPT_LOGGER;

  private final List<ScriptPreprocessor> preprocessors;

  /**
   * Creates a composite preprocessor from the given preprocessors.
   * Null entries are ignored.
   *
   * @param preprocessors preprocessors to apply in order; may be {@code null}
   */
  public CompositeScriptPreprocessor(List<ScriptPreprocessor> preprocessors) {
    if (preprocessors == null) {
      this.preprocessors = Collections.unmodifiableList(new ArrayList<>());
    } else {
      this.preprocessors = preprocessors.stream()
          .filter(Objects::nonNull)
          .toList();
    }
  }

  /**
   * Applies each configured preprocessor in sequence.
   *
   * <p>If {@code request} is {@code null}, this method logs a warning and returns {@code null}.</p>
   *
   * <p>If {@code request.getScript()} is {@code null}, this method returns {@code null} immediately.
   * Empty scripts are valid input and are passed through the configured preprocessor chain.</p>
   *
   * @param request current preprocessing request
   * @return {@code null} when the request itself is {@code null} or its script is {@code null};
   *         otherwise the original script or the latest non-{@code null} processed script
   */
  @Override
  public String process(ScriptPreprocessorRequest request) {
    if (request == null) {
      LOG.warnScriptPreprocessorRequestNull(getName());
      return null;
    }
    String script = request.getScript();
    if (script == null) {
      return script;
    }
    for (ScriptPreprocessor preprocessor : preprocessors) {
      ScriptPreprocessorRequest nextRequest = new ScriptPreprocessorRequest(script, request.getLanguage(), request.getVariableScope());
      String processedScript = preprocessor.process(nextRequest);
      if (processedScript == null) {
        continue;
      }
      script = processedScript;
    }
    return script;
  }

  /**
   * @return the configured preprocessors in execution order
   */
  public List<ScriptPreprocessor> getPreprocessors() {
    return preprocessors;
  }

  /**
   * Returns the human-readable name of this preprocessor.
   *
   * @return the preprocessor name
   */
  @Override
  public String getName() {
    return "CompositeScriptPreprocessor";
  }
}
