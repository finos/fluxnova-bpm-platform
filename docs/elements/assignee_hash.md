---
search:
  boost: 5.0
---

# Slot: assignee_hash 


_Hash of the assignee for aggregation._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:assignee_hash](https://w3id.org/TD-Universe/fluxnova-bpm-platform/assignee_hash)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [TaskMeterLog](TaskMeterLog.md) | Task Meter Log entity in the engine infrastructure |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Integer](Integer.md) |
| Domain Of | [TaskMeterLog](TaskMeterLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | ASSIGNEE_HASH_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:assignee_hash |
| native | fluxnova_bpm_platform:assignee_hash |




## LinkML Source

<details>
```yaml
name: assignee_hash
annotations:
  sql_column:
    tag: sql_column
    value: ASSIGNEE_HASH_
description: Hash of the assignee for aggregation.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- TaskMeterLog
range: integer

```
</details></div>