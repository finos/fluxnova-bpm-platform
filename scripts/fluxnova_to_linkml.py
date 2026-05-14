#!/usr/bin/env python3
"""Transform Fluxnova BPM Platform Java entities, H2 DDL, and MyBatis XML
mappings into a reproducible, modular LinkML schema.

Usage::

    python scripts/fluxnova_to_linkml.py            # defaults for repo layout
    python scripts/fluxnova_to_linkml.py --dry-run   # preview without writing

The script reads three complementary source layers:

1. **Java Entity interfaces** - Javadoc descriptions for classes and methods
2. **H2 DDL SQL** - ``CREATE TABLE`` definitions, ``NOT NULL``, FK constraints
3. **MyBatis XML mappings** - column ↔ field name maps (validation)

It produces modular LinkML YAML files in ``src/fluxnova_bpm_platform/schema/``.
"""

from __future__ import annotations

import argparse
import re
import sys
import xml.etree.ElementTree as ET
from collections import OrderedDict
from dataclasses import dataclass, field
from pathlib import Path
from typing import Optional

import yaml


# ---------------------------------------------------------------------------
# Constants
# ---------------------------------------------------------------------------

REPO_ROOT = Path(__file__).resolve().parent.parent

DEFAULT_ENGINE_ENTITY_DIR = (
    REPO_ROOT
    / "engine/src/main/java/org/finos/fluxnova/bpm/engine/impl/persistence/entity"
)
DEFAULT_CMMN_DIR = (
    REPO_ROOT
    / "engine/src/main/java/org/finos/fluxnova/bpm/engine/impl/cmmn/entity"
)
DEFAULT_DMN_DIR = (
    REPO_ROOT
    / "engine/src/main/java/org/finos/fluxnova/bpm/engine/impl/dmn/entity"
)
DEFAULT_HISTORY_DIR = (
    REPO_ROOT
    / "engine/src/main/java/org/finos/fluxnova/bpm/engine/impl/history/event"
)
DEFAULT_BATCH_DIR = (
    REPO_ROOT
    / "engine/src/main/java/org/finos/fluxnova/bpm/engine/impl/batch"
)
DEFAULT_SQL_DIR = (
    REPO_ROOT
    / "engine/src/main/resources/org/finos/fluxnova/bpm/engine/db/create"
)
DEFAULT_MYBATIS_DIR = (
    REPO_ROOT
    / "engine/src/main/resources/org/finos/fluxnova/bpm/engine/impl/mapping/entity"
)
DEFAULT_POM_PATH = REPO_ROOT / "pom.xml"
DEFAULT_OUTPUT_DIR = REPO_ROOT / "src/fluxnova_bpm_platform/schema"

# Java type -> LinkML range
JAVA_TYPE_MAP: dict[str, str] = {
    "String": "string",
    "string": "string",
    "int": "integer",
    "Integer": "integer",
    "long": "integer",
    "Long": "integer",
    "double": "float",
    "Double": "float",
    "float": "float",
    "Float": "float",
    "boolean": "boolean",
    "Boolean": "boolean",
    "Date": "datetime",
    "Timestamp": "datetime",
    "byte[]": "string",
    "Object": "string",
}

# SQL type -> LinkML range
SQL_TYPE_MAP: dict[str, str] = {
    "varchar": "string",
    "integer": "integer",
    "bigint": "integer",
    "bit": "boolean",
    "boolean": "boolean",
    "timestamp": "datetime",
    "double precision": "float",
    "double": "float",
    "blob": "string",
    "longvarbinary": "string",
    "clob": "string",
    "long": "integer",
}

# Well-known CURIE prefix -> IRI expansions (for slot_uri / class_uri references)
CURIE_PREFIXES: dict[str, str] = {
    "schema": "http://schema.org/",
    "dcterms": "http://purl.org/dc/terms/",
    "dct": "http://purl.org/dc/terms/",
    "skos": "http://www.w3.org/2004/02/skos/core#",
    "rdfs": "http://www.w3.org/2000/01/rdf-schema#",
    "rdf": "http://www.w3.org/1999/02/22-rdf-syntax-ns#",
    "owl": "http://www.w3.org/2002/07/owl#",
    "bpmn": "http://www.omg.org/spec/BPMN/20100524/MODEL",
}

# SQL table name -> (LinkML class name, module)
TABLE_TO_CLASS: dict[str, tuple[str, str]] = {
    # Repository
    "ACT_RE_DEPLOYMENT": ("Deployment", "repository"),
    "ACT_RE_PROCDEF": ("ProcessDefinition", "repository"),
    "ACT_RE_CAMFORMDEF": ("FormDefinition", "repository"),
    "ACT_RE_CASE_DEF": ("CaseDefinition", "repository"),
    "ACT_RE_DECISION_DEF": ("DecisionDefinition", "repository"),
    "ACT_RE_DECISION_REQ_DEF": ("DecisionRequirementsDefinition", "repository"),
    # Runtime
    "ACT_RU_EXECUTION": ("Execution", "runtime"),
    "ACT_RU_TASK": ("Task", "runtime"),
    "ACT_RU_VARIABLE": ("VariableInstance", "runtime"),
    "ACT_RU_EVENT_SUBSCR": ("EventSubscription", "runtime"),
    "ACT_RU_INCIDENT": ("Incident", "runtime"),
    "ACT_RU_EXT_TASK": ("ExternalTask", "runtime"),
    "ACT_RU_IDENTITYLINK": ("IdentityLink", "identity"),
    # Jobs
    "ACT_RU_JOB": ("Job", "job"),
    "ACT_RU_JOBDEF": ("JobDefinition", "job"),
    "ACT_RU_BATCH": ("Batch", "job"),
    # Identity
    "ACT_ID_USER": ("User", "identity"),
    "ACT_ID_GROUP": ("Group", "identity"),
    "ACT_ID_MEMBERSHIP": ("Membership", "identity"),
    "ACT_ID_TENANT": ("Tenant", "identity"),
    "ACT_ID_TENANT_MEMBER": ("TenantMembership", "identity"),
    "ACT_ID_INFO": ("IdentityInfo", "identity"),
    # Auth
    "ACT_RU_AUTHORIZATION": ("Authorization", "identity"),
    "ACT_RU_FILTER": ("Filter", "collaboration"),
    # General
    "ACT_GE_BYTEARRAY": ("ByteArray", "base"),
    "ACT_GE_PROPERTY": ("Property", "base"),
    "ACT_GE_SCHEMA_LOG": ("SchemaLogEntry", "base"),
    # Meters
    "ACT_RU_METER_LOG": ("MeterLog", "base"),
    "ACT_RU_TASK_METER_LOG": ("TaskMeterLog", "base"),
    # Case Runtime
    "ACT_RU_CASE_EXECUTION": ("CaseExecution", "runtime"),
    "ACT_RU_CASE_SENTRY_PART": ("CaseSentryPart", "runtime"),
    # History
    "ACT_HI_PROCINST": ("HistoricProcessInstance", "history"),
    "ACT_HI_ACTINST": ("HistoricActivityInstance", "history"),
    "ACT_HI_TASKINST": ("HistoricTaskInstance", "history"),
    "ACT_HI_VARINST": ("HistoricVariableInstance", "history"),
    "ACT_HI_DETAIL": ("HistoricDetail", "history"),
    "ACT_HI_IDENTITYLINK": ("HistoricIdentityLink", "history"),
    "ACT_HI_COMMENT": ("Comment", "collaboration"),
    "ACT_HI_ATTACHMENT": ("Attachment", "collaboration"),
    "ACT_HI_OP_LOG": ("UserOperationLogEntry", "history"),
    "ACT_HI_INCIDENT": ("HistoricIncident", "history"),
    "ACT_HI_JOB_LOG": ("HistoricJobLog", "history"),
    "ACT_HI_BATCH": ("HistoricBatch", "history"),
    "ACT_HI_EXT_TASK_LOG": ("HistoricExternalTaskLog", "history"),
    "ACT_HI_DECINST": ("HistoricDecisionInstance", "history"),
    "ACT_HI_DEC_IN": ("HistoricDecisionInputInstance", "history"),
    "ACT_HI_DEC_OUT": ("HistoricDecisionOutputInstance", "history"),
    "ACT_HI_CASEINST": ("HistoricCaseInstance", "history"),
    "ACT_HI_CASEACTINST": ("HistoricCaseActivityInstance", "history"),
}

# Columns that map to enums (column_name -> enum_name)
ENUM_COLUMNS: dict[str, str] = {
    "SUSPENSION_STATE_": "SuspensionState",
    "DELEGATION_": "DelegationState",
    "ACT_INST_STATE_": "ActivityInstanceState",
    "INCIDENT_STATE_": "IncidentState",
    "JOB_STATE_": "JobState",
    "STATE_": "EntityState",
}

# Table-specific enum column overrides: (table_name, column_name) -> enum_name
TABLE_ENUM_COLUMNS: dict[tuple[str, str], str] = {
    ("ACT_RU_AUTHORIZATION", "TYPE_"): "AuthorizationType",
}

# Class inheritance map (class_name -> parent_class_name)
CLASS_INHERITANCE: dict[str, str] = {
    "ProcessDefinition": "ResourceDefinition",
    "CaseDefinition": "ResourceDefinition",
    "DecisionDefinition": "ResourceDefinition",
    "DecisionRequirementsDefinition": "ResourceDefinition",
    "FormDefinition": "ResourceDefinition",
    # History hierarchy
    "HistoricProcessInstance": "HistoricScopeInstance",
    "HistoricActivityInstance": "HistoricScopeInstance",
    "HistoricTaskInstance": "HistoricScopeInstance",
    "HistoricCaseInstance": "HistoricScopeInstance",
    "HistoricCaseActivityInstance": "HistoricScopeInstance",
}

# Classes that are abstract
ABSTRACT_CLASSES: set[str] = {
    "ResourceDefinition",
    "HistoricScopeInstance",
}

# Columns to skip (internal / not part of domain model)
SKIP_COLUMNS: set[str] = {
    "REV_",
}

# Module subsets for LinkML schema partitioning and enrichment
# Each module is tagged for filtering/documentation purposes
MODULE_SUBSETS = {
    "base": "Base types and utility entities (ByteArray, Property, Meter, Schema).",
    "repository": "Resource definitions (Process, Case, Decision, Form).",
    "runtime": "Active execution, task, and event instances.",
    "job": "Job and batch management entities.",
    "identity": "Identity and authorization entities (User, Group, Tenant, Role).",
    "history": "Historical snapshots of completed runtime entities.",
    "collaboration": "Collaboration features (Comments, Attachments, Filters).",
}

