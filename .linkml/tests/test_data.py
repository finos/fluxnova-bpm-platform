"""Checks each example against the schema.

`tests/data/valid/<Class>-<anything>.yaml` must validate against `<Class>` and load
as its generated dataclass; `tests/data/invalid/<Class>-<anything>.yaml` must fail
validation. One validator serves the session, so the schema's JSON Schema is built
once per class rather than once per file.
"""

from functools import lru_cache
from pathlib import Path

import pytest
import yaml
from linkml.validator import Validator
from linkml.validator.plugins import JsonschemaValidationPlugin
from linkml_runtime.loaders import yaml_loader
from linkml_runtime.utils.schemaview import SchemaView

import fluxnova_bpm_platform.datamodel.fluxnova_bpm_platform as datamodel

DATA = Path(__file__).parent / "data"
SCHEMA = (
    Path(__file__).parent.parent
    / "src"
    / "fluxnova_bpm_platform"
    / "schema"
    / "fluxnova_bpm_platform.yaml"
)
VALID = sorted((DATA / "valid").glob("*.yaml"))
INVALID = sorted((DATA / "invalid").glob("*.yaml"))


@lru_cache(maxsize=1)
def _view() -> SchemaView:
    return SchemaView(str(SCHEMA))


@lru_cache(maxsize=1)
def _validator() -> Validator:
    return Validator(
        _view().schema, validation_plugins=[JsonschemaValidationPlugin(closed=True)]
    )


def _class(path: Path) -> str:
    return path.stem.split("-")[0]


def _errors(path: Path) -> list[str]:
    data = yaml.safe_load(path.read_text(encoding="utf-8"))
    report = _validator().validate(data, _class(path))
    return [result.message for result in report.results]


@pytest.mark.parametrize("path", VALID, ids=lambda p: p.stem)
def test_valid_example(path):
    assert not _errors(path)
    assert yaml_loader.load(str(path), target_class=getattr(datamodel, _class(path)))


@pytest.mark.parametrize("path", INVALID, ids=lambda p: p.stem)
def test_counter_example(path):
    assert _errors(path)


def test_every_example_names_a_class():
    classes = set(_view().all_classes())
    assert {_class(p) for p in VALID + INVALID} <= classes
