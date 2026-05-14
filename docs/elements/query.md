---
search:
  boost: 5.0
---

# Slot: query 


_Serialized query expression._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:query](https://w3id.org/TD-Universe/fluxnova-bpm-platform/query)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Filter](Filter.md) | Filter entity in the user collaboration |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Filter](Filter.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | QUERY_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:query |
| native | fluxnova_bpm_platform:query |




## LinkML Source

<details>
```yaml
name: query
annotations:
  sql_column:
    tag: sql_column
    value: QUERY_
description: Serialized query expression.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Filter
range: string
required: true

```
</details></div>