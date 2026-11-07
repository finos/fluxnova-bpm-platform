---
type: Service
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/workflows/upstream-watch
genre: reference
title: Upstream watch (upstream-watch.yaml)
description: The weekly check of FINOS's tags, the files the converters read and FINOS's main branch, which opens or updates an issue when a check fails.
resource: .github/workflows/upstream-watch.yaml
sources:
  - id: upstream-watch.yaml
    resource: .github/workflows/upstream-watch.yaml
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: f97506b4c5db4e7ae7b7b55ca00747a16d1a4ed2
status: draft
---

# Upstream watch (upstream-watch.yaml)

The workflow runs on Mondays at 07:00 UTC and runs `scripts/check_upstream_release.py`. A failing check fails the run and opens an issue, or comments on the one already open.[^upstream-watch.yaml]

[^upstream-watch.yaml]: .github/workflows/upstream-watch.yaml
