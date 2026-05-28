/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.finos.fluxnova.bpm.engine.test.standalone.scripting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import javax.script.CompiledScript;
import javax.script.ScriptEngine;

import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;
import org.finos.fluxnova.bpm.engine.impl.scripting.ExecutableScript;
import org.finos.fluxnova.bpm.engine.impl.scripting.ScriptFactory;
import org.finos.fluxnova.bpm.engine.impl.scripting.SourceExecutableScript;
import org.finos.fluxnova.bpm.engine.impl.scripting.env.ScriptingEnvironment;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.ScriptPreprocessor;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.ScriptPreprocessorRequest;
import org.finos.fluxnova.bpm.engine.test.util.PluggableProcessEngineTest;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Stefan Hentschel.
 */
public class ScriptCompilationTest extends PluggableProcessEngineTest {

  protected static final String SCRIPT_LANGUAGE = "groovy";
  protected static final String EXAMPLE_SCRIPT = "println 'hello world'";

  protected ScriptFactory scriptFactory;

  @Before
  public void setUp() {
    scriptFactory = processEngineConfiguration.getScriptFactory();
  }

  protected SourceExecutableScript createScript(String language, String source) {
    return (SourceExecutableScript) scriptFactory.createScriptFromSource(language, source);
  }

  @Test
  public void testScriptShouldBeCompiledByDefault() {
    // when a script is created
    SourceExecutableScript script = createScript(SCRIPT_LANGUAGE, EXAMPLE_SCRIPT);
    assertNotNull(script);

    // then it should not be compiled on creation
    assertTrue(script.isShouldBeCompiled());
    assertNull(script.getCompiledScript());

    // but after first execution
    executeScript(script);

    // it was compiled
    assertFalse(script.isShouldBeCompiled());
    assertNotNull(script.getCompiledScript());
  }

  @Test
  public void testDisableScriptCompilation() {
    // when script compilation is disabled and a script is created
    processEngineConfiguration.setEnableScriptCompilation(false);
    SourceExecutableScript script = createScript(SCRIPT_LANGUAGE, EXAMPLE_SCRIPT);
    assertNotNull(script);

    // then it should not be compiled on creation
    assertTrue(script.isShouldBeCompiled());
    assertNull(script.getCompiledScript());

    // and after first execution
    executeScript(script);

    // it was also not compiled
    assertFalse(script.isShouldBeCompiled());
    assertNull(script.getCompiledScript());

    // re-enable script compilation
    processEngineConfiguration.setEnableScriptCompilation(true);
  }

  @Test
  public void testDisableScriptCompilationByDisabledScriptEngineCaching() {
    // when script engine caching is disabled and a script is created
    processEngineConfiguration.setEnableScriptEngineCaching(false);
    SourceExecutableScript script = createScript(SCRIPT_LANGUAGE, EXAMPLE_SCRIPT);
    assertNotNull(script);

    // then it should not be compiled on creation
    assertTrue(script.isShouldBeCompiled());
    assertNull(script.getCompiledScript());

    // and after first execution
    executeScript(script);

    // it was also not compiled
    assertFalse(script.isShouldBeCompiled());
    assertNull(script.getCompiledScript());

    // re-enable script engine caching
    processEngineConfiguration.setEnableScriptEngineCaching(true);
  }

  @Test
  public void testOverrideScriptSource() {
    // when a script is created and executed
    SourceExecutableScript script = createScript(SCRIPT_LANGUAGE, EXAMPLE_SCRIPT);
    assertNotNull(script);
    executeScript(script);

    // it was compiled
    assertFalse(script.isShouldBeCompiled());
    assertNotNull(script.getCompiledScript());

    // if the script source changes
    script.setScriptSource(EXAMPLE_SCRIPT);

    // then it should not be compiled after change
    assertTrue(script.isShouldBeCompiled());
    assertNull(script.getCompiledScript());

    // but after next execution
    executeScript(script);

    // it is compiled again
    assertFalse(script.isShouldBeCompiled());
    assertNotNull(script.getCompiledScript());
  }

