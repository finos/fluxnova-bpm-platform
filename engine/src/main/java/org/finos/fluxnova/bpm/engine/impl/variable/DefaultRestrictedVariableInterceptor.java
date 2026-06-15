package org.finos.fluxnova.bpm.engine.impl.variable;

import static org.finos.fluxnova.bpm.engine.authorization.Authorization.ANY;

import java.util.Objects;

import org.finos.fluxnova.bpm.engine.authorization.Resources;
import org.finos.fluxnova.bpm.engine.authorization.VariablePermissions;
import org.finos.fluxnova.bpm.engine.history.HistoricVariableInstance;
import org.finos.fluxnova.bpm.engine.impl.context.Context;
import org.finos.fluxnova.bpm.engine.impl.core.variable.CoreVariableInstance;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.AuthorizationManager;
import org.finos.fluxnova.bpm.engine.runtime.VariableInstance;
import org.finos.fluxnova.bpm.engine.variable.value.TypedValue;

/**
 * Default implementation of VariableInterceptor that performs
 * authorization checks and filters restricted variables when unauthorized.
 */
public class DefaultRestrictedVariableInterceptor implements VariableInterceptor {

  @Override
  public TypedValue interceptGetVariable(VariableInstance variableInstance, TypedValue value) {
    if (InternalVariableContext.isInternalWrite() || InternalVariableContext.isInternalRead()) {
      return value;
    }
    if (variableInstance.isRestricted() && !isAuthorized(VariablePermissions.READ_RESTRICTED)) {
      return null;
    }
    return value;
  }

  @Override
  public TypedValue interceptGetHistoricVariable(HistoricVariableInstance historicVariableInstance, TypedValue value) {
    if (InternalVariableContext.isInternalWrite() || InternalVariableContext.isInternalRead()) {
      return value;
    }
    if (historicVariableInstance.isRestricted() && !isAuthorized(VariablePermissions.READ_HISTORY_RESTRICTED)) {
      return null;
    }
    return value;
  }

  @Override
  public CoreVariableInstance interceptCreateVariable(CoreVariableInstance variableInstance) {
    if (!InternalVariableContext.isInternalWrite()) {
      checkAuthorization(VariablePermissions.CREATE_RESTRICTED, variableInstance.isRestricted());
    }
    return variableInstance;
  }

  @Override
  public TypedValue interceptUpdateVariable(CoreVariableInstance variableInstance, TypedValue newValue) {
    boolean restricted = variableInstance.isRestricted();

    if (restricted
        && hasNoEffectiveChange(variableInstance, newValue)
        && isAuthorized(VariablePermissions.READ_RESTRICTED)) {
      return newValue;
    }

    checkAuthorization(VariablePermissions.UPDATE_RESTRICTED, restricted);
    return newValue;
  }

  @Override
  public void interceptDeleteVariable(CoreVariableInstance variableInstance) {
    if (!InternalVariableContext.isInternalWrite()) {
      checkAuthorization(VariablePermissions.DELETE_RESTRICTED, variableInstance.isRestricted());
    }
  }

  protected void checkAuthorization(VariablePermissions permission, boolean restricted) {
    if (restricted) {
      CommandContext commandContext = Context.getCommandContext();
      AuthorizationManager authorizationManager = commandContext.getAuthorizationManager();

      boolean wasAuthorizationCheckEnabled = commandContext.isAuthorizationCheckEnabled();
      try {
        // Force authorization check for restricted variables if authorization is
        // enabled engine-wide.
        // This ensures that even if authorization is disabled for custom code
        // (listeners/delegates),
        // restricted variable permissions are still enforced.
        if (authorizationManager.isAuthorizationEnabled()) {
          commandContext.enableAuthorizationCheck();
        }

        authorizationManager.checkAuthorization(permission, Resources.VARIABLE, ANY);
      } finally {
        if (!wasAuthorizationCheckEnabled) {
          commandContext.disableAuthorizationCheck();
        }
      }
    }
  }

  protected boolean isAuthorized(VariablePermissions permission) {
    CommandContext commandContext = Context.getCommandContext();
    if (commandContext != null) {
      AuthorizationManager authorizationManager = commandContext.getAuthorizationManager();
      if (authorizationManager != null) {
        boolean wasAuthorizationCheckEnabled = commandContext.isAuthorizationCheckEnabled();
        try {
          if (authorizationManager.isAuthorizationEnabled()) {
            commandContext.enableAuthorizationCheck();
          }
          return authorizationManager.isAuthorized(permission, Resources.VARIABLE, ANY);
        } finally {
          if (!wasAuthorizationCheckEnabled) {
            commandContext.disableAuthorizationCheck();
          }
        }
      }
    }
    return true;
  }

  protected boolean hasNoEffectiveChange(CoreVariableInstance variableInstance, TypedValue newValue) {
    if (newValue == null) {
      return false;
    }

    final TypedValue[] currentValueHolder = new TypedValue[1];
    InternalVariableContext.executeAsInternalRead(() -> currentValueHolder[0] = variableInstance.getTypedValue(false));

    TypedValue currentValue = currentValueHolder[0];
    if (currentValue == null) {
      return false;
    }

    if (currentValue.isTransient() != newValue.isTransient()) {
      return false;
    }

    if (variableInstance.isRestricted() != newValue.isRestricted()) {
      if (!(variableInstance.isRestricted() && !newValue.isRestricted())) {
        return false;
      }
    }

    String currentTypeName = currentValue.getType() != null ? currentValue.getType().getName() : null;
    String newTypeName = newValue.getType() != null ? newValue.getType().getName() : null;
    if (!Objects.equals(currentTypeName, newTypeName)) {
      return false;
    }

    return Objects.deepEquals(currentValue.getValue(), newValue.getValue());
  }

}
