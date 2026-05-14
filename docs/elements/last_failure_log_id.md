---
search:
  boost: 5.0
---

# Slot: last_failure_log_id 


_Reference to the last failure log._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:last_failure_log_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/last_failure_log_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [ExternalTask](ExternalTask.md) | Represents an instance of an external task that is created when a service-tas... |  no  |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [ExternalTask](ExternalTask.md), [Job](Job.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | LAST_FAILURE_LOG_ID_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:last_failure_log_id |
| native | fluxnova_bpm_platform:last_failure_log_id |




## LinkML Source

<details>
```yaml
name: last_failure_log_id
annotations:
  sql_column:
    tag: sql_column
    value: LAST_FAILURE_LOG_ID_
description: Reference to the last failure log.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- ExternalTask
- Job
range: string

```
</details></div>