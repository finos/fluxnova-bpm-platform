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
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaScript;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.fluxnova.bpm.model.xml.type.attribute.Attribute;

import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_RESOURCE;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_SCRIPT_FORMAT;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_SCRIPT;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

/**
 * The BPMN script camunda extension element
 *
 * @author Sebastian Menski
 */
public class FluxnovaScriptImpl extends BpmnModelElementInstanceImpl implements FluxnovaScript {

  protected static Attribute<String> camundaScriptFormatAttribute;
  protected static Attribute<String> camundaResourceAttribute;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FluxnovaScript.class, CAMUNDA_ELEMENT_SCRIPT)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FluxnovaScript>() {
        public FluxnovaScript newInstance(ModelTypeInstanceContext instanceContext) {
          return new FluxnovaScriptImpl(instanceContext);
        }
      });

    camundaScriptFormatAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_SCRIPT_FORMAT)
      .required()
      .build();

    camundaResourceAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_RESOURCE)
      .build();

    typeBuilder.build();
  }

  public FluxnovaScriptImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getFluxnovaScriptFormat() {
    return camundaScriptFormatAttribute.getValue(this);
  }

  public void setFluxnovaScriptFormat(String camundaScriptFormat) {
    camundaScriptFormatAttribute.setValue(this, camundaScriptFormat);
  }

  public String getFluxnovaResource() {
    return camundaResourceAttribute.getValue(this);
  }

  public void setFluxnovaResource(String camundaResource) {
    camundaResourceAttribute.setValue(this, camundaResource);
  }
}
