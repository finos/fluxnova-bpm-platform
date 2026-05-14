---
search:
  boost: 5.0
---

# Slot: incident_type 


_Type of this incident to identify the kind of incident. For example: failedJobs will be returned in the case of an incident, which identify failed job during the execution of a process instance._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:incident_type](https://w3id.org/TD-Universe/fluxnova-bpm-platform/incident_type)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Incident](Incident.md) | An Incident represents a failure in the execution of a process instance |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Incident](Incident.md), [HistoricIncident](HistoricIncident.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | INCIDENT_TYPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:incident_type |
| native | fluxnova_bpm_platform:incident_type |




## LinkML Source

<details>
```yaml
name: incident_type
annotations:
  sql_column:
    tag: sql_column
    value: INCIDENT_TYPE_
description: 'Type of this incident to identify the kind of incident. For example:
  failedJobs will be returned in the case of an incident, which identify failed job
  during the execution of a process instance.'
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Incident
- HistoricIncident
range: string
required: true

```
</details></div>