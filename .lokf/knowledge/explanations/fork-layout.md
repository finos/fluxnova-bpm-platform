---
type: Explanation
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/explanations/fork-layout
genre: explanation
title: How the fork is laid out
description: Why this repository keeps FINOS's tree unchanged at its root and puts the schema project in `.linkml/`, the bundle in `.lokf/` and the site in `website/`, and what links it adds.
resource: .linkml/NOTICE
about:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/finos-tree
sources:
  - id: linkml-readme.md
    resource: .linkml/README.md
    title: What it models
  - id: notice
    resource: .linkml/NOTICE
  - id: security.md
    resource: .github/SECURITY.md
    title: What this repository releases
generated:
  by: process:ktl-librarian
  at: "2026-11-07T04:06:15Z"
  revision: 642e6a61c3ef4ba02a97592475f5c851a41fff91
status: draft
---

# How the fork is laid out

FINOS's tree is unchanged at the root, and this project's folders are beside it: `.linkml/`, `.lokf/` and `website/`.[^linkml-readme.md] NOTICE lists every path this project adds, among them the `linkml_schema` and `knowledge_bundle` links and `llms.txt`.[^notice] FINOS's own workflows stay in place, and SECURITY.md asks the maintainer to turn them off in this fork's settings.[^security.md]

[^linkml-readme.md]: .linkml/README.md, What it models
[^notice]: .linkml/NOTICE
[^security.md]: .github/SECURITY.md, What this repository releases
