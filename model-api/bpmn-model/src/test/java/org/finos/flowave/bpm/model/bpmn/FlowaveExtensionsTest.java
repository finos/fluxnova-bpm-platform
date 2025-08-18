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
package org.finos.flowave.bpm.model.bpmn;

import static org.assertj.core.api.Assertions.assertThat;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.BUSINESS_RULE_TASK;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.CALL_ACTIVITY_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.END_EVENT_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.PROCESS_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.SCRIPT_TASK_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.SEND_TASK_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.SEQUENCE_FLOW_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.SERVICE_TASK_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.START_EVENT_ID;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_CLASS_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_CLASS_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_DELEGATE_EXPRESSION_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_DELEGATE_EXPRESSION_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_DUE_DATE_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_DUE_DATE_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_EXECUTION_EVENT_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_EXECUTION_EVENT_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_EXPRESSION_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_EXPRESSION_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_FLOW_NODE_JOB_PRIORITY;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_LIST_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_LIST_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_GROUPS_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_HISTORY_TIME_TO_LIVE;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_PRIORITY_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_PRIORITY_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_PROCESS_JOB_PRIORITY;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_PROCESS_TASK_PRIORITY;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_SERVICE_TASK_PRIORITY;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_STRING_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_STRING_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_TASK_EVENT_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_TASK_EVENT_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_TYPE_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_TYPE_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_LIST_API;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_LIST_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.TEST_USERS_XML;
import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.USER_TASK_ID;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.ACTIVITI_NS;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_ERROR_CODE_VARIABLE;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_ERROR_MESSAGE_VARIABLE;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.finos.flowave.bpm.model.bpmn.instance.BaseElement;
import org.finos.flowave.bpm.model.bpmn.instance.BpmnModelElementInstance;
import org.finos.flowave.bpm.model.bpmn.instance.BusinessRuleTask;
import org.finos.flowave.bpm.model.bpmn.instance.CallActivity;
import org.finos.flowave.bpm.model.bpmn.instance.EndEvent;
import org.finos.flowave.bpm.model.bpmn.instance.Error;
import org.finos.flowave.bpm.model.bpmn.instance.ErrorEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.Expression;
import org.finos.flowave.bpm.model.bpmn.instance.MessageEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.ParallelGateway;
import org.finos.flowave.bpm.model.bpmn.instance.Process;
import org.finos.flowave.bpm.model.bpmn.instance.ScriptTask;
import org.finos.flowave.bpm.model.bpmn.instance.SendTask;
import org.finos.flowave.bpm.model.bpmn.instance.SequenceFlow;
import org.finos.flowave.bpm.model.bpmn.instance.ServiceTask;
import org.finos.flowave.bpm.model.bpmn.instance.StartEvent;
import org.finos.flowave.bpm.model.bpmn.instance.TimerEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.UserTask;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveConnector;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveConnectorId;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveConstraint;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveEntry;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveExecutionListener;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFailedJobRetryTimeCycle;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveField;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormData;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormField;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormProperty;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveIn;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveInputOutput;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveInputParameter;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveList;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveMap;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveOut;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveOutputParameter;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowavePotentialStarter;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveProperties;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveProperty;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveScript;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveTaskListener;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveValue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * @author Sebastian Menski
 * @author Ronny Bräunlich
 */
@RunWith(Parameterized.class)
public class FlowaveExtensionsTest {

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

  @Parameters(name="Namespace: {0}")
  public static Collection<Object[]> parameters(){
    return Arrays.asList(new Object[][]{
        {CAMUNDA_NS, Bpmn.readModelFromStream(FlowaveExtensionsTest.class.getResourceAsStream("CamundaExtensionsTest.xml"))},
        //for compatability reasons we gotta check the old namespace, too
        {ACTIVITI_NS, Bpmn.readModelFromStream(FlowaveExtensionsTest.class.getResourceAsStream("CamundaExtensionsCompatabilityTest.xml"))}
    });
  }

  public FlowaveExtensionsTest(String namespace, BpmnModelInstance modelInstance) {
    this.namespace = namespace;
    this.originalModelInstance = modelInstance;
  }

