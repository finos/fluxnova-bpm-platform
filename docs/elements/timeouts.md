---
search:
  boost: 5.0
---

# Slot: timeouts 


_Collection of timer event definition elements associated with this element._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:timeouts](https://w3id.org/TD-Universe/fluxnova-bpm-platform/timeouts)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [FluxnovaTaskListener](FluxnovaTaskListener.md) | The BPMN taskListener camunda extension element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [TimerEventDefinition](TimerEventDefinition.md) |
| Domain Of | [FluxnovaTaskListener](FluxnovaTaskListener.md) |

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
| self | fluxnova_bpm_platform:timeouts |
| native | fluxnova_bpm_platform:timeouts |




## LinkML Source

<details>
```yaml
name: timeouts
description: Collection of timer event definition elements associated with this element.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- FluxnovaTaskListener
range: TimerEventDefinition
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>