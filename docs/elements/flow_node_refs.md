---
search:
  boost: 5.0
---

# Slot: flow_node_refs 


_Flow nodes allocated to this lane._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:flow_node_refs](https://w3id.org/TD-Universe/fluxnova-bpm-platform/flow_node_refs)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Lane](Lane.md) | The BPMN lane element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [FlowNode](FlowNode.md) |
| Domain Of | [Lane](Lane.md) |

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
| self | fluxnova_bpm_platform:flow_node_refs |
| native | fluxnova_bpm_platform:flow_node_refs |




## LinkML Source

<details>
```yaml
name: flow_node_refs
description: Flow nodes allocated to this lane.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Lane
range: FlowNode
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>