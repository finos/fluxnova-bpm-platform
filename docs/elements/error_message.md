---
search:
  boost: 5.0
---

# Slot: error_message 


_If the variable value could not be loaded, this returns the error message._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:error_message](https://w3id.org/TD-Universe/fluxnova-bpm-platform/error_message)
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
| sql_column | ERROR_MSG_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:error_message |
| native | fluxnova_bpm_platform:error_message |




## LinkML Source

<details>
```yaml
name: error_message
annotations:
  sql_column:
    tag: sql_column
    value: ERROR_MSG_
description: If the variable value could not be loaded, this returns the error message.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ExternalTask
- HistoricExternalTaskLog
range: string

```
</details></div>