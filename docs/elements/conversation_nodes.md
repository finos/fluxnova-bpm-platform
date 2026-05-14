---
search:
  boost: 5.0
---

# Slot: conversation_nodes 


_Conversation nodes in this collaboration._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:conversation_nodes](https://w3id.org/TD-Universe/fluxnova-bpm-platform/conversation_nodes)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Collaboration](Collaboration.md) | The BPMN collaboration element |  no  |
| [SubConversation](SubConversation.md) | The BPMN subConversation element |  no  |
| [GlobalConversation](GlobalConversation.md) | The BPMN globalConversation element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [ConversationNode](ConversationNode.md) |
| Domain Of | [Collaboration](Collaboration.md), [SubConversation](SubConversation.md) |

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
| self | fluxnova_bpm_platform:conversation_nodes |
| native | fluxnova_bpm_platform:conversation_nodes |




## LinkML Source

<details>
```yaml
name: conversation_nodes
description: Conversation nodes in this collaboration.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Collaboration
- SubConversation
range: ConversationNode
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>