---
search:
  boost: 5.0
---

# Slot: fluxnova_output_parameters 


_Output parameters produced by this connector or script._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:fluxnova_output_parameters](https://w3id.org/TD-Universe/fluxnova-bpm-platform/fluxnova_output_parameters)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [FluxnovaInputOutput](FluxnovaInputOutput.md) | The BPMN inputOutput camunda extension element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [FluxnovaOutputParameter](FluxnovaOutputParameter.md) |
| Domain Of | [FluxnovaInputOutput](FluxnovaInputOutput.md) |

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
| self | fluxnova_bpm_platform:fluxnova_output_parameters |
| native | fluxnova_bpm_platform:fluxnova_output_parameters |




## LinkML Source

<details>
```yaml
name: fluxnova_output_parameters
description: Output parameters produced by this connector or script.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- FluxnovaInputOutput
range: FluxnovaOutputParameter
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>