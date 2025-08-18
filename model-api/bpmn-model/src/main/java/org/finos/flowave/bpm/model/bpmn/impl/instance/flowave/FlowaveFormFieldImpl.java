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
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveFormField;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveProperties;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveValidation;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveValue;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.attribute.Attribute;
import org.finos.flowave.bpm.model.xml.type.child.ChildElement;
import org.finos.flowave.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;

import java.util.Collection;

import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.*;
import static org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN formField camunda extension element
 *
 * @author Sebastian Menski
 */
public class FlowaveFormFieldImpl extends BpmnModelElementInstanceImpl implements FlowaveFormField {

  protected static Attribute<String> camundaIdAttribute;
  protected static Attribute<String> camundaLabelAttribute;
  protected static Attribute<String> camundaTypeAttribute;
  protected static Attribute<String> camundaDatePatternAttribute;
  protected static Attribute<String> camundaDefaultValueAttribute;
  protected static ChildElement<FlowaveProperties> camundaPropertiesChild;
  protected static ChildElement<FlowaveValidation> camundaValidationChild;
  protected static ChildElementCollection<FlowaveValue> camundaValueCollection;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlowaveFormField.class, CAMUNDA_ELEMENT_FORM_FIELD)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FlowaveFormField>() {
        public FlowaveFormField newInstance(ModelTypeInstanceContext instanceContext) {
          return new FlowaveFormFieldImpl(instanceContext);
        }
      });

    camundaIdAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_ID)
      .namespace(CAMUNDA_NS)
      .build();

    camundaLabelAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_LABEL)
      .namespace(CAMUNDA_NS)
      .build();

    camundaTypeAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_TYPE)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDatePatternAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DATE_PATTERN)
      .namespace(CAMUNDA_NS)
      .build();

    camundaDefaultValueAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_DEFAULT_VALUE)
      .namespace(CAMUNDA_NS)
      .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaPropertiesChild = sequenceBuilder.element(FlowaveProperties.class)
      .build();

    camundaValidationChild = sequenceBuilder.element(FlowaveValidation.class)
      .build();

    camundaValueCollection = sequenceBuilder.elementCollection(FlowaveValue.class)
      .build();

    typeBuilder.build();
  }

  public FlowaveFormFieldImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getFlowaveId() {
    return camundaIdAttribute.getValue(this);
  }

  public void setFlowaveId(String camundaId) {
    camundaIdAttribute.setValue(this, camundaId);
  }

  public String getFlowaveLabel() {
    return camundaLabelAttribute.getValue(this);
  }

  public void setFlowaveLabel(String camundaLabel) {
    camundaLabelAttribute.setValue(this, camundaLabel);
  }

  public String getFlowaveType() {
    return camundaTypeAttribute.getValue(this);
  }

  public void setFlowaveType(String camundaType) {
    camundaTypeAttribute.setValue(this, camundaType);
  }

  public String getFlowaveDatePattern() {
    return camundaDatePatternAttribute.getValue(this);
  }

  public void setFlowaveDatePattern(String camundaDatePattern) {
    camundaDatePatternAttribute.setValue(this, camundaDatePattern);
  }

  public String getFlowaveDefaultValue() {
    return camundaDefaultValueAttribute.getValue(this);
  }

  public void setFlowaveDefaultValue(String camundaDefaultValue) {
    camundaDefaultValueAttribute.setValue(this, camundaDefaultValue);
  }

  public FlowaveProperties getFlowaveProperties() {
    return camundaPropertiesChild.getChild(this);
  }

  public void setFlowaveProperties(FlowaveProperties camundaProperties) {
    camundaPropertiesChild.setChild(this, camundaProperties);
  }

  public FlowaveValidation getFlowaveValidation() {
    return camundaValidationChild.getChild(this);
  }

  public void setFlowaveValidation(FlowaveValidation camundaValidation) {
    camundaValidationChild.setChild(this, camundaValidation);
  }

  public Collection<FlowaveValue> getFlowaveValues() {
    return camundaValueCollection.get(this);
  }
}
