# Contributing to fluxnova-bpm-platform

*This file is a checklist, not a design log. Each rule is a line or two that links to where its reasoning lives. `lint-and-docs.yaml` holds it to a word budget.*

## What this project is

A LinkML schema of Fluxnova 3.1.1, the engine's database tables and the BPMN elements its model API reads, in a fork of FINOS's Fluxnova BPM Platform. FINOS's tree sits unchanged at the repository's root, and this project sits beside it in `.linkml/`.

| Path | Holds |
| --- | --- |
| `.linkml/src/fluxnova_bpm_platform/schema/` | The LinkML schema, written by the two converters. Edit the converters, not the modules. |
| `.linkml/scripts/fluxnova_to_linkml.py` | Writes the engine's tables module from the H2 DDL and the engine API's Javadoc. |
| `.linkml/scripts/bpmn_to_linkml.py` | Writes the BPMN modules from the model API, with descriptions from `bpmn_descriptions.yaml`. |
| `.linkml/src/fluxnova_bpm_platform/datamodel/`, `.linkml/project/`, `.linkml/docs/schema/` | Other artefacts generated from the schema. |
| `.linkml/scripts/edition.py`, `upstream_pins.tsv` | The edition the schema renders, and every file of FINOS's tree the converters read. |
| `.linkml/scripts/check_upstream_release.py` | The weekly comparison with FINOS's tags and main. |
| `.lokf/knowledge/` | This repository's knowledge bundle. |

Everything else is FINOS's, but what [NOTICE](NOTICE) lists as this project's.

## Development setup

You need Python 3.10+, [uv](https://docs.astral.sh/uv/) and [just](https://github.com/casey/just).

```bash
git clone https://github.com/lmodel/fluxnova-bpm-platform.git
cd fluxnova-bpm-platform/.linkml
uv sync --group dev
just --list
```

Never run `just setup` (it nests a repository) or `just deploy` (it pushes the root of `gh-pages`).

### Agent skills (optional, only for this repo's `.lokf/` bundle)

The bundle is maintained with the Knowledge Trust Ladder (KTL) skills, **installed, never committed**. Continuous integration (CI) installs the librarian skill at run time, pinned to a release. [The install page](https://w3id.org/ktl/docs/install/) lists every route. With npm:

```bash
npx skills add noelmcloughlin/knowledge-trust-ladder --skill ktl-librarian --yes   # derive concepts
npx skills add noelmcloughlin/knowledge-trust-ladder --skill ktl-curator --yes     # confirm them as a person
```

## Before opening a pull request

- **Leave FINOS's files alone.** A change to one goes to [FINOS](https://github.com/finos/fluxnova-bpm-platform). `.linkml/tests/test_upstream.py` holds every file `.linkml/tests/upstream_tree.tsv` lists to its hash.
- **Change a converter, then regenerate.** From `.linkml/`, run `just gen-schema`, `just gen-project`, `just gen-doc` and `just lokf-adapt`, and commit the output. `just check-schema` fails when a module differs from what FINOS's tree gives.
- **An element says what Fluxnova's sources say.** `.linkml/tests/test_sources.py` holds every table, column, foreign key, state code and registered BPMN element to the sources.
- **A mapping is read at its source.** A term with no sure match stays unmapped.
- **Keep names apart.** A host imports this adapt copy beside the Linked Open Knowledge Format (LOKF) schema and the released copies in `.linkml/tests/neighbours/`. `.linkml/tests/test_schema_rules.py` checks this.
- **Run the tests**: `just test` from `.linkml/`. Examples sit in `tests/data/valid/` and `invalid/`, named `ClassName-suffix.yaml`.
- **Follow the schema's conventions**: PascalCase classes with the `Fluxnova`, `Bpmn`, `Di` or `Dc` prefix, snake_case slots, the sources' spelling for values, and a short description on every element.
- **Run the pre-commit hooks** on what you staged, from the root (`uvx pre-commit run -c .linkml/.pre-commit-config.yaml`).
- **Lock files are part of the change.** CI installs with `uv sync --locked`, so an edit without its `.linkml/uv.lock` (or `.lokf/uv.lock`) fails.
- **Knowledge-bundle changes**: `cd .lokf && just lokf-validate` must pass, and `knowledge-registrar.yaml` runs on any `.lokf/**` change.
- **`lint-and-docs.yaml`** runs ShellCheck, actionlint, markdownlint, lychee and codespell over this project's files, never FINOS's.
- **Actions are pinned to commit hashes**; Dependabot bumps them.
- **The skills pin moves with the sidecar copies.** When moving `TRUST_LADDER_SKILLS_REF` in `.github/workflows/knowledge-librarian.yaml`, copy the other `knowledge-*.yaml` workflows and `.lokf/scripts/` and `.lokf/m365/` from that release's `skills/ktl-sidecar/templates/` in the same pull request.
- **If your change alters behaviour**, add an entry under `## [Unreleased]` in [CHANGELOG.md](CHANGELOG.md).

## Taking a new release of Fluxnova or FINOS's tree

The weekly watch opens an issue when FINOS tags a release or its main moves. Merge `upstream/main` (or the release's commit), then run `just pin-finos-tree <commit>`, move `scripts/edition.py`, run `just gen-schema` and `just pin-sources`, and regenerate. Merge with a merge commit: a squash loses FINOS's history, and the next merge conflicts on every file.

## Code of conduct

Participation here is covered by the [Contributor Covenant](CODE_OF_CONDUCT.md).

## Using AI tools

Artificial intelligence (AI) assistance is welcome; [AI_COVENANT.md](AI_COVENANT.md) sets the rules, for people and the scheduled `knowledge-librarian` agent alike.

## Reporting issues

Use the [issue tracker](https://github.com/lmodel/fluxnova-bpm-platform/issues) for the schema. A problem in Fluxnova belongs with [FINOS](https://github.com/finos/fluxnova-bpm-platform/issues).

## Releasing (maintainers)

- Write `## [Unreleased]` in [CHANGELOG.md](CHANGELOG.md) as you go. The release job refuses an empty one (`.github/scripts/changelog-release.mjs check`).
- Type the commit ([Conventional Commits](https://www.conventionalcommits.org/)) for what the change *is*. Only `feat:`, `fix:`, `security:` and a breaking `!` start a release, and FINOS's commits in a merge count too. A pull request that would release must carry a releasing type in its title.
- On merge, [`semantic-release.yml`](../.github/workflows/semantic-release.yml) retitles the section to `## [X.Y.Z] - YYYY-MM-DD`, commits `.linkml/CHANGELOG.md`, tags `vX.Y.Z` and publishes the GitHub Release. Once `KNOWLEDGE_RELEASE_ENABLED` is `true`, it dispatches `.github/workflows/knowledge-release.yaml`, which attaches the schema copy and the bundle when either changed.
- That step runs behind the `release` GitHub Environment. Configure required reviewers on it in Settings → Environments, or every qualifying merge is released unattended.
- Below 1.0.0: the `v0.0.0` baseline tag sits on the merge of FINOS's tree, so FINOS's older commits do not count. `.releaserc.json` maps `breaking: true` to `minor`.
- A branch rule requiring pull requests, status checks or signed commits would reject the release job's own push to `main`, so leave them off. [SECURITY.md](../.github/SECURITY.md) says what holds `main` instead.

## License

By contributing, you agree that your contributions are licensed under the [Apache License 2.0](LICENSE). [NOTICE](NOTICE) says what comes from FINOS. Update it when you add something from elsewhere.
