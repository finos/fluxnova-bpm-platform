package org.finos.fluxnova.bpm.engine.impl.variable;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.finos.fluxnova.bpm.engine.history.HistoricVariableInstance;
import org.finos.fluxnova.bpm.engine.impl.context.Context;
import org.finos.fluxnova.bpm.engine.impl.core.variable.CoreVariableInstance;
import org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.finos.fluxnova.bpm.engine.runtime.VariableInstance;
import org.finos.fluxnova.bpm.engine.variable.value.TypedValue;

/**
 * Utility class for invoking variable interceptors in a centralized way.
 * This provides a single source of truth for interceptor invocation logic.
 */
public class VariableInterceptorUtil {

  /**
   * Intercepts a variable read operation through all configured interceptors.
   *
   * @param variableInstance the variable instance being read
   * @param value the raw typed value
   * @return the intercepted typed value (may be null if filtered)
   */
  public static TypedValue interceptGetVariable(VariableInstance variableInstance, TypedValue value) {
    List<VariableInterceptor> interceptors = getInterceptors();
    for (VariableInterceptor interceptor : interceptors) {
      value = interceptor.interceptGetVariable(variableInstance, value);
      if (value == null) {
        return null;
      }
    }
    return value;
  }

  /**
   * Intercepts a historic variable read operation through all configured interceptors.
   *
   * @param historicVariableInstance the historic variable instance being read
   * @param value the raw typed value
   * @return the intercepted typed value (may be null if filtered)
   */
  public static TypedValue interceptGetHistoricVariable(HistoricVariableInstance historicVariableInstance, TypedValue value) {
    List<VariableInterceptor> interceptors = getInterceptors();
    for (VariableInterceptor interceptor : interceptors) {
      value = interceptor.interceptGetHistoricVariable(historicVariableInstance, value);
      if (value == null) {
        return null;
      }
    }
    return value;
  }

  /**
   * Intercepts a variable create operation through all configured interceptors.
   *
   * @param variableInstance the variable instance being created
   * @return the variable instance to persist
   */
  public static CoreVariableInstance interceptCreateVariable(CoreVariableInstance variableInstance) {
    List<VariableInterceptor> interceptors = getInterceptors();
    for (VariableInterceptor interceptor : interceptors) {
      variableInstance = Objects.requireNonNull(
          interceptor.interceptCreateVariable(variableInstance),
          "Variable interceptor returned null for create interception");
    }
    return variableInstance;
  }

  /**
   * Intercepts a variable update operation through all configured interceptors.
   *
   * @param variableInstance the variable instance being updated
   * @param newValue the new typed value being set
   * @return the value to persist
   */
  public static TypedValue interceptUpdateVariable(CoreVariableInstance variableInstance, TypedValue newValue) {
    List<VariableInterceptor> interceptors = getInterceptors();
    for (VariableInterceptor interceptor : interceptors) {
      newValue = Objects.requireNonNull(
          interceptor.interceptUpdateVariable(variableInstance, newValue),
          "Variable interceptor returned null for update interception");
    }
    return newValue;
  }

  /**
   * Intercepts a variable delete operation through all configured interceptors.
   * Historic variable delete check implemented in {@link org.finos.fluxnova.bpm.engine.impl.cfg.auth.AuthorizationCommandChecker}
   *
   * @param variableInstance the variable instance being deleted
   * @throws AuthException if deletion is not authorized
   */
  public static void interceptDeleteVariable(CoreVariableInstance variableInstance) {
    List<VariableInterceptor> interceptors = getInterceptors();
    for (VariableInterceptor interceptor : interceptors) {
      interceptor.interceptDeleteVariable(variableInstance);
    }
  }

  /**
   * Gets the list of configured variable interceptors in a null-safe way.
   *
   * @return the list of interceptors, or an empty list if none are configured or context is unavailable
   */
  private static List<VariableInterceptor> getInterceptors() {
    if (Context.getCommandContext() != null) {
      ProcessEngineConfigurationImpl processEngineConfiguration = Context.getProcessEngineConfiguration();
      List<VariableInterceptor> interceptors = processEngineConfiguration.getVariableInterceptors();
      return interceptors != null ? interceptors : Collections.emptyList();
    }
    return Collections.emptyList();
  }

}
