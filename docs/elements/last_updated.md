---
search:
  boost: 5.0
---

# Slot: last_updated 


_The date/time when this task was last updated. All operations that fire count as an update to the task. Returns null if the task was never updated before (i.e. it was only created)._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:last_updated](https://w3id.org/TD-Universe/fluxnova-bpm-platform/last_updated)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Task](Task.md) | Represents one task for a human user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [Task](Task.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | LAST_UPDATED_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:last_updated |
| native | fluxnova_bpm_platform:last_updated |




## LinkML Source

<details>
```yaml
name: last_updated
annotations:
  sql_column:
    tag: sql_column
    value: LAST_UPDATED_
description: The date/time when this task was last updated. All operations that fire
  count as an update to the task. Returns null if the task was never updated before
  (i.e. it was only created).
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Task
range: datetime

```
</details></div>