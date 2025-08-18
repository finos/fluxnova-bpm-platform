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

import java.util.List;

import org.finos.flowave.bpm.model.bpmn.BpmnModelInstance;
import org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants;
import org.finos.flowave.bpm.model.bpmn.instance.TimerEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.UserTask;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormData;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormField;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveTaskListener;

/**
 * @author Sebastian Menski
 */
public abstract class AbstractUserTaskBuilder<B extends AbstractUserTaskBuilder<B>> extends AbstractTaskBuilder<B, UserTask> {

  protected AbstractUserTaskBuilder(BpmnModelInstance modelInstance, UserTask element, Class<?> selfType) {
    super(modelInstance, element, selfType);
  }

  /**
   * Sets the implementation of the build user task.
   *
   * @param implementation  the implementation to set
   * @return the builder object
   */
  public B implementation(String implementation) {
    element.setImplementation(implementation);
    return myself;
  }

  /** camunda extensions */

  /**
   * Sets the camunda attribute assignee.
   *
   * @param camundaAssignee  the assignee to set
   * @return the builder object
   */
  public B flowaveAssignee(String camundaAssignee) {
    element.setFlowaveAssignee(camundaAssignee);
    return myself;
  }

  /**
   * Sets the camunda candidate groups attribute.
   *
   * @param camundaCandidateGroups  the candidate groups to set
   * @return the builder object
   */
  public B flowaveCandidateGroups(String camundaCandidateGroups) {
    element.setFlowaveCandidateGroups(camundaCandidateGroups);
    return myself;
  }

  /**
   * Sets the camunda candidate groups attribute.
   *
   * @param camundaCandidateGroups  the candidate groups to set
   * @return the builder object
   */
  public B flowaveCandidateGroups(List<String> camundaCandidateGroups) {
    element.setFlowaveCandidateGroupsList(camundaCandidateGroups);
    return myself;
  }

  /**
   * Sets the camunda candidate users attribute.
   *
   * @param camundaCandidateUsers  the candidate users to set
   * @return the builder object
   */
  public B flowaveCandidateUsers(String camundaCandidateUsers) {
    element.setFlowaveCandidateUsers(camundaCandidateUsers);
    return myself;
  }

  /**
   * Sets the camunda candidate users attribute.
   *
   * @param camundaCandidateUsers  the candidate users to set
   * @return the builder object
   */
  public B flowaveCandidateUsers(List<String> camundaCandidateUsers) {
    element.setFlowaveCandidateUsersList(camundaCandidateUsers);
    return myself;
  }

  /**
   * Sets the camunda due date attribute.
   *
   * @param camundaDueDate  the due date of the user task
   * @return the builder object
   */
  public B flowaveDueDate(String camundaDueDate) {
    element.setFlowaveDueDate(camundaDueDate);
    return myself;
  }

  /**
   * Sets the camunda follow up date attribute.
   *
   * @param camundaFollowUpDate  the follow up date of the user task
   * @return the builder object
   */
  public B flowaveFollowUpDate(String camundaFollowUpDate) {
    element.setFlowaveFollowUpDate(camundaFollowUpDate);
    return myself;
  }

  /**
   * Sets the camunda form handler class attribute.
   *
   * @param camundaFormHandlerClass  the class name of the form handler
   * @return the builder object
   */
  @SuppressWarnings("rawtypes")
  public B flowaveFormHandlerClass(Class camundaFormHandlerClass) {
    return flowaveFormHandlerClass(camundaFormHandlerClass.getName());
  }

  /**
   * Sets the camunda form handler class attribute.
   *
   * @param camundaFormHandlerClass  the class name of the form handler
   * @return the builder object
   */
  public B flowaveFormHandlerClass(String fullQualifiedClassName) {
    element.setFlowaveFormHandlerClass(fullQualifiedClassName);
    return myself;
  }

