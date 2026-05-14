---
search:
  boost: 5.0
---

# Slot: job_retries 


_Retries of the associated job before the associated job has been executed and when this log occurred._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_retries](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_retries)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [HistoricJobLog](HistoricJobLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | JOB_RETRIES_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_retries |
| native | fluxnova_bpm_platform:job_retries |




## LinkML Source

<details>
```yaml
name: job_retries
annotations:
  sql_column:
    tag: sql_column
    value: JOB_RETRIES_
description: Retries of the associated job before the associated job has been executed
  and when this log occurred.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricJobLog
range: integer

```
</details></div>