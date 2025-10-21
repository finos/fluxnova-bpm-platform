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

import java.util.List;

import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants;
import org.finos.fluxnova.bpm.model.bpmn.instance.TimerEventDefinition;
import org.finos.fluxnova.bpm.model.bpmn.instance.UserTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFormData;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFormField;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaTaskListener;

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
  public B fluxnovaAssignee(String camundaAssignee) {
    element.setFluxnovaAssignee(camundaAssignee);
    return myself;
  }

  /**
   * Sets the camunda candidate groups attribute.
   *
   * @param camundaCandidateGroups  the candidate groups to set
   * @return the builder object
   */
  public B fluxnovaCandidateGroups(String camundaCandidateGroups) {
    element.setFluxnovaCandidateGroups(camundaCandidateGroups);
    return myself;
  }

  /**
   * Sets the camunda candidate groups attribute.
   *
   * @param camundaCandidateGroups  the candidate groups to set
   * @return the builder object
   */
  public B fluxnovaCandidateGroups(List<String> camundaCandidateGroups) {
    element.setFluxnovaCandidateGroupsList(camundaCandidateGroups);
    return myself;
  }

  /**
   * Sets the camunda candidate users attribute.
   *
   * @param camundaCandidateUsers  the candidate users to set
   * @return the builder object
   */
  public B fluxnovaCandidateUsers(String camundaCandidateUsers) {
    element.setFluxnovaCandidateUsers(camundaCandidateUsers);
    return myself;
  }

  /**
   * Sets the camunda candidate users attribute.
   *
   * @param camundaCandidateUsers  the candidate users to set
   * @return the builder object
   */
  public B fluxnovaCandidateUsers(List<String> camundaCandidateUsers) {
    element.setFluxnovaCandidateUsersList(camundaCandidateUsers);
    return myself;
  }

  /**
   * Sets the camunda due date attribute.
   *
   * @param camundaDueDate  the due date of the user task
   * @return the builder object
   */
  public B fluxnovaDueDate(String camundaDueDate) {
    element.setFluxnovaDueDate(camundaDueDate);
    return myself;
  }

  /**
   * Sets the camunda follow up date attribute.
   *
   * @param camundaFollowUpDate  the follow up date of the user task
   * @return the builder object
   */
  public B fluxnovaFollowUpDate(String camundaFollowUpDate) {
    element.setFluxnovaFollowUpDate(camundaFollowUpDate);
    return myself;
  }

  /**
   * Sets the camunda form handler class attribute.
   *
   * @param camundaFormHandlerClass  the class name of the form handler
   * @return the builder object
   */
  @SuppressWarnings("rawtypes")
  public B fluxnovaFormHandlerClass(Class camundaFormHandlerClass) {
    return fluxnovaFormHandlerClass(camundaFormHandlerClass.getName());
  }

  /**
   * Sets the camunda form handler class attribute.
   *
   * @param fullQualifiedClassName  the class name of the form handler
   * @return the builder object
   */
  public B fluxnovaFormHandlerClass(String fullQualifiedClassName) {
    element.setFluxnovaFormHandlerClass(fullQualifiedClassName);
    return myself;
  }

  /**
   * Sets the camunda form key attribute.
   *
   * @param camundaFormKey  the form key to set
   * @return the builder object
   */
  public B fluxnovaFormKey(String camundaFormKey) {
    element.setFluxnovaFormKey(camundaFormKey);
    return myself;
  }

  /**
   * Sets the camunda form ref attribute.
   *
   * @param fluxnovaFormRef the form ref to set
   * @return the builder object
   */
  public B fluxnovaFormRef(String fluxnovaFormRef) {
    element.setFluxnovaFormRef(fluxnovaFormRef);
    return myself;
  }

  /**
   * Sets the camunda form ref binding attribute.
   *
   * @param fluxnovaFormRefBinding the form ref binding to set
   * @return the builder object
   */
  public B fluxnovaFormRefBinding(String fluxnovaFormRefBinding) {
    element.setFluxnovaFormRefBinding(fluxnovaFormRefBinding);
    return myself;
  }

  /**
   * Sets the camunda form ref version attribute.
   *
   * @param fluxnovaFormRefVersion the form ref version to set
   * @return the builder object
   */
  public B fluxnovaFormRefVersion(String fluxnovaFormRefVersion) {
    element.setFluxnovaFormRefVersion(fluxnovaFormRefVersion);
    return myself;
  }

  /**
   * Sets the camunda priority attribute.
   *
   * @param camundaPriority  the priority of the user task
   * @return the builder object
   */
  public B fluxnovaPriority(String camundaPriority) {
    element.setFluxnovaPriority(camundaPriority);
    return myself;
  }

  /**
   * Creates a new camunda form field extension element.
   *
   * @return the builder object
   */
  public FluxnovaUserTaskFormFieldBuilder fluxnovaFormField() {
    FluxnovaFormData camundaFormData = getCreateSingleExtensionElement(FluxnovaFormData.class);
    FluxnovaFormField camundaFormField = createChild(camundaFormData, FluxnovaFormField.class);
    return new FluxnovaUserTaskFormFieldBuilder(modelInstance, element, camundaFormField);
  }

  /**
   * Add a class based task listener with specified event name
   *
   * @param eventName - event names to listen to
   * @param listenerClass - a class
   * @return the builder object
   */
  @SuppressWarnings("rawtypes")
  public B fluxnovaTaskListenerClass(String eventName, Class listenerClass) {
    return fluxnovaTaskListenerClass(eventName, listenerClass.getName());
  }

  /**
   * Add a class based task listener with specified event name
   *
   * @param eventName - event names to listen to
   * @param fullQualifiedClassName - a string representing a class
   * @return the builder object
   */
  public B fluxnovaTaskListenerClass(String eventName, String fullQualifiedClassName) {
    FluxnovaTaskListener executionListener = createInstance(FluxnovaTaskListener.class);
    executionListener.setFluxnovaEvent(eventName);
    executionListener.setFluxnovaClass(fullQualifiedClassName);

    addExtensionElement(executionListener);

    return myself;
  }

  public B fluxnovaTaskListenerExpression(String eventName, String expression) {
    FluxnovaTaskListener executionListener = createInstance(FluxnovaTaskListener.class);
    executionListener.setFluxnovaEvent(eventName);
    executionListener.setFluxnovaExpression(expression);

    addExtensionElement(executionListener);

    return myself;
  }

  public B fluxnovaTaskListenerDelegateExpression(String eventName, String delegateExpression) {
    FluxnovaTaskListener executionListener = createInstance(FluxnovaTaskListener.class);
    executionListener.setFluxnovaEvent(eventName);
    executionListener.setFluxnovaDelegateExpression(delegateExpression);

    addExtensionElement(executionListener);

    return myself;
  }

  @SuppressWarnings("rawtypes")
  public B fluxnovaTaskListenerClassTimeoutWithCycle(String id, Class listenerClass, String timerCycle) {
    return fluxnovaTaskListenerClassTimeoutWithCycle(id, listenerClass.getName(), timerCycle);
  }

  @SuppressWarnings("rawtypes")
  public B fluxnovaTaskListenerClassTimeoutWithDate(String id, Class listenerClass, String timerDate) {
    return fluxnovaTaskListenerClassTimeoutWithDate(id, listenerClass.getName(), timerDate);
  }

  @SuppressWarnings("rawtypes")
  public B fluxnovaTaskListenerClassTimeoutWithDuration(String id, Class listenerClass, String timerDuration) {
    return fluxnovaTaskListenerClassTimeoutWithDuration(id, listenerClass.getName(), timerDuration);
  }

  public B fluxnovaTaskListenerClassTimeoutWithCycle(String id, String fullQualifiedClassName, String timerCycle) {
    return createFluxnovaTaskListenerClassTimeout(id, fullQualifiedClassName, createTimeCycle(timerCycle));
  }

  public B fluxnovaTaskListenerClassTimeoutWithDate(String id, String fullQualifiedClassName, String timerDate) {
    return createFluxnovaTaskListenerClassTimeout(id, fullQualifiedClassName, createTimeDate(timerDate));
  }

  public B fluxnovaTaskListenerClassTimeoutWithDuration(String id, String fullQualifiedClassName, String timerDuration) {
    return createFluxnovaTaskListenerClassTimeout(id, fullQualifiedClassName, createTimeDuration(timerDuration));
  }

  public B fluxnovaTaskListenerExpressionTimeoutWithCycle(String id, String expression, String timerCycle) {
    return createFluxnovaTaskListenerExpressionTimeout(id, expression, createTimeCycle(timerCycle));
  }

  public B fluxnovaTaskListenerExpressionTimeoutWithDate(String id, String expression, String timerDate) {
    return createFluxnovaTaskListenerExpressionTimeout(id, expression, createTimeDate(timerDate));
  }

  public B fluxnovaTaskListenerExpressionTimeoutWithDuration(String id, String expression, String timerDuration) {
    return createFluxnovaTaskListenerExpressionTimeout(id, expression, createTimeDuration(timerDuration));
  }

  public B fluxnovaTaskListenerDelegateExpressionTimeoutWithCycle(String id, String delegateExpression, String timerCycle) {
    return createFluxnovaTaskListenerDelegateExpressionTimeout(id, delegateExpression, createTimeCycle(timerCycle));
  }

  public B fluxnovaTaskListenerDelegateExpressionTimeoutWithDate(String id, String delegateExpression, String timerDate) {
    return createFluxnovaTaskListenerDelegateExpressionTimeout(id, delegateExpression, createTimeDate(timerDate));
  }

  public B fluxnovaTaskListenerDelegateExpressionTimeoutWithDuration(String id, String delegateExpression, String timerDuration) {
    return createFluxnovaTaskListenerDelegateExpressionTimeout(id, delegateExpression, createTimeDuration(timerDuration));
  }

  protected B createFluxnovaTaskListenerClassTimeout(String id, String fullQualifiedClassName, TimerEventDefinition timerDefinition) {
    FluxnovaTaskListener executionListener = createFluxnovaTaskListenerTimeout(id, timerDefinition);
    executionListener.setFluxnovaClass(fullQualifiedClassName);
    return myself;
  }

  protected B createFluxnovaTaskListenerExpressionTimeout(String id, String expression, TimerEventDefinition timerDefinition) {
    FluxnovaTaskListener executionListener = createFluxnovaTaskListenerTimeout(id, timerDefinition);
    executionListener.setFluxnovaExpression(expression);
    return myself;
  }

  protected B createFluxnovaTaskListenerDelegateExpressionTimeout(String id, String delegateExpression, TimerEventDefinition timerDefinition) {
    FluxnovaTaskListener executionListener = createFluxnovaTaskListenerTimeout(id, timerDefinition);
    executionListener.setFluxnovaDelegateExpression(delegateExpression);
    return myself;
  }

  protected FluxnovaTaskListener createFluxnovaTaskListenerTimeout(String id, TimerEventDefinition timerDefinition) {
    FluxnovaTaskListener executionListener = createInstance(FluxnovaTaskListener.class);
    executionListener.setAttributeValue(BpmnModelConstants.BPMN_ATTRIBUTE_ID, id, true);
    executionListener.setFluxnovaEvent("timeout");
    executionListener.addChildElement(timerDefinition);
    addExtensionElement(executionListener);
    return executionListener;
  }
}
