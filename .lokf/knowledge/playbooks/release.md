---
type: Playbook
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/playbooks/release
genre: how-to
title: Release the schema
description: "How a release is cut: the changelog's Unreleased section, conventional commit types, semantic-release from the v0.0.0 baseline, the release Environment, and the assets the knowledge release attaches."
resource: .releaserc.json
about:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/adapt-copy
sources:
  - id: contributing.md
    resource: .linkml/CONTRIBUTING.md
    title: Releasing (maintainers)
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 50be04479a0cca2c092d6a1e4c0e7752dabe3ce8
status: draft
---

# Release the schema

- Write `## [Unreleased]` in `.linkml/CHANGELOG.md` as you go, since the release job refuses an empty one.[^contributing.md]
- Only `feat:`, `fix:`, `security:` and a breaking `!` start a release, and FINOS's commits in a merge count too.[^contributing.md]
- The `v0.0.0` baseline tag is on the merge of FINOS's tree, and `.releaserc.json` maps a breaking change to a minor release.[^contributing.md]
- Once `KNOWLEDGE_RELEASE_ENABLED` is `true`, the knowledge release attaches the schema copy and the bundle when either changed.[^contributing.md]

[^contributing.md]: .linkml/CONTRIBUTING.md, Releasing (maintainers)
