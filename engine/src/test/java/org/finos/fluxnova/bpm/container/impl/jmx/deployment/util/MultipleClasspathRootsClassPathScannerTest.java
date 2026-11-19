/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.finos.fluxnova.bpm.container.impl.jmx.deployment.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.finos.fluxnova.bpm.container.impl.deployment.scanning.ClassPathProcessApplicationScanner;

import org.junit.jupiter.api.Test;


/**
 * @author Falko Menge
 * @author Daniel Meyer
 */
public class MultipleClasspathRootsClassPathScannerTest {

  private static final String RESOURCE_ROOT =
      "src/test/resources/org/finos/fluxnova/bpm/container/impl/jmx/deployment/util/";

  @Test
  public void testScanClassPath_multipleRoots() throws MalformedURLException {

    // build the jar fixture at test execution time instead of committing a
    // generated binary artifact (see OSPS-QA-05.01 / OSPS-QA-05.02)
    File jarFile = TestJarBuilder.createJarFromDirectory(
        Paths.get(RESOURCE_ROOT + "ClassPathScannerTest.testScanClassPathWithFilesRecursiveTwoDirectories"),
        "testScanClassPathRecursiveTwoDirectories");

    // define a classloader with multiple roots.
    URLClassLoader classLoader = new URLClassLoader(
      new URL[]{
        new URL("file:" + RESOURCE_ROOT + "ClassPathScannerTest.testScanClassPathWithFiles/"),
        new URL("file:" + RESOURCE_ROOT + "ClassPathScannerTest.testScanClassPathWithFilesRecursive/"),
        new URL("file:" + jarFile.getAbsolutePath())
      });

    ClassPathProcessApplicationScanner scanner = new ClassPathProcessApplicationScanner();

    Map<String, byte[]> scanResult = new HashMap<String, byte[]>();

    scanner.scanPaResourceRootPath(classLoader, null, "classpath:directory/",scanResult);

    assertTrue(contains(scanResult, "testDeployProcessArchive.bpmn20.xml"), "'testDeployProcessArchive.bpmn20.xml' not found");
    assertTrue(contains(scanResult, "testDeployProcessArchive.png"), "'testDeployProcessArchive.png' not found");
    assertEquals(2, scanResult.size()); // only finds two files since the resource name of the processes (and diagrams) is the same

    scanResult.clear();
    scanner.scanPaResourceRootPath(classLoader, null, "directory/", scanResult);

    assertTrue(contains(scanResult, "testDeployProcessArchive.bpmn20.xml"), "'testDeployProcessArchive.bpmn20.xml' not found");
    assertTrue(contains(scanResult, "testDeployProcessArchive.png"), "'testDeployProcessArchive.png' not found");
    assertEquals(2, scanResult.size()); // only finds two files since the resource name of the processes (and diagrams) is the same

    scanResult.clear();
    scanner.scanPaResourceRootPath(classLoader, new URL("file:" + RESOURCE_ROOT + "ClassPathScannerTest.testScanClassPathWithFilesRecursive/META-INF/processes.xml"), "pa:directory/", scanResult);

    assertTrue(contains(scanResult, "testDeployProcessArchive.bpmn20.xml"), "'testDeployProcessArchive.bpmn20.xml' not found");
    assertTrue(contains(scanResult, "testDeployProcessArchive.png"), "'testDeployProcessArchive.png' not found");
    assertEquals(2, scanResult.size()); // only finds two files since a PA-local resource root path is provided

  }

  private boolean contains(Map<String, byte[]> scanResult, String suffix) {
    for (String string : scanResult.keySet()) {
      if (string.endsWith(suffix)) {
        return true;
      }
    }
    return false;
  }

}
