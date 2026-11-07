---
type: Playbook
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/playbooks/take-a-new-fluxnova-release
genre: how-to
title: Take a new Fluxnova release or FINOS tree
description: "What to do when the weekly watch reports a new FINOS tag or a moved main: merge FINOS's tree, re-pin it, move the edition, regenerate and re-pin the sources, with a merge commit."
resource: .linkml/CONTRIBUTING.md
about:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/references/finos-fluxnova-bpm-platform
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/finos-tree
sources:
  - id: contributing.md
    resource: .linkml/CONTRIBUTING.md
    title: Taking a new release of Fluxnova or FINOS's tree
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 78dcb8aa6e900eca363d48f1f6aa1088ea75a360
status: draft
---

# Take a new Fluxnova release or FINOS tree

1. Merge `upstream/main`, or the release's commit.[^contributing.md]
2. Run `just pin-finos-tree <commit>` and update `scripts/edition.py`.[^contributing.md]
3. Run `just gen-schema` and `just pin-sources`, then regenerate.[^contributing.md]
4. Merge with a merge commit, since a squash loses FINOS's history.[^contributing.md]

[^contributing.md]: .linkml/CONTRIBUTING.md, Taking a new release of Fluxnova or FINOS's tree
