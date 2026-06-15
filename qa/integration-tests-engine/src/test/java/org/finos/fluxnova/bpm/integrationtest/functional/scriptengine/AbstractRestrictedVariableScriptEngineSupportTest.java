package org.finos.fluxnova.bpm.integrationtest.functional.scriptengine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.finos.fluxnova.bpm.engine.runtime.VariableInstance;
import org.finos.fluxnova.bpm.integrationtest.util.AbstractFoxPlatformIntegrationTest;
import org.finos.fluxnova.bpm.model.bpmn.Bpmn;
import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public abstract class AbstractRestrictedVariableScriptEngineSupportTest extends AbstractFoxPlatformIntegrationTest {

  protected static final String CREATE_PROCESS_ID = "restrictedCreateProcess";
  protected static final String READ_PROCESS_ID = "restrictedReadProcess";
  protected static final String OVERWRITE_PROCESS_ID = "restrictedOverwriteProcess";

  protected static final String RESTRICTED_VAR = "restrictedVar";
  protected static final String DERIVED_PUBLIC_VAR = "derivedPublic";

  protected static final String SECRET_VALUE = "secret";
  protected static final String DERIVED_VALUE = "secret_seen";
  protected static final String OVERWRITTEN_VALUE = "plain-update";

  protected static StringAsset createSingleScriptProcess(String processId, String scriptFormat, String scriptText) {
    BpmnModelInstance modelInstance = Bpmn.createExecutableProcess(processId)
        .fluxnovaHistoryTimeToLive(180)
      .startEvent()
      .scriptTask()
        .scriptFormat(scriptFormat)
        .scriptText(scriptText)
      .userTask()
      .endEvent()
      .done();
    return new StringAsset(Bpmn.convertToString(modelInstance));
  }

  protected static StringAsset createTwoScriptProcess(
      String processId,
      String scriptFormat,
      String firstScript,
      String secondScript) {
    BpmnModelInstance modelInstance = Bpmn.createExecutableProcess(processId)
        .fluxnovaHistoryTimeToLive(180)
      .startEvent()
      .scriptTask()
        .scriptFormat(scriptFormat)
        .scriptText(firstScript)
      .scriptTask()
        .scriptFormat(scriptFormat)
        .scriptText(secondScript)
      .userTask()
      .endEvent()
      .done();
    return new StringAsset(Bpmn.convertToString(modelInstance));
  }

  @Test
  public void shouldCreateRestrictedVariableFromScript() {
    String processInstanceId = runtimeService.startProcessInstanceByKey(CREATE_PROCESS_ID).getId();

    VariableInstance variableInstance = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(processInstanceId)
        .variableName(RESTRICTED_VAR)
        .singleResult();

    assertNotNull(variableInstance);
    assertEquals(SECRET_VALUE, variableInstance.getValue());
    assertTrue(variableInstance.isRestricted());
  }

  @Test
  public void shouldReadRestrictedVariableFromScriptAndCreateDerivedPublicVariable() {
    String processInstanceId = runtimeService.startProcessInstanceByKey(READ_PROCESS_ID).getId();

    Object derivedValue = runtimeService.getVariable(processInstanceId, DERIVED_PUBLIC_VAR);
    assertEquals(DERIVED_VALUE, derivedValue);

    VariableInstance restrictedVar = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(processInstanceId)
        .variableName(RESTRICTED_VAR)
        .singleResult();

    assertNotNull(restrictedVar);
    assertEquals(SECRET_VALUE, restrictedVar.getValue());
    assertTrue(restrictedVar.isRestricted());
  }

  @Test
  public void shouldClearRestrictionWhenOverwritingRestrictedVariableWithPlainValue() {
    String processInstanceId = runtimeService.startProcessInstanceByKey(OVERWRITE_PROCESS_ID).getId();

    VariableInstance variableInstance = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(processInstanceId)
        .variableName(RESTRICTED_VAR)
        .singleResult();

    assertNotNull(variableInstance);
    assertEquals(OVERWRITTEN_VALUE, variableInstance.getValue());
    assertFalse(variableInstance.isRestricted());
  }
}
