---
search:
  boost: 10.0
---

# Class: ProcessDefinition 


_An object structure representing an executable process composed of activities and transitions. Business processes are often created with graphical editors that store the process definition in certa..._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:ProcessDefinition](https://w3id.org/TD-Universe/fluxnova-bpm-platform/ProcessDefinition)





```mermaid
 classDiagram
    class ProcessDefinition
    click ProcessDefinition href "../ProcessDefinition/"
      ResourceDefinition <|-- ProcessDefinition
        click ResourceDefinition href "../ResourceDefinition/"
      
      ProcessDefinition : category
        
      ProcessDefinition : deployment_id
        
      ProcessDefinition : diagram_resource_name
        
      ProcessDefinition : has_start_form_key
        
      ProcessDefinition : history_time_to_live
        
      ProcessDefinition : id
        
      ProcessDefinition : is_startable
        
      ProcessDefinition : key
        
      ProcessDefinition : name
        
      ProcessDefinition : resource_name
        
      ProcessDefinition : suspension_state
        
          
    
        
        
        ProcessDefinition --> "0..1" SuspensionState : suspension_state
        click SuspensionState href "../SuspensionState/"
    

        
      ProcessDefinition : tenant_id
        
      ProcessDefinition : version
        
      ProcessDefinition : version_tag
        
      
```





## Inheritance
* [ResourceDefinition](ResourceDefinition.md)
    * **ProcessDefinition**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [has_start_form_key](has_start_form_key.md) | 0..1 <br/> [Boolean](Boolean.md) | The has start form key | direct |
| [suspension_state](suspension_state.md) | 0..1 <br/> [SuspensionState](SuspensionState.md) | Whether the entity is active or suspended | direct |
| [version_tag](version_tag.md) | 0..1 <br/> [String](String.md) | Version tag of the process definition | direct |
| [is_startable](is_startable.md) | 1 <br/> [Boolean](Boolean.md) | Whether this entity is startable | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [ResourceDefinition](ResourceDefinition.md) |
| [key](key.md) | 1 <br/> [String](String.md) | Business key for the definition | [ResourceDefinition](ResourceDefinition.md) |
| [name](name.md) | 0..1 <br/> [String](String.md) | Human-readable name | [ResourceDefinition](ResourceDefinition.md) |
| [version](version.md) | 1 <br/> [Integer](Integer.md) | Version number | [ResourceDefinition](ResourceDefinition.md) |
| [category](category.md) | 0..1 <br/> [String](String.md) | Category classification | [ResourceDefinition](ResourceDefinition.md) |
| [deployment_id](deployment_id.md) | 0..1 <br/> [String](String.md) | Reference to the deployment | [ResourceDefinition](ResourceDefinition.md) |
| [resource_name](resource_name.md) | 0..1 <br/> [String](String.md) | Name of the deployed resource file | [ResourceDefinition](ResourceDefinition.md) |
| [diagram_resource_name](diagram_resource_name.md) | 0..1 <br/> [String](String.md) | Name of the diagram resource file | [ResourceDefinition](ResourceDefinition.md) |
| [tenant_id](tenant_id.md) | 0..1 <br/> [String](String.md) | Multi-tenancy discriminator | [ResourceDefinition](ResourceDefinition.md) |
| [history_time_to_live](history_time_to_live.md) | 0..1 <br/> [Integer](Integer.md) | Days to retain history before cleanup | [ResourceDefinition](ResourceDefinition.md) |





## Usages

| used by | used in | type | used |
| ---  | --- | --- | --- |
| [FluxnovaPlatformData](FluxnovaPlatformData.md) | [process_definitions](process_definitions.md) | range | [ProcessDefinition](ProcessDefinition.md) |








## In Subsets


* [Repository](Repository.md)
* [FluxnovaBpm](FluxnovaBpm.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_table | ACT_RE_PROCDEF |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:ProcessDefinition |
| native | fluxnova_bpm_platform:ProcessDefinition |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: ProcessDefinition
annotations:
  sql_table:
    tag: sql_table
    value: ACT_RE_PROCDEF
description: An object structure representing an executable process composed of activities
  and transitions. Business processes are often created with graphical editors that
  store the process definition in certa...
in_subset:
- repository
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: ResourceDefinition
slots:
- has_start_form_key
- suspension_state
- version_tag
- is_startable
slot_usage:
  key:
    name: key
    required: true
  version:
    name: version
    required: true

```
</details>

### Induced

<details>
```yaml
name: ProcessDefinition
annotations:
  sql_table:
    tag: sql_table
    value: ACT_RE_PROCDEF
description: An object structure representing an executable process composed of activities
  and transitions. Business processes are often created with graphical editors that
  store the process definition in certa...
in_subset:
- repository
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: ResourceDefinition
slot_usage:
  key:
    name: key
    required: true
  version:
    name: version
    required: true
attributes:
  has_start_form_key:
    name: has_start_form_key
    annotations:
      sql_column:
        tag: sql_column
        value: HAS_START_FORM_KEY_
    description: The has start form key.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - ProcessDefinition
    range: boolean
  suspension_state:
    name: suspension_state
    annotations:
      sql_column:
        tag: sql_column
        value: SUSPENSION_STATE_
    description: Whether the entity is active or suspended.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - Execution
    - ExternalTask
    - Task
    - ProcessDefinition
    - Batch
    - Job
    - JobDefinition
    range: SuspensionState
  version_tag:
    name: version_tag
    annotations:
      sql_column:
        tag: sql_column
        value: VERSION_TAG_
    description: Version tag of the process definition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - DecisionDefinition
    - ProcessDefinition
    range: string
  is_startable:
    name: is_startable
    annotations:
      sql_column:
        tag: sql_column
        value: STARTABLE_
    description: Whether this entity is startable.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - ProcessDefinition
    range: boolean
    required: true
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: ProcessDefinition
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
  key:
    name: key
    description: Business key for the definition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - IdentityInfo
    - ResourceDefinition
    range: string
    required: true
  name:
    name: name
    description: Human-readable name.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:name
    owner: ProcessDefinition
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
  version:
    name: version
    description: Version number.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - SchemaLogEntry
    - ResourceDefinition
    range: integer
    required: true
  category:
    name: category
    description: Category classification.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - ResourceDefinition
    - UserOperationLogEntry
    - BpmnGroup
    range: string
  deployment_id:
    name: deployment_id
    description: Reference to the deployment.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - ByteArray
    - ResourceDefinition
    - Job
    - JobDefinition
    - HistoricJobLog
    - UserOperationLogEntry
    range: string
  resource_name:
    name: resource_name
    description: Name of the deployed resource file.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - ResourceDefinition
    range: string
  diagram_resource_name:
    name: diagram_resource_name
    description: Name of the diagram resource file.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - ResourceDefinition
    range: string
  tenant_id:
    name: tenant_id
    description: Multi-tenancy discriminator.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - ByteArray
    - IdentityLink
    - TenantMembership
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
    - Deployment
    - ResourceDefinition
    - Batch
    - Job
    - JobDefinition
    - HistoricActivityInstance
    - HistoricBatch
    - HistoricCaseActivityInstance
    - HistoricCaseInstance
    - HistoricDecisionInputInstance
    - HistoricDecisionInstance
    - HistoricDecisionOutputInstance
    - HistoricDetail
    - HistoricExternalTaskLog
    - HistoricIdentityLink
    - HistoricIncident
    - HistoricJobLog
    - HistoricProcessInstance
    - HistoricTaskInstance
    - HistoricVariableInstance
    - UserOperationLogEntry
    range: string
  history_time_to_live:
    name: history_time_to_live
    description: Days to retain history before cleanup.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: ProcessDefinition
    domain_of:
    - ResourceDefinition
    range: integer

```
</details></div>