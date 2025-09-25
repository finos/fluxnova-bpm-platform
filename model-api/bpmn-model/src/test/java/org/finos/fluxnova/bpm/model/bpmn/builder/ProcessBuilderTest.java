/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.finos.fluxnova.bpm.model.bpmn.builder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.BOUNDARY_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.CALL_ACTIVITY_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.CATCH_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.CONDITION_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.EXTERNAL_TASK_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.FORM_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.PROCESS_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.SERVICE_TASK_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.START_EVENT_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.SUB_PROCESS_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TASK_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_CLASS_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_CONDITION;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_CONDITIONAL_VARIABLE_EVENTS;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_CONDITIONAL_VARIABLE_EVENTS_LIST;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_CONDITIONAL_VARIABLE_NAME;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_DELEGATE_EXPRESSION_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_DUE_DATE_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_EXPRESSION_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_EXTERNAL_TASK_TOPIC;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_FOLLOW_UP_DATE_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_LIST_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_HISTORY_TIME_TO_LIVE;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_PRIORITY_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_PROCESS_TASK_PRIORITY;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_SERVICE_TASK_PRIORITY;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_STARTABLE_IN_TASKLIST;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_STRING_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_STRING_FORM_REF_BINDING;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_STRING_FORM_REF_VERSION;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_LIST_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_VERSION_TAG;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TRANSACTION_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.USER_TASK_ID;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.BPMN20_NS;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.fluxnova.bpm.model.bpmn.AssociationDirection;
import org.finos.fluxnova.bpm.model.bpmn.Bpmn;
import org.finos.fluxnova.bpm.model.bpmn.BpmnModelException;
import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.finos.fluxnova.bpm.model.bpmn.GatewayDirection;
import org.finos.fluxnova.bpm.model.bpmn.TransactionMethod;
import org.finos.fluxnova.bpm.model.bpmn.instance.Activity;
import org.finos.fluxnova.bpm.model.bpmn.instance.Association;
import org.finos.fluxnova.bpm.model.bpmn.instance.BaseElement;
import org.finos.fluxnova.bpm.model.bpmn.instance.BoundaryEvent;
import org.finos.fluxnova.bpm.model.bpmn.instance.BpmnModelElementInstance;
import org.finos.fluxnova.bpm.model.bpmn.instance.BusinessRuleTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.CallActivity;
import org.finos.fluxnova.bpm.model.bpmn.instance.CompensateEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.ConditionalEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.Definitions;
import org.finos.fluxnova.bpm.model.bpmn.instance.Documentation;
import org.finos.fluxnova.bpm.model.bpmn.instance.EndEvent;
import org.finos.fluxnova.bpm.model.bpmn.instance.Error;
import org.finos.fluxnova.bpm.model.bpmn.instance.ErrorEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.Escalation;
import org.finos.fluxnova.bpm.model.bpmn.instance.EscalationEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.Event;
import org.finos.fluxnova.bpm.model.bpmn.instance.EventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.ExtensionElements;
import org.finos.fluxnova.bpm.model.bpmn.instance.FlowElement;
import org.finos.fluxnova.bpm.model.bpmn.instance.FlowNode;
import org.finos.fluxnova.bpm.model.bpmn.instance.Gateway;
import org.finos.fluxnova.bpm.model.bpmn.instance.InclusiveGateway;
import org.finos.fluxnova.bpm.model.bpmn.instance.Message;
import org.finos.fluxnova.bpm.model.bpmn.instance.MessageEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.MultiInstanceLoopCharacteristics;
import org.finos.fluxnova.bpm.model.bpmn.instance.Process;
import org.finos.fluxnova.bpm.model.bpmn.instance.ReceiveTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.ScriptTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.SendTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.SequenceFlow;
import org.finos.fluxnova.bpm.model.bpmn.instance.ServiceTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.Signal;
import org.finos.fluxnova.bpm.model.bpmn.instance.SignalEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.StartEvent;
import org.finos.fluxnova.bpm.model.bpmn.instance.SubProcess;
import org.finos.fluxnova.bpm.model.bpmn.instance.Task;
import org.finos.fluxnova.bpm.model.bpmn.instance.TimeCycle;
import org.finos.fluxnova.bpm.model.bpmn.instance.TimeDate;
import org.finos.fluxnova.bpm.model.bpmn.instance.TimeDuration;
import org.finos.fluxnova.bpm.model.bpmn.instance.TimerEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.Transaction;
import org.finos.fluxnova.bpm.model.bpmn.instance.UserTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaErrorEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaExecutionListener;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFailedJobRetryTimeCycle;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFormData;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFormField;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaIn;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaInputOutput;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaInputParameter;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaOut;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaOutputParameter;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaTaskListener;
import org.finos.fluxnova.bpm.model.xml.Model;
import org.finos.fluxnova.bpm.model.xml.instance.ModelElementInstance;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementType;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 * @author Sebastian Menski
 */
public class ProcessBuilderTest {

  public static final String TIMER_DATE = "2011-03-11T12:13:14Z";
  public static final String TIMER_DURATION = "P10D";
  public static final String TIMER_CYCLE = "R3/PT10H";

  public static final String FAILED_JOB_RETRY_TIME_CYCLE = "R5/PT1M";

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  private BpmnModelInstance modelInstance;
  private static ModelElementType taskType;
  private static ModelElementType gatewayType;
  private static ModelElementType eventType;
  private static ModelElementType processType;

  @BeforeClass
  public static void getElementTypes() {
    Model model = Bpmn.createEmptyModel().getModel();
    taskType = model.getType(Task.class);
    gatewayType = model.getType(Gateway.class);
    eventType = model.getType(Event.class);
    processType = model.getType(Process.class);
  }

  @After
  public void validateModel() throws IOException {
    if (modelInstance != null) {
      Bpmn.validateModel(modelInstance);
    }
  }

  @Test
  public void testCreateEmptyProcess() {
    modelInstance = Bpmn.createProcess()
      .done();

    Definitions definitions = modelInstance.getDefinitions();
    assertThat(definitions).isNotNull();
    assertThat(definitions.getTargetNamespace()).isEqualTo(BPMN20_NS);

    Collection<ModelElementInstance> processes = modelInstance.getModelElementsByType(processType);
    assertThat(processes)
      .hasSize(1);

    Process process = (Process) processes.iterator().next();

    assertThat(process.getId()).isNotNull();
  }

  @Test
  public void emptyProcessShouldHaveDefaultHTTL() {
    modelInstance = Bpmn.createProcess().done();

    var process = (Process) modelInstance.getModelElementsByType(processType)
        .iterator()
        .next();

    assertThat(process.getFluxnovaHistoryTimeToLiveString())
        .isEqualTo("P180D");
  }

  @Test
  public void shouldHaveDefaultHTTLValueOnSkipDefaultHistoryTimeToLiveFalse() {
    modelInstance = Bpmn.createProcess().done();

    var process = (Process) modelInstance.getModelElementsByType(processType)
        .iterator()
        .next();

    assertThat(process.getFluxnovaHistoryTimeToLiveString())
        .isEqualTo("P180D");
  }

  @Test
  public void shouldHaveNullHTTLValueOnCreateProcessWithSkipHTTL() {
    modelInstance = Bpmn.createProcess().fluxnovaHistoryTimeToLive(null).done();

    var process = (Process) modelInstance.getModelElementsByType(processType)
        .iterator()
        .next();

    assertThat(process.getFluxnovaHistoryTimeToLiveString())
        .isNull();
  }

  @Test
  public void shouldHaveNullHTTLValueOnCreateProcessIdWithoutSkipHTTL(){
    modelInstance = Bpmn.createProcess(PROCESS_ID).done();

    var process = (Process) modelInstance.getModelElementById(PROCESS_ID);

    assertThat(process.getFluxnovaHistoryTimeToLiveString())
        .isEqualTo("P180D");
  }

  @Test
  public void shouldHaveNullHTTLValueOnCreateProcessIdWithSkipHTTL(){
    modelInstance = Bpmn.createProcess(PROCESS_ID).fluxnovaHistoryTimeToLive(null).done();

    var process = (Process) modelInstance.getModelElementById(PROCESS_ID);

    assertThat(process.getFluxnovaHistoryTimeToLiveString())
        .isNull();
  }

  @Test
  public void testGetElement() {
    // Make sure this method is publicly available
    Process process = Bpmn.createProcess().getElement();
    assertThat(process).isNotNull();
  }

