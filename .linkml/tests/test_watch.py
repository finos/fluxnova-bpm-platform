"""Checks the upstream watch's decisions against stubbed answers.

scripts/check_upstream_release.py reads GitHub's API. These tests replace its one network
call, `_get`, with a table of answers, so they run offline. They show what the report says
in each case the watch knows.
"""

import http.client
import importlib.util
import urllib.error
import urllib.parse
from pathlib import Path, PurePosixPath

import pytest

ROOT = Path(__file__).parent.parent
SCRIPT = ROOT / "scripts" / "check_upstream_release.py"
REPO = "fluxnova-bpm-platform"
DDL = "engine/src/main/resources/org/finos/fluxnova/bpm/engine/db/create"


@pytest.fixture
def watch():
    """A fresh copy of the script, so no test sees another's stub."""
    spec = importlib.util.spec_from_file_location("watch_under_test", SCRIPT)
    module = importlib.util.module_from_spec(spec)
    spec.loader.exec_module(module)
    return module


def _q(path):
    return urllib.parse.quote(path, safe="/")


def _answers(watch):
    """The answers of an unchanged upstream, built from the pins."""
    edition = watch.EDITION
    answers = {
        f"/{REPO}": {"default_branch": "main"},
        f"/{REPO}/tags?per_page=100": [{"name": t} for t in sorted(watch.KNOWN_TAGS)],
        f"/{REPO}/git/ref/tags/{_q(edition['tag'])}": {
            "object": {"type": "commit", "sha": edition["commit"]}
        },
        f"/{REPO}/commits/main": {"sha": watch.FINOS_COMMIT},
    }
    folders: dict = {}
    for pin in watch.pins():
        folder = str(PurePosixPath(pin["path"]).parent)
        folder = "" if folder == "." else folder
        for ref in (pin["commit"], "main"):
            folders.setdefault((folder, ref), []).append(
                {"path": pin["path"], "sha": pin["sha"], "type": "file"}
            )
    folders[("", "main")] = [
        {"path": "LICENSE", "sha": watch.LICENCES[REPO], "type": "file"}
    ]
    for (folder, ref), entries in folders.items():
        answers[f"/{REPO}/contents/{_q(folder)}?ref={_q(ref)}"] = entries
    return answers


def _run(watch, answers, capsys, argv=()):
    def fake_get(path):
        answer = answers[path]
        if isinstance(answer, Exception):
            raise answer
        return answer

    watch._get = fake_get
    code = watch.main(list(argv))
    return code, capsys.readouterr().out


def _ddl_key(watch, ref):
    return f"/{REPO}/contents/{_q(DDL)}?ref={_q(ref)}"


def test_an_unchanged_upstream_reports_nothing(watch, capsys):
    code, report = _run(watch, _answers(watch), capsys)
    assert code == 0, report
    assert "**" not in report


def test_every_pin_is_at_the_pinned_commit(watch):
    assert {p["commit"] for p in watch.pins()} == {watch.EDITION["commit"]}
    assert {p["repository"] for p in watch.pins()} == {REPO}
    assert all(p["local"] == p["path"] for p in watch.pins())


def test_a_new_tag_is_reported_and_quoted(watch, capsys):
    answers = _answers(watch)
    answers[f"/{REPO}/tags?per_page=100"].append({"name": "v3.2.0 `@x`"})
    code, report = _run(watch, answers, capsys)
    assert code == 1
    assert f"{REPO} has 1 new tags:** `v3.2.0 '@x'`" in report


def test_a_moved_tag_is_reported(watch, capsys):
    answers = _answers(watch)
    answers[f"/{REPO}/git/ref/tags/v3.1.1"] = {
        "object": {"type": "commit", "sha": "abc123"}
    }
    code, report = _run(watch, answers, capsys)
    assert code == 1
    assert f"The tag v3.1.1 of {REPO} moved to `abc123`" in report


def test_a_tag_behind_two_tag_objects_is_followed(watch, capsys):
    answers = _answers(watch)
    answers[f"/{REPO}/git/ref/tags/v3.1.1"] = {
        "object": {"type": "tag", "sha": "outer"}
    }
    answers[f"/{REPO}/git/tags/outer"] = {"object": {"type": "tag", "sha": "inner"}}
    answers[f"/{REPO}/git/tags/inner"] = {
        "object": {"type": "commit", "sha": watch.EDITION["commit"]}
    }
    code, report = _run(watch, answers, capsys)
    assert code == 0, report


