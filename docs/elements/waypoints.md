---
search:
  boost: 5.0
---

# Slot: waypoints 


_Ordered list of waypoints defining the visual path of this edge._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:waypoints](https://w3id.org/TD-Universe/fluxnova-bpm-platform/waypoints)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Edge](Edge.md) | The DI Edge element |  no  |
| [LabeledEdge](LabeledEdge.md) | The DI LabeledEdge element |  no  |
| [BpmnEdge](BpmnEdge.md) | The BPMNDI BPMNEdge element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Waypoint](Waypoint.md) |
| Domain Of | [Edge](Edge.md) |

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
| self | fluxnova_bpm_platform:waypoints |
| native | fluxnova_bpm_platform:waypoints |




## LinkML Source

<details>
```yaml
name: waypoints
description: Ordered list of waypoints defining the visual path of this edge.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Edge
range: Waypoint
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>