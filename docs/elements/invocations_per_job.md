---
search:
  boost: 5.0
---

# Slot: invocations_per_job 


_The invocations per job._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:invocations_per_job](https://w3id.org/TD-Universe/fluxnova-bpm-platform/invocations_per_job)
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
| sql_column | INVOCATIONS_PER_JOB_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:invocations_per_job |
| native | fluxnova_bpm_platform:invocations_per_job |




## LinkML Source

<details>
```yaml
name: invocations_per_job
annotations:
  sql_column:
    tag: sql_column
    value: INVOCATIONS_PER_JOB_
description: The invocations per job.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Batch
- HistoricBatch
range: integer

```
</details></div>