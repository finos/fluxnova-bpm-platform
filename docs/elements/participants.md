---
search:
  boost: 5.0
---

# Slot: participants 


_Participants (pools) in this collaboration._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:participants](https://w3id.org/TD-Universe/fluxnova-bpm-platform/participants)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Collaboration](Collaboration.md) | The BPMN collaboration element |  no  |
| [ConversationNode](ConversationNode.md) | The BPMN conversationNode element |  no  |
| [CallConversation](CallConversation.md) | The BPMN callConversation element |  no  |
| [Conversation](Conversation.md) | The BPMN conversation element |  no  |
| [GlobalConversation](GlobalConversation.md) | The BPMN globalConversation element |  no  |
| [SubConversation](SubConversation.md) | The BPMN subConversation element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Participant](Participant.md) |
| Domain Of | [Collaboration](Collaboration.md), [ConversationNode](ConversationNode.md) |

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
| self | fluxnova_bpm_platform:participants |
| native | fluxnova_bpm_platform:participants |




## LinkML Source

<details>
```yaml
name: participants
description: Participants (pools) in this collaboration.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Collaboration
- ConversationNode
range: Participant
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>