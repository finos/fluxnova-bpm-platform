package org.finos.flowave.service;

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
    private Invoker mockInvoker;

    @BeforeEach
    void setUp() throws IOException {
        projectLocation = tempDir + File.separator + "test-project";
        Files.createDirectories(Path.of(projectLocation));
        projectLocation = tempDir + File.separator + "test-project" + File.separator;
        migratorService = new MigratorService(projectLocation);
    }

    @Test
    void testStartMethodReplacesOrgFlowaveWithOrgFlowave() throws IOException, XmlPullParserException, MavenInvocationException {
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
                                  targetNamespace="http://camunda.org/examples">
                  <bpmn:process id="exampleProcess" name="Example Process" isExecutable="true">
                    <bpmn:startEvent id="StartEvent_1" camunda:initiator="starter" />
                    <bpmn:endEvent id="endEvent_1" mycamunda:initiator="end"/>
                    <bpmn:endEvent id="endEvent_1" camundaprocess:initiator="end"/>
                  </bpmn:process>
                </bpmn:definitions>
                """;
        Files.writeString(resourcesDir.resolve("process.bpmn"), bpmnContent);
    }

    private void verifyMigrationResults() throws IOException, MavenInvocationException {
        // Verify POM dependencies were updated
        String updatedPom = Files.readString(Path.of(projectLocation + "pom.xml"));
        assertTrue(updatedPom.contains("org.finos.flowave.bpm"));
        assertFalse(updatedPom.contains("org.camunda.bpm"));

        // Verify Java package and imports were updated
        Path migratedJavaFile = Path.of(projectLocation + "src/main/java/org/workflow/example/CamundaService.java");

        String javaContent = Files.readString(migratedJavaFile);
        assertTrue(javaContent.contains("package org.workflow.example;"));
        assertTrue(javaContent.contains("import org.finos.flowave.bpm.engine.ProcessEngine;"));
        assertTrue(javaContent.contains("import org.finos.flowave.bpm.engine.RuntimeService;"));
        assertFalse(javaContent.contains("org.camunda"));

        // Verify BPMN file was converted back from XML
        Path bpmnFile = Path.of(projectLocation + "src/main/resources/process.bpmn");
        assertTrue(Files.exists(bpmnFile), "BPMN file should exist");

        String bpmnContent = Files.readString(bpmnFile);
        assertTrue(bpmnContent.contains("flowave:initiator=\"starter\""));
        assertFalse(bpmnContent.contains("camunda:initiator=\"starter\""));

        assertTrue(bpmnContent.contains("mycamunda:initiator=\"end\""));
        assertTrue(bpmnContent.contains("camundaprocess:initiator=\"end\""));

        // Verify rewrite.yml was deleted
        assertFalse(Files.exists(Path.of(projectLocation + "rewrite.yml")), "rewrite.yml should be deleted");

    }

}
