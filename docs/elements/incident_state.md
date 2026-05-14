---
search:
  boost: 5.0
---

# Slot: incident_state 


_The incident state._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:incident_state](https://w3id.org/TD-Universe/fluxnova-bpm-platform/incident_state)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [IncidentState](IncidentState.md) |
| Domain Of | [HistoricIncident](HistoricIncident.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | INCIDENT_STATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:incident_state |
| native | fluxnova_bpm_platform:incident_state |




## LinkML Source

<details>
```yaml
name: incident_state
annotations:
  sql_column:
    tag: sql_column
    value: INCIDENT_STATE_
description: The incident state.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricIncident
range: IncidentState

```
</details></div>