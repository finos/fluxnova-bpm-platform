"""Schema-level checks for the generated BPMN Model API LinkML schema."""

import subprocess
from pathlib import Path

import yaml

SCHEMA_PATH = (
    Path(__file__).resolve().parent.parent
    / "src"
    / "fluxnova_bpm_platform"
    / "schema"
    / "fluxnova_bpmn_model.yaml"
)


def test_bpmn_model_schema_exists():
    assert SCHEMA_PATH.is_file()


def test_bpmn_model_schema_lints_without_errors():
    result = subprocess.run(
        ["linkml-lint", str(SCHEMA_PATH)],
        capture_output=True,
        text=True,
    )
    error_lines = [
        line for line in result.stdout.splitlines()
        if "  error  " in line
    ]
    assert error_lines == [], result.stdout + result.stderr


def test_bpmn_model_schema_generates_json_schema():
    result = subprocess.run(
        ["gen-json-schema", str(SCHEMA_PATH)],
        capture_output=True,
        text=True,
    )
    assert result.returncode == 0, result.stderr
    assert result.stdout.strip().startswith("{")


def test_bpmn_model_schema_has_coverage_metadata():
    data = yaml.safe_load(SCHEMA_PATH.read_text(encoding="utf-8"))
    annotations = data.get("annotations") or {}
    assert annotations.get("coverage_target")
    assert annotations.get("interface_count")
    assert annotations.get("enum_count")
    assert data["classes"]["BpmnModelInstance"]["tree_root"] is True
