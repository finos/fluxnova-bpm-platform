# Datasets

* [Fluxnova LinkML schema](fluxnova-linkml-schema.md) - The LinkML schema of Fluxnova 3.1.1: the umbrella `fluxnova_bpm_platform.yaml`, the engine tables module and the BPMN modules, which two converters write from FINOS's tree.
* [Engine tables module](engine-tables.md) - The module `fluxnova_bpm_engine`: one class per table of Fluxnova's process engine, with columns as slots, foreign keys as references, unique keys, defaults, state enums and coded state bounds, grouped by area subsets.
* [BPMN modules](bpmn-modules.md) - The modules `fluxnova_bpmn_core`, `_dc`, `_di`, `_bpmndi`, `_semantic` and `_extension`: one class per element type Fluxnova's BPMN model API registers, with attributes, child elements, references and text.
* [The schema's adapt copy](adapt-copy.md) - `.lokf/schema/fluxnova_bpm_platform.yaml`, the copy `lokf adapt` writes from the schema for the bundle: which classes it roots on Concept, which names it renames, and how a release attaches it.
* [FINOS's tree and the source pins](finos-tree.md) - The two pin lists: every file of FINOS's merged commit by git object hash, and every file the converters read with its hash at the tag `v3.1.1`, which the tests hold the tree to.
* [Example data](example-data.md) - The examples under `.linkml/tests/data/`: a valid example of each engine table's class, a BPMN definitions document, and counter-examples, some derived from FINOS's MockProvider test fixtures.
* [Neighbour adapt copies](neighbour-copies.md) - The released adapt copies of other lmodel schemas under `.linkml/tests/neighbours/`, pinned by checksum, which the tests use to keep this copy's names apart from a neighbour's and from LOKF's.
* [Generated artefacts](generated-artefacts.md) - What the LinkML generators write from the schema and nobody edits: `.linkml/project/` (JSON Schema, OWL, SHACL, SQL and more), the Python datamodel and `docs/schema/`.
