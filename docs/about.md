# About fluxnova-bpm-platform

Fluxnova BPMN Platform - LinkML Schema

# References

- [https://github.com/finos/fluxnova-bpm-platform](https://github.com/finos/fluxnova-bpm-platform)
- [https://fluxnova.finos.org/](https://fluxnova.finos.org/)

# Schema Directory

This folder contains the LinkML schema yaml files.

## Fluxnova BPM Platform — LinkML Schema Status

Generated: 2026-05-14
Generators: `scripts/fluxnova_to_linkml.py`, `scripts/fluxnova_bpmn_model_to_linkml.py`
Features: Modular schemas, shared common-slot schema, subset enrichment (model + module-level + filename), MyBatis cross-validation, SQL column annotations, top-level platform schema imports the BPMN Model API, SSSOM mapping overlay

### Coverage

#### Platform (Runtime & Persistence)

| Metric | Count |
| --- | --- |
| SQL tables parsed | 49 |
| SQL tables mapped | 49 (100%) |
| SQL tables unmapped | 0 |
| Classes generated | 51 |
| Slots generated | 192 |
| Enums generated | 7 |
| Columns in mapped tables | 652 |

#### BPMN Model API

| Metric | Count |
| --- | --- |
| Java interfaces mapped | 181 |
| Public API interfaces | 181 (100% coverage) |
| Enums generated | 10 |
| Modular schema files | 6 |
| Fluxnova extensions | 28 classes |

### Quality Gates

| Gate | Status |
| --- | --- |
| `linkml-lint` | ✅ No problems found |
| `gen-json-schema` | ✅ Pass |
| `gen-python` | ✅ Pass |
| Reproducibility (identical output on re-run) | ✅ Pass |
| SSSOM overlay (`overlay-sssom-mappings`) | ✅ Pass (idempotent, 26 mapping files loaded) |

### Supported Scripts

The maintained workflow in `scripts/` is intentionally limited to three scripts:

- `fluxnova_to_linkml.py` — generates the platform LinkML schemas from H2 DDL, Java interface Javadoc, and MyBatis-derived validation inputs. Enriches schemas with:
  - **Subsets** for module-level (`base`, `repository`, `runtime`, `job`, `identity`, `history`, `collaboration`, `platform`) and cross-cutting (`fluxnova_bpm`) partitioning. Every class carries `in_subset: [<filename_module>, fluxnova_bpm]`.
  - **SQL column annotations** embedded in every slot (`annotations: {sql_column: COL_NAME_}`).
  - **Shared `fluxnova_common.yaml`** emitted alongside module schemas, holding 8 cross-cutting slot definitions (id, tenant_id, revision, etc.) imported by every module to avoid URI collisions when the platform also imports the BPMN Model API.
  - Automatic Javadoc extraction and fallback descriptions.

- `fluxnova_bpmn_model_to_linkml.py` — generates the modular BPMN Model API LinkML schemas from public Java interfaces and enums. Enriches schemas with:
  - **Subsets** for package-level partitioning (`core_api`, `instance`, `bpmndi`, `di`, `dc`, `fluxnova_extensions`).
  - Curated slot descriptions using hand-crafted fallbacks + automatic pattern inference.
  - Modular imports to avoid circular dependencies.

- `fluxnova_mybatis_enrichment.py` — validates MyBatis XML field mappings against the DDL-derived LinkML slot names and embedded `annotations.sql_column` metadata. Confirms:
  - 55 entity mappers parsed.
  - 336 field→column mappings verified.
  - Zero discrepancies detected on each run.

- `overlay_sssom.py` — deterministically applies all SSSOM mapping files from `src/fluxnova_bpm_platform/mappings/` to the generated LinkML schema YAML files. Runs automatically after every `gen-schema` / `gen-bpmn-model` / `gen-all` invocation. Key properties:
  - Reads all `fluxnova-*.sssom.tsv` files in **sorted filename order** (deterministic).
  - Matches `subject_id` CURIE prefix against each schema's `default_prefix`.
  - Injects/merges `exact_mappings`, `close_mappings`, `broad_mappings`, `narrow_mappings`, and `related_mappings` into classes, slots, class attributes, and enum permissible_values.
  - Updates the `prefixes:` block with any newly referenced namespace URIs.
  - Uses `ruamel.yaml` round-trip parsing — YAML comments and block structure are preserved.
  - **Idempotent**: mapping lists are sorted and deduplicated; files are written only when content changes.
  - Supports `--dry-run` and `--verbose` flags.

### Module Breakdown

#### Platform Modules

| Module | Classes | Description |
| --- | --- | --- |
| `fluxnova_bpm_base` | 5 | ByteArray, MeterLog, Property, SchemaLogEntry, TaskMeterLog + 7 enums |
| `fluxnova_bpm_repository` | 7 | ResourceDefinition (abstract), ProcessDefinition, CaseDefinition, DecisionDefinition, DecisionRequirementsDefinition, FormDefinition, Deployment |
| `fluxnova_bpm_runtime` | 8 | Execution, Task, VariableInstance, EventSubscription, Incident, ExternalTask, CaseExecution, CaseSentryPart |
| `fluxnova_bpm_job` | 3 | Job, JobDefinition, Batch |
| `fluxnova_bpm_identity` | 8 | User, Group, Tenant, Membership, TenantMembership, IdentityLink, IdentityInfo, Authorization |
| `fluxnova_bpm_history` | 17 | HistoricProcessInstance, HistoricActivityInstance, HistoricTaskInstance, HistoricVariableInstance, HistoricDetail, HistoricIdentityLink, HistoricIncident, HistoricJobLog, HistoricBatch, HistoricExternalTaskLog, HistoricDecisionInstance, HistoricDecisionInputInstance, HistoricDecisionOutputInstance, HistoricCaseInstance, HistoricCaseActivityInstance, HistoricScopeInstance (abstract), UserOperationLogEntry |
| `fluxnova_bpm_collaboration` | 3 | Comment, Attachment, Filter |

#### BPMN Model Modules

| Module | Classes | Description |
| --- | --- | --- |
| `fluxnova_bpmn_model_dc` | 3 | Diagram Common (Bounds, Font, Point) |
| `fluxnova_bpmn_model_di` | 12 | Diagram Interchange (Diagram, DiagramElement, Edge, Plane, Shape, Style, Label, and related DI base types) |
| `fluxnova_bpmn_model_instance` | 130 | Core BPMN 2.0 elements (Process, Activity, Task, Gateway, Event, Data objects, etc.) |
| `fluxnova_bpmn_model_bpmndi` | 6 | BPMN Diagram Interchange (BpmnDiagram, BpmnPlane, BpmnShape, BpmnEdge, BpmnLabel, BpmnLabelStyle) |
| `fluxnova_bpmn_model_fluxnova` | 28 | Fluxnova extensions (FluxnovaConnector, FluxnovaFormField, FluxnovaListener, etc.) |

#### Root Schemas

| Schema | Local classes | Role |
| --- | --- | --- |
| `fluxnova_common` | 0 (slots only) | Shared slot definitions (id, tenant_id, revision, …) imported by every module to avoid URI collisions across schemas. |
| `fluxnova_bpm_platform` | 1 | Aggregate root schema importing `fluxnova_common`, all platform modules, and `fluxnova_bpmn_model`; locally defines `FluxnovaPlatformData` as the tree root. Classes tagged `in_subset: [platform, fluxnova_bpm]`. |
| `fluxnova_bpmn_model` | 2 | Aggregate root schema importing all BPMN modules; locally defines `BpmnModelInstance` and `BpmnModelType`. |

### Enums

#### Platform Enums

| Enum | Values |
| --- | --- |
| SuspensionState | ACTIVE, SUSPENDED |
| DelegationState | PENDING, RESOLVED |
| ActivityInstanceState | DEFAULT, SCOPE_COMPLETE, CANCELED, STARTING, ENDING |
| IncidentState | OPEN, DELETED, RESOLVED |
| JobState | CREATED, FAILED, SUCCESSFUL, DELETED |
| EntityState | ACTIVE, SUSPENDED, COMPLETED, EXTERNALLY_TERMINATED, INTERNALLY_TERMINATED |
| AuthorizationType | GLOBAL, GRANT, REVOKE |

#### BPMN Model Enums

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

### Source Data

The transformer reads H2 DDL SQL from 7 files in `engine/src/main/resources/org/finos/fluxnova/bpm/engine/db/create/`:

- `activiti.h2.create.engine.sql` — core runtime and repository tables
- `activiti.h2.create.identity.sql` — identity management tables
- `activiti.h2.create.history.sql` — history tables
- `activiti.h2.create.case.engine.sql` — CMMN case runtime tables
- `activiti.h2.create.case.history.sql` — CMMN case history tables
- `activiti.h2.create.decision.engine.sql` — DMN decision tables
- `activiti.h2.create.decision.history.sql` — DMN decision history tables

### Modular Approach

**BPMN Model API** (`model-api/bpmn-model/`) — included as 6 modular schema files:

- Import structure: `dc` -> `di`; `instance` -> `di`; `bpmndi` -> `di` + `dc`; `fluxnova_extensions` -> `instance`; root `fluxnova_bpmn_model` imports all modules
- Inaccessible cross-module types converted to `range: string` to break circular imports
- 300+ curated slot descriptions using hand-crafted fallbacks + automatic pattern inference
- Full BPMN 2.0 spec compliance with all multiparent inheritance and enumerations

### SQL Column Annotations

Every slot generated from H2 DDL carries an `annotations: {sql_column: COL_NAME_}` entry embedded directly in the LinkML schema. This is the authoritative ORM mapping — no sidecar JSON needed.

Example from `fluxnova_bpm_job.yaml`:

```yaml
slots:
  exception_message:
    range: string
    description: Message of the exception that occurred.
    annotations:
      sql_column: EXCEPTION_MSG_
```

The SQL column name is the ground truth from the H2 DDL; the slot name is the LinkML-idiomatic snake_case representation. Consumers can use `annotations.sql_column` to map back to the database column without any external file.

**MyBatis cross-validation** (`scripts/fluxnova_mybatis_enrichment.py`) parses the 55 MyBatis XML mapping files to verify field names against the DDL-derived slot names. It does not produce any output artifact — it exits non-zero if discrepancies are found:

```bash
python scripts/fluxnova_mybatis_enrichment.py          # pass/fail check
python scripts/fluxnova_mybatis_enrichment.py --verbose # show all field mappings
```

### Subset Enrichment

Both transformer scripts now generate **subsets** for LinkML schema partitioning and documentation:

#### Platform Schema Subsets

The platform schema defines **7 module-level subsets** plus a cross-cutting **model-level subset**:

| Subset | Description |
| --- | --- |
| `base` | Base types and utility entities (ByteArray, Property, Meter, Schema). |
| `repository` | Resource definitions (Process, Case, Decision, Form). |
| `runtime` | Active execution, task, and event instances. |
| `job` | Job and batch management entities. |
| `identity` | Identity and authorization entities (User, Group, Tenant, Role). |
| `history` | Historical snapshots of completed runtime entities. |
| `collaboration` | Collaboration features (Comments, Attachments, Filters). |
| `fluxnova_bpm` | **Cross-cutting:** All Fluxnova BPM platform entities. |

**Usage:**

- Every platform entity is tagged with its **module subset** (e.g., `ByteArray` -> `in_subset: [base, fluxnova_bpm]`).
- Use subsets to filter schema for domain-specific views or documentation generation.
- The root schema `fluxnova_bpm_platform.yaml` declares all subsets so consumers see available partitions.

#### BPMN Model API Subsets

The BPMN schema defines **6 package-level subsets**:

| Subset | Description |
| --- | --- |
| `core_api` | Top-level BPMN API types and enums. |
| `instance` | Core BPMN element interfaces. |
| `bpmndi` | BPMN diagram interchange interfaces and enums. |
| `di` | Generic diagram interchange interfaces. |
| `dc` | Diagram coordinate and bounds interfaces. |
| `fluxnova_extensions` | Fluxnova BPMN extension interfaces. |

**Usage:**

- Each BPMN interface is tagged by its package (e.g., `Process` -> `in_subset: [instance]`).
- Modular schema files declare their own subsets for isolated schema views.
- The root BPMN schema aggregates all subsets from sub-modules.

#### Subset Filename Mapping

Transformer scripts use **filename-based subset assignment**:

- Platform: module name from `fluxnova_bpm_<module>.yaml` -> `<module>` subset (including the top-level `platform` subset for `fluxnova_bpm_platform.yaml`).
- BPMN: package hierarchy (`dc`, `di`, `instance`, `bpmndi`, `fluxnova_extensions`, `core_api`) -> named subsets.

Every generated class carries **two subsets**: its filename-derived module subset and the cross-cutting model subset (`fluxnova_bpm` or `fluxnova_bpmn_model`). This is enforced by a unit test in `tests/test_fluxnova_to_linkml.py`.

This ensures **reproducible, deterministic tagging** without manual configuration.

### Not in Scope

- **REST DTOs** (`engine-rest/`) — API data transfer objects that mirror persistence entities. Excluded to avoid duplication.
- **Java implementation entity sources** — implementation classes under `engine/.../impl/.../entity` are not part of schema generation. A review of representative  entities (`ExecutionEntity`, `TaskEntity`, `CamundaFormDefinitionEntity`, job subclasses such as `TimerEntity`) do not expose additional DDL-backed schema surface beyond the generated model. Most extra fields are transient navigation caches, runtime helpers, or subtype-specific behavior already represented by existing tables/slots.

### Test Coverage

| Test Module | Tests | Description |
| --- | --- | --- |
| `tests/test_fluxnova_to_linkml.py` | 96 | Transformer unit tests (parsing, mapping, generation) |
| `tests/test_schema.py` | 20 | Schema-level lint, generators, structure checks |
| `tests/test_data.py` | 185 | Valid/invalid YAML data files against schema (yaml_loader + linkml-validate); covers BPM + BPMN classes |
| `tests/test_ddl_coverage.py` | 104 | DDL cross-validation: table coverage, column-to-slot, vendor file checks |
| `tests/test_bpmn_model_schema.py` | 4 | BPMN schema file validation, lint, JSON schema generation |
| `tests/test_fluxnova_bpmn_model_to_linkml.py` | 7 | BPMN generator unit tests (discovery, headers, coverage, inheritance, serialization) |
| **Total** | **409** | All passing |

#### Vendor Test Data

33 vendor-data YAML files in `tests/data/valid/*-vendor.yaml` derived from
`engine-rest/.../helper/MockProvider.java` constants. These exercise the schema with the same values the upstream BPM engine uses in its own REST API tests.

13 invalid YAML files in `tests/data/invalid/` test rejection of:

- Missing required fields (id, event_time, query)
- Invalid enum values (suspension_state, state)
- Wrong types (string where integer/float/boolean expected, bad timestamps)

#### BPMN Model Test Data

Valid: `Point-001.yaml`, `Bounds-001.yaml`, `Font-001.yaml` exercise the cross-schema integration where `fluxnova_bpm_platform.yaml` imports `fluxnova_bpmn_model.yaml`. Invalid counterparts (`Point-bad-type.yaml`, `Font-bad-bool.yaml`) verify that the platform-level `linkml-validate` correctly rejects bad data on imported BPMN classes.

### Regeneration

#### Platform Schema (H2 DDL  -> LinkML)

```bash
# Regenerate all platform schemas from H2 DDL sources, then overlay SSSOM mappings
python scripts/fluxnova_to_linkml.py

# Or via justfile (overlay runs automatically after generation)
just gen-schema

# Dry-run (report only, no files written)
just gen-schema --dry-run

# Apply SSSOM mappings without regenerating schemas
just overlay-sssom-mappings

# Dry-run the overlay only
just overlay-sssom-mappings --dry-run --verbose
```

#### Full reproducibility gate

```bash
# Regenerate everything (BPMN model + platform), lint, cross-validate, and test transformers
just verify-schema

# Individual recipes
just gen-all                    # gen-bpmn-model + gen-schema + overlay-sssom-mappings
just overlay-sssom-mappings     # apply SSSOM mappings to generated schemas (idempotent)
just lint-schema                # linkml-lint over src/fluxnova_bpm_platform/schema/
just validate-mybatis           # MyBatis ↔ DDL field-name cross-validation
just test-transformers          # focused pytest scope (transformer + schema tests)
```

#### MyBatis Cross-Validation (optional)

```bash
# Validate MyBatis field names against DDL-derived slot names
python scripts/fluxnova_mybatis_enrichment.py
# SQL column↔slot annotations are already embedded in generated schemas
```

#### BPMN Model API Schema (Java interfaces  -> LinkML)

```bash
# Regenerate BPMN schemas from BPMN Model API sources
python scripts/fluxnova_bpmn_model_to_linkml.py

# Output: 6 modular YAML files in src/fluxnova_bpm_platform/schema/
#   - fluxnova_bpmn_model.yaml (root)
#   - fluxnova_bpmn_model_{dc,di,instance,bpmndi,fluxnova}.yaml (modules)
```

#### Validation

```bash
# Lint all schemas (focused on schema dir)
just lint-schema

# Run full test suite
just test
# or directly:
pytest tests/ -v
```

### SSSOM Mappings

All ontology/standard cross-walk mappings are stored as [SSSOM](https://mapping-commons.github.io/sssom/) v0.9 TSV files in `src/fluxnova_bpm_platform/mappings/`.

#### Coverage — 26 mapping files (4 451 element mappings)

| File | Rows | Covers |
| --- | --- | --- |
| `fluxnova-attack.sssom.tsv` | 325 | MITRE ATT&CK |
| `fluxnova-capec.sssom.tsv` | 14 | MITRE CAPEC |
| `fluxnova-cis-controls.sssom.tsv` | 37 | CIS Controls v8 |
| `fluxnova-common-domain-model.sssom.tsv` | 659 | FINOS CDM (merged from 23 sub-schemas) |
| `fluxnova-cra.sssom.tsv` | 99 | EU Cyber Resilience Act |
| `fluxnova-cve.sssom.tsv` | 61 | MITRE CVE |
| `fluxnova-cwe.sssom.tsv` | 25 | MITRE CWE |
| `fluxnova-cyberinfra.sssom.tsv` | 8 | Cyber Infrastructure |
| `fluxnova-d3fend.sssom.tsv` | 7 523 | MITRE D3FEND |
| `fluxnova-generic.sssom.tsv` | 1 530 | Generic/cross-cutting concepts |
| `fluxnova-gist.sssom.tsv` | 40 | Semantic Arts GIST (merged from 4 sub-schemas) |
| `fluxnova-iso27001.sssom.tsv` | 14 | ISO/IEC 27001 |
| `fluxnova-iso29100.sssom.tsv` | 58 | ISO/IEC 29100 (Privacy) |
| `fluxnova-kev-catalog.sssom.tsv` | 58 | CISA KEV Catalog |
| `fluxnova-mcp.sssom.tsv` | 10 | Model Context Protocol |
| `fluxnova-nist-csf-v2.sssom.tsv` | 22 | NIST CSF v2 |
| `fluxnova-nist-nvd.sssom.tsv` | 63 | NIST NVD |
| `fluxnova-nist-sp-800-171.sssom.tsv` | 10 | NIST SP 800-171 |
| `fluxnova-nist-sp-800-218.sssom.tsv` | 10 | NIST SP 800-218 (SSDF) |
| `fluxnova-nist-sp-800-53.sssom.tsv` | 10 | NIST SP 800-53 |
| `fluxnova-ocsf.sssom.tsv` | 124 | OCSF (merged from 4 sub-schemas) |
| `fluxnova-oscal.sssom.tsv` | 10 | NIST OSCAL |
| `fluxnova-slsa.sssom.tsv` | 10 | SLSA Supply-Chain Security |
| `fluxnova-spdx.sssom.tsv` | 10 | SPDX (Software Package Data Exchange) |
| `fluxnova-stix.sssom.tsv` | 58 | OASIS STIX 2.1 |
| `fluxnova-vulnerability-core.sssom.tsv` | 30 | Vulnerability Core ontology |

#### Key Namespaces

| Prefix | URI |
| --- | --- |
| `common_domain_model:` | `https://w3id.org/lmodel/common-domain-model/` |
| `gist:` | `https://w3id.org/lmodel/gist/` |
| `ocsf:` | `https://w3id.org/lmodel/ocsf/` |
| `d3f:` | `https://d3fend.mitre.org/ontologies/d3fend.owl#` |
| `attack:` | `https://w3id.org/lmodel/attack/` |

#### Overlay Integration

`scripts/overlay_sssom.py` reads the mapping files and injects `*_mappings` / `prefixes` entries into the generated LinkML YAML files. It is called automatically as part of every schema generation recipe:

```
gen-schema      → fluxnova_to_linkml.py   → overlay_sssom.py
gen-bpmn-model  → bpmn_model_to_linkml.py → overlay_sssom.py
gen-all         → gen-bpmn-model + gen-schema + overlay_sssom.py (final dedup pass)
```

Predicate mapping from SSSOM to LinkML:

| SSSOM predicate | LinkML field |
| --- | --- |
| `skos:exactMatch` | `exact_mappings` |
| `skos:closeMatch` | `close_mappings` |
| `skos:broadMatch` | `broad_mappings` |
| `skos:narrowMatch` | `narrow_mappings` |
| `skos:relatedMatch` | `related_mappings` |
