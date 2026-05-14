---
search:
  boost: 5.0
---

# Slot: create_user_id 


_The authenticated user that created this case instance._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:create_user_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/create_user_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Batch](Batch.md) | A batch represents a number of jobs which execute a number of commands asynch... |  no  |
| [HistoricBatch](HistoricBatch.md) | Historic representation of a org |  no  |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Batch](Batch.md), [HistoricBatch](HistoricBatch.md), [HistoricCaseInstance](HistoricCaseInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CREATE_USER_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:create_user_id |
| native | fluxnova_bpm_platform:create_user_id |




## LinkML Source

<details>
```yaml
name: create_user_id
annotations:
  sql_column:
    tag: sql_column
    value: CREATE_USER_ID_
description: The authenticated user that created this case instance.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Batch
- HistoricBatch
- HistoricCaseInstance
range: string

```
</details></div>