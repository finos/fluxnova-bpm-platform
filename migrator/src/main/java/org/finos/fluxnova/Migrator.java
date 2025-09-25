package org.finos.fluxnova;

import org.apache.maven.shared.invoker.*;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.finos.fluxnova.service.MigratorService;

import java.io.*;

/**
 * Main entry point for the Flowave migration tool.
 * This class provides a command-line interface for migrating Camunda projects to Flowave.
 * It delegates the actual migration work to the {@link MigratorService} class.
 * 
 * <p>Usage: java -jar flowave-migrator.jar "/path/to/project"</p>
 */
public class Migrator {
    
    /**
     * The main method that initiates the migration process.
     * 
     * @param args Command line arguments. Expects exactly one argument:
     *             the path to the root directory of the project to be migrated.
     * @throws IOException If there is an error reading or writing files during migration
     * @throws XmlPullParserException If there is an error parsing XML files (e.g., pom.xml)
     * @throws MavenInvocationException If there is an error invoking Maven during the migration process
     */
    public static void main(String[] args) throws IOException, XmlPullParserException, MavenInvocationException {
        if(args.length != 3) {
            System.out.println("Usage: java Migrator <project-root-folder> <target-flowave-version> <modeler-version>");
            System.out.println("Example: java Migrator /path/to/project 0.0.1 1.0.0");
        } else {
            String projectPath = args[0];
            String targetVersion = args[1];
            String modelerVersion = args[2];
            System.out.println(String.format("Migration from Camunda to Flowave %s (Modeler %s) started on project %s", 
                targetVersion, modelerVersion, projectPath));
            MigratorService migratorService = new MigratorService(projectPath, targetVersion, modelerVersion);
            migratorService.start();
            System.out.println("Migrating from Camunda to Flowave ended");
        }
    }
}
