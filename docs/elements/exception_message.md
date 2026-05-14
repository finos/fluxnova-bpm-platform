---
search:
  boost: 5.0
---

# Slot: exception_message 


_Message of the exception that occurred, the last time the job was executed. Returns null when no exception occurred. To get the full exception stacktrace, use_



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:exception_message](https://w3id.org/TD-Universe/fluxnova-bpm-platform/exception_message)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Job](Job.md) | Represents one job (timer, message, etc |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Job](Job.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | EXCEPTION_MSG_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:exception_message |
| native | fluxnova_bpm_platform:exception_message |




## LinkML Source

<details>
```yaml
name: exception_message
annotations:
  sql_column:
    tag: sql_column
    value: EXCEPTION_MSG_
description: Message of the exception that occurred, the last time the job was executed.
  Returns null when no exception occurred. To get the full exception stacktrace, use
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Job
range: string

```
</details></div>