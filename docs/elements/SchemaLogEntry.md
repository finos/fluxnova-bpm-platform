---
search:
  boost: 10.0
---

# Class: SchemaLogEntry 


_Schema Log Entry entity in the engine infrastructure._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:SchemaLogEntry](https://w3id.org/TD-Universe/fluxnova-bpm-platform/SchemaLogEntry)





```mermaid
 classDiagram
    class SchemaLogEntry
    click SchemaLogEntry href "../SchemaLogEntry/"
      SchemaLogEntry : id
        
      SchemaLogEntry : timestamp
        
      SchemaLogEntry : version
        
      
```




<!-- no inheritance hierarchy -->

## Slots

| Name | Cardinality and Range | Description | Inheritance |
| ---  | --- | --- | --- |
| [id](id.md) | 1 <br/> [String](String.md) | Unique identifier | direct |
| [timestamp](timestamp.md) | 0..1 <br/> [Datetime](Datetime.md) | Time when this log occurred | direct |
| [version](version.md) | 0..1 <br/> [String](String.md) | Version number | direct |











## In Subsets


* [Base](Base.md)
* [FluxnovaBpm](FluxnovaBpm.md)






## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_table | ACT_GE_SCHEMA_LOG |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:SchemaLogEntry |
| native | fluxnova_bpm_platform:SchemaLogEntry |






## LinkML Source

<!-- TODO: investigate https://stackoverflow.com/questions/37606292/how-to-create-tabbed-code-blocks-in-mkdocs-or-sphinx -->

### Direct

<details>
```yaml
name: SchemaLogEntry
annotations:
  sql_table:
    tag: sql_table
    value: ACT_GE_SCHEMA_LOG
description: Schema Log Entry entity in the engine infrastructure.
in_subset:
- base
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
slots:
- id
- timestamp
- version
slot_usage:
  version:
    name: version
    range: string

```
</details>

### Induced

<details>
```yaml
name: SchemaLogEntry
annotations:
  sql_table:
    tag: sql_table
    value: ACT_GE_SCHEMA_LOG
description: Schema Log Entry entity in the engine infrastructure.
in_subset:
- base
- fluxnova_bpm
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
slot_usage:
  version:
    name: version
    range: string
attributes:
  id:
    name: id
    description: Unique identifier.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    slot_uri: schema:identifier
    identifier: true
    owner: SchemaLogEntry
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
  timestamp:
    name: timestamp
    annotations:
      sql_column:
        tag: sql_column
        value: TIMESTAMP_
    description: Time when this log occurred.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SchemaLogEntry
    domain_of:
    - MeterLog
    - SchemaLogEntry
    - TaskMeterLog
    - HistoricExternalTaskLog
    - HistoricIdentityLink
    - HistoricJobLog
    - UserOperationLogEntry
    range: datetime
  version:
    name: version
    description: Version number.
    from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
    rank: 1000
    owner: SchemaLogEntry
    domain_of:
    - SchemaLogEntry
    - ResourceDefinition
    range: string

```
</details></div>