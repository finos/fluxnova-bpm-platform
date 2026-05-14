"""DDL coverage tests — cross-validates LinkML schema against SQL DDL.

Ensures every mapped SQL table/column is represented in the schema,
and that vendor-supplied test data (from MockProvider.java) exercises
the schema with the values the upstream codebase uses in its own tests.
"""

import re
import sys
from pathlib import Path

import pytest
import yaml

# ---------------------------------------------------------------------------
# Paths
# ---------------------------------------------------------------------------

REPO_ROOT = Path(__file__).resolve().parent.parent
SQL_DIR = (
    REPO_ROOT
    / "engine"
    / "src"
    / "main"
    / "resources"
    / "org"
    / "finos"
    / "fluxnova"
    / "bpm"
    / "engine"
    / "db"
    / "create"
)
SCHEMA_DIR = REPO_ROOT / "src" / "fluxnova_bpm_platform" / "schema"

# Import the transformer's mapping constants so the test stays in sync
sys.path.insert(0, str(REPO_ROOT / "scripts"))
from fluxnova_to_linkml import (  # noqa: E402
    TABLE_TO_CLASS,
    SKIP_COLUMNS,
    COLUMN_SLOT_OVERRIDES,
    col_to_slot,
    parse_sql_files,
)


# ---------------------------------------------------------------------------
# Fixtures
# ---------------------------------------------------------------------------


@pytest.fixture(scope="module")
def sql_tables():
    """Parse all H2 DDL files once."""
    return parse_sql_files(SQL_DIR)


@pytest.fixture(scope="module")
def all_schema_classes():
    """Load every class definition across all module schemas."""
    classes: dict[str, dict] = {}
    for schema_file in sorted(SCHEMA_DIR.glob("fluxnova_bpm_*.yaml")):
        with open(schema_file) as f:
            doc = yaml.safe_load(f)
        for cls_name, cls_def in (doc.get("classes") or {}).items():
            classes[cls_name] = cls_def
    return classes


@pytest.fixture(scope="module")
def all_schema_slots():
    """Load every slot definition across all module schemas."""
    slots: dict[str, dict] = {}
    for schema_file in sorted(SCHEMA_DIR.glob("fluxnova_bpm_*.yaml")):
        with open(schema_file) as f:
            doc = yaml.safe_load(f)
        for slot_name, slot_def in (doc.get("slots") or {}).items():
            slots[slot_name] = slot_def
    return slots


# ---------------------------------------------------------------------------
# Table coverage
# ---------------------------------------------------------------------------


class TestTableCoverage:
    """Every mapped SQL table must have a corresponding LinkML class."""

    def test_all_mapped_tables_exist_in_sql(self, sql_tables):
        """Every TABLE_TO_CLASS key must correspond to a parsed DDL table."""
        for table_name in TABLE_TO_CLASS:
            assert table_name in sql_tables, (
                f"TABLE_TO_CLASS maps {table_name!r} but it was not found in DDL"
            )

    def test_all_mapped_tables_have_classes(self, all_schema_classes):
        """Every TABLE_TO_CLASS value must be a class in the schema."""
        for table_name, (class_name, _module) in TABLE_TO_CLASS.items():
            assert class_name in all_schema_classes, (
                f"TABLE_TO_CLASS maps {table_name} → {class_name} "
                f"but class not found in schema"
            )

    def test_table_count_matches(self, sql_tables):
        """Number of mapped tables == number of TABLE_TO_CLASS entries."""
        mapped_in_ddl = set(TABLE_TO_CLASS.keys()) & set(sql_tables.keys())
        assert len(mapped_in_ddl) == len(TABLE_TO_CLASS), (
            f"Expected {len(TABLE_TO_CLASS)} tables, "
            f"but only {len(mapped_in_ddl)} overlap with DDL"
        )


# ---------------------------------------------------------------------------
# Column-to-slot coverage
# ---------------------------------------------------------------------------


