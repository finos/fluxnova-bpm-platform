---
search:
  boost: 2.0
---


# Enum: DelegationState 




_Delegation states of a task._



<div data-search-exclude markdown="1">

URI: [fluxnova_bpm_platform:DelegationState](https://w3id.org/TD-Universe/fluxnova-bpm-platform/DelegationState)

## Permissible Values
| Value | Meaning | Description |
| --- | --- | --- |
| PENDING | None | The task has been delegated and is awaiting resolution |
| RESOLVED | None | The delegated task has been resolved by the assignee |




## Slots

| Name | Description |
| ---  | --- |
| [delegation_state](delegation_state.md) | The current DelegationState for this task |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform






## LinkML Source

<details>
```yaml
name: DelegationState
description: Delegation states of a task.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
permissible_values:
  PENDING:
    text: PENDING
    description: The task has been delegated and is awaiting resolution.
  RESOLVED:
    text: RESOLVED
    description: The delegated task has been resolved by the assignee.

```
</details>

</div>