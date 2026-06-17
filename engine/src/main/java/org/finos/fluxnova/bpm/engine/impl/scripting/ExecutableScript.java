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

import javax.script.Bindings;
import javax.script.ScriptEngine;

import org.finos.fluxnova.bpm.engine.ProcessEngineException;
import org.finos.fluxnova.bpm.engine.delegate.DelegateCaseExecution;
import org.finos.fluxnova.bpm.engine.delegate.DelegateExecution;
import org.finos.fluxnova.bpm.engine.delegate.VariableScope;
import org.finos.fluxnova.bpm.engine.impl.ProcessEngineLogger;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.impl.context.Context;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.TaskEntity;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.ScriptPreprocessor;
import org.finos.fluxnova.bpm.engine.impl.scripting.preprocessor.ScriptPreprocessorRequest;

/**
 * <p>Represents an executable script.</p>
 *
 *
 * @author Daniel Meyer
 *
 */
public abstract class ExecutableScript {

  private static final ScriptLogger LOG = ProcessEngineLogger.SCRIPT_LOGGER;

  /** The language of the script. Used to resolve the
   * {@link ScriptEngine}. */
  protected final String language;

  protected ExecutableScript(String language) {
    this.language = language;
  }

  /**
   * The language in which the script is written.
   * @return the language
   */
  public String getLanguage() {
    return language;
  }

  /**
   * <p>Evaluates the script using the provided engine and bindings</p>
   *
   * @param scriptEngine the script engine to use for evaluating the script.
   * @param variableScope the variable scope of the execution
   * @param bindings the bindings to use for evaluating the script.
   * @throws ProcessEngineException in case the script cannot be evaluated.
   * @return the result of the script evaluation
   */
  public Object execute(ScriptEngine scriptEngine, VariableScope variableScope, Bindings bindings) {
    return evaluate(scriptEngine, variableScope, bindings);
  }

  protected String getActivityIdExceptionMessage(VariableScope variableScope) {
    String activityId = null;
    String definitionIdMessage = "";

    if (variableScope instanceof DelegateExecution) {
      activityId = ((DelegateExecution) variableScope).getCurrentActivityId();
      definitionIdMessage = " in the process definition with id '" + ((DelegateExecution) variableScope).getProcessDefinitionId() + "'";
    } else if (variableScope instanceof TaskEntity) {
      TaskEntity task = (TaskEntity) variableScope;
      if (task.getExecution() != null) {
        activityId = task.getExecution().getActivityId();
        definitionIdMessage = " in the process definition with id '" + task.getProcessDefinitionId() + "'";
      }
      if (task.getCaseExecution() != null) {
        activityId = task.getCaseExecution().getActivityId();
        definitionIdMessage = " in the case definition with id '" + task.getCaseDefinitionId() + "'";
      }
    } else if (variableScope instanceof DelegateCaseExecution) {
      activityId = ((DelegateCaseExecution) variableScope).getActivityId();
      definitionIdMessage = " in the case definition with id '" + ((DelegateCaseExecution) variableScope).getCaseDefinitionId() + "'";
    }

    if (activityId == null) {
      return "";
    } else {
      return " while executing activity '" + activityId + "'" + definitionIdMessage;
    }
  }

  protected abstract Object evaluate(ScriptEngine scriptEngine, VariableScope variableScope, Bindings bindings);

  /**
   * Preprocesses a script before execution.
   *
   * <p>If script preprocessing is disabled, no preprocessor is configured, or the preprocessor
   * returns {@code null}, the original script is returned unchanged.</p>
   *
   * <p>If preprocessing fails with an exception, a warning is logged and the original script is
   * returned as a safe fallback to ensure scripts continue to execute.</p>
   *
   * @param script the script text to preprocess; may be {@code null}
   * @param variableScope the current execution context; may be {@code null}
   * @return the preprocessed script, or the original script if preprocessing is disabled,
   *         not configured, returns {@code null}, or fails with an exception
   */
  protected String preprocessScript(String script, VariableScope variableScope) {
    if (script == null) {
      return script;
    }

    ProcessEngineConfigurationImpl processEngineConfiguration = Context.getProcessEngineConfiguration();
    if (processEngineConfiguration == null
        || !processEngineConfiguration.isEnableScriptPreprocessing()) {
      return script;
    }

    ScriptPreprocessor scriptPreprocessor = processEngineConfiguration.getEffectiveScriptPreprocessor();
    if (scriptPreprocessor == null) {
      return script;
    }

    String preprocessorName = getPreprocessorName(scriptPreprocessor);

    ScriptPreprocessorRequest request = new ScriptPreprocessorRequest(script, language, variableScope);
    String processedScript;
    try {
      processedScript = scriptPreprocessor.process(request);
    } catch (Throwable e) {
      LOG.warnScriptPreprocessingFailed(language, preprocessorName, e);
      return script;
    }

    if (processedScript == null) {
      return script;
    }

    return processedScript;
  }

  private String getPreprocessorName(ScriptPreprocessor scriptPreprocessor) {
    try {
      String name = scriptPreprocessor.getName();
      return name != null ? name : "<unknown>";
    } catch (Exception e) {
      return "<unknown>";
    }
  }
}
