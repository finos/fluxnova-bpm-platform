---
search:
  boost: 5.0
---

# Slot: lanes 


_Sub-lanes contained in this lane._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:lanes](https://w3id.org/TD-Universe/fluxnova-bpm-platform/lanes)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [LaneSet](LaneSet.md) | The BPMN laneSet element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Lane](Lane.md) |
| Domain Of | [LaneSet](LaneSet.md) |

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
| self | fluxnova_bpm_platform:lanes |
| native | fluxnova_bpm_platform:lanes |




## LinkML Source

<details>
```yaml
name: lanes
description: Sub-lanes contained in this lane.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- LaneSet
range: Lane
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>