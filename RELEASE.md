# RELEASE.md

## Release Instructions

This document describes how to prepare, perform, and publish a new release of Fluxnova BPM Platform to Maven Central and build/push a Docker image tagged with the release version.

---

### Prerequisites
- Repository permissions: ability to push branches and tags.
- Branch state: code is green (build/tests pass) and on a `*-SNAPSHOT` version in `pom.xml`.
- Secrets in GitHub repository settings:
  - `CI_DEPLOY_USERNAME`, `CI_DEPLOY_PASSWORD` (Sonatype OSSRH)
  - `CI_GPG_PRIVATE_KEY`, `CI_GPG_PASSPHRASE` (GPG signing)
  - `GH_TOKEN` (for git and GHCR authentication)
- GitHub Actions runners must have Java 21 (handled by workflow).

---

### Release Branching
1. Choose the release version (e.g., `1.15.0`). It will be derived from the current `*-SNAPSHOT` in `pom.xml` by removing `-SNAPSHOT`.
2. Create and push a branch named `release/<version>`:
   - Example: `release/1.15.0`.
3. Pushing to `release/*` or manually dispatching the workflow will trigger the release pipeline.

---

### Triggering the Workflow
- Go to GitHub → Actions → "Release and publish artifacts to Maven Central".
- Either:
  - Click "Run workflow" (manual), or
  - Push to `release/*` (automatic).

---

### What the Workflow Does (high level)
- Computes `RELEASE_VERSION` from the current `project.version` (strips `-SNAPSHOT`).
- Computes `DEVELOPMENT_VERSION` for the next cycle (bumps minor, appends `-SNAPSHOT`).
- Runs `mvn release:prepare` with computed versions and tags.
- Runs `mvn release:perform` to build and deploy artifacts to Sonatype (Maven Central).
- Exposes `release_version` as an output so downstream jobs (Docker) receive the tag.
- Builds the distro ZIP (at `distro/run/distro/target/fluxnova-bpm-run-*.zip`).
- Builds and pushes a Docker image tagged with `RELEASE_VERSION` to GHCR.

---

### Commands (reference)
These are representative of what the workflow runs:

- Extract version and set env/outputs:
  - `mvn help:evaluate -Dexpression=project.version -q -DforceStdout`
  - `RELEASE_VERSION=${currentVersion%-SNAPSHOT}`
  - `DEVELOPMENT_VERSION=<computed next>-SNAPSHOT`

- Prepare release:
```bash
mvn -B \
  -DpreparationGoals=clean \
  release:prepare \
  -DreleaseVersion=${RELEASE_VERSION} \
  -DdevelopmentVersion=${DEVELOPMENT_VERSION} \
  -Dtag=v${RELEASE_VERSION} \
  -Psonatype-oss-release,distro,distro-ce,distro-wildfly \
  -DignoreSnapshots=true \
  -DinteractiveMode=false
```

- Perform release (deploy in steps, avoid bundling too-large archives):
```bash
mvn -B \
  -DinteractiveMode=false \
  -DreleaseProfiles=sonatype-oss-release \
  -Dgoals='deploy org.sonatype.plugins:nexus-staging-maven-plugin:1.6.13:close org.sonatype.plugins:nexus-staging-maven-plugin:1.6.13:release' \
  -Darguments='-Psonatype-oss-release,distro,distro-ce -DreleasePerform=true -DskipTests -DskipITs' \
  release:perform
```

- Build distro ZIP for Docker:
```bash
mvn -B -DskipTests -pl distro/run/distro -am package
```

- Build/push Docker image (via composite action):
  - Images: `ghcr.io/<org>/<repo>`
  - Tag: `${{ inputs.version }}` (e.g., `1.15.0`)

---

### Docker Image Tagging
- The Docker job consumes `needs.publish-central.outputs.release_version` and passes it to the composite action `build-publish-image`.
- docker/metadata-action composes tags and labels; we explicitly include the literal tag equal to the release version.
- Result: image pushed to `ghcr.io/<org>/<repo>:<RELEASE_VERSION>`.

---

### Troubleshooting
- Missing distro ZIP during Docker build
  - Error: `lstat .../distro/run/distro/target: no such file or directory`.
  - Fix: ensure the step `mvn -B -DskipTests -pl distro/run/distro -am package` runs before `docker build`, and the Docker build context includes the repository.

- 413 Payload Too Large (Sonatype central-publishing bundle)
  - Cause: giant bundle (zip) created by central-publishing-maven-plugin exceeds limits.
  - Fixes:
    - Prefer deploying artifact-by-artifact (use `deploy` + `nexus-staging:close` + `nexus-staging:release` goals in `release:perform`).
    - Exclude non-essential distributions/profiles during perform (e.g., avoid `distro-webjar`, `distro-wildfly` if not required).
    - Ensure only one `sources.jar` and one `javadoc.jar` are attached per module; avoid shaded sources duplication.
    - Avoid attaching `classifier=classes` unless strictly necessary.

- Tag push errors (detached HEAD or ref mismatch)
  - Ensure checkout uses the branch ref: `ref: ${{ github.event_name == 'pull_request' && github.head_ref || github.ref_name }}` and `fetch-depth: 0`.

- Docker push error "tag is needed when pushing to registry"
  - Ensure the version input is set and non-empty; add a guard step:
    ```bash
    if [ -z "${{ needs.publish-central.outputs.release_version }}" ]; then echo "empty version"; exit 1; fi
    ```

---

### Post-Release
- Verify artifacts on Maven Central.
- Confirm Git tag (e.g., `v1.15.0`) exists.
- Check GHCR image at `Packages` tab.
- The workflow computes and sets `DEVELOPMENT_VERSION` automatically; if not, bump `pom.xml` manually.

---

### Notes
- See the workflow file: `.github/workflows/release.yml` for exact steps.
- Dockerfile expects `distro/run/distro/target/fluxnova-bpm-run-*.zip`; keep this path or update both Dockerfile and workflow accordingly.
