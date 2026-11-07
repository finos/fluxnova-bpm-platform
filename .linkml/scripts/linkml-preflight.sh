#!/usr/bin/env bash
# What this host can and cannot do for the LinkML sidecar skills: one
# read-only screen, no project needed. linkml-sidecar runs it first (Step 0)
# and repeats its summary line in the hand-off; linkml-author runs the copy
# the sidecar installed under .linkml/scripts/, or this one, to find the
# schema and the way to run the tools on it. A missing tool disables a step
# out loud instead of being discovered after the scaffold has run.
#
# Each line is `ok`, `warn`, `missing` or `info`, then one summary line:
#   Preflight: <n> missing, <m> warning(s). Missing disables: <steps>.
# Exit 0 always: the skills read the lines; nothing here is a gate.
#
# Bash 3.2 and POSIX tools only, so it runs on macOS's stock bash and on Git
# for Windows. From PowerShell, run it through Git for Windows' bash: the
# one-liner is in linkml-sidecar/references/portability.md.
#
# Usage: linkml-preflight.sh [repo-root]   (default: the nearest ancestor of
# the current directory holding `.linkml/`, `.lokf/` or `.git`, else the
# current directory). LINKML_PREFLIGHT_OFFLINE=1 skips the two checks that
# reach the network (copier through uvx, and the template's source and the
# package index), for tests and air-gapped machines.
[ -n "${BASH_VERSION:-}" ] || { echo "run this with bash: bash ${0##*/} [repo-root]" >&2; exit 2; }
set -u

missing=0; warns=0; disables=""
line() { printf '%-8s%-11s%s\n' "$1" "$2" "$3"; }
ok()   { line ok "$1" "$2"; }
info() { line info "$1" "$2"; }
warn() { line warn "$1" "$2"; warns=$((warns + 1)); }
miss() { line missing "$1" "$2"; missing=$((missing + 1)); [ -n "${3:-}" ] && disables="${disables}${disables:+; }$3"; }
have() { command -v "$1" >/dev/null 2>&1; }
# One value out of a `KEY="value"` or `KEY=value` line of config.public.mk.
mkvalue() { sed -n "s/^$2=//p" "$1" 2>/dev/null | head -n 1 | sed -e 's/^"//' -e 's/"$//'; }
# One value out of a `key: value` line of a copier answers file.
answer() { sed -n "s/^$2: *//p" "$1" 2>/dev/null | head -n 1 | tr -d '"'"'"''; }
# The host of a URL, without its scheme, user, password, port and path. An
# index URL may carry a password, so a URL is only ever printed this way.
hostof() { printf '%s\n' "$1" | sed -e 's#^[A-Za-z][A-Za-z0-9+.-]*://##' -e 's#^[^/@]*@##' -e 's#[/:?].*$##'; }

# ---- root ------------------------------------------------------------------
start="$(pwd -P)"
root="${1:-}"
if [ -z "$root" ]; then
  d="$start"; root="$d"
  while [ "$d" != "/" ]; do
    if [ -d "$d/.linkml" ] || [ -d "$d/.lokf" ] || [ -d "$d/.git" ]; then root="$d"; break; fi
    d="$(dirname "$d")"
  done
