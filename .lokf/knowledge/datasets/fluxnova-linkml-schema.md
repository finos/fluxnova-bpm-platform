---
type: Dataset
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/fluxnova-linkml-schema
genre: reference
title: Fluxnova LinkML schema
description: "The LinkML schema of Fluxnova 3.1.1: the umbrella `fluxnova_bpm_platform.yaml`, the engine tables module and the BPMN modules, which two converters write from FINOS's tree."
resource: .linkml/src/fluxnova_bpm_platform/schema/fluxnova_bpm_platform.yaml
derivedFrom:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/references/finos-fluxnova-bpm-platform
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/references/bpmn-2
hasPart:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/engine-tables
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/bpmn-modules
sources:
  - id: about.md
    resource: .linkml/docs/about.md
    title: The modules
  - id: linkml-readme.md
    resource: .linkml/README.md
    title: What it models
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 44e97f2125e7dc2b3e9345c5b9f610ad5eca5162
status: draft
---

# Fluxnova LinkML schema

The umbrella `fluxnova_bpm_platform.yaml` imports the engine tables module and the BPMN modules, and its root class is `FluxnovaPlatformData`.[^about.md] Two converters write every module from FINOS's tree: `scripts/fluxnova_to_linkml.py` from the engine's H2 DDL and its Java API's Javadoc, and `scripts/bpmn_to_linkml.py` from the model API's `registerType` methods.[^linkml-readme.md] Every module carries version 3.1.1 and a source at the release's commit.[^about.md]

[^about.md]: .linkml/docs/about.md, The modules
[^linkml-readme.md]: .linkml/README.md, What it models
