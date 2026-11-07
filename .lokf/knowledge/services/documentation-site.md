---
type: Service
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/services/documentation-site
genre: reference
title: Documentation site
description: The knowledge website at https://lmodel.github.io/fluxnova-bpm-platform, built from the bundle, the sidecar README, the docs pages, the changelog and the schema's pages.
resource: website/site.config.mjs
sources:
  - id: site.config.mjs
    resource: website/site.config.mjs
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 11043a8937af140aeb6fb5c9830870addbaa0eab
status: draft
---

# Documentation site

The site is served at `https://lmodel.github.io/fluxnova-bpm-platform`.[^site.config.mjs] Its home page is `.linkml/README.md`, its docs pages come from `.linkml/docs`, and its changelog from `.linkml/CHANGELOG.md`.[^site.config.mjs] The site leaves out FINOS's own `docs/`.[^site.config.mjs]

[^site.config.mjs]: website/site.config.mjs
