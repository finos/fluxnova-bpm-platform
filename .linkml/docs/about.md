# About fluxnova-bpm-platform

This page says where the [LinkML](https://linkml.io) schema's modules come from, how each renders its source, and what the model leaves out.

## Where it comes from

Fluxnova is FINOS's BPM platform, grown from Camunda 7. The schema renders the release 3.1.1: every file the converters read from FINOS's tree is byte for byte the file at the tag `v3.1.1`, and `scripts/upstream_pins.tsv` lists them. FINOS's tree is merged from its main branch, and the files the converters read on that branch are the release's.

## The modules

| Module | Written from | Holds |
| --- | --- | --- |
| `fluxnova_bpm_engine` | the engine's H2 DDL and its Java API's Javadoc | one class per table, `FluxnovaExecution` for `ACT_RU_EXECUTION` and so on |
| `fluxnova_bpmn_core` | | `BpmnModelElementInstance`, the base of every BPMN class |
| `fluxnova_bpmn_dc`, `_di`, `_bpmndi` | the model API's diagram types | bounds, shapes, edges and BPMN diagrams |
| `fluxnova_bpmn_semantic` | the model API's BPMN 2.0 types | `BpmnDefinitions`, `BpmnProcess`, `BpmnUserTask` and the rest |
| `fluxnova_bpmn_extension` | the model API's extension types | `FluxnovaFormField`, `FluxnovaInputParameter` and the rest |
| `fluxnova_bpm_platform` | | the umbrella, with `FluxnovaPlatformData` as its root |

## The engine's tables

- **Columns.** Each column is a slot, required when the column is not null, and a table's one-column key `ID_` is the class's identifier. A table with a composite key states it as a unique key. The lock counter `REV_` is left out.
- **Foreign keys.** A column the DDL makes a foreign key ranges over the class of the table it refers to. The history tables have none, so their ids stay strings.
- **States.** Where a column holds the engine's text values, such as a historic process instance's `STATE_`, an enum lists them. Where it holds the engine's integer codes, such as `SUSPENSION_STATE_`, it stays an integer bounded by the codes, and a comment names each code.
- **Descriptions.** A class's or slot's description is the first sentence of its Javadoc where the Java API has one, and this project's otherwise.
- **Areas.** The subsets `engine_repository`, `engine_runtime`, `engine_history` and the rest group the tables.

## The BPMN elements

- **Elements and attributes.** Each element type the model API registers is a class, with its parent, its attributes and its child elements as the API states them: required, defaults and how many. The annotations `xml_name` and `xml_namespace` keep each element's and attribute's XML name.
- **References.** A reference to another element, by id or QName, is a string whose `refers_to` annotation names the class it points to, since BPMN lets an element have no id.
- **Polymorphic children.** A process's flow elements range over `BpmnFlowElement`, and `element_type` names each child's class.
- **Text.** `text_content` holds an element's text where the BPMN XML Schema included with the model API gives the element mixed content, and on the extension elements the engine reads as text.
- **Names.** An attribute in Fluxnova's extension namespace carries the `fluxnova_` prefix, and a slot whose name LOKF defines, such as `id` or `documentation`, the `bpmn_` prefix. An assignment's `from` and `to` are `from_expression` and `to_expression`.
- **Extensions.** `extensionElements` holds any element, as BPMN's schema has it.
- **Descriptions** are this project's own, in `scripts/bpmn_descriptions.yaml`.

## What is left out

- **The engine's computed columns**, such as the configuration table's `TENANT_ID_NULL_`, which the database derives for an index.
- **CMMN and DMN models**, which the engine also reads. Their tables are in the schema, and their models are not.
- **The rest of Fluxnova**: the engine's behaviour, the REST API, the web applications and the rest of FINOS's tree.
