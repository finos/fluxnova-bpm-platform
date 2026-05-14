---
search:
  boost: 5.0
---

# Slot: conversation_associations 


_Associations linking conversation nodes to other elements._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:conversation_associations](https://w3id.org/TD-Universe/fluxnova-bpm-platform/conversation_associations)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Collaboration](Collaboration.md) | The BPMN collaboration element |  no  |
| [GlobalConversation](GlobalConversation.md) | The BPMN globalConversation element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [ConversationAssociation](ConversationAssociation.md) |
| Domain Of | [Collaboration](Collaboration.md) |

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
| self | fluxnova_bpm_platform:conversation_associations |
| native | fluxnova_bpm_platform:conversation_associations |




## LinkML Source

<details>
```yaml
name: conversation_associations
description: Associations linking conversation nodes to other elements.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Collaboration
range: ConversationAssociation
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>