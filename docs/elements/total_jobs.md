---
search:
  boost: 5.0
---

# Slot: total_jobs 


_Total number of jobs._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:total_jobs](https://w3id.org/TD-Universe/fluxnova-bpm-platform/total_jobs)
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
| Range | [Integer](Integer.md) |
| Domain Of | [Batch](Batch.md), [HistoricBatch](HistoricBatch.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | TOTAL_JOBS_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:total_jobs |
| native | fluxnova_bpm_platform:total_jobs |




## LinkML Source

<details>
```yaml
name: total_jobs
annotations:
  sql_column:
    tag: sql_column
    value: TOTAL_JOBS_
description: Total number of jobs.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Batch
- HistoricBatch
range: integer

```
</details></div>