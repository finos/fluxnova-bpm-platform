
package org.finos.fluxnova.bpm.engine.impl.scripting;

import java.io.StringReader;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * Shared script evaluation helpers.
 */
final class ScriptEvaluationUtil {

    private ScriptEvaluationUtil() {
        // utility class
    }

    static Object evaluate(ScriptEngine scriptEngine, String scriptSource, Bindings bindings) throws ScriptException {
        if (scriptSource == null) {
            throw new ScriptException("Script source is null");
        }

        // Evaluate script source via a reader to avoid direct String eval sinks.
        return scriptEngine.eval(new StringReader(scriptSource), bindings);
    }
}