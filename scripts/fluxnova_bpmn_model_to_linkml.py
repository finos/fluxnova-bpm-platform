#!/usr/bin/env python3
"""Generate a LinkML schema for the Fluxnova BPMN Model API.

The generator treats the public BPMN metamodel as the source of truth:
- top-level BPMN enums plus selected public interfaces
- BPMN instance interfaces in core and subpackages
- Fluxnova BPMN extension interfaces

Builders, implementation classes, parser utilities, and generic query helpers are
excluded because they are construction/runtime APIs rather than metamodel types.
"""

from __future__ import annotations

import argparse
import re
from collections import OrderedDict
from dataclasses import dataclass, field
from pathlib import Path

from fluxnova_to_linkml import (
    _clean_javadoc,
    _repo_relative,
    read_project_version,
    write_yaml,
    SHARED_SLOTS,
    COMMON_SCHEMA_NAME,
)


REPO_ROOT = Path(__file__).resolve().parent.parent
DEFAULT_SOURCE_ROOT = (
    REPO_ROOT / "model-api/bpmn-model/src/main/java/org/finos/fluxnova/bpm/model/bpmn"
)
DEFAULT_OUTPUT_PATH = REPO_ROOT / "src/fluxnova_bpm_platform/schema/fluxnova_bpmn_model.yaml"
DEFAULT_MODULE_POM_PATH = REPO_ROOT / "model-api/bpmn-model/pom.xml"

SCALAR_TYPES: dict[str, str] = {
    "String": "string",
    "string": "string",
    "boolean": "boolean",
    "Boolean": "boolean",
    "int": "integer",
    "Integer": "integer",
    "long": "integer",
    "Long": "integer",
    "double": "float",
    "Double": "float",
    "float": "float",
    "Float": "float",
}

TOP_LEVEL_INCLUDED_INTERFACES = {"BpmnModelInstance", "BpmnModelType"}
TOP_LEVEL_EXCLUDED_TYPES = {"Bpmn", "BpmnModelException", "Query"}
COLLECTION_TYPES = {"Collection", "List", "Set"}
SLOT_URI_MAP = {
    "id": "schema:identifier",
    "name": "schema:name",
}
PACKAGE_SUBSETS = OrderedDict([
    ("core_api", "Top-level BPMN API types and enums."),
    ("instance", "Core BPMN element interfaces."),
    ("bpmndi", "BPMN diagram interchange interfaces and enums."),
    ("di", "Generic diagram interchange interfaces."),
    ("dc", "Diagram coordinate and bounds interfaces."),
    ("fluxnova_extensions", "Fluxnova BPMN extension interfaces."),
])

# Cross-cutting model-level subset (analogous to fluxnova_bpm in the platform schema).
BPMN_MODEL_SUBSET = "fluxnova_bpmn_model"
BPMN_MODEL_SUBSET_DESCRIPTION = "All Fluxnova BPMN Model API types."

# ---------------------------------------------------------------------------
# Modular schema configuration
# ---------------------------------------------------------------------------

# subset name -> module file stem (without .yaml)
MODULE_FILE_NAMES: dict[str, str] = {
    "core_api": "fluxnova_bpmn_model",          # root schema
    "instance": "fluxnova_bpmn_model_instance",
    "bpmndi": "fluxnova_bpmn_model_bpmndi",
    "di": "fluxnova_bpmn_model_di",
    "dc": "fluxnova_bpmn_model_dc",
    "fluxnova_extensions": "fluxnova_bpmn_model_fluxnova",
}

# Module processing order (most abstract first -> avoids slot duplication)
MODULE_PROCESSING_ORDER = ["dc", "di", "instance", "bpmndi", "fluxnova_extensions", "core_api"]

# Per-module LinkML import lists (the root module imports all others).
# Every module imports ``./fluxnova_common`` because SHARED_SLOTS (id, name,
# category, message, properties, source, type, value) are defined there to
# avoid URI collisions with the BPM persistence schema.
MODULE_IMPORTS: dict[str, list[str]] = {
    "dc": ["linkml:types", f"./{COMMON_SCHEMA_NAME}"],
    "di": ["linkml:types", f"./{COMMON_SCHEMA_NAME}", "./fluxnova_bpmn_model_dc"],
    "instance": ["linkml:types", f"./{COMMON_SCHEMA_NAME}", "./fluxnova_bpmn_model_di"],
    # bpmndi imports di and dc; cross-refs to instance types use range: string
    # to avoid a circular dependency (instance does not import bpmndi).
    "bpmndi": [
        "linkml:types",
        f"./{COMMON_SCHEMA_NAME}",
        "./fluxnova_bpmn_model_di",
        "./fluxnova_bpmn_model_dc",
    ],
    "fluxnova_extensions": [
        "linkml:types",
        f"./{COMMON_SCHEMA_NAME}",
        "./fluxnova_bpmn_model_instance",
    ],
    "core_api": [
        "linkml:types",
        f"./{COMMON_SCHEMA_NAME}",
        "./fluxnova_bpmn_model_dc",
        "./fluxnova_bpmn_model_di",
        "./fluxnova_bpmn_model_instance",
        "./fluxnova_bpmn_model_bpmndi",
        "./fluxnova_bpmn_model_fluxnova",
    ],
}

# BPMN classes whose names collide with BPM persistence classes. We rename
# them in the LinkML output (the underlying Java interface name is preserved
# in the ``annotations.source_file`` metadata) so that the platform root
# schema can import both schemas without "Conflicting URIs ... for item: X"
# errors during gen-project / gen-python.
CLASS_RENAMES: dict[str, str] = {
    "Group": "BpmnGroup",
    "Property": "BpmnProperty",
    "Task": "BpmnTask",
}


def _rename_class(name: str) -> str:
    """Apply :data:`CLASS_RENAMES` to a class name (idempotent for non-mapped names)."""
    return CLASS_RENAMES.get(name, name)

# Modules accessible (directly or transitively via imports) from each module.
# Any type whose home module is NOT in this set will have its range
# replaced with "string" to avoid undeclared-range errors.
MODULE_ACCESSIBLE_MODULES: dict[str, frozenset[str]] = {
    "dc": frozenset({"dc"}),
    "di": frozenset({"di", "dc"}),
    # instance imports di (→dc); bpmndi is NOT imported to break the cycle.
    "instance": frozenset({"instance", "di", "dc"}),
    # bpmndi imports di and dc; instance is NOT imported to break the cycle.
    "bpmndi": frozenset({"bpmndi", "di", "dc"}),
    # fluxnova imports instance (→di→dc); bpmndi is NOT in scope.
    "fluxnova_extensions": frozenset({"fluxnova_extensions", "instance", "di", "dc"}),
    # root imports everything.
    "core_api": frozenset({
        "core_api", "instance", "bpmndi", "di", "dc", "fluxnova_extensions"
    }),
}

# ---------------------------------------------------------------------------
# Description generation for BPMN slots and classes
# ---------------------------------------------------------------------------

