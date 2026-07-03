# Proposal: An AI Provenance Overlay for FINOS AI-Augmented Workflows

**Status:** Draft for discussion
**Author:** Fluxnova BPM Platform maintainers
**Audience:** FINOS Fluxnova maintainers, FINOS AI Governance Framework contributors, adopting member firms
**License of contribution:** Apache-2.0 (matching the host projects)

---

## 1. Summary

We propose contributing a small, vendor-neutral **AI Provenance Overlay** to the
relevant FINOS Fluxnova projects. It is a standard set of **record types** that
capture *what an AI-augmented workflow step actually did at runtime* - which
model was called, what prompts and tool calls were involved, how many tokens
were consumed, what it cost, what safety checks fired, and what evaluations
passed or failed.

The overlay is published as a **JSON Schema** so that any Fluxnova engine,
plugin, or downstream firm can produce and consume the same audit records
without agreeing on a single implementation language.

Today this model lives only as a **sidecar** inside the `fluxnova-bpm-platform`
repository and has never been contributed upstream. With the arrival of the
**Agentic Subprocess** capability (fluxnova-plugins#29), there is now a concrete
runtime feature that produces exactly the kind of AI activity this overlay was
designed to record. This is the right moment to upstream it.

## 2. Motivation

The Agentic Subprocess feature turns a BPMN ad-hoc subprocess into an autonomous
LLM + tool loop. It is powerful, but by design it keeps its working state
(conversation history, pending tool calls, results) in **transient process
variables**. Once the process instance completes, there is **no durable,
standardised audit record** of:

- which model and provider were called, and with which parameters;
- the reasoning turns and the tools the agent chose to activate;
- token consumption and monetary cost;
- guardrail / safety outcomes; and
- any quality or safety evaluation of the result.

The Agentic Subprocess PR itself lists several of these as **"Not Included / future
work"** - specifically *"an auditable record of reasoning for each task
activation."* Regulated financial-services adopters will need precisely this
record for model risk management, cost attribution, incident review, and
regulatory evidence.

Rather than each firm inventing its own audit format, we propose one shared,
open record model.

## 3. How this relates to the FINOS AI Governance Framework

These are **complementary layers, not competing ones**:

| Layer | Question it answers | Owner |
| --- | --- | --- |
| **Prospective governance** - *what an AI system IS, what risks and controls apply, model cards, risk taxonomies* | "Is this system allowed, and under what controls?" | **FINOS AI Governance Framework** |
| **Retrospective provenance (this proposal)** - *what a specific AI step DID on a specific run* | "What actually happened, and can we prove it?" | This overlay |

The overlay does **not** try to model risk taxonomies or approval workflows. It
records runtime evidence and **references** governance concepts by URI, so that a
governance tool can join a runtime record back to the controls that were meant to
apply. A published **crosswalk table** maps every overlay term to the equivalent
concept in the AI Governance Framework vocabulary and in W3C standards.

## 4. Standards alignment

The record model is aligned with widely adopted, vendor-neutral standards so it
is defensible to auditors and portable across firms:

- **W3C PROV** - the model reuses the "Activity / Entity / Agent" provenance
  pattern. An AI call is an Activity, the model is an Agent, prompts and
  artifacts are Entities.
- **W3C Data Quality Vocabulary (DQV)** - used for evaluation/quality measurements.
- **MLCommons Croissant** and **W3C ML-Schema** - used for dataset and model
  artifact descriptions.
- **W3C DPV (DPV-AI, DPV-RISK) and the AI Risk Ontology (AIRO)** - the Data
  Privacy Vocabulary and its AI and risk extensions are
  [W3C Community Group reports](https://w3id.org/dpv/), and
  [AIRO](https://delaramglp.github.io/airo/) is a companion AI-risk ontology
  aligned with them. The overlay reuses their *AI system*, *AI agent*, and
  *AI component* concepts so that a runtime record can point at how a firm
  classifies the system it ran; safety observations recorded on a run (for
  example a suspected policy violation) are references, not new risk
  definitions, so they can be tied to a firm's existing risk taxonomy rather
  than competing with it.
- **Model Context Protocol (MCP)** - the tool-definition, tool-call, and
  conversation-message shapes are aligned with MCP so that an agent that
  discovers or calls tools over MCP is recorded without translation:
  MCP `Tool` (`name`, `description`, `inputSchema`, `outputSchema`) matches
  **AI Tool Definition**; MCP `ToolUseContent` / `ToolResultContent`
  (`toolUseId`, `input`, `content`, `isError`) matches **Tool Call**;
  MCP `SamplingMessage` and `PromptMessage` match **Prompt Message**.
- **FINOS AI Governance Framework vocabulary** - used to reference governance and
  control concepts.

Alignment is expressed as an external **mapping/crosswalk file** (a simple table
of "our term → standard term"), so governance tooling can consume it without
adopting our data model wholesale.

## 5. What the overlay records

The overlay adds the following record types on top of the existing Fluxnova
workflow-provenance records (workflow run, step run, parameter values, incidents,
resource usage). Everything below is expressed as ordinary JSON objects governed
by a published JSON Schema.

### 5.1 Context records (the "what was available")

| Record type | Purpose |
| --- | --- |
| **AI Agent** | A concrete deployed AI agent / model endpoint (provider, model name/version, context window, modalities). Extends the existing generic "Agent". |
| **AI Model Descriptor** | Static model characteristics (family, architecture, parameter count, supported languages). |
| **AI Tool Definition** | A tool advertised to the agent - corresponds to a child service task of an agentic subprocess, including which process variables it reads and writes and the step that backs it. |
| **AI Dataset** | A dataset referenced by a call (training, fine-tuning, evaluation, RAG corpus, ground truth). |
| **Model Artifact** | A persistent model artifact (checkpoint, weights, model card). |

### 5.2 Runtime records (the "what actually happened")

| Record type | Purpose |
| --- | --- |
| **Agent Loop Run** | One run of an autonomous agent loop hosted by an (ad-hoc) subprocess. Owns the ordered turns and the tools that were advertised. Maps directly onto the Agentic Subprocess orchestration loop. |
| **AI Model Invocation** | One concrete call to a model - one turn of the loop, or a stand-alone call. Captures parameters (temperature, top-p, max tokens), token counts, cost, safety flags, and evaluation results. |
| **Prompt Message** | One turn in the conversation (system, user, assistant, or tool), with role, content (redactable), an ordering index, and a data-classification label. |
| **Tool Call** | A tool/function call the agent made, its arguments and result, its status, and a link to the actual BPMN step that was triggered to execute it. |
| **Evaluation Result** | An online quality or safety measurement of an invocation (human review, LLM-as-judge, metric, guardrail, static rule) with pass/fail. |

### 5.3 Controlled vocabularies

The overlay ships fixed value lists (each value carries a description and, where
one exists, a link to the equivalent standard term):

- **Message role** - system / user / assistant / tool
- **Invocation kind** - chat completion / completion / embedding / tool use /
  agent loop / retrieval / guardrail
- **Modality** - text / image / audio / video / multimodal / embedding
- **Safety flag** - policy violation / hallucination suspected / jailbreak attempt
  / PII leak / prompt injection / toxicity / none
- **Dataset kind** - training / fine-tuning / evaluation / RAG corpus / ground truth
- **Evaluator kind** - human review / LLM-as-judge / metric / guardrail / static rule

## 6. How it maps onto the Agentic Subprocess feature

The overlay was designed so that the Agentic Subprocess runtime state maps onto it
almost one-to-one, which means adoption is mostly a matter of serialising state
that the plugin already holds:

| Agentic Subprocess runtime state | Overlay record |
| --- | --- |
| `agent:config` provider / model | AI Agent (provider, model name) |
| `agent:config` system prompt | Prompt Message (role = system) |
| `agent:tool` catalogue (reads / writes) | AI Tool Definition |
| Conversation entry | Prompt Message |
| LLM text response | Invocation response message |
| Tool-call request | Tool Call (name, id, arguments) |
| Tool-invocation result + triggered task | Tool Call result/status + link to the child step run |
| The orchestration loop | Agent Loop Run → ordered AI Model Invocation turns |
| Token usage / cost / guardrails | Invocation token counts, cost, safety flags, evaluations |

The same records line up with **Model Context Protocol** for MCP-based tool
platforms: the overlay's tool-call identifier is MCP's `toolUseId`, arguments
and results are MCP's `input` / `content`, and error status is MCP's `isError`.

## 7. Scope and non-goals

**In scope:** a durable, standard, opt-in record of what an AI-augmented step did
at runtime; alignment tables to W3C, MCP, and the FINOS AI Governance Framework;
a JSON Schema (Java bindings can be generated from the same source when adopters
want native types).

**Out of scope (explicitly):**

- Prospective AI governance - risk taxonomies, control catalogues, approval
  workflows, model cards as policy. These belong to the FINOS AI Governance
  Framework; the overlay only *references* them.
- Mandating capture. The overlay is **opt-in**. Engines that do not run AI steps
  are unaffected; it is not added to the core platform model by default.
- Prescribing a storage or transport mechanism. Records can be emitted as history
  events, exported bundles, or an API payload - the firm decides.

## 8. Proposed target projects and contribution path

| FINOS project | What lands there |
| --- | --- |
| **fluxnova-bpm-platform** | The overlay record model (JSON Schema) and the crosswalk table. It already lives here as a sidecar - this step promotes it to a supported, versioned artifact. |
| **fluxnova-plugins** (Agentic Subprocess) | An **optional** provenance emitter that serialises agent-loop state into overlay records. Satisfies the PR's "auditable record of reasoning" follow-up. |
| **fluxnova-ai** | Design discussion, examples, and reference wiring for adopters. |
| **FINOS AI Governance Framework** | Contribute the crosswalk so the framework can reference runtime evidence, and to keep the two vocabularies aligned as they evolve. |

### Suggested phases

1. **Adopt the model.** Promote the sidecar to a versioned, documented artifact in
  `fluxnova-bpm-platform`, with a published JSON Schema.
2. **Emit from the engine.** Provide an optional emitter so any BPMN step (AI or
   not) can already be recorded via the existing workflow-provenance records.
3. **Emit from the agent loop.** Add the optional Agentic Subprocess emitter that
   populates Agent Loop Run / Invocation / Tool Call records.
4. **Publish the crosswalk** to the AI Governance Framework and iterate with its
   maintainers.

## 9. Why standardise now (benefits)

- **Auditability & model risk management** - a defensible, standards-aligned record
  of every AI decision inside a business process.
- **Cost governance** - token and cost attribution per step, per process, per model.
- **Portability** - one open format instead of N proprietary ones; avoids per-firm
  lock-in and eases inter-firm and regulatory exchange.
- **Interoperability** - because it reuses W3C PROV and references the FINOS AI
  Governance Framework, existing provenance and governance tooling can consume it.
- **Low friction** - opt-in, additive, and does not change existing engine behaviour.

## 10. A note on format

The record model is published as a **JSON Schema** for validation and for
language-neutral record exchange, alongside a **crosswalk table** that maps
each overlay term to the equivalent concept in the FINOS AI Governance
Framework vocabulary, W3C PROV and DQV, W3C DPV (with AIRO), MLCommons
Croissant, and MCP.

Consumers work against the JSON Schema directly. Java bindings for engine and
plugin integration can be generated from the same source when adopters want
native types rather than JSON.

### Relationship to OCSF

We considered expressing these records in the **Open Cybersecurity Schema
Framework (OCSF)**. OCSF is an excellent fit for *security telemetry* -
normalised events for SIEM/SOC pipelines - but it is built for a different job.
It models self-contained security *events* (authentication, network, process,
findings), whereas this proposal needs a linked, retrospective *provenance
graph*: a run, its steps, each model turn, and the tool calls and artifacts they
depend on. OCSF also has no native generative-AI vocabulary - in OCSF an "agent"
is a security sensor and a "token" is an authentication token - so adopting it
would mean inventing an unofficial AI extension while losing the relationships
that make the record auditable.

The two are complementary rather than competing. Where a run raises a
security-relevant signal - a suspected prompt injection, jailbreak, or PII leak
- that observation is exactly what a SOC wants in its SIEM and can be emitted as
an **OCSF Finding** downstream, while the provenance record remains the
canonical, governance-facing source. We therefore recommend **not** adopting
OCSF as the record format, and instead treating OCSF as an optional export
target for security operations.

## 11. Requested decision

We ask the FINOS Fluxnova and AI Governance Framework maintainers to:

1. Accept the AI Provenance Overlay as an **opt-in, versioned artifact** in
   `fluxnova-bpm-platform`.
2. Endorse an **optional provenance emitter** for the Agentic Subprocess plugin.
3. Review and host the **crosswalk** alongside the AI Governance Framework
   vocabulary.

---

*This document proposes upstreaming an artifact that currently exists only as a
local sidecar. No behavioural change to any existing engine or plugin is implied;
the overlay and any emitters are additive and opt-in.*
