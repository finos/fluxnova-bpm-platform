---
search:
  boost: 5.0
---

# Slot: configuration 


_Payload of this incident._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:configuration](https://w3id.org/TD-Universe/fluxnova-bpm-platform/configuration)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [EventSubscription](EventSubscription.md) | A message event subscription exists, if an Execution waits for an event like ... |  no  |
| [Incident](Incident.md) | An Incident represents a failure in the execution of a process instance |  no  |
| [Batch](Batch.md) | A batch represents a number of jobs which execute a number of commands asynch... |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [EventSubscription](EventSubscription.md), [Incident](Incident.md), [Batch](Batch.md), [HistoricIncident](HistoricIncident.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CONFIGURATION_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:configuration |
| native | fluxnova_bpm_platform:configuration |




## LinkML Source

<details>
```yaml
name: configuration
annotations:
  sql_column:
    tag: sql_column
    value: CONFIGURATION_
description: Payload of this incident.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- EventSubscription
- Incident
- Batch
- HistoricIncident
range: string

```
</details></div>