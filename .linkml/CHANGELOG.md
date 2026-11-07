# Changelog

All notable changes to this project are documented here. The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/), and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

The `v0.0.0` tag is a baseline, not a release: it marks where versioning starts so the first real release is `0.1.0` rather than `1.0.0`. The schema stays below 1.0.0 until its shape settles, so a breaking change is a minor release.

## [Unreleased]

### Added

- **A schema of Fluxnova 3.1.1.** It has one class per table of the engine's database, from its H2 DDL, with foreign keys as references, unique constraints as unique keys, the columns' defaults, the engine's state values as enums and its integer state codes as bounds. It also has the BPMN 2.0 elements the model API reads, with Fluxnova's extension elements, their XML names and an exact mapping to each element.
- **Two converters that write every module from FINOS's tree**, `scripts/fluxnova_to_linkml.py` and `scripts/bpmn_to_linkml.py`, and tests that check each table, column, key, default, state code and registered element against the sources, and 176 of FINOS's BPMN files against the schema.
- **A weekly watch** of FINOS's tags and main, against the files the converters read at `v3.1.1` and a list of every file of FINOS's merged commit.
- **`.lokf/schema/fluxnova_bpm_platform.yaml`, the schema's `lokf adapt` copy.** The knowledge release attaches it as `schema-<tag>-fluxnova-bpm-platform.yaml`.
- **The repository's Knowledge Trust Ladder (KTL) knowledge bundle and its sidecar automation**, from the KTL v0.62.0 templates with the lokf floor at 0.9.0, and a knowledge website that replaces the mkdocs site.
- **The governance files**: SECURITY.md, AI_COVENANT.md, NOTICE and the CONTRIBUTING checklist.

### Changed

- **The LinkML project is now in `.linkml/`**, beside FINOS's tree, which is FINOS's main at 6a0bf7f (2026-11-03), unchanged.

### Removed

- **The provenance overlay** under `schema/provenance/`, which modelled workflow and AI provenance that Fluxnova does not state, and its tests.
- **The sixteen SSSOM sets and the overlay that wrote them into the schema.** Fifteen mapped other lmodel schemas to each other, and the sixteenth the provenance overlay; none stated a mapping of Fluxnova's.
- **The MyBatis cross-check**, which counted no discrepancies by construction.
