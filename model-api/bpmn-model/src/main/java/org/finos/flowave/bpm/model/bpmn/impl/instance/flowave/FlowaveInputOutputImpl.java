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

import java.util.Collection;
import org.finos.flowave.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveInputOutput;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveInputParameter;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveOutputParameter;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.flowave.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;

import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_INPUT_OUTPUT;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

/**
 * The BPMN inputOutput camunda extension element
 *
 * @author Sebastian Menski
 */
public class FlowaveInputOutputImpl extends BpmnModelElementInstanceImpl implements FlowaveInputOutput {

  protected static ChildElementCollection<FlowaveInputParameter> camundaInputParameterCollection;
  protected static ChildElementCollection<FlowaveOutputParameter> camundaOutputParameterCollection;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlowaveInputOutput.class, CAMUNDA_ELEMENT_INPUT_OUTPUT)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FlowaveInputOutput>() {
        public FlowaveInputOutput newInstance(ModelTypeInstanceContext instanceContext) {
          return new FlowaveInputOutputImpl(instanceContext);
        }
      });

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaInputParameterCollection = sequenceBuilder.elementCollection(FlowaveInputParameter.class)
      .build();

    camundaOutputParameterCollection = sequenceBuilder.elementCollection(FlowaveOutputParameter.class)
      .build();

    typeBuilder.build();
  }

  public FlowaveInputOutputImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public Collection<FlowaveInputParameter> getFlowaveInputParameters() {
    return camundaInputParameterCollection.get(this);
  }

  public Collection<FlowaveOutputParameter> getFlowaveOutputParameters() {
    return camundaOutputParameterCollection.get(this);
  }
}
