---
search:
  boost: 5.0
---

# Slot: job_type 


_The Type of a job. Asynchronous continuation, timer, ..._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_type)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [JobDefinition](JobDefinition.md) | A Job Definition provides details about asynchronous background processing ("... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [JobDefinition](JobDefinition.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | JOB_TYPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_type |
| native | fluxnova_bpm_platform:job_type |




## LinkML Source

<details>
```yaml
name: job_type
annotations:
  sql_column:
    tag: sql_column
    value: JOB_TYPE_
description: The Type of a job. Asynchronous continuation, timer, ...
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- JobDefinition
range: string
required: true

```
</details></div>