---
type: Dataset
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/engine-tables
genre: reference
title: Engine tables module
description: "The module `fluxnova_bpm_engine`: one class per table of Fluxnova's process engine, with columns as slots, foreign keys as references, state enums and coded state bounds, grouped by area subsets."
resource: .linkml/src/fluxnova_bpm_platform/schema/fluxnova_bpm_engine.yaml
isPartOf:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/fluxnova-linkml-schema
derivedFrom:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/references/finos-fluxnova-bpm-platform
sources:
  - id: about.md
    resource: .linkml/docs/about.md
    title: The engine's tables
  - id: fluxnova_to_linkml.py
    resource: .linkml/scripts/fluxnova_to_linkml.py
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 44e97f2125e7dc2b3e9345c5b9f610ad5eca5162
status: draft
---

# Engine tables module

Each table the engine's H2 DDL creates is a class, such as `FluxnovaExecution` for `ACT_RU_EXECUTION`.[^about.md] A column is a slot, required when it is not null, and a table's one-column key `ID_` is the class's identifier.[^about.md] A foreign key ranges over the class of the table it refers to.[^about.md] A column of the engine's text values takes an enum. A column of its integer state codes stays an integer, bounded by the codes.[^about.md] The subsets `engine_repository`, `engine_runtime`, `engine_history` and the rest group the tables.[^about.md] `scripts/fluxnova_to_linkml.py` writes the module.[^fluxnova_to_linkml.py]

[^about.md]: .linkml/docs/about.md, The engine's tables
[^fluxnova_to_linkml.py]: .linkml/scripts/fluxnova_to_linkml.py
