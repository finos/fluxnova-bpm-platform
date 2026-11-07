#!/usr/bin/env python3
"""Write scripts/upstream_pins.tsv: each file of FINOS's tree the converters read.

The script runs both converters in check mode, records every file they open under
FINOS's tree, and writes each one's path and git object hash at the edition's tag
(scripts/edition.py). It refuses when a file the converters read differs from the
tag's, since the schema would then render something no release holds. Run it after
a merge of FINOS's tree, once the edition and the tag agree. Usage::

    python scripts/pin_sources.py
"""

from __future__ import annotations

import builtins
import io
import subprocess
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from edition import EDITION  # noqa: E402

ROOT = Path(__file__).resolve().parent.parent
TREE = ROOT.parent
PINS = ROOT / "scripts" / "upstream_pins.tsv"


def read_by_converters() -> set[str]:
    """The files under FINOS's tree the converters open, relative to it."""
    import bpmn_to_linkml
    import fluxnova_to_linkml

    opened: set[str] = set()
    real_open = builtins.open
    real_io_open = io.open
    real_path_open = Path.open

    def note(file) -> None:
        path = Path(file).resolve() if isinstance(file, (str, Path)) else None
        if (
            path is not None
            and path.is_relative_to(TREE)
            and not path.is_relative_to(ROOT)
        ):
            opened.add(path.relative_to(TREE).as_posix())

    def record(file, *args, **kwargs):
        note(file)
        return real_open(file, *args, **kwargs)

    def record_path(self, *args, **kwargs):
        note(self)
        return real_path_open(self, *args, **kwargs)

    # Path.open is replaced too: on Python 3.10, Path.read_text opens a file through
    # an accessor that holds io.open from before the replacement.
    builtins.open = record
    io.open = record
    Path.open = record_path
    try:
        bpmn_to_linkml.main(["--check"])
        fluxnova_to_linkml.main(["--check"])
    finally:
        builtins.open = real_open
        io.open = real_io_open
        Path.open = real_path_open
    return opened


def blobs(ref: str, paths: list[str]) -> dict[str, str]:
    listing = subprocess.run(
        ["git", "-C", str(TREE), "ls-tree", "-r", "-z", ref, "--", *paths],
        capture_output=True,
        check=True,
    ).stdout.decode("utf-8")
    found = {}
    for entry in filter(None, listing.split("\0")):
        meta, path = entry.split("\t", 1)
        found[path] = meta.split()[2]
    return found


def main() -> int:
    paths = sorted(read_by_converters())
    at_tag = blobs(EDITION["commit"], paths)
    at_head = blobs("HEAD", paths)
    differing = [p for p in paths if at_tag.get(p) != at_head.get(p)]
    if differing:
        print(f"These files differ from {EDITION['tag']}'s:", *differing, sep="\n  ")
        return 1
    rows = [
        f"{path}\t{at_tag[path]}\t{EDITION['repository']}\t{EDITION['commit']}\t{path}\n"
        for path in paths
    ]
    PINS.write_text("".join(rows), encoding="utf-8")
    print(f"Wrote {len(rows)} files to {PINS.relative_to(ROOT)}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
