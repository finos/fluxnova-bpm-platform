"""Comprehensive tests for scripts/fluxnova_to_linkml.py transformer."""

import sys
import textwrap
from collections import OrderedDict
from pathlib import Path

import pytest
import yaml

# Make the scripts directory importable
SCRIPTS_DIR = Path(__file__).resolve().parent.parent / "scripts"
sys.path.insert(0, str(SCRIPTS_DIR))

from fluxnova_to_linkml import (
    COLUMN_SLOT_OVERRIDES,
    CLASS_INHERITANCE,
    ENUM_COLUMNS,
    SKIP_COLUMNS,
    TABLE_TO_CLASS,
    ClassDef,
    LinkMLGenerator,
    SlotDef,
    SqlColumn,
    SqlTable,
    _col_to_slot_name,
    _insert_blank_lines,
    _str_representer,
    col_to_slot,
    parse_sql_files,
    sql_type_to_range,
    write_yaml,
)


# ---------------------------------------------------------------------------
# Fixtures
# ---------------------------------------------------------------------------

MINIMAL_DDL = textwrap.dedent("""\
    create table ACT_RE_DEPLOYMENT (
        ID_ varchar(64),
        NAME_ varchar(255),
        DEPLOY_TIME_ timestamp,
        SOURCE_ varchar(255),
        TENANT_ID_ varchar(64),
        primary key (ID_)
    );
""")

MULTI_TABLE_DDL = textwrap.dedent("""\
    create table ACT_RE_DEPLOYMENT (
        ID_ varchar(64),
        NAME_ varchar(255),
        DEPLOY_TIME_ timestamp,
        SOURCE_ varchar(255),
        TENANT_ID_ varchar(64),
        primary key (ID_)
    );

    create table ACT_RE_PROCDEF (
        ID_ varchar(64) NOT NULL,
        REV_ integer,
        CATEGORY_ varchar(255),
        NAME_ varchar(255),
        KEY_ varchar(255) NOT NULL,
        VERSION_ integer NOT NULL,
        DEPLOYMENT_ID_ varchar(64),
        RESOURCE_NAME_ varchar(4000),
        DGRM_RESOURCE_NAME_ varchar(4000),
        HAS_START_FORM_KEY_ bit,
        SUSPENSION_STATE_ integer,
        TENANT_ID_ varchar(64),
        VERSION_TAG_ varchar(64),
        HISTORY_TTL_ integer,
        STARTABLE_ boolean NOT NULL default TRUE,
        primary key (ID_)
    );

    create table ACT_RU_TASK (
        ID_ varchar(64),
        REV_ integer,
        EXECUTION_ID_ varchar(64),
        PROC_INST_ID_ varchar(64),
        PROC_DEF_ID_ varchar(64),
        NAME_ varchar(255),
        DESCRIPTION_ varchar(4000),
        OWNER_ varchar(255),
        ASSIGNEE_ varchar(255),
        DELEGATION_ varchar(64),
        PRIORITY_ integer,
        CREATE_TIME_ timestamp,
        LAST_UPDATED_ timestamp,
        DUE_DATE_ timestamp,
        FOLLOW_UP_DATE_ timestamp,
        SUSPENSION_STATE_ integer,
        TENANT_ID_ varchar(64),
        TASK_STATE_ varchar(64),
        primary key (ID_)
    );

    create table ACT_RU_JOB (
        ID_ varchar(64) NOT NULL,
        REV_ integer,
        TYPE_ varchar(255) NOT NULL,
        LOCK_EXP_TIME_ timestamp,
        LOCK_OWNER_ varchar(255),
        EXCLUSIVE_ boolean,
        EXECUTION_ID_ varchar(64),
        ROOT_PROC_INST_ID_ varchar(64),
        PROCESS_INSTANCE_ID_ varchar(64),
        PROCESS_DEF_ID_ varchar(64),
        PROCESS_DEF_KEY_ varchar(255),
        RETRIES_ integer,
        EXCEPTION_MSG_ varchar(4000),
        DUEDATE_ timestamp,
        HANDLER_TYPE_ varchar(255),
        HANDLER_CFG_ varchar(4000),
        DEPLOYMENT_ID_ varchar(64),
        SUSPENSION_STATE_ integer NOT NULL DEFAULT 1,
        JOB_DEF_ID_ varchar(64),
        PRIORITY_ bigint NOT NULL DEFAULT 0,
        TENANT_ID_ varchar(64),
        CREATE_TIME_ timestamp,
        BATCH_ID_ varchar(64),
        primary key (ID_)
    );

    create table ACT_ID_USER (
        ID_ varchar(64),
        REV_ integer,
        FIRST_ varchar(255),
        LAST_ varchar(255),
        EMAIL_ varchar(255),
        PWD_ varchar(255),
        SALT_ varchar(255),
        LOCK_EXP_TIME_ timestamp,
        ATTEMPTS_ integer,
        PICTURE_ID_ varchar(64),
        primary key (ID_)
    );

    create table ACT_ID_GROUP (
        ID_ varchar(64),
        REV_ integer,
        NAME_ varchar(255),
        TYPE_ varchar(255),
        primary key (ID_)
    );

    create table ACT_ID_MEMBERSHIP (
        USER_ID_ varchar(64),
        GROUP_ID_ varchar(64),
        primary key (USER_ID_, GROUP_ID_)
    );

    create table ACT_HI_PROCINST (
        ID_ varchar(64) not null,
        PROC_INST_ID_ varchar(64) not null,
        BUSINESS_KEY_ varchar(255),
        PROC_DEF_KEY_ varchar(255),
        PROC_DEF_ID_ varchar(64) not null,
        START_TIME_ timestamp not null,
        END_TIME_ timestamp,
        REMOVAL_TIME_ timestamp,
        DURATION_ bigint,
        START_USER_ID_ varchar(255),
        START_ACT_ID_ varchar(255),
        END_ACT_ID_ varchar(255),
        SUPER_PROCESS_INSTANCE_ID_ varchar(64),
        ROOT_PROC_INST_ID_ varchar(64),
        TENANT_ID_ varchar(64),
        STATE_ varchar(255),
        primary key (ID_),
        unique (PROC_INST_ID_)
    );

    alter table ACT_ID_MEMBERSHIP
        add constraint ACT_FK_MEMB_GROUP
        foreign key (GROUP_ID_)
        references ACT_ID_GROUP;

    alter table ACT_ID_MEMBERSHIP
        add constraint ACT_FK_MEMB_USER
        foreign key (USER_ID_)
        references ACT_ID_USER;
""")


