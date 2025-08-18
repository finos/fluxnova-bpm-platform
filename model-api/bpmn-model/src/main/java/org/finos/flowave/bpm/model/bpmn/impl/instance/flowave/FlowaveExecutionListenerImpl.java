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
package org.finos.flowave.bpm.model.bpmn.impl.instance.flowave;

import java.util.Collection;

import org.finos.flowave.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveExecutionListener;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveField;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveScript;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.attribute.Attribute;
import org.finos.flowave.bpm.model.xml.type.child.ChildElement;
import org.finos.flowave.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;

import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_CLASS;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_DELEGATE_EXPRESSION;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_EVENT;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_EXPRESSION;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_EXECUTION_LISTENER;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;
import static org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN executionListener camunda extension element
 *
 * @author Sebastian Menski
 */
public class FlowaveExecutionListenerImpl extends BpmnModelElementInstanceImpl implements FlowaveExecutionListener {

  protected static Attribute<String> camundaEventAttribute;
  protected static Attribute<String> camundaClassAttribute;
  protected static Attribute<String> camundaExpressionAttribute;
  protected static Attribute<String> camundaDelegateExpressionAttribute;
  protected static ChildElementCollection<FlowaveField> camundaFieldCollection;
  protected static ChildElement<FlowaveScript> camundaScriptChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlowaveExecutionListener.class, CAMUNDA_ELEMENT_EXECUTION_LISTENER)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FlowaveExecutionListener>() {
        public FlowaveExecutionListener newInstance(ModelTypeInstanceContext instanceContext) {
          return new FlowaveExecutionListenerImpl(instanceContext);
        }
      });

    camundaEventAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_EVENT)
      .namespace(CAMUNDA_NS)
      .build();

    camundaClassAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_CLASS)
      .namespace(CAMUNDA_NS)
      .build();

    camundaExpressionAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_EXPRESSION)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDelegateExpressionAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DELEGATE_EXPRESSION)
      .namespace(CAMUNDA_NS)
      .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaFieldCollection = sequenceBuilder.elementCollection(FlowaveField.class)
      .build();

    camundaScriptChild = sequenceBuilder.element(FlowaveScript.class)
      .build();

    typeBuilder.build();
  }

  public FlowaveExecutionListenerImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getFlowaveEvent() {
    return camundaEventAttribute.getValue(this);
  }

  public void setFlowaveEvent(String camundaEvent) {
    camundaEventAttribute.setValue(this, camundaEvent);
  }

  public String getFlowaveClass() {
    return camundaClassAttribute.getValue(this);
  }

  public void setFlowaveClass(String camundaClass) {
    camundaClassAttribute.setValue(this, camundaClass);
  }

  public String getFlowaveExpression() {
    return camundaExpressionAttribute.getValue(this);
  }

  public void setFlowaveExpression(String camundaExpression) {
    camundaExpressionAttribute.setValue(this, camundaExpression);
  }

  public String getFlowaveDelegateExpression() {
    return camundaDelegateExpressionAttribute.getValue(this);
  }

  public void setFlowaveDelegateExpression(String camundaDelegateExpression) {
    camundaDelegateExpressionAttribute.setValue(this, camundaDelegateExpression);
  }

  public Collection<FlowaveField> getFlowaveFields() {
    return camundaFieldCollection.get(this);
  }

  public FlowaveScript getFlowaveScript() {
    return camundaScriptChild.getChild(this);
  }

  public void setFlowaveScript(FlowaveScript camundaScript) {
    camundaScriptChild.setChild(this, camundaScript);
  }

}
