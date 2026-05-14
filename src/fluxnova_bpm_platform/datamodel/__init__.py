from pathlib import Path
from .fluxnova_bpm_platform import *

THIS_PATH = Path(__file__).parent

SCHEMA_DIRECTORY = THIS_PATH.parent / "schema"
MAIN_SCHEMA_PATH = SCHEMA_DIRECTORY / "fluxnova_bpm_platform.yaml"
