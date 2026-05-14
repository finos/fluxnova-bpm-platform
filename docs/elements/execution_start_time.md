---
search:
  boost: 5.0
---

# Slot: execution_start_time 


_Timestamp when this started._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:execution_start_time](https://w3id.org/TD-Universe/fluxnova-bpm-platform/execution_start_time)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Batch](Batch.md) | A batch represents a number of jobs which execute a number of commands asynch... |  no  |
| [HistoricBatch](HistoricBatch.md) | Historic representation of a org |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [Batch](Batch.md), [HistoricBatch](HistoricBatch.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | EXEC_START_TIME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:execution_start_time |
| native | fluxnova_bpm_platform:execution_start_time |




## LinkML Source

<details>
```yaml
name: execution_start_time
annotations:
  sql_column:
    tag: sql_column
    value: EXEC_START_TIME_
description: Timestamp when this started.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Batch
- HistoricBatch
range: datetime

```
</details></div>