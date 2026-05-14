---
search:
  boost: 5.0
---

# Slot: job_definition_configuration 


_Job definition configuration type of the associated job._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_definition_configuration](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_definition_configuration)
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
| sql_column | JOB_DEF_CONFIGURATION_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_definition_configuration |
| native | fluxnova_bpm_platform:job_definition_configuration |




## LinkML Source

<details>
```yaml
name: job_definition_configuration
annotations:
  sql_column:
    tag: sql_column
    value: JOB_DEF_CONFIGURATION_
description: Job definition configuration type of the associated job.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricJobLog
range: string

```
</details></div>