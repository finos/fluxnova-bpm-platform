---
search:
  boost: 5.0
---

# Slot: data_inputs 


_Input data elements of this specification._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:data_inputs](https://w3id.org/TD-Universe/fluxnova-bpm-platform/data_inputs)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [InputSet](InputSet.md) | The BPMN inputSet element |  no  |
| [IoSpecification](IoSpecification.md) | The BPMN inputOutputSpecification element |  no  |
| [ThrowEvent](ThrowEvent.md) | The BPMN throwEvent element |  no  |
| [EndEvent](EndEvent.md) | The BPMN endEvent element |  no  |
| [IntermediateThrowEvent](IntermediateThrowEvent.md) | The BPMN intermediateThrowEvent element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [DataInput](DataInput.md) |
| Domain Of | [InputSet](InputSet.md), [IoSpecification](IoSpecification.md), [ThrowEvent](ThrowEvent.md) |

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
| self | fluxnova_bpm_platform:data_inputs |
| native | fluxnova_bpm_platform:data_inputs |




## LinkML Source

<details>
```yaml
name: data_inputs
description: Input data elements of this specification.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- InputSet
- IoSpecification
- ThrowEvent
range: DataInput
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>