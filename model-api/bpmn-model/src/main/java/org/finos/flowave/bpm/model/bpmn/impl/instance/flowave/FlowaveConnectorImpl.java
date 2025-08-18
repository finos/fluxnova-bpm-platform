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

import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_CONNECTOR;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

import org.finos.flowave.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveConnector;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveConnectorId;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveInputOutput;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.flowave.bpm.model.xml.type.child.ChildElement;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;

/**
 * The BPMN connector camunda extension element
 *
 * @author Sebastian Menski
 */
public class FlowaveConnectorImpl extends BpmnModelElementInstanceImpl implements FlowaveConnector {

  protected static ChildElement<FlowaveConnectorId> camundaConnectorIdChild;
  protected static ChildElement<FlowaveInputOutput> camundaInputOutputChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlowaveConnector.class, CAMUNDA_ELEMENT_CONNECTOR)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FlowaveConnector>() {
        public FlowaveConnector newInstance(ModelTypeInstanceContext instanceContext) {
          return new FlowaveConnectorImpl(instanceContext);
        }
      });

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaConnectorIdChild = sequenceBuilder.element(FlowaveConnectorId.class)
      .required()
      .build();

    camundaInputOutputChild = sequenceBuilder.element(FlowaveInputOutput.class)
      .build();

    typeBuilder.build();
  }

  public FlowaveConnectorImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public FlowaveConnectorId getFlowaveConnectorId() {
    return camundaConnectorIdChild.getChild(this);
  }

  public void setFlowaveConnectorId(FlowaveConnectorId camundaConnectorId) {
    camundaConnectorIdChild.setChild(this, camundaConnectorId);
  }

  public FlowaveInputOutput getFlowaveInputOutput() {
    return camundaInputOutputChild.getChild(this);
  }

  public void setFlowaveInputOutput(FlowaveInputOutput camundaInputOutput) {
    camundaInputOutputChild.setChild(this, camundaInputOutput);
  }

}
