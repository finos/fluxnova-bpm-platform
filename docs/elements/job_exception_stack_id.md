---
search:
  boost: 5.0
---

# Slot: job_exception_stack_id 


_Reference to the job exception stack._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_exception_stack_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_exception_stack_id)
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
| sql_column | JOB_EXCEPTION_STACK_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_exception_stack_id |
| native | fluxnova_bpm_platform:job_exception_stack_id |




## LinkML Source

<details>
```yaml
name: job_exception_stack_id
annotations:
  sql_column:
    tag: sql_column
    value: JOB_EXCEPTION_STACK_ID_
description: Reference to the job exception stack.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricJobLog
range: string

```
</details></div>