---
type: Reference
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/references/bpmn-2
genre: reference
title: BPMN 2.0 (OMG)
description: BPMN 2.0, the Object Management Group's process notation, whose elements Fluxnova's BPMN model API reads and the BPMN modules render, mapped by the XML namespace and the element's name.
resource: .linkml/scripts/bpmn_to_linkml.py
sources:
  - id: notice
    resource: .linkml/NOTICE
    title: BPMN
  - id: bpmn_to_linkml.py
    resource: .linkml/scripts/bpmn_to_linkml.py
    title: NAMESPACES
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 3591d4c38d24bac31506e9690250d87977df291a
status: draft
---

# BPMN 2.0 (OMG)

BPMN 2.0 is a specification of the Object Management Group (OMG).[^notice] The schema names its elements by the XML names and namespaces that Fluxnova's model API registers, and maps each to that name.[^notice] The converter binds the prefix `bpmn` to `http://www.omg.org/spec/BPMN/20100524/MODEL#`, and `bpmndi`, `omgdi` and `omgdc` to the diagram namespaces.[^bpmn_to_linkml.py] No text of the specification is copied into the repository.[^notice]

[^notice]: .linkml/NOTICE, BPMN
[^bpmn_to_linkml.py]: .linkml/scripts/bpmn_to_linkml.py, NAMESPACES
