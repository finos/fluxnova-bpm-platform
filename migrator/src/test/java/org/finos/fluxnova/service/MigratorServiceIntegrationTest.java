package org.finos.fluxnova.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.finos.fluxnova.util.Utils.deleteDirectoryRecursively;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MigratorServiceIntegrationTest {

    static String tempDir = System.getProperty("java.io.tmpdir");

    private MigratorService migratorService;
    private String projectLocation;
    private String targetVersion = "0.0.1-SNAPSHOT";
    private String modelerVersion = "0.0.1";

    @BeforeAll
    static void clear() throws IOException {
        deleteDirectoryRecursively(Paths.get(tempDir + File.separator + "test-project"));
        deleteDirectoryRecursively(Paths.get(tempDir + File.separator + "test-project-without-pom"));
    }

    void setUp(String folderName) throws IOException {
        projectLocation = tempDir + File.separator + folderName;
        Files.createDirectories(Path.of(projectLocation));
        projectLocation = tempDir + File.separator + folderName + File.separator;
        migratorService = new MigratorService(projectLocation, targetVersion, modelerVersion);
    }

    @Test
    @Order(1)
    void testStartMethodReplacesCamundaWithFluxnova() throws IOException, XmlPullParserException, MavenInvocationException {
        setUp("test-project");
        // Create a mock project structure
        createMockProjectStructure();

        // Run the migration
        migratorService.start();

        // Verify the results
        verifyMigrationResults();

    }

    @Test
    @Order(2)
    void testStartMethodWithoutExistingPom() throws IOException, XmlPullParserException, MavenInvocationException {
        setUp("test-project-without-pom");
        // Create a mock project structure WITHOUT pom.xml
        createMockProjectStructureWithoutPom();

        // Run the migration
        migratorService.start();

        // Verify the results for no-pom scenario
        verifyMigrationResultsWithoutOriginalPom();
    }

    private void createMockProjectStructure() throws IOException {
        // Create pom.xml
        String pomContent = """
            <?xml version="1.0" encoding="UTF-8"?>
            <project xmlns="http://maven.apache.org/POM/4.0.0"
                     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                     xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
                <modelVersion>4.0.0</modelVersion>
                <groupId>org.example</groupId>
                <artifactId>test-project</artifactId>
                <version>1.0-SNAPSHOT</version>
                <properties>
                    <camunda.version>7.23.0</camunda.version>
                </properties>
                <dependencies>
                    <dependency>
                        <groupId>org.camunda.bpm</groupId>
                        <artifactId>camunda-engine</artifactId>
                        <version>7.15.0</version>
                    </dependency>
                </dependencies>
            </project>
            """;
        Files.writeString(Path.of(projectLocation + "pom.xml"), pomContent);

        // Create src/main/java directory structure
        Path srcMainJava = Path.of(projectLocation + "src/main/java/org/workflow/example");
        Files.createDirectories(srcMainJava);

        // Create a Java file with Camunda imports
        String javaContent = """
            package org.workflow.example;

            import org.camunda.bpm.engine.ProcessEngine;
            import org.camunda.bpm.engine.RuntimeService;
            import org.camunda.bpm.model.bpmn.builder.CamundaErrorEventDefinitionBuilder;

            public class CamundaService {
                private final ProcessEngine processEngine;

                public CamundaService(ProcessEngine processEngine) {
                    this.processEngine = processEngine;
                }

                public void startProcess(String processKey) {
                    RuntimeService runtimeService = processEngine.getRuntimeService();
                    runtimeService.startProcessInstanceByKey(processKey);
                }
            }
            """;
        Files.writeString(srcMainJava.resolve("CamundaService.java"), javaContent);

        // Create a BPMN file
        Path resourcesDir = Path.of(projectLocation + "src/main/resources");
        Files.createDirectories(resourcesDir);
        String bpmnContent = """
                <?xml version="1.0" encoding="UTF-8"?>
                <bpmn:definitions xmlns:bpmn="http://www.omg.org/spec/BPMN/20100524/MODEL"
                                  xmlns:camunda="http://camunda.org/schema/1.0/bpmn"
                                  targetNamespace="http://camunda.org/examples"
                                  modeler:executionPlatformVersion="7.23.0"
                                  exporter="Camunda Modeler"
                                  exporterVersion="5.0.0"
                                  xmlns:modeler="http://camunda.org/schema/modeler/1.0/">
                  <bpmn:process id="exampleProcess" name="Example Process" isExecutable="true">
                    <bpmn:startEvent id="StartEvent_1" camunda:initiator="starter" />
                    <bpmn:endEvent id="endEvent_1" mycamunda:initiator="end"/>
                    <bpmn:endEvent id="endEvent_1" camundaprocess:initiator="end"/>
                  </bpmn:process>
                </bpmn:definitions>
                """;
        Files.writeString(resourcesDir.resolve("process.bpmn"), bpmnContent);

        // Create a DMN file
        String dmnContent = """
            <?xml version="1.0" encoding="UTF-8"?>
            <definitions xmlns="https://www.omg.org/spec/DMN/20191111/MODEL/"
                        xmlns:dmndi="https://www.omg.org/spec/DMN/20191111/DMNDI/"
                        xmlns:dc="http://www.omg.org/spec/DMN/20180521/DC/"
                        xmlns:di="http://www.omg.org/spec/DMN/20180521/DI/"
                        xmlns:biodi="http://bpmn.io/schema/dmn/biodi/2.0"
                        xmlns:camunda="http://camunda.org/schema/1.0/dmn"
                        id="Definitions_1r0cwkc" name="DRD"
                        namespace="http://camunda.org/schema/1.0/dmn"
                        exporter="Camunda Modeler" exporterVersion="4.5.0">
            <decision id="Decision_1" name="Sample Decision" camunda:historyTimeToLive="180">
                <decisionTable id="DecisionTable_1" hitPolicy="UNIQUE">
                <input id="Input_1" label="Input" camunda:inputVariable="input">
                    <inputExpression id="InputExpression_1" typeRef="string">
                    <text>input</text>
                    </inputExpression>
                </input>
                <output id="Output_1" label="Output" name="output" typeRef="string" />
                </decisionTable>
            </decision>
            </definitions>
            """;
        Files.writeString(resourcesDir.resolve("decision.dmn"), dmnContent);

        // Create a form with execution platform
        String formWithExecutionPlatform = """
                {
                    "components": [],
                    "schema": "10",
                    "executionPlatform": "Camunda Platform",
                    "executionPlatformVersion": "7.23.0",
                    "exporter": {
                        "name": "Camunda Modeler",
                        "version": "5.35.0"
                    }
                }
        """;
        Files.writeString(resourcesDir.resolve("formWithExecutionPlatform.form"), formWithExecutionPlatform);

        // Create a form with no execution platform
        String formWithNoExecutionPlatform = """
                {
                    "components": [],
                    "schema": "10",
                    "exporter": {
                        "name": "Camunda Modeler",
                        "version": "5.35.0"
                    }
                }
        """;
        Files.writeString(resourcesDir.resolve("formWithNoExecutionPlatform.form"), formWithNoExecutionPlatform);

        // Create a non-related json file
        String nonRelatedJsonFile = """
                {
                    "name": "John",
                    "age": "10"
                }
        """;
        Files.writeString(resourcesDir.resolve("nonRelatedJsonFile.json"), nonRelatedJsonFile);
    }

    private void verifyMigrationResults() throws IOException {
        // Verify POM dependencies were updated
        String updatedPom = Files.readString(Path.of(projectLocation + "pom.xml"));
        assertTrue(updatedPom.contains("org.finos.fluxnova.bpm"));
        assertTrue(updatedPom.contains(targetVersion));
        assertFalse(updatedPom.contains("org.camunda.bpm"));
        assertTrue(updatedPom.contains("<fluxnova.version>" + targetVersion + "</fluxnova.version>"));

        // Verify Java package and imports were updated
        Path migratedJavaFile = Path.of(projectLocation + "src/main/java/org/workflow/example/CamundaService.java");

        String javaContent = Files.readString(migratedJavaFile);
        assertTrue(javaContent.contains("package org.workflow.example;"));
        assertTrue(javaContent.contains("import org.finos.fluxnova.bpm.engine.ProcessEngine;"));
        assertTrue(javaContent.contains("import org.finos.fluxnova.bpm.engine.RuntimeService;"));
        assertTrue(javaContent.contains("import org.finos.fluxnova.bpm.model.bpmn.builder.FluxnovaErrorEventDefinitionBuilder;"));
        assertFalse(javaContent.contains("org.camunda"));

        // Verify BPMN file was converted back from XML
        Path bpmnFile = Path.of(projectLocation + "src/main/resources/process.bpmn");
        assertTrue(Files.exists(bpmnFile), "BPMN file should exist");

        String bpmnContent = Files.readString(bpmnFile);
        System.out.println("bpmnContent = " + bpmnContent);
        assertTrue(bpmnContent.contains("xmlns:fluxnova=\"http://fluxnova.finos.org/schema/1.0/bpmn\""));
        assertTrue(bpmnContent.contains("modeler:executionPlatformVersion=\"" + targetVersion + "\""));
        assertTrue(bpmnContent.contains("exporter=\"Fluxnova Modeler\""));
        assertTrue(bpmnContent.contains("xmlns:modeler=\"http://fluxnova.finos.org/schema/modeler/1.0/\""));
        assertTrue(bpmnContent.contains("exporterVersion=\""+ modelerVersion + "\""));

        assertTrue(bpmnContent.contains("mycamunda:initiator=\"end\""));
        assertTrue(bpmnContent.contains("camundaprocess:initiator=\"end\""));

        // Verify rewrite.yml was deleted
        assertFalse(Files.exists(Path.of(projectLocation + "rewrite.yml")), "rewrite.yml should be deleted");

        // Verify DMN file was converted back from XML and transformed
        Path dmnFile = Path.of(projectLocation + "src/main/resources/decision.dmn");
        assertTrue(Files.exists(dmnFile), "DMN file should exist");

        String dmnContent = Files.readString(dmnFile);
        System.out.println("dmnContent = " + dmnContent);
        // Verify DMN namespace transformations based on OpenRewrite recipes
        assertTrue(dmnContent.contains("xmlns:fluxnova=\"http://fluxnova.finos.org/schema/1.0/dmn\""),
            "DMN should contain fluxnova namespace for DMN");
        assertTrue(dmnContent.contains("namespace=\"http://fluxnova.finos.org/schema/1.0/dmn\""),
            "DMN should contain updated namespace attribute");
        assertTrue(dmnContent.contains("exporter=\"Fluxnova Modeler\""),
            "DMN should contain Fluxnova Modeler as exporter");
        assertTrue(dmnContent.contains("exporterVersion=\""+ modelerVersion +"\""),
            "DMN should contain updated exporter version");

        // Verify old Camunda references are removed from DMN
        assertFalse(dmnContent.contains("namespace=\"http://camunda.org/schema/1.0/dmn\""),
            "DMN should not contain old Camunda namespace");
        assertFalse(dmnContent.contains("exporter=\"Camunda Modeler\""),
            "DMN should not contain Camunda Modeler as exporter");
        assertFalse(dmnContent.contains("exporterVersion=\"4.5.0\""),
            "DMN should not contain old Camunda exporter version");

        ObjectMapper objectMapper = new ObjectMapper();

        // Verify form with no execution platform was converted back and transformed
        Path formWithNoExecutionPlatform = Path.of(projectLocation + "src/main/resources/formWithNoExecutionPlatform.form");
        assertTrue(Files.exists(formWithNoExecutionPlatform), "Form file <formWithNoExecutionPlatform.form> should exist");

        JsonNode formWithNoExecutionPlatformJson = getJsonObject(formWithNoExecutionPlatform, objectMapper);

        assertTrue(formWithNoExecutionPlatformJson.has("executionPlatform"));
        assertTrue(formWithNoExecutionPlatformJson.has("executionPlatformVersion"));
        assertEquals("Fluxnova Platform", formWithNoExecutionPlatformJson.get("executionPlatform").asText());
        assertEquals(targetVersion, formWithNoExecutionPlatformJson.get("executionPlatformVersion").asText());
        assertExporterValues(formWithNoExecutionPlatformJson);

        // Verify form with execution platform was converted back and transformed
        Path formWithExecutionPlatform = Path.of(projectLocation + "src/main/resources/formWithExecutionPlatform.form");
        assertTrue(Files.exists(formWithExecutionPlatform), "Form file <formWithExecutionPlatform.form> should exist");

        JsonNode formWithExecutionPlatformJson = getJsonObject(formWithExecutionPlatform, objectMapper);

        assertEquals("Fluxnova Platform", formWithExecutionPlatformJson.get("executionPlatform").asText());
        assertEquals(targetVersion, formWithExecutionPlatformJson.get("executionPlatformVersion").asText());
        assertExporterValues(formWithExecutionPlatformJson);

        // Verify non-form JSON did not get updated
        Path nonFormJson = Path.of(projectLocation + "src/main/resources/nonRelatedJsonFile.json");
        assertTrue(Files.exists(nonFormJson), "File <nonFormJson.json> should exist");

        JsonNode nonFormJsonObject = getJsonObject(nonFormJson, objectMapper);

        assertFalse(nonFormJsonObject.has("executionPlatform"));
        assertFalse(nonFormJsonObject.has("executionPlatformVersion"));

        // Verify rewrite.yml was deleted
        assertFalse(Files.exists(Path.of(projectLocation + "rewrite.yml")), "rewrite.yml should be deleted");

    }

    private void createMockProjectStructureWithoutPom() throws IOException {
        // Create test directory structure but skip pom.xml creation
        Path projectPath = Paths.get(projectLocation);
        Files.createDirectories(projectPath);

        // Create sample XML files that need migration
        Path xmlFile = projectPath.resolve("process-application.xml");
        String camundaXmlContent = """
                <?xml version="1.0" encoding="UTF-8"?>
                <process-application xmlns="http://camunda.org/schema/1.0/ProcessApplication"
                                     xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
                    <process-archive name="invoice-process">
                        <process-engine>default</process-engine>
                        <properties>
                            <property name="isDeleteUponUndeploy">false</property>
                        </properties>
                    </process-archive>
                </process-application>
                """;
        Files.writeString(xmlFile, camundaXmlContent);

        // Create additional test files if needed
        Path bpmnFile = projectPath.resolve("sample-process.bpmn");
        String bpmnContent = """
                <?xml version="1.0" encoding="UTF-8"?>
                <definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL"
                             xmlns:camunda="http://camunda.org/schema/1.0/bpmn">
                    <process id="sample-process" isExecutable="true">
                        <startEvent id="start"/>
                    </process>
                </definitions>
                """;
        Files.writeString(bpmnFile, bpmnContent);

        // Ensure no pom.xml exists
        Path pomPath = projectPath.resolve("pom.xml");
        assertFalse(Files.exists(pomPath));
    }

    private void verifyMigrationResultsWithoutOriginalPom() throws IOException {
        Path projectPath = Paths.get(projectLocation);

        // Verify XML files were migrated (check for Fluxnova namespace)
        Path xmlFile = projectPath.resolve("process-application.xml");
        assertTrue(Files.exists(xmlFile), "XML file should exist after migration");

        String migratedContent = Files.readString(xmlFile);
        assertTrue(migratedContent.contains("http://www.fluxnova.finos.org/schema/1.0/ProcessApplication"),
                "Migrated content should contain Fluxnova namespace");
        assertFalse(migratedContent.contains("http://camunda.org/schema/1.0/ProcessApplication"),
                "Migrated content should not contain Camunda namespace");


        // Verify BPMN files were processed
        Path bpmnFile = projectPath.resolve("sample-process.bpmn");
        if (Files.exists(bpmnFile)) {
            String bpmnContent = Files.readString(bpmnFile);
            // Add assertions for BPMN transformations if applicable
        }

        // Verify rewrite.yml was cleaned up
        Path rewriteYmlPath = projectPath.resolve("rewrite.yml");
        assertFalse(Files.exists(rewriteYmlPath), "rewrite.yml should be cleaned up");
    }

    private JsonNode getJsonObject(Path file, ObjectMapper objectMapper) throws IOException {
        String fileContent = Files.readString(file);
        return objectMapper.readTree(fileContent);
    }

    private void assertExporterValues(JsonNode node) {
        assertTrue(node.has("exporter"));
        JsonNode exporter = node.get("exporter");
        assertEquals("Fluxnova Modeler", exporter.get("name").asText());
        assertEquals(modelerVersion, exporter.get("version").asText());
    }

}
