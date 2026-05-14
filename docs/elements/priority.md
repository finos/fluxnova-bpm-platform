---
search:
  boost: 5.0
---

# Slot: priority 


_Indication of how important/urgent this task is with a number between 0 and 100 where higher values mean a higher priority and lower values mean lower priority: [0..19] lowest, [20..39] low, [40..5..._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:priority](https://w3id.org/TD-Universe/fluxnova-bpm-platform/priority)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [ExternalTask](ExternalTask.md), [Task](Task.md), [Job](Job.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [HistoricTaskInstance](HistoricTaskInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | PRIORITY_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:priority |
| native | fluxnova_bpm_platform:priority |




## LinkML Source

<details>
```yaml
name: priority
annotations:
  sql_column:
    tag: sql_column
    value: PRIORITY_
description: 'Indication of how important/urgent this task is with a number between
  0 and 100 where higher values mean a higher priority and lower values mean lower
  priority: [0..19] lowest, [20..39] low, [40..5...'
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ExternalTask
- Task
- Job
- HistoricExternalTaskLog
- HistoricTaskInstance
range: integer
required: true

```
</details></div>