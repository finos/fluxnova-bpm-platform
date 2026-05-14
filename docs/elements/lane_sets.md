---
search:
  boost: 5.0
---

# Slot: lane_sets 


_Lane sets partitioning this process into swimlanes._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:lane_sets](https://w3id.org/TD-Universe/fluxnova-bpm-platform/lane_sets)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Process](Process.md) | The BPMN process element |  no  |
| [SubProcess](SubProcess.md) | The BPMN subProcess element |  no  |
| [Transaction](Transaction.md) | A sub-process that executes as an atomic unit with compensation support |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [LaneSet](LaneSet.md) |
| Domain Of | [Process](Process.md), [SubProcess](SubProcess.md) |

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
| self | fluxnova_bpm_platform:lane_sets |
| native | fluxnova_bpm_platform:lane_sets |




## LinkML Source

<details>
```yaml
name: lane_sets
description: Lane sets partitioning this process into swimlanes.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Process
- SubProcess
range: LaneSet
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>