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
package org.finos.fluxnova.spin.xml.dom.format.spi;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import org.finos.fluxnova.spin.DataFormats;
import org.finos.fluxnova.spin.impl.xml.dom.format.DomXmlDataFormat;
import org.finos.fluxnova.spin.xml.JdkUtil;
import org.finos.fluxnova.spin.xml.SpinXmlDataFormatException;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DomXmlDataFormatProtectionTest {

  protected static DomXmlDataFormat format;

  @BeforeAll
  public static void setUpMocks() {
    format = (DomXmlDataFormat) DataFormats.xml();
  }

  @Test
  public void shouldThrowExceptionForTooManyAttributes() {
    // IBM JDKs do not check on attribute number limits, skip the test there
    Assumptions.assumeFalse(JdkUtil.runsOnIbmJDK());

    // given
    String testXml = "org/finos/fluxnova/spin/xml/dom/format/spi/FeatureSecureProcessing.xml";
    InputStream testXmlAsStream = this.getClass().getClassLoader().getResourceAsStream(testXml);

    // when
    assertThatThrownBy(() ->
      format.getReader().readInput(new InputStreamReader(testXmlAsStream)))
        // then
        .isInstanceOf(SpinXmlDataFormatException.class);
  }

  @Test
  public void shouldThrowExceptionForDoctype() {
    // given
    String testXml = "org/finos/fluxnova/spin/xml/dom/format/spi/XxeProcessing.xml";
    InputStream testXmlAsStream = this.getClass().getClassLoader().getResourceAsStream(testXml);

    // when
    assertThatThrownBy(() ->
      format.getReader().readInput(new InputStreamReader(testXmlAsStream)))
        // then
        .isInstanceOf(SpinXmlDataFormatException.class)
        .hasMessageContaining("SPIN/DOM-XML-01009 Unable to parse input into DOM document")
        .hasStackTraceContaining("DOCTYPE")
        .hasStackTraceContaining("http://apache.org/xml/features/disallow-doctype-decl");
  }

  /*
   * Verifies that the TransformerFactory used by the writer is hardened against CWE-611
   * (XML External Entity Reference). The test simulates an attacker-controlled XSL
   * that attempts to include an external stylesheet via xsl:include (file URI).
   * With ACCESS_EXTERNAL_STYLESHEET set to "" and FEATURE_SECURE_PROCESSING enabled,
   * the transformer must reject external resource resolution and throw SpinXmlDataFormatException.
   */
  @Test
  public void shouldDenyExternalStylesheetAccessInFormattingConfiguration() throws Exception {
    // given
    // A minimal valid XSL file on disk, simulating an external resource an attacker
    // could reference.
    Path importedStylesheet = Files.createTempFile("spin-dom-xml-external-", ".xsl");
    Files.write(
      importedStylesheet,
      ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        + "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">"
        + "<xsl:template match=\"/\">"
        + "<included/>"
        + "</xsl:template>"
        + "</xsl:stylesheet>")
        .getBytes(StandardCharsets.UTF_8));

    // The security-sensitive line: xsl:include with an external file:// URI.
    // This is the attack vector that must be blocked by the hardened TransformerFactory.
    String stylesheetWithExternalIncluded = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
      + "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">"
      + "<xsl:include href=\"" + importedStylesheet.toUri() + "\"/>"
      + "</xsl:stylesheet>";

    // when / then
    // Setting this as the formatting configuration triggers template compilation, at which
    // point the transformer attempts to resolve the external include and must fail.
    try {
      assertThatThrownBy(() ->
        format.setFormattingConfiguration(
          new ByteArrayInputStream(stylesheetWithExternalIncluded.getBytes(StandardCharsets.UTF_8))))
        .isInstanceOf(SpinXmlDataFormatException.class)
        .hasMessageContaining("SPIN/DOM-XML-01038 Failed to get formatting templates")
        .hasStackTraceContaining("accessExternalStylesheet");
    } finally {
      Files.deleteIfExists(importedStylesheet);
    }
  }

}
