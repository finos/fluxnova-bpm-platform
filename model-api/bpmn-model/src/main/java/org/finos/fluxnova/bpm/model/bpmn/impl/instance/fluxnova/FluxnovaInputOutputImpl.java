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

import java.util.Collection;
import org.finos.fluxnova.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaInputOutput;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaInputParameter;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaOutputParameter;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.fluxnova.bpm.model.xml.type.child.SequenceBuilder;

import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_INPUT_OUTPUT;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

/**
 * The BPMN inputOutput camunda extension element
 *
 * @author Sebastian Menski
 */
public class FluxnovaInputOutputImpl extends BpmnModelElementInstanceImpl implements FluxnovaInputOutput {

  protected static ChildElementCollection<FluxnovaInputParameter> camundaInputParameterCollection;
  protected static ChildElementCollection<FluxnovaOutputParameter> camundaOutputParameterCollection;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FluxnovaInputOutput.class, CAMUNDA_ELEMENT_INPUT_OUTPUT)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FluxnovaInputOutput>() {
        public FluxnovaInputOutput newInstance(ModelTypeInstanceContext instanceContext) {
          return new FluxnovaInputOutputImpl(instanceContext);
        }
      });

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaInputParameterCollection = sequenceBuilder.elementCollection(FluxnovaInputParameter.class)
      .build();

    camundaOutputParameterCollection = sequenceBuilder.elementCollection(FluxnovaOutputParameter.class)
      .build();

    typeBuilder.build();
  }

  public FluxnovaInputOutputImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public Collection<FluxnovaInputParameter> getFluxnovaInputParameters() {
    return camundaInputParameterCollection.get(this);
  }

  public Collection<FluxnovaOutputParameter> getFluxnovaOutputParameters() {
    return camundaOutputParameterCollection.get(this);
  }
}
