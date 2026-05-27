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
package org.finos.fluxnova.bpm.engine.impl.scripting;

import java.util.Objects;

import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.apache.commons.codec.digest.DigestUtils;
import org.finos.fluxnova.bpm.engine.ScriptCompilationException;
import org.finos.fluxnova.bpm.engine.ScriptEvaluationException;
import org.finos.fluxnova.bpm.engine.delegate.BpmnError;
import org.finos.fluxnova.bpm.engine.delegate.VariableScope;
import org.finos.fluxnova.bpm.engine.impl.ProcessEngineLogger;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.context.Context;

/**
 * A script which is provided as source code.
 *
 * @author Daniel Meyer
 *
 */
public class SourceExecutableScript extends CompiledExecutableScript {

  private final static ScriptLogger LOG = ProcessEngineLogger.SCRIPT_LOGGER;

  /** The source of the script. */
  protected String scriptSource;

  /** Flag to signal if the script should be compiled */
  protected volatile boolean shouldBeCompiled = true;

  /** Digest of the processed script source used to produce the current {@link #compiledScript}.
   * A {@code null} value indicates no compiled artifact is present.
   */
  protected volatile String compiledScriptSourceDigest;

  public SourceExecutableScript(String language, String source) {
    super(language);
    scriptSource = source;
  }

  @Override
  public Object evaluate(ScriptEngine engine, VariableScope variableScope, Bindings bindings) {
    String processedScript = preprocessScript(scriptSource, variableScope);
    String processedScriptDigest = null;
    CompiledScript compiledScriptToEvaluate;

    synchronized (this) {
      boolean hasCompiledScript = compiledScript != null;

      if (hasCompiledScript || shouldBeCompiled) {
        processedScriptDigest = computeScriptDigest(processedScript);
      }

      if (hasCompiledScript && !Objects.equals(compiledScriptSourceDigest, processedScriptDigest)) {
        invalidateCompiledScript();
      }

      if (shouldBeCompiled) {
        compileScript(engine, processedScript);
      }

      compiledScriptToEvaluate = compiledScript;
    }

    if (compiledScriptToEvaluate != null) {
      return evaluateCompiledScript(compiledScriptToEvaluate, variableScope, bindings);
    }
    else {
      try {
        return evaluateScript(engine, processedScript, bindings);
      } catch (ScriptException e) {
        if (e.getCause() instanceof BpmnError) {
          throw (BpmnError) e.getCause();
        }
        String activityIdMessage = getActivityIdExceptionMessage(variableScope);
        throw new ScriptEvaluationException("Unable to evaluate script" + activityIdMessage + ":" + e.getMessage(), e);
      }
    }
  }

  protected void compileScript(ScriptEngine engine, String processedScript) {
    ProcessEngineConfigurationImpl processEngineConfiguration = Context.getProcessEngineConfiguration();
    if (processEngineConfiguration.isEnableScriptEngineCaching() && processEngineConfiguration.isEnableScriptCompilation()) {

      if (getCompiledScript() == null && shouldBeCompiled) {
        synchronized (this) {
          if (getCompiledScript() == null && shouldBeCompiled) {
            // try to compile script
            compiledScript = compile(engine, language, processedScript);
            compiledScriptSourceDigest = compiledScript != null ? computeScriptDigest(processedScript) : null;

            // either the script was successfully compiled or it can't be
            // compiled but we won't try it again
            shouldBeCompiled = false;
          }
        }
      }

    }
    else {
      // if script compilation is disabled abort
      shouldBeCompiled = false;
    }
  }

  public CompiledScript compile(ScriptEngine scriptEngine, String language, String src) {
    if(scriptEngine instanceof Compilable && !scriptEngine.getFactory().getLanguageName().equalsIgnoreCase("ecmascript")) {
      Compilable compilingEngine = (Compilable) scriptEngine;

      try {
        CompiledScript compiledScript = compilingEngine.compile(src);

        LOG.debugCompiledScriptUsing(language);

        return compiledScript;

      } catch (ScriptException e) {
        throw new ScriptCompilationException("Unable to compile script: " + e.getMessage(), e);

      }

    } else {
      // engine does not support compilation
      return null;
    }

  }

  protected Object evaluateScript(ScriptEngine engine, String processedScript, Bindings bindings) throws ScriptException {
    LOG.debugEvaluatingNonCompiledScript(processedScript);
    return engine.eval(processedScript, bindings);
  }

  public String getScriptSource() {
    return scriptSource;
  }

  /**
   * Sets the script source code. And invalidates any cached compilation result.
   *
   * @param scriptSource
   *          the new script source code
   */
  public synchronized void setScriptSource(String scriptSource) {
    invalidateCompiledScript();
    this.scriptSource = scriptSource;
  }

  /**
   * Invalidates all cached compilation state for this script instance.
   *
   * <p>This method clears the currently cached compiled artifact and its
   * associated source digest, and marks the script as eligible for compilation
   * on the next evaluation. The method is synchronized to guarantee that cache
   * reset is applied atomically with respect to concurrent evaluation and source
   * updates.</p>
   */
  protected synchronized void invalidateCompiledScript() {
    this.compiledScript = null;
    this.compiledScriptSourceDigest = null;
    this.shouldBeCompiled = true;
  }

  public boolean isShouldBeCompiled() {
    return shouldBeCompiled;
  }

  /**
   * Computes a collision-resistant SHA-256 digest of the given script text.
   *
   * @param scriptText the script text to digest
   * @return the hex-encoded SHA-256 digest, or {@code null} if {@code scriptText} is {@code null}
   */
  private String computeScriptDigest(String scriptText) {
    return scriptText != null ? DigestUtils.sha256Hex(scriptText) : null;
  }

}
