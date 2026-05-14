---
search:
  boost: 5.0
---

# Slot: flow_elements 


_Flow elements (tasks, gateways, events, sequence flows) in this process._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:flow_elements](https://w3id.org/TD-Universe/fluxnova-bpm-platform/flow_elements)
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
| Range | [FlowElement](FlowElement.md) |
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
| self | fluxnova_bpm_platform:flow_elements |
| native | fluxnova_bpm_platform:flow_elements |




## LinkML Source

<details>
```yaml
name: flow_elements
description: Flow elements (tasks, gateways, events, sequence flows) in this process.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Process
- SubProcess
range: FlowElement
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>