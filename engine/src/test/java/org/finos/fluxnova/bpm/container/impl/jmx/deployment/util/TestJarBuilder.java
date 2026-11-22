package org.finos.fluxnova.bpm.container.impl.jmx.deployment.util;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.stream.Stream;

/**
 * Test utility that packages a directory of test fixtures into a jar file at
 * test execution time. This avoids committing generated/binary jar artifacts
 * to version control (see OSPS-QA-05.01 / OSPS-QA-05.02).
 */
public final class TestJarBuilder {

  private TestJarBuilder() {
  }

  /**
   * Zips the contents of {@code sourceDirectory} into a newly created jar file
   * named {@code jarBaseName + ".jar"} inside a temporary directory. The
   * temporary directory and its contents are deleted on JVM exit.
   *
   * @param sourceDirectory the directory whose contents should be archived
   * @param jarBaseName     the jar file name, without the ".jar" suffix
   * @return the created jar file
   */
  public static File createJarFromDirectory(Path sourceDirectory, String jarBaseName) {
    try {
      Path tempDir = Files.createTempDirectory("fluxnova-test-jars");
      tempDir.toFile().deleteOnExit();

      File jarFile = tempDir.resolve(jarBaseName + ".jar").toFile();
      jarFile.deleteOnExit();

      try (JarOutputStream jarOutputStream = new JarOutputStream(Files.newOutputStream(jarFile.toPath()))) {
        try (Stream<Path> paths = Files.walk(sourceDirectory).sorted(Comparator.naturalOrder())) {
          paths.filter(path -> !path.equals(sourceDirectory))
              .forEach(path -> addEntry(jarOutputStream, sourceDirectory, path));
        }
      }

      return jarFile;
    }
    catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private static void addEntry(JarOutputStream jarOutputStream, Path sourceDirectory, Path path) {
    try {
      boolean isDirectory = Files.isDirectory(path);
      String entryName = sourceDirectory.relativize(path).toString().replace(File.separatorChar, '/');
      if (isDirectory && !entryName.endsWith("/")) {
        entryName = entryName + "/";
      }
      jarOutputStream.putNextEntry(new JarEntry(entryName));
      if (!isDirectory) {
        Files.copy(path, (OutputStream) jarOutputStream);
      }
      jarOutputStream.closeEntry();
    }
    catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

}


