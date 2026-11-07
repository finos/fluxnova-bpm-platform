---
type: Dataset
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/finos-tree
genre: reference
title: FINOS's tree and the source pins
description: "The two pin lists: every file of FINOS's merged commit by git object hash, and every file the converters read with its hash at the tag `v3.1.1`, which the tests hold the tree to."
resource: .linkml/tests/upstream_tree.tsv
about:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/references/finos-fluxnova-bpm-platform
sources:
  - id: test_upstream.py
    resource: .linkml/tests/test_upstream.py
  - id: project.justfile
    resource: .linkml/project.justfile
    title: Upstream
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: ada6083c86fc7bc98e6cb7f492265e4662801d6b
status: draft
---

# FINOS's tree and the source pins

`tests/upstream_tree.tsv` lists every file of FINOS's merged commit by its git object hash, and a test holds each file here to it.[^test_upstream.py] `scripts/upstream_pins.tsv` lists every file the converters read, with its hash at the tag `v3.1.1`, and a test checks that the converters read no other file.[^test_upstream.py] `just pin-finos-tree <commit>` and `just pin-sources` rewrite the two lists.[^project.justfile]

[^test_upstream.py]: .linkml/tests/test_upstream.py
[^project.justfile]: .linkml/project.justfile, Upstream
