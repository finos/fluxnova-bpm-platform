#!/usr/bin/env python3
"""Write the engine tables module and the umbrella module from Fluxnova's engine sources.

The script reads the engine's H2 DDL (tables, columns, keys and foreign keys) and the
Javadoc of the engine's Java API (descriptions) from FINOS's tree beside .linkml/,
and writes ``fluxnova_bpm_engine.yaml`` and the umbrella ``fluxnova_bpm_platform.yaml``.
Usage::

    python scripts/fluxnova_to_linkml.py            # write the modules
    python scripts/fluxnova_to_linkml.py --check    # fail if a module would change
"""

from __future__ import annotations

import argparse
import re
import sys
from collections import OrderedDict
from dataclasses import dataclass, field
from pathlib import Path
from typing import Optional


sys.path.insert(0, str(Path(__file__).resolve().parent))
from edition import EDITION  # noqa: E402
from schema_yaml import dump_schema  # noqa: E402


# ---------------------------------------------------------------------------
# Constants
# ---------------------------------------------------------------------------

PROJECT_ROOT = Path(__file__).resolve().parent.parent
# FINOS's tree, which holds the sources the converters read.
REPO_ROOT = PROJECT_ROOT.parent

DEFAULT_SQL_DIR = (
    REPO_ROOT / "engine/src/main/resources/org/finos/fluxnova/bpm/engine/db/create"
)
DEFAULT_OUTPUT_DIR = PROJECT_ROOT / "src/fluxnova_bpm_platform/schema"

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

# Each table's class, before finalize() adds the Fluxnova prefix, and its area.
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
    "ACT_GE_CONFIGURATION": ("Configuration", "base"),
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

# Columns whose text values the engine names, by (table, column): the enum that lists
# them. Each enum's values are the strings the engine writes, as its Java constants
# give them (see generate_enums).
ENUM_COLUMNS: dict[tuple[str, str], str] = {
    ("ACT_HI_PROCINST", "STATE_"): "HistoricProcessInstanceState",
    ("ACT_HI_VARINST", "STATE_"): "HistoricVariableInstanceState",
    ("ACT_RU_TASK", "DELEGATION_"): "DelegationState",
    ("ACT_GE_CONFIGURATION", "STATUS_"): "ConfigurationStatus",
}

# Columns that hold one of the engine's integer state codes, by (table, column), with
# "*" for any table: the Java class that defines the codes, the lowest and highest
# code, and what each code means. The column stays an integer, bounded by the codes.
_CASE_STATE = (
    "engine/impl/cmmn/execution/CaseExecutionState.java",
    0,
    14,
    "0 new, 1 available, 2 enabled, 3 disabled, 4 active, 5 suspended, 6 terminated, "
    "7 completed, 8 failed, 9 closed, 10 terminating on termination, 11 terminating "
    "on parent termination, 12 terminating on exit, 13 suspending on suspension, "
    "14 suspending on parent suspension",
)
_TASK_LOG_STATE = (0, 3, "0 created, 1 failed, 2 successful, 3 deleted")
CODED_COLUMNS: dict[tuple[str, str], tuple[str, int, int, str]] = {
    ("*", "SUSPENSION_STATE_"): (
        "engine/impl/persistence/entity/SuspensionState.java",
        1,
        2,
        "1 active, 2 suspended",
    ),
    ("ACT_HI_ACTINST", "ACT_INST_STATE_"): (
        "engine/impl/pvm/runtime/ActivityInstanceState.java",
        0,
        4,
        "0 default, 1 scope complete, 2 canceled, 3 starting, 4 ending",
    ),
    ("ACT_HI_INCIDENT", "INCIDENT_STATE_"): (
        "engine/history/IncidentState.java",
        0,
        2,
        "0 open, 1 resolved, 2 deleted",
    ),
    ("ACT_HI_JOB_LOG", "JOB_STATE_"): (
        "engine/history/JobState.java",
        *_TASK_LOG_STATE,
    ),
    ("ACT_HI_EXT_TASK_LOG", "STATE_"): (
        "engine/history/ExternalTaskState.java",
        *_TASK_LOG_STATE,
    ),
    ("ACT_RU_AUTHORIZATION", "TYPE_"): (
        "engine/authorization/Authorization.java",
        0,
        2,
        "0 global, 1 grant, 2 revoke",
    ),
    ("ACT_HI_CASEINST", "STATE_"): _CASE_STATE,
    ("ACT_HI_CASEACTINST", "STATE_"): _CASE_STATE,
    ("ACT_RU_CASE_EXECUTION", "CURRENT_STATE_"): _CASE_STATE,
    ("ACT_RU_CASE_EXECUTION", "PREV_STATE_"): _CASE_STATE,
}


def coded_column(table_name: str, column: str) -> tuple[str, int, int, str] | None:
    """The engine's codes for an integer state column, if it holds them."""
    return CODED_COLUMNS.get((table_name, column)) or CODED_COLUMNS.get(("*", column))


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

