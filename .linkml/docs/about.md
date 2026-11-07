# About fluxnova-bpm-platform

A [LinkML](https://linkml.io/) data model for the **Fluxnova BPM Platform** - the process engine's persistence schema and its BPMN 2.0 model API, expressed as one coherent, machine-validatable schema.

The schema is **generated, not hand-written**: transformer scripts read the engine's own sources (H2 DDL, Java interface Javadoc, MyBatis mappings) and produce LinkML YAML that you can validate data against, render as docs, or project into JSON Schema, Python, OWL, and more. Re-running the generators on unchanged inputs produces byte-identical output.

## At a glance

- **Two domains in one model** - runtime/persistence entities (from the database schema) and the BPMN 2.0 model API (from Java interfaces).
- **Platform side:** 49 SQL tables -> 51 classes, 192 slots, 7 enums (100% of tables mapped).
- **BPMN side:** 181 Java interfaces -> 6 modular schemas, 10 enums, 28 Fluxnova extension classes.
- **Provenance overlay** - a W3C PROV-aligned record of workflow definitions, runs, and per-invocation AI activity.
- **Ontology cross-walks** - 16 SSSOM mapping files (~7,530 element mappings) to standards like D3FEND, OCSF, STIX, NIST CSF, and CIS Controls, plus an AI-provenance crosswalk to IBM AI Atlas Nexus.
- **484 tests, all passing**, plus reproducible regeneration and `linkml-lint` clean.

## Links

- Source: [github.com/finos/fluxnova-bpm-platform](https://github.com/finos/fluxnova-bpm-platform)
- Project home: [fluxnova.finos.org](https://fluxnova.finos.org/)

## Quality gates

Every regeneration is checked against these gates:

| Gate | Status |
| --- | --- |
| `linkml-lint` | ✅ No problems found |
| `gen-json-schema` | ✅ Pass |
| `gen-python` | ✅ Pass |
| Reproducibility (identical output on re-run) | ✅ Pass |
| SSSOM overlay (`overlay-sssom-mappings`) | ✅ Pass (idempotent, 16 mapping files loaded) |

## What's in the schema

The model is split into small, focused modules. A handful of **root schemas** import the modules to give you a single entry point per domain.

### Platform modules (persistence & runtime)

Generated from the H2 DDL - one module per functional area:

| Module | Classes | Highlights |
| --- | --- | --- |
| `fluxnova_bpm_base` | 5 | ByteArray, MeterLog, Property, SchemaLogEntry, TaskMeterLog (+ 7 enums) |
| `fluxnova_bpm_repository` | 7 | ResourceDefinition (abstract), ProcessDefinition, CaseDefinition, DecisionDefinition, DecisionRequirementsDefinition, FormDefinition, Deployment |
| `fluxnova_bpm_runtime` | 8 | Execution, Task, VariableInstance, EventSubscription, Incident, ExternalTask, CaseExecution, CaseSentryPart |
| `fluxnova_bpm_job` | 3 | Job, JobDefinition, Batch |
| `fluxnova_bpm_identity` | 8 | User, Group, Tenant, Membership, TenantMembership, IdentityLink, IdentityInfo, Authorization |
| `fluxnova_bpm_history` | 17 | Historic* snapshots (process, activity, task, variable, decision, case, …) + UserOperationLogEntry |
| `fluxnova_bpm_collaboration` | 3 | Comment, Attachment, Filter |

### BPMN model modules

Generated from the public BPMN Model API Java interfaces:

| Module | Classes | Covers |
| --- | --- | --- |
| `fluxnova_bpmn_model_dc` | 3 | Diagram Common (Bounds, Font, Point) |
| `fluxnova_bpmn_model_di` | 12 | Diagram Interchange (Diagram, Edge, Plane, Shape, Style, Label, …) |
| `fluxnova_bpmn_model_instance` | 130 | Core BPMN 2.0 elements (Process, Activity, Task, Gateway, Event, Data objects, …) |
| `fluxnova_bpmn_model_bpmndi` | 6 | BPMN Diagram Interchange (BpmnDiagram, BpmnPlane, BpmnShape, BpmnEdge, BpmnLabel, BpmnLabelStyle) |
| `fluxnova_bpmn_model_fluxnova` | 28 | Fluxnova extensions (FluxnovaConnector, FluxnovaFormField, FluxnovaListener, …) |

The BPMN modules import each other in layers (`dc` -> `di`; `instance` -> `di`; `bpmndi` -> `di` + `dc`; `fluxnova_extensions` -> `instance`), with cross-module types that would create cycles flattened to `range: string`. Slot descriptions come from a mix of curated fallbacks and automatic pattern inference (~300 of them).

### Root schemas

These tie everything together:

| Schema | Local classes | Role |
| --- | --- | --- |
| `fluxnova_common` | 0 (slots only) | Shared slot definitions (`id`, `tenant_id`, `revision`, …) imported by every module so the same concept never gets two conflicting URIs. |
| `fluxnova_bpm_platform` | 1 | The top-level entry point: imports `fluxnova_common`, all platform modules, `fluxnova_bpmn_model`, and the provenance overlay. Defines `FluxnovaPlatformData` as the tree root. |
| `fluxnova_bpmn_model` | 2 | BPMN entry point: imports all BPMN modules. Defines `BpmnModelInstance` and `BpmnModelType`. |

### Provenance

A hand-authored, [W3C PROV](https://www.w3.org/TR/prov-overview/)-aligned provenance overlay lives under `src/fluxnova_bpm_platform/schema/provenance/` (base + per-invocation AI overlay + opt-in strict profile). It is not derived from the H2 DDL; the platform root imports it so `ProvenanceBundle` and friends survive regeneration.

See **[elements/provenance/README.md](elements/provenance/README.md)** for the module breakdown, mapping spec, RO-Crate/JSON-LD projection, AI overlay overview, fixtures, and the SSSOM cross-walk to IBM AI Atlas Nexus (`nexus:`), W3C AIRO, and DPV-AI.

### Enums

**Platform:**

| Enum | Values |
| --- | --- |
| SuspensionState | ACTIVE, SUSPENDED |
| DelegationState | PENDING, RESOLVED |
| ActivityInstanceState | DEFAULT, SCOPE_COMPLETE, CANCELED, STARTING, ENDING |
| IncidentState | OPEN, DELETED, RESOLVED |
| JobState | CREATED, FAILED, SUCCESSFUL, DELETED |
| EntityState | ACTIVE, SUSPENDED, COMPLETED, EXTERNALLY_TERMINATED, INTERNALLY_TERMINATED |
| AuthorizationType | GLOBAL, GRANT, REVOKE |

**BPMN model:**

| Enum | Values |
| --- | --- |
| AssociationDirection | None, One, Both |
| EventBasedGatewayType | Exclusive, Parallel |
| GatewayDirection | Unspecified, Converging, Diverging, Mixed |
| ItemKind | Information, Physical |
| MessageVisibleKind | initiating, non_initiating |
| MultiInstanceFlowCondition | None, One, All, Complex |
| ParticipantBandKind | top_initiating, middle_initiating, bottom_initiating, top_non_initiating, middle_non_initiating, bottom_non_initiating |
| ProcessType | None, Public, Private |
| RelationshipDirection | None, Forward, Backward, Both |
| TransactionMethod | Compensate, Image, Store |

### Subsets (filtered views)

Every class is tagged with subsets so you can carve out domain-specific views or docs. Tagging is automatic and deterministic - derived from the file a class lives in - and enforced by a unit test, so it never drifts.

Each class carries **two** subsets: its module subset and a cross-cutting model subset (`fluxnova_bpm` or `fluxnova_bpmn_model`). For example, `ByteArray` -> `in_subset: [base, fluxnova_bpm]`.

| Platform subset | Contents |
| --- | --- |
| `base` | Base types and utility entities (ByteArray, Property, Meter, Schema). |
| `repository` | Resource definitions (Process, Case, Decision, Form). |
| `runtime` | Active execution, task, and event instances. |
| `job` | Job and batch management entities. |
| `identity` | Identity and authorization entities (User, Group, Tenant, Role). |
| `history` | Historical snapshots of completed runtime entities. |
| `collaboration` | Collaboration features (Comments, Attachments, Filters). |
| `fluxnova_bpm` | **Cross-cutting:** all Fluxnova BPM platform entities. |

| BPMN subset | Contents |
| --- | --- |
| `core_api` | Top-level BPMN API types and enums. |
| `instance` | Core BPMN element interfaces. |
| `bpmndi` | BPMN diagram interchange interfaces and enums. |
| `di` | Generic diagram interchange interfaces. |
| `dc` | Diagram coordinate and bounds interfaces. |
| `fluxnova_extensions` | Fluxnova BPMN extension interfaces. |

## How it's built

### Source data

The platform transformer reads the engine's H2 DDL - 7 SQL files in `engine/src/main/resources/org/finos/fluxnova/bpm/engine/db/create/`:

| File | Tables |
| --- | --- |
| `activiti.h2.create.engine.sql` | Core runtime and repository |
| `activiti.h2.create.identity.sql` | Identity management |
| `activiti.h2.create.history.sql` | History |
| `activiti.h2.create.case.engine.sql` | CMMN case runtime |
| `activiti.h2.create.case.history.sql` | CMMN case history |
| `activiti.h2.create.decision.engine.sql` | DMN decision |
| `activiti.h2.create.decision.history.sql` | DMN decision history |

The BPMN transformer reads the public Java interfaces and enums under `model-api/bpmn-model/`.

### The transformer scripts

The maintained workflow lives in four scripts:

- **`fluxnova_to_linkml.py`** - builds the platform schemas from H2 DDL, Java Javadoc, and MyBatis inputs. It adds subset tags, embeds the SQL column name on every slot, emits the shared `fluxnova_common.yaml`, and fills in descriptions from Javadoc (with sensible fallbacks).

- **`fluxnova_bpmn_model_to_linkml.py`** - builds the modular BPMN model schemas from the public Java interfaces, with package-level subsets and curated slot descriptions.

- **`fluxnova_mybatis_enrichment.py`** - a cross-check, not a generator: it parses the 55 MyBatis XML mappers (336 field->column mappings) and confirms they line up with the DDL-derived slot names. It writes nothing and exits non-zero if anything disagrees.

- **`overlay_sssom.py`** - applies the SSSOM ontology mappings onto the generated YAML (see [SSSOM mappings](#sssom-mappings) below). It runs automatically after each generation step.

### SQL column annotations

Every slot generated from the DDL records the database column it came from, right in the schema - no sidecar mapping file needed:

```yaml
slots:
  exception_message:
    range: string
    description: Message of the exception that occurred.
    annotations:
      sql_column: EXCEPTION_MSG_
```

The SQL column name is the ground truth; the slot name is its LinkML-idiomatic snake_case form. Consumers read `annotations.sql_column` to map a slot back to its database column. The `fluxnova_mybatis_enrichment.py` cross-check keeps these honest against the MyBatis ORM mappings:

```bash
python scripts/fluxnova_mybatis_enrichment.py            # pass/fail check
python scripts/fluxnova_mybatis_enrichment.py --verbose  # show all field mappings
```

### SSSOM mappings

Cross-walks to external ontologies and standards are kept as [SSSOM](https://mapping-commons.github.io/sssom/) v0.9 TSV files in `src/fluxnova_bpm_platform/mappings/`. `overlay_sssom.py` reads them and injects `*_mappings` and `prefixes` entries into the generated schema YAML - in sorted, deduplicated, comment-preserving, idempotent fashion.

**Coverage - 16 mapping files (~7,533 element mappings):**

| File | Rows | Covers |
| --- | --- | --- |
| `fluxnova-ai-provenance-to-nexus.sssom.tsv` | 36 | AI-provenance overlay → IBM AI Atlas Nexus, AIRO, DPV-AI, W3C PROV, schema.org |
| `fluxnova-capec.sssom.tsv` | 4 | MITRE CAPEC |
| `fluxnova-cis-controls.sssom.tsv` | 22 | CIS Controls v8 |
| `fluxnova-cve.sssom.tsv` | 19 | MITRE CVE |
| `fluxnova-cwe.sssom.tsv` | 15 | MITRE CWE |
| `fluxnova-cyberinfra.sssom.tsv` | 8 | Cyber Infrastructure |
| `fluxnova-d3fend.sssom.tsv` | 7,162 | MITRE D3FEND |
| `fluxnova-gist.sssom.tsv` | 3 | Semantic Arts GIST |
| `fluxnova-iso27001.sssom.tsv` | 4 | ISO/IEC 27001 |
| `fluxnova-iso29100.sssom.tsv` | 24 | ISO/IEC 29100 (Privacy) |
| `fluxnova-kev-catalog.sssom.tsv` | 10 | CISA KEV Catalog |
| `fluxnova-nist-csf-v2.sssom.tsv` | 12 | NIST CSF v2 |
| `fluxnova-nvd.sssom.tsv` | 12 | NIST NVD |
| `fluxnova-ocsf.sssom.tsv` | 114 | OCSF |
| `fluxnova-stix.sssom.tsv` | 58 | OASIS STIX 2.1 |
| `fluxnova-vulnerability-core.sssom.tsv` | 30 | Vulnerability Core ontology |

**Key namespaces:**

| Prefix | URI |
| --- | --- |
| `d3f:` | `http://d3fend.mitre.org/ontologies/d3fend.owl#` |
| `ocsf:` | `https://w3id.org/lmodel/ocsf/` |
| `gist:` | `https://w3id.org/lmodel/gist/` |
| `core:` | `https://w3id.org/lmodel/vulnerability-core/` |
| `nexus:` | `https://ibm.github.io/ai-atlas-nexus/ontology/` |

SSSOM predicates map onto LinkML mapping slots as follows:

| SSSOM predicate | LinkML field |
| --- | --- |
| `skos:exactMatch` | `exact_mappings` |
| `skos:closeMatch` | `close_mappings` |
| `skos:broadMatch` | `broad_mappings` |
| `skos:narrowMatch` | `narrow_mappings` |
| `skos:relatedMatch` | `related_mappings` |

## Working with the schema

### Regenerating

The overlay step runs automatically after each generation recipe, so you rarely call it by hand.

```bash
# Everything (BPMN model + platform), then overlay mappings
just gen-linkml-all

# Just the platform schemas (from H2 DDL)
just gen-linkml
just gen-linkml --dry-run        # report only, write nothing

# Just the BPMN model schemas (from Java interfaces)
python scripts/fluxnova_bpmn_model_to_linkml.py

# Re-apply SSSOM mappings without regenerating
just overlay-sssom-mappings
just overlay-sssom-mappings --dry-run --verbose
```

### Validating & testing

```bash
# Lint the schema
just lint-schema

# Full reproducibility gate: regenerate -> lint -> cross-validate -> test
just verify-schema

# MyBatis ↔ DDL field-name cross-check
just validate-mybatis

# Run the test suite
just test
# or directly:
pytest tests/ -v
```

### Test coverage

484 tests, all passing:

| Test module | Tests | What it checks |
| --- | --- | --- |
| `tests/test_fluxnova_to_linkml.py` | 97 | Platform transformer (parsing, mapping, generation) |
| `tests/test_schema.py` | 20 | Schema-level lint, generators, structure |
| `tests/test_data.py` | 187 | Valid/invalid example data against the schema (covers BPM, BPMN, and provenance classes) |
| `tests/test_ddl_coverage.py` | 104 | DDL cross-validation: table coverage, column->slot, vendor files |
| `tests/test_bpmn_model_schema.py` | 4 | BPMN schema validation, lint, JSON Schema generation |
| `tests/test_fluxnova_bpmn_model_to_linkml.py` | 7 | BPMN transformer (discovery, headers, coverage, inheritance, serialization) |
| `tests/test_ai_provenance.py` | 65 | AI-provenance overlay: classes, fixtures, PROV alignment, Nexus crosswalk |

The example data is realistic: 33 of the valid files (`tests/data/valid/*-vendor.yaml`) reuse the exact constants the upstream engine uses in its own REST API tests (`engine-rest/.../helper/MockProvider.java`). The invalid files deliberately break things - missing required fields, bad enum values, wrong types - to prove validation rejects them. A few cross-schema cases (`Point-001.yaml`, `Bounds-001.yaml`, `Font-001.yaml`, and their bad counterparts) confirm the platform root correctly validates imported BPMN classes.

## Reference

### What's intentionally out of scope

- **REST DTOs** (`engine-rest/`) - API transfer objects that mirror persistence entities; excluded to avoid duplication.
- **Java implementation entity classes** (`engine/.../impl/.../entity`) - a review of representative entities (`ExecutionEntity`, `TaskEntity`, `CamundaFormDefinitionEntity`, timer/job subclasses) found no DDL-backed surface beyond the generated model. Their extra fields are transient caches, runtime helpers, or subtype behavior already covered by existing tables.
