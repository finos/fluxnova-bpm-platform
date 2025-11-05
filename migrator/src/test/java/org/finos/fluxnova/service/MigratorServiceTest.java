package org.finos.fluxnova.service;

import org.apache.maven.model.*;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.shared.invoker.Invoker;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.finos.fluxnova.Migrator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.finos.fluxnova.util.Utils.deleteDirectoryRecursively;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
class MigratorServiceTest {

    String tempDir = System.getProperty("java.io.tmpdir");

    private MigratorService migratorService;
    private String projectLocation;
    private String targetVersion = "0.0.1-SNAPSHOT";
    private String modelerVersion = "0.0.1";

    @Mock
    private MavenXpp3Reader mavenReader;

    @Mock
    private MavenXpp3Writer mavenWriter;

    @Mock
    private Invoker invoker;

    @Mock
    private InputStream mockInputStream;

    @BeforeEach
    void setUp() throws IOException {
        projectLocation = tempDir + File.separator;
        migratorService = new MigratorService(projectLocation, targetVersion, modelerVersion);

        // Create a minimal pom.xml file in the temp directory
        Path pomPath = Path.of(projectLocation + "pom.xml");
        String minimalPom = """
            <?xml version="1.0" encoding="UTF-8"?>
            <project xmlns="http://maven.apache.org/POM/4.0.0"
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
                <modelVersion>4.0.0</modelVersion>
                <groupId>org.example</groupId>
                <artifactId>test-project</artifactId>
                <version>1.0-SNAPSHOT</version>
                <build>
                    <plugins>
                    </plugins>
                </build>
            </project>""";
        Files.writeString(pomPath, minimalPom);
    }

    @Test
    void testReadPomToModel() throws Exception {
        // This test uses the real implementation to read a pom file
        Model model = migratorService.readPomToModel(projectLocation + "pom.xml");

        assertNotNull(model);
        assertEquals("org.example", model.getGroupId());
        assertEquals("test-project", model.getArtifactId());
        assertEquals("1.0-SNAPSHOT", model.getVersion());
    }

    @Test
    void testAddPlugin() throws Exception {
        // Read the model from the test pom file
        Model model = migratorService.readPomToModel(projectLocation + "pom.xml");

        // Use reflection to access the private method
        java.lang.reflect.Method addPluginMethod = MigratorService.class.getDeclaredMethod("addPlugin", Model.class);
        addPluginMethod.setAccessible(true);
        addPluginMethod.invoke(migratorService, model);

        // Verify the plugin was added correctly
        List<Plugin> plugins = model.getBuild().getPlugins();
        assertEquals(1, plugins.size());

        Plugin plugin = plugins.get(0);
        assertEquals("org.openrewrite.maven", plugin.getGroupId());
        assertEquals("rewrite-maven-plugin", plugin.getArtifactId());
        assertEquals("6.16.0", plugin.getVersion());

        // Verify configuration
        Xpp3Dom config = (Xpp3Dom) plugin.getConfiguration();
        assertNotNull(config);

        Xpp3Dom activeRecipes = config.getChild("activeRecipes");
        assertNotNull(activeRecipes);

        Xpp3Dom[] recipeNodes = activeRecipes.getChildren("recipe");
        assertEquals(2, recipeNodes.length);
        assertEquals("camundaToFluxnova", recipeNodes[0].getValue());
        assertEquals("formMigration", recipeNodes[1].getValue());
    }

    @Test
    void testCopyRewriteYml() throws Exception {
        try (MockedStatic<Migrator> migratorMockedStatic = mockStatic(Migrator.class)) {
            // Setup ClassLoader mock
            ClassLoader mockClassLoader = mock(ClassLoader.class);
            //lenient(mockClassLoader.getResourceAsStream("rewrite.yml")).thenReturn(new ByteArrayInputStream("test content".getBytes()));

            // Use reflection to access the private method
            java.lang.reflect.Method copyRewriteYmlMethod = MigratorService.class.getDeclaredMethod("copyRewriteYml");
            copyRewriteYmlMethod.setAccessible(true);
            copyRewriteYmlMethod.invoke(migratorService);

            // Verify the file was created
            Path rewriteYmlPath = Path.of(projectLocation + "rewrite.yml");
            assertTrue(Files.exists(rewriteYmlPath));
        }
    }

