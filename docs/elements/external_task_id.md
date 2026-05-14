---
search:
  boost: 5.0
---

# Slot: external_task_id 


_Id of the associated external task._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:external_task_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/external_task_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | EXT_TASK_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:external_task_id |
| native | fluxnova_bpm_platform:external_task_id |




## LinkML Source

<details>
```yaml
name: external_task_id
annotations:
  sql_column:
    tag: sql_column
    value: EXT_TASK_ID_
description: Id of the associated external task.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricExternalTaskLog
- UserOperationLogEntry
range: string
required: true

```
</details></div>