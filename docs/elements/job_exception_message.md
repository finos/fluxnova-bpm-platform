---
search:
  boost: 5.0
---

# Slot: job_exception_message 


_Message of the exception that occurred by executing the associated job. To get the full exception stacktrace, use_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_exception_message](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_exception_message)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricJobLog](HistoricJobLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | JOB_EXCEPTION_MSG_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_exception_message |
| native | fluxnova_bpm_platform:job_exception_message |




## LinkML Source

<details>
```yaml
name: job_exception_message
annotations:
  sql_column:
    tag: sql_column
    value: JOB_EXCEPTION_MSG_
description: Message of the exception that occurred by executing the associated job.
  To get the full exception stacktrace, use
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricJobLog
range: string

```
</details></div>