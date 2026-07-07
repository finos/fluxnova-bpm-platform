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

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.finos.fluxnova.bpm.container.impl.deployment.scanning.ClassPathProcessApplicationScanner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


/**
 * @author Falko Menge
 * @author Daniel Meyer
 */
public class ClassPathScannerTest {

  private String url;
  private static ClassPathProcessApplicationScanner scanner;

  public static List<Object[]> data() {
    return Arrays.asList(new Object[][] {
            { "file:src/test/resources/org/finos/fluxnova/bpm/container/impl/jmx/deployment/util/ClassPathScannerTest.testScanClassPathWithFiles/" },
            { "file:src/test/resources/org/finos/fluxnova/bpm/container/impl/jmx/deployment/util/ClassPathScannerTest.testScanClassPathWithFilesRecursive/" },
            { "file:src/test/resources/org/finos/fluxnova/bpm/container/impl/jmx/deployment/util/ClassPathScannerTest.testScanClassPathWithFilesRecursiveTwoDirectories/" },
            { "file:src/test/resources/org/finos/fluxnova/bpm/container/impl/jmx/deployment/util/ClassPathScannerTest.testScanClassPathWithAdditionalResourceSuffixes/" },
            { "file:src/test/resources/org/finos/fluxnova/bpm/container/impl/jmx/deployment/util/ClassPathScannerTest.testScanClassPath.jar" },
            { "file:src/test/resources/org/finos/fluxnova/bpm/container/impl/jmx/deployment/util/ClassPathScannerTest.testScanClassPathRecursive.jar" },
            { "file:src/test/resources/org/finos/fluxnova/bpm/container/impl/jmx/deployment/util/ClassPathScannerTest.testScanClassPathRecursiveTwoDirectories.jar" },
    });
  }


  public void initClassPathScannerTest(String url) {
    this.url = url;
  }
  
  @BeforeAll
  public static void setup() {
    scanner = new ClassPathProcessApplicationScanner();
  }

  /**
   * Test method for {@link org.finos.fluxnova.bpm.container.impl.deployment.scanning.ClassPathProcessApplicationScanner#scanClassPath(java.lang.ClassLoader)}.
   * @throws MalformedURLException 
   */
  @MethodSource("data")
  @ParameterizedTest
  public void testScanClassPath(String url) throws MalformedURLException {

    initClassPathScannerTest(url);
    
    URLClassLoader classLoader = getClassloader();
    
    Map<String, byte[]> scanResult = new HashMap<String, byte[]>();
    
    scanner.scanPaResourceRootPath(classLoader, new URL(url+"/META-INF/processes.xml"), null, scanResult);

    assertTrue(contains(scanResult, "testDeployProcessArchive.bpmn20.xml"), "'testDeployProcessArchive.bpmn20.xml' not found");
    assertTrue(contains(scanResult, "testDeployProcessArchive.png"), "'testDeployProcessArchive.png' not found");
    if(url.contains("TwoDirectories")) {
      assertEquals(4, scanResult.size());
    } else {
      assertEquals(2, scanResult.size());
    }
  }

  @MethodSource("data")
  @ParameterizedTest
  public void testScanClassPathWithNonExistingRootPath_relativeToPa(String url) throws MalformedURLException {

    initClassPathScannerTest(url);

    URLClassLoader classLoader = getClassloader();
    
    Map<String, byte[]> scanResult = new HashMap<String, byte[]>();
    scanner.scanPaResourceRootPath(classLoader, new URL(url+"/META-INF/processes.xml"), "pa:nonexisting", scanResult);

    assertFalse(contains(scanResult, "testDeployProcessArchive.bpmn20.xml"), "'testDeployProcessArchive.bpmn20.xml' found");
    assertFalse(contains(scanResult, "testDeployProcessArchive.png"), "'testDeployProcessArchive.png' found");
    assertEquals(0, scanResult.size());
  }