# Model-level subset for cross-module tagging
MODEL_SUBSET = "fluxnova_bpm"

# Filename-derived subset for the top-level platform schema
# (``fluxnova_bpm_platform.yaml`` → ``platform``). Every class in a given
# schema file is tagged with both its module subset and the cross-cutting
# ``fluxnova_bpm`` subset; the root schema's ``FluxnovaPlatformData`` follows
# the same convention with the ``platform`` filename-derived subset.
PLATFORM_SUBSET = "platform"

# Slots whose names collide between the BPM persistence schema and the BPMN
# Model API schema (fluxnova_bpmn_model.yaml). LinkML's import-merge requires
# such slots to be declared in a SINGLE owning schema, otherwise gen-project /
# gen-python raise ``Conflicting URIs ... for item: <name>``. We extract them
# into ``fluxnova_common.yaml`` which is imported by both sides. The BPM-side
# definitions (range: string, plus optional sql_column annotation) are used
# verbatim; the BPMN side refines via slot_usage where it needs object ranges.
SHARED_SLOTS: set[str] = {
    "id", "name", "category", "message", "properties", "source", "type", "value",
}

COMMON_SCHEMA_NAME = "fluxnova_common"

# ---------------------------------------------------------------------------
# Java Interface -> LinkML Class Mapping (for Javadoc extraction)
# ---------------------------------------------------------------------------

_ENGINE_BASE = "engine/src/main/java/org/finos/fluxnova/bpm/engine"

# Maps LinkML class name -> relative path from REPO_ROOT to Java interface file
CLASS_JAVA_INTERFACES: dict[str, str] = {
    # Runtime
    "Execution": f"{_ENGINE_BASE}/runtime/Execution.java",
    "Task": f"{_ENGINE_BASE}/task/Task.java",
    "VariableInstance": f"{_ENGINE_BASE}/runtime/VariableInstance.java",
    "EventSubscription": f"{_ENGINE_BASE}/runtime/EventSubscription.java",
    "Incident": f"{_ENGINE_BASE}/runtime/Incident.java",
    "ExternalTask": f"{_ENGINE_BASE}/externaltask/ExternalTask.java",
    "CaseExecution": f"{_ENGINE_BASE}/runtime/CaseExecution.java",
    # Repository
    "Deployment": f"{_ENGINE_BASE}/repository/Deployment.java",
    "ProcessDefinition": f"{_ENGINE_BASE}/repository/ProcessDefinition.java",
    "ResourceDefinition": f"{_ENGINE_BASE}/repository/ResourceDefinition.java",
    "CaseDefinition": f"{_ENGINE_BASE}/repository/CaseDefinition.java",
    "DecisionDefinition": f"{_ENGINE_BASE}/repository/DecisionDefinition.java",
    "DecisionRequirementsDefinition": f"{_ENGINE_BASE}/repository/DecisionRequirementsDefinition.java",
    "FormDefinition": f"{_ENGINE_BASE}/repository/FluxnovaFormDefinition.java",
    # Jobs
    "Job": f"{_ENGINE_BASE}/runtime/Job.java",
    "JobDefinition": f"{_ENGINE_BASE}/management/JobDefinition.java",
    "Batch": f"{_ENGINE_BASE}/batch/Batch.java",
    # Identity
    "User": f"{_ENGINE_BASE}/identity/User.java",
    "Group": f"{_ENGINE_BASE}/identity/Group.java",
    "Tenant": f"{_ENGINE_BASE}/identity/Tenant.java",
    "Authorization": f"{_ENGINE_BASE}/authorization/Authorization.java",
    "IdentityLink": f"{_ENGINE_BASE}/task/IdentityLink.java",
    # Collaboration
    "Attachment": f"{_ENGINE_BASE}/task/Attachment.java",
    "Comment": f"{_ENGINE_BASE}/task/Comment.java",
    "Filter": f"{_ENGINE_BASE}/filter/Filter.java",
    # History
    "HistoricActivityInstance": f"{_ENGINE_BASE}/history/HistoricActivityInstance.java",
    "HistoricProcessInstance": f"{_ENGINE_BASE}/history/HistoricProcessInstance.java",
    "HistoricTaskInstance": f"{_ENGINE_BASE}/history/HistoricTaskInstance.java",
    "HistoricVariableInstance": f"{_ENGINE_BASE}/history/HistoricVariableInstance.java",
    "HistoricDetail": f"{_ENGINE_BASE}/history/HistoricDetail.java",
    "HistoricIncident": f"{_ENGINE_BASE}/history/HistoricIncident.java",
    "HistoricJobLog": f"{_ENGINE_BASE}/history/HistoricJobLog.java",
    "HistoricExternalTaskLog": f"{_ENGINE_BASE}/history/HistoricExternalTaskLog.java",
    "HistoricDecisionInstance": f"{_ENGINE_BASE}/history/HistoricDecisionInstance.java",
    "HistoricDecisionInputInstance": f"{_ENGINE_BASE}/history/HistoricDecisionInputInstance.java",
    "HistoricDecisionOutputInstance": f"{_ENGINE_BASE}/history/HistoricDecisionOutputInstance.java",
    "HistoricCaseInstance": f"{_ENGINE_BASE}/history/HistoricCaseInstance.java",
    "HistoricCaseActivityInstance": f"{_ENGINE_BASE}/history/HistoricCaseActivityInstance.java",
    "HistoricIdentityLink": f"{_ENGINE_BASE}/history/HistoricIdentityLinkLog.java",
    "HistoricBatch": f"{_ENGINE_BASE}/batch/history/HistoricBatch.java",
    "UserOperationLogEntry": f"{_ENGINE_BASE}/history/UserOperationLogEntry.java",
}

# ---------------------------------------------------------------------------
# Dynamic Description Generation
# ---------------------------------------------------------------------------
# Instead of hardcoded fallback dicts, descriptions are generated dynamically
# from SQL column names, types, FK constraints, and table context.


def _generate_slot_description(
    slot_name: str,
    sql_col_name: str,
    sql_type: str,
    table_name: str,
    fk_constraints: dict[str, str],
) -> str:
    """Generate a description for a slot from its SQL column metadata.

    Uses naming patterns, types, and FK constraints to infer meaning.
    """
    # FK reference: if this column references another table, describe the reference
    if sql_col_name in fk_constraints:
        ref_table = fk_constraints[sql_col_name]
        if ref_table in TABLE_TO_CLASS:
            target_class = TABLE_TO_CLASS[ref_table][0]
            return f"Reference to a {target_class}."
        return f"Foreign key reference to {ref_table}."

    # Boolean patterns (IS_ prefix columns -> "Whether...")
    if slot_name.startswith("is_"):
        remainder = slot_name[3:].replace("_", " ")
        return f"Whether this entity is {remainder}."

    # Timestamp patterns
    if sql_type in ("timestamp", "datetime") or slot_name.endswith("_time") or slot_name.endswith("_date"):
        if "start" in slot_name:
            return "Timestamp when this started."
        if "end" in slot_name:
            return "Timestamp when this ended."
        if "create" in slot_name or "created" == slot_name:
            return "Timestamp when this was created."
        if "last_updated" == slot_name:
            return "Timestamp of the last modification."
        if "due" in slot_name:
            return "Date by which this should be completed."
        if "follow_up" in slot_name:
            return "Follow-up date."
        if "lock_expiration" in slot_name:
            return "Time at which the lock expires."
        return f"Timestamp for {slot_name.replace('_', ' ')}."

    # ID reference patterns (ending in _id but not a declared FK)
    if slot_name.endswith("_id") and slot_name != "id":
        # Try to derive target from the slot name
        ref_part = slot_name[:-3].replace("_", " ").strip()
        return f"Reference to the {ref_part}."

    # Hash columns
    if "hash" in slot_name:
        subject = slot_name.replace("_hash", "").replace("_", " ")
        return f"Hash of the {subject} for aggregation."

    # Count / numeric columns
    if slot_name in ("retries", "priority"):
        if slot_name == "retries":
            return "Number of remaining retry attempts."
        return "Priority level for ordering."
    if slot_name.startswith("total_") or slot_name.endswith("_count"):
        return f"Total number of {slot_name.replace('total_', '').replace('_count', '').replace('_', ' ')}."

    # Value holder patterns
    if slot_name in ("double_value", "long_value", "text_value", "text2_value"):
        type_part = slot_name.replace("_value", "").replace("_", " ")
        return f"Variable value stored as {type_part}."
    if slot_name == "value":
        return "Generic value holder."
    if slot_name == "bytes":
        return "Serialized binary content."

    # Common well-known column names
    known: dict[str, str] = {
        "owner": "User ID of the owner.",
        "assignee": "User ID of the assignee.",
        "reporter": "Identifier of the reporting node.",
        "message": "Short message or summary.",
        "full_message": "Full message body.",
        "state": "Current lifecycle state.",
        "type": "Type discriminator.",
        "priority": "Priority level for ordering.",
        "configuration": "Configuration value.",
        "properties": "Serialized properties.",
        "query": "Serialized query expression.",
        "url": "External URL reference.",
        "email": "Email address.",
        "first_name": "First name.",
        "last_name": "Last name.",
        "password": "Hashed password.",
        "salt": "Cryptographic salt for password hashing.",
        "permissions": "Bitmask of granted permissions.",
        "resource_type": "Numeric type of the authorized resource.",
        "attempts": "Number of failed login attempts.",
        "error_message": "Error message from the last failure.",
        "handler_type": "Type of handler that processes this entity.",
        "handler_configuration": "Configuration for the handler.",
        "repeat": "Repeat/recurrence expression (ISO 8601).",
        "repeat_offset": "Offset applied to repeat interval calculation.",
        "lock_owner": "Identifier of the node that acquired the lock.",
        "worker_id": "Identifier of the external worker.",
        "topic_name": "Topic name for external task subscription.",
        "sequence_counter": "Monotonically increasing counter for ordering.",
        "suspension_state": "Whether the entity is active or suspended.",
        "delegation_state": "Current delegation state.",
        "cached_entity_state": "Bitmask caching associated entity existence.",
        "version_tag": "User-defined version tag.",
    }
    if slot_name in known:
        return known[slot_name]

    # Fallback: humanize the column name
    humanized = slot_name.replace("_", " ")
    return f"The {humanized}."


