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
package org.finos.fluxnova.bpm.model.cmmn.impl.instance.fluxnova;

import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_CLASS;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_DELEGATE_EXPRESSION;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_EVENT;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_EXPRESSION;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ELEMENT_VARIABLE_LISTENER;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_NS;

import java.util.Collection;

import org.finos.fluxnova.bpm.model.cmmn.impl.instance.CmmnModelElementInstanceImpl;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaField;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaScript;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaVariableListener;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.fluxnova.bpm.model.xml.type.attribute.Attribute;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElement;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.fluxnova.bpm.model.xml.type.child.SequenceBuilder;

/**
 * @author Thorben Lindhauer
 */
public class FluxnovaVariableListenerImpl extends CmmnModelElementInstanceImpl implements FluxnovaVariableListener {

  protected static Attribute<String> camundaEventAttribute;
  protected static Attribute<String> camundaClassAttribute;
  protected static Attribute<String> camundaExpressionAttribute;
  protected static Attribute<String> camundaDelegateExpressionAttribute;
  protected static ChildElementCollection<FluxnovaField> camundaFieldCollection;
  protected static ChildElement<FluxnovaScript> camundaScriptChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FluxnovaVariableListener.class, CAMUNDA_ELEMENT_VARIABLE_LISTENER)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FluxnovaVariableListener>() {
        public FluxnovaVariableListener newInstance(ModelTypeInstanceContext instanceContext) {
          return new FluxnovaVariableListenerImpl(instanceContext);
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

    camundaFieldCollection = sequenceBuilder.elementCollection(FluxnovaField.class)
      .build();

    camundaScriptChild = sequenceBuilder.element(FluxnovaScript.class)
      .build();

    typeBuilder.build();
  }

  public FluxnovaVariableListenerImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }
  public String getFluxnovaEvent() {
    return camundaEventAttribute.getValue(this);
  }

  public void setFluxnovaEvent(String camundaEvent) {
    camundaEventAttribute.setValue(this, camundaEvent);
  }

  public String getFluxnovaClass() {
    return camundaClassAttribute.getValue(this);
  }

  public void setFluxnovaClass(String camundaClass) {
    camundaClassAttribute.setValue(this, camundaClass);
  }

  public String getFluxnovaExpression() {
    return camundaExpressionAttribute.getValue(this);
  }

  public void setFluxnovaExpression(String camundaExpression) {
    camundaExpressionAttribute.setValue(this, camundaExpression);
  }

  public String getFluxnovaDelegateExpression() {
    return camundaDelegateExpressionAttribute.getValue(this);
  }

  public void setFluxnovaDelegateExpression(String camundaDelegateExpression) {
    camundaDelegateExpressionAttribute.setValue(this, camundaDelegateExpression);
  }

  public FluxnovaScript getFluxnovaScript() {
    return camundaScriptChild.getChild(this);
  }

  public void setFluxnovaScript(FluxnovaScript camundaScript) {
    camundaScriptChild.setChild(this, camundaScript);
  }

  public Collection<FluxnovaField> getFluxnovaFields() {
    return camundaFieldCollection.get(this);
  }

}
