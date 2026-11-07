"""Checks BPMN files from FINOS's tree against the schema.

tests/bpmn_xml.py reads each file into the schema's shape. The files are the model
API's own test resources, the engine's tests of input and output mappings, and the
processes the tests of FINOS's assertion library deploy. Each must validate, except
the files KNOWN lists, each with what the schema does not model, and each of those
must still fail.
"""

import xml.etree.ElementTree as ET
from functools import lru_cache
from pathlib import Path

import pytest
from linkml.validator import Validator
from linkml.validator.plugins import JsonschemaValidationPlugin
from linkml_runtime.utils.schemaview import SchemaView

from tests.bpmn_xml import Reader

ROOT = Path(__file__).resolve().parent.parent
FINOS = ROOT.parent
SCHEMA = ROOT / "src/fluxnova_bpm_platform/schema/fluxnova_bpm_platform.yaml"
FOLDERS = [
    "model-api/bpmn-model/src/test/resources",
    "engine/src/test/resources/org/finos/fluxnova/bpm/engine/test/bpmn/iomapping",
    "test-utils/assert/core/src/test/resources/bpmn",
]
FILES = sorted(
    path
    for folder in FOLDERS
    for pattern in ("*.bpmn", "*.xml")
    for path in (FINOS / folder).rglob(pattern)
)
NESTED_VALUE = (
    "a camunda:value that holds a list or a map, which the model API reads as text "
    "and the engine as null"
)
KNOWN = {
    "CamundaExtensionsCompatabilityTest.xml": NESTED_VALUE,
    "CamundaExtensionsFluxnovaCompatabilityTest.xml": NESTED_VALUE,
    "CamundaExtensionsTest.xml": NESTED_VALUE,
    "DefinitionsTest.shouldNotAffectCommentsResult.bpmn": (
        "not well-formed XML: text follows the root element"
    ),
}


@lru_cache(maxsize=1)
def _view() -> SchemaView:
    return SchemaView(str(SCHEMA))


@lru_cache(maxsize=1)
def _validator() -> Validator:
    return Validator(
        _view().schema, validation_plugins=[JsonschemaValidationPlugin(closed=True)]
    )


@lru_cache(maxsize=1)
def _reader() -> Reader:
    return Reader(_view())


def _errors(path: Path) -> list[str]:
    try:
        cls, doc = _reader().read(ET.parse(path).getroot())
    except (ET.ParseError, KeyError, ValueError) as error:
        return [f"{type(error).__name__}: {error}"]
    return [result.message for result in _validator().validate(doc, cls).results]


def test_the_folders_hold_files():
    assert len(FILES) > 150


@pytest.mark.parametrize("path", FILES, ids=lambda p: p.name)
def test_finos_bpmn_file(path):
    errors = _errors(path)
    if path.name in KNOWN:
        assert errors, f"{path.name} validates, so KNOWN can drop it"
    else:
        assert not errors, errors[:3]
