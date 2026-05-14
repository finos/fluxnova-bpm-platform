---
search:
  boost: 5.0
---

# Slot: variable_instance_id 


_Reference to the variable instance._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:variable_instance_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/variable_instance_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricDetail](HistoricDetail.md) | Base class for all kinds of information that is related to either a HistoricP... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [HistoricDetail](HistoricDetail.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | VAR_INST_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:variable_instance_id |
| native | fluxnova_bpm_platform:variable_instance_id |




## LinkML Source

<details>
```yaml
name: variable_instance_id
annotations:
  sql_column:
    tag: sql_column
    value: VAR_INST_ID_
description: Reference to the variable instance.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricDetail
range: string

```
</details></div>