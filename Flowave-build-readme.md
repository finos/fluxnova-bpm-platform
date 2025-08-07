# Flowave BPM Platform Build Guide

This guide contains the following main sections:

1. **Building Locally:**  
   Step-by-step instructions to build `flowave-bpm-platform` and its dependencies on your local machine.

2. **Building with GitHub Actions on FINOS:**  
   Details on how the project is built, tested, and deployed automatically using GitHub Actions, including workflow triggers and package management.

3. **Running Flowave BPM Platform:**  
   Instructions for running Flowave in Tomcat and Spring Boot modes after building.

## Contents

- [Building Flowave BPM Platform Locally](#building-flowave-bpm-platform-locally)
- [Building with GitHub Actions on FINOS](#building-with-github-actions-on-finos)
- [Running Flowave BPM Platform](#running-flowave-bpm-platform)
    - [Running the Tomcat Version](#running-the-tomcat-version)
    - [Running the Spring Boot Version](#running-the-spring-boot-version)

Please follow the relevant section based on your build environment.

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
   # To skip tests:
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

- Go to the [Packages](https://github.com/orgs/finos/packages?q=org.flowave&tab=packages&q=org.finos.flowave) section of the repository on GitHub to view published artifacts.
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
   sh start-camunda.sh
   ```
4. Access the Flowave Cockpit at [http://localhost:8080/camunda/app/cockpit/default/#/dashboard](http://localhost:8080/camunda/app/cockpit/default/#/dashboard)

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
4. Access the Flowave Cockpit at [http://localhost:8080/camunda/app/cockpit/default/#/dashboard](http://localhost:8080/camunda/app/cockpit/default/#/dashboard)