# Hand-crafted descriptions for the most important BPMN slots (used when
# the Java source has no Javadoc for the getter).
BPMN_SLOT_DESCRIPTIONS: dict[str, str] = {
    # Identity / navigation
    "id": "Unique identifier of this BPMN element.",
    "name": "Human-readable name of this element.",
    "documentation": "Human-readable documentation attached to this element.",
    "extension_elements": "Extension elements holding vendor-specific metadata.",
    "diagram_element": "The diagram element that visually represents this BPMN element.",
    # Geometry (DC package)
    "x": "X coordinate (horizontal offset) of this element's bounds.",
    "y": "Y coordinate (vertical offset) of this element's bounds.",
    "width": "Width of this element's bounding rectangle.",
    "height": "Height of this element's bounding rectangle.",
    # Font (DC package)
    "bold": "Whether the font is rendered in bold.",
    "italic": "Whether the font is rendered in italic.",
    "underline": "Whether the font is underlined.",
    "strike_through": "Whether the font has a strike-through decoration.",
    "size": "Font size in points.",
    # DI package
    "bounds": "Bounding rectangle giving position and size of this diagram element.",
    "waypoints": "Ordered list of waypoints defining the visual path of this edge.",
    "extension": "Extension element containing additional diagram information.",
    "style": "The visual style applied to this diagram element.",
    "owns_style": "A style definition owned exclusively by this diagram element.",
    "shared_style": "A shared style referenced by multiple diagram elements.",
    "label": "The label associated with this diagram element.",
    "diagram_elements": "All diagram elements contained within this plane.",
    # BPMNDI package
    "bpmn_plane": "The plane element containing the shapes and edges of this diagram.",
    "bpmn_label": "The label element attached to this shape or edge.",
    "bpmn_label_styles": "Label style definitions available in this BPMN diagram.",
    "bpmn_label_style": "The label style applied to this BPMN label.",
    "bpmn_element": "The BPMN model element this diagram element represents.",
    "bpm_diagrams": "BPMN diagram elements (BPMNDiagram) in the root definitions.",
    "choreography_activity_shape": "Shape of the associated choreography activity.",
    "horizontal": "Whether this pool or lane is oriented horizontally.",
    "expanded": "Whether this sub-process shape is shown in expanded form.",
    "marker_visible": "Whether the loop or multi-instance marker is displayed.",
    "message_visible": "Whether the message flow envelope icon is visible.",
    "participant_band_kind": "Indicates the initiating/non-initiating role of this participant band.",
    "message_visible_kind": "Visibility kind of the message flow in this edge.",
    # Sequence flow
    "incoming": "Sequence flows entering this flow node.",
    "outgoing": "Sequence flows leaving this flow node.",
    "source_ref": "The source element of this connection.",
    "target_ref": "The target element of this connection.",
    "condition_expression": "Expression evaluated to decide whether this flow is taken.",
    "condition": "Condition guard expression.",
    "default": "Default sequence flow taken when no other outgoing condition is satisfied.",
    # Activity
    "io_specification": "Input and output specification of this activity.",
    "loop_characteristics": "Loop or multi-instance characteristics of this activity.",
    "data_input_associations": "Data associations that feed input data into this activity.",
    "data_output_associations": "Data associations that move output data out of this activity.",
    "resource_roles": "Resources (performers, potential owners) assigned to this activity.",
    "for_compensation": "Whether this activity is used for compensation handling.",
    "start_quantity": "Minimum number of tokens required to start this activity.",
    "completion_quantity": "Number of tokens produced when this activity completes.",
    "properties": "Local data properties scoped to this element.",
    # Multi-instance
    "loop_cardinality": "Expression evaluating to the number of loop iterations.",
    "completion_condition": "Condition that, when true, terminates remaining instances.",
    "is_sequential": "Whether instances execute sequentially rather than in parallel.",
    "behavior": "Behavior governing how completion events are thrown.",
    "complex_behavior_definitions": "Rules defining complex multi-instance completion behavior.",
    "input_data_item": "Loop input data item variable.",
    "output_data_item": "Loop output data item variable.",
    # Gateway
    "gateway_direction": "Convergence/divergence direction of token routing through this gateway.",
    "activation_condition": "Condition that activates this complex gateway.",
    # Events
    "event_definitions": "Event definitions that specify the event trigger type.",
    "parallel_multiple": "Whether all event triggers must occur (parallel) rather than any one.",
    "cancel_activity": "Whether the boundary event cancels the host activity when triggered.",
    "attached_to": "The activity to which this boundary event is attached.",
    "interrupting": "Whether this start event interrupts the parent sub-process.",
    # Data
    "data_state": "Current state of this data object or data store reference.",
    "data_object": "The data object that this reference points to.",
    "data_store": "The data store that this reference points to.",
    "item_definition": "Item definition describing the structure of this data element.",
    "is_collection": "Whether this element represents a collection of items.",
    "data_inputs": "Input data elements of this specification.",
    "data_outputs": "Output data elements of this specification.",
    "input_sets": "Input sets grouping required input data.",
    "output_sets": "Output sets grouping produced output data.",
    "input_set": "The input set associated with this input data.",
    "output_set": "The output set associated with this output data.",
    "data_input_refs": "Required input data references for this input set.",
    "data_output_refs": "Produced output data references for this output set.",
    "optional_input_refs": "Optional (non-required) input data references.",
    "while_executing_input_refs": "Input data available during execution but not required to start.",
    "while_executing_output_refs": "Output data produced during execution before completion.",
    "optional_output_refs": "Output data that may or may not be produced.",
    "data_path": "XPath expression navigating to the relevant data node.",
    # Definitions (root element)
    "definitions": "The root BPMN Definitions element of this model.",
    "target_namespace": "Namespace URI for elements defined in this document.",
    "expression_language": "Default expression language used in this definitions element.",
    "type_language": "Default type language used for item definitions.",
    "exporter": "Name of the tool that exported this BPMN document.",
    "exporter_version": "Version of the exporting tool.",
    "root_elements": "Top-level elements (processes, messages, signals, etc.) in this definitions.",
    "diagrams": "BPMN diagrams contained in this definitions element.",
    "imports": "Import declarations referencing external definitions.",
    "relationships": "Informal relationships between elements in this model.",
    "extensions": "Extension elements attached to this definitions element.",
    # Process
    "process_type": "Whether this process is a public, private, or collaboration process.",
    "is_closed": "Whether this process forbids additional participants.",
    "is_executable": "Whether this process can be executed by a process engine.",
    "flow_elements": "Flow elements (tasks, gateways, events, sequence flows) in this process.",
    "lane_sets": "Lane sets partitioning this process into swimlanes.",
    "artifacts": "Artifacts (text annotations, groups, associations) in this process.",
    "correlation_subscriptions": "Correlation subscriptions associated with this process.",
    "supports": "Interfaces that this process is declared to support.",
    # Collaboration
    "participants": "Participants (pools) in this collaboration.",
    "message_flows": "Message flows between participants in this collaboration.",
    "conversation_nodes": "Conversation nodes in this collaboration.",
    "conversation_links": "Links between conversation nodes.",
    "conversation_associations": "Associations linking conversation nodes to other elements.",
    "participant_associations": "Associations between participants.",
    "message_flow_associations": "Associations between message flows.",
    "correlation_keys": "Correlation keys used to correlate messages in this collaboration.",
    # Conversation
    "correlation_keys_refs": "Correlation keys scoped to this conversation node.",
    "sub_conversations": "Nested conversations within this sub-conversation.",
    "called_collaboration": "The collaboration element called by this call conversation.",
    # Participant
    "process_ref": "The process element that this participant represents.",
    "interface_refs": "Interfaces supported by the process of this participant.",
    "end_point_refs": "Endpoints associated with this participant.",
    "participant_multiplicity": "Multiplicity configuration of this participant.",
    "minimum": "Minimum number of instances for this participant multiplicity.",
    "maximum": "Maximum number of instances for this participant multiplicity.",
    # Lane
    "lanes": "Sub-lanes contained in this lane.",
    "child_lane_set": "The child lane set contained within this lane.",
    "flow_node_refs": "Flow nodes allocated to this lane.",
    "partition_element": "The partitioning element (e.g. performer) represented by this lane.",
    # Interface / Operation
    "operations": "Operations defined by this interface.",
    "in_message_ref": "The input message for this operation.",
    "out_message_ref": "The output message for this operation.",
    "error_refs": "Error elements that this operation may throw.",
    "io_binding": "Input/output binding of this operation.",
    "operation_ref": "The operation this binding refers to.",
    "in_message_ref_binding": "The input message binding.",
    "out_message_ref_binding": "The output message binding.",
    # Correlation
    "correlation_property": "The correlation property this binding is based on.",
    "data_path_ref": "The formal expression locating the correlation value in a message.",
    "retrieval_expression_list": "Expressions used to retrieve the correlation value.",
    "correlation_property_retrieval_expressions": "Retrieval expressions for this correlation property.",
    "correlation_property_bindings": "Bindings mapping correlation properties to data paths.",
    "correlation_properties": "Correlation properties defined in this collaboration.",
    "correlation_key": "Correlation key grouping correlation properties.",
    # Resource
    "resource_ref": "The resource element referenced by this role.",
    "resource_parameter_bindings": "Bindings assigning values to resource parameters.",
    "resource_assignment_expression": "Expression used to resolve the assigned resource.",
    "resource_parameters": "Parameters defined on this resource.",
    "is_required": "Whether this resource parameter is required.",
    # Call activity
    "called_element": "The global task or process called by this call activity.",
    # Message / Signal / Error / Escalation
    "message_ref": "The message element associated with this event or operation.",
    "signal_ref": "The signal element that triggers or is thrown by this event.",
    "error_ref": "The error element associated with this error event definition.",
    "escalation_ref": "The escalation element associated with this escalation event definition.",
    "error_code": "The error code identifying this error.",
    "escalation_code": "The escalation code identifying this escalation.",
    "item_ref": "The item definition for this message or signal.",
    "structure_ref": "The item definition describing the data structure.",
    # Timer
    "time_date": "Specific date and time at which this timer fires.",
    "time_duration": "Duration expression for this timer.",
    "time_cycle": "Repeating cycle expression for this timer.",
    # Link
    "target": "The catching link event that receives this link.",
    "sources": "The throwing link events that send to this link target.",
    # Compensate
    "activity_ref": "The activity element that performs compensation.",
    "wait_for_completion": "Whether to wait for the compensation to complete.",
    # Rendering
    "rendering_refs": "Rendering elements referenced by this event definition.",
    # Relationship
    "sources_refs": "Source elements of this informal relationship.",
    "targets_refs": "Target elements of this informal relationship.",
    "direction": "Direction of this relationship.",
    # Categories
    "category_values": "Category values contained in this category.",
    "category_value_refs": "Category values associated with this flow element.",
    "value": "The text value of this category value.",
    "category": "The category that contains this category value.",
    "categories": "Categories defined in this definitions element.",
    # Text / Documentation
    "text": "Textual content of this element.",
    "text_format": "MIME type or format of the documentation text.",
    # Assignment
    "assignments": "Data assignments (from/to) within this data association.",
    "from_": "The source expression of this assignment.",
    "to_": "The target expression of this assignment.",
    "transformation": "Transformation expression applied during data association.",
    # Monitoring / Auditing
    "monitoring": "Monitoring information attached to this flow element.",
    "auditing": "Auditing information attached to this flow element.",
    # Performer / HumanPerformer
    # (resource roles - already covered)
    # IoBinding
    "input_data_ref": "Input data reference for this IO binding.",
    "output_data_ref": "Output data reference for this IO binding.",
    # EndPoint
    "end_points": "Endpoints associated with this process or service.",
    # Rendering
    "renderings": "Rendering hints for this event.",
    # Misc
    "called_collaboration_ref": "Reference to the called collaboration.",
    "capacity": "Maximum number of items this data store can hold.",
    "is_unlimited": "Whether the data store capacity is unbounded.",
    "script": "Script code of this script task.",
    "script_format": "MIME type or language of the script (e.g. application/javascript).",
    "implementation": "Implementation technology of this service or send/receive task.",
    "instantiate": "Whether receiving this message creates a new process instance.",
    "ordering": "Sequential or parallel ordering of output set production.",
    # BpmnModelInstance
    "model_element_instance": "The root Definitions element of this BPMN model instance.",
    # Fluxnova extensions
    "fluxnova_async_before": "Whether this element is executed asynchronously before its start.",
    "fluxnova_async_after": "Whether this element is executed asynchronously after its end.",
    "fluxnova_exclusive": "Whether this element participates in an exclusive job execution.",
    "fluxnova_job_priority": "Priority assigned to async continuation jobs for this element.",
    "fluxnova_async": "Deprecated: use fluxnova_async_before instead.",
    "fluxnova_caller_id": "Identifier of the calling connector.",
    "fluxnova_class": "Fully-qualified Java class implementing this element.",
    "fluxnova_delegate_expression": "Expression resolving to a JavaDelegate.",
    "fluxnova_expression": "EL expression for this element.",
    "fluxnova_result_variable": "Process variable to store the expression result.",
    "fluxnova_topic": "External task topic name.",
    "fluxnova_type": "Type name for this form field or listener.",
    "fluxnova_event": "Event that triggers this execution listener.",
    "fluxnova_script": "Inline script for this element.",
    "fluxnova_resource": "Script resource path or identifier.",
    "fluxnova_string": "Inline string value.",
    "fluxnova_map": "Map of key-value pairs.",
    "fluxnova_list": "List of values.",
    "fluxnova_id": "Identifier for this Fluxnova extension element.",
    "fluxnova_label": "Display label for this form field.",
    "fluxnova_date_pattern": "Date pattern for date-typed form fields.",
    "fluxnova_default_value": "Default value for this form field.",
    "fluxnova_name": "Name attribute of this Fluxnova extension element.",
    "fluxnova_value": "Value of this Fluxnova extension element.",
    "fluxnova_properties": "Fluxnova extension properties container.",
    "fluxnova_validation": "Validation rules for this form field.",
    "fluxnova_values": "Permissible value options for this form field.",
    "fluxnova_constraints": "Validation constraints for this form field.",
    "fluxnova_entries": "Key-value entries in this Fluxnova map.",
    "fluxnova_fields": "Field elements of this connector or form.",
    "fluxnova_input_output": "Input/output parameter container for this connector.",
    "fluxnova_input_parameters": "Input parameters passed to this connector or script.",
    "fluxnova_output_parameters": "Output parameters produced by this connector or script.",
    "fluxnova_form_data": "Form data container for this user task or start event.",
    "fluxnova_form_fields": "Form fields defined in this form data.",
    "fluxnova_form_properties": "Deprecated form property definitions.",
    "fluxnova_execution_listener": "Execution listener attached to this element.",
    "fluxnova_execution_listeners": "Execution listeners attached to this element.",
    "fluxnova_task_listeners": "Task listeners attached to this user task.",
    "fluxnova_potential_starter": "Fluxnova potential starter definition for this process.",
    "fluxnova_potential_starters": "Potential starters allowed to initiate this process.",
    "fluxnova_failed_job_retry_time_cycle": "Retry cycle expression for failed asynchronous jobs.",
    "fluxnova_connector_id": "The unique identifier of this connector configuration.",
    "fluxnova_in": "Variable mapping for incoming variables.",
    "fluxnova_in_list": "Incoming variable mapping elements.",
    "fluxnova_out": "Variable mapping for outgoing variables.",
    "fluxnova_out_list": "Outgoing variable mapping elements.",
    "fluxnova_error_event_definition": "Fluxnova-specific error event definition.",
    "fluxnova_error_event_definitions": "Fluxnova error event definitions on this end event.",
    "fluxnova_error_code_variable": "Process variable to receive the error code.",
    "fluxnova_error_message_variable": "Process variable to receive the error message.",
}

