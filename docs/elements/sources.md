---
search:
  boost: 5.0
---

# Slot: sources 


_The throwing link events that send to this link target._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:sources](https://w3id.org/TD-Universe/fluxnova-bpm-platform/sources)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [DataAssociation](DataAssociation.md) | The BPMN dataAssociation element |  no  |
| [LinkEventDefinition](LinkEventDefinition.md) | The BPMN linkEventDefinition element |  yes  |
| [Relationship](Relationship.md) | The BPMN relationship element |  yes  |
| [DataInputAssociation](DataInputAssociation.md) | The BPMN dataInputAssociation element |  no  |
| [DataOutputAssociation](DataOutputAssociation.md) | The BPMN dataOutputAssociation element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [ItemAwareElement](ItemAwareElement.md) |
| Domain Of | [DataAssociation](DataAssociation.md), [LinkEventDefinition](LinkEventDefinition.md), [Relationship](Relationship.md) |

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
| self | fluxnova_bpm_platform:sources |
| native | fluxnova_bpm_platform:sources |




## LinkML Source

<details>
```yaml
name: sources
description: The throwing link events that send to this link target.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- DataAssociation
- LinkEventDefinition
- Relationship
range: ItemAwareElement
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>