@pytest.fixture
def minimal_sql_dir(tmp_path):
    """Write minimal DDL to a temp directory."""
    sql_file = tmp_path / "activiti.h2.create.engine.sql"
    sql_file.write_text(MINIMAL_DDL)
    return tmp_path


@pytest.fixture
def multi_table_sql_dir(tmp_path):
    """Write multi-table DDL to a temp directory."""
    sql_file = tmp_path / "activiti.h2.create.engine.sql"
    sql_file.write_text(MULTI_TABLE_DDL)
    return tmp_path


@pytest.fixture
def real_sql_dir():
    """Path to the actual H2 DDL files in the repo."""
    d = (
        Path(__file__).resolve().parent.parent
        / "engine/src/main/resources/org/finos/fluxnova/bpm/engine/db/create"
    )
    if not d.is_dir():
        pytest.skip("Engine SQL directory not found")
    return d


# ---------------------------------------------------------------------------
# Tests: col_to_slot / _col_to_slot_name
# ---------------------------------------------------------------------------


class TestColToSlot:
    """Test SQL column name -> LinkML slot name conversion."""

    @pytest.mark.parametrize(
        "col, expected",
        [
            ("ID_", "id"),
            ("REV_", "revision"),
            ("NAME_", "name"),
            ("TENANT_ID_", "tenant_id"),
            ("PROC_DEF_ID_", "process_definition_id"),
            ("PROC_INST_ID_", "process_instance_id"),
            ("ROOT_PROC_INST_ID_", "root_process_instance_id"),
            ("EXECUTION_ID_", "execution_id"),
            ("TASK_ID_", "task_id"),
            ("PARENT_TASK_ID_", "parent_task_id"),
            ("ASSIGNEE_", "assignee"),
            ("SUSPENSION_STATE_", "suspension_state"),
            ("DGRM_RESOURCE_NAME_", "diagram_resource_name"),
            ("DELEGATION_", "delegation_state"),
            ("FIRST_", "first_name"),
            ("LAST_", "last_name"),
            ("HISTORY_TTL_", "history_time_to_live"),
            ("HAS_START_FORM_KEY_", "has_start_form_key"),
            ("IS_ACTIVE_", "is_active"),
            ("BYTES_", "bytes"),
            ("DEC_DEF_ID_", "decision_definition_id"),
            ("DEC_REQ_ID_", "decision_requirements_definition_id"),
            ("CASE_INST_ID_", "case_instance_id"),
            ("TIME_", "event_time"),
        ],
    )
    def test_override_mapping(self, col, expected):
        assert col_to_slot(col) == expected

    def test_fallback_to_expansion(self):
        """Columns not in OVERRIDES use _col_to_slot_name expansion."""
        # A fictional column not in overrides
        result = _col_to_slot_name("SOME_CUSTOM_COL_")
        assert result == "some_custom_col"

    def test_abbreviation_expansion(self):
        # Use a column with a single abbreviation to avoid overlapping expansions
        result = _col_to_slot_name("DGRM_NAME_")
        assert "diagram" in result

    def test_case_insensitive_override(self):
        """Override lookup is case-insensitive via .upper()."""
        assert col_to_slot("tenant_id_") == "tenant_id"
        assert col_to_slot("Tenant_Id_") == "tenant_id"