fi
root="$(cd "$root" 2>/dev/null && pwd -P)" || { echo "no such directory: ${1:-.}" >&2; exit 2; }
# A path as a person reads it: relative to the root, or `.` for the root.
# A path outside the root stays absolute: stripping the root as a bare string
# prefix would turn a sibling such as <root>2/schema into 2/schema.
relpath() { case "$1" in "$root") printf '.' ;; "$root"/*) printf '%s' "${1#"$root"/}" ;; *) printf '%s' "$1" ;; esac; }

# ---- host ------------------------------------------------------------------
os="$(uname -s 2>/dev/null || echo unknown)"
case "$os" in
  Linux) host=Linux ;;
  Darwin) host=macOS ;;
  MINGW*|MSYS*|CYGWIN*) host="Windows (Git for Windows bash)" ;;
  *) host="$os" ;;
esac
if have python3; then py="python3 $(python3 --version 2>&1 | sed 's/^Python //')"; else py="none (uv run python stands in)"; fi
printf 'Preflight for %s\n' "$root"
ok host "$host, bash ${BASH_VERSION%%(*}; python: $py"
case "$root" in
  *OneDrive*|*Dropbox*|*iCloud*|*"Google Drive"*|*GoogleDrive*|*Nextcloud*)
    info sync "synced folder: the linkml_schema link is per machine, and .venv/ should be excluded from the sync" ;;
esac

# ---- git -------------------------------------------------------------------
ingit=0; tracked=""; forge=none; remote=""
if have git && git -C "$root" rev-parse --is-inside-work-tree >/dev/null 2>&1; then
  ingit=1
  if [ -n "$(git -C "$root" ls-files .linkml 2>/dev/null | head -n 1)" ]; then tracked="tracked"
  elif git -C "$root" check-ignore -q .linkml 2>/dev/null; then tracked="gitignored (no workflow, no pull requests for the schema)"
  elif [ -d "$root/.linkml" ]; then tracked="not yet committed"
  else tracked="not present"; fi
  remote="$(git -C "$root" remote get-url origin 2>/dev/null || true)"
  case "$remote" in
    *github*) forge=github ;;
    *gitlab*) forge=gitlab ;;
    *codeberg*|*forgejo*|*gitea*) forge=forgejo ;;
    *bitbucket*) forge=bitbucket ;;
    "") forge=none ;;
    *) forge=other ;;
  esac
  ok git ".linkml/ $tracked; forge $forge${remote:+ ($remote)}"
  # --show-prefix is empty at the root and a path below it, on every host;
  # --show-toplevel spells the path differently from pwd on Git for Windows.
  prefix="$(git -C "$root" rev-parse --show-prefix 2>/dev/null || true)"
  [ -n "$prefix" ] && warn git "this directory is $prefix inside its repository; the sidecar belongs at the repository root"
elif have git; then
  info git "not under git: copier update, the workflow and pull requests do not apply; the host's own history is the record"
else
  miss git "git not installed - copier fetches the template with it, and the scaffold checks the template's tag with git ls-remote" "Step 1 (the scaffold)"
fi

# The folder the forge reads workflows from. Forgejo, Codeberg's forge, reads
# only the first of .forgejo/, .gitea/ and .github/workflows/ that exists, so
# the sidecar's workflow goes in that one, and a new folder would hide it.
wfdir=.github/workflows
if [ "$forge" = forgejo ]; then
  wfdir=.forgejo/workflows
  for d in .forgejo/workflows .gitea/workflows .github/workflows; do
    if [ -d "$root/$d" ]; then wfdir="$d"; break; fi
  done
fi

# ---- package index ---------------------------------------------------------
# The index uv installs from: UV_DEFAULT_INDEX (a URL, or name=URL), the
# older UV_INDEX_URL, else the default index of a user or system uv.toml,
# else PyPI. The copier, lock and network lines name its host.
index="${UV_DEFAULT_INDEX:-${UV_INDEX_URL:-}}"
case "$index" in *=http*) index="${index#*=}" ;; esac
if [ -z "$index" ]; then
  for f in "${XDG_CONFIG_HOME:-${HOME:-}/.config}/uv/uv.toml" /etc/uv/uv.toml; do
    [ -f "$f" ] || continue
    # An [[index]] table with `default = true` names the default index; a
    # top-level index-url is the older spelling of the same.
    index="$(awk '
      function flush() { if (inidx && dflt && url != "") found = url }
      /^[[:space:]]*\[\[index\]\]/ { flush(); inidx = 1; url = ""; dflt = 0; next }
      /^[[:space:]]*\[/ { flush(); inidx = 0; next }
      inidx && /^[[:space:]]*url[[:space:]]*=/ { url = $0; sub(/^[^"]*"/, "", url); sub(/".*$/, "", url) }
      inidx && /^[[:space:]]*default[[:space:]]*=[[:space:]]*true/ { dflt = 1 }
      !inidx && /^[[:space:]]*index-url[[:space:]]*=/ { top = $0; sub(/^[^"]*"/, "", top); sub(/".*$/, "", top) }
      END { flush(); if (found != "") print found; else if (top != "") print top }' "$f")"
    [ -n "$index" ] && break
  done
fi
index="${index:-https://pypi.org/simple}"
ihost="$(hostof "$index")"

# ---- tooling ---------------------------------------------------------------
if have uv; then
  ok uv "uv $(uv --version 2>/dev/null | sed 's/^uv //')"
  pyfound="$(uv python find '>=3.10' 2>/dev/null || true)"
  if [ -n "$pyfound" ]; then ok python "$pyfound satisfies the project's >=3.10"
  else miss python "uv finds no Python >=3.10 - uv python install 3.12" "Step 4 (install, lint, test)"; fi
  if [ -f "$root/.python-version" ]; then
    pinned="$(head -n 1 "$root/.python-version" | tr -d ' \r')"
    case "$pinned" in
      2.*|3.[0-9]|3.[0-9].*) warn python "root .python-version pins $pinned; uv reads it inside .linkml/ too, and the project needs >=3.10" ;;
    esac
  fi
  copier_cmd=(uvx --from 'copier>=9.4.0,<10' --with jinja2-time copier)
  copier_hint="uvx --from 'copier>=9.4.0,<10' --with jinja2-time copier --version"
  if [ "${LINKML_PREFLIGHT_OFFLINE:-}" = 1 ]; then
    info copier "not checked (LINKML_PREFLIGHT_OFFLINE=1): $copier_hint"
  elif cout="$("${copier_cmd[@]}" --version 2>&1)" && cv="$(printf '%s\n' "$cout" | grep -m 1 '^copier [0-9]')"; then
    ok copier "$cv through uvx, with jinja2-time (the template needs both)"
  else
    # uv says why it failed; a certificate error also mentions the request,
    # so it is matched first.
    case "$cout" in
      *system-certs*|*native-tls*|*certificate*) why="uv does not trust this network's certificates - set UV_SYSTEM_CERTS=true, or SSL_CERT_FILE to the system's bundle" ;;
      *"No interpreter found"*|*"current Python version"*) why="uv finds no Python that copier runs on (3.9 or later)" ;;
      *"error sending request"*|*"dns error"*|*"Connection refused"*|*"timed out"*) why="uv cannot reach the package index $ihost" ;;
      *) why="uvx cannot run copier" ;;
    esac
    miss copier "$why - try: $copier_hint" "Step 1 (the scaffold)"
  fi
  if have just; then ok just "just $(just --version 2>/dev/null | sed 's/^just //')"
  else info just "just not installed - uvx --from rust-just just works the same, and so does uv tool install rust-just"; fi
else
  miss uv "uv not installed (docs.astral.sh/uv) - copier, just, the project's Python and every generator run through it" "Steps 1, 4 and 5"
fi

# ---- sidecar: what the host already holds ----------------------------------
# A LinkML schema project is told by its files, never by its folder's name:
# linkml-project-copier's answers naming that template, or the config.public.mk
# that it and the older linkml-project-cookiecutter render (a signal upstream
# may retire; the answers stay). The candidates are .linkml/ (the sidecar), the
# repository root, the directory this script was started in, and every
# directory one level down, hidden or not. A .linkml/ that holds only
# configuration files (LinkML's own, or a tool's) is reported and nothing more:
# the sidecar installs around it. With no project anywhere, the schema files
# are found by content (below), because a schema can live in any repository.
is_project() {
  [ -f "$1/config.public.mk" ] && return 0
  [ -f "$1/.copier-answers.yml" ] && answer "$1/.copier-answers.yml" _src_path | grep -q 'linkml-project-copier'
}
# .linkml/ with any answers file is a sidecar, whatever template a local clone was called.
holds_project() {
  if [ "$1" = "$root/.linkml" ] && [ -f "$1/.copier-answers.yml" ]; then return 0; fi
  is_project "$1"
}
told_by() { if [ -f "$1/.copier-answers.yml" ]; then printf 'copier answers'; else printf 'config.public.mk'; fi; }
# Folders that by convention hold copies, fixtures or rendered output, never
# the host's own model; the scaffold prunes the same names.
pruned() {
  case "$1" in
    .|..|.git|.github|.venv|node_modules|tmp|site|project|docs|tests|test|fixtures|templates|.lokf) return 0 ;;
  esac
  return 1
}
candidates="$root/.linkml
$root
$start"
for d in "$root"/*/ "$root"/.*/; do
  d="${d%/}"
  pruned "${d##*/}" && continue
  [ -d "$d" ] && candidates="$candidates
