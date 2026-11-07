# Workflows

* [Build and test (main.yaml)](main.md) - The test workflow: on each pull request and push to main it installs from `.linkml/uv.lock`, runs `just test` on Python 3.10 to 3.14, and lints and checks the schema and the adapt copy on 3.13.
* [Lint and docs (lint-and-docs.yaml)](lint-and-docs.md) - Static checks of the shell scripts, workflows and prose this project adds beside FINOS's tree: ShellCheck, actionlint, markdownlint, lychee and codespell, never over FINOS's files.
* [Upstream watch (upstream-watch.yaml)](upstream-watch.md) - The weekly check of FINOS's tags, the files the converters read and FINOS's main branch, which opens or updates an issue when a check fails.
* [Semantic release (semantic-release.yml)](semantic-release.md) - The release workflow: on a push to main it computes the next version from conventional commits, promotes the changelog's Unreleased section, tags and publishes the release, and dispatches the knowledge release.
