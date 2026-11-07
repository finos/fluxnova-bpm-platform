---
type: Service
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/workflows/main
genre: reference
title: Build and test (main.yaml)
description: "The test workflow: on each pull request and push to main it installs from `.linkml/uv.lock`, runs `just test` on Python 3.10 to 3.14, and lints and checks the schema and the adapt copy on 3.13."
resource: .github/workflows/main.yaml
sources:
  - id: main.yaml
    resource: .github/workflows/main.yaml
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: f97506b4c5db4e7ae7b7b55ca00747a16d1a4ed2
status: draft
---

# Build and test (main.yaml)

The workflow runs in `.linkml/`. It lints the schema, checks the modules against FINOS's sources with `just check-schema` and checks the adapt copy, on Python 3.13 only.[^main.yaml]

[^main.yaml]: .github/workflows/main.yaml
