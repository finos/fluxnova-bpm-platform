# Release Instructions

This project releases through the GitHub Actions workflow in `.github/workflows/release.yml`.
You do not need to run the Maven release commands manually. Create the correct release branch, push it, and then manually run the release workflow from that branch.
The workflow jobs run only when the selected branch starts with `release/`; other branches are ignored.

## Before You Start

Make sure:

- You have permission to push branches and tags.
- The build is green before releasing.
- The root `pom.xml` version ends with `-SNAPSHOT`.
  - Example: `3.1.0-SNAPSHOT`
- The required GitHub secrets are configured:
  - `CI_DEPLOY_USERNAME`, `CI_DEPLOY_PASSWORD`
  - `CI_GPG_PRIVATE_KEY`, `CI_GPG_PASSPHRASE`
  - `GH_TOKEN`
  - `DOCKER_PASSWORD`

Check the current project version:

```bash
./mvnw help:evaluate -Dexpression=project.version -q -DforceStdout
```

The release version is the current Maven version without `-SNAPSHOT`.
The release branch type controls the next development version only.

Example:

```text
Current version: 3.1.0-SNAPSHOT
Release version: 3.1.0
Release tag:     v3.1.0
```

## How to Release

Start from the latest release-ready branch, usually `main`:

```bash
git checkout main
git pull origin main
```

Then create one of the supported release branches below and push it.

## Major Release Example

Use this when releasing breaking changes or a new major version line.

If the current version is `2.0.0-SNAPSHOT`:

- The workflow releases `2.0.0`.
- The workflow prepares the next development version as `3.0.0-SNAPSHOT`.

Create and push the branch:

```bash
git checkout -b release/major
git push origin release/major
```

## Minor Release Example

Use this when releasing normal new features.

If the current version is `2.0.0-SNAPSHOT`:

- The workflow releases `2.0.0`.
- The workflow prepares the next development version as `2.1.0-SNAPSHOT`.

Create and push the branch:

```bash
git checkout -b release/minor
git push origin release/minor
```

After a major or minor release, create a PR from the release branch back to `main` so the next development version update is preserved.

## Patch Release Example

Use this when releasing a bug fix for the current minor version.

If `1.0.0` is already released and you need to publish `1.0.1`:

- Check out the released tag `v1.0.0` locally.
- Set the project version to `1.0.1-SNAPSHOT`, example below for reference.
- Commit the patch fix and version change, then push the branch as `release/patch/1.0.1`.
- Run the release workflow from `release/patch/1.0.1`.
- Verify the workflow creates the release tag `v1.0.1`; the next development version on the patch branch can be ignored.

Example:

```bash
git checkout -b release/patch/1.0.1 v1.0.0
./mvnw versions:set -DnewVersion=1.0.1-SNAPSHOT -DgenerateBackupPoms=false
git add .
git commit -m "Prepare patch release 1.0.1"
git push origin release/patch/1.0.1
```

After a patch release, merge or cherry-pick the patch changes back into `main` or the current development branch so the fix is not lost in future releases.

After pushing the release branch:

1. Go to **GitHub Actions**.
2. Select **Release and publish artifacts to Maven Central and creates docker image in Docker Hub**.
3. Click **Run workflow**.
4. In the branch dropdown, select the release branch you pushed, for example `release/major`, `release/minor`, or `release/patch/1.0.1`. If you select a branch that does not start with `release/`, the release jobs will be skipped.
5. Click **Run workflow** to start the release.

## What the Workflow Publishes

After the workflow is manually run, `.github/workflows/release.yml` will:

- Build and publish Maven artifacts to Maven Central.
- Create the Git tag, for example `v<release-version>`.
- Build the distro ZIP needed for Docker.
- Build and publish the Docker Hub image:
  - `finos/fluxnova-bpm-platform:<release-version>`
  - `finos/fluxnova-bpm-platform:latest`
- Publish Javadocs to GitHub Pages under `javadocs/<major>.<minor>`.
- Publish OpenAPI docs to GitHub Pages under `openapi/<major>.<minor>`.
- Notify `finos/fluxnova-examples` about the new release version.

## After the Release

Verify:

- The GitHub Actions workflow completed successfully.
- Log in to [Sonatype Central](https://my.sonatype.com/) after the workflow finishes. Obtain the username and password from a FINOS admin.
  - Verify that all published artifacts are present and appear correct.
  - Click the **Publish** button in Sonatype to release the artifacts to Maven Central.
  - After publishing, go to [Maven Central Search](https://central.sonatype.com/search) and verify the artifacts show up correctly. This can take anywhere from a few minutes to a couple of hours.
- The Maven artifacts are available in Maven Central.
- The Git tag exists, for example `v<release-version>`.
- The Docker Hub image exists with the release version and `latest` tags.
- Javadocs and OpenAPI docs were published.
- For major and minor releases, the root `pom.xml` was moved to the expected next `-SNAPSHOT` version and the release branch was merged back to `main`.

## Notes

- Use `release/major`, `release/minor`, `release/patch`, or their `release/<type>/*` variants as shown above.
- The workflow runs only from branches that start with `release/`, and the version bump logic supports only `major`, `minor`, or `patch` release types.
- For exact workflow steps, see `.github/workflows/release.yml`.
