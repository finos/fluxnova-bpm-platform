# Fluxnova Provenance - Design Documents

Narrative and reference material for the Fluxnova BPM provenance feature.
The canonical, validated schema modules live under
[`src/fluxnova_bpm_platform/schema/provenance/`](https://github.com/lmodel/fluxnova-bpm-platform/tree/main/src/fluxnova_bpm_platform/schema/provenance/);
these documents explain how to populate and project them.

## Documents

| File                                                                                   | Contents                                                       |
| -------------------------------------------------------------------------------------- | -------------------------------------------------------------- |
| [fluxnova_to_linkml_mapping_spec.md](fluxnova_to_linkml_mapping_spec.md)               | Field-level mapping from Fluxnova engine APIs to LinkML classes |
| [fluxnova_provenance_rocrate_projection.md](fluxnova_provenance_rocrate_projection.md) | Projection of provenance bundles to RO-Crate / JSON-LD          |
| [fluxnova_ai_provenance_overview.md](fluxnova_ai_provenance_overview.md)               | Per-invocation AI overlay overview and integration guidance     |

## Schema modules

The base provenance module is imported by the master platform schema, and the
base in turn imports the AI overlay - so both are part of the platform root. The
strict overlay is **opt-in**: a consumer must `imports:` it explicitly.

| Module                                                                                                                           | Imported by master | Purpose                                           |
| -------------------------------------------------------------------------------------------------------------------------------- | ------------------ | ------------------------------------------------- |
| [provenance/fluxnova_bpm_provenance.yaml](https://github.com/lmodel/fluxnova-bpm-platform/blob/main/src/fluxnova_bpm_platform/schema/provenance/fluxnova_bpm_provenance.yaml)                 | yes                | Base PROV-aligned provenance schema               |
| [provenance/fluxnova_bpm_provenance_strict.yaml](https://github.com/lmodel/fluxnova-bpm-platform/blob/main/src/fluxnova_bpm_platform/schema/provenance/fluxnova_bpm_provenance_strict.yaml)   | no (opt-in)        | Strict validation overlay (required slots, regex) |
| [provenance/fluxnova_bpm_ai_provenance.yaml](https://github.com/lmodel/fluxnova-bpm-platform/blob/main/src/fluxnova_bpm_platform/schema/provenance/fluxnova_bpm_ai_provenance.yaml)           | yes (via base)     | AI-invocation provenance overlay                  |

The base schema is PROV-aligned and separates **prospective** provenance
(`WorkflowDefinition`, `StepDefinition`, `ParameterDefinition`) from
**retrospective** provenance (`WorkflowRun`, `StepRun`, `ParameterValue`). The
strict overlay tightens cardinality and adds identifier/endpoint patterns to make
exports deterministic and CI-validatable.

## Fixtures

- Valid: [tests/data/valid/ProvenanceBundle-customer-onboarding.yaml](https://github.com/lmodel/fluxnova-bpm-platform/blob/main/tests/data/valid/ProvenanceBundle-customer-onboarding.yaml)
- Invalid: [tests/data/invalid/ProvenanceBundle-bad-status.yaml](https://github.com/lmodel/fluxnova-bpm-platform/blob/main/tests/data/invalid/ProvenanceBundle-bad-status.yaml)

## Mappings

- SSSOM crosswalk to FINOS `nexus:`: [src/fluxnova_bpm_platform/mappings/fluxnova-ai-provenance-to-nexus.sssom.tsv](https://github.com/lmodel/fluxnova-bpm-platform/blob/main/src/fluxnova_bpm_platform/mappings/fluxnova-ai-provenance-to-nexus.sssom.tsv)