def _generate_class_description(
    class_name: str,
    module: str,
    table: "SqlTable",
) -> str:
    """Generate a description for a class from its table metadata.

    Uses the class name, module context, and column structure to infer meaning.
    """
    # Infer from class name patterns
    if "Historic" in class_name:
        entity = class_name.replace("Historic", "").replace("Instance", "")
        # Insert spaces before capitals
        entity = re.sub(r"([A-Z])", r" \1", entity).strip().lower()
        return f"Historic record of a {entity}."

    # Module-based context
    module_context = {
        "base": "engine infrastructure",
        "runtime": "process execution runtime",
        "job": "asynchronous job execution",
        "identity": "identity and access management",
        "collaboration": "user collaboration",
        "history": "audit history",
        "repository": "process repository",
    }
    ctx = module_context.get(module, module)

    # Check columns for hints
    col_names = {c.name for c in table.columns}
    has_key = "KEY_" in col_names
    has_deploy_time = "DEPLOY_TIME_" in col_names
    has_version = "VERSION_" in col_names

    if has_key and has_version:
        # Likely a definition entity
        human_name = re.sub(r"([A-Z])", r" \1", class_name).strip().lower()
        return f"A deployed {human_name} in the {ctx}."

    if "MEMBER" in class_name.upper() or "MEMBERSHIP" in class_name.upper():
        return f"Association entity in {ctx}."

    # Generic: use class name
    human_name = re.sub(r"([A-Z])", r" \1", class_name).strip()
    return f"{human_name} entity in the {ctx}."


# ---------------------------------------------------------------------------
# Javadoc Parser
# ---------------------------------------------------------------------------

# Regex to match a Javadoc comment block: /** ... */
RE_JAVADOC = re.compile(r"/\*\*(.*?)\*/", re.DOTALL)

# Regex to match a method signature (interface getter)
RE_METHOD = re.compile(
    r"^\s*(?:\w+\s+)*(\w+)\s+(\w+)\s*\(\s*\)", re.MULTILINE
)


def _clean_javadoc(raw: str) -> str:
    """Clean a raw Javadoc comment body into a single-line description."""
    lines = raw.split("\n")
    cleaned: list[str] = []
    for line in lines:
        # Strip leading whitespace, *, and trailing whitespace
        line = line.strip()
        if line.startswith("*"):
            line = line[1:].strip()
        # Stop at @param, @return, @author, @see, @since, @throws, etc.
        if line.startswith("@"):
            break
        # Skip empty lines and HTML tags that are structural
        if line.startswith("<") and line.endswith(">"):
            continue
        if line == "<p>" or line == "</p>" or line == "<ul>" or line == "</ul>":
            continue
        if line.startswith("<li>"):
            line = line.replace("<li>", "").replace("</li>", "").strip()
        if line:
            cleaned.append(line)
    result = " ".join(cleaned)
    # Remove inline HTML tags
    result = re.sub(r"<[^>]+>", "", result)
    # Remove {@link ...} and {@code ...} keeping just the display text
    result = re.sub(r"\{@\w+\s+([^}]+)\}", r"\1", result)
    # Clean up Java-style references: Class#method(args) -> just the method concept
    result = re.sub(r"\w+#\w+\([^)]*\)\s*", "", result)
    result = re.sub(r"\w+#\w+", "", result)
    # Collapse multiple spaces
    result = re.sub(r"\s+", " ", result).strip()
    # Remove leading "Returns " / "returns " for slot descriptions (getter style)
    result = re.sub(r"^[Rr]eturns?\s+(?:the\s+)?", "", result).strip()
    # Capitalize first letter
    if result and result[0].islower():
        result = result[0].upper() + result[1:]
    # Truncate very long descriptions to keep schema readable
    if len(result) > 200:
        result = result[:197] + "..."
    return result


def _getter_to_slot_name(method_name: str) -> str:
    """Convert a Java getter name like ``getProcessInstanceId`` to ``process_instance_id``."""
    # Remove 'get' or 'is' prefix
    if method_name.startswith("get"):
        name = method_name[3:]
    elif method_name.startswith("is"):
        name = method_name[2:]
    else:
        return ""
    # CamelCase -> snake_case
    result = re.sub(r"([A-Z])", r"_\1", name).lower().lstrip("_")
    return result


@dataclass
class JavadocInfo:
    """Extracted Javadoc information for a Java interface."""
    class_description: str = ""
    method_descriptions: dict[str, str] = field(default_factory=dict)
    # Maps slot_name -> description


def parse_javadoc_file(filepath: Path) -> JavadocInfo:
    """Parse a Java interface file and extract Javadoc for class and methods."""
    info = JavadocInfo()
    if not filepath.is_file():
        return info

    content = filepath.read_text(encoding="utf-8")

    # Find the class-level Javadoc: the last /** ... */ before 'public interface'
    # or 'public abstract class'
    class_decl_match = re.search(
        r"(public\s+(?:abstract\s+)?(?:interface|class)\s+\w+)", content
    )
    if class_decl_match:
        # Find the Javadoc immediately preceding the class declaration
        before_class = content[: class_decl_match.start()]
        # Find the last Javadoc in 'before_class'
        javadocs = list(RE_JAVADOC.finditer(before_class))
        if javadocs:
            last_jd = javadocs[-1]
            info.class_description = _clean_javadoc(last_jd.group(1))

    # Find method-level Javadocs: each /** ... */ followed by a method signature
    pos = class_decl_match.end() if class_decl_match else 0
    remaining = content[pos:]

    # Split into chunks by finding Javadoc + method pairs
    for jd_match in RE_JAVADOC.finditer(remaining):
        jd_end = jd_match.end()
        # Look for a method signature after this Javadoc (within ~200 chars)
        after_jd = remaining[jd_end: jd_end + 300]
        method_match = RE_METHOD.match(after_jd.lstrip())
        if method_match:
            method_name = method_match.group(2)
            slot_name = _getter_to_slot_name(method_name)
            if slot_name:
                desc = _clean_javadoc(jd_match.group(1))
                if desc:
                    info.method_descriptions[slot_name] = desc

    return info


def parse_all_javadoc(repo_root: Path) -> dict[str, JavadocInfo]:
    """Parse all mapped Java interface files and return class→JavadocInfo."""
    results: dict[str, JavadocInfo] = {}
    for class_name, rel_path in CLASS_JAVA_INTERFACES.items():
        filepath = repo_root / rel_path
        info = parse_javadoc_file(filepath)
        if info.class_description or info.method_descriptions:
            results[class_name] = info
    return results


def read_project_version(pom_path: Path) -> str:
    """Read the project version from the root Maven POM."""
    if not pom_path.is_file():
        return ""

    try:
        root = ET.fromstring(pom_path.read_text(encoding="utf-8"))
    except (ET.ParseError, OSError):
        return ""

    version = root.findtext("./{*}version")
    return version.strip() if version else ""


def _repo_relative(path: Path) -> str:
    """Return a stable repository-relative path when possible."""
    try:
        return str(path.relative_to(REPO_ROOT))
    except ValueError:
        return str(path)

# ---------------------------------------------------------------------------
# IR Dataclasses
# ---------------------------------------------------------------------------


@dataclass
class SqlColumn:
    """A column parsed from a DDL CREATE TABLE statement."""

    name: str
    sql_type: str
    nullable: bool = True
    is_pk: bool = False


@dataclass
class SqlTable:
    """A table parsed from DDL."""

    name: str
    columns: list[SqlColumn] = field(default_factory=list)
    pk_columns: list[str] = field(default_factory=list)
    fk_constraints: dict[str, str] = field(default_factory=dict)  # col -> ref_table


@dataclass
class SlotDef:
    """A LinkML slot definition."""

    name: str
    range: str = "string"
    required: bool = False
    multivalued: bool = False
    identifier: bool = False
    description: str = ""
    slot_uri: str = ""
    inlined: Optional[bool] = None
    inlined_as_list: Optional[bool] = None
    pattern: str = ""
    annotations: dict = field(default_factory=dict)
    aliases: list = field(default_factory=list)


@dataclass
class ClassDef:
    """A LinkML class definition ready for output."""

    name: str
    module: str
    description: str = ""
    is_a: str = ""
    abstract: bool = False
    mixin: bool = False
    tree_root: bool = False
    slots: list[str] = field(default_factory=list)
    slot_usage: dict[str, dict] = field(default_factory=dict)
    unique_keys: dict[str, dict] = field(default_factory=dict)
    annotations: dict = field(default_factory=dict)
    sql_table: str = ""
    in_subset: list[str] = field(default_factory=list)


# ---------------------------------------------------------------------------
# SQL DDL Parser
# ---------------------------------------------------------------------------

RE_CREATE_TABLE = re.compile(
    r"create\s+table\s+(\w+)\s*\(", re.IGNORECASE
)
RE_COLUMN = re.compile(
    r"^\s+(\w+)\s+([\w\s\(\)]+?)(?:\s+(NOT\s+NULL))?"
    r"(?:\s+DEFAULT\s+\S+)?"
    r"\s*(?:,\s*)?$",
    re.IGNORECASE,
)
RE_PK = re.compile(
    r"primary\s+key\s*\(([^)]+)\)", re.IGNORECASE
)
RE_UNIQUE = re.compile(
    r"unique\s*\(([^)]+)\)", re.IGNORECASE
)
RE_FK = re.compile(
    r"alter\s+table\s+(\w+)\s+add\s+constraint\s+\w+\s+"
    r"foreign\s+key\s*\((\w+)\)\s*references\s+(\w+)",
    re.IGNORECASE,
)