# The root's lists of four tables' rows, whose plain plural another lmodel copy
# uses as its own key: CVE's configurations, D3FEND's comments and filters and
# OCSF's authorizations. A composite of the copies then gives each key one meaning.
ROOT_SLOT_OVERRIDES: dict[str, str] = {
    "Authorization": "authorization_entries",
    "Comment": "comment_entries",
    "Configuration": "configuration_entries",
    "Filter": "filter_entries",
}

# Classes that are abstract
ABSTRACT_CLASSES: set[str] = {
    "ResourceDefinition",
    "HistoricScopeInstance",
}

# Columns left out: REV_, the engine's optimistic-locking counter.
SKIP_COLUMNS: set[str] = {
    "REV_",
}

# Slots that shared_slots() declares with fixed definitions, in place of definitions
# built from the columns. module_elements() skips them.
SHARED_SLOTS: set[str] = {
    "id",
    "name",
    "category",
    "message",
    "properties",
    "source",
    "type",
    "value",
}

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
    # General
    "Configuration": f"{_ENGINE_BASE}/configuration/Configuration.java",
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
# A class the Javadoc does not describe gets a description built from its name, its
# area and its columns. A slot gets one from its name, its type and its foreign key.


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
            words = re.sub(
                r"(?<!^)(?=[A-Z])", " ", TABLE_TO_CLASS[ref_table][0]
            ).lower()
            article = "an" if words[0] in "aeiou" else "a"
            return f"Reference to {article} {words}."
        return f"Foreign key reference to {ref_table}."

    # Boolean patterns (IS_ prefix columns -> "Whether...")
    if slot_name.startswith("is_"):
        remainder = slot_name[3:].replace("_", " ")
        return f"Whether this entity is {remainder}."

    # Timestamp patterns
    if (
        sql_type in ("timestamp", "datetime")
        or slot_name.endswith("_time")
        or slot_name.endswith("_date")
    ):
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
RE_METHOD = re.compile(r"^\s*(?:\w+\s+)*(\w+)\s+(\w+)\s*\(\s*\)", re.MULTILINE)


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
    # Replace {@link Target label} by its label, or by the target's simple name
    result = re.sub(
        r"\{@\w+\s+((?:[^\s}(]|\([^)]*\))+)(?:\s+([^}]+))?\}",
        lambda m: m.group(2) or re.split(r"[.#]", re.sub(r"\(.*", "", m.group(1)))[-1],
        result,
    )
    # A fully qualified Java name reads as its simple name
    result = re.sub(r"\b(?:[a-z]\w*\.){2,}([A-Z]\w*)", r"\1", result)
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
    # Keep the first sentence: a description says what the element is, and the
    # Javadoc's later sentences are usage notes. A sentence ends at a full stop that
    # is followed by a capital, so "e.g. the" and "1.0" do not end one.
    result = re.split(
        r"(?<=[a-z0-9)\]'])(?<!i\.e)(?<!e\.g)\.\s+(?=[A-Z])", result, maxsplit=1
    )[0].strip()
    if result and not result.endswith((".", "?", "!")):
        result += "."
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
        after_jd = remaining[jd_end : jd_end + 300]
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
    # The column's DEFAULT as the DDL writes it, without quotes.
    default: str | None = None


@dataclass
class SqlTable:
    """A table parsed from DDL."""

    name: str
    columns: list[SqlColumn] = field(default_factory=list)
    pk_columns: list[str] = field(default_factory=list)
    # The table each foreign key's column refers to, by the column.
    fk_constraints: dict[str, str] = field(default_factory=dict)
    # Each unique constraint: its name, empty for one written inside the table, and
    # its columns.
    unique_constraints: list[tuple[str, list[str]]] = field(default_factory=list)


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

