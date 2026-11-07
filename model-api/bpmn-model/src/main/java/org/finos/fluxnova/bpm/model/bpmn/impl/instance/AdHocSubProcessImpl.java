package org.finos.fluxnova.bpm.model.bpmn.impl.instance;

import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.BPMN20_NS;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.BPMN_ATTRIBUTE_CANCEL_REMAINING_INSTANCES;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.BPMN_ATTRIBUTE_ORDERING;
import static org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants.BPMN_ELEMENT_AD_HOC_SUB_PROCESS;

import org.finos.fluxnova.bpm.model.bpmn.instance.AdHocSubProcess;
import org.finos.fluxnova.bpm.model.bpmn.instance.CompletionCondition;
import org.finos.fluxnova.bpm.model.bpmn.instance.SubProcess;
import org.finos.fluxnova.bpm.model.xml.ModelBuilder;
import org.finos.fluxnova.bpm.model.xml.impl.instance.ModelTypeInstanceContext;
import org.finos.fluxnova.bpm.model.xml.type.ModelElementTypeBuilder;
import org.finos.fluxnova.bpm.model.xml.type.attribute.Attribute;
import org.finos.fluxnova.bpm.model.xml.type.child.ChildElement;
import org.finos.fluxnova.bpm.model.xml.type.child.SequenceBuilder;

/**
 * The BPMN 2.0 adHocSubProcess element implementation.
 *
 * <p>Note: the {@code ordering} attribute is persisted as BPMN model metadata.
 * In the current engine implementation, ad-hoc runtime activation is
 * parallel-only and "Sequential" is not enforced.
 *
 */
public class AdHocSubProcessImpl extends SubProcessImpl implements AdHocSubProcess {

  protected static Attribute<String> orderingAttribute;
  protected static Attribute<Boolean> cancelRemainingInstancesAttribute;
  protected static ChildElement<CompletionCondition> completionConditionChild;

  public static void registerType(ModelBuilder modelBuilder) {
    ModelElementTypeBuilder typeBuilder = modelBuilder
      .defineType(AdHocSubProcess.class, BPMN_ELEMENT_AD_HOC_SUB_PROCESS)
      .namespaceUri(BPMN20_NS)
      .extendsType(SubProcess.class)
      .instanceProvider(new ModelElementTypeBuilder.ModelTypeInstanceProvider<AdHocSubProcess>() {
        public AdHocSubProcess newInstance(ModelTypeInstanceContext instanceContext) {
          return new AdHocSubProcessImpl(instanceContext);
        }
      });

    orderingAttribute = typeBuilder.stringAttribute(BPMN_ATTRIBUTE_ORDERING)
      .defaultValue("Parallel")
      .build();

    cancelRemainingInstancesAttribute = typeBuilder.booleanAttribute(BPMN_ATTRIBUTE_CANCEL_REMAINING_INSTANCES)
      .defaultValue(true)
      .build();

    SequenceBuilder sequenceBuilder = typeBuilder.sequence();

    completionConditionChild = sequenceBuilder.element(CompletionCondition.class)
      .minOccurs(0)
      .maxOccurs(1)
      .build();

    typeBuilder.build();
  }

  public AdHocSubProcessImpl(ModelTypeInstanceContext instanceContext) {
    super(instanceContext);
  }

  @Override
  public String getOrdering() {
    return orderingAttribute.getValue(this);
  }

  @Override
  public void setOrdering(String ordering) {
    orderingAttribute.setValue(this, ordering);
  }

  @Override
  public boolean isCancelRemainingInstances() {
    Boolean value = cancelRemainingInstancesAttribute.getValue(this);
    return value == null ? true : value;
  }

  @Override
  public void setCancelRemainingInstances(boolean cancelRemainingInstances) {
    cancelRemainingInstancesAttribute.setValue(this, cancelRemainingInstances);
  }

  @Override
  public CompletionCondition getCompletionCondition() {
    return completionConditionChild.getChild(this);
  }

  @Override
  public void setCompletionCondition(CompletionCondition completionCondition) {
    completionConditionChild.setChild(this, completionCondition);
  }

}
