---
search:
  boost: 2.0
---


# Enum: JobState 




_State of a historic job log entry._



<div data-search-exclude markdown="1">

URI: [fluxnova_bpm_platform:JobState](https://w3id.org/TD-Universe/fluxnova-bpm-platform/JobState)

## Permissible Values
| Value | Meaning | Description |
| --- | --- | --- |
| CREATED | None | The job was created |
| FAILED | None | The job execution failed |
| SUCCESSFUL | None | The job executed successfully |
| DELETED | None | The job was deleted |




## Slots

| Name | Description |
| ---  | --- |
| [job_state](job_state.md) | The job state |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform






## LinkML Source

<details>
```yaml
name: JobState
description: State of a historic job log entry.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
permissible_values:
  CREATED:
    text: CREATED
    description: The job was created.
  FAILED:
    text: FAILED
    description: The job execution failed.
  SUCCESSFUL:
    text: SUCCESSFUL
    description: The job executed successfully.
  DELETED:
    text: DELETED
    description: The job was deleted.

```
</details>

</div>