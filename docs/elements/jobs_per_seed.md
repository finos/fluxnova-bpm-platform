---
search:
  boost: 5.0
---

# Slot: jobs_per_seed 


_The jobs per seed._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:jobs_per_seed](https://w3id.org/TD-Universe/fluxnova-bpm-platform/jobs_per_seed)
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
| sql_column | JOBS_PER_SEED_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:jobs_per_seed |
| native | fluxnova_bpm_platform:jobs_per_seed |




## LinkML Source

<details>
```yaml
name: jobs_per_seed
annotations:
  sql_column:
    tag: sql_column
    value: JOBS_PER_SEED_
description: The jobs per seed.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Batch
- HistoricBatch
range: integer

```
</details></div>