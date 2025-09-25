package org.finos.fluxnova.service;

import org.apache.maven.model.*;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.shared.invoker.*;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.finos.fluxnova.Migrator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
        assertEquals(1, recipeNodes.length);
        assertEquals("camundaToFlowave", recipeNodes[0].getValue());
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
    void convertBpmnAndDmnToXml_ShouldRenameFiles() throws IOException {
        Path bpmnFile = Path.of(projectLocation + "process.bpmn");
        Path dmnFile = Path.of(projectLocation + "decision.dmn");
        
        Files.deleteIfExists(bpmnFile);
        Files.deleteIfExists(dmnFile);
        
        // Create test BPMN and DMN files
        Files.createFile(bpmnFile);
        Files.createFile(dmnFile);
    
        // Execute conversion
        migratorService.convertBpmnAndDmnToXml(new File(tempDir));
    
        // Verify BPMN conversion
        Path processXml = Path.of(projectLocation + "process__bpmn__.xml");
        assertTrue(Files.exists(processXml), "Converted BPMN XML file should exist");
        assertFalse(Files.exists(bpmnFile), "Original BPMN file should not exist after conversion");
    
        // Verify DMN conversion
        Path decisionXml = Path.of(projectLocation + "decision__dmn__.xml");
        assertTrue(Files.exists(decisionXml), "Converted DMN XML file should exist");
        assertFalse(Files.exists(dmnFile), "Original DMN file should not exist after conversion");
    
        // Cleanup
        Files.deleteIfExists(processXml);
        Files.deleteIfExists(decisionXml);

    }

    @Test
    void convertXmlToBpmnAndDmn_ShouldRenameFiles() throws IOException {
        // Create test converted XML files
        Path bpmnXmlFile = Path.of(projectLocation + "process__bpmn__.xml");
        Path dmnXmlFile = Path.of(projectLocation + "decision__dmn__.xml");
        
        Files.deleteIfExists(bpmnXmlFile);
        Files.deleteIfExists(dmnXmlFile);
        Files.createFile(bpmnXmlFile);
        Files.createFile(dmnXmlFile);
    
        // Execute conversion
        migratorService.convertXmlToBpmnAndDmn(new File(tempDir));
    
        // Verify BPMN conversion
        Path processBpmn = Path.of(projectLocation + "process.bpmn");
        assertTrue(Files.exists(processBpmn), "BPMN file should exist after conversion");
        assertFalse(Files.exists(bpmnXmlFile), "Original BPMN XML file should not exist after conversion");
    
        // Verify DMN conversion
        Path decisionDmn = Path.of(projectLocation + "decision.dmn");
        assertTrue(Files.exists(decisionDmn), "DMN file should exist after conversion");
        assertFalse(Files.exists(dmnXmlFile), "Original DMN XML file should not exist after conversion");
    
        // Cleanup
        Files.deleteIfExists(processBpmn);
        Files.deleteIfExists(decisionDmn);
    }

}