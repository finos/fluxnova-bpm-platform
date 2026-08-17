package org.finos.fluxnova.bpm.engine.test.api.variables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.runtime.VariableInstance;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.util.PluggableProcessEngineTest;
import org.finos.fluxnova.bpm.engine.variable.VariableMap;
import org.finos.fluxnova.bpm.engine.variable.Variables;
import org.junit.Test;

public class RestrictedVariableCallActivityMappingTest extends PluggableProcessEngineTest {

  @Test
  @Deployment(resources = {
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingTest.bpmn20.xml",
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingSubprocess.bpmn20.xml"
  })
  public void shouldPropagateRestrictionForSourceExpressionInAndOutMappings() {
    VariableMap variables = Variables.createVariables().putValue("secret", "top-secret");

    ProcessInstance parentInstance = runtimeService.startProcessInstanceByKey("parentRestrictedIoMapping", variables);

    ProcessInstance subInstance = runtimeService.createProcessInstanceQuery()
        .superProcessInstanceId(parentInstance.getId())
        .singleResult();

    assertNotNull(subInstance);

    VariableInstance subSecretVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(subInstance.getId())
        .variableName("subSecret")
        .singleResult();

    assertNotNull(subSecretVariable);
    assertEquals("top-secret", subSecretVariable.getValue());
    assertTrue(subSecretVariable.isRestricted());

    Task subTask = taskService.createTaskQuery().processInstanceId(subInstance.getId()).singleResult();
    assertNotNull(subTask);
    taskService.complete(subTask.getId());

    VariableInstance parentResultVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(parentInstance.getId())
        .variableName("resultSecret")
        .singleResult();

    assertNotNull(parentResultVariable);
    assertEquals("top-secret", parentResultVariable.getValue());
    assertTrue(parentResultVariable.isRestricted());
  }

  @Test
  @Deployment(resources = {
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingSourceTest.bpmn20.xml",
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingSubprocess.bpmn20.xml"
  })
  public void shouldPropagateRestrictionForSourceInAndOutMappings() {
    VariableMap variables = Variables.createVariables().putValue("secret", "top-secret");

    ProcessInstance parentInstance = runtimeService.startProcessInstanceByKey("parentRestrictedIoMappingSource", variables);

    ProcessInstance subInstance = runtimeService.createProcessInstanceQuery()
        .superProcessInstanceId(parentInstance.getId())
        .singleResult();

    assertNotNull(subInstance);

    VariableInstance subSecretVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(subInstance.getId())
        .variableName("subSecret")
        .singleResult();

    assertNotNull(subSecretVariable);
    assertEquals("top-secret", subSecretVariable.getValue());
    assertTrue(subSecretVariable.isRestricted());

    Task subTask = taskService.createTaskQuery().processInstanceId(subInstance.getId()).singleResult();
    assertNotNull(subTask);
    taskService.complete(subTask.getId());

    VariableInstance parentResultVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(parentInstance.getId())
        .variableName("resultSecret")
        .singleResult();

    assertNotNull(parentResultVariable);
    assertEquals("top-secret", parentResultVariable.getValue());
    assertTrue(parentResultVariable.isRestricted());
  }

  @Test
  @Deployment(resources = {
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingSourceTest.bpmn20.xml",
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingSubprocess.bpmn20.xml"
  })
  public void shouldPreserveTransientFlagWhenRestrictedWithSource() {
    // source attribute preserves TypedValue, so transient flag should be maintained
    VariableMap variables = Variables.createVariables()
        .putValue("secret", Variables.integerValue(42, true)); // transient integer value

    ProcessInstance parentInstance = runtimeService.startProcessInstanceByKey("parentRestrictedIoMappingSource", variables);

    ProcessInstance subInstance = runtimeService.createProcessInstanceQuery()
        .superProcessInstanceId(parentInstance.getId())
        .singleResult();

    assertNotNull(subInstance);

    VariableInstance subSecretVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(subInstance.getId())
        .variableName("subSecret")
        .singleResult();

    // Transient values are not persisted across command boundaries, so the mapped variable
    // is expected to be absent when queried in a subsequent command.
    assertNull("Transient flag should be preserved with source attribute, resulting in no persisted variable", subSecretVariable);

    Task subTask = taskService.createTaskQuery().processInstanceId(subInstance.getId()).singleResult();
    assertNotNull(subTask);
    taskService.complete(subTask.getId());

    VariableInstance parentResultVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(parentInstance.getId())
        .variableName("resultSecret")
        .singleResult();

    // The transient source variable is not persisted in the subprocess, so out mapping resolves to null
    // and creates a restricted null variable in the parent scope.
    assertNotNull(parentResultVariable);
    assertNull("Out mapping should resolve to null when transient source variable is not persisted", parentResultVariable.getValue());
    assertTrue("Restricted flag should still be applied on out mapping", parentResultVariable.isRestricted());
  }

