---
search:
  boost: 5.0
---

# Slot: failed_activity_id 


_Id of the activity on which the last exception occurred._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:failed_activity_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/failed_activity_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Incident](Incident.md) | An Incident represents a failure in the execution of a process instance |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Incident](Incident.md), [Job](Job.md), [HistoricIncident](HistoricIncident.md), [HistoricJobLog](HistoricJobLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | FAILED_ACTIVITY_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:failed_activity_id |
| native | fluxnova_bpm_platform:failed_activity_id |




## LinkML Source

<details>
```yaml
name: failed_activity_id
annotations:
  sql_column:
    tag: sql_column
    value: FAILED_ACTIVITY_ID_
description: Id of the activity on which the last exception occurred.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Incident
- Job
- HistoricIncident
- HistoricJobLog
range: string

```
</details></div>