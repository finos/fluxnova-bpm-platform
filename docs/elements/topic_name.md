---
search:
  boost: 5.0
---

# Slot: topic_name 


_Topic name of the associated external task._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:topic_name](https://w3id.org/TD-Universe/fluxnova-bpm-platform/topic_name)
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
| sql_column | TOPIC_NAME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:topic_name |
| native | fluxnova_bpm_platform:topic_name |




## LinkML Source

<details>
```yaml
name: topic_name
annotations:
  sql_column:
    tag: sql_column
    value: TOPIC_NAME_
description: Topic name of the associated external task.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ExternalTask
- HistoricExternalTaskLog
range: string

```
</details></div>