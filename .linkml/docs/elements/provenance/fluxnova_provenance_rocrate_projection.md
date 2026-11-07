# RO-Crate / JSON-LD Projection for Fluxnova Provenance

## Purpose

This document describes how the Fluxnova provenance LinkML model can be projected into a JSON-LD / RO-Crate style representation.

## Projection strategy

The LinkML model is the canonical authoring/validation layer. JSON-LD / RO-Crate is the interchange and graph-publication layer.

### Core projection rules

- `ProvenanceBundle` -> RO-Crate root dataset / top-level crate container
- `WorkflowDefinition` -> JSON-LD node with BPMN / computational workflow semantics
- `StepDefinition` -> prospective step/method node
- `WorkflowRun` -> retrospective run action
- `StepRun` -> retrospective step execution action
- `ParameterDefinition` -> formal parameter node
- `ParameterValue` -> actual value node
- `Agent`, `Environment`, `RuntimeComponent`, `WorkflowArtifact` -> contextual or data entities

## Recommended JSON-LD context sketch

```json
{
  "@context": {
    "schema": "http://schema.org/",
    "prov": "http://www.w3.org/ns/prov#",
    "fluxnova_bpm_provenance": "https://w3id.org/lmodel/fluxnova-bpm-platform/provenance/",
    "id": "@id",
    "type": "@type",
    "name": "schema:name",
    "description": "schema:description",
    "instrument": {"@id": "schema:instrument", "@type": "@id"},
    "object": {"@id": "schema:object", "@type": "@id"},
    "result": {"@id": "schema:result", "@type": "@id"},
    "agent": {"@id": "schema:agent", "@type": "@id"},
    "startTime": "schema:startTime",
    "endTime": "schema:endTime",
    "exampleOfWork": {"@id": "schema:exampleOfWork", "@type": "@id"},
    "workExample": {"@id": "schema:workExample", "@type": "@id"},
    "used": {"@id": "prov:used", "@type": "@id"},
    "wasGeneratedBy": {"@id": "prov:wasGeneratedBy", "@type": "@id"}
  }
}
```

## Recommended RO-Crate graph pattern

### Root entities

- Metadata descriptor: `ro-crate-metadata.json`
- Root data entity: `./`
- Crate metadata includes `workflow_definitions`, `workflow_runs`, `workflow_artifacts`

### Prospective entities

- Workflow definition node as `File + SoftwareSourceCode + ComputationalWorkflow + HowTo` when exporting BPMN model artifacts
- Step definitions as `HowToStep` and/or `SoftwareSourceCode` style nodes depending on desired fidelity
- Parameter definitions as `FormalParameter`

### Retrospective entities

- Workflow run as `CreateAction`
- Step run as `CreateAction`
- Optional orchestration node as `OrganizeAction`
- Optional step-linking node as `ControlAction`
- Actual values as `PropertyValue`

## Minimal example projection

```json
{
  "@context": "https://w3id.org/ro/crate/1.1/context",
  "@graph": [
    {
      "@id": "ro-crate-metadata.json",
      "@type": "CreativeWork",
      "about": {"@id": "./"}
    },
    {
      "@id": "./",
      "@type": "Dataset",
      "name": "Fluxnova provenance bundle"
    },
    {
      "@id": "wfdef:customer-onboarding-review:1",
      "@type": ["File", "SoftwareSourceCode", "ComputationalWorkflow", "HowTo"],
      "name": "Customer Onboarding Review",
      "step": [{"@id": "stepdef:intake-service-task"}]
    },
    {
      "@id": "stepdef:intake-service-task",
      "@type": "HowToStep",
      "name": "Capture Intake Data"
    },
    {
      "@id": "wfrun:customer-onboarding-review:90001",
      "@type": "CreateAction",
      "instrument": {"@id": "wfdef:customer-onboarding-review:1"},
      "startTime": "2026-06-11T09:00:00+01:00",
      "endTime": "2026-06-11T09:08:45+01:00"
    }
  ]
}
```

## Export recommendation

A practical export pipeline is:

1. Export Fluxnova runtime/history into LinkML instance YAML/JSON.
2. Validate against the strict LinkML profile.
3. Transform validated instance data into JSON-LD / RO-Crate using deterministic IDs.
4. Load JSON-LD into graph tooling or publish crate bundles for downstream analysis.
