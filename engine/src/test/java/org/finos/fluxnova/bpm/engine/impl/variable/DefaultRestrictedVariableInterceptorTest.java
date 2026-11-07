package org.finos.fluxnova.bpm.engine.impl.variable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.finos.fluxnova.bpm.engine.authorization.VariablePermissions.CREATE_RESTRICTED;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.finos.fluxnova.bpm.engine.authorization.VariablePermissions;
import org.finos.fluxnova.bpm.engine.impl.core.variable.CoreVariableInstance;
import org.finos.fluxnova.bpm.engine.runtime.VariableInstance;
import org.finos.fluxnova.bpm.engine.variable.Variables;
import org.finos.fluxnova.bpm.engine.variable.value.TypedValue;
import org.junit.Test;

public class DefaultRestrictedVariableInterceptorTest {

  @Test
  public void shouldBypassReadFilterDuringInternalRead() {
    TestInterceptor interceptor = new TestInterceptor();
    interceptor.authorized = false;

    VariableInstance variableInstance = mock(VariableInstance.class);
    when(variableInstance.isRestricted()).thenReturn(true);

    TypedValue value = Variables.stringValue("secret");

    TypedValue filteredValue = interceptor.interceptGetVariable(variableInstance, value);
    assertNull(filteredValue);

    final TypedValue[] internalReadResult = new TypedValue[1];
    InternalVariableContext.executeAsInternalRead(
        () -> internalReadResult[0] = interceptor.interceptGetVariable(variableInstance, value));

    assertNotNull(internalReadResult[0]);
    assertEquals("secret", internalReadResult[0].getValue());
  }

  @Test
  public void shouldStillCheckCreatePermissionDuringInternalRead() {
    TestInterceptor interceptor = new TestInterceptor();

    CoreVariableInstance variableInstance = mock(CoreVariableInstance.class);
    when(variableInstance.isRestricted()).thenReturn(true);

    InternalVariableContext.executeAsInternalRead(() -> interceptor.interceptCreateVariable(variableInstance));

    assertEquals(1, interceptor.checkAuthorizationInvocations);
    assertEquals(CREATE_RESTRICTED, interceptor.lastPermission);
    assertEquals(true, interceptor.lastRestricted);
  }

  protected static class TestInterceptor extends DefaultRestrictedVariableInterceptor {

    protected boolean authorized = true;
    protected int checkAuthorizationInvocations;
    protected VariablePermissions lastPermission;
    protected boolean lastRestricted;

    @Override
    protected boolean isAuthorized(VariablePermissions permission) {
      return authorized;
    }

    @Override
    protected void checkAuthorization(VariablePermissions permission, boolean restricted) {
      checkAuthorizationInvocations++;
      lastPermission = permission;
      lastRestricted = restricted;
    }
  }
}