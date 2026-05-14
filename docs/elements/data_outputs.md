---
search:
  boost: 5.0
---

# Slot: data_outputs 


_Output data elements of this specification._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:data_outputs](https://w3id.org/TD-Universe/fluxnova-bpm-platform/data_outputs)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CatchEvent](CatchEvent.md) | The BPMN catchEvent element |  no  |
| [IoSpecification](IoSpecification.md) | The BPMN inputOutputSpecification element |  no  |
| [BoundaryEvent](BoundaryEvent.md) | The BPMN boundaryEvent element |  no  |
| [IntermediateCatchEvent](IntermediateCatchEvent.md) | The BPMN intermediateCatchEvent element |  no  |
| [StartEvent](StartEvent.md) | The BPMN startEvent element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [DataOutput](DataOutput.md) |
| Domain Of | [CatchEvent](CatchEvent.md), [IoSpecification](IoSpecification.md) |

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
| self | fluxnova_bpm_platform:data_outputs |
| native | fluxnova_bpm_platform:data_outputs |




## LinkML Source

<details>
```yaml
name: data_outputs
description: Output data elements of this specification.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CatchEvent
- IoSpecification
range: DataOutput
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>