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
import org.finos.flowave.bpm.model.bpmn.instance.CallActivity;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveIn;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveOut;

/**
 * @author Sebastian Menski
 */
public class AbstractCallActivityBuilder<B extends AbstractCallActivityBuilder<B>> extends AbstractActivityBuilder<B, CallActivity> {

  protected AbstractCallActivityBuilder(BpmnModelInstance modelInstance, CallActivity element, Class<?> selfType) {
    super(modelInstance, element, selfType);
  }

  /**
   * Sets the called element
   *
   * @param calledElement  the process to call
   * @return the builder object
   */
  public B calledElement(String calledElement) {
    element.setCalledElement(calledElement);
    return myself;
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
   * @deprecated use camundaAsyncBefore(isCamundaAsyncBefore) instead
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
   * Sets the camunda calledElementBinding attribute
   *
   * @param camundaCalledElementBinding  the element binding to use
   * @return the builder object
   */
  public B flowaveCalledElementBinding(String camundaCalledElementBinding) {
    element.setFlowaveCalledElementBinding(camundaCalledElementBinding);
    return myself;
  }

  /**
   * Sets the camunda calledElementVersion attribute
   *
   * @param camundaCalledElementVersion  the element version to use
   * @return the builder object
   */
  public B flowaveCalledElementVersion(String camundaCalledElementVersion) {
    element.setFlowaveCalledElementVersion(camundaCalledElementVersion);
    return myself;
  }

  /**
   * Sets the camunda calledElementVersionTag attribute
   *
   * @param camundaCalledElementVersionTag  the element version to use
   * @return the builder object
   */
  public B flowaveCalledElementVersionTag(String camundaCalledElementVersionTag) {
    element.setFlowaveCalledElementVersionTag(camundaCalledElementVersionTag);
    return myself;
  }

  /**
   * Sets the camunda calledElementTenantId attribute
   * @param camundaCalledElementTenantId the called element tenant id
   * @return the builder object
   */
  public B flowaveCalledElementTenantId(String camundaCalledElementTenantId) {
    element.setFlowaveCalledElementTenantId(camundaCalledElementTenantId);
    return myself;
  }

  /**
   * Sets the camunda caseRef attribute
   *
   * @param caseRef the case to call
   * @return the builder object
   */
  public B flowaveCaseRef(String caseRef) {
    element.setFlowaveCaseRef(caseRef);
    return myself;
  }

  /**
   * Sets the camunda caseBinding attribute
   *
   * @param camundaCaseBinding  the case binding to use
   * @return the builder object
   */
  public B flowaveCaseBinding(String camundaCaseBinding) {
    element.setFlowaveCaseBinding(camundaCaseBinding);
    return myself;
  }

  /**
   * Sets the camunda caseVersion attribute
   *
   * @param camundaCaseVersion  the case version to use
   * @return the builder object
   */
  public B flowaveCaseVersion(String camundaCaseVersion) {
    element.setFlowaveCaseVersion(camundaCaseVersion);
    return myself;
  }

  /**
   * Sets the caseTenantId
   * @param tenantId the tenant id to set
   * @return the builder object
   */
  public B flowaveCaseTenantId(String tenantId) {
    element.setFlowaveCaseTenantId(tenantId);
    return myself;
  }

  /**
   * Sets a "camunda in" parameter to pass a business key from the super process instance to the sub process instance
   * @param businessKey the business key to set
   * @return the builder object
   */
  public B flowaveInBusinessKey(String businessKey) {
    FlowaveIn param = modelInstance.newInstance(FlowaveIn.class);
    param.setFlowaveBusinessKey(businessKey);
    addExtensionElement(param);
    return myself;
  }

  /**
   * Sets a "camunda in" parameter to pass a variable from the super process instance to the sub process instance
   *
   * @param source the name of variable in the super process instance
   * @param target the name of the variable in the sub process instance
   * @return the builder object
   */
  public B flowaveIn(String source, String target) {
    FlowaveIn param = modelInstance.newInstance(FlowaveIn.class);
    param.setFlowaveSource(source);
    param.setFlowaveTarget(target);
    addExtensionElement(param);
    return myself;
  }

  /**
   * Sets a "camunda out" parameter to pass a variable from a sub process instance to the super process instance
   *
   * @param source the name of variable in the sub process instance
   * @param target the name of the variable in the super process instance
   * @return the builder object
   */
  public B flowaveOut(String source, String target) {
    FlowaveOut param = modelInstance.newInstance(FlowaveOut.class);
    param.setFlowaveSource(source);
    param.setFlowaveTarget(target);
    addExtensionElement(param);
    return myself;
  }

  /**
   * Sets the camunda variableMappingClass attribute. It references on a class which implements the
   * {@link DelegateVariableMapping} interface.
   * Is used to delegate the variable in- and output mapping to the given class.
   *
   * @param camundaVariableMappingClass                  the class name to set
   * @return                              the builder object
   */
  @SuppressWarnings("rawtypes")
  public B flowaveVariableMappingClass(Class camundaVariableMappingClass) {
    return flowaveVariableMappingClass(camundaVariableMappingClass.getName());
  }

  /**
   * Sets the camunda variableMappingClass attribute. It references on a class which implements the
   * {@link DelegateVariableMapping} interface.
   * Is used to delegate the variable in- and output mapping to the given class.
   *
   * @param camundaVariableMappingClass                  the class name to set
   * @return                              the builder object
   */
  public B flowaveVariableMappingClass(String fullQualifiedClassName) {
    element.setFlowaveVariableMappingClass(fullQualifiedClassName);
    return myself;
  }

  /**
   * Sets the camunda variableMappingDelegateExpression attribute. The expression when is resolved
   * references to an object of a class, which implements the {@link DelegateVariableMapping} interface.
   * Is used to delegate the variable in- and output mapping to the given class.
   *
   * @param camundaVariableMappingDelegateExpression     the expression which references a delegate object
   * @return                              the builder object
   */
  public B flowaveVariableMappingDelegateExpression(String camundaVariableMappingDelegateExpression) {
    element.setFlowaveVariableMappingDelegateExpression(camundaVariableMappingDelegateExpression);
    return myself;
  }
}
