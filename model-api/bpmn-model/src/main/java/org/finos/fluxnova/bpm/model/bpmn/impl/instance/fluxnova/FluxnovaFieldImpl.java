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
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaExpression;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaField;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaString;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.attribute.Attribute;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElement;
import org.finos.fluxnova.bpm.model.xml.type.child.SequenceBuilder;

import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.*;
import static org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN field camunda extension element
 *
 * @author Sebastian Menski
 */
public class FluxnovaFieldImpl extends BpmnModelElementInstanceImpl implements FluxnovaField {

  protected static Attribute<String> camundaNameAttribute;
  protected static Attribute<String> camundaExpressionAttribute;
  protected static Attribute<String> camundaStringValueAttribute;
  protected static ChildElement<FluxnovaExpression> camundaExpressionChild;
  protected static ChildElement<FluxnovaString> camundaStringChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FluxnovaField.class, CAMUNDA_ELEMENT_FIELD)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FluxnovaField>() {
        public FluxnovaField newInstance(ModelTypeInstanceContext instanceContext) {
          return new FluxnovaFieldImpl(instanceContext);
        }
      });

    camundaNameAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_NAME)
      .namespace(CAMUNDA_NS)
      .build();

    camundaExpressionAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_EXPRESSION)
      .namespace(CAMUNDA_NS)
      .build();

    camundaStringValueAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_STRING_VALUE)
      .namespace(CAMUNDA_NS)
      .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaExpressionChild = sequenceBuilder.element(FluxnovaExpression.class)
      .build();

    camundaStringChild = sequenceBuilder.element(FluxnovaString.class)
      .build();

    typeBuilder.build();
  }

  public FluxnovaFieldImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getFluxnovaName() {
    return camundaNameAttribute.getValue(this);
  }

  public void setFluxnovaName(String camundaName) {
    camundaNameAttribute.setValue(this, camundaName);
  }

  public String getFluxnovaExpression() {
    return camundaExpressionAttribute.getValue(this);
  }

  public void setFluxnovaExpression(String camundaExpression) {
    camundaExpressionAttribute.setValue(this, camundaExpression);
  }

  public String getFluxnovaStringValue() {
    return camundaStringValueAttribute.getValue(this);
  }

  public void setFluxnovaStringValue(String camundaStringValue) {
    camundaStringValueAttribute.setValue(this, camundaStringValue);
  }

  public FluxnovaString getFluxnovaString() {
    return camundaStringChild.getChild(this);
  }

  public void setFluxnovaString(FluxnovaString camundaString) {
    camundaStringChild.setChild(this, camundaString);
  }

  public FluxnovaExpression getFluxnovaExpressionChild() {
    return camundaExpressionChild.getChild(this);
  }

  public void setFluxnovaExpressionChild(FluxnovaExpression camundaExpression) {
    camundaExpressionChild.setChild(this, camundaExpression);
  }
}
