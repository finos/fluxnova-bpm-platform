#!/usr/bin/env bash
#
# Fails the build if the repository contains binary files whose extension is not on the
# allow-list documented in CONTRIBUTING.md ("Binary files" section).
#
# This enforces the OpenSSF Security Baseline requirements:
#   OSPS-QA-05.01: The version control system MUST NOT contain generated executable artifacts.
#   OSPS-QA-05.02: The version control system MUST NOT contain unreviewable binary artifacts.
#
set -euo pipefail

# Allowed binary asset types (case-insensitive), see CONTRIBUTING.md#binary-files
ALLOWED_EXTENSIONS_REGEX='\.(png|jpg|jpeg|gif|ico|otf|ttf|woff2?|eot|pdf)$'

echo "Scanning tracked files for disallowed binary artifacts..."

# Build the candidate list: all tracked files whose extension is not on the allow-list.
# We then batch-classify them with a single `file` invocation (instead of one process per
# file) to keep this fast even on large repositories.
candidates_file=$(mktemp)
violations_file=$(mktemp)
trap 'rm -f "$candidates_file" "$violations_file"' EXIT

git ls-files | grep -ivE "$ALLOWED_EXTENSIONS_REGEX" > "$candidates_file" || true

if [ -s "$candidates_file" ]; then
  # `file -f <list>` reads a newline separated list of file names and prints
  # "<name>: <description>" for each, in a single process invocation.
  file -f "$candidates_file" --mime-encoding 2>/dev/null \
    | grep -E ': *binary$' | sed -E 's/: *binary$//' > "$violations_file" || true
fi

if [ -s "$violations_file" ]; then
  echo "ERROR: Found disallowed binary file(s) tracked in version control:"
  sed 's/^/  - /' "$violations_file"
  echo ""
  echo "Only the following binary asset types are allowed: images (.png, .jpg, .jpeg, .gif, .ico),"
  echo "fonts (.otf, .ttf, .woff, .woff2, .eot), and example PDFs (.pdf)."
  echo "Generated executables, archives, jars, class files, keystores, and other compiled"
  echo "output (e.g. .jar, .class, .zip, .sgx, .p12) must be generated at build/test time instead."
  echo "See CONTRIBUTING.md#binary-files for details."
  exit 1
fi

echo "No disallowed binary files found."