  @Test
  public void testRecompileWhenPreprocessedScriptChanges() {
    // given
    boolean preprocessingEnabledBefore = processEngineConfiguration.isEnableScriptPreprocessing();
    List<ScriptPreprocessor> preprocessorsBefore = processEngineConfiguration.getScriptPreprocessors();

    // preprocessor returns a different script on each invocation to simulate changing output
    AtomicInteger preprocessorInvocations = new AtomicInteger();
    ScriptPreprocessor preprocessor = new ScriptPreprocessor() {
      @Override
      public String process(ScriptPreprocessorRequest request) {
        return preprocessorInvocations.incrementAndGet() == 1 ? "1 + 1" : "1 + 2";
      }

      @Override
      public String getName() {
        return "changing-preprocessor";
      }
    };
    enablePreprocessingWith(preprocessor);

    // source is a placeholder; the registered preprocessor replaces it entirely at runtime
    AtomicInteger compileInvocations = new AtomicInteger();
    SourceExecutableScript script = createCountingScript(compileInvocations);

    try {
      // when
      Object firstResult = executeScript(script);
      CompiledScript compiledForFirstPreprocessedOutput = script.getCompiledScript();
      
      Object secondResult = executeScript(script);
      CompiledScript compiledForSecondPreprocessedOutput = script.getCompiledScript();

      // then — each execution evaluates a distinct preprocessed script
      assertEquals(2, firstResult);
      assertEquals(3, secondResult);

      // compile() is called exactly twice — once per unique preprocessed output,
      // confirming that the compiled cache is invalidated and recompilation is triggered
      // when the preprocessor returns different output on subsequent executions
      assertEquals("compile() should be called once per unique preprocessed script",
          2, compileInvocations.get());
      assertNotNull(compiledForFirstPreprocessedOutput);
      assertNotNull(compiledForSecondPreprocessedOutput);
      assertNotSame("compiled scripts for different preprocessed outputs must not be reused",
          compiledForFirstPreprocessedOutput, compiledForSecondPreprocessedOutput);
    } finally {
      restorePreprocessingConfig(preprocessingEnabledBefore, preprocessorsBefore);
    }
  }

  @Test
  public void testCompiledScriptCacheIsReusedWhenPreprocessedScriptIsStable() {
    // given — a preprocessor that consistently returns the same script on every invocation
    boolean preprocessingEnabledBefore = processEngineConfiguration.isEnableScriptPreprocessing();
    List<ScriptPreprocessor> preprocessorsBefore = processEngineConfiguration.getScriptPreprocessors();

    ScriptPreprocessor preprocessor = new ScriptPreprocessor() {
      @Override
      public String process(ScriptPreprocessorRequest request) {
        return "1 + 1";
      }

      @Override
      public String getName() {
        return "stable-preprocessor";
      }
    };
    enablePreprocessingWith(preprocessor);

    // source is a placeholder; the registered preprocessor replaces it entirely at runtime
    AtomicInteger compileInvocations = new AtomicInteger();
    SourceExecutableScript script = createCountingScript(compileInvocations);

    try {
      // when — executed three times with identical preprocessed output
      Object firstResult = executeScript(script);
      Object secondResult = executeScript(script);
      Object thirdResult = executeScript(script);

      // then — all executions produce the correct result
      assertEquals(2, firstResult);
      assertEquals(2, secondResult);
      assertEquals(2, thirdResult);

      // compile() is called exactly once — confirming the compiled artifact is reused
      // on the second and third executions rather than recompiled from the same source
      assertEquals("compile() should be called exactly once; subsequent executions must reuse the cached artifact",
          1, compileInvocations.get());
    } finally {
      restorePreprocessingConfig(preprocessingEnabledBefore, preprocessorsBefore);
    }
  }