class TestColumnCoverage:
    """Every non-skipped DDL column must map to a LinkML slot."""

    @pytest.fixture(scope="class")
    def class_slots(self, all_schema_classes, all_schema_slots):
        """For each class, collect its effective slot names including inherited."""
        result: dict[str, set[str]] = {}
        for cls_name, cls_def in all_schema_classes.items():
            slots = set()
            # slots: list in class definition
            for s in (cls_def.get("slots") or []):
                slots.add(s)
            # Direct attributes
            for attr_name in (cls_def.get("attributes") or {}):
                slots.add(attr_name)
            # Slot usage
            for su_name in (cls_def.get("slot_usage") or {}):
                slots.add(su_name)
            # Slots from top-level definitions
            for slot_name, slot_def in all_schema_slots.items():
                domain = slot_def.get("domain")
                if domain == cls_name:
                    slots.add(slot_name)
                owner = slot_def.get("owner")
                if owner == cls_name:
                    slots.add(slot_name)
            result[cls_name] = slots

        # Resolve inheritance: add parent slots to child classes
        for cls_name, cls_def in all_schema_classes.items():
            parent = cls_def.get("is_a")
            if parent and parent in result:
                result[cls_name] |= result[parent]
            for mixin in (cls_def.get("mixins") or []):
                if mixin in result:
                    result[cls_name] |= result[mixin]

        return result

    def test_every_column_has_slot(self, sql_tables, class_slots):
        """Each DDL column (except SKIP_COLUMNS) must map to a slot."""
        missing = []
        for table_name, (class_name, _module) in TABLE_TO_CLASS.items():
            if table_name not in sql_tables:
                continue
            table = sql_tables[table_name]
            slots = class_slots.get(class_name, set())
            # Also check parent class slots for inherited classes
            for col in table.columns:
                if col.name in SKIP_COLUMNS:
                    continue
                slot_name = col_to_slot(col.name)
                if slot_name not in slots:
                    missing.append(
                        f"{table_name}.{col.name} → {class_name}.{slot_name}"
                    )
        assert not missing, (
            f"{len(missing)} DDL columns have no corresponding slot:\n"
            + "\n".join(missing[:20])
        )


# ---------------------------------------------------------------------------
# Schema annotation cross-check
# ---------------------------------------------------------------------------


class TestSchemaAnnotations:
    """Verify sql_table annotations match TABLE_TO_CLASS."""

    def test_sql_table_annotations(self, all_schema_classes):
        """Every class with sql_table annotation must match TABLE_TO_CLASS."""
        reverse_map = {v[0]: k for k, v in TABLE_TO_CLASS.items()}
        for cls_name, cls_def in all_schema_classes.items():
            annotations = cls_def.get("annotations") or {}
            sql_table = annotations.get("sql_table")
            if sql_table:
                sql_val = sql_table if isinstance(sql_table, str) else sql_table.get("value", "")
                expected = reverse_map.get(cls_name)
                if expected:
                    assert sql_val == expected, (
                        f"{cls_name}: sql_table annotation {sql_val!r} "
                        f"does not match TABLE_TO_CLASS {expected!r}"
                    )


# ---------------------------------------------------------------------------
# Vendor data file checks
# ---------------------------------------------------------------------------


class TestVendorDataFiles:
    """Verify vendor-data YAML files exist for key entities."""

    VENDOR_DIR = Path(__file__).parent / "data" / "valid"
    EXPECTED_VENDOR_ENTITIES = [
        "Task",
        "ProcessDefinition",
        "Deployment",
        "Incident",
        "ExternalTask",
        "Job",
        "JobDefinition",
        "Batch",
        "Authorization",
        "Filter",
        "Comment",
        "Attachment",
        "HistoricProcessInstance",
        "HistoricActivityInstance",
        "HistoricTaskInstance",
        "HistoricIncident",
        "HistoricJobLog",
        "HistoricExternalTaskLog",
        "HistoricBatch",
        "HistoricDecisionInstance",
        "HistoricDecisionInputInstance",
        "HistoricDecisionOutputInstance",
        "HistoricCaseInstance",
        "HistoricCaseActivityInstance",
        "HistoricIdentityLink",
        "UserOperationLogEntry",
        "HistoricDetail",
        "VariableInstance",
        "CaseDefinition",
        "DecisionDefinition",
        "DecisionRequirementsDefinition",
        "CaseExecution",
        "EventSubscription",
    ]

    @pytest.mark.parametrize("entity", EXPECTED_VENDOR_ENTITIES)
    def test_vendor_file_exists(self, entity):
        """Each entity listed must have a *-vendor.yaml test file."""
        vendor_file = self.VENDOR_DIR / f"{entity}-vendor.yaml"
        assert vendor_file.exists(), (
            f"Missing vendor data file: {vendor_file.name}"
        )

    @pytest.mark.parametrize("entity", EXPECTED_VENDOR_ENTITIES)
    def test_vendor_file_has_id(self, entity):
        """Each vendor YAML must contain an 'id' field."""
        vendor_file = self.VENDOR_DIR / f"{entity}-vendor.yaml"
        if not vendor_file.exists():
            pytest.skip(f"Vendor file missing: {vendor_file.name}")
        with open(vendor_file) as f:
            data = yaml.safe_load(f)
        assert "id" in data, (
            f"Vendor file {vendor_file.name} is missing 'id' field"
        )

    @pytest.mark.parametrize("entity", EXPECTED_VENDOR_ENTITIES)
    def test_vendor_file_is_valid_yaml(self, entity):
        """Each vendor YAML must be parseable."""
        vendor_file = self.VENDOR_DIR / f"{entity}-vendor.yaml"
        if not vendor_file.exists():
            pytest.skip(f"Vendor file missing: {vendor_file.name}")
        with open(vendor_file) as f:
            data = yaml.safe_load(f)
        assert isinstance(data, dict), (
            f"Vendor file {vendor_file.name} did not parse as a dict"
        )
