---
search:
  boost: 10.0
---

# Class: HistoricIncident 


_Represents a historic Incident incident that is stored permanently._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:HistoricIncident](https://w3id.org/TD-Universe/fluxnova-bpm-platform/HistoricIncident)





```mermaid
 classDiagram
    class HistoricIncident
    click HistoricIncident href "../HistoricIncident/"
      HistoricIncident : activity_id
        
      HistoricIncident : annotation
        
      HistoricIncident : cause_incident_id
        
      HistoricIncident : configuration
        
      HistoricIncident : create_time
        
      HistoricIncident : end_time
        
      HistoricIncident : execution_id
        
      HistoricIncident : failed_activity_id
        
      HistoricIncident : history_configuration
        
      HistoricIncident : id
        
      HistoricIncident : incident_message
        
      HistoricIncident : incident_state
        
          
    
        
        
        HistoricIncident --> "0..1" IncidentState : incident_state
        click IncidentState href "../IncidentState/"
    

        
      HistoricIncident : incident_type
        
      HistoricIncident : job_definition_id
        
      HistoricIncident : process_definition_id
        
      HistoricIncident : process_definition_key
        
      HistoricIncident : process_instance_id
        
      HistoricIncident : removal_time
        
      HistoricIncident : root_cause_incident_id
        
      HistoricIncident : root_process_instance_id
        
      HistoricIncident : tenant_id
        
      
```




<!-- no inheritance hierarchy -->

## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | direct |
| [process_definition_key](process_definition_key.md) | 0..1 <br/> [String](String.md) | Key of the process definition | direct |
| [process_definition_id](process_definition_id.md) | 0..1 <br/> [String](String.md) | Reference to the process definition | direct |
| [root_process_instance_id](root_process_instance_id.md) | 0..1 <br/> [String](String.md) | Root process instance for history cleanup | direct |
| [process_instance_id](process_instance_id.md) | 0..1 <br/> [String](String.md) | Reference to the process instance | direct |
| [execution_id](execution_id.md) | 0..1 <br/> [String](String.md) | Reference to the execution | direct |
| [create_time](create_time.md) | 1 <br/> [Datetime](Datetime.md) | Creation timestamp | direct |
| [end_time](end_time.md) | 0..1 <br/> [Datetime](Datetime.md) | End timestamp | direct |
| [incident_message](incident_message.md) | 0..1 <br/> [String](String.md) | Incident message | direct |
| [incident_type](incident_type.md) | 1 <br/> [String](String.md) | Type of this incident to identify the kind of incident | direct |
| [activity_id](activity_id.md) | 0..1 <br/> [String](String.md) | BPMN activity element identifier | direct |
| [failed_activity_id](failed_activity_id.md) | 0..1 <br/> [String](String.md) | Id of the activity on which the last exception occurred | direct |
| [cause_incident_id](cause_incident_id.md) | 0..1 <br/> [String](String.md) | Id of the incident on which this incident has been triggered | direct |
| [root_cause_incident_id](root_cause_incident_id.md) | 0..1 <br/> [String](String.md) | Id of the root incident on which this transitive incident has been triggered | direct |
| [configuration](configuration.md) | 0..1 <br/> [String](String.md) | Payload of this incident | direct |
| [history_configuration](history_configuration.md) | 0..1 <br/> [String](String.md) | History payload of this incident | direct |
| [incident_state](incident_state.md) | 0..1 <br/> [IncidentState](IncidentState.md) | The incident state | direct |
| [tenant_id](tenant_id.md) | 0..1 <br/> [String](String.md) | Multi-tenancy discriminator | direct |
| [job_definition_id](job_definition_id.md) | 0..1 <br/> [String](String.md) | Reference to the job definition | direct |
| [annotation](annotation.md) | 0..1 <br/> [String](String.md) | Annotation of this incident | direct |
| [removal_time](removal_time.md) | 0..1 <br/> [Datetime](Datetime.md) | Timestamp when this entity is eligible for removal | direct |











## In Subsets


* [History](History.md)
* [FluxnovaBpm](FluxnovaBpm.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_table | ACT_HI_INCIDENT |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:HistoricIncident |
| native | fluxnova_bpm_platform:HistoricIncident |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: HistoricIncident
annotations:
  sql_table:
    tag: sql_table
    value: ACT_HI_INCIDENT
description: Represents a historic Incident incident that is stored permanently.
in_subset:
- history
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
slots:
- id
- process_definition_key
- process_definition_id
- root_process_instance_id
- process_instance_id
- execution_id
- create_time
- end_time
- incident_message
- incident_type
- activity_id
- failed_activity_id
- cause_incident_id
- root_cause_incident_id
- configuration
- history_configuration
- incident_state
- tenant_id
- job_definition_id
- annotation
- removal_time
slot_usage:
  create_time:
    name: create_time
    required: true

```
</details>

### Induced

<details>
```yaml
name: HistoricIncident
annotations:
  sql_table:
    tag: sql_table
    value: ACT_HI_INCIDENT
description: Represents a historic Incident incident that is stored permanently.
in_subset:
- history
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
slot_usage:
  create_time:
    name: create_time
    required: true
attributes:
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: HistoricIncident
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
  process_definition_key:
    name: process_definition_key
    description: Key of the process definition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
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
  process_definition_id:
    name: process_definition_id
    description: Reference to the process definition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
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
  root_process_instance_id:
    name: root_process_instance_id
    description: Root process instance for history cleanup.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
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
    owner: HistoricIncident
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
  execution_id:
    name: execution_id
    description: Reference to the execution.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - EventSubscription
    - ExternalTask
    - Incident
    - Task
    - VariableInstance
    - Job
    - HistoricActivityInstance
    - HistoricDetail
    - HistoricExternalTaskLog
    - HistoricIncident
    - HistoricJobLog
    - HistoricTaskInstance
    - HistoricVariableInstance
    - UserOperationLogEntry
    range: string
  create_time:
    name: create_time
    description: Creation timestamp.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
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
  end_time:
    name: end_time
    description: End timestamp.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - HistoricBatch
    - HistoricIncident
    - HistoricScopeInstance
    range: datetime
  incident_message:
    name: incident_message
    annotations:
      sql_column:
        tag: sql_column
        value: INCIDENT_MSG_
    description: Incident message.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - Incident
    - HistoricIncident
    range: string
  incident_type:
    name: incident_type
    annotations:
      sql_column:
        tag: sql_column
        value: INCIDENT_TYPE_
    description: 'Type of this incident to identify the kind of incident. For example:
      failedJobs will be returned in the case of an incident, which identify failed
      job during the execution of a process instance.'
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - Incident
    - HistoricIncident
    range: string
    required: true
  activity_id:
    name: activity_id
    description: BPMN activity element identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - CaseExecution
    - EventSubscription
    - Execution
    - ExternalTask
    - Incident
    - JobDefinition
    - HistoricActivityInstance
    - HistoricDecisionInstance
    - HistoricExternalTaskLog
    - HistoricIncident
    - HistoricJobLog
    range: string
  failed_activity_id:
    name: failed_activity_id
    annotations:
      sql_column:
        tag: sql_column
        value: FAILED_ACTIVITY_ID_
    description: Id of the activity on which the last exception occurred.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - Incident
    - Job
    - HistoricIncident
    - HistoricJobLog
    range: string
  cause_incident_id:
    name: cause_incident_id
    annotations:
      sql_column:
        tag: sql_column
        value: CAUSE_INCIDENT_ID_
    description: Id of the incident on which this incident has been triggered.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - Incident
    - HistoricIncident
    range: string
  root_cause_incident_id:
    name: root_cause_incident_id
    annotations:
      sql_column:
        tag: sql_column
        value: ROOT_CAUSE_INCIDENT_ID_
    description: Id of the root incident on which this transitive incident has been
      triggered.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - Incident
    - HistoricIncident
    range: string
  configuration:
    name: configuration
    annotations:
      sql_column:
        tag: sql_column
        value: CONFIGURATION_
    description: Payload of this incident.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - EventSubscription
    - Incident
    - Batch
    - HistoricIncident
    range: string
  history_configuration:
    name: history_configuration
    annotations:
      sql_column:
        tag: sql_column
        value: HISTORY_CONFIGURATION_
    description: History payload of this incident.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - HistoricIncident
    range: string
  incident_state:
    name: incident_state
    annotations:
      sql_column:
        tag: sql_column
        value: INCIDENT_STATE_
    description: The incident state.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - HistoricIncident
    range: IncidentState
  tenant_id:
    name: tenant_id
    description: Multi-tenancy discriminator.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
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
  job_definition_id:
    name: job_definition_id
    description: Reference to the job definition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - Incident
    - Job
    - HistoricIncident
    - HistoricJobLog
    - UserOperationLogEntry
    range: string
  annotation:
    name: annotation
    annotations:
      sql_column:
        tag: sql_column
        value: ANNOTATION_
    description: Annotation of this incident
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
    domain_of:
    - Incident
    - HistoricIncident
    - UserOperationLogEntry
    range: string
  removal_time:
    name: removal_time
    description: Timestamp when this entity is eligible for removal.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricIncident
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