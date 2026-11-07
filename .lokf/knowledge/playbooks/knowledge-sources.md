---
type: Playbook
id: https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/playbooks/knowledge-sources
genre: reference
title: Knowledge sources map
description: "The librarian's scrape map: every repository location this bundle derives concepts from, how to re-check each, and the tracked paths left out with their reasons. FINOS's other files are its engine and tools and stay outside the map."
resource: .
references:
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/datasets/fluxnova-linkml-schema
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/references/finos-fluxnova-bpm-platform
  - https://w3id.org/lmodel/fluxnova-bpm-platform/knowledge/references/bpmn-2
sources:
  - resource: .linkml/src/fluxnova_bpm_platform/schema
  - resource: .linkml/scripts
  - resource: .linkml/tests
  - resource: .linkml/docs
  - resource: .linkml/project
  - resource: .linkml/src/fluxnova_bpm_platform/datamodel
  - resource: website
  - resource: .github/workflows/main.yaml
  - resource: .github/workflows/lint-and-docs.yaml
  - resource: .github/workflows/upstream-watch.yaml
  - resource: .github/workflows/semantic-release.yml
  - resource: .github/SECURITY.md
  - resource: .lokf/schema/fluxnova_bpm_platform.yaml
  - resource: .linkml/generators.yaml
  - resource: .linkml/project.justfile
  - resource: .linkml/README.md
  - resource: .linkml/CHANGELOG.md
  - resource: .linkml/CONTRIBUTING.md
  - resource: .linkml/AI_COVENANT.md
  - resource: .linkml/NOTICE
  - resource: .releaserc.json
  - resource: engine/src/main/resources/org/finos/fluxnova/bpm/engine/db/create
  - resource: model-api/bpmn-model/src/main