# ---------------------------------------------------------------------------
# Tests: sql_type_to_range
# ---------------------------------------------------------------------------


class TestSqlTypeToRange:
    """Test SQL type -> LinkML range mapping."""

    @pytest.mark.parametrize(
        "sql_type, expected",
        [
            ("varchar", "string"),
            ("varchar(64)", "string"),
            ("varchar(4000)", "string"),
            ("integer", "integer"),
            ("bigint", "integer"),
            ("bit", "boolean"),
            ("boolean", "boolean"),
            ("timestamp", "datetime"),
            ("double precision", "float"),
            ("blob", "string"),
            ("clob", "string"),
            ("long", "integer"),
            ("longvarbinary", "string"),
        ],
    )
    def test_type_mapping(self, sql_type, expected):
        assert sql_type_to_range(sql_type) == expected

    def test_unknown_type_defaults_to_string(self):
        assert sql_type_to_range("xml") == "string"

    def test_whitespace_handling(self):
        assert sql_type_to_range("  varchar  ") == "string"


# ---------------------------------------------------------------------------
# Tests: parse_sql_files
# ---------------------------------------------------------------------------


class TestParseSqlFiles:
    """Test H2 DDL SQL parser."""

    def test_parse_single_table(self, minimal_sql_dir):
        tables = parse_sql_files(minimal_sql_dir)
        assert "ACT_RE_DEPLOYMENT" in tables
        t = tables["ACT_RE_DEPLOYMENT"]
        assert t.name == "ACT_RE_DEPLOYMENT"
        assert len(t.columns) == 5
        assert t.pk_columns == ["ID_"]

    def test_column_names(self, minimal_sql_dir):
        tables = parse_sql_files(minimal_sql_dir)
        col_names = [c.name for c in tables["ACT_RE_DEPLOYMENT"].columns]
        assert "ID_" in col_names
        assert "NAME_" in col_names
        assert "DEPLOY_TIME_" in col_names
        assert "SOURCE_" in col_names
        assert "TENANT_ID_" in col_names

    def test_pk_column_not_nullable(self, minimal_sql_dir):
        tables = parse_sql_files(minimal_sql_dir)
        id_col = next(
            c for c in tables["ACT_RE_DEPLOYMENT"].columns if c.name == "ID_"
        )
        assert id_col.is_pk is True
        assert id_col.nullable is False

    def test_non_pk_column_nullable(self, minimal_sql_dir):
        tables = parse_sql_files(minimal_sql_dir)
        name_col = next(
            c for c in tables["ACT_RE_DEPLOYMENT"].columns if c.name == "NAME_"
        )
        assert name_col.is_pk is False
        assert name_col.nullable is True

    def test_not_null_column(self, multi_table_sql_dir):
        tables = parse_sql_files(multi_table_sql_dir)
        procdef = tables["ACT_RE_PROCDEF"]
        key_col = next(c for c in procdef.columns if c.name == "KEY_")
        assert key_col.nullable is False

    def test_multi_table_parsing(self, multi_table_sql_dir):
        tables = parse_sql_files(multi_table_sql_dir)
        assert "ACT_RE_DEPLOYMENT" in tables
        assert "ACT_RE_PROCDEF" in tables
        assert "ACT_RU_TASK" in tables
        assert "ACT_RU_JOB" in tables
        assert "ACT_ID_USER" in tables
        assert "ACT_ID_GROUP" in tables
        assert "ACT_ID_MEMBERSHIP" in tables
        assert "ACT_HI_PROCINST" in tables

    def test_composite_pk(self, multi_table_sql_dir):
        tables = parse_sql_files(multi_table_sql_dir)
        membership = tables["ACT_ID_MEMBERSHIP"]
        assert sorted(membership.pk_columns) == ["GROUP_ID_", "USER_ID_"]

    def test_fk_constraints(self, multi_table_sql_dir):
        tables = parse_sql_files(multi_table_sql_dir)
        membership = tables["ACT_ID_MEMBERSHIP"]
        assert "GROUP_ID_" in membership.fk_constraints
        assert membership.fk_constraints["GROUP_ID_"] == "ACT_ID_GROUP"
        assert "USER_ID_" in membership.fk_constraints
        assert membership.fk_constraints["USER_ID_"] == "ACT_ID_USER"

    def test_sql_type_parsing(self, multi_table_sql_dir):
        tables = parse_sql_files(multi_table_sql_dir)
        procdef = tables["ACT_RE_PROCDEF"]
        version_col = next(c for c in procdef.columns if c.name == "VERSION_")
        assert "integer" in version_col.sql_type.lower()
        suspension_col = next(
            c for c in procdef.columns if c.name == "SUSPENSION_STATE_"
        )
        assert "integer" in suspension_col.sql_type.lower()

    def test_empty_dir_returns_empty(self, tmp_path):
        tables = parse_sql_files(tmp_path)
        assert tables == {}

    def test_real_sql_all_tables_parsed(self, real_sql_dir):
        """Integration: parse real SQL files; expect ≥49 tables."""
        tables = parse_sql_files(real_sql_dir)
        assert len(tables) >= 49