def parse_sql_files(sql_dir: Path) -> dict[str, SqlTable]:
    """Parse all H2 DDL create SQL files and return table definitions."""
    tables: dict[str, SqlTable] = {}
    fk_stmts: list[tuple[str, str, str]] = []  # (table, col, ref_table)

    sql_files = sorted(sql_dir.glob("activiti.h2.create.*.sql"))
    if not sql_files:
        print(f"Warning: no SQL files found in {sql_dir}", file=sys.stderr)
        return tables

    for sql_file in sql_files:
        content = sql_file.read_text(encoding="utf-8")

        # Extract foreign key ALTER TABLE statements
        for m in RE_FK.finditer(content):
            fk_stmts.append((m.group(1).upper(), m.group(2).upper(), m.group(3).upper()))

        # Parse CREATE TABLE blocks
        for ct_match in RE_CREATE_TABLE.finditer(content):
            table_name = ct_match.group(1).upper()
            # Find the matching closing paren by scanning from match end
            start = ct_match.end()
            depth = 1
            pos = start
            while pos < len(content) and depth > 0:
                if content[pos] == "(":
                    depth += 1
                elif content[pos] == ")":
                    depth -= 1
                pos += 1
            block = content[start : pos - 1]

            table = SqlTable(name=table_name)

            # Find primary key
            pk_match = RE_PK.search(block)
            if pk_match:
                table.pk_columns = [
                    c.strip().upper() for c in pk_match.group(1).split(",")
                ]

            # Parse columns
            for line in block.split("\n"):
                line_stripped = line.strip()
                if not line_stripped or line_stripped.lower().startswith("primary"):
                    continue
                if line_stripped.lower().startswith("unique"):
                    continue

                # Try to extract column definition
                col_match = re.match(
                    r"(\w+)\s+([\w\s\(\)]+?)(?:\s+(NOT\s+NULL))?(?:\s+DEFAULT\s+\S+)?\s*,?\s*$",
                    line_stripped,
                    re.IGNORECASE,
                )
                if col_match:
                    col_name = col_match.group(1).upper()
                    raw_type = col_match.group(2).strip().lower()
                    # Normalize type: strip size specifiers
                    raw_type = re.sub(r"\(\d+\)", "", raw_type).strip()
                    raw_type = re.sub(r"\s+", " ", raw_type)
                    not_null = col_match.group(3) is not None
                    is_pk = col_name in table.pk_columns

                    table.columns.append(
                        SqlColumn(
                            name=col_name,
                            sql_type=raw_type,
                            nullable=not not_null and not is_pk,
                            is_pk=is_pk,
                        )
                    )

            if table.columns:
                tables[table_name] = table

    # Apply FK constraints
    for tbl_name, col_name, ref_table in fk_stmts:
        if tbl_name in tables:
            tables[tbl_name].fk_constraints[col_name] = ref_table

    return tables


# ---------------------------------------------------------------------------
# Column -> Slot name conversion
# ---------------------------------------------------------------------------


def _col_to_slot_name(col_name: str) -> str:
    """Convert a SQL column name like ``PROC_DEF_ID_`` to ``process_definition_id``."""
    # Strip trailing underscore that Activiti uses
    name = col_name.rstrip("_").lower()

    # Expand well-known abbreviations
    expansions = {
        "proc_def": "process_definition",
        "proc_inst": "process_instance",
        "proc": "process",
        "def": "definition",
        "inst": "instance",
        "exec": "execution",
        "act": "activity",
        "dgrm": "diagram",
        "subscr": "subscription",
        "config": "configuration",
        "msg": "message",
        "exp": "expiration",
        "ent": "entity",
        "buskey": "business_key",
        "dec_def": "decision_definition",
        "dec_req": "decision_requirements_definition",
        "dec_inst": "decision_instance",
        "ext_task": "external_task",
        "case_def": "case_definition",
        "case_inst": "case_instance",
        "case_exec": "case_execution",
        "case_act": "case_activity",
        "job_def": "job_definition",
        "root_proc_inst": "root_process_instance",
        "super_exec": "super_execution",
        "super_case_exec": "super_case_execution",
        "super_process_instance": "super_process_instance",
        "super_case_instance": "super_case_instance",
        "lock_exp_time": "lock_expiration_time",
        "hist_config": "history_configuration",
        "history_ttl": "history_time_to_live",
        "handler_cfg": "handler_configuration",
        "exception_stack": "exception_stack",
        "err_msg": "error_message",
        "err_details": "error_details",
    }

    # Apply longest-match-first expansion
    for abbr, expansion in sorted(expansions.items(), key=lambda x: -len(x[0])):
        name = name.replace(abbr, expansion)

    return name


# Canonical column name -> slot name overrides for clarity
COLUMN_SLOT_OVERRIDES: dict[str, str] = {
    "ID_": "id",
    "REV_": "revision",
    "NAME_": "name",
    "KEY_": "key",
    "TYPE_": "type",
    "VERSION_": "version",
    "CATEGORY_": "category",
    "TENANT_ID_": "tenant_id",
    "DEPLOYMENT_ID_": "deployment_id",
    "RESOURCE_NAME_": "resource_name",
    "DGRM_RESOURCE_NAME_": "diagram_resource_name",
    "SUSPENSION_STATE_": "suspension_state",
    "PROC_DEF_ID_": "process_definition_id",
    "PROC_DEF_KEY_": "process_definition_key",
    "PROC_INST_ID_": "process_instance_id",
    "ROOT_PROC_INST_ID_": "root_process_instance_id",
    "EXECUTION_ID_": "execution_id",
    "PARENT_ID_": "parent_id",
    "ACT_ID_": "activity_id",
    "ACT_INST_ID_": "activity_instance_id",
    "TASK_ID_": "task_id",
    "TASK_DEF_KEY_": "task_definition_key",
    "PARENT_TASK_ID_": "parent_task_id",
    "ASSIGNEE_": "assignee",
    "OWNER_": "owner",
    "PRIORITY_": "priority",
    "CREATE_TIME_": "create_time",
    "START_TIME_": "start_time",
    "END_TIME_": "end_time",
    "DUE_DATE_": "due_date",
    "DUEDATE_": "due_date",
    "FOLLOW_UP_DATE_": "follow_up_date",
    "DURATION_": "duration",
    "DELETE_REASON_": "delete_reason",
    "DESCRIPTION_": "description",
    "BUSINESS_KEY_": "business_key",
    "CASE_DEF_ID_": "case_definition_id",
    "CASE_DEF_KEY_": "case_definition_key",
    "CASE_INST_ID_": "case_instance_id",
    "CASE_EXECUTION_ID_": "case_execution_id",
    "CASE_EXEC_ID_": "case_execution_id",
    "SUPER_EXEC_": "super_execution_id",
    "SUPER_CASE_EXEC_": "super_case_execution_id",
    "DEC_DEF_ID_": "decision_definition_id",
    "DEC_DEF_KEY_": "decision_definition_key",
    "DEC_DEF_NAME_": "decision_definition_name",
    "DEC_REQ_ID_": "decision_requirements_definition_id",
    "DEC_REQ_KEY_": "decision_requirements_definition_key",
    "JOB_DEF_ID_": "job_definition_id",
    "BATCH_ID_": "batch_id",
    "LOCK_OWNER_": "lock_owner",
    "LOCK_EXP_TIME_": "lock_expiration_time",
    "EXCLUSIVE_": "is_exclusive",
    "RETRIES_": "retries",
    "EXCEPTION_MSG_": "exception_message",
    "EXCEPTION_STACK_ID_": "exception_stack_id",
    "HANDLER_TYPE_": "handler_type",
    "HANDLER_CFG_": "handler_configuration",
    "REPEAT_": "repeat",
    "REPEAT_OFFSET_": "repeat_offset",
    "FAILED_ACT_ID_": "failed_activity_id",
    "SEQUENCE_COUNTER_": "sequence_counter",
    "JOB_TYPE_": "job_type",
    "JOB_CONFIGURATION_": "job_configuration",
    "JOB_PRIORITY_": "job_priority",
    "PROCESS_INSTANCE_ID_": "process_instance_id",
    "PROCESS_DEF_ID_": "process_definition_id",
    "PROCESS_DEF_KEY_": "process_definition_key",
    "ROOT_PROC_INST_ID_": "root_process_instance_id",
    "USER_ID_": "user_id",
    "GROUP_ID_": "group_id",
    "PERMS_": "permissions",
    "RESOURCE_TYPE_": "resource_type",
    "RESOURCE_ID_": "resource_id",
    "REMOVAL_TIME_": "removal_time",
    "LAST_UPDATED_": "last_updated",
    "TASK_STATE_": "task_state",
    "INCIDENT_TIMESTAMP_": "incident_timestamp",
    "INCIDENT_MSG_": "incident_message",
    "INCIDENT_TYPE_": "incident_type",
    "CAUSE_INCIDENT_ID_": "cause_incident_id",
    "ROOT_CAUSE_INCIDENT_ID_": "root_cause_incident_id",
    "CONFIGURATION_": "configuration",
    "ANNOTATION_": "annotation",
    "EVENT_TYPE_": "event_type",
    "EVENT_NAME_": "event_name",
    "CREATED_": "created",
    "TOPIC_NAME_": "topic_name",
    "WORKER_ID_": "worker_id",
    "ERROR_MSG_": "error_message",
    "ERROR_DETAILS_ID_": "error_details_id",
    "LAST_FAILURE_LOG_ID_": "last_failure_log_id",
    "HAS_START_FORM_KEY_": "has_start_form_key",
    "STARTABLE_": "is_startable",
    "VERSION_TAG_": "version_tag",
    "HISTORY_TTL_": "history_time_to_live",
    "TOTAL_JOBS_": "total_jobs",
    "JOBS_CREATED_": "jobs_created",
    "JOBS_PER_SEED_": "jobs_per_seed",
    "INVOCATIONS_PER_JOB_": "invocations_per_job",
    "SEED_JOB_DEF_ID_": "seed_job_definition_id",
    "MONITOR_JOB_DEF_ID_": "monitor_job_definition_id",
    "BATCH_JOB_DEF_ID_": "batch_job_definition_id",
    "CREATE_USER_ID_": "create_user_id",
    "EXEC_START_TIME_": "execution_start_time",
    "IS_ACTIVE_": "is_active",
    "IS_CONCURRENT_": "is_concurrent",
    "IS_SCOPE_": "is_scope",
    "IS_EVENT_SCOPE_": "is_event_scope",
    "CACHED_ENT_STATE_": "cached_entity_state",
    "DELEGATION_": "delegation_state",
    "FIRST_": "first_name",
    "LAST_": "last_name",
    "EMAIL_": "email",
    "PWD_": "password",
    "SALT_": "salt",
    "ATTEMPTS_": "attempts",
    "PICTURE_ID_": "picture_id",
    "BYTES_": "bytes",
    "GENERATED_": "is_generated",
    "TIMESTAMP_": "timestamp",
    "VALUE_": "value",
    "REPORTER_": "reporter",
    "MILLISECONDS_": "milliseconds",
    "ASSIGNEE_HASH_": "assignee_hash",
    "QUERY_": "query",
    "PROPERTIES_": "properties",
    "FULL_MSG_": "full_message",
    "ACTION_": "action",
    "MESSAGE_": "message",
    "TIME_": "event_time",
    "URL_": "url",
    "CONTENT_ID_": "content_id",
    # History-specific
    "START_USER_ID_": "start_user_id",
    "START_ACT_ID_": "start_activity_id",
    "END_ACT_ID_": "end_activity_id",
    "SUPER_PROCESS_INSTANCE_ID_": "super_process_instance_id",
    "SUPER_CASE_INSTANCE_ID_": "super_case_instance_id",
    "STATE_": "state",
    "RESTARTED_PROC_INST_ID_": "restarted_process_instance_id",
    "PARENT_ACT_INST_ID_": "parent_activity_instance_id",
    "ACT_NAME_": "activity_name",
    "ACT_TYPE_": "activity_type",
    "ACT_INST_STATE_": "activity_instance_state",
    "CALL_PROC_INST_ID_": "called_process_instance_id",
    "CALL_CASE_INST_ID_": "called_case_instance_id",
    "TASK_ASSIGNEE_": "task_assignee",
    "BYTEARRAY_ID_": "byte_array_id",
    "DOUBLE_": "double_value",
    "LONG_": "long_value",
    "TEXT_": "text_value",
    "TEXT2_": "text2_value",
    "VAR_SCOPE_": "variable_scope_id",
    "IS_CONCURRENT_LOCAL_": "is_concurrent_local",
    "VAR_TYPE_": "variable_type",
    "VAR_INST_ID_": "variable_instance_id",
    "OPERATION_ID_": "operation_id",
    "OPERATION_TYPE_": "operation_type",
    "ASSIGNER_ID_": "assigner_id",
    "INITIAL_": "is_initial",
    "COLLECT_VALUE_": "collect_result_value",
    "EVAL_TIME_": "evaluation_time",
    "ROOT_DEC_INST_ID_": "root_decision_instance_id",
    "CLAUSE_ID_": "clause_id",
    "CLAUSE_NAME_": "clause_name",
    "RULE_ID_": "rule_id",
    "RULE_ORDER_": "rule_order",
    "VAR_NAME_": "variable_name",
    "DEC_INST_ID_": "decision_instance_id",
    "EXT_TASK_ID_": "external_task_id",
    "JOB_ID_": "job_id",
    "JOB_DUEDATE_": "job_due_date",
    "JOB_RETRIES_": "job_retries",
    "JOB_PRIORITY_": "job_priority",
    "JOB_EXCEPTION_MSG_": "job_exception_message",
    "JOB_EXCEPTION_STACK_ID_": "job_exception_stack_id",
    "JOB_STATE_": "job_state",
    "JOB_DEF_TYPE_": "job_definition_type",
    "JOB_DEF_CONFIGURATION_": "job_definition_configuration",
    "HOSTNAME_": "hostname",
    "CLOSE_TIME_": "close_time",
    "PREV_STATE_": "previous_state",
    "CURRENT_STATE_": "current_state",
    "REQUIRED_": "is_required",
    "SENTRY_ID_": "sentry_id",
    "SOURCE_CASE_EXEC_ID_": "source_case_execution_id",
    "STANDARD_EVENT_": "standard_event",
    "SOURCE_": "source",
    "VARIABLE_EVENT_": "variable_event",
    "VARIABLE_NAME_": "variable_name",
    "SATISFIED_": "is_satisfied",
    "CASE_ACT_ID_": "case_activity_id",
    "CASE_ACT_NAME_": "case_activity_name",
    "CASE_ACT_TYPE_": "case_activity_type",
    "INCIDENT_STATE_": "incident_state",
    "HISTORY_CONFIGURATION_": "history_configuration",
    "ENTITY_TYPE_": "entity_type",
    "PROPERTY_": "property",
    "ORG_VALUE_": "original_value",
    "NEW_VALUE_": "new_value",
    "EXTERNAL_TASK_ID_": "external_task_id",
    "ACTIVITY_ID_": "activity_id",
    "FAILED_ACTIVITY_ID_": "failed_activity_id",
}


