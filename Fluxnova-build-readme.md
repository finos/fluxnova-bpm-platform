# Fluxnova BPM Platform Build Guide

This guide contains the following main sections:

1. **Building Locally:**  
   Step-by-step instructions to build `fluxnova-bpm-platform` on your local machine.

2. **Building with GitHub Actions on FINOS:**  
   Details on how the project is built, tested, and deployed automatically using GitHub Actions, including workflow triggers and package management.

3. **Running Fluxnova BPM Platform:**  
   Instructions for running Fluxnova in Tomcat and Spring Boot modes after building.

## Contents

- [Building Fluxnova BPM Platform Locally](#building-fluxnova-bpm-platform-locally)
- [Building with GitHub Actions on FINOS](#building-with-github-actions-on-finos)
- [Running Fluxnova BPM Platform](#running-fluxnova-bpm-platform)
    - [Running the Tomcat Version](#running-the-tomcat-version)
    - [Running the Spring Boot Version](#running-the-spring-boot-version)
    - [Running with Docker](#running-with-docker)

Please follow the relevant section based on your build environment.

## Building Fluxnova BPM Platform Locally

### Build Prerequisites

- Java 21+
- Maven 3.8+
- Git

### Build Steps

All Fluxnova dependencies are now public and published to Maven Central.

1. **Clone and Build `fluxnova-bpm-platform` Repository**

   ```bash
   git clone https://github.com/finos/fluxnova-bpm-platform
   cd fluxnova-bpm-platform
   mvn clean install
   ```

   - To skip tests:
     ```bash
     mvn clean install -DskipTests -DskipITs
     ```
   - To run all tests:
     ```bash
     mvn clean install
     ```

### Notes

- All dependencies are resolved from Maven Central.
- Artifacts from each build will be stored in your local Maven repository and used by subsequent builds.

-----------------------------------------------------------------------------------------------------------------------

## Building with GitHub Actions on FINOS

The `fluxnova-bpm-platform` project uses GitHub Actions for automated CI/CD on FINOS. This workflow builds, tests, and deploys the project.

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
  Lists the Maven repositories (including GitHub Packages for all Fluxnova dependencies) from which dependencies are resolved during the build.

Example configuration in the root `pom.xml`:

```xml
<repositories>
  <repository>
    <id>fluxnova-bpm-platform</id>
    <url>https://maven.pkg.github.com/finos/fluxnova-bpm-platform</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
  <repository>
    <id>fluxnova-feel-scala</id>
    <url>https://maven.pkg.github.com/finos/fluxnova-feel-scala</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
  <repository>
    <id>fluxnova-bpm-release-parent</id>
    <url>https://maven.pkg.github.com/finos/fluxnova-bpm-release-parent</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
  <repository>
    <id>fluxnova-release-parent</id>
    <url>https://maven.pkg.github.com/finos/fluxnova-release-parent</url>
    <snapshots>
      <enabled>true</enabled>
    </snapshots>
  </repository>
</repositories>

<distributionManagement>
<repository>
   <id>fluxnova-bpm-platform</id>
   <name>GitHub Fluxnova Maven Packages</name>
   <url>https://maven.pkg.github.com/finos/fluxnova-bpm-platform</url>
</repository>
<snapshotRepository>
   <id>fluxnova-bpm-platform</id>
   <name>GitHub Fluxnova Maven Packages</name>
   <url>https://maven.pkg.github.com/finos/fluxnova-bpm-platform</url>
</snapshotRepository>
</distributionManagement>
```

This setup ensures that all builds and deployments use GitHub Packages for both publishing and resolving dependencies. The workflow uses the `GH_TOKEN` for authentication.

### Dependency Management

When building on GitHub Actions, you do **not** need to build dependent projects locally. All dependencies are already
built and published to GitHub Packages from their respective repositories. The workflow uses the `GH_TOKEN` (a GitHub Personal Access Token)
to access these packages securely.

### Viewing Packages

- Go to the [Packages](https://github.com/orgs/finos/packages?q=org.fluxnova&tab=packages&q=org.finos.fluxnova) section of the repository on GitHub to view published artifacts.
- These packages can be used as dependencies in other projects via GitHub Packages.


## Running Fluxnova BPM Platform

You can run Fluxnova in two modes: **Tomcat** and **Spring Boot**.

### Running the Tomcat Version

1. After a successful build, extract the Tomcat distribution archive:
   ```bash
   unzip distro/tomcat/distro/target/fluxnova-bpm-tomcat-0.0.1-SNAPSHOT.zip
   ```
2. Navigate to the extracted folder:
   ```bash
   cd fluxnova-bpm-tomcat-0.0.1-SNAPSHOT
   ```
3. Start the Fluxnova Tomcat server:
   ```bash
   sh start-fluxnova.sh
   ```
4. Access the Fluxnova Monitoring interface at [http://localhost:8080/fluxnova/app/monitoring/default/#/dashboard](http://localhost:8080/camunda/app/cockpit/default/#/dashboard)

### Running the Spring Boot Version

1. After a successful build, extract the Spring Boot distribution archive:
   ```bash
   unzip distro/run/distro/target/fluxnova-bpm-run-0.0.1-SNAPSHOT.zip
   ```
2. Navigate to the extracted folder:
   ```bash
   cd fluxnova-bpm-run-0.0.1-SNAPSHOT
   ```
3. Start the Spring Boot server:
   ```bash
   sh start.sh
   ```
4. Access the Fluxnova Monitoring interface at [http://localhost:8080/fluxnova/app/monitoring/default/#/dashboard](http://localhost:8080/fluxnova/app/cockpit/default/#/dashboard)

### Running with Docker

You can run the Fluxnova BPM Platform using the official Docker image. By default, the image uses an embedded H2 database. You can customize it to use PostgreSQL or MySQL by providing the required JDBC driver version and database connection details.

#### Pull the Docker Image

```bash
docker pull ghcr.io/finos/fluxnova-bpm-platform:1.1.0
```

#### Run the Container (Default: H2 Database)

```bash
docker run -p 8080:8080 ghcr.io/finos/fluxnova-bpm-platform:1.1.0
```

#### Run with PostgreSQL or MySQL

To use PostgreSQL or MySQL, pass the driver version as a build argument and provide DB connection variables as environment variables:

```bash
docker run -p 8080:8080 \
  -e DB_DRIVER_CLASS_NAME=org.postgresql.Driver \
  -e DB_URL=jdbc:postgresql://<host>:<port>/<db> \
  -e DB_USERNAME=<username> \
  -e DB_PASSWORD=<password> \
  ghcr.io/finos/fluxnova-bpm-platform:1.1.0
```

Replace the values as needed for MySQL. Any other Spring Boot configuration can be passed as environment variables.

#### Notes

- The Docker container runs the Spring Boot version of the application and does **not** include additional dependencies like connectors or script engines.
- If you need a Docker image with these dependencies, use the image from the examples repo:

  ```bash
  docker pull ghcr.io/finos/fluxnova-examples:1.0.0-snapshot
  ```
