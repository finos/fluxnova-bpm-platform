"""Holds the schema to what FINOS's tree states.

The converters write every module from FINOS's tree beside .linkml/. These tests rerun
them in check mode. Then they check what they wrote against the sources: each table,
column, key, default and foreign key of the engine's H2 DDL, each table's Javadoc, the
state codes and values the engine's Java classes define, and each element type the
BPMN model API registers.
"""

import re
import sys
from functools import lru_cache
from pathlib import Path

import pytest
import yaml
from linkml_runtime.utils.schemaview import SchemaView

SCRIPTS = Path(__file__).resolve().parent.parent / "scripts"
sys.path.insert(0, str(SCRIPTS))

import bpmn_to_linkml as bpmn  # noqa: E402
import fluxnova_to_linkml as engine  # noqa: E402

SCHEMA_DIR = SCRIPTS.parent / "src" / "fluxnova_bpm_platform" / "schema"
JAVA = engine.REPO_ROOT / "engine/src/main/java/org/finos/fluxnova/bpm"


@lru_cache(maxsize=1)
def _view() -> SchemaView:
    return SchemaView(str(SCHEMA_DIR / "fluxnova_bpm_platform.yaml"))


@lru_cache(maxsize=1)
def _engine() -> dict:
    return yaml.safe_load(
        (SCHEMA_DIR / "fluxnova_bpm_engine.yaml").read_text(encoding="utf-8")
    )


@lru_cache(maxsize=1)
def _tables() -> dict:
    return engine.parse_sql_files(engine.DEFAULT_SQL_DIR)


def _class_of_table() -> dict[str, str]:
    return {
        body["annotations"]["sql_table"]: name
        for name, body in _engine()["classes"].items()
        if "sql_table" in body.get("annotations", {})
    }


def _slot_of_column(table: str) -> dict[str, object]:
    """Each column's slot in its table's class, by the converter's naming rule."""
    slots = {s.name: s for s in _view().class_induced_slots(_class_of_table()[table])}
    return {
        column.name: slots.get(engine.col_to_slot(column.name))
        for column in _tables()[table].columns
    }


def test_engine_module_is_what_the_ddl_gives():
    assert engine.main(["--check"]) == 0


def test_bpmn_modules_are_what_the_model_api_gives():
    assert bpmn.main(["--check"]) == 0


def test_every_table_has_a_class():
    assert set(_class_of_table()) == set(_tables())


@pytest.mark.parametrize("table", sorted(_tables()))
def test_every_column_has_a_slot(table):
    """Each column, but the revision counter the engine keeps for locking, is a slot,
    required when the column is not null and the class's identifier when it is the
    table's one-column primary key."""
    found = _slot_of_column(table)
    sql = _tables()[table]
    for column in sql.columns:
        if column.name in engine.SKIP_COLUMNS:
            continue
        slot = found[column.name]
        assert slot is not None, column.name
        expected = engine.sql_type_to_range(column.sql_type)
        assert (
            slot.range == expected
            or slot.range in _view().all_enums()
            or (slot.range in _view().all_classes() and expected == "string")
        ), (column.name, slot.range, column.sql_type)
        assert bool(slot.required or slot.identifier) == (not column.nullable), (
            column.name
        )
        if column.is_pk and sql.pk_columns == ["ID_"]:
            assert slot.identifier, column.name


@pytest.mark.parametrize("table", sorted(_tables()))
def test_every_slot_is_a_column(table):
    """A table's class has slots for its own columns only. A base holds only the
    columns every subclass's table has, so no class inherits one its table lacks."""
    columns = {engine.col_to_slot(column.name) for column in _tables()[table].columns}
    slots = {s.name for s in _view().class_induced_slots(_class_of_table()[table])}
    assert slots <= columns, sorted(slots - columns)


def _ddl_text() -> str:
    return "\n".join(
        path.read_text(encoding="utf-8")
        for path in sorted(engine.DEFAULT_SQL_DIR.glob("activiti.h2.create.*.sql"))
    )


def test_the_parser_reads_every_default_and_unique_constraint():
    text = _ddl_text()
    defaults = re.findall(r"^\s*(\w+)\s.*?\bdefault\s+([^\s,]+)", text, re.I | re.M)
    parsed = [
        (column.name, column.default)
        for sql in _tables().values()
        for column in sql.columns
        if column.default is not None
    ]
    assert sorted((n.upper(), v.strip("'")) for n, v in defaults) == sorted(parsed)
    constraints = re.findall(r"\bunique\s*\(", text, re.I)
    assert len(constraints) == sum(
        len(t.unique_constraints) for t in _tables().values()
    )


@pytest.mark.parametrize("table", sorted(_tables()))
def test_defaults_are_the_ddls(table):
    """A column's DEFAULT is its slot's ifabsent value in its table's class, and a
    column with none gives no ifabsent."""
    found = _slot_of_column(table)
    for column in _tables()[table].columns:
        slot = found[column.name]
        if slot is None:
            continue
        if column.default is None:
            assert slot.ifabsent is None, column.name
        else:
            assert column.default.lower() in slot.ifabsent.lower(), column.name


