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
package org.finos.fluxnova.bpm.container.impl.deployment.scanning;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests Windows-specific path normalization performed by
 * {@link ClassPathProcessApplicationScanner}.
 */
public class ClassPathProcessApplicationScannerWindowsPathTest {

  protected ClassPathProcessApplicationScanner scanner;

  @Before
  public void setUp() {
    scanner = new ClassPathProcessApplicationScanner();
  }

  @Test
  public void shouldRemoveLeadingSlashFromWindowsDrivePath() {
    assertEquals(
        "C:/dev/fluxnova-loan-review/target/classes/META-INF/processes.xml",
        scanner.normalizeWindowsPath(
            "/C:/dev/fluxnova-loan-review/target/classes/META-INF/processes.xml",
            '\\'));
  }

  @Test
  public void shouldSupportLowercaseWindowsDriveLetter() {
    assertEquals(
        "c:/dev/fluxnova-loan-review",
        scanner.normalizeWindowsPath(
            "/c:/dev/fluxnova-loan-review",
            '\\'));
  }

  @Test
  public void shouldNotChangeWindowsPathWithoutLeadingSlash() {
    assertEquals(
        "C:/dev/fluxnova-loan-review",
        scanner.normalizeWindowsPath(
            "C:/dev/fluxnova-loan-review",
            '\\'));
  }

  @Test
  public void shouldNotChangeNonDriveWindowsPath() {
    assertEquals(
        "/dev/fluxnova-loan-review",
        scanner.normalizeWindowsPath(
            "/dev/fluxnova-loan-review",
            '\\'));
  }

  @Test
  public void shouldNotChangePathOnNonWindowsPlatform() {
    assertEquals(
        "/C:/dev/fluxnova-loan-review",
        scanner.normalizeWindowsPath(
            "/C:/dev/fluxnova-loan-review",
            '/'));
  }
}
