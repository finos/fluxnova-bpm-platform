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

import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ATTRIBUTE_VARIABLE_NAME;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_ELEMENT_VARIABLE_ON_PART;
import static org.finos.fluxnova.bpm.model.cmmn.impl.CmmnModelConstants.CAMUNDA_NS;

import org.finos.fluxnova.bpm.model.cmmn.VariableTransition;
import org.finos.fluxnova.bpm.model.cmmn.impl.instance.CmmnModelElementInstanceImpl;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaVariableOnPart;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaVariableTransitionEvent;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.fluxnova.bpm.model.xml.type.attribute.Attribute;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElement;
import org.finos.fluxnova.bpm.model.xml.type.child.SequenceBuilder;

public class FluxnovaVariableOnPartImpl extends CmmnModelElementInstanceImpl implements FluxnovaVariableOnPart {

  protected static Attribute<String> camundaVariableNameAttribute;
  protected static ChildElement<FluxnovaVariableTransitionEvent> camundaVariableEventChild; 
  
  public FluxnovaVariableOnPartImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public static void registerType(ModelBuilder modelBuilder) {

    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FluxnovaVariableOnPart.class, CAMUNDA_ELEMENT_VARIABLE_ON_PART)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FluxnovaVariableOnPart>() {
        public FluxnovaVariableOnPart newInstance(ModelTypeInstanceContext instanceContext) {
          return new FluxnovaVariableOnPartImpl(instanceContext);
      }
    });

    camundaVariableNameAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_VARIABLE_NAME)
      .namespace(CAMUNDA_NS)
      .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaVariableEventChild = sequenceBuilder.element(FluxnovaVariableTransitionEvent.class)
      .build();

    typeBuilder.build();
  }

  public String getVariableName() {
    return camundaVariableNameAttribute.getValue(this);
  }

  public void setVariableName(String name) {
    camundaVariableNameAttribute.setValue(this, name);
  }


  public VariableTransition getVariableEvent() {
    FluxnovaVariableTransitionEvent child = camundaVariableEventChild.getChild(this);
    return child.getValue();
  }

  public void setVariableEvent(VariableTransition variableTransition) {
    FluxnovaVariableTransitionEvent child = camundaVariableEventChild.getChild(this);
    child.setValue(variableTransition);
  }

}