@pytest.mark.parametrize("table", sorted(_tables()))
def test_unique_keys_are_the_ddls(table):
    """A class's unique keys are its table's composite primary key and unique
    constraints. A key with a column that may be null treats two nulls as unequal,
    as SQL does."""
    sql = _tables()[table]
    expected = [columns for _, columns in sql.unique_constraints]
    if len(sql.pk_columns) > 1:
        expected.append(sql.pk_columns)
    keys = _view().get_class(_class_of_table()[table]).unique_keys.values()
    found = {tuple(key.unique_key_slots): key for key in keys}
    want = {
        tuple(engine.col_to_slot(c) for c in columns): columns for columns in expected
    }
    assert set(found) == set(want)
    nullable = {column.name for column in sql.columns if column.nullable}
    for slots, columns in want.items():
        assert bool(found[slots].consider_nulls_inequal) == bool(
            nullable & set(columns)
        )


def test_a_shared_slot_keeps_each_tables_javadoc():
    """A slot many tables share carries, in each class, its own interface's Javadoc."""
    task = {s.name: s for s in _view().class_induced_slots("FluxnovaTask")}
    job = {s.name: s for s in _view().class_induced_slots("FluxnovaJob")}
    assert task["priority"].description.startswith(
        "Indication of how important/urgent this task is"
    )
    assert job["priority"].description == (
        "The job's priority that is a hint to job acquisition."
    )
    assert task["assignee"].description == (
        "The userId of the person to which this task is assigned or delegated."
    )


def test_each_class_slot_has_its_javadoc():
    """Where a class's interface describes a getter, the class's slot of that name
    carries the getter's first sentence."""
    gen = engine.LinkMLGenerator(_tables(), engine.parse_all_javadoc(engine.REPO_ROOT))
    names = engine.class_names(gen.classes)
    for cls in gen.classes.values():
        if cls.abstract:
            continue
        induced = {s.name: s for s in _view().class_induced_slots(names[cls.name])}
        for slot_name in gen._slots_of(cls):
            sentence = gen._javadoc(cls.name, slot_name)
            if sentence:
                assert induced[slot_name].description == sentence, (cls.name, slot_name)


def test_the_root_holds_every_table():
    root = _view().class_induced_slots("FluxnovaPlatformData")
    assert sorted(s.range for s in root) == sorted(_class_of_table().values())


@pytest.mark.parametrize("table", sorted(_tables()))
def test_each_foreign_key_refers_to_its_tables_class(table):
    found = _slot_of_column(table)
    for column, target in _tables()[table].fk_constraints.items():
        assert found[column].range == _class_of_table()[target], column


def _java_codes(source: str) -> dict[int, str]:
    text = (JAVA / source).read_text(encoding="utf-8")
    pairs = re.findall(r'new \w+Impl\((\d+),\s*"(\w+)"\)', text)
    pairs += [(n, m.lower()) for m, n in re.findall(r"AUTH_TYPE_(\w+) = (\d+);", text)]
    return {int(code): name for code, name in pairs}


@pytest.mark.parametrize("key", sorted(engine.CODED_COLUMNS), ids="-".join)
def test_state_codes_are_the_engines(key):
    """Each integer state column is bounded by the codes its Java class defines, and
    its comment lists each code by the name the class gives it."""
    source, low, high, meanings = engine.CODED_COLUMNS[key]
    codes = _java_codes(source)
    assert (low, high) == (min(codes), max(codes))
    assert sorted(codes) == list(range(low, high + 1))
    listed = dict(re.findall(r"(\d+) ([a-z ]+?)(?:,|$)", meanings))
    assert {int(c): n.replace(" ", "") for c, n in listed.items()} == {
        c: n.lower() for c, n in codes.items()
    }


@pytest.mark.parametrize("name", sorted(set(engine.ENUM_COLUMNS.values())))
def test_text_values_are_the_engines(name):
    enum = _engine()["enums"][name]
    source = re.search(r"from (engine/\S+\.java)", enum["comments"][0]).group(1)
    text = (JAVA / source).read_text(encoding="utf-8")
    if f"enum {name}" in text:
        body = text[text.index("{", text.index(f"enum {name}")) :]
        values = set(
            re.findall(r"^\s+([A-Z_]+)\s*[,;}]?\s*$", body, flags=re.MULTILINE)
        )
    else:
        values = set(re.findall(r'String STAT\w+ = "(\w+)";', text))
    assert set(enum["permissible_values"]) == values


@lru_cache(maxsize=1)
def _converter() -> bpmn.Converter:
    return bpmn.Converter()


def test_the_converter_reads_every_type_bpmn_java_registers():
    """Bpmn.java registers each type of the model API. The converter reads every one
    but ModelElementInstanceImpl, the base, which is the schema's root class."""
    text = (bpmn.JAVA_ROOT / "Bpmn.java").read_text(encoding="utf-8")
    registered = set(re.findall(r"(\w+)\.registerType\(", text))
    read = {element.source.stem for element in _converter().types.values()}
    assert registered - read == {"ModelElementInstanceImpl"}
    assert read <= registered


def test_every_registered_bpmn_type_has_a_class():
    """Each type the model API registers is a class, but a child that only holds a
    reference, such as incoming, which is a slot."""
    converter = _converter()
    classes = _view().all_classes()
    for java_name, element in converter.types.items():
        if java_name in converter.holders:
            continue
        cls = classes[converter.class_name(java_name)]
        annotations = {k: v.value for k, v in cls.annotations.items()}
        assert annotations.get("xml_name", "") == element.xml_name, java_name


def test_every_mapping_names_a_bound_prefix():
    prefixes = set(_view().namespaces())
    for element in [*_view().all_classes().values(), *_view().all_slots().values()]:
        for curie in element.exact_mappings or []:
            assert curie.split(":")[0] in prefixes, (element.name, curie)
