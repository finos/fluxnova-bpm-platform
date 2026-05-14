---
search:
  boost: 5.0
---

# Slot: end_points 


_Endpoints associated with this process or service._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:end_points](https://w3id.org/TD-Universe/fluxnova-bpm-platform/end_points)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Participant](Participant.md) | The BPMN participant element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [EndPoint](EndPoint.md) |
| Domain Of | [Participant](Participant.md) |

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
| self | fluxnova_bpm_platform:end_points |
| native | fluxnova_bpm_platform:end_points |




## LinkML Source

<details>
```yaml
name: end_points
description: Endpoints associated with this process or service.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Participant
range: EndPoint
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>