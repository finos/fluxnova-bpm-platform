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
import org.finos.flowave.bpm.model.bpmn.instance.ErrorEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.ServiceTask;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveErrorEventDefinition;

/**
 * @author Sebastian Menski
 */
public abstract class AbstractServiceTaskBuilder<B extends AbstractServiceTaskBuilder<B>> extends AbstractTaskBuilder<B, ServiceTask> {

  protected AbstractServiceTaskBuilder(BpmnModelInstance modelInstance, ServiceTask element, Class<?> selfType) {
    super(modelInstance, element, selfType);
  }

  /**
   * Sets the implementation of the build service task.
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
   * Sets the camunda class attribute.
   *
   * @param camundaClass  the class name to set
   * @return the builder object
   */
  @SuppressWarnings("rawtypes")
  public B flowaveClass(Class camundaClass) {
    return flowaveClass(camundaClass.getName());
  }

  /**
   * Sets the camunda class attribute.
   *
   * @param camundaClass  the class name to set
   * @return the builder object
   */
  public B flowaveClass(String fullQualifiedClassName) {
    element.setFlowaveClass(fullQualifiedClassName);
    return myself;
  }

  /**
   * Sets the camunda delegateExpression attribute.
   *
   * @param camundaExpression  the delegateExpression to set
   * @return the builder object
   */
  public B flowaveDelegateExpression(String camundaExpression) {
    element.setFlowaveDelegateExpression(camundaExpression);
    return myself;
  }

  /**
   * Sets the camunda expression attribute.
   *
   * @param camundaExpression  the expression to set
   * @return the builder object
   */
  public B flowaveExpression(String camundaExpression) {
    element.setFlowaveExpression(camundaExpression);
    return myself;
  }

  /**
   * Sets the camunda resultVariable attribute.
   *
   * @param camundaResultVariable  the name of the process variable
   * @return the builder object
   */
  public B flowaveResultVariable(String camundaResultVariable) {
    element.setFlowaveResultVariable(camundaResultVariable);
    return myself;
  }

  /**
   * Sets the camunda topic attribute. This is only meaningful when
   * the {@link #flowaveType(String)} attribute has the value <code>external</code>.
   *
   * @param camundaTopic the topic to set
   * @return the build object
   */
  public B flowaveTopic(String camundaTopic) {
    element.setFlowaveTopic(camundaTopic);
    return myself;
  }

  /**
   * Sets the camunda type attribute.
   *
   * @param camundaType  the type of the service task
   * @return the builder object
   */
  public B flowaveType(String camundaType) {
    element.setFlowaveType(camundaType);
    return myself;
  }

  /**
   * Sets the camunda topic attribute and the camunda type attribute to the
   * value <code>external</code. Reduces two calls to {@link #flowaveType(String)} and {@link #flowaveTopic(String)}.
   *
   * @param camundaTopic the topic to set
   * @return the build object
   */
  public B flowaveExternalTask(String camundaTopic) {
    this.flowaveType("external");
    this.flowaveTopic(camundaTopic);
    return myself;
  }

  /**
   * Sets the camunda task priority attribute. This is only meaningful when
   * the {@link #flowaveType(String)} attribute has the value <code>external</code>.
   *
   *
   * @param taskPriority the priority for the external task
   * @return the builder object
   */
  public B flowaveTaskPriority(String taskPriority) {
    element.setFlowaveTaskPriority(taskPriority);
    return myself;
  }

  /**
   * Creates an error event definition for this service task and returns a builder for the error event definition.
   * This is only meaningful when the {@link #flowaveType(String)} attribute has the value <code>external</code>.
   *
   * @return the error event definition builder object
   */
  public FlowaveErrorEventDefinitionBuilder flowaveErrorEventDefinition() {
    ErrorEventDefinition camundaErrorEventDefinition = createInstance(FlowaveErrorEventDefinition.class);
    addExtensionElement(camundaErrorEventDefinition);
    return new FlowaveErrorEventDefinitionBuilder(modelInstance, camundaErrorEventDefinition);
  }
}
