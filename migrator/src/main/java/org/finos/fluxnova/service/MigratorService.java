package org.finos.fluxnova.service;

import org.apache.maven.model.*;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.apache.maven.shared.invoker.*;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.finos.fluxnova.Migrator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

/**
 * Service class responsible for migrating Camunda projects to Fluxnova.
 * This class handles the entire migration process including:
 * - Adding and removing OpenRewrite plugins and dependencies
 * - Converting BPMN files to XML and back
 * - Executing the OpenRewrite migration recipe
 */
public class MigratorService {

    protected static final Logger LOG = LoggerFactory.getLogger(MigratorService.class);
    private final String projectLocation;
    private final String targetVersion;
    private final String modelerVersion;

    /**
     * Constructs a new MigratorService with the specified project location.
     *
     * @param projectLocation The file system path to the project being migrated
     * @param targetVersion The target Fluxnova version to migrate to
     */
    public MigratorService(String projectLocation, String targetVersion, String modelerVersion) {
        this.projectLocation = projectLocation;
        this.targetVersion = targetVersion;
        this.modelerVersion = modelerVersion;
    }

    /**
     * Initiates the migration process.
     * This method orchestrates the entire migration workflow:
     * 1. Reads the project's POM file
     * 2. Prepares the project for migration
     * 3. Executes the OpenRewrite migration recipe
     * 4. Reads the modified POM file again to preserve changes
     * 5. Cleans up temporary migration artifacts
     *
     * @throws IOException If there is an error reading or writing files
     * @throws XmlPullParserException If there is an error parsing the POM XML
     * @throws MavenInvocationException If there is an error invoking Maven
     */
    public void start() throws IOException, XmlPullParserException, MavenInvocationException {
        String pomFile = projectLocation + File.separator + "pom.xml";
        Model model = readPomToModel(pomFile);
        prepare(pomFile, model);
        invokeRewriteRunGoal(pomFile);
        model = readPomToModel(pomFile); // it is important to read the model again to avoid losing changes done by openrewrite
        clear(pomFile, model);
    }

    /**
     * Reads a Maven POM file and converts it to a Model object.
     *
     * @param pomFile The path to the pom.xml file
     * @return The Maven Model object representing the POM
     * @throws IOException If there is an error reading the file
     * @throws XmlPullParserException If there is an error parsing the XML
     */
    Model readPomToModel(String pomFile) throws IOException, XmlPullParserException {
        return new MavenXpp3Reader().read(new FileReader(pomFile));
    }

    /**
     * Prepares the project for migration.
     * This method:
     * 1. Adds the OpenRewrite plugin to the POM
     * 2. Adds required OpenRewrite dependencies
     * 3. Writes the modified POM back to disk
     * 4. Copies the rewrite.yml recipe file to the project
     * 5. Converts BPMN files to XML format for processing
     *
     * @param pomFile The path to the project's pom.xml file
     * @param model The Maven Model object representing the POM
     * @throws IOException If there is an error writing files
     */
    private void prepare(String pomFile, Model model) throws IOException {
        addPlugin(model);
        writeModelToPom(pomFile, model);
        copyRewriteYml();
        convertBpmnAndDmnToXml(new File(projectLocation));
    }

    /**
     * Writes a Maven Model object back to a POM file.
     *
     * @param pomFile The path where the POM file should be written
     * @param model The Maven Model to write
     * @throws IOException If there is an error writing the file
     */
    private void writeModelToPom(String pomFile, Model model) throws IOException {
        new MavenXpp3Writer().write(new FileWriter(pomFile), model);
    }

    /**
     * Adds the OpenRewrite plugin to the project's POM file.
     * This plugin is necessary to execute the migration recipe.
     *
     * @param model The Maven Model to modify
     */
    private void addPlugin(Model model) {
        Build build = model.getBuild();
        if (build == null) {
            build = new Build();
            model.setBuild(build);
        }
        Plugin plugin = new Plugin();
        plugin.setGroupId("org.openrewrite.maven");
        plugin.setArtifactId("rewrite-maven-plugin");
        plugin.setVersion("6.16.0");
        // Build <configuration> with <activeRecipes><recipe>...</recipe></activeRecipes>
        Xpp3Dom configuration = new Xpp3Dom("configuration");
        Xpp3Dom activeRecipes = new Xpp3Dom("activeRecipes");

        String[] recipes = {
                "camundaToFluxnova"
        };

        for (String recipe : recipes) {
            Xpp3Dom recipeNode = new Xpp3Dom("recipe");
            recipeNode.setValue(recipe);
            activeRecipes.addChild(recipeNode);
        }

        configuration.addChild(activeRecipes);
        plugin.setConfiguration(configuration);
        build.addPlugin(plugin);
    }

