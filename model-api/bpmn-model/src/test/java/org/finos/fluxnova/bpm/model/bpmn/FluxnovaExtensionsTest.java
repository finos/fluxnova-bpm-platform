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
package org.finos.fluxnova.bpm.model.bpmn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.BUSINESS_RULE_TASK;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.CALL_ACTIVITY_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.END_EVENT_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.PROCESS_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.SCRIPT_TASK_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.SEND_TASK_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.SEQUENCE_FLOW_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.SERVICE_TASK_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.START_EVENT_ID;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_CLASS_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_CLASS_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_DELEGATE_EXPRESSION_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_DELEGATE_EXPRESSION_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_DUE_DATE_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_DUE_DATE_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_EXECUTION_EVENT_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_EXECUTION_EVENT_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_EXPRESSION_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_EXPRESSION_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_FLOW_NODE_JOB_PRIORITY;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_LIST_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_LIST_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_HISTORY_TIME_TO_LIVE;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_PRIORITY_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_PRIORITY_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_PROCESS_JOB_PRIORITY;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_PROCESS_TASK_PRIORITY;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_SERVICE_TASK_PRIORITY;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_STRING_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_STRING_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_TASK_EVENT_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_TASK_EVENT_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_TYPE_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_TYPE_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_LIST_API;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_LIST_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_XML;
import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.USER_TASK_ID;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.ACTIVITI_NS;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_ERROR_CODE_VARIABLE;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_ERROR_MESSAGE_VARIABLE;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.FLUXNOVA_NS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.finos.fluxnova.bpm.model.bpmn.instance.BaseElement;
import org.finos.fluxnova.bpm.model.bpmn.instance.BpmnModelElementInstance;
import org.finos.fluxnova.bpm.model.bpmn.instance.BusinessRuleTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.CallActivity;
import org.finos.fluxnova.bpm.model.bpmn.instance.EndEvent;
import org.finos.fluxnova.bpm.model.bpmn.instance.Error;
import org.finos.fluxnova.bpm.model.bpmn.instance.ErrorEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.Expression;
import org.finos.fluxnova.bpm.model.bpmn.instance.MessageEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.ParallelGateway;
import org.finos.fluxnova.bpm.model.bpmn.instance.Process;
import org.finos.fluxnova.bpm.model.bpmn.instance.ScriptTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.SendTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.SequenceFlow;
import org.finos.fluxnova.bpm.model.bpmn.instance.ServiceTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.StartEvent;
import org.finos.fluxnova.bpm.model.bpmn.instance.TimerEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.UserTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaConnector;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaConnectorId;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaConstraint;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaEntry;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaExecutionListener;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFailedJobRetryTimeCycle;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaField;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFormData;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFormField;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFormProperty;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaIn;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaInputOutput;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaInputParameter;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaList;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaMap;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaOut;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaOutputParameter;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaPotentialStarter;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaProperties;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaProperty;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaScript;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaTaskListener;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaValue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Sebastian Menski
 * @author Ronny Bräunlich
 */
public class FluxnovaExtensionsTest {

  private Process process;
  private StartEvent startEvent;
  private SequenceFlow sequenceFlow;
  private UserTask userTask;
  private ServiceTask serviceTask;
  private SendTask sendTask;
  private ScriptTask scriptTask;
  private CallActivity callActivity;
  private BusinessRuleTask businessRuleTask;
  private EndEvent endEvent;
  private MessageEventDefinition messageEventDefinition;
  private ParallelGateway parallelGateway;
  private String namespace;
  private BpmnModelInstance originalModelInstance;
  private BpmnModelInstance modelInstance;
  private Error error;

  public static Collection<Object[]> parameters(){
    return Arrays.asList(new Object[][]{
        {CAMUNDA_NS, Bpmn.readModelFromStream(FluxnovaExtensionsTest.class.getResourceAsStream("CamundaExtensionsTest.xml"))},
        //for compatability reasons we gotta check the old namespace, too
        {ACTIVITI_NS, Bpmn.readModelFromStream(FluxnovaExtensionsTest.class.getResourceAsStream("CamundaExtensionsCompatabilityTest.xml"))},
        {FLUXNOVA_NS, Bpmn.readModelFromStream(FluxnovaExtensionsTest.class.getResourceAsStream("CamundaExtensionsFluxnovaCompatabilityTest.xml"))}
    });
  }