exclusions:
  - resource: .github/dependabot.yml
    reason: "Tooling: when Dependabot opens version bumps."
  - resource: .github/PULL_REQUEST_TEMPLATE
    reason: The sync pull request text, from the KTL template, states nothing about the schema.
  - resource: .github/workflows/knowledge-librarian.yaml
    reason: The KTL sidecar's workflow, from the v0.62.0 template; KTL documents it.
  - resource: .github/workflows/knowledge-registrar.yaml
    reason: The KTL sidecar's workflow, from the v0.62.0 template; KTL documents it.
  - resource: .github/workflows/knowledge-release.yaml
    reason: The KTL sidecar's workflow, from the v0.62.0 template; KTL documents it.
  - resource: .github/workflows/knowledge-sync.yaml
    reason: The KTL sidecar's workflow, from the v0.62.0 template; KTL documents it.
  - resource: .github/workflows/knowledge-website.yaml
    reason: The KTL website's workflow, from the v0.62.0 template; KTL documents it.
  - resource: .github/scripts
    reason: The release job's helpers, which the release playbook names through CONTRIBUTING.
  - resource: .github/release
    reason: The release job's pinned npm tools.
  - resource: .lokf/README.md
    reason: The sidecar README, from the KTL template, states nothing about this project.
  - resource: .lokf/queries.http
    reason: Sample queries from the KTL template.
  - resource: .lokf/ingest.yaml.sample
    reason: The ingest's example manifest from the KTL template; this host mirrors nothing.
  - resource: .lokf/scripts
    reason: The KTL sidecar's scripts, which the weekly sync replaces.
  - resource: .lokf/m365
    reason: The KTL sidecar's Copilot skill builder.
  - resource: .lokf/schema/lokf.yaml
    reason: LOKF's own schema, copied from the toolkit.
  - resource: .linkml/.copier-answers.yml
    reason: The copier template's answers.
  - resource: .linkml/justfile
    reason: The copier template's recipes; the project's own are in project.justfile.
  - resource: .linkml/config.public.mk
    reason: The copier template's settings, naming the schema and generators.yaml.
  - resource: .linkml/pyproject.toml
    reason: The Python package's settings and the lint tools' word lists.
  - resource: .linkml/uv.lock
    reason: The locked toolchain.
  - resource: .linkml/.gitignore
    reason: Tooling.
  - resource: .linkml/.editorconfig
    reason: Tooling.
  - resource: .linkml/.linkmllint.yaml
    reason: linkml-lint's settings; README.md and CONTRIBUTING.md state the naming rules.
  - resource: .linkml/.markdownlint-cli2.jsonc
    reason: Tooling.
  - resource: .linkml/.pre-commit-config.yaml
    reason: Tooling; CONTRIBUTING.md says to run the hooks.
  - resource: .linkml/.yamllint.yaml
    reason: Tooling.
  - resource: .linkml/lychee.toml
    reason: Tooling.
  - resource: .linkml/CODE_OF_CONDUCT.md
    reason: The Contributor Covenant, unchanged.
  - resource: .linkml/LICENSE
    reason: The Apache License 2.0 text, which the licence policy names through NOTICE.
  - resource: .linkml/examples/README.md
    reason: The copier template's note on examples.
  - resource: .linkml/src/README.md
    reason: The copier template's note on src/.
  - resource: .linkml/src/fluxnova_bpm_platform/__init__.py
    reason: The package's version import.
  - resource: .linkml/src/fluxnova_bpm_platform/_version.py
    reason: Written by the build.
  - resource: linkml_schema
    reason: A link to the schema folder, which the schema concept covers.
  - resource: llms.txt
    reason: Pointers for agents to the bundle and the schema; it states no fact of its own.
  - resource: .ci
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: .github
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: .gitignore
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: .mvn
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: .snyk
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: AUTH_CONFIGURATION_GUIDE.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: CONTRIBUTING.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: Dockerfile
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: Fluxnova-build-readme.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: Fluxnova-getting-started.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: GOVERNANCE.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: INTEGRATION_TEST_FIXES.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: Jenkinsfile
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: LICENSE
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: LICENSE.spdx
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: MAINTAINERS.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: NOTICE
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: README.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: RELEASE.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: SECURITY.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: TESTING.md
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: bom
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: clients
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: commons
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: connect
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: coverage
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: database
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: distro
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: docker-bake.hcl
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: docker-script.sh
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: docs
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: engine-cdi
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: engine-dmn
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: engine-plugins
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: engine-rest
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: engine-spring
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: engine
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: examples
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: freemarker-template-engine
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: internal-dependencies
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: javaee
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: juel
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: migrator
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: model-api
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: mvnw
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: mvnw.cmd
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: parent
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: pom.xml
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: qa
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: quarkus-extension
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: rewrite
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: settings.xml
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: settings
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: spin
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: spring-boot-starter
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: test-utils
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
  - resource: webapps
    reason: FINOS's tree, unchanged. The converters read only the files .linkml/scripts/upstream_pins.tsv lists.
generated:
  by: process:ktl-librarian
  at: "2026-11-07T03:39:33Z"
  revision: 5201fdb877aeca68ac530b10533bca31c7a23ffa
status: draft
---

# Knowledge sources map

| Source | Yields | Re-check |
| --- | --- | --- |
| `.linkml/src/fluxnova_bpm_platform/schema` | the schema and its modules (`Dataset`) | `just check-schema` from `.linkml/` |
| `.linkml/scripts` | the converters, the edition and the pins (`Dataset`, `Reference`) | `just test` |
| `.linkml/docs`, `.linkml/README.md`, `.linkml/CHANGELOG.md` | what the schema models and leaves out (`Explanation`) | read the pages |
| `.linkml/CONTRIBUTING.md`, `.linkml/project.justfile` | how to change and release the schema (`Playbook`) | `just --list` from `.linkml/` |
| `.linkml/NOTICE`, `.linkml/AI_COVENANT.md`, `.github/SECURITY.md` | the policies (`Policy`) | read the files |
| `.github/workflows/` (this project's four) | the workflows (`Service`) | read each header |
| `website/` | the documentation site (`Service`) | `website/site.config.mjs` |

FINOS's tree outside these paths is FINOS's engine, applications and tools. The converters read from it, and `.linkml/scripts/upstream_pins.tsv` lists those files.
