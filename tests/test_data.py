"""Data test."""
import os
import glob
import subprocess
import pytest
from pathlib import Path

import fluxnova_bpm_platform.datamodel.fluxnova_bpm_platform
from linkml_runtime.loaders import yaml_loader

DATA_DIR_VALID = Path(__file__).parent / "data" / "valid"
DATA_DIR_INVALID = Path(__file__).parent / "data" / "invalid"
SCHEMA_PATH = (
    Path(__file__).parent.parent
    / "src"
    / "fluxnova_bpm_platform"
    / "schema"
    / "fluxnova_bpm_platform.yaml"
)

VALID_EXAMPLE_FILES = glob.glob(os.path.join(DATA_DIR_VALID, '*.yaml'))
INVALID_EXAMPLE_FILES = glob.glob(os.path.join(DATA_DIR_INVALID, '*.yaml'))


@pytest.mark.parametrize("filepath", VALID_EXAMPLE_FILES)
def test_valid_data_files(filepath):
    """Test loading of all valid data files."""
    target_class_name = Path(filepath).stem.split("-")[0]
    tgt_class = getattr(
        fluxnova_bpm_platform.datamodel.fluxnova_bpm_platform,
        target_class_name,
    )
    obj = yaml_loader.load(filepath, target_class=tgt_class)
    assert obj


@pytest.mark.parametrize("filepath", VALID_EXAMPLE_FILES)
def test_valid_data_linkml_validate(filepath):
    """Validate valid examples against the schema with linkml-validate."""
    target_class_name = Path(filepath).stem.split("-")[0]
    result = subprocess.run(
        [
            "linkml-validate",
            "--schema", str(SCHEMA_PATH),
            "--target-class", target_class_name,
            filepath,
        ],
        capture_output=True,
        text=True,
    )
    assert result.returncode == 0, (
        f"linkml-validate failed for {filepath}:\n{result.stderr}"
    )


@pytest.mark.parametrize("filepath", INVALID_EXAMPLE_FILES)
def test_invalid_data_linkml_validate(filepath):
    """Invalid examples must fail linkml-validate."""
    target_class_name = Path(filepath).stem.split("-")[0]
    result = subprocess.run(
        [
            "linkml-validate",
            "--schema", str(SCHEMA_PATH),
            "--target-class", target_class_name,
            filepath,
        ],
        capture_output=True,
        text=True,
    )
    assert result.returncode != 0, (
        f"linkml-validate should have failed for {filepath}"
    )
