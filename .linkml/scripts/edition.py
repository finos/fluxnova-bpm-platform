"""The Fluxnova edition the schema renders, and FINOS's tree it reads it from.

The converters, the watch and the tests read these values from here, so they name one
edition. Move them together after a merge of FINOS's tree, then rerun the converters,
scripts/pin_finos_tree.py and scripts/pin_sources.py.
"""

# The release the converters' sources match: every file they read is byte for byte
# the file at this tag, which scripts/upstream_pins.tsv records.
EDITION = {
    "label": "Fluxnova BPM Platform 3.1.1",
    "version": "3.1.1",
    "repository": "fluxnova-bpm-platform",
    "tag": "v3.1.1",
    "commit": "3ac64ca2c3d7c93f00395e18b9dc3218e5250264",
}

# FINOS's tree, merged into this repository at this commit of its default branch.
FINOS_REPOSITORY = "fluxnova-bpm-platform"
FINOS_COMMIT = "6a0bf7f412022877109c22c72127138d94effb77"
