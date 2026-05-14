---
search:
  boost: 5.0
---

# Slot: owner 


_The userId of the person that is responsible for this task. This is used when a task is delegated._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:owner](https://w3id.org/TD-Universe/fluxnova-bpm-platform/owner)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [Filter](Filter.md) | Filter entity in the user collaboration |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Task](Task.md), [Filter](Filter.md), [HistoricTaskInstance](HistoricTaskInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | OWNER_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:owner |
| native | fluxnova_bpm_platform:owner |




## LinkML Source

<details>
```yaml
name: owner
annotations:
  sql_column:
    tag: sql_column
    value: OWNER_
description: The userId of the person that is responsible for this task. This is used
  when a task is delegated.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Task
- Filter
- HistoricTaskInstance
range: string

```
</details></div>