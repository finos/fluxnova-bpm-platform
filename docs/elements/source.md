---
search:
  boost: 5.0
---

# Slot: source 


_The source._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:source](https://w3id.org/TD-Universe/fluxnova-bpm-platform/source)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [CaseSentryPart](CaseSentryPart.md) | Case Sentry Part entity in the process execution runtime |  no  |
| [Deployment](Deployment.md) | Represents a deployment that is already present in the process repository |  no  |
| [Association](Association.md) | The BPMN association element |  yes  |
| [ConversationLink](ConversationLink.md) | The BPMN conversationLink element |  yes  |
| [MessageFlow](MessageFlow.md) | The BPMN messageFlow element |  yes  |
| [SequenceFlow](SequenceFlow.md) | The BPMN sequenceFlow element |  yes  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [CaseSentryPart](CaseSentryPart.md), [Deployment](Deployment.md), [Association](Association.md), [ConversationLink](ConversationLink.md), [MessageFlow](MessageFlow.md), [SequenceFlow](SequenceFlow.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | SOURCE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:source |
| native | fluxnova_bpm_platform:source |




## LinkML Source

<details>
```yaml
name: source
annotations:
  sql_column:
    tag: sql_column
    value: SOURCE_
description: The source.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- CaseSentryPart
- Deployment
- Association
- ConversationLink
- MessageFlow
- SequenceFlow
range: string

```
</details></div>