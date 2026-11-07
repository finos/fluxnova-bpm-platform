package org.finos.fluxnova.bpm.engine.test.api.authorization;

import static org.finos.fluxnova.bpm.engine.authorization.Authorization.ANY;
import static org.finos.fluxnova.bpm.engine.authorization.Permissions.ALL;
import static org.finos.fluxnova.bpm.engine.authorization.Permissions.READ;
import static org.finos.fluxnova.bpm.engine.authorization.Resources.PROCESS_INSTANCE;
import static org.finos.fluxnova.bpm.engine.authorization.Resources.TASK;
import static org.finos.fluxnova.bpm.engine.authorization.Resources.VARIABLE;
import static org.finos.fluxnova.bpm.engine.authorization.VariablePermissions.CREATE_RESTRICTED;
import static org.finos.fluxnova.bpm.engine.authorization.VariablePermissions.DELETE_RESTRICTED;
import static org.finos.fluxnova.bpm.engine.authorization.VariablePermissions.READ_RESTRICTED;
import static org.finos.fluxnova.bpm.engine.authorization.VariablePermissions.UPDATE_RESTRICTED;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.finos.fluxnova.bpm.engine.AuthorizationException;
import org.finos.fluxnova.bpm.engine.authorization.Permissions;
import org.finos.fluxnova.bpm.engine.history.HistoricVariableInstance;
import org.finos.fluxnova.bpm.engine.runtime.VariableInstance;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.variable.VariableMap;
import org.finos.fluxnova.bpm.engine.variable.VariableOptions;
import org.finos.fluxnova.bpm.engine.variable.Variables;
import org.junit.Test;

/**
 * Tests for Resources.VARIABLE and VariablePermissions.
 */
public class VariableAuthorizationTest extends AuthorizationTest {

  protected static final String ONE_TASK_PROCESS =
      "org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml";
  protected static final String PROCESS_KEY = "oneTaskProcess";
  protected static final String RESTRICTED_VARIABLE_NAME = "restrictedVar";
  protected static final String RESTRICTED_VARIABLE_VALUE = "secret";
  protected static final String UPDATED_VARIABLE_VALUE = "newSecret";
  protected static final String PUBLIC_VARIABLE_NAME = "publicVar";
  protected static final String PUBLIC_VARIABLE_VALUE = "publicValue";

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testCreateDenied() {
    // given
    String processInstanceId = startProcessInstanceByKey(PROCESS_KEY).getId();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);