# Hand-crafted descriptions for BPMN classes that lack Javadoc.
BPMN_CLASS_DESCRIPTIONS: dict[str, str] = {
    "BpmnModelInstance": "Root container for a parsed BPMN model, providing access to the Definitions element.",
    "BpmnModelType": "Enumeration-like interface representing the BPMN model type.",
    "Category": "A named grouping used to categorise BPMN elements via CategoryValue references.",
    "FluxnovaErrorEventDefinition": "Fluxnova extension that augments an end event error definition with engine-specific variables.",
    "Group": "An artifact that visually groups flow elements without affecting the process semantics.",
    "Transaction": "A sub-process that executes as an atomic unit with compensation support.",
}


def _generate_bpmn_slot_description(slot_name: str, range_type: str, multivalued: bool) -> str:
    """Generate a meaningful description for a BPMN slot when Javadoc is absent."""
    # Check hand-crafted dict first
    if slot_name in BPMN_SLOT_DESCRIPTIONS:
        return BPMN_SLOT_DESCRIPTIONS[slot_name]

    humanized = _humanize_symbol(slot_name)
    human_lower = humanized.lower()

    # Fluxnova extension pattern
    if slot_name.startswith("fluxnova_"):
        property_name = _humanize_symbol(slot_name[len("fluxnova_"):]).lower()
        return f"Fluxnova extension property: {property_name}."

    # Boolean flag patterns
    if slot_name.startswith("is_") or range_type == "boolean":
        subject = slot_name[3:] if slot_name.startswith("is_") else slot_name
        return f"Whether {_humanize_symbol(subject).lower()}."

    # Collection/multivalued slots
    if multivalued:
        if range_type not in SCALAR_TYPES.values():
            type_label = _humanize_symbol(range_type).lower()
            return f"Collection of {type_label} elements associated with this element."
        return f"Collection of {human_lower} values."

    # Object reference slots
    if range_type not in SCALAR_TYPES.values():
        return f"The {human_lower} of this element."

    # Scalar fallback
    return f"The {human_lower} of this element."