    @Test
    void removeDependencies_shouldRemoveOpenrewriteDependencies() {
        // Arrange
        Model model = new Model();
        DependencyManagement dependencyManagement = new DependencyManagement();

        Dependency keepDependency = new Dependency();
        keepDependency.setGroupId("org.example");
        keepDependency.setArtifactId("example-lib");

        Dependency removeDependency1 = new Dependency();
        removeDependency1.setGroupId("org.openrewrite");
        removeDependency1.setArtifactId("rewrite-core");

        Dependency removeDependency2 = new Dependency();
        removeDependency2.setGroupId("org.openrewrite");
        removeDependency2.setArtifactId("rewrite-java");

        dependencyManagement.addDependency(keepDependency);
        dependencyManagement.addDependency(removeDependency1);
        dependencyManagement.addDependency(removeDependency2);

        model.setDependencyManagement(dependencyManagement);

        // Act
        migratorService.removeDependencies(model);

        // Assert
        List<Dependency> remainingDependencies = model.getDependencyManagement().getDependencies();
        assertEquals(1, remainingDependencies.size());
        assertEquals("org.example", remainingDependencies.get(0).getGroupId());
        assertEquals("example-lib", remainingDependencies.get(0).getArtifactId());
    }

    @Test
    void removeDependencies_shouldHandleNullDependencyManagement() {
        // Arrange
        Model model = new Model();
        model.setDependencyManagement(null);

        // Act & Assert (should not throw exception)
        assertDoesNotThrow(() -> migratorService.removeDependencies(model));
    }

    @Test
    void removePlugin_shouldRemoveRewriteMavenPlugin() {
        // Arrange
        Model model = new Model();
        Build build = new Build();

        Plugin keepPlugin = new Plugin();
        keepPlugin.setGroupId("org.example");
        keepPlugin.setArtifactId("example-plugin");

        Plugin removePlugin = new Plugin();
        removePlugin.setGroupId("org.openrewrite.maven");
        removePlugin.setArtifactId("rewrite-maven-plugin");

        build.addPlugin(keepPlugin);
        build.addPlugin(removePlugin);

        model.setBuild(build);

        // Act
        migratorService.removePlugin(model);

        // Assert
        List<Plugin> remainingPlugins = model.getBuild().getPlugins();
        assertEquals(1, remainingPlugins.size());
        assertEquals("org.example", remainingPlugins.get(0).getGroupId());
        assertEquals("example-plugin", remainingPlugins.get(0).getArtifactId());
    }

    @Test
    void removePlugin_shouldHandleNullBuild() {
        // Arrange
        Model model = new Model();
        model.setBuild(null);

        // Act & Assert (should not throw exception)
        assertDoesNotThrow(() -> migratorService.removePlugin(model));
    }

    @Test
    void deleteRewriteYml_shouldDeleteFileIfExists() throws IOException {
        // Arrange
        Path rewriteYmlPath = Path.of(projectLocation + "rewrite.yml");
        Files.writeString(rewriteYmlPath, "dummy content");

        // Act
        migratorService.deleteRewriteYml();

        // Assert
        assertFalse(Files.exists(rewriteYmlPath));
    }

    @Test
    void deleteRewriteYml_shouldHandleNonExistentFile() {
        // Arrange - ensure file doesn't exist
        Path rewriteYmlPath = Path.of(projectLocation + "rewrite.yml");
        assertFalse(Files.exists(rewriteYmlPath));

        // Act & Assert (should not throw exception)
        assertDoesNotThrow(() -> migratorService.deleteRewriteYml());
    }

    @Test
    void convertBpmnDmnFormToFileType_ShouldRenameFiles() throws IOException {
        Path bpmnFile = Path.of(projectLocation + "process.bpmn");
        Path dmnFile = Path.of(projectLocation + "decision.dmn");
        Path formFile = Path.of(projectLocation + "c_form.form");

        Files.deleteIfExists(bpmnFile);
        Files.deleteIfExists(dmnFile);
        Files.deleteIfExists(formFile);

        // Create test BPMN and DMN files
        Files.createFile(bpmnFile);
        Files.createFile(dmnFile);
        Files.createFile(formFile);

        // Execute conversion
        migratorService.convertBpmnDmnFormToFileType(new File(tempDir));

        // Verify BPMN conversion
        Path processXml = Path.of(projectLocation + "process__bpmn__.xml");
        assertTrue(Files.exists(processXml), "Converted BPMN XML file should exist");
        assertFalse(Files.exists(bpmnFile), "Original BPMN file should not exist after conversion");

        // Verify DMN conversion
        Path decisionXml = Path.of(projectLocation + "decision__dmn__.xml");
        assertTrue(Files.exists(decisionXml), "Converted DMN XML file should exist");
        assertFalse(Files.exists(dmnFile), "Original DMN file should not exist after conversion");

        // Verify form conversion
        Path formJson = Path.of(projectLocation + "c_form__form__.json");
        assertTrue(Files.exists(formJson), "Converted form JSON file should exist");
        assertFalse(Files.exists(formFile), "Original form file should not exist after conversion");

        // Cleanup
        Files.deleteIfExists(processXml);
        Files.deleteIfExists(decisionXml);
        Files.deleteIfExists(formJson);

    }

