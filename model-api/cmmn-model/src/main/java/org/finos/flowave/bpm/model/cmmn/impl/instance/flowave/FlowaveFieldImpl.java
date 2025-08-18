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
package org.finos.flowave.bpm.model.cmmn.impl.instance.flowave;

import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_EXPRESSION;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_NAME;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_STRING_VALUE;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ELEMENT_FIELD;
import static org.finos.flowave.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_NS;

import org.finos.flowave.bpm.model.cmmn.impl.instance.CmmnModelElementInstanceImpl;
import org.finos.flowave.bpm.model.cmmn.instance.flowave.FlowaveExpression;
import org.finos.flowave.bpm.model.cmmn.instance.flowave.FlowaveField;
import org.finos.flowave.bpm.model.cmmn.instance.flowave.FlowaveString;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.flowave.bpm.model.xml.type.attribute.Attribute;
import org.finos.flowave.bpm.model.xml.type.child.ChildElement;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;

/**
 * @author Roman Smirnov
 *
 */
public class FlowaveFieldImpl extends CmmnModelElementInstanceImpl implements FlowaveField {

  protected static Attribute<String> camundaNameAttribute;
  protected static Attribute<String> camundaExpressionAttribute;
  protected static Attribute<String> camundaStringValueAttribute;
  protected static ChildElement<FlowaveExpression> camundaExpressionChild;
  protected static ChildElement<FlowaveString> camundaStringChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlowaveField.class, CAMUNDA_ELEMENT_FIELD)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FlowaveField>() {
        public FlowaveField newInstance(ModelTypeInstanceContext instanceContext) {
          return new FlowaveFieldImpl(instanceContext);
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

    camundaExpressionChild = sequenceBuilder.element(FlowaveExpression.class)
      .build();

    camundaStringChild = sequenceBuilder.element(FlowaveString.class)
      .build();

    typeBuilder.build();
  }

  public FlowaveFieldImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getFlowaveName() {
    return camundaNameAttribute.getValue(this);
  }

  public void setFlowaveName(String camundaName) {
    camundaNameAttribute.setValue(this, camundaName);
  }

  public String getFlowaveExpression() {
    return camundaExpressionAttribute.getValue(this);
  }

  public void setFlowaveExpression(String camundaExpression) {
    camundaExpressionAttribute.setValue(this, camundaExpression);
  }

  public String getFlowaveStringValue() {
    return camundaStringValueAttribute.getValue(this);
  }

  public void setFlowaveStringValue(String camundaStringValue) {
    camundaStringValueAttribute.setValue(this, camundaStringValue);
  }

  public FlowaveString getFlowaveString() {
    return camundaStringChild.getChild(this);
  }

  public void setFlowaveString(FlowaveString camundaString) {
    camundaStringChild.setChild(this, camundaString);
  }

  public FlowaveExpression getFlowaveExpressionChild() {
    return camundaExpressionChild.getChild(this);
  }

  public void setFlowaveExpressionChild(FlowaveExpression camundaExpression) {
    camundaExpressionChild.setChild(this, camundaExpression);
  }

}
