---
search:
  boost: 5.0
---

# Slot: bytes 


_Serialized binary content._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:bytes](https://w3id.org/TD-Universe/fluxnova-bpm-platform/bytes)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ByteArray](ByteArray.md) | Byte Array entity in the engine infrastructure |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [ByteArray](ByteArray.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | BYTES_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:bytes |
| native | fluxnova_bpm_platform:bytes |




## LinkML Source

<details>
```yaml
name: bytes
annotations:
  sql_column:
    tag: sql_column
    value: BYTES_
description: Serialized binary content.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ByteArray
range: string

```
</details></div>