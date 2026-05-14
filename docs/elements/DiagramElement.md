---
search:
  boost: 10.0
---

# Class: DiagramElement 


_The DI DiagramElement element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:DiagramElement](https://w3id.org/TD-Universe/fluxnova-bpm-platform/DiagramElement)





```mermaid
 classDiagram
    class DiagramElement
    click DiagramElement href "../DiagramElement/"
      BpmnModelElementInstance <|-- DiagramElement
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
      

      DiagramElement <|-- Edge
        click Edge href "../Edge/"
      DiagramElement <|-- Node
        click Node href "../Node/"
      

      DiagramElement : extension
        
          
    
        
        
        DiagramElement --> "0..1" Extension : extension
        click Extension href "../Extension/"
    

        
      DiagramElement : id
        
      DiagramElement : scope
        
          
    
        
        
        DiagramElement --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * **DiagramElement**
        * [Edge](Edge.md)
        * [Node](Node.md)


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | direct |
| [extension](extension.md) | 0..1 <br/> [Extension](Extension.md) | Extension element containing additional diagram information | direct |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Plane](Plane.md) | [diagram_elements](diagram_elements.md) | range | [DiagramElement](DiagramElement.md) |
| [ActivationCondition](ActivationCondition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Activity](Activity.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Artifact](Artifact.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Assignment](Assignment.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Association](Association.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Auditing](Auditing.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [BaseElement](BaseElement.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [BoundaryEvent](BoundaryEvent.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CallActivity](CallActivity.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CallConversation](CallConversation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CallableElement](CallableElement.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CancelEventDefinition](CancelEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CatchEvent](CatchEvent.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Category](Category.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CategoryValue](CategoryValue.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Collaboration](Collaboration.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CompensateEventDefinition](CompensateEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CompletionCondition](CompletionCondition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ComplexBehaviorDefinition](ComplexBehaviorDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ComplexGateway](ComplexGateway.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Condition](Condition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ConditionExpression](ConditionExpression.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ConditionalEventDefinition](ConditionalEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Conversation](Conversation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ConversationAssociation](ConversationAssociation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ConversationLink](ConversationLink.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ConversationNode](ConversationNode.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CorrelationKey](CorrelationKey.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CorrelationProperty](CorrelationProperty.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CorrelationPropertyBinding](CorrelationPropertyBinding.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CorrelationPropertyRetrievalExpression](CorrelationPropertyRetrievalExpression.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [CorrelationSubscription](CorrelationSubscription.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [DataAssociation](DataAssociation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [DataInput](DataInput.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [DataInputAssociation](DataInputAssociation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [DataObject](DataObject.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [DataObjectReference](DataObjectReference.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [DataOutput](DataOutput.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [DataOutputAssociation](DataOutputAssociation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [DataState](DataState.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [DataStore](DataStore.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [DataStoreReference](DataStoreReference.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [EndEvent](EndEvent.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [EndPoint](EndPoint.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Error](Error.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ErrorEventDefinition](ErrorEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Escalation](Escalation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [EscalationEventDefinition](EscalationEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Event](Event.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [EventBasedGateway](EventBasedGateway.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [EventDefinition](EventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ExclusiveGateway](ExclusiveGateway.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Expression](Expression.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [FlowElement](FlowElement.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [FlowNode](FlowNode.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [FormalExpression](FormalExpression.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Gateway](Gateway.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [GlobalConversation](GlobalConversation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [BpmnGroup](BpmnGroup.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [HumanPerformer](HumanPerformer.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [InclusiveGateway](InclusiveGateway.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [InputDataItem](InputDataItem.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [InputSet](InputSet.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Interface](Interface.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [IoBinding](IoBinding.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [IoSpecification](IoSpecification.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ItemAwareElement](ItemAwareElement.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ItemDefinition](ItemDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Lane](Lane.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [LaneSet](LaneSet.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [LinkEventDefinition](LinkEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [LoopCardinality](LoopCardinality.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [LoopCharacteristics](LoopCharacteristics.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ManualTask](ManualTask.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Message](Message.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [MessageEventDefinition](MessageEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [MessageFlow](MessageFlow.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [MessageFlowAssociation](MessageFlowAssociation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Monitoring](Monitoring.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [MultiInstanceLoopCharacteristics](MultiInstanceLoopCharacteristics.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Operation](Operation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [OutputDataItem](OutputDataItem.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [OutputSet](OutputSet.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ParallelGateway](ParallelGateway.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Participant](Participant.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ParticipantAssociation](ParticipantAssociation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ParticipantMultiplicity](ParticipantMultiplicity.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Performer](Performer.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [PotentialOwner](PotentialOwner.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Process](Process.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [BpmnProperty](BpmnProperty.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ReceiveTask](ReceiveTask.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Relationship](Relationship.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Rendering](Rendering.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Resource](Resource.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ResourceAssignmentExpression](ResourceAssignmentExpression.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ResourceParameter](ResourceParameter.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ResourceParameterBinding](ResourceParameterBinding.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ResourceRole](ResourceRole.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [RootElement](RootElement.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ScriptTask](ScriptTask.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [SendTask](SendTask.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [SequenceFlow](SequenceFlow.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ServiceTask](ServiceTask.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Signal](Signal.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [SignalEventDefinition](SignalEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [StartEvent](StartEvent.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [SubConversation](SubConversation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [SubProcess](SubProcess.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [BpmnTask](BpmnTask.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [TerminateEventDefinition](TerminateEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [TextAnnotation](TextAnnotation.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [ThrowEvent](ThrowEvent.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [TimeCycle](TimeCycle.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [TimeDate](TimeDate.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [TimeDuration](TimeDuration.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [TimerEventDefinition](TimerEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [Transaction](Transaction.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [UserTask](UserTask.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |
| [BpmnEdge](BpmnEdge.md) | [source_element](source_element.md) | range | [DiagramElement](DiagramElement.md) |
| [BpmnEdge](BpmnEdge.md) | [target_element](target_element.md) | range | [DiagramElement](DiagramElement.md) |
| [BpmnPlane](BpmnPlane.md) | [diagram_elements](diagram_elements.md) | range | [DiagramElement](DiagramElement.md) |
| [FluxnovaErrorEventDefinition](FluxnovaErrorEventDefinition.md) | [diagram_element](diagram_element.md) | range | [DiagramElement](DiagramElement.md) |








## In Subsets


* [Di](Di.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance.di |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/di/DiagramElement.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:DiagramElement |
| native | fluxnova_bpm_platform:DiagramElement |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: DiagramElement
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.di
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/di/DiagramElement.java
description: The DI DiagramElement element
in_subset:
- di
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
slots:
- id
- extension

```
</details>

### Induced

<details>
```yaml
name: DiagramElement
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance.di
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/di/DiagramElement.java
description: The DI DiagramElement element
in_subset:
- di
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnModelElementInstance
attributes:
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: DiagramElement
    domain_of:
    - ByteArray
    - MeterLog
    - SchemaLogEntry
    - TaskMeterLog
    - Authorization
    - Group
    - IdentityInfo
    - IdentityLink
    - Tenant
    - TenantMembership
    - User
    - CaseExecution
    - CaseSentryPart
    - EventSubscription
    - Execution
    - ExternalTask
    - Incident
    - Task
    - VariableInstance
    - Attachment
    - Comment
    - Filter
    - Deployment
    - ResourceDefinition
    - Batch
    - Job
    - JobDefinition
    - HistoricBatch
    - HistoricDecisionInputInstance
    - HistoricDecisionInstance
    - HistoricDecisionOutputInstance
    - HistoricDetail
    - HistoricExternalTaskLog
    - HistoricIdentityLink
    - HistoricIncident
    - HistoricJobLog
    - HistoricScopeInstance
    - HistoricVariableInstance
    - UserOperationLogEntry
    - Diagram
    - DiagramElement
    - Style
    - BaseElement
    - Definitions
    - Documentation
    - InteractionNode
    range: string
    required: true
  extension:
    name: extension
    description: Extension element containing additional diagram information.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DiagramElement
    domain_of:
    - DiagramElement
    range: Extension
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: DiagramElement
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>