  /**
   * Sets the camunda form key attribute.
   *
   * @param camundaFormKey  the form key to set
   * @return the builder object
   */
  public B flowaveFormKey(String camundaFormKey) {
    element.setFlowaveFormKey(camundaFormKey);
    return myself;
  }

  /**
   * Sets the camunda form ref attribute.
   *
   * @param camundaFormRef the form ref to set
   * @return the builder object
   */
  public B flowaveFormRef(String camundaFormRef) {
    element.setFlowaveFormRef(camundaFormRef);
    return myself;
  }

  /**
   * Sets the camunda form ref binding attribute.
   *
   * @param camundaFormRef the form ref binding to set
   * @return the builder object
   */
  public B flowaveFormRefBinding(String camundaFormRefBinding) {
    element.setFlowaveFormRefBinding(camundaFormRefBinding);
    return myself;
  }

  /**
   * Sets the camunda form ref version attribute.
   *
   * @param camundaFormRef the form ref version to set
   * @return the builder object
   */
  public B flowaveFormRefVersion(String camundaFormRefVersion) {
    element.setFlowaveFormRefVersion(camundaFormRefVersion);
    return myself;
  }

  /**
   * Sets the camunda priority attribute.
   *
   * @param camundaPriority  the priority of the user task
   * @return the builder object
   */
  public B flowavePriority(String camundaPriority) {
    element.setFlowavePriority(camundaPriority);
    return myself;
  }

  /**
   * Creates a new camunda form field extension element.
   *
   * @return the builder object
   */
  public FlowaveUserTaskFormFieldBuilder flowaveFormField() {
    FlowaveFormData camundaFormData = getCreateSingleExtensionElement(FlowaveFormData.class);
    FlowaveFormField camundaFormField = createChild(camundaFormData, FlowaveFormField.class);
    return new FlowaveUserTaskFormFieldBuilder(modelInstance, element, camundaFormField);
  }

  /**
   * Add a class based task listener with specified event name
   *
   * @param eventName - event names to listen to
   * @param fullQualifiedClassName - a string representing a class
   * @return the builder object
   */
  @SuppressWarnings("rawtypes")
  public B flowaveTaskListenerClass(String eventName, Class listenerClass) {
    return flowaveTaskListenerClass(eventName, listenerClass.getName());
  }

  /**
   * Add a class based task listener with specified event name
   *
   * @param eventName - event names to listen to
   * @param fullQualifiedClassName - a string representing a class
   * @return the builder object
   */
  public B flowaveTaskListenerClass(String eventName, String fullQualifiedClassName) {
    FlowaveTaskListener executionListener = createInstance(FlowaveTaskListener.class);
    executionListener.setFlowaveEvent(eventName);
    executionListener.setFlowaveClass(fullQualifiedClassName);

    addExtensionElement(executionListener);

    return myself;
  }

  public B flowaveTaskListenerExpression(String eventName, String expression) {
    FlowaveTaskListener executionListener = createInstance(FlowaveTaskListener.class);
    executionListener.setFlowaveEvent(eventName);
    executionListener.setFlowaveExpression(expression);

    addExtensionElement(executionListener);

    return myself;
  }

  public B flowaveTaskListenerDelegateExpression(String eventName, String delegateExpression) {
    FlowaveTaskListener executionListener = createInstance(FlowaveTaskListener.class);
    executionListener.setFlowaveEvent(eventName);
    executionListener.setFlowaveDelegateExpression(delegateExpression);

    addExtensionElement(executionListener);

    return myself;
  }

  @SuppressWarnings("rawtypes")
  public B flowaveTaskListenerClassTimeoutWithCycle(String id, Class listenerClass, String timerCycle) {
    return flowaveTaskListenerClassTimeoutWithCycle(id, listenerClass.getName(), timerCycle);
  }

  @SuppressWarnings("rawtypes")
  public B flowaveTaskListenerClassTimeoutWithDate(String id, Class listenerClass, String timerDate) {
    return flowaveTaskListenerClassTimeoutWithDate(id, listenerClass.getName(), timerDate);
  }

