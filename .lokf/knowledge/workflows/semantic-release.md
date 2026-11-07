---
type: Service
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/workflows/semantic-release
genre: reference
title: Semantic release (semantic-release.yml)
description: "The release workflow: on a push to main it computes the next version from conventional commits, promotes the changelog's Unreleased section, tags and publishes the release, and dispatches the knowledge release."
resource: .github/workflows/semantic-release.yml
sources:
  - id: semantic-release.yml
    resource: .github/workflows/semantic-release.yml
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 50be04479a0cca2c092d6a1e4c0e7752dabe3ce8
status: draft
---

# Semantic release (semantic-release.yml)

The workflow retitles `.linkml/CHANGELOG.md`'s Unreleased section, tags the commit and publishes the release. Once `KNOWLEDGE_RELEASE_ENABLED` is `true`, it dispatches the knowledge release.[^semantic-release.yml]

[^semantic-release.yml]: .github/workflows/semantic-release.yml
