---
lokf_version: "0.2"
okf_version: "0.2"
base_iri: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/
context: https://w3id.org/lokf/context.jsonld
title: fluxnova-bpm-platform Knowledge Bundle
description: FINOS Fluxnova BPM Platform 3.1.1 (LinkML)
license: https://creativecommons.org/licenses/by/4.0/
publisher:
  type: Person
  id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/person/noel-mcloughlin
  name: Noel McLoughlin
---

# fluxnova-bpm-platform Knowledge Bundle

A [LOKF](https://lokf.nolan-nichols.com) knowledge base for fluxnova-bpm-platform. Every Markdown file under `knowledge/` is one concept; together they form a queryable knowledge graph, derived from this repository's code and docs.

# Services

* [Documentation site](services/documentation-site.md) - The knowledge website at https://lmodel.github.io/fluxnova-bpm-platform, built from the bundle, the sidecar README, the docs pages, the changelog and the schema's pages.

# References

* [Fluxnova BPM Platform 3.1.1 (FINOS)](references/finos-fluxnova-bpm-platform.md) - FINOS's Fluxnova BPM Platform, the upstream this repository forks: the release 3.1.1 the schema renders, its tag and commit, its Apache 2.0 licence, and the merged main commit.
* [BPMN 2.0 (OMG)](references/bpmn-2.md) - BPMN 2.0, the Object Management Group's process notation, whose elements Fluxnova's BPMN model API reads and the BPMN modules render, mapped by the XML namespace and the element's name.

# Datasets

* [Fluxnova LinkML schema](datasets/fluxnova-linkml-schema.md) - The LinkML schema of Fluxnova 3.1.1: the umbrella `fluxnova_bpm_platform.yaml`, the engine tables module and the BPMN modules, which two converters write from FINOS's tree.
* [Engine tables module](datasets/engine-tables.md) - The module `fluxnova_bpm_engine`: one class per table of Fluxnova's process engine, with columns as slots, foreign keys as references, unique keys, defaults, state enums and coded state bounds, grouped by area subsets.
* [BPMN modules](datasets/bpmn-modules.md) - The modules `fluxnova_bpmn_core`, `_dc`, `_di`, `_bpmndi`, `_semantic` and `_extension`: one class per element type Fluxnova's BPMN model API registers, with attributes, child elements, references and text.
* [The schema's adapt copy](datasets/adapt-copy.md) - `.lokf/schema/fluxnova_bpm_platform.yaml`, the copy `lokf adapt` writes from the schema for the bundle: which classes it roots on Concept, which names it renames, and how a release attaches it.
* [FINOS's tree and the source pins](datasets/finos-tree.md) - The two pin lists: every file of FINOS's merged commit by git object hash, and every file the converters read with its hash at the tag `v3.1.1`, which the tests hold the tree to.
* [Example data](datasets/example-data.md) - The examples under `.linkml/tests/data/`: a valid example of each engine table's class, a BPMN definitions document, and counter-examples, some derived from FINOS's MockProvider test fixtures.
* [Neighbour adapt copies](datasets/neighbour-copies.md) - The released adapt copies of other lmodel schemas under `.linkml/tests/neighbours/`, pinned by checksum, which the tests use to keep this copy's names apart from a neighbour's and from LOKF's.
* [Generated artefacts](datasets/generated-artefacts.md) - What the LinkML generators write from the schema and nobody edits: `.linkml/project/` (JSON Schema, OWL, SHACL, SQL and more), the Python datamodel and `docs/schema/`.

# Explanations

* [How the fork is laid out](explanations/fork-layout.md) - Why this repository keeps FINOS's tree unchanged at its root and puts the schema project in `.linkml/`, the bundle in `.lokf/` and the site in `website/`, and what links it adds.
* [Modelling choices](explanations/modelling-choices.md) - How the schema renders its sources: integer state codes as bounded integers, foreign keys as references, BPMN references as strings, polymorphic children by element_type, and the prefixes on names.
* [What the schema leaves out](explanations/what-is-left-out.md) - What the schema does not model: the engine's computed columns and the columns' lengths, the CMMN and DMN models, what the BPMN model API does not register, the rest of Fluxnova, and what the first release removed from the old sidecar.

# Playbooks

* [Regenerate the schema and run the tests](playbooks/regenerate-and-test.md) - How to change the schema: edit a converter or the BPMN descriptions, rewrite the modules with just gen-schema, regenerate, refresh the adapt copy and run just lint and just test.
* [Take a new Fluxnova release or FINOS tree](playbooks/take-a-new-fluxnova-release.md) - What to do when the weekly watch reports a new FINOS tag or a moved main: merge FINOS's tree, re-pin it, move the edition, regenerate and re-pin the sources, with a merge commit.
* [Release the schema](playbooks/release.md) - How a release is cut: the changelog's Unreleased section, conventional commit types, semantic-release from the v0.0.0 baseline, the release Environment, and the assets the knowledge release attaches.
* [Knowledge sources map](playbooks/knowledge-sources.md) - The librarian's scrape map: every repository location this bundle derives concepts from, how to re-check each, and the tracked paths left out with their reasons. FINOS's other files are its engine and tools and stay outside the map.

# Policies

* [Licence and attribution](policies/license-and-attribution.md) - What licence covers each part of the repository: this project's Apache 2.0 files, FINOS's unchanged tree, the engine descriptions taken from FINOS's Javadoc, BPMN's names, and the template credits.
* [Security policy](policies/security-policy.md) - How to report a vulnerability privately, what this repository releases and runs, what holds each workflow, and what is out of scope, such as Fluxnova itself.
* [AI covenant](policies/ai-covenant.md) - The rules for AI-assisted contributions and the scheduled librarian agent: contributors own their work, FINOS's files stay FINOS's, elements say what the sources say, and mappings are read first.

# Workflows

* [Build and test (main.yaml)](workflows/main.md) - The test workflow: on each pull request and push to main it installs from `.linkml/uv.lock`, runs `just test` on Python 3.10 to 3.14, and lints and checks the schema and the adapt copy on 3.13.
* [Lint and docs (lint-and-docs.yaml)](workflows/lint-and-docs.md) - Static checks of the shell scripts, workflows and prose this project adds beside FINOS's tree: ShellCheck, actionlint, markdownlint, lychee and codespell, never over FINOS's files.
* [Upstream watch (upstream-watch.yaml)](workflows/upstream-watch.md) - The weekly check of FINOS's tags, the files the converters read and FINOS's main branch, which opens or updates an issue when a check fails.
* [Semantic release (semantic-release.yml)](workflows/semantic-release.md) - The release workflow: on a push to main it computes the next version from conventional commits, promotes the changelog's Unreleased section, tags and publishes the release, and dispatches the knowledge release.
