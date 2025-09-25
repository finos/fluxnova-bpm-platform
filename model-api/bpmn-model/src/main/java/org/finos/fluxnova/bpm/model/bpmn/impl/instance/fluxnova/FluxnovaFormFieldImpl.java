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
package org.finos.fluxnova.bpm.model.bpmn.impl.instance.fluxnova;

import org.finos.fluxnova.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFormField;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaProperties;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaValidation;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaValue;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.attribute.Attribute;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElement;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.fluxnova.bpm.model.xml.type.child.SequenceBuilder;

import java.util.Collection;

import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.*;
import static org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN formField camunda extension element
 *
 * @author Sebastian Menski
 */
public class FluxnovaFormFieldImpl extends BpmnModelElementInstanceImpl implements FluxnovaFormField {

  protected static Attribute<String> camundaIdAttribute;
  protected static Attribute<String> camundaLabelAttribute;
  protected static Attribute<String> camundaTypeAttribute;
  protected static Attribute<String> camundaDatePatternAttribute;
  protected static Attribute<String> camundaDefaultValueAttribute;
  protected static ChildElement<FluxnovaProperties> camundaPropertiesChild;
  protected static ChildElement<FluxnovaValidation> camundaValidationChild;
  protected static ChildElementCollection<FluxnovaValue> camundaValueCollection;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FluxnovaFormField.class, CAMUNDA_ELEMENT_FORM_FIELD)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FluxnovaFormField>() {
        public FluxnovaFormField newInstance(ModelTypeInstanceContext instanceContext) {
          return new FluxnovaFormFieldImpl(instanceContext);
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

    camundaPropertiesChild = sequenceBuilder.element(FluxnovaProperties.class)
      .build();

    camundaValidationChild = sequenceBuilder.element(FluxnovaValidation.class)
      .build();

    camundaValueCollection = sequenceBuilder.elementCollection(FluxnovaValue.class)
      .build();

    typeBuilder.build();
  }

  public FluxnovaFormFieldImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getFluxnovaId() {
    return camundaIdAttribute.getValue(this);
  }

  public void setFluxnovaId(String camundaId) {
    camundaIdAttribute.setValue(this, camundaId);
  }

  public String getFluxnovaLabel() {
    return camundaLabelAttribute.getValue(this);
  }

  public void setFluxnovaLabel(String camundaLabel) {
    camundaLabelAttribute.setValue(this, camundaLabel);
  }

  public String getFluxnovaType() {
    return camundaTypeAttribute.getValue(this);
  }

  public void setFluxnovaType(String camundaType) {
    camundaTypeAttribute.setValue(this, camundaType);
  }

  public String getFluxnovaDatePattern() {
    return camundaDatePatternAttribute.getValue(this);
  }

  public void setFluxnovaDatePattern(String camundaDatePattern) {
    camundaDatePatternAttribute.setValue(this, camundaDatePattern);
  }

  public String getFluxnovaDefaultValue() {
    return camundaDefaultValueAttribute.getValue(this);
  }

  public void setFluxnovaDefaultValue(String camundaDefaultValue) {
    camundaDefaultValueAttribute.setValue(this, camundaDefaultValue);
  }

  public FluxnovaProperties getFluxnovaProperties() {
    return camundaPropertiesChild.getChild(this);
  }

  public void setFluxnovaProperties(FluxnovaProperties camundaProperties) {
    camundaPropertiesChild.setChild(this, camundaProperties);
  }

  public FluxnovaValidation getFluxnovaValidation() {
    return camundaValidationChild.getChild(this);
  }

  public void setFluxnovaValidation(FluxnovaValidation camundaValidation) {
    camundaValidationChild.setChild(this, camundaValidation);
  }

  public Collection<FluxnovaValue> getFluxnovaValues() {
    return camundaValueCollection.get(this);
  }
}