    try {
      runtimeService.setVariable(
          processInstanceId,
          RESTRICTED_VARIABLE_NAME,
          Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));
      fail("Should throw AuthorizationException");
    } catch (AuthorizationException e) {
      testRule.assertTextPresent(CREATE_RESTRICTED.getName(), e.getMessage());
    }
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testCreateAllowed() {
    String processInstanceId = startProcessInstanceByKey(PROCESS_KEY).getId();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);
    createGrantAuthorization(VARIABLE, ANY, userId, CREATE_RESTRICTED, READ_RESTRICTED);

    runtimeService.setVariable(
        processInstanceId,
        RESTRICTED_VARIABLE_NAME,
        Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));

    VariableInstance variableInstance =
        runtimeService.createVariableInstanceQuery().variableName(RESTRICTED_VARIABLE_NAME).singleResult();
    assertEquals(RESTRICTED_VARIABLE_VALUE, variableInstance.getValue());
    assertTrue(variableInstance.isRestricted());
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testCreateDeniedWrongTag() {
    String processInstanceId = startProcessInstanceByKey(PROCESS_KEY).getId();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);
    createGrantAuthorization(VARIABLE, "different_tag", userId, CREATE_RESTRICTED);

    try {
      runtimeService.setVariable(
          processInstanceId,
          RESTRICTED_VARIABLE_NAME,
          Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));
      fail("Should throw AuthorizationException");
    } catch (AuthorizationException e) {
      testRule.assertTextPresent(CREATE_RESTRICTED.getName(), e.getMessage());
    }
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testCreateAllowedAnyTag() {
    String processInstanceId = startProcessInstanceByKey(PROCESS_KEY).getId();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);
    createGrantAuthorization(VARIABLE, ANY, userId, CREATE_RESTRICTED, READ_RESTRICTED);

    runtimeService.setVariable(
        processInstanceId,
        RESTRICTED_VARIABLE_NAME,
        Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));

    VariableInstance variableInstance =
        runtimeService.createVariableInstanceQuery().variableName(RESTRICTED_VARIABLE_NAME).singleResult();
    assertEquals(RESTRICTED_VARIABLE_VALUE, variableInstance.getValue());
    assertTrue(variableInstance.isRestricted());
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testUpdateDenied() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);

    try {
      runtimeService.setVariable(processInstanceId, RESTRICTED_VARIABLE_NAME, UPDATED_VARIABLE_VALUE);
      fail("Should throw AuthorizationException");
    } catch (AuthorizationException e) {
      testRule.assertTextPresent(UPDATE_RESTRICTED.getName(), e.getMessage());
    }
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testUpdateAllowed() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);
    createGrantAuthorization(VARIABLE, ANY, userId, UPDATE_RESTRICTED, READ_RESTRICTED);

    runtimeService.setVariable(processInstanceId, RESTRICTED_VARIABLE_NAME, UPDATED_VARIABLE_VALUE);

    assertEquals(UPDATED_VARIABLE_VALUE, runtimeService.getVariable(processInstanceId, RESTRICTED_VARIABLE_NAME));
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testBulkUpdateDenied() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);

    try {
      runtimeService.setVariables(processInstanceId, Variables.createVariables()
          .putValue(RESTRICTED_VARIABLE_NAME, UPDATED_VARIABLE_VALUE)
          .putValue(PUBLIC_VARIABLE_NAME, PUBLIC_VARIABLE_VALUE));
      fail("Should throw AuthorizationException");
    } catch (AuthorizationException e) {
      testRule.assertTextPresent(UPDATE_RESTRICTED.getName(), e.getMessage());
    }

    assertNull(runtimeService.getVariable(processInstanceId, PUBLIC_VARIABLE_NAME));
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testBulkUpdateAllowed() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);
    createGrantAuthorization(VARIABLE, ANY, userId, UPDATE_RESTRICTED, READ_RESTRICTED);

    runtimeService.setVariables(processInstanceId, Variables.createVariables()
        .putValue(RESTRICTED_VARIABLE_NAME, UPDATED_VARIABLE_VALUE)
        .putValue(PUBLIC_VARIABLE_NAME, PUBLIC_VARIABLE_VALUE));

    assertEquals(UPDATED_VARIABLE_VALUE, runtimeService.getVariable(processInstanceId, RESTRICTED_VARIABLE_NAME));
    assertEquals(PUBLIC_VARIABLE_VALUE, runtimeService.getVariable(processInstanceId, PUBLIC_VARIABLE_NAME));
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testUpdateDeniedWrongTag() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);
    createGrantAuthorization(VARIABLE, "different_tag", userId, UPDATE_RESTRICTED);

    try {
      runtimeService.setVariable(processInstanceId, RESTRICTED_VARIABLE_NAME, UPDATED_VARIABLE_VALUE);
      fail("Should throw AuthorizationException");
    } catch (AuthorizationException e) {
      testRule.assertTextPresent(UPDATE_RESTRICTED.getName(), e.getMessage());
    }
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testUpdateAllowedAnyTag() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);
    createGrantAuthorization(VARIABLE, ANY, userId, UPDATE_RESTRICTED, READ_RESTRICTED);

    runtimeService.setVariable(processInstanceId, RESTRICTED_VARIABLE_NAME, UPDATED_VARIABLE_VALUE);

    assertEquals(UPDATED_VARIABLE_VALUE, runtimeService.getVariable(processInstanceId, RESTRICTED_VARIABLE_NAME));
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testDeleteDenied() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);

    try {
      runtimeService.removeVariable(processInstanceId, RESTRICTED_VARIABLE_NAME);
      fail("Should throw AuthorizationException");
    } catch (AuthorizationException e) {
      testRule.assertTextPresent(DELETE_RESTRICTED.getName(), e.getMessage());
    }
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testDeleteAllowed() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);
    createGrantAuthorization(VARIABLE, ANY, userId, DELETE_RESTRICTED);

    runtimeService.removeVariable(processInstanceId, RESTRICTED_VARIABLE_NAME);

    assertNull(runtimeService.getVariable(processInstanceId, RESTRICTED_VARIABLE_NAME));
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testDeleteDeniedWrongTag() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);
    createGrantAuthorization(VARIABLE, "different_tag", userId, DELETE_RESTRICTED);

    try {
      runtimeService.removeVariable(processInstanceId, RESTRICTED_VARIABLE_NAME);
      fail("Should throw AuthorizationException");
    } catch (AuthorizationException e) {
      testRule.assertTextPresent(DELETE_RESTRICTED.getName(), e.getMessage());
    }
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testDeleteAllowedAnyTag() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, ALL);
    createGrantAuthorization(VARIABLE, ANY, userId, DELETE_RESTRICTED);

    runtimeService.removeVariable(processInstanceId, RESTRICTED_VARIABLE_NAME);

    assertNull(runtimeService.getVariable(processInstanceId, RESTRICTED_VARIABLE_NAME));
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testReadFiltered() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    setExecutionVariable(processInstanceId, "publicVar", "publicValue");
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, READ);

    VariableInstance restrictedVar = runtimeService.createVariableInstanceQuery()
        .variableName(RESTRICTED_VARIABLE_NAME)
        .singleResult();
    VariableInstance publicVar = runtimeService.createVariableInstanceQuery()
        .variableName("publicVar")
        .singleResult();

    assertEquals("publicValue", publicVar.getValue());
    assertNull(restrictedVar);
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testReadFilteredFromMap() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    setExecutionVariable(processInstanceId, "publicVar", "publicValue");
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, READ);

    // When getting all variables as a map
    Map<String, Object> variables = runtimeService.getVariables(processInstanceId);

    // Then the restricted variable key should NOT be present at all
    assertEquals(1, variables.size());
    assertTrue(variables.containsKey("publicVar"));
    assertFalse(variables.containsKey(RESTRICTED_VARIABLE_NAME));
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testReadFilteredFromFormVariables() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, READ);
    createGrantAuthorization(TASK, ANY, userId, Permissions.READ);

    String taskId = taskService.createTaskQuery().processInstanceId(processInstanceId).singleResult().getId();

    // When getting form variables (the path used by Tasklist)
    VariableMap formVariables = formService.getTaskFormVariables(taskId);

    // Then the restricted variable should be filtered out
    assertFalse(formVariables.containsKey(RESTRICTED_VARIABLE_NAME));
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testHistoricReadFiltered() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, READ);

    // When querying historic variables
    List<HistoricVariableInstance> history = historyService.createHistoricVariableInstanceQuery()
        .processInstanceId(processInstanceId)
        .list();

    // Then restricted variables should be absent
    assertTrue(history.isEmpty());
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testReadAllowed() {
    String processInstanceId = createProcessInstanceWithRestrictedVariable();
    setExecutionVariable(processInstanceId, "publicVar", "publicValue");
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, READ);
    createGrantAuthorization(VARIABLE, ANY, userId, READ_RESTRICTED);

    VariableInstance restrictedVar = runtimeService.createVariableInstanceQuery()
        .variableName(RESTRICTED_VARIABLE_NAME)
        .singleResult();
    VariableInstance publicVar = runtimeService.createVariableInstanceQuery()
        .variableName("publicVar")
        .singleResult();

    assertEquals("publicValue", publicVar.getValue());
    assertEquals(RESTRICTED_VARIABLE_VALUE, restrictedVar.getValue());
  }





  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testReadFilteredWrongTag() {
    createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, READ);
    createGrantAuthorization(VARIABLE, "different_tag", userId, READ_RESTRICTED);

    VariableInstance variableInstance =
        runtimeService.createVariableInstanceQuery().variableName(RESTRICTED_VARIABLE_NAME).singleResult();

    assertNull(variableInstance);
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testReadAllowedAnyTag() {
    createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(PROCESS_INSTANCE, ANY, userId, READ);
    createGrantAuthorization(VARIABLE, ANY, userId, READ_RESTRICTED);

    VariableInstance variableInstance =
        runtimeService.createVariableInstanceQuery().variableName(RESTRICTED_VARIABLE_NAME).singleResult();

    assertEquals(RESTRICTED_VARIABLE_VALUE, variableInstance.getValue());
    assertTrue(variableInstance.isRestricted());
  }

  @Test
  @Deployment(resources = ONE_TASK_PROCESS)
  public void testReadNotReturnedWithoutProcessRead() {
    createProcessInstanceWithRestrictedVariable();
    createGrantAuthorization(VARIABLE, ANY, userId, READ_RESTRICTED);

    verifyQueryResults(runtimeService.createVariableInstanceQuery().variableName(RESTRICTED_VARIABLE_NAME), 0);
  }

  protected String createProcessInstanceWithRestrictedVariable() {
    return runWithoutAuthorization(() -> {
      String processInstanceId = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();
      runtimeService.setVariable(
          processInstanceId,
          RESTRICTED_VARIABLE_NAME,
          Variables.stringValue(RESTRICTED_VARIABLE_VALUE, VariableOptions.options(false, true)));
      return processInstanceId;
    });
  }
}