  @Test
  public void testCreateProcessWithStartEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithEndEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(2);
  }

  @Test
  public void testCreateProcessWithServiceTask() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .serviceTask()
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(2);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithSendTask() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .sendTask()
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(2);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithUserTask() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask()
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(2);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithBusinessRuleTask() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .businessRuleTask()
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(2);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithScriptTask() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .scriptTask()
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(2);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithReceiveTask() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .receiveTask()
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(2);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithManualTask() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .manualTask()
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(2);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithParallelGateway() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .parallelGateway()
        .scriptTask()
        .endEvent()
      .moveToLastGateway()
        .userTask()
        .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(3);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(2);
    assertThat(modelInstance.getModelElementsByType(gatewayType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithExclusiveGateway() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask()
      .exclusiveGateway()
        .condition("approved", "${approved}")
        .serviceTask()
        .endEvent()
      .moveToLastGateway()
        .condition("not approved", "${!approved}")
        .scriptTask()
        .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(3);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(3);
    assertThat(modelInstance.getModelElementsByType(gatewayType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithInclusiveGateway() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask()
      .inclusiveGateway()
        .condition("approved", "${approved}")
        .serviceTask()
        .endEvent()
      .moveToLastGateway()
        .condition("not approved", "${!approved}")
        .scriptTask()
        .endEvent()
      .done();

    ModelElementType inclusiveGwType = modelInstance.getModel().getType(InclusiveGateway.class);

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(3);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(3);
    assertThat(modelInstance.getModelElementsByType(inclusiveGwType))
      .hasSize(1);
  }

  @Test
  public void testCreateProcessWithForkAndJoin() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask()
      .parallelGateway()
        .serviceTask()
        .parallelGateway()
        .id("join")
      .moveToLastGateway()
        .scriptTask()
      .connectTo("join")
      .userTask()
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(2);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(4);
    assertThat(modelInstance.getModelElementsByType(gatewayType))
      .hasSize(2);
  }

  @Test
  public void testCreateProcessWithMultipleParallelTask() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .parallelGateway("fork")
        .userTask()
        .parallelGateway("join")
      .moveToNode("fork")
        .serviceTask()
        .connectTo("join")
      .moveToNode("fork")
        .userTask()
        .connectTo("join")
      .moveToNode("fork")
        .scriptTask()
        .connectTo("join")
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(eventType))
      .hasSize(2);
    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(4);
    assertThat(modelInstance.getModelElementsByType(gatewayType))
      .hasSize(2);
  }

  @Test
  public void testBaseElementDocumentation() {
    modelInstance = Bpmn.createProcess("process")
            .documentation("processDocumentation")
            .startEvent("startEvent")
            .documentation("startEventDocumentation_1")
            .documentation("startEventDocumentation_2")
            .documentation("startEventDocumentation_3")
            .userTask("task")
            .documentation("taskDocumentation")
            .businessRuleTask("businessruletask")
            .subProcess("subprocess")
            .documentation("subProcessDocumentation")
            .embeddedSubProcess()
            .startEvent("subprocessStartEvent")
            .endEvent("subprocessEndEvent")
            .subProcessDone()
            .endEvent("endEvent")
            .documentation("endEventDocumentation")
            .done();

    assertThat(((Process) modelInstance.getModelElementById("process")).getDocumentations().iterator().next().getTextContent()).isEqualTo("processDocumentation");
    assertThat(((UserTask) modelInstance.getModelElementById("task")).getDocumentations().iterator().next().getTextContent()).isEqualTo("taskDocumentation");
    assertThat(((SubProcess) modelInstance.getModelElementById("subprocess")).getDocumentations().iterator().next().getTextContent()).isEqualTo("subProcessDocumentation");
    assertThat(((EndEvent) modelInstance.getModelElementById("endEvent")).getDocumentations().iterator().next().getTextContent()).isEqualTo("endEventDocumentation");

    final Documentation[] startEventDocumentations = ((StartEvent) modelInstance.getModelElementById("startEvent")).getDocumentations().toArray(new Documentation[]{});
    assertThat(startEventDocumentations.length).isEqualTo(3);
    for (int i = 1; i <=3; i++) {
      assertThat(startEventDocumentations[i - 1].getTextContent()).isEqualTo("startEventDocumentation_" + i);
    }
  }

  @Test
  public void testExtend() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask()
        .id("task1")
      .serviceTask()
      .endEvent()
      .done();

    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(2);

    UserTask userTask = modelInstance.getModelElementById("task1");
    SequenceFlow outgoingSequenceFlow = userTask.getOutgoing().iterator().next();
    FlowNode serviceTask = outgoingSequenceFlow.getTarget();
    userTask.getOutgoing().remove(outgoingSequenceFlow);
    userTask.builder()
      .scriptTask()
      .userTask()
      .connectTo(serviceTask.getId());

    assertThat(modelInstance.getModelElementsByType(taskType))
      .hasSize(4);
  }

  @Test
  public void testCreateInvoiceProcess() {
    modelInstance = Bpmn.createProcess()
      .executable()
      .startEvent()
        .name("Invoice received")
        .fluxnovaFormKey("embedded:app:forms/start-form.html")
      .userTask()
        .name("Assign Approver")
        .fluxnovaFormKey("embedded:app:forms/assign-approver.html")
        .fluxnovaAssignee("demo")
      .userTask("approveInvoice")
        .name("Approve Invoice")
        .fluxnovaFormKey("embedded:app:forms/approve-invoice.html")
        .fluxnovaAssignee("${approver}")
      .exclusiveGateway()
        .name("Invoice approved?")
        .gatewayDirection(GatewayDirection.Diverging)
      .condition("yes", "${approved}")
      .userTask()
        .name("Prepare Bank Transfer")
        .fluxnovaFormKey("embedded:app:forms/prepare-bank-transfer.html")
        .fluxnovaCandidateGroups("accounting")
      .serviceTask()
        .name("Archive Invoice")
        .fluxnovaClass("org.finos.fluxnova.bpm.example.invoice.service.ArchiveInvoiceService" )
      .endEvent()
        .name("Invoice processed")
      .moveToLastGateway()
      .condition("no", "${!approved}")
      .userTask()
        .name("Review Invoice")
        .fluxnovaFormKey("embedded:app:forms/review-invoice.html" )
        .fluxnovaAssignee("demo")
       .exclusiveGateway()
        .name("Review successful?")
        .gatewayDirection(GatewayDirection.Diverging)
      .condition("no", "${!clarified}")
      .endEvent()
        .name("Invoice not processed")
      .moveToLastGateway()
      .condition("yes", "${clarified}")
      .connectTo("approveInvoice")
      .done();
  }

  @Test
  public void testProcessFluxnovaExtensions() {
    modelInstance = Bpmn.createProcess(PROCESS_ID)
      .fluxnovaJobPriority("${somePriority}")
      .fluxnovaTaskPriority(TEST_PROCESS_TASK_PRIORITY)
      .fluxnovaHistoryTimeToLive(TEST_HISTORY_TIME_TO_LIVE)
      .fluxnovaStartableInTasklist(TEST_STARTABLE_IN_TASKLIST)
      .fluxnovaVersionTag(TEST_VERSION_TAG)
      .startEvent()
      .endEvent()
      .done();

    Process process = modelInstance.getModelElementById(PROCESS_ID);
    assertThat(process.getFluxnovaJobPriority()).isEqualTo("${somePriority}");
    assertThat(process.getFluxnovaTaskPriority()).isEqualTo(TEST_PROCESS_TASK_PRIORITY);
    assertThat(process.getFluxnovaHistoryTimeToLive()).isEqualTo(TEST_HISTORY_TIME_TO_LIVE);
    assertThat(process.isFluxnovaStartableInTasklist()).isEqualTo(TEST_STARTABLE_IN_TASKLIST);
    assertThat(process.getFluxnovaVersionTag()).isEqualTo(TEST_VERSION_TAG);
  }

  @Test
  public void testProcessStartableInTasklist() {
    modelInstance = Bpmn.createProcess(PROCESS_ID)
      .startEvent()
      .endEvent()
      .done();

    Process process = modelInstance.getModelElementById(PROCESS_ID);
    assertThat(process.isFluxnovaStartableInTasklist()).isEqualTo(true);
  }

  @Test
  public void testTaskFluxnovaExternalTask() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
        .serviceTask(EXTERNAL_TASK_ID)
          .fluxnovaExternalTask(TEST_EXTERNAL_TASK_TOPIC)
        .endEvent()
        .done();

    ServiceTask serviceTask = modelInstance.getModelElementById(EXTERNAL_TASK_ID);
    assertThat(serviceTask.getFluxnovaType()).isEqualTo("external");
    assertThat(serviceTask.getFluxnovaTopic()).isEqualTo(TEST_EXTERNAL_TASK_TOPIC);
  }

  @Test
  public void testTaskFluxnovaExternalTaskErrorEventDefinition() {
    modelInstance = Bpmn.createProcess()
    .startEvent()
    .serviceTask(EXTERNAL_TASK_ID)
    .fluxnovaExternalTask(TEST_EXTERNAL_TASK_TOPIC)
      .fluxnovaErrorEventDefinition().id("id").error("myErrorCode", "errorMessage").expression("expression").errorEventDefinitionDone()
    .endEvent()
    .moveToActivity(EXTERNAL_TASK_ID)
    .boundaryEvent("boundary").error("myErrorCode", "errorMessage")
    .endEvent("boundaryEnd")
    .done();

    ServiceTask externalTask = modelInstance.getModelElementById(EXTERNAL_TASK_ID);
    ExtensionElements extensionElements = externalTask.getExtensionElements();
    Collection<FluxnovaErrorEventDefinition> errorEventDefinitions = extensionElements.getChildElementsByType(FluxnovaErrorEventDefinition.class);
    assertThat(errorEventDefinitions).hasSize(1);
    FluxnovaErrorEventDefinition camundaErrorEventDefinition = errorEventDefinitions.iterator().next();
    assertThat(camundaErrorEventDefinition).isNotNull();
    assertThat(camundaErrorEventDefinition.getId()).isEqualTo("id");
    assertThat(camundaErrorEventDefinition.getFluxnovaExpression()).isEqualTo("expression");
    assertErrorEventDefinition("boundary", "myErrorCode", "errorMessage");
  }

  @Test
  public void testTaskFluxnovaExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .serviceTask(TASK_ID)
        .fluxnovaAsyncBefore()
        .notFluxnovaExclusive()
        .fluxnovaJobPriority("${somePriority}")
        .fluxnovaTaskPriority(TEST_SERVICE_TASK_PRIORITY)
        .fluxnovaFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    ServiceTask serviceTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(serviceTask.isFluxnovaAsyncBefore()).isTrue();
    assertThat(serviceTask.isFluxnovaExclusive()).isFalse();
    assertThat(serviceTask.getFluxnovaJobPriority()).isEqualTo("${somePriority}");
    assertThat(serviceTask.getFluxnovaTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);

    assertFluxnovaFailedJobRetryTimeCycle(serviceTask);
  }

  @Test
  public void testServiceTaskFluxnovaExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .serviceTask(TASK_ID)
        .fluxnovaClass(TEST_CLASS_API)
        .fluxnovaDelegateExpression(TEST_DELEGATE_EXPRESSION_API)
        .fluxnovaExpression(TEST_EXPRESSION_API)
        .fluxnovaResultVariable(TEST_STRING_API)
        .fluxnovaTopic(TEST_STRING_API)
        .fluxnovaType(TEST_STRING_API)
        .fluxnovaTaskPriority(TEST_SERVICE_TASK_PRIORITY)
        .fluxnovaFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .done();

    ServiceTask serviceTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(serviceTask.getFluxnovaClass()).isEqualTo(TEST_CLASS_API);
    assertThat(serviceTask.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertThat(serviceTask.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(serviceTask.getFluxnovaResultVariable()).isEqualTo(TEST_STRING_API);
    assertThat(serviceTask.getFluxnovaTopic()).isEqualTo(TEST_STRING_API);
    assertThat(serviceTask.getFluxnovaType()).isEqualTo(TEST_STRING_API);
    assertThat(serviceTask.getFluxnovaTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);

    assertFluxnovaFailedJobRetryTimeCycle(serviceTask);
  }

  @Test
  public void testServiceTaskFluxnovaClass() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .serviceTask(TASK_ID)
        .fluxnovaClass(getClass().getName())
      .done();

    ServiceTask serviceTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(serviceTask.getFluxnovaClass()).isEqualTo(getClass().getName());
  }


  @Test
  public void testSendTaskFluxnovaExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .sendTask(TASK_ID)
        .fluxnovaClass(TEST_CLASS_API)
        .fluxnovaDelegateExpression(TEST_DELEGATE_EXPRESSION_API)
        .fluxnovaExpression(TEST_EXPRESSION_API)
        .fluxnovaResultVariable(TEST_STRING_API)
        .fluxnovaTopic(TEST_STRING_API)
        .fluxnovaType(TEST_STRING_API)
        .fluxnovaTaskPriority(TEST_SERVICE_TASK_PRIORITY)
        .fluxnovaFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    SendTask sendTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(sendTask.getFluxnovaClass()).isEqualTo(TEST_CLASS_API);
    assertThat(sendTask.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertThat(sendTask.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(sendTask.getFluxnovaResultVariable()).isEqualTo(TEST_STRING_API);
    assertThat(sendTask.getFluxnovaTopic()).isEqualTo(TEST_STRING_API);
    assertThat(sendTask.getFluxnovaType()).isEqualTo(TEST_STRING_API);
    assertThat(sendTask.getFluxnovaTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);

    assertFluxnovaFailedJobRetryTimeCycle(sendTask);
  }

  @Test
  public void testSendTaskFluxnovaClass() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .sendTask(TASK_ID)
        .fluxnovaClass(this.getClass())
      .endEvent()
      .done();

    SendTask sendTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(sendTask.getFluxnovaClass()).isEqualTo(this.getClass().getName());
  }

  @Test
  public void testUserTaskFluxnovaExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask(TASK_ID)
        .fluxnovaAssignee(TEST_STRING_API)
        .fluxnovaCandidateGroups(TEST_GROUPS_API)
        .fluxnovaCandidateUsers(TEST_USERS_LIST_API)
        .fluxnovaDueDate(TEST_DUE_DATE_API)
        .fluxnovaFollowUpDate(TEST_FOLLOW_UP_DATE_API)
        .fluxnovaFormHandlerClass(TEST_CLASS_API)
        .fluxnovaFormKey(TEST_STRING_API)
        .fluxnovaFormRef(FORM_ID)
        .fluxnovaFormRefBinding(TEST_STRING_FORM_REF_BINDING)
        .fluxnovaFormRefVersion(TEST_STRING_FORM_REF_VERSION)
        .fluxnovaPriority(TEST_PRIORITY_API)
        .fluxnovaFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(userTask.getFluxnovaAssignee()).isEqualTo(TEST_STRING_API);
    assertThat(userTask.getFluxnovaCandidateGroups()).isEqualTo(TEST_GROUPS_API);
    assertThat(userTask.getFluxnovaCandidateGroupsList()).containsAll(TEST_GROUPS_LIST_API);
    assertThat(userTask.getFluxnovaCandidateUsers()).isEqualTo(TEST_USERS_API);
    assertThat(userTask.getFluxnovaCandidateUsersList()).containsAll(TEST_USERS_LIST_API);
    assertThat(userTask.getFluxnovaDueDate()).isEqualTo(TEST_DUE_DATE_API);
    assertThat(userTask.getFluxnovaFollowUpDate()).isEqualTo(TEST_FOLLOW_UP_DATE_API);
    assertThat(userTask.getFluxnovaFormHandlerClass()).isEqualTo(TEST_CLASS_API);
    assertThat(userTask.getFluxnovaFormKey()).isEqualTo(TEST_STRING_API);
    assertThat(userTask.getFluxnovaFormRef()).isEqualTo(FORM_ID);
    assertThat(userTask.getFluxnovaFormRefBinding()).isEqualTo(TEST_STRING_FORM_REF_BINDING);
    assertThat(userTask.getFluxnovaFormRefVersion()).isEqualTo(TEST_STRING_FORM_REF_VERSION);
    assertThat(userTask.getFluxnovaPriority()).isEqualTo(TEST_PRIORITY_API);

    assertFluxnovaFailedJobRetryTimeCycle(userTask);
  }

  @Test
  public void testBusinessRuleTaskFluxnovaExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .businessRuleTask(TASK_ID)
        .fluxnovaClass(TEST_CLASS_API)
        .fluxnovaDelegateExpression(TEST_DELEGATE_EXPRESSION_API)
        .fluxnovaExpression(TEST_EXPRESSION_API)
        .fluxnovaResultVariable("resultVar")
        .fluxnovaTopic("topic")
        .fluxnovaType("type")
        .fluxnovaDecisionRef("decisionRef")
        .fluxnovaDecisionRefBinding("latest")
        .fluxnovaDecisionRefVersion("7")
        .fluxnovaDecisionRefVersionTag("0.1.0")
        .fluxnovaDecisionRefTenantId("tenantId")
        .fluxnovaMapDecisionResult("singleEntry")
        .fluxnovaTaskPriority(TEST_SERVICE_TASK_PRIORITY)
        .fluxnovaFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    BusinessRuleTask businessRuleTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(businessRuleTask.getFluxnovaClass()).isEqualTo(TEST_CLASS_API);
    assertThat(businessRuleTask.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertThat(businessRuleTask.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(businessRuleTask.getFluxnovaResultVariable()).isEqualTo("resultVar");
    assertThat(businessRuleTask.getFluxnovaTopic()).isEqualTo("topic");
    assertThat(businessRuleTask.getFluxnovaType()).isEqualTo("type");
    assertThat(businessRuleTask.getFluxnovaDecisionRef()).isEqualTo("decisionRef");
    assertThat(businessRuleTask.getFluxnovaDecisionRefBinding()).isEqualTo("latest");
    assertThat(businessRuleTask.getFluxnovaDecisionRefVersion()).isEqualTo("7");
    assertThat(businessRuleTask.getFluxnovaDecisionRefVersionTag()).isEqualTo("0.1.0");
    assertThat(businessRuleTask.getFluxnovaDecisionRefTenantId()).isEqualTo("tenantId");
    assertThat(businessRuleTask.getFluxnovaMapDecisionResult()).isEqualTo("singleEntry");
    assertThat(businessRuleTask.getFluxnovaTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);

    assertFluxnovaFailedJobRetryTimeCycle(businessRuleTask);
  }

  @Test
  public void testBusinessRuleTaskFluxnovaClass() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .businessRuleTask(TASK_ID)
        .fluxnovaClass(Bpmn.class)
      .endEvent()
      .done();

    BusinessRuleTask businessRuleTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(businessRuleTask.getFluxnovaClass()).isEqualTo("org.finos.fluxnova.bpm.model.bpmn.Bpmn");
  }

  @Test
  public void testScriptTaskFluxnovaExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .scriptTask(TASK_ID)
        .fluxnovaResultVariable(TEST_STRING_API)
        .fluxnovaResource(TEST_STRING_API)
        .fluxnovaFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    ScriptTask scriptTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(scriptTask.getFluxnovaResultVariable()).isEqualTo(TEST_STRING_API);
    assertThat(scriptTask.getFluxnovaResource()).isEqualTo(TEST_STRING_API);

    assertFluxnovaFailedJobRetryTimeCycle(scriptTask);
  }

  @Test
  public void testStartEventFluxnovaExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent(START_EVENT_ID)
        .fluxnovaAsyncBefore()
        .notFluxnovaExclusive()
        .fluxnovaFormHandlerClass(TEST_CLASS_API)
        .fluxnovaFormKey(TEST_STRING_API)
        .fluxnovaFormRef(FORM_ID)
        .fluxnovaFormRefBinding(TEST_STRING_FORM_REF_BINDING)
        .fluxnovaFormRefVersion(TEST_STRING_FORM_REF_VERSION)
        .fluxnovaInitiator(TEST_STRING_API)
        .fluxnovaFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .done();

    StartEvent startEvent = modelInstance.getModelElementById(START_EVENT_ID);
    assertThat(startEvent.isFluxnovaAsyncBefore()).isTrue();
    assertThat(startEvent.isFluxnovaExclusive()).isFalse();
    assertThat(startEvent.getFluxnovaFormHandlerClass()).isEqualTo(TEST_CLASS_API);
    assertThat(startEvent.getFluxnovaFormKey()).isEqualTo(TEST_STRING_API);
    assertThat(startEvent.getFluxnovaFormRef()).isEqualTo(FORM_ID);
    assertThat(startEvent.getFluxnovaFormRefBinding()).isEqualTo(TEST_STRING_FORM_REF_BINDING);
    assertThat(startEvent.getFluxnovaFormRefVersion()).isEqualTo(TEST_STRING_FORM_REF_VERSION);
    assertThat(startEvent.getFluxnovaInitiator()).isEqualTo(TEST_STRING_API);

    assertFluxnovaFailedJobRetryTimeCycle(startEvent);
  }

  @Test
  public void testErrorDefinitionsForStartEvent() {
    modelInstance = Bpmn.createProcess()
    .startEvent("start")
      .errorEventDefinition("event")
        .errorCodeVariable("errorCodeVariable")
        .errorMessageVariable("errorMessageVariable")
        .error("errorCode", "errorMessage")
      .errorEventDefinitionDone()
     .endEvent().done();

    assertErrorEventDefinition("start", "errorCode", "errorMessage");
    assertErrorEventDefinitionForErrorVariables("start", "errorCodeVariable", "errorMessageVariable");
  }

  @Test
  public void testErrorDefinitionsForStartEventWithoutEventDefinitionId() {
    modelInstance = Bpmn.createProcess()
    .startEvent("start")
      .errorEventDefinition()
        .errorCodeVariable("errorCodeVariable")
        .errorMessageVariable("errorMessageVariable")
        .error("errorCode", "errorMessage")
      .errorEventDefinitionDone()
     .endEvent().done();

    assertErrorEventDefinition("start", "errorCode", "errorMessage");
    assertErrorEventDefinitionForErrorVariables("start", "errorCodeVariable", "errorMessageVariable");
  }

  @Test
  public void testCallActivityFluxnovaExtension() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .callActivity(CALL_ACTIVITY_ID)
        .calledElement(TEST_STRING_API)
        .fluxnovaAsyncBefore()
        .fluxnovaCalledElementBinding("version")
        .fluxnovaCalledElementVersion("1.0")
        .fluxnovaCalledElementVersionTag("ver-1.0")
        .fluxnovaCalledElementTenantId("t1")
        .fluxnovaCaseRef("case")
        .fluxnovaCaseBinding("deployment")
        .fluxnovaCaseVersion("2")
        .fluxnovaCaseTenantId("t2")
        .fluxnovaIn("in-source", "in-target")
        .fluxnovaOut("out-source", "out-target")
        .fluxnovaVariableMappingClass(TEST_CLASS_API)
        .fluxnovaVariableMappingDelegateExpression(TEST_DELEGATE_EXPRESSION_API)
        .notFluxnovaExclusive()
        .fluxnovaFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    CallActivity callActivity = modelInstance.getModelElementById(CALL_ACTIVITY_ID);
    assertThat(callActivity.getCalledElement()).isEqualTo(TEST_STRING_API);
    assertThat(callActivity.isFluxnovaAsyncBefore()).isTrue();
    assertThat(callActivity.getFluxnovaCalledElementBinding()).isEqualTo("version");
    assertThat(callActivity.getFluxnovaCalledElementVersion()).isEqualTo("1.0");
    assertThat(callActivity.getFluxnovaCalledElementVersionTag()).isEqualTo("ver-1.0");
    assertThat(callActivity.getFluxnovaCalledElementTenantId()).isEqualTo("t1");
    assertThat(callActivity.getFluxnovaCaseRef()).isEqualTo("case");
    assertThat(callActivity.getFluxnovaCaseBinding()).isEqualTo("deployment");
    assertThat(callActivity.getFluxnovaCaseVersion()).isEqualTo("2");
    assertThat(callActivity.getFluxnovaCaseTenantId()).isEqualTo("t2");
    assertThat(callActivity.isFluxnovaExclusive()).isFalse();

    FluxnovaIn camundaIn = (FluxnovaIn) callActivity.getExtensionElements().getUniqueChildElementByType(FluxnovaIn.class);
    assertThat(camundaIn.getFluxnovaSource()).isEqualTo("in-source");
    assertThat(camundaIn.getFluxnovaTarget()).isEqualTo("in-target");

    FluxnovaOut camundaOut = (FluxnovaOut) callActivity.getExtensionElements().getUniqueChildElementByType(FluxnovaOut.class);
    assertThat(camundaOut.getFluxnovaSource()).isEqualTo("out-source");
    assertThat(camundaOut.getFluxnovaTarget()).isEqualTo("out-target");

    assertThat(callActivity.getFluxnovaVariableMappingClass()).isEqualTo(TEST_CLASS_API);
    assertThat(callActivity.getFluxnovaVariableMappingDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertFluxnovaFailedJobRetryTimeCycle(callActivity);
  }

  @Test
  public void testCallActivityFluxnovaBusinessKey() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .callActivity(CALL_ACTIVITY_ID)
        .fluxnovaInBusinessKey("business-key")
      .endEvent()
      .done();

    CallActivity callActivity = modelInstance.getModelElementById(CALL_ACTIVITY_ID);
    FluxnovaIn camundaIn = (FluxnovaIn) callActivity.getExtensionElements().getUniqueChildElementByType(FluxnovaIn.class);
    assertThat(camundaIn.getFluxnovaBusinessKey()).isEqualTo("business-key");
  }

  @Test
  public void testCallActivityFluxnovaVariableMappingClass() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .callActivity(CALL_ACTIVITY_ID)
        .fluxnovaVariableMappingClass(this.getClass())
      .endEvent()
      .done();

    CallActivity callActivity = modelInstance.getModelElementById(CALL_ACTIVITY_ID);
    assertThat(callActivity.getFluxnovaVariableMappingClass()).isEqualTo(this.getClass().getName());
  }

  @Test
  public void testSubProcessBuilder() {
    BpmnModelInstance modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess(SUB_PROCESS_ID)
        .fluxnovaAsyncBefore()
        .embeddedSubProcess()
          .startEvent()
          .userTask()
          .endEvent()
        .subProcessDone()
      .serviceTask(SERVICE_TASK_ID)
      .endEvent()
      .done();

    SubProcess subProcess = modelInstance.getModelElementById(SUB_PROCESS_ID);
    ServiceTask serviceTask = modelInstance.getModelElementById(SERVICE_TASK_ID);
    assertThat(subProcess.isFluxnovaAsyncBefore()).isTrue();
    assertThat(subProcess.isFluxnovaExclusive()).isTrue();
    assertThat(subProcess.getChildElementsByType(Event.class)).hasSize(2);
    assertThat(subProcess.getChildElementsByType(Task.class)).hasSize(1);
    assertThat(subProcess.getFlowElements()).hasSize(5);
    assertThat(subProcess.getSucceedingNodes().singleResult()).isEqualTo(serviceTask);
  }

  @Test
  public void testSubProcessBuilderDetached() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess(SUB_PROCESS_ID)
      .serviceTask(SERVICE_TASK_ID)
      .endEvent()
      .done();

    SubProcess subProcess = modelInstance.getModelElementById(SUB_PROCESS_ID);

    subProcess.builder()
      .fluxnovaAsyncBefore()
      .embeddedSubProcess()
        .startEvent()
        .userTask()
        .endEvent();

    ServiceTask serviceTask = modelInstance.getModelElementById(SERVICE_TASK_ID);
    assertThat(subProcess.isFluxnovaAsyncBefore()).isTrue();
    assertThat(subProcess.isFluxnovaExclusive()).isTrue();
    assertThat(subProcess.getChildElementsByType(Event.class)).hasSize(2);
    assertThat(subProcess.getChildElementsByType(Task.class)).hasSize(1);
    assertThat(subProcess.getFlowElements()).hasSize(5);
    assertThat(subProcess.getSucceedingNodes().singleResult()).isEqualTo(serviceTask);
  }

  @Test
  public void testSubProcessBuilderNested() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess(SUB_PROCESS_ID + 1)
        .fluxnovaAsyncBefore()
        .embeddedSubProcess()
          .startEvent()
          .userTask()
          .subProcess(SUB_PROCESS_ID + 2)
            .fluxnovaAsyncBefore()
            .notFluxnovaExclusive()
            .embeddedSubProcess()
              .startEvent()
              .userTask()
              .endEvent()
            .subProcessDone()
          .serviceTask(SERVICE_TASK_ID + 1)
          .endEvent()
        .subProcessDone()
      .serviceTask(SERVICE_TASK_ID + 2)
      .endEvent()
      .done();

    SubProcess subProcess = modelInstance.getModelElementById(SUB_PROCESS_ID + 1);
    ServiceTask serviceTask = modelInstance.getModelElementById(SERVICE_TASK_ID + 2);
    assertThat(subProcess.isFluxnovaAsyncBefore()).isTrue();
    assertThat(subProcess.isFluxnovaExclusive()).isTrue();
    assertThat(subProcess.getChildElementsByType(Event.class)).hasSize(2);
    assertThat(subProcess.getChildElementsByType(Task.class)).hasSize(2);
    assertThat(subProcess.getChildElementsByType(SubProcess.class)).hasSize(1);
    assertThat(subProcess.getFlowElements()).hasSize(9);
    assertThat(subProcess.getSucceedingNodes().singleResult()).isEqualTo(serviceTask);

    SubProcess nestedSubProcess = modelInstance.getModelElementById(SUB_PROCESS_ID + 2);
    ServiceTask nestedServiceTask = modelInstance.getModelElementById(SERVICE_TASK_ID + 1);
    assertThat(nestedSubProcess.isFluxnovaAsyncBefore()).isTrue();
    assertThat(nestedSubProcess.isFluxnovaExclusive()).isFalse();
    assertThat(nestedSubProcess.getChildElementsByType(Event.class)).hasSize(2);
    assertThat(nestedSubProcess.getChildElementsByType(Task.class)).hasSize(1);
    assertThat(nestedSubProcess.getFlowElements()).hasSize(5);
    assertThat(nestedSubProcess.getSucceedingNodes().singleResult()).isEqualTo(nestedServiceTask);
  }

  @Test
  public void testSubProcessBuilderWrongScope() {
    try {
      modelInstance = Bpmn.createProcess()
        .startEvent()
        .subProcessDone()
        .endEvent()
        .done();
      fail("Exception expected");
    }
    catch (Exception e) {
      assertThat(e).isInstanceOf(BpmnModelException.class);
    }
  }

  @Test
  public void testTransactionBuilder() {
    BpmnModelInstance modelInstance = Bpmn.createProcess()
      .startEvent()
      .transaction(TRANSACTION_ID)
        .fluxnovaAsyncBefore()
        .method(TransactionMethod.Image)
        .embeddedSubProcess()
          .startEvent()
          .userTask()
          .endEvent()
        .transactionDone()
      .serviceTask(SERVICE_TASK_ID)
      .endEvent()
      .done();

    Transaction transaction = modelInstance.getModelElementById(TRANSACTION_ID);
    ServiceTask serviceTask = modelInstance.getModelElementById(SERVICE_TASK_ID);
    assertThat(transaction.isFluxnovaAsyncBefore()).isTrue();
    assertThat(transaction.isFluxnovaExclusive()).isTrue();
    assertThat(transaction.getMethod()).isEqualTo(TransactionMethod.Image);
    assertThat(transaction.getChildElementsByType(Event.class)).hasSize(2);
    assertThat(transaction.getChildElementsByType(Task.class)).hasSize(1);
    assertThat(transaction.getFlowElements()).hasSize(5);
    assertThat(transaction.getSucceedingNodes().singleResult()).isEqualTo(serviceTask);
  }

  @Test
  public void testTransactionBuilderDetached() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .transaction(TRANSACTION_ID)
      .serviceTask(SERVICE_TASK_ID)
      .endEvent()
      .done();

    Transaction transaction = modelInstance.getModelElementById(TRANSACTION_ID);

    transaction.builder()
      .fluxnovaAsyncBefore()
      .embeddedSubProcess()
        .startEvent()
        .userTask()
        .endEvent();

    ServiceTask serviceTask = modelInstance.getModelElementById(SERVICE_TASK_ID);
    assertThat(transaction.isFluxnovaAsyncBefore()).isTrue();
    assertThat(transaction.isFluxnovaExclusive()).isTrue();
    assertThat(transaction.getChildElementsByType(Event.class)).hasSize(2);
    assertThat(transaction.getChildElementsByType(Task.class)).hasSize(1);
    assertThat(transaction.getFlowElements()).hasSize(5);
    assertThat(transaction.getSucceedingNodes().singleResult()).isEqualTo(serviceTask);
  }

  @Test
  public void testScriptText() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .scriptTask("script")
        .scriptFormat("groovy")
        .scriptText("println \"hello, world\";")
      .endEvent()
      .done();

    ScriptTask scriptTask = modelInstance.getModelElementById("script");
    assertThat(scriptTask.getScriptFormat()).isEqualTo("groovy");
    assertThat(scriptTask.getScript().getTextContent()).isEqualTo("println \"hello, world\";");
  }

  @Test
  public void testEventBasedGatewayAsyncAfter() {
    try {
      modelInstance = Bpmn.createProcess()
        .startEvent()
        .eventBasedGateway()
          .fluxnovaAsyncAfter()
        .done();

      fail("Expected UnsupportedOperationException");
    } catch(UnsupportedOperationException ex) {
      // happy path
    }

    try {
      modelInstance = Bpmn.createProcess()
        .startEvent()
        .eventBasedGateway()
          .fluxnovaAsyncAfter(true)
        .endEvent()
        .done();
      fail("Expected UnsupportedOperationException");
    } catch(UnsupportedOperationException ex) {
      // happy ending :D
    }
  }

  @Test
  public void testMessageStartEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent("start").message("message")
      .done();

    assertMessageEventDefinition("start", "message");
  }

  @Test
  public void testMessageStartEventWithExistingMessage() {
    modelInstance = Bpmn.createProcess()
      .startEvent("start").message("message")
        .subProcess().triggerByEvent()
         .embeddedSubProcess()
         .startEvent("subStart").message("message")
         .subProcessDone()
      .done();

    Message message = assertMessageEventDefinition("start", "message");
    Message subMessage = assertMessageEventDefinition("subStart", "message");

    assertThat(message).isEqualTo(subMessage);

    assertOnlyOneMessageExists("message");
  }

  @Test
  public void testIntermediateMessageCatchEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateCatchEvent("catch").message("message")
      .done();

    assertMessageEventDefinition("catch", "message");
  }

  @Test
  public void testIntermediateMessageCatchEventWithExistingMessage() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateCatchEvent("catch1").message("message")
      .intermediateCatchEvent("catch2").message("message")
      .done();

    Message message1 = assertMessageEventDefinition("catch1", "message");
    Message message2 = assertMessageEventDefinition("catch2", "message");

    assertThat(message1).isEqualTo(message2);

    assertOnlyOneMessageExists("message");
  }

  @Test
  public void testMessageEndEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent("end").message("message")
      .done();

    assertMessageEventDefinition("end", "message");
  }

  @Test
  public void testMessageEventDefintionEndEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent("end")
      .messageEventDefinition()
        .message("message")
      .done();

    assertMessageEventDefinition("end", "message");
  }

  @Test
  public void testMessageEndEventWithExistingMessage() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .parallelGateway()
      .endEvent("end1").message("message")
      .moveToLastGateway()
      .endEvent("end2").message("message")
      .done();

    Message message1 = assertMessageEventDefinition("end1", "message");
    Message message2 = assertMessageEventDefinition("end2", "message");

    assertThat(message1).isEqualTo(message2);

    assertOnlyOneMessageExists("message");
  }

  @Test
  public void testMessageEventDefinitionEndEventWithExistingMessage() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .parallelGateway()
      .endEvent("end1")
      .messageEventDefinition()
        .message("message")
        .messageEventDefinitionDone()
      .moveToLastGateway()
      .endEvent("end2")
      .messageEventDefinition()
        .message("message")
      .done();

    Message message1 = assertMessageEventDefinition("end1", "message");
    Message message2 = assertMessageEventDefinition("end2", "message");

    assertThat(message1).isEqualTo(message2);

    assertOnlyOneMessageExists("message");
  }

  @Test
  public void testIntermediateMessageThrowEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw").message("message")
      .done();

    assertMessageEventDefinition("throw", "message");
  }

  @Test
  public void testIntermediateMessageEventDefintionThrowEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw")
      .messageEventDefinition()
        .message("message")
      .done();

    assertMessageEventDefinition("throw", "message");
  }

  @Test
  public void testIntermediateMessageThrowEventWithExistingMessage() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw1").message("message")
      .intermediateThrowEvent("throw2").message("message")
      .done();

    Message message1 = assertMessageEventDefinition("throw1", "message");
    Message message2 = assertMessageEventDefinition("throw2", "message");

    assertThat(message1).isEqualTo(message2);
    assertOnlyOneMessageExists("message");
  }


  @Test
  public void testIntermediateMessageEventDefintionThrowEventWithExistingMessage() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw1")
      .messageEventDefinition()
        .message("message")
        .messageEventDefinitionDone()
      .intermediateThrowEvent("throw2")
      .messageEventDefinition()
        .message("message")
        .messageEventDefinitionDone()
      .done();

    Message message1 = assertMessageEventDefinition("throw1", "message");
    Message message2 = assertMessageEventDefinition("throw2", "message");

    assertThat(message1).isEqualTo(message2);
    assertOnlyOneMessageExists("message");
  }

  @Test
  public void testIntermediateMessageThrowEventWithMessageDefinition() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw1")
      .messageEventDefinition()
        .id("messageEventDefinition")
        .message("message")
        .fluxnovaTaskPriority(TEST_SERVICE_TASK_PRIORITY)
        .fluxnovaType("external")
        .fluxnovaTopic("TOPIC")
      .done();

    MessageEventDefinition event = modelInstance.getModelElementById("messageEventDefinition");
    assertThat(event.getFluxnovaTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);
    assertThat(event.getFluxnovaTopic()).isEqualTo("TOPIC");
    assertThat(event.getFluxnovaType()).isEqualTo("external");
    assertThat(event.getMessage().getName()).isEqualTo("message");
  }

  @Test
  public void testIntermediateMessageThrowEventWithTaskPriority() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw1")
      .messageEventDefinition("messageEventDefinition")
        .fluxnovaTaskPriority(TEST_SERVICE_TASK_PRIORITY)
      .done();

    MessageEventDefinition event = modelInstance.getModelElementById("messageEventDefinition");
    assertThat(event.getFluxnovaTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);
  }

  @Test
  public void testEndEventWithTaskPriority() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent("end")
      .messageEventDefinition("messageEventDefinition")
        .fluxnovaTaskPriority(TEST_SERVICE_TASK_PRIORITY)
      .done();

    MessageEventDefinition event = modelInstance.getModelElementById("messageEventDefinition");
    assertThat(event.getFluxnovaTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);
  }

  @Test
  public void testMessageEventDefinitionWithID() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw1")
      .messageEventDefinition("messageEventDefinition")
      .done();

    MessageEventDefinition event = modelInstance.getModelElementById("messageEventDefinition");
    assertThat(event).isNotNull();

    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw2")
      .messageEventDefinition().id("messageEventDefinition1")
      .done();

    //========================================
    //==============end event=================
    //========================================
    event = modelInstance.getModelElementById("messageEventDefinition1");
    assertThat(event).isNotNull();
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent("end1")
      .messageEventDefinition("messageEventDefinition")
      .done();

    event = modelInstance.getModelElementById("messageEventDefinition");
    assertThat(event).isNotNull();

    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent("end2")
      .messageEventDefinition().id("messageEventDefinition1")
      .done();

    event = modelInstance.getModelElementById("messageEventDefinition1");
    assertThat(event).isNotNull();
  }

  @Test
  public void testReceiveTaskMessage() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .receiveTask("receive").message("message")
      .done();

    ReceiveTask receiveTask = modelInstance.getModelElementById("receive");

    Message message = receiveTask.getMessage();
    assertThat(message).isNotNull();
    assertThat(message.getName()).isEqualTo("message");
  }

  @Test
  public void testReceiveTaskWithExistingMessage() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .receiveTask("receive1").message("message")
      .receiveTask("receive2").message("message")
      .done();

    ReceiveTask receiveTask1 = modelInstance.getModelElementById("receive1");
    Message message1 = receiveTask1.getMessage();

    ReceiveTask receiveTask2 = modelInstance.getModelElementById("receive2");
    Message message2 = receiveTask2.getMessage();

    assertThat(message1).isEqualTo(message2);

    assertOnlyOneMessageExists("message");
  }

  @Test
  public void testSendTaskMessage() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .sendTask("send").message("message")
      .done();

    SendTask sendTask = modelInstance.getModelElementById("send");

    Message message = sendTask.getMessage();
    assertThat(message).isNotNull();
    assertThat(message.getName()).isEqualTo("message");
  }

  @Test
  public void testSendTaskWithExistingMessage() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .sendTask("send1").message("message")
      .sendTask("send2").message("message")
      .done();

    SendTask sendTask1 = modelInstance.getModelElementById("send1");
    Message message1 = sendTask1.getMessage();

    SendTask sendTask2 = modelInstance.getModelElementById("send2");
    Message message2 = sendTask2.getMessage();

    assertThat(message1).isEqualTo(message2);

    assertOnlyOneMessageExists("message");
  }

  @Test
  public void testSignalStartEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent("start").signal("signal")
      .done();

    assertSignalEventDefinition("start", "signal");
  }

  @Test
  public void testSignalStartEventWithExistingSignal() {
    modelInstance = Bpmn.createProcess()
      .startEvent("start").signal("signal")
      .subProcess().triggerByEvent()
      .embeddedSubProcess()
      .startEvent("subStart").signal("signal")
      .subProcessDone()
      .done();

    Signal signal = assertSignalEventDefinition("start", "signal");
    Signal subSignal = assertSignalEventDefinition("subStart", "signal");

    assertThat(signal).isEqualTo(subSignal);

    assertOnlyOneSignalExists("signal");
  }

  @Test
  public void testIntermediateSignalCatchEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateCatchEvent("catch").signal("signal")
      .done();

    assertSignalEventDefinition("catch", "signal");
  }

  @Test
  public void testIntermediateSignalCatchEventWithExistingSignal() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateCatchEvent("catch1").signal("signal")
      .intermediateCatchEvent("catch2").signal("signal")
      .done();

    Signal signal1 = assertSignalEventDefinition("catch1", "signal");
    Signal signal2 = assertSignalEventDefinition("catch2", "signal");

    assertThat(signal1).isEqualTo(signal2);

    assertOnlyOneSignalExists("signal");
  }

  @Test
  public void testSignalEndEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent("end").signal("signal")
      .done();

    assertSignalEventDefinition("end", "signal");
  }

  @Test
  public void testSignalEndEventWithExistingSignal() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .parallelGateway()
      .endEvent("end1").signal("signal")
      .moveToLastGateway()
      .endEvent("end2").signal("signal")
      .done();

    Signal signal1 = assertSignalEventDefinition("end1", "signal");
    Signal signal2 = assertSignalEventDefinition("end2", "signal");

    assertThat(signal1).isEqualTo(signal2);

    assertOnlyOneSignalExists("signal");
  }

  @Test
  public void testIntermediateSignalThrowEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw").signal("signal")
      .done();

    assertSignalEventDefinition("throw", "signal");
  }

  @Test
  public void testIntermediateSignalThrowEventWithExistingSignal() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw1").signal("signal")
      .intermediateThrowEvent("throw2").signal("signal")
      .done();

    Signal signal1 = assertSignalEventDefinition("throw1", "signal");
    Signal signal2 = assertSignalEventDefinition("throw2", "signal");

    assertThat(signal1).isEqualTo(signal2);

    assertOnlyOneSignalExists("signal");
  }

  @Test
  public void testIntermediateSignalThrowEventWithPayloadLocalVar() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw")
        .signalEventDefinition("signal")
          .fluxnovaInSourceTarget("source", "target1")
          .fluxnovaInSourceExpressionTarget("${'sourceExpression'}", "target2")
          .fluxnovaInAllVariables("all", true)
          .fluxnovaInBusinessKey("aBusinessKey")
          .throwEventDefinitionDone()
      .endEvent()
      .done();

    assertSignalEventDefinition("throw", "signal");
    SignalEventDefinition signalEventDefinition = assertAndGetSingleEventDefinition("throw", SignalEventDefinition.class);

    assertThat(signalEventDefinition.getSignal().getName()).isEqualTo("signal");

    List<FluxnovaIn> camundaInParams = signalEventDefinition.getExtensionElements().getElementsQuery().filterByType(FluxnovaIn.class).list();
    assertThat(camundaInParams.size()).isEqualTo(4);

    int paramCounter = 0;
    for (FluxnovaIn inParam : camundaInParams) {
      if (inParam.getFluxnovaVariables() != null) {
        assertThat(inParam.getFluxnovaVariables()).isEqualTo("all");
        if (inParam.getFluxnovaLocal()) {
          paramCounter++;
        }
      } else if (inParam.getFluxnovaBusinessKey() != null) {
        assertThat(inParam.getFluxnovaBusinessKey()).isEqualTo("aBusinessKey");
        paramCounter++;
      } else if (inParam.getFluxnovaSourceExpression() != null) {
        assertThat(inParam.getFluxnovaSourceExpression()).isEqualTo("${'sourceExpression'}");
        assertThat(inParam.getFluxnovaTarget()).isEqualTo("target2");
        paramCounter++;
      } else if (inParam.getFluxnovaSource() != null) {
        assertThat(inParam.getFluxnovaSource()).isEqualTo("source");
        assertThat(inParam.getFluxnovaTarget()).isEqualTo("target1");
        paramCounter++;
      }
    }
    assertThat(paramCounter).isEqualTo(camundaInParams.size());
  }

  @Test
  public void testIntermediateSignalThrowEventWithPayload() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw")
        .signalEventDefinition("signal")
          .fluxnovaInAllVariables("all")
          .throwEventDefinitionDone()
      .endEvent()
      .done();

    SignalEventDefinition signalEventDefinition = assertAndGetSingleEventDefinition("throw", SignalEventDefinition.class);

    List<FluxnovaIn> camundaInParams = signalEventDefinition.getExtensionElements().getElementsQuery().filterByType(FluxnovaIn.class).list();
    assertThat(camundaInParams.size()).isEqualTo(1);

    assertThat(camundaInParams.get(0).getFluxnovaVariables()).isEqualTo("all");
  }

  @Test
  public void testMessageBoundaryEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent()
      .moveToActivity("task") // jump back to user task and attach a boundary event
      .boundaryEvent("boundary").message("message")
      .endEvent("boundaryEnd")
      .done();

    assertMessageEventDefinition("boundary", "message");

    UserTask userTask = modelInstance.getModelElementById("task");
    BoundaryEvent boundaryEvent = modelInstance.getModelElementById("boundary");
    EndEvent boundaryEnd = modelInstance.getModelElementById("boundaryEnd");

    // boundary event is attached to the user task
    assertThat(boundaryEvent.getAttachedTo()).isEqualTo(userTask);

    // boundary event has no incoming sequence flows
    assertThat(boundaryEvent.getIncoming()).isEmpty();

    // the next flow node is the boundary end event
    List<FlowNode> succeedingNodes = boundaryEvent.getSucceedingNodes().list();
    assertThat(succeedingNodes).containsOnly(boundaryEnd);
  }

  @Test
  public void testMultipleBoundaryEvents() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent()
      .moveToActivity("task") // jump back to user task and attach a boundary event
      .boundaryEvent("boundary1").message("message")
      .endEvent("boundaryEnd1")
      .moveToActivity("task") // jump back to user task and attach another boundary event
      .boundaryEvent("boundary2").signal("signal")
      .endEvent("boundaryEnd2")
      .done();

    assertMessageEventDefinition("boundary1", "message");
    assertSignalEventDefinition("boundary2", "signal");

    UserTask userTask = modelInstance.getModelElementById("task");
    BoundaryEvent boundaryEvent1 = modelInstance.getModelElementById("boundary1");
    EndEvent boundaryEnd1 = modelInstance.getModelElementById("boundaryEnd1");
    BoundaryEvent boundaryEvent2 = modelInstance.getModelElementById("boundary2");
    EndEvent boundaryEnd2 = modelInstance.getModelElementById("boundaryEnd2");

    // boundary events are attached to the user task
    assertThat(boundaryEvent1.getAttachedTo()).isEqualTo(userTask);
    assertThat(boundaryEvent2.getAttachedTo()).isEqualTo(userTask);

    // boundary events have no incoming sequence flows
    assertThat(boundaryEvent1.getIncoming()).isEmpty();
    assertThat(boundaryEvent2.getIncoming()).isEmpty();

    // the next flow node is the boundary end event
    List<FlowNode> succeedingNodes = boundaryEvent1.getSucceedingNodes().list();
    assertThat(succeedingNodes).containsOnly(boundaryEnd1);
    succeedingNodes = boundaryEvent2.getSucceedingNodes().list();
    assertThat(succeedingNodes).containsOnly(boundaryEnd2);
  }

  @Test
  public void testFluxnovaTaskListenerByClassName() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerClass("start", "aClass")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaClass()).isEqualTo("aClass");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("start");
  }

  @Test
  public void testFluxnovaTaskListenerByClass() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerClass("start", this.getClass())
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaClass()).isEqualTo(this.getClass().getName());
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("start");
  }

  @Test
  public void testFluxnovaTaskListenerByExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerExpression("start", "anExpression")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaExpression()).isEqualTo("anExpression");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("start");
  }

  @Test
  public void testFluxnovaTaskListenerByDelegateExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerDelegateExpression("start", "aDelegate")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaDelegateExpression()).isEqualTo("aDelegate");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("start");
  }

  @Test
  public void testFluxnovaTimeoutCycleTaskListenerByClassName() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerClassTimeoutWithCycle("timeout-1", "aClass", "R/PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaClass()).isEqualTo("aClass");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNotNull();
    assertThat(timeout.getTimeCycle().getRawTextContent()).isEqualTo("R/PT1H");
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFluxnovaTimeoutDateTaskListenerByClassName() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerClassTimeoutWithDate("timeout-1", "aClass", "2019-09-09T12:12:12")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaClass()).isEqualTo("aClass");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNotNull();
    assertThat(timeout.getTimeDate().getRawTextContent()).isEqualTo("2019-09-09T12:12:12");
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFluxnovaTimeoutDurationTaskListenerByClassName() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerClassTimeoutWithDuration("timeout-1", "aClass", "PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaClass()).isEqualTo("aClass");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNotNull();
    assertThat(timeout.getTimeDuration().getRawTextContent()).isEqualTo("PT1H");
  }

  @Test
  public void testFluxnovaTimeoutDurationTaskListenerByClass() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerClassTimeoutWithDuration("timeout-1", this.getClass(), "PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaClass()).isEqualTo(this.getClass().getName());
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNotNull();
    assertThat(timeout.getTimeDuration().getRawTextContent()).isEqualTo("PT1H");
  }

  @Test
  public void testFluxnovaTimeoutCycleTaskListenerByClass() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerClassTimeoutWithCycle("timeout-1", this.getClass(), "R/PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaClass()).isEqualTo(this.getClass().getName());
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNotNull();
    assertThat(timeout.getTimeCycle().getRawTextContent()).isEqualTo("R/PT1H");
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFluxnovaTimeoutDateTaskListenerByClass() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerClassTimeoutWithDate("timeout-1", this.getClass(), "2019-09-09T12:12:12")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaClass()).isEqualTo(this.getClass().getName());
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNotNull();
    assertThat(timeout.getTimeDate().getRawTextContent()).isEqualTo("2019-09-09T12:12:12");
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFluxnovaTimeoutCycleTaskListenerByExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerExpressionTimeoutWithCycle("timeout-1", "anExpression", "R/PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaExpression()).isEqualTo("anExpression");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNotNull();
    assertThat(timeout.getTimeCycle().getRawTextContent()).isEqualTo("R/PT1H");
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFluxnovaTimeoutDateTaskListenerByExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerExpressionTimeoutWithDate("timeout-1", "anExpression", "2019-09-09T12:12:12")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaExpression()).isEqualTo("anExpression");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNotNull();
    assertThat(timeout.getTimeDate().getRawTextContent()).isEqualTo("2019-09-09T12:12:12");
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFluxnovaTimeoutDurationTaskListenerByExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerExpressionTimeoutWithDuration("timeout-1", "anExpression", "PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaExpression()).isEqualTo("anExpression");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNotNull();
    assertThat(timeout.getTimeDuration().getRawTextContent()).isEqualTo("PT1H");
  }

  @Test
  public void testFluxnovaTimeoutCycleTaskListenerByDelegateExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerDelegateExpressionTimeoutWithCycle("timeout-1", "aDelegate", "R/PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaDelegateExpression()).isEqualTo("aDelegate");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNotNull();
    assertThat(timeout.getTimeCycle().getRawTextContent()).isEqualTo("R/PT1H");
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFluxnovaTimeoutDateTaskListenerByDelegateExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerDelegateExpressionTimeoutWithDate("timeout-1", "aDelegate", "2019-09-09T12:12:12")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaDelegateExpression()).isEqualTo("aDelegate");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNotNull();
    assertThat(timeout.getTimeDate().getRawTextContent()).isEqualTo("2019-09-09T12:12:12");
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFluxnovaTimeoutDurationTaskListenerByDelegateExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .fluxnovaTaskListenerDelegateExpressionTimeoutWithDuration("timeout-1", "aDelegate", "PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaTaskListener> taskListeners = extensionElements.getChildElementsByType(FluxnovaTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FluxnovaTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFluxnovaDelegateExpression()).isEqualTo("aDelegate");
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNotNull();
    assertThat(timeout.getTimeDuration().getRawTextContent()).isEqualTo("PT1H");
  }

  @Test
  public void testFluxnovaExecutionListenerByClassName() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .fluxnovaExecutionListenerClass("start", "aClass")
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaExecutionListener> executionListeners = extensionElements.getChildElementsByType(FluxnovaExecutionListener.class);
    assertThat(executionListeners).hasSize(1);

    FluxnovaExecutionListener executionListener = executionListeners.iterator().next();
    assertThat(executionListener.getFluxnovaClass()).isEqualTo("aClass");
    assertThat(executionListener.getFluxnovaEvent()).isEqualTo("start");
  }

  @Test
  public void testFluxnovaExecutionListenerByClass() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .fluxnovaExecutionListenerClass("start", this.getClass())
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaExecutionListener> executionListeners = extensionElements.getChildElementsByType(FluxnovaExecutionListener.class);
    assertThat(executionListeners).hasSize(1);

    FluxnovaExecutionListener executionListener = executionListeners.iterator().next();
    assertThat(executionListener.getFluxnovaClass()).isEqualTo(this.getClass().getName());
    assertThat(executionListener.getFluxnovaEvent()).isEqualTo("start");
  }

  @Test
  public void testFluxnovaExecutionListenerByExpression() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .fluxnovaExecutionListenerExpression("start", "anExpression")
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaExecutionListener> executionListeners = extensionElements.getChildElementsByType(FluxnovaExecutionListener.class);
    assertThat(executionListeners).hasSize(1);

    FluxnovaExecutionListener executionListener = executionListeners.iterator().next();
    assertThat(executionListener.getFluxnovaExpression()).isEqualTo("anExpression");
    assertThat(executionListener.getFluxnovaEvent()).isEqualTo("start");
  }

  @Test
  public void testFluxnovaExecutionListenerByDelegateExpression() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .fluxnovaExecutionListenerDelegateExpression("start", "aDelegateExpression")
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FluxnovaExecutionListener> executionListeners = extensionElements.getChildElementsByType(FluxnovaExecutionListener.class);
    assertThat(executionListeners).hasSize(1);

    FluxnovaExecutionListener executionListener = executionListeners.iterator().next();
    assertThat(executionListener.getFluxnovaDelegateExpression()).isEqualTo("aDelegateExpression");
    assertThat(executionListener.getFluxnovaEvent()).isEqualTo("start");
  }

  @Test
  public void testMultiInstanceLoopCharacteristicsSequential() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
        .multiInstance()
          .sequential()
          .cardinality("card")
          .completionCondition("compl")
          .fluxnovaCollection("coll")
          .fluxnovaElementVariable("element")
        .multiInstanceDone()
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    Collection<MultiInstanceLoopCharacteristics> miCharacteristics =
        userTask.getChildElementsByType(MultiInstanceLoopCharacteristics.class);

    assertThat(miCharacteristics).hasSize(1);

    MultiInstanceLoopCharacteristics miCharacteristic = miCharacteristics.iterator().next();
    assertThat(miCharacteristic.isSequential()).isTrue();
    assertThat(miCharacteristic.getLoopCardinality().getTextContent()).isEqualTo("card");
    assertThat(miCharacteristic.getCompletionCondition().getTextContent()).isEqualTo("compl");
    assertThat(miCharacteristic.getFluxnovaCollection()).isEqualTo("coll");
    assertThat(miCharacteristic.getFluxnovaElementVariable()).isEqualTo("element");

  }

  @Test
  public void testMultiInstanceLoopCharacteristicsParallel() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
        .multiInstance()
          .parallel()
        .multiInstanceDone()
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    Collection<MultiInstanceLoopCharacteristics> miCharacteristics =
      userTask.getChildElementsByType(MultiInstanceLoopCharacteristics.class);

    assertThat(miCharacteristics).hasSize(1);

    MultiInstanceLoopCharacteristics miCharacteristic = miCharacteristics.iterator().next();
    assertThat(miCharacteristic.isSequential()).isFalse();
  }

  @Test
  public void testTaskWithFluxnovaInputOutput() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
        .fluxnovaInputParameter("foo", "bar")
        .fluxnovaInputParameter("yoo", "hoo")
        .fluxnovaOutputParameter("one", "two")
        .fluxnovaOutputParameter("three", "four")
      .endEvent()
      .done();

    UserTask task = modelInstance.getModelElementById("task");
    assertFluxnovaInputOutputParameter(task);
  }

  @Test
  public void testMultiInstanceLoopCharacteristicsAsynchronousMultiInstanceAsyncBeforeElement() {
    modelInstance = Bpmn.createProcess()
            .startEvent()
            .userTask("task")
            .multiInstance()
            .fluxnovaAsyncBefore()
            .parallel()
            .multiInstanceDone()
            .endEvent()
            .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    Collection<MultiInstanceLoopCharacteristics> miCharacteristics =
            userTask.getChildElementsByType(MultiInstanceLoopCharacteristics.class);

    assertThat(miCharacteristics).hasSize(1);

    MultiInstanceLoopCharacteristics miCharacteristic = miCharacteristics.iterator().next();
    assertThat(miCharacteristic.isSequential()).isFalse();
    assertThat(miCharacteristic.isFluxnovaAsyncAfter()).isFalse();
    assertThat(miCharacteristic.isFluxnovaAsyncBefore()).isTrue();
  }

  @Test
  public void testMultiInstanceLoopCharacteristicsAsynchronousMultiInstanceAsyncAfterElement() {
    modelInstance = Bpmn.createProcess()
            .startEvent()
            .userTask("task")
            .multiInstance()
            .fluxnovaAsyncAfter()
            .parallel()
            .multiInstanceDone()
            .endEvent()
            .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    Collection<MultiInstanceLoopCharacteristics> miCharacteristics =
            userTask.getChildElementsByType(MultiInstanceLoopCharacteristics.class);

    assertThat(miCharacteristics).hasSize(1);

    MultiInstanceLoopCharacteristics miCharacteristic = miCharacteristics.iterator().next();
    assertThat(miCharacteristic.isSequential()).isFalse();
    assertThat(miCharacteristic.isFluxnovaAsyncAfter()).isTrue();
    assertThat(miCharacteristic.isFluxnovaAsyncBefore()).isFalse();
  }

  @Test
  public void testTaskWithFluxnovaInputOutputWithExistingExtensionElements() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
        .fluxnovaExecutionListenerExpression("end", "${true}")
        .fluxnovaInputParameter("foo", "bar")
        .fluxnovaInputParameter("yoo", "hoo")
        .fluxnovaOutputParameter("one", "two")
        .fluxnovaOutputParameter("three", "four")
      .endEvent()
      .done();

    UserTask task = modelInstance.getModelElementById("task");
    assertFluxnovaInputOutputParameter(task);
  }

  @Test
  public void testTaskWithFluxnovaInputOutputWithExistingFluxnovaInputOutput() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
        .fluxnovaInputParameter("foo", "bar")
        .fluxnovaOutputParameter("one", "two")
      .endEvent()
      .done();

    UserTask task = modelInstance.getModelElementById("task");

    task.builder()
      .fluxnovaInputParameter("yoo", "hoo")
      .fluxnovaOutputParameter("three", "four");

    assertFluxnovaInputOutputParameter(task);
  }

  @Test
  public void testSubProcessWithFluxnovaInputOutput() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess("subProcess")
        .fluxnovaInputParameter("foo", "bar")
        .fluxnovaInputParameter("yoo", "hoo")
        .fluxnovaOutputParameter("one", "two")
        .fluxnovaOutputParameter("three", "four")
        .embeddedSubProcess()
          .startEvent()
          .endEvent()
        .subProcessDone()
      .endEvent()
      .done();

    SubProcess subProcess = modelInstance.getModelElementById("subProcess");
    assertFluxnovaInputOutputParameter(subProcess);
  }

  @Test
  public void testSubProcessWithFluxnovaInputOutputWithExistingExtensionElements() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess("subProcess")
        .fluxnovaExecutionListenerExpression("end", "${true}")
        .fluxnovaInputParameter("foo", "bar")
        .fluxnovaInputParameter("yoo", "hoo")
        .fluxnovaOutputParameter("one", "two")
        .fluxnovaOutputParameter("three", "four")
        .embeddedSubProcess()
          .startEvent()
          .endEvent()
        .subProcessDone()
      .endEvent()
      .done();

    SubProcess subProcess = modelInstance.getModelElementById("subProcess");
    assertFluxnovaInputOutputParameter(subProcess);
  }

  @Test
  public void testSubProcessWithFluxnovaInputOutputWithExistingFluxnovaInputOutput() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess("subProcess")
        .fluxnovaInputParameter("foo", "bar")
        .fluxnovaOutputParameter("one", "two")
        .embeddedSubProcess()
          .startEvent()
          .endEvent()
        .subProcessDone()
      .endEvent()
      .done();

    SubProcess subProcess = modelInstance.getModelElementById("subProcess");

    subProcess.builder()
      .fluxnovaInputParameter("yoo", "hoo")
      .fluxnovaOutputParameter("three", "four");

    assertFluxnovaInputOutputParameter(subProcess);
  }

  @Test
  public void testTimerStartEventWithDate() {
    modelInstance = Bpmn.createProcess()
      .startEvent("start").timerWithDate(TIMER_DATE)
      .done();

    assertTimerWithDate("start", TIMER_DATE);
  }

  @Test
  public void testTimerStartEventWithDuration() {
    modelInstance = Bpmn.createProcess()
      .startEvent("start").timerWithDuration(TIMER_DURATION)
      .done();

    assertTimerWithDuration("start", TIMER_DURATION);
  }

  @Test
  public void testTimerStartEventWithCycle() {
    modelInstance = Bpmn.createProcess()
      .startEvent("start").timerWithCycle(TIMER_CYCLE)
      .done();

    assertTimerWithCycle("start", TIMER_CYCLE);
  }

  @Test
  public void testIntermediateTimerCatchEventWithDate() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateCatchEvent("catch").timerWithDate(TIMER_DATE)
      .done();

    assertTimerWithDate("catch", TIMER_DATE);
  }

  @Test
  public void testIntermediateTimerCatchEventWithDuration() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateCatchEvent("catch").timerWithDuration(TIMER_DURATION)
      .done();

    assertTimerWithDuration("catch", TIMER_DURATION);
  }

  @Test
  public void testIntermediateTimerCatchEventWithCycle() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateCatchEvent("catch").timerWithCycle(TIMER_CYCLE)
      .done();

    assertTimerWithCycle("catch", TIMER_CYCLE);
  }

  @Test
  public void testTimerBoundaryEventWithDate() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent()
      .moveToActivity("task")
      .boundaryEvent("boundary").timerWithDate(TIMER_DATE)
      .done();

    assertTimerWithDate("boundary", TIMER_DATE);
  }

  @Test
  public void testTimerBoundaryEventWithDuration() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent()
      .moveToActivity("task")
      .boundaryEvent("boundary").timerWithDuration(TIMER_DURATION)
      .done();

    assertTimerWithDuration("boundary", TIMER_DURATION);
  }

  @Test
  public void testTimerBoundaryEventWithCycle() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent()
      .moveToActivity("task")
      .boundaryEvent("boundary").timerWithCycle(TIMER_CYCLE)
      .done();

    assertTimerWithCycle("boundary", TIMER_CYCLE);
  }

  @Test
  public void testNotCancelingBoundaryEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask()
      .boundaryEvent("boundary").cancelActivity(false)
      .done();

    BoundaryEvent boundaryEvent = modelInstance.getModelElementById("boundary");
    assertThat(boundaryEvent.cancelActivity()).isFalse();
  }

  @Test
  public void testCatchAllErrorBoundaryEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent()
      .moveToActivity("task")
      .boundaryEvent("boundary").error()
      .endEvent("boundaryEnd")
      .done();

    ErrorEventDefinition errorEventDefinition = assertAndGetSingleEventDefinition("boundary", ErrorEventDefinition.class);
    assertThat(errorEventDefinition.getError()).isNull();
  }

  @Test
  public void testCompensationTask() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .boundaryEvent("boundary")
        .compensateEventDefinition().compensateEventDefinitionDone()
        .compensationStart()
        .userTask("compensate").name("compensate")
        .compensationDone()
      .endEvent("theend")
      .done();

    // Checking Association
    Collection<Association> associations = modelInstance.getModelElementsByType(Association.class);
    assertThat(associations).hasSize(1);
    Association association = associations.iterator().next();
    assertThat(association.getSource().getId()).isEqualTo("boundary");
    assertThat(association.getTarget().getId()).isEqualTo("compensate");
    assertThat(association.getAssociationDirection()).isEqualTo(AssociationDirection.One);

    // Checking Sequence flow
    UserTask task = modelInstance.getModelElementById("task");
    Collection<SequenceFlow> outgoing = task.getOutgoing();
    assertThat(outgoing).hasSize(1);
    SequenceFlow flow = outgoing.iterator().next();
    assertThat(flow.getSource().getId()).isEqualTo("task");
    assertThat(flow.getTarget().getId()).isEqualTo("theend");

  }

  @Test
  public void testOnlyOneCompensateBoundaryEventAllowed() {
    // given
    UserTaskBuilder builder = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .boundaryEvent("boundary")
      .compensateEventDefinition().compensateEventDefinitionDone()
      .compensationStart()
      .userTask("compensate").name("compensate");

    // then
    thrown.expect(BpmnModelException.class);
    thrown.expectMessage("Only single compensation handler allowed. Call compensationDone() to continue main flow.");

    // when
    builder.userTask();
  }

  @Test
  public void testInvalidCompensationStartCall() {
    // given
    StartEventBuilder builder = Bpmn.createProcess().startEvent();

    // then
    thrown.expect(BpmnModelException.class);
    thrown.expectMessage("Compensation can only be started on a boundary event with a compensation event definition");

    // when
    builder.compensationStart();
  }

  @Test
  public void testInvalidCompensationDoneCall() {
    // given
    AbstractFlowNodeBuilder builder = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .boundaryEvent("boundary")
      .compensateEventDefinition().compensateEventDefinitionDone();

    // then
    thrown.expect(BpmnModelException.class);
    thrown.expectMessage("No compensation in progress. Call compensationStart() first.");

    // when
    builder.compensationDone();
  }

  @Test
  public void testErrorBoundaryEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent()
      .moveToActivity("task")
      .boundaryEvent("boundary").error("myErrorCode", "errorMessage")
      .endEvent("boundaryEnd")
      .done();

    assertErrorEventDefinition("boundary", "myErrorCode", "errorMessage");

    UserTask userTask = modelInstance.getModelElementById("task");
    BoundaryEvent boundaryEvent = modelInstance.getModelElementById("boundary");
    EndEvent boundaryEnd = modelInstance.getModelElementById("boundaryEnd");

    // boundary event is attached to the user task
    assertThat(boundaryEvent.getAttachedTo()).isEqualTo(userTask);

    // boundary event has no incoming sequence flows
    assertThat(boundaryEvent.getIncoming()).isEmpty();

    // the next flow node is the boundary end event
    List<FlowNode> succeedingNodes = boundaryEvent.getSucceedingNodes().list();
    assertThat(succeedingNodes).containsOnly(boundaryEnd);
  }

  @Test
  public void testErrorBoundaryEventWithoutErrorMessage() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
        .userTask("task")
        .endEvent()
        .moveToActivity("task")
        .boundaryEvent("boundary").error("myErrorCode")
        .endEvent("boundaryEnd")
        .done();

    assertErrorEventDefinition("boundary", "myErrorCode", null);
  }

  @Test
  public void testErrorDefinitionForBoundaryEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent()
      .moveToActivity("task")
      .boundaryEvent("boundary")
        .errorEventDefinition("event")
          .errorCodeVariable("errorCodeVariable")
          .errorMessageVariable("errorMessageVariable")
          .error("errorCode", "errorMessage")
        .errorEventDefinitionDone()
      .endEvent("boundaryEnd")
      .done();

    assertErrorEventDefinition("boundary", "errorCode", "errorMessage");
    assertErrorEventDefinitionForErrorVariables("boundary", "errorCodeVariable", "errorMessageVariable");
  }

  @Test
  public void testErrorDefinitionForBoundaryEventWithoutEventDefinitionId() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent()
      .moveToActivity("task")
      .boundaryEvent("boundary")
        .errorEventDefinition()
          .errorCodeVariable("errorCodeVariable")
          .errorMessageVariable("errorMessageVariable")
          .error("errorCode", "errorMessage")
        .errorEventDefinitionDone()
      .endEvent("boundaryEnd")
      .done();

    Bpmn.writeModelToStream(System.out, modelInstance);

    assertErrorEventDefinition("boundary", "errorCode", "errorMessage");
    assertErrorEventDefinitionForErrorVariables("boundary", "errorCodeVariable", "errorMessageVariable");
  }

  @Test
  public void testErrorEndEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent("end").error("myErrorCode", "errorMessage")
      .done();

    assertErrorEventDefinition("end", "myErrorCode", "errorMessage");
  }

  @Test
  public void testErrorEndEventWithoutErrorMessage() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
        .endEvent("end").error("myErrorCode")
        .done();

    assertErrorEventDefinition("end", "myErrorCode", null);
  }

  @Test
  public void testErrorEndEventWithExistingError() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent("end").error("myErrorCode", "errorMessage")
      .moveToActivity("task")
      .boundaryEvent("boundary").error("myErrorCode")
      .endEvent("boundaryEnd")
      .done();

    Error boundaryError = assertErrorEventDefinition("boundary", "myErrorCode", "errorMessage");
    Error endError = assertErrorEventDefinition("end", "myErrorCode", "errorMessage");

    assertThat(boundaryError).isEqualTo(endError);

    assertOnlyOneErrorExists("myErrorCode");
  }

  @Test
  public void testErrorStartEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent()
      .subProcess()
        .triggerByEvent()
        .embeddedSubProcess()
        .startEvent("subProcessStart")
        .error("myErrorCode", "errorMessage")
        .endEvent()
      .done();

    assertErrorEventDefinition("subProcessStart", "myErrorCode", "errorMessage");
  }

  @Test
  public void testErrorStartEventWithoutErrorMessage() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
        .endEvent()
        .subProcess()
          .triggerByEvent()
          .embeddedSubProcess()
            .startEvent("subProcessStart")
            .error("myErrorCode")
            .endEvent()
        .done();

    assertErrorEventDefinition("subProcessStart", "myErrorCode", null);
  }

  @Test
  public void testCatchAllErrorStartEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent()
      .subProcess()
        .triggerByEvent()
        .embeddedSubProcess()
        .startEvent("subProcessStart")
        .error()
        .endEvent()
      .done();

    ErrorEventDefinition errorEventDefinition = assertAndGetSingleEventDefinition("subProcessStart", ErrorEventDefinition.class);
    assertThat(errorEventDefinition.getError()).isNull();
  }

  @Test
  public void testCatchAllEscalationBoundaryEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent()
      .moveToActivity("task")
      .boundaryEvent("boundary").escalation()
      .endEvent("boundaryEnd")
      .done();

    EscalationEventDefinition escalationEventDefinition = assertAndGetSingleEventDefinition("boundary", EscalationEventDefinition.class);
    assertThat(escalationEventDefinition.getEscalation()).isNull();
  }

  @Test
  public void testEscalationBoundaryEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess("subProcess")
      .endEvent()
      .moveToActivity("subProcess")
      .boundaryEvent("boundary").escalation("myEscalationCode")
      .endEvent("boundaryEnd")
      .done();

    assertEscalationEventDefinition("boundary", "myEscalationCode");

    SubProcess subProcess = modelInstance.getModelElementById("subProcess");
    BoundaryEvent boundaryEvent = modelInstance.getModelElementById("boundary");
    EndEvent boundaryEnd = modelInstance.getModelElementById("boundaryEnd");

    // boundary event is attached to the sub process
    assertThat(boundaryEvent.getAttachedTo()).isEqualTo(subProcess);

    // boundary event has no incoming sequence flows
    assertThat(boundaryEvent.getIncoming()).isEmpty();

    // the next flow node is the boundary end event
    List<FlowNode> succeedingNodes = boundaryEvent.getSucceedingNodes().list();
    assertThat(succeedingNodes).containsOnly(boundaryEnd);
  }

  @Test
  public void testEscalationEndEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent("end").escalation("myEscalationCode")
      .done();

    assertEscalationEventDefinition("end", "myEscalationCode");
  }

  @Test
  public void testEscalationStartEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent()
      .subProcess()
        .triggerByEvent()
        .embeddedSubProcess()
        .startEvent("subProcessStart")
        .escalation("myEscalationCode")
        .endEvent()
      .done();

    assertEscalationEventDefinition("subProcessStart", "myEscalationCode");
  }

  @Test
  public void testCatchAllEscalationStartEvent() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
        .endEvent()
        .subProcess()
          .triggerByEvent()
          .embeddedSubProcess()
          .startEvent("subProcessStart")
          .escalation()
          .endEvent()
        .done();

    EscalationEventDefinition escalationEventDefinition = assertAndGetSingleEventDefinition("subProcessStart", EscalationEventDefinition.class);
    assertThat(escalationEventDefinition.getEscalation()).isNull();
  }

  @Test
  public void testIntermediateEscalationThrowEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw").escalation("myEscalationCode")
      .endEvent()
      .done();

    assertEscalationEventDefinition("throw", "myEscalationCode");
  }

  @Test
  public void testEscalationEndEventWithExistingEscalation() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .endEvent("end").escalation("myEscalationCode")
      .moveToActivity("task")
      .boundaryEvent("boundary").escalation("myEscalationCode")
      .endEvent("boundaryEnd")
      .done();

    Escalation boundaryEscalation = assertEscalationEventDefinition("boundary", "myEscalationCode");
    Escalation endEscalation = assertEscalationEventDefinition("end", "myEscalationCode");

    assertThat(boundaryEscalation).isEqualTo(endEscalation);

    assertOnlyOneEscalationExists("myEscalationCode");

  }

  @Test
  public void testCompensationStartEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent()
      .subProcess()
        .triggerByEvent()
        .embeddedSubProcess()
        .startEvent("subProcessStart")
        .compensation()
        .endEvent()
      .done();

    assertCompensationEventDefinition("subProcessStart");
  }

  @Test
  public void testInterruptingStartEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent()
      .subProcess()
        .triggerByEvent()
        .embeddedSubProcess()
        .startEvent("subProcessStart")
          .interrupting(true)
          .error()
        .endEvent()
      .done();

    StartEvent startEvent = modelInstance.getModelElementById("subProcessStart");
    assertThat(startEvent).isNotNull();
    assertThat(startEvent.isInterrupting()).isTrue();
  }

  @Test
  public void testNonInterruptingStartEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent()
      .subProcess()
        .triggerByEvent()
        .embeddedSubProcess()
        .startEvent("subProcessStart")
          .interrupting(false)
          .error()
        .endEvent()
      .done();

    StartEvent startEvent = modelInstance.getModelElementById("subProcessStart");
    assertThat(startEvent).isNotNull();
    assertThat(startEvent.isInterrupting()).isFalse();
  }

  @Test
  public void testUserTaskFluxnovaFormField() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask(TASK_ID)
        .fluxnovaFormField()
          .fluxnovaId("myFormField_1")
          .fluxnovaLabel("Form Field One")
          .fluxnovaType("string")
          .fluxnovaDefaultValue("myDefaultVal_1")
         .fluxnovaFormFieldDone()
        .fluxnovaFormField()
          .fluxnovaId("myFormField_2")
          .fluxnovaLabel("Form Field Two")
          .fluxnovaType("integer")
          .fluxnovaDefaultValue("myDefaultVal_2")
         .fluxnovaFormFieldDone()
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById(TASK_ID);
    assertFluxnovaFormField(userTask);
  }

  @Test
  public void testUserTaskFluxnovaFormFieldWithExistingFluxnovaFormData() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask(TASK_ID)
        .fluxnovaFormField()
          .fluxnovaId("myFormField_1")
          .fluxnovaLabel("Form Field One")
          .fluxnovaType("string")
          .fluxnovaDefaultValue("myDefaultVal_1")
         .fluxnovaFormFieldDone()
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById(TASK_ID);

    userTask.builder()
      .fluxnovaFormField()
        .fluxnovaId("myFormField_2")
        .fluxnovaLabel("Form Field Two")
        .fluxnovaType("integer")
        .fluxnovaDefaultValue("myDefaultVal_2")
       .fluxnovaFormFieldDone();

    assertFluxnovaFormField(userTask);
  }

  @Test
  public void testStartEventFluxnovaFormField() {
    modelInstance = Bpmn.createProcess()
      .startEvent(START_EVENT_ID)
        .fluxnovaFormField()
          .fluxnovaId("myFormField_1")
          .fluxnovaLabel("Form Field One")
          .fluxnovaType("string")
          .fluxnovaDefaultValue("myDefaultVal_1")
         .fluxnovaFormFieldDone()
         .fluxnovaFormField()
         .fluxnovaId("myFormField_2")
          .fluxnovaLabel("Form Field Two")
          .fluxnovaType("integer")
          .fluxnovaDefaultValue("myDefaultVal_2")
         .fluxnovaFormFieldDone()
      .endEvent()
      .done();

    StartEvent startEvent = modelInstance.getModelElementById(START_EVENT_ID);
    assertFluxnovaFormField(startEvent);
  }

  @Test
  public void testUserTaskFluxnovaFormRef() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask(TASK_ID)
        .fluxnovaFormRef(FORM_ID)
        .fluxnovaFormRefBinding(TEST_STRING_FORM_REF_BINDING)
        .fluxnovaFormRefVersion(TEST_STRING_FORM_REF_VERSION)
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(userTask.getFluxnovaFormRef()).isEqualTo(FORM_ID);
    assertThat(userTask.getFluxnovaFormRefBinding()).isEqualTo(TEST_STRING_FORM_REF_BINDING);
    assertThat(userTask.getFluxnovaFormRefVersion()).isEqualTo(TEST_STRING_FORM_REF_VERSION);
  }

  @Test
  public void testStartEventFluxnovaFormRef() {
    modelInstance = Bpmn.createProcess()
        .startEvent(START_EVENT_ID)
          .fluxnovaFormRef(FORM_ID)
          .fluxnovaFormRefBinding(TEST_STRING_FORM_REF_BINDING)
          .fluxnovaFormRefVersion(TEST_STRING_FORM_REF_VERSION)
        .userTask()
        .endEvent()
        .done();

    StartEvent startEvent = modelInstance.getModelElementById(START_EVENT_ID);
    assertThat(startEvent.getFluxnovaFormRef()).isEqualTo(FORM_ID);
    assertThat(startEvent.getFluxnovaFormRefBinding()).isEqualTo(TEST_STRING_FORM_REF_BINDING);
    assertThat(startEvent.getFluxnovaFormRefVersion()).isEqualTo(TEST_STRING_FORM_REF_VERSION);
  }

  @Test
  public void testCompensateEventDefintionCatchStartEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent("start")
        .compensateEventDefinition()
        .waitForCompletion(false)
        .compensateEventDefinitionDone()
      .userTask("userTask")
      .endEvent("end")
      .done();

    CompensateEventDefinition eventDefinition = assertAndGetSingleEventDefinition("start", CompensateEventDefinition.class);
    Activity activity = eventDefinition.getActivity();
    assertThat(activity).isNull();
    assertThat(eventDefinition.isWaitForCompletion()).isFalse();
  }


  @Test
  public void testCompensateEventDefintionCatchBoundaryEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("userTask")
      .boundaryEvent("catch")
        .compensateEventDefinition()
        .waitForCompletion(false)
        .compensateEventDefinitionDone()
      .endEvent("end")
      .done();

    CompensateEventDefinition eventDefinition = assertAndGetSingleEventDefinition("catch", CompensateEventDefinition.class);
    Activity activity = eventDefinition.getActivity();
    assertThat(activity).isNull();
    assertThat(eventDefinition.isWaitForCompletion()).isFalse();
  }

  @Test
  public void testCompensateEventDefintionCatchBoundaryEventWithId() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("userTask")
      .boundaryEvent("catch")
        .compensateEventDefinition("foo")
        .waitForCompletion(false)
        .compensateEventDefinitionDone()
      .endEvent("end")
      .done();

    CompensateEventDefinition eventDefinition = assertAndGetSingleEventDefinition("catch", CompensateEventDefinition.class);
    assertThat(eventDefinition.getId()).isEqualTo("foo");
  }

  @Test
  public void testCompensateEventDefintionThrowEndEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("userTask")
      .endEvent("end")
        .compensateEventDefinition()
        .activityRef("userTask")
        .waitForCompletion(true)
        .compensateEventDefinitionDone()
      .done();

    CompensateEventDefinition eventDefinition = assertAndGetSingleEventDefinition("end", CompensateEventDefinition.class);
    Activity activity = eventDefinition.getActivity();
    assertThat(activity).isEqualTo(modelInstance.getModelElementById("userTask"));
    assertThat(eventDefinition.isWaitForCompletion()).isTrue();
  }

  @Test
  public void testCompensateEventDefintionThrowIntermediateEvent() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("userTask")
      .intermediateThrowEvent("throw")
        .compensateEventDefinition()
        .activityRef("userTask")
        .waitForCompletion(true)
        .compensateEventDefinitionDone()
      .endEvent("end")
      .done();

    CompensateEventDefinition eventDefinition = assertAndGetSingleEventDefinition("throw", CompensateEventDefinition.class);
    Activity activity = eventDefinition.getActivity();
    assertThat(activity).isEqualTo(modelInstance.getModelElementById("userTask"));
    assertThat(eventDefinition.isWaitForCompletion()).isTrue();
  }

  @Test
  public void testCompensateEventDefintionThrowIntermediateEventWithId() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("userTask")
      .intermediateCatchEvent("throw")
        .compensateEventDefinition("foo")
        .activityRef("userTask")
        .waitForCompletion(true)
        .compensateEventDefinitionDone()
      .endEvent("end")
      .done();

    CompensateEventDefinition eventDefinition = assertAndGetSingleEventDefinition("throw", CompensateEventDefinition.class);
    assertThat(eventDefinition.getId()).isEqualTo("foo");
  }

  @Test
  public void testCompensateEventDefintionReferencesNonExistingActivity() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("userTask")
      .endEvent("end")
      .done();

    UserTask userTask = modelInstance.getModelElementById("userTask");
    UserTaskBuilder userTaskBuilder = userTask.builder();

    try {
      userTaskBuilder
        .boundaryEvent()
        .compensateEventDefinition()
        .activityRef("nonExistingTask")
        .done();
      fail("should fail");
    } catch (BpmnModelException e) {
      assertThat(e).hasMessageContaining("Activity with id 'nonExistingTask' does not exist");
    }
  }

  @Test
  public void testCompensateEventDefintionReferencesActivityInDifferentScope() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("userTask")
      .subProcess()
        .embeddedSubProcess()
        .startEvent()
        .userTask("subProcessTask")
        .endEvent()
        .subProcessDone()
      .endEvent("end")
      .done();

    UserTask userTask = modelInstance.getModelElementById("userTask");
    UserTaskBuilder userTaskBuilder = userTask.builder();

    try {
      userTaskBuilder
        .boundaryEvent("boundary")
        .compensateEventDefinition()
        .activityRef("subProcessTask")
        .done();
      fail("should fail");
    } catch (BpmnModelException e) {
      assertThat(e).hasMessageContaining("Activity with id 'subProcessTask' must be in the same scope as 'boundary'");
    }
  }

  @Test
  public void testConditionalEventDefinitionFluxnovaExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateCatchEvent()
      .conditionalEventDefinition(CONDITION_ID)
        .condition(TEST_CONDITION)
        .fluxnovaVariableEvents(TEST_CONDITIONAL_VARIABLE_EVENTS)
        .fluxnovaVariableEvents(TEST_CONDITIONAL_VARIABLE_EVENTS_LIST)
        .fluxnovaVariableName(TEST_CONDITIONAL_VARIABLE_NAME)
      .conditionalEventDefinitionDone()
      .endEvent()
      .done();

    ConditionalEventDefinition conditionalEventDef = modelInstance.getModelElementById(CONDITION_ID);
    assertThat(conditionalEventDef.getFluxnovaVariableEvents()).isEqualTo(TEST_CONDITIONAL_VARIABLE_EVENTS);
    assertThat(conditionalEventDef.getFluxnovaVariableEventsList()).containsAll(TEST_CONDITIONAL_VARIABLE_EVENTS_LIST);
    assertThat(conditionalEventDef.getFluxnovaVariableName()).isEqualTo(TEST_CONDITIONAL_VARIABLE_NAME);
  }

  @Test
  public void testIntermediateConditionalEventDefinition() {

    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateCatchEvent(CATCH_ID)
        .conditionalEventDefinition(CONDITION_ID)
            .condition(TEST_CONDITION)
        .conditionalEventDefinitionDone()
      .endEvent()
      .done();

    ConditionalEventDefinition eventDefinition = assertAndGetSingleEventDefinition(CATCH_ID, ConditionalEventDefinition.class);
    assertThat(eventDefinition.getId()).isEqualTo(CONDITION_ID);
    assertThat(eventDefinition.getCondition().getTextContent()).isEqualTo(TEST_CONDITION);
  }

  @Test
  public void testIntermediateConditionalEventDefinitionShortCut() {

    modelInstance = Bpmn.createProcess()
      .startEvent()
        .intermediateCatchEvent(CATCH_ID)
        .condition(TEST_CONDITION)
      .endEvent()
      .done();

    ConditionalEventDefinition eventDefinition = assertAndGetSingleEventDefinition(CATCH_ID, ConditionalEventDefinition.class);
    assertThat(eventDefinition.getCondition().getTextContent()).isEqualTo(TEST_CONDITION);
  }

  @Test
  public void testBoundaryConditionalEventDefinition() {

    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask(USER_TASK_ID)
      .endEvent()
        .moveToActivity(USER_TASK_ID)
          .boundaryEvent(BOUNDARY_ID)
            .conditionalEventDefinition(CONDITION_ID)
              .condition(TEST_CONDITION)
            .conditionalEventDefinitionDone()
          .endEvent()
      .done();

    ConditionalEventDefinition eventDefinition = assertAndGetSingleEventDefinition(BOUNDARY_ID, ConditionalEventDefinition.class);
    assertThat(eventDefinition.getId()).isEqualTo(CONDITION_ID);
    assertThat(eventDefinition.getCondition().getTextContent()).isEqualTo(TEST_CONDITION);
  }

  @Test
  public void testEventSubProcessConditionalStartEvent() {

    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask()
      .endEvent()
      .subProcess()
        .triggerByEvent()
        .embeddedSubProcess()
        .startEvent(START_EVENT_ID)
          .conditionalEventDefinition(CONDITION_ID)
            .condition(TEST_CONDITION)
          .conditionalEventDefinitionDone()
        .endEvent()
      .done();

    ConditionalEventDefinition eventDefinition = assertAndGetSingleEventDefinition(START_EVENT_ID, ConditionalEventDefinition.class);
    assertThat(eventDefinition.getId()).isEqualTo(CONDITION_ID);
    assertThat(eventDefinition.getCondition().getTextContent()).isEqualTo(TEST_CONDITION);
  }

  protected Message assertMessageEventDefinition(String elementId, String messageName) {
    MessageEventDefinition messageEventDefinition = assertAndGetSingleEventDefinition(elementId, MessageEventDefinition.class);
    Message message = messageEventDefinition.getMessage();
    assertThat(message).isNotNull();
    assertThat(message.getName()).isEqualTo(messageName);

    return message;
  }

  protected void assertOnlyOneMessageExists(String messageName) {
    Collection<Message> messages = modelInstance.getModelElementsByType(Message.class);
    assertThat(messages).extracting("name").containsOnlyOnce(messageName);
  }

  protected Signal assertSignalEventDefinition(String elementId, String signalName) {
    SignalEventDefinition signalEventDefinition = assertAndGetSingleEventDefinition(elementId, SignalEventDefinition.class);
    Signal signal = signalEventDefinition.getSignal();
    assertThat(signal).isNotNull();
    assertThat(signal.getName()).isEqualTo(signalName);

    return signal;
  }

  protected void assertOnlyOneSignalExists(String signalName) {
    Collection<Signal> signals = modelInstance.getModelElementsByType(Signal.class);
    assertThat(signals).extracting("name").containsOnlyOnce(signalName);
  }

  protected Error assertErrorEventDefinition(String elementId, String errorCode, String errorMessage) {
    ErrorEventDefinition errorEventDefinition = assertAndGetSingleEventDefinition(elementId, ErrorEventDefinition.class);
    Error error = errorEventDefinition.getError();
    assertThat(error).isNotNull();
    assertThat(error.getErrorCode()).isEqualTo(errorCode);
    assertThat(error.getFluxnovaErrorMessage()).isEqualTo(errorMessage);

    return error;
  }

  protected void assertErrorEventDefinitionForErrorVariables(String elementId, String errorCodeVariable, String errorMessageVariable) {
    ErrorEventDefinition errorEventDefinition = assertAndGetSingleEventDefinition(elementId, ErrorEventDefinition.class);
    assertThat(errorEventDefinition).isNotNull();
    if(errorCodeVariable != null) {
      assertThat(errorEventDefinition.getFluxnovaErrorCodeVariable()).isEqualTo(errorCodeVariable);
    }
    if(errorMessageVariable != null) {
      assertThat(errorEventDefinition.getFluxnovaErrorMessageVariable()).isEqualTo(errorMessageVariable);
    }
  }

  protected void assertOnlyOneErrorExists(String errorCode) {
    Collection<Error> errors = modelInstance.getModelElementsByType(Error.class);
    assertThat(errors).extracting("errorCode").containsOnlyOnce(errorCode);
  }

  protected Escalation assertEscalationEventDefinition(String elementId, String escalationCode) {
    EscalationEventDefinition escalationEventDefinition = assertAndGetSingleEventDefinition(elementId, EscalationEventDefinition.class);
    Escalation escalation = escalationEventDefinition.getEscalation();
    assertThat(escalation).isNotNull();
    assertThat(escalation.getEscalationCode()).isEqualTo(escalationCode);

    return escalation;
  }

  protected void assertOnlyOneEscalationExists(String escalationCode) {
    Collection<Escalation> escalations = modelInstance.getModelElementsByType(Escalation.class);
    assertThat(escalations).extracting("escalationCode").containsOnlyOnce(escalationCode);
  }

  protected void assertCompensationEventDefinition(String elementId) {
    assertAndGetSingleEventDefinition(elementId, CompensateEventDefinition.class);
  }

  protected void assertFluxnovaInputOutputParameter(BaseElement element) {
    FluxnovaInputOutput camundaInputOutput = element.getExtensionElements().getElementsQuery().filterByType(FluxnovaInputOutput.class).singleResult();
    assertThat(camundaInputOutput).isNotNull();

    List<FluxnovaInputParameter> camundaInputParameters = new ArrayList<>(camundaInputOutput.getFluxnovaInputParameters());
    assertThat(camundaInputParameters).hasSize(2);

    FluxnovaInputParameter camundaInputParameter = camundaInputParameters.get(0);
    assertThat(camundaInputParameter.getFluxnovaName()).isEqualTo("foo");
    assertThat(camundaInputParameter.getTextContent()).isEqualTo("bar");

    camundaInputParameter = camundaInputParameters.get(1);
    assertThat(camundaInputParameter.getFluxnovaName()).isEqualTo("yoo");
    assertThat(camundaInputParameter.getTextContent()).isEqualTo("hoo");

    List<FluxnovaOutputParameter> camundaOutputParameters = new ArrayList<>(camundaInputOutput.getFluxnovaOutputParameters());
    assertThat(camundaOutputParameters).hasSize(2);

    FluxnovaOutputParameter camundaOutputParameter = camundaOutputParameters.get(0);
    assertThat(camundaOutputParameter.getFluxnovaName()).isEqualTo("one");
    assertThat(camundaOutputParameter.getTextContent()).isEqualTo("two");

    camundaOutputParameter = camundaOutputParameters.get(1);
    assertThat(camundaOutputParameter.getFluxnovaName()).isEqualTo("three");
    assertThat(camundaOutputParameter.getTextContent()).isEqualTo("four");
  }

  protected void assertTimerWithDate(String elementId, String timerDate) {
    TimerEventDefinition timerEventDefinition = assertAndGetSingleEventDefinition(elementId, TimerEventDefinition.class);
    TimeDate timeDate = timerEventDefinition.getTimeDate();
    assertThat(timeDate).isNotNull();
    assertThat(timeDate.getTextContent()).isEqualTo(timerDate);
  }

  protected void assertTimerWithDuration(String elementId, String timerDuration) {
    TimerEventDefinition timerEventDefinition = assertAndGetSingleEventDefinition(elementId, TimerEventDefinition.class);
    TimeDuration timeDuration = timerEventDefinition.getTimeDuration();
    assertThat(timeDuration).isNotNull();
    assertThat(timeDuration.getTextContent()).isEqualTo(timerDuration);
  }

  protected void assertTimerWithCycle(String elementId, String timerCycle) {
    TimerEventDefinition timerEventDefinition = assertAndGetSingleEventDefinition(elementId, TimerEventDefinition.class);
    TimeCycle timeCycle = timerEventDefinition.getTimeCycle();
    assertThat(timeCycle).isNotNull();
    assertThat(timeCycle.getTextContent()).isEqualTo(timerCycle);
  }

  @SuppressWarnings("unchecked")
  protected <T extends EventDefinition> T assertAndGetSingleEventDefinition(String elementId, Class<T> eventDefinitionType) {
    BpmnModelElementInstance element = modelInstance.getModelElementById(elementId);
    assertThat(element).isNotNull();
    Collection<EventDefinition> eventDefinitions = element.getChildElementsByType(EventDefinition.class);
    assertThat(eventDefinitions).hasSize(1);

    EventDefinition eventDefinition = eventDefinitions.iterator().next();
    assertThat(eventDefinition)
      .isNotNull()
      .isInstanceOf(eventDefinitionType);
    return (T) eventDefinition;
  }

  protected void assertFluxnovaFormField(BaseElement element) {
    assertThat(element.getExtensionElements()).isNotNull();

    FluxnovaFormData camundaFormData = element.getExtensionElements().getElementsQuery().filterByType(FluxnovaFormData.class).singleResult();
    assertThat(camundaFormData).isNotNull();

    List<FluxnovaFormField> camundaFormFields = new ArrayList<>(camundaFormData.getFluxnovaFormFields());
    assertThat(camundaFormFields).hasSize(2);

    FluxnovaFormField camundaFormField = camundaFormFields.get(0);
    assertThat(camundaFormField.getFluxnovaId()).isEqualTo("myFormField_1");
    assertThat(camundaFormField.getFluxnovaLabel()).isEqualTo("Form Field One");
    assertThat(camundaFormField.getFluxnovaType()).isEqualTo("string");
    assertThat(camundaFormField.getFluxnovaDefaultValue()).isEqualTo("myDefaultVal_1");

    camundaFormField = camundaFormFields.get(1);
    assertThat(camundaFormField.getFluxnovaId()).isEqualTo("myFormField_2");
    assertThat(camundaFormField.getFluxnovaLabel()).isEqualTo("Form Field Two");
    assertThat(camundaFormField.getFluxnovaType()).isEqualTo("integer");
    assertThat(camundaFormField.getFluxnovaDefaultValue()).isEqualTo("myDefaultVal_2");

  }

  protected void assertFluxnovaFailedJobRetryTimeCycle(BaseElement element) {
    assertThat(element.getExtensionElements()).isNotNull();

    FluxnovaFailedJobRetryTimeCycle camundaFailedJobRetryTimeCycle = element.getExtensionElements().getElementsQuery().filterByType(FluxnovaFailedJobRetryTimeCycle.class).singleResult();
    assertThat(camundaFailedJobRetryTimeCycle).isNotNull();
    assertThat(camundaFailedJobRetryTimeCycle.getTextContent()).isEqualTo(FAILED_JOB_RETRY_TIME_CYCLE);
  }

  @Test
  public void testCreateEventSubProcess() {
    ProcessBuilder process = Bpmn.createProcess();
    modelInstance = process
      .startEvent()
      .sendTask()
      .endEvent()
      .done();

    EventSubProcessBuilder eventSubProcess = process.eventSubProcess();
    eventSubProcess
      .startEvent()
      .userTask()
      .endEvent();

    SubProcess subProcess = eventSubProcess.getElement();

    // no input or output from the sub process
    assertThat(subProcess.getIncoming().isEmpty());
    assertThat(subProcess.getOutgoing().isEmpty());

    // subProcess was triggered by event
    assertThat(eventSubProcess.getElement().triggeredByEvent());

    // subProcess contains startEvent, sendTask and endEvent
    assertThat(subProcess.getChildElementsByType(StartEvent.class)).isNotNull();
    assertThat(subProcess.getChildElementsByType(UserTask.class)).isNotNull();
    assertThat(subProcess.getChildElementsByType(EndEvent.class)).isNotNull();
  }


  @Test
  public void testCreateEventSubProcessInSubProcess() {
    ProcessBuilder process = Bpmn.createProcess();
    modelInstance = process
      .startEvent()
      .subProcess("mysubprocess")
        .embeddedSubProcess()
        .startEvent()
        .userTask()
        .endEvent()
        .subProcessDone()
      .userTask()
      .endEvent()
      .done();

    SubProcess subprocess = modelInstance.getModelElementById("mysubprocess");
    subprocess
      .builder()
      .embeddedSubProcess()
        .eventSubProcess("myeventsubprocess")
        .startEvent()
        .userTask()
        .endEvent()
        .subProcessDone();

    SubProcess eventSubProcess = modelInstance.getModelElementById("myeventsubprocess");

    // no input or output from the sub process
    assertThat(eventSubProcess.getIncoming().isEmpty());
    assertThat(eventSubProcess.getOutgoing().isEmpty());

    // subProcess was triggered by event
    assertThat(eventSubProcess.triggeredByEvent());

    // subProcess contains startEvent, sendTask and endEvent
    assertThat(eventSubProcess.getChildElementsByType(StartEvent.class)).isNotNull();
    assertThat(eventSubProcess.getChildElementsByType(UserTask.class)).isNotNull();
    assertThat(eventSubProcess.getChildElementsByType(EndEvent.class)).isNotNull();
  }

  @Test
  public void testCreateEventSubProcessError() {
    ProcessBuilder process = Bpmn.createProcess();
    modelInstance = process
      .startEvent()
      .sendTask()
      .endEvent()
      .done();

    EventSubProcessBuilder eventSubProcess = process.eventSubProcess();
    eventSubProcess
      .startEvent()
      .userTask()
      .endEvent();

    try {
      eventSubProcess.subProcessDone();
      fail("eventSubProcess has returned a builder after completion");
    } catch (BpmnModelException e) {
      assertThat(e).hasMessageContaining("Unable to find a parent subProcess.");

    }
  }

  @Test
  public void testSetIdAsDefaultNameForFlowElements() {
    BpmnModelInstance instance = Bpmn.createExecutableProcess("process")
        .startEvent("start")
        .userTask("user")
        .endEvent("end")
          .name("name")
        .done();

    String startName = ((FlowElement) instance.getModelElementById("start")).getName();
    assertEquals("start", startName);
    String userName = ((FlowElement) instance.getModelElementById("user")).getName();
    assertEquals("user", userName);
    String endName = ((FlowElement) instance.getModelElementById("end")).getName();
    assertEquals("name", endName);
  }

}
