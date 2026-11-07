---
type: Dataset
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/generated-artefacts
genre: reference
title: Generated artefacts
description: "What the LinkML generators write from the schema and nobody edits: `.linkml/project/` (JSON Schema, OWL, SHACL, SQL and more), the Python datamodel and `docs/schema/`."
resource: .linkml/project
derivedFrom:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/fluxnova-linkml-schema
sources:
  - id: contributing.md
    resource: .linkml/CONTRIBUTING.md
    title: What this project is
  - id: generators.yaml
    resource: .linkml/generators.yaml
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 3591d4c38d24bac31506e9690250d87977df291a
status: draft
---

# Generated artefacts

`just gen-project` writes `.linkml/project/` and the Python datamodel from the schema, and the files are never edited by hand.[^contributing.md] The JSON Schema admits each subclass where a range is an abstract BPMN class.[^generators.yaml]

[^contributing.md]: .linkml/CONTRIBUTING.md, What this project is
[^generators.yaml]: .linkml/generators.yaml
