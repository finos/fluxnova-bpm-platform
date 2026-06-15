package org.finos.fluxnova.bpm.engine.test.api.authorization.task;

import static org.finos.fluxnova.bpm.engine.authorization.Authorization.ANY;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.finos.fluxnova.bpm.engine.authorization.Permissions.READ;
import static org.finos.fluxnova.bpm.engine.authorization.Permissions.UPDATE;
import static org.finos.fluxnova.bpm.engine.authorization.Resources.PROCESS_DEFINITION;
import static org.finos.fluxnova.bpm.engine.authorization.Resources.PROCESS_INSTANCE;
import static org.finos.fluxnova.bpm.engine.authorization.Resources.TASK;
import static org.finos.fluxnova.bpm.engine.authorization.Resources.VARIABLE;
import static org.junit.Assert.fail;

import org.finos.fluxnova.bpm.engine.AuthorizationException;
import org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration;
import org.finos.fluxnova.bpm.engine.authorization.VariablePermissions;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.RequiredHistoryLevel;
import org.finos.fluxnova.bpm.engine.test.api.authorization.AuthorizationTest;
import org.finos.fluxnova.bpm.engine.variable.VariableOptions;
import org.finos.fluxnova.bpm.engine.variable.Variables;
import org.junit.Test;

@RequiredHistoryLevel(ProcessEngineConfiguration.HISTORY_AUDIT)
public class RestrictedVariableTaskCompletionTest extends AuthorizationTest {

  protected static final String PROCESS_KEY = "oneTaskProcess";
  protected static final String RESTRICTED_VARIABLE_NAME = "restrictedVar";
  protected static final String RESTRICTED_VARIABLE_VALUE = "secretValue";
  protected static final String NEW_RESTRICTED_VARIABLE_NAME = "newRestrictedVar";
  protected static final String NEW_RESTRICTED_VARIABLE_VALUE = "secret";
  protected static final String PUBLIC_VARIABLE_NAME = "publicVar";
  protected static final String PUBLIC_VARIABLE_VALUE = "publicValue";

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testCompleteWithTaskLocalRestrictedVariable() {
    // given
    ProcessInstance processInstance = startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();

    setTaskVariableLocal(task.getId(), RESTRICTED_VARIABLE_NAME,
        Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));

    grantTaskCompletionPermissions();

    // when
    taskService.complete(task.getId());

