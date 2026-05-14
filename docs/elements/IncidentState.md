---
search:
  boost: 2.0
---


# Enum: IncidentState 




_State of a historic incident._



<div data-search-exclude markdown="1">

URI: [fluxnova_bpm_platform:IncidentState](https://w3id.org/TD-Universe/fluxnova-bpm-platform/IncidentState)

## Permissible Values
| Value | Meaning | Description |
| --- | --- | --- |
| OPEN | None | The incident is open |
| DELETED | None | The incident has been deleted |
| RESOLVED | None | The incident has been resolved |




## Slots

| Name | Description |
| ---  | --- |
| [incident_state](incident_state.md) | The incident state |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform






## LinkML Source

<details>
```yaml
name: IncidentState
description: State of a historic incident.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
permissible_values:
  OPEN:
    text: OPEN
    description: The incident is open.
  DELETED:
    text: DELETED
    description: The incident has been deleted.
  RESOLVED:
    text: RESOLVED
    description: The incident has been resolved.

```
</details>

</div>