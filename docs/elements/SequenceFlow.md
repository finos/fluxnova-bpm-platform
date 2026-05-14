---
search:
  boost: 10.0
---

# Class: SequenceFlow 


_The BPMN sequenceFlow element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:SequenceFlow](https://w3id.org/TD-Universe/fluxnova-bpm-platform/SequenceFlow)





```mermaid
 classDiagram
    class SequenceFlow
    click SequenceFlow href "../SequenceFlow/"
      FlowElement <|-- SequenceFlow
        click FlowElement href "../FlowElement/"
      
      SequenceFlow : auditing
        
          
    
        
        
        SequenceFlow --> "0..1" Auditing : auditing
        click Auditing href "../Auditing/"
    

        
      SequenceFlow : category_value_refs
        
          
    
        
        
        SequenceFlow --> "*" CategoryValue : category_value_refs
        click CategoryValue href "../CategoryValue/"
    

        
      SequenceFlow : condition_expression
        
          
    
        
        
        SequenceFlow --> "0..1" ConditionExpression : condition_expression
        click ConditionExpression href "../ConditionExpression/"
    

        
      SequenceFlow : diagram_element
        
          
    
        
        
        SequenceFlow --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      SequenceFlow : documentations
        
          
    
        
        
        SequenceFlow --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      SequenceFlow : extension_elements
        
          
    
        
        
        SequenceFlow --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      SequenceFlow : id
        
      SequenceFlow : immediate
        
      SequenceFlow : monitoring
        
          
    
        
        
        SequenceFlow --> "0..1" Monitoring : monitoring
        click Monitoring href "../Monitoring/"
    

        
      SequenceFlow : name
        
      SequenceFlow : scope
        
          
    
        
        
        SequenceFlow --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      SequenceFlow : source
        
          
    
        
        
        SequenceFlow --> "0..1" FlowNode : source
        click FlowNode href "../FlowNode/"
    

        
      SequenceFlow : target
        
          
    
        
        
        SequenceFlow --> "0..1" FlowNode : target
        click FlowNode href "../FlowNode/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [FlowElement](FlowElement.md)
            * **SequenceFlow**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [source](source.md) | 0..1 <br/> [FlowNode](FlowNode.md) | The source | direct |
| [target](target.md) | 0..1 <br/> [FlowNode](FlowNode.md) | The catching link event that receives this link | direct |
| [immediate](immediate.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether immediate | direct |
| [condition_expression](condition_expression.md) | 0..1 <br/> [ConditionExpression](ConditionExpression.md) | Expression evaluated to decide whether this flow is taken | direct |
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
| [Activity](Activity.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [Activity](Activity.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [Activity](Activity.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [BoundaryEvent](BoundaryEvent.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [BoundaryEvent](BoundaryEvent.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [BusinessRuleTask](BusinessRuleTask.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [CallActivity](CallActivity.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [CallActivity](CallActivity.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [CallActivity](CallActivity.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [CatchEvent](CatchEvent.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [CatchEvent](CatchEvent.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ComplexGateway](ComplexGateway.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ComplexGateway](ComplexGateway.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ComplexGateway](ComplexGateway.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [EndEvent](EndEvent.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [EndEvent](EndEvent.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [Event](Event.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [Event](Event.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [EventBasedGateway](EventBasedGateway.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [EventBasedGateway](EventBasedGateway.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ExclusiveGateway](ExclusiveGateway.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ExclusiveGateway](ExclusiveGateway.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ExclusiveGateway](ExclusiveGateway.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [FlowNode](FlowNode.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [FlowNode](FlowNode.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [Gateway](Gateway.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [Gateway](Gateway.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [InclusiveGateway](InclusiveGateway.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [InclusiveGateway](InclusiveGateway.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [InclusiveGateway](InclusiveGateway.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ManualTask](ManualTask.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ManualTask](ManualTask.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ManualTask](ManualTask.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ParallelGateway](ParallelGateway.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ParallelGateway](ParallelGateway.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ReceiveTask](ReceiveTask.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ReceiveTask](ReceiveTask.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ReceiveTask](ReceiveTask.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ScriptTask](ScriptTask.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ScriptTask](ScriptTask.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ScriptTask](ScriptTask.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [SendTask](SendTask.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [SendTask](SendTask.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [SendTask](SendTask.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ServiceTask](ServiceTask.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ServiceTask](ServiceTask.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ServiceTask](ServiceTask.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [StartEvent](StartEvent.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [StartEvent](StartEvent.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [SubProcess](SubProcess.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [SubProcess](SubProcess.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [SubProcess](SubProcess.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [BpmnTask](BpmnTask.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [BpmnTask](BpmnTask.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [BpmnTask](BpmnTask.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ThrowEvent](ThrowEvent.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [ThrowEvent](ThrowEvent.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [Transaction](Transaction.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [Transaction](Transaction.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [Transaction](Transaction.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |
| [UserTask](UserTask.md) | [default](default.md) | range | [SequenceFlow](SequenceFlow.md) |
| [UserTask](UserTask.md) | [incoming](incoming.md) | range | [SequenceFlow](SequenceFlow.md) |
| [UserTask](UserTask.md) | [outgoing](outgoing.md) | range | [SequenceFlow](SequenceFlow.md) |








## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/SequenceFlow.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:SequenceFlow |
| native | fluxnova_bpm_platform:SequenceFlow |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: SequenceFlow
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/SequenceFlow.java
description: The BPMN sequenceFlow element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: FlowElement
slots:
- source
- target
- immediate
- condition_expression
slot_usage:
  source:
    name: source
    range: FlowNode
  target:
    name: target
    range: FlowNode

```
</details>

### Induced

<details>
```yaml
name: SequenceFlow
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/SequenceFlow.java
description: The BPMN sequenceFlow element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: FlowElement
slot_usage:
  source:
    name: source
    range: FlowNode
  target:
    name: target
    range: FlowNode
attributes:
  source:
    name: source
    annotations:
      sql_column:
        tag: sql_column
        value: SOURCE_
    description: The source.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SequenceFlow
    domain_of:
    - CaseSentryPart
    - Deployment
    - Association
    - ConversationLink
    - MessageFlow
    - SequenceFlow
    range: FlowNode
  target:
    name: target
    description: The catching link event that receives this link.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SequenceFlow
    domain_of:
    - Association
    - ConversationLink
    - DataAssociation
    - LinkEventDefinition
    - MessageFlow
    - SequenceFlow
    range: FlowNode
  immediate:
    name: immediate
    description: Whether immediate.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SequenceFlow
    domain_of:
    - SequenceFlow
    range: boolean
  condition_expression:
    name: condition_expression
    description: Expression evaluated to decide whether this flow is taken.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SequenceFlow
    domain_of:
    - SequenceFlow
    range: ConditionExpression
  name:
    name: name
    description: Human-readable name.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:name
    owner: SequenceFlow
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
    owner: SequenceFlow
    domain_of:
    - FlowElement
    - Process
    range: Auditing
  monitoring:
    name: monitoring
    description: Monitoring information attached to this flow element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SequenceFlow
    domain_of:
    - FlowElement
    - Process
    range: Monitoring
  category_value_refs:
    name: category_value_refs
    description: Category values associated with this flow element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SequenceFlow
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
    owner: SequenceFlow
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
    owner: SequenceFlow
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
    owner: SequenceFlow
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SequenceFlow
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SequenceFlow
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>