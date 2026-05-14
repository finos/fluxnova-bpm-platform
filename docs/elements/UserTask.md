---
search:
  boost: 10.0
---

# Class: UserTask 


_The BPMN userTask element_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:UserTask](https://w3id.org/TD-Universe/fluxnova-bpm-platform/UserTask)





```mermaid
 classDiagram
    class UserTask
    click UserTask href "../UserTask/"
      BpmnTask <|-- UserTask
        click BpmnTask href "../BpmnTask/"
      
      UserTask : auditing
        
          
    
        
        
        UserTask --> "0..1" Auditing : auditing
        click Auditing href "../Auditing/"
    

        
      UserTask : category_value_refs
        
          
    
        
        
        UserTask --> "*" CategoryValue : category_value_refs
        click CategoryValue href "../CategoryValue/"
    

        
      UserTask : completion_quantity
        
      UserTask : data_input_associations
        
          
    
        
        
        UserTask --> "*" DataInputAssociation : data_input_associations
        click DataInputAssociation href "../DataInputAssociation/"
    

        
      UserTask : data_output_associations
        
          
    
        
        
        UserTask --> "*" DataOutputAssociation : data_output_associations
        click DataOutputAssociation href "../DataOutputAssociation/"
    

        
      UserTask : default
        
          
    
        
        
        UserTask --> "0..1" SequenceFlow : default
        click SequenceFlow href "../SequenceFlow/"
    

        
      UserTask : diagram_element
        
          
    
        
        
        UserTask --> "0..1" DiagramElement : diagram_element
        click DiagramElement href "../DiagramElement/"
    

        
      UserTask : documentations
        
          
    
        
        
        UserTask --> "*" Documentation : documentations
        click Documentation href "../Documentation/"
    

        
      UserTask : extension_elements
        
          
    
        
        
        UserTask --> "0..1" ExtensionElements : extension_elements
        click ExtensionElements href "../ExtensionElements/"
    

        
      UserTask : fluxnova_assignee
        
      UserTask : fluxnova_async
        
      UserTask : fluxnova_async_after
        
      UserTask : fluxnova_async_before
        
      UserTask : fluxnova_candidate_groups
        
      UserTask : fluxnova_candidate_groups_list
        
      UserTask : fluxnova_candidate_users
        
      UserTask : fluxnova_candidate_users_list
        
      UserTask : fluxnova_due_date
        
      UserTask : fluxnova_exclusive
        
      UserTask : fluxnova_follow_up_date
        
      UserTask : fluxnova_form_handler_class
        
      UserTask : fluxnova_form_key
        
      UserTask : fluxnova_form_ref
        
      UserTask : fluxnova_form_ref_binding
        
      UserTask : fluxnova_form_ref_version
        
      UserTask : fluxnova_job_priority
        
      UserTask : fluxnova_priority
        
      UserTask : for_compensation
        
      UserTask : id
        
      UserTask : implementation
        
      UserTask : incoming
        
          
    
        
        
        UserTask --> "*" SequenceFlow : incoming
        click SequenceFlow href "../SequenceFlow/"
    

        
      UserTask : io_specification
        
          
    
        
        
        UserTask --> "0..1" IoSpecification : io_specification
        click IoSpecification href "../IoSpecification/"
    

        
      UserTask : loop_characteristics
        
          
    
        
        
        UserTask --> "0..1" LoopCharacteristics : loop_characteristics
        click LoopCharacteristics href "../LoopCharacteristics/"
    

        
      UserTask : monitoring
        
          
    
        
        
        UserTask --> "0..1" Monitoring : monitoring
        click Monitoring href "../Monitoring/"
    

        
      UserTask : name
        
      UserTask : outgoing
        
          
    
        
        
        UserTask --> "*" SequenceFlow : outgoing
        click SequenceFlow href "../SequenceFlow/"
    

        
      UserTask : previous_nodes
        
          
    
        
        
        UserTask --> "0..1" FlowNode : previous_nodes
        click FlowNode href "../FlowNode/"
    

        
      UserTask : properties
        
          
    
        
        
        UserTask --> "*" BpmnProperty : properties
        click BpmnProperty href "../BpmnProperty/"
    

        
      UserTask : renderings
        
          
    
        
        
        UserTask --> "*" Rendering : renderings
        click Rendering href "../Rendering/"
    

        
      UserTask : resource_roles
        
          
    
        
        
        UserTask --> "*" ResourceRole : resource_roles
        click ResourceRole href "../ResourceRole/"
    

        
      UserTask : scope
        
          
    
        
        
        UserTask --> "0..1" BpmnModelElementInstance : scope
        click BpmnModelElementInstance href "../BpmnModelElementInstance/"
    

        
      UserTask : start_quantity
        
      UserTask : succeeding_nodes
        
          
    
        
        
        UserTask --> "0..1" FlowNode : succeeding_nodes
        click FlowNode href "../FlowNode/"
    

        
      
```





## Inheritance
* [BpmnModelElementInstance](BpmnModelElementInstance.md)
    * [BaseElement](BaseElement.md)
        * [FlowElement](FlowElement.md)
            * [FlowNode](FlowNode.md)
                * [Activity](Activity.md) [ [InteractionNode](InteractionNode.md)]
                    * [BpmnTask](BpmnTask.md)
                        * **UserTask**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [implementation](implementation.md) | 0..1 <br/> [String](String.md) | Implementation technology of this service or send/receive task | direct |
| [renderings](renderings.md) | * <br/> [Rendering](Rendering.md) | Rendering hints for this event | direct |
| [fluxnova_assignee](fluxnova_assignee.md) | 0..1 <br/> [String](String.md) | Camunda extensions | direct |
| [fluxnova_candidate_groups](fluxnova_candidate_groups.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: candidate groups | direct |
| [fluxnova_candidate_groups_list](fluxnova_candidate_groups_list.md) | * <br/> [String](String.md) | Fluxnova extension property: candidate groups list | direct |
| [fluxnova_candidate_users](fluxnova_candidate_users.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: candidate users | direct |
| [fluxnova_candidate_users_list](fluxnova_candidate_users_list.md) | * <br/> [String](String.md) | Fluxnova extension property: candidate users list | direct |
| [fluxnova_due_date](fluxnova_due_date.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: due date | direct |
| [fluxnova_follow_up_date](fluxnova_follow_up_date.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: follow up date | direct |
| [fluxnova_form_handler_class](fluxnova_form_handler_class.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: form handler class | direct |
| [fluxnova_form_key](fluxnova_form_key.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: form key | direct |
| [fluxnova_form_ref](fluxnova_form_ref.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: form ref | direct |
| [fluxnova_form_ref_binding](fluxnova_form_ref_binding.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: form ref binding | direct |
| [fluxnova_form_ref_version](fluxnova_form_ref_version.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: form ref version | direct |
| [fluxnova_priority](fluxnova_priority.md) | 0..1 <br/> [String](String.md) | Fluxnova extension property: priority | direct |
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
| source_file | model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/UserTask.java |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:UserTask |
| native | fluxnova_bpm_platform:UserTask |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: UserTask
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/UserTask.java
description: The BPMN userTask element
in_subset:
- instance
- fluxnova_bpmn_model
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: BpmnTask
slots:
- implementation
- renderings
- fluxnova_assignee
- fluxnova_candidate_groups
- fluxnova_candidate_groups_list
- fluxnova_candidate_users
- fluxnova_candidate_users_list
- fluxnova_due_date
- fluxnova_follow_up_date
- fluxnova_form_handler_class
- fluxnova_form_key
- fluxnova_form_ref
- fluxnova_form_ref_binding
- fluxnova_form_ref_version
- fluxnova_priority

```
</details>

### Induced

<details>
```yaml
name: UserTask
annotations:
  java_package:
    tag: java_package
    value: org.finos.fluxnova.bpm.model.bpmn.instance
  source_file:
    tag: source_file
    value: model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn/instance/UserTask.java
description: The BPMN userTask element
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
    owner: UserTask
    domain_of:
    - BusinessRuleTask
    - ReceiveTask
    - SendTask
    - ServiceTask
    - UserTask
    range: string
  renderings:
    name: renderings
    description: Rendering hints for this event.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - UserTask
    range: Rendering
    multivalued: true
    inlined: true
    inlined_as_list: true
  fluxnova_assignee:
    name: fluxnova_assignee
    description: Camunda extensions
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - UserTask
    range: string
  fluxnova_candidate_groups:
    name: fluxnova_candidate_groups
    description: 'Fluxnova extension property: candidate groups.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - UserTask
    range: string
  fluxnova_candidate_groups_list:
    name: fluxnova_candidate_groups_list
    description: 'Fluxnova extension property: candidate groups list.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - UserTask
    range: string
    multivalued: true
  fluxnova_candidate_users:
    name: fluxnova_candidate_users
    description: 'Fluxnova extension property: candidate users.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - UserTask
    range: string
  fluxnova_candidate_users_list:
    name: fluxnova_candidate_users_list
    description: 'Fluxnova extension property: candidate users list.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - UserTask
    range: string
    multivalued: true
  fluxnova_due_date:
    name: fluxnova_due_date
    description: 'Fluxnova extension property: due date.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - UserTask
    range: string
  fluxnova_follow_up_date:
    name: fluxnova_follow_up_date
    description: 'Fluxnova extension property: follow up date.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - UserTask
    range: string
  fluxnova_form_handler_class:
    name: fluxnova_form_handler_class
    description: 'Fluxnova extension property: form handler class.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - StartEvent
    - UserTask
    range: string
  fluxnova_form_key:
    name: fluxnova_form_key
    description: 'Fluxnova extension property: form key.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - StartEvent
    - UserTask
    range: string
  fluxnova_form_ref:
    name: fluxnova_form_ref
    description: 'Fluxnova extension property: form ref.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - StartEvent
    - UserTask
    range: string
  fluxnova_form_ref_binding:
    name: fluxnova_form_ref_binding
    description: 'Fluxnova extension property: form ref binding.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - StartEvent
    - UserTask
    range: string
  fluxnova_form_ref_version:
    name: fluxnova_form_ref_version
    description: 'Fluxnova extension property: form ref version.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - StartEvent
    - UserTask
    range: string
  fluxnova_priority:
    name: fluxnova_priority
    description: 'Fluxnova extension property: priority.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - UserTask
    range: string
  fluxnova_async:
    name: fluxnova_async
    description: Camunda extensions */ /**
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
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
    owner: UserTask
    domain_of:
    - Activity
    range: boolean
  start_quantity:
    name: start_quantity
    description: Minimum number of tokens required to start this activity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - Activity
    range: integer
  completion_quantity:
    name: completion_quantity
    description: Number of tokens produced when this activity completes.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - Activity
    range: integer
  default:
    name: default
    description: Default sequence flow taken when no other outgoing condition is satisfied.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
    domain_of:
    - FlowNode
    range: FlowNode
  succeeding_nodes:
    name: succeeding_nodes
    description: The succeeding nodes of this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - FlowNode
    range: FlowNode
  fluxnova_async_before:
    name: fluxnova_async_before
    description: Whether this element is executed asynchronously before its start.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - FlowNode
    - MultiInstanceLoopCharacteristics
    range: boolean
  fluxnova_async_after:
    name: fluxnova_async_after
    description: Whether this element is executed asynchronously after its end.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - FlowNode
    - MultiInstanceLoopCharacteristics
    range: boolean
  fluxnova_exclusive:
    name: fluxnova_exclusive
    description: Whether this element participates in an exclusive job execution.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - FlowNode
    - MultiInstanceLoopCharacteristics
    range: boolean
  fluxnova_job_priority:
    name: fluxnova_job_priority
    description: Priority assigned to async continuation jobs for this element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
    domain_of:
    - FlowElement
    - Process
    range: Auditing
  monitoring:
    name: monitoring
    description: Monitoring information attached to this flow element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - FlowElement
    - Process
    range: Monitoring
  category_value_refs:
    name: category_value_refs
    description: Category values associated with this flow element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
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
    owner: UserTask
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
    owner: UserTask
    domain_of:
    - BaseElement
    range: ExtensionElements
  diagram_element:
    name: diagram_element
    description: The diagram element that visually represents this BPMN element.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - BaseElement
    range: DiagramElement
  scope:
    name: scope
    description: Tests if the element is a scope like process or sub-process.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: UserTask
    domain_of:
    - BpmnModelElementInstance
    range: BpmnModelElementInstance

```
</details></div>