    // then
    assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult());
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testCompleteWithProcessRestrictedVariable() {
    // given
    ProcessInstance processInstance = startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();

    setExecutionVariable(processInstance.getId(), RESTRICTED_VARIABLE_NAME,
        Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));

    grantTaskCompletionPermissions();

    // when
    taskService.complete(task.getId());

    // then
    assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult());
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testCompleteDeniedOnUserProvidedRestrictedVariable() {
    // given
    startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();
    grantTaskCompletionPermissions();

    // when
    try {
      taskService.complete(task.getId(), Variables.createVariables().putValueTyped(
          NEW_RESTRICTED_VARIABLE_NAME,
          Variables.stringValue(NEW_RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true))));
      fail("Expected AuthorizationException");
    } catch (AuthorizationException e) {
      // then
      assertEquals(VariablePermissions.CREATE_RESTRICTED.getName(), e.getMissingAuthorizations().get(0).getViolatedPermissionName());
    }
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testCompleteAllowedOnUserProvidedRestrictedVariable() {
    // given
    ProcessInstance processInstance = startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();
    grantTaskCompletionPermissions();
    grantRestrictedVariablePermissions();

    // when
    taskService.complete(task.getId(), Variables.createVariables().putValueTyped(
            NEW_RESTRICTED_VARIABLE_NAME,
            Variables.stringValue(NEW_RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true))));

    // then
    assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult());

        // Verify variable was created with restricted flag in history
    identityService.clearAuthentication();
        assertTrue(historyService.createHistoricVariableInstanceQuery()
            .variableName(NEW_RESTRICTED_VARIABLE_NAME)
            .singleResult()
          .isRestricted());


  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testCompleteDeniedOnUserProvidedRestrictedAndPublicVariables() {
    // given
    ProcessInstance processInstance = startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();
    grantTaskCompletionPermissions();

    try {
      taskService.complete(task.getId(), Variables.createVariables()
          .putValue(PUBLIC_VARIABLE_NAME, PUBLIC_VARIABLE_VALUE)
          .putValueTyped(
              NEW_RESTRICTED_VARIABLE_NAME,
              Variables.stringValue(NEW_RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true))));
      fail("Expected AuthorizationException");
    } catch (AuthorizationException e) {
      assertEquals(VariablePermissions.CREATE_RESTRICTED.getName(), e.getMissingAuthorizations().get(0).getViolatedPermissionName());
    }

    assertNull(runtimeService.getVariable(processInstance.getId(), PUBLIC_VARIABLE_NAME));
    assertNull(runtimeService.getVariable(processInstance.getId(), NEW_RESTRICTED_VARIABLE_NAME));
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testCompleteDeniedOnUpdateOfExistingRestrictedVariable() {
    // given
    ProcessInstance processInstance = startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();

    setTaskVariable(task.getId(), RESTRICTED_VARIABLE_NAME,
            Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));

    grantTaskCompletionPermissions();
    // Manually grant only CREATE to verify it specifically fails on UPDATE
    createGrantAuthorization(VARIABLE, ANY, userId, VariablePermissions.CREATE_RESTRICTED);

    // then
    try {
      taskService.complete(task.getId(), Variables.createVariables().putValueTyped(
              RESTRICTED_VARIABLE_NAME,
              Variables.stringValue("updatedValue", VariableOptions.options(false, true))));
      fail("Expected AuthorizationException due to missing UPDATE_RESTRICTED permission");
    } catch (AuthorizationException e) {
      // then: The missing permission should be UPDATE_RESTRICTED
      assertEquals(VariablePermissions.UPDATE_RESTRICTED.getName(), e.getMissingAuthorizations().get(0).getViolatedPermissionName());
    }
    assertNull(runtimeService.getVariable(processInstance.getId(), NEW_RESTRICTED_VARIABLE_NAME));
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testCompleteDeniedOnModifyingExistingRestrictedVariableWithReadPermissionAndUntaggedPayload() {
    // given
    ProcessInstance processInstance = startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();

    setTaskVariable(task.getId(), RESTRICTED_VARIABLE_NAME,
        Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));

    grantTaskCompletionPermissions();
    createGrantAuthorization(VARIABLE, ANY, userId, VariablePermissions.READ_RESTRICTED);

    // when
    try {
      taskService.complete(task.getId(), Variables.createVariables().putValueTyped(
          RESTRICTED_VARIABLE_NAME,
          Variables.stringValue("updatedValue")));
      fail("Expected AuthorizationException due to missing UPDATE_RESTRICTED permission");
    } catch (AuthorizationException e) {
      // then
      assertEquals(VariablePermissions.UPDATE_RESTRICTED.getName(), e.getMissingAuthorizations().get(0).getViolatedPermissionName());
    }

    // and: value remains unchanged
    Object value = runWithoutAuthorization(() -> runtimeService.getVariable(processInstance.getId(), RESTRICTED_VARIABLE_NAME));
    assertEquals(RESTRICTED_VARIABLE_VALUE, value);
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testCompleteAllowedOnResubmittingUnchangedRestrictedVariableWithReadPermission() {
    // given
    ProcessInstance processInstance = startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();

    setTaskVariable(task.getId(), RESTRICTED_VARIABLE_NAME,
        Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));

    grantTaskCompletionPermissions();
    createGrantAuthorization(VARIABLE, ANY, userId, VariablePermissions.READ_RESTRICTED);

    // when: resubmit without restriction tag (as tasklist does)
    taskService.complete(task.getId(), Variables.createVariables().putValueTyped(
        RESTRICTED_VARIABLE_NAME,
        Variables.stringValue(RESTRICTED_VARIABLE_VALUE)));

    // then
    assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult());

    Object historicValue = runWithoutAuthorization(() -> historyService.createHistoricVariableInstanceQuery()
        .variableName(RESTRICTED_VARIABLE_NAME)
        .singleResult()
        .getValue());
    assertEquals(RESTRICTED_VARIABLE_VALUE, historicValue);
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testCompleteTaskWithExistingRestrictedVariableNoPermissions() {
    // given
    ProcessInstance processInstance = startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();

    setTaskVariableLocal(task.getId(), RESTRICTED_VARIABLE_NAME,
            Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));

    // when
    grantTaskCompletionPermissions();
    // (Notice: no call to grantRestrictedVariablePermissions here)

    // then
    identityService.setAuthenticatedUserId(userId);
    try {
      taskService.getVariableTyped(task.getId(), RESTRICTED_VARIABLE_NAME);
    } finally {
      identityService.clearAuthentication();
    }

    taskService.complete(task.getId());

    assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult());

    identityService.clearAuthentication();
    Object historicValue = historyService.createHistoricVariableInstanceQuery()
            .variableName(RESTRICTED_VARIABLE_NAME)
            .singleResult()
            .getValue();

    assertEquals(RESTRICTED_VARIABLE_VALUE, historicValue);

    // Also verify it's NOT a null type
    org.finos.fluxnova.bpm.engine.variable.value.TypedValue historicTypedValue = historyService.createHistoricVariableInstanceQuery()
            .variableName(RESTRICTED_VARIABLE_NAME)
            .singleResult()
            .getTypedValue();
    assertEquals("string", historicTypedValue.getType().getName());
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testSubmitTaskFormDeniedOnUserProvidedRestrictedVariable() {
    // given
    startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();
    grantTaskCompletionPermissions();
    // No restricted variable permissions granted

    // when
    try {
      formService.submitTaskForm(task.getId(), Variables.createVariables().putValueTyped(
              NEW_RESTRICTED_VARIABLE_NAME,
              Variables.stringValue(NEW_RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true))));
      fail("Expected AuthorizationException");
    } catch (AuthorizationException e) {
      // then
      assertEquals(VariablePermissions.CREATE_RESTRICTED.getName(), e.getMissingAuthorizations().get(0).getViolatedPermissionName());
    }
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testSubmitTaskFormAllowedWithRestrictedVariablePermissions() {
    // given
    ProcessInstance processInstance = startProcessInstanceByKey(PROCESS_KEY);
    Task task = selectSingleTask();

    grantTaskCompletionPermissions();
    grantRestrictedVariablePermissions();

    // when
    formService.submitTaskForm(task.getId(), Variables.createVariables().putValueTyped(
            NEW_RESTRICTED_VARIABLE_NAME,
            Variables.stringValue(NEW_RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true))));

    // then
    assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).singleResult());

        // Verify variable was created with restricted flag in history
    identityService.clearAuthentication();
        assertTrue(historyService.createHistoricVariableInstanceQuery()
            .variableName(NEW_RESTRICTED_VARIABLE_NAME)
            .singleResult()
          .isRestricted());
  }

  protected void grantTaskCompletionPermissions() {
    createGrantAuthorization(PROCESS_DEFINITION, ANY, userId, READ);
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, READ);
    createGrantAuthorization(TASK, ANY, userId, READ, UPDATE);
  }

  protected void grantRestrictedVariablePermissions() {
    createGrantAuthorization(VARIABLE, ANY, userId, VariablePermissions.READ_RESTRICTED, VariablePermissions.CREATE_RESTRICTED, VariablePermissions.UPDATE_RESTRICTED, VariablePermissions.DELETE_RESTRICTED);
  }

}