RE_CREATE_TABLE = re.compile(r"create\s+table\s+(\w+)\s*\(", re.IGNORECASE)
# A column's line: its name, its type, NOT NULL and its DEFAULT, in the DDL's order.
RE_COLUMN = re.compile(
    r"(\w+)\s+([\w\s\(\)]+?)(?:\s+(NOT\s+NULL))?(?:\s+DEFAULT\s+([^\s,]+))?\s*,?\s*$",
    re.IGNORECASE,
)
RE_PK = re.compile(r"primary\s+key\s*\(([^)]+)\)", re.IGNORECASE)
RE_UNIQUE = re.compile(r"unique\s*\(([^)]+)\)", re.IGNORECASE)
RE_UNIQUE_CONSTRAINT = re.compile(
    r"alter\s+table\s+(\w+)\s+add\s+constraint\s+(\w+)\s+unique\s*\(([^)]+)\)",
    re.IGNORECASE,
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
    unique_stmts: list[tuple[str, str, list[str]]] = []  # (table, name, columns)

    sql_files = sorted(sql_dir.glob("activiti.h2.create.*.sql"))
    if not sql_files:
        print(f"Warning: no SQL files found in {sql_dir}", file=sys.stderr)
        return tables

    for sql_file in sql_files:
        content = sql_file.read_text(encoding="utf-8")

        # Extract foreign key ALTER TABLE statements
        for m in RE_FK.finditer(content):
            fk_stmts.append(
                (m.group(1).upper(), m.group(2).upper(), m.group(3).upper())
            )
        for m in RE_UNIQUE_CONSTRAINT.finditer(content):
            columns = [c.strip().upper() for c in m.group(3).split(",")]
            unique_stmts.append((m.group(1).upper(), m.group(2).upper(), columns))

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
                # A computed column holds what the database derives from other
                # columns, for an index; the engine never writes it.
                if re.search(
                    r"\bgenerated\s+always\s+as\b", line_stripped, re.IGNORECASE
                ):
                    continue
                if line_stripped.lower().startswith("unique"):
                    unique = RE_UNIQUE.match(line_stripped)
                    if unique:
                        columns = [
                            c.strip().upper() for c in unique.group(1).split(",")
                        ]
                        table.unique_constraints.append(("", columns))
                    continue

                col_match = RE_COLUMN.match(line_stripped)
                if col_match:
                    col_name = col_match.group(1).upper()
                    raw_type = col_match.group(2).strip().lower()
                    # Normalize type: strip size specifiers
                    raw_type = re.sub(r"\(\d+\)", "", raw_type).strip()
                    raw_type = re.sub(r"\s+", " ", raw_type)
                    not_null = col_match.group(3) is not None
                    is_pk = col_name in table.pk_columns

                    default = col_match.group(4)
                    table.columns.append(
                        SqlColumn(
                            name=col_name,
                            sql_type=raw_type,
                            nullable=not not_null and not is_pk,
                            is_pk=is_pk,
                            default=default.strip("'") if default else None,
                        )
                    )

            if table.columns:
                tables[table_name] = table

    # Apply FK constraints
    for tbl_name, col_name, ref_table in fk_stmts:
        if tbl_name in tables:
            tables[tbl_name].fk_constraints[col_name] = ref_table
    for tbl_name, name, columns in unique_stmts:
        if tbl_name in tables:
            tables[tbl_name].unique_constraints.append((name, columns))

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


def _snake(name: str) -> str:
    """A CamelCase name in snake case: HistoricJobLog is historic_job_log."""
    return re.sub(r"(?<=[a-z0-9])(?=[A-Z])", "_", name).lower()


def _plural(name: str) -> str:
    """A snake-case name in the plural: batch is batches and log_entry is log_entries."""
    if re.search(r"[^aeiou]y$", name):
        return name[:-1] + "ies"
    if name.endswith(("s", "x", "ch", "sh")):
        return name + "es"
    return name + "s"


def _ifabsent(range_: str, default: str) -> str:
    """A column's DEFAULT as an ifabsent value: an integer, a boolean, a string or
    one of an enum's values."""
    if range_ == "boolean":
        return "true" if default.lower() == "true" else "false"
    if range_ == "integer":
        return f"int({default})"
    if range_ == "string":
        return f"string({default})"
    return f"{range_}({default})"


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
    ):
        self.tables = tables
        self.javadoc = javadoc or {}
        # All slot definitions keyed by slot name
        self.all_slots: dict[str, SlotDef] = {}
        # The area that owns each slot, which _assign_slot_ownership() settles
        self._slot_owner: dict[str, str] = {}
        # Classes keyed by name
        self.classes: dict[str, ClassDef] = {}
        # Build everything
        self._build_abstract_bases()
        self._build_classes()
        self._settle_required()
        self._assign_slot_ownership()
        self._apply_descriptions()

    def _register_slot(self, slot: SlotDef, module: str) -> None:
        """Register a slot globally. The first area to register it owns it until
        _assign_slot_ownership() runs, and _settle_required() decides where it is
        required."""
        if slot.name not in self.all_slots:
            self.all_slots[slot.name] = slot
            self._slot_owner[slot.name] = module
        else:
            # The first definition stays, and only the identifier flag is merged.
            existing = self.all_slots[slot.name]
            if slot.identifier and not existing.identifier:
                existing.identifier = True

    def _assign_slot_ownership(self) -> None:
        """Give each slot to the first area, in MODULE_ORDER, whose classes use it, so
        that module_elements() declares each slot once."""
        MODULE_ORDER = [
            "base",
            "repository",
            "runtime",
            "job",
            "identity",
            "collaboration",
            "history",
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

    # Slots whose meaning differs from table to table, so that no one table's Javadoc
    # describes them.
    SHARED_DESCRIPTIONS = {
        "state": "The row's state; which values it takes depends on its table.",
    }

    def _javadoc(self, class_name: str, slot_name: str) -> str:
        """The Javadoc sentence that describes a class's slot: its interface's getter,
        or the getter of the interface its base renders."""
        for name in (class_name, CLASS_INHERITANCE.get(class_name, "")):
            info = self.javadoc.get(name)
            if info and info.method_descriptions.get(slot_name):
                return info.method_descriptions[slot_name]
        return ""

    def _slots_of(self, cls: ClassDef) -> list[str]:
        """A class's slots, with those it inherits from its base."""
        base = self.classes.get(cls.is_a) if cls.is_a else None
        return (base.slots if base else []) + cls.slots

    def _apply_descriptions(self) -> None:
        """Give each class and slot its description.

        A class takes its interface's Javadoc, or a description built from its table.
        A slot's definition takes the Javadoc when every class that has the slot says
        the same. Otherwise it keeps a description that fits every table, from
        SHARED_DESCRIPTIONS, the slot's registration or its column. Each class whose
        Javadoc describes the slot says so in its slot_usage, or in its base's when
        every subclass's Javadoc agrees.
        """
        for class_name, cls in self.classes.items():
            info = self.javadoc.get(class_name)
            if not cls.description and info and info.class_description:
                cls.description = info.class_description
            if not cls.description and cls.sql_table in self.tables:
                cls.description = _generate_class_description(
                    class_name, cls.module, self.tables[cls.sql_table]
                )

        # The first column of each slot's name, for a description built from it.
        columns: dict[str, tuple[SqlColumn, SqlTable]] = {}
        for table_name, table in self.tables.items():
            if table_name in TABLE_TO_CLASS:
                for col in table.columns:
                    columns.setdefault(col_to_slot(col.name), (col, table))

        for slot_name, slot in self.all_slots.items():
            holders = [
                cls
                for cls in self.classes.values()
                if not cls.abstract and slot_name in self._slots_of(cls)
            ]
            said = {cls.name: self._javadoc(cls.name, slot_name) for cls in holders}
            sentences = set(said.values())
            if slot_name in self.SHARED_DESCRIPTIONS:
                slot.description = self.SHARED_DESCRIPTIONS[slot_name]
            elif holders and len(sentences) == 1 and "" not in sentences:
                slot.description = sentences.pop()
                continue
            if not slot.description and slot_name in columns:
                col, table = columns[slot_name]
                slot.description = _generate_slot_description(
                    slot_name, col.name, col.sql_type, table.name, table.fk_constraints
                )
            for base in self.classes.values():
                if not base.abstract or slot_name not in base.slots:
                    continue
                children = [cls for cls in holders if cls.is_a == base.name]
                told = {said[cls.name] for cls in children}
                if len(told) == 1 and "" not in told:
                    sentence = told.pop()
                    if sentence != slot.description:
                        usage = base.slot_usage.setdefault(slot_name, {})
                        usage["description"] = sentence
                    for cls in children:
                        said[cls.name] = ""
            for cls in holders:
                if said[cls.name] and said[cls.name] != slot.description:
                    usage = cls.slot_usage.setdefault(slot_name, {})
                    usage["description"] = said[cls.name]

    def _shared_columns(self, base: str) -> list[str]:
        """The slots of the columns every table of a base's subclasses has, in the
        order of the first such table. A base holds only these, so no subclass
        inherits a slot that its table lacks."""
        columns = [
            [
                col_to_slot(c.name)
                for c in self.tables[table].columns
                if c.name not in SKIP_COLUMNS
            ]
            for table, (name, _) in TABLE_TO_CLASS.items()
            if CLASS_INHERITANCE.get(name) == base and table in self.tables
        ]
        if not columns:
            return []
        shared = set(columns[0]).intersection(*columns[1:])
        return [s for s in columns[0] if s in shared]

    def _settle_required(self) -> None:
        """Make a slot required only where its column is not null.

        A slot's definition is required when its column is not null in every table
        that has it. Otherwise each class whose table makes the column not null
        says so in its slot_usage.
        """
        not_null: dict[str, list[bool]] = {}
        for cls in self.classes.values():
            if cls.sql_table:
                for col in self.tables[cls.sql_table].columns:
                    if col.name not in SKIP_COLUMNS:
                        name = col_to_slot(col.name)
                        not_null.setdefault(name, []).append(not col.nullable)
        for name, slot in self.all_slots.items():
            if not slot.identifier:
                slot.required = bool(not_null.get(name)) and all(not_null[name])
        for cls in self.classes.values():
            if not cls.sql_table:
                continue
            for col in self.tables[cls.sql_table].columns:
                name = col_to_slot(col.name)
                if col.name in SKIP_COLUMNS or self.all_slots[name].identifier:
                    continue
                usage = cls.slot_usage.get(name, {})
                if usage.get("identifier"):
                    continue
                if not col.nullable and not self.all_slots[name].required:
                    cls.slot_usage.setdefault(name, {})["required"] = True
                elif "required" in usage:
                    del usage["required"]
                    if not usage:
                        del cls.slot_usage[name]

    def _build_abstract_bases(self) -> None:
        """Create abstract base classes and mixins not directly in SQL."""
        # DbEntity, the abstract root of every persisted entity, is not written as a
        # class: it gives only the shared id slot.

        # ResourceDefinition: the abstract base of the definition entities.
        rd = ClassDef(
            name="ResourceDefinition",
            module="repository",
            description=(
                "Abstract base of the process, case, decision, decision requirements and "
                "form definitions, with the columns all five tables have."
            ),
            abstract=True,
            slots=self._shared_columns("ResourceDefinition"),
            in_subset=["repository"],
        )
        self.classes["ResourceDefinition"] = rd

        # HistoricScopeInstance: the abstract base of the timed history events.
        historic_scope = ClassDef(
            name="HistoricScopeInstance",
            module="history",
            description=(
                "Abstract base of the historic process, activity, task, case and case "
                "activity instances, with the columns all five tables have."
            ),
            abstract=True,
            slots=self._shared_columns("HistoricScopeInstance"),
            in_subset=["history"],
        )
        self.classes["HistoricScopeInstance"] = historic_scope

        # Register base slots
        base_slots = [
            SlotDef(
                "id",
                "string",
                required=True,
                identifier=True,
                description="Unique identifier.",
                slot_uri="schema:identifier",
            ),
            SlotDef("key", "string", description="The row's key."),
            SlotDef(
                "name",
                "string",
                description="Human-readable name.",
                slot_uri="schema:name",
            ),
            SlotDef(
                "description",
                "string",
                description="Human-readable description.",
                slot_uri="schema:description",
            ),
            SlotDef("version", "integer", description="Version number."),
            SlotDef("category", "string", description="Category classification."),
            SlotDef(
                "deployment_id", "string", description="Reference to the deployment."
            ),
            SlotDef(
                "resource_name",
                "string",
                description="Name of the deployed resource file.",
            ),
            SlotDef(
                "diagram_resource_name",
                "string",
                description="Name of the diagram resource file.",
            ),
            SlotDef("tenant_id", "string", description="Multi-tenancy discriminator."),
            SlotDef(
                "history_time_to_live",
                "integer",
                description="Days to retain history before cleanup.",
            ),
            SlotDef("revision", "integer", description="Optimistic locking revision."),
            SlotDef(
                "removal_time",
                "datetime",
                description="Timestamp when this entity is eligible for removal.",
            ),
            SlotDef(
                "root_process_instance_id",
                "string",
                description="Root process instance for history cleanup.",
            ),
            SlotDef(
                "process_instance_id",
                "string",
                description="Reference to the process instance.",
            ),
            SlotDef(
                "process_definition_id",
                "string",
                description="Reference to the process definition.",
            ),
            SlotDef(
                "process_definition_key",
                "string",
                description="Key of the process definition.",
            ),
            SlotDef(
                "execution_id", "string", description="Reference to the execution."
            ),
            SlotDef("start_time", "datetime", description="Start timestamp."),
            SlotDef("end_time", "datetime", description="End timestamp."),
            SlotDef("duration", "integer", description="Duration in milliseconds."),
            SlotDef("create_time", "datetime", description="Creation timestamp."),
            SlotDef(
                "activity_id", "string", description="BPMN activity element identifier."
            ),
            SlotDef(
                "activity_instance_id",
                "string",
                description="Runtime activity instance identifier.",
            ),
            SlotDef("task_id", "string", description="Reference to the task."),
            SlotDef(
                "case_definition_id",
                "string",
                description="Reference to the case definition.",
            ),
            SlotDef(
                "case_instance_id",
                "string",
                description="Reference to the case instance.",
            ),
            SlotDef(
                "case_execution_id",
                "string",
                description="Reference to the case execution.",
            ),
            SlotDef("user_id", "string", description="Reference to a user."),
            SlotDef("group_id", "string", description="Reference to a group."),
            SlotDef("batch_id", "string", description="Reference to a batch."),
            SlotDef(
                "job_definition_id",
                "string",
                description="Reference to the job definition.",
            ),
            SlotDef("type", "string", description="Type discriminator."),
            SlotDef(
                "business_key", "string", description="Domain-specific business key."
            ),
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
                continue  # Already built (for example, from the abstract bases)

            is_a = CLASS_INHERITANCE.get(class_name, "")
            cls = ClassDef(
                name=class_name,
                module=module,
                is_a=is_a,
                sql_table=table_name,
                annotations={"sql_table": table_name},
                in_subset=[module],
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

                # A column of the engine's text values takes their enum
                if (table_name, col.name) in ENUM_COLUMNS:
                    linkml_range = ENUM_COLUMNS[(table_name, col.name)]

                # Build slot if not already registered
                # Only 'id' can be an identifier; other PK columns use unique_keys
                is_identifier = (
                    col.is_pk and len(table.pk_columns) == 1 and slot_name == "id"
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
                        cls.slot_usage.setdefault(slot_name, {})["range"] = (
                            range_override
                        )
                    if col.is_pk and len(table.pk_columns) == 1 and slot_name != "id":
                        cls.slot_usage.setdefault(slot_name, {})["identifier"] = True
                        cls.slot_usage.setdefault(slot_name, {})["required"] = True
                    elif (
                        not col.nullable
                        and slot_name != "id"
                        and not self.all_slots[slot_name].required
                    ):
                        cls.slot_usage.setdefault(slot_name, {})["required"] = True
                else:
                    # The slot is inherited: use slot_usage only to refine it.
                    usage: dict = {}
                    if not col.nullable and slot_name != "id":
                        usage["required"] = True
                    if range_override:
                        usage["range"] = range_override
                    if usage:
                        cls.slot_usage[slot_name] = usage

            for col in table.columns:
                if col.name in SKIP_COLUMNS:
                    continue
                slot_name = col_to_slot(col.name)
                # A foreign key refers to the row of the class its table renders.
                target = table.fk_constraints.get(col.name)
                if target in TABLE_TO_CLASS:
                    cls.slot_usage.setdefault(slot_name, {})["range"] = TABLE_TO_CLASS[
                        target
                    ][0]
                coded = coded_column(table_name, col.name)
                if coded:
                    source, low, high, meanings = coded
                    usage = cls.slot_usage.setdefault(slot_name, {})
                    usage["minimum_value"] = low
                    usage["maximum_value"] = high
                    usage["comments"] = [f"Codes, from {source}: {meanings}."]

            # Only add 'id' if the table actually has an ID_ column as PK
            has_id_pk = any(c.name == "ID_" and c.is_pk for c in table.columns)
            if has_id_pk and "id" not in cls.slots and "id" not in inherited_slots:
                cls.slots.insert(0, "id")

            # A composite primary key is a unique key, and its columns are required.
            if len(table.pk_columns) > 1:
                pk_slot_names = [col_to_slot(c) for c in table.pk_columns]
                key_name = f"{class_name.lower()}_pk"
                cls.unique_keys[key_name] = {
                    "description": "The table's primary key.",
                    "unique_key_slots": pk_slot_names,
                }
                for slot_name in pk_slot_names:
                    cls.slot_usage.setdefault(slot_name, {})["required"] = True

            # Each unique constraint of the DDL is a unique key. Where a column of the
            # key may be null, two nulls are never equal, as in SQL.
            nullable = {c.name: c.nullable for c in table.columns}
            for constraint, columns in table.unique_constraints:
                slot_names = [col_to_slot(c) for c in columns]
                key: dict = {
                    "description": (
                        f"The DDL's constraint {constraint}."
                        if constraint
                        else "A unique constraint of the table's DDL."
                    ),
                    "unique_key_slots": slot_names,
                }
                if any(nullable[c] for c in columns):
                    key["consider_nulls_inequal"] = True
                key_name = constraint.lower() or "_".join(
                    [class_name.lower(), *slot_names]
                )
                cls.unique_keys[key_name] = key

            # A column's DEFAULT is its slot's ifabsent value in this class.
            for col in table.columns:
                if col.default is None or col.name in SKIP_COLUMNS:
                    continue
                slot_name = col_to_slot(col.name)
                usage = cls.slot_usage.setdefault(slot_name, {})
                range_ = usage.get("range") or self.all_slots[slot_name].range
                usage["ifabsent"] = _ifabsent(range_, col.default)

            self.classes[class_name] = cls

    def generate_enums(self) -> dict:
        """The enums of the columns that hold the engine's text values.

        Each value is the string the engine writes, from the Java constants named in
        its enum's comment.
        """
        return {
            "HistoricProcessInstanceState": {
                "description": "The state a historic process instance records.",
                "comments": [
                    "Values from engine/history/HistoricProcessInstance.java."
                ],
                "permissible_values": {
                    "ACTIVE": {"description": "The process instance is running."},
                    "SUSPENDED": {"description": "The process instance is suspended."},
                    "COMPLETED": {
                        "description": "The process instance reached an end event."
                    },
                    "EXTERNALLY_TERMINATED": {
                        "description": "The process instance was ended from outside, such as through the REST API."
                    },
                    "INTERNALLY_TERMINATED": {
                        "description": "The process instance was ended from within, such as by a terminate end event."
                    },
                },
            },
            "HistoricVariableInstanceState": {
                "description": "Whether a historic variable instance still exists.",
                "comments": [
                    "Values from engine/history/HistoricVariableInstance.java."
                ],
                "permissible_values": {
                    "CREATED": {"description": "The variable exists."},
                    "DELETED": {"description": "The variable was deleted."},
                },
            },
            "ConfigurationStatus": {
                "description": "Whether a configuration entry is in effect.",
                "comments": ["Values from engine/configuration/Configuration.java."],
                "permissible_values": {
                    "ACTIVE": {"description": "The entry is in effect."},
                    "INACTIVE": {
                        "description": "A newer version of the entry replaced it."
                    },
                    "DELETED": {"description": "The entry was deleted, and is kept."},
                },
            },
            "DelegationState": {
                "description": "Where a delegated task stands.",
                "comments": ["Values from engine/task/DelegationState.java."],
                "permissible_values": {
                    "PENDING": {
                        "description": "The task was delegated and waits for the delegate to resolve it."
                    },
                    "RESOLVED": {
                        "description": "The delegate resolved the task and handed it back to its owner."
                    },
                },
            },
        }

    def shared_slots(self) -> dict:
        """The slots SHARED_SLOTS names, with their fixed definitions."""
        return {
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
                "description": "The row's value.",
                "annotations": {"sql_column": "VALUE_"},
            },
        }

    def module_elements(self, module_name: str) -> dict | None:
        """The slots and classes of one area's tables, or None for an area with none."""
        module_classes = {
            name: cls
            for name, cls in sorted(self.classes.items())
            if cls.module == module_name
        }
        if not module_classes:
            return None

        # The slots this area's classes use.
        module_slot_names: list[str] = []
        for cls in module_classes.values():
            for s in cls.slots:
                if s not in module_slot_names:
                    module_slot_names.append(s)

        # The slots this area owns. shared_slots() declares the shared ones.
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

        return {"slots": dict(slots_dict), "classes": dict(classes_dict)}

    def root_elements(self) -> dict:
        """The root class, FluxnovaPlatformData, and the container slots it holds.

        The root holds a list of rows for each table, in a slot named after the
        table's class in the plural, such as historic_process_instances, or as
        ROOT_SLOT_OVERRIDES names it. The container slots are top-level slots, not
        ``attributes``, and the root class refines them in ``slot_usage``.
        """
        names = class_names(self.classes)
        specs = sorted(
            (
                ROOT_SLOT_OVERRIDES.get(cls.name)
                or _plural(_snake(names[cls.name].removeprefix("Fluxnova"))),
                cls.name,
                cls.sql_table,
            )
            for cls in self.classes.values()
            if cls.sql_table
        )
        root_slots = {
            slot_name: {
                "range": class_name,
                "multivalued": True,
                "inlined_as_list": True,
                "description": f"The rows of {table}.",
            }
            for slot_name, class_name, table in specs
        }
        slot_usage = {
            slot_name: {
                "range": class_name,
                "multivalued": True,
                "inlined_as_list": True,
            }
            for slot_name, class_name, _ in specs
        }
        return {
            "slots": root_slots,
            "classes": {
                "FluxnovaPlatformData": {
                    "tree_root": True,
                    "description": (
                        "Root container for Fluxnova BPM Platform data: a list of rows "
                        "for each of the engine's tables."
                    ),
                    "slots": [slot_name for slot_name, _, _ in specs],
                    "slot_usage": slot_usage,
                },
            },
        }


# ---------------------------------------------------------------------------
# The schema's names, namespace and edition
# ---------------------------------------------------------------------------

SCHEMA_ID = "https://w3id.org/lmodel/fluxnova-bpm-platform"
SCHEMA_PREFIX = "fluxnova_bpm_platform"
SQL_SOURCE = "engine/src/main/resources/org/finos/fluxnova/bpm/engine/db/create"
ENGINE_SCHEMA = "fluxnova_bpm_engine"

# What each area of tables holds, by the area the generator files a table under. Each
# area is a subset of the root schema.
MODULE_DESCRIPTIONS = {
    "base": "The general tables: stored bytes, properties, the schema log and the metrics logs.",
    "repository": "The repository tables: deployments and the process, case, decision and form definitions in them.",
    "runtime": "The runtime tables: executions, tasks, variables, event subscriptions, incidents and external tasks.",
    "job": "The job tables: jobs, their definitions and batches.",
    "identity": "The identity tables: users, groups, tenants, their memberships and authorizations.",
    "history": "The history tables: what process, case and decision instances did, kept after they end.",
    "collaboration": "The tables of what people add to tasks and process instances: comments, attachments and filters.",
}


def class_names(classes) -> dict[str, str]:
    """The schema's name for each class the generator builds.

    The classes carry Fluxnova's prefix, as a schema others import asks, so that
    a table's class never meets a BPMN class or another schema's class of the same
    name. ACT_GE_PROPERTY's class is FluxnovaEngineProperty, since the extension
    element camunda:property is FluxnovaProperty.
    """
    names = {name: f"Fluxnova{name}" for name in classes}
    names["Property"] = "FluxnovaEngineProperty"
    return names


def _rename(value, names: dict[str, str]):
    return names.get(value, value) if isinstance(value, str) else value


def finalize(schema: dict, names: dict[str, str], module_of: dict[str, str]) -> dict:
    """Give a generated schema the lmodel names, the one namespace and the edition."""
    out: dict = {}
    name = schema["name"]
    out["id"] = SCHEMA_ID if name == SCHEMA_PREFIX else f"{SCHEMA_ID}/{name}"
    out["name"] = name
    out["title"] = schema.get("title") or (
        "Fluxnova BPM Platform " + name.removeprefix("fluxnova_bpm_").replace("_", " ")
    )
    out["description"] = schema["description"]
    out["version"] = EDITION["version"]
    out["source"] = (
        f"https://github.com/finos/fluxnova-bpm-platform/tree/{EDITION['commit']}/{SQL_SOURCE}"
    )
    out["license"] = "Apache-2.0"
    out["see_also"] = ["https://lmodel.github.io/fluxnova-bpm-platform"]
    out["prefixes"] = {
        SCHEMA_PREFIX: f"{SCHEMA_ID}/",
        "linkml": "https://w3id.org/linkml/",
    }
    out["default_prefix"] = SCHEMA_PREFIX
    out["default_range"] = "string"
    imports = [i.removeprefix("./") for i in schema.get("imports", [])]
    for key in ("subsets", "enums"):
        if schema.get(key):
            out[key] = schema[key]
    for key in ("slots", "classes"):
        if not schema.get(key):
            continue
        renamed: dict = {}
        for element, body in schema[key].items():
            body = dict(body)
            body.pop("slot_uri", None)
            body.pop("related_mappings", None)
            for field_name in ("range", "is_a"):
                if field_name in body:
                    body[field_name] = _rename(body[field_name], names)
            if "slot_usage" in body:
                body["slot_usage"] = {
                    s: {
                        k: _rename(v, names) if k == "range" else v
                        for k, v in u.items()
                    }
                    for s, u in body["slot_usage"].items()
                }
            if "in_subset" in body:
                # Each table's class is in its area's subset; the root is in none.
                areas = [s for s in body["in_subset"] if s in MODULE_DESCRIPTIONS]
                if areas:
                    body["in_subset"] = [f"engine_{a}" for a in areas]
                else:
                    del body["in_subset"]
            renamed[_rename(element, names) if key == "classes" else element] = body
        out[key] = renamed
    # A class this module's ranges name, from another module, is imported.
    needed = set()
    for body in list(out.get("slots", {}).values()) + list(
        out.get("classes", {}).values()
    ):
        ranges = [body.get("range"), body.get("is_a")]
        ranges += [u.get("range") for u in body.get("slot_usage", {}).values()]
        needed |= {module_of[r] for r in ranges if r in module_of}
    needed.discard(name)
    imports += sorted(m for m in needed if m not in imports)
    out["imports"] = imports
    # Keep only the order the keys are read in.
    order = [
        "id",
        "name",
        "title",
        "description",
        "version",
        "source",
        "license",
        "see_also",
        "prefixes",
        "default_prefix",
        "default_range",
        "imports",
        "subsets",
        "enums",
        "slots",
        "classes",
    ]
    return {k: out[k] for k in order if k in out}


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(
        description="Write the platform modules of the schema from Fluxnova's engine sources"
    )
    parser.add_argument(
        "--sql-dir", type=Path, default=DEFAULT_SQL_DIR, help="H2 DDL directory"
    )
    parser.add_argument(
        "--output-dir", type=Path, default=DEFAULT_OUTPUT_DIR, help="where to write"
    )
    parser.add_argument(
        "--check", action="store_true", help="fail if a module would change"
    )
    args = parser.parse_args(argv)

    tables = parse_sql_files(args.sql_dir)
    javadoc = parse_all_javadoc(REPO_ROOT)
    gen = LinkMLGenerator(tables, javadoc=javadoc)
    names = class_names(gen.classes)
    module_of = {
        names[c]: f"fluxnova_bpm_{cls.module}" for c, cls in gen.classes.items()
    }

    # The tables refer to each other across every area, so one module holds them all
    # and the areas are subsets; a module per area would import in cycles.
    module_of = {name: ENGINE_SCHEMA for name in module_of}
    engine: dict = {
        "name": ENGINE_SCHEMA,
        "title": "Fluxnova BPM Platform engine tables",
        "description": (
            "The tables Fluxnova's process engine keeps in its database, one class per "
            "table, as the engine's H2 DDL creates them."
        ),
        "imports": ["linkml:types"],
        "enums": gen.generate_enums(),
        "slots": gen.shared_slots(),
        "classes": {},
    }
    for module_name in sorted({cls.module for cls in gen.classes.values()}):
        module = gen.module_elements(module_name)
        engine["slots"].update(module.get("slots", {}))
        engine["classes"].update(module.get("classes", {}))
    engine["slots"] = dict(sorted(engine["slots"].items()))
    engine["classes"] = dict(sorted(engine["classes"].items()))
    root = {
        "name": SCHEMA_PREFIX,
        "title": "Fluxnova BPM Platform",
        "description": (
            "The tables Fluxnova's process engine keeps, and the BPMN elements its model "
            "API reads, as of Fluxnova 3.1.1."
        ),
        "imports": ["linkml:types", ENGINE_SCHEMA, "fluxnova_bpmn_extension"],
        **gen.root_elements(),
    }
    engine["subsets"] = {
        f"engine_{area}": {"description": MODULE_DESCRIPTIONS[area]}
        for area in MODULE_DESCRIPTIONS
    }
    schemas = {ENGINE_SCHEMA: engine, SCHEMA_PREFIX: root}

    changed = []
    for name, schema in schemas.items():
        path = args.output_dir / f"{name}.yaml"
        text = dump_schema(
            finalize(schema, names, module_of),
            generated_by="scripts/fluxnova_to_linkml.py",
        )
        if args.check:
            if not path.is_file() or path.read_text(encoding="utf-8") != text:
                changed.append(path.name)
        else:
            path.write_text(text, encoding="utf-8")
    if changed:
        print(
            "These modules differ from what the engine's sources give:",
            ", ".join(changed),
        )
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(main())
