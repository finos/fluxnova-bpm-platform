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
import org.finos.flowave.bpm.model.bpmn.instance.ResourceAssignmentExpression;
import org.finos.flowave.bpm.model.bpmn.instance.flowave.FlowavePotentialStarter;
import org.finos.flowave.bpm.model.xml.ModelBuilder;
import org.finos.flowave.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.flowave.bpm.model.xml.type.child.ChildElement;
import org.finos.flowave.bpm.model.xml.type.child.SequenceBuilder;

import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_ELEMENT_POTENTIAL_STARTER;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;
import static org.finos.flowave.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN potentialStarter camunda extension
 *
 * @author Sebastian Menski
 */
public class FlowavePotentialStarterImpl extends BpmnModelElementInstanceImpl implements FlowavePotentialStarter {

  protected static ChildElement<ResourceAssignmentExpression> resourceAssignmentExpressionChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(FlowavePotentialStarter.class, CAMUNDA_ELEMENT_POTENTIAL_STARTER)
      .namespaceUri(CAMUNDA_NS)
      .instanceProvider(new ModelTypeInstanceProvider<FlowavePotentialStarter>() {
        public FlowavePotentialStarter newInstance(ModelTypeInstanceContext instanceContext) {
          return new FlowavePotentialStarterImpl(instanceContext);
        }
      });

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    resourceAssignmentExpressionChild = sequenceBuilder.element(ResourceAssignmentExpression.class)
      .build();

    typeBuilder.build();
  }

  public FlowavePotentialStarterImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  public ResourceAssignmentExpression getResourceAssignmentExpression() {
    return resourceAssignmentExpressionChild.getChild(this);
  }

  public void setResourceAssignmentExpression(ResourceAssignmentExpression resourceAssignmentExpression) {
    resourceAssignmentExpressionChild.setChild(this, resourceAssignmentExpression);
  }
}
