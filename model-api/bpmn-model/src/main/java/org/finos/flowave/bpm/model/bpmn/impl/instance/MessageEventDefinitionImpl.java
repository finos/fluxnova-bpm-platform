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
package org.finos.flowave.bpm.model.bpmn.impl.instance;

import org.finos.flowave.bpm.model.bpmn.instance.EventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.Message;
import org.finos.flowave.bpm.model.bpmn.instance.MessageEventDefinition;
import org.finos.flowave.bpm.model.bpmn.instance.Operation;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.attribute.Attribute;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;
import org.finos.flowave.bpm.model.xml.type.reference.AttributeReference;
import org.finos.flowave.bpm.model.xml.type.reference.ElementReference;

import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.*;

/**
*
* @author Sebastian Menski
*
*/
public class MessageEventDefinitionImpl extends EventDefinitionImpl implements MessageEventDefinition {

  protected static AttributeReference<Message> messageRefAttribute;
  protected static ElementReference<Operation, OperationRef> operationRefChild;

  /** camunda extensions */

  protected static Attribute<String> camundaClassAttribute;
  protected static Attribute<String> camundaDelegateExpressionAttribute;
  protected static Attribute<String> camundaExpressionAttribute;
  protected static Attribute<String> camundaResultVariableAttribute;
  protected static Attribute<String> camundaTopicAttribute;
  protected static Attribute<String> camundaTypeAttribute;
  protected static Attribute<String> camundaTaskPriorityAttribute;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(MessageEventDefinition.class, BPMN_ELEMENT_MESSAGE_EVENT_DEFINITION)
      .namespaceUri(BPMN20_NS)
      .extendsType(EventDefinition.class)
      .instanceProvider(new ModelElementTypeBuilder.ModelTypeInstanceProvider<MessageEventDefinition>() {
        public MessageEventDefinition newInstance(ModelTypeInstanceContext instanceContext) {
          return new MessageEventDefinitionImpl(instanceContext);
        }
      });

    messageRefAttribute = typeBuilder.stringAttribute(BPMN_ATTRIBUTE_MESSAGE_REF)
      .qNameAttributeReference(Message.class)
      .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    operationRefChild = sequenceBuilder.element(OperationRef.class)
      .qNameElementReference(Operation.class)
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
        
    camundaTaskPriorityAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_TASK_PRIORITY)
      .namespace(CAMUNDA_NS)
      .build();

    typeBuilder.build();
  }

  public MessageEventDefinitionImpl(ModelTypeInstanceContext context) {
    super(context);
  }

  public Message getMessage() {
    return messageRefAttribute.getReferenceTargetElement(this);
  }

  public void setMessage(Message message) {
    messageRefAttribute.setReferenceTargetElement(this, message);
  }

  public Operation getOperation() {
    return operationRefChild.getReferenceTargetElement(this);
  }

  public void setOperation(Operation operation) {
    operationRefChild.setReferenceTargetElement(this, operation);
  }

  /** camunda extensions */

  public String getFlowaveClass() {
    return camundaClassAttribute.getValue(this);
  }

  public void setFlowaveClass(String camundaClass) {
    camundaClassAttribute.setValue(this, camundaClass);
  }

  public String getFlowaveDelegateExpression() {
    return camundaDelegateExpressionAttribute.getValue(this);
  }

  public void setFlowaveDelegateExpression(String camundaExpression) {
    camundaDelegateExpressionAttribute.setValue(this, camundaExpression);
  }

  public String getFlowaveExpression() {
    return camundaExpressionAttribute.getValue(this);
  }

  public void setFlowaveExpression(String camundaExpression) {
    camundaExpressionAttribute.setValue(this, camundaExpression);
  }

  public String getFlowaveResultVariable() {
    return camundaResultVariableAttribute.getValue(this);
  }

  public void setFlowaveResultVariable(String camundaResultVariable) {
    camundaResultVariableAttribute.setValue(this, camundaResultVariable);
  }

  public String getFlowaveTopic() {
    return camundaTopicAttribute.getValue(this);
  }

  public void setFlowaveTopic(String camundaTopic) {
    camundaTopicAttribute.setValue(this, camundaTopic);
  }

  public String getFlowaveType() {
    return camundaTypeAttribute.getValue(this);
  }

  public void setFlowaveType(String camundaType) {
    camundaTypeAttribute.setValue(this, camundaType);
  }
  
  @Override
  public String getFlowaveTaskPriority() {
    return camundaTaskPriorityAttribute.getValue(this);    
  }

  @Override
  public void setFlowaveTaskPriority(String taskPriority) {
    camundaTaskPriorityAttribute.setValue(this, taskPriority);
  }
}
