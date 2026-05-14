---
search:
  boost: 10.0
---

# Class: TaskMeterLog 


_Task Meter Log entity in the engine infrastructure._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:TaskMeterLog](https://w3id.org/TD-Universe/fluxnova-bpm-platform/TaskMeterLog)





```mermaid
 classDiagram
    class TaskMeterLog
    click TaskMeterLog href "../TaskMeterLog/"
      TaskMeterLog : assignee_hash
        
      TaskMeterLog : id
        
      TaskMeterLog : timestamp
        
      
```




<!-- no inheritance hierarchy -->

## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | direct |
| [assignee_hash](assignee_hash.md) | 0..1 <br/> [Integer](Integer.md) | Hash of the assignee for aggregation | direct |
| [timestamp](timestamp.md) | 0..1 <br/> [Datetime](Datetime.md) | Time when this log occurred | direct |











## In Subsets


* [Base](Base.md)
* [FluxnovaBpm](FluxnovaBpm.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_table | ACT_RU_TASK_METER_LOG |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:TaskMeterLog |
| native | fluxnova_bpm_platform:TaskMeterLog |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: TaskMeterLog
annotations:
  sql_table:
    tag: sql_table
    value: ACT_RU_TASK_METER_LOG
description: Task Meter Log entity in the engine infrastructure.
in_subset:
- base
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
slots:
- id
- assignee_hash
- timestamp

```
</details>

### Induced

<details>
```yaml
name: TaskMeterLog
annotations:
  sql_table:
    tag: sql_table
    value: ACT_RU_TASK_METER_LOG
description: Task Meter Log entity in the engine infrastructure.
in_subset:
- base
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
attributes:
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: TaskMeterLog
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
  assignee_hash:
    name: assignee_hash
    annotations:
      sql_column:
        tag: sql_column
        value: ASSIGNEE_HASH_
    description: Hash of the assignee for aggregation.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: TaskMeterLog
    domain_of:
    - TaskMeterLog
    range: integer
  timestamp:
    name: timestamp
    annotations:
      sql_column:
        tag: sql_column
        value: TIMESTAMP_
    description: Time when this log occurred.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: TaskMeterLog
    domain_of:
    - MeterLog
    - SchemaLogEntry
    - TaskMeterLog
    - HistoricExternalTaskLog
    - HistoricIdentityLink
    - HistoricJobLog
    - UserOperationLogEntry
    range: datetime

```
</details></div>