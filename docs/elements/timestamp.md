---
search:
  boost: 5.0
---

# Slot: timestamp 


_Time when this log occurred._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:timestamp](https://w3id.org/TD-Universe/fluxnova-bpm-platform/timestamp)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [MeterLog](MeterLog.md) | Meter Log entity in the engine infrastructure |  no  |
| [SchemaLogEntry](SchemaLogEntry.md) | Schema Log Entry entity in the engine infrastructure |  no  |
| [TaskMeterLog](TaskMeterLog.md) | Task Meter Log entity in the engine infrastructure |  no  |
| [HistoricExternalTaskLog](HistoricExternalTaskLog.md) | The HistoricExternalTaskLog is used to have a log containing information abou... |  yes  |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |  yes  |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  yes  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  yes  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [MeterLog](MeterLog.md), [SchemaLogEntry](SchemaLogEntry.md), [TaskMeterLog](TaskMeterLog.md), [HistoricExternalTaskLog](HistoricExternalTaskLog.md), [HistoricIdentityLink](HistoricIdentityLink.md), [HistoricJobLog](HistoricJobLog.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | TIMESTAMP_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:timestamp |
| native | fluxnova_bpm_platform:timestamp |




## LinkML Source

<details>
```yaml
name: timestamp
annotations:
  sql_column:
    tag: sql_column
    value: TIMESTAMP_
description: Time when this log occurred.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- MeterLog
- SchemaLogEntry
- TaskMeterLog
- HistoricExternalTaskLog
- HistoricIdentityLink
- HistoricJobLog
- UserOperationLogEntry
range: datetime

```
</details></div>