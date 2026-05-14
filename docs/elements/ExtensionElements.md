---
search:
  boost: 10.0
---

# Class: ExtensionElements 


_The BPMN extensionElements element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:ExtensionElements](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ExtensionElements)





```mermaid
 classDiagram
    class ExtensionElements
    click ExtensionElements href "../ExtensionElements/"
      BpmnModelElementInstance <|-- ExtensionElements
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      
      ExtensionElements : elements
        
      ExtensionElements : elements_query
        
      ExtensionElements : scope
        
          
    
        
        
        ExtensionElements --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **ExtensionElements**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [elements](elements.md) | * <br/> [String](String.md) | Collection of elements values | direct |
| [elements_query](elements_query.md) | 0..1 <br/> [String](String.md) | The elements query of this element | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [ActivationCondition](ActivationCondition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Activity](Activity.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Artifact](Artifact.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Assignment](Assignment.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Association](Association.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Auditing](Auditing.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [BaseElement](BaseElement.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [BoundaryEvent](BoundaryEvent.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CallActivity](CallActivity.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CallConversation](CallConversation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CallableElement](CallableElement.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CancelEventDefinition](CancelEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CatchEvent](CatchEvent.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Category](Category.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CategoryValue](CategoryValue.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Collaboration](Collaboration.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CompensateEventDefinition](CompensateEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CompletionCondition](CompletionCondition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ComplexBehaviorDefinition](ComplexBehaviorDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ComplexGateway](ComplexGateway.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Condition](Condition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ConditionExpression](ConditionExpression.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ConditionalEventDefinition](ConditionalEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Conversation](Conversation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ConversationAssociation](ConversationAssociation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ConversationLink](ConversationLink.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ConversationNode](ConversationNode.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CorrelationKey](CorrelationKey.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CorrelationProperty](CorrelationProperty.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CorrelationPropertyBinding](CorrelationPropertyBinding.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CorrelationPropertyRetrievalExpression](CorrelationPropertyRetrievalExpression.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [CorrelationSubscription](CorrelationSubscription.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [DataAssociation](DataAssociation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [DataInput](DataInput.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [DataInputAssociation](DataInputAssociation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [DataObject](DataObject.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [DataObjectReference](DataObjectReference.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [DataOutput](DataOutput.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [DataOutputAssociation](DataOutputAssociation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [DataState](DataState.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [DataStore](DataStore.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [DataStoreReference](DataStoreReference.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [EndEvent](EndEvent.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [EndPoint](EndPoint.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Error](Error.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ErrorEventDefinition](ErrorEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Escalation](Escalation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [EscalationEventDefinition](EscalationEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Event](Event.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [EventBasedGateway](EventBasedGateway.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [EventDefinition](EventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ExclusiveGateway](ExclusiveGateway.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Expression](Expression.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [FlowElement](FlowElement.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [FlowNode](FlowNode.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [FormalExpression](FormalExpression.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Gateway](Gateway.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [GlobalConversation](GlobalConversation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [BpmnGroup](BpmnGroup.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [HumanPerformer](HumanPerformer.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [InclusiveGateway](InclusiveGateway.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [InputDataItem](InputDataItem.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [InputSet](InputSet.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Interface](Interface.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [IoBinding](IoBinding.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [IoSpecification](IoSpecification.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ItemAwareElement](ItemAwareElement.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ItemDefinition](ItemDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Lane](Lane.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [LaneSet](LaneSet.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [LinkEventDefinition](LinkEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [LoopCardinality](LoopCardinality.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [LoopCharacteristics](LoopCharacteristics.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ManualTask](ManualTask.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Message](Message.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [MessageEventDefinition](MessageEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [MessageFlow](MessageFlow.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [MessageFlowAssociation](MessageFlowAssociation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Monitoring](Monitoring.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [MultiInstanceLoopCharacteristics](MultiInstanceLoopCharacteristics.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Operation](Operation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [OutputDataItem](OutputDataItem.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [OutputSet](OutputSet.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ParallelGateway](ParallelGateway.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Participant](Participant.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ParticipantAssociation](ParticipantAssociation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ParticipantMultiplicity](ParticipantMultiplicity.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Performer](Performer.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [PotentialOwner](PotentialOwner.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Process](Process.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [BpmnProperty](BpmnProperty.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ReceiveTask](ReceiveTask.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Relationship](Relationship.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Rendering](Rendering.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Resource](Resource.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ResourceAssignmentExpression](ResourceAssignmentExpression.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ResourceParameter](ResourceParameter.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ResourceParameterBinding](ResourceParameterBinding.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ResourceRole](ResourceRole.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [RootElement](RootElement.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ScriptTask](ScriptTask.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [SendTask](SendTask.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [SequenceFlow](SequenceFlow.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ServiceTask](ServiceTask.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Signal](Signal.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [SignalEventDefinition](SignalEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [StartEvent](StartEvent.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [SubConversation](SubConversation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [SubProcess](SubProcess.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [BpmnTask](BpmnTask.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [TerminateEventDefinition](TerminateEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [TextAnnotation](TextAnnotation.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [ThrowEvent](ThrowEvent.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [TimeCycle](TimeCycle.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [TimeDate](TimeDate.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [TimeDuration](TimeDuration.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [TimerEventDefinition](TimerEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [Transaction](Transaction.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [UserTask](UserTask.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |
| [FluxnovaErrorEventDefinition](FluxnovaErrorEventDefinition.md) | [extension_elements](extension_elements.md) | range | [ExtensionElements](ExtensionElements.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ExtensionElements.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:ExtensionElements |
| native | fluxnova_bpm_platform:ExtensionElements |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: ExtensionElements
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ExtensionElements.java
description: The BPMN extensionElements element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- elements
- elements_query

```
</details>

### Induced

<details>
```yaml
name: ExtensionElements
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/ExtensionElements.java
description: The BPMN extensionElements element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  elements:
    name: elements
    description: Collection of elements values.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ExtensionElements
    domain_of:
    - ExtensionElements
    range: string
    multivalued: true
  elements_query:
    name: elements_query
    description: The elements query of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ExtensionElements
    domain_of:
    - ExtensionElements
    range: string
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ExtensionElements
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>