  @SuppressWarnings("rawtypes")
  public B flowaveTaskListenerClassTimeoutWithDuration(String id, Class listenerClass, String timerDuration) {
    return flowaveTaskListenerClassTimeoutWithDuration(id, listenerClass.getName(), timerDuration);
  }

  public B flowaveTaskListenerClassTimeoutWithCycle(String id, String fullQualifiedClassName, String timerCycle) {
    return createFlowaveTaskListenerClassTimeout(id, fullQualifiedClassName, createTimeCycle(timerCycle));
  }

  public B flowaveTaskListenerClassTimeoutWithDate(String id, String fullQualifiedClassName, String timerDate) {
    return createFlowaveTaskListenerClassTimeout(id, fullQualifiedClassName, createTimeDate(timerDate));
  }

  public B flowaveTaskListenerClassTimeoutWithDuration(String id, String fullQualifiedClassName, String timerDuration) {
    return createFlowaveTaskListenerClassTimeout(id, fullQualifiedClassName, createTimeDuration(timerDuration));
  }

  public B flowaveTaskListenerExpressionTimeoutWithCycle(String id, String expression, String timerCycle) {
    return createFlowaveTaskListenerExpressionTimeout(id, expression, createTimeCycle(timerCycle));
  }

  public B flowaveTaskListenerExpressionTimeoutWithDate(String id, String expression, String timerDate) {
    return createFlowaveTaskListenerExpressionTimeout(id, expression, createTimeDate(timerDate));
  }

  public B flowaveTaskListenerExpressionTimeoutWithDuration(String id, String expression, String timerDuration) {
    return createFlowaveTaskListenerExpressionTimeout(id, expression, createTimeDuration(timerDuration));
  }

  public B flowaveTaskListenerDelegateExpressionTimeoutWithCycle(String id, String delegateExpression, String timerCycle) {
    return createFlowaveTaskListenerDelegateExpressionTimeout(id, delegateExpression, createTimeCycle(timerCycle));
  }

  public B flowaveTaskListenerDelegateExpressionTimeoutWithDate(String id, String delegateExpression, String timerDate) {
    return createFlowaveTaskListenerDelegateExpressionTimeout(id, delegateExpression, createTimeDate(timerDate));
  }

  public B flowaveTaskListenerDelegateExpressionTimeoutWithDuration(String id, String delegateExpression, String timerDuration) {
    return createFlowaveTaskListenerDelegateExpressionTimeout(id, delegateExpression, createTimeDuration(timerDuration));
  }

  protected B createFlowaveTaskListenerClassTimeout(String id, String fullQualifiedClassName, TimerEventDefinition timerDefinition) {
    FlowaveTaskListener executionListener = createFlowaveTaskListenerTimeout(id, timerDefinition);
    executionListener.setFlowaveClass(fullQualifiedClassName);
    return myself;
  }

  protected B createFlowaveTaskListenerExpressionTimeout(String id, String expression, TimerEventDefinition timerDefinition) {
    FlowaveTaskListener executionListener = createFlowaveTaskListenerTimeout(id, timerDefinition);
    executionListener.setFlowaveExpression(expression);
    return myself;
  }

  protected B createFlowaveTaskListenerDelegateExpressionTimeout(String id, String delegateExpression, TimerEventDefinition timerDefinition) {
    FlowaveTaskListener executionListener = createFlowaveTaskListenerTimeout(id, timerDefinition);
    executionListener.setFlowaveDelegateExpression(delegateExpression);
    return myself;
  }

  protected FlowaveTaskListener createFlowaveTaskListenerTimeout(String id, TimerEventDefinition timerDefinition) {
    FlowaveTaskListener executionListener = createInstance(FlowaveTaskListener.class);
    executionListener.setAttributeValue(BpmnModelConstants.BPMN_ATTRIBUTE_ID, id, true);
    executionListener.setFlowaveEvent("timeout");
    executionListener.addChildElement(timerDefinition);
    addExtensionElement(executionListener);
    return executionListener;
  }
}
