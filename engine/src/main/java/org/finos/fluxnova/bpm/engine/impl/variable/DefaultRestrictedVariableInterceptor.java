package org.finos.fluxnova.bpm.engine.impl.variable;

import static org.finos.fluxnova.bpm.engine.authorization.Authorization.ANY;

import java.util.Objects;

import org.finos.fluxnova.bpm.engine.authorization.Resources;
import org.finos.fluxnova.bpm.engine.authorization.VariablePermissions;
import org.finos.fluxnova.bpm.engine.history.HistoricVariableInstance;
import org.finos.fluxnova.bpm.engine.impl.context.Context;
import org.finos.fluxnova.bpm.engine.impl.core.variable.CoreVariableInstance;
import org.finos.fluxnova.bpm.engine.impl.db.CompositePermissionCheck;
import org.finos.fluxnova.bpm.engine.impl.db.PermissionCheckBuilder;
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
    if (variableInstance.isRestricted() && !isAuthorizedToReadRestricted()) {
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
        && isAuthorizedToReadRestricted()) {
      // No-op resubmit (same value, same restricted flag): UPDATE_RESTRICTED is not required.
      return newValue;
    }

    checkAuthorization(VariablePermissions.UPDATE_RESTRICTED, restricted);

    // The restricted flag is taken at face value from the payload: callers (and their UI) are
    // responsible for explicitly re-asserting it on every update; it is not preserved implicitly.
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

  // UPDATE_RESTRICTED implies READ_RESTRICTED: being authorized to update a restricted
  // variable's value also authorizes seeing it, so the two permissions are checked disjunctively.
  protected boolean isAuthorizedToReadRestricted() {
    CommandContext commandContext = Context.getCommandContext();
    if (commandContext != null) {
      AuthorizationManager authorizationManager = commandContext.getAuthorizationManager();
      if (authorizationManager != null) {
        boolean wasAuthorizationCheckEnabled = commandContext.isAuthorizationCheckEnabled();
        try {
          if (authorizationManager.isAuthorizationEnabled()) {
            commandContext.enableAuthorizationCheck();
          }
          CompositePermissionCheck check = new PermissionCheckBuilder()
              .disjunctive()
              .atomicCheckForResourceId(Resources.VARIABLE, ANY, VariablePermissions.READ_RESTRICTED)
              .atomicCheckForResourceId(Resources.VARIABLE, ANY, VariablePermissions.UPDATE_RESTRICTED)
              .build();
          return authorizationManager.isAuthorized(check);
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

    // No internal-read bypass needed here: UPDATE_RESTRICTED implies READ_RESTRICTED, so a user
    // who reaches this point (authorized to update) is also authorized to read the current value.
    TypedValue currentValue = variableInstance.getTypedValue(false);
    if (currentValue == null) {
      return false;
    }

    if (currentValue.isTransient() != newValue.isTransient()) {
      return false;
    }

    // a change to the restricted flag is itself a real, privileged change, never a no-op
    if (variableInstance.isRestricted() != newValue.isRestricted()) {
      return false;
    }

    String currentTypeName = currentValue.getType() != null ? currentValue.getType().getName() : null;
    String newTypeName = newValue.getType() != null ? newValue.getType().getName() : null;
    if (!Objects.equals(currentTypeName, newTypeName)) {
      return false;
    }

    return Objects.deepEquals(currentValue.getValue(), newValue.getValue());
  }

}
