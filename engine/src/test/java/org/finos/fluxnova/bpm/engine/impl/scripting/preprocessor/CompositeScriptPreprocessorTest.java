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

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

import org.junit.Test;

/**
 * Unit tests for {@link CompositeScriptPreprocessor}.
 *
 * <p>Validates the sequential chaining behavior of the composite preprocessor,
 * including correct execution order, {@code null} return semantics (skip and continue),
 * null-entry filtering in the constructor, and guard conditions for null requests
 * and null scripts.</p>
 */
public class CompositeScriptPreprocessorTest {

  @Test
  public void shouldApplyPreprocessorsInOrder() {
    // given
    ScriptPreprocessor first = scriptPreprocessor("first", request -> request.getScript() + "-first");
    ScriptPreprocessor second = scriptPreprocessor("second", request -> request.getScript() + "-second");

    CompositeScriptPreprocessor composite = new CompositeScriptPreprocessor(Arrays.asList(first, second));

    // when
    String processed = composite.process(new ScriptPreprocessorRequest("source", "groovy", null));

    // then
    assertThat(processed).isEqualTo("source-first-second");
  }

  @Test
  public void shouldContinueWhenPreprocessorReturnsNull() {
    // given
    ScriptPreprocessor first = scriptPreprocessor("first", request -> null);
    ScriptPreprocessor second = scriptPreprocessor("second", request -> request.getScript() + "-processed");

    CompositeScriptPreprocessor composite = new CompositeScriptPreprocessor(Arrays.asList(first, second));

    // when
    String processed = composite.process(new ScriptPreprocessorRequest("source", "groovy", null));

    // then
    assertThat(processed).isEqualTo("source-processed");
  }

  @Test
  public void shouldIgnoreNullPreprocessorsInConstructor() {
    // given
    ScriptPreprocessor nonNull = scriptPreprocessor("only", request -> request.getScript() + "-ok");

    CompositeScriptPreprocessor composite = new CompositeScriptPreprocessor(Arrays.asList(null, nonNull, null));

    // when
    String processed = composite.process(new ScriptPreprocessorRequest("source", "groovy", null));

    // then
    assertThat(processed).isEqualTo("source-ok");
    assertThat(composite.getPreprocessors()).hasSize(1);
  }

  @Test
  public void shouldReturnNullWhenRequestIsNull() {
    CompositeScriptPreprocessor composite = new CompositeScriptPreprocessor(null);

    assertThat(composite.process(null)).isNull();
  }

  @Test
  public void shouldReturnNullWhenScriptIsNull() {
    // given
    AtomicBoolean called = new AtomicBoolean(false);
    ScriptPreprocessor preprocessor = scriptPreprocessor("probe", request -> {
      called.set(true);
      return request.getScript() + "-changed";
    });

    CompositeScriptPreprocessor composite = new CompositeScriptPreprocessor(Collections.singletonList(preprocessor));

    // when
    String result = composite.process(new ScriptPreprocessorRequest(null, "groovy", null));

    // then
    assertThat(result).isNull();
    assertThat(called).isFalse();
  }

  @Test
  public void shouldProcessEmptyScript() {
    // given
    ScriptPreprocessor preprocessor = scriptPreprocessor("probe", request -> request.getScript() + "-changed");

    CompositeScriptPreprocessor composite = new CompositeScriptPreprocessor(Collections.singletonList(preprocessor));

    // when
    String result = composite.process(new ScriptPreprocessorRequest("", "groovy", null));

    // then
    assertThat(result).isEqualTo("-changed");
  }

  @Test
  public void shouldExposeCompositeName() {
    CompositeScriptPreprocessor composite = new CompositeScriptPreprocessor(null);

    assertThat(composite.getName()).isEqualTo("CompositeScriptPreprocessor");
  }

  private ScriptPreprocessor scriptPreprocessor(String name, Function<ScriptPreprocessorRequest, String> behavior) {
    return new ScriptPreprocessor() {
      @Override
      public String process(ScriptPreprocessorRequest request) {
        return behavior.apply(request);
      }

      @Override
      public String getName() {
        return name;
      }
    };
  }
}
