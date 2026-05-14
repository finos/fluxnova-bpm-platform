---
search:
  boost: 5.0
---

# Slot: incident_timestamp 


_Time when the incident happened._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:incident_timestamp](https://w3id.org/TD-Universe/fluxnova-bpm-platform/incident_timestamp)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Incident](Incident.md) | An Incident represents a failure in the execution of a process instance |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [Incident](Incident.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | INCIDENT_TIMESTAMP_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:incident_timestamp |
| native | fluxnova_bpm_platform:incident_timestamp |




## LinkML Source

<details>
```yaml
name: incident_timestamp
annotations:
  sql_column:
    tag: sql_column
    value: INCIDENT_TIMESTAMP_
description: Time when the incident happened.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Incident
range: datetime
required: true

```
</details></div>