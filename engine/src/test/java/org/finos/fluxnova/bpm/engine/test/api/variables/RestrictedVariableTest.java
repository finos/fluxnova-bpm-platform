package org.finos.fluxnova.bpm.engine.test.api.variables;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.finos.fluxnova.bpm.engine.runtime.Execution;
import org.finos.fluxnova.bpm.engine.runtime.VariableInstance;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.util.PluggableProcessEngineTest;
import org.finos.fluxnova.bpm.engine.variable.VariableOptions;
import org.finos.fluxnova.bpm.engine.variable.Variables;
import org.finos.fluxnova.bpm.engine.variable.value.TypedValue;
import org.junit.After;
import org.junit.Test;

/**
 * @author Yusuf
 */
public class RestrictedVariableTest extends PluggableProcessEngineTest {

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testSetRestrictedVariable() {
    String processInstanceId = runtimeService.startProcessInstanceByKey("oneTaskProcess").getId();

    TypedValue restrictedValue = Variables.stringValue("secret", VariableOptions.options(false, true));
    runtimeService.setVariable(processInstanceId, "restrictedVar", restrictedValue);

    VariableInstance variableInstance = runtimeService.createVariableInstanceQuery()
            .variableName("restrictedVar")
            .singleResult();

    assertTrue(variableInstance.isRestricted());
    assertEquals("secret", variableInstance.getValue());
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testSetNonRestrictedVariable() {
    String processInstanceId = runtimeService.startProcessInstanceByKey("oneTaskProcess").getId();

    TypedValue value = Variables.stringValue("public");
    runtimeService.setVariable(processInstanceId, "publicVar", value);

    VariableInstance variableInstance = runtimeService.createVariableInstanceQuery()
            .variableName("publicVar")
            .singleResult();

    assertEquals(false, variableInstance.isRestricted());
    assertEquals("public", variableInstance.getValue());
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testUpdateRestrictedToNonRestricted() {
    String processInstanceId = runtimeService.startProcessInstanceByKey("oneTaskProcess").getId();

    runtimeService.setVariable(processInstanceId, "var", Variables.stringValue("v1", VariableOptions.options(false, true)));
        assertTrue(runtimeService.createVariableInstanceQuery().variableName("var").singleResult().isRestricted());

    // Update
    runtimeService.setVariable(processInstanceId, "var", "v2");
    VariableInstance variableInstance = runtimeService.createVariableInstanceQuery().variableName("var").singleResult();

        assertEquals(false, variableInstance.isRestricted());
    assertEquals("v2", variableInstance.getValue());
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testUpdateNonRestrictedToRestricted() {
    String processInstanceId = runtimeService.startProcessInstanceByKey("oneTaskProcess").getId();

    runtimeService.setVariable(processInstanceId, "var", "v1");

    runtimeService.setVariable(processInstanceId, "var",
            Variables.stringValue("v2", VariableOptions.options(false, true)));

    VariableInstance variableInstance = runtimeService.createVariableInstanceQuery()
            .variableName("var")
            .singleResult();

    assertTrue(variableInstance.isRestricted());
    assertEquals("v2", variableInstance.getValue());
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testSetRestrictedLocalVariable() {
    String processInstanceId = runtimeService.startProcessInstanceByKey("oneTaskProcess").getId();

    Execution execution = runtimeService.createExecutionQuery()
            .processInstanceId(processInstanceId)
            .singleResult();

    runtimeService.setVariableLocal(execution.getId(), "restrictedLocalVar",
            Variables.stringValue("localSecret", VariableOptions.options(false, true)));

    VariableInstance variableInstance = runtimeService.createVariableInstanceQuery()
            .variableName("restrictedLocalVar")
            .singleResult();

    assertTrue(variableInstance.isRestricted());
    assertEquals("localSecret", variableInstance.getValue());
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testSetRestrictedVariableUsingObjectBuilder() {
    String processInstanceId = runtimeService.startProcessInstanceByKey("oneTaskProcess").getId();

    TypedValue restrictedValue = Variables.objectValue("secretData")
            .setRestricted(true)
            .setTransient(false)
            .create();

    runtimeService.setVariable(processInstanceId, "objectRestrictedVar", restrictedValue);

    VariableInstance variableInstance = runtimeService.createVariableInstanceQuery()
            .variableName("objectRestrictedVar")
            .singleResult();

    assertTrue(variableInstance.isRestricted());
    assertEquals("secretData", variableInstance.getValue());
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testSetRestrictedVariableUsingFileBuilder() {
    String processInstanceId = runtimeService.startProcessInstanceByKey("oneTaskProcess").getId();

    TypedValue restrictedFile = Variables.fileValue("test.txt")
            .file("content".getBytes())
            .mimeType("text/plain")
            .setRestricted(true)
            .create();

    runtimeService.setVariable(processInstanceId, "fileRestrictedVar", restrictedFile);

    VariableInstance variableInstance = runtimeService.createVariableInstanceQuery()
            .variableName("fileRestrictedVar")
            .singleResult();

    assertTrue(variableInstance.isRestricted());
    assertEquals("test.txt", ((org.finos.fluxnova.bpm.engine.variable.value.FileValue)variableInstance.getTypedValue()).getFilename());
  }

  @After
  public void cleanup() {
    processEngineConfiguration.setJavaSerializationFormatEnabled(false);
  }

  @Test
  @Deployment(resources = {"org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml"})
  public void testSetRestrictedVariableUsingSerializedObjectBuilder() {
    processEngineConfiguration.setJavaSerializationFormatEnabled(true);
    String processInstanceId = runtimeService.startProcessInstanceByKey("oneTaskProcess").getId();
    
    TypedValue restrictedSerializedValue = Variables.serializedObjectValue("rO0ABXNyABFqYXZhLnV0aWwuSGFzaE1hcAr7PpsB9v1LAwAFRgAKbG9hZEZhY3RvckkACXRocmVzaG9sZFsACmFsbG9jYXRpb250AAJbS0wAE3NlcmlhbGl6ZWREYXRhVGFibGV0ABJbTGphdmEvbGFuZy9PYmplY3Q7eHBAQAAAAAAACAAHdwgAAAAIAAAABXQAA2tleXQABXZhbHVleA==")
            .serializationDataFormat(Variables.SerializationDataFormats.JAVA)
            .objectTypeName("java.util.HashMap")
            .setRestricted(true)
            .create();

    runtimeService.setVariable(processInstanceId, "serializedRestrictedVar", restrictedSerializedValue);

    VariableInstance variableInstance = runtimeService.createVariableInstanceQuery()
            .variableName("serializedRestrictedVar")
            .singleResult();

    assertTrue(variableInstance.isRestricted());
  }

}

