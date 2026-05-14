---
search:
  boost: 5.0
---

# Slot: incident_message 


_Incident message._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:incident_message](https://w3id.org/TD-Universe/fluxnova-bpm-platform/incident_message)
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










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | INCIDENT_MSG_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:incident_message |
| native | fluxnova_bpm_platform:incident_message |




## LinkML Source

<details>
```yaml
name: incident_message
annotations:
  sql_column:
    tag: sql_column
    value: INCIDENT_MSG_
description: Incident message.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Incident
- HistoricIncident
range: string

```
</details></div>