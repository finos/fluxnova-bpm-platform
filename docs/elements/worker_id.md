---
search:
  boost: 5.0
---

# Slot: worker_id 


_Id of the worker that fetched the external task most recently._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:worker_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/worker_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [ExternalTask](ExternalTask.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | WORKER_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:worker_id |
| native | fluxnova_bpm_platform:worker_id |




## LinkML Source

<details>
```yaml
name: worker_id
annotations:
  sql_column:
    tag: sql_column
    value: WORKER_ID_
description: Id of the worker that fetched the external task most recently.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ExternalTask
- HistoricExternalTaskLog
range: string

```
</details></div>