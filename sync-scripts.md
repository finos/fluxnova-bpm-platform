# Sync helpers

These scripts are provided to help FINOS keep the internal mirrors updated, and for members to keep their internal mirrors updated prior to public release.

They are only needed until the Flowave repo is made public.

## For FINOS repo managers

These scripts prepare a local copies of the public Camunda repos, and push any changes (including tags) into the private FINOS mirrors. Only FINOS repo managers should run these.

### Clone upstream repos

This script should be run once to create local copies of the upstream Camunda repos. It also adds the internal FINOS mirrors as remotes.

You will need to create a [classic Personal Access Token (PAT)](https://github.com/settings/tokens/new) with the `repo` scope and add it to the script. This only needs to be run once.

```bash
PUBLIC_TOKEN=""  # Public GitHub user's personal access token with write access to Flowave repos

git clone https://null:$PUBLIC_TOKEN@github.com/camunda/camunda-bpm-platform flowave-bpm-platform
git -C flowave-bpm-platform remote add finos https://null:$PUBLIC_TOKEN@github.com/finos/flowave-bpm-platform

git clone https://null:$PUBLIC_TOKEN@github.com/camunda/camunda-bpm-release-parent flowave-bmp-release-parent
git -C flowave-bmp-release-parent remote add finos https://null:$PUBLIC_TOKEN@github.com/finos/flowave-bpm-release-parent

git clone https://null:$PUBLIC_TOKEN@github.com/camunda/camunda-release-parent flowave-release-parent
git -C flowave-release-parent remote add finos https://null:$PUBLIC_TOKEN@github.com/finos/flowave-release-parent

git clone https://null:$PUBLIC_TOKEN@github.com/camunda/camunda-docs-manual flowave-docs-manual
git -C flowave-docs-manual remote add finos https://null:$PUBLIC_TOKEN@github.com/finos/flowave-docs-manual

git clone https://null:$PUBLIC_TOKEN@github.com/camunda/camunda-modeler flowave-modeler
git -C flowave-modeler remote add finos https://null:$PUBLIC_TOKEN@github.com/finos/flowave-modeler

git clone https://null:$PUBLIC_TOKEN@github.com/camunda/feel-scala flowave-feel-scala
git -C flowave-feel-scala remote add finos https://null:$PUBLIC_TOKEN@github.com/finos/flowave-feel-scala

```

### Update FINOS mirror

This script updates the FINOS mirrors with the latest from upstream. It should be run from the directory containing the repos cloned above.

This script should be run often.

```bash
for DIR in `find . -maxdepth 1 -mindepth 1 -type d`;
do
        git -C $DIR pull origin --tags
        git -C $DIR push finos --tags
done
```

## For FINOS participants

These scripts ensure that members can get the latest version of the FINOS mirrors and keep in sync.

### Clone FINOS private repos

This script pulls the latest code from the private FINOS Flowave mirrors.

You will need a [classic Personal Access Token (PAT)](https://github.com/settings/tokens/new) with the `repo` scope from your public GitHub account, and the same for your internal organization (GitHub Enterprise or GitLab). You will also need to specify the URL and org of your internal environment where the mirror will be pushed. This only needs to be run once.

```bash
PUBLIC_TOKEN=""  # Public GitHub user's personal access token with read access to Flowave repos
INTERNAL_URL="url/your_org"  # Internal GitHub or GitLab URL and org
INTERNAL_TOKEN=""  # Token for user with write access to internal GitHub or GitLab

git clone https://null:$PUBLIC_TOKEN@github.com/finos/flowave-bpm-platform
git -C flowave-bpm-platform remote add internal https://null:$INTERNAL_TOKEN@$INTERNAL_URL$/flowave-bpm-platform

git clone https://null:$PUBLIC_TOKEN@github.com/finos/flowave-bpm-release-parent
git -C flowave-bmp-release-parent remote add internal https://null:$INTERNAL_TOKEN@$INTERNAL_URL/flowave-bpm-release-parent

git clone https://null:$PUBLIC_TOKEN@github.com/finos/flowave-release-parent
git -C flowave-release-parent remote add internal https://null:$INTERNAL_TOKEN@$INTERNAL_URL/flowave-release-parent

git clone https://null:$PUBLIC_TOKEN@github.com/finos/flowave-docs-manual
git -C flowave-docs-manual remote add internal https://null:$INTERNAL_TOKEN@$INTERNAL_URL/flowave-docs-manual

git clone https://null:$PUBLIC_TOKEN@github.com/finos/flowave-modeler
git -C flowave-modeler remote add internal https://null:$INTERNAL_TOKEN@$INTERNAL_URL/flowave-modeler

git clone https://null:$PUBLIC_TOKEN@github.com/finos/flowave-feel-scala
git -C flowave-feel-scala remote add internal https://null:$INTERNAL_TOKEN@$INTERNAL_URL/flowave-feel-scala
```

### Update private mirrors

This script pushes updates from FINOS to the internal mirror. It should be run from the directory containing the repos cloned above.

This script should be run often.

```bash
for DIR in `find . -maxdepth 1 -mindepth 1 -type d`;
do
        git -C $DIR pull origin --tags
        git -C $DIR push internal --tags
done
```

