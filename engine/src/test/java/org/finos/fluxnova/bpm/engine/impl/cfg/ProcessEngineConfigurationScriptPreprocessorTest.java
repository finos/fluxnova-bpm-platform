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
package org.finos.fluxnova.bpm.engine.impl.cfg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.CompositeScriptPreprocessor;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.ScriptPreprocessor;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.ScriptPreprocessorRequest;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for script preprocessor configuration in {@link ProcessEngineConfigurationImpl}.
 *
 * <p>Validates enabling/disabling preprocessing, setting and adding preprocessors, defensive copy
 * semantics, cache invalidation on configuration changes, and effective preprocessor resolution
 * (single instance vs. {@link CompositeScriptPreprocessor}).</p>
 */
public class ProcessEngineConfigurationScriptPreprocessorTest {

  private ProcessEngineConfigurationImpl configuration;

  @Before
  public void setUp() {
    configuration = (ProcessEngineConfigurationImpl) ProcessEngineConfiguration
        .createProcessEngineConfigurationFromResourceDefault();
  }

  // -------------------------------------------------------------------------
  // Enable / disable flag
  // -------------------------------------------------------------------------

  @Test
  public void shouldBeDisabledByDefault() {
    assertThat(configuration.isEnableScriptPreprocessing()).isFalse();
  }

  @Test
  public void shouldEnableScriptPreprocessing() {
    // when
    configuration.setEnableScriptPreprocessing(true);

    // then
    assertThat(configuration.isEnableScriptPreprocessing()).isTrue();
  }

  @Test
  public void shouldDisableScriptPreprocessingAgain() {
    // given
    configuration.setEnableScriptPreprocessing(true);

    // when
    configuration.setEnableScriptPreprocessing(false);

    // then
    assertThat(configuration.isEnableScriptPreprocessing()).isFalse();
  }

  // -------------------------------------------------------------------------
  // getEffectiveScriptPreprocessor — disabled / no preprocessors
  // -------------------------------------------------------------------------

  @Test
  public void shouldReturnNullEffectivePreprocessorWhenDisabled() {
    // given
    configuration.setEnableScriptPreprocessing(false);
    configuration.setScriptPreprocessors(Collections.singletonList(mockPreprocessor("p1")));

    // when / then
    assertThat(configuration.getEffectiveScriptPreprocessor()).isNull();
  }

  @Test
  public void shouldReturnNullEffectivePreprocessorWhenNoPreprocessorsConfigured() {
    // given
    configuration.setEnableScriptPreprocessing(true);
    configuration.setScriptPreprocessors(null);

    // when / then
    assertThat(configuration.getEffectiveScriptPreprocessor()).isNull();
  }

  @Test
  public void shouldReturnNullEffectivePreprocessorWhenEmptyListConfigured() {
    // given
    configuration.setEnableScriptPreprocessing(true);
    configuration.setScriptPreprocessors(Collections.emptyList());

    // when / then
    assertThat(configuration.getEffectiveScriptPreprocessor()).isNull();
  }

  // -------------------------------------------------------------------------
  // getEffectiveScriptPreprocessor — single vs composite resolution
  // -------------------------------------------------------------------------

  @Test
  public void shouldReturnSinglePreprocessorDirectlyWhenOnlyOneConfigured() {
    // given
    ScriptPreprocessor preprocessor = mockPreprocessor("only");
    configuration.setEnableScriptPreprocessing(true);
    configuration.setScriptPreprocessors(Collections.singletonList(preprocessor));

    // when
    ScriptPreprocessor effective = configuration.getEffectiveScriptPreprocessor();

    // then
    assertThat(effective).isSameAs(preprocessor);
  }

  @Test
  public void shouldReturnCompositePreprocessorWhenMultipleConfigured() {
    // given
    configuration.setEnableScriptPreprocessing(true);
    configuration.setScriptPreprocessors(Arrays.asList(mockPreprocessor("p1"), mockPreprocessor("p2")));

    // when
    ScriptPreprocessor effective = configuration.getEffectiveScriptPreprocessor();

    // then
    assertThat(effective).isInstanceOf(CompositeScriptPreprocessor.class);
  }

