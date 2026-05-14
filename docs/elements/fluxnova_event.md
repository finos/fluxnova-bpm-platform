---
search:
  boost: 5.0
---

# Slot: fluxnova_event 


_Event that triggers this execution listener._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:fluxnova_event](https://w3id.org/TD-Universe/fluxnova-bpm-platform/fluxnova_event)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [FluxnovaExecutionListener](FluxnovaExecutionListener.md) | The BPMN executionListener camunda extension element |  no  |
| [FluxnovaTaskListener](FluxnovaTaskListener.md) | The BPMN taskListener camunda extension element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [FluxnovaExecutionListener](FluxnovaExecutionListener.md), [FluxnovaTaskListener](FluxnovaTaskListener.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:fluxnova_event |
| native | fluxnova_bpm_platform:fluxnova_event |




## LinkML Source

<details>
```yaml
name: fluxnova_event
description: Event that triggers this execution listener.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- FluxnovaExecutionListener
- FluxnovaTaskListener
range: string

```
</details></div>