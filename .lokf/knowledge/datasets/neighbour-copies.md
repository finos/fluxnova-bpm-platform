---
type: Dataset
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/neighbour-copies
genre: reference
title: Neighbour adapt copies
description: The released adapt copies of other lmodel schemas under `.linkml/tests/neighbours/`, pinned by checksum, which the tests use to keep this copy's names apart from a neighbour's and from LOKF's.
resource: .linkml/tests/neighbours
about:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/adapt-copy
sources:
  - id: test_schema_rules.py
    resource: .linkml/tests/test_schema_rules.py
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: b8347cdbefcd460b75d52864d31d6ef5c38484a5
status: draft
---

# Neighbour adapt copies

Each file under `tests/neighbours/` is the schema asset of another lmodel release, pinned by its checksum.[^test_schema_rules.py] The tests check that no class, enum, type or subset name of this copy is a neighbour's or LOKF's, and list the keys it shares with each neighbour.[^test_schema_rules.py]

[^test_schema_rules.py]: .linkml/tests/test_schema_rules.py
