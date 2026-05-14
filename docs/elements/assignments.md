---
search:
  boost: 5.0
---

# Slot: assignments 


_Data assignments (from/to) within this data association._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:assignments](https://w3id.org/TD-Universe/fluxnova-bpm-platform/assignments)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [DataAssociation](DataAssociation.md) | The BPMN dataAssociation element |  no  |
| [DataInputAssociation](DataInputAssociation.md) | The BPMN dataInputAssociation element |  no  |
| [DataOutputAssociation](DataOutputAssociation.md) | The BPMN dataOutputAssociation element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Assignment](Assignment.md) |
| Domain Of | [DataAssociation](DataAssociation.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Multivalued | Yes |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:assignments |
| native | fluxnova_bpm_platform:assignments |




## LinkML Source

<details>
```yaml
name: assignments
description: Data assignments (from/to) within this data association.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- DataAssociation
range: Assignment
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>