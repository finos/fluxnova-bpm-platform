---
search:
  boost: 5.0
---

# Slot: history_configuration 


_History payload of this incident._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:history_configuration](https://w3id.org/TD-Universe/fluxnova-bpm-platform/history_configuration)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricIncident](HistoricIncident.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | HISTORY_CONFIGURATION_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:history_configuration |
| native | fluxnova_bpm_platform:history_configuration |




## LinkML Source

<details>
```yaml
name: history_configuration
annotations:
  sql_column:
    tag: sql_column
    value: HISTORY_CONFIGURATION_
description: History payload of this incident.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricIncident
range: string

```
</details></div>