$d"
done
sidecar=""; others=""; seen="
"
oldifs="$IFS"; IFS="
"
for d in $candidates; do
  case "$d" in "$root"|"$root"/*) ;; *) continue ;; esac
  case "$seen" in *"
$d
"*) continue ;; esac
  seen="$seen$d
"
  if ! { [ -d "$d" ] && holds_project "$d"; }; then continue; fi
  if [ -z "$sidecar" ]; then sidecar="$d"; else others="$others${others:+, }$(relpath "$d")/"; fi
done
IFS="$oldifs"

# kind: sidecar (a copier sidecar in .linkml/), project (a schema project
# elsewhere, which no sidecar joins), schemas (schema files outside any
# project) or none.
kind=none
if [ -n "$sidecar" ]; then
  commit="$(answer "$sidecar/.copier-answers.yml" _commit)"
  src="$(answer "$sidecar/.copier-answers.yml" _src_path)"
  if [ "$sidecar" = "$root/.linkml" ] && [ -f "$sidecar/.copier-answers.yml" ]; then
    kind=sidecar
    ok sidecar ".linkml/ from ${src:-?} at ${commit:-?}; linkml-author works here; just --justfile .linkml/justfile update moves the template"
    [ -e "$root/.linkml/.git" ] && warn sidecar ".linkml/.git exists: a nested repository, which just setup creates - remove it (rm -rf .linkml/.git) so the host repository holds the sidecar"
  elif [ "$sidecar" = "$root/.linkml" ]; then
    kind=project
    info sidecar ".linkml/ holds a LinkML schema project made without copier (config.public.mk); linkml-author works in it, linkml-sidecar leaves it alone"
  elif [ "$sidecar" = "$root" ]; then
    kind=project
    info sidecar "this repository is itself a LinkML schema project ($(told_by "$root")${src:+: $src}${commit:+ at $commit}); no sidecar applies, linkml-author works at the root"
  else
    kind=project
    info sidecar "$(relpath "$sidecar")/ is a LinkML schema project ($(told_by "$sidecar")${src:+: $src}${commit:+ at $commit}); linkml-sidecar leaves it alone, linkml-author works in it"
  fi
  [ -n "$others" ] && info sidecar "also a LinkML schema project: $others; linkml-author works in whichever a person names"
else
  if [ -d "$root/.linkml" ]; then
    shaped=""
    for n in pyproject.toml justfile Makefile src; do [ -e "$root/.linkml/$n" ] && shaped="$shaped${shaped:+, }$n"; done
    held="$(cd "$root/.linkml" && find . -mindepth 1 -maxdepth 1 2>/dev/null | sed 's|^\./||' | sort | head -n 5 | tr '\n' ' ')"
    if [ -n "$shaped" ]; then
      warn sidecar ".linkml/ holds $shaped but no .copier-answers.yml or config.public.mk - an unfinished sidecar, or a project made by hand; linkml-sidecar refuses it until a person decides which"
    elif [ -n "$held" ]; then
      info sidecar ".linkml/ holds configuration files (${held% }) and no project; linkml-sidecar installs around them, and the schema is looked for elsewhere"
    else
      info sidecar ".linkml/ is empty; linkml-sidecar installs into it"
    fi
  fi
fi

# ---- schema files, by content -----------------------------------------------
# A YAML file that imports linkml:types or names the linkml prefix and has a
# top-level key only a schema has, outside the pruned folders: what git tracks
# or would track, else the whole tree.
schema_files() {
  prune='(^|/)(\.git|\.github|\.venv|node_modules|tmp|site|project|docs|tests|test|fixtures|templates|\.lokf|\.linkml)/'
  if [ "$ingit" -eq 1 ]; then
    # core.quotePath=false: git would otherwise quote a non-ASCII path, which then matches no file.
    git -C "$root" -c core.quotePath=false ls-files -co --exclude-standard -- '*.yaml' '*.yml' 2>/dev/null
  else
    (cd "$root" && find . \( -name .git -o -name .github -o -name .venv -o -name node_modules -o -name tmp -o -name site -o -name project -o -name docs -o -name tests -o -name test -o -name fixtures -o -name templates -o -name .lokf -o -name .linkml \) -prune -o -type f \( -name '*.yaml' -o -name '*.yml' \) -print 2>/dev/null | sed 's|^\./||')
  fi | grep -vE "$prune" | while IFS= read -r f; do
    grep -qE 'linkml:types|w3id\.org/linkml/' "$root/$f" 2>/dev/null && grep -qE '^(classes|slots|enums|types|subsets|imports):' "$root/$f" 2>/dev/null && printf '%s\n' "$f"
  done | sort
}
if [ "$kind" = none ]; then
  schemas="$(schema_files)"
  if [ -n "$schemas" ]; then
    kind=schemas
    n="$(printf '%s\n' "$schemas" | grep -c .)"
    info sidecar "no sidecar or project; $n LinkML schema file(s) found by content (below): linkml-author works on them in place, and linkml-sidecar --adopt <file> gives one the toolchain"
    printf '%s\n' "$schemas" | head -n 5 | while IFS= read -r f; do ok schema "$f"; done
    [ "$n" -gt 5 ] && info schema "and $((n - 5)) more"
  else
    miss sidecar "no LinkML project or schema under $root - run linkml-sidecar first" "linkml-author until a schema exists, and linkml-sidecar Steps 2 to 5 until Step 1 has run"
  fi
fi

# ---- project ---------------------------------------------------------------
# The project directory as a person reads it: relative to the root, or empty when it is the root.
sdisp="${sidecar#"$root"}"; sdisp="${sdisp#/}"; sdisp="${sdisp:+$sdisp/}"
name=""; srcdir=""
if [ -n "$sidecar" ]; then
  # config.public.mk names the schema while the template renders it; the answers' project_slug is the fallback.
  if [ -f "$sidecar/config.public.mk" ]; then
    name="$(mkvalue "$sidecar/config.public.mk" LINKML_SCHEMA_NAME)"
    srcdir="$(mkvalue "$sidecar/config.public.mk" LINKML_SCHEMA_SOURCE_DIR)"
  else
    name="$(answer "$sidecar/.copier-answers.yml" project_slug)"
    srcdir="src/$name/schema"
  fi
  schema="$srcdir/$name.yaml"
  shown="$sdisp$schema"
  # An adopted schema sits outside the sidecar, where LINKML_SCHEMA_SOURCE_DIR points.
  case "$srcdir" in ..*) [ -d "$sidecar/$srcdir" ] && shown="$(relpath "$(cd "$sidecar/$srcdir" && pwd -P)")/$name.yaml" ;; esac
  venv="no .venv (just install)"; [ -d "$sidecar/.venv" ] && venv=".venv present"
  if [ -n "$name" ] && [ -f "$sidecar/$schema" ]; then ok project "schema $shown; $venv"
  elif [ -n "$name" ]; then warn project "the project names $schema but it is not there - the schema file is the one thing linkml-author needs"
  else warn project "${sdisp}config.public.mk missing and the answers name no project_slug - just cannot find the schema name; linkml-sidecar repair, or copier update, lays config.public.mk down"; fi
  # The generators' settings: the template renders config.yaml and names it
  # in config.public.mk, which every recipe reads. The sidecar keeps them as
  # .linkml/generators.yaml, and linkml-sidecar --repair generators.yaml
  # moves an existing project's file there, so the line below is an offer.
  if [ -f "$sidecar/config.public.mk" ]; then
    gens="$(mkvalue "$sidecar/config.public.mk" LINKML_GENERATORS_CONFIG_YAML)"
    case "$gens" in
      config.yaml)
        [ -f "$sidecar/config.yaml" ] && info generators "${sdisp}config.yaml holds the generators' settings; linkml-sidecar --repair generators.yaml moves it to .linkml/generators.yaml and changes the one line of ${sdisp}config.public.mk that names it" ;;
      generators.yaml|.linkml/generators.yaml)
        [ -f "$sidecar/config.yaml" ] && warn generators "${sdisp}config.yaml exists beside $gens, which the recipes read - carry any change into $gens, then delete ${sdisp}config.yaml" ;;
    esac
  fi
  if [ "$ingit" -eq 1 ] && [ "$tracked" = tracked ] && [ -f "$root/$wfdir/linkml-sidecar.yaml" ] \
     && [ -z "$(git -C "$root" ls-files .linkml/uv.lock 2>/dev/null | head -n 1)" ]; then
    warn project ".linkml/uv.lock is not in git - the workflow installs with uv sync --locked and fails without it; run just --justfile .linkml/justfile install and commit the file"
  fi
  # A lock records the index it was made against, and every file's address
  # there. Where uv reads another index, uv sync --locked fails on it, and
  # just install rewrites every address to the index uv reads.
  if [ -f "$sidecar/uv.lock" ]; then
    lhost="$(hostof "$(sed -n 's/.*registry = "\([^"]*\)".*/\1/p' "$sidecar/uv.lock" | sort | uniq -c | sort -rn | head -n 1 | sed 's/^ *[0-9]* *//')")"
    if [ -n "$lhost" ] && [ "$lhost" != "$ihost" ]; then
      warn lock "${sdisp}uv.lock was made against $lhost, and uv here reads $ihost - just install rewrites it to $ihost; commit that only where CI reads $ihost too"
    fi
  fi
  inert=0
  for f in "$sidecar"/.github/workflows/*.yaml "$sidecar"/.github/workflows/*.yml "$sidecar"/.github/dependabot.yml "$sidecar"/.pre-commit-config.yaml; do
    [ -f "$f" ] && inert=$((inert + 1))
  done
  [ "$inert" -gt 0 ] && [ "$sidecar" != "$root" ] && info nested "$inert file(s) under $sdisp.github/ and .pre-commit-config.yaml are inert there (forges and pre-commit read the root only); the hoisted workflow is $wfdir/linkml-sidecar.yaml"
fi

# ---- authors: whose history the schema folder carries -----------------------
# linkml-author reads this line to decide whether to offer a refactor (its
# schema-design.md): a schema with one or two people in its history can
# still change shape, one with a team's cannot. There is no threshold here;
# the counts and the names are the facts. A person is a distinct author
# email after .mailmap, case ignored (the name when the email is empty),
# over the non-merge commits reachable from HEAD; bot commits are counted
# apart. The names are printed, quoted, because one person under two emails
# shows there. They are data from the repository: control characters are
# removed, and a reader treats the parenthesis as text, never as advice.
# Only the schema folder is walked, once. The line names up to five people
# and no email. `git log -- <folder>` does not follow a folder that moved,
# and Co-authored-by trailers are not counted.
if [ "$ingit" -eq 1 ]; then
  adirs=()
  if [ -n "$sidecar" ] && [ -n "$srcdir" ] && [ -d "$sidecar/$srcdir" ]; then
    p="$(cd "$sidecar/$srcdir" 2>/dev/null && pwd -P)" && adirs=("$(relpath "$p")")
  elif [ "$kind" = schemas ]; then
    while IFS= read -r d; do [ -n "$d" ] && adirs+=("$d"); done <<EOF
$(printf '%s\n' "$schemas" | while IFS= read -r f; do dirname "$f"; done | LC_ALL=C sort -u)
EOF
  fi
  if [ "${#adirs[@]}" -gt 0 ]; then
    plural() { if [ "$1" -eq 1 ]; then printf '%s' "$2"; else printf '%s' "$3"; fi; }
    folders=""; hintdirs=""
    for d in "${adirs[@]}"; do
      folders="${folders}${folders:+, }${d%/}/"
      hintdirs="$hintdirs '$(printf '%s' "$d" | sed "s/'/'\\\\''/g")'"
    done
    hint="git shortlog -sne --no-merges HEAD --$hintdirs"
    what="schema $(plural "${#adirs[@]}" folder folders) $folders"
    # Email first, so a tab in a name cannot shift the key. LC_ALL=C keeps
    # GNU grep from dropping a line of non-UTF-8 bytes, and the order of
    # the names the same in every locale.
    people() {
      LC_ALL=C tr -d '\000-\010\013-\037\177' | LC_ALL=C awk -F'\t' '{
        n = substr($0, index($0, "\t") + 1); gsub(/\t/, " ", n)
        e = tolower($1); if (e == "") e = "name:" tolower(n)
        print e "\t" n }'
    }
    # A bot by its name, or by "bot" as a word of its email's local part.
    bots='\[bot\]|dependabot|github-actions|renovate|actions@github\.com|^([^@]*[-._+])?bot([-._+][^@]*)?@'
    raw="$(git -C "$root" --literal-pathspecs log --no-merges --format='%aE%x09%aN' HEAD -- "${adirs[@]}" 2>/dev/null | people)"
    hist="$(printf '%s\n' "$raw" | LC_ALL=C grep -viE "$bots")"
    acommits="$(printf '%s\n' "$hist" | grep -c .)"
    bcommits=$(( $(printf '%s\n' "$raw" | grep -c .) - acommits ))
    bnote=""; [ "$bcommits" -gt 0 ] && bnote=", and $bcommits bot $(plural "$bcommits" commit commits)"
    shallow=""; [ "$(git -C "$root" rev-parse --is-shallow-repository 2>/dev/null)" = true ] && shallow="; a shallow clone, so the history is cut short and the counts mean nothing"
    if [ "$acommits" -gt 0 ]; then
      apeople="$(printf '%s\n' "$hist" | cut -f1 | LC_ALL=C sort -u | grep -c .)"
      anames="$(printf '%s\n' "$hist" | cut -f2- | grep . | LC_ALL=C sort | LC_ALL=C uniq -c | LC_ALL=C sort -k1,1nr -k2 | LC_ALL=C awk '{
        sub(/^[ \t]*[0-9]+[ \t]/, ""); n[NR] = $0 }
        END { m = (NR <= 5 ? NR : 4)
          for (i = 1; i <= m; i++) printf "%s\"%s\"", (i > 1 ? ", " : ""), n[i]
          if (NR > 5) printf ", and %d more", NR - 4 }')"
      info authors "$what: $apeople $(plural "$apeople" person people), $acommits $(plural "$acommits" commit commits) ($anames)$bnote$shallow; $hint for the detail"
    elif [ "$bcommits" -gt 0 ]; then
      info authors "$what: no person, only $bcommits bot $(plural "$bcommits" commit commits)$shallow; $hint for the detail"
    fi
    # A folder with no commits yet has no history to weigh, so no line.
  fi
fi

# ---- tools: how linkml-lint and the generators run here ---------------------
# The host's own environment first, a pinned uvx last, never a tool found on
# the path: the versions the host tested with are the ones that count.
tools=""
if [ -n "$sidecar" ]; then
  if [ -f "$sidecar/justfile" ]; then
    hint=""; have just || hint=" (uvx --from rust-just just stands in for just)"
    tools="just --justfile ${sdisp}justfile <recipe>: lint, gen-project, test, gen-doc$hint"
  elif [ -f "$sidecar/Makefile" ]; then
    tools="make -C ${sdisp:-.} <target>: lint, gen-project, test, gendoc"
  else
    tools="uv run --project ${sdisp:-.} linkml-lint and gen-project (the project has no justfile or Makefile)"
  fi
elif [ "$kind" = schemas ]; then
  if [ -f "$root/uv.lock" ] && grep -q linkml "$root/pyproject.toml" 2>/dev/null; then
    tools="uv run linkml-lint <schema>, and gen-project the same way: the host's pyproject.toml names linkml"
  elif [ -f "$root/poetry.lock" ] && grep -q linkml "$root/pyproject.toml" 2>/dev/null; then
    tools="poetry run linkml-lint <schema>, and gen-project the same way: the host's pyproject.toml names linkml"
  elif grep -qs linkml "$root"/requirements*.txt 2>/dev/null; then
    tools="the host's own environment: its requirements name linkml"
  else
    tools="uvx --from linkml linkml-lint <schema>, and gen-project the same way; name the version uvx resolved in the hand-off"
  fi
fi
[ -n "$tools" ] && info tools "$tools"

# ---- doorway ---------------------------------------------------------------
door="$root/linkml_schema"
if [ -L "$door" ]; then ok doorway "linkml_schema -> $(readlink "$door")"
elif [ -d "$door" ]; then ok doorway "linkml_schema is a folder or junction"
elif [ "$kind" = sidecar ]; then
  case "$srcdir" in
    ..*) info doorway "no linkml_schema doorway: the adopted schema is already visible at ${shown%/*}/" ;;
    *) info doorway "no linkml_schema doorway (ln -s .linkml/src/${name:-<slug>}/schema linkml_schema, just --justfile .linkml/justfile linkml-link, or mklink /J on Windows)" ;;
  esac
fi

# ---- KTL -------------------------------------------------------------------
if [ -d "$root/.lokf" ]; then
  floor="$(sed -n 's/.*"lokf\[build\]>=\([0-9.]*\)".*/\1/p' "$root/.lokf/pyproject.toml" 2>/dev/null | head -n 1)"
  pinned="absent (the scaffold copies it out of the installed toolkit)"; [ -f "$root/.lokf/lokf.yaml" ] && pinned="pinned"
  # ktl-sidecar's template carries `schema := ""` until a schema is named.
  named="$(sed -n 's/^schema := "\(.*\)"$/\1/p' "$root/.lokf/justfile" 2>/dev/null | head -n 1)"
  wired="not wired"; [ -n "$named" ] && wired="wired ($named)"
  # A lokf command given no --schema (0.9.0 or later) reads `[tool.lokf] schema`; the scaffold writes the line's path there too.
  tool="$(awk -v q="'" '
    /^[[:space:]]*\[/ { intool = ($0 ~ /^[[:space:]]*\[tool\.lokf\][[:space:]]*(#.*)?$/); next }
    intool && /^[[:space:]]*schema[[:space:]]*=/ {
      v = $0; sub(/^[^=]*=[[:space:]]*/, "", v)
      if (match(v, /^"[^"]*"/) || match(v, "^" q "[^" q "]*" q)) print substr(v, 2, RLENGTH - 2)
      exit
    }' "$root/.lokf/pyproject.toml" 2>/dev/null)"
  # A copy `lokf adapt` wrote means the adapt route: the project's schema is the source, so edits go there and the copy is written again.
  adapted="# Generated by \`lokf adapt\` from "
  first="$( [ -n "$named" ] && head -n 1 "$root/.lokf/$named" 2>/dev/null)"
  case "$first" in
    "$adapted"*) src="${first#"$adapted"}"; wired="wired ($named, a copy lokf adapt wrote from ${src%; do not edit.})" ;;
  esac
  base="$(sed -n 's/^base_iri: *//p' "$root/.lokf/knowledge/index.md" 2>/dev/null | head -n 1)"
  ok lokf "KTL bundle present: with-KTL mode; lokf floor >=${floor:-?}; .lokf/lokf.yaml $pinned; .lokf/justfile schema $wired; [tool.lokf] schema ${tool:-absent}; base_iri ${base:-unknown}"
  [ -n "$tool" ] && [ "${tool#./}" != "${named#./}" ] && warn lokf "[tool.lokf] schema in .lokf/pyproject.toml is $tool and .lokf/justfile's schema line is ${named:-empty}: a bare lokf command and the recipes check against different schemas; set both to one path"
  [ -z "$base" ] && warn lokf "no base_iri in .lokf/knowledge/index.md - the dummy concept's id needs it (BASE_IRI)"
  [ -z "$named" ] && [ "$kind" != none ] && info lokf "the schema is not the bundle's domain schema until .lokf/justfile names it (schema :=); a schema beside an unwired bundle stays what it is"
else
  info lokf "no .lokf/: plain mode; a KTL bundle can be added later and the schema wired to it (references/ktl.md)"
fi

# ---- root pointers, docs and workflows --------------------------------------
if [ -f "$root/.gitignore" ] && grep -qE '^\.linkml/?$' "$root/.gitignore"; then
  info gitignore "root .gitignore names .linkml: gitignored mode (no commit, no workflow)"
fi
pages=""
if [ "$ingit" -eq 1 ]; then
  git -C "$root" show-ref --quiet refs/heads/gh-pages 2>/dev/null && pages="a local gh-pages branch"
  git -C "$root" show-ref --quiet refs/remotes/origin/gh-pages 2>/dev/null && pages="${pages:-}${pages:+ and }origin/gh-pages"
fi
for wf in "$root"/.github/workflows/*.y*ml; do
  case "$wf" in */linkml-sidecar.yaml) continue ;; esac
  if [ -f "$wf" ] && grep -qE 'gh-pages|deploy-pages|mkdocs gh-deploy' "$wf" 2>/dev/null; then
    pages="${pages:-}${pages:+ and }a workflow that publishes Pages"; break
  fi
done
# A project of its own publishes its own pages; the collision is a sidecar's.
if [ -n "$pages" ] && [ "$kind" != project ]; then
  warn pages "the host already publishes Pages ($pages) - never run just deploy from .linkml/; the Step 5 docs job publishes under the linkml/ subpath only"
fi
if [ -d "$root/$wfdir" ]; then
  if [ -f "$root/$wfdir/linkml-sidecar.yaml" ]; then
    if grep -q 'working-directory: .linkml' "$root/$wfdir/linkml-sidecar.yaml"; then ok workflows "$wfdir/linkml-sidecar.yaml present"
    else warn workflows "a linkml-sidecar.yaml exists in $wfdir/ that is not the sidecar's hoisted workflow - rename one of them"; fi
  else
    n="$(find "$root/$wfdir" -maxdepth 1 -name '*.y*ml' | wc -l | tr -d ' ')"
    if [ "$kind" = project ]; then info workflows "$n workflow(s) in $wfdir/; the project's own are its gate, and no hoisted sidecar workflow applies"
    else info workflows "$n workflow(s) in $wfdir/, none for the sidecar (Step 5 lays down linkml-sidecar.yaml there)"; fi
  fi
elif [ "$forge" = forgejo ] && [ "$kind" != project ]; then
  info workflows "no workflow folder yet; on Forgejo, Step 5 lays down $wfdir/linkml-sidecar.yaml"
fi
if [ "$kind" != project ] && [ -f "$root/pyproject.toml" ] && grep -q '^\[tool.uv.workspace\]' "$root/pyproject.toml"; then
  warn workspace "the root pyproject.toml declares a uv workspace; .linkml/ is not a member and uv sync inside it is untested (references/template-assumptions.md)"
fi

# ---- session and network ---------------------------------------------------
unattended=""
for v in CI GITHUB_ACTIONS GITLAB_CI TF_BUILD; do
  val="${!v:-}"; [ -n "$val" ] && unattended="${unattended}${unattended:+, }$v"
done
if [ -n "$unattended" ]; then info session "unattended ($unattended set): guessed facts cannot be confirmed here; the hand-off lists them"
else info session "attended: a person can confirm each guessed fact, and choose among several schemas"; fi
# The template's source and the package index, as git and uv reach them:
# LINKML_TEMPLATE_SRC or the pinned template, after any git
# url.<base>.insteadOf rule, which applies when copier clones it too. Any
# HTTP answer counts as reachable, and curl asks through the same proxy
# variables git and uv read.
tsrc="${LINKML_TEMPLATE_SRC:-gh:linkml/linkml-project-copier}"
case "$tsrc" in gh:*) tsrc="https://github.com/${tsrc#gh:}.git" ;; esac
have git && tsrc="$(git ls-remote --get-url "$tsrc" 2>/dev/null || printf '%s' "$tsrc")"
thost="$(hostof "$tsrc")"; thost="${thost:-$tsrc}"
if [ "${LINKML_PREFLIGHT_OFFLINE:-}" = 1 ]; then
  info network "not checked (LINKML_PREFLIGHT_OFFLINE=1); the scaffold needs the template from $thost and packages from $ihost"
elif have curl; then
  net=""
  case "$tsrc" in
    http://*|https://*)
      if curl -sI --max-time 4 "$tsrc" >/dev/null 2>&1; then net="$thost"
      else warn network "$thost unreachable - copier cannot fetch the template; a company copy goes in LINKML_TEMPLATE_SRC, or in a git url.<copy>.insteadOf rule"; fi ;;
    *://*|*@*) ;;
    *)
      if [ -d "$tsrc" ]; then net="the template copy at $tsrc"
      else warn network "the template source $tsrc is not a directory here"; fi ;;
  esac
  if curl -sI --max-time 4 "${index%/}/linkml/" >/dev/null 2>&1; then net="${net}${net:+, }$ihost"
  else warn network "$ihost unreachable - uv cannot install copier, just or linkml; a company mirror goes in UV_DEFAULT_INDEX"; fi
  [ -n "$net" ] && info network "$net reachable"
else
  warn network "curl not installed - reachability not checked; the scaffold needs the template from $thost and packages from $ihost"
fi

printf 'Preflight: %d missing, %d warning(s).%s\n' "$missing" "$warns" "${disables:+ Missing disables: $disables.}"
exit 0
