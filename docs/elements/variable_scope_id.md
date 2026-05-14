---
search:
  boost: 5.0
---

# Slot: variable_scope_id 


_Reference to the variable scope._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:variable_scope_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/variable_scope_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [VariableInstance](VariableInstance.md) | A VariableInstance represents a variable in the execution of a process instan... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [VariableInstance](VariableInstance.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |
| Required | Yes |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | VAR_SCOPE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:variable_scope_id |
| native | fluxnova_bpm_platform:variable_scope_id |




## LinkML Source

<details>
```yaml
name: variable_scope_id
annotations:
  sql_column:
    tag: sql_column
    value: VAR_SCOPE_
description: Reference to the variable scope.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- VariableInstance
range: string
required: true

```
</details></div>