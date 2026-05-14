---
search:
  boost: 5.0
---

# Slot: end_time 


_End timestamp._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:end_time](https://w3id.org/TD-Universe/fluxnova-bpm-platform/end_time)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricBatch](HistoricBatch.md) | Historic representation of a org |  no  |
| [HistoricIncident](HistoricIncident.md) | Represents a historic Incident incident that is stored permanently |  no  |
| [HistoricScopeInstance](HistoricScopeInstance.md) | Abstract base for historic entities with start/end time and duration |  no  |
| [HistoricActivityInstance](HistoricActivityInstance.md) | Represents one execution of an activity and it's stored permanent for statist... |  no  |
| [HistoricCaseActivityInstance](HistoricCaseActivityInstance.md) | Represents one execution of a case activity which is stored permanent for sta... |  no  |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  no  |
| [HistoricProcessInstance](HistoricProcessInstance.md) | A single execution of a whole process definition that is stored permanently |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [HistoricBatch](HistoricBatch.md), [HistoricIncident](HistoricIncident.md), [HistoricScopeInstance](HistoricScopeInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:end_time |
| native | fluxnova_bpm_platform:end_time |




## LinkML Source

<details>
```yaml
name: end_time
description: End timestamp.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricBatch
- HistoricIncident
- HistoricScopeInstance
range: datetime

```
</details></div>