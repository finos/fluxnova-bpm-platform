#!/usr/bin/env python3
# /// script
# requires-python = ">=3.10"
# dependencies = []
# ///
"""Check FINOS's repository against the Fluxnova edition the schema renders.

The schema renders Fluxnova 3.1.1: the converters read the engine's H2 DDL, the
engine API's Javadoc and the BPMN model API from FINOS's tree beside .linkml/, and
every file they read is byte for byte the file at the tag v3.1.1, which
scripts/upstream_pins.tsv records with its git object hash. FINOS's tree itself is
merged from its default branch at FINOS_COMMIT (scripts/edition.py). These can change
without any change here:

- FINOS gains a tag, such as a 3.2.0 release;
- the pinned tag moves, or a pinned file changes or goes at the pinned commit;
- the licence on the default branch changes.

Each of these fails the check. Two more are reported for information only: a pinned
file on the default branch differs from the release's, and the default branch has moved
past the merged commit, so a merge of FINOS's tree is due.

The script reads only GitHub's API and compares git object hashes, so it downloads no
file. It prints a Markdown report and exits 1 on any failing check, or when a check could
not finish. Text a server chose is quoted as code on one line in the report, so the issue
the workflow opens from it cannot mention anyone. A redirect is followed only to an https
address on api.github.com. Set ``GITHUB_TOKEN`` to raise the API's rate limit. Usage::

    python scripts/check_upstream_release.py [--report FILE]
"""

from __future__ import annotations

import argparse
import http.client
import json
import os
import sys
import urllib.error
import urllib.parse
import urllib.request
from pathlib import Path, PurePosixPath

ROOT = Path(__file__).resolve().parent.parent
PINS = ROOT / "scripts" / "upstream_pins.tsv"
USER_AGENT = "lmodel-fluxnova-upstream-check"
OWNER = "finos"
HOST = "api.github.com"
API = f"https://{HOST}/repos/{OWNER}"

# The most the script reads of one answer. A folder listing is a few kilobytes.
MAX_BYTES = 5_000_000

sys.path.insert(0, str(Path(__file__).resolve().parent))
from edition import EDITION, FINOS_COMMIT, FINOS_REPOSITORY  # noqa: E402

# Every tag FINOS's repository held when the pin was set. A tag outside this list is news.
KNOWN_TAGS = {
    "v1.0.0",
    "v1.1.0",
    "v2.0.0",
    "v2.0.1",
    "v2.0.2",
    "v2.0.3",
    "v2.0.4",
    "v2.0.5",
    "v3.0.0",
    "v3.0.1",
    "v3.1.1",
}

# The licence file at the repository's root, with its hash when the pins were set. The
# default branch is read from the API.
LICENCE = "LICENSE"
LICENCES = {
    "fluxnova-bpm-platform": "f433b1a53f5b830a205fd2df78e2b34974656c7b",
}


class _ApiRedirect(urllib.request.HTTPRedirectHandler):
    """Follow a redirect only to an https address on the API's host."""

    def redirect_request(self, req, fp, code, msg, headers, newurl):
        parts = urllib.parse.urlsplit(newurl)
        if parts.scheme != "https" or parts.hostname != HOST:
            raise ValueError(f"a redirect leads off {HOST}, to {newurl}")
        return super().redirect_request(req, fp, code, msg, headers, newurl)


# An opener in place of urlopen's, whose redirect handler follows any address.
_open = urllib.request.build_opener(_ApiRedirect).open


def _get(path: str):
    """The JSON answer to one API path under the owner's repositories, read up to the cap."""
    headers = {
        "User-Agent": USER_AGENT,
        "Accept": "application/vnd.github+json",
        "X-GitHub-Api-Version": "2022-11-28",
    }
    token = os.environ.get("GITHUB_TOKEN")
    if token:
        headers["Authorization"] = f"Bearer {token}"
    req = urllib.request.Request(f"{API}{path}", headers=headers)
    with _open(req, timeout=60) as resp:
        body = resp.read(MAX_BYTES + 1)
    if len(body) > MAX_BYTES:
        raise ValueError(f"the answer to {path} is larger than {MAX_BYTES} bytes")
    return json.loads(body)