def _generate_bpmn_class_description(class_name: str, parents: list[str], package: str) -> str:
    """Generate a description for a BPMN class when Javadoc is absent."""
    if class_name in BPMN_CLASS_DESCRIPTIONS:
        return BPMN_CLASS_DESCRIPTIONS[class_name]

    humanized = _humanize_symbol(class_name)

    # Package-based context
    if package.endswith(".instance.dc"):
        return f"DC {humanized} element representing diagram coordinate or styling information."
    if package.endswith(".instance.di"):
        return f"DI {humanized} element representing a generic diagram interchange construct."
    if package.endswith(".instance.bpmndi"):
        return f"BPMNDI {humanized} element used in BPMN diagram interchange."
    if package.endswith(".instance.fluxnova"):
        return f"Fluxnova extension element: {humanized}."

    # Structural patterns
    if "EventDefinition" in class_name:
        event_type = class_name.replace("EventDefinition", "").replace("Impl", "")
        return f"Event definition for a {_humanize_symbol(event_type).lower()} trigger."
    if class_name.endswith("Event") or class_name.endswith("EventImpl"):
        return f"BPMN {humanized} element representing an event in a process flow."
    if class_name.endswith("Gateway"):
        return f"BPMN {humanized} controlling the divergence or convergence of token flow."
    if class_name.endswith("Task"):
        return f"BPMN {humanized} representing a unit of work in a process."
    if class_name.endswith("SubProcess"):
        return f"BPMN {humanized} embedding a process within another process."

    return f"BPMN {humanized} element."

RE_DECLARATION = re.compile(
    r"public\s+(interface|enum|class)\s+(\w+)(?:\s+extends\s+([^\{]+))?",
    re.MULTILINE,
)
RE_JAVADOC = re.compile(r"/\*\*(.*?)\*/", re.DOTALL)
RE_METHOD = re.compile(
    r"(?:/\*\*(?P<javadoc>.*?)\*/\s*)?"
    r"(?:@\w+(?:\([^)]*\))?\s*)*"
    r"(?P<return>[\w<>, ?\.\[\]]+)\s+"
    r"(?P<name>\w+)\s*\((?P<args>[^)]*)\)\s*;",
    re.DOTALL,
)


@dataclass
class ParsedMethod:
    slot_name: str
    java_type: str
    range: str
    multivalued: bool = False
    description: str = ""


@dataclass
class ParsedInterface:
    name: str
    package: str
    relative_path: str
    description: str = ""
    parents: list[str] = field(default_factory=list)
    methods: list[ParsedMethod] = field(default_factory=list)


@dataclass
class ParsedEnum:
    name: str
    package: str
    relative_path: str
    description: str = ""
    values: list[str] = field(default_factory=list)


@dataclass
class SlotSpec:
    range: str
    multivalued: bool = False
    description: str = ""
    slot_uri: str = ""


@dataclass
class SourceFile:
    path: Path
    declaration_kind: str
    type_name: str
    package_name: str


def _camel_to_snake(name: str) -> str:
    result = re.sub(r"([A-Z])", r"_\1", name).lower().lstrip("_")
    return result.replace("__", "_")


# Python keywords that cannot be used as field names in generated dataclasses.
# When a Java getter maps to one of these, append a trailing underscore.
_PYTHON_KEYWORDS = frozenset({
    "from", "to", "import", "class", "return", "global", "lambda", "yield",
    "raise", "pass", "break", "continue", "if", "elif", "else", "for", "while",
    "def", "try", "except", "finally", "with", "as", "is", "in", "not", "and",
    "or", "True", "False", "None", "async", "await", "nonlocal", "assert",
    "del",
})


def _safe_slot_name(name: str) -> str:
    """Append `_` to slot names that collide with Python keywords."""
    return f"{name}_" if name in _PYTHON_KEYWORDS else name


def _getter_to_slot_name(method_name: str) -> str:
    if method_name.startswith("get"):
        return _safe_slot_name(_camel_to_snake(method_name[3:]))
    if method_name.startswith("is"):
        return _safe_slot_name(_camel_to_snake(method_name[2:]))
    return ""


def _extract_package(content: str) -> str:
    match = re.search(r"package\s+([\w\.]+);", content)
    return match.group(1) if match else ""


def _parse_declaration(content: str) -> tuple[str, str, list[str], int]:
    match = RE_DECLARATION.search(content)
    if not match:
        raise ValueError("No public declaration found")
    kind, name, extends_clause = match.groups()
    parents: list[str] = []
    if extends_clause:
        parents = [part.strip().split(".")[-1] for part in extends_clause.split(",")]
    return kind, name, parents, match.start()


