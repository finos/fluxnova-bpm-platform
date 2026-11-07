package org.finos.fluxnova.bpm.integrationtest.functional.scriptengine;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.spec.WebArchive;

public class JavascriptRestrictedVariableScriptEngineSupportTest
    extends AbstractRestrictedVariableScriptEngineSupportTest {

  protected static final String SCRIPT_FORMAT = "javascript";

  protected static final String RESTRICTED_CREATE_SCRIPT =
      "var VariableOptions = Java.type('org.finos.fluxnova.bpm.engine.variable.VariableOptions');"
          + "var options = new VariableOptions(false, true, false);"
          + "execution.setVariable('restrictedVar', 'secret', options);";

  protected static final String RESTRICTED_READ_SCRIPT =
      "execution.setVariable('derivedPublic', execution.getVariable('restrictedVar') + '_seen');";

  protected static final String PLAIN_OVERWRITE_SCRIPT =
      "execution.setVariable('restrictedVar', 'plain-update');";

  @Deployment
  public static WebArchive createProcessApplication() {
    return initWebArchiveDeployment()
      .addClass(AbstractRestrictedVariableScriptEngineSupportTest.class)
      .addAsResource(createSingleScriptProcess(CREATE_PROCESS_ID, SCRIPT_FORMAT, RESTRICTED_CREATE_SCRIPT),
          "restricted-create-process.bpmn20.xml")
      .addAsResource(createTwoScriptProcess(READ_PROCESS_ID, SCRIPT_FORMAT, RESTRICTED_CREATE_SCRIPT,
          RESTRICTED_READ_SCRIPT), "restricted-read-process.bpmn20.xml")
      .addAsResource(createTwoScriptProcess(OVERWRITE_PROCESS_ID, SCRIPT_FORMAT, RESTRICTED_CREATE_SCRIPT,
          PLAIN_OVERWRITE_SCRIPT), "restricted-overwrite-process.bpmn20.xml");
  }
}