def test_a_hundred_tags_stop_the_tags_check(watch, capsys):
    answers = _answers(watch)
    answers[f"/{REPO}/tags?per_page=100"] = [{"name": f"t{i}"} for i in range(100)]
    code, report = _run(watch, answers, capsys)
    assert code == 1
    assert "The tags check could not finish" in report
    assert "100 tags or more" in report


def test_a_renamed_default_branch_is_read_from_the_api(watch, capsys):
    """The licence check reads the branch the API names, not a fixed one."""
    answers = _answers(watch)
    answers[f"/{REPO}"] = {"default_branch": "trunk"}
    answers[f"/{REPO}/commits/trunk"] = answers.pop(f"/{REPO}/commits/main")
    for key in [k for k in answers if k.startswith(f"/{REPO}/contents/")]:
        if key.endswith("?ref=main"):
            answers[key.replace("?ref=main", "?ref=trunk")] = answers.pop(key)
    code, report = _run(watch, answers, capsys)
    assert code == 0, report


def test_a_changed_pinned_file_is_reported(watch, capsys):
    answers = _answers(watch)
    entries = answers[_ddl_key(watch, watch.EDITION["commit"])]
    entries[0]["sha"] = "0" * 40
    code, report = _run(watch, answers, capsys)
    assert code == 1
    assert f"1 pinned files changed:** `{REPO}/{entries[0]['path']}`" in report


def test_a_gone_pinned_file_is_reported(watch, capsys):
    answers = _answers(watch)
    key = _ddl_key(watch, watch.EDITION["commit"])
    gone = answers[key][0]["path"]
    answers[key] = answers[key][1:]
    code, report = _run(watch, answers, capsys)
    assert code == 1
    assert f"1 pinned files gone:** `{REPO}/{gone}`" in report


def test_a_changed_licence_is_reported(watch, capsys):
    answers = _answers(watch)
    for entry in answers[f"/{REPO}/contents/?ref=main"]:
        entry["sha"] = "1" * 40
    code, report = _run(watch, answers, capsys)
    assert code == 1
    assert f"LICENSE on {REPO}'s default branch changed" in report


def test_unreleased_source_changes_are_for_information_only(watch, capsys):
    answers = _answers(watch)
    for entry in answers[_ddl_key(watch, "main")]:
        entry["sha"] = "2" * 40
    code, report = _run(watch, answers, capsys)
    assert code == 0, report
    assert "For information, 7 of the files the converters read differ" in report


def test_a_newer_finos_tree_is_for_information_only(watch, capsys):
    answers = _answers(watch)
    answers[f"/{REPO}/commits/main"] = {"sha": "3" * 40}
    code, report = _run(watch, answers, capsys)
    assert code == 0, report
    assert f"{REPO}'s default branch is at `3333333" in report


@pytest.mark.parametrize(
    "error",
    [
        urllib.error.URLError("refused"),
        http.client.IncompleteRead(b""),
        ValueError("a redirect leads off api.github.com"),
    ],
)
def test_a_failed_check_is_reported(watch, capsys, error):
    answers = _answers(watch)
    answers[f"/{REPO}/tags?per_page=100"] = error
    code, report = _run(watch, answers, capsys)
    assert code == 1
    assert "The tags check could not finish" in report


def test_a_redirect_off_the_api_is_refused(watch):
    handler = watch._ApiRedirect()
    with pytest.raises(ValueError, match="leads off"):
        handler.redirect_request(None, None, 302, "Found", {}, "https://example.org/x")
    with pytest.raises(ValueError, match="leads off"):
        handler.redirect_request(
            None, None, 302, "Found", {}, "http://api.github.com/x"
        )


def test_the_report_is_written_to_a_file(watch, capsys, tmp_path):
    out = tmp_path / "report.md"
    code, report = _run(watch, _answers(watch), capsys, ["--report", str(out)])
    assert code == 0
    assert out.read_text(encoding="utf-8") == report