  @Test
  public void testRecompileWhenPreprocessedScriptChangesConcurrently() throws Exception {
    // given
    boolean preprocessingEnabledBefore = processEngineConfiguration.isEnableScriptPreprocessing();
    List<ScriptPreprocessor> preprocessorsBefore = processEngineConfiguration.getScriptPreprocessors();

    AtomicInteger preprocessorInvocations = new AtomicInteger();
    ScriptPreprocessor preprocessor = new ScriptPreprocessor() {
      @Override
      public String process(ScriptPreprocessorRequest request) {
        return preprocessorInvocations.incrementAndGet() % 2 == 0 ? "1 + 2" : "1 + 1";
      }

      @Override
      public String getName() {
        return "alternating-preprocessor";
      }
    };
    enablePreprocessingWith(preprocessor);

    AtomicInteger compileInvocations = new AtomicInteger();
    SourceExecutableScript script = createCountingScript(compileInvocations);

    int threadCount = 8;
    int iterationsPerThread = 25;
    int totalExecutions = threadCount * iterationsPerThread;
    CountDownLatch startGate = new CountDownLatch(1);
    Set<Integer> observedResults = ConcurrentHashMap.newKeySet();

    ExecutorService executor = Executors.newFixedThreadPool(threadCount);
    try {
      List<Future<?>> futures = new java.util.ArrayList<>(threadCount);
      for (int i = 0; i < threadCount; i++) {
        futures.add(executor.submit(() -> {
          startGate.await();
          for (int j = 0; j < iterationsPerThread; j++) {
            Object value = executeScript(script);
            observedResults.add((Integer) value);
          }
          return null;
        }));
      }

      // when
      startGate.countDown();
      for (Future<?> future : futures) {
        future.get(30, TimeUnit.SECONDS);
      }

      // then
      assertEquals("preprocessor should run once per execution", totalExecutions, preprocessorInvocations.get());
      assertTrue("result 2 should be observed", observedResults.contains(2));
      assertTrue("result 3 should be observed", observedResults.contains(3));
      assertTrue("compile() should run at least twice for alternating preprocessed output",
          compileInvocations.get() >= 2);
      assertTrue("compile() should not exceed execution count", compileInvocations.get() <= totalExecutions);

      int compileCountAfterConcurrentPhase = compileInvocations.get();
      enablePreprocessingWith(new ScriptPreprocessor() {
        @Override
        public String process(ScriptPreprocessorRequest request) {
          return "1 + 1";
        }

        @Override
        public String getName() {
          return "stable-preprocessor-after-concurrency";
        }
      });

      Object stableFirstResult = executeScript(script);
      CompiledScript compiledAfterStableExecution = script.getCompiledScript();
      Object stableSecondResult = executeScript(script);

      assertEquals(2, stableFirstResult);
      assertEquals(2, stableSecondResult);
      assertNotNull(compiledAfterStableExecution);
      assertSame("once preprocessing output stabilizes, the compiled artifact should be reused",
          compiledAfterStableExecution, script.getCompiledScript());
      assertTrue("stabilizing the preprocessing output should require at most one additional compilation",
          compileInvocations.get() <= compileCountAfterConcurrentPhase + 1);
    } finally {
      executor.shutdownNow();
      restorePreprocessingConfig(preprocessingEnabledBefore, preprocessorsBefore);
    }
  }

  /**
   * Creates a {@link SourceExecutableScript} instrumented subclass that increments
   * {@code compileInvocations} on each call to {@link SourceExecutableScript#compile},
   * enabling tests to assert the exact number of compilations and verify whether
   * subsequent executions are served from the compiled cache or trigger recompilation.
   *
   * <p>The script source is set to a placeholder value. Tests using this method are
   * expected to register a preprocessor via {@link #enablePreprocessingWith} that
   * replaces the source entirely at runtime.</p>
   *
   * @param compileInvocations counter incremented on each compilation
   * @return instrumented script instance backed by {@link #SCRIPT_LANGUAGE}
   */
  private SourceExecutableScript createCountingScript(AtomicInteger compileInvocations) {
    return new SourceExecutableScript(SCRIPT_LANGUAGE, "ignored") {
      @Override
      public CompiledScript compile(ScriptEngine scriptEngine, String language, String src) {
        compileInvocations.incrementAndGet();
        return super.compile(scriptEngine, language, src);
      }
    };
  }

  /**
   * Enables script preprocessing on the current engine configuration and registers
   * the given preprocessor as the sole active preprocessor for the duration of the test.
   * Any previously configured preprocessors are replaced.
   *
   * @param preprocessor the preprocessor to register; replaces any existing preprocessors
   */
  private void enablePreprocessingWith(ScriptPreprocessor preprocessor) {
    processEngineConfiguration.setEnableScriptPreprocessing(true);
    processEngineConfiguration.setScriptPreprocessors(Collections.singletonList(preprocessor));
  }

  /**
   * Restores script preprocessing configuration to the state captured before the test.
   * Must be called from a {@code finally} block to guarantee restoration even when
   * test assertions fail.
   *
   * @param enabledBefore       preprocessing flag value before the test
   * @param preprocessorsBefore preprocessor list captured before the test
   */
  private void restorePreprocessingConfig(boolean enabledBefore, List<ScriptPreprocessor> preprocessorsBefore) {
    processEngineConfiguration.setEnableScriptPreprocessing(enabledBefore);
    processEngineConfiguration.setScriptPreprocessors(preprocessorsBefore);
  }

  protected Object executeScript(final ExecutableScript script) {
    final ScriptingEnvironment scriptingEnvironment = processEngineConfiguration.getScriptingEnvironment();
    return processEngineConfiguration.getCommandExecutorTxRequired()
      .execute(new Command<Object>() {
        public Object execute(CommandContext commandContext) {
          return scriptingEnvironment.execute(script, null);
        }
      });
  }

}
