---
search:
  boost: 5.0
---

# Slot: job_state 


_The job state._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_state](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_state)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [JobState](JobState.md) |
| Domain Of | [HistoricJobLog](HistoricJobLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | JOB_STATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_state |
| native | fluxnova_bpm_platform:job_state |




## LinkML Source

<details>
```yaml
name: job_state
annotations:
  sql_column:
    tag: sql_column
    value: JOB_STATE_
description: The job state.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricJobLog
range: JobState

```
</details></div>