def _extract_class_description(content: str, declaration_start: int) -> str:
    before_decl = content[:declaration_start]
    javadocs = list(RE_JAVADOC.finditer(before_decl))
    if not javadocs:
        return ""
    return _clean_javadoc(javadocs[-1].group(1))


def _strip_type_modifiers(type_name: str) -> str:
    cleaned = re.sub(r"\bfinal\b", "", type_name)
    cleaned = re.sub(r"\s+", " ", cleaned).strip()
    return cleaned


def _split_generic_inner(type_name: str) -> str:
    inner = type_name[type_name.index("<") + 1:type_name.rindex(">")]
    inner = inner.strip()
    inner = re.sub(r"^\?\s+extends\s+", "", inner)
    inner = re.sub(r"^\?\s+super\s+", "", inner)
    return inner


def _simple_type_name(type_name: str) -> str:
    type_name = _strip_type_modifiers(type_name)
    if "<" in type_name and ">" in type_name:
        type_name = _split_generic_inner(type_name)
    type_name = type_name.strip().split(".")[-1]
    return type_name


def _map_java_type(type_name: str, known_types: set[str]) -> tuple[str, bool]:
    type_name = _strip_type_modifiers(type_name)
    multivalued = False
    outer_match = re.match(r"(\w+)\s*<(.+)>", type_name)
    if outer_match and outer_match.group(1) in COLLECTION_TYPES:
        multivalued = True
        type_name = _split_generic_inner(type_name)

    simple_name = _simple_type_name(type_name)
    if simple_name in SCALAR_TYPES:
        return SCALAR_TYPES[simple_name], multivalued
    if simple_name in known_types:
        return simple_name, multivalued
    return "string", multivalued


def _humanize_symbol(symbol: str) -> str:
    spaced = re.sub(r"([a-z0-9])([A-Z])", r"\1 \2", symbol)
    spaced = spaced.replace("_", " ")
    spaced = re.sub(r"\s+", " ", spaced).strip()
    if not spaced:
        return symbol
    return spaced[0].upper() + spaced[1:]


def discover_source_files(source_root: Path = DEFAULT_SOURCE_ROOT) -> list[SourceFile]:
    files: list[SourceFile] = []
    for path in sorted(source_root.rglob("*.java")):
        if "builder" in path.parts or "impl" in path.parts:
            continue
        content = path.read_text(encoding="utf-8")
        try:
            kind, name, _, _ = _parse_declaration(content)
        except ValueError:
            continue

        if name in TOP_LEVEL_EXCLUDED_TYPES or kind == "class":
            continue

        relative_path = path.relative_to(source_root)
        if relative_path.parent == Path("."):
            include = kind == "enum" or name in TOP_LEVEL_INCLUDED_INTERFACES
        else:
            include = relative_path.parts[0] == "instance" and kind in {"interface", "enum"}
        if not include:
            continue

        files.append(
            SourceFile(
                path=path,
                declaration_kind=kind,
                type_name=name,
                package_name=_extract_package(content),
            )
        )
    return files


def parse_interface(source_file: SourceFile, known_types: set[str]) -> ParsedInterface:
    content = source_file.path.read_text(encoding="utf-8")
    _, name, parents, declaration_start = _parse_declaration(content)
    description = _extract_class_description(content, declaration_start)
    body = content[content.find("{", declaration_start) + 1:content.rfind("}")]

    methods: list[ParsedMethod] = []
    for match in RE_METHOD.finditer(body):
        method_name = match.group("name")
        if not (method_name.startswith("get") or method_name.startswith("is")):
            continue
        if method_name == "getClass":
            continue
        slot_name = _getter_to_slot_name(method_name)
        if not slot_name:
            continue

        return_type = match.group("return").strip()
        if return_type.endswith("Builder"):
            continue
        slot_range, multivalued = _map_java_type(return_type, known_types)
        method_desc = _clean_javadoc(match.group("javadoc")) if match.group("javadoc") else ""
        methods.append(
            ParsedMethod(
                slot_name=slot_name,
                java_type=return_type,
                range=slot_range,
                multivalued=multivalued,
                description=method_desc,
            )
        )

    return ParsedInterface(
        name=name,
        package=source_file.package_name,
        relative_path=_repo_relative(source_file.path),
        description=description,
        parents=parents,
        methods=methods,
    )


def parse_enum(source_file: SourceFile) -> ParsedEnum:
    content = source_file.path.read_text(encoding="utf-8")
    _, name, _, declaration_start = _parse_declaration(content)
    description = _extract_class_description(content, declaration_start)
    body = content[content.find("{", declaration_start) + 1:content.rfind("}")]
    before_methods = body.split(";", 1)[0]
    values: list[str] = []
    for part in before_methods.split(","):
        token = part.strip()
        if not token:
            continue
        token = token.split("(", 1)[0].strip()
        token = token.split()[0]
        if token:
            values.append(token)
    return ParsedEnum(
        name=name,
        package=source_file.package_name,
        relative_path=_repo_relative(source_file.path),
        description=description,
        values=values,
    )


def _subset_for_package(package_name: str) -> list[str]:
    if package_name == "org.finos.fluxnova.bpm.model.bpmn":
        return ["core_api"]
    if package_name.endswith(".instance.bpmndi"):
        return ["bpmndi"]
    if package_name.endswith(".instance.di"):
        return ["di"]
    if package_name.endswith(".instance.dc"):
        return ["dc"]
    if package_name.endswith(".instance.fluxnova"):
        return ["fluxnova_extensions"]
    return ["instance"]


def _collect_inherited_slots(
    class_name: str,
    interfaces: dict[str, ParsedInterface],
    memo: dict[str, set[str]],
) -> set[str]:
    if class_name in memo:
        return memo[class_name]
    interface = interfaces[class_name]
    inherited: set[str] = set()
    for parent in interface.parents:
        if parent not in interfaces:
            continue
        inherited.update(method.slot_name for method in interfaces[parent].methods)
        inherited.update(_collect_inherited_slots(parent, interfaces, memo))
    memo[class_name] = inherited
    return inherited


