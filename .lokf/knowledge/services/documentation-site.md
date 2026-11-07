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
  at: "2026-11-07T04:06:15Z"
  revision: 642e6a61c3ef4ba02a97592475f5c851a41fff91
status: draft
---

# Documentation site

The site is served at `https://lmodel.github.io/fluxnova-bpm-platform`.[^site.config.mjs] Its home page is `.linkml/README.md` and its docs pages come from `.linkml/docs`. It shows no changelog until `.linkml/CHANGELOG.md` holds a release.[^site.config.mjs] The site leaves out FINOS's own `docs/`.[^site.config.mjs]

[^site.config.mjs]: website/site.config.mjs