def col_to_slot(col_name: str) -> str:
    """Map a SQL column name to a LinkML slot name."""
    upper = col_name.upper()
    if upper in COLUMN_SLOT_OVERRIDES:
        return COLUMN_SLOT_OVERRIDES[upper]
    return _col_to_slot_name(col_name)


def sql_type_to_range(sql_type: str) -> str:
    """Map a SQL type string to a LinkML range."""
    t = sql_type.lower().strip()
    # Handle parameterized types
    base = re.sub(r"\(.*\)", "", t).strip()
    return SQL_TYPE_MAP.get(base, "string")


# ---------------------------------------------------------------------------
# LinkML Generator
# ---------------------------------------------------------------------------


class LinkMLGenerator:
    """Convert parsed SQL tables into LinkML schema dicts."""

    def __init__(
        self,
        tables: dict[str, SqlTable],
        javadoc: dict[str, JavadocInfo] | None = None,
        project_version: str = "",
        source_sql_dir: Path | None = None,
        source_sql_files: list[str] | None = None,
    ):
        self.tables = tables
        self.javadoc = javadoc or {}
        self.project_version = project_version
        self.source_sql_dir = source_sql_dir or DEFAULT_SQL_DIR
        self.source_sql_files = source_sql_files or []
        # All slot definitions keyed by slot name
        self.all_slots: dict[str, SlotDef] = {}
        # Track which module "owns" (first defines) each slot
        self._slot_owner: dict[str, str] = {}
        # Classes keyed by name
        self.classes: dict[str, ClassDef] = {}
        # Build everything
        self._build_abstract_bases()
        self._build_classes()
        self._assign_slot_ownership()
        self._apply_javadoc_descriptions()

    def _module_annotations(
        self,
        module_name: str,
        module_classes: dict[str, ClassDef],
        slots_dict: OrderedDict[str, dict],
    ) -> OrderedDict[str, object]:
        """Return deterministic schema-level annotations for a module."""
        annotations: OrderedDict[str, object] = OrderedDict()
        annotations["generated_by"] = "scripts/fluxnova_to_linkml.py"
        annotations["module"] = module_name
        annotations["source_sql_dir"] = _repo_relative(self.source_sql_dir)
        annotations["class_count"] = len(module_classes)
        annotations["slot_count"] = len(slots_dict)
        if module_name == "base":
            annotations["enum_count"] = len(self.generate_enums())
        return annotations

    def _root_annotations(self, modules: list[str]) -> OrderedDict[str, object]:
        """Return deterministic schema-level annotations for the root schema."""
        annotations: OrderedDict[str, object] = OrderedDict()
        annotations["generated_by"] = "scripts/fluxnova_to_linkml.py"
        annotations["source_pom"] = _repo_relative(DEFAULT_POM_PATH)
        annotations["source_sql_dir"] = _repo_relative(self.source_sql_dir)
        annotations["source_sql_file_count"] = len(self.source_sql_files)
        annotations["source_sql_files"] = ", ".join(self.source_sql_files)
        annotations["sql_table_count"] = len(self.tables)
        annotations["mapped_table_count"] = sum(
            1 for table_name in self.tables if table_name in TABLE_TO_CLASS
        )
        annotations["class_count"] = len(self.classes)
        annotations["slot_count"] = len(self.all_slots)
        annotations["enum_count"] = len(self.generate_enums())
        annotations["module_count"] = len(modules)
        return annotations

    def _register_slot(self, slot: SlotDef, module: str) -> None:
        """Register a slot globally; first module wins ownership."""
        if slot.name not in self.all_slots:
            self.all_slots[slot.name] = slot
            self._slot_owner[slot.name] = module
        else:
            # Merge: if existing is less constrained, keep the more constrained
            existing = self.all_slots[slot.name]
            if slot.required and not existing.required:
                pass  # Don't override, use slot_usage instead
            if slot.identifier and not existing.identifier:
                existing.identifier = True

    def _assign_slot_ownership(self) -> None:
        """Reassign slot ownership so each slot is owned by the first module
        (in stable order) that has a class actually using the slot.

        This ensures every slot appears in a ``slots:`` section of exactly
        one module YAML file, and that module imports work correctly.
        """
        MODULE_ORDER = [
            "base", "repository", "runtime", "job", "identity",
            "collaboration", "history",
        ]
        # Collect: for each slot, which modules actually use it
        slot_modules: dict[str, list[str]] = {}
        for cls in self.classes.values():
            for sn in cls.slots:
                slot_modules.setdefault(sn, [])
                if cls.module not in slot_modules[sn]:
                    slot_modules[sn].append(cls.module)

        # Assign ownership to the earliest module in MODULE_ORDER
        for slot_name, modules in slot_modules.items():
            best = None
            for m in MODULE_ORDER:
                if m in modules:
                    best = m
                    break
            if best is None:
                best = modules[0]
            self._slot_owner[slot_name] = best

        # Also ensure slots not used by any class but registered keep their owner
        for sn in self.all_slots:
            if sn not in self._slot_owner:
                self._slot_owner[sn] = "base"

    def _apply_javadoc_descriptions(self) -> None:
        """Apply extracted Javadoc descriptions to classes and slots.

        Priority: fallback constants (curated) > Javadoc extraction > empty.
        """
        # Apply Javadoc-extracted class descriptions
        for class_name, info in self.javadoc.items():
            if info.class_description and class_name in self.classes:
                cls = self.classes[class_name]
                if not cls.description:
                    cls.description = info.class_description

            # Apply method descriptions to slots (only if slot has no description)
            for slot_name, desc in info.method_descriptions.items():
                if slot_name in self.all_slots:
                    slot = self.all_slots[slot_name]
                    if not slot.description:
                        slot.description = desc

        # Apply dynamically generated class descriptions (for classes without Javadoc)
        for class_name, cls in self.classes.items():
            if not cls.description and cls.sql_table and cls.sql_table in self.tables:
                table = self.tables[cls.sql_table]
                cls.description = _generate_class_description(class_name, cls.module, table)

        # Apply dynamically generated slot descriptions (for slots without Javadoc)
        # Build a mapping of slot_name -> (sql_col_name, sql_type, table_name, fk_constraints)
        for table_name, table in self.tables.items():
            if table_name not in TABLE_TO_CLASS:
                continue
            for col in table.columns:
                slot_name = col_to_slot(col.name)
                if slot_name in self.all_slots and not self.all_slots[slot_name].description:
                    desc = _generate_slot_description(
                        slot_name, col.name, col.sql_type, table_name, table.fk_constraints
                    )
                    self.all_slots[slot_name].description = desc

    def _build_abstract_bases(self) -> None:
        """Create abstract base classes and mixins not directly in SQL."""
        # DbEntity — abstract root for all persisted entities
        # (not emitted as a class, but provides shared id slot)

        # ResourceDefinition — abstract base for definition entities
        rd = ClassDef(
            name="ResourceDefinition",
            module="repository",
            description="Abstract base for deployable resource definitions (process, case, decision, form).",
            abstract=True,
            slots=[
                "id", "key", "name", "version", "category",
                "deployment_id", "resource_name", "diagram_resource_name",
                "tenant_id", "history_time_to_live",
            ],
            in_subset=["repository", MODEL_SUBSET],
        )
        self.classes["ResourceDefinition"] = rd

        # HistoricScopeInstance — abstract base for timed history events
        hsi = ClassDef(
            name="HistoricScopeInstance",
            module="history",
            description="Abstract base for historic entities with start/end time and duration.",
            abstract=True,
            slots=[
                "id", "root_process_instance_id", "process_instance_id",
                "process_definition_id", "process_definition_key",
                "start_time", "end_time", "duration", "removal_time",
            ],
            in_subset=["history", MODEL_SUBSET],
        )
        self.classes["HistoricScopeInstance"] = hsi

        # Register base slots
        base_slots = [
            SlotDef("id", "string", required=True, identifier=True,
                    description="Unique identifier.", slot_uri="schema:identifier"),
            SlotDef("key", "string", description="Business key for the definition."),
            SlotDef("name", "string", description="Human-readable name.", slot_uri="schema:name"),
            SlotDef("description", "string", description="Human-readable description.",
                    slot_uri="schema:description"),
            SlotDef("version", "integer", description="Version number."),
            SlotDef("category", "string", description="Category classification."),
            SlotDef("deployment_id", "string", description="Reference to the deployment."),
            SlotDef("resource_name", "string", description="Name of the deployed resource file."),
            SlotDef("diagram_resource_name", "string",
                    description="Name of the diagram resource file."),
            SlotDef("tenant_id", "string", description="Multi-tenancy discriminator."),
            SlotDef("history_time_to_live", "integer",
                    description="Days to retain history before cleanup."),
            SlotDef("revision", "integer", description="Optimistic locking revision."),
            SlotDef("removal_time", "datetime",
                    description="Timestamp when this entity is eligible for removal."),
            SlotDef("root_process_instance_id", "string",
                    description="Root process instance for history cleanup."),
            SlotDef("process_instance_id", "string",
                    description="Reference to the process instance."),
            SlotDef("process_definition_id", "string",
                    description="Reference to the process definition."),
            SlotDef("process_definition_key", "string",
                    description="Key of the process definition."),
            SlotDef("execution_id", "string",
                    description="Reference to the execution."),
            SlotDef("start_time", "datetime", description="Start timestamp."),
            SlotDef("end_time", "datetime", description="End timestamp."),
            SlotDef("duration", "integer", description="Duration in milliseconds."),
            SlotDef("create_time", "datetime", description="Creation timestamp."),
            SlotDef("activity_id", "string", description="BPMN activity element identifier."),
            SlotDef("activity_instance_id", "string",
                    description="Runtime activity instance identifier."),
            SlotDef("task_id", "string", description="Reference to the task."),
            SlotDef("case_definition_id", "string",
                    description="Reference to the case definition."),
            SlotDef("case_instance_id", "string",
                    description="Reference to the case instance."),
            SlotDef("case_execution_id", "string",
                    description="Reference to the case execution."),
            SlotDef("user_id", "string", description="Reference to a user."),
            SlotDef("group_id", "string", description="Reference to a group."),
            SlotDef("batch_id", "string", description="Reference to a batch."),
            SlotDef("job_definition_id", "string",
                    description="Reference to the job definition."),
            SlotDef("type", "string", description="Type discriminator."),
            SlotDef("business_key", "string", description="Domain-specific business key."),
        ]
        for s in base_slots:
            self._register_slot(s, "base")

    def _build_classes(self) -> None:
        """Build class definitions from SQL tables."""
        for table_name, table in sorted(self.tables.items()):
            if table_name not in TABLE_TO_CLASS:
                continue

            class_name, module = TABLE_TO_CLASS[table_name]
            if class_name in ABSTRACT_CLASSES:
                continue  # Already built
            if class_name in self.classes:
                continue  # Already built (e.g. from abstract bases)

            is_a = CLASS_INHERITANCE.get(class_name, "")
            cls = ClassDef(
                name=class_name,
                module=module,
                is_a=is_a,
                sql_table=table_name,
                annotations={"sql_table": table_name},
                in_subset=[module, MODEL_SUBSET],
            )

            # Get inherited slots from parent (if any)
            inherited_slots: set[str] = set()
            if is_a and is_a in self.classes:
                inherited_slots = set(self.classes[is_a].slots)

            for col in table.columns:
                if col.name in SKIP_COLUMNS:
                    continue

                slot_name = col_to_slot(col.name)
                linkml_range = sql_type_to_range(col.sql_type)

                # Check if this column maps to an enum
                if (table_name, col.name) in TABLE_ENUM_COLUMNS:
                    linkml_range = TABLE_ENUM_COLUMNS[(table_name, col.name)]
                elif col.name in ENUM_COLUMNS:
                    linkml_range = ENUM_COLUMNS[col.name]

                # Build slot if not already registered
                # Only 'id' can be an identifier; other PK columns use unique_keys
                is_identifier = (
                    col.is_pk
                    and len(table.pk_columns) == 1
                    and slot_name == "id"
                )
                slot = SlotDef(
                    name=slot_name,
                    range=linkml_range,
                    required=not col.nullable,
                    identifier=is_identifier,
                    annotations={"sql_column": col.name},
                )
                self._register_slot(slot, module)

                # Detect range mismatch: column type differs from global slot
                global_range = self.all_slots[slot_name].range
                range_override = linkml_range if linkml_range != global_range else None

                if slot_name not in inherited_slots:
                    cls.slots.append(slot_name)
                    # Add slot_usage for range overrides or non-id identifiers
                    if range_override:
                        cls.slot_usage.setdefault(slot_name, {})["range"] = range_override
                    if col.is_pk and len(table.pk_columns) == 1 and slot_name != "id":
                        cls.slot_usage.setdefault(slot_name, {})["identifier"] = True
                        cls.slot_usage.setdefault(slot_name, {})["required"] = True
                    elif not col.nullable and slot_name != "id" and not self.all_slots[slot_name].required:
                        cls.slot_usage.setdefault(slot_name, {})["required"] = True
                else:
                    # Slot inherited — use slot_usage only if we refine it
                    usage: dict = {}
                    if not col.nullable and slot_name != "id":
                        usage["required"] = True
                    if range_override:
                        usage["range"] = range_override
                    if usage:
                        cls.slot_usage[slot_name] = usage

            # Only add 'id' if the table actually has an ID_ column as PK
            has_id_pk = any(
                c.name == "ID_" and c.is_pk for c in table.columns
            )
            if has_id_pk and "id" not in cls.slots and "id" not in inherited_slots:
                cls.slots.insert(0, "id")

            # For composite PKs, add unique_keys and mark PK slots as required
            if len(table.pk_columns) > 1:
                pk_slot_names = [col_to_slot(c) for c in table.pk_columns]
                key_name = f"{class_name.lower()}_pk"
                cls.unique_keys[key_name] = {
                    "unique_key_slots": pk_slot_names,
                }
                for slot_name in pk_slot_names:
                    cls.slot_usage.setdefault(slot_name, {})["required"] = True

            self.classes[class_name] = cls

    def generate_enums(self) -> dict:
        """Generate enum definitions."""
        enums: dict[str, dict] = {}

        enums["SuspensionState"] = {
            "description": "Whether an entity is active or suspended.",
            "permissible_values": {
                "ACTIVE": {"description": "The entity is active.", "meaning": "fluxnova_bpm_platform:SuspensionState/1"},
                "SUSPENDED": {"description": "The entity is suspended.", "meaning": "fluxnova_bpm_platform:SuspensionState/2"},
            },
        }

        enums["DelegationState"] = {
            "description": "Delegation states of a task.",
            "permissible_values": {
                "PENDING": {"description": "The task has been delegated and is awaiting resolution."},
                "RESOLVED": {"description": "The delegated task has been resolved by the assignee."},
            },
        }

        enums["ActivityInstanceState"] = {
            "description": "State of an activity instance.",
            "permissible_values": {
                "DEFAULT": {"description": "The activity instance is running normally.", "meaning": "fluxnova_bpm_platform:ActivityInstanceState/0"},
                "SCOPE_COMPLETE": {"description": "The scope of the activity instance is complete.", "meaning": "fluxnova_bpm_platform:ActivityInstanceState/1"},
                "CANCELED": {"description": "The activity instance was canceled.", "meaning": "fluxnova_bpm_platform:ActivityInstanceState/2"},
                "STARTING": {"description": "The activity instance is starting.", "meaning": "fluxnova_bpm_platform:ActivityInstanceState/3"},
                "ENDING": {"description": "The activity instance is ending.", "meaning": "fluxnova_bpm_platform:ActivityInstanceState/4"},
            },
        }

        enums["IncidentState"] = {
            "description": "State of a historic incident.",
            "permissible_values": {
                "OPEN": {"description": "The incident is open."},
                "DELETED": {"description": "The incident has been deleted."},
                "RESOLVED": {"description": "The incident has been resolved."},
            },
        }

        enums["JobState"] = {
            "description": "State of a historic job log entry.",
            "permissible_values": {
                "CREATED": {"description": "The job was created."},
                "FAILED": {"description": "The job execution failed."},
                "SUCCESSFUL": {"description": "The job executed successfully."},
                "DELETED": {"description": "The job was deleted."},
            },
        }

        enums["EntityState"] = {
            "description": "General state of an entity (e.g. variable, process instance).",
            "permissible_values": {
                "ACTIVE": {"description": "Active."},
                "SUSPENDED": {"description": "Suspended."},
                "COMPLETED": {"description": "Completed."},
                "EXTERNALLY_TERMINATED": {"description": "Terminated externally."},
                "INTERNALLY_TERMINATED": {"description": "Terminated internally."},
            },
        }

        enums["AuthorizationType"] = {
            "description": "Type of authorization rule.",
            "permissible_values": {
                "GLOBAL": {"description": "Applies to all users.", "meaning": "fluxnova_bpm_platform:AuthorizationType/0"},
                "GRANT": {"description": "Grants permission.", "meaning": "fluxnova_bpm_platform:AuthorizationType/1"},
                "REVOKE": {"description": "Revokes permission.", "meaning": "fluxnova_bpm_platform:AuthorizationType/2"},
            },
        }

        return enums

    def generate_subsets(self) -> dict:
        """Generate subset definitions for the root schema only.
        
        Per-module schemas do NOT declare subsets to avoid URI conflicts during
        LinkML schema merging. Instead, classes reference subsets via in_subset,
        which are resolved at merge time via the root schema.
        
        The root schema declares both platform module subsets and the BPMN Model
        API subsets (since the unified root imports the BPMN root schema).
        """
        subsets: dict[str, dict] = {}
        
        # Platform module subsets + cross-cutting subset
        for module_name, description in MODULE_SUBSETS.items():
            subsets[module_name] = {"description": description}
        subsets[MODEL_SUBSET] = {"description": "All Fluxnova BPM platform entities."}
        subsets[PLATFORM_SUBSET] = {
            "description": "Top-level platform schema entities (filename-derived subset for fluxnova_bpm_platform.yaml)."
        }

        return subsets

    def generate_common_schema(self) -> dict:
        """Generate the ``fluxnova_common.yaml`` shared-slot schema.

        This schema owns the slots whose names collide between the BPM
        persistence schema and the BPMN Model API schema. By centralizing
        them in a single import, we avoid LinkML's "Conflicting URIs" merge
        error while still letting both sides reference and refine them.

        BPMN classes that need object ranges (e.g. ``properties: Property``)
        refine these slots via ``slot_usage`` in their own schema.
        """
        common: OrderedDict[str, object] = OrderedDict()
        common["id"] = f"https://w3id.org/TD-Universe/fluxnova-bpm-platform/{COMMON_SCHEMA_NAME}"
        common["name"] = COMMON_SCHEMA_NAME
        common["description"] = (
            "Shared slot definitions imported by both the Fluxnova BPM "
            "persistence schema and the Fluxnova BPMN Model API schema. "
            "Centralizing the slots avoids LinkML import-merge URI conflicts."
        )
        common["license"] = "Apache-2.0"
        common["source"] = "https://github.com/finos/fluxnova-bpm-platform"
        if self.project_version:
            common["version"] = self.project_version
        common["annotations"] = OrderedDict([
            ("generated_by", "scripts/fluxnova_to_linkml.py"),
            ("purpose", "Resolve slot-name collisions between BPM and BPMN Model API schemas."),
        ])
        common["prefixes"] = OrderedDict([
            (COMMON_SCHEMA_NAME, f"https://w3id.org/TD-Universe/fluxnova-bpm-platform/{COMMON_SCHEMA_NAME}/"),
            ("linkml", "https://w3id.org/linkml/"),
            ("schema", "http://schema.org/"),
        ])
        common["default_prefix"] = COMMON_SCHEMA_NAME
        common["default_range"] = "string"
        common["imports"] = ["linkml:types"]

        # Slot definitions match the BPM-side semantics so existing BPM data
        # validates unchanged. BPMN classes refine via ``slot_usage`` where a
        # different range/multiplicity is required.
        common["slots"] = {
            "id": {
                "identifier": True,
                "range": "string",
                "required": True,
                "description": "Unique identifier.",
                "slot_uri": "schema:identifier",
            },
            "name": {
                "range": "string",
                "description": "Human-readable name.",
                "slot_uri": "schema:name",
            },
            "category": {
                "range": "string",
                "description": "Category classification.",
            },
            "message": {
                "range": "string",
                "description": "Short message or summary.",
                "annotations": {"sql_column": "MESSAGE_"},
            },
            "properties": {
                "range": "string",
                "description": "Serialized properties.",
                "annotations": {"sql_column": "PROPERTIES_"},
            },
            "source": {
                "range": "string",
                "description": "The source.",
                "annotations": {"sql_column": "SOURCE_"},
            },
            "type": {
                "range": "string",
                "description": "Type discriminator.",
            },
            "value": {
                "range": "string",
                "description": "Value of this variable instance.",
                "annotations": {"sql_column": "VALUE_"},
            },
        }
        return dict(common)

    def generate_module(self, module_name: str) -> dict | None:
        """Generate a LinkML module dict for the given module."""
        module_classes = {
            name: cls
            for name, cls in sorted(self.classes.items())
            if cls.module == module_name
        }
        if not module_classes:
            return None

        # Collect slots used by classes in this module
        module_slot_names: list[str] = []
        for cls in module_classes.values():
            for s in cls.slots:
                if s not in module_slot_names:
                    module_slot_names.append(s)

        # Build slots dict — only include slots owned by this module.
        # SHARED_SLOTS are emitted by ``fluxnova_common.yaml`` instead, so we
        # skip them here and rely on the ``./fluxnova_common`` import below.
        slots_dict: OrderedDict[str, dict] = OrderedDict()
        for sn in sorted(module_slot_names):
            if sn in SHARED_SLOTS:
                continue
            if sn in self.all_slots and self._slot_owner.get(sn) == module_name:
                slot = self.all_slots[sn]
                sd: dict = {}
                if slot.identifier:
                    sd["identifier"] = True
                sd["range"] = slot.range
                if slot.required:
                    sd["required"] = True
                if slot.multivalued:
                    sd["multivalued"] = True
                if slot.description:
                    sd["description"] = slot.description
                if slot.slot_uri:
                    sd["slot_uri"] = slot.slot_uri
                if slot.pattern:
                    sd["pattern"] = slot.pattern
                if slot.annotations:
                    sd["annotations"] = slot.annotations
                if slot.aliases:
                    sd["aliases"] = slot.aliases
                slots_dict[sn] = sd

        # Build classes dict
        classes_dict: OrderedDict[str, dict] = OrderedDict()
        for cls_name, cls in sorted(module_classes.items()):
            cd: dict = {}
            if cls.description:
                cd["description"] = cls.description
            if cls.is_a:
                cd["is_a"] = cls.is_a
            if cls.abstract:
                cd["abstract"] = True
            if cls.mixin:
                cd["mixin"] = True
            if cls.tree_root:
                cd["tree_root"] = True
            if cls.slots:
                cd["slots"] = cls.slots
            if cls.slot_usage:
                cd["slot_usage"] = cls.slot_usage
            if cls.unique_keys:
                cd["unique_keys"] = cls.unique_keys
            if cls.in_subset:
                cd["in_subset"] = cls.in_subset
            if cls.annotations:
                cd["annotations"] = cls.annotations
            classes_dict[cls_name] = cd

        schema_name = f"fluxnova_bpm_{module_name}"
        module_dict: OrderedDict[str, object] = OrderedDict()
        module_dict["id"] = f"https://w3id.org/TD-Universe/fluxnova-bpm-platform/{module_name}"
        module_dict["name"] = schema_name
        module_dict["description"] = f"Fluxnova BPM Platform - {module_name.replace('_', ' ').title()} module."
        module_dict["license"] = "Apache-2.0"
        module_dict["source"] = "https://github.com/finos/fluxnova-bpm-platform"
        module_dict["see_also"] = ["https://fluxnova.finos.org/"]
        if self.project_version:
            module_dict["version"] = self.project_version

        # Collect CURIE prefixes referenced in slot_uri values for this module
        prefixes = OrderedDict([
            (schema_name, f"https://w3id.org/TD-Universe/fluxnova-bpm-platform/{module_name}/"),
            ("linkml", "https://w3id.org/linkml/"),
        ])
        for sn in sorted(module_slot_names):
            if sn in self.all_slots and self._slot_owner.get(sn) == module_name:
                slot = self.all_slots[sn]
                if slot.slot_uri and ":" in slot.slot_uri:
                    prefix = slot.slot_uri.split(":")[0]
                    if prefix not in prefixes:
                        prefixes[prefix] = CURIE_PREFIXES.get(prefix, f"https://w3id.org/{prefix}/")
        module_dict["prefixes"] = prefixes
        module_dict["default_prefix"] = schema_name
        module_dict["default_range"] = "string"

        # Imports: always linkml:types, plus cross-module imports
        imports = ["linkml:types"]
        needed_modules: set[str] = set()
        module_dict["annotations"] = self._module_annotations(
            module_name, module_classes, slots_dict
        )
        for cls in module_classes.values():
            for sn in cls.slots:
                if sn in SHARED_SLOTS:
                    continue  # provided by fluxnova_common, handled below
                owner = self._slot_owner.get(sn)
                if owner and owner != module_name:
                    needed_modules.add(owner)
            if cls.is_a and cls.is_a in self.classes:
                parent_mod = self.classes[cls.is_a].module
                if parent_mod != module_name:
                    needed_modules.add(parent_mod)
        for dep in sorted(needed_modules):
            imports.append(f"./fluxnova_bpm_{dep}")
        # Always import the common schema so SHARED_SLOTS used by classes in
        # this module resolve at merge time.
        if any(sn in SHARED_SLOTS for cls in module_classes.values() for sn in cls.slots):
            imports.append(f"./{COMMON_SCHEMA_NAME}")
        module_dict["imports"] = imports

        if slots_dict:
            module_dict["slots"] = dict(slots_dict)
        if module_name == "base":
            module_dict["enums"] = self.generate_enums()
        
        # NOTE: Do NOT add subsets to per-module schemas.
        # Subset definitions are centralized in the root schema to avoid
        # URI conflicts during LinkML schema merging. Classes still reference
        # subsets (in_subset) which are resolved via the root schema imports.
        
        module_dict["classes"] = dict(classes_dict)

        return dict(module_dict)

    def generate_root_schema(self, modules: list[str]) -> dict:
        """Generate the root schema that imports all modules."""
        imports = ["linkml:types", f"./{COMMON_SCHEMA_NAME}"]
        for m in sorted(modules):
            imports.append(f"./fluxnova_bpm_{m}")
        # Cross-schema import: include the BPMN Model API root schema so the
        # platform root unifies persistence + BPMN metamodel into one entry
        # point. Slots that collide between BPM and BPMN are resolved via
        # ``./fluxnova_common`` (imported above).
        imports.append("./fluxnova_bpmn_model")

        root: OrderedDict[str, object] = OrderedDict()
        root["id"] = "https://w3id.org/TD-Universe/fluxnova-bpm-platform"
        root["name"] = "fluxnova_bpm_platform"
        root["title"] = "Fluxnova BPM Platform"
        root["description"] = (
            "LinkML schema for the Fluxnova BPM Platform data model, "
            "covering process definitions, runtime execution, jobs, identity, "
            "history, and collaboration entities."
        )
        root["license"] = "Apache-2.0"
        root["source"] = "https://github.com/finos/fluxnova-bpm-platform"
        root["see_also"] = [
            "https://TD-Universe.github.io/fluxnova-bpm-platform",
            "https://fluxnova.finos.org/",
        ]
        if self.project_version:
            root["version"] = self.project_version
        root["annotations"] = self._root_annotations(modules)

        root["prefixes"] = OrderedDict([
            ("fluxnova_bpm_platform", "https://w3id.org/TD-Universe/fluxnova-bpm-platform/"),
            ("linkml", "https://w3id.org/linkml/"),
            ("schema", "http://schema.org/"),
            ("dcterms", "http://purl.org/dc/terms/"),
            ("bpmn", "http://www.omg.org/spec/BPMN/20100524/MODEL#"),
        ])
        root["default_prefix"] = "fluxnova_bpm_platform"
        root["default_range"] = "string"
        root["imports"] = imports

        # Add subsets (only in root schema, not in per-module schemas)
        root["subsets"] = self.generate_subsets()

        # Tree-root container slots are declared at schema level (NEVER as
        # ``attributes``) per LinkML authoring conventions: top-level slots
        # plus per-class slot_usage. Each container slot is multivalued and
        # inlined as a list so the root document is a serializable forest.
        container_slot_specs: list[tuple[str, str, str]] = [
            ("deployments", "Deployment", "Deployed resources."),
            ("process_definitions", "ProcessDefinition", "Process definitions."),
            ("executions", "Execution", "Process execution instances."),
            ("tasks", "Task", "User tasks."),
            ("jobs", "Job", "Asynchronous jobs."),
            ("users", "User", "Identity users."),
            ("groups", "Group", "Identity groups."),
            ("batches", "Batch", "Batch operations."),
        ]

        root_slots: OrderedDict[str, dict] = OrderedDict()
        for slot_name, range_class, description in container_slot_specs:
            root_slots[slot_name] = {
                "range": range_class,
                "multivalued": True,
                "inlined_as_list": True,
                "description": description,
            }
        root["slots"] = dict(root_slots)

        # FluxnovaPlatformData references the schema-level slots and refines
        # them through ``slot_usage`` (this is the canonical LinkML pattern).
        slot_usage: OrderedDict[str, dict] = OrderedDict()
        for slot_name, range_class, _ in container_slot_specs:
            slot_usage[slot_name] = {
                "range": range_class,
                "multivalued": True,
                "inlined_as_list": True,
            }

        root["classes"] = {
            "FluxnovaPlatformData": {
                "tree_root": True,
                "description": "Root container for Fluxnova BPM Platform data.",
                "in_subset": [PLATFORM_SUBSET, MODEL_SUBSET],
                "slots": [name for name, _, _ in container_slot_specs],
                "slot_usage": dict(slot_usage),
            },
        }

        return dict(root)