  @Before
  public void setUp(){
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

  @Test
  public void testAssignee() {
    assertThat(userTask.getFlowaveAssignee()).isEqualTo(TEST_STRING_XML);
    userTask.setFlowaveAssignee(TEST_STRING_API);
    assertThat(userTask.getFlowaveAssignee()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testAsync() {
    assertThat(startEvent.isFlowaveAsync()).isFalse();
    assertThat(userTask.isFlowaveAsync()).isTrue();
    assertThat(parallelGateway.isFlowaveAsync()).isTrue();

    startEvent.setFlowaveAsync(true);
    userTask.setFlowaveAsync(false);
    parallelGateway.setFlowaveAsync(false);

    assertThat(startEvent.isFlowaveAsync()).isTrue();
    assertThat(userTask.isFlowaveAsync()).isFalse();
    assertThat(parallelGateway.isFlowaveAsync()).isFalse();
  }

  @Test
  public void testAsyncBefore() {
    assertThat(startEvent.isFlowaveAsyncBefore()).isTrue();
    assertThat(endEvent.isFlowaveAsyncBefore()).isTrue();
    assertThat(userTask.isFlowaveAsyncBefore()).isTrue();
    assertThat(parallelGateway.isFlowaveAsyncBefore()).isTrue();

    startEvent.setFlowaveAsyncBefore(false);
    endEvent.setFlowaveAsyncBefore(false);
    userTask.setFlowaveAsyncBefore(false);
    parallelGateway.setFlowaveAsyncBefore(false);

    assertThat(startEvent.isFlowaveAsyncBefore()).isFalse();
    assertThat(endEvent.isFlowaveAsyncBefore()).isFalse();
    assertThat(userTask.isFlowaveAsyncBefore()).isFalse();
    assertThat(parallelGateway.isFlowaveAsyncBefore()).isFalse();
  }

  @Test
  public void testAsyncAfter() {
    assertThat(startEvent.isFlowaveAsyncAfter()).isTrue();
    assertThat(endEvent.isFlowaveAsyncAfter()).isTrue();
    assertThat(userTask.isFlowaveAsyncAfter()).isTrue();
    assertThat(parallelGateway.isFlowaveAsyncAfter()).isTrue();

    startEvent.setFlowaveAsyncAfter(false);
    endEvent.setFlowaveAsyncAfter(false);
    userTask.setFlowaveAsyncAfter(false);
    parallelGateway.setFlowaveAsyncAfter(false);

    assertThat(startEvent.isFlowaveAsyncAfter()).isFalse();
    assertThat(endEvent.isFlowaveAsyncAfter()).isFalse();
    assertThat(userTask.isFlowaveAsyncAfter()).isFalse();
    assertThat(parallelGateway.isFlowaveAsyncAfter()).isFalse();
  }

  @Test
  public void testFlowNodeJobPriority() {
    assertThat(startEvent.getFlowaveJobPriority()).isEqualTo(TEST_FLOW_NODE_JOB_PRIORITY);
    assertThat(endEvent.getFlowaveJobPriority()).isEqualTo(TEST_FLOW_NODE_JOB_PRIORITY);
    assertThat(userTask.getFlowaveJobPriority()).isEqualTo(TEST_FLOW_NODE_JOB_PRIORITY);
    assertThat(parallelGateway.getFlowaveJobPriority()).isEqualTo(TEST_FLOW_NODE_JOB_PRIORITY);
  }

  @Test
  public void testProcessJobPriority() {
    assertThat(process.getFlowaveJobPriority()).isEqualTo(TEST_PROCESS_JOB_PRIORITY);
  }

  @Test
  public void testProcessTaskPriority() {
    assertThat(process.getFlowaveTaskPriority()).isEqualTo(TEST_PROCESS_TASK_PRIORITY);
  }

  @Test
  public void testHistoryTimeToLive() {
    assertThat(process.getFlowaveHistoryTimeToLive()).isEqualTo(TEST_HISTORY_TIME_TO_LIVE);
  }

  @Test
  public void testIsStartableInTasklist() {
    assertThat(process.isFlowaveStartableInTasklist()).isEqualTo(false);
  }

  @Test
  public void testVersionTag() {
    assertThat(process.getFlowaveVersionTag()).isEqualTo("v1.0.0");
  }

  @Test
  public void testServiceTaskPriority() {
    assertThat(serviceTask.getFlowaveTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);
  }

  @Test
  public void testCalledElementBinding() {
    assertThat(callActivity.getFlowaveCalledElementBinding()).isEqualTo(TEST_STRING_XML);
    callActivity.setFlowaveCalledElementBinding(TEST_STRING_API);
    assertThat(callActivity.getFlowaveCalledElementBinding()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testCalledElementVersion() {
    assertThat(callActivity.getFlowaveCalledElementVersion()).isEqualTo(TEST_STRING_XML);
    callActivity.setFlowaveCalledElementVersion(TEST_STRING_API);
    assertThat(callActivity.getFlowaveCalledElementVersion()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testCalledElementVersionTag() {
    assertThat(callActivity.getFlowaveCalledElementVersionTag()).isEqualTo(TEST_STRING_XML);
    callActivity.setFlowaveCalledElementVersionTag(TEST_STRING_API);
    assertThat(callActivity.getFlowaveCalledElementVersionTag()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testCalledElementTenantId() {
    assertThat(callActivity.getFlowaveCalledElementTenantId()).isEqualTo(TEST_STRING_XML);
    callActivity.setFlowaveCalledElementTenantId(TEST_STRING_API);
    assertThat(callActivity.getFlowaveCalledElementTenantId()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testCaseRef() {
    assertThat(callActivity.getFlowaveCaseRef()).isEqualTo(TEST_STRING_XML);
    callActivity.setFlowaveCaseRef(TEST_STRING_API);
    assertThat(callActivity.getFlowaveCaseRef()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testCaseBinding() {
    assertThat(callActivity.getFlowaveCaseBinding()).isEqualTo(TEST_STRING_XML);
    callActivity.setFlowaveCaseBinding(TEST_STRING_API);
    assertThat(callActivity.getFlowaveCaseBinding()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testCaseVersion() {
    assertThat(callActivity.getFlowaveCaseVersion()).isEqualTo(TEST_STRING_XML);
    callActivity.setFlowaveCaseVersion(TEST_STRING_API);
    assertThat(callActivity.getFlowaveCaseVersion()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testCaseTenantId() {
    assertThat(callActivity.getFlowaveCaseTenantId()).isEqualTo(TEST_STRING_XML);
    callActivity.setFlowaveCaseTenantId(TEST_STRING_API);
    assertThat(callActivity.getFlowaveCaseTenantId()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testDecisionRef() {
    assertThat(businessRuleTask.getFlowaveDecisionRef()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFlowaveDecisionRef(TEST_STRING_API);
    assertThat(businessRuleTask.getFlowaveDecisionRef()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testDecisionRefBinding() {
    assertThat(businessRuleTask.getFlowaveDecisionRefBinding()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFlowaveDecisionRefBinding(TEST_STRING_API);
    assertThat(businessRuleTask.getFlowaveDecisionRefBinding()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testDecisionRefVersion() {
    assertThat(businessRuleTask.getFlowaveDecisionRefVersion()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFlowaveDecisionRefVersion(TEST_STRING_API);
    assertThat(businessRuleTask.getFlowaveDecisionRefVersion()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testDecisionRefVersionTag() {
    assertThat(businessRuleTask.getFlowaveDecisionRefVersionTag()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFlowaveDecisionRefVersionTag(TEST_STRING_API);
    assertThat(businessRuleTask.getFlowaveDecisionRefVersionTag()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testDecisionRefTenantId() {
    assertThat(businessRuleTask.getFlowaveDecisionRefTenantId()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFlowaveDecisionRefTenantId(TEST_STRING_API);
    assertThat(businessRuleTask.getFlowaveDecisionRefTenantId()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testMapDecisionResult() {
    assertThat(businessRuleTask.getFlowaveMapDecisionResult()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFlowaveMapDecisionResult(TEST_STRING_API);
    assertThat(businessRuleTask.getFlowaveMapDecisionResult()).isEqualTo(TEST_STRING_API);
  }


  @Test
  public void testTaskPriority() {
    assertThat(businessRuleTask.getFlowaveTaskPriority()).isEqualTo(TEST_STRING_XML);
    businessRuleTask.setFlowaveTaskPriority(TEST_SERVICE_TASK_PRIORITY);
    assertThat(businessRuleTask.getFlowaveTaskPriority()).isEqualTo(TEST_SERVICE_TASK_PRIORITY);
  }

  @Test
  public void testCandidateGroups() {
    assertThat(userTask.getFlowaveCandidateGroups()).isEqualTo(TEST_GROUPS_XML);
    assertThat(userTask.getFlowaveCandidateGroupsList()).containsAll(TEST_GROUPS_LIST_XML);
    userTask.setFlowaveCandidateGroups(TEST_GROUPS_API);
    assertThat(userTask.getFlowaveCandidateGroups()).isEqualTo(TEST_GROUPS_API);
    assertThat(userTask.getFlowaveCandidateGroupsList()).containsAll(TEST_GROUPS_LIST_API);
    userTask.setFlowaveCandidateGroupsList(TEST_GROUPS_LIST_XML);
    assertThat(userTask.getFlowaveCandidateGroups()).isEqualTo(TEST_GROUPS_XML);
    assertThat(userTask.getFlowaveCandidateGroupsList()).containsAll(TEST_GROUPS_LIST_XML);
  }

  @Test
  public void testCandidateStarterGroups() {
    assertThat(process.getFlowaveCandidateStarterGroups()).isEqualTo(TEST_GROUPS_XML);
    assertThat(process.getFlowaveCandidateStarterGroupsList()).containsAll(TEST_GROUPS_LIST_XML);
    process.setFlowaveCandidateStarterGroups(TEST_GROUPS_API);
    assertThat(process.getFlowaveCandidateStarterGroups()).isEqualTo(TEST_GROUPS_API);
    assertThat(process.getFlowaveCandidateStarterGroupsList()).containsAll(TEST_GROUPS_LIST_API);
    process.setFlowaveCandidateStarterGroupsList(TEST_GROUPS_LIST_XML);
    assertThat(process.getFlowaveCandidateStarterGroups()).isEqualTo(TEST_GROUPS_XML);
    assertThat(process.getFlowaveCandidateStarterGroupsList()).containsAll(TEST_GROUPS_LIST_XML);
  }

  @Test
  public void testCandidateStarterUsers() {
    assertThat(process.getFlowaveCandidateStarterUsers()).isEqualTo(TEST_USERS_XML);
    assertThat(process.getFlowaveCandidateStarterUsersList()).containsAll(TEST_USERS_LIST_XML);
    process.setFlowaveCandidateStarterUsers(TEST_USERS_API);
    assertThat(process.getFlowaveCandidateStarterUsers()).isEqualTo(TEST_USERS_API);
    assertThat(process.getFlowaveCandidateStarterUsersList()).containsAll(TEST_USERS_LIST_API);
    process.setFlowaveCandidateStarterUsersList(TEST_USERS_LIST_XML);
    assertThat(process.getFlowaveCandidateStarterUsers()).isEqualTo(TEST_USERS_XML);
    assertThat(process.getFlowaveCandidateStarterUsersList()).containsAll(TEST_USERS_LIST_XML);
  }

  @Test
  public void testCandidateUsers() {
    assertThat(userTask.getFlowaveCandidateUsers()).isEqualTo(TEST_USERS_XML);
    assertThat(userTask.getFlowaveCandidateUsersList()).containsAll(TEST_USERS_LIST_XML);
    userTask.setFlowaveCandidateUsers(TEST_USERS_API);
    assertThat(userTask.getFlowaveCandidateUsers()).isEqualTo(TEST_USERS_API);
    assertThat(userTask.getFlowaveCandidateUsersList()).containsAll(TEST_USERS_LIST_API);
    userTask.setFlowaveCandidateUsersList(TEST_USERS_LIST_XML);
    assertThat(userTask.getFlowaveCandidateUsers()).isEqualTo(TEST_USERS_XML);
    assertThat(userTask.getFlowaveCandidateUsersList()).containsAll(TEST_USERS_LIST_XML);
  }

  @Test
  public void testClass() {
    assertThat(serviceTask.getFlowaveClass()).isEqualTo(TEST_CLASS_XML);
    assertThat(messageEventDefinition.getFlowaveClass()).isEqualTo(TEST_CLASS_XML);

    serviceTask.setFlowaveClass(TEST_CLASS_API);
    messageEventDefinition.setFlowaveClass(TEST_CLASS_API);

    assertThat(serviceTask.getFlowaveClass()).isEqualTo(TEST_CLASS_API);
    assertThat(messageEventDefinition.getFlowaveClass()).isEqualTo(TEST_CLASS_API);
  }

  @Test
  public void testDelegateExpression() {
    assertThat(serviceTask.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_XML);
    assertThat(messageEventDefinition.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_XML);

    serviceTask.setFlowaveDelegateExpression(TEST_DELEGATE_EXPRESSION_API);
    messageEventDefinition.setFlowaveDelegateExpression(TEST_DELEGATE_EXPRESSION_API);

    assertThat(serviceTask.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertThat(messageEventDefinition.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
  }

  @Test
  public void testDueDate() {
    assertThat(userTask.getFlowaveDueDate()).isEqualTo(TEST_DUE_DATE_XML);
    userTask.setFlowaveDueDate(TEST_DUE_DATE_API);
    assertThat(userTask.getFlowaveDueDate()).isEqualTo(TEST_DUE_DATE_API);
  }

  @Test
  public void testErrorCodeVariable(){
    ErrorEventDefinition errorEventDefinition = startEvent.getChildElementsByType(ErrorEventDefinition.class).iterator().next();
    assertThat(errorEventDefinition.getAttributeValueNs(namespace, CAMUNDA_ATTRIBUTE_ERROR_CODE_VARIABLE)).isEqualTo("errorVariable");
  }

  @Test
  public void testErrorMessageVariable(){
    ErrorEventDefinition errorEventDefinition = startEvent.getChildElementsByType(ErrorEventDefinition.class).iterator().next();
    assertThat(errorEventDefinition.getAttributeValueNs(namespace, CAMUNDA_ATTRIBUTE_ERROR_MESSAGE_VARIABLE)).isEqualTo("errorMessageVariable");
  }

  @Test
  public void testErrorMessage() {
    assertThat(error.getFlowaveErrorMessage()).isEqualTo(TEST_STRING_XML);
    error.setFlowaveErrorMessage(TEST_STRING_API);
    assertThat(error.getFlowaveErrorMessage()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testExclusive() {
    assertThat(startEvent.isFlowaveExclusive()).isTrue();
    assertThat(userTask.isFlowaveExclusive()).isFalse();
    userTask.setFlowaveExclusive(true);
    assertThat(userTask.isFlowaveExclusive()).isTrue();
    assertThat(parallelGateway.isFlowaveExclusive()).isTrue();
    parallelGateway.setFlowaveExclusive(false);
    assertThat(parallelGateway.isFlowaveExclusive()).isFalse();

    assertThat(callActivity.isFlowaveExclusive()).isFalse();
    callActivity.setFlowaveExclusive(true);
    assertThat(callActivity.isFlowaveExclusive()).isTrue();
  }

  @Test
  public void testExpression() {
    assertThat(serviceTask.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(messageEventDefinition.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_XML);
    serviceTask.setFlowaveExpression(TEST_EXPRESSION_API);
    messageEventDefinition.setFlowaveExpression(TEST_EXPRESSION_API);
    assertThat(serviceTask.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(messageEventDefinition.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_API);
  }

  @Test
  public void testFormHandlerClass() {
    assertThat(startEvent.getFlowaveFormHandlerClass()).isEqualTo(TEST_CLASS_XML);
    assertThat(userTask.getFlowaveFormHandlerClass()).isEqualTo(TEST_CLASS_XML);
    startEvent.setFlowaveFormHandlerClass(TEST_CLASS_API);
    userTask.setFlowaveFormHandlerClass(TEST_CLASS_API);
    assertThat(startEvent.getFlowaveFormHandlerClass()).isEqualTo(TEST_CLASS_API);
    assertThat(userTask.getFlowaveFormHandlerClass()).isEqualTo(TEST_CLASS_API);
  }

  @Test
  public void testFormKey() {
    assertThat(startEvent.getFlowaveFormKey()).isEqualTo(TEST_STRING_XML);
    assertThat(userTask.getFlowaveFormKey()).isEqualTo(TEST_STRING_XML);
    startEvent.setFlowaveFormKey(TEST_STRING_API);
    userTask.setFlowaveFormKey(TEST_STRING_API);
    assertThat(startEvent.getFlowaveFormKey()).isEqualTo(TEST_STRING_API);
    assertThat(userTask.getFlowaveFormKey()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testInitiator() {
    assertThat(startEvent.getFlowaveInitiator()).isEqualTo(TEST_STRING_XML);
    startEvent.setFlowaveInitiator(TEST_STRING_API);
    assertThat(startEvent.getFlowaveInitiator()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testPriority() {
    assertThat(userTask.getFlowavePriority()).isEqualTo(TEST_PRIORITY_XML);
    userTask.setFlowavePriority(TEST_PRIORITY_API);
    assertThat(userTask.getFlowavePriority()).isEqualTo(TEST_PRIORITY_API);
  }

  @Test
  public void testResultVariable() {
    assertThat(serviceTask.getFlowaveResultVariable()).isEqualTo(TEST_STRING_XML);
    assertThat(messageEventDefinition.getFlowaveResultVariable()).isEqualTo(TEST_STRING_XML);
    serviceTask.setFlowaveResultVariable(TEST_STRING_API);
    messageEventDefinition.setFlowaveResultVariable(TEST_STRING_API);
    assertThat(serviceTask.getFlowaveResultVariable()).isEqualTo(TEST_STRING_API);
    assertThat(messageEventDefinition.getFlowaveResultVariable()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testType() {
    assertThat(serviceTask.getFlowaveType()).isEqualTo(TEST_TYPE_XML);
    assertThat(messageEventDefinition.getFlowaveType()).isEqualTo(TEST_STRING_XML);
    serviceTask.setFlowaveType(TEST_TYPE_API);
    messageEventDefinition.setFlowaveType(TEST_STRING_API);
    assertThat(serviceTask.getFlowaveType()).isEqualTo(TEST_TYPE_API);
    assertThat(messageEventDefinition.getFlowaveType()).isEqualTo(TEST_STRING_API);

  }

  @Test
  public void testTopic() {
    assertThat(serviceTask.getFlowaveTopic()).isEqualTo(TEST_STRING_XML);
    assertThat(messageEventDefinition.getFlowaveTopic()).isEqualTo(TEST_STRING_XML);
    serviceTask.setFlowaveTopic(TEST_TYPE_API);
    messageEventDefinition.setFlowaveTopic(TEST_STRING_API);
    assertThat(serviceTask.getFlowaveTopic()).isEqualTo(TEST_TYPE_API);
    assertThat(messageEventDefinition.getFlowaveTopic()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testVariableMappingClass() {
    assertThat(callActivity.getFlowaveVariableMappingClass()).isEqualTo(TEST_CLASS_XML);
    callActivity.setFlowaveVariableMappingClass(TEST_CLASS_API);
    assertThat(callActivity.getFlowaveVariableMappingClass()).isEqualTo(TEST_CLASS_API);
  }

  @Test
  public void testVariableMappingDelegateExpression() {
    assertThat(callActivity.getFlowaveVariableMappingDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_XML);
    callActivity.setFlowaveVariableMappingDelegateExpression(TEST_DELEGATE_EXPRESSION_API);
    assertThat(callActivity.getFlowaveVariableMappingDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
  }

  @Test
  public void testExecutionListenerExtension() {
    FlowaveExecutionListener processListener = process.getExtensionElements().getElementsQuery().filterByType(FlowaveExecutionListener.class).singleResult();
    FlowaveExecutionListener startEventListener = startEvent.getExtensionElements().getElementsQuery().filterByType(FlowaveExecutionListener.class).singleResult();
    FlowaveExecutionListener serviceTaskListener = serviceTask.getExtensionElements().getElementsQuery().filterByType(FlowaveExecutionListener.class).singleResult();
    assertThat(processListener.getFlowaveClass()).isEqualTo(TEST_CLASS_XML);
    assertThat(processListener.getFlowaveEvent()).isEqualTo(TEST_EXECUTION_EVENT_XML);
    assertThat(startEventListener.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(startEventListener.getFlowaveEvent()).isEqualTo(TEST_EXECUTION_EVENT_XML);
    assertThat(serviceTaskListener.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_XML);
    assertThat(serviceTaskListener.getFlowaveEvent()).isEqualTo(TEST_EXECUTION_EVENT_XML);
    processListener.setFlowaveClass(TEST_CLASS_API);
    processListener.setFlowaveEvent(TEST_EXECUTION_EVENT_API);
    startEventListener.setFlowaveExpression(TEST_EXPRESSION_API);
    startEventListener.setFlowaveEvent(TEST_EXECUTION_EVENT_API);
    serviceTaskListener.setFlowaveDelegateExpression(TEST_DELEGATE_EXPRESSION_API);
    serviceTaskListener.setFlowaveEvent(TEST_EXECUTION_EVENT_API);
    assertThat(processListener.getFlowaveClass()).isEqualTo(TEST_CLASS_API);
    assertThat(processListener.getFlowaveEvent()).isEqualTo(TEST_EXECUTION_EVENT_API);
    assertThat(startEventListener.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(startEventListener.getFlowaveEvent()).isEqualTo(TEST_EXECUTION_EVENT_API);
    assertThat(serviceTaskListener.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);
    assertThat(serviceTaskListener.getFlowaveEvent()).isEqualTo(TEST_EXECUTION_EVENT_API);
  }

  @Test
  public void testFlowaveScriptExecutionListener() {
    FlowaveExecutionListener sequenceFlowListener = sequenceFlow.getExtensionElements().getElementsQuery().filterByType(FlowaveExecutionListener.class).singleResult();

    FlowaveScript script = sequenceFlowListener.getFlowaveScript();
    assertThat(script.getFlowaveScriptFormat()).isEqualTo("groovy");
    assertThat(script.getFlowaveResource()).isNull();
    assertThat(script.getTextContent()).isEqualTo("println 'Hello World'");

    FlowaveScript newScript = modelInstance.newInstance(FlowaveScript.class);
    newScript.setFlowaveScriptFormat("groovy");
    newScript.setFlowaveResource("test.groovy");
    sequenceFlowListener.setFlowaveScript(newScript);

    script = sequenceFlowListener.getFlowaveScript();
    assertThat(script.getFlowaveScriptFormat()).isEqualTo("groovy");
    assertThat(script.getFlowaveResource()).isEqualTo("test.groovy");
    assertThat(script.getTextContent()).isEmpty();
  }

  @Test
  public void testFailedJobRetryTimeCycleExtension() {
    FlowaveFailedJobRetryTimeCycle timeCycle = sendTask.getExtensionElements().getElementsQuery().filterByType(FlowaveFailedJobRetryTimeCycle.class).singleResult();
    assertThat(timeCycle.getTextContent()).isEqualTo(TEST_STRING_XML);
    timeCycle.setTextContent(TEST_STRING_API);
    assertThat(timeCycle.getTextContent()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testFieldExtension() {
    FlowaveField field = sendTask.getExtensionElements().getElementsQuery().filterByType(FlowaveField.class).singleResult();
    assertThat(field.getFlowaveName()).isEqualTo(TEST_STRING_XML);
    assertThat(field.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(field.getFlowaveStringValue()).isEqualTo(TEST_STRING_XML);
    assertThat(field.getFlowaveExpressionChild().getTextContent()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(field.getFlowaveString().getTextContent()).isEqualTo(TEST_STRING_XML);
    field.setFlowaveName(TEST_STRING_API);
    field.setFlowaveExpression(TEST_EXPRESSION_API);
    field.setFlowaveStringValue(TEST_STRING_API);
    field.getFlowaveExpressionChild().setTextContent(TEST_EXPRESSION_API);
    field.getFlowaveString().setTextContent(TEST_STRING_API);
    assertThat(field.getFlowaveName()).isEqualTo(TEST_STRING_API);
    assertThat(field.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(field.getFlowaveStringValue()).isEqualTo(TEST_STRING_API);
    assertThat(field.getFlowaveExpressionChild().getTextContent()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(field.getFlowaveString().getTextContent()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testFormData() {
    FlowaveFormData formData = userTask.getExtensionElements().getElementsQuery().filterByType(FlowaveFormData.class).singleResult();
    FlowaveFormField formField = formData.getFlowaveFormFields().iterator().next();
    assertThat(formField.getFlowaveId()).isEqualTo(TEST_STRING_XML);
    assertThat(formField.getFlowaveLabel()).isEqualTo(TEST_STRING_XML);
    assertThat(formField.getFlowaveType()).isEqualTo(TEST_STRING_XML);
    assertThat(formField.getFlowaveDatePattern()).isEqualTo(TEST_STRING_XML);
    assertThat(formField.getFlowaveDefaultValue()).isEqualTo(TEST_STRING_XML);
    formField.setFlowaveId(TEST_STRING_API);
    formField.setFlowaveLabel(TEST_STRING_API);
    formField.setFlowaveType(TEST_STRING_API);
    formField.setFlowaveDatePattern(TEST_STRING_API);
    formField.setFlowaveDefaultValue(TEST_STRING_API);
    assertThat(formField.getFlowaveId()).isEqualTo(TEST_STRING_API);
    assertThat(formField.getFlowaveLabel()).isEqualTo(TEST_STRING_API);
    assertThat(formField.getFlowaveType()).isEqualTo(TEST_STRING_API);
    assertThat(formField.getFlowaveDatePattern()).isEqualTo(TEST_STRING_API);
    assertThat(formField.getFlowaveDefaultValue()).isEqualTo(TEST_STRING_API);

    FlowaveProperty property = formField.getFlowaveProperties().getFlowaveProperties().iterator().next();
    assertThat(property.getFlowaveId()).isEqualTo(TEST_STRING_XML);
    assertThat(property.getFlowaveValue()).isEqualTo(TEST_STRING_XML);
    property.setFlowaveId(TEST_STRING_API);
    property.setFlowaveValue(TEST_STRING_API);
    assertThat(property.getFlowaveId()).isEqualTo(TEST_STRING_API);
    assertThat(property.getFlowaveValue()).isEqualTo(TEST_STRING_API);

    FlowaveConstraint constraint = formField.getFlowaveValidation().getFlowaveConstraints().iterator().next();
    assertThat(constraint.getFlowaveName()).isEqualTo(TEST_STRING_XML);
    assertThat(constraint.getFlowaveConfig()).isEqualTo(TEST_STRING_XML);
    constraint.setFlowaveName(TEST_STRING_API);
    constraint.setFlowaveConfig(TEST_STRING_API);
    assertThat(constraint.getFlowaveName()).isEqualTo(TEST_STRING_API);
    assertThat(constraint.getFlowaveConfig()).isEqualTo(TEST_STRING_API);

    FlowaveValue value = formField.getFlowaveValues().iterator().next();
    assertThat(value.getFlowaveId()).isEqualTo(TEST_STRING_XML);
    assertThat(value.getFlowaveName()).isEqualTo(TEST_STRING_XML);
    value.setFlowaveId(TEST_STRING_API);
    value.setFlowaveName(TEST_STRING_API);
    assertThat(value.getFlowaveId()).isEqualTo(TEST_STRING_API);
    assertThat(value.getFlowaveName()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testFormProperty() {
    FlowaveFormProperty formProperty = startEvent.getExtensionElements().getElementsQuery().filterByType(FlowaveFormProperty.class).singleResult();
    assertThat(formProperty.getFlowaveId()).isEqualTo(TEST_STRING_XML);
    assertThat(formProperty.getFlowaveName()).isEqualTo(TEST_STRING_XML);
    assertThat(formProperty.getFlowaveType()).isEqualTo(TEST_STRING_XML);
    assertThat(formProperty.isFlowaveRequired()).isFalse();
    assertThat(formProperty.isFlowaveReadable()).isTrue();
    assertThat(formProperty.isFlowaveWriteable()).isTrue();
    assertThat(formProperty.getFlowaveVariable()).isEqualTo(TEST_STRING_XML);
    assertThat(formProperty.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(formProperty.getFlowaveDatePattern()).isEqualTo(TEST_STRING_XML);
    assertThat(formProperty.getFlowaveDefault()).isEqualTo(TEST_STRING_XML);
    formProperty.setFlowaveId(TEST_STRING_API);
    formProperty.setFlowaveName(TEST_STRING_API);
    formProperty.setFlowaveType(TEST_STRING_API);
    formProperty.setFlowaveRequired(true);
    formProperty.setFlowaveReadable(false);
    formProperty.setFlowaveWriteable(false);
    formProperty.setFlowaveVariable(TEST_STRING_API);
    formProperty.setFlowaveExpression(TEST_EXPRESSION_API);
    formProperty.setFlowaveDatePattern(TEST_STRING_API);
    formProperty.setFlowaveDefault(TEST_STRING_API);
    assertThat(formProperty.getFlowaveId()).isEqualTo(TEST_STRING_API);
    assertThat(formProperty.getFlowaveName()).isEqualTo(TEST_STRING_API);
    assertThat(formProperty.getFlowaveType()).isEqualTo(TEST_STRING_API);
    assertThat(formProperty.isFlowaveRequired()).isTrue();
    assertThat(formProperty.isFlowaveReadable()).isFalse();
    assertThat(formProperty.isFlowaveWriteable()).isFalse();
    assertThat(formProperty.getFlowaveVariable()).isEqualTo(TEST_STRING_API);
    assertThat(formProperty.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(formProperty.getFlowaveDatePattern()).isEqualTo(TEST_STRING_API);
    assertThat(formProperty.getFlowaveDefault()).isEqualTo(TEST_STRING_API);
  }

  @Test
  public void testInExtension() {
    FlowaveIn in = callActivity.getExtensionElements().getElementsQuery().filterByType(FlowaveIn.class).singleResult();
    assertThat(in.getFlowaveSource()).isEqualTo(TEST_STRING_XML);
    assertThat(in.getFlowaveSourceExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(in.getFlowaveVariables()).isEqualTo(TEST_STRING_XML);
    assertThat(in.getFlowaveTarget()).isEqualTo(TEST_STRING_XML);
    assertThat(in.getFlowaveBusinessKey()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(in.getFlowaveLocal()).isTrue();
    in.setFlowaveSource(TEST_STRING_API);
    in.setFlowaveSourceExpression(TEST_EXPRESSION_API);
    in.setFlowaveVariables(TEST_STRING_API);
    in.setFlowaveTarget(TEST_STRING_API);
    in.setFlowaveBusinessKey(TEST_EXPRESSION_API);
    in.setFlowaveLocal(false);
    assertThat(in.getFlowaveSource()).isEqualTo(TEST_STRING_API);
    assertThat(in.getFlowaveSourceExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(in.getFlowaveVariables()).isEqualTo(TEST_STRING_API);
    assertThat(in.getFlowaveTarget()).isEqualTo(TEST_STRING_API);
    assertThat(in.getFlowaveBusinessKey()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(in.getFlowaveLocal()).isFalse();
  }

  @Test
  public void testOutExtension() {
    FlowaveOut out = callActivity.getExtensionElements().getElementsQuery().filterByType(FlowaveOut.class).singleResult();
    assertThat(out.getFlowaveSource()).isEqualTo(TEST_STRING_XML);
    assertThat(out.getFlowaveSourceExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(out.getFlowaveVariables()).isEqualTo(TEST_STRING_XML);
    assertThat(out.getFlowaveTarget()).isEqualTo(TEST_STRING_XML);
    assertThat(out.getFlowaveLocal()).isTrue();
    out.setFlowaveSource(TEST_STRING_API);
    out.setFlowaveSourceExpression(TEST_EXPRESSION_API);
    out.setFlowaveVariables(TEST_STRING_API);
    out.setFlowaveTarget(TEST_STRING_API);
    out.setFlowaveLocal(false);
    assertThat(out.getFlowaveSource()).isEqualTo(TEST_STRING_API);
    assertThat(out.getFlowaveSourceExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(out.getFlowaveVariables()).isEqualTo(TEST_STRING_API);
    assertThat(out.getFlowaveTarget()).isEqualTo(TEST_STRING_API);
    assertThat(out.getFlowaveLocal()).isFalse();
  }

  @Test
  public void testPotentialStarter() {
    FlowavePotentialStarter potentialStarter = startEvent.getExtensionElements().getElementsQuery().filterByType(FlowavePotentialStarter.class).singleResult();
    Expression expression = potentialStarter.getResourceAssignmentExpression().getExpression();
    assertThat(expression.getTextContent()).isEqualTo(TEST_GROUPS_XML);
    expression.setTextContent(TEST_GROUPS_API);
    assertThat(expression.getTextContent()).isEqualTo(TEST_GROUPS_API);
  }

  @Test
  public void testTaskListener() {
    FlowaveTaskListener taskListener = userTask.getExtensionElements().getElementsQuery().filterByType(FlowaveTaskListener.class).list().get(0);
    assertThat(taskListener.getFlowaveEvent()).isEqualTo(TEST_TASK_EVENT_XML);
    assertThat(taskListener.getFlowaveClass()).isEqualTo(TEST_CLASS_XML);
    assertThat(taskListener.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_XML);
    assertThat(taskListener.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_XML);
    taskListener.setFlowaveEvent(TEST_TASK_EVENT_API);
    taskListener.setFlowaveClass(TEST_CLASS_API);
    taskListener.setFlowaveExpression(TEST_EXPRESSION_API);
    taskListener.setFlowaveDelegateExpression(TEST_DELEGATE_EXPRESSION_API);
    assertThat(taskListener.getFlowaveEvent()).isEqualTo(TEST_TASK_EVENT_API);
    assertThat(taskListener.getFlowaveClass()).isEqualTo(TEST_CLASS_API);
    assertThat(taskListener.getFlowaveExpression()).isEqualTo(TEST_EXPRESSION_API);
    assertThat(taskListener.getFlowaveDelegateExpression()).isEqualTo(TEST_DELEGATE_EXPRESSION_API);

    FlowaveField field = taskListener.getFlowaveFields().iterator().next();
    assertThat(field.getFlowaveName()).isEqualTo(TEST_STRING_XML);
    assertThat(field.getFlowaveString().getTextContent()).isEqualTo(TEST_STRING_XML);

    Collection<TimerEventDefinition> timeouts = taskListener.getTimeouts();
    assertThat(timeouts.size()).isEqualTo(1);

    TimerEventDefinition timeout = timeouts.iterator().next();
    assertThat(timeout.getTimeCycle()).isNull();
    assertThat(timeout.getTimeDate()).isNull();
    assertThat(timeout.getTimeDuration()).isNotNull();
    assertThat(timeout.getTimeDuration().getRawTextContent()).isEqualTo("PT1H");
  }

  @Test
  public void testFlowaveScriptTaskListener() {
    FlowaveTaskListener taskListener = userTask.getExtensionElements().getElementsQuery().filterByType(FlowaveTaskListener.class).list().get(1);

    FlowaveScript script = taskListener.getFlowaveScript();
    assertThat(script.getFlowaveScriptFormat()).isEqualTo("groovy");
    assertThat(script.getFlowaveResource()).isEqualTo("test.groovy");
    assertThat(script.getTextContent()).isEmpty();

    FlowaveScript newScript = modelInstance.newInstance(FlowaveScript.class);
    newScript.setFlowaveScriptFormat("groovy");
    newScript.setTextContent("println 'Hello World'");
    taskListener.setFlowaveScript(newScript);

    script = taskListener.getFlowaveScript();
    assertThat(script.getFlowaveScriptFormat()).isEqualTo("groovy");
    assertThat(script.getFlowaveResource()).isNull();
    assertThat(script.getTextContent()).isEqualTo("println 'Hello World'");
  }

  @Test
  public void testFlowaveModelerProperties() {
    FlowaveProperties camundaProperties = endEvent.getExtensionElements().getElementsQuery().filterByType(FlowaveProperties.class).singleResult();
    assertThat(camundaProperties).isNotNull();
    assertThat(camundaProperties.getFlowaveProperties()).hasSize(2);

    for (FlowaveProperty camundaProperty : camundaProperties.getFlowaveProperties()) {
      assertThat(camundaProperty.getFlowaveId()).isNull();
      assertThat(camundaProperty.getFlowaveName()).startsWith("name");
      assertThat(camundaProperty.getFlowaveValue()).startsWith("value");
    }
  }

  @Test
  public void testGetNonExistingFlowaveCandidateUsers() {
    userTask.removeAttributeNs(namespace, "candidateUsers");
    assertThat(userTask.getFlowaveCandidateUsers()).isNull();
    assertThat(userTask.getFlowaveCandidateUsersList()).isEmpty();
  }

  @Test
  public void testSetNullFlowaveCandidateUsers() {
    assertThat(userTask.getFlowaveCandidateUsers()).isNotEmpty();
    assertThat(userTask.getFlowaveCandidateUsersList()).isNotEmpty();
    userTask.setFlowaveCandidateUsers(null);
    assertThat(userTask.getFlowaveCandidateUsers()).isNull();
    assertThat(userTask.getFlowaveCandidateUsersList()).isEmpty();
  }

  @Test
  public void testEmptyFlowaveCandidateUsers() {
    assertThat(userTask.getFlowaveCandidateUsers()).isNotEmpty();
    assertThat(userTask.getFlowaveCandidateUsersList()).isNotEmpty();
    userTask.setFlowaveCandidateUsers("");
    assertThat(userTask.getFlowaveCandidateUsers()).isNull();
    assertThat(userTask.getFlowaveCandidateUsersList()).isEmpty();
  }

  @Test
  public void testSetNullFlowaveCandidateUsersList() {
    assertThat(userTask.getFlowaveCandidateUsers()).isNotEmpty();
    assertThat(userTask.getFlowaveCandidateUsersList()).isNotEmpty();
    userTask.setFlowaveCandidateUsersList(null);
    assertThat(userTask.getFlowaveCandidateUsers()).isNull();
    assertThat(userTask.getFlowaveCandidateUsersList()).isEmpty();
  }

  @Test
  public void testEmptyFlowaveCandidateUsersList() {
    assertThat(userTask.getFlowaveCandidateUsers()).isNotEmpty();
    assertThat(userTask.getFlowaveCandidateUsersList()).isNotEmpty();
    userTask.setFlowaveCandidateUsersList(Collections.<String>emptyList());
    assertThat(userTask.getFlowaveCandidateUsers()).isNull();
    assertThat(userTask.getFlowaveCandidateUsersList()).isEmpty();
  }

  @Test
  public void testScriptResource() {
    assertThat(scriptTask.getScriptFormat()).isEqualTo("groovy");
    assertThat(scriptTask.getFlowaveResource()).isEqualTo("test.groovy");
  }

  @Test
  public void testFlowaveConnector() {
    FlowaveConnector camundaConnector = serviceTask.getExtensionElements().getElementsQuery().filterByType(FlowaveConnector.class).singleResult();
    assertThat(camundaConnector).isNotNull();

    FlowaveConnectorId camundaConnectorId = camundaConnector.getFlowaveConnectorId();
    assertThat(camundaConnectorId).isNotNull();
    assertThat(camundaConnectorId.getTextContent()).isEqualTo("soap-http-connector");

    FlowaveInputOutput camundaInputOutput = camundaConnector.getFlowaveInputOutput();

    Collection<FlowaveInputParameter> inputParameters = camundaInputOutput.getFlowaveInputParameters();
    assertThat(inputParameters).hasSize(1);

    FlowaveInputParameter inputParameter = inputParameters.iterator().next();
    assertThat(inputParameter.getFlowaveName()).isEqualTo("endpointUrl");
    assertThat(inputParameter.getTextContent()).isEqualTo("http://example.com/webservice");

    Collection<FlowaveOutputParameter> outputParameters = camundaInputOutput.getFlowaveOutputParameters();
    assertThat(outputParameters).hasSize(1);

    FlowaveOutputParameter outputParameter = outputParameters.iterator().next();
    assertThat(outputParameter.getFlowaveName()).isEqualTo("result");
    assertThat(outputParameter.getTextContent()).isEqualTo("output");
  }

  @Test
  public void testFlowaveInputOutput() {
    FlowaveInputOutput camundaInputOutput = serviceTask.getExtensionElements().getElementsQuery().filterByType(FlowaveInputOutput.class).singleResult();
    assertThat(camundaInputOutput).isNotNull();
    assertThat(camundaInputOutput.getFlowaveInputParameters()).hasSize(6);
    assertThat(camundaInputOutput.getFlowaveOutputParameters()).hasSize(1);
  }

  @Test
  public void testFlowaveInputParameter() {
    // find existing
    FlowaveInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeConstant");

    // modify existing
    inputParameter.setFlowaveName("hello");
    inputParameter.setTextContent("world");
    inputParameter = findInputParameterByName(serviceTask, "hello");
    assertThat(inputParameter.getTextContent()).isEqualTo("world");

    // add new one
    inputParameter = modelInstance.newInstance(FlowaveInputParameter.class);
    inputParameter.setFlowaveName("abc");
    inputParameter.setTextContent("def");
    serviceTask.getExtensionElements().getElementsQuery().filterByType(FlowaveInputOutput.class).singleResult()
      .addChildElement(inputParameter);

    // search for new one
    inputParameter = findInputParameterByName(serviceTask, "abc");
    assertThat(inputParameter.getFlowaveName()).isEqualTo("abc");
    assertThat(inputParameter.getTextContent()).isEqualTo("def");
  }

  @Test
  public void testFlowaveNullInputParameter() {
    FlowaveInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeNull");
    assertThat(inputParameter.getFlowaveName()).isEqualTo("shouldBeNull");
    assertThat(inputParameter.getTextContent()).isEmpty();
  }

  @Test
  public void testFlowaveConstantInputParameter() {
    FlowaveInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeConstant");
    assertThat(inputParameter.getFlowaveName()).isEqualTo("shouldBeConstant");
    assertThat(inputParameter.getTextContent()).isEqualTo("foo");
  }

  @Test
  public void testFlowaveExpressionInputParameter() {
    FlowaveInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeExpression");
    assertThat(inputParameter.getFlowaveName()).isEqualTo("shouldBeExpression");
    assertThat(inputParameter.getTextContent()).isEqualTo("${1 + 1}");
  }

  @Test
  public void testFlowaveListInputParameter() {
    FlowaveInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeList");
    assertThat(inputParameter.getFlowaveName()).isEqualTo("shouldBeList");
    assertThat(inputParameter.getTextContent()).isNotEmpty();
    assertThat(inputParameter.getUniqueChildElementByNameNs(CAMUNDA_NS, "list")).isNotNull();

    FlowaveList list = inputParameter.getValue();
    assertThat(list.getValues()).hasSize(3);
    for (BpmnModelElementInstance values : list.getValues()) {
      assertThat(values.getTextContent()).isIn("a", "b", "c");
    }

    list = modelInstance.newInstance(FlowaveList.class);
    for (int i = 0; i < 4; i++) {
      FlowaveValue value = modelInstance.newInstance(FlowaveValue.class);
      value.setTextContent("test");
      list.getValues().add(value);
    }
    Collection<FlowaveValue> testValues = Arrays.asList(modelInstance.newInstance(FlowaveValue.class), modelInstance.newInstance(FlowaveValue.class));
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

    FlowaveValue value = modelInstance.newInstance(FlowaveValue.class);
    elements.add(value);

    List<FlowaveValue> newValues = new ArrayList<FlowaveValue>();
    newValues.add(modelInstance.newInstance(FlowaveValue.class));
    newValues.add(modelInstance.newInstance(FlowaveValue.class));
    elements.addAll(newValues);
    assertThat(elements).hasSize(3);

    assertThat(elements).doesNotContain(modelInstance.newInstance(FlowaveValue.class));
    assertThat(elements.containsAll(Arrays.asList(modelInstance.newInstance(FlowaveValue.class)))).isFalse();

    assertThat(elements.remove(modelInstance.newInstance(FlowaveValue.class))).isFalse();
    assertThat(elements).hasSize(3);

    assertThat(elements.remove(value)).isTrue();
    assertThat(elements).hasSize(2);

    assertThat(elements.removeAll(newValues)).isTrue();
    assertThat(elements).isEmpty();

    elements.add(modelInstance.newInstance(FlowaveValue.class));
    elements.clear();
    assertThat(elements).isEmpty();

    inputParameter.removeValue();
    assertThat((Object) inputParameter.getValue()).isNull();

  }

  @Test
  public void testFlowaveMapInputParameter() {
    FlowaveInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeMap");
    assertThat(inputParameter.getFlowaveName()).isEqualTo("shouldBeMap");
    assertThat(inputParameter.getTextContent()).isNotEmpty();
    assertThat(inputParameter.getUniqueChildElementByNameNs(CAMUNDA_NS, "map")).isNotNull();

    FlowaveMap map = inputParameter.getValue();
    assertThat(map.getFlowaveEntries()).hasSize(2);
    for (FlowaveEntry entry : map.getFlowaveEntries()) {
      if (entry.getFlowaveKey().equals("foo")) {
        assertThat(entry.getTextContent()).isEqualTo("bar");
      }
      else {
        assertThat(entry.getFlowaveKey()).isEqualTo("hello");
        assertThat(entry.getTextContent()).isEqualTo("world");
      }
    }

    map = modelInstance.newInstance(FlowaveMap.class);
    FlowaveEntry entry = modelInstance.newInstance(FlowaveEntry.class);
    entry.setFlowaveKey("test");
    entry.setTextContent("value");
    map.getFlowaveEntries().add(entry);

    inputParameter.setValue(map);
    map = inputParameter.getValue();
    assertThat(map.getFlowaveEntries()).hasSize(1);
    entry = map.getFlowaveEntries().iterator().next();
    assertThat(entry.getFlowaveKey()).isEqualTo("test");
    assertThat(entry.getTextContent()).isEqualTo("value");

    Collection<FlowaveEntry> entries = map.getFlowaveEntries();
    entries.add(modelInstance.newInstance(FlowaveEntry.class));
    assertThat(entries).hasSize(2);

    inputParameter.removeValue();
    assertThat((Object) inputParameter.getValue()).isNull();
  }

  @Test
  public void testFlowaveScriptInputParameter() {
    FlowaveInputParameter inputParameter = findInputParameterByName(serviceTask, "shouldBeScript");
    assertThat(inputParameter.getFlowaveName()).isEqualTo("shouldBeScript");
    assertThat(inputParameter.getTextContent()).isNotEmpty();
    assertThat(inputParameter.getUniqueChildElementByNameNs(CAMUNDA_NS, "script")).isNotNull();
    assertThat(inputParameter.getUniqueChildElementByType(FlowaveScript.class)).isNotNull();

    FlowaveScript script = inputParameter.getValue();
    assertThat(script.getFlowaveScriptFormat()).isEqualTo("groovy");
    assertThat(script.getFlowaveResource()).isNull();
    assertThat(script.getTextContent()).isEqualTo("1 + 1");

    script = modelInstance.newInstance(FlowaveScript.class);
    script.setFlowaveScriptFormat("python");
    script.setFlowaveResource("script.py");

    inputParameter.setValue(script);

    script = inputParameter.getValue();
    assertThat(script.getFlowaveScriptFormat()).isEqualTo("python");
    assertThat(script.getFlowaveResource()).isEqualTo("script.py");
    assertThat(script.getTextContent()).isEmpty();

    inputParameter.removeValue();
    assertThat((Object) inputParameter.getValue()).isNull();
  }

  @Test
  public void testFlowaveNestedOutputParameter() {
    FlowaveOutputParameter camundaOutputParameter = serviceTask.getExtensionElements().getElementsQuery().filterByType(FlowaveInputOutput.class).singleResult().getFlowaveOutputParameters().iterator().next();

    assertThat(camundaOutputParameter).isNotNull();
    assertThat(camundaOutputParameter.getFlowaveName()).isEqualTo("nested");
    FlowaveList list = camundaOutputParameter.getValue();
    assertThat(list).isNotNull();
    assertThat(list.getValues()).hasSize(2);
    Iterator<BpmnModelElementInstance> iterator = list.getValues().iterator();

    // nested list
    FlowaveList nestedList = (FlowaveList) iterator.next().getUniqueChildElementByType(FlowaveList.class);
    assertThat(nestedList).isNotNull();
    assertThat(nestedList.getValues()).hasSize(2);
    for (BpmnModelElementInstance value : nestedList.getValues()) {
      assertThat(value.getTextContent()).isEqualTo("list");
    }

    // nested map
    FlowaveMap nestedMap = (FlowaveMap) iterator.next().getUniqueChildElementByType(FlowaveMap.class);
    assertThat(nestedMap).isNotNull();
    assertThat(nestedMap.getFlowaveEntries()).hasSize(2);
    Iterator<FlowaveEntry> mapIterator = nestedMap.getFlowaveEntries().iterator();

    // nested list in nested map
    FlowaveEntry nestedListEntry = mapIterator.next();
    assertThat(nestedListEntry).isNotNull();
    assertThat(nestedListEntry.getFlowaveKey()).isEqualTo("list");
    FlowaveList nestedNestedList = nestedListEntry.getValue();
    for (BpmnModelElementInstance value : nestedNestedList.getValues()) {
      assertThat(value.getTextContent()).isEqualTo("map");
    }

    // nested map in nested map
    FlowaveEntry nestedMapEntry = mapIterator.next();
    assertThat(nestedMapEntry).isNotNull();
    assertThat(nestedMapEntry.getFlowaveKey()).isEqualTo("map");
    FlowaveMap nestedNestedMap = nestedMapEntry.getValue();
    FlowaveEntry entry = nestedNestedMap.getFlowaveEntries().iterator().next();
    assertThat(entry.getFlowaveKey()).isEqualTo("so");
    assertThat(entry.getTextContent()).isEqualTo("nested");
  }

  protected FlowaveInputParameter findInputParameterByName(BaseElement baseElement, String name) {
    Collection<FlowaveInputParameter> camundaInputParameters = baseElement.getExtensionElements().getElementsQuery()
      .filterByType(FlowaveInputOutput.class).singleResult().getFlowaveInputParameters();
    for (FlowaveInputParameter camundaInputParameter : camundaInputParameters) {
      if (camundaInputParameter.getFlowaveName().equals(name)) {
        return camundaInputParameter;
      }
    }
    throw new BpmnModelException("Unable to find camunda:inputParameter with name '" + name + "' for element with id '" + baseElement.getId() + "'");
  }

  @After
  public void validateModel() {
    Bpmn.validateModel(modelInstance);
  }
}
