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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.finos.fluxnova.bpm.engine.delegate.VariableScope;
import org.junit.Test;

/**
 * Unit tests for {@link ScriptPreprocessorRequest}
 *
 * <p>Validates that the request object correctly stores and retrieves script content,
 * language, and variable scope metadata. Tests cover all nullability scenarios to ensure
 * the Class handles optional fields as documented in the SPI contract.</p>
 */
public class ScriptPreprocessorRequestTest {

  @Test
  public void shouldConstructWithAllParameters() {
    // given
    String script = "var x = 1;";
    String language = "javascript";
    VariableScope variableScope = mock(VariableScope.class);

    // when
    ScriptPreprocessorRequest request = new ScriptPreprocessorRequest(script, language, variableScope);

    // then
    assertThat(request.getScript()).isEqualTo(script);
    assertThat(request.getLanguage()).isEqualTo(language);
    assertThat(request.getVariableScope()).isEqualTo(variableScope);
  }

  @Test
  public void shouldConstructWithNullScript() {
    // given
    String language = "javascript";
    VariableScope variableScope = mock(VariableScope.class);

    // when
    ScriptPreprocessorRequest request = new ScriptPreprocessorRequest(null, language, variableScope);

    // then
    assertThat(request.getScript()).isNull();
    assertThat(request.getLanguage()).isEqualTo(language);
    assertThat(request.getVariableScope()).isEqualTo(variableScope);
  }

  @Test
  public void shouldConstructWithNullLanguage() {
    // given
    String script = "var x = 1;";
    VariableScope variableScope = mock(VariableScope.class);

    // when
    ScriptPreprocessorRequest request = new ScriptPreprocessorRequest(script, null, variableScope);

    // then
    assertThat(request.getScript()).isEqualTo(script);
    assertThat(request.getLanguage()).isNull();
    assertThat(request.getVariableScope()).isEqualTo(variableScope);
  }

  @Test
  public void shouldConstructWithNullVariableScope() {
    // given
    String script = "var x = 1;";
    String language = "javascript";

    // when
    ScriptPreprocessorRequest request = new ScriptPreprocessorRequest(script, language, null);

    // then
    assertThat(request.getScript()).isEqualTo(script);
    assertThat(request.getLanguage()).isEqualTo(language);
    assertThat(request.getVariableScope()).isNull();
  }

  @Test
  public void shouldConstructWithAllNullFields() {
    // when
    ScriptPreprocessorRequest request = new ScriptPreprocessorRequest(null, null, null);

    // then
    assertThat(request.getScript()).isNull();
    assertThat(request.getLanguage()).isNull();
    assertThat(request.getVariableScope()).isNull();
  }

  @Test
  public void shouldReturnEmptyScriptAsIs() {
    // given
    String emptyScript = "";
    String language = "groovy";

    // when
    ScriptPreprocessorRequest request = new ScriptPreprocessorRequest(emptyScript, language, null);

    // then
    assertThat(request.getScript()).isEmpty();
    assertThat(request.getScript()).isEqualTo("");
  }
}