# ---------------------------------------------------------------------------
# YAML Formatting (adapted from reference rosetta_to_linkml.py)
# ---------------------------------------------------------------------------


def _str_representer(dumper: yaml.Dumper, data: str) -> yaml.Node:
    """Use literal block style for multi-line, plain style for single-line."""
    if "\n" in data:
        return dumper.represent_scalar("tag:yaml.org,2002:str", data, style="|")
    return dumper.represent_scalar("tag:yaml.org,2002:str", data)


def _ordered_dict_representer(dumper: yaml.Dumper, data: OrderedDict) -> yaml.Node:
    """Represent OrderedDict as a regular YAML mapping (preserving order)."""
    return dumper.represent_mapping("tag:yaml.org,2002:map", data.items())


def _insert_blank_lines(text: str) -> str:
    """Insert blank lines between top-level YAML sections and between entries
    inside slots/enums/classes for human readability."""
    lines = text.split("\n")
    result: list[str] = []
    current_section = ""
    item_sections = {"slots:", "enums:", "classes:", "types:", "subsets:", "attributes:"}
    major_sections = {
        "prefixes:", "imports:", "types:", "subsets:", "enums:",
        "slots:", "classes:", "attributes:",
    }

    for line in lines:
        if line and not line[0].isspace() and ":" in line:
            key_token = line.split(":")[0] + ":"
            if key_token in major_sections and result and result[-1] != "":
                result.append("")
            current_section = key_token
        elif (
            current_section in item_sections
            and line.startswith("  ")
            and not line.startswith("    ")
            and len(line) > 2
            and line[2] != " "
            and ":" in line
        ):
            if result and result[-1] != "" and not result[-1].rstrip().endswith(":"):
                result.append("")

        result.append(line)

    return "\n".join(result)