  // -------------------------------------------------------------------------
  // Cache invalidation
  // -------------------------------------------------------------------------

  @Test
  public void shouldInvalidateCacheWhenPreprocessingDisabled() {
    // given
    ScriptPreprocessor preprocessor = mockPreprocessor("p1");
    configuration.setEnableScriptPreprocessing(true);
    configuration.setScriptPreprocessors(Collections.singletonList(preprocessor));
    ScriptPreprocessor before = configuration.getEffectiveScriptPreprocessor();
    assertThat(before).isNotNull();

    // when
    configuration.setEnableScriptPreprocessing(false);

    // then
    assertThat(configuration.getEffectiveScriptPreprocessor()).isNull();
  }

  @Test
  public void shouldInvalidateCacheWhenPreprocessorsReplaced() {
    // given
    ScriptPreprocessor first = mockPreprocessor("first");
    ScriptPreprocessor second = mockPreprocessor("second");
    configuration.setEnableScriptPreprocessing(true);
    configuration.setScriptPreprocessors(Collections.singletonList(first));
    ScriptPreprocessor before = configuration.getEffectiveScriptPreprocessor();
    assertThat(before).isSameAs(first);

    // when
    configuration.setScriptPreprocessors(Collections.singletonList(second));

    // then
    assertThat(configuration.getEffectiveScriptPreprocessor()).isSameAs(second);
  }

  // -------------------------------------------------------------------------
  // addScriptPreprocessor
  // -------------------------------------------------------------------------

  @Test
  public void shouldAddScriptPreprocessor() {
    // given
    ScriptPreprocessor preprocessor = mockPreprocessor("p1");

    // when
    configuration.addScriptPreprocessor(preprocessor);

    // then
    List<ScriptPreprocessor> preprocessors = configuration.getScriptPreprocessors();
    assertThat(preprocessors).containsExactly(preprocessor);
  }

  @Test
  public void shouldIgnoreNullOnAddScriptPreprocessor() {
    // when
    configuration.addScriptPreprocessor(null);

    // then
    assertThat(configuration.getScriptPreprocessors()).isNullOrEmpty();
  }

  @Test
  public void shouldInvalidateCacheOnAddScriptPreprocessor() {
    // given
    ScriptPreprocessor first = mockPreprocessor("first");
    ScriptPreprocessor second = mockPreprocessor("second");
    configuration.setEnableScriptPreprocessing(true);
    configuration.setScriptPreprocessors(Collections.singletonList(first));
    ScriptPreprocessor before = configuration.getEffectiveScriptPreprocessor();
    assertThat(before).isSameAs(first);

    // when
    configuration.addScriptPreprocessor(second);

    // then — two preprocessors now, so composite is returned
    assertThat(configuration.getEffectiveScriptPreprocessor()).isInstanceOf(CompositeScriptPreprocessor.class);
  }

  // -------------------------------------------------------------------------
  // getScriptPreprocessors — copy
  // -------------------------------------------------------------------------

  @Test
  public void shouldReturnDefensiveCopyOfPreprocessors() {
    // given
    configuration.setScriptPreprocessors(Collections.singletonList(mockPreprocessor("p1")));

    // when
    List<ScriptPreprocessor> copy = configuration.getScriptPreprocessors();
    copy.clear();

    // then — internal list not affected
    assertThat(configuration.getScriptPreprocessors()).hasSize(1);
  }

  // -------------------------------------------------------------------------
  // Test helpers — creates minimal mock preprocessors for use in test setup
  // -------------------------------------------------------------------------

  private ScriptPreprocessor mockPreprocessor(String name) {
    ScriptPreprocessor p = mock(ScriptPreprocessor.class);
    when(p.getName()).thenReturn(name);
    when(p.process(any(ScriptPreprocessorRequest.class))).thenReturn(null);
    return p;
  }
}
