---
search:
  boost: 5.0
---

# Slot: reporter 


_Identifier of the reporting node._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:reporter](https://w3id.org/TD-Universe/fluxnova-bpm-platform/reporter)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [MeterLog](MeterLog.md) | Meter Log entity in the engine infrastructure |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [MeterLog](MeterLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | REPORTER_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:reporter |
| native | fluxnova_bpm_platform:reporter |




## LinkML Source

<details>
```yaml
name: reporter
annotations:
  sql_column:
    tag: sql_column
    value: REPORTER_
description: Identifier of the reporting node.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- MeterLog
range: string

```
</details></div>