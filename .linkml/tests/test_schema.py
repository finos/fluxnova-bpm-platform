"""Schema-level tests using LinkML tooling.

Tests the schema files themselves via linkml-lint, gen-json-schema,
and gen-python to ensure the schema is well-formed and generator-clean.
"""

import subprocess
from pathlib import Path

import pytest
import yaml

SCHEMA_DIR = (
    Path(__file__).resolve().parent.parent
    / "src"
    / "fluxnova_bpm_platform"
    / "schema"
)
ROOT_SCHEMA = SCHEMA_DIR / "fluxnova_bpm_platform.yaml"
MODULE_SCHEMAS = sorted(SCHEMA_DIR.glob("fluxnova_bpm_*.yaml"))


class TestSchemaLint:
    """Validate schema files with linkml-lint."""

    def test_root_schema_lint(self):
        result = subprocess.run(
            ["linkml-lint", str(ROOT_SCHEMA)],
            capture_output=True,
            text=True,
        )
        assert "No problems found" in result.stdout, (
            f"linkml-lint found problems:\n{result.stdout}\n{result.stderr}"
        )

    @pytest.mark.parametrize(
        "schema_file",
        MODULE_SCHEMAS,
        ids=[f.stem for f in MODULE_SCHEMAS],
    )
    def test_module_schema_lint_no_errors(self, schema_file):
        """Modules must have zero errors; warnings are tolerated."""
        result = subprocess.run(
            ["linkml-lint", str(schema_file)],
            capture_output=True,
            text=True,
        )
        # Filter out "warning" lines; only fail on "error" lines
        error_lines = [
            line for line in result.stdout.splitlines()
            if "  error  " in line
        ]
        assert error_lines == [], (
            f"linkml-lint errors in {schema_file.name}:\n"
            + "\n".join(error_lines)
        )


class TestSchemaGenerators:
    """Test that schema passes all LinkML generators cleanly."""

    def test_gen_json_schema(self, tmp_path):
        out = tmp_path / "schema.json"
        result = subprocess.run(
            ["gen-json-schema", str(ROOT_SCHEMA)],
            capture_output=True,
            text=True,
        )
        assert result.returncode == 0, (
            f"gen-json-schema failed:\n{result.stderr}"
        )
        out.write_text(result.stdout)
        assert out.stat().st_size > 0

    def test_gen_python(self, tmp_path):
        result = subprocess.run(
            [
                "gen-project",
                "-d", str(tmp_path),
                "-I", "python",
                str(ROOT_SCHEMA),
            ],
            capture_output=True,
            text=True,
        )
        assert result.returncode == 0, (
            f"gen-python failed:\n{result.stderr}"
        )
        # Verify Python file was generated
        py_files = list(tmp_path.glob("**/*.py"))
        assert len(py_files) > 0


class TestSchemaStructure:
    """Validate structural properties of the generated schema YAML."""

    def test_root_schema_has_tree_root(self):
        data = yaml.safe_load(ROOT_SCHEMA.read_text())
        assert "FluxnovaPlatformData" in data.get("classes", {})
        assert data["classes"]["FluxnovaPlatformData"].get("tree_root") is True

    def test_root_imports_all_modules(self):
        data = yaml.safe_load(ROOT_SCHEMA.read_text())
        imports = data.get("imports", [])
        expected_modules = [
            "base", "collaboration", "history", "identity",
            "job", "repository", "runtime",
        ]
        for mod in expected_modules:
            assert any(
                f"fluxnova_bpm_{mod}" in imp for imp in imports
            ), f"Root schema missing import for module '{mod}'"

    def test_default_range_is_string(self):
        data = yaml.safe_load(ROOT_SCHEMA.read_text())
        assert data.get("default_range") == "string"

    def test_every_module_has_required_header(self):
        for schema_file in MODULE_SCHEMAS:
            data = yaml.safe_load(schema_file.read_text())
            assert "id" in data, f"{schema_file.name} missing 'id'"
            assert "name" in data, f"{schema_file.name} missing 'name'"
            assert "version" in data, f"{schema_file.name} missing 'version'"
            assert "annotations" in data, f"{schema_file.name} missing 'annotations'"
            assert "imports" in data, f"{schema_file.name} missing 'imports'"
            assert "linkml:types" in data["imports"], (
                f"{schema_file.name} missing 'linkml:types' import"
            )

    def test_root_schema_has_metadata_annotations(self):
        data = yaml.safe_load(ROOT_SCHEMA.read_text())
        assert data.get("version")
        annotations = data.get("annotations") or {}
        assert annotations.get("generated_by") == "scripts/fluxnova_to_linkml.py"
        assert annotations.get("source_sql_file_count")
        assert annotations.get("source_sql_files")

    def test_no_duplicate_slot_names_within_module(self):
        for schema_file in MODULE_SCHEMAS:
            data = yaml.safe_load(schema_file.read_text())
            slots = data.get("slots", {})
            if not slots:
                continue
            slot_names = list(slots.keys())
            duplicates = [s for s in slot_names if slot_names.count(s) > 1]
            assert duplicates == [], (
                f"Duplicate slots in {schema_file.name}: {set(duplicates)}"
            )

    def test_every_concrete_class_has_id_slot(self):
        """Every non-abstract class must have 'id' in its slots or inherit it."""
        abstract_classes = set()
        class_parents = {}
        class_slots = {}

        for schema_file in MODULE_SCHEMAS:
            data = yaml.safe_load(schema_file.read_text())
            for cls_name, cls_def in data.get("classes", {}).items():
                if cls_def.get("abstract"):
                    abstract_classes.add(cls_name)
                class_parents[cls_name] = cls_def.get("is_a", "")
                class_slots[cls_name] = cls_def.get("slots", [])

        # Classes exempt from the 'id' slot requirement
        # Property uses 'name' as identifier; Membership uses composite key
        ID_EXEMPT = {"FluxnovaPlatformData", "Property", "Membership"}

        for cls_name, slots in class_slots.items():
            if cls_name in abstract_classes:
                continue
            if cls_name in ID_EXEMPT:
                continue
            # Check if 'id' is in own slots or inherited
            has_id = "id" in slots
            parent = class_parents.get(cls_name, "")
            while parent and not has_id:
                has_id = "id" in class_slots.get(parent, [])
                parent = class_parents.get(parent, "")
            assert has_id, f"Class {cls_name} missing 'id' slot"

    def test_enum_values_have_descriptions(self):
        """Every enum permissible value should have a description."""
        for schema_file in MODULE_SCHEMAS:
            data = yaml.safe_load(schema_file.read_text())
            for enum_name, enum_def in data.get("enums", {}).items():
                for val_name, val_def in enum_def.get(
                    "permissible_values", {}
                ).items():
                    assert val_def.get("description"), (
                        f"Enum {enum_name}.{val_name} missing description"
                    )

    def test_all_classes_have_sql_table_annotation(self):
        """Every concrete non-abstract class should have sql_table annotation."""
        for schema_file in MODULE_SCHEMAS:
            data = yaml.safe_load(schema_file.read_text())
            for cls_name, cls_def in data.get("classes", {}).items():
                if cls_def.get("abstract"):
                    continue
                if cls_def.get("tree_root"):
                    continue  # tree_root container has no SQL table
                annotations = cls_def.get("annotations", {})
                assert "sql_table" in annotations, (
                    f"Class {cls_name} in {schema_file.name} "
                    f"missing sql_table annotation"
                )
