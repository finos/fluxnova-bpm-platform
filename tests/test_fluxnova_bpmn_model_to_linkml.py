"""Tests for the BPMN Model API -> LinkML generator."""

import sys
from pathlib import Path

import yaml

SCRIPTS_DIR = Path(__file__).resolve().parent.parent / "scripts"
sys.path.insert(0, str(SCRIPTS_DIR))

from fluxnova_bpmn_model_to_linkml import (  # noqa: E402
    DEFAULT_SOURCE_ROOT,
    build_schema,
    discover_source_files,
)
from fluxnova_to_linkml import write_yaml  # noqa: E402


def test_discovers_in_scope_bpmn_sources():
    sources = discover_source_files(DEFAULT_SOURCE_ROOT)
    names = {source.type_name for source in sources}
    assert "Process" in names
    assert "Definitions" in names
    assert "FluxnovaProperties" in names
    assert "BpmnModelInstance" in names
    assert "ProcessType" in names
    assert "Bpmn" not in names
    assert "Query" not in names
    assert all("builder" not in source.path.parts for source in sources)
    assert all("impl" not in source.path.parts for source in sources)


def test_build_schema_has_expected_headers():
    schema = build_schema(DEFAULT_SOURCE_ROOT, project_version="test-version")
    assert schema["name"] == "fluxnova_bpmn_model"
    assert schema["version"] == "test-version"
    assert schema["imports"] == ["linkml:types"]
    assert schema["annotations"]["generated_by"] == "scripts/fluxnova_bpmn_model_to_linkml.py"


def test_build_schema_covers_all_in_scope_interfaces_and_enums():
    sources = discover_source_files(DEFAULT_SOURCE_ROOT)
    schema = build_schema(DEFAULT_SOURCE_ROOT, project_version="test-version")
    class_names = set(schema["classes"])
    enum_names = set(schema["enums"])

    source_interfaces = {
        source.type_name for source in sources if source.declaration_kind == "interface"
    }
    source_enums = {
        source.type_name for source in sources if source.declaration_kind == "enum"
    }

    assert source_interfaces == class_names
    assert source_enums == enum_names


def test_build_schema_represents_multiparent_inheritance():
    schema = build_schema(DEFAULT_SOURCE_ROOT, project_version="test-version")
    activity = schema["classes"]["Activity"]
    assert activity["is_a"] == "FlowNode"
    assert activity["mixins"] == ["InteractionNode"]


def test_build_schema_represents_multivalued_references_and_enums():
    schema = build_schema(DEFAULT_SOURCE_ROOT, project_version="test-version")
    definitions = schema["classes"]["Definitions"]
    assert "bpm_diagrams" in definitions["slots"]
    assert schema["slots"]["bpm_diagrams"]["multivalued"] is True
    assert schema["slots"]["process_type"]["range"] == "ProcessType"


def test_tree_root_is_bpmn_model_instance():
    schema = build_schema(DEFAULT_SOURCE_ROOT, project_version="test-version")
    assert schema["classes"]["BpmnModelInstance"]["tree_root"] is True


def test_schema_serializes_cleanly(tmp_path):
    schema = build_schema(DEFAULT_SOURCE_ROOT, project_version="test-version")
    out = tmp_path / "fluxnova_bpmn_model.yaml"
    write_yaml(schema, out)
    loaded = yaml.safe_load(out.read_text(encoding="utf-8"))
    assert loaded["name"] == "fluxnova_bpmn_model"
