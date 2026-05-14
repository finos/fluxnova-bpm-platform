---
search:
  boost: 10.0
---

# Class: FlowNode 


_The BPMN flowNode element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:FlowNode](https://w3id.org/TD-Universe/fluxnova-bpm-platform/FlowNode)





```mermaid
 classDiagram
    class FlowNode
    click FlowNode href "../FlowNode/"
      FlowElement <|-- FlowNode
        click FlowElement href "../FlowElement/"
      

      FlowNode <|-- Activity
        click Activity href "../Activity/"
      FlowNode <|-- Event
        click Event href "../Event/"
      FlowNode <|-- Gateway
        click Gateway href "../Gateway/"
      

      FlowNode : auditing
        
          
    
        
        
        FlowNode --> "0..1" Auditing : auditing
        click Auditing href "../Auditing/"
    

        
      FlowNode : category_value_refs
        
          
    
        
        
        FlowNode --> "*" CategoryValue : category_value_refs
        click CategoryValue href "../CategoryValue/"
    

        
      FlowNode : diagram_element
        
          
    
        
        
        FlowNode --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      FlowNode : documentations
        
          
    
        
        
        FlowNode --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      FlowNode : extension_elements
        
          
    
        
        
        FlowNode --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      FlowNode : fluxnova_async_after
        
      FlowNode : fluxnova_async_before
        
      FlowNode : fluxnova_exclusive
        
      FlowNode : fluxnova_job_priority
        
      FlowNode : id
        
      FlowNode : incoming
        
          
    
        
        
        FlowNode --> "*" SequenceFlow : incoming
        click SequenceFlow href "../SequenceFlow/"
    

        
      FlowNode : monitoring
        
          
    
        
        
        FlowNode --> "0..1" Monitoring : monitoring
        click Monitoring href "../Monitoring/"
    

        
      FlowNode : name
        
      FlowNode : outgoing
        
          
    
        
        
        FlowNode --> "*" SequenceFlow : outgoing
        click SequenceFlow href "../SequenceFlow/"
    

        
      FlowNode : previous_nodes
        
          
    
        
        
        FlowNode --> "0..1" FlowNode : previous_nodes
        click FlowNode href "../FlowNode/"
    

        
      FlowNode : scope
        
          
    
        
        
        FlowNode --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      FlowNode : succeeding_nodes
        
          
    
        
        
        FlowNode --> "0..1" FlowNode : succeeding_nodes
        click FlowNode href "../FlowNode/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [FlowElement](FlowElement.md)
            * **FlowNode**
                * [Activity](Activity.md) [ [InteractionNode](InteractionNode.md)]
                * [Event](Event.md) [ [InteractionNode](InteractionNode.md)]
                * [Gateway](Gateway.md)


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [incoming](incoming.md) | * <br/> [SequenceFlow](SequenceFlow.md) | Sequence flows entering this flow node | direct |
| [outgoing](outgoing.md) | * <br/> [SequenceFlow](SequenceFlow.md) | Sequence flows leaving this flow node | direct |
| [previous_nodes](previous_nodes.md) | 0..1 <br/> [FlowNode](FlowNode.md) | The previous nodes of this element | direct |
| [succeeding_nodes](succeeding_nodes.md) | 0..1 <br/> [FlowNode](FlowNode.md) | The succeeding nodes of this element | direct |
| [fluxnova_async_before](fluxnova_async_before.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether this element is executed asynchronously before its start | direct |
| [fluxnova_async_after](fluxnova_async_after.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether this element is executed asynchronously after its end | direct |
| [fluxnova_exclusive](fluxnova_exclusive.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether this element participates in an exclusive job execution | direct |
| [fluxnova_job_priority](fluxnova_job_priority.md) | 0..1 <br/> [String](String.md) | Priority assigned to async continuation jobs for this element | direct |
| [name](name.md) | 0..1 <br/> [String](String.md) | Human-readable name | [FlowElement](FlowElement.md) |
| [auditing](auditing.md) | 0..1 <br/> [Auditing](Auditing.md) | Auditing information attached to this flow element | [FlowElement](FlowElement.md) |
| [monitoring](monitoring.md) | 0..1 <br/> [Monitoring](Monitoring.md) | Monitoring information attached to this flow element | [FlowElement](FlowElement.md) |
| [category_value_refs](category_value_refs.md) | * <br/> [CategoryValue](CategoryValue.md) | Category values associated with this flow element | [FlowElement](FlowElement.md) |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [BaseElement](BaseElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [Activity](Activity.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [Activity](Activity.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [BoundaryEvent](BoundaryEvent.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [BoundaryEvent](BoundaryEvent.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [CallActivity](CallActivity.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [CallActivity](CallActivity.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [CatchEvent](CatchEvent.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [CatchEvent](CatchEvent.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ComplexGateway](ComplexGateway.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ComplexGateway](ComplexGateway.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [EndEvent](EndEvent.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [EndEvent](EndEvent.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [Event](Event.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [Event](Event.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [EventBasedGateway](EventBasedGateway.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [EventBasedGateway](EventBasedGateway.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ExclusiveGateway](ExclusiveGateway.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ExclusiveGateway](ExclusiveGateway.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [FlowNode](FlowNode.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [FlowNode](FlowNode.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [Gateway](Gateway.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [Gateway](Gateway.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [InclusiveGateway](InclusiveGateway.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [InclusiveGateway](InclusiveGateway.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [Lane](Lane.md) | [flow_node_refs](flow_node_refs.md) | range | [FlowNode](FlowNode.md) |
| [ManualTask](ManualTask.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ManualTask](ManualTask.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ParallelGateway](ParallelGateway.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ParallelGateway](ParallelGateway.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ReceiveTask](ReceiveTask.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ReceiveTask](ReceiveTask.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ScriptTask](ScriptTask.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ScriptTask](ScriptTask.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [SendTask](SendTask.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [SendTask](SendTask.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [SequenceFlow](SequenceFlow.md) | [source](source.md) | range | [FlowNode](FlowNode.md) |
| [SequenceFlow](SequenceFlow.md) | [target](target.md) | range | [FlowNode](FlowNode.md) |
| [ServiceTask](ServiceTask.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ServiceTask](ServiceTask.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [StartEvent](StartEvent.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [StartEvent](StartEvent.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [SubProcess](SubProcess.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [SubProcess](SubProcess.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [BpmnTask](BpmnTask.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [BpmnTask](BpmnTask.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ThrowEvent](ThrowEvent.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [ThrowEvent](ThrowEvent.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [Transaction](Transaction.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [Transaction](Transaction.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |
| [UserTask](UserTask.md) | [previous_nodes](previous_nodes.md) | range | [FlowNode](FlowNode.md) |
| [UserTask](UserTask.md) | [succeeding_nodes](succeeding_nodes.md) | range | [FlowNode](FlowNode.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/FlowNode.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:FlowNode |
| native | fluxnova_bpm_platform:FlowNode |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: FlowNode
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/FlowNode.java
description: The BPMN flowNode element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: FlowElement
slots:
- incoming
- outgoing
- previous_nodes
- succeeding_nodes
- fluxnova_async_before
- fluxnova_async_after
- fluxnova_exclusive
- fluxnova_job_priority

```
</details>

### Induced

<details>
```yaml
name: FlowNode
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/FlowNode.java
description: The BPMN flowNode element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: FlowElement
attributes:
  incoming:
    name: incoming
    description: Sequence flows entering this flow node.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowNode
    range: SequenceFlow
    multivalued: true
    inlined: true
    inlined_as_list: true
  outgoing:
    name: outgoing
    description: Sequence flows leaving this flow node.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowNode
    range: SequenceFlow
    multivalued: true
    inlined: true
    inlined_as_list: true
  previous_nodes:
    name: previous_nodes
    description: The previous nodes of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowNode
    range: FlowNode
  succeeding_nodes:
    name: succeeding_nodes
    description: The succeeding nodes of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowNode
    range: FlowNode
  fluxnova_async_before:
    name: fluxnova_async_before
    description: Whether this element is executed asynchronously before its start.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowNode
    - MultiInstanceLoopCharacteristics
    range: boolean
  fluxnova_async_after:
    name: fluxnova_async_after
    description: Whether this element is executed asynchronously after its end.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowNode
    - MultiInstanceLoopCharacteristics
    range: boolean
  fluxnova_exclusive:
    name: fluxnova_exclusive
    description: Whether this element participates in an exclusive job execution.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowNode
    - MultiInstanceLoopCharacteristics
    range: boolean
  fluxnova_job_priority:
    name: fluxnova_job_priority
    description: Priority assigned to async continuation jobs for this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowNode
    - Process
    range: string
  name:
    name: name
    description: Human-readable name.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:name
    owner: FlowNode
    domain_of:
    - ByteArray
    - MeterLog
    - Property
    - Group
    - Tenant
    - Task
    - VariableInstance
    - Attachment
    - Filter
    - Deployment
    - ResourceDefinition
    - HistoricDetail
    - HistoricTaskInstance
    - HistoricVariableInstance
    - Font
    - Diagram
    - CallableElement
    - Category
    - Collaboration
    - ConversationLink
    - ConversationNode
    - CorrelationKey
    - CorrelationProperty
    - DataInput
    - DataOutput
    - DataState
    - DataStore
    - Definitions
    - Error
    - Escalation
    - FlowElement
    - InputSet
    - Interface
    - Lane
    - LaneSet
    - LinkEventDefinition
    - Message
    - MessageFlow
    - Operation
    - OutputSet
    - Participant
    - BpmnProperty
    - Resource
    - ResourceParameter
    - ResourceRole
    - Signal
    range: string
  auditing:
    name: auditing
    description: Auditing information attached to this flow element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowElement
    - Process
    range: Auditing
  monitoring:
    name: monitoring
    description: Monitoring information attached to this flow element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowElement
    - Process
    range: Monitoring
  category_value_refs:
    name: category_value_refs
    description: Category values associated with this flow element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - FlowElement
    range: CategoryValue
    multivalued: true
    inlined: true
    inlined_as_list: true
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: FlowNode
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
  documentations:
    name: documentations
    description: Collection of documentation elements associated with this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - BaseElement
    range: Documentation
    multivalued: true
    inlined: true
    inlined_as_list: true
  extension_elements:
    name: extension_elements
    description: Extension elements holding vendor-specific metadata.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: FlowNode
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>