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

import org.finos.flowave.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormProperty;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveValue;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.attribute.Attribute;
import org.finos.flowave.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;

import java.util.Collection;

import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.*;
import static org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN formProperty camunda extension element
 *
 * @author Sebastian Menski
 */
public class FlowaveFormPropertyImpl extends BpmnModelElementInstanceImpl implements FlowaveFormProperty {

  protected static Attribute<String> camundaIdAttribute;
  protected static Attribute<String> camundaNameAttribute;
  protected static Attribute<String> camundaTypeAttribute;
  protected static Attribute<Boolean> camundaRequiredAttribute;
  protected static Attribute<Boolean> camundaReadableAttribute;
  protected static Attribute<Boolean> camundaWriteableAttribute;
  protected static Attribute<String> camundaVariableAttribute;
  protected static Attribute<String> camundaExpressionAttribute;
  protected static Attribute<String> camundaDatePatternAttribute;
  protected static Attribute<String> camundaDefaultAttribute;
  protected static ChildElementCollection<FlowaveValue> camundaValueCollection;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlowaveFormProperty.class, CAMUNDA_ELEMENT_FORM_PROPERTY)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FlowaveFormProperty>() {
        public FlowaveFormProperty newInstance(ModelTypeInstanceContext instanceContext) {
          return new FlowaveFormPropertyImpl(instanceContext);
        }
      });

    camundaIdAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_ID)
      .namespace(CAMUNDA_NS)
      .build();

    camundaNameAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_NAME)
      .namespace(CAMUNDA_NS)
      .build();

    camundaTypeAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_TYPE)
      .namespace(CAMUNDA_NS)
      .build();

    camundaRequiredAttribute = typeBuilder.booleanAttribute(CAMUNDA_ATTRIBUTE_REQUIRED)
      .namespace(CAMUNDA_NS)
      .defaultValue(false)
      .build();

    camundaReadableAttribute = typeBuilder.booleanAttribute(CAMUNDA_ATTRIBUTE_READABLE)
      .namespace(CAMUNDA_NS)
      .defaultValue(true)
      .build();

    camundaWriteableAttribute = typeBuilder.booleanAttribute(CAMUNDA_ATTRIBUTE_WRITEABLE)
      .namespace(CAMUNDA_NS)
      .defaultValue(true)
      .build();

    camundaVariableAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_VARIABLE)
      .namespace(CAMUNDA_NS)
      .build();

    camundaExpressionAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_EXPRESSION)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDatePatternAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DATE_PATTERN)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDefaultAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DEFAULT)
      .namespace(CAMUNDA_NS)
      .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaValueCollection = sequenceBuilder.elementCollection(FlowaveValue.class)
      .build();

    typeBuilder.build();
  }

  public FlowaveFormPropertyImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getFlowaveId() {
    return camundaIdAttribute.getValue(this);
  }

  public void setFlowaveId(String camundaId) {
    camundaIdAttribute.setValue(this, camundaId);
  }

  public String getFlowaveName() {
    return camundaNameAttribute.getValue(this);
  }

  public void setFlowaveName(String camundaName) {
    camundaNameAttribute.setValue(this, camundaName);
  }

  public String getFlowaveType() {
    return camundaTypeAttribute.getValue(this);
  }

  public void setFlowaveType(String camundaType) {
    camundaTypeAttribute.setValue(this, camundaType);
  }

  public boolean isFlowaveRequired() {
    return camundaRequiredAttribute.getValue(this);
  }

  public void setFlowaveRequired(boolean isCamundaRequired) {
    camundaRequiredAttribute.setValue(this, isCamundaRequired);
  }

  public boolean isFlowaveReadable() {
    return camundaReadableAttribute.getValue(this);
  }

  public void setFlowaveReadable(boolean isCamundaReadable) {
    camundaReadableAttribute.setValue(this, isCamundaReadable);
  }

  public boolean isFlowaveWriteable() {
    return camundaWriteableAttribute.getValue(this);
  }

  public void setFlowaveWriteable(boolean isCamundaWriteable) {
    camundaWriteableAttribute.setValue(this, isCamundaWriteable);
  }

  public String getFlowaveVariable() {
    return camundaVariableAttribute.getValue(this);
  }

  public void setFlowaveVariable(String camundaVariable) {
    camundaVariableAttribute.setValue(this, camundaVariable);
  }

  public String getFlowaveExpression() {
    return camundaExpressionAttribute.getValue(this);
  }

  public void setFlowaveExpression(String camundaExpression) {
    camundaExpressionAttribute.setValue(this, camundaExpression);
  }

  public String getFlowaveDatePattern() {
    return camundaDatePatternAttribute.getValue(this);
  }

  public void setFlowaveDatePattern(String camundaDatePattern) {
    camundaDatePatternAttribute.setValue(this, camundaDatePattern);
  }

  public String getFlowaveDefault() {
    return camundaDefaultAttribute.getValue(this);
  }

  public void setFlowaveDefault(String camundaDefault) {
    camundaDefaultAttribute.setValue(this, camundaDefault);
  }

  public Collection<FlowaveValue> getFlowaveValues() {
    return camundaValueCollection.get(this);
  }
}
