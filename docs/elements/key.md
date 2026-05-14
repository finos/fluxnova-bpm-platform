---
search:
  boost: 5.0
---

# Slot: key 


_Business key for the definition._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:key](https://w3id.org/TD-Universe/fluxnova-bpm-platform/key)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [IdentityInfo](IdentityInfo.md) | Identity Info entity in the identity and access management |  no  |
| [ResourceDefinition](ResourceDefinition.md) | Abstract base for deployable resource definitions (process, case, decision, f... |  no  |
| [CaseDefinition](CaseDefinition.md) | A deployed case definition in the process repository |  yes  |
| [DecisionDefinition](DecisionDefinition.md) | Definition of a decision resource |  yes  |
| [DecisionRequirementsDefinition](DecisionRequirementsDefinition.md) | Container of DecisionDefinitions which belongs to the same decision requireme... |  yes  |
| [FormDefinition](FormDefinition.md) | An object structure representing a Camunda Form used to present forms to user... |  yes  |
| [ProcessDefinition](ProcessDefinition.md) | An object structure representing an executable process composed of activities... |  yes  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [IdentityInfo](IdentityInfo.md), [ResourceDefinition](ResourceDefinition.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:key |
| native | fluxnova_bpm_platform:key |




## LinkML Source

<details>
```yaml
name: key
description: Business key for the definition.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- IdentityInfo
- ResourceDefinition
range: string

```
</details></div>