def _code(text: object) -> str:
    """Text a server chose, as a code span on one line, so it cannot mention a person or
    add a link in the issue. A blank line would end the span, so every run of spaces and
    line breaks is one space."""
    return "`" + " ".join(str(text).replace("`", "'").split()) + "`"


def pins() -> list[dict[str, str]]:
    """Each pinned file: its path in FINOS's tree here, git object hash, repository,
    commit and path in that repository."""
    keys = ("local", "sha", "repository", "commit", "path")
    rows = PINS.read_text(encoding="utf-8").splitlines()
    return [dict(zip(keys, row.split("\t"), strict=True)) for row in rows]


def _quote(path: str) -> str:
    return urllib.parse.quote(path, safe="/")


def _listing(repository: str, folder: str, ref: str) -> dict[str, str]:
    """The git object hash of each file in one folder of a repository at a ref."""
    answer = _get(f"/{repository}/contents/{_quote(folder)}?ref={_quote(ref)}")
    if not isinstance(answer, list):
        raise ValueError(f"{folder} in {repository} at {ref} is not a folder")
    return {entry["path"]: entry["sha"] for entry in answer if entry["type"] == "file"}


def _files(repository: str, paths: set[str], ref: str) -> dict[str, str]:
    """The git object hash of each named file at a ref, read folder by folder."""
    folders = {str(PurePosixPath(path).parent) for path in paths}
    found = {}
    for folder in sorted(folders):
        found |= _listing(repository, "" if folder == "." else folder, ref)
    return {path: found[path] for path in paths if path in found}


def _commit_of(repository: str, tag: str) -> str:
    """The commit a tag names, through any annotated tag objects on the way."""
    target = _get(f"/{repository}/git/ref/tags/{_quote(tag)}")["object"]
    while target["type"] == "tag":
        target = _get(f"/{repository}/git/tags/{target['sha']}")["object"]
    return target["sha"]


_default_branches: dict[str, str] = {}


def _default_branch(repository: str) -> str:
    """The repository's default branch, read once."""
    if repository not in _default_branches:
        _default_branches[repository] = _get(f"/{repository}")["default_branch"]
    return _default_branches[repository]


def check_tags() -> tuple[list[str], bool]:
    """Report any tag FINOS's repository has gained since the pin was set."""
    repository = EDITION["repository"]
    entries = _get(f"/{repository}/tags?per_page=100")
    if len(entries) >= 100:
        raise ValueError(f"{repository} has 100 tags or more, past what one page holds")
    new = sorted({entry["name"] for entry in entries} - KNOWN_TAGS)
    if not new:
        return [f"- {repository} has no new tag."], False
    shown = ", ".join(_code(tag) for tag in new[:10])
    return [
        f"- **{repository} has {len(new)} new tags:** {shown}. Read what changed, "
        "decide whether the schema moves to it, merge FINOS's tree, and move "
        "scripts/edition.py and the pins together."
    ], True


def check_pinned_tag() -> tuple[list[str], bool]:
    """Report whether the pinned tag still names its commit."""
    found = _commit_of(EDITION["repository"], EDITION["tag"])
    if found != EDITION["commit"]:
        return [
            f"- **The tag {EDITION['tag']} of {EDITION['repository']} moved to "
            f"{_code(found)}.** Find out why a published tag moved before trusting the "
            "schema's sources."
        ], True
    return [f"- The tag {EDITION['tag']} names its pinned commit."], False


