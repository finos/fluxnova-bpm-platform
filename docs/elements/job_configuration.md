---
search:
  boost: 5.0
---

# Slot: job_configuration 


_The configuration of a job definition provides details about the jobs which will be created. For timer jobs this method returns the timer configuration._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_configuration](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_configuration)
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










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | JOB_CONFIGURATION_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_configuration |
| native | fluxnova_bpm_platform:job_configuration |




## LinkML Source

<details>
```yaml
name: job_configuration
annotations:
  sql_column:
    tag: sql_column
    value: JOB_CONFIGURATION_
description: The configuration of a job definition provides details about the jobs
  which will be created. For timer jobs this method returns the timer configuration.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- JobDefinition
range: string

```
</details></div>