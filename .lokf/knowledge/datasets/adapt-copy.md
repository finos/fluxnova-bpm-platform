---
type: Dataset
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/adapt-copy
genre: reference
title: The schema's adapt copy
description: "`.lokf/schema/fluxnova_bpm_platform.yaml`, the copy `lokf adapt` writes from the schema for the bundle: which classes it roots on Concept, which names it renames, and how a release attaches it."
resource: .lokf/schema/fluxnova_bpm_platform.yaml
derivedFrom:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/fluxnova-linkml-schema
sources:
  - id: linkml-readme.md
    resource: .linkml/README.md
    title: Knowledge Trust Ladder (KTL)
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 3591d4c38d24bac31506e9690250d87977df291a
status: draft
---

# The schema's adapt copy

`just lokf-adapt` writes `.lokf/schema/fluxnova_bpm_platform.yaml` from the schema, and `just lokf-adapt-check` says when it is stale.[^linkml-readme.md] In the copy, every class that carries the schema's identifier, `id`, descends from LOKF's `Concept`. The BPMN classes carry no identifier.[^linkml-readme.md] A release carries the copy as `schema-<tag>-fluxnova-bpm-platform.yaml`.[^linkml-readme.md]

[^linkml-readme.md]: .linkml/README.md, Knowledge Trust Ladder (KTL)
