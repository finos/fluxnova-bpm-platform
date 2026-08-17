package org.finos.fluxnova.bpm.engine.test.history;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration;
import org.finos.fluxnova.bpm.engine.history.HistoricVariableInstance;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.RequiredHistoryLevel;
import org.finos.fluxnova.bpm.engine.test.util.PluggableProcessEngineTest;
import org.finos.fluxnova.bpm.engine.variable.VariableOptions;
import org.finos.fluxnova.bpm.engine.variable.Variables;
import org.junit.Test;

/**
 * @author Yusuf
 */
@RequiredHistoryLevel(ProcessEngineConfiguration.HISTORY_AUDIT)
public class RestrictedHistoricVariableInstanceTest extends PluggableProcessEngineTest {

  protected static final String ONE_TASK_PROCESS =
      "org/finos/fluxnova/bpm/engine/test/api/oneTaskProcess.bpmn20.xml";
  protected static final String PROCESS_KEY = "oneTaskProcess";
  protected static final String RESTRICTED_VARIABLE_NAME = "restrictedVar";
  protected static final String INITIAL_VALUE = "secret";
  protected static final String UPDATED_VALUE = "newValue";
  protected static final String UPDATED_RESTRICTED_VALUE = "newSecret";
  protected static final String READ_TAG = "ssn_Read";
  protected static final String ADMIN_TAG = "ssn_Admin";

  @Test
  @Deployment(resources = {ONE_TASK_PROCESS})
  public void testRestrictedHistoricVariable() {
    // given
    String processInstanceId = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();

    // when
    runtimeService.setVariable(processInstanceId, RESTRICTED_VARIABLE_NAME,
        Variables.stringValue(INITIAL_VALUE, VariableOptions.options(false, true)));

    // then
    HistoricVariableInstance historicVariable = selectHistoricVariable(processInstanceId);

    assertTrue(historicVariable.isRestricted());
    assertEquals(INITIAL_VALUE, historicVariable.getValue());
  }

  @Test
  @Deployment(resources = {ONE_TASK_PROCESS})
  public void testUpdateRestrictedToNonRestrictedHistoricVariable() {
    // given
    String processInstanceId = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();
    runtimeService.setVariable(processInstanceId, RESTRICTED_VARIABLE_NAME,
        Variables.stringValue(INITIAL_VALUE, VariableOptions.options(false, true)));

    // when
    runtimeService.setVariable(processInstanceId, RESTRICTED_VARIABLE_NAME, UPDATED_VALUE);

    // then
    HistoricVariableInstance historicVariable = selectHistoricVariable(processInstanceId);

    assertEquals(false, historicVariable.isRestricted());
    assertEquals(UPDATED_VALUE, historicVariable.getValue());
  }

  @Test
  @Deployment(resources = {ONE_TASK_PROCESS})
  public void testUpdateRestrictedToRestrictedHistoricVariable() {
    // given
    String processInstanceId = runtimeService.startProcessInstanceByKey(PROCESS_KEY).getId();
    runtimeService.setVariable(processInstanceId, RESTRICTED_VARIABLE_NAME,
            Variables.stringValue(INITIAL_VALUE, VariableOptions.options(false, true)));

    // when
    runtimeService.setVariable(processInstanceId, RESTRICTED_VARIABLE_NAME,
            Variables.stringValue(UPDATED_RESTRICTED_VALUE, VariableOptions.options(false, true)));

    // then
    HistoricVariableInstance historicVariable = selectHistoricVariable(processInstanceId);

    assertTrue(historicVariable.isRestricted());
    assertEquals(UPDATED_RESTRICTED_VALUE, historicVariable.getValue());
  }

  protected HistoricVariableInstance selectHistoricVariable(String processInstanceId) {
    return historyService.createHistoricVariableInstanceQuery()
        .processInstanceId(processInstanceId)
        .variableName(RESTRICTED_VARIABLE_NAME)
        .singleResult();
  }
}

