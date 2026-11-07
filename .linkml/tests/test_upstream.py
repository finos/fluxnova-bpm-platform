"""Holds FINOS's tree, the converters' sources and the schema headers to the pins.

FINOS's tree sits beside .linkml/, unchanged. These tests show that it matches the
merged commit byte for byte, that every file the converters read is the file at the
release tag the schema names, and that the headers, the edition and the watch agree.
"""

import hashlib
import sys
from functools import lru_cache
from pathlib import Path

import yaml

ROOT = Path(__file__).parent.parent
TREE = ROOT.parent
SCHEMA_DIR = ROOT / "src" / "fluxnova_bpm_platform" / "schema"
MANIFEST = Path(__file__).parent / "upstream_tree.tsv"
PINS = ROOT / "scripts" / "upstream_pins.tsv"

sys.path.insert(0, str(ROOT / "scripts"))
from edition import EDITION  # noqa: E402


def _blob_sha(path: Path) -> str:
    data = path.read_bytes()
    return hashlib.sha1(b"blob %d\0" % len(data) + data).hexdigest()


@lru_cache(maxsize=1)
def _pins() -> dict[str, str]:
    rows = [line.split("\t") for line in PINS.read_text(encoding="utf-8").splitlines()]
    return {row[0]: row[1] for row in rows}


def test_finos_tree_is_the_merged_commit():
    """Every file FINOS's merged commit holds is here, byte for byte."""
    differing = []
    for line in MANIFEST.read_text(encoding="utf-8").splitlines():
        sha, path = line.split("\t", 1)
        local = TREE / path
        if not local.is_file() or _blob_sha(local) != sha:
            differing.append(path)
    assert not differing


def test_the_converters_read_the_releases_files():
    """Each file the converters read is the file at the edition's tag."""
    differing = [path for path, sha in _pins().items() if _blob_sha(TREE / path) != sha]
    assert not differing


def test_the_pins_name_every_file_the_converters_read():
    import pin_sources

    assert pin_sources.read_by_converters() == set(_pins())


def test_the_headers_name_the_edition():
    for path in SCHEMA_DIR.glob("*.yaml"):
        header = yaml.safe_load(path.read_text(encoding="utf-8"))
        assert header["version"] == EDITION["version"], path.name
        assert f"/tree/{EDITION['commit']}/" in header["source"], path.name
        assert header["license"] == "Apache-2.0", path.name