    @Test
    void convertFileTypeToBpmnDmn_Form_ShouldRenameFiles() throws IOException {
        // Create test converted XML files
        Path bpmnXmlFile = Path.of(projectLocation + "process__bpmn__.xml");
        Path dmnXmlFile = Path.of(projectLocation + "decision__dmn__.xml");
        Path formJsonFile = Path.of(projectLocation + "c_form__form__.json");

        Files.deleteIfExists(bpmnXmlFile);
        Files.deleteIfExists(dmnXmlFile);
        Files.deleteIfExists(formJsonFile);
        Files.createFile(bpmnXmlFile);
        Files.createFile(dmnXmlFile);
        Files.createFile(formJsonFile);

        // Execute conversion
        migratorService.convertFileTypeToBpmnDmnForm(new File(tempDir));

        // Verify BPMN conversion
        Path processBpmn = Path.of(projectLocation + "process.bpmn");
        assertTrue(Files.exists(processBpmn), "BPMN file should exist after conversion");
        assertFalse(Files.exists(bpmnXmlFile), "Original BPMN XML file should not exist after conversion");

        // Verify DMN conversion
        Path decisionDmn = Path.of(projectLocation + "decision.dmn");
        assertTrue(Files.exists(decisionDmn), "DMN file should exist after conversion");
        assertFalse(Files.exists(dmnXmlFile), "Original DMN XML file should not exist after conversion");

        // Verify DMN conversion
        Path formFile = Path.of(projectLocation + "c_form.form");
        assertTrue(Files.exists(formFile), "Form file should exist after conversion");
        assertFalse(Files.exists(formJsonFile), "Original form JSON file should not exist after conversion");

        // Cleanup
        Files.deleteIfExists(processBpmn);
        Files.deleteIfExists(decisionDmn);
        Files.deleteIfExists(formFile);
    }

    @Test
    void testCreateMinimalPom() throws IOException {
        // Arrange
        Path testDir = Path.of(projectLocation + File.separator + "testFolder");
        File pomFile = testDir.resolve("pom.xml").toFile();
        deleteDirectoryRecursively(testDir);
        // Ensure the directory doesn't exist initially
        assertFalse(Files.exists(testDir), "Test directory should not exist initially");

        // Act - Call the method directly (no reflection needed)
        migratorService.createMinimalPom(pomFile);

        // Assert
        // Verify that parent directory was created
        assertTrue(Files.exists(testDir), "Parent directory should be created");

        // Verify that pom.xml file was created
        assertTrue(Files.exists(pomFile.toPath()), "pom.xml file should be created");

        // Verify file content
        String pomContent = Files.readString(pomFile.toPath());

        // Check XML declaration and project structure
        assertTrue(pomContent.contains("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"),
                "Should contain XML declaration");
        assertTrue(pomContent.contains("<project xmlns=\"http://maven.apache.org/POM/4.0.0\""),
                "Should contain Maven project namespace");

        // Check project coordinates
        assertTrue(pomContent.contains("<groupId>org.finos.fluxnova</groupId>"),
                "Should contain correct groupId");
        assertTrue(pomContent.contains("<artifactId>migration-temp</artifactId>"),
                "Should contain correct artifactId");
        assertTrue(pomContent.contains("<version>1.0.0</version>"),
                "Should contain correct version");
        assertTrue(pomContent.contains("<packaging>pom</packaging>"),
                "Should contain pom packaging");

        // Check project metadata
        assertTrue(pomContent.contains("<name>Temporary Migration Project</name>"),
                "Should contain project name");
        assertTrue(pomContent.contains("<description>Temporary project for OpenRewrite migration from Camunda to Fluxnova</description>"),
                "Should contain project description");

        // Check build section
        assertTrue(pomContent.contains("<build>"), "Should contain build section");
        assertTrue(pomContent.contains("<plugins>"), "Should contain plugins section");
        assertTrue(pomContent.contains("<!-- OpenRewrite plugin will be added by prepare() method -->"),
                "Should contain OpenRewrite plugin comment");

        // Verify it's valid XML by parsing it
        assertDoesNotThrow(() -> {
            MavenXpp3Reader reader = new MavenXpp3Reader();
            try (StringReader stringReader = new StringReader(pomContent)) {
                Model model = reader.read(stringReader);

                // Additional model-level assertions
                assertEquals("org.finos.fluxnova", model.getGroupId());
                assertEquals("migration-temp", model.getArtifactId());
                assertEquals("1.0.0", model.getVersion());
                assertEquals("pom", model.getPackaging());
                assertEquals("Temporary Migration Project", model.getName());
                assertNotNull(model.getBuild());
                assertNotNull(model.getBuild().getPlugins());
            }
        }, "Generated POM should be valid XML and parseable by Maven");
    }
}