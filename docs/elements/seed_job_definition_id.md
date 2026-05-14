---
search:
  boost: 5.0
---

# Slot: seed_job_definition_id 


_Reference to a JobDefinition._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:seed_job_definition_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/seed_job_definition_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Batch](Batch.md) | A batch represents a number of jobs which execute a number of commands asynch... |  no  |
| [HistoricBatch](HistoricBatch.md) | Historic representation of a org |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Batch](Batch.md), [HistoricBatch](HistoricBatch.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | SEED_JOB_DEF_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:seed_job_definition_id |
| native | fluxnova_bpm_platform:seed_job_definition_id |




## LinkML Source

<details>
```yaml
name: seed_job_definition_id
annotations:
  sql_column:
    tag: sql_column
    value: SEED_JOB_DEF_ID_
description: Reference to a JobDefinition.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Batch
- HistoricBatch
range: string

```
</details></div>