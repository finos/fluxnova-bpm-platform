---
search:
  boost: 5.0
---

# Slot: parallel_multiple 


_Whether all event triggers must occur (parallel) rather than any one._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:parallel_multiple](https://w3id.org/TD-Universe/fluxnova-bpm-platform/parallel_multiple)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CatchEvent](CatchEvent.md) | The BPMN catchEvent element |  no  |
| [BoundaryEvent](BoundaryEvent.md) | The BPMN boundaryEvent element |  no  |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | The BPMN intermediateCatchEvent element |  no  |
| [StartEvent](StartEvent.md) | The BPMN startEvent element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Boolean](Boolean.md) |
| Domain Of | [CatchEvent](CatchEvent.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:parallel_multiple |
| native | fluxnova_bpm_platform:parallel_multiple |




## LinkML Source

<details>
```yaml
name: parallel_multiple
description: Whether all event triggers must occur (parallel) rather than any one.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CatchEvent
range: boolean

```
</details></div>