# AI Provenance for the Agentic Subprocess - ready-to-post PR comment & issue

Companion to [finos-ai-provenance-overlay-proposal.md](./finos-ai-provenance-overlay-proposal.md).
This file holds two ready-to-post GitHub artifacts written for a FINOS
engineering audience. Both describe the AI provenance model in terms of its
published **JSON Schema**. See the proposal for the full rationale so it is not
repeated here.

---

## A. Comment for `finos/fluxnova-plugins` PR #29 (Agentic Subprocess)

> Really nice work on this - turning a BPMN ad-hoc subprocess into an autonomous
> LLM + tool loop is clean, and keeping conversation/tool state in scoped process
> variables makes it resumable and engine-native.
>
> One cross-repo note for whoever picks up the **"auditable record of reasoning
> for each task activation"** item from *Not Included*: `fluxnova-bpm-platform`
> already defines a retrospective **AI provenance record model** (published as a
> JSON Schema) whose shape maps almost one-to-one onto the
> state this plugin already holds:
>
> | Agentic Subprocess runtime state | AI provenance record |
> | --- | --- |
> | `agent:config` provider / model | AI Agent (provider, model name) |
> | `agent:config` system prompt | Prompt Message (role = system) |
> | `agent:tool` catalogue (reads / writes) | AI Tool Definition |
> | Conversation entry | Prompt Message |
> | LLM text response | Invocation response message |
> | Tool-call request | Tool Call (name, id, arguments) |
> | Tool-invocation result + triggered task | Tool Call result/status + link to the child step run |
> | Orchestration loop | Agent Loop Run → ordered AI Model Invocation turns |
> | Token usage / cost / guardrails | Invocation token counts, cost, safety flags, evaluations |
>
> The tool-call, tool-definition and conversation-message shapes are aligned
> with **Model Context Protocol**: the tool-call identifier is MCP's
> `toolUseId`, arguments/results are MCP's `input`/`content`, and the tool
> catalogue mirrors MCP `Tool` (`name`, `description`, `inputSchema`,
> `outputSchema`). MCP-based tools record without translation.
>
> These are **complementary layers**, not overlapping concerns - nothing to
> change in this PR. I've raised an issue on `finos/fluxnova-ai` to track an
> optional provenance-emitter that would serialise the agent-loop state into
> these records, which also covers the token/cost and per-activation
> auditability items. Flagging it here so the runtime state and the audit record
> model stay aligned as this evolves.

---

## B. New issue for `finos/fluxnova-ai`

**Title:** Emit AI provenance records for agentic subprocess runs

**Body:**

> ### Context
> The agentic subprocess capability (finos/fluxnova-plugins#29) runs an
> autonomous LLM + tool loop over a BPMN ad-hoc subprocess and keeps its working
> state (conversation, pending tool calls, results) in transient process
> variables. When the instance completes, there is no durable, standardised
> audit record of what the agent did.
>
> `fluxnova-bpm-platform` already defines an opt-in **AI provenance record
> model** (published as a JSON Schema) for exactly this - see
> [the proposal](https://github.com/finos/fluxnova-bpm-platform/blob/main/docs/proposals/finos-ai-provenance-overlay-proposal.md).
> These are complementary layers: the plugin *executes* the loop; the record
> model *captures what it did*. The plugin's runtime state is the natural source.
>
> ### Proposal
> Add an **optional** provenance emitter that serialises agentic-subprocess
> runtime state into these records at loop completion (via a history-event hook
> or export bundle - mechanism left to the implementation). This directly
> satisfies PR #29's "auditable record of reasoning per activation" and
> token/cost follow-ups.
>
> ### Mapping
> *(same table as the PR #29 comment above)*
>
> ### Alignment already in place
> - Each LLM call → one **AI Model Invocation** turn under a single **Agent Loop
>   Run**, ordered by turn index.
> - Each tool call → a **Tool Call** linked to the materialised child step run,
>   with the tool advertised as an **AI Tool Definition**.
> - The BPMN element/implementation vocabularies already carry the
>   ad-hoc-subprocess and agent-loop values needed to type the hosting step.
> - Token counts, cost, safety flags, and evaluation results are already fields
>   on the invocation record.
> - Tool-definition, tool-call, and message shapes are aligned with **Model
>   Context Protocol** (`Tool`, `ToolUseContent`/`ToolResultContent`,
>   `SamplingMessage`), so MCP-based tools record without translation.
>
> ### Acceptance criteria
> - [ ] A completed agentic subprocess run produces a record set that validates
>       against the published JSON Schema.
> - [ ] Each LLM call is an AI Model Invocation turn under one Agent Loop Run,
>       ordered by turn index.
> - [ ] Each tool call links to the materialised child step run.
> - [ ] Token counts and cost are populated where the provider reports them.
> - [ ] Message-content redaction is honoured (redaction flag / content hash).
>
> ### Links
> Runtime: finos/fluxnova-plugins#29 · Design: finos/fluxnova-ai#34 ·
> Related: finos/fluxnova-ai#25–29
