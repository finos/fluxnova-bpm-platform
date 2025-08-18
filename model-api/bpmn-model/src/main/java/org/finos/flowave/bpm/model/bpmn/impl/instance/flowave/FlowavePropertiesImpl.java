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

import org.finos.flowave.bpm.model.bpmn.impl.instance.BpmnModelElementInstanceImpl;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveProperties;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveProperty;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.child.ChildElementCollection;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;

import java.util.Collection;

import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_PROPERTIES;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;
import static org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN properties camunda extension element
 *
 * @author Sebastian Menski
 */
public class FlowavePropertiesImpl extends BpmnModelElementInstanceImpl implements FlowaveProperties {

  protected static ChildElementCollection<FlowaveProperty> camundaPropertyCollection;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlowaveProperties.class, CAMUNDA_ELEMENT_PROPERTIES)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FlowaveProperties>() {
        public FlowaveProperties newInstance(ModelTypeInstanceContext instanceContext) {
          return new FlowavePropertiesImpl(instanceContext);
        }
      });

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    camundaPropertyCollection = sequenceBuilder.elementCollection(FlowaveProperty.class)
      .build();

    typeBuilder.build();
  }

  public FlowavePropertiesImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public Collection<FlowaveProperty> getFlowaveProperties() {
    return camundaPropertyCollection.get(this);
  }
}
