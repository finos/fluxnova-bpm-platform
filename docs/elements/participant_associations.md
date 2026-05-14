---
search:
  boost: 5.0
---

# Slot: participant_associations 


_Associations between participants._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:participant_associations](https://w3id.org/TD-Universe/fluxnova-bpm-platform/participant_associations)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CallConversation](CallConversation.md) | The BPMN callConversation element |  no  |
| [Collaboration](Collaboration.md) | The BPMN collaboration element |  no  |
| [GlobalConversation](GlobalConversation.md) | The BPMN globalConversation element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [ParticipantAssociation](ParticipantAssociation.md) |
| Domain Of | [CallConversation](CallConversation.md), [Collaboration](Collaboration.md) |

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
| self | fluxnova_bpm_platform:participant_associations |
| native | fluxnova_bpm_platform:participant_associations |




## LinkML Source

<details>
```yaml
name: participant_associations
description: Associations between participants.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CallConversation
- Collaboration
range: ParticipantAssociation
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>