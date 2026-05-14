---
search:
  boost: 5.0
---

# Slot: message 


_Short message or summary._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:message](https://w3id.org/TD-Universe/fluxnova-bpm-platform/message)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Comment](Comment.md) | User comments that form discussions around tasks |  no  |
| [CorrelationPropertyRetrievalExpression](CorrelationPropertyRetrievalExpression.md) | The BPMN correlationPropertyRetrievalExpression element |  yes  |
| [MessageEventDefinition](MessageEventDefinition.md) | The BPMN messageEventDefinition element |  yes  |
| [MessageFlow](MessageFlow.md) | The BPMN messageFlow element |  yes  |
| [ReceiveTask](ReceiveTask.md) | The BPMN receiveTask element |  yes  |
| [SendTask](SendTask.md) | The BPMN sendTask element |  yes  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Comment](Comment.md), [CorrelationPropertyRetrievalExpression](CorrelationPropertyRetrievalExpression.md), [MessageEventDefinition](MessageEventDefinition.md), [MessageFlow](MessageFlow.md), [ReceiveTask](ReceiveTask.md), [SendTask](SendTask.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | MESSAGE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:message |
| native | fluxnova_bpm_platform:message |




## LinkML Source

<details>
```yaml
name: message
annotations:
  sql_column:
    tag: sql_column
    value: MESSAGE_
description: Short message or summary.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Comment
- CorrelationPropertyRetrievalExpression
- MessageEventDefinition
- MessageFlow
- ReceiveTask
- SendTask
range: string

```
</details></div>