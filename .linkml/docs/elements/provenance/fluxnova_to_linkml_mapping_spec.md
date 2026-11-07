# Fluxnova -> LinkML Mapping Specification

## Purpose

This mapping specification describes how Fluxnova engine/runtime concepts should populate the Fluxnova provenance LinkML model.

## Mapping principles

1. Prefer **stable engine identifiers** for definitions and runtime instances.
2. Preserve **definition vs execution** separation.
3. Preserve **formal definition vs actual observed value** separation.
4. Export references to large payloads as `WorkflowArtifact` where direct embedding is undesirable.

## Recommended mappings

### Definition layer

- **BPMN process definition key / deployed process definition** -> `WorkflowDefinition.id`, `WorkflowDefinition.definition_key`, `WorkflowDefinition.version`, `WorkflowDefinition.deployment_id`
- **BPMN XML model artifact** -> `WorkflowArtifact` with `artifact_kind: BPMN_XML`; referenced from `WorkflowDefinition.source_model_ref`
- **BPMN flow node / task / event / gateway** -> `StepDefinition`
- **Task implementation metadata** (delegate class, connector id, called element, script reference, expression, form key, DMN ref) -> `StepDefinition.implementation_ref`, `called_element`, `decision_ref`, `form_ref`, `implementation_kind`
- **Input/output variable contracts** -> `ParameterDefinition`

### Runtime layer

- **Process instance / historic process instance** -> `WorkflowRun`
- **Activity instance / task execution** -> `StepRun`
- **Runtime variable snapshot / variable history record** -> `ParameterValue`
- **Incident / failed job / retry metadata** -> `ProvenanceIncident`, `StepRun.retries`, `StepRun.incident_message`
- **Execution timing / duration / queue wait / retry counts** -> `ResourceUsage`
- **Deployed environment / engine endpoint / plugin identity** -> `Environment`, `RuntimeComponent`
- **External payloads, documents, or serialized request/response bodies** -> `WorkflowArtifact`

## Field-by-field mapping guidance

### WorkflowDefinition

- `id`: deterministic URI/CURIE built from process definition key + version
- `external_ref`: raw engine identifier (if different from schema id)
- `definition_key`: BPMN process key
- `version`: deployed version tag/version field
- `deployment_id`: engine deployment identifier
- `source_model_ref`: BPMN artifact
- `runtime_component`: engine component that executes the definition
- `steps`: all BPMN executable flow nodes and relevant events/gateways

### StepDefinition

- `id`: deterministic URI/CURIE built from workflow definition + BPMN element id
- `workflow_definition`: owning process definition
- `bpmn_type`: normalized BPMN element type enum
- `implementation_kind`: normalized implementation enum
- `implementation_ref`: Java delegate class, expression, script path, connector id, etc.
- `input_parameters` / `output_parameters`: formal variable contracts or IO mappings where available

### WorkflowRun

- `id`: deterministic URI/CURIE built from process instance id
- `workflow_definition`: owning definition id
- `business_key`: engine business key/correlation key
- `status`: normalized status enum
- `started_at` / `ended_at`: process timestamps
- `started_by`: initiator principal if available
- `environment`: cluster/runtime environment
- `runtime_component`: engine component
- `input_values`: process-start variables and other top-level inputs
- `output_values`: terminal or completion outputs
- `step_runs`: all activity/task executions in scope

### StepRun

- `id`: deterministic URI/CURIE built from activity instance id
- `workflow_run`: owning process instance
- `step_definition`: BPMN element definition
- `activity_instance_id`: native activity instance id
- `status`: normalized status enum
- `started_at` / `ended_at`: activity timestamps
- `executed_by`: assignee/system principal where meaningful
- `execution_resource`: resource/pod/worker node if meaningful
- `input_values`: values consumed at step boundary
- `output_values`: values produced at step boundary
- `consumed_artifacts` / `produced_artifacts`: external payloads / documents / logs / exports
- `retries`: retry count for retriable execution
- `sequence_no`: exporter-assigned ordering field for deterministic serialization

### ParameterDefinition / ParameterValue

- `ParameterDefinition.id`: definition-scoped ID for a variable contract
- `ParameterDefinition.parameter_scope`: WORKFLOW / STEP / TASK / DECISION / FORM
- `ParameterDefinition.direction`: IN / OUT / INOUT / LOCAL
- `ParameterValue.parameter_definition`: link to formal definition
- `ParameterValue.observed_type`: runtime-observed concrete type
- `ParameterValue.serialized_value`: export-safe representation (truncate or externalize large values if needed)
- `ParameterValue.value_hash`: stable digest for dedupe / comparison / diffing
- `ParameterValue.produced_by_step_run` and `consumed_by_step_runs`: optional lineage edges

## ID strategy recommendation

Use deterministic IDs rather than exporter-local counters.

Examples:

- `wfdef:{process_key}:{version}`
- `stepdef:{process_key}:{bpmn_element_id}`
- `wfrun:{process_instance_id}`
- `steprun:{activity_instance_id}`
- `paramdef:{scope}:{qualified_name}`
- `pval:{run_id}:{qualified_name}:{sequence_no}`

## Redaction recommendation

For sensitive variables:

- keep `ParameterDefinition.secret: true`
- set `ParameterValue.redacted: true`
- store only `value_hash` and a policy-safe `serialized_value` placeholder
- externalize raw payloads to controlled stores and reference them as `WorkflowArtifact`
