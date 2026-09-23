variable "IMAGE_NAME" {
  default = "finos/fluxnova-bpm-platform"
}

variable "VERSION" {
  default = "dev"
}

group "default" {
  targets = ["corretto21", "corretto21_alpine"]
}

target "_common" {
  context    = "."
  dockerfile  = "Dockerfile"
  platforms   = ["linux/amd64", "linux/arm64"]
  provenance  = true
}

target "corretto21" {
  inherits = ["_common"]
  target   = "corretto21"
  tags     = ["${IMAGE_NAME}:${VERSION}", "${IMAGE_NAME}:latest", "${IMAGE_NAME}:${VERSION}-corretto21", "${IMAGE_NAME}:latest-corretto21"]
}

target "corretto21_alpine" {
  inherits = ["_common"]
  target   = "corretto21_alpine"
  tags     = ["${IMAGE_NAME}:${VERSION}-corretto21-alpine", "${IMAGE_NAME}:latest-corretto21-alpine"]
}