def build_schema(
    source_root: Path = DEFAULT_SOURCE_ROOT,
    project_version: str = "",
) -> dict:
    source_files = discover_source_files(source_root)
    known_types = {source.type_name for source in source_files}

    interfaces: dict[str, ParsedInterface] = OrderedDict()
    enums: dict[str, ParsedEnum] = OrderedDict()
    for source_file in source_files:
        if source_file.declaration_kind == "enum":
            enums[source_file.type_name] = parse_enum(source_file)
        elif source_file.declaration_kind == "interface":
            interfaces[source_file.type_name] = parse_interface(source_file, known_types)

    slots: OrderedDict[str, SlotSpec] = OrderedDict()
    classes: OrderedDict[str, dict] = OrderedDict()
    inherited_memo: dict[str, set[str]] = {}

    for interface_name in sorted(interfaces):
        interface = interfaces[interface_name]
        parent_names = [parent for parent in interface.parents if parent in interfaces]
        inherited_slots = _collect_inherited_slots(interface_name, interfaces, inherited_memo)

        class_dict: OrderedDict[str, object] = OrderedDict()
        class_desc = interface.description or _generate_bpmn_class_description(
            interface_name, parent_names, interface.package
        )
        if class_desc:
            class_dict["description"] = class_desc
        if parent_names:
            class_dict["is_a"] = parent_names[0]
        if len(parent_names) > 1:
            class_dict["mixins"] = parent_names[1:]
        if interface_name == "BpmnModelInstance":
            class_dict["tree_root"] = True
        class_dict["annotations"] = OrderedDict([
            ("java_package", interface.package),
            ("source_file", interface.relative_path),
        ])
        subsets = _subset_for_package(interface.package)
        if subsets:
            class_dict["in_subset"] = subsets + [BPMN_MODEL_SUBSET]

        class_slots: list[str] = []
        slot_usage: OrderedDict[str, dict] = OrderedDict()
        for method in interface.methods:
            javadoc_desc = method.description
            slot_spec = SlotSpec(
                range=method.range,
                multivalued=method.multivalued,
                description=javadoc_desc or _generate_bpmn_slot_description(
                    method.slot_name, method.range, method.multivalued
                ),
                slot_uri=SLOT_URI_MAP.get(method.slot_name, ""),
            )
            existing = slots.get(method.slot_name)
            if existing is None:
                slots[method.slot_name] = slot_spec
                existing = slot_spec
            elif not existing.description and slot_spec.description:
                existing.description = slot_spec.description

            usage: OrderedDict[str, object] = OrderedDict()
            if method.range != existing.range:
                usage["range"] = method.range
            if method.multivalued != existing.multivalued:
                usage["multivalued"] = method.multivalued
            if method.description and method.description != existing.description:
                usage["description"] = method.description

            if method.slot_name not in inherited_slots:
                class_slots.append(method.slot_name)
            if usage:
                slot_usage[method.slot_name] = dict(usage)

        if class_slots:
            class_dict["slots"] = class_slots
        if slot_usage:
            class_dict["slot_usage"] = dict(slot_usage)
        classes[interface_name] = dict(class_dict)

    enum_dict: OrderedDict[str, dict] = OrderedDict()
    for enum_name in sorted(enums):
        enum_info = enums[enum_name]
        permissible_values = OrderedDict()
        for value in enum_info.values:
            permissible_values[value] = {
                "description": _humanize_symbol(value),
            }
        entry: OrderedDict[str, object] = OrderedDict()
        enum_desc = enum_info.description or f"BPMN {enum_name} enumeration."
        entry["description"] = enum_desc
        entry["permissible_values"] = dict(permissible_values)
        enum_dict[enum_name] = dict(entry)

    slot_dict: OrderedDict[str, dict] = OrderedDict()
    for slot_name in sorted(slots):
        spec = slots[slot_name]
        entry: OrderedDict[str, object] = OrderedDict()
        entry["range"] = spec.range
        if spec.multivalued:
            entry["multivalued"] = True
            if spec.range not in SCALAR_TYPES.values():
                entry["inlined_as_list"] = True
        if slot_name == "id":
            entry["identifier"] = True
        if spec.description:
            entry["description"] = spec.description
        if spec.slot_uri:
            entry["slot_uri"] = spec.slot_uri
        slot_dict[slot_name] = dict(entry)

    schema: OrderedDict[str, object] = OrderedDict()
    schema["id"] = "https://w3id.org/TD-Universe/fluxnova-bpmn-model"
    schema["name"] = "fluxnova_bpmn_model"
    schema["title"] = "Fluxnova BPMN Model API"
    schema["description"] = (
        "LinkML schema generated from the public BPMN Model API interfaces and enums, "
        "covering BPMN core elements, diagram interchange types, and Fluxnova extensions."
    )
    schema["license"] = "Apache-2.0"
    schema["source"] = "https://github.com/finos/fluxnova-bpm-platform/tree/main/model-api/bpmn-model"
    schema["see_also"] = [
        "https://fluxnova.finos.org/",
        "https://docs.fluxnova.finos.org/user-guide/model-api/bpmn-model-api/",
    ]
    if project_version:
        schema["version"] = project_version
    schema["annotations"] = {
        "generated_by": "scripts/fluxnova_bpmn_model_to_linkml.py",
        "source_root": _repo_relative(source_root),
        "interface_count": len(interfaces),
        "enum_count": len(enums),
        "class_count": len(classes),
        "slot_count": len(slot_dict),
        "coverage_target": "100% of in-scope public BPMN metamodel interfaces and enums",
    }
    schema["prefixes"] = OrderedDict([
        ("fluxnova_bpmn_model", "https://w3id.org/TD-Universe/fluxnova-bpmn-model/"),
        ("linkml", "https://w3id.org/linkml/"),
        ("schema", "http://schema.org/"),
        ("bpmn", "http://www.omg.org/spec/BPMN/20100524/MODEL#"),
        ("fluxnova", "https://fluxnova.finos.org/ns/bpmn/"),
    ])
    schema["default_prefix"] = "fluxnova_bpmn_model"
    schema["default_range"] = "string"
    schema["imports"] = ["linkml:types"]
    schema["subsets"] = {
        subset_name: {"description": description}
        for subset_name, description in PACKAGE_SUBSETS.items()
    }
    schema["subsets"][BPMN_MODEL_SUBSET] = {"description": BPMN_MODEL_SUBSET_DESCRIPTION}
    schema["enums"] = dict(enum_dict)
    schema["slots"] = dict(slot_dict)
    schema["classes"] = dict(classes)
    return dict(schema)


# ---------------------------------------------------------------------------
# Modular schema generation
# ---------------------------------------------------------------------------

_COMMON_SCHEMA_META = {
    "license": "Apache-2.0",
    "source": "https://github.com/finos/fluxnova-bpm-platform/tree/main/model-api/bpmn-model",
    "see_also": [
        "https://fluxnova.finos.org/",
        "https://docs.fluxnova.finos.org/user-guide/model-api/bpmn-model-api/",
    ],
}

_MODULE_TITLES = {
    "dc": "Fluxnova BPMN Model – DC (Diagram Common)",
    "di": "Fluxnova BPMN Model – DI (Diagram Interchange)",
    "instance": "Fluxnova BPMN Model – Instance (Core BPMN Elements)",
    "bpmndi": "Fluxnova BPMN Model – BPMNDI (BPMN Diagram Interchange)",
    "fluxnova_extensions": "Fluxnova BPMN Model – Fluxnova Extensions",
    "core_api": "Fluxnova BPMN Model API",
}

_MODULE_DESCRIPTIONS = {
    "dc": "Diagram Common (DC) types: bounds, points, and font definitions.",
    "di": "Generic Diagram Interchange (DI) types: shapes, edges, planes, and styles.",
    "instance": (
        "Core BPMN 2.0 element interfaces covering processes, activities, gateways, "
        "events, data objects, and the full BPMN element hierarchy."
    ),
    "bpmndi": (
        "BPMN Diagram Interchange (BPMNDI) types for layout and visual representation "
        "of BPMN diagrams."
    ),
    "fluxnova_extensions": (
        "Fluxnova-specific BPMN extension elements for connectors, form fields, "
        "execution listeners, and engine configuration."
    ),
    "core_api": (
        "Root BPMN Model API schema. Imports all sub-modules and exposes "
        "BpmnModelInstance as the tree root."
    ),
}

_MODULE_BASE_IDS = {
    "dc": "https://w3id.org/TD-Universe/fluxnova-bpmn-model/dc",
    "di": "https://w3id.org/TD-Universe/fluxnova-bpmn-model/di",
    "instance": "https://w3id.org/TD-Universe/fluxnova-bpmn-model/instance",
    "bpmndi": "https://w3id.org/TD-Universe/fluxnova-bpmn-model/bpmndi",
    "fluxnova_extensions": "https://w3id.org/TD-Universe/fluxnova-bpmn-model/fluxnova",
    "core_api": "https://w3id.org/TD-Universe/fluxnova-bpmn-model",
}

