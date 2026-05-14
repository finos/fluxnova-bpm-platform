---
search:
  boost: 5.0
---

# Slot: jobs_created 


_The jobs created._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:jobs_created](https://w3id.org/TD-Universe/fluxnova-bpm-platform/jobs_created)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Batch](Batch.md) | A batch represents a number of jobs which execute a number of commands asynch... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [Batch](Batch.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | JOBS_CREATED_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:jobs_created |
| native | fluxnova_bpm_platform:jobs_created |




## LinkML Source

<details>
```yaml
name: jobs_created
annotations:
  sql_column:
    tag: sql_column
    value: JOBS_CREATED_
description: The jobs created.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Batch
range: integer

```
</details></div>