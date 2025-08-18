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
package org.finos.flowave.bpm.model.bpmn.builder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.BOUNDARY_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.CALL_ACTIVITY_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.CATCH_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.CONDITION_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.EXTERNAL_TASK_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.FORM_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.PROCESS_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.SERVICE_TASK_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.START_EVENT_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.SUB_PROCESS_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TASK_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_CLASS_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_CONDITION;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_CONDITIONAL_VARIABLE_EVENTS;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_CONDITIONAL_VARIABLE_EVENTS_LIST;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_CONDITIONAL_VARIABLE_NAME;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_DELEGATE_EXPRESSION_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_DUE_DATE_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_EXPRESSION_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_EXTERNAL_TASK_TOPIC;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_FOLLOW_UP_DATE_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_LIST_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_HISTORY_TIME_TO_LIVE;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_PRIORITY_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_PROCESS_TASK_PRIORITY;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_SERVICE_TASK_PRIORITY;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_STARTABLE_IN_TASKLIST;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_STRING_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_STRING_FORM_REF_BINDING;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_STRING_FORM_REF_VERSION;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_LIST_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_VERSION_TAG;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TRANSACTION_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.USER_TASK_ID;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.BPMN20_NS;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.finos.flowave.bpm.model.bpmn.AssociationDirection;
import org.finos.flowave.bpm.model.bpmn.Bpmn;
import org.finos.flowave.bpm.model.bpmn.BpmnModelException;
import org.finos.flowave.bpm.model.bpmn.BpmnModelInstance;
import org.finos.flowave.bpm.model.bpmn.GatewayDirection;
import org.finos.flowave.bpm.model.bpmn.TransactionMethod;
import org.finos.flowave.bpm.model.bpmn.instance.Activity;
import org.finos.flowave.bpm.model.bpmn.instance.Association;
import org.finos.flowave.bpm.model.bpmn.instance.BaseElement;
import org.finos.flowave.bpm.model.bpmn.instance.BoundaryEvent;
import org.finos.flowave.bpm.model.bpmn.instance.BpmnModelElementInstance;
import org.finos.flowave.bpm.model.bpmn.instance.BusinessRuleTask;
import org.finos.flowave.bpm.model.bpmn.instance.CallActivity;
import org.finos.flowave.bpm.model.bpmn.instance.CompensateEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.ConditionalEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.Definitions;
import org.finos.flowave.bpm.model.bpmn.instance.Documentation;
import org.finos.flowave.bpm.model.bpmn.instance.EndEvent;
import org.finos.flowave.bpm.model.bpmn.instance.Error;
import org.finos.flowave.bpm.model.bpmn.instance.ErrorEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.Escalation;
import org.finos.flowave.bpm.model.bpmn.instance.EscalationEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.Event;
import org.finos.flowave.bpm.model.bpmn.instance.EventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.ExtensionElements;
import org.finos.flowave.bpm.model.bpmn.instance.FlowElement;
import org.finos.flowave.bpm.model.bpmn.instance.FlowNode;
import org.finos.flowave.bpm.model.bpmn.instance.Gateway;
import org.finos.flowave.bpm.model.bpmn.instance.InclusiveGateway;
import org.finos.flowave.bpm.model.bpmn.instance.Message;
import org.finos.flowave.bpm.model.bpmn.instance.MessageEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.MultiInstanceLoopCharacteristics;
import org.finos.flowave.bpm.model.bpmn.instance.Process;
import org.finos.flowave.bpm.model.bpmn.instance.ReceiveTask;
import org.finos.flowave.bpm.model.bpmn.instance.ScriptTask;
import org.finos.flowave.bpm.model.bpmn.instance.SendTask;
import org.finos.flowave.bpm.model.bpmn.instance.SequenceFlow;
import org.finos.flowave.bpm.model.bpmn.instance.ServiceTask;
import org.finos.flowave.bpm.model.bpmn.instance.Signal;
import org.finos.flowave.bpm.model.bpmn.instance.SignalEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.StartEvent;
import org.finos.flowave.bpm.model.bpmn.instance.SubProcess;
import org.finos.flowave.bpm.model.bpmn.instance.Task;
import org.finos.flowave.bpm.model.bpmn.instance.TimeCycle;
import org.finos.flowave.bpm.model.bpmn.instance.TimeDate;
import org.finos.flowave.bpm.model.bpmn.instance.TimeDuration;
import org.finos.flowave.bpm.model.bpmn.instance.TimerEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.Transaction;
import org.finos.flowave.bpm.model.bpmn.instance.UserTask;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveErrorEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveExecutionListener;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFailedJobRetryTimeCycle;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormData;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormField;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveIn;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveInputOutput;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveInputParameter;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveOut;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveOutputParameter;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveTaskListener;
import org.finos.flowave.bpm.model.xml.Model;
import org.finos.flowave.bpm.model.xml.instance.ModelElementInstance;
import org.finos.flowave.bpm.model.xml.type.ModelElementType;
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

    assertThat(process.getFlowaveHistoryTimeToLiveString())
        .isEqualTo("P180D");
  }

  @Test
  public void shouldHaveDefaultHTTLValueOnSkipDefaultHistoryTimeToLiveFalse() {
    modelInstance = Bpmn.createProcess().done();

    var process = (Process) modelInstance.getModelElementsByType(processType)
        .iterator()
        .next();

    assertThat(process.getFlowaveHistoryTimeToLiveString())
        .isEqualTo("P180D");
  }

  @Test
  public void shouldHaveNullHTTLValueOnCreateProcessWithSkipHTTL() {
    modelInstance = Bpmn.createProcess().flowaveHistoryTimeToLive(null).done();

    var process = (Process) modelInstance.getModelElementsByType(processType)
        .iterator()
        .next();

    assertThat(process.getFlowaveHistoryTimeToLiveString())
        .isNull();
  }

  @Test
  public void shouldHaveNullHTTLValueOnCreateProcessIdWithoutSkipHTTL(){
    modelInstance = Bpmn.createProcess(PROCESS_ID).done();

    var process = (Process) modelInstance.getModelElementById(PROCESS_ID);

    assertThat(process.getFlowaveHistoryTimeToLiveString())
        .isEqualTo("P180D");
  }

  @Test
  public void shouldHaveNullHTTLValueOnCreateProcessIdWithSkipHTTL(){
    modelInstance = Bpmn.createProcess(PROCESS_ID).flowaveHistoryTimeToLive(null).done();

    var process = (Process) modelInstance.getModelElementById(PROCESS_ID);

    assertThat(process.getFlowaveHistoryTimeToLiveString())
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
        .flowaveFormKey("embedded:app:forms/start-form.html")
      .userTask()
        .name("Assign Approver")
        .flowaveFormKey("embedded:app:forms/assign-approver.html")
        .flowaveAssignee("demo")
      .userTask("approveInvoice")
        .name("Approve Invoice")
        .flowaveFormKey("embedded:app:forms/approve-invoice.html")
        .flowaveAssignee("${approver}")
      .exclusiveGateway()
        .name("Invoice approved?")
        .gatewayDirection(GatewayDirection.Diverging)
      .condition("yes", "${approved}")
      .userTask()
        .name("Prepare Bank Transfer")
        .flowaveFormKey("embedded:app:forms/prepare-bank-transfer.html")
        .flowaveCandidateGroups("accounting")
      .serviceTask()
        .name("Archive Invoice")
        .flowaveClass("org.finos.flowave.bpm.example.invoice.service.ArchiveInvoiceService" )
      .endEvent()
        .name("Invoice processed")
      .moveToLastGateway()
      .condition("no", "${!approved}")
      .userTask()
        .name("Review Invoice")
        .flowaveFormKey("embedded:app:forms/review-invoice.html" )
        .flowaveAssignee("demo")
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
  public void testProcessFlowaveExtensions() {
    modelInstance = Bpmn.createProcess(PROCESS_ID)
      .flowaveJobPriority("${somePriority}")
      .flowaveTaskPriority(TEST_PROCESS_TASK_PRIORITY)
      .flowaveHistoryTimeToLive(TEST_HISTORY_TIME_TO_LIVE)
      .flowaveStartableInTasklist(TEST_STARTABLE_IN_TASKLIST)
      .flowaveVersionTag(TEST_VERSION_TAG)
      .startEvent()
      .endEvent()
      .done();

    Process process = modelInstance.getModelElementById(PROCESS_ID);
    assertThat(process.getFlowaveJobPriority()).isEqualTo("${somePriority}");
    assertThat(process.getFlowaveTaskPriority()).isEqualTo(TEST_PROCESS_TASK_PRIORITY);
    assertThat(process.getFlowaveHistoryTimeToLive()).isEqualTo(TEST_HISTORY_TIME_TO_LIVE);
    assertThat(process.isFlowaveStartableInTasklist()).isEqualTo(TEST_STARTABLE_IN_TASKLIST);
    assertThat(process.getFlowaveVersionTag()).isEqualTo(TEST_VERSION_TAG);
  }

  @Test
  public void testProcessStartableInTasklist() {
    modelInstance = Bpmn.createProcess(PROCESS_ID)
      .startEvent()
      .endEvent()
      .done();

    Process process = modelInstance.getModelElementById(PROCESS_ID);
    assertThat(process.isFlowaveStartableInTasklist()).isEqualTo(true);
  }

  @Test
  public void testTaskFlowaveExternalTask() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
        .serviceTask(EXTERNAL_TASK_ID)
          .flowaveExternalTask(TEST_EXTERNAL_TASK_TOPIC)
        .endEvent()
        .done();

    ServiceTask serviceTask = modelInstance.getModelElementById(EXTERNAL_TASK_ID);
    assertThat(serviceTask.getFlowaveType()).isEqualTo("external");
    assertThat(serviceTask.getFlowaveTopic()).isEqualTo(TEST_EXTERNAL_TASK_TOPIC);
  }

  @Test
  public void testTaskFlowaveExternalTaskErrorEventDefinition() {
    modelInstance = Bpmn.createProcess()
    .startEvent()
    .serviceTask(EXTERNAL_TASK_ID)
    .flowaveExternalTask(TEST_EXTERNAL_TASK_TOPIC)
      .flowaveErrorEventDefinition().id("id").error("myErrorCode", "errorMessage").expression("expression").errorEventDefinitionDone()
    .endEvent()
    .moveToActivity(EXTERNAL_TASK_ID)
    .boundaryEvent("boundary").error("myErrorCode", "errorMessage")
    .endEvent("boundaryEnd")
    .done();

    ServiceTask externalTask = modelInstance.getModelElementById(EXTERNAL_TASK_ID);
    ExtensionElements extensionElements = externalTask.getExtensionElements();
    Collection<FlowaveErrorEventDefinition> errorEventDefinitions = extensionElements.getChildElementsByType(FlowaveErrorEventDefinition.class);
    assertThat(errorEventDefinitions).hasSize(1);
    FlowaveErrorEventDefinition camundaErrorEventDefinition = errorEventDefinitions.iterator().next();
    assertThat(camundaErrorEventDefinition).isNotNull();
    assertThat(camundaErrorEventDefinition.getId()).isEqualTo("id");
    assertThat(camundaErrorEventDefinition.getFlowaveExpression()).isEqualTo("expression");
    assertErrorEventDefinition("boundary", "myErrorCode", "errorMessage");
  }

  @Test
  public void testTaskFlowaveExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .serviceTask(TASK_ID)
        .flowaveAsyncBefore()
        .notFlowaveExclusive()
        .flowaveJobPriority("${somePriority}")
        .flowaveTaskPriority(TEST_SERVICE_TASK_PRIORITY)
        .flowaveFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    ServiceTask serviceTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(serviceTask.isFlowaveAsyncBefore()).isTrue();
    assertThat(serviceTask.isFlowaveExclusive()).isFalse();
    assertThat(serviceTask.getFlowaveJobPriority()).isEqualTo("${somePriority}");
    assertThat(serviceTask.getFlowaveTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);

    assertFlowaveFailedJobRetryTimeCycle(serviceTask);
  }

  @Test
  public void testServiceTaskFlowaveExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .serviceTask(TASK_ID)
        .flowaveClass(TEST_CLASS_API)
        .flowaveDelegateExpression(TEST_DELEGATE_EXPRESSION_API)
        .flowaveExpression(TEST_EXPRESSION_API)
        .flowaveResultVariable(TEST_STRING_API)
        .flowaveTopic(TEST_STRING_API)
        .flowaveType(TEST_STRING_API)
        .flowaveTaskPriority(TEST_SERVICE_TASK_PRIORITY)
        .flowaveFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .done();

    ServiceTask serviceTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(serviceTask.getFlowaveClass()).isEqualTo(TEST_CLASS_API);
    assertThat(serviceTask.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertThat(serviceTask.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(serviceTask.getFlowaveResultVariable()).isEqualTo(TEST_STRING_API);
    assertThat(serviceTask.getFlowaveTopic()).isEqualTo(TEST_STRING_API);
    assertThat(serviceTask.getFlowaveType()).isEqualTo(TEST_STRING_API);
    assertThat(serviceTask.getFlowaveTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);

    assertFlowaveFailedJobRetryTimeCycle(serviceTask);
  }

  @Test
  public void testServiceTaskFlowaveClass() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .serviceTask(TASK_ID)
        .flowaveClass(getClass().getName())
      .done();

    ServiceTask serviceTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(serviceTask.getFlowaveClass()).isEqualTo(getClass().getName());
  }


  @Test
  public void testSendTaskFlowaveExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .sendTask(TASK_ID)
        .flowaveClass(TEST_CLASS_API)
        .flowaveDelegateExpression(TEST_DELEGATE_EXPRESSION_API)
        .flowaveExpression(TEST_EXPRESSION_API)
        .flowaveResultVariable(TEST_STRING_API)
        .flowaveTopic(TEST_STRING_API)
        .flowaveType(TEST_STRING_API)
        .flowaveTaskPriority(TEST_SERVICE_TASK_PRIORITY)
        .flowaveFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    SendTask sendTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(sendTask.getFlowaveClass()).isEqualTo(TEST_CLASS_API);
    assertThat(sendTask.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertThat(sendTask.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(sendTask.getFlowaveResultVariable()).isEqualTo(TEST_STRING_API);
    assertThat(sendTask.getFlowaveTopic()).isEqualTo(TEST_STRING_API);
    assertThat(sendTask.getFlowaveType()).isEqualTo(TEST_STRING_API);
    assertThat(sendTask.getFlowaveTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);

    assertFlowaveFailedJobRetryTimeCycle(sendTask);
  }

  @Test
  public void testSendTaskFlowaveClass() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .sendTask(TASK_ID)
        .flowaveClass(this.getClass())
      .endEvent()
      .done();

    SendTask sendTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(sendTask.getFlowaveClass()).isEqualTo(this.getClass().getName());
  }

  @Test
  public void testUserTaskFlowaveExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask(TASK_ID)
        .flowaveAssignee(TEST_STRING_API)
        .flowaveCandidateGroups(TEST_GROUPS_API)
        .flowaveCandidateUsers(TEST_USERS_LIST_API)
        .flowaveDueDate(TEST_DUE_DATE_API)
        .flowaveFollowUpDate(TEST_FOLLOW_UP_DATE_API)
        .flowaveFormHandlerClass(TEST_CLASS_API)
        .flowaveFormKey(TEST_STRING_API)
        .flowaveFormRef(FORM_ID)
        .flowaveFormRefBinding(TEST_STRING_FORM_REF_BINDING)
        .flowaveFormRefVersion(TEST_STRING_FORM_REF_VERSION)
        .flowavePriority(TEST_PRIORITY_API)
        .flowaveFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(userTask.getFlowaveAssignee()).isEqualTo(TEST_STRING_API);
    assertThat(userTask.getFlowaveCandidateGroups()).isEqualTo(TEST_GROUPS_API);
    assertThat(userTask.getFlowaveCandidateGroupsList()).containsAll(TEST_GROUPS_LIST_API);
    assertThat(userTask.getFlowaveCandidateUsers()).isEqualTo(TEST_USERS_API);
    assertThat(userTask.getFlowaveCandidateUsersList()).containsAll(TEST_USERS_LIST_API);
    assertThat(userTask.getFlowaveDueDate()).isEqualTo(TEST_DUE_DATE_API);
    assertThat(userTask.getFlowaveFollowUpDate()).isEqualTo(TEST_FOLLOW_UP_DATE_API);
    assertThat(userTask.getFlowaveFormHandlerClass()).isEqualTo(TEST_CLASS_API);
    assertThat(userTask.getFlowaveFormKey()).isEqualTo(TEST_STRING_API);
    assertThat(userTask.getFlowaveFormRef()).isEqualTo(FORM_ID);
    assertThat(userTask.getFlowaveFormRefBinding()).isEqualTo(TEST_STRING_FORM_REF_BINDING);
    assertThat(userTask.getFlowaveFormRefVersion()).isEqualTo(TEST_STRING_FORM_REF_VERSION);
    assertThat(userTask.getFlowavePriority()).isEqualTo(TEST_PRIORITY_API);

    assertFlowaveFailedJobRetryTimeCycle(userTask);
  }

  @Test
  public void testBusinessRuleTaskFlowaveExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .businessRuleTask(TASK_ID)
        .flowaveClass(TEST_CLASS_API)
        .flowaveDelegateExpression(TEST_DELEGATE_EXPRESSION_API)
        .flowaveExpression(TEST_EXPRESSION_API)
        .flowaveResultVariable("resultVar")
        .flowaveTopic("topic")
        .flowaveType("type")
        .flowaveDecisionRef("decisionRef")
        .flowaveDecisionRefBinding("latest")
        .flowaveDecisionRefVersion("7")
        .flowaveDecisionRefVersionTag("0.1.0")
        .flowaveDecisionRefTenantId("tenantId")
        .flowaveMapDecisionResult("singleEntry")
        .flowaveTaskPriority(TEST_SERVICE_TASK_PRIORITY)
        .flowaveFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    BusinessRuleTask businessRuleTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(businessRuleTask.getFlowaveClass()).isEqualTo(TEST_CLASS_API);
    assertThat(businessRuleTask.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertThat(businessRuleTask.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(businessRuleTask.getFlowaveResultVariable()).isEqualTo("resultVar");
    assertThat(businessRuleTask.getFlowaveTopic()).isEqualTo("topic");
    assertThat(businessRuleTask.getFlowaveType()).isEqualTo("type");
    assertThat(businessRuleTask.getFlowaveDecisionRef()).isEqualTo("decisionRef");
    assertThat(businessRuleTask.getFlowaveDecisionRefBinding()).isEqualTo("latest");
    assertThat(businessRuleTask.getFlowaveDecisionRefVersion()).isEqualTo("7");
    assertThat(businessRuleTask.getFlowaveDecisionRefVersionTag()).isEqualTo("0.1.0");
    assertThat(businessRuleTask.getFlowaveDecisionRefTenantId()).isEqualTo("tenantId");
    assertThat(businessRuleTask.getFlowaveMapDecisionResult()).isEqualTo("singleEntry");
    assertThat(businessRuleTask.getFlowaveTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);

    assertFlowaveFailedJobRetryTimeCycle(businessRuleTask);
  }

  @Test
  public void testBusinessRuleTaskFlowaveClass() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .businessRuleTask(TASK_ID)
        .flowaveClass(Bpmn.class)
      .endEvent()
      .done();

    BusinessRuleTask businessRuleTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(businessRuleTask.getFlowaveClass()).isEqualTo("org.finos.flowave.bpm.model.bpmn.Bpmn");
  }

  @Test
  public void testScriptTaskFlowaveExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .scriptTask(TASK_ID)
        .flowaveResultVariable(TEST_STRING_API)
        .flowaveResource(TEST_STRING_API)
        .flowaveFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    ScriptTask scriptTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(scriptTask.getFlowaveResultVariable()).isEqualTo(TEST_STRING_API);
    assertThat(scriptTask.getFlowaveResource()).isEqualTo(TEST_STRING_API);

    assertFlowaveFailedJobRetryTimeCycle(scriptTask);
  }

  @Test
  public void testStartEventFlowaveExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent(START_EVENT_ID)
        .flowaveAsyncBefore()
        .notFlowaveExclusive()
        .flowaveFormHandlerClass(TEST_CLASS_API)
        .flowaveFormKey(TEST_STRING_API)
        .flowaveFormRef(FORM_ID)
        .flowaveFormRefBinding(TEST_STRING_FORM_REF_BINDING)
        .flowaveFormRefVersion(TEST_STRING_FORM_REF_VERSION)
        .flowaveInitiator(TEST_STRING_API)
        .flowaveFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .done();

    StartEvent startEvent = modelInstance.getModelElementById(START_EVENT_ID);
    assertThat(startEvent.isFlowaveAsyncBefore()).isTrue();
    assertThat(startEvent.isFlowaveExclusive()).isFalse();
    assertThat(startEvent.getFlowaveFormHandlerClass()).isEqualTo(TEST_CLASS_API);
    assertThat(startEvent.getFlowaveFormKey()).isEqualTo(TEST_STRING_API);
    assertThat(startEvent.getFlowaveFormRef()).isEqualTo(FORM_ID);
    assertThat(startEvent.getFlowaveFormRefBinding()).isEqualTo(TEST_STRING_FORM_REF_BINDING);
    assertThat(startEvent.getFlowaveFormRefVersion()).isEqualTo(TEST_STRING_FORM_REF_VERSION);
    assertThat(startEvent.getFlowaveInitiator()).isEqualTo(TEST_STRING_API);

    assertFlowaveFailedJobRetryTimeCycle(startEvent);
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
  public void testCallActivityFlowaveExtension() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .callActivity(CALL_ACTIVITY_ID)
        .calledElement(TEST_STRING_API)
        .flowaveAsyncBefore()
        .flowaveCalledElementBinding("version")
        .flowaveCalledElementVersion("1.0")
        .flowaveCalledElementVersionTag("ver-1.0")
        .flowaveCalledElementTenantId("t1")
        .flowaveCaseRef("case")
        .flowaveCaseBinding("deployment")
        .flowaveCaseVersion("2")
        .flowaveCaseTenantId("t2")
        .flowaveIn("in-source", "in-target")
        .flowaveOut("out-source", "out-target")
        .flowaveVariableMappingClass(TEST_CLASS_API)
        .flowaveVariableMappingDelegateExpression(TEST_DELEGATE_EXPRESSION_API)
        .notFlowaveExclusive()
        .flowaveFailedJobRetryTimeCycle(FAILED_JOB_RETRY_TIME_CYCLE)
      .endEvent()
      .done();

    CallActivity callActivity = modelInstance.getModelElementById(CALL_ACTIVITY_ID);
    assertThat(callActivity.getCalledElement()).isEqualTo(TEST_STRING_API);
    assertThat(callActivity.isFlowaveAsyncBefore()).isTrue();
    assertThat(callActivity.getFlowaveCalledElementBinding()).isEqualTo("version");
    assertThat(callActivity.getFlowaveCalledElementVersion()).isEqualTo("1.0");
    assertThat(callActivity.getFlowaveCalledElementVersionTag()).isEqualTo("ver-1.0");
    assertThat(callActivity.getFlowaveCalledElementTenantId()).isEqualTo("t1");
    assertThat(callActivity.getFlowaveCaseRef()).isEqualTo("case");
    assertThat(callActivity.getFlowaveCaseBinding()).isEqualTo("deployment");
    assertThat(callActivity.getFlowaveCaseVersion()).isEqualTo("2");
    assertThat(callActivity.getFlowaveCaseTenantId()).isEqualTo("t2");
    assertThat(callActivity.isFlowaveExclusive()).isFalse();

    FlowaveIn camundaIn = (FlowaveIn) callActivity.getExtensionElements().getUniqueChildElementByType(FlowaveIn.class);
    assertThat(camundaIn.getFlowaveSource()).isEqualTo("in-source");
    assertThat(camundaIn.getFlowaveTarget()).isEqualTo("in-target");

    FlowaveOut camundaOut = (FlowaveOut) callActivity.getExtensionElements().getUniqueChildElementByType(FlowaveOut.class);
    assertThat(camundaOut.getFlowaveSource()).isEqualTo("out-source");
    assertThat(camundaOut.getFlowaveTarget()).isEqualTo("out-target");

    assertThat(callActivity.getFlowaveVariableMappingClass()).isEqualTo(TEST_CLASS_API);
    assertThat(callActivity.getFlowaveVariableMappingDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertFlowaveFailedJobRetryTimeCycle(callActivity);
  }

  @Test
  public void testCallActivityFlowaveBusinessKey() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .callActivity(CALL_ACTIVITY_ID)
        .flowaveInBusinessKey("business-key")
      .endEvent()
      .done();

    CallActivity callActivity = modelInstance.getModelElementById(CALL_ACTIVITY_ID);
    FlowaveIn camundaIn = (FlowaveIn) callActivity.getExtensionElements().getUniqueChildElementByType(FlowaveIn.class);
    assertThat(camundaIn.getFlowaveBusinessKey()).isEqualTo("business-key");
  }

  @Test
  public void testCallActivityFlowaveVariableMappingClass() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .callActivity(CALL_ACTIVITY_ID)
        .flowaveVariableMappingClass(this.getClass())
      .endEvent()
      .done();

    CallActivity callActivity = modelInstance.getModelElementById(CALL_ACTIVITY_ID);
    assertThat(callActivity.getFlowaveVariableMappingClass()).isEqualTo(this.getClass().getName());
  }

  @Test
  public void testSubProcessBuilder() {
    BpmnModelInstance modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess(SUB_PROCESS_ID)
        .flowaveAsyncBefore()
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
    assertThat(subProcess.isFlowaveAsyncBefore()).isTrue();
    assertThat(subProcess.isFlowaveExclusive()).isTrue();
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
      .flowaveAsyncBefore()
      .embeddedSubProcess()
        .startEvent()
        .userTask()
        .endEvent();

    ServiceTask serviceTask = modelInstance.getModelElementById(SERVICE_TASK_ID);
    assertThat(subProcess.isFlowaveAsyncBefore()).isTrue();
    assertThat(subProcess.isFlowaveExclusive()).isTrue();
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
        .flowaveAsyncBefore()
        .embeddedSubProcess()
          .startEvent()
          .userTask()
          .subProcess(SUB_PROCESS_ID + 2)
            .flowaveAsyncBefore()
            .notFlowaveExclusive()
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
    assertThat(subProcess.isFlowaveAsyncBefore()).isTrue();
    assertThat(subProcess.isFlowaveExclusive()).isTrue();
    assertThat(subProcess.getChildElementsByType(Event.class)).hasSize(2);
    assertThat(subProcess.getChildElementsByType(Task.class)).hasSize(2);
    assertThat(subProcess.getChildElementsByType(SubProcess.class)).hasSize(1);
    assertThat(subProcess.getFlowElements()).hasSize(9);
    assertThat(subProcess.getSucceedingNodes().singleResult()).isEqualTo(serviceTask);

    SubProcess nestedSubProcess = modelInstance.getModelElementById(SUB_PROCESS_ID + 2);
    ServiceTask nestedServiceTask = modelInstance.getModelElementById(SERVICE_TASK_ID + 1);
    assertThat(nestedSubProcess.isFlowaveAsyncBefore()).isTrue();
    assertThat(nestedSubProcess.isFlowaveExclusive()).isFalse();
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
        .flowaveAsyncBefore()
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
    assertThat(transaction.isFlowaveAsyncBefore()).isTrue();
    assertThat(transaction.isFlowaveExclusive()).isTrue();
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
      .flowaveAsyncBefore()
      .embeddedSubProcess()
        .startEvent()
        .userTask()
        .endEvent();

    ServiceTask serviceTask = modelInstance.getModelElementById(SERVICE_TASK_ID);
    assertThat(transaction.isFlowaveAsyncBefore()).isTrue();
    assertThat(transaction.isFlowaveExclusive()).isTrue();
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
          .flowaveAsyncAfter()
        .done();

      fail("Expected UnsupportedOperationException");
    } catch(UnsupportedOperationException ex) {
      // happy path
    }

    try {
      modelInstance = Bpmn.createProcess()
        .startEvent()
        .eventBasedGateway()
          .flowaveAsyncAfter(true)
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
        .flowaveTaskPriority(TEST_SERVICE_TASK_PRIORITY)
        .flowaveType("external")
        .flowaveTopic("TOPIC")
      .done();

    MessageEventDefinition event = modelInstance.getModelElementById("messageEventDefinition");
    assertThat(event.getFlowaveTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);
    assertThat(event.getFlowaveTopic()).isEqualTo("TOPIC");
    assertThat(event.getFlowaveType()).isEqualTo("external");
    assertThat(event.getMessage().getName()).isEqualTo("message");
  }

  @Test
  public void testIntermediateMessageThrowEventWithTaskPriority() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateThrowEvent("throw1")
      .messageEventDefinition("messageEventDefinition")
        .flowaveTaskPriority(TEST_SERVICE_TASK_PRIORITY)
      .done();

    MessageEventDefinition event = modelInstance.getModelElementById("messageEventDefinition");
    assertThat(event.getFlowaveTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);
  }

  @Test
  public void testEndEventWithTaskPriority() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .endEvent("end")
      .messageEventDefinition("messageEventDefinition")
        .flowaveTaskPriority(TEST_SERVICE_TASK_PRIORITY)
      .done();

    MessageEventDefinition event = modelInstance.getModelElementById("messageEventDefinition");
    assertThat(event.getFlowaveTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);
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
          .flowaveInSourceTarget("source", "target1")
          .flowaveInSourceExpressionTarget("${'sourceExpression'}", "target2")
          .flowaveInAllVariables("all", true)
          .flowaveInBusinessKey("aBusinessKey")
          .throwEventDefinitionDone()
      .endEvent()
      .done();

    assertSignalEventDefinition("throw", "signal");
    SignalEventDefinition signalEventDefinition = assertAndGetSingleEventDefinition("throw", SignalEventDefinition.class);

    assertThat(signalEventDefinition.getSignal().getName()).isEqualTo("signal");

    List<FlowaveIn> camundaInParams = signalEventDefinition.getExtensionElements().getElementsQuery().filterByType(FlowaveIn.class).list();
    assertThat(camundaInParams.size()).isEqualTo(4);

    int paramCounter = 0;
    for (FlowaveIn inParam : camundaInParams) {
      if (inParam.getFlowaveVariables() != null) {
        assertThat(inParam.getFlowaveVariables()).isEqualTo("all");
        if (inParam.getFlowaveLocal()) {
          paramCounter++;
        }
      } else if (inParam.getFlowaveBusinessKey() != null) {
        assertThat(inParam.getFlowaveBusinessKey()).isEqualTo("aBusinessKey");
        paramCounter++;
      } else if (inParam.getFlowaveSourceExpression() != null) {
        assertThat(inParam.getFlowaveSourceExpression()).isEqualTo("${'sourceExpression'}");
        assertThat(inParam.getFlowaveTarget()).isEqualTo("target2");
        paramCounter++;
      } else if (inParam.getFlowaveSource() != null) {
        assertThat(inParam.getFlowaveSource()).isEqualTo("source");
        assertThat(inParam.getFlowaveTarget()).isEqualTo("target1");
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
          .flowaveInAllVariables("all")
          .throwEventDefinitionDone()
      .endEvent()
      .done();

    SignalEventDefinition signalEventDefinition = assertAndGetSingleEventDefinition("throw", SignalEventDefinition.class);

    List<FlowaveIn> camundaInParams = signalEventDefinition.getExtensionElements().getElementsQuery().filterByType(FlowaveIn.class).list();
    assertThat(camundaInParams.size()).isEqualTo(1);

    assertThat(camundaInParams.get(0).getFlowaveVariables()).isEqualTo("all");
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
  public void testFlowaveTaskListenerByClassName() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerClass("start", "aClass")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveClass()).isEqualTo("aClass");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("start");
  }

  @Test
  public void testFlowaveTaskListenerByClass() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerClass("start", this.getClass())
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveClass()).isEqualTo(this.getClass().getName());
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("start");
  }

  @Test
  public void testFlowaveTaskListenerByExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerExpression("start", "anExpression")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveExpression()).isEqualTo("anExpression");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("start");
  }

  @Test
  public void testFlowaveTaskListenerByDelegateExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerDelegateExpression("start", "aDelegate")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveDelegateExpression()).isEqualTo("aDelegate");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("start");
  }

  @Test
  public void testFlowaveTimeoutCycleTaskListenerByClassName() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerClassTimeoutWithCycle("timeout-1", "aClass", "R/PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveClass()).isEqualTo("aClass");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNotNull();
    assertThat(timeout.getTimeCycle().getRawTextContent()).isEqualTo("R/PT1H");
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFlowaveTimeoutDateTaskListenerByClassName() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerClassTimeoutWithDate("timeout-1", "aClass", "2019-09-09T12:12:12")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveClass()).isEqualTo("aClass");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNotNull();
    assertThat(timeout.getTimeDate().getRawTextContent()).isEqualTo("2019-09-09T12:12:12");
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFlowaveTimeoutDurationTaskListenerByClassName() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerClassTimeoutWithDuration("timeout-1", "aClass", "PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveClass()).isEqualTo("aClass");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNotNull();
    assertThat(timeout.getTimeDuration().getRawTextContent()).isEqualTo("PT1H");
  }

  @Test
  public void testFlowaveTimeoutDurationTaskListenerByClass() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerClassTimeoutWithDuration("timeout-1", this.getClass(), "PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveClass()).isEqualTo(this.getClass().getName());
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNotNull();
    assertThat(timeout.getTimeDuration().getRawTextContent()).isEqualTo("PT1H");
  }

  @Test
  public void testFlowaveTimeoutCycleTaskListenerByClass() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerClassTimeoutWithCycle("timeout-1", this.getClass(), "R/PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveClass()).isEqualTo(this.getClass().getName());
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNotNull();
    assertThat(timeout.getTimeCycle().getRawTextContent()).isEqualTo("R/PT1H");
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFlowaveTimeoutDateTaskListenerByClass() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerClassTimeoutWithDate("timeout-1", this.getClass(), "2019-09-09T12:12:12")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveClass()).isEqualTo(this.getClass().getName());
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNotNull();
    assertThat(timeout.getTimeDate().getRawTextContent()).isEqualTo("2019-09-09T12:12:12");
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFlowaveTimeoutCycleTaskListenerByExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerExpressionTimeoutWithCycle("timeout-1", "anExpression", "R/PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveExpression()).isEqualTo("anExpression");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNotNull();
    assertThat(timeout.getTimeCycle().getRawTextContent()).isEqualTo("R/PT1H");
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFlowaveTimeoutDateTaskListenerByExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerExpressionTimeoutWithDate("timeout-1", "anExpression", "2019-09-09T12:12:12")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveExpression()).isEqualTo("anExpression");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNotNull();
    assertThat(timeout.getTimeDate().getRawTextContent()).isEqualTo("2019-09-09T12:12:12");
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFlowaveTimeoutDurationTaskListenerByExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerExpressionTimeoutWithDuration("timeout-1", "anExpression", "PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveExpression()).isEqualTo("anExpression");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNotNull();
    assertThat(timeout.getTimeDuration().getRawTextContent()).isEqualTo("PT1H");
  }

  @Test
  public void testFlowaveTimeoutCycleTaskListenerByDelegateExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerDelegateExpressionTimeoutWithCycle("timeout-1", "aDelegate", "R/PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveDelegateExpression()).isEqualTo("aDelegate");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNotNull();
    assertThat(timeout.getTimeCycle().getRawTextContent()).isEqualTo("R/PT1H");
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFlowaveTimeoutDateTaskListenerByDelegateExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerDelegateExpressionTimeoutWithDate("timeout-1", "aDelegate", "2019-09-09T12:12:12")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveDelegateExpression()).isEqualTo("aDelegate");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNotNull();
    assertThat(timeout.getTimeDate().getRawTextContent()).isEqualTo("2019-09-09T12:12:12");
    assertThat(timeout.getTimeDuration()).isNull();
  }

  @Test
  public void testFlowaveTimeoutDurationTaskListenerByDelegateExpression() {
    modelInstance = Bpmn.createProcess()
        .startEvent()
          .userTask("task")
            .flowaveTaskListenerDelegateExpressionTimeoutWithDuration("timeout-1", "aDelegate", "PT1H")
        .endEvent()
        .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveTaskListener> taskListeners = extensionElements.getChildElementsByType(FlowaveTaskListener.class);
    assertThat(taskListeners).hasSize(1);

    FlowaveTaskListener taskListener = taskListeners.iterator().next();
    assertThat(taskListener.getFlowaveDelegateExpression()).isEqualTo("aDelegate");
    assertThat(taskListener.getFlowaveEvent()).isEqualTo("timeout");

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNotNull();
    assertThat(timeout.getTimeDuration().getRawTextContent()).isEqualTo("PT1H");
  }

  @Test
  public void testFlowaveExecutionListenerByClassName() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .flowaveExecutionListenerClass("start", "aClass")
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveExecutionListener> executionListeners = extensionElements.getChildElementsByType(FlowaveExecutionListener.class);
    assertThat(executionListeners).hasSize(1);

    FlowaveExecutionListener executionListener = executionListeners.iterator().next();
    assertThat(executionListener.getFlowaveClass()).isEqualTo("aClass");
    assertThat(executionListener.getFlowaveEvent()).isEqualTo("start");
  }

  @Test
  public void testFlowaveExecutionListenerByClass() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .flowaveExecutionListenerClass("start", this.getClass())
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveExecutionListener> executionListeners = extensionElements.getChildElementsByType(FlowaveExecutionListener.class);
    assertThat(executionListeners).hasSize(1);

    FlowaveExecutionListener executionListener = executionListeners.iterator().next();
    assertThat(executionListener.getFlowaveClass()).isEqualTo(this.getClass().getName());
    assertThat(executionListener.getFlowaveEvent()).isEqualTo("start");
  }

  @Test
  public void testFlowaveExecutionListenerByExpression() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .flowaveExecutionListenerExpression("start", "anExpression")
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveExecutionListener> executionListeners = extensionElements.getChildElementsByType(FlowaveExecutionListener.class);
    assertThat(executionListeners).hasSize(1);

    FlowaveExecutionListener executionListener = executionListeners.iterator().next();
    assertThat(executionListener.getFlowaveExpression()).isEqualTo("anExpression");
    assertThat(executionListener.getFlowaveEvent()).isEqualTo("start");
  }

  @Test
  public void testFlowaveExecutionListenerByDelegateExpression() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
      .flowaveExecutionListenerDelegateExpression("start", "aDelegateExpression")
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById("task");
    ExtensionElements extensionElements = userTask.getExtensionElements();
    Collection<FlowaveExecutionListener> executionListeners = extensionElements.getChildElementsByType(FlowaveExecutionListener.class);
    assertThat(executionListeners).hasSize(1);

    FlowaveExecutionListener executionListener = executionListeners.iterator().next();
    assertThat(executionListener.getFlowaveDelegateExpression()).isEqualTo("aDelegateExpression");
    assertThat(executionListener.getFlowaveEvent()).isEqualTo("start");
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
          .flowaveCollection("coll")
          .flowaveElementVariable("element")
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
    assertThat(miCharacteristic.getFlowaveCollection()).isEqualTo("coll");
    assertThat(miCharacteristic.getFlowaveElementVariable()).isEqualTo("element");

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
  public void testTaskWithFlowaveInputOutput() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
        .flowaveInputParameter("foo", "bar")
        .flowaveInputParameter("yoo", "hoo")
        .flowaveOutputParameter("one", "two")
        .flowaveOutputParameter("three", "four")
      .endEvent()
      .done();

    UserTask task = modelInstance.getModelElementById("task");
    assertFlowaveInputOutputParameter(task);
  }

  @Test
  public void testMultiInstanceLoopCharacteristicsAsynchronousMultiInstanceAsyncBeforeElement() {
    modelInstance = Bpmn.createProcess()
            .startEvent()
            .userTask("task")
            .multiInstance()
            .flowaveAsyncBefore()
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
    assertThat(miCharacteristic.isFlowaveAsyncAfter()).isFalse();
    assertThat(miCharacteristic.isFlowaveAsyncBefore()).isTrue();
  }

  @Test
  public void testMultiInstanceLoopCharacteristicsAsynchronousMultiInstanceAsyncAfterElement() {
    modelInstance = Bpmn.createProcess()
            .startEvent()
            .userTask("task")
            .multiInstance()
            .flowaveAsyncAfter()
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
    assertThat(miCharacteristic.isFlowaveAsyncAfter()).isTrue();
    assertThat(miCharacteristic.isFlowaveAsyncBefore()).isFalse();
  }

  @Test
  public void testTaskWithFlowaveInputOutputWithExistingExtensionElements() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
        .flowaveExecutionListenerExpression("end", "${true}")
        .flowaveInputParameter("foo", "bar")
        .flowaveInputParameter("yoo", "hoo")
        .flowaveOutputParameter("one", "two")
        .flowaveOutputParameter("three", "four")
      .endEvent()
      .done();

    UserTask task = modelInstance.getModelElementById("task");
    assertFlowaveInputOutputParameter(task);
  }

  @Test
  public void testTaskWithFlowaveInputOutputWithExistingFlowaveInputOutput() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("task")
        .flowaveInputParameter("foo", "bar")
        .flowaveOutputParameter("one", "two")
      .endEvent()
      .done();

    UserTask task = modelInstance.getModelElementById("task");

    task.builder()
      .flowaveInputParameter("yoo", "hoo")
      .flowaveOutputParameter("three", "four");

    assertFlowaveInputOutputParameter(task);
  }

  @Test
  public void testSubProcessWithFlowaveInputOutput() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess("subProcess")
        .flowaveInputParameter("foo", "bar")
        .flowaveInputParameter("yoo", "hoo")
        .flowaveOutputParameter("one", "two")
        .flowaveOutputParameter("three", "four")
        .embeddedSubProcess()
          .startEvent()
          .endEvent()
        .subProcessDone()
      .endEvent()
      .done();

    SubProcess subProcess = modelInstance.getModelElementById("subProcess");
    assertFlowaveInputOutputParameter(subProcess);
  }

  @Test
  public void testSubProcessWithFlowaveInputOutputWithExistingExtensionElements() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess("subProcess")
        .flowaveExecutionListenerExpression("end", "${true}")
        .flowaveInputParameter("foo", "bar")
        .flowaveInputParameter("yoo", "hoo")
        .flowaveOutputParameter("one", "two")
        .flowaveOutputParameter("three", "four")
        .embeddedSubProcess()
          .startEvent()
          .endEvent()
        .subProcessDone()
      .endEvent()
      .done();

    SubProcess subProcess = modelInstance.getModelElementById("subProcess");
    assertFlowaveInputOutputParameter(subProcess);
  }

  @Test
  public void testSubProcessWithFlowaveInputOutputWithExistingFlowaveInputOutput() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .subProcess("subProcess")
        .flowaveInputParameter("foo", "bar")
        .flowaveOutputParameter("one", "two")
        .embeddedSubProcess()
          .startEvent()
          .endEvent()
        .subProcessDone()
      .endEvent()
      .done();

    SubProcess subProcess = modelInstance.getModelElementById("subProcess");

    subProcess.builder()
      .flowaveInputParameter("yoo", "hoo")
      .flowaveOutputParameter("three", "four");

    assertFlowaveInputOutputParameter(subProcess);
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
  public void testUserTaskFlowaveFormField() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask(TASK_ID)
        .flowaveFormField()
          .flowaveId("myFormField_1")
          .flowaveLabel("Form Field One")
          .flowaveType("string")
          .flowaveDefaultValue("myDefaultVal_1")
         .flowaveFormFieldDone()
        .flowaveFormField()
          .flowaveId("myFormField_2")
          .flowaveLabel("Form Field Two")
          .flowaveType("integer")
          .flowaveDefaultValue("myDefaultVal_2")
         .flowaveFormFieldDone()
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById(TASK_ID);
    assertFlowaveFormField(userTask);
  }

  @Test
  public void testUserTaskFlowaveFormFieldWithExistingFlowaveFormData() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask(TASK_ID)
        .flowaveFormField()
          .flowaveId("myFormField_1")
          .flowaveLabel("Form Field One")
          .flowaveType("string")
          .flowaveDefaultValue("myDefaultVal_1")
         .flowaveFormFieldDone()
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById(TASK_ID);

    userTask.builder()
      .flowaveFormField()
        .flowaveId("myFormField_2")
        .flowaveLabel("Form Field Two")
        .flowaveType("integer")
        .flowaveDefaultValue("myDefaultVal_2")
       .flowaveFormFieldDone();

    assertFlowaveFormField(userTask);
  }

  @Test
  public void testStartEventFlowaveFormField() {
    modelInstance = Bpmn.createProcess()
      .startEvent(START_EVENT_ID)
        .flowaveFormField()
          .flowaveId("myFormField_1")
          .flowaveLabel("Form Field One")
          .flowaveType("string")
          .flowaveDefaultValue("myDefaultVal_1")
         .flowaveFormFieldDone()
         .flowaveFormField()
         .flowaveId("myFormField_2")
          .flowaveLabel("Form Field Two")
          .flowaveType("integer")
          .flowaveDefaultValue("myDefaultVal_2")
         .flowaveFormFieldDone()
      .endEvent()
      .done();

    StartEvent startEvent = modelInstance.getModelElementById(START_EVENT_ID);
    assertFlowaveFormField(startEvent);
  }

  @Test
  public void testUserTaskFlowaveFormRef() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask(TASK_ID)
        .flowaveFormRef(FORM_ID)
        .flowaveFormRefBinding(TEST_STRING_FORM_REF_BINDING)
        .flowaveFormRefVersion(TEST_STRING_FORM_REF_VERSION)
      .endEvent()
      .done();

    UserTask userTask = modelInstance.getModelElementById(TASK_ID);
    assertThat(userTask.getFlowaveFormRef()).isEqualTo(FORM_ID);
    assertThat(userTask.getFlowaveFormRefBinding()).isEqualTo(TEST_STRING_FORM_REF_BINDING);
    assertThat(userTask.getFlowaveFormRefVersion()).isEqualTo(TEST_STRING_FORM_REF_VERSION);
  }

  @Test
  public void testStartEventFlowaveFormRef() {
    modelInstance = Bpmn.createProcess()
        .startEvent(START_EVENT_ID)
          .flowaveFormRef(FORM_ID)
          .flowaveFormRefBinding(TEST_STRING_FORM_REF_BINDING)
          .flowaveFormRefVersion(TEST_STRING_FORM_REF_VERSION)
        .userTask()
        .endEvent()
        .done();

    StartEvent startEvent = modelInstance.getModelElementById(START_EVENT_ID);
    assertThat(startEvent.getFlowaveFormRef()).isEqualTo(FORM_ID);
    assertThat(startEvent.getFlowaveFormRefBinding()).isEqualTo(TEST_STRING_FORM_REF_BINDING);
    assertThat(startEvent.getFlowaveFormRefVersion()).isEqualTo(TEST_STRING_FORM_REF_VERSION);
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
  public void testConditionalEventDefinitionFlowaveExtensions() {
    modelInstance = Bpmn.createProcess()
      .startEvent()
      .intermediateCatchEvent()
      .conditionalEventDefinition(CONDITION_ID)
        .condition(TEST_CONDITION)
        .flowaveVariableEvents(TEST_CONDITIONAL_VARIABLE_EVENTS)
        .flowaveVariableEvents(TEST_CONDITIONAL_VARIABLE_EVENTS_LIST)
        .flowaveVariableName(TEST_CONDITIONAL_VARIABLE_NAME)
      .conditionalEventDefinitionDone()
      .endEvent()
      .done();

    ConditionalEventDefinition conditionalEventDef = modelInstance.getModelElementById(CONDITION_ID);
    assertThat(conditionalEventDef.getFlowaveVariableEvents()).isEqualTo(TEST_CONDITIONAL_VARIABLE_EVENTS);
    assertThat(conditionalEventDef.getFlowaveVariableEventsList()).containsAll(TEST_CONDITIONAL_VARIABLE_EVENTS_LIST);
    assertThat(conditionalEventDef.getFlowaveVariableName()).isEqualTo(TEST_CONDITIONAL_VARIABLE_NAME);
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
    assertThat(error.getFlowaveErrorMessage()).isEqualTo(errorMessage);

    return error;
  }

  protected void assertErrorEventDefinitionForErrorVariables(String elementId, String errorCodeVariable, String errorMessageVariable) {
    ErrorEventDefinition errorEventDefinition = assertAndGetSingleEventDefinition(elementId, ErrorEventDefinition.class);
    assertThat(errorEventDefinition).isNotNull();
    if(errorCodeVariable != null) {
      assertThat(errorEventDefinition.getFlowaveErrorCodeVariable()).isEqualTo(errorCodeVariable);
    }
    if(errorMessageVariable != null) {
      assertThat(errorEventDefinition.getFlowaveErrorMessageVariable()).isEqualTo(errorMessageVariable);
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

  protected void assertFlowaveInputOutputParameter(BaseElement element) {
    FlowaveInputOutput camundaInputOutput = element.getExtensionElements().getElementsQuery().filterByType(FlowaveInputOutput.class).singleResult();
    assertThat(camundaInputOutput).isNotNull();

    List<FlowaveInputParameter> camundaInputParameters = new ArrayList<>(camundaInputOutput.getFlowaveInputParameters());
    assertThat(camundaInputParameters).hasSize(2);

    FlowaveInputParameter camundaInputParameter = camundaInputParameters.get(0);
    assertThat(camundaInputParameter.getFlowaveName()).isEqualTo("foo");
    assertThat(camundaInputParameter.getTextContent()).isEqualTo("bar");

    camundaInputParameter = camundaInputParameters.get(1);
    assertThat(camundaInputParameter.getFlowaveName()).isEqualTo("yoo");
    assertThat(camundaInputParameter.getTextContent()).isEqualTo("hoo");

    List<FlowaveOutputParameter> camundaOutputParameters = new ArrayList<>(camundaInputOutput.getFlowaveOutputParameters());
    assertThat(camundaOutputParameters).hasSize(2);

    FlowaveOutputParameter camundaOutputParameter = camundaOutputParameters.get(0);
    assertThat(camundaOutputParameter.getFlowaveName()).isEqualTo("one");
    assertThat(camundaOutputParameter.getTextContent()).isEqualTo("two");

    camundaOutputParameter = camundaOutputParameters.get(1);
    assertThat(camundaOutputParameter.getFlowaveName()).isEqualTo("three");
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

  protected void assertFlowaveFormField(BaseElement element) {
    assertThat(element.getExtensionElements()).isNotNull();

    FlowaveFormData camundaFormData = element.getExtensionElements().getElementsQuery().filterByType(FlowaveFormData.class).singleResult();
    assertThat(camundaFormData).isNotNull();

    List<FlowaveFormField> camundaFormFields = new ArrayList<>(camundaFormData.getFlowaveFormFields());
    assertThat(camundaFormFields).hasSize(2);

    FlowaveFormField camundaFormField = camundaFormFields.get(0);
    assertThat(camundaFormField.getFlowaveId()).isEqualTo("myFormField_1");
    assertThat(camundaFormField.getFlowaveLabel()).isEqualTo("Form Field One");
    assertThat(camundaFormField.getFlowaveType()).isEqualTo("string");
    assertThat(camundaFormField.getFlowaveDefaultValue()).isEqualTo("myDefaultVal_1");

    camundaFormField = camundaFormFields.get(1);
    assertThat(camundaFormField.getFlowaveId()).isEqualTo("myFormField_2");
    assertThat(camundaFormField.getFlowaveLabel()).isEqualTo("Form Field Two");
    assertThat(camundaFormField.getFlowaveType()).isEqualTo("integer");
    assertThat(camundaFormField.getFlowaveDefaultValue()).isEqualTo("myDefaultVal_2");

  }

  protected void assertFlowaveFailedJobRetryTimeCycle(BaseElement element) {
    assertThat(element.getExtensionElements()).isNotNull();

    FlowaveFailedJobRetryTimeCycle camundaFailedJobRetryTimeCycle = element.getExtensionElements().getElementsQuery().filterByType(FlowaveFailedJobRetryTimeCycle.class).singleResult();
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
