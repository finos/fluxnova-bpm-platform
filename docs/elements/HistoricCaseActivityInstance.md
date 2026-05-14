---
search:
  boost: 10.0
---

# Class: HistoricCaseActivityInstance 


_Represents one execution of a case activity which is stored permanent for statistics, audit and other business intelligence purposes._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:HistoricCaseActivityInstance](https://w3id.org/TD-Universe/fluxnova-bpm-platform/HistoricCaseActivityInstance)





```mermaid
 classDiagram
    class HistoricCaseActivityInstance
    click HistoricCaseActivityInstance href "../HistoricCaseActivityInstance/"
      HistoricScopeInstance <|-- HistoricCaseActivityInstance
        click HistoricScopeInstance href "../HistoricScopeInstance/"
      
      HistoricCaseActivityInstance : called_case_instance_id
        
      HistoricCaseActivityInstance : called_process_instance_id
        
      HistoricCaseActivityInstance : case_activity_id
        
      HistoricCaseActivityInstance : case_activity_name
        
      HistoricCaseActivityInstance : case_activity_type
        
      HistoricCaseActivityInstance : case_definition_id
        
      HistoricCaseActivityInstance : case_instance_id
        
      HistoricCaseActivityInstance : create_time
        
      HistoricCaseActivityInstance : duration
        
      HistoricCaseActivityInstance : end_time
        
      HistoricCaseActivityInstance : id
        
      HistoricCaseActivityInstance : is_required
        
      HistoricCaseActivityInstance : parent_activity_instance_id
        
      HistoricCaseActivityInstance : process_definition_id
        
      HistoricCaseActivityInstance : process_definition_key
        
      HistoricCaseActivityInstance : process_instance_id
        
      HistoricCaseActivityInstance : removal_time
        
      HistoricCaseActivityInstance : root_process_instance_id
        
      HistoricCaseActivityInstance : start_time
        
      HistoricCaseActivityInstance : state
        
          
    
        
        
        HistoricCaseActivityInstance --> "0..1" EntityState : state
        click EntityState href "../EntityState/"
    

        
      HistoricCaseActivityInstance : task_id
        
      HistoricCaseActivityInstance : tenant_id
        
      
```





## Inheritance
* [HistoricScopeInstance](HistoricScopeInstance.md)
    * **HistoricCaseActivityInstance**


## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [parent_activity_instance_id](parent_activity_instance_id.md) | 0..1 <br/> [String](String.md) | Id of the parent activity instance | direct |
| [case_definition_id](case_definition_id.md) | 1 <br/> [String](String.md) | Reference to the case definition | direct |
| [case_instance_id](case_instance_id.md) | 1 <br/> [String](String.md) | Reference to the case instance | direct |
| [case_activity_id](case_activity_id.md) | 1 <br/> [String](String.md) | The unique identifier of the case activity in the case | direct |
| [task_id](task_id.md) | 0..1 <br/> [String](String.md) | Reference to the task | direct |
| [called_process_instance_id](called_process_instance_id.md) | 0..1 <br/> [String](String.md) | The called process instance in case of call activity | direct |
| [called_case_instance_id](called_case_instance_id.md) | 0..1 <br/> [String](String.md) | The called case instance in case of (case) call activity | direct |
| [case_activity_name](case_activity_name.md) | 0..1 <br/> [String](String.md) | The display name for the case activity | direct |
| [case_activity_type](case_activity_type.md) | 0..1 <br/> [String](String.md) | The display type for the case activity | direct |
| [create_time](create_time.md) | 1 <br/> [Datetime](Datetime.md) | Creation timestamp | direct |
| [state](state.md) | 0..1 <br/> [EntityState](EntityState.md) | Current state of HistoricProcessInstance, following values are recognized dur... | direct |
| [is_required](is_required.md) | 0..1 <br/> [Boolean](Boolean.md) | Whether this entity is required | direct |
| [tenant_id](tenant_id.md) | 0..1 <br/> [String](String.md) | Multi-tenancy discriminator | direct |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | [HistoricScopeInstance](HistoricScopeInstance.md) |
| [root_process_instance_id](root_process_instance_id.md) | 0..1 <br/> [String](String.md) | Root process instance for history cleanup | [HistoricScopeInstance](HistoricScopeInstance.md) |
| [process_instance_id](process_instance_id.md) | 0..1 <br/> [String](String.md) | Reference to the process instance | [HistoricScopeInstance](HistoricScopeInstance.md) |
| [process_definition_id](process_definition_id.md) | 0..1 <br/> [String](String.md) | Reference to the process definition | [HistoricScopeInstance](HistoricScopeInstance.md) |
| [process_definition_key](process_definition_key.md) | 0..1 <br/> [String](String.md) | Key of the process definition | [HistoricScopeInstance](HistoricScopeInstance.md) |
| [start_time](start_time.md) | 0..1 <br/> [Datetime](Datetime.md) | Start timestamp | [HistoricScopeInstance](HistoricScopeInstance.md) |
| [end_time](end_time.md) | 0..1 <br/> [Datetime](Datetime.md) | End timestamp | [HistoricScopeInstance](HistoricScopeInstance.md) |
| [duration](duration.md) | 0..1 <br/> [Integer](Integer.md) | Duration in milliseconds | [HistoricScopeInstance](HistoricScopeInstance.md) |
| [removal_time](removal_time.md) | 0..1 <br/> [Datetime](Datetime.md) | Timestamp when this entity is eligible for removal | [HistoricScopeInstance](HistoricScopeInstance.md) |











## In Subsets


* [History](History.md)
* [FluxnovaBpm](FluxnovaBpm.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_table | ACT_HI_CASEACTINST |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:HistoricCaseActivityInstance |
| native | fluxnova_bpm_platform:HistoricCaseActivityInstance |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: HistoricCaseActivityInstance
annotations:
  sql_table:
    tag: sql_table
    value: ACT_HI_CASEACTINST
description: Represents one execution of a case activity which is stored permanent
  for statistics, audit and other business intelligence purposes.
in_subset:
- history
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: HistoricScopeInstance
slots:
- parent_activity_instance_id
- case_definition_id
- case_instance_id
- case_activity_id
- task_id
- called_process_instance_id
- called_case_instance_id
- case_activity_name
- case_activity_type
- create_time
- state
- is_required
- tenant_id
slot_usage:
  case_definition_id:
    name: case_definition_id
    required: true
  case_instance_id:
    name: case_instance_id
    required: true
  create_time:
    name: create_time
    required: true

```
</details>

### Induced

<details>
```yaml
name: HistoricCaseActivityInstance
annotations:
  sql_table:
    tag: sql_table
    value: ACT_HI_CASEACTINST
description: Represents one execution of a case activity which is stored permanent
  for statistics, audit and other business intelligence purposes.
in_subset:
- history
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
is_a: HistoricScopeInstance
slot_usage:
  case_definition_id:
    name: case_definition_id
    required: true
  case_instance_id:
    name: case_instance_id
    required: true
  create_time:
    name: create_time
    required: true
attributes:
  parent_activity_instance_id:
    name: parent_activity_instance_id
    annotations:
      sql_column:
        tag: sql_column
        value: PARENT_ACT_INST_ID_
    description: Id of the parent activity instance
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - HistoricActivityInstance
    - HistoricCaseActivityInstance
    range: string
  case_definition_id:
    name: case_definition_id
    description: Reference to the case definition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - CaseExecution
    - Task
    - HistoricCaseActivityInstance
    - HistoricCaseInstance
    - HistoricDecisionInstance
    - HistoricDetail
    - HistoricTaskInstance
    - HistoricVariableInstance
    - UserOperationLogEntry
    range: string
    required: true
  case_instance_id:
    name: case_instance_id
    description: Reference to the case instance.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - CaseExecution
    - CaseSentryPart
    - Execution
    - Task
    - VariableInstance
    - HistoricCaseActivityInstance
    - HistoricCaseInstance
    - HistoricDecisionInstance
    - HistoricDetail
    - HistoricProcessInstance
    - HistoricTaskInstance
    - HistoricVariableInstance
    - UserOperationLogEntry
    range: string
    required: true
  case_activity_id:
    name: case_activity_id
    annotations:
      sql_column:
        tag: sql_column
        value: CASE_ACT_ID_
    description: The unique identifier of the case activity in the case.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - HistoricCaseActivityInstance
    range: string
    required: true
  task_id:
    name: task_id
    description: Reference to the task.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - IdentityLink
    - VariableInstance
    - Attachment
    - Comment
    - HistoricActivityInstance
    - HistoricCaseActivityInstance
    - HistoricDetail
    - HistoricIdentityLink
    - HistoricVariableInstance
    - UserOperationLogEntry
    range: string
  called_process_instance_id:
    name: called_process_instance_id
    annotations:
      sql_column:
        tag: sql_column
        value: CALL_PROC_INST_ID_
    description: The called process instance in case of call activity
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - HistoricActivityInstance
    - HistoricCaseActivityInstance
    range: string
  called_case_instance_id:
    name: called_case_instance_id
    annotations:
      sql_column:
        tag: sql_column
        value: CALL_CASE_INST_ID_
    description: The called case instance in case of (case) call activity
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - HistoricActivityInstance
    - HistoricCaseActivityInstance
    range: string
  case_activity_name:
    name: case_activity_name
    annotations:
      sql_column:
        tag: sql_column
        value: CASE_ACT_NAME_
    description: The display name for the case activity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - HistoricCaseActivityInstance
    range: string
  case_activity_type:
    name: case_activity_type
    annotations:
      sql_column:
        tag: sql_column
        value: CASE_ACT_TYPE_
    description: The display type for the case activity.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - HistoricCaseActivityInstance
    range: string
  create_time:
    name: create_time
    description: Creation timestamp.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - ByteArray
    - ExternalTask
    - Task
    - Attachment
    - Job
    - HistoricCaseActivityInstance
    - HistoricCaseInstance
    - HistoricDecisionInputInstance
    - HistoricDecisionOutputInstance
    - HistoricIncident
    - HistoricVariableInstance
    range: datetime
    required: true
  state:
    name: state
    annotations:
      sql_column:
        tag: sql_column
        value: STATE_
    description: 'Current state of HistoricProcessInstance, following values are recognized
      during process engine operations: STATE_ACTIVE - running process instance STATE_SUSPENDED
      - suspended process instances STA...'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - HistoricCaseActivityInstance
    - HistoricCaseInstance
    - HistoricExternalTaskLog
    - HistoricProcessInstance
    - HistoricVariableInstance
    range: EntityState
  is_required:
    name: is_required
    annotations:
      sql_column:
        tag: sql_column
        value: REQUIRED_
    description: Whether this entity is required.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - CaseExecution
    - HistoricCaseActivityInstance
    range: boolean
  tenant_id:
    name: tenant_id
    description: Multi-tenancy discriminator.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
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
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: HistoricCaseActivityInstance
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
  root_process_instance_id:
    name: root_process_instance_id
    description: Root process instance for history cleanup.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - ByteArray
    - Authorization
    - Execution
    - Attachment
    - Comment
    - Job
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
    range: string
  process_instance_id:
    name: process_instance_id
    description: Reference to the process instance.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - EventSubscription
    - Execution
    - ExternalTask
    - Incident
    - Task
    - VariableInstance
    - Attachment
    - Comment
    - Job
    - HistoricDecisionInstance
    - HistoricDetail
    - HistoricExternalTaskLog
    - HistoricIncident
    - HistoricJobLog
    - HistoricScopeInstance
    - HistoricVariableInstance
    - UserOperationLogEntry
    range: string
  process_definition_id:
    name: process_definition_id
    description: Reference to the process definition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - IdentityLink
    - Execution
    - ExternalTask
    - Incident
    - Task
    - VariableInstance
    - Job
    - JobDefinition
    - HistoricDecisionInstance
    - HistoricDetail
    - HistoricExternalTaskLog
    - HistoricIdentityLink
    - HistoricIncident
    - HistoricJobLog
    - HistoricScopeInstance
    - HistoricVariableInstance
    - UserOperationLogEntry
    range: string
  process_definition_key:
    name: process_definition_key
    description: Key of the process definition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - Execution
    - ExternalTask
    - Job
    - JobDefinition
    - HistoricDecisionInstance
    - HistoricDetail
    - HistoricExternalTaskLog
    - HistoricIdentityLink
    - HistoricIncident
    - HistoricJobLog
    - HistoricScopeInstance
    - HistoricVariableInstance
    - UserOperationLogEntry
    range: string
  start_time:
    name: start_time
    description: Start timestamp.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - Batch
    - HistoricBatch
    - HistoricScopeInstance
    range: datetime
  end_time:
    name: end_time
    description: End timestamp.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - HistoricBatch
    - HistoricIncident
    - HistoricScopeInstance
    range: datetime
  duration:
    name: duration
    description: Duration in milliseconds.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - HistoricScopeInstance
    range: integer
  removal_time:
    name: removal_time
    description: Timestamp when this entity is eligible for removal.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricCaseActivityInstance
    domain_of:
    - ByteArray
    - Authorization
    - Attachment
    - Comment
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
    range: datetime

```
</details></div>