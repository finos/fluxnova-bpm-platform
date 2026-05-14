---
search:
  boost: 5.0
---

# Slot: category 


_Category classification._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:category](https://w3id.org/TD-Universe/fluxnova-bpm-platform/category)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ResourceDefinition](ResourceDefinition.md) | Abstract base for deployable resource definitions (process, case, decision, f... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |
| [BpmnGroup](BpmnGroup.md) | An artifact that visually groups flow elements without affecting the process ... |  yes  |
| [CaseDefinition](CaseDefinition.md) | A deployed case definition in the process repository |  no  |
| [DecisionDefinition](DecisionDefinition.md) | Definition of a decision resource |  no  |
| [DecisionRequirementsDefinition](DecisionRequirementsDefinition.md) | Container of DecisionDefinitions which belongs to the same decision requireme... |  no  |
| [FormDefinition](FormDefinition.md) | An object structure representing a Camunda Form used to present forms to user... |  no  |
| [ProcessDefinition](ProcessDefinition.md) | An object structure representing an executable process composed of activities... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [ResourceDefinition](ResourceDefinition.md), [UserOperationLogEntry](UserOperationLogEntry.md), [BpmnGroup](BpmnGroup.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:category |
| native | fluxnova_bpm_platform:category |




## LinkML Source

<details>
```yaml
name: category
description: Category classification.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ResourceDefinition
- UserOperationLogEntry
- BpmnGroup
range: string

```
</details></div>