  @MethodSource("data")
  @ParameterizedTest
  public void testScanClassPathWithNonExistingRootPath_nonRelativeToPa(String url) throws MalformedURLException {

    initClassPathScannerTest(url);
    
    URLClassLoader classLoader = getClassloader();
    
    Map<String, byte[]> scanResult = new HashMap<String, byte[]>();
    scanner.scanPaResourceRootPath(classLoader, null, "nonexisting", scanResult);
    
    assertFalse(contains(scanResult, "testDeployProcessArchive.bpmn20.xml"), "'testDeployProcessArchive.bpmn20.xml' found");
    assertFalse(contains(scanResult, "testDeployProcessArchive.png"), "'testDeployProcessArchive.png' found");
    assertEquals(0, scanResult.size());
  }

  @MethodSource("data")
  @ParameterizedTest
  public void testScanClassPathWithExistingRootPath_relativeToPa(String url) throws MalformedURLException {

    initClassPathScannerTest(url);

    URLClassLoader classLoader = getClassloader();
    
    Map<String, byte[]> scanResult = new HashMap<String, byte[]>();
    scanner.scanPaResourceRootPath(classLoader, new URL(url+"/META-INF/processes.xml"), "pa:directory/", scanResult);

    if(url.contains("Recursive")) {
      assertTrue(contains(scanResult, "testDeployProcessArchive.bpmn20.xml"), "'testDeployProcessArchive.bpmn20.xml' not found");
      assertTrue(contains(scanResult, "testDeployProcessArchive.png"), "'testDeployProcessArchive.png' not found");
      assertEquals(2, scanResult.size());      
    } else {
      assertFalse(contains(scanResult, "testDeployProcessArchive.bpmn20.xml"), "'testDeployProcessArchive.bpmn20.xml' found");
      assertFalse(contains(scanResult, "testDeployProcessArchive.png"), "'testDeployProcessArchive.png' found");
      assertEquals(0, scanResult.size());
    }
  }

  @MethodSource("data")
  @ParameterizedTest
  public void testScanClassPathWithExistingRootPath_nonRelativeToPa(String url) throws MalformedURLException {

    initClassPathScannerTest(url);
    
    URLClassLoader classLoader = getClassloader();
    
    Map<String, byte[]> scanResult = new HashMap<String, byte[]>();
    scanner.scanPaResourceRootPath(classLoader, null, "directory/", scanResult);
        
    if(url.contains("Recursive")) {
      assertTrue(contains(scanResult, "testDeployProcessArchive.bpmn20.xml"), "'testDeployProcessArchive.bpmn20.xml' not found");
      assertTrue(contains(scanResult, "testDeployProcessArchive.png"), "'testDeployProcessArchive.png' not found");
      assertEquals(2, scanResult.size());      
    } else {
      assertFalse(contains(scanResult, "testDeployProcessArchive.bpmn20.xml"), "'testDeployProcessArchive.bpmn20.xml' found");
      assertFalse(contains(scanResult, "testDeployProcessArchive.png"), "'testDeployProcessArchive.png' found");
      assertEquals(0, scanResult.size());
    }
  }

  @MethodSource("data")
  @ParameterizedTest
  public void testScanClassPathWithAdditionalResourceSuffixes(String url) throws MalformedURLException {
    initClassPathScannerTest(url);
    URLClassLoader classLoader = getClassloader();

    String[] additionalResourceSuffixes = new String[] {"py", "rb", "groovy"};

    Map<String, byte[]> scanResult = scanner.findResources(classLoader, null, new URL(url + "/META-INF/processes.xml"), additionalResourceSuffixes);

    if (url.contains("AdditionalResourceSuffixes")) {
      assertEquals(5, scanResult.size());
    }
  }
  

  private URLClassLoader getClassloader() throws MalformedURLException {
    return new URLClassLoader(new URL[]{new URL(url)});
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