def check_pinned_files() -> tuple[list[str], bool]:
    """Report whether each pinned file still has its hash at its pinned commit."""
    by_source: dict[tuple[str, str], dict[str, str]] = {}
    for pin in pins():
        by_source.setdefault((pin["repository"], pin["commit"]), {})[pin["path"]] = pin[
            "sha"
        ]
    gone, changed = [], []
    for (repository, commit), wanted in sorted(by_source.items()):
        found = _files(repository, set(wanted), commit)
        for path, sha in sorted(wanted.items()):
            if path not in found:
                gone.append(f"{repository}/{path}")
            elif found[path] != sha:
                changed.append(f"{repository}/{path}")
    lines = []
    for label, paths in (("gone", gone), ("changed", changed)):
        if paths:
            shown = ", ".join(_code(path) for path in paths[:10])
            lines.append(f"- **{len(paths)} pinned files {label}:** {shown}.")
    if gone or changed:
        return lines, True
    return [f"- All {len(pins())} pinned files are unchanged."], False


def check_licences() -> tuple[list[str], bool]:
    """Report whether the licence on each default branch is the pinned file."""
    lines = []
    attention = False
    for repository, sha in sorted(LICENCES.items()):
        found = _files(repository, {LICENCE}, _default_branch(repository)).get(LICENCE)
        if found != sha:
            attention = True
            lines.append(
                f"- **{LICENCE} on {repository}'s default branch changed.** Read what "
                "changed, and update NOTICE if the licence moved."
            )
    if not attention:
        lines.append("- The licence is unchanged.")
    return lines, attention


def check_default_branches() -> tuple[list[str], bool]:
    """Report, for information, what has moved on the default branch."""
    lines = []
    repository = EDITION["repository"]
    wanted = {pin["path"]: pin["sha"] for pin in pins()}
    found = _files(repository, set(wanted), _default_branch(repository))
    moved = sorted(path for path, sha in wanted.items() if found.get(path) != sha)
    if moved:
        shown = ", ".join(_code(path) for path in moved[:10])
        lines.append(
            f"- For information, {len(moved)} of the files the converters read differ on "
            f"{repository}'s default branch from {EDITION['tag']}'s: {shown}. They are "
            "unreleased."
        )
    else:
        lines.append(
            f"- {repository}'s default branch holds {EDITION['tag']}'s source files."
        )
    branch = _default_branch(FINOS_REPOSITORY)
    head = _get(f"/{FINOS_REPOSITORY}/commits/{_quote(branch)}")["sha"]
    if head != FINOS_COMMIT:
        lines.append(
            f"- For information, {FINOS_REPOSITORY}'s default branch is at {_code(head)}, "
            "past the merged commit. Merge FINOS's tree when it suits, and move "
            "FINOS_COMMIT and tests/upstream_tree.tsv with it."
        )
    else:
        lines.append(f"- {FINOS_REPOSITORY}'s default branch is the merged commit.")
    return lines, False


# Each check, by the name the report gives it when it cannot finish.
CHECKS = (
    ("tags", check_tags),
    ("pinned tag", check_pinned_tag),
    ("pinned files", check_pinned_files),
    ("licence", check_licences),
    ("default branch", check_default_branches),
)


def main(argv: list[str] | None = None) -> int:
    parser = argparse.ArgumentParser(description=__doc__.splitlines()[0])
    parser.add_argument(
        "--report", type=Path, help="Also write the Markdown report to this file"
    )
    args = parser.parse_args(argv)
    lines = [
        f"- Pinned edition: {EDITION['label']}, {EDITION['repository']} at "
        f"{EDITION['tag']}; FINOS's tree at {FINOS_COMMIT[:7]}."
    ]
    attention = False
    for label, check in CHECKS:
        try:
            found, needs = check()
        # OSError covers a refused or failed request and a timeout, HTTPException and
        # EOFError a connection cut off mid-answer, LookupError and ValueError an answer
        # of another shape or too large.
        except (
            OSError,
            http.client.HTTPException,
            EOFError,
            LookupError,
            ValueError,
        ) as err:
            found = [f"- **The {label} check could not finish: {_code(err)}.**"]
            needs = True
        lines += found
        attention = attention or needs
    text = "\n".join(lines) + "\n"
    print(text, end="")
    if args.report:
        args.report.write_text(text, encoding="utf-8")
    return 1 if attention else 0


if __name__ == "__main__":
    sys.exit(main())
