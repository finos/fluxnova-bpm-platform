---
search:
  boost: 5.0
---

# Slot: description 


_Human-readable description._



<div data-search-exclude markdown="1">



URI: [schema:description](http://schema.org/description)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Task](Task.md) | Represents one task for a human user |  no  |
| [Attachment](Attachment.md) | Any type of content that is be associated with a task or with a process insta... |  no  |
| [HistoricTaskInstance](HistoricTaskInstance.md) | Represents a historic task instance (waiting, finished or deleted) that is st... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Task](Task.md), [Attachment](Attachment.md), [HistoricTaskInstance](HistoricTaskInstance.md) |
| Slot URI | [schema:description](http://schema.org/description) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | schema:description |
| native | fluxnova_bpm_platform:description |




## LinkML Source

<details>
```yaml
name: description
description: Human-readable description.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
slot_uri: schema:description
domain_of:
- Task
- Attachment
- HistoricTaskInstance
range: string

```
</details></div>