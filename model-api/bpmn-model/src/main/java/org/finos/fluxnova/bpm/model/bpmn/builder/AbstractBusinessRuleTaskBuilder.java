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

import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.finos.fluxnova.bpm.model.bpmn.instance.BusinessRuleTask;

/**
 * @author Sebastian Menski
 */
public abstract class AbstractBusinessRuleTaskBuilder<B extends AbstractBusinessRuleTaskBuilder<B>> extends AbstractTaskBuilder<B, BusinessRuleTask> {

  protected AbstractBusinessRuleTaskBuilder(BpmnModelInstance modelInstance, BusinessRuleTask element, Class<?> selfType) {
    super(modelInstance, element, selfType);
  }

  /**
   * Sets the implementation of the business rule task.
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
  public B fluxnovaClass(Class camundaClass) {
    return fluxnovaClass(camundaClass.getName());
  }

  /**
   * Sets the camunda class attribute.
   *
   * @param camundaClass  the class name to set
   * @return the builder object
   */
  public B fluxnovaClass(String fullQualifiedClassName) {
    element.setFluxnovaClass(fullQualifiedClassName);
    return myself;
  }

  /**
   * Sets the camunda delegateExpression attribute.
   *
   * @param camundaExpression  the delegateExpression to set
   * @return the builder object
   */
  public B fluxnovaDelegateExpression(String camundaExpression) {
    element.setFluxnovaDelegateExpression(camundaExpression);
    return myself;
  }

  /**
   * Sets the camunda expression attribute.
   *
   * @param camundaExpression  the expression to set
   * @return the builder object
   */
  public B fluxnovaExpression(String camundaExpression) {
    element.setFluxnovaExpression(camundaExpression);
    return myself;
  }

  /**
   * Sets the camunda resultVariable attribute.
   *
   * @param camundaResultVariable  the name of the process variable
   * @return the builder object
   */
  public B fluxnovaResultVariable(String camundaResultVariable) {
    element.setFluxnovaResultVariable(camundaResultVariable);
    return myself;
  }

  /**
   * Sets the camunda topic attribute. This is only meaningful when
   * the {@link #fluxnovaType(String)} attribute has the value <code>external</code>.
   *
   * @param camundaTopic the topic to set
   * @return the builder object
   */
  public B fluxnovaTopic(String camundaTopic) {
    element.setFluxnovaTopic(camundaTopic);
    return myself;
  }

  /**
   * Sets the camunda type attribute.
   *
   * @param camundaType  the type of the service task
   * @return the builder object
   */
  public B fluxnovaType(String camundaType) {
    element.setFluxnovaType(camundaType);
    return myself;
  }

  /**
   * Sets the camunda decisionRef attribute.
   *
   * @param camundaDecisionRef the decisionRef to set
   * @return the builder object
   */
  public B fluxnovaDecisionRef(String camundaDecisionRef) {
    element.setFluxnovaDecisionRef(camundaDecisionRef);
    return myself;
  }

  /**
   * Sets the camunda decisionRefBinding attribute.
   *
   * @param camundaDecisionRefBinding the decisionRefBinding to set
   * @return the builder object
   */
  public B fluxnovaDecisionRefBinding(String camundaDecisionRefBinding) {
    element.setFluxnovaDecisionRefBinding(camundaDecisionRefBinding);
    return myself;
  }

  /**
   * Sets the camunda decisionRefVersion attribute.
   *
   * @param camundaDecisionRefVersion the decisionRefVersion to set
   * @return the builder object
   */
  public B fluxnovaDecisionRefVersion(String camundaDecisionRefVersion) {
    element.setFluxnovaDecisionRefVersion(camundaDecisionRefVersion);
    return myself;
  }

  /**
   * Sets the camunda decisionRefVersionTag attribute.
   *
   * @param camundaDecisionRefVersionTag the decisionRefVersionTag to set
   * @return the builder object
   */
  public B fluxnovaDecisionRefVersionTag(String camundaDecisionRefVersionTag) {
    element.setFluxnovaDecisionRefVersionTag(camundaDecisionRefVersionTag);
    return myself;
  }

  /**
   * Sets the camunda decisionRefTenantId attribute.
   *
   * @param decisionRefTenantId the decisionRefTenantId to set
   * @return the builder object
   */
  public B fluxnovaDecisionRefTenantId(String decisionRefTenantId) {
    element.setFluxnovaDecisionRefTenantId(decisionRefTenantId);
    return myself;
  }

  /**
   * Set the camunda mapDecisionResult attribute.
   *
   * @param camundaMapDecisionResult the mapper for the decision result to set
   * @return the builder object
   */
  public B fluxnovaMapDecisionResult(String camundaMapDecisionResult) {
    element.setFluxnovaMapDecisionResult(camundaMapDecisionResult);
    return myself;
  }

  /**
   * Sets the camunda task priority attribute. This is only meaningful when
   * the {@link #fluxnovaType(String)} attribute has the value <code>external</code>.
   *
   *
   * @param taskPriority the priority for the external task
   * @return the builder object
   */
  public B fluxnovaTaskPriority(String taskPriority) {
    element.setFluxnovaTaskPriority(taskPriority);
    return myself;
  }
}