    /**
     * Copies the rewrite.yml file containing the migration recipe to the project directory.
     * This file defines the transformations that will be applied to the codebase.
     */
    private void copyRewriteYml() {
        String rewriteYmlFile = "rewrite.yml"; // the file inside src/main/resources
        Path targetPath = Path.of(projectLocation + File.separator + rewriteYmlFile);

        try (InputStream inputStream = Migrator.class.getClassLoader().getResourceAsStream(rewriteYmlFile)) {
            Files.createDirectories(targetPath.getParent()); // create target dir if not exists
            assert inputStream != null;
            
            // Read the content as string
            String content = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            
            // Replace placeholders with actual values
            String processedContent = content
                .replace("{{TARGET_VERSION}}", targetVersion)
                .replace("{{MODELER_VERSION}}", modelerVersion);
            
            // Write the processed content to target
            Files.writeString(targetPath, processedContent, StandardCharsets.UTF_8);
            System.out.println("Copied and processed rewrite.yml to " + targetPath);

        } catch (IOException e) {
            LOG.error("Failed to copy and process rewrite.yml", e);
            e.printStackTrace();
        }
    }

    /**
     * Cleans up the project after migration.
     * This method:
     * 1. Removes the OpenRewrite plugin from the POM
     * 2. Removes OpenRewrite dependencies
     * 3. Writes the cleaned POM back to disk
     * 4. Deletes the rewrite.yml recipe file
     * 5. Converts XML files back to BPMN format
     *
     * @param pomFile The path to the project's pom.xml file
     * @param model The Maven Model object representing the POM
     * @throws IOException If there is an error writing files
     */
    private void clear(String pomFile, Model model) throws IOException {
        removePlugin(model);
        removeDependencies(model);
        writeModelToPom(pomFile, model);
        deleteRewriteYml();
        convertXmlToBpmnAndDmn(new File(projectLocation));
    }

    /**
     * Removes the OpenRewrite dependencies from the project's POM file.
     * This is done after migration to clean up the project.
     *
     * @param model The Maven Model to modify
     */
    void removeDependencies(Model model) {
        DependencyManagement dm = model.getDependencyManagement();
        if (dm != null) {
            List<Dependency> dependencies = dm.getDependencies();
            // Safely remove with iterator
            Iterator<Dependency> iterator = dependencies.iterator();
            while (iterator.hasNext()) {
                Dependency dep = iterator.next();

                // Match based on groupId + artifactId
                if ("org.openrewrite".equals(dep.getGroupId()) &&
                        ("rewrite-core".equals(dep.getArtifactId())
                                || "rewrite-java".equals(dep.getArtifactId()))) {
                    iterator.remove();
                    LOG.info("Removed dependency from dependencyManagement: " +
                            dep.getGroupId() + ":" + dep.getArtifactId());
                }
            }
        } else {
            LOG.info("<dependencyManagement> not found in pom.xml.");
        }
    }

    /**
     * Removes the OpenRewrite plugin from the project's POM file.
     * This is done after migration to clean up the project.
     *
     * @param model The Maven Model to modify
     */
    void removePlugin(Model model) {
        if (model.getBuild() != null) {
            List<Plugin> plugins = model.getBuild().getPlugins();

            // Use iterator to safely remove plugin while looping
            Iterator<Plugin> iterator = plugins.iterator();
            while (iterator.hasNext()) {
                Plugin plugin = iterator.next();
                if ("rewrite-maven-plugin".equals(plugin.getArtifactId())
                        && "org.openrewrite.maven".equals(plugin.getGroupId())) {
                    iterator.remove();
                    LOG.info("Removed rewrite-maven-plugin from pom.xml");
                }
            }
        }
    }

