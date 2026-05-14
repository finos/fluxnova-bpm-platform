---
search:
  boost: 5.0
---

# Slot: error_details_id 


_Reference to a ByteArray._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:error_details_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/error_details_id)
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
| sql_column | ERROR_DETAILS_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:error_details_id |
| native | fluxnova_bpm_platform:error_details_id |




## LinkML Source

<details>
```yaml
name: error_details_id
annotations:
  sql_column:
    tag: sql_column
    value: ERROR_DETAILS_ID_
description: Reference to a ByteArray.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ExternalTask
- HistoricExternalTaskLog
range: string

```
</details></div>