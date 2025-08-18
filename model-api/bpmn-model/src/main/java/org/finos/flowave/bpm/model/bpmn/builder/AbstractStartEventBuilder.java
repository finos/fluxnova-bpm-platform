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

import org.finos.flowave.bpm.model.bpmn.BpmnModelInstance;
import org.finos.flowave.bpm.model.bpmn.instance.CompensateEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.ErrorEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.EscalationEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.StartEvent;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormData;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormField;

/**
 * @author Sebastian Menski
 */
public abstract class AbstractStartEventBuilder<B extends AbstractStartEventBuilder<B>> extends AbstractCatchEventBuilder<B, StartEvent> {

  protected AbstractStartEventBuilder(BpmnModelInstance modelInstance, StartEvent element, Class<?> selfType) {
    super(modelInstance, element, selfType);
  }

  /** camunda extensions */

  /**
   * @deprecated use camundaAsyncBefore() instead.
   *
   * Sets the camunda async attribute to true.
   *
   * @return the builder object
   */
  @Deprecated
  public B flowaveAsync() {
    element.setFlowaveAsyncBefore(true);
    return myself;
  }

  /**
   * @deprecated use camundaAsyncBefore(isCamundaAsyncBefore) instead.
   *
   * Sets the camunda async attribute.
   *
   * @param isCamundaAsync  the async state of the task
   * @return the builder object
   */
  @Deprecated
  public B flowaveAsync(boolean isCamundaAsync) {
    element.setFlowaveAsyncBefore(isCamundaAsync);
    return myself;
  }

  /**
   * Sets the camunda form handler class attribute.
   *
   * @param camundaFormHandlerClass  the class name of the form handler
   * @return the builder object
   */
  public B flowaveFormHandlerClass(String camundaFormHandlerClass) {
    element.setFlowaveFormHandlerClass(camundaFormHandlerClass);
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
   * Sets the camunda initiator attribute.
   *
   * @param camundaInitiator  the initiator to set
   * @return the builder object
   */
  public B flowaveInitiator(String camundaInitiator) {
    element.setFlowaveInitiator(camundaInitiator);
    return myself;
  }

  /**
   * Creates a new camunda form field extension element.
   *
   * @return the builder object
   */
  public FlowaveStartEventFormFieldBuilder flowaveFormField() {
    FlowaveFormData camundaFormData = getCreateSingleExtensionElement(FlowaveFormData.class);
    FlowaveFormField camundaFormField = createChild(camundaFormData, FlowaveFormField.class);
    return new FlowaveStartEventFormFieldBuilder(modelInstance, element, camundaFormField);
  }

  /**
   * Sets a catch all error definition.
   *
   * @return the builder object
   */
  public B error() {
    ErrorEventDefinition errorEventDefinition = createInstance(ErrorEventDefinition.class);
    element.getEventDefinitions().add(errorEventDefinition);

    return myself;
  }

  /**
   * Sets an error definition for the given error code. If already an error
   * with this code exists it will be used, otherwise a new error is created.
   *
   * @param errorCode the code of the error
   * @return the builder object
   */
  public B error(String errorCode) {
    return error(errorCode, null);
  }

  /**
   * Sets an error definition for the given error code. If already an error
   * with this code exists it will be used, otherwise a new error is created
   * with the given errorMessage.
   *
   * @param errorCode the code of the error
   * @param errorMessage the error message that is used when a new error needs
   *        to be created
   * @return the builder object
   */
  public B error(String errorCode, String errorMessage) {
    ErrorEventDefinition errorEventDefinition = createErrorEventDefinition(errorCode, errorMessage);
    element.getEventDefinitions().add(errorEventDefinition);

    return myself;
  }

  /**
   * Creates an error event definition with an unique id
   * and returns a builder for the error event definition.
   *
   * @return the error event definition builder object
   */
  public ErrorEventDefinitionBuilder errorEventDefinition(String id) {
    ErrorEventDefinition errorEventDefinition = createEmptyErrorEventDefinition();
    if (id != null) {
      errorEventDefinition.setId(id);
    }

    element.getEventDefinitions().add(errorEventDefinition);
    return new ErrorEventDefinitionBuilder(modelInstance, errorEventDefinition);
  }

  /**
   * Creates an error event definition
   * and returns a builder for the error event definition.
   *
   * @return the error event definition builder object
   */
  public ErrorEventDefinitionBuilder errorEventDefinition() {
    ErrorEventDefinition errorEventDefinition = createEmptyErrorEventDefinition();
    element.getEventDefinitions().add(errorEventDefinition);
    return new ErrorEventDefinitionBuilder(modelInstance, errorEventDefinition);
  }

  /**
   * Sets a catch all escalation definition.
   *
   * @return the builder object
   */
  public B escalation() {
    EscalationEventDefinition escalationEventDefinition = createInstance(EscalationEventDefinition.class);
    element.getEventDefinitions().add(escalationEventDefinition);

    return myself;
  }

  /**
   * Sets an escalation definition for the given escalation code. If already an escalation
   * with this code exists it will be used, otherwise a new escalation is created.
   *
   * @param escalationCode the code of the escalation
   * @return the builder object
   */
  public B escalation(String escalationCode) {
    EscalationEventDefinition escalationEventDefinition = createEscalationEventDefinition(escalationCode);
    element.getEventDefinitions().add(escalationEventDefinition);

    return myself;
  }

  /**
   * Sets a catch compensation definition.
   *
   * @return the builder object
   */
  public B compensation() {
    CompensateEventDefinition compensateEventDefinition = createCompensateEventDefinition();
    element.getEventDefinitions().add(compensateEventDefinition);

    return myself;
  }

  /**
   * Sets whether the start event is interrupting or not.
   */
  public B interrupting(boolean interrupting) {
    element.setInterrupting(interrupting);

    return myself;
  }

}
