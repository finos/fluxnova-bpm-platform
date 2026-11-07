# Fluxnova AI Provenance - Overview

The AI provenance overlay layers on top of the generic BPM provenance schema and adds the entities and slots needed to record what happened when a BPMN step invoked an AI model (LLM completion, embedding call, tool use, agent
loop, retrieval, or guardrail).

It is an **opt-in** overlay - neither the strict overlay nor the AI overlay is imported by [`fluxnova_bpm_platform.yaml`](https://github.com/lmodel/fluxnova-bpm-platform/blob/main/src/fluxnova_bpm_platform/schema/fluxnova_bpm_platform.yaml). Consumers `imports:` it explicitly only when they need it.

## Files

- Schema: [src/fluxnova_bpm_platform/schema/provenance/fluxnova_bpm_ai_provenance.yaml](https://github.com/lmodel/fluxnova-bpm-platform/blob/main/src/fluxnova_bpm_platform/schema/provenance/fluxnova_bpm_ai_provenance.yaml)
- SSSOM crosswalk: [src/fluxnova_bpm_platform/mappings/fluxnova-ai-provenance-to-nexus.sssom.tsv](https://github.com/lmodel/fluxnova-bpm-platform/blob/main/src/fluxnova_bpm_platform/mappings/fluxnova-ai-provenance-to-nexus.sssom.tsv)

## Scope

The overlay is **retrospective per-invocation**. It records concrete
runtime evidence:

- Which AI agent / model was called by a workflow step
- Conversation messages and roles
- Tool calls made inside an agent loop
- Token / cost telemetry
- Safety / guardrail decisions
- Online evaluation results (LLM-as-judge, metric, guardrail, human review)
- Datasets and model artifacts referenced by the invocation

It deliberately does **not** cover prospective AI governance modeling
(what an AI system *is*, what risks/controls apply, benchmark cards, risk
taxonomies). That space is owned upstream by FINOS
[ai-governance-framework](https://github.com/finos/ai-governance-framework).

## Class summary

| Overlay class         | `is_a`              | Purpose                                                  |
| --------------------- | ------------------- | -------------------------------------------------------- |
| `AiAgent`             | `Agent`             | Concrete deployed AI agent / model endpoint              |
| `AiModelDescriptor`   | `RuntimeComponent`  | Model family, architecture, parameter count, modalities  |
| `AiModelInvocation`   | `StepRun`           | One invocation of a model from a BPMN step               |
| `PromptMessage`       | `NamedThing`        | One turn in the conversation (system/user/assistant/tool)|
| `ToolCall`            | `NamedThing`        | A tool/function call inside an agent loop                |
| `EvaluationResult`    | `NamedThing`        | Online quality measurement of an invocation              |
| `AiDataset`           | `WorkflowArtifact`  | Dataset artifact (training, fine-tuning, eval, RAG, GT)  |
| `ModelArtifact`       | `WorkflowArtifact`  | Persistent model artifact (checkpoint, weights, card)    |

## Enums

`MessageRole`, `AiModality`, `AiInvocationKind`, `SafetyFlag`, `DatasetKind`, `EvaluatorKind` - each permissible value carries a
`description:` and a `meaning:` mapping where a stable upstream URI exists (per the *Do not guess mappings* rule in the LinkML SKILL).

## Mapping strategy

The overlay follows the project's "**own-prefix identity, upstream in mappings**" convention:

- `class_uri:` and `slot_uri:` always point at the overlay's own w3id-resolvable IRI (`fluxnova_bpm_ai_provenance:*`).
- Upstream vocabulary CURIEs go into `exact_mappings`, `close_mappings`, or `related_mappings` on the relevant element.
- Cross-vocabulary mappings to FINOS `nexus:` (AI Governance Framework ontology), W3C `prov:`, `airo:`, `dpv:`, `dpv_ai:`, `dpv_risk:`, `dqv:`, `mls:`, `cr:` (MLCommons Croissant), and `schema:` are declared inline AND in the standalone SSSOM TSV crosswalk for externally-maintainable governance tooling.
- The overlay does **not** `imports:` `ai-risk-ontology`. A separate governance-bridge overlay can be added later if a real consumer asks for native AIRO/DPV-AI type checking; until then SSSOM is sufficient.

## Sample usage

The overlay is consumed by adding:

```yaml
imports:
  - linkml:types
  - ./fluxnova_common
  - ./provenance/fluxnova_bpm_provenance
  - ./provenance/fluxnova_bpm_ai_provenance
```

to a downstream schema, then instantiating `AiModelInvocation` records inside a `ProvenanceBundle` exactly as you would `StepRun` records (since `AiModelInvocation is_a StepRun` and the overlay's classes are not added to the master platform schema).

## Related vocabularies

- W3C [PROV-O](https://www.w3.org/TR/prov-overview/) - `prov:Activity`, `prov:Entity`, `prov:Agent`, `prov:wasInformedBy`, `prov:wasGeneratedBy`
- W3C [DQV](http://www.w3.org/ns/dqv) - `dqv:QualityMeasurement` for `EvaluationResult`
- W3C [AIRO](https://w3id.org/airo) - `airo:AIAgent`, `airo:AIModel`, `airo:Modality`
- W3C [DPV-AI](https://w3id.org/dpv/ai) and [DPV-RISK](https://w3id.org/dpv/risk) - risk taxonomy for safety flags
- W3ID [MLS](http://www.w3.org/ns/mls#) - machine-learning schema (`mls:ModelEvaluation`)
- MLCommons [Croissant](http://mlcommons.org/croissant/) - `cr:Dataset`
- FINOS [AI Governance Framework `nexus:`](https://ibm.github.io/ai-atlas-nexus/ontology/) - governance and risk-control concepts
