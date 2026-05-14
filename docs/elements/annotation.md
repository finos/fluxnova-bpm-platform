---
search:
  boost: 5.0
---

# Slot: annotation 


_Annotation of this incident_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:annotation](https://w3id.org/TD-Universe/fluxnova-bpm-platform/annotation)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Incident](Incident.md) | An Incident represents a failure in the execution of a process instance |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Incident](Incident.md), [HistoricIncident](HistoricIncident.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ANNOTATION_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:annotation |
| native | fluxnova_bpm_platform:annotation |




## LinkML Source

<details>
```yaml
name: annotation
annotations:
  sql_column:
    tag: sql_column
    value: ANNOTATION_
description: Annotation of this incident
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Incident
- HistoricIncident
- UserOperationLogEntry
range: string

```
</details></div>