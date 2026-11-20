package org.finos.fluxnova.bpm.engine.impl.variable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.finos.fluxnova.bpm.engine.authorization.VariablePermissions.CREATE_RESTRICTED;
import static org.finos.fluxnova.bpm.engine.authorization.VariablePermissions.UPDATE_RESTRICTED;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.finos.fluxnova.bpm.engine.authorization.VariablePermissions;
import org.finos.fluxnova.bpm.engine.impl.core.variable.CoreVariableInstance;
import org.finos.fluxnova.bpm.engine.runtime.VariableInstance;
import org.finos.fluxnova.bpm.engine.variable.Variables;
import org.finos.fluxnova.bpm.engine.variable.VariableOptions;
import org.finos.fluxnova.bpm.engine.variable.value.TypedValue;
import org.junit.jupiter.api.Test;

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

  @Test
  public void shouldSkipUpdateAuthorizationForUnchangedValueAfterAuthorizedInternalRead() {
    TestInterceptor interceptor = new TestInterceptor();
    CoreVariableInstance variableInstance = mock(CoreVariableInstance.class);
    when(variableInstance.isRestricted()).thenReturn(true);

    TypedValue value = Variables.stringValue("secret", VariableOptions.options(false, true));
    when(variableInstance.getTypedValue(false)).thenAnswer(invocation -> {
      assertTrue(InternalVariableContext.isInternalRead());
      assertEquals(1, interceptor.readAuthorizationCheckInvocations);
      return value;
    });

    assertSame(value, interceptor.interceptUpdateVariable(variableInstance, value));
    assertEquals(1, interceptor.readAuthorizationCheckInvocations);
    assertEquals(0, interceptor.checkAuthorizationInvocations);
  }

  @Test
  public void shouldNotReadCurrentValueWhenCallerCannotReadRestrictedValue() {
    TestInterceptor interceptor = new TestInterceptor();
    interceptor.authorized = false;
    CoreVariableInstance variableInstance = mock(CoreVariableInstance.class);
    when(variableInstance.isRestricted()).thenReturn(true);

    TypedValue value = Variables.stringValue("secret", VariableOptions.options(false, true));

    assertSame(value, interceptor.interceptUpdateVariable(variableInstance, value));
    verify(variableInstance, never()).getTypedValue(false);
    assertEquals(1, interceptor.readAuthorizationCheckInvocations);
    assertEquals(1, interceptor.checkAuthorizationInvocations);
    assertEquals(UPDATE_RESTRICTED, interceptor.lastPermission);
  }

  protected static class TestInterceptor extends DefaultRestrictedVariableInterceptor {

    protected boolean authorized = true;
    protected int readAuthorizationCheckInvocations;
    protected int checkAuthorizationInvocations;
    protected VariablePermissions lastPermission;
    protected boolean lastRestricted;

    @Override
    protected boolean isAuthorized(VariablePermissions permission) {
      return authorized;
    }

    @Override
    protected boolean isAuthorizedToReadRestricted() {
      readAuthorizationCheckInvocations++;
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