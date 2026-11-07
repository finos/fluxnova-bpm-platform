# Playbooks

* [Regenerate the schema and run the tests](regenerate-and-test.md) - How to change the schema: edit a converter or the BPMN descriptions, rewrite the modules with just gen-schema, regenerate, refresh the adapt copy and run just lint and just test.
* [Take a new Fluxnova release or FINOS tree](take-a-new-fluxnova-release.md) - What to do when the weekly watch reports a new FINOS tag or a moved main: merge FINOS's tree, re-pin it, move the edition, regenerate and re-pin the sources, with a merge commit.
* [Release the schema](release.md) - How a release is cut: the changelog's Unreleased section, conventional commit types, semantic-release from the v0.0.0 baseline, the release Environment, and the assets the knowledge release attaches.
* [Knowledge sources map](knowledge-sources.md) - The librarian's scrape map: every repository location this bundle derives concepts from, how to re-check each, and the tracked paths left out with their reasons. FINOS's other files are its engine and tools and stay outside the map.
