package org.finos.fluxnova.bpm.engine.impl.scripting;

import java.io.StringReader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.finos.fluxnova.bpm.engine.ScriptEvaluationException;

/**
 * Shared script evaluation helpers.
 */
final class ScriptEvaluationUtil {

  static final int MAX_SCRIPT_SOURCE_LENGTH = 500_000;

  private ScriptEvaluationUtil() {
    // utility class
  }

  static void validateScriptSource(String scriptSource) {
    if (scriptSource == null) {
      throw new ScriptEvaluationException("Script source must not be null");
    }

    if (scriptSource.length() > MAX_SCRIPT_SOURCE_LENGTH) {
      throw new ScriptEvaluationException(
          "Script source length (" + scriptSource.length() + ") exceeds "
              + "maximum permitted length of " + MAX_SCRIPT_SOURCE_LENGTH);
    }
  }

  static Object evaluate(
      ScriptEngine scriptEngine,
      String scriptSource,
      Bindings bindings) throws ScriptException {

    validateScriptSource(scriptSource);
    return scriptEngine.eval(new StringReader(scriptSource), bindings);
  }
}