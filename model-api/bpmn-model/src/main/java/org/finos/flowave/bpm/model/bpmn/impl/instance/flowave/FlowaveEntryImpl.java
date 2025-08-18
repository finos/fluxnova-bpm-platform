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

import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ATTRIBUTE_KEY;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_ENTRY;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowaveEntry;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;
import org.finos.flowave.bpm.model.xml.type.attribute.Attribute;

/**
 * @author Sebastian Menski
 */
public class FlowaveEntryImpl extends FlowaveGenericValueElementImpl implements FlowaveEntry {

  protected static Attribute<String> camundaKeyAttribute;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlowaveEntry.class, CAMUNDA_ELEMENT_ENTRY)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FlowaveEntry>() {
        public FlowaveEntry newInstance(ModelTypeInstanceContext instanceContext) {
          return new FlowaveEntryImpl(instanceContext);
        }
      });

    camundaKeyAttribute = typeBuilder.stringAttribute(CAMUNDA_ATTRIBUTE_KEY)
      .namespace(CAMUNDA_NS)
      .required()
      .build();

    typeBuilder.build();
  }

  public FlowaveEntryImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public String getFlowaveKey() {
    return camundaKeyAttribute.getValue(this);
  }

  public void setFlowaveKey(String camundaKey) {
    camundaKeyAttribute.setValue(this, camundaKey);
  }

}