  public void initFluxnovaExtensionsTest(String namespace, BpmnModelInstance originalModelInstance) {
    this.namespace = namespace;
    this.originalModelInstance = originalModelInstance;
    modelInstance = originalModelInstance.clone();
    process = modelInstance.getModelElementById(PROCESS_ID);
    startEvent = modelInstance.getModelElementById(START_EVENT_ID);
    sequenceFlow = modelInstance.getModelElementById(SEQUENCE_FLOW_ID);
    userTask = modelInstance.getModelElementById(USER_TASK_ID);
    serviceTask = modelInstance.getModelElementById(SERVICE_TASK_ID);
    sendTask = modelInstance.getModelElementById(SEND_TASK_ID);
    scriptTask = modelInstance.getModelElementById(SCRIPT_TASK_ID);
    callActivity = modelInstance.getModelElementById(CALL_ACTIVITY_ID);
    businessRuleTask = modelInstance.getModelElementById(BUSINESS_RULE_TASK);
    endEvent = modelInstance.getModelElementById(END_EVENT_ID);
    messageEventDefinition = (MessageEventDefinition) endEvent.getEventDefinitions().iterator().next();
    parallelGateway = modelInstance.getModelElementById("parallelGateway");
    error = modelInstance.getModelElementById("error");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testAssignee(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(userTask.getFluxnovaAssignee()).isEqualTo(TEST_STRING_XML);
    userTask.setFluxnovaAssignee(TEST_STRING_API);
    assertThat(userTask.getFluxnovaAssignee()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testAsync(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(startEvent.isFluxnovaAsync()).isFalse();
    assertThat(userTask.isFluxnovaAsync()).isTrue();
    assertThat(parallelGateway.isFluxnovaAsync()).isTrue();

    startEvent.setFluxnovaAsync(true);
    userTask.setFluxnovaAsync(false);
    parallelGateway.setFluxnovaAsync(false);

    assertThat(startEvent.isFluxnovaAsync()).isTrue();
    assertThat(userTask.isFluxnovaAsync()).isFalse();
    assertThat(parallelGateway.isFluxnovaAsync()).isFalse();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testAsyncBefore(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(startEvent.isFluxnovaAsyncBefore()).isTrue();
    assertThat(endEvent.isFluxnovaAsyncBefore()).isTrue();
    assertThat(userTask.isFluxnovaAsyncBefore()).isTrue();
    assertThat(parallelGateway.isFluxnovaAsyncBefore()).isTrue();

    startEvent.setFluxnovaAsyncBefore(false);
    endEvent.setFluxnovaAsyncBefore(false);
    userTask.setFluxnovaAsyncBefore(false);
    parallelGateway.setFluxnovaAsyncBefore(false);

    assertThat(startEvent.isFluxnovaAsyncBefore()).isFalse();
    assertThat(endEvent.isFluxnovaAsyncBefore()).isFalse();
    assertThat(userTask.isFluxnovaAsyncBefore()).isFalse();
    assertThat(parallelGateway.isFluxnovaAsyncBefore()).isFalse();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testAsyncAfter(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(startEvent.isFluxnovaAsyncAfter()).isTrue();
    assertThat(endEvent.isFluxnovaAsyncAfter()).isTrue();
    assertThat(userTask.isFluxnovaAsyncAfter()).isTrue();
    assertThat(parallelGateway.isFluxnovaAsyncAfter()).isTrue();

    startEvent.setFluxnovaAsyncAfter(false);
    endEvent.setFluxnovaAsyncAfter(false);
    userTask.setFluxnovaAsyncAfter(false);
    parallelGateway.setFluxnovaAsyncAfter(false);

    assertThat(startEvent.isFluxnovaAsyncAfter()).isFalse();
    assertThat(endEvent.isFluxnovaAsyncAfter()).isFalse();
    assertThat(userTask.isFluxnovaAsyncAfter()).isFalse();
    assertThat(parallelGateway.isFluxnovaAsyncAfter()).isFalse();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFlowNodeJobPriority(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(startEvent.getFluxnovaJobPriority()).isEqualTo(TEST_FLOW_NODE_JOB_PRIORITY);
    assertThat(endEvent.getFluxnovaJobPriority()).isEqualTo(TEST_FLOW_NODE_JOB_PRIORITY);
    assertThat(userTask.getFluxnovaJobPriority()).isEqualTo(TEST_FLOW_NODE_JOB_PRIORITY);
    assertThat(parallelGateway.getFluxnovaJobPriority()).isEqualTo(TEST_FLOW_NODE_JOB_PRIORITY);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testProcessJobPriority(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(process.getFluxnovaJobPriority()).isEqualTo(TEST_PROCESS_JOB_PRIORITY);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testProcessTaskPriority(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(process.getFluxnovaTaskPriority()).isEqualTo(TEST_PROCESS_TASK_PRIORITY);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testHistoryTimeToLive(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(process.getFluxnovaHistoryTimeToLive()).isEqualTo(TEST_HISTORY_TIME_TO_LIVE);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testIsStartableInTasklist(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(process.isFluxnovaStartableInTasklist()).isEqualTo(false);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testVersionTag(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(process.getFluxnovaVersionTag()).isEqualTo("v1.0.0");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testServiceTaskPriority(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(serviceTask.getFluxnovaTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCalledElementBinding(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(callActivity.getFluxnovaCalledElementBinding()).isEqualTo(TEST_STRING_XML);
    callActivity.setFluxnovaCalledElementBinding(TEST_STRING_API);
    assertThat(callActivity.getFluxnovaCalledElementBinding()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCalledElementVersion(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(callActivity.getFluxnovaCalledElementVersion()).isEqualTo(TEST_STRING_XML);
    callActivity.setFluxnovaCalledElementVersion(TEST_STRING_API);
    assertThat(callActivity.getFluxnovaCalledElementVersion()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCalledElementVersionTag(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(callActivity.getFluxnovaCalledElementVersionTag()).isEqualTo(TEST_STRING_XML);
    callActivity.setFluxnovaCalledElementVersionTag(TEST_STRING_API);
    assertThat(callActivity.getFluxnovaCalledElementVersionTag()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCalledElementTenantId(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(callActivity.getFluxnovaCalledElementTenantId()).isEqualTo(TEST_STRING_XML);
    callActivity.setFluxnovaCalledElementTenantId(TEST_STRING_API);
    assertThat(callActivity.getFluxnovaCalledElementTenantId()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCaseRef(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(callActivity.getFluxnovaCaseRef()).isEqualTo(TEST_STRING_XML);
    callActivity.setFluxnovaCaseRef(TEST_STRING_API);
    assertThat(callActivity.getFluxnovaCaseRef()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCaseBinding(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(callActivity.getFluxnovaCaseBinding()).isEqualTo(TEST_STRING_XML);
    callActivity.setFluxnovaCaseBinding(TEST_STRING_API);
    assertThat(callActivity.getFluxnovaCaseBinding()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCaseVersion(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(callActivity.getFluxnovaCaseVersion()).isEqualTo(TEST_STRING_XML);
    callActivity.setFluxnovaCaseVersion(TEST_STRING_API);
    assertThat(callActivity.getFluxnovaCaseVersion()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCaseTenantId(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(callActivity.getFluxnovaCaseTenantId()).isEqualTo(TEST_STRING_XML);
    callActivity.setFluxnovaCaseTenantId(TEST_STRING_API);
    assertThat(callActivity.getFluxnovaCaseTenantId()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testDecisionRef(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(businessRuleTask.getFluxnovaDecisionRef()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFluxnovaDecisionRef(TEST_STRING_API);
    assertThat(businessRuleTask.getFluxnovaDecisionRef()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testDecisionRefBinding(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(businessRuleTask.getFluxnovaDecisionRefBinding()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFluxnovaDecisionRefBinding(TEST_STRING_API);
    assertThat(businessRuleTask.getFluxnovaDecisionRefBinding()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testDecisionRefVersion(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(businessRuleTask.getFluxnovaDecisionRefVersion()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFluxnovaDecisionRefVersion(TEST_STRING_API);
    assertThat(businessRuleTask.getFluxnovaDecisionRefVersion()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testDecisionRefVersionTag(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(businessRuleTask.getFluxnovaDecisionRefVersionTag()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFluxnovaDecisionRefVersionTag(TEST_STRING_API);
    assertThat(businessRuleTask.getFluxnovaDecisionRefVersionTag()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testDecisionRefTenantId(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(businessRuleTask.getFluxnovaDecisionRefTenantId()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFluxnovaDecisionRefTenantId(TEST_STRING_API);
    assertThat(businessRuleTask.getFluxnovaDecisionRefTenantId()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testMapDecisionResult(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(businessRuleTask.getFluxnovaMapDecisionResult()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFluxnovaMapDecisionResult(TEST_STRING_API);
    assertThat(businessRuleTask.getFluxnovaMapDecisionResult()).isEqualTo(TEST_STRING_API);
  }


  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testTaskPriority(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(businessRuleTask.getFluxnovaTaskPriority()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFluxnovaTaskPriority(TEST_SERVICE_TASK_PRIORITY);
    assertThat(businessRuleTask.getFluxnovaTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCandidateGroups(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(userTask.getFluxnovaCandidateGroups()).isEqualTo(TEST_GROUPS_XML);
    assertThat(userTask.getFluxnovaCandidateGroupsList()).containsAll(TEST_GROUPS_LIST_XML);
    userTask.setFluxnovaCandidateGroups(TEST_GROUPS_API);
    assertThat(userTask.getFluxnovaCandidateGroups()).isEqualTo(TEST_GROUPS_API);
    assertThat(userTask.getFluxnovaCandidateGroupsList()).containsAll(TEST_GROUPS_LIST_API);
    userTask.setFluxnovaCandidateGroupsList(TEST_GROUPS_LIST_XML);
    assertThat(userTask.getFluxnovaCandidateGroups()).isEqualTo(TEST_GROUPS_XML);
    assertThat(userTask.getFluxnovaCandidateGroupsList()).containsAll(TEST_GROUPS_LIST_XML);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCandidateStarterGroups(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(process.getFluxnovaCandidateStarterGroups()).isEqualTo(TEST_GROUPS_XML);
    assertThat(process.getFluxnovaCandidateStarterGroupsList()).containsAll(TEST_GROUPS_LIST_XML);
    process.setFluxnovaCandidateStarterGroups(TEST_GROUPS_API);
    assertThat(process.getFluxnovaCandidateStarterGroups()).isEqualTo(TEST_GROUPS_API);
    assertThat(process.getFluxnovaCandidateStarterGroupsList()).containsAll(TEST_GROUPS_LIST_API);
    process.setFluxnovaCandidateStarterGroupsList(TEST_GROUPS_LIST_XML);
    assertThat(process.getFluxnovaCandidateStarterGroups()).isEqualTo(TEST_GROUPS_XML);
    assertThat(process.getFluxnovaCandidateStarterGroupsList()).containsAll(TEST_GROUPS_LIST_XML);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCandidateStarterUsers(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(process.getFluxnovaCandidateStarterUsers()).isEqualTo(TEST_USERS_XML);
    assertThat(process.getFluxnovaCandidateStarterUsersList()).containsAll(TEST_USERS_LIST_XML);
    process.setFluxnovaCandidateStarterUsers(TEST_USERS_API);
    assertThat(process.getFluxnovaCandidateStarterUsers()).isEqualTo(TEST_USERS_API);
    assertThat(process.getFluxnovaCandidateStarterUsersList()).containsAll(TEST_USERS_LIST_API);
    process.setFluxnovaCandidateStarterUsersList(TEST_USERS_LIST_XML);
    assertThat(process.getFluxnovaCandidateStarterUsers()).isEqualTo(TEST_USERS_XML);
    assertThat(process.getFluxnovaCandidateStarterUsersList()).containsAll(TEST_USERS_LIST_XML);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testCandidateUsers(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(userTask.getFluxnovaCandidateUsers()).isEqualTo(TEST_USERS_XML);
    assertThat(userTask.getFluxnovaCandidateUsersList()).containsAll(TEST_USERS_LIST_XML);
    userTask.setFluxnovaCandidateUsers(TEST_USERS_API);
    assertThat(userTask.getFluxnovaCandidateUsers()).isEqualTo(TEST_USERS_API);
    assertThat(userTask.getFluxnovaCandidateUsersList()).containsAll(TEST_USERS_LIST_API);
    userTask.setFluxnovaCandidateUsersList(TEST_USERS_LIST_XML);
    assertThat(userTask.getFluxnovaCandidateUsers()).isEqualTo(TEST_USERS_XML);
    assertThat(userTask.getFluxnovaCandidateUsersList()).containsAll(TEST_USERS_LIST_XML);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testClass(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(serviceTask.getFluxnovaClass()).isEqualTo(TEST_CLASS_XML);
    assertThat(messageEventDefinition.getFluxnovaClass()).isEqualTo(TEST_CLASS_XML);

    serviceTask.setFluxnovaClass(TEST_CLASS_API);
    messageEventDefinition.setFluxnovaClass(TEST_CLASS_API);

    assertThat(serviceTask.getFluxnovaClass()).isEqualTo(TEST_CLASS_API);
    assertThat(messageEventDefinition.getFluxnovaClass()).isEqualTo(TEST_CLASS_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testDelegateExpression(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(serviceTask.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_XML);
    assertThat(messageEventDefinition.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_XML);

    serviceTask.setFluxnovaDelegateExpression(TEST_DELEGATE_EXPRESSION_API);
    messageEventDefinition.setFluxnovaDelegateExpression(TEST_DELEGATE_EXPRESSION_API);

    assertThat(serviceTask.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertThat(messageEventDefinition.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testDueDate(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(userTask.getFluxnovaDueDate()).isEqualTo(TEST_DUE_DATE_XML);
    userTask.setFluxnovaDueDate(TEST_DUE_DATE_API);
    assertThat(userTask.getFluxnovaDueDate()).isEqualTo(TEST_DUE_DATE_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testErrorCodeVariable(String namespace, BpmnModelInstance modelInstance){
    initFluxnovaExtensionsTest(namespace, modelInstance);
    ErrorEventDefinition errorEventDefinition = startEvent.getChildElementsByType(ErrorEventDefinition.class).iterator().next();
    assertThat(errorEventDefinition.getAttributeValueNs(namespace, CAMUNDA_ATTRIBUTE_ERROR_CODE_VARIABLE)).isEqualTo("errorVariable");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testErrorMessageVariable(String namespace, BpmnModelInstance modelInstance){
    initFluxnovaExtensionsTest(namespace, modelInstance);
    ErrorEventDefinition errorEventDefinition = startEvent.getChildElementsByType(ErrorEventDefinition.class).iterator().next();
    assertThat(errorEventDefinition.getAttributeValueNs(namespace, CAMUNDA_ATTRIBUTE_ERROR_MESSAGE_VARIABLE)).isEqualTo("errorMessageVariable");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testErrorMessage(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(error.getFluxnovaErrorMessage()).isEqualTo(TEST_STRING_XML);
    error.setFluxnovaErrorMessage(TEST_STRING_API);
    assertThat(error.getFluxnovaErrorMessage()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testExclusive(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(startEvent.isFluxnovaExclusive()).isTrue();
    assertThat(userTask.isFluxnovaExclusive()).isFalse();
    userTask.setFluxnovaExclusive(true);
    assertThat(userTask.isFluxnovaExclusive()).isTrue();
    assertThat(parallelGateway.isFluxnovaExclusive()).isTrue();
    parallelGateway.setFluxnovaExclusive(false);
    assertThat(parallelGateway.isFluxnovaExclusive()).isFalse();

    assertThat(callActivity.isFluxnovaExclusive()).isFalse();
    callActivity.setFluxnovaExclusive(true);
    assertThat(callActivity.isFluxnovaExclusive()).isTrue();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testExpression(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(serviceTask.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(messageEventDefinition.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_XML);
    serviceTask.setFluxnovaExpression(TEST_EXPRESSION_API);
    messageEventDefinition.setFluxnovaExpression(TEST_EXPRESSION_API);
    assertThat(serviceTask.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(messageEventDefinition.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFormHandlerClass(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(startEvent.getFluxnovaFormHandlerClass()).isEqualTo(TEST_CLASS_XML);
    assertThat(userTask.getFluxnovaFormHandlerClass()).isEqualTo(TEST_CLASS_XML);
    startEvent.setFluxnovaFormHandlerClass(TEST_CLASS_API);
    userTask.setFluxnovaFormHandlerClass(TEST_CLASS_API);
    assertThat(startEvent.getFluxnovaFormHandlerClass()).isEqualTo(TEST_CLASS_API);
    assertThat(userTask.getFluxnovaFormHandlerClass()).isEqualTo(TEST_CLASS_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFormKey(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(startEvent.getFluxnovaFormKey()).isEqualTo(TEST_STRING_XML);
    assertThat(userTask.getFluxnovaFormKey()).isEqualTo(TEST_STRING_XML);
    startEvent.setFluxnovaFormKey(TEST_STRING_API);
    userTask.setFluxnovaFormKey(TEST_STRING_API);
    assertThat(startEvent.getFluxnovaFormKey()).isEqualTo(TEST_STRING_API);
    assertThat(userTask.getFluxnovaFormKey()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testInitiator(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(startEvent.getFluxnovaInitiator()).isEqualTo(TEST_STRING_XML);
    startEvent.setFluxnovaInitiator(TEST_STRING_API);
    assertThat(startEvent.getFluxnovaInitiator()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testPriority(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(userTask.getFluxnovaPriority()).isEqualTo(TEST_PRIORITY_XML);
    userTask.setFluxnovaPriority(TEST_PRIORITY_API);
    assertThat(userTask.getFluxnovaPriority()).isEqualTo(TEST_PRIORITY_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testResultVariable(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(serviceTask.getFluxnovaResultVariable()).isEqualTo(TEST_STRING_XML);
    assertThat(messageEventDefinition.getFluxnovaResultVariable()).isEqualTo(TEST_STRING_XML);
    serviceTask.setFluxnovaResultVariable(TEST_STRING_API);
    messageEventDefinition.setFluxnovaResultVariable(TEST_STRING_API);
    assertThat(serviceTask.getFluxnovaResultVariable()).isEqualTo(TEST_STRING_API);
    assertThat(messageEventDefinition.getFluxnovaResultVariable()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testType(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(serviceTask.getFluxnovaType()).isEqualTo(TEST_TYPE_XML);
    assertThat(messageEventDefinition.getFluxnovaType()).isEqualTo(TEST_STRING_XML);
    serviceTask.setFluxnovaType(TEST_TYPE_API);
    messageEventDefinition.setFluxnovaType(TEST_STRING_API);
    assertThat(serviceTask.getFluxnovaType()).isEqualTo(TEST_TYPE_API);
    assertThat(messageEventDefinition.getFluxnovaType()).isEqualTo(TEST_STRING_API);

  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testTopic(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(serviceTask.getFluxnovaTopic()).isEqualTo(TEST_STRING_XML);
    assertThat(messageEventDefinition.getFluxnovaTopic()).isEqualTo(TEST_STRING_XML);
    serviceTask.setFluxnovaTopic(TEST_TYPE_API);
    messageEventDefinition.setFluxnovaTopic(TEST_STRING_API);
    assertThat(serviceTask.getFluxnovaTopic()).isEqualTo(TEST_TYPE_API);
    assertThat(messageEventDefinition.getFluxnovaTopic()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testVariableMappingClass(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(callActivity.getFluxnovaVariableMappingClass()).isEqualTo(TEST_CLASS_XML);
    callActivity.setFluxnovaVariableMappingClass(TEST_CLASS_API);
    assertThat(callActivity.getFluxnovaVariableMappingClass()).isEqualTo(TEST_CLASS_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testVariableMappingDelegateExpression(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(callActivity.getFluxnovaVariableMappingDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_XML);
    callActivity.setFluxnovaVariableMappingDelegateExpression(TEST_DELEGATE_EXPRESSION_API);
    assertThat(callActivity.getFluxnovaVariableMappingDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testExecutionListenerExtension(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaExecutionListener processListener = process.getExtensionElements().getElementsQuery().filterByType(FluxnovaExecutionListener.class).singleResult();
    FluxnovaExecutionListener startEventListener = startEvent.getExtensionElements().getElementsQuery().filterByType(FluxnovaExecutionListener.class).singleResult();
    FluxnovaExecutionListener serviceTaskListener = serviceTask.getExtensionElements().getElementsQuery().filterByType(FluxnovaExecutionListener.class).singleResult();
    assertThat(processListener.getFluxnovaClass()).isEqualTo(TEST_CLASS_XML);
    assertThat(processListener.getFluxnovaEvent()).isEqualTo(TEST_EXECUTION_EVENT_XML);
    assertThat(startEventListener.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(startEventListener.getFluxnovaEvent()).isEqualTo(TEST_EXECUTION_EVENT_XML);
    assertThat(serviceTaskListener.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_XML);
    assertThat(serviceTaskListener.getFluxnovaEvent()).isEqualTo(TEST_EXECUTION_EVENT_XML);
    processListener.setFluxnovaClass(TEST_CLASS_API);
    processListener.setFluxnovaEvent(TEST_EXECUTION_EVENT_API);
    startEventListener.setFluxnovaExpression(TEST_EXPRESSION_API);
    startEventListener.setFluxnovaEvent(TEST_EXECUTION_EVENT_API);
    serviceTaskListener.setFluxnovaDelegateExpression(TEST_DELEGATE_EXPRESSION_API);
    serviceTaskListener.setFluxnovaEvent(TEST_EXECUTION_EVENT_API);
    assertThat(processListener.getFluxnovaClass()).isEqualTo(TEST_CLASS_API);
    assertThat(processListener.getFluxnovaEvent()).isEqualTo(TEST_EXECUTION_EVENT_API);
    assertThat(startEventListener.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(startEventListener.getFluxnovaEvent()).isEqualTo(TEST_EXECUTION_EVENT_API);
    assertThat(serviceTaskListener.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertThat(serviceTaskListener.getFluxnovaEvent()).isEqualTo(TEST_EXECUTION_EVENT_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaScriptExecutionListener(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaExecutionListener sequenceFlowListener = sequenceFlow.getExtensionElements().getElementsQuery().filterByType(FluxnovaExecutionListener.class).singleResult();

    FluxnovaScript script = sequenceFlowListener.getFluxnovaScript();
    assertThat(script.getFluxnovaScriptFormat()).isEqualTo("groovy");
    assertThat(script.getFluxnovaResource()).isNull();
    assertThat(script.getTextContent()).isEqualTo("println 'Hello World'");

    FluxnovaScript newScript = this.modelInstance.newInstance(FluxnovaScript.class);
    newScript.setFluxnovaScriptFormat("groovy");
    newScript.setFluxnovaResource("test.groovy");
    sequenceFlowListener.setFluxnovaScript(newScript);

    script = sequenceFlowListener.getFluxnovaScript();
    assertThat(script.getFluxnovaScriptFormat()).isEqualTo("groovy");
    assertThat(script.getFluxnovaResource()).isEqualTo("test.groovy");
    assertThat(script.getTextContent()).isEmpty();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFailedJobRetryTimeCycleExtension(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaFailedJobRetryTimeCycle timeCycle = sendTask.getExtensionElements().getElementsQuery().filterByType(FluxnovaFailedJobRetryTimeCycle.class).singleResult();
    assertThat(timeCycle.getTextContent()).isEqualTo(TEST_STRING_XML);
    timeCycle.setTextContent(TEST_STRING_API);
    assertThat(timeCycle.getTextContent()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFieldExtension(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaField field = sendTask.getExtensionElements().getElementsQuery().filterByType(FluxnovaField.class).singleResult();
    assertThat(field.getFluxnovaName()).isEqualTo(TEST_STRING_XML);
    assertThat(field.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(field.getFluxnovaStringValue()).isEqualTo(TEST_STRING_XML);
    assertThat(field.getFluxnovaExpressionChild().getTextContent()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(field.getFluxnovaString().getTextContent()).isEqualTo(TEST_STRING_XML);
    field.setFluxnovaName(TEST_STRING_API);
    field.setFluxnovaExpression(TEST_EXPRESSION_API);
    field.setFluxnovaStringValue(TEST_STRING_API);
    field.getFluxnovaExpressionChild().setTextContent(TEST_EXPRESSION_API);
    field.getFluxnovaString().setTextContent(TEST_STRING_API);
    assertThat(field.getFluxnovaName()).isEqualTo(TEST_STRING_API);
    assertThat(field.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(field.getFluxnovaStringValue()).isEqualTo(TEST_STRING_API);
    assertThat(field.getFluxnovaExpressionChild().getTextContent()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(field.getFluxnovaString().getTextContent()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFormData(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaFormData formData = userTask.getExtensionElements().getElementsQuery().filterByType(FluxnovaFormData.class).singleResult();
    FluxnovaFormField formField = formData.getFluxnovaFormFields().iterator().next();
    assertThat(formField.getFluxnovaId()).isEqualTo(TEST_STRING_XML);
    assertThat(formField.getFluxnovaLabel()).isEqualTo(TEST_STRING_XML);
    assertThat(formField.getFluxnovaType()).isEqualTo(TEST_STRING_XML);
    assertThat(formField.getFluxnovaDatePattern()).isEqualTo(TEST_STRING_XML);
    assertThat(formField.getFluxnovaDefaultValue()).isEqualTo(TEST_STRING_XML);
    formField.setFluxnovaId(TEST_STRING_API);
    formField.setFluxnovaLabel(TEST_STRING_API);
    formField.setFluxnovaType(TEST_STRING_API);
    formField.setFluxnovaDatePattern(TEST_STRING_API);
    formField.setFluxnovaDefaultValue(TEST_STRING_API);
    assertThat(formField.getFluxnovaId()).isEqualTo(TEST_STRING_API);
    assertThat(formField.getFluxnovaLabel()).isEqualTo(TEST_STRING_API);
    assertThat(formField.getFluxnovaType()).isEqualTo(TEST_STRING_API);
    assertThat(formField.getFluxnovaDatePattern()).isEqualTo(TEST_STRING_API);
    assertThat(formField.getFluxnovaDefaultValue()).isEqualTo(TEST_STRING_API);

    FluxnovaProperty property = formField.getFluxnovaProperties().getFluxnovaProperties().iterator().next();
    assertThat(property.getFluxnovaId()).isEqualTo(TEST_STRING_XML);
    assertThat(property.getFluxnovaValue()).isEqualTo(TEST_STRING_XML);
    property.setFluxnovaId(TEST_STRING_API);
    property.setFluxnovaValue(TEST_STRING_API);
    assertThat(property.getFluxnovaId()).isEqualTo(TEST_STRING_API);
    assertThat(property.getFluxnovaValue()).isEqualTo(TEST_STRING_API);

    FluxnovaConstraint constraint = formField.getFluxnovaValidation().getFluxnovaConstraints().iterator().next();
    assertThat(constraint.getFluxnovaName()).isEqualTo(TEST_STRING_XML);
    assertThat(constraint.getFluxnovaConfig()).isEqualTo(TEST_STRING_XML);
    constraint.setFluxnovaName(TEST_STRING_API);
    constraint.setFluxnovaConfig(TEST_STRING_API);
    assertThat(constraint.getFluxnovaName()).isEqualTo(TEST_STRING_API);
    assertThat(constraint.getFluxnovaConfig()).isEqualTo(TEST_STRING_API);

    FluxnovaValue value = formField.getFluxnovaValues().iterator().next();
    assertThat(value.getFluxnovaId()).isEqualTo(TEST_STRING_XML);
    assertThat(value.getFluxnovaName()).isEqualTo(TEST_STRING_XML);
    value.setFluxnovaId(TEST_STRING_API);
    value.setFluxnovaName(TEST_STRING_API);
    assertThat(value.getFluxnovaId()).isEqualTo(TEST_STRING_API);
    assertThat(value.getFluxnovaName()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFormProperty(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaFormProperty formProperty = startEvent.getExtensionElements().getElementsQuery().filterByType(FluxnovaFormProperty.class).singleResult();
    assertThat(formProperty.getFluxnovaId()).isEqualTo(TEST_STRING_XML);
    assertThat(formProperty.getFluxnovaName()).isEqualTo(TEST_STRING_XML);
    assertThat(formProperty.getFluxnovaType()).isEqualTo(TEST_STRING_XML);
    assertThat(formProperty.isFluxnovaRequired()).isFalse();
    assertThat(formProperty.isFluxnovaReadable()).isTrue();
    assertThat(formProperty.isFluxnovaWriteable()).isTrue();
    assertThat(formProperty.getFluxnovaVariable()).isEqualTo(TEST_STRING_XML);
    assertThat(formProperty.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(formProperty.getFluxnovaDatePattern()).isEqualTo(TEST_STRING_XML);
    assertThat(formProperty.getFluxnovaDefault()).isEqualTo(TEST_STRING_XML);
    formProperty.setFluxnovaId(TEST_STRING_API);
    formProperty.setFluxnovaName(TEST_STRING_API);
    formProperty.setFluxnovaType(TEST_STRING_API);
    formProperty.setFluxnovaRequired(true);
    formProperty.setFluxnovaReadable(false);
    formProperty.setFluxnovaWriteable(false);
    formProperty.setFluxnovaVariable(TEST_STRING_API);
    formProperty.setFluxnovaExpression(TEST_EXPRESSION_API);
    formProperty.setFluxnovaDatePattern(TEST_STRING_API);
    formProperty.setFluxnovaDefault(TEST_STRING_API);
    assertThat(formProperty.getFluxnovaId()).isEqualTo(TEST_STRING_API);
    assertThat(formProperty.getFluxnovaName()).isEqualTo(TEST_STRING_API);
    assertThat(formProperty.getFluxnovaType()).isEqualTo(TEST_STRING_API);
    assertThat(formProperty.isFluxnovaRequired()).isTrue();
    assertThat(formProperty.isFluxnovaReadable()).isFalse();
    assertThat(formProperty.isFluxnovaWriteable()).isFalse();
    assertThat(formProperty.getFluxnovaVariable()).isEqualTo(TEST_STRING_API);
    assertThat(formProperty.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(formProperty.getFluxnovaDatePattern()).isEqualTo(TEST_STRING_API);
    assertThat(formProperty.getFluxnovaDefault()).isEqualTo(TEST_STRING_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testInExtension(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaIn in = callActivity.getExtensionElements().getElementsQuery().filterByType(FluxnovaIn.class).singleResult();
    assertThat(in.getFluxnovaSource()).isEqualTo(TEST_STRING_XML);
    assertThat(in.getFluxnovaSourceExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(in.getFluxnovaVariables()).isEqualTo(TEST_STRING_XML);
    assertThat(in.getFluxnovaTarget()).isEqualTo(TEST_STRING_XML);
    assertThat(in.getFluxnovaBusinessKey()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(in.getFluxnovaLocal()).isTrue();
    assertThat(in.getFluxnovaRestricted()).isFalse();
    in.setFluxnovaSource(TEST_STRING_API);
    in.setFluxnovaSourceExpression(TEST_EXPRESSION_API);
    in.setFluxnovaVariables(TEST_STRING_API);
    in.setFluxnovaTarget(TEST_STRING_API);
    in.setFluxnovaBusinessKey(TEST_EXPRESSION_API);
    in.setFluxnovaLocal(false);
    in.setFluxnovaRestricted(true);
    assertThat(in.getFluxnovaSource()).isEqualTo(TEST_STRING_API);
    assertThat(in.getFluxnovaSourceExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(in.getFluxnovaVariables()).isEqualTo(TEST_STRING_API);
    assertThat(in.getFluxnovaTarget()).isEqualTo(TEST_STRING_API);
    assertThat(in.getFluxnovaBusinessKey()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(in.getFluxnovaLocal()).isFalse();
    assertThat(in.getFluxnovaRestricted()).isTrue();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testOutExtension(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaOut out = callActivity.getExtensionElements().getElementsQuery().filterByType(FluxnovaOut.class).singleResult();
    assertThat(out.getFluxnovaSource()).isEqualTo(TEST_STRING_XML);
    assertThat(out.getFluxnovaSourceExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(out.getFluxnovaVariables()).isEqualTo(TEST_STRING_XML);
    assertThat(out.getFluxnovaTarget()).isEqualTo(TEST_STRING_XML);
    assertThat(out.getFluxnovaLocal()).isTrue();
    assertThat(out.getFluxnovaRestricted()).isFalse();
    out.setFluxnovaSource(TEST_STRING_API);
    out.setFluxnovaSourceExpression(TEST_EXPRESSION_API);
    out.setFluxnovaVariables(TEST_STRING_API);
    out.setFluxnovaTarget(TEST_STRING_API);
    out.setFluxnovaLocal(false);
    out.setFluxnovaRestricted(true);
    assertThat(out.getFluxnovaSource()).isEqualTo(TEST_STRING_API);
    assertThat(out.getFluxnovaSourceExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(out.getFluxnovaVariables()).isEqualTo(TEST_STRING_API);
    assertThat(out.getFluxnovaTarget()).isEqualTo(TEST_STRING_API);
    assertThat(out.getFluxnovaLocal()).isFalse();
    assertThat(out.getFluxnovaRestricted()).isTrue();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testPotentialStarter(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaPotentialStarter potentialStarter = startEvent.getExtensionElements().getElementsQuery().filterByType(FluxnovaPotentialStarter.class).singleResult();
    Expression expression = potentialStarter.getResourceAssignmentExpression().getExpression();
    assertThat(expression.getTextContent()).isEqualTo(TEST_GROUPS_XML);
    expression.setTextContent(TEST_GROUPS_API);
    assertThat(expression.getTextContent()).isEqualTo(TEST_GROUPS_API);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testTaskListener(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaTaskListener taskListener = userTask.getExtensionElements().getElementsQuery().filterByType(FluxnovaTaskListener.class).list().get(0);
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo(TEST_TASK_EVENT_XML);
    assertThat(taskListener.getFluxnovaClass()).isEqualTo(TEST_CLASS_XML);
    assertThat(taskListener.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(taskListener.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_XML);
    taskListener.setFluxnovaEvent(TEST_TASK_EVENT_API);
    taskListener.setFluxnovaClass(TEST_CLASS_API);
    taskListener.setFluxnovaExpression(TEST_EXPRESSION_API);
    taskListener.setFluxnovaDelegateExpression(TEST_DELEGATE_EXPRESSION_API);
    assertThat(taskListener.getFluxnovaEvent()).isEqualTo(TEST_TASK_EVENT_API);
    assertThat(taskListener.getFluxnovaClass()).isEqualTo(TEST_CLASS_API);
    assertThat(taskListener.getFluxnovaExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(taskListener.getFluxnovaDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);

    FluxnovaField field = taskListener.getFluxnovaFields().iterator().next();
    assertThat(field.getFluxnovaName()).isEqualTo(TEST_STRING_XML);
    assertThat(field.getFluxnovaString().getTextContent()).isEqualTo(TEST_STRING_XML);

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNotNull();
    assertThat(timeout.getTimeDuration().getRawTextContent()).isEqualTo("PT1H");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaScriptTaskListener(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaTaskListener taskListener = userTask.getExtensionElements().getElementsQuery().filterByType(FluxnovaTaskListener.class).list().get(1);

    FluxnovaScript script = taskListener.getFluxnovaScript();
    assertThat(script.getFluxnovaScriptFormat()).isEqualTo("groovy");
    assertThat(script.getFluxnovaResource()).isEqualTo("test.groovy");
    assertThat(script.getTextContent()).isEmpty();

    FluxnovaScript newScript = this.modelInstance.newInstance(FluxnovaScript.class);
    newScript.setFluxnovaScriptFormat("groovy");
    newScript.setTextContent("println 'Hello World'");
    taskListener.setFluxnovaScript(newScript);

    script = taskListener.getFluxnovaScript();
    assertThat(script.getFluxnovaScriptFormat()).isEqualTo("groovy");
    assertThat(script.getFluxnovaResource()).isNull();
    assertThat(script.getTextContent()).isEqualTo("println 'Hello World'");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaModelerProperties(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaProperties camundaProperties = endEvent.getExtensionElements().getElementsQuery().filterByType(FluxnovaProperties.class).singleResult();
    assertThat(camundaProperties).isNotNull();
    assertThat(camundaProperties.getFluxnovaProperties()).hasSize(2);

    for (FluxnovaProperty camundaProperty : camundaProperties.getFluxnovaProperties()) {
      assertThat(camundaProperty.getFluxnovaId()).isNull();
      assertThat(camundaProperty.getFluxnovaName()).startsWith("name");
      assertThat(camundaProperty.getFluxnovaValue()).startsWith("value");
    }
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testGetNonExistingFluxnovaCandidateUsers(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    userTask.removeAttributeNs(namespace, "candidateUsers");
    assertThat(userTask.getFluxnovaCandidateUsers()).isNull();
    assertThat(userTask.getFluxnovaCandidateUsersList()).isEmpty();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testSetNullFluxnovaCandidateUsers(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(userTask.getFluxnovaCandidateUsers()).isNotEmpty();
    assertThat(userTask.getFluxnovaCandidateUsersList()).isNotEmpty();
    userTask.setFluxnovaCandidateUsers(null);
    assertThat(userTask.getFluxnovaCandidateUsers()).isNull();
    assertThat(userTask.getFluxnovaCandidateUsersList()).isEmpty();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testEmptyFluxnovaCandidateUsers(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(userTask.getFluxnovaCandidateUsers()).isNotEmpty();
    assertThat(userTask.getFluxnovaCandidateUsersList()).isNotEmpty();
    userTask.setFluxnovaCandidateUsers("");
    assertThat(userTask.getFluxnovaCandidateUsers()).isNull();
    assertThat(userTask.getFluxnovaCandidateUsersList()).isEmpty();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testSetNullFluxnovaCandidateUsersList(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(userTask.getFluxnovaCandidateUsers()).isNotEmpty();
    assertThat(userTask.getFluxnovaCandidateUsersList()).isNotEmpty();
    userTask.setFluxnovaCandidateUsersList(null);
    assertThat(userTask.getFluxnovaCandidateUsers()).isNull();
    assertThat(userTask.getFluxnovaCandidateUsersList()).isEmpty();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testEmptyFluxnovaCandidateUsersList(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(userTask.getFluxnovaCandidateUsers()).isNotEmpty();
    assertThat(userTask.getFluxnovaCandidateUsersList()).isNotEmpty();
    userTask.setFluxnovaCandidateUsersList(Collections.<String>emptyList());
    assertThat(userTask.getFluxnovaCandidateUsers()).isNull();
    assertThat(userTask.getFluxnovaCandidateUsersList()).isEmpty();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testScriptResource(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    assertThat(scriptTask.getScriptFormat()).isEqualTo("groovy");
    assertThat(scriptTask.getFluxnovaResource()).isEqualTo("test.groovy");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaConnector(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaConnector camundaConnector = serviceTask.getExtensionElements().getElementsQuery().filterByType(FluxnovaConnector.class).singleResult();
    assertThat(camundaConnector).isNotNull();

    FluxnovaConnectorId camundaConnectorId = camundaConnector.getFluxnovaConnectorId();
    assertThat(camundaConnectorId).isNotNull();
    assertThat(camundaConnectorId.getTextContent()).isEqualTo("soap-http-connector");

    FluxnovaInputOutput camundaInputOutput = camundaConnector.getFluxnovaInputOutput();

    Collection<FluxnovaInputParameter> inputParameters = camundaInputOutput.getFluxnovaInputParameters();
    assertThat(inputParameters).hasSize(1);

    FluxnovaInputParameter inputParameter = inputParameters.iterator().next();
    assertThat(inputParameter.getFluxnovaName()).isEqualTo("endpointUrl");
    assertThat(inputParameter.getTextContent()).isEqualTo("http://example.com/webservice");
    assertThat(inputParameter.getFluxnovaRestricted()).isFalse();
    inputParameter.setFluxnovaRestricted(true);
    assertThat(inputParameter.getFluxnovaRestricted()).isTrue();

    Collection<FluxnovaOutputParameter> outputParameters = camundaInputOutput.getFluxnovaOutputParameters();
    assertThat(outputParameters).hasSize(1);

    FluxnovaOutputParameter outputParameter = outputParameters.iterator().next();
    assertThat(outputParameter.getFluxnovaName()).isEqualTo("result");
    assertThat(outputParameter.getTextContent()).isEqualTo("output");
    assertThat(outputParameter.getFluxnovaRestricted()).isFalse();
    outputParameter.setFluxnovaRestricted(true);
    assertThat(outputParameter.getFluxnovaRestricted()).isTrue();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaInputOutput(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaInputOutput camundaInputOutput = serviceTask.getExtensionElements().getElementsQuery().filterByType(FluxnovaInputOutput.class).singleResult();
    assertThat(camundaInputOutput).isNotNull();
    assertThat(camundaInputOutput.getFluxnovaInputParameters()).hasSize(6);
    assertThat(camundaInputOutput.getFluxnovaOutputParameters()).hasSize(1);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaInputParameter(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    // find existing
    FluxnovaInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeConstant");

    // modify existing
    inputParameter.setFluxnovaName("hello");
    inputParameter.setTextContent("world");
    inputParameter.setFluxnovaRestricted(true);
    inputParameter = findInputParameterByName(serviceTask, "hello");
    assertThat(inputParameter.getTextContent()).isEqualTo("world");
    assertThat(inputParameter.getFluxnovaRestricted()).isTrue();

    // add new one
    inputParameter = this.modelInstance.newInstance(FluxnovaInputParameter.class);
    inputParameter.setFluxnovaName("abc");
    inputParameter.setTextContent("def");
    serviceTask.getExtensionElements().getElementsQuery().filterByType(FluxnovaInputOutput.class).singleResult()
      .addChildElement(inputParameter);

    // search for new one
    inputParameter = findInputParameterByName(serviceTask, "abc");
    assertThat(inputParameter.getFluxnovaName()).isEqualTo("abc");
    assertThat(inputParameter.getTextContent()).isEqualTo("def");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaNullInputParameter(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeNull");
    assertThat(inputParameter.getFluxnovaName()).isEqualTo("shouldBeNull");
    assertThat(inputParameter.getTextContent()).isEmpty();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaConstantInputParameter(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeConstant");
    assertThat(inputParameter.getFluxnovaName()).isEqualTo("shouldBeConstant");
    assertThat(inputParameter.getTextContent()).isEqualTo("foo");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaExpressionInputParameter(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeExpression");
    assertThat(inputParameter.getFluxnovaName()).isEqualTo("shouldBeExpression");
    assertThat(inputParameter.getTextContent()).isEqualTo("${1 + 1}");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaListInputParameter(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeList");
    assertThat(inputParameter.getFluxnovaName()).isEqualTo("shouldBeList");
    assertThat(inputParameter.getTextContent()).isNotEmpty();
    assertThat(inputParameter.getUniqueChildElementByNameNs(CAMUNDA_NS, "list")).isNotNull();

    FluxnovaList list = inputParameter.getValue();
    assertThat(list.getValues()).hasSize(3);
    for (BpmnModelElementInstance values : list.getValues()) {
      assertThat(values.getTextContent()).isIn("a", "b", "c");
    }

    list = this.modelInstance.newInstance(FluxnovaList.class);
    for (int i = 0; i < 4; i++) {
      FluxnovaValue value = this.modelInstance.newInstance(FluxnovaValue.class);
      value.setTextContent("test");
      list.getValues().add(value);
    }
    Collection<FluxnovaValue> testValues = Arrays.asList(this.modelInstance.newInstance(FluxnovaValue.class), this.modelInstance.newInstance(FluxnovaValue.class));
    list.getValues().addAll(testValues);
    inputParameter.setValue(list);

    list = inputParameter.getValue();
    assertThat(list.getValues()).hasSize(6);
    list.getValues().removeAll(testValues);
    ArrayList<BpmnModelElementInstance> camundaValues = new ArrayList<BpmnModelElementInstance>(list.getValues());
    assertThat(camundaValues).hasSize(4);
    for (BpmnModelElementInstance value : camundaValues) {
      assertThat(value.getTextContent()).isEqualTo("test");
    }

    list.getValues().remove(camundaValues.get(1));
    assertThat(list.getValues()).hasSize(3);

    list.getValues().removeAll(Arrays.asList(camundaValues.get(0), camundaValues.get(3)));
    assertThat(list.getValues()).hasSize(1);

    list.getValues().clear();
    assertThat(list.getValues()).isEmpty();

    // test standard list interactions
    Collection<BpmnModelElementInstance> elements = list.getValues();

    FluxnovaValue value = this.modelInstance.newInstance(FluxnovaValue.class);
    elements.add(value);

    List<FluxnovaValue> newValues = new ArrayList<FluxnovaValue>();
    newValues.add(this.modelInstance.newInstance(FluxnovaValue.class));
    newValues.add(this.modelInstance.newInstance(FluxnovaValue.class));
    elements.addAll(newValues);
    assertThat(elements).hasSize(3);

    assertThat(elements).doesNotContain(this.modelInstance.newInstance(FluxnovaValue.class));
    assertThat(elements.containsAll(Arrays.asList(this.modelInstance.newInstance(FluxnovaValue.class)))).isFalse();

    assertThat(elements.remove(this.modelInstance.newInstance(FluxnovaValue.class))).isFalse();
    assertThat(elements).hasSize(3);

    assertThat(elements.remove(value)).isTrue();
    assertThat(elements).hasSize(2);

    assertThat(elements.removeAll(newValues)).isTrue();
    assertThat(elements).isEmpty();

    elements.add(this.modelInstance.newInstance(FluxnovaValue.class));
    elements.clear();
    assertThat(elements).isEmpty();

    inputParameter.removeValue();
    assertThat((Object) inputParameter.getValue()).isNull();

  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaMapInputParameter(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeMap");
    assertThat(inputParameter.getFluxnovaName()).isEqualTo("shouldBeMap");
    assertThat(inputParameter.getTextContent()).isNotEmpty();
    assertThat(inputParameter.getUniqueChildElementByNameNs(CAMUNDA_NS, "map")).isNotNull();

    FluxnovaMap map = inputParameter.getValue();
    assertThat(map.getFluxnovaEntries()).hasSize(2);
    for (FluxnovaEntry entry : map.getFluxnovaEntries()) {
      if (entry.getFluxnovaKey().equals("foo")) {
        assertThat(entry.getTextContent()).isEqualTo("bar");
      }
      else {
        assertThat(entry.getFluxnovaKey()).isEqualTo("hello");
        assertThat(entry.getTextContent()).isEqualTo("world");
      }
    }

    map = this.modelInstance.newInstance(FluxnovaMap.class);
    FluxnovaEntry entry = this.modelInstance.newInstance(FluxnovaEntry.class);
    entry.setFluxnovaKey("test");
    entry.setTextContent("value");
    map.getFluxnovaEntries().add(entry);

    inputParameter.setValue(map);
    map = inputParameter.getValue();
    assertThat(map.getFluxnovaEntries()).hasSize(1);
    entry = map.getFluxnovaEntries().iterator().next();
    assertThat(entry.getFluxnovaKey()).isEqualTo("test");
    assertThat(entry.getTextContent()).isEqualTo("value");

    Collection<FluxnovaEntry> entries = map.getFluxnovaEntries();
    entries.add(this.modelInstance.newInstance(FluxnovaEntry.class));
    assertThat(entries).hasSize(2);

    inputParameter.removeValue();
    assertThat((Object) inputParameter.getValue()).isNull();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaScriptInputParameter(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeScript");
    assertThat(inputParameter.getFluxnovaName()).isEqualTo("shouldBeScript");
    assertThat(inputParameter.getTextContent()).isNotEmpty();
    assertThat(inputParameter.getUniqueChildElementByNameNs(CAMUNDA_NS, "script")).isNotNull();
    assertThat(inputParameter.getUniqueChildElementByType(FluxnovaScript.class)).isNotNull();

    FluxnovaScript script = inputParameter.getValue();
    assertThat(script.getFluxnovaScriptFormat()).isEqualTo("groovy");
    assertThat(script.getFluxnovaResource()).isNull();
    assertThat(script.getTextContent()).isEqualTo("1 + 1");

    script = this.modelInstance.newInstance(FluxnovaScript.class);
    script.setFluxnovaScriptFormat("python");
    script.setFluxnovaResource("script.py");

    inputParameter.setValue(script);

    script = inputParameter.getValue();
    assertThat(script.getFluxnovaScriptFormat()).isEqualTo("python");
    assertThat(script.getFluxnovaResource()).isEqualTo("script.py");
    assertThat(script.getTextContent()).isEmpty();

    inputParameter.removeValue();
    assertThat((Object) inputParameter.getValue()).isNull();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaNestedOutputParameter(String namespace, BpmnModelInstance modelInstance) {
    initFluxnovaExtensionsTest(namespace, modelInstance);
    FluxnovaOutputParameter camundaOutputParameter = serviceTask.getExtensionElements().getElementsQuery().filterByType(FluxnovaInputOutput.class).singleResult().getFluxnovaOutputParameters().iterator().next();

    assertThat(camundaOutputParameter).isNotNull();
    assertThat(camundaOutputParameter.getFluxnovaName()).isEqualTo("nested");
    FluxnovaList list = camundaOutputParameter.getValue();
    assertThat(list).isNotNull();
    assertThat(list.getValues()).hasSize(2);
    Iterator<BpmnModelElementInstance> iterator = list.getValues().iterator();

    // nested list
    FluxnovaList nestedList = (FluxnovaList) iterator.next().getUniqueChildElementByType(FluxnovaList.class);
    assertThat(nestedList).isNotNull();
    assertThat(nestedList.getValues()).hasSize(2);
    for (BpmnModelElementInstance value : nestedList.getValues()) {
      assertThat(value.getTextContent()).isEqualTo("list");
    }

    // nested map
    FluxnovaMap nestedMap = (FluxnovaMap) iterator.next().getUniqueChildElementByType(FluxnovaMap.class);
    assertThat(nestedMap).isNotNull();
    assertThat(nestedMap.getFluxnovaEntries()).hasSize(2);
    Iterator<FluxnovaEntry> mapIterator = nestedMap.getFluxnovaEntries().iterator();

    // nested list in nested map
    FluxnovaEntry nestedListEntry = mapIterator.next();
    assertThat(nestedListEntry).isNotNull();
    assertThat(nestedListEntry.getFluxnovaKey()).isEqualTo("list");
    FluxnovaList nestedNestedList = nestedListEntry.getValue();
    for (BpmnModelElementInstance value : nestedNestedList.getValues()) {
      assertThat(value.getTextContent()).isEqualTo("map");
    }

    // nested map in nested map
    FluxnovaEntry nestedMapEntry = mapIterator.next();
    assertThat(nestedMapEntry).isNotNull();
    assertThat(nestedMapEntry.getFluxnovaKey()).isEqualTo("map");
    FluxnovaMap nestedNestedMap = nestedMapEntry.getValue();
    FluxnovaEntry entry = nestedNestedMap.getFluxnovaEntries().iterator().next();
    assertThat(entry.getFluxnovaKey()).isEqualTo("so");
    assertThat(entry.getTextContent()).isEqualTo("nested");
  }

  protected FluxnovaInputParameter findInputParameterByName(BaseElement baseElement, String name) {
    Collection<FluxnovaInputParameter> camundaInputParameters = baseElement.getExtensionElements().getElementsQuery()
      .filterByType(FluxnovaInputOutput.class).singleResult().getFluxnovaInputParameters();
    for (FluxnovaInputParameter camundaInputParameter : camundaInputParameters) {
      if (camundaInputParameter.getFluxnovaName().equals(name)) {
        return camundaInputParameter;
      }
    }
    throw new BpmnModelException("Unable to find camunda:inputParameter with name '" + name + "' for element with id '" + baseElement.getId() + "'");
  }

  @AfterEach
  public void validateModel() {
    Bpmn.validateModel(modelInstance);
  }
}
