---
search:
  boost: 5.0
---

# Slot: message_flow_associations 


_Associations between message flows._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:message_flow_associations](https://w3id.org/TD-Universe/fluxnova-bpm-platform/message_flow_associations)
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
| Range | [MessageFlowAssociation](MessageFlowAssociation.md) |
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
| self | fluxnova_bpm_platform:message_flow_associations |
| native | fluxnova_bpm_platform:message_flow_associations |




## LinkML Source

<details>
```yaml
name: message_flow_associations
description: Associations between message flows.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Collaboration
range: MessageFlowAssociation
multivalued: true
inlined: true
inlined_as_list: true

```
</details></div>