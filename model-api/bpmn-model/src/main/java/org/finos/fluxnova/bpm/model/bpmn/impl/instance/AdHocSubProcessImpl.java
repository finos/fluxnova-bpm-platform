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
package org.finos.fluxnova.bpm.model.bpmn.impl.instance;

import org.finos.fluxnova.bpm.model.bpmn.AdHocOrdering;
import org.finos.fluxnova.bpm.model.bpmn.instance.AdHocSubProcess;
import org.finos.fluxnova.bpm.model.bpmn.instance.CompletionCondition;
import org.finos.fluxnova.bpm.model.bpmn.instance.SubProcess;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.attribute.Attribute;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElement;
import org.finos.fluxnova.bpm.model.xml.type.child.SequenceBuilder;

import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.*;
import static org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder.ModelTypeInstanceProvider;

/**
 * The BPMN adHocSubProcess element
 */
public class AdHocSubProcessImpl extends SubProcessImpl implements AdHocSubProcess {

  protected static Attribute<AdHocOrdering> orderingAttribute;
  protected static Attribute<Boolean> cancelRemainingInstancesAttribute;
  protected static ChildElement<CompletionCondition> completionConditionChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder.defineType(AdHocSubProcess.class, BPMN_ELEMENT_AD_HOC_SUB_PROCESS)
      .namespaceUri(BPMN20_NS)
      .extendsType(SubProcess.class)
      .instanceProvider(new ModelTypeInstanceProvider<AdHocSubProcess>() {
        public AdHocSubProcess newInstance(ModelTypeInstanceContext instanceContext) {
          return new AdHocSubProcessImpl(instanceContext);
        }
      });

    orderingAttribute = typeBuilder.enumAttribute(BPMN_ATTRIBUTE_ORDERING, AdHocOrdering.class)
      .defaultValue(AdHocOrdering.Parallel)
      .build();

    cancelRemainingInstancesAttribute = typeBuilder.booleanAttribute(BPMN_ATTRIBUTE_CANCEL_REMAINING_INSTANCES)
      .defaultValue(true)
      .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    completionConditionChild = sequenceBuilder.element(CompletionCondition.class)
      .build();

    typeBuilder.build();
  }

  public AdHocSubProcessImpl(ModelTypeInstanceContext context) {
    super(context);
  }

  public AdHocOrdering getOrdering() {
    return orderingAttribute.getValue(this);
  }

  public void setOrdering(AdHocOrdering ordering) {
    orderingAttribute.setValue(this, ordering);
  }

  public boolean isCancelRemainingInstances() {
    return cancelRemainingInstancesAttribute.getValue(this);
  }

  public void setCancelRemainingInstances(boolean cancelRemainingInstances) {
    cancelRemainingInstancesAttribute.setValue(this, cancelRemainingInstances);
  }

  public CompletionCondition getCompletionCondition() {
    return completionConditionChild.getChild(this);
  }

  public void setCompletionCondition(CompletionCondition completionCondition) {
    completionConditionChild.setChild(this, completionCondition);
  }

}
