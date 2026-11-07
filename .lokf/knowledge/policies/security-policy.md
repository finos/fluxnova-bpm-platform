---
type: Policy
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/policies/security-policy
genre: reference
title: Security policy
description: How to report a vulnerability privately, what this repository releases and runs, what holds each workflow, and what is out of scope, such as Fluxnova itself.
resource: .github/SECURITY.md
sources:
  - id: security.md
    resource: .github/SECURITY.md
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 78dcb8aa6e900eca363d48f1f6aa1088ea75a360
status: draft
---

# Security policy

Report a vulnerability through GitHub's private vulnerability reporting, not a public issue.[^security.md] Only the latest release receives fixes.[^security.md] The converters read FINOS's Java, SQL and XML Schema files as text, run none of them and use no network.[^security.md] A problem in Fluxnova itself goes to FINOS.[^security.md]

[^security.md]: .github/SECURITY.md