def write_yaml(data: dict, path: Path) -> None:
    """Write a dict as YAML with sensible formatting and blank-line separation."""
    path.parent.mkdir(parents=True, exist_ok=True)

    class IndentedDumper(yaml.Dumper):
        """Custom dumper that indents list items under mapping keys."""
        pass

    IndentedDumper.add_representer(str, _str_representer)
    IndentedDumper.add_representer(OrderedDict, _ordered_dict_representer)

    # Increase indent so list items get 2-space offset under their key
    raw = yaml.dump(
        data,
        Dumper=IndentedDumper,
        default_flow_style=False,
        sort_keys=False,
        allow_unicode=True,
        width=120,
        indent=2,
    )
    # PyYAML with indent=2 produces "- item" at the mapping indent level.
    # We need "  - item" (indented under the key). Fix sequences that follow
    # a mapping key by adding 2-space indent to bare "- " lines that should
    # be children of a key.
    lines = raw.split("\n")
    fixed: list[str] = []
    prev_was_seq_key = False
    seq_indent = 0
    for line in lines:
        stripped = line.lstrip()
        current_indent = len(line) - len(stripped)

        if prev_was_seq_key and stripped.startswith("- "):
            # This list item should be indented under its parent key
            if current_indent <= seq_indent:
                line = " " * (seq_indent + 2) + stripped
        # Detect a key whose value is a sequence (key followed by "- " on next line)
        if stripped.endswith(":") or (stripped.endswith(":") and not stripped.startswith("-")):
            prev_was_seq_key = True
            seq_indent = current_indent
        elif stripped.startswith("- "):
            pass  # keep prev_was_seq_key for continuation
        else:
            prev_was_seq_key = False

        fixed.append(line)

    formatted = "---\n" + _insert_blank_lines("\n".join(fixed))
    with open(path, "w", encoding="utf-8") as f:
        f.write(formatted)