    /**
     * Invokes the OpenRewrite plugin's run goal using Maven.
     * This executes the migration recipe against the project.
     *
     * @param pomFile The path to the project's pom.xml file
     * @throws MavenInvocationException If there is an error invoking Maven
     */
    void invokeRewriteRunGoal(String pomFile) throws MavenInvocationException, IOException {
        String mavenHome = System.getenv("M2_HOME");
        if (mavenHome == null || mavenHome.isEmpty()) {
            LOG.info("M2_HOME not set");
            // Migrator service will most probably run in the Windows machine
            // However the below logic is required to get the test passed in CICD where M2_HOME is not explicitly set.
            String os = System.getProperty("os.name").toLowerCase();
            String command = os.contains("win") ? "where" : "which";
            ProcessBuilder pb = new ProcessBuilder(command, "mvn");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String mvnPath = reader.readLine();
            if (mvnPath != null) {
                mavenHome = mvnPath.replace("\\bin\\mvn.cmd", "").replace("/bin/mvn", "");
                LOG.info("Maven Home inferred: " + mavenHome);
            } else {
                LOG.info("Maven not found in PATH.");
            }
        } else {
            LOG.info("Maven home: " + mavenHome);
        }

        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File(pomFile));
        request.setGoals(List.of("rewrite:run"));

        Invoker invoker = new DefaultInvoker();
        assert mavenHome != null;
        invoker.setMavenHome(new File(mavenHome));
        invoker.setOutputHandler(System.out::println);
        invoker.execute(request);
    }

    /**
     * Deletes the rewrite.yml file from the project directory.
     * This method is called after the migration process is complete to clean up
     * temporary migration artifacts. The rewrite.yml file contains the OpenRewrite
     * recipe used for the migration.
     * 
     * <p>The method attempts to delete the file and prints a status message to the console:
     * <ul>
     *   <li>If the file was successfully deleted, it prints a success message</li>
     *   <li>If the file was not found, it prints a notification</li>
     *   <li>If an error occurs during deletion, it prints the error message</li>
     * </ul>
     *
     */
    void deleteRewriteYml() {
        String rewriteYmlFile = "rewrite.yml";
        Path targetPath = Path.of(projectLocation + File.separator + rewriteYmlFile);

        try {
            boolean deleted = Files.deleteIfExists(targetPath);
            if (deleted) {
                LOG.info(rewriteYmlFile + " file deleted successfully.");
            } else {
                LOG.info(rewriteYmlFile + " file not found.");
            }
        } catch (IOException e) {
            System.err.println("Error deleting file: " + e.getMessage());
        }
    }

    /**
     * Converts all BPMN files in the project to XML files.
     * This is necessary because OpenRewrite can only process XML files.
     * We can use the xml recipes to change the BPMN files.
     * The original file extension is preserved in the filename with a "__bpmn__" marker.
     *
     * @param folder The directory to process recursively
     */
    void convertBpmnAndDmnToXml(File folder) {
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                convertBpmnAndDmnToXml(file);
            } else if (file.isFile()) {
                String fileName = file.getName();
                String newName = null;
                // Handle .bpmn files
                if (fileName.endsWith(".bpmn") && !fileName.contains("__bpmn__")) {
                    newName = fileName.replace(".bpmn", "__bpmn__.xml");
                }
                // Handle .dmn files
                else if (fileName.endsWith(".dmn") && !fileName.contains("__dmn__")) {
                    newName = fileName.replace(".dmn", "__dmn__.xml");
                }
                if (newName != null) {
                    File newFile = new File(file.getParent(), newName);
                    if (file.renameTo(newFile)) {
                        LOG.info("Renamed to XML: {} -> {}", fileName, newName);
                    } else {
                        LOG.error("Failed to rename: {}", file.getAbsolutePath());
                    }
                }
            }
        }
    }

    /**
     * Converts all XML files that were originally BPMN files back to BPMN files.
     * This is done after the migration to restore the original file extensions.
     * Only files with the "__bpmn__" marker are converted back.
     *
     * @param folder The directory to process recursively
     */
    void convertXmlToBpmnAndDmn(File folder) {
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                convertXmlToBpmnAndDmn(file);
            } else if (file.isFile()) {
                String fileName = file.getName();
                String newName = null;
                // Handle __bpmn__.xml files
                if (fileName.endsWith("__bpmn__.xml")) {
                    newName = fileName.replace("__bpmn__.xml", ".bpmn");
                }
                // Handle __dmn__.xml files
                else if (fileName.endsWith("__dmn__.xml")) {
                    newName = fileName.replace("__dmn__.xml", ".dmn");
                }
                if (newName != null) {
                    File newFile = new File(file.getParent(), newName);
                    if (file.renameTo(newFile)) {
                        LOG.info("Reverted to original format: {} -> {}", fileName, newName);
                    } else {
                        LOG.error("Failed to rename: {}", file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
