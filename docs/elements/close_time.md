---
search:
  boost: 5.0
---

# Slot: close_time 


_The time the case was closed._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:close_time](https://w3id.org/TD-Universe/fluxnova-bpm-platform/close_time)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricCaseInstance](HistoricCaseInstance.md) | A single execution of a case definition that is stored permanently |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [HistoricCaseInstance](HistoricCaseInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | CLOSE_TIME_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:close_time |
| native | fluxnova_bpm_platform:close_time |




## LinkML Source

<details>
```yaml
name: close_time
annotations:
  sql_column:
    tag: sql_column
    value: CLOSE_TIME_
description: The time the case was closed.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricCaseInstance
range: datetime

```
</details></div>