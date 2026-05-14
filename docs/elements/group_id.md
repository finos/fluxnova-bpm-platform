---
search:
  boost: 5.0
---

# Slot: group_id 


_Reference to a group._



<div data-search-exclude markdown="1">



URI: [fluxnova_bpm_platform:group_id](https://w3id.org/TD-Universe/fluxnova-bpm-platform/group_id)
<!-- no inheritance hierarchy -->





## Applicable Classes

| Name | Description | Modifies Slot |
| --- | --- | --- |
| [Authorization](Authorization.md) | An Authorization assigns a set of Permission Permissions to an identity to in... |  no  |
| [IdentityLink](IdentityLink.md) | An identity link is used to associate a task with a certain identity |  no  |
| [Membership](Membership.md) | Association entity in identity and access management |  yes  |
| [TenantMembership](TenantMembership.md) | Association entity in identity and access management |  no  |
| [HistoricIdentityLink](HistoricIdentityLink.md) | An historic identity link stores the association of a task with a certain ide... |  no  |






## Properties

### Type and Range

| Property | Value |
| --- | --- |
| Range | [String](String.md) |
| Domain Of | [Authorization](Authorization.md), [IdentityLink](IdentityLink.md), [Membership](Membership.md), [TenantMembership](TenantMembership.md), [HistoricIdentityLink](HistoricIdentityLink.md) |

### Cardinality and Requirements

| Property | Value |
| --- | --- |










## Identifier and Mapping Information





### Schema Source


* from schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform




## Mappings

| Mapping Type | Mapped Value |
| ---  | ---  |
| self | fluxnova_bpm_platform:group_id |
| native | fluxnova_bpm_platform:group_id |




## LinkML Source

<details>
```yaml
name: group_id
description: Reference to a group.
from_schema: https://w3id.org/TD-Universe/fluxnova-bpm-platform
rank: 1000
domain_of:
- Authorization
- IdentityLink
- Membership
- TenantMembership
- HistoricIdentityLink
range: string

```
</details></div>