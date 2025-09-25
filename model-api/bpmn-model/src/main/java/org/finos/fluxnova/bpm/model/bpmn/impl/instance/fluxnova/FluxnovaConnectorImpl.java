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

import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_CONNECTOR;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

import org.finos.fluxnova.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaConnector;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaConnectorId;
import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaInputOutput;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElement;
import org.finos.fluxnova.bpm.model.xml.type.child.SequenceBuilder;

/**
 * The BPMN connector camunda extension element
 *
 * @author Sebastian Menski
 */
public class FluxnovaConnectorImpl extends BpmnModelElementInstanceImpl implements FluxnovaConnector {

  protected static ChildElement<FluxnovaConnectorId> camundaConnectorIdChild;
  protected static ChildElement<FluxnovaInputOutput> camundaInputOutputChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FluxnovaConnector.class, CAMUNDA_ELEMENT_CONNECTOR)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FluxnovaConnector>() {
        public FluxnovaConnector newInstance(ModelTypeInstanceContext instanceContext) {
          return new FluxnovaConnectorImpl(instanceContext);
        }
      });

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaConnectorIdChild = sequenceBuilder.element(FluxnovaConnectorId.class)
      .required()
      .build();

    camundaInputOutputChild = sequenceBuilder.element(FluxnovaInputOutput.class)
      .build();

    typeBuilder.build();
  }

  public FluxnovaConnectorImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public FluxnovaConnectorId getFluxnovaConnectorId() {
    return camundaConnectorIdChild.getChild(this);
  }

  public void setFluxnovaConnectorId(FluxnovaConnectorId camundaConnectorId) {
    camundaConnectorIdChild.setChild(this, camundaConnectorId);
  }

  public FluxnovaInputOutput getFluxnovaInputOutput() {
    return camundaInputOutputChild.getChild(this);
  }

  public void setFluxnovaInputOutput(FluxnovaInputOutput camundaInputOutput) {
    camundaInputOutputChild.setChild(this, camundaInputOutput);
  }

}
