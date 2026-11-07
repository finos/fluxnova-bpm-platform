---
type: Dataset
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/bpmn-modules
genre: reference
title: BPMN modules
description: "The modules `fluxnova_bpmn_core`, `_dc`, `_di`, `_bpmndi`, `_semantic` and `_extension`: one class per element type Fluxnova's BPMN model API registers, with attributes, child elements, references and text."
resource: .linkml/src/fluxnova_bpm_platform/schema/fluxnova_bpmn_semantic.yaml
isPartOf:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/fluxnova-linkml-schema
derivedFrom:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/references/bpmn-2
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/references/finos-fluxnova-bpm-platform
sources:
  - id: about.md
    resource: .linkml/docs/about.md
    title: The BPMN elements
  - id: bpmn_to_linkml.py
    resource: .linkml/scripts/bpmn_to_linkml.py
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 3591d4c38d24bac31506e9690250d87977df291a
status: draft
---

# BPMN modules

Each element type the model API registers is a class, with its parent, its attributes and its child elements as the API states them.[^about.md] A reference to another element is a string whose `refers_to` annotation names the class it points to, since BPMN lets an element have no id.[^about.md] A process's flow elements range over `BpmnFlowElement`, and `element_type` names each child's class.[^about.md] The descriptions are this project's own, in `scripts/bpmn_descriptions.yaml`.[^about.md] `scripts/bpmn_to_linkml.py` writes the modules.[^bpmn_to_linkml.py]

[^about.md]: .linkml/docs/about.md, The BPMN elements
[^bpmn_to_linkml.py]: .linkml/scripts/bpmn_to_linkml.py
