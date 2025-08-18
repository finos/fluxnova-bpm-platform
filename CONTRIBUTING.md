# Flowave Contribution Policy

This document describes the contribution process and requirements of the FINOS Flowave project.  

Please also see our [Governance guidelines](https://github.com/finos/flowave-bpm-platform/blob/main/CONTRIBUTING.md), and FINOS [Code of Conduct](https://community.finos.org/docs/governance/code-of-conduct) & [Collaborative Principles](https://community.finos.org/docs/governance/collaborative-principles/).

# How to contribute

* [Ways to contribute](#ways-to-contribute)
* [Browse our issues](#browse-our-issues)
* [Build from source](#build-from-source)
* [Create a pull request](#create-a-pull-request)
* [Contribution checklist](#contribution-checklist)
* [Contributor License Agreement (CLA)](#contributor-license-agreement-cla)
* [Commit message conventions](#commit-message-conventions)
* [License headers](#license-headers)
* [Review process](#review-process)

# Ways to contribute

We’re excited you’re here and want to contribute to Flowave! This guide outlines how you can contribute effectively and collaboratively.

## Contribute your knowledge

Help others by participating in discussions on [GitHub](https://github.com/finos/flowave-bpm-platform/discussions) or by joining our mailing list [flowave@lists.finos.org](mailto:flowave@lists.finos.org) (email [help@finos.org](mailto:help@finos.org) to add you to the list).

## File bugs or feature requests

Found a bug in the code or have a feature that you would like to see in the future? [Search our open issues](https://github.com/finos/flowave-bpm-platform/issues) if we have it on the radar already or [create a new issue otherwise](https://github.com/finos/flowave-bpm-platform/issues/new/choose).

Please try to create high quality issues:

Try to apply our best practices for creating issues:

* Create a high-quality issue:
  * Give enough context so that a person who doesn't know your project can understand your request
  * Be concise, only add what's needed to understand the core of the request
  * If you raise a bug report, describe the steps to reproduce the problem
  * Specify your environment (e.g. Flowave version, Flowave modules you use, ...)
  * Provide code. For a bug report, create a test that reproduces the problem. For feature requests, create mockup code that shows how the feature might look like. Fork our [unit test Github template](https://github.com/camunda/camunda-engine-unittest) to get started quickly.** Needs To Be Reviewed **

## Contribute code

You can contribute code that fixes bugs and/or implements features. Here is how it works:


1. Select an issue that you would like to work on. Have a look at [our Project Board](https://github.com/orgs/finos/projects/116) or the issues lists for the individual projects, e.g.  [Flowave-BPM-Platform Issues](https://github.com/finos/flowave-bpm-platform/issues) if you need inspiration. Be aware that some of the issues need good knowledge of the surrounding code.
1. [Create a fork of the project](https://github.com/finos/flowave-bpm-platform/fork) to contribute from. Create a feature branch in your fork to hold your changes.
1. Check your code changes against our [contribution checklist](#contribution-checklist)
    1. For large changes, open a draft PR before you have finished your implementation to get feedback.
1. [Create a pull request](https://github.com/finos/flowave-bpm-platform/pulls). 

# Browse our issues

We manage issues for the multiple Flowave projects through [our Project Board](https://github.com/orgs/finos/projects/116).
You can find the full list of FINOS hosted Flowave projects [here](https://github.com/finos/?q=flowave&type=all&language=&sort=).

We use [labels](https://github.com/finos/flowave-bpm-platform/labels) to mark and group our issues for easier browsing. We define the following label prefixes:  ** labels arent in Flowave. Needs To Be Reviewed **

* `bot:` labels that control a github app, workflow, ...
* `ci:` labels that control the CI for a pull request
* `group:` Arbitrary labels that we can define to group tickets. If you create this, please add a DRI to the description to make sure someone has ownership, e.g. to decide if we still need the label
* `potential:` Issues that we are potentially releasing with the given version. This is not a guarantee and does not express high confidence.
* `hacktoberfest-` labels for hacktoberfest contributions. This prefix cannot be changed. It is a rule of Hacktoberfest to name it like that.
* `scope:` The technical scope in which the ticket makes changes.
* `type:` Issue type. Every issue should have exactly one of these labels. They are automatically added when you create a new issue from a template.
* `version:` Issues that will be released (with high confidence) with the given version.

# Build from source

## Building Flowave BPM Platform Locally

### Important Note

Currently, not all Flowave packages on FINOS are public. To build `flowave-bpm-platform`, you must first clone and build
all dependent repositories locally. Once all packages are public, you will be able to build `flowave-bpm-platform` directly
without building dependencies locally.

### Build Prerequisites

- Java 17+
- Maven 3.8+
- Git

### Build Order and Steps

1. **Clone and Build `flowave-release-parent` Repository**

   This repository contains the parent POM used by other Flowave projects.

   ```bash
   git clone https://github.com/finos/flowave-release-parent
   cd flowave-release-parent
   mvn clean install -o
   ```

2. **Clone and Build `flowave-bpm-release-parent` Repository**

   This repository is the next-level parent POM, used by downstream projects.

   ```bash
   git clone https://github.com/finos/flowave-bpm-release-parent
   cd flowave-bpm-release-parent
   mvn clean install -o
   ```

3. **Clone and Build `flowave-feel-scala` Repository**

   This repository is a dependency for `flowave-bpm-platform`.

   ```bash
   git clone https://github.com/finos/flowave-feel-scala
   cd flowave-feel-scala
   # To skip tests (recommended for adopters only, contributors should always run tests):
   mvn clean install -DskipTests -DskipITs -o

   # To run all tests:
   mvn clean install -o
   ```

4. **Clone and Build `flowave-bpm-platform` Repository**

   Finally, build the main project. You can skip tests or run them as needed.

   ```bash
   git clone https://github.com/finos/flowave-bpm-platform
   cd flowave-bpm-platform
   # To skip tests:
   mvn clean install -DskipTests -DskipITs -o

   # To run all tests:
   mvn clean install -o
   ```

### Notes

- The `-o` flag enables Maven offline mode, so it uses dependencies from your local `.m2/repository/org/flowave` directory.
- Artifacts from each build will be stored in your local Maven repository and used by subsequent builds.
- Once all Flowave dependencies are public, you can build `flowave-bpm-platform` directly without building the other repositories locally.

-----------------------------------------------------------------------------------------------------------------------

## Building with GitHub Actions on FINOS

The `flowave-bpm-platform` project uses GitHub Actions for automated CI/CD on FINOS. This workflow builds, tests, and deploys the project.

### Workflow Triggers

- **Automatic Triggers:**  
  The workflow runs automatically on every push to the `main` branch and on every pull request.
- **Manual Trigger:**  
  You can manually trigger the workflow from the GitHub Actions tab using the "Run workflow" button.  
  When using this manual trigger (`workflow_dispatch`), you can select which branch to build.

### Steps in the Workflow

1. **Checkout Repository:**  
   Checks out the latest code from the selected branch.
2. **Java Setup:**  
   Sets up the required Java version.
3. **Git Configuration:**  
   Configures Git for the workflow environment.
4. **Set Project Version:**  
   Sets the Maven project version.
5. **Download Dependencies:**  
   Resolves and downloads all Maven dependencies and plugins.
6. **Build and Deploy:**  
   Builds the project and deploys artifacts to GitHub Packages.
7. **Run Tests:**  
   Runs unit and integration tests in separate jobs.

### Deployment to GitHub Packages

The deployment of artifacts to GitHub Packages is configured in the root `pom.xml` using the `<distributionManagement>` and `<repositories>` tags.

- **`<distributionManagement>`**:  
  Specifies where Maven should deploy release and snapshot artifacts. For this project, both releases and snapshots are deployed to GitHub Packages.

- **`<repositories>`**:  
  Lists the Maven repositories (including GitHub Packages for all Flowave dependencies) from which dependencies are resolved during the build.

Example configuration in the root `pom.xml`:

```xml
<repositories>
  <repository>
    <id>flowave-bpm-platform</id>
    <url>https://maven.pkg.github.com/finos/flowave-bpm-platform</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
  <repository>
    <id>flowave-feel-scala</id>
    <url>https://maven.pkg.github.com/finos/flowave-feel-scala</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
  <repository>
    <id>flowave-bpm-release-parent</id>
    <url>https://maven.pkg.github.com/finos/flowave-bpm-release-parent</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
  <repository>
    <id>flowave-release-parent</id>
    <url>https://maven.pkg.github.com/finos/flowave-release-parent</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>

<distributionManagement>
<repository>
   <id>flowave-bpm-platform</id>
   <name>GitHub Flowave Maven Packages</name>
   <url>https://maven.pkg.github.com/finos/flowave-bpm-platform</url>
</repository>
<snapshotRepository>
   <id>flowave-bpm-platform</id>
   <name>GitHub Flowave Maven Packages</name>
   <url>https://maven.pkg.github.com/finos/flowave-bpm-platform</url>
</snapshotRepository>
</distributionManagement>
```

This setup ensures that all builds and deployments use GitHub Packages for both publishing and resolving dependencies. The workflow uses the `GH_TOKEN` for authentication.

### Dependency Management

When building on GitHub Actions, you do **not** need to build dependent projects locally. All dependencies are already
built and published to GitHub Packages from their respective repositories. The workflow uses the `GH_TOKEN` (a GitHub Personal Access Token)
to access these packages securely.

### Viewing Packages

- Go to the [Packages](https://github.com/orgs/finos/packages?tab=packages&q=org.flowave) section of the repository on GitHub to view published artifacts.
- These packages can be used as dependencies in other projects via GitHub Packages.


## Running Flowave BPM Platform

You can run Flowave in two modes: **Tomcat** and **Spring Boot**.

### Running the Tomcat Version

1. After a successful build, extract the Tomcat distribution archive:
   ```bash
   unzip distro/tomcat/distro/target/flowave-bpm-tomcat-0.0.1-SNAPSHOT.zip
   ```
2. Navigate to the extracted folder:
   ```bash
   cd flowave-bpm-tomcat-0.0.1-SNAPSHOT
   ```
3. Start the Flowave Tomcat server:
   ```bash
   sh start-flowave.sh
   ```
4. Access the Flowave Cockpit at [http://localhost:8080/flowave/app/cockpit/default/#/dashboard](http://localhost:8080/flowave/app/cockpit/default/#/dashboard)

### Running the Spring Boot Version

1. After a successful build, extract the Spring Boot distribution archive:
   ```bash
   unzip distro/run/distro/target/flowave-bpm-run-0.0.1-SNAPSHOT.zip
   ```
2. Navigate to the extracted folder:
   ```bash
   cd flowave-bpm-run-0.0.1-SNAPSHOT
   ```
3. Start the Spring Boot server:
   ```bash
   sh start.sh
   ```
4. Access the Flowave Cockpit at [http://localhost:8080/flowave/app/cockpit/default/#/dashboard](http://localhost:8080/flowave/app/cockpit/default/#/dashboard)

# Create a pull request

In order to show us your code, you can create a pull request on Github. Do this when your contribution is ready for review, or if you have started with your implementation and want some feedback before you continue. It is always easier to help if we can see your work in progress.

A pull request can be submitted as follows: 

1. [Fork the Flowave repository](https://docs.github.com/en/github/getting-started-with-github/fork-a-repo) you are contributing to
1. Commit and push your changes to a branch in your fork
1. [Submit a Pull Request to the Flowave repository](https://docs.github.com/en/github/collaborating-with-issues-and-pull-requests/creating-a-pull-request-from-a-fork). As the *base* branch (the one that you contribute to), select `main`. This should also be the default in the Github UI.

1. In the pull request description, reference the github issue that your pull request addresses.

# Contribution checklist

Before submitting your pull request for code review, please go through the following checklist:
** Wiki Pages are missing. Needs To Be Reviewed **
1. Is your code formatted according to our code style guidelines?
    * Java: Please check our [Java Code Style Guidelines](https://github.com/camunda/camunda-bpm-platform/wiki/Coding-Style-Java). You can also import [our template and settings files](https://github.com/finos/flowave-bpm-platform/tree/master/settings) into your IDE before you start coding.
    * Javascript: Your code is automatically formatted whenever you commit.
1. Is your code covered by unit tests?
    * Ask us if you are not sure where to write the tests or what kind of tests you should write.
    * Java: Please follow our [testing best practices](https://github.com/camunda/camunda-bpm-platform/wiki/Testing-Best-Practices-Java).
    * Have a look at other tests in the same module for how it works.
    * In rare cases, it is not feasible to write an automated test. Please ask us if you think that is the case for your contribution.
1. Do your commits follow our [commit message conventions](#commit-message-conventions)?
1. Does your code use the [correct license headers](#license-headers)?

# Contributor License Agreement (CLA)

All contributors must have a contributor license agreement (CLA) on file with FINOS before their pull requests will be merged. Please review the FINOS [contribution requirements](https://community.finos.org/docs/governance/Software-Projects/contribution-compliance-requirements) and submit (or have your employer submit) the required CLA before submitting a pull request.

# Commit message conventions

The messages of all commits must conform to the style:

```
<type>(<scope>): <subject>

<body>

<footer>
```

Example:

```
feat(engine): Support BPEL

- implements execution for a really old standard
- BPEL models are mapped to internal ActivityBehavior classes

related to #123
```

Have a look at the [commit history](https://github.com/finos/flowave-bpm-platform/commits/master) for real-life examples.


## \<type\>

One of the following:

* feat (feature)
* fix (bug fix)
* docs (documentation)
* style (formatting, missing semi colons, …)
* refactor
* test (when adding missing tests)
* chore (maintain)
 
## \<scope\>

The scope is the module that is changed by the commit. E.g. `engine` in the case of https://github.com/finos/flowave-bpm-platform/commits/master/engine.

## \<subject\>

A brief summary of the change. Use imperative form (e.g. *implement* instead of *implemented*).  The entire subject line shall not exceed 70 characters.

## \<body\>

A list of bullet points giving a high-level overview of the contribution, e.g. which strategy was used for implementing the feature. Use present tense here (e.g. *implements* instead of *implemented*). A line in the body shall not exceed 80 characters. For small changes, the body can be omitted. 

## \<footer\>

Must be `related to <ticket>` where ticket is the ticket number, e.g. CAM-1234. If the change is related to multiple 
tickets, list them in a comma-separated list such as `related to CAM-1234, CAM-4321`.

Optionally, you can reference the number of the GitHub PR from which the commit is merged. The message footer can then 
look like `related to <ticket>, closes #<pr_number>` such as `related to CAM-1234, closes #567`.

# License headers (see issue) [https://github.com/finos/flowave-bpm-platform/issues/141]

Every source file in an open-source repository needs to contain the following license header at  the top, formatted as a code comment: ** License. Needs To Be Reviewed **

```
Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
under one or more contributor license agreements. See the NOTICE file
distributed with this work for additional information regarding copyright
ownership. Camunda licenses this file to you under the Apache License,
Version 2.0; you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

The header can be added manually (check other files). If you use our [IDE settings](https://github.com/finos/flowave-bpm-platform/tree/master/settings), it will be generated automatically when you create new `.java` files. You can also add it by running `mvn clean install -Plicense-header-check` in the module that you have changed. This command also re-formats any incorrectly formatted license header.

Contributions that do not contain valid license headers cannot be merged.

# Review process

We usually check for new community-submitted pull requests once a week. We will then assign a reviewer from our development team and that person will provide feedback as soon as possible. 

Note that due to other responsibilities (our own implementation tasks, releases), feedback can sometimes be a bit delayed. Especially for larger contributions, it can take a bit until we have the time to assess your code properly.

During review we will provide you with feedback and help to get your contribution merge-ready. However, before requesting a review, please go through our [contribution checklist](#contribution-checklist).

Once your code is merged, it will be shipped in the next alpha and minor releases. We usually build alpha releases once a month and minor releases once every six months. If you are curious about the exact next minor release date, check our [release announcements](https://docs.camunda.org/enterprise/announcement/) page. ** Needs To Be Reviewed **

# Changes to this Document

This document MAY be amended by a vote of the Maintainers according to the Maintainer Voting process above.
