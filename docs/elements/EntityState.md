---
search:
  boost: 2.0
---


# Enum: EntityState 




_General state of an entity (e.g. variable, process instance)._



<div data-search-exclude markdown="1">

URI: [fluxnova_bpm_platform:EntityState](https://w3id.org/TD-Universe/fluxnova-bpm-platform/EntityState)

## Permissible Values
| Value | Meaning | Description |
| --- | --- | --- |
| ACTIVE | None | Active |
| SUSPENDED | None | Suspended |
| COMPLETED | None | Completed |
| EXTERNALLY_TERMINATED | None | Terminated externally |
| INTERNALLY_TERMINATED | None | Terminated internally |




## Slots

| Name | Description |
| ---  | --- |
| [state](state.md) | Current state of HistoricProcessInstance, following values are recognized dur... |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform






## LinkML Source

<details>
```yaml
name: EntityState
description: General state of an entity (e.g. variable, process instance).
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
permissible_values:
  ACTIVE:
    text: ACTIVE
    description: Active.
  SUSPENDED:
    text: SUSPENDED
    description: Suspended.
  COMPLETED:
    text: COMPLETED
    description: Completed.
  EXTERNALLY_TERMINATED:
    text: EXTERNALLY_TERMINATED
    description: Terminated externally.
  INTERNALLY_TERMINATED:
    text: INTERNALLY_TERMINATED
    description: Terminated internally.

```
</details>

</div>