---
search:
  boost: 10.0
---

# Class: BusinessRuleTask 


_The BPMN businessRuleTask element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:BusinessRuleTask](https://w3id.org/TD-Universe/fluxnova-bpm-platform/BusinessRuleTask)





```mermaid
 classDiagram
    class BusinessRuleTask
    click BusinessRuleTask href "../BusinessRuleTask/"
      BpmnTask <|-- BusinessRuleTask
        click BpmnTask href "../BpmnTask/"
      
      BusinessRuleTask : auditing
        
          
    
        
        
        BusinessRuleTask --> "0..1" Auditing : auditing
        click Auditing href "../Auditing/"
    

        
      BusinessRuleTask : category_value_refs
        
          
    
        
        
        BusinessRuleTask --> "*" CategoryValue : category_value_refs
        click CategoryValue href "../CategoryValue/"
    

        
      BusinessRuleTask : completion_quantity
        
      BusinessRuleTask : data_input_associations
        
          
    
        
        
        BusinessRuleTask --> "*" DataInputAssociation : data_input_associations
        click DataInputAssociation href "../DataInputAssociation/"
    

        
      BusinessRuleTask : data_output_associations
        
          
    
        
        
        BusinessRuleTask --> "*" DataOutputAssociation : data_output_associations
        click DataOutputAssociation href "../DataOutputAssociation/"
    

        
      BusinessRuleTask : default
        
          
    
        
        
        BusinessRuleTask --> "0..1" SequenceFlow : default
        click SequenceFlow href "../SequenceFlow/"
    

        
      BusinessRuleTask : diagram_element
        
          
    
        
        
        BusinessRuleTask --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      BusinessRuleTask : documentations
        
          
    
        
        
        BusinessRuleTask --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      BusinessRuleTask : extension_elements
        
          
    
        
        
        BusinessRuleTask --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      BusinessRuleTask : fluxnova_async
        
      BusinessRuleTask : fluxnova_async_after
        
      BusinessRuleTask : fluxnova_async_before
        
      BusinessRuleTask : fluxnova_class
        
      BusinessRuleTask : fluxnova_decision_ref
        
      BusinessRuleTask : fluxnova_decision_ref_binding
        
      BusinessRuleTask : fluxnova_decision_ref_tenant_id
        
      BusinessRuleTask : fluxnova_decision_ref_version
        
      BusinessRuleTask : fluxnova_decision_ref_version_tag
        
      BusinessRuleTask : fluxnova_delegate_expression
        
      BusinessRuleTask : fluxnova_exclusive
        
      BusinessRuleTask : fluxnova_expression
        
      BusinessRuleTask : fluxnova_job_priority
        
      BusinessRuleTask : fluxnova_map_decision_result
        
      BusinessRuleTask : fluxnova_result_variable
        
      BusinessRuleTask : fluxnova_task_priority
        
      BusinessRuleTask : fluxnova_topic
        
      BusinessRuleTask : fluxnova_type
        
      BusinessRuleTask : for_compensation
        
      BusinessRuleTask : id
        
      BusinessRuleTask : implementation
        
      BusinessRuleTask : incoming
        
          
    
        
        
        BusinessRuleTask --> "*" SequenceFlow : incoming
        click SequenceFlow href "../SequenceFlow/"
    

        
      BusinessRuleTask : io_specification
        
          
    
        
        
        BusinessRuleTask --> "0..1" IoSpecification : io_specification
        click IoSpecification href "../IoSpecification/"
    

        
      BusinessRuleTask : loop_characteristics
        
          
    
        
        
        BusinessRuleTask --> "0..1" LoopCharacteristics : loop_characteristics
        click LoopCharacteristics href "../LoopCharacteristics/"
    

        
      BusinessRuleTask : monitoring
        
          
    
        
        
        BusinessRuleTask --> "0..1" Monitoring : monitoring
        click Monitoring href "../Monitoring/"
    

        
      BusinessRuleTask : name
        
      BusinessRuleTask : outgoing
        
          
    
        
        
        BusinessRuleTask --> "*" SequenceFlow : outgoing
        click SequenceFlow href "../SequenceFlow/"
    

        
      BusinessRuleTask : previous_nodes
        
          
    
        
        
        BusinessRuleTask --> "0..1" FlowNode : previous_nodes
        click FlowNode href "../FlowNode/"
    

        
      BusinessRuleTask : properties
        
          
    
        
        
        BusinessRuleTask --> "*" BpmnProperty : properties
        click BpmnProperty href "../BpmnProperty/"
    

        
      BusinessRuleTask : resource_roles
        
          
    
        
        
        BusinessRuleTask --> "*" ResourceRole : resource_roles
        click ResourceRole href "../ResourceRole/"
    

        
      BusinessRuleTask : scope
        
          
    
        
        
        BusinessRuleTask --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      BusinessRuleTask : start_quantity
        
      BusinessRuleTask : succeeding_nodes
        
          
    
        
        
        BusinessRuleTask --> "0..1" FlowNode : succeeding_nodes
        click FlowNode href "../FlowNode/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [FlowElement](FlowElement.md)
            * [FlowNode](FlowNode.md)
                * [Activity](Activity.md) [ [InteractionNode](InteractionNode.md)]
                    * [BpmnTask](BpmnTask.md)
                        * **BusinessRuleTask**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [implementation](implementation.md) | 0..1 <br/> [String](String.md) | Implementation technology of this service or send/receive task | direct |
| [fluxnova_class](fluxnova_class.md) | 0..1 <br/> [String](String.md) | Camunda extensions | direct |
| [fluxnova_delegate_expression](fluxnova_delegate_expression.md) | 0..1 <br/> [String](String.md) | Expression resolving to a JavaDelegate | direct |
| [fluxnova_expression](fluxnova_expression.md) | 0..1 <br/> [String](String.md) | EL expression for this element | direct |
| [fluxnova_result_variable](fluxnova_result_variable.md) | 0..1 <br/> [String](String.md) | Process variable to store the expression result | direct |
| [fluxnova_type](fluxnova_type.md) | 0..1 <br/> [String](String.md) | Type name for this form field or listener | direct |
| [fluxnova_topic](fluxnova_topic.md) | 0..1 <br/> [String](String.md) | External task topic name | direct |
| [fluxnova_decision_ref](fluxnova_decision_ref.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: decision ref | direct |
| [fluxnova_decision_ref_binding](fluxnova_decision_ref_binding.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: decision ref binding | direct |
| [fluxnova_decision_ref_version](fluxnova_decision_ref_version.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: decision ref version | direct |
| [fluxnova_decision_ref_version_tag](fluxnova_decision_ref_version_tag.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: decision ref version tag | direct |
| [fluxnova_decision_ref_tenant_id](fluxnova_decision_ref_tenant_id.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: decision ref tenant id | direct |
| [fluxnova_map_decision_result](fluxnova_map_decision_result.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: map decision result | direct |
| [fluxnova_task_priority](fluxnova_task_priority.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: task priority | direct |
| [fluxnova_async](fluxnova_async.md) | 0..1 <br/> [Boolean](Boolean.md) | Camunda extensions */ /** | [BpmnTask](BpmnTask.md) |
| [for_compensation](for_compensation.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether this activity is used for compensation handling | [Activity](Activity.md) |
| [start_quantity](start_quantity.md) | 0..1 <br/> [Integer](Integer.md) | Minimum number of tokens required to start this activity | [Activity](Activity.md) |
| [completion_quantity](completion_quantity.md) | 0..1 <br/> [Integer](Integer.md) | Number of tokens produced when this activity completes | [Activity](Activity.md) |
| [default](default.md) | 0..1 <br/> [SequenceFlow](SequenceFlow.md) | Default sequence flow taken when no other outgoing condition is satisfied | [Activity](Activity.md) |
| [io_specification](io_specification.md) | 0..1 <br/> [IoSpecification](IoSpecification.md) | Input and output specification of this activity | [Activity](Activity.md) |
| [properties](properties.md) | * <br/> [BpmnProperty](BpmnProperty.md) | Serialized properties | [Activity](Activity.md) |
| [data_input_associations](data_input_associations.md) | * <br/> [DataInputAssociation](DataInputAssociation.md) | Data associations that feed input data into this activity | [Activity](Activity.md) |
| [data_output_associations](data_output_associations.md) | * <br/> [DataOutputAssociation](DataOutputAssociation.md) | Data associations that move output data out of this activity | [Activity](Activity.md) |
| [resource_roles](resource_roles.md) | * <br/> [ResourceRole](ResourceRole.md) | Resources (performers, potential owners) assigned to this activity | [Activity](Activity.md) |
| [loop_characteristics](loop_characteristics.md) | 0..1 <br/> [LoopCharacteristics](LoopCharacteristics.md) | Loop or multi-instance characteristics of this activity | [Activity](Activity.md) |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [InteractionNode](InteractionNode.md), [BaseElement](BaseElement.md) |
| [incoming](incoming.md) | * <br/> [SequenceFlow](SequenceFlow.md) | Sequence flows entering this flow node | [FlowNode](FlowNode.md) |
| [outgoing](outgoing.md) | * <br/> [SequenceFlow](SequenceFlow.md) | Sequence flows leaving this flow node | [FlowNode](FlowNode.md) |
| [previous_nodes](previous_nodes.md) | 0..1 <br/> [FlowNode](FlowNode.md) | The previous nodes of this element | [FlowNode](FlowNode.md) |
| [succeeding_nodes](succeeding_nodes.md) | 0..1 <br/> [FlowNode](FlowNode.md) | The succeeding nodes of this element | [FlowNode](FlowNode.md) |
| [fluxnova_async_before](fluxnova_async_before.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether this element is executed asynchronously before its start | [FlowNode](FlowNode.md) |
| [fluxnova_async_after](fluxnova_async_after.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether this element is executed asynchronously after its end | [FlowNode](FlowNode.md) |
| [fluxnova_exclusive](fluxnova_exclusive.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether this element participates in an exclusive job execution | [FlowNode](FlowNode.md) |
| [fluxnova_job_priority](fluxnova_job_priority.md) | 0..1 <br/> [String](String.md) | Priority assigned to async continuation jobs for this element | [FlowNode](FlowNode.md) |
| [name](name.md) | 0..1 <br/> [String](String.md) | Human-readable name | [FlowElement](FlowElement.md) |
| [auditing](auditing.md) | 0..1 <br/> [Auditing](Auditing.md) | Auditing information attached to this flow element | [FlowElement](FlowElement.md) |
| [monitoring](monitoring.md) | 0..1 <br/> [Monitoring](Monitoring.md) | Monitoring information attached to this flow element | [FlowElement](FlowElement.md) |
| [category_value_refs](category_value_refs.md) | * <br/> [CategoryValue](CategoryValue.md) | Category values associated with this flow element | [FlowElement](FlowElement.md) |
| [documentations](documentations.md) | * <br/> [Documentation](Documentation.md) | Collection of documentation elements associated with this element | [BaseElement](BaseElement.md) |
| [extension_elements](extension_elements.md) | 0..1 <br/> [ExtensionElements](ExtensionElements.md) | Extension elements holding vendor-specific metadata | [BaseElement](BaseElement.md) |
| [diagram_element](diagram_element.md) | 0..1 <br/> [DiagramElement](DiagramElement.md) | The diagram element that visually represents this BPMN element | [BaseElement](BaseElement.md) |
| [scope](scope.md) | 0..1 <br/> [BpmnModelElementInstance](BpmnModelElementInstance.md) | Tests if the element is a scope like process or sub-process | [BpmnModelElementInstance](BpmnModelElementInstance.md) |











## In Subsets


* [Instance](Instance.md)
* [FluxnovaBpmnModel](FluxnovaBpmnModel.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| java_package | org.finos.fluxnova.bpm.model.bpmn.instance |
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/BusinessRuleTask.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:BusinessRuleTask |
| native | fluxnova_bpm_platform:BusinessRuleTask |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: BusinessRuleTask
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/BusinessRuleTask.java
description: The BPMN businessRuleTask element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnTask
slots:
- implementation
- fluxnova_class
- fluxnova_delegate_expression
- fluxnova_expression
- fluxnova_result_variable
- fluxnova_type
- fluxnova_topic
- fluxnova_decision_ref
- fluxnova_decision_ref_binding
- fluxnova_decision_ref_version
- fluxnova_decision_ref_version_tag
- fluxnova_decision_ref_tenant_id
- fluxnova_map_decision_result
- fluxnova_task_priority

```
</details>

### Induced

<details>
```yaml
name: BusinessRuleTask
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/BusinessRuleTask.java
description: The BPMN businessRuleTask element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnTask
attributes:
  implementation:
    name: implementation
    description: Implementation technology of this service or send/receive task.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    - ReceiveTask
    - SendTask
    - ServiceTask
    - UserTask
    range: string
  fluxnova_class:
    name: fluxnova_class
    description: Camunda extensions
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - SendTask
    - ServiceTask
    - FluxnovaExecutionListener
    - FluxnovaTaskListener
    range: string
  fluxnova_delegate_expression:
    name: fluxnova_delegate_expression
    description: Expression resolving to a JavaDelegate.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - SendTask
    - ServiceTask
    - FluxnovaExecutionListener
    - FluxnovaTaskListener
    range: string
  fluxnova_expression:
    name: fluxnova_expression
    description: EL expression for this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - SendTask
    - ServiceTask
    - FluxnovaErrorEventDefinition
    - FluxnovaExecutionListener
    - FluxnovaField
    - FluxnovaFormProperty
    - FluxnovaTaskListener
    range: string
  fluxnova_result_variable:
    name: fluxnova_result_variable
    description: Process variable to store the expression result.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - ScriptTask
    - SendTask
    - ServiceTask
    range: string
  fluxnova_type:
    name: fluxnova_type
    description: Type name for this form field or listener.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - SendTask
    - ServiceTask
    - FluxnovaFormField
    - FluxnovaFormProperty
    range: string
  fluxnova_topic:
    name: fluxnova_topic
    description: External task topic name.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - SendTask
    - ServiceTask
    range: string
  fluxnova_decision_ref:
    name: fluxnova_decision_ref
    description: 'Fluxnova extension property: decision ref.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    range: string
  fluxnova_decision_ref_binding:
    name: fluxnova_decision_ref_binding
    description: 'Fluxnova extension property: decision ref binding.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    range: string
  fluxnova_decision_ref_version:
    name: fluxnova_decision_ref_version
    description: 'Fluxnova extension property: decision ref version.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    range: string
  fluxnova_decision_ref_version_tag:
    name: fluxnova_decision_ref_version_tag
    description: 'Fluxnova extension property: decision ref version tag.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    range: string
  fluxnova_decision_ref_tenant_id:
    name: fluxnova_decision_ref_tenant_id
    description: 'Fluxnova extension property: decision ref tenant id.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    range: string
  fluxnova_map_decision_result:
    name: fluxnova_map_decision_result
    description: 'Fluxnova extension property: map decision result.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    range: string
  fluxnova_task_priority:
    name: fluxnova_task_priority
    description: 'Fluxnova extension property: task priority.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BusinessRuleTask
    - MessageEventDefinition
    - Process
    - SendTask
    - ServiceTask
    range: string
  fluxnova_async:
    name: fluxnova_async
    description: Camunda extensions */ /**
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - CallActivity
    - ParallelGateway
    - SignalEventDefinition
    - StartEvent
    - SubProcess
    - BpmnTask
    range: boolean
  for_compensation:
    name: for_compensation
    description: Whether this activity is used for compensation handling.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - Activity
    range: boolean
  start_quantity:
    name: start_quantity
    description: Minimum number of tokens required to start this activity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - Activity
    range: integer
  completion_quantity:
    name: completion_quantity
    description: Number of tokens produced when this activity completes.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - Activity
    range: integer
  default:
    name: default
    description: Default sequence flow taken when no other outgoing condition is satisfied.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - Activity
    - ComplexGateway
    - ExclusiveGateway
    - InclusiveGateway
    range: SequenceFlow
  io_specification:
    name: io_specification
    description: Input and output specification of this activity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - Activity
    - CallableElement
    range: IoSpecification
  properties:
    name: properties
    annotations:
      sql_column:
        tag: sql_column
        value: PROPERTIES_
    description: Serialized properties.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - Filter
    - Activity
    - Event
    - Process
    range: BpmnProperty
    multivalued: true
    inlined: true
    inlined_as_list: true
  data_input_associations:
    name: data_input_associations
    description: Data associations that feed input data into this activity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - Activity
    - ThrowEvent
    range: DataInputAssociation
    multivalued: true
    inlined: true
    inlined_as_list: true
  data_output_associations:
    name: data_output_associations
    description: Data associations that move output data out of this activity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - Activity
    - CatchEvent
    range: DataOutputAssociation
    multivalued: true
    inlined: true
    inlined_as_list: true
  resource_roles:
    name: resource_roles
    description: Resources (performers, potential owners) assigned to this activity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - Activity
    - Process
    range: ResourceRole
    multivalued: true
    inlined: true
    inlined_as_list: true
  loop_characteristics:
    name: loop_characteristics
    description: Loop or multi-instance characteristics of this activity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - Activity
    range: LoopCharacteristics
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: BusinessRuleTask
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
  incoming:
    name: incoming
    description: Sequence flows entering this flow node.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
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
    owner: BusinessRuleTask
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
    owner: BusinessRuleTask
    domain_of:
    - FlowNode
    range: FlowNode
  succeeding_nodes:
    name: succeeding_nodes
    description: The succeeding nodes of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - FlowNode
    range: FlowNode
  fluxnova_async_before:
    name: fluxnova_async_before
    description: Whether this element is executed asynchronously before its start.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - FlowNode
    - MultiInstanceLoopCharacteristics
    range: boolean
  fluxnova_async_after:
    name: fluxnova_async_after
    description: Whether this element is executed asynchronously after its end.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - FlowNode
    - MultiInstanceLoopCharacteristics
    range: boolean
  fluxnova_exclusive:
    name: fluxnova_exclusive
    description: Whether this element participates in an exclusive job execution.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - FlowNode
    - MultiInstanceLoopCharacteristics
    range: boolean
  fluxnova_job_priority:
    name: fluxnova_job_priority
    description: Priority assigned to async continuation jobs for this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
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
    owner: BusinessRuleTask
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
    owner: BusinessRuleTask
    domain_of:
    - FlowElement
    - Process
    range: Auditing
  monitoring:
    name: monitoring
    description: Monitoring information attached to this flow element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - FlowElement
    - Process
    range: Monitoring
  category_value_refs:
    name: category_value_refs
    description: Category values associated with this flow element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - FlowElement
    range: CategoryValue
    multivalued: true
    inlined: true
    inlined_as_list: true
  documentations:
    name: documentations
    description: Collection of documentation elements associated with this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
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
    owner: BusinessRuleTask
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: BusinessRuleTask
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>