package org.finos.fluxnova.service;

import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MigratorServiceIntegrationTest {

    String tempDir = System.getProperty("java.io.tmpdir");

    private MigratorService migratorService;
    private String projectLocation;
    private String targetVersion = "0.0.1-SNAPSHOT";
    private String modelerVersion = "0.0.1";
    private Invoker mockInvoker;

    @BeforeEach
    void setUp() throws IOException {
        projectLocation = tempDir + File.separator + "test-project";
        Files.createDirectories(Path.of(projectLocation));
        projectLocation = tempDir + File.separator + "test-project" + File.separator;
        migratorService = new MigratorService(projectLocation, targetVersion, modelerVersion);
    }

    @Test
    void testStartMethodReplacesOrgFluxnovaWithOrgFluxnova() throws IOException, XmlPullParserException, MavenInvocationException {
        // Create a mock project structure
        createMockProjectStructure();

        // Run the migration
        migratorService.start();

        // Verify the results
        verifyMigrationResults();

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
            <dmn:definitions xmlns="https://www.omg.org/spec/DMN/20191111/MODEL/"
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
            </dmn:definitions>
            """;
        Files.writeString(resourcesDir.resolve("decision.dmn"), dmnContent);
    }

    private void verifyMigrationResults() throws IOException, MavenInvocationException {
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
        assertTrue(javaContent.contains("import org.finos.fluxnova.bpm.model.bpmn.builder.FlowaveErrorEventDefinitionBuilder;"));
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

        // Verify rewrite.yml was deleted
        assertFalse(Files.exists(Path.of(projectLocation + "rewrite.yml")), "rewrite.yml should be deleted");

    }

}
