---
search:
  boost: 5.0
---

# Slot: root_cause_incident_id 


_Id of the root incident on which this transitive incident has been triggered._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:root_cause_incident_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/root_cause_incident_id)
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
| sql_column | ROOT_CAUSE_INCIDENT_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:root_cause_incident_id |
| native | fluxnova_bpm_platform:root_cause_incident_id |




## LinkML Source

<details>
```yaml
name: root_cause_incident_id
annotations:
  sql_column:
    tag: sql_column
    value: ROOT_CAUSE_INCIDENT_ID_
description: Id of the root incident on which this transitive incident has been triggered.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Incident
- HistoricIncident
range: string

```
</details></div>