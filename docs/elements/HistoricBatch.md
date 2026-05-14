---
search:
  boost: 10.0
---

# Class: HistoricBatch 


_Historic representation of a org.finos.fluxnova.bpm.engine.batch.Batch._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:HistoricBatch](https://w3id.org/TD-Universe/fluxnova-bpm-platform/HistoricBatch)





```mermaid
 classDiagram
    class HistoricBatch
    click HistoricBatch href "../HistoricBatch/"
      HistoricBatch : batch_job_definition_id
        
      HistoricBatch : create_user_id
        
      HistoricBatch : end_time
        
      HistoricBatch : execution_start_time
        
      HistoricBatch : id
        
      HistoricBatch : invocations_per_job
        
      HistoricBatch : jobs_per_seed
        
      HistoricBatch : monitor_job_definition_id
        
      HistoricBatch : removal_time
        
      HistoricBatch : seed_job_definition_id
        
      HistoricBatch : start_time
        
      HistoricBatch : tenant_id
        
      HistoricBatch : total_jobs
        
      HistoricBatch : type
        
      
```




<!-- no inheritance hierarchy -->

## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | direct |
| [type](type.md) | 0..1 <br/> [String](String.md) | Type discriminator | direct |
| [total_jobs](total_jobs.md) | 0..1 <br/> [Integer](Integer.md) | Total number of jobs | direct |
| [jobs_per_seed](jobs_per_seed.md) | 0..1 <br/> [Integer](Integer.md) | The jobs per seed | direct |
| [invocations_per_job](invocations_per_job.md) | 0..1 <br/> [Integer](Integer.md) | The invocations per job | direct |
| [seed_job_definition_id](seed_job_definition_id.md) | 0..1 <br/> [String](String.md) | Reference to a JobDefinition | direct |
| [monitor_job_definition_id](monitor_job_definition_id.md) | 0..1 <br/> [String](String.md) | Reference to a JobDefinition | direct |
| [batch_job_definition_id](batch_job_definition_id.md) | 0..1 <br/> [String](String.md) | Reference to a JobDefinition | direct |
| [tenant_id](tenant_id.md) | 0..1 <br/> [String](String.md) | Multi-tenancy discriminator | direct |
| [create_user_id](create_user_id.md) | 0..1 <br/> [String](String.md) | The authenticated user that created this case instance | direct |
| [start_time](start_time.md) | 1 <br/> [Datetime](Datetime.md) | Start timestamp | direct |
| [end_time](end_time.md) | 0..1 <br/> [Datetime](Datetime.md) | End timestamp | direct |
| [removal_time](removal_time.md) | 0..1 <br/> [Datetime](Datetime.md) | Timestamp when this entity is eligible for removal | direct |
| [execution_start_time](execution_start_time.md) | 0..1 <br/> [Datetime](Datetime.md) | Timestamp when this started | direct |











## In Subsets


* [History](History.md)
* [FluxnovaBpm](FluxnovaBpm.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_table | ACT_HI_BATCH |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:HistoricBatch |
| native | fluxnova_bpm_platform:HistoricBatch |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: HistoricBatch
annotations:
  sql_table:
    tag: sql_table
    value: ACT_HI_BATCH
description: Historic representation of a org.finos.fluxnova.bpm.engine.batch.Batch.
in_subset:
- history
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
slots:
- id
- type
- total_jobs
- jobs_per_seed
- invocations_per_job
- seed_job_definition_id
- monitor_job_definition_id
- batch_job_definition_id
- tenant_id
- create_user_id
- start_time
- end_time
- removal_time
- execution_start_time
slot_usage:
  start_time:
    name: start_time
    required: true

```
</details>

### Induced

<details>
```yaml
name: HistoricBatch
annotations:
  sql_table:
    tag: sql_table
    value: ACT_HI_BATCH
description: Historic representation of a org.finos.fluxnova.bpm.engine.batch.Batch.
in_subset:
- history
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
slot_usage:
  start_time:
    name: start_time
    required: true
attributes:
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: HistoricBatch
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
  type:
    name: type
    description: Type discriminator.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - ByteArray
    - Authorization
    - Group
    - IdentityInfo
    - IdentityLink
    - CaseSentryPart
    - VariableInstance
    - Attachment
    - Comment
    - Batch
    - Job
    - HistoricBatch
    - HistoricDetail
    - HistoricIdentityLink
    - ConditionExpression
    - CorrelationProperty
    - Relationship
    - ResourceParameter
    range: string
  total_jobs:
    name: total_jobs
    annotations:
      sql_column:
        tag: sql_column
        value: TOTAL_JOBS_
    description: Total number of jobs.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - Batch
    - HistoricBatch
    range: integer
  jobs_per_seed:
    name: jobs_per_seed
    annotations:
      sql_column:
        tag: sql_column
        value: JOBS_PER_SEED_
    description: The jobs per seed.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - Batch
    - HistoricBatch
    range: integer
  invocations_per_job:
    name: invocations_per_job
    annotations:
      sql_column:
        tag: sql_column
        value: INVOCATIONS_PER_JOB_
    description: The invocations per job.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - Batch
    - HistoricBatch
    range: integer
  seed_job_definition_id:
    name: seed_job_definition_id
    annotations:
      sql_column:
        tag: sql_column
        value: SEED_JOB_DEF_ID_
    description: Reference to a JobDefinition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - Batch
    - HistoricBatch
    range: string
  monitor_job_definition_id:
    name: monitor_job_definition_id
    annotations:
      sql_column:
        tag: sql_column
        value: MONITOR_JOB_DEF_ID_
    description: Reference to a JobDefinition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - Batch
    - HistoricBatch
    range: string
  batch_job_definition_id:
    name: batch_job_definition_id
    annotations:
      sql_column:
        tag: sql_column
        value: BATCH_JOB_DEF_ID_
    description: Reference to a JobDefinition.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - Batch
    - HistoricBatch
    range: string
  tenant_id:
    name: tenant_id
    description: Multi-tenancy discriminator.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
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
  create_user_id:
    name: create_user_id
    annotations:
      sql_column:
        tag: sql_column
        value: CREATE_USER_ID_
    description: The authenticated user that created this case instance.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - Batch
    - HistoricBatch
    - HistoricCaseInstance
    range: string
  start_time:
    name: start_time
    description: Start timestamp.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - Batch
    - HistoricBatch
    - HistoricScopeInstance
    range: datetime
    required: true
  end_time:
    name: end_time
    description: End timestamp.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - HistoricBatch
    - HistoricIncident
    - HistoricScopeInstance
    range: datetime
  removal_time:
    name: removal_time
    description: Timestamp when this entity is eligible for removal.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
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
  execution_start_time:
    name: execution_start_time
    annotations:
      sql_column:
        tag: sql_column
        value: EXEC_START_TIME_
    description: Timestamp when this started.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: HistoricBatch
    domain_of:
    - Batch
    - HistoricBatch
    range: datetime

```
</details></div>