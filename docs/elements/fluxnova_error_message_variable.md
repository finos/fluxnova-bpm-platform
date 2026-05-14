---
search:
  boost: 5.0
---

# Slot: fluxnova_error_message_variable 


_Process variable to receive the error message._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:fluxnova_error_message_variable](https://w3id.org/TD-Universe/fluxnova-bpm-platform/fluxnova_error_message_variable)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ErrorEventDefinition](ErrorEventDefinition.md) | The BPMN errorEventDefinition element |  no  |
| [FluxnovaErrorEventDefinition](FluxnovaErrorEventDefinition.md) | Fluxnova extension that augments an end event error definition with engine-sp... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [ErrorEventDefinition](ErrorEventDefinition.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:fluxnova_error_message_variable |
| native | fluxnova_bpm_platform:fluxnova_error_message_variable |




## LinkML Source

<details>
```yaml
name: fluxnova_error_message_variable
description: Process variable to receive the error message.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ErrorEventDefinition
range: string

```
</details></div>