package org.finos.fluxnova.bpm.engine.impl.variable;

import org.finos.fluxnova.bpm.engine.history.HistoricVariableInstance;
import org.finos.fluxnova.bpm.engine.impl.core.variable.CoreVariableInstance;
import org.finos.fluxnova.bpm.engine.runtime.VariableInstance;
import org.finos.fluxnova.bpm.engine.variable.value.TypedValue;

/**
 * Interceptor for variable access, allowing transformations like masking.
 */
public interface VariableInterceptor {

  /**
   * Intercepts a variable read operation.
   *
   * @param variableInstance the variable instance being read
   * @param value the raw typed value
   * @return the intercepted typed value (may be null if filtered)
   */
  TypedValue interceptGetVariable(VariableInstance variableInstance, TypedValue value);

  /**
   * Intercepts a historic variable read operation.
   *
   * @param historicVariableInstance the historic variable instance being read
   * @param value the raw typed value
   * @return the intercepted typed value (may be null if filtered)
   */
  TypedValue interceptGetHistoricVariable(HistoricVariableInstance historicVariableInstance, TypedValue value);

  /**
   * Intercepts a variable create operation.
   *
   * @param variableInstance the variable instance being created
    * @return the variable instance to persist (may be the same instance, but must not be null)
   */
    CoreVariableInstance interceptCreateVariable(CoreVariableInstance variableInstance);

  /**
   * Intercepts a variable update operation.
   *
   * @param variableInstance the variable instance being updated
   * @param newValue the new typed value being set
    * @return the value to persist (may be the same value, but must not be null)
   */
    TypedValue interceptUpdateVariable(CoreVariableInstance variableInstance, TypedValue newValue);

  /**
   * Intercepts a variable delete operation.
   *
   * @param variableInstance the variable instance being deleted
   * @throws AuthException if deletion is not authorized
   */
  void interceptDeleteVariable(CoreVariableInstance variableInstance);

}
