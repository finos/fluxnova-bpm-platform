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
package org.finos.fluxnova.bpm.model.bpmn.impl.instance;

import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.BPMN20_NS;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.BPMN_ATTRIBUTE_IMPLEMENTATION;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.BPMN_ELEMENT_BUSINESS_RULE_TASK;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_CLASS;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_DECISION_REF;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_DECISION_REF_BINDING;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_DECISION_REF_VERSION;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_DELEGATE_EXPRESSION;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.*;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_MAP_DECISION_RESULT;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_RESULT_VARIABLE;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_TOPIC;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_TYPE;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.finos.fluxnova.bpm.model.bpmn.builder.BusinessRuleTaskBuilder;
import org.finos.fluxnova.bpm.model.bpmn.instance.BusinessRuleTask;
import org.finos.fluxnova.bpm.model.bpmn.instance.Rendering;
import org.finos.fluxnova.bpm.model.bpmn.instance.Task;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.fluxnova.bpm.model.xml.type.attribute.Attribute;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElementCollection;

/**
 * The BPMN businessRuleTask element
 *
 * @author Sebastian Menski
 */
public class BusinessRuleTaskImpl extends TaskImpl implements BusinessRuleTask {

  protected static Attribute<String> implementationAttribute;
  protected static ChildElementCollection<Rendering> renderingCollection;

  /** camunda extensions */

  protected static Attribute<String> camundaClassAttribute;
  protected static Attribute<String> camundaDelegateExpressionAttribute;
  protected static Attribute<String> camundaExpressionAttribute;
  protected static Attribute<String> camundaResultVariableAttribute;
  protected static Attribute<String> camundaTopicAttribute;
  protected static Attribute<String> camundaTypeAttribute;
  protected static Attribute<String> camundaDecisionRefAttribute;
  protected static Attribute<String> camundaDecisionRefBindingAttribute;
  protected static Attribute<String> camundaDecisionRefVersionAttribute;
  protected static Attribute<String> camundaDecisionRefVersionTagAttribute;
  protected static Attribute<String> camundaDecisionRefTenantIdAttribute;
  protected static Attribute<String> camundaMapDecisionResultAttribute;
  protected static Attribute<String> camundaTaskPriorityAttribute;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(BusinessRuleTask.class, BPMN_ELEMENT_BUSINESS_RULE_TASK)
      .namespaceUri(BPMN20_NS)
      .extendsType(Task.class)
      .instanceProvider(new ModelTypeInstanceProvider<BusinessRuleTask>() {
        public BusinessRuleTask newInstance(ModelTypeInstanceContext instanceContext) {
          return new BusinessRuleTaskImpl(instanceContext);
        }
      });

    implementationAttribute = typeBuilder.stringAttribute(BPMN_ATTRIBUTE_IMPLEMENTATION)
      .defaultValue("##unspecified")
      .build();

    /** camunda extensions */

    camundaClassAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_CLASS)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDelegateExpressionAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DELEGATE_EXPRESSION)
      .namespace(CAMUNDA_NS)
      .build();

    camundaExpressionAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_EXPRESSION)
      .namespace(CAMUNDA_NS)
      .build();

    camundaResultVariableAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_RESULT_VARIABLE)
      .namespace(CAMUNDA_NS)
      .build();

    camundaTopicAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_TOPIC)
      .namespace(CAMUNDA_NS)
      .build();

    camundaTypeAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_TYPE)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDecisionRefAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DECISION_REF)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDecisionRefBindingAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DECISION_REF_BINDING)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDecisionRefVersionAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DECISION_REF_VERSION)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDecisionRefVersionTagAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DECISION_REF_VERSION_TAG)
        .namespace(CAMUNDA_NS)
        .build();

    camundaDecisionRefTenantIdAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DECISION_REF_TENANT_ID)
      .namespace(CAMUNDA_NS)
      .build();

    camundaMapDecisionResultAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_MAP_DECISION_RESULT)
        .namespace(CAMUNDA_NS)
        .build();

    camundaTaskPriorityAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_TASK_PRIORITY)
      .namespace(CAMUNDA_NS)
      .build();

    typeBuilder.build();
  }

  public BusinessRuleTaskImpl(ModelTypeInstanceContext context) {
    super(context);
  }

  @Override
  public BusinessRuleTaskBuilder builder() {
    return new BusinessRuleTaskBuilder((BpmnModelInstance) modelInstance, this);
  }

  public String getImplementation() {
    return implementationAttribute.getValue(this);
  }

  public void setImplementation(String implementation) {
    implementationAttribute.setValue(this, implementation);
  }

  /** camunda extensions */

  public String getFluxnovaClass() {
    return camundaClassAttribute.getValue(this);
  }

  public void setFluxnovaClass(String camundaClass) {
    camundaClassAttribute.setValue(this, camundaClass);
  }

  public String getFluxnovaDelegateExpression() {
    return camundaDelegateExpressionAttribute.getValue(this);
  }

  public void setFluxnovaDelegateExpression(String camundaExpression) {
    camundaDelegateExpressionAttribute.setValue(this, camundaExpression);
  }

  public String getFluxnovaExpression() {
    return camundaExpressionAttribute.getValue(this);
  }

  public void setFluxnovaExpression(String camundaExpression) {
    camundaExpressionAttribute.setValue(this, camundaExpression);
  }

  public String getFluxnovaResultVariable() {
    return camundaResultVariableAttribute.getValue(this);
  }

  public void setFluxnovaResultVariable(String camundaResultVariable) {
    camundaResultVariableAttribute.setValue(this, camundaResultVariable);
  }

  public String getFluxnovaTopic() {
    return camundaTopicAttribute.getValue(this);
  }

  public void setFluxnovaTopic(String camundaTopic) {
    camundaTopicAttribute.setValue(this, camundaTopic);
  }

  public String getFluxnovaType() {
    return camundaTypeAttribute.getValue(this);
  }

  public void setFluxnovaType(String camundaType) {
    camundaTypeAttribute.setValue(this, camundaType);
  }

  public String getFluxnovaDecisionRef() {
    return camundaDecisionRefAttribute.getValue(this);
  }

  public void setFluxnovaDecisionRef(String camundaDecisionRef) {
    camundaDecisionRefAttribute.setValue(this, camundaDecisionRef);
  }

  public String getFluxnovaDecisionRefBinding() {
    return camundaDecisionRefBindingAttribute.getValue(this);
  }

  public void setFluxnovaDecisionRefBinding(String camundaDecisionRefBinding) {
    camundaDecisionRefBindingAttribute.setValue(this, camundaDecisionRefBinding);
  }

  public String getFluxnovaDecisionRefVersion() {
    return camundaDecisionRefVersionAttribute.getValue(this);
  }

  public void setFluxnovaDecisionRefVersion(String camundaDecisionRefVersion) {
    camundaDecisionRefVersionAttribute.setValue(this, camundaDecisionRefVersion);
  }

  public String getFluxnovaDecisionRefVersionTag() {
    return camundaDecisionRefVersionTagAttribute.getValue(this);
  }

  public void setFluxnovaDecisionRefVersionTag(String camundaDecisionRefVersionTag) {
    camundaDecisionRefVersionTagAttribute.setValue(this, camundaDecisionRefVersionTag);
  }

  @Override
  public String getFluxnovaMapDecisionResult() {
    return camundaMapDecisionResultAttribute.getValue(this);
  }

  @Override
  public void setFluxnovaMapDecisionResult(String camundaMapDecisionResult) {
    camundaMapDecisionResultAttribute.setValue(this, camundaMapDecisionResult);
  }

  public String getFluxnovaDecisionRefTenantId() {
    return camundaDecisionRefTenantIdAttribute.getValue(this);
  }

  public void setFluxnovaDecisionRefTenantId(String tenantId) {
    camundaDecisionRefTenantIdAttribute.setValue(this, tenantId);
  }

  @Override
  public String getFluxnovaTaskPriority() {
    return camundaTaskPriorityAttribute.getValue(this);
  }

  @Override
  public void setFluxnovaTaskPriority(String taskPriority) {
    camundaTaskPriorityAttribute.setValue(this, taskPriority);
  }
}
