---
search:
  boost: 5.0
---

# Slot: job_definition_id 


_Reference to the job definition._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_definition_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_definition_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Incident](Incident.md) | An Incident represents a failure in the execution of a process instance |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Incident](Incident.md), [Job](Job.md), [HistoricIncident](HistoricIncident.md), [HistoricJobLog](HistoricJobLog.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_definition_id |
| native | fluxnova_bpm_platform:job_definition_id |




## LinkML Source

<details>
```yaml
name: job_definition_id
description: Reference to the job definition.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Incident
- Job
- HistoricIncident
- HistoricJobLog
- UserOperationLogEntry
range: string

```
</details></div>