_MODULE_DEFAULT_PREFIXES = {
    "dc": "fluxnova_bpmn_model_dc",
    "di": "fluxnova_bpmn_model_di",
    "instance": "fluxnova_bpmn_model_instance",
    "bpmndi": "fluxnova_bpmn_model_bpmndi",
    "fluxnova_extensions": "fluxnova_bpmn_model_fluxnova",
    "core_api": "fluxnova_bpmn_model",
}

_PREFIXES_COMMON = OrderedDict([
    ("linkml", "https://w3id.org/linkml/"),
    ("schema", "http://schema.org/"),
    ("bpmn", "http://www.omg.org/spec/BPMN/20100524/MODEL#"),
    ("fluxnova", "https://fluxnova.finos.org/ns/bpmn/"),
])

# Subsets that belong to the root/core_api schema file
_ROOT_SUBSETS = {"core_api"}


def _module_schema_header(
    module: str,
    project_version: str,
    source_root: Path,
    extra_annotations: dict | None = None,
) -> OrderedDict:
    """Build the common header for a module schema dict."""
    file_stem = MODULE_FILE_NAMES[module]
    prefix_iri = f"https://w3id.org/TD-Universe/fluxnova-bpmn-model/{file_stem}/"
    prefixes = OrderedDict([(file_stem, prefix_iri)])
    prefixes.update(_PREFIXES_COMMON)

    annotations: dict = {
        "generated_by": "scripts/fluxnova_bpmn_model_to_linkml.py",
        "source_root": _repo_relative(source_root),
        "module": module,
    }
    if extra_annotations:
        annotations.update(extra_annotations)

    hdr: OrderedDict = OrderedDict()
    hdr["id"] = _MODULE_BASE_IDS[module]
    hdr["name"] = file_stem
    hdr["title"] = _MODULE_TITLES[module]
    hdr["description"] = _MODULE_DESCRIPTIONS[module]
    hdr["license"] = _COMMON_SCHEMA_META["license"]
    hdr["source"] = _COMMON_SCHEMA_META["source"]
    hdr["see_also"] = _COMMON_SCHEMA_META["see_also"]
    if project_version:
        hdr["version"] = project_version
    hdr["annotations"] = annotations
    hdr["prefixes"] = prefixes
    hdr["default_prefix"] = _MODULE_DEFAULT_PREFIXES[module]
    hdr["default_range"] = "string"
    hdr["imports"] = MODULE_IMPORTS[module]
    return hdr


