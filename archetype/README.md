### Fluxnova Archetype

This Maven archetype helps you quickly bootstrap a **Fluxnova project** with:

*   Embedded Fluxnova engine
*   Fluxnova webapps - Tasklist, Monitoring, Admin
*   Basic REST APIs:
    *   Start a process
    *   Assign a user task
    *   Complete a user task
*   Preconfigured dependencies and structure for rapid development

***

### Target Audience
This Archetype is targeted at developers, solutions designers and other who are curious about Fluxnova. The generated archetypes are NOT production ready.

### Features

*   Generates a ready-to-run Fluxnova application.
*   Includes REST endpoints for common operations.
*   Provides a sample BPMN process.
*   Integration with Spring Boot (if applicable).

***

### Prerequisites

*   **Java** 21+
*   **Maven** 3.6+
*   Internet access for downloading dependencies

***

### How to Generate a New Project

Use the Maven `archetype:generate` goal.

Replace:

*  `archetypeVersion` with the Fluxnova version of your choice.
*   `groupId`, `artifactId`, `version` with your new project details.

```
mvn archetype:generate ^
  -DarchetypeGroupId=org.finos.fluxnova ^
  -DarchetypeArtifactId=fluxnova-archetype ^
  -DarchetypeVersion=<FLUXNOVA_BPM_PLATFORM_VERSION> ^
  -DgroupId=<YOUR_PROJECT_GROUP_ID> ^
  -DartifactId=<YOUR_PROJECT_ARTIFACT_ID> ^
  -Dversion=1.0.0-SNAPSHOT ^
  -DinteractiveMode=false
```

***

### Next Steps

1.  Navigate to the generated project folder:
    ```
    cd <YOUR_PROJECT_GROUP_ID>
    ```
2.  Follow the **README inside the generated project** for instructions on running and testing.
