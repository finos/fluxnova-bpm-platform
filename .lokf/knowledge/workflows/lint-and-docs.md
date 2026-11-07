---
type: Service
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/workflows/lint-and-docs
genre: reference
title: Lint and docs (lint-and-docs.yaml)
description: "Static checks of the shell scripts, workflows and prose this project adds beside FINOS's tree: ShellCheck, actionlint, markdownlint, lychee and codespell, never over FINOS's files."
resource: .github/workflows/lint-and-docs.yaml
sources:
  - id: lint-and-docs.yaml
    resource: .github/workflows/lint-and-docs.yaml
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: f97506b4c5db4e7ae7b7b55ca00747a16d1a4ed2
status: draft
---

# Lint and docs (lint-and-docs.yaml)

The workflow checks only what this project adds, and leaves FINOS's files as FINOS writes them. It also runs on Mondays at 06:00 UTC to find links that no longer work.[^lint-and-docs.yaml]

[^lint-and-docs.yaml]: .github/workflows/lint-and-docs.yaml
