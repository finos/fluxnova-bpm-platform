---
search:
  boost: 5.0
---

# Slot: retries 


_Number of retries this job has left. Whenever the jobexecutor fails to execute the job, this value is decremented. When it hits zero, the job is supposed to be dead and not retried again (ie a manu..._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:retries](https://w3id.org/TD-Universe/fluxnova-bpm-platform/retries)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [ExternalTask](ExternalTask.md), [Job](Job.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | RETRIES_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:retries |
| native | fluxnova_bpm_platform:retries |




## LinkML Source

<details>
```yaml
name: retries
annotations:
  sql_column:
    tag: sql_column
    value: RETRIES_
description: Number of retries this job has left. Whenever the jobexecutor fails to
  execute the job, this value is decremented. When it hits zero, the job is supposed
  to be dead and not retried again (ie a manu...
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ExternalTask
- Job
- HistoricExternalTaskLog
range: integer

```
</details></div>