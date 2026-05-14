---
search:
  boost: 5.0
---

# Slot: event_definitions 


_Event definitions that specify the event trigger type._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:event_definitions](https://w3id.org/TD-Universe/fluxnova-bpm-platform/event_definitions)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CatchEvent](CatchEvent.md) | The BPMN catchEvent element |  no  |
| [ThrowEvent](ThrowEvent.md) | The BPMN throwEvent element |  no  |
| [BoundaryEvent](BoundaryEvent.md) | The BPMN boundaryEvent element |  no  |
| [EndEvent](EndEvent.md) | The BPMN endEvent element |  no  |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | The BPMN intermediateCatchEvent element |  no  |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | The BPMN intermediateThrowEvent element |  no  |
| [StartEvent](StartEvent.md) | The BPMN startEvent element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [EventDefinition](EventDefinition.md) |
| Domain Of | [CatchEvent](CatchEvent.md), [ThrowEvent](ThrowEvent.md) |

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
| self | fluxnova_bpm_platform:event_definitions |
| native | fluxnova_bpm_platform:event_definitions |




## LinkML Source

<details>
```yaml
name: event_definitions
description: Event definitions that specify the event trigger type.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CatchEvent
- ThrowEvent
range: EventDefinition
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>