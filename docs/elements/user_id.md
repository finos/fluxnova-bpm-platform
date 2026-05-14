---
search:
  boost: 5.0
---

# Slot: user_id 


_Reference to a user._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:user_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/user_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Authorization](Authorization.md) | An Authorization assigns a set of Permission Permissions to an identity to in... |  no  |
| [IdentityInfo](IdentityInfo.md) | Identity Info entity in the identity and access management |  no  |
| [IdentityLink](IdentityLink.md) | An identity link is used to associate a task with a certain identity |  no  |
| [Membership](Membership.md) | Association entity in identity and access management |  yes  |
| [TenantMembership](TenantMembership.md) | Association entity in identity and access management |  no  |
| [Attachment](Attachment.md) | Any type of content that is be associated with a task or with a process insta... |  no  |
| [Comment](Comment.md) | User comments that form discussions around tasks |  no  |
| [HistoricDecisionInstance](HistoricDecisionInstance.md) | Represents one evaluation of a decision |  no  |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |  no  |
| [UserOperationLogEntry](UserOperationLogEntry.md) | Log entry about an operation performed by a user |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Authorization](Authorization.md), [IdentityInfo](IdentityInfo.md), [IdentityLink](IdentityLink.md), [Membership](Membership.md), [TenantMembership](TenantMembership.md), [Attachment](Attachment.md), [Comment](Comment.md), [HistoricDecisionInstance](HistoricDecisionInstance.md), [HistoricIdentityLink](HistoricIdentityLink.md), [UserOperationLogEntry](UserOperationLogEntry.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:user_id |
| native | fluxnova_bpm_platform:user_id |




## LinkML Source

<details>
```yaml
name: user_id
description: Reference to a user.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Authorization
- IdentityInfo
- IdentityLink
- Membership
- TenantMembership
- Attachment
- Comment
- HistoricDecisionInstance
- HistoricIdentityLink
- UserOperationLogEntry
range: string

```
</details></div>