def build_modular_schemas(
    source_root: Path = DEFAULT_SOURCE_ROOT,
    project_version: str = "",
) -> dict[str, dict]:
    """Build per-package LinkML module schemas.

    Returns a mapping from module name to schema dict.  The ``core_api`` key
    holds the root (aggregating) schema that imports all sub-modules.

    Module dependency order (no cycles):
        dc -> di -> instance -> bpmndi -> fluxnova_extensions -> core_api
    Cross-module references from bpmndi to instance types (e.g. BaseElement)
    that would create a cycle are given ``range: string`` and annotated.
    """
    source_files = discover_source_files(source_root)
    known_types = {source.type_name for source in source_files}

    # Map source_type -> module name via package
    def _type_module(sf: SourceFile) -> str:
        return _subset_for_package(sf.package_name)[0]

    # Parse all sources
    interfaces: dict[str, ParsedInterface] = OrderedDict()
    enums: dict[str, ParsedEnum] = OrderedDict()
    type_to_module: dict[str, str] = {}
    for sf in source_files:
        mod = _type_module(sf)
        type_to_module[sf.type_name] = mod
        if sf.declaration_kind == "enum":
            enums[sf.type_name] = parse_enum(sf)
        elif sf.declaration_kind == "interface":
            interfaces[sf.type_name] = parse_interface(sf, known_types)

    # ------------------------------------------------------------------
    # Assign slots to modules
    # ------------------------------------------------------------------
    # A slot is owned by the module of the first class (in processing order)
    # that introduces it (i.e. it's not inherited from a same-module parent).
    # We track globally assigned slots to avoid duplicates across modules.

    # slot_name -> (module, SlotSpec)
    slot_assignment: dict[str, tuple[str, "SlotSpec"]] = {}
    inherited_memo: dict[str, set[str]] = {}

    for module in MODULE_PROCESSING_ORDER:
        for interface_name in sorted(interfaces):
            iface = interfaces[interface_name]
            if type_to_module.get(interface_name) != module:
                continue
            inherited = _collect_inherited_slots(interface_name, interfaces, inherited_memo)
            for method in iface.methods:
                if method.slot_name in inherited:
                    continue  # slot inherited, no need to own it
                if method.slot_name in slot_assignment:
                    continue  # already assigned to an earlier module
                
                # Determine effective range: use "string" for inaccessible types
                effective_range = method.range
                range_type_module = type_to_module.get(method.range)
                if (
                    range_type_module
                    and range_type_module not in MODULE_ACCESSIBLE_MODULES[module]
                ):
                    # Type is in an inaccessible module; break the cycle with "string"
                    effective_range = "string"
                
                javadoc_desc = method.description
                spec = SlotSpec(
                    range=effective_range,
                    multivalued=method.multivalued,
                    description=javadoc_desc or _generate_bpmn_slot_description(
                        method.slot_name, effective_range, method.multivalued
                    ),
                    slot_uri=SLOT_URI_MAP.get(method.slot_name, ""),
                )
                slot_assignment[method.slot_name] = (module, spec)

    # ------------------------------------------------------------------
    # Build per-module dicts
    # ------------------------------------------------------------------
    # Collect classes, slots, enums per module
    module_classes: dict[str, OrderedDict] = {m: OrderedDict() for m in MODULE_PROCESSING_ORDER}
    module_slots: dict[str, OrderedDict] = {m: OrderedDict() for m in MODULE_PROCESSING_ORDER}
    module_enums: dict[str, OrderedDict] = {m: OrderedDict() for m in MODULE_PROCESSING_ORDER}

    # Populate slots
    for slot_name, (mod, spec) in slot_assignment.items():
        # SHARED_SLOTS are owned by ``fluxnova_common.yaml``; do not redeclare.
        if slot_name in SHARED_SLOTS:
            continue
        entry: OrderedDict = OrderedDict()
        # Rename ranges that point to renamed classes (e.g. Property -> BpmnProperty)
        entry["range"] = _rename_class(spec.range)
        if spec.multivalued:
            entry["multivalued"] = True
            if spec.range not in SCALAR_TYPES.values():
                entry["inlined_as_list"] = True
        if slot_name == "id":
            entry["identifier"] = True
        if spec.description:
            entry["description"] = spec.description
        if spec.slot_uri:
            entry["slot_uri"] = spec.slot_uri
        module_slots[mod][slot_name] = dict(entry)

    # Populate enums
    for enum_name in sorted(enums):
        enum_info = enums[enum_name]
        mod = type_to_module[enum_name]
        # Top-level bpmn-package enums go into instance module so they are
        # available to instance classes without needing a separate core_api import.
        if mod == "core_api":
            mod = "instance"
        permissible_values = OrderedDict()
        for value in enum_info.values:
            permissible_values[value] = {"description": _humanize_symbol(value)}
        entry = OrderedDict()
        # Description: prefer Javadoc, fallback to a generated description so every enum is documented.
        enum_desc = enum_info.description or f"BPMN {enum_name} enumeration."
        entry["description"] = enum_desc
        entry["permissible_values"] = dict(permissible_values)
        module_enums[mod][enum_name] = dict(entry)

    # Populate classes
    for interface_name in sorted(interfaces):
        iface = interfaces[interface_name]
        mod = type_to_module[interface_name]
        parent_names = [p for p in iface.parents if p in interfaces]
        inherited = _collect_inherited_slots(interface_name, interfaces, inherited_memo)

        class_desc = iface.description or _generate_bpmn_class_description(
            interface_name, parent_names, iface.package
        )
        class_dict: OrderedDict = OrderedDict()
        if class_desc:
            class_dict["description"] = class_desc
        if parent_names:
            class_dict["is_a"] = parent_names[0]
        if len(parent_names) > 1:
            class_dict["mixins"] = parent_names[1:]
        if interface_name == "BpmnModelInstance":
            class_dict["tree_root"] = True
        class_dict["annotations"] = OrderedDict([
            ("java_package", iface.package),
            ("source_file", iface.relative_path),
        ])
        # Subsets: package-level + cross-cutting model subset.
        # core_api subset is included on classes that live in the root schema
        # (BpmnModelInstance/BpmnModelType) so they participate in subset filtering.
        subsets = _subset_for_package(iface.package)
        if subsets:
            class_dict["in_subset"] = subsets + [BPMN_MODEL_SUBSET]

        # Own slots (not inherited within the full hierarchy)
        class_slots: list[str] = []
        slot_usage: OrderedDict = OrderedDict()
        for method in iface.methods:
            if method.slot_name not in inherited:
                class_slots.append(method.slot_name)

            # SHARED_SLOTS are owned by fluxnova_common.yaml with permissive
            # ``range: string``. Refine via slot_usage when BPMN's actual
            # range is an object type (multivalued in the case of ``properties``).
            if method.slot_name in SHARED_SLOTS:
                range_type_module = type_to_module.get(method.range)
                refine_range = method.range
                if (
                    range_type_module
                    and range_type_module not in MODULE_ACCESSIBLE_MODULES[mod]
                ):
                    refine_range = "string"
                refine_range = _rename_class(refine_range)
                usage: OrderedDict = OrderedDict()
                if refine_range != "string":
                    usage["range"] = refine_range
                if method.multivalued:
                    usage["multivalued"] = True
                    if refine_range not in SCALAR_TYPES.values():
                        usage["inlined_as_list"] = True
                if usage:
                    slot_usage[method.slot_name] = dict(usage)
                continue

            # slot_usage when range differs from schema-level definition
            # BUT: skip if the method's range type is not accessible in this module
            assigned_mod, assigned_spec = slot_assignment.get(
                method.slot_name, (None, None)
            )
            if not assigned_spec:
                continue
            # Check if method.range type is accessible from this module
            range_type_module = type_to_module.get(method.range)
            if (
                range_type_module
                and range_type_module not in MODULE_ACCESSIBLE_MODULES[mod]
            ):
                # Not accessible; don't add slot_usage (keep base range)
                continue
            if method.range != assigned_spec.range:
                slot_usage[method.slot_name] = {"range": _rename_class(method.range)}

        if class_slots:
            class_dict["slots"] = class_slots
        if slot_usage:
            class_dict["slot_usage"] = dict(slot_usage)
        # Rename references to BPM-conflicting class names (e.g. Group -> BpmnGroup).
        # The dict key is renamed below; here we rewrite is_a / mixins / range refs.
        if class_dict.get("is_a") in CLASS_RENAMES:
            class_dict["is_a"] = CLASS_RENAMES[class_dict["is_a"]]
        if "mixins" in class_dict:
            class_dict["mixins"] = [_rename_class(m) for m in class_dict["mixins"]]
        if "slot_usage" in class_dict:
            for usage in class_dict["slot_usage"].values():
                if isinstance(usage, dict) and usage.get("range") in CLASS_RENAMES:
                    usage["range"] = CLASS_RENAMES[usage["range"]]
        module_classes[mod][_rename_class(interface_name)] = dict(class_dict)

    # ------------------------------------------------------------------
    # Assemble per-module schema dicts
    # ------------------------------------------------------------------
    schemas: dict[str, dict] = {}
    total_interfaces = len(interfaces)
    total_enums = len(enums)

    for module in MODULE_PROCESSING_ORDER:
        classes_here = module_classes[module]
        slots_here = module_slots[module]
        enums_here = module_enums[module]
        is_root = module == "core_api"

        extra_annotations: dict = {
            "class_count": len(classes_here),
            "slot_count": len(slots_here),
            "enum_count": len(enums_here),
        }
        if is_root:
            extra_annotations["interface_count"] = total_interfaces
            extra_annotations["enum_count"] = total_enums
            extra_annotations["coverage_target"] = (
                "100% of in-scope public BPMN metamodel interfaces and enums"
            )

        schema = _module_schema_header(module, project_version, source_root, extra_annotations)

        # Subsets: only root carries all subset declarations
        if is_root:
            subsets_dict = {
                name: {"description": desc}
                for name, desc in PACKAGE_SUBSETS.items()
            }
            subsets_dict[BPMN_MODEL_SUBSET] = {"description": BPMN_MODEL_SUBSET_DESCRIPTION}
            schema["subsets"] = subsets_dict

        if enums_here:
            schema["enums"] = dict(enums_here)
        if slots_here:
            schema["slots"] = dict(slots_here)
        if classes_here:
            schema["classes"] = dict(classes_here)

        schemas[module] = dict(schema)

    return schemas


def write_modular_schemas(
    schemas: dict[str, dict],
    output_dir: Path,
) -> list[Path]:
    """Write modular schemas to *output_dir*.  Returns list of written paths."""
    output_dir.mkdir(parents=True, exist_ok=True)
    written: list[Path] = []
    for module, schema in schemas.items():
        stem = MODULE_FILE_NAMES[module]
        out_path = output_dir / f"{stem}.yaml"
        write_yaml(schema, out_path)
        written.append(out_path)
    return written


def main() -> None:
    parser = argparse.ArgumentParser(
        description="Generate LinkML schema from the Fluxnova BPMN Model API"
    )
    parser.add_argument(
        "--source-root",
        type=Path,
        default=DEFAULT_SOURCE_ROOT,
        help="Path to the BPMN model API Java source root",
    )
    parser.add_argument(
        "--output-dir",
        type=Path,
        default=DEFAULT_OUTPUT_PATH.parent,
        help="Output directory for schema module files",
    )
    parser.add_argument(
        "--dry-run",
        action="store_true",
        help="Print counts only and do not write files",
    )
    args = parser.parse_args()

    version = read_project_version(DEFAULT_MODULE_POM_PATH)
    schemas = build_modular_schemas(
        source_root=args.source_root,
        project_version=version,
    )

    root_ann = schemas["core_api"]["annotations"]
    print(f"Interfaces: {root_ann.get('interface_count', '?')}")
    print(f"Enums: {root_ann.get('enum_count', '?')}")
    print(f"Modules: {len(schemas)}")

    if args.dry_run:
        print("Dry run - no files written.")
        return

    written = write_modular_schemas(schemas, args.output_dir)
    for path in sorted(written):
        print(f"Wrote {path}")


if __name__ == "__main__":
    main()
