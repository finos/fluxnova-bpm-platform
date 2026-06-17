package org.finos.fluxnova.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
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
    void testStartMethodReplacesCamundaWithFluxnova() throws IOException, XmlPullParserException, MavenInvocationException, URISyntaxException {
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
    void testStartMethodWithoutExistingPom() throws IOException, XmlPullParserException, MavenInvocationException, URISyntaxException {
        setUp("test-project-without-pom");
        // Create a mock project structure WITHOUT pom.xml
        createMockProjectStructureWithoutPom();

        // Run the migration
        migratorService.start();

        // Verify the results for no-pom scenario
        verifyMigrationResultsWithoutOriginalPom();
    }

    private void createMockProjectStructure() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL templateUrl = classLoader.getResource("test-project-template");

        if (templateUrl == null) {
            throw new IOException("Template directory not found: test-project-template");
        }

        Path templatePath = Paths.get(templateUrl.toURI());
        Path targetPath = Paths.get(projectLocation);

        FileUtils.copyDirectory(templatePath.toFile(), targetPath.toFile());
    }


    private void verifyMigrationResults() throws IOException {
        verifyPomMigration();
        verifyJavaMigration();
        verifyBpmnMigration();
        verifyDmnMigration();
        verifyFormMigration();
        verifySpringXmlMigration();
        verifyOpenApiMigration();
        verifyPropertiesMigration();
        verifyYamlMigration();
        verifyJavaScriptTypeScriptMigration();
        verifyTextFileMigration();
        verifyHtmlEmbeddedFormMigration();
        verifyMetaInfMigration();
        VerifyPythonScriptMigration();
        verifyRewriteYmlDeleted();
    }

    private void verifyPomMigration() throws IOException {
        String updatedPom = Files.readString(Path.of(projectLocation + "pom.xml"));

        // Verify Camunda was migrated to Fluxnova
        assertTrue(updatedPom.contains("org.finos.fluxnova.bpm"), "Should contain Fluxnova groupId");
        assertTrue(updatedPom.contains("<fluxnova.version>" + targetVersion + "</fluxnova.version>"),
                "Should contain fluxnova.version property");
        assertTrue(updatedPom.contains("<version>${fluxnova.version}</version>"),
                "Camunda dependency should use fluxnova.version property");
        assertTrue(updatedPom.contains("<artifactId>fluxnova-engine</artifactId>"),
                "Should contain fluxnova-engine artifact");
        assertFalse(updatedPom.contains("org.camunda.bpm"), "Should not contain Camunda groupId");
        assertFalse(updatedPom.contains("<camunda.version>"), "Should not contain camunda.version property");
        assertFalse(updatedPom.contains("camunda-engine"), "Should not contain camunda-engine artifact");

        // Verify Spring dependencies remain unchanged
        assertTrue(updatedPom.contains("org.springframework"), "Should still contain Spring groupId");
        assertTrue(updatedPom.contains("<spring.version>5.3.20</spring.version>"),
                "Spring version property should remain unchanged");
        assertTrue(updatedPom.contains("<artifactId>spring-core</artifactId>"),
                "Should still contain spring-core artifact");

        // Verify Spring dependency version reference is NOT changed to fluxnova.version
        verifySpringDependencyVersion(updatedPom);
        verifySpringBomVersion(updatedPom);

        // Negative assertion: Spring should NOT be migrated to Fluxnova
        assertFalse(updatedPom.contains("org.finos.fluxnova.springframework"),
                "Spring should NOT be migrated to Fluxnova namespace");

        // Count occurrences - Spring version should appear in property definition and BOM
        int fluxnovaVersionCount = updatedPom.split("\\$\\{fluxnova\\.version\\}", -1).length - 1;
        int springVersionCount = updatedPom.split("\\$\\{spring\\.version\\}", -1).length - 1;

        assertTrue(fluxnovaVersionCount >= 2,
                "Should have at least 2 fluxnova.version references (property + BOM + dependency)");
        assertTrue(springVersionCount >= 1,
                "Should have at least 1 spring.version reference (BOM in dependencyManagement)");

        // Verify the property definition exists
        assertTrue(updatedPom.contains("<spring.version>5.3.20</spring.version>"),
                "Should have spring.version property definition");
    }

    private void verifySpringDependencyVersion(String updatedPom) {
        String[] pomLines = updatedPom.split("\n");
        boolean foundSpringDependency = false;
        boolean springUsesCorrectVersion = false;

        for (int i = 0; i < pomLines.length; i++) {
            if (pomLines[i].contains("<artifactId>spring-core</artifactId>")) {
                foundSpringDependency = true;
                // Check the next few lines for version tag
                for (int j = i; j < Math.min(i + 5, pomLines.length); j++) {
                    // Spring can either have explicit version or inherit from BOM
                    if (pomLines[j].contains("<version>${spring.version}</version>")) {
                        springUsesCorrectVersion = true;
                        break;
                    }
                    // If we find the closing </dependency> tag without a version,
                    // it means version is inherited from BOM (which is correct)
                    if (pomLines[j].contains("</dependency>")) {
                        // Verify BOM exists in dependencyManagement
                        if (updatedPom.contains("<artifactId>spring-framework-bom</artifactId>") &&
                                updatedPom.contains("<version>${spring.version}</version>")) {
                            springUsesCorrectVersion = true;
                        }
                        break;
                    }
                }
                break;
            }
        }

        assertTrue(foundSpringDependency, "Should find Spring dependency");
        assertTrue(springUsesCorrectVersion,
                "Spring dependency should use ${spring.version} property (either directly or via BOM)");
    }

    private void verifySpringBomVersion(String updatedPom) {
        // Verify Spring BOM in dependencyManagement uses correct version
        assertTrue(updatedPom.contains("<artifactId>spring-framework-bom</artifactId>"),
                "Should have Spring BOM in dependencyManagement");

        // Verify the BOM uses the spring.version property
        String[] bomLines = updatedPom.split("\n");
        boolean foundSpringBom = false;
        boolean bomUsesSpringVersion = false;

        for (int i = 0; i < bomLines.length; i++) {
            if (bomLines[i].contains("<artifactId>spring-framework-bom</artifactId>")) {
                foundSpringBom = true;
                for (int j = i; j < Math.min(i + 5, bomLines.length); j++) {
                    if (bomLines[j].contains("<version>${spring.version}</version>")) {
                        bomUsesSpringVersion = true;
                        break;
                    }
                }
                break;
            }
        }

        assertTrue(foundSpringBom, "Should find Spring BOM in dependencyManagement");
        assertTrue(bomUsesSpringVersion, "Spring BOM should use ${spring.version} property");
    }

    private void verifyJavaMigration() throws IOException {
        Path migratedJavaFile = Path.of(projectLocation + "src/main/java/org/workflow/example/CamundaService.java");
        String javaContent = Files.readString(migratedJavaFile);

        assertTrue(javaContent.contains("package org.workflow.example;"));
        assertTrue(javaContent.contains("import org.finos.fluxnova.bpm.engine.ProcessEngine;"));
        assertTrue(javaContent.contains("import org.finos.fluxnova.bpm.engine.RuntimeService;"));
        assertTrue(javaContent.contains("import org.finos.fluxnova.bpm.model.bpmn.builder.FluxnovaErrorEventDefinitionBuilder;"));
        assertTrue(javaContent.contains("import org.finos.fluxnova.bpm.model.bpmn.impl.instance.fluxnova.FluxnovaExecutionListenerImpl;"));
        assertTrue(javaContent.contains("import org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova.FluxnovaConnector;"));
        assertTrue(javaContent.contains("import org.finos.fluxnova.bpm.model.bpmn.impl.instance.fluxnova.FluxnovaInputOutputImpl;"));
        assertTrue(javaContent.contains("FluxnovaExecutionListenerImpl testListener = (FluxnovaExecutionListenerImpl) listener;"));
        assertTrue(javaContent.contains("FluxnovaExecutionListener newListener = sampleMethod((FluxnovaExecutionListener) listener)"));
        assertTrue(javaContent.contains("public FluxnovaExecutionListener sampleMethod(FluxnovaExecutionListener exeListener)"));
        assertTrue(javaContent.contains("getType(FluxnovaConnector.class)"));
        assertTrue(javaContent.contains("Collection<FluxnovaExecutionListenerImpl> someList"));
        assertTrue(javaContent.contains("for(FluxnovaExecutionListenerImpl listenerItem : listeners)"));
        assertTrue(javaContent.contains("FluxnovaInputOutputImpl inputOutputImpl"));
        assertTrue(javaContent.contains("inputOutputImpl.getFluxnovaInputParameters()"));
        assertFalse(javaContent.contains("org.camunda"));
    }

    private void verifyBpmnMigration() throws IOException {
        Path bpmnFile = Path.of(projectLocation + "src/main/resources/process.bpmn");
        assertTrue(Files.exists(bpmnFile), "BPMN file should exist");

        String bpmnContent = Files.readString(bpmnFile);

        assertTrue(bpmnContent.contains("xmlns:fluxnova=\"http://fluxnova.finos.org/schema/1.0/bpmn\""));
        assertTrue(bpmnContent.contains("modeler:executionPlatformVersion=\"" + targetVersion + "\""));
        assertTrue(bpmnContent.contains("exporter=\"Fluxnova Modeler\""));
        assertTrue(bpmnContent.contains("xmlns:modeler=\"http://fluxnova.finos.org/schema/modeler/1.0/\""));
        assertTrue(bpmnContent.contains("exporterVersion=\"" + modelerVersion + "\""));
        assertTrue(bpmnContent.contains("camunda:initiator=\"starter\""));
        assertTrue(bpmnContent.contains("org.finos.fluxnova.commons.logging.Loggers.getLogger(\"MyProcess\")"));
        assertTrue(bpmnContent.contains("org.finos.fluxnova.bpm.engine.delegate"));
        assertTrue(bpmnContent.contains("org.finos.fluxnova.example.fluxnova.sample.TestFluxnovaExample"));
        assertTrue(bpmnContent.contains("camunda:class=\"org.finos.fluxnova.example.fluxnova.sample.TestFluxnovaExample\""));
        assertTrue(bpmnContent.contains("mycamunda:initiator=\"end\""));
        assertTrue(bpmnContent.contains("camundaprocess:initiator=\"end\""));

        //verify old camunda references removed from BPMN
        assertFalse(bpmnContent.contains("org.camunda"));
        assertFalse(bpmnContent.contains("org.camunda.bpm.engine.delegate"));
    }

    private void verifyDmnMigration() throws IOException {
        Path dmnFile = Path.of(projectLocation + "src/main/resources/decision.dmn");
        assertTrue(Files.exists(dmnFile), "DMN file should exist");

        String dmnContent = Files.readString(dmnFile);

        // Verify DMN namespace transformations based on OpenRewrite recipes
        assertTrue(dmnContent.contains("xmlns:fluxnova=\"http://fluxnova.finos.org/schema/1.0/dmn\""),
                "DMN should contain fluxnova namespace for DMN");
        assertTrue(dmnContent.contains("namespace=\"http://fluxnova.finos.org/schema/1.0/dmn\""),
                "DMN should contain updated namespace attribute");
        assertTrue(dmnContent.contains("exporter=\"Fluxnova Modeler\""),
                "DMN should contain Fluxnova Modeler as exporter");
        assertTrue(dmnContent.contains("exporterVersion=\"" + modelerVersion + "\""),
                "DMN should contain updated exporter version");
        assertTrue(dmnContent.contains("org.finos.fluxnova.bpm.engine.ProcessEngines.getDefaultProcessEngine()"));

        // Verify old Camunda references are removed from DMN
        assertFalse(dmnContent.contains("namespace=\"http://camunda.org/schema/1.0/dmn\""),
                "DMN should not contain old Camunda namespace");
        assertFalse(dmnContent.contains("exporter=\"Camunda Modeler\""),
                "DMN should not contain Camunda Modeler as exporter");
        assertFalse(dmnContent.contains("exporterVersion=\"4.5.0\""),
                "DMN should not contain old Camunda exporter version");
        assertFalse(dmnContent.contains("org.camunda"));
        assertFalse(dmnContent.contains("org.camunda.bpm.engine"));
    }

    private void verifyFormMigration() throws IOException {
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
    }

    private void verifyRewriteYmlDeleted() {
        assertFalse(Files.exists(Path.of(projectLocation + "rewrite.yml")), "rewrite.yml should be deleted");
    }

    private void createMockProjectStructureWithoutPom() throws IOException, URISyntaxException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL templateUrl = classLoader.getResource("test-project-without-pom-template");

        if (templateUrl == null) {
            throw new IOException("Template directory not found: test-project-without-pom-template");
        }

        Path templatePath = Paths.get(templateUrl.toURI());
        Path targetPath = Paths.get(projectLocation);

        FileUtils.copyDirectory(templatePath.toFile(), targetPath.toFile());

        // Verify no pom.xml exists
        Path pomPath = targetPath.resolve("pom.xml");
        assertFalse(Files.exists(pomPath), "pom.xml should not exist in this test scenario");
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

    private void verifySpringXmlMigration() throws IOException {
        Path springContextFile = Path.of(projectLocation + "src/main/resources/applicationContext.xml");
        assertTrue(Files.exists(springContextFile), "Spring context file should exist");

        String springContent = Files.readString(springContextFile);
        assertTrue(springContent.contains("org.finos.fluxnova.bpm.engine.spring.ProcessEngineFactoryBean"),
                "Should contain Fluxnova ProcessEngineFactoryBean");
        assertTrue(springContent.contains("org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration"),
                "Should contain Fluxnova ProcessEngineConfiguration");
        assertFalse(springContent.contains("org.camunda.bpm"),
                "Should not contain Camunda package references");

        Path log4jFile = Path.of(projectLocation + "src/main/resources/log4j2.xml");
        assertTrue(Files.exists(log4jFile), "Log4j2 file should exist");

        String log4jContent = Files.readString(log4jFile);
        assertTrue(log4jContent.contains("org.finos.fluxnova.bpm.engine"),
                "Should contain Fluxnova logger names");
        assertFalse(log4jContent.contains("org.camunda.bpm"),
                "Should not contain Camunda logger names");
    }

    private void verifyOpenApiMigration() throws IOException {
        Path openApiFile = Path.of(projectLocation + "src/main/resources/openapi.json");
        assertTrue(Files.exists(openApiFile), "OpenAPI file should exist");

        String openApiContent = Files.readString(openApiFile);

        // Verify title updated
        assertTrue(openApiContent.contains("\"title\": \"Fluxnova Process API\""),
                "Should contain Fluxnova Process API title");

        // Verify descriptions updated
        assertTrue(openApiContent.contains("API for Fluxnova BPM processes"),
                "Should contain Fluxnova BPM in description");
        assertTrue(openApiContent.contains("Get Fluxnova process definitions"),
                "Should contain Fluxnova in summary");
        assertTrue(openApiContent.contains("List of Fluxnova processes"),
                "Should contain Fluxnova in response description");

        // Verify schema references updated
        assertTrue(openApiContent.contains("FluxnovaProcessList"),
                "Should contain Fluxnova schema name");
        assertTrue(openApiContent.contains("Array of Fluxnova process definitions"),
                "Should contain Fluxnova in schema description");

        // Verify examples updated
        assertTrue(openApiContent.contains("Fluxnova Platform"),
                "Should contain Fluxnova in example values");

        // Verify no Camunda references remain
        assertFalse(openApiContent.contains("Camunda Process API"),
                "Should not contain Camunda Process API");
        assertFalse(openApiContent.contains("Camunda BPM"),
                "Should not contain Camunda BPM");
        assertFalse(openApiContent.contains("CamundaProcessList"),
                "Should not contain Camunda schema names");
    }

    private void verifyPropertiesMigration() throws IOException {
        Path propertiesFile = Path.of(projectLocation + "src/main/resources/application.properties");
        assertTrue(Files.exists(propertiesFile), "Properties file should exist");

        String propertiesContent = Files.readString(propertiesFile);
        System.out.println("propertiesContent = " + propertiesContent);

        // Verify spring.camunda.* properties migrated to spring.fluxnova.*
        assertTrue(propertiesContent.contains("spring.fluxnova.bpm.enabled=true"),
                "Should contain spring.fluxnova.bpm.enabled");
        assertTrue(propertiesContent.contains("spring.fluxnova.bpm.admin-user.id=admin"),
                "Should contain spring.fluxnova.bpm.admin-user.id");
        assertTrue(propertiesContent.contains("spring.fluxnova.bpm.database.schema-update=true"),
                "Should contain spring.fluxnova.bpm.database.schema-update");
        assertTrue(propertiesContent.contains("spring.fluxnova.bpm.history-level=full"),
                "Should contain spring.fluxnova.bpm.history-level");

        // Verify camunda.* properties migrated to fluxnova.*
        assertTrue(propertiesContent.contains("fluxnova.bpm.process-engine-name=default"),
                "Should contain fluxnova.bpm.process-engine-name");
        assertTrue(propertiesContent.contains("fluxnova.bpm.default-serialization-format=application/json"),
                "Should contain fluxnova.bpm.default-serialization-format");
        assertTrue(propertiesContent.contains("fluxnova.bpm.id-generator=strong"),
                "Should contain fluxnova.bpm.id-generator");

        // Verify environment variables migrated
        assertTrue(propertiesContent.contains("FLUXNOVA_BPM_URL=http://localhost:8080/fluxnova"),
                "Should contain FLUXNOVA_BPM_URL");
        assertTrue(propertiesContent.contains("FLUXNOVA_BPM_ADMIN_USER=admin"),
                "Should contain FLUXNOVA_BPM_ADMIN_USER");
        assertTrue(propertiesContent.contains("FLUXNOVA_BPM_ADMIN_PASSWORD=secret"),
                "Should contain FLUXNOVA_BPM_ADMIN_PASSWORD");

        // Verify URL paths migrated
        assertTrue(propertiesContent.contains("app.process.url=/fluxnova/api/process"),
                "Should contain /fluxnova/api/process");
        assertTrue(propertiesContent.contains("app.engine.endpoint=/fluxnova/engine-rest"),
                "Should contain /fluxnova/engine-rest");

        // Verify database URL migrated
        assertTrue(propertiesContent.contains("spring.datasource.url=jdbc:h2:mem:fluxnova-db"),
                "Should contain fluxnova-db");

        // Verify comments migrated
        assertTrue(propertiesContent.contains("# Fluxnova BPM Configuration"),
                "Should contain Fluxnova in comments");
        assertTrue(propertiesContent.contains("# Fluxnova Process Engine"),
                "Should contain Fluxnova Process Engine comment");

        // Verify application name migrated
        assertTrue(propertiesContent.contains("spring.application.name=Fluxnova Process Application"),
                "Should contain Fluxnova Process Application");
        assertTrue(propertiesContent.contains("app.description=Fluxnova BPM Integration"),
                "Should contain Fluxnova BPM Integration");

        // Verify deployment properties migrated
        assertTrue(propertiesContent.contains("deployment.artifact=fluxnova-process-app"),
                "Should contain fluxnova-process-app");
        assertTrue(propertiesContent.contains("deployment.version=fluxnova-7.15.0"),
                "Should contain fluxnova version");

        // Verify no Camunda references remain
        assertFalse(propertiesContent.contains("spring.camunda."),
                "Should not contain spring.camunda prefix");
        assertFalse(propertiesContent.contains("camunda.bpm"),
                "Should not contain camunda.bpm");
        assertFalse(propertiesContent.contains("CAMUNDA_"),
                "Should not contain CAMUNDA_ environment variables");
        assertFalse(propertiesContent.contains("/camunda"),
                "Should not contain /camunda paths");
        assertFalse(propertiesContent.contains("# Camunda"),
                "Should not contain Camunda in comments");
        assertFalse(propertiesContent.contains("=Camunda "),
                "Should not contain Camunda in values");
    }

    private void verifyYamlMigration() throws IOException {
        Path yamlFile = Path.of(projectLocation + "src/main/resources/application.yml");
        assertTrue(Files.exists(yamlFile), "YAML file should exist");

        String yamlContent = Files.readString(yamlFile);
        System.out.println("yamlContent = " + yamlContent);

        // Verify spring.fluxnova section (check for actual YAML structure)
        assertTrue(yamlContent.contains("spring:") && yamlContent.contains("  fluxnova:"),
                "Should contain spring.fluxnova section");
        assertTrue(yamlContent.contains("fluxnova:") && yamlContent.contains("  bpm:"),
                "Should contain fluxnova.bpm section");

        // Verify URL paths migrated
        assertTrue(yamlContent.contains("context-path: /fluxnova"),
                "Should contain /fluxnova context path");
        assertTrue(yamlContent.contains("url: http://localhost:8080/fluxnova"),
                "Should contain fluxnova URL");

        // Verify application name migrated
        assertTrue(yamlContent.contains("name: Fluxnova Process Application"),
                "Should contain Fluxnova Process Application");

        // Verify no Camunda references remain
        assertFalse(yamlContent.contains("camunda:"),
                "Should not contain camunda: key");
        assertFalse(yamlContent.contains("/camunda"),
                "Should not contain /camunda paths");
        assertFalse(yamlContent.contains("Camunda "),
                "Should not contain Camunda in values");
    }
    private void verifyJavaScriptTypeScriptMigration() throws IOException {
        // Verify consolidated TypeScript file
        Path tsFile = Path.of(projectLocation + "src/main/resources/typescript/TaskForm.tsx");
        if (Files.exists(tsFile)) {
            String tsContent = Files.readString(tsFile);
            System.out.println("TypeScript Content = " + tsContent);

            // Verify imports migrated
            assertTrue(tsContent.contains("from '@finos/fluxnova-form-js'"),
                    "Should contain Fluxnova form SDK import");
            assertTrue(tsContent.contains("from '@finos/fluxnova-tasklist-client'"),
                    "Should contain Fluxnova tasklist client import");
            assertTrue(tsContent.contains("from '@finos/fluxnova-camunda-bpm-sdk-js'"),
                    "Should contain Fluxnova SDK import");
            assertTrue(tsContent.contains("from '@finos/fluxnova-external-task-client-js'"),
                    "Should contain Fluxnova external task client import");

            // Verify class names migrated
            assertTrue(tsContent.contains("FluxnovaClient"),
                    "Should contain FluxnovaClient class");
            assertTrue(tsContent.contains("FluxnovaFormSDK"),
                    "Should contain FluxnovaFormSDK");

            // Verify API URLs migrated
            assertTrue(tsContent.contains("http://localhost:8080/fluxnova/api"),
                    "Should contain Fluxnova API URL");

            // Verify comments migrated
            assertTrue(tsContent.contains("// Fluxnova"),
                    "Should contain Fluxnova in single-line comments");
            assertTrue(tsContent.contains("/* Fluxnova"),
                    "Should contain Fluxnova in multi-line comments");
            assertTrue(tsContent.contains("Fluxnova imports"),
                    "Should contain Fluxnova imports comment");
            assertTrue(tsContent.contains("Fluxnova BPM"),
                    "Should contain Fluxnova BPM in comments");

            // Verify no Camunda references remain in imports and class names
            assertFalse(tsContent.contains("from '@camunda/"),
                    "Should not contain @camunda imports");
            assertFalse(tsContent.contains("from 'camunda-"),
                    "Should not contain camunda- imports");
            assertFalse(tsContent.contains("CamundaFormSDK"),
                    "Should not contain CamundaFormSDK");
        }
    }

    private void verifyTextFileMigration() throws IOException {
        // Verify README.md
        Path readmeFile = Path.of(projectLocation + "README.md");
        if (Files.exists(readmeFile)) {
            String readmeContent = Files.readString(readmeFile);
            System.out.println("README Content = " + readmeContent);

            assertTrue(readmeContent.contains("Fluxnova BPM Project"),
                    "Should contain Fluxnova BPM Project");
            assertTrue(readmeContent.contains("Fluxnova Platform"),
                    "Should contain Fluxnova Platform");
            assertTrue(readmeContent.contains("fluxnova.bpm.admin-user"),
                    "Should contain fluxnova.bpm.admin-user");
            assertTrue(readmeContent.contains("http://localhost:8080/fluxnova"),
                    "Should contain Fluxnova URL");

            assertFalse(readmeContent.contains("Camunda"),
                    "Should not contain Camunda");

            // Verify Test.txt
            Path textFile = Path.of(projectLocation + "src/main/resources/Test.txt");
            String textContent = Files.readString(textFile);

            assertTrue(textContent.contains("org.finos.fluxnova.bpm.engine.impl.plugin.AdministratorAuthorizationPlugin"),
                    "Should contain Fluxnova AdministratorAuthorizationPlugin");
            assertTrue(textContent.contains("org.finos.fluxnova.connect.plugin.impl.ConnectProcessEnginePlugin"),
                    "Should contain Fluxnova ConnectProcessEnginePlugin");
            assertTrue(textContent.contains("org.finos.fluxnova.bpm.engine.ProcessEngineConfiguration"),
                    "Should contain Fluxnova ProcessEngineConfiguration");
            assertTrue(textContent.contains("org.finos.fluxnova.example.fluxnova.sample.TestFluxnovaExample"),
                    "Should contain Fluxnova TestFluxnovaExample");

            assertFalse(textContent.contains("Camunda"),
                    "Should not contain Camunda");
        }

        // Verify startup.sh
        Path scriptFile = Path.of(projectLocation + "startup.sh");
        if (Files.exists(scriptFile)) {
            String scriptContent = Files.readString(scriptFile);
            System.out.println("Script Content = " + scriptContent);

            assertTrue(scriptContent.contains("FLUXNOVA_HOME"),
                    "Should contain FLUXNOVA_HOME");
            assertTrue(scriptContent.contains("FLUXNOVA_PORT"),
                    "Should contain FLUXNOVA_PORT");
            assertTrue(scriptContent.contains("Fluxnova BPM Platform"),
                    "Should contain Fluxnova BPM Platform");
            assertTrue(scriptContent.contains("fluxnova-bpm-run.jar"),
                    "Should contain fluxnova-bpm-run.jar");

            assertFalse(scriptContent.contains("CAMUNDA_"),
                    "Should not contain CAMUNDA_ variables");
        }
    }

    private void verifyHtmlEmbeddedFormMigration() throws IOException {
        Path migratedHtmlForm = Path.of(projectLocation, "src", "main", "resources", "UserRegistrationForm.html");
        assertTrue(Files.exists(migratedHtmlForm), "UserRegistrationForm.html should exist");

        String htmlContent = Files.readString(migratedHtmlForm);
        System.out.println("\n=== Migrated HTML Embedded Form Content ===");
        System.out.println(htmlContent);
        System.out.println("============================================\n");

        // Verify cam-variable-name migrated to fxn-variable-name
        assertFalse(htmlContent.contains("cam-variable-name"),
                "Should not contain cam-variable-name attribute");
        assertTrue(htmlContent.contains("fxn-variable-name=\"firstName\""),
                "Should contain fxn-variable-name=\"firstName\"");
        assertTrue(htmlContent.contains("fxn-variable-name=\"age\""),
                "Should contain fxn-variable-name=\"age\"");
        assertTrue(htmlContent.contains("fxn-variable-name=\"approved\""),
                "Should contain fxn-variable-name=\"approved\"");
        assertTrue(htmlContent.contains("fxn-variable-name=\"startDate\""),
                "Should contain fxn-variable-name=\"startDate\"");
        assertTrue(htmlContent.contains("fxn-variable-name=\"salary\""),
                "Should contain fxn-variable-name=\"salary\"");
        assertTrue(htmlContent.contains("fxn-variable-name=\"comments\""),
                "Should contain fxn-variable-name=\"comments\"");
        assertTrue(htmlContent.contains("fxn-variable-name=\"department\""),
                "Should contain fxn-variable-name=\"department\"");
        assertTrue(htmlContent.contains("fxn-variable-name=\"metadata\""),
                "Should contain fxn-variable-name=\"metadata\"");

        // Verify cam-variable-type migrated to fxn-variable-type
        assertFalse(htmlContent.contains("cam-variable-type"),
                "Should not contain cam-variable-type attribute");
        assertTrue(htmlContent.contains("fxn-variable-type=\"String\""),
                "Should contain fxn-variable-type=\"String\"");
        assertTrue(htmlContent.contains("fxn-variable-type=\"Integer\""),
                "Should contain fxn-variable-type=\"Integer\"");
        assertTrue(htmlContent.contains("fxn-variable-type=\"Boolean\""),
                "Should contain fxn-variable-type=\"Boolean\"");
        assertTrue(htmlContent.contains("fxn-variable-type=\"Date\""),
                "Should contain fxn-variable-type=\"Date\"");
        assertTrue(htmlContent.contains("fxn-variable-type=\"Double\""),
                "Should contain fxn-variable-type=\"Double\"");
        assertTrue(htmlContent.contains("fxn-variable-type=\"Json\""),
                "Should contain fxn-variable-type=\"Json\"");

        // Verify cam-choices migrated to fxn-choices
        assertFalse(htmlContent.contains("cam-choices"),
                "Should not contain cam-choices attribute");
        assertTrue(htmlContent.contains("fxn-choices=\"Engineering,Sales,Marketing,HR\""),
                "Should contain fxn-choices attribute");

        // Verify cam-values migrated to fxn-values
        assertFalse(htmlContent.contains("cam-values"),
                "Should not contain cam-values attribute");
        assertTrue(htmlContent.contains("fxn-values=\"ENG,SAL,MKT,HR\""),
                "Should contain fxn-values attribute");

        // Verify cam-script migrated to fxn-script
        assertFalse(htmlContent.contains("cam-script"),
                "Should not contain cam-script attribute");
        assertTrue(htmlContent.contains("fxn-script"),
                "Should contain fxn-script attribute");

        // Verify camForm references migrated to fxnForm
        assertFalse(htmlContent.contains("camForm"),
                "Should not contain camForm references");
        assertTrue(htmlContent.contains("fxnForm.variableManager"),
                "Should contain fxnForm.variableManager");
        assertTrue(htmlContent.contains("fxnForm.on('form-loaded'"),
                "Should contain fxnForm.on('form-loaded')");
        assertTrue(htmlContent.contains("fxnForm.on('variables-fetched'"),
                "Should contain fxnForm.on('variables-fetched')");
        assertTrue(htmlContent.contains("fxnForm.on('submit'"),
                "Should contain fxnForm.on('submit')");
        assertTrue(htmlContent.contains("fxnForm.on('submit-success'"),
                "Should contain fxnForm.on('submit-success')");
        assertTrue(htmlContent.contains("fxnForm.on('submit-failed'"),
                "Should contain fxnForm.on('submit-failed')");
        assertTrue(htmlContent.contains("fxnForm.fields.department"),
                "Should contain fxnForm.fields reference");

        // Verify Camunda SDK reference migrated
        assertFalse(htmlContent.contains("camunda-bpm-sdk"),
                "Should not contain camunda-bpm-sdk reference");
        assertTrue(htmlContent.contains("fluxnova-bpm-sdk"),
                "Should contain fluxnova-bpm-sdk reference");

        System.out.println("✅ All HTML embedded form attributes migrated successfully!");
    }

    private void verifyMetaInfMigration() throws IOException {
        Path springFactoriesFile = Path.of(projectLocation + "src/main/resources/META-INF/spring.factories");
        assertTrue(Files.exists(springFactoriesFile), "spring.factories file should exist");

        String springFactoriesContent = Files.readString(springFactoriesFile);
        System.out.println("springFactoriesContent = " + springFactoriesContent);

        // Verify Auto Configuration is migrated
        assertFalse(springFactoriesContent.contains("org.camunda.bpm.spring.boot.starter.CamundaBpmAutoConfiguration"),
                "Should not contain Camunda CamundaBpmAutoConfiguration");
        assertFalse(springFactoriesContent.contains("org.camunda.bpm.spring.boot.starter.rest.CamundaBpmRestAutoConfiguration"),
                "Should not contain Camunda CamundaBpmRestAutoConfiguration");
        assertFalse(springFactoriesContent.contains("org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration"),
                "Should not contain Camunda SpringProcessEngineConfiguration");

        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.bpm.spring.boot.starter.FluxnovaBpmAutoConfiguration"),
                "Should contain Fluxnova FluxnovaBpmAutoConfiguration");
        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.bpm.spring.boot.starter.rest.FluxnovaBpmRestAutoConfiguration"),
                "Should contain Fluxnova FluxnovaBpmRestAutoConfiguration");
        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.bpm.engine.spring.SpringProcessEngineConfiguration"),
                "Should contain Fluxnova SpringProcessEngineConfiguration");

        // Verify Application Listeners are migrated
        assertTrue(springFactoriesContent.contains("com.example.bpm.listener.CustomApplicationListener"),
                "Should preserve custom Application Listener");
        assertFalse(springFactoriesContent.contains("org.camunda.bpm.engine.spring.application.SpringProcessApplicationEventListener"),
                "Should not contain Camunda SpringProcessApplicationEventListener");
        assertFalse(springFactoriesContent.contains("org.camunda.bpm.spring.boot.starter.event.ProcessApplicationEventPublisher"),
                "Should not contain Camunda ProcessApplicationEventPublisher");

        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.bpm.engine.spring.application.SpringProcessApplicationEventListener"),
                "Should contain Fluxnova SpringProcessApplicationEventListener");
        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.bpm.spring.boot.starter.event.ProcessApplicationEventPublisher"),
                "Should contain Fluxnova ProcessApplicationEventPublisher");

        // Verify Process Engine Plugins are migrated
        assertFalse(springFactoriesContent.contains("org.camunda.bpm.engine.impl.plugin.AdministratorAuthorizationPlugin"),
                "Should not contain Camunda AdministratorAuthorizationPlugin");
        assertFalse(springFactoriesContent.contains("org.camunda.spin.plugin.impl.SpinProcessEnginePlugin"),
                "Should not contain Camunda SpinProcessEnginePlugin");
        assertFalse(springFactoriesContent.contains("org.camunda.connect.plugin.impl.ConnectProcessEnginePlugin"),
                "Should not contain Camunda ConnectProcessEnginePlugin");

        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.bpm.engine.impl.plugin.AdministratorAuthorizationPlugin"),
                "Should contain Fluxnova AdministratorAuthorizationPlugin");
        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.spin.plugin.impl.SpinProcessEnginePlugin"),
                "Should contain Fluxnova SpinProcessEnginePlugin");
        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.connect.plugin.impl.ConnectProcessEnginePlugin"),
                "Should contain Fluxnova ConnectProcessEnginePlugin");

        // Verify Initializers are migrated
        assertFalse(springFactoriesContent.contains("org.camunda.bpm.spring.boot.starter.configuration.CamundaBpmConfiguration"),
                "Should not contain Camunda CamundaBpmConfiguration");
        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.bpm.spring.boot.starter.configuration.FluxnovaBpmConfiguration"),
                "Should contain Fluxnova FluxnovaBpmConfiguration");

        // Verify Failure Analyzers are migrated
        assertFalse(springFactoriesContent.contains("org.camunda.bpm.spring.boot.starter.util.CamundaBpmFailureAnalyzer"),
                "Should not contain Camunda CamundaBpmFailureAnalyzer");
        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.bpm.spring.boot.starter.util.FluxnovaBpmFailureAnalyzer"),
                "Should contain Fluxnova FluxnovaBpmFailureAnalyzer");

        // Verify Property Sources are migrated
        assertFalse(springFactoriesContent.contains("org.camunda.bpm.spring.boot.starter.property.CamundaBpmPropertySourceLoader"),
                "Should not contain Camunda CamundaBpmPropertySourceLoader");
        assertTrue(springFactoriesContent.contains("org.finos.fluxnova.bpm.spring.boot.starter.property.FluxnovaBpmPropertySourceLoader"),
                "Should contain Fluxnova FluxnovaBpmPropertySourceLoader");

        // Verify structure is preserved
        assertTrue(springFactoriesContent.contains("# Auto Configuration"),
                "Should preserve Auto Configuration comment");
        assertTrue(springFactoriesContent.contains("# Application Listeners"),
                "Should preserve Application Listeners comment");
        assertTrue(springFactoriesContent.contains("# Process Engine Plugins"),
                "Should preserve Process Engine Plugins comment");
        assertTrue(springFactoriesContent.contains("org.springframework.boot.autoconfigure.EnableAutoConfiguration="),
                "Should preserve Spring Boot key");
        assertTrue(springFactoriesContent.contains("org.springframework.context.ApplicationListener="),
                "Should preserve Spring context key");

        Path processesFile = Path.of(projectLocation + "src/main/resources/META-INF/processes.xml");
        assertTrue(Files.exists(processesFile), "processes.xml file should exist");

        String processesContent = Files.readString(processesFile);
        System.out.println("processesContent = " + processesContent);

        assertFalse(processesContent.contains("http://www.camunda.org/schema/1.0/ProcessApplication"),
                "Should not contain Camunda namespace");
        assertTrue(processesContent.contains("http://www.fluxnova.finos.org/schema/1.0/ProcessApplication"),
                "Should contain Fluxnova namespace");

        // Verify structure is preserved
        assertTrue(processesContent.contains("<process-application"),
                "Should preserve process-application element");
        assertTrue(processesContent.contains("<process-archive name=\"tenant-a-processes\">"),
                "Should preserve first process-archive");
        assertTrue(processesContent.contains("<process-archive name=\"tenant-b-processes\" tenantId=\"tenant-b\">"),
                "Should preserve second process-archive with tenantId");
        assertTrue(processesContent.contains("<process-engine>default</process-engine>"),
                "Should preserve process-engine element");

        Path persistenceXmlFile = Path.of(projectLocation + "src/main/resources/META-INF/persistence.xml");
        assertTrue(Files.exists(persistenceXmlFile), "persistence.xml file should exist");

        String persistenceXmlContent = Files.readString(persistenceXmlFile);
        System.out.println("persistenceXmlContent = " + persistenceXmlContent);

        assertTrue(persistenceXmlContent.contains("CamundaPU"),
                "Should contain Camunda persistence-unit name");

        assertTrue(persistenceXmlContent.contains("<class>org.finos.fluxnova.bpm.engine.impl.persistence.entity.ProcessDefinitionEntity</class>"),
                "Should contain Fluxnova ProcessDefinitionEntity");
        assertTrue(persistenceXmlContent.contains("<class>org.finos.fluxnova.bpm.engine.impl.persistence.entity.ExecutionEntity</class>"),
                "Should contain Fluxnova ExecutionEntity");
        assertTrue(persistenceXmlContent.contains("<class>org.finos.fluxnova.bpm.engine.impl.persistence.entity.TaskEntity</class>"),
                "Should contain Fluxnova TaskEntity");

        Path oldServicePlugin = Path.of(projectLocation + "src/main/resources/META-INF/services/org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin");

        Path newServicePlugin = Path.of(projectLocation + "src/main/resources/META-INF/services/org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEnginePlugin");
        assertTrue(Files.exists(newServicePlugin), "ProcessEnginePlugin should exist");
        String servicePluginContent = Files.readString(newServicePlugin);
        System.out.println("servicePluginContent = " + servicePluginContent);

        assertFalse(Files.exists(oldServicePlugin),
                "Old service file should not exist: org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin");
        assertTrue(Files.exists(newServicePlugin),
                "New service file should exist: org.finos.fluxnova.bpm.engine.impl.cfg.ProcessEnginePlugin");
        assertTrue(servicePluginContent.contains("com.example.MyCustomCamundaPlugin"),
                "Should preserve Camunda custom plugin ");
        assertTrue(servicePluginContent.contains("com.example.MyCustomPlugin"),
                "Should preserve custom plugin");
        assertTrue(servicePluginContent.contains("org.finos.fluxnova.example.fluxnova.sample.TestFluxnovaExample"),
                "Should migrate to Fluxnova reference");
    }

    private void VerifyPythonScriptMigration() throws IOException {
        Path pythonFile = Path.of(projectLocation + "src/main/resources/external-script.py");
        assertTrue(Files.exists(pythonFile), "python script file should exist");

        String pythonScriptContent = Files.readString(pythonFile);
        System.out.println("pythonScriptContent = " + pythonScriptContent);

        // Verify Auto Configuration is migrated
        assertTrue(pythonScriptContent.contains("org.finos.fluxnova.bpm.engine"),
                "Should contain Fluxnova BPM engine reference");
        assertTrue(pythonScriptContent.contains("org.finos.fluxnova.bpm.engine.delegate"),
                "Should contain Fluxnova BPM engine delegate reference");
        assertTrue(pythonScriptContent.contains("org.finos.fluxnova.bpm.engine.variable"),
                "Should contain Fluxnova BPM engine variable reference");
        assertTrue(pythonScriptContent.contains("org.finos.fluxnova.spin"),
                "Should contain Fluxnova spin reference");
        assertTrue(pythonScriptContent.contains("org.finos.fluxnova.bpm.engine.impl.context"),
                "Should contain Fluxnova BPM engine Context reference");
        assertTrue(pythonScriptContent.contains("org.finos.fluxnova.example.fluxnova.sample"),
                "Should contain Fluxnova custom import reference");
        assertTrue(pythonScriptContent.contains("org.finos.fluxnova.bpm.fluxnova.service"),
                "Should contain Fluxnova custom service reference");
        assertTrue(pythonScriptContent.contains("process_engine = org.finos.fluxnova.bpm.engine.ProcessEngines.getDefaultProcessEngine()"),
                "Should contain Fluxnova ProcessEngines");
        assertTrue(pythonScriptContent.contains("variables = org.finos.fluxnova.bpm.engine.variable.Variables.createVariables()"),
                "Should contain Fluxnova BPM engine variables reference");
        assertTrue(pythonScriptContent.contains("json_data = org.finos.fluxnova.spin.Spin.JSON('{\"key\": \"value\"}')"),
                "Should contain Fluxnova Spin JSON reference");
        assertTrue(pythonScriptContent.contains("custom_service = org.finos.fluxnova.example.fluxnova.sample.CustomFluxnovaDelegate()"),
                "Should contain Fluxnova custom service reference");
        assertTrue(pythonScriptContent.contains("process_service = org.finos.fluxnova.bpm.fluxnova.service.ProcessService()"),
                "Should contain Fluxnova process service reference");
        assertTrue(pythonScriptContent.contains("execution.setVariable(\"engine_name\", org.finos.fluxnova.bpm.engine.ProcessEngines.NAME_DEFAULT)"),
                "Should contain Fluxnova ProcessEngines.NAME_DEFAULT");
        assertTrue(pythonScriptContent.contains("engine = org.finos.fluxnova.bpm.engine.ProcessEngines.getDefaultProcessEngine()"),
                "Should contain Fluxnova ProcessEngines.getDefaultProcessEngine()");

        assertFalse(pythonScriptContent.contains("org.camunda"),
                "Should not contain Camunda reference");
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
