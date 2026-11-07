---
type: Explanation
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/explanations/modelling-choices
genre: explanation
title: Modelling choices
description: "How the schema renders its sources: integer state codes as bounded integers, foreign keys as references, BPMN references as strings, polymorphic children by element_type, and the prefixes on names."
resource: .linkml/docs/about.md
about:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/engine-tables
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/bpmn-modules
sources:
  - id: about.md
    resource: .linkml/docs/about.md
  - id: linkml-readme.md
    resource: .linkml/README.md
    title: Knowledge Trust Ladder (KTL)
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 3591d4c38d24bac31506e9690250d87977df291a
status: draft
---

# Modelling choices

A column that holds the engine's integer codes, such as `SUSPENSION_STATE_`, stays an integer bounded by the codes, and a comment names each code.[^about.md] A BPMN reference is a string, since BPMN lets an element have no id.[^about.md] An attribute in Fluxnova's extension namespace carries the `fluxnova_` prefix, and a BPMN slot whose name LOKF defines, such as `id`, the `bpmn_` prefix.[^about.md] Every class carries the `Fluxnova`, `Bpmn`, `Di` or `Dc` prefix, so none is a neighbour's.[^linkml-readme.md]

[^about.md]: .linkml/docs/about.md
[^linkml-readme.md]: .linkml/README.md, Knowledge Trust Ladder (KTL)
