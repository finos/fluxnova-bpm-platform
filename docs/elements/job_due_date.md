---
search:
  boost: 5.0
---

# Slot: job_due_date 


_Due date of the associated job when this log occurred._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:job_due_date](https://w3id.org/TD-Universe/fluxnova-bpm-platform/job_due_date)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [HistoricJobLog](HistoricJobLog.md) | The HistoricJobLog is used to have a log containing information about Job job... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [Datetime](Datetime.md) |
| Domain Of | [HistoricJobLog](HistoricJobLog.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information



### Annotations

| property | value |
| --- | --- |
| sql_column | JOB_DUEDATE_ |




### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:job_due_date |
| native | fluxnova_bpm_platform:job_due_date |




## LinkML Source

<details>
```yaml
name: job_due_date
annotations:
  sql_column:
    tag: sql_column
    value: JOB_DUEDATE_
description: Due date of the associated job when this log occurred.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- HistoricJobLog
range: datetime

```
</details></div>