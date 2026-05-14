---
search:
  boost: 5.0
---

# Slot: output_sets 


_Output sets grouping produced output data._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:output_sets](https://w3id.org/TD-Universe/fluxnova-bpm-platform/output_sets)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [InputSet](InputSet.md) | The BPMN inputSet element |  no  |
| [IoSpecification](IoSpecification.md) | The BPMN inputOutputSpecification element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [OutputSet](OutputSet.md) |
| Domain Of | [InputSet](InputSet.md), [IoSpecification](IoSpecification.md) |

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
| self | fluxnova_bpm_platform:output_sets |
| native | fluxnova_bpm_platform:output_sets |




## LinkML Source

<details>
```yaml
name: output_sets
description: Output sets grouping produced output data.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- InputSet
- IoSpecification
range: OutputSet
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>