# ---------------------------------------------------------------------------
# Tests: LinkMLGenerator
# ---------------------------------------------------------------------------


class TestLinkMLGenerator:
    """Test LinkML schema generation from parsed SQL tables."""

    def _make_generator(self, sql_dir):
        tables = parse_sql_files(sql_dir)
        source_sql_files = sorted(path.name for path in sql_dir.glob("*.sql"))
        return LinkMLGenerator(
            tables,
            project_version="test-version",
            source_sql_dir=sql_dir,
            source_sql_files=source_sql_files,
        ), tables

    def test_classes_created(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        assert "Deployment" in gen.classes
        assert "ProcessDefinition" in gen.classes
        assert "Task" in gen.classes
        assert "Job" in gen.classes
        assert "User" in gen.classes
        assert "Group" in gen.classes
        assert "Membership" in gen.classes
        assert "HistoricProcessInstance" in gen.classes

    def test_abstract_bases_exist(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        assert "ResourceDefinition" in gen.classes
        assert gen.classes["ResourceDefinition"].abstract is True
        assert "HistoricScopeInstance" in gen.classes
        assert gen.classes["HistoricScopeInstance"].abstract is True

    def test_inheritance(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        assert gen.classes["ProcessDefinition"].is_a == "ResourceDefinition"
        assert gen.classes["HistoricProcessInstance"].is_a == "HistoricScopeInstance"

    def test_every_class_has_id_slot(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        # Classes with composite PKs (no ID_ column) are exempt
        composite_pk_classes = {"Membership", "TenantMembership"}
        for cls_name, cls in gen.classes.items():
            if cls_name in composite_pk_classes:
                continue
            # Either the class itself has 'id' or it inherits it
            parent = cls.is_a
            parent_slots = set()
            if parent and parent in gen.classes:
                parent_slots = set(gen.classes[parent].slots)
            assert "id" in cls.slots or "id" in parent_slots, (
                f"Class {cls_name} is missing 'id' slot"
            )

    def test_rev_column_skipped(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        for cls in gen.classes.values():
            assert "revision" not in cls.slots, (
                f"Class {cls.name} should not have 'revision' slot (REV_ skipped)"
            )

    def test_slot_registered(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        assert "id" in gen.all_slots
        assert gen.all_slots["id"].identifier is True
        assert "tenant_id" in gen.all_slots
        assert "deployment_id" in gen.all_slots

    def test_enum_column_range(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        # Task has DELEGATION_ mapped to DelegationState
        task = gen.classes["Task"]
        assert "delegation_state" in task.slots
        # The global slot should exist (range set during registration)
        assert "delegation_state" in gen.all_slots

    def test_sql_table_annotation(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        assert gen.classes["Deployment"].annotations["sql_table"] == "ACT_RE_DEPLOYMENT"
        assert gen.classes["Task"].annotations["sql_table"] == "ACT_RU_TASK"

    def test_slot_ownership(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        # 'id' is used by base classes (ResourceDefinition -> repository)
        # and many others; ownership should go to earliest module
        owner = gen._slot_owner.get("id")
        assert owner is not None

    def test_generate_enums(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        enums = gen.generate_enums()
        assert "SuspensionState" in enums
        assert "DelegationState" in enums
        assert "ActivityInstanceState" in enums
        assert "AuthorizationType" in enums
        # Check structure
        ss = enums["SuspensionState"]
        assert "permissible_values" in ss
        assert "ACTIVE" in ss["permissible_values"]
        assert "SUSPENDED" in ss["permissible_values"]
        assert "description" in ss["permissible_values"]["ACTIVE"]

    def test_generate_module_returns_dict(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        mod = gen.generate_module("repository")
        assert mod is not None
        assert mod["name"] == "fluxnova_bpm_repository"
        assert "classes" in mod
        assert "imports" in mod
        assert "linkml:types" in mod["imports"]

    def test_generate_module_nonexistent_returns_none(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        assert gen.generate_module("nonexistent_module") is None

    def test_generate_module_has_prefixes(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        mod = gen.generate_module("repository")
        assert "prefixes" in mod
        assert "linkml" in mod["prefixes"]

    def test_generate_module_has_schema_metadata(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        mod = gen.generate_module("repository")
        assert mod["version"] == "test-version"
        assert mod["annotations"]["generated_by"] == "scripts/fluxnova_to_linkml.py"
        assert mod["annotations"]["module"] == "repository"
        assert mod["annotations"]["class_count"] >= 1

    def test_generate_module_cross_imports(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        # runtime module should import base (for shared slots)
        runtime_mod = gen.generate_module("runtime")
        if runtime_mod:
            # Check that it imports at least linkml:types
            assert "linkml:types" in runtime_mod["imports"]

    def test_generate_root_schema(self, multi_table_sql_dir):
        gen, _ = self._make_generator(multi_table_sql_dir)
        modules = sorted({cls.module for cls in gen.classes.values()})
        root = gen.generate_root_schema(modules)
        assert root["name"] == "fluxnova_bpm_platform"
        assert root["version"] == "test-version"
        assert root["annotations"]["generated_by"] == "scripts/fluxnova_to_linkml.py"
        assert root["annotations"]["source_sql_file_count"] >= 1
        assert root["annotations"]["source_sql_files"]
        assert "FluxnovaPlatformData" in root["classes"]
        assert root["classes"]["FluxnovaPlatformData"]["tree_root"] is True
        # Should import all modules
        for m in modules:
            assert f"./fluxnova_bpm_{m}" in root["imports"]

    def test_id_is_only_identifier(self, multi_table_sql_dir):
        """Only the 'id' slot should be marked as identifier: true."""
        gen, _ = self._make_generator(multi_table_sql_dir)
        for slot_name, slot in gen.all_slots.items():
            if slot.identifier:
                assert slot_name == "id", (
                    f"Slot '{slot_name}' should not be an identifier"
                )

    def test_filename_derived_subsets_present(self, multi_table_sql_dir):
        """Every class in a generated schema file is tagged with the
        filename-derived subset (e.g. ``platform`` for
        ``fluxnova_bpm_platform.yaml``, ``runtime`` for
        ``fluxnova_bpm_runtime.yaml``) plus the cross-cutting ``fluxnova_bpm``
        subset. The root schema must also DECLARE every filename-derived
        subset it references."""
        gen, _ = self._make_generator(multi_table_sql_dir)
        modules = sorted({cls.module for cls in gen.classes.values()})

        # Per-module: every class has [<module>, fluxnova_bpm].
        for module in modules:
            mod = gen.generate_module(module)
            if not mod:
                continue
            for cls_name, cls_dict in mod.get("classes", {}).items():
                in_subset = cls_dict.get("in_subset") or []
                assert module in in_subset, (
                    f"Class {cls_name} in module '{module}' missing "
                    f"filename-derived subset '{module}'; got {in_subset}"
                )
                assert "fluxnova_bpm" in in_subset, (
                    f"Class {cls_name} in module '{module}' missing "
                    f"cross-cutting 'fluxnova_bpm' subset; got {in_subset}"
                )

        # Root: FluxnovaPlatformData has [platform, fluxnova_bpm].
        root = gen.generate_root_schema(modules)
        platform_cls = root["classes"]["FluxnovaPlatformData"]
        assert "platform" in platform_cls["in_subset"], (
            "FluxnovaPlatformData missing filename-derived subset 'platform'; "
            f"got {platform_cls['in_subset']}"
        )
        assert "fluxnova_bpm" in platform_cls["in_subset"]

        # Every referenced subset must be declared in the root subsets dict.
        declared = set(root.get("subsets", {}).keys())
        referenced: set[str] = set()
        for cls_dict in root["classes"].values():
            referenced.update(cls_dict.get("in_subset") or [])
        for module in modules:
            mod = gen.generate_module(module)
            if not mod:
                continue
            for cls_dict in mod.get("classes", {}).values():
                referenced.update(cls_dict.get("in_subset") or [])
        missing = referenced - declared
        assert not missing, (
            f"Subsets referenced via in_subset but not declared in root "
            f"subsets dict: {sorted(missing)}"
        )


# ---------------------------------------------------------------------------
# Tests: LinkMLGenerator with real SQL (integration)
# ---------------------------------------------------------------------------


class TestLinkMLGeneratorReal:
    """Integration tests using real SQL files from the repository."""

    def test_full_generation(self, real_sql_dir):
        tables = parse_sql_files(real_sql_dir)
        gen = LinkMLGenerator(tables)
        assert len(gen.classes) >= 49  # 49 tables + 2 abstract bases
        assert len(gen.all_slots) >= 100

    def test_all_tables_mapped(self, real_sql_dir):
        tables = parse_sql_files(real_sql_dir)
        for table_name in tables:
            assert table_name in TABLE_TO_CLASS, (
                f"Table {table_name} not in TABLE_TO_CLASS mapping"
            )

    def test_all_modules_generate(self, real_sql_dir):
        tables = parse_sql_files(real_sql_dir)
        gen = LinkMLGenerator(tables)
        expected_modules = {
            "base", "repository", "runtime", "job",
            "identity", "collaboration", "history",
        }
        for mod in expected_modules:
            result = gen.generate_module(mod)
            assert result is not None, f"Module {mod} should not be None"
            assert "classes" in result
            assert len(result["classes"]) > 0

    def test_no_slot_declared_but_unowned(self, real_sql_dir):
        """Every slot used by a class must have an owner module."""
        tables = parse_sql_files(real_sql_dir)
        gen = LinkMLGenerator(tables)
        for cls in gen.classes.values():
            for sn in cls.slots:
                assert sn in gen._slot_owner, (
                    f"Slot '{sn}' used by {cls.name} has no owner module"
                )

    def test_slot_in_owner_module_output(self, real_sql_dir):
        """Each slot appears in the slots: section of its owner module.

        Exception: slots in :data:`SHARED_SLOTS` are emitted by
        ``fluxnova_common.yaml`` and intentionally omitted from per-module
        slots dicts to avoid LinkML import-merge URI conflicts.
        """
        from fluxnova_to_linkml import SHARED_SLOTS

        tables = parse_sql_files(real_sql_dir)
        gen = LinkMLGenerator(tables)
        for slot_name, owner_mod in gen._slot_owner.items():
            if slot_name in SHARED_SLOTS:
                continue
            mod_dict = gen.generate_module(owner_mod)
            if mod_dict and "slots" in mod_dict:
                # Slot should be declared in its owner's slots dict
                if any(
                    slot_name in cls.slots
                    for cls in gen.classes.values()
                    if cls.module == owner_mod
                ):
                    assert slot_name in mod_dict["slots"], (
                        f"Slot '{slot_name}' owned by '{owner_mod}' "
                        f"not in module slots dict"
                    )


# ---------------------------------------------------------------------------
# Tests: YAML formatting
# ---------------------------------------------------------------------------


class TestYamlFormatting:
    """Test YAML output formatting utilities."""

    def test_str_representer_single_line(self):
        dumper = yaml.Dumper("")
        node = _str_representer(dumper, "hello world")
        assert node.style is None  # plain style

    def test_str_representer_multi_line(self):
        dumper = yaml.Dumper("")
        node = _str_representer(dumper, "line one\nline two")
        assert node.style == "|"  # literal block

    def test_insert_blank_lines_between_sections(self):
        text = "id: foo\nname: bar\nprefixes:\n  a: b\nimports:\n- c\nslots:\n  x:\n    range: string"
        result = _insert_blank_lines(text)
        lines = result.split("\n")
        # There should be blank lines before prefixes, imports, and slots
        for keyword in ["prefixes:", "imports:", "slots:"]:
            idx = next(i for i, l in enumerate(lines) if l.startswith(keyword))
            assert idx > 0
            assert lines[idx - 1] == "", (
                f"Expected blank line before '{keyword}'"
            )

    def test_insert_blank_lines_between_slot_entries(self):
        text = "slots:\n  slot_a:\n    range: string\n  slot_b:\n    range: integer"
        result = _insert_blank_lines(text)
        lines = result.split("\n")
        # Between slot_a and slot_b there should be a blank line
        idx_b = next(i for i, l in enumerate(lines) if "slot_b:" in l)
        assert lines[idx_b - 1] == ""

    def test_write_yaml_creates_file(self, tmp_path):
        data = {"id": "test", "name": "test_schema"}
        out_file = tmp_path / "test.yaml"
        write_yaml(data, out_file)
        assert out_file.exists()
        content = out_file.read_text()
        assert content.startswith("---")
        assert "id: test" in content

    def test_write_yaml_ordered_dict(self, tmp_path):
        data = OrderedDict([("first", "a"), ("second", "b")])
        out_file = tmp_path / "ordered.yaml"
        write_yaml(data, out_file)
        content = out_file.read_text()
        # Should NOT contain Python-specific OrderedDict tags
        assert "!!python" not in content
        assert "first: a" in content

    def test_write_yaml_creates_parent_dirs(self, tmp_path):
        out_file = tmp_path / "sub" / "dir" / "schema.yaml"
        write_yaml({"id": "x"}, out_file)
        assert out_file.exists()


# ---------------------------------------------------------------------------
# Tests: Constants & mapping tables
# ---------------------------------------------------------------------------


class TestConstants:
    """Test consistency of mapping tables and constants."""

    def test_table_to_class_values_unique(self):
        """Each class name must be unique across all table mappings."""
        class_names = [v[0] for v in TABLE_TO_CLASS.values()]
        duplicates = [n for n in class_names if class_names.count(n) > 1]
        assert duplicates == [], f"Duplicate class names: {set(duplicates)}"

    def test_class_inheritance_parents_exist(self):
        """Every parent in CLASS_INHERITANCE must be in TABLE_TO_CLASS or ABSTRACT_CLASSES."""
        all_class_names = {v[0] for v in TABLE_TO_CLASS.values()}
        from fluxnova_to_linkml import ABSTRACT_CLASSES
        for child, parent in CLASS_INHERITANCE.items():
            assert parent in all_class_names or parent in ABSTRACT_CLASSES, (
                f"Parent class '{parent}' of '{child}' not found"
            )

    def test_enum_columns_use_valid_enums(self):
        """ENUM_COLUMNS values should be valid enum names."""
        valid_enums = {
            "SuspensionState",
            "DelegationState",
            "ActivityInstanceState",
            "IncidentState",
            "JobState",
            "EntityState",
        }
        for col, enum_name in ENUM_COLUMNS.items():
            assert enum_name in valid_enums, (
                f"Enum '{enum_name}' for column '{col}' not recognized"
            )

    def test_skip_columns_has_rev(self):
        assert "REV_" in SKIP_COLUMNS

    def test_all_override_keys_are_uppercase(self):
        """COLUMN_SLOT_OVERRIDES keys should be uppercase with trailing _."""
        for key in COLUMN_SLOT_OVERRIDES:
            assert key == key.upper(), f"Override key '{key}' not uppercase"
            assert key.endswith("_"), f"Override key '{key}' missing trailing _"

    def test_all_override_values_are_snake_case(self):
        """Override values should be lowercase snake_case."""
        for key, val in COLUMN_SLOT_OVERRIDES.items():
            assert val == val.lower(), (
                f"Override value '{val}' for '{key}' not lowercase"
            )
            assert " " not in val, (
                f"Override value '{val}' for '{key}' contains space"
            )


# ---------------------------------------------------------------------------
# Tests: Dataclasses
# ---------------------------------------------------------------------------


class TestDataclasses:
    """Test IR dataclass defaults and structure."""

    def test_sql_column_defaults(self):
        col = SqlColumn(name="FOO_", sql_type="varchar")
        assert col.nullable is True
        assert col.is_pk is False

    def test_sql_table_defaults(self):
        tbl = SqlTable(name="TEST")
        assert tbl.columns == []
        assert tbl.pk_columns == []
        assert tbl.fk_constraints == {}

    def test_slot_def_defaults(self):
        s = SlotDef(name="test_slot")
        assert s.range == "string"
        assert s.required is False
        assert s.multivalued is False
        assert s.identifier is False

    def test_class_def_defaults(self):
        c = ClassDef(name="TestClass", module="base")
        assert c.is_a == ""
        assert c.abstract is False
        assert c.slots == []
        assert c.slot_usage == {}


# ---------------------------------------------------------------------------
# Tests: End-to-end write + reload
# ---------------------------------------------------------------------------


class TestEndToEnd:
    """End-to-end test: generate -> write -> reload YAML."""

    def test_write_and_reload_module(self, multi_table_sql_dir, tmp_path):
        tables = parse_sql_files(multi_table_sql_dir)
        gen = LinkMLGenerator(tables)
        mod = gen.generate_module("repository")
        assert mod is not None

        out_file = tmp_path / "fluxnova_bpm_repository.yaml"
        write_yaml(mod, out_file)

        # Reload and verify structure
        loaded = yaml.safe_load(out_file.read_text())
        assert loaded["name"] == "fluxnova_bpm_repository"
        assert "classes" in loaded
        assert "Deployment" in loaded["classes"]
        assert "ProcessDefinition" in loaded["classes"]
        assert "ResourceDefinition" in loaded["classes"]

    def test_write_and_reload_root(self, multi_table_sql_dir, tmp_path):
        tables = parse_sql_files(multi_table_sql_dir)
        gen = LinkMLGenerator(tables)
        modules = sorted({cls.module for cls in gen.classes.values()})
        root = gen.generate_root_schema(modules)

        out_file = tmp_path / "fluxnova_bpm_platform.yaml"
        write_yaml(root, out_file)

        loaded = yaml.safe_load(out_file.read_text())
        assert loaded["name"] == "fluxnova_bpm_platform"
        assert "FluxnovaPlatformData" in loaded["classes"]
        assert loaded["default_range"] == "string"

    def test_reproducible_output(self, multi_table_sql_dir, tmp_path):
        """Running the generator twice produces identical YAML."""
        dir1 = tmp_path / "run1"
        dir2 = tmp_path / "run2"
        dir1.mkdir()
        dir2.mkdir()

        for run_dir in (dir1, dir2):
            tables = parse_sql_files(multi_table_sql_dir)
            gen = LinkMLGenerator(tables)
            write_yaml(gen.generate_common_schema(), run_dir / "fluxnova_common.yaml")
            for mod_name in sorted({c.module for c in gen.classes.values()}):
                mod = gen.generate_module(mod_name)
                if mod:
                    write_yaml(mod, run_dir / f"fluxnova_bpm_{mod_name}.yaml")
            root = gen.generate_root_schema(
                sorted({c.module for c in gen.classes.values()})
            )
            write_yaml(root, run_dir / "fluxnova_bpm_platform.yaml")

        # Compare all files
        for f in sorted(dir1.glob("*.yaml")):
            f2 = dir2 / f.name
            assert f2.exists(), f"Missing {f.name} in run2"
            assert f.read_text() == f2.read_text(), (
                f"Output differs for {f.name}"
            )

    def test_real_schema_linkml_valid(self, real_sql_dir, tmp_path):
        """Integration: generate schema and validate with linkml-lint."""
        import subprocess
        import shutil

        tables = parse_sql_files(real_sql_dir)
        gen = LinkMLGenerator(tables)
        modules = sorted({cls.module for cls in gen.classes.values()})
        # Common shared-slot schema (imported by every module + the root)
        write_yaml(gen.generate_common_schema(), tmp_path / "fluxnova_common.yaml")
        for mod_name in modules:
            mod = gen.generate_module(mod_name)
            if mod:
                write_yaml(mod, tmp_path / f"fluxnova_bpm_{mod_name}.yaml")
        root = gen.generate_root_schema(modules)
        write_yaml(root, tmp_path / "fluxnova_bpm_platform.yaml")

        # Copy BPMN model schema files (imported by the platform root schema)
        repo_schema_dir = (
            Path(__file__).resolve().parent.parent
            / "src/fluxnova_bpm_platform/schema"
        )
        for bpmn_file in repo_schema_dir.glob("fluxnova_bpmn_model*.yaml"):
            shutil.copy(bpmn_file, tmp_path / bpmn_file.name)

        result = subprocess.run(
            ["linkml-lint", str(tmp_path / "fluxnova_bpm_platform.yaml")],
            capture_output=True,
            text=True,
        )
        assert "No problems found" in result.stdout, (
            f"linkml-lint failed:\n{result.stdout}\n{result.stderr}"
        )
