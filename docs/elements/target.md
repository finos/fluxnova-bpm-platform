---
search:
  boost: 5.0
---

# Slot: target 


_The catching link event that receives this link._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:target](https://w3id.org/TD-Universe/fluxnova-bpm-platform/target)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Association](Association.md) | The BPMN association element |  no  |
| [ConversationLink](ConversationLink.md) | The BPMN conversationLink element |  yes  |
| [DataAssociation](DataAssociation.md) | The BPMN dataAssociation element |  yes  |
| [LinkEventDefinition](LinkEventDefinition.md) | The BPMN linkEventDefinition element |  yes  |
| [MessageFlow](MessageFlow.md) | The BPMN messageFlow element |  yes  |
| [SequenceFlow](SequenceFlow.md) | The BPMN sequenceFlow element |  yes  |
| [DataInputAssociation](DataInputAssociation.md) | The BPMN dataInputAssociation element |  no  |
| [DataOutputAssociation](DataOutputAssociation.md) | The BPMN dataOutputAssociation element |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [BaseElement](BaseElement.md) |
| Domain Of | [Association](Association.md), [ConversationLink](ConversationLink.md), [DataAssociation](DataAssociation.md), [LinkEventDefinition](LinkEventDefinition.md), [MessageFlow](MessageFlow.md), [SequenceFlow](SequenceFlow.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:target |
| native | fluxnova_bpm_platform:target |




## LinkML Source

<details>
```yaml
name: target
description: The catching link event that receives this link.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Association
- ConversationLink
- DataAssociation
- LinkEventDefinition
- MessageFlow
- SequenceFlow
range: BaseElement

```
</details></div>