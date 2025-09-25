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

import org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants;
import org.finos.fluxnova.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFormData;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaFormField;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.fluxnova.bpm.model.xml.type.child.SequenceBuilder;

import java.util.Collection;

import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_FORM_DATA;
import static org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN formData camunda extension element
 *
 * @author Sebastian Menski
 */
public class FluxnovaFormDataImpl extends BpmnModelElementInstanceImpl implements FluxnovaFormData {

  protected static ChildElementCollection<FluxnovaFormField> camundaFormFieldCollection;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FluxnovaFormData.class, CAMUNDA_ELEMENT_FORM_DATA)
      .namespaceUri(BpmnModelConstants.CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FluxnovaFormData>() {
        public FluxnovaFormData newInstance(ModelTypeInstanceContext instanceContext) {
          return new FluxnovaFormDataImpl(instanceContext);
        }
      });

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaFormFieldCollection = sequenceBuilder.elementCollection(FluxnovaFormField.class)
      .build();

    typeBuilder.build();
  }

  public FluxnovaFormDataImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public Collection<FluxnovaFormField> getFluxnovaFormFields() {
    return camundaFormFieldCollection.get(this);
  }
}