# ---------------------------------------------------------------------------
# Completeness Report
# ---------------------------------------------------------------------------


def print_report(tables: dict[str, SqlTable], gen: LinkMLGenerator) -> None:
    """Print a coverage report."""
    mapped_tables = set(TABLE_TO_CLASS.keys()) & set(tables.keys())
    unmapped_tables = set(tables.keys()) - set(TABLE_TO_CLASS.keys())

    total_cols = 0
    total_slots = 0
    for tn in mapped_tables:
        t = tables[tn]
        total_cols += len([c for c in t.columns if c.name not in SKIP_COLUMNS])

    total_slots = len(gen.all_slots)

    print(f"\n{'='*60}")
    print(f"  Fluxnova BPM -> LinkML Completeness Report")
    print(f"{'='*60}")
    print(f"  SQL tables parsed:          {len(tables)}")
    print(f"  SQL tables mapped:          {len(mapped_tables)}")
    print(f"  SQL tables unmapped:        {len(unmapped_tables)}")
    if unmapped_tables:
        for t in sorted(unmapped_tables):
            print(f"    - {t}")
    print(f"  Classes generated:          {len(gen.classes)}")
    print(f"  Slots generated:            {total_slots}")
    print(f"  Enums generated:            {len(gen.generate_enums())}")
    print(f"  Columns in mapped tables:   {total_cols}")
    print()

    # Module breakdown
    modules: dict[str, int] = {}
    for cls in gen.classes.values():
        modules[cls.module] = modules.get(cls.module, 0) + 1
    print("  Module breakdown:")
    for mod, count in sorted(modules.items()):
        print(f"    fluxnova_bpm_{mod}: {count} classes")
    print(f"{'='*60}\n")


# ---------------------------------------------------------------------------
# Main
# ---------------------------------------------------------------------------


def main() -> None:
    parser = argparse.ArgumentParser(
        description="Generate LinkML schema from Fluxnova BPM Platform sources"
    )
    parser.add_argument(
        "--sql-dir",
        type=Path,
        default=DEFAULT_SQL_DIR,
        help="Path to H2 DDL create SQL directory",
    )
    parser.add_argument(
        "--output-dir",
        type=Path,
        default=DEFAULT_OUTPUT_DIR,
        help="Output directory for LinkML schema files",
    )
    parser.add_argument(
        "--dry-run",
        action="store_true",
        help="Print report only, do not write files",
    )
    args = parser.parse_args()

    sql_dir: Path = args.sql_dir
    output_dir: Path = args.output_dir

    if not sql_dir.is_dir():
        print(f"Error: {sql_dir} is not a directory", file=sys.stderr)
        sys.exit(1)

    # ---- Phase 1: Parse SQL DDL ----
    print(f"Parsing SQL DDL from {sql_dir} ...")
    tables = parse_sql_files(sql_dir)
    print(f"  Parsed {len(tables)} tables.")

    # ---- Phase 1b: Extract Javadoc descriptions ----
    print("Extracting Javadoc descriptions from Java interfaces ...")
    javadoc = parse_all_javadoc(REPO_ROOT)
    print(f"  Extracted descriptions for {len(javadoc)} classes.")
    project_version = read_project_version(DEFAULT_POM_PATH)
    sql_source_files = sorted(path.name for path in sql_dir.glob("activiti.h2.create.*.sql"))

    # ---- Phase 2: Generate LinkML ----
    print("Generating LinkML schema ...")
    gen = LinkMLGenerator(
        tables,
        javadoc=javadoc,
        project_version=project_version,
        source_sql_dir=sql_dir,
        source_sql_files=sql_source_files,
    )

    # ---- Report ----
    print_report(tables, gen)

    if args.dry_run:
        print("Dry run — no files written.")
        return

    # ---- Phase 3: Write schema files ----
    output_dir.mkdir(parents=True, exist_ok=True)

    modules_written: list[str] = []
    all_modules = sorted({cls.module for cls in gen.classes.values()})

    # Common shared-slot schema (must be written before module schemas that
    # reference it through ``./fluxnova_common`` imports).
    common_dict = gen.generate_common_schema()
    write_yaml(common_dict, output_dir / f"{COMMON_SCHEMA_NAME}.yaml")
    print(f"  Wrote {COMMON_SCHEMA_NAME}.yaml")

    for module_name in all_modules:
        module_dict = gen.generate_module(module_name)
        if module_dict:
            fname = f"fluxnova_bpm_{module_name}.yaml"
            write_yaml(module_dict, output_dir / fname)
            modules_written.append(module_name)
            print(f"  Wrote {fname}")

    # Root schema
    root_dict = gen.generate_root_schema(modules_written)
    write_yaml(root_dict, output_dir / "fluxnova_bpm_platform.yaml")
    print(f"  Wrote fluxnova_bpm_platform.yaml")

    print(f"\nDone. {len(modules_written) + 2} schema files written to {output_dir}")


if __name__ == "__main__":
    main()
