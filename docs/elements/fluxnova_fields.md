---
search:
  boost: 5.0
---

# Slot: fluxnova_fields 


_Field elements of this connector or form._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:fluxnova_fields](https://w3id.org/TD-Universe/fluxnova-bpm-platform/fluxnova_fields)
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
| Range | [FluxnovaField](FluxnovaField.md) |
| Domain Of | [FluxnovaExecutionListener](FluxnovaExecutionListener.md), [FluxnovaTaskListener](FluxnovaTaskListener.md) |

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
| self | fluxnova_bpm_platform:fluxnova_fields |
| native | fluxnova_bpm_platform:fluxnova_fields |




## LinkML Source

<details>
```yaml
name: fluxnova_fields
description: Field elements of this connector or form.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- FluxnovaExecutionListener
- FluxnovaTaskListener
range: FluxnovaField
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>