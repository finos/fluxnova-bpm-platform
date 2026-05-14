---
search:
  boost: 5.0
---

# Slot: job_priority 


_Priority of the associated job when this log entry was created._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_priority](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_priority)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [JobDefinition](JobDefinition.md) | A Job Definition provides details about asynchronous background processing ("... |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [JobDefinition](JobDefinition.md), [HistoricJobLog](HistoricJobLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | JOB_PRIORITY_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_priority |
| native | fluxnova_bpm_platform:job_priority |




## LinkML Source

<details>
```yaml
name: job_priority
annotations:
  sql_column:
    tag: sql_column
    value: JOB_PRIORITY_
description: Priority of the associated job when this log entry was created.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- JobDefinition
- HistoricJobLog
range: integer
required: true

```
</details></div>