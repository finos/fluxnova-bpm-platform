# Change Log

## 2026-11-07

* **Added**: Fluxnova BPM Platform 3.1.1 (FINOS), from `.linkml/scripts/edition.py`.
* **Added**: BPMN 2.0 (OMG), from `.linkml/scripts/bpmn_to_linkml.py`.
* **Added**: Fluxnova LinkML schema, from `.linkml/src/fluxnova_bpm_platform/schema/fluxnova_bpm_platform.yaml`.
* **Added**: Engine tables module, from `.linkml/src/fluxnova_bpm_platform/schema/fluxnova_bpm_engine.yaml`.
* **Added**: BPMN modules, from `.linkml/src/fluxnova_bpm_platform/schema/fluxnova_bpmn_semantic.yaml`.
* **Added**: The schema's adapt copy, from `.lokf/schema/fluxnova_bpm_platform.yaml`.
* **Added**: FINOS's tree and the source pins, from `.linkml/tests/upstream_tree.tsv`.
* **Added**: Example data, from `.linkml/tests/data`.
* **Added**: Neighbour adapt copies, from `.linkml/tests/neighbours`.
* **Added**: Generated artefacts, from `.linkml/project`.
* **Added**: How the fork is laid out, from `.linkml/NOTICE`.
* **Added**: Modelling choices, from `.linkml/docs/about.md`.
* **Added**: What the schema leaves out, from `.linkml/docs/about.md`.
* **Added**: Regenerate the schema and run the tests, from `.linkml/project.justfile`.
* **Added**: Take a new Fluxnova release or FINOS tree, from `.linkml/CONTRIBUTING.md`.
* **Added**: Release the schema, from `.releaserc.json`.
* **Added**: Licence and attribution, from `.linkml/NOTICE`.
* **Added**: Security policy, from `.github/SECURITY.md`.
* **Added**: AI covenant, from `.linkml/AI_COVENANT.md`.
* **Added**: Documentation site, from `website/site.config.mjs`.
* **Added**: Build and test (main.yaml), from `.github/workflows/main.yaml`.
* **Added**: Lint and docs (lint-and-docs.yaml), from `.github/workflows/lint-and-docs.yaml`.
* **Added**: Upstream watch (upstream-watch.yaml), from `.github/workflows/upstream-watch.yaml`.
* **Added**: Semantic release (semantic-release.yml), from `.github/workflows/semantic-release.yml`.
* **Added**: Knowledge sources map, the bundle's scrape map of this project's files and FINOS's paths left out.
* **Removal**: the sidecar's first example service, now that real concepts stand in its place.
* **Removal**: the sidecar's second example service, now that real concepts stand in its place.
* **Initialization**: Scaffolded the LOKF bundle for fluxnova-bpm-platform with placeholder
  services. Real concepts to follow.
