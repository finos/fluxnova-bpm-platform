"""Holds the schema to what FINOS's tree states.

The converters write every module from FINOS's tree beside .linkml/. These tests rerun
them in check mode, then check what they wrote against the sources themselves: each
table, column and foreign key of the engine's H2 DDL, the state codes and values the
engine's Java classes define, and each element type the BPMN model API registers.
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
        if not column.nullable:
            assert slot.required or slot.identifier, column.name
        if column.is_pk and sql.pk_columns == ["ID_"]:
            assert slot.identifier, column.name


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


def test_every_registered_bpmn_type_has_a_class():
    """Each type the model API registers is a class, but a child that only holds a
    reference, such as incoming, which is a slot."""
    converter = bpmn.Converter()
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