  @Test
  @Deployment(resources = {
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingLocalOutTest.bpmn20.xml",
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingSubprocess.bpmn20.xml"
  })
  public void shouldPropagateRestrictionForLocalOutMapping() {
    VariableMap variables = Variables.createVariables().putValue("secret", "top-secret");

    ProcessInstance parentInstance = runtimeService.startProcessInstanceByKey("parentRestrictedIoMappingLocalOut", variables);

    ProcessInstance subInstance = runtimeService.createProcessInstanceQuery()
        .superProcessInstanceId(parentInstance.getId())
        .singleResult();

    assertNotNull(subInstance);

    VariableInstance subSecretVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(subInstance.getId())
        .variableName("subSecret")
        .singleResult();

    assertNotNull(subSecretVariable);
    assertEquals("top-secret", subSecretVariable.getValue());
    assertTrue(subSecretVariable.isRestricted());

    Task subTask = taskService.createTaskQuery().processInstanceId(subInstance.getId()).singleResult();
    assertNotNull(subTask);
    taskService.complete(subTask.getId());

    VariableInstance parentResultVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(parentInstance.getId())
        .variableName("resultSecret")
        .singleResult();

    assertNotNull(parentResultVariable);
    assertEquals("top-secret", parentResultVariable.getValue());
    assertTrue("Restricted flag should be applied on local out mapping", parentResultVariable.isRestricted());
  }

  @Test
  @Deployment(resources = {
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingAllVariablesTest.bpmn20.xml",
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingSubprocess.bpmn20.xml"
  })
  public void shouldNotApplyRestrictionWhenVariablesAll() {
    // When variables="all" is used, the restriction should NOT be applied even if restricted="true" is specified.
    // This is intentional behavior to avoid unexpected restriction of all variables copied through variables="all".
    VariableMap variables = Variables.createVariables()
        .putValue("secret", "top-secret")
        .putValue("otherVar", "other-value");

    ProcessInstance parentInstance = runtimeService.startProcessInstanceByKey("parentRestrictedIoMappingAllVariables", variables);

    ProcessInstance subInstance = runtimeService.createProcessInstanceQuery()
        .superProcessInstanceId(parentInstance.getId())
        .singleResult();

    assertNotNull(subInstance);

    // When variables="all" is used for in-mapping, all parent variables should be copied without restriction
    VariableInstance subSecretVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(subInstance.getId())
        .variableName("secret")
        .singleResult();

    assertNotNull(subSecretVariable);
    assertEquals("top-secret", subSecretVariable.getValue());
    assertTrue("variables='all' should NOT apply restriction flag", !subSecretVariable.isRestricted());

    VariableInstance subOtherVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(subInstance.getId())
        .variableName("otherVar")
        .singleResult();

    assertNotNull(subOtherVariable);
    assertEquals("other-value", subOtherVariable.getValue());
    assertTrue("variables='all' should NOT apply restriction flag", !subOtherVariable.isRestricted());

    Task subTask = taskService.createTaskQuery().processInstanceId(subInstance.getId()).singleResult();
    assertNotNull(subTask);
    taskService.complete(subTask.getId());

    // When variables="all" is used for out-mapping, all child variables should be copied back without restriction
    VariableInstance parentSecretVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(parentInstance.getId())
        .variableName("secret")
        .singleResult();

    assertNotNull(parentSecretVariable);
    assertEquals("top-secret", parentSecretVariable.getValue());
    assertTrue("variables='all' out-mapping should NOT apply restriction flag", !parentSecretVariable.isRestricted());
  }

  @Test
  @Deployment(resources = {
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingTest.bpmn20.xml",
      "org/finos/fluxnova/bpm/engine/test/api/variables/RestrictedVariableCallActivityMappingSubprocess.bpmn20.xml"
  })
  public void shouldDropTransientFlagWhenRestrictedWithSourceExpression() {
    // sourceExpression uses EL evaluation which unwraps TypedValue, causing the transient flag to be lost.
    // This is expected behavior due to how VariableScopeElResolver works (calls getVariable() not getVariableTyped()).
    VariableMap variables = Variables.createVariables()
        .putValue("secret", Variables.integerValue(42, true)); // transient integer value

    ProcessInstance parentInstance = runtimeService.startProcessInstanceByKey("parentRestrictedIoMapping", variables);

    ProcessInstance subInstance = runtimeService.createProcessInstanceQuery()
        .superProcessInstanceId(parentInstance.getId())
        .singleResult();

    assertNotNull(subInstance);

    VariableInstance subSecretVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(subInstance.getId())
        .variableName("subSecret")
        .singleResult();

    assertNotNull(subSecretVariable);
    assertEquals(42, subSecretVariable.getValue());
    // The transient flag is lost because sourceExpression evaluates through EL which unwraps TypedValue
    assertTrue("Transient flag should be lost with sourceExpression (EL evaluator unwraps TypedValue)", !subSecretVariable.getTypedValue().isTransient());
    assertTrue("Restricted flag should be applied", subSecretVariable.isRestricted());

    Task subTask = taskService.createTaskQuery().processInstanceId(subInstance.getId()).singleResult();
    assertNotNull(subTask);
    taskService.complete(subTask.getId());

    VariableInstance parentResultVariable = runtimeService.createVariableInstanceQuery()
        .processInstanceIdIn(parentInstance.getId())
        .variableName("resultSecret")
        .singleResult();

    assertNotNull(parentResultVariable);
    assertEquals(42, parentResultVariable.getValue());
    // Transient flag continues to be lost through the mapping chain
    assertTrue("Transient flag should remain lost through out mapping", !parentResultVariable.getTypedValue().isTransient());
    assertTrue("Restricted flag should be applied on out mapping", parentResultVariable.isRestricted());
  }
}
