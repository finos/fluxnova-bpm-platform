---
search:
  boost: 5.0
---

# Slot: job_id 


_Id of the associated job._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricJobLog](HistoricJobLog.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | JOB_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_id |
| native | fluxnova_bpm_platform:job_id |




## LinkML Source

<details>
```yaml
name: job_id
annotations:
  sql_column:
    tag: sql_column
    value: JOB_ID_
description: Id of the associated job.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricJobLog
- UserOperationLogEntry
range: string
required: true

```
</details></div>