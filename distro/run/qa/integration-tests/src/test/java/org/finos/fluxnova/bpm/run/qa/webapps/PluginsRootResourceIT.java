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
package org.finos.fluxnova.bpm.run.qa.webapps;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.finos.fluxnova.bpm.run.qa.util.SpringBootManagedContainer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * NOTE:
 * copied from
 * <a href="https://github.com/finos/fluxnova-bpm-platform/tree/main/qa/integration-tests-webapps/integration-tests/src/main/java/org/finos/fluxnova/bpm/PluginsRootResourceIT.java">platform</a>
 * then added container lifecycle management for different setups
 * and changed  <code>appBasePath</code> to <code>APP_BASE_PATH</code>
 */
public class PluginsRootResourceIT extends AbstractWebIT {
  public String assetName;
  public boolean assetAllowed;

  @BeforeEach
  public void createClient() throws Exception {
    createClient(getWebappCtxPath());
  }

  private SpringBootManagedContainer container;

  @AfterEach
  public void stopApp() {
    try {
      if (container != null) {
        container.stop();
      }
    } catch (Exception e) {
      throw new RuntimeException("Cannot stop managed Spring Boot application!", e);
    } finally {
      container = null;
    }
  }

  private void startContainer() {
    container = new SpringBootManagedContainer("--webapps");
    try {
      container.start();
    } catch (Exception e) {
      throw new RuntimeException("Cannot start managed Spring Boot application!", e);
    }
  }

  public static Collection<Object[]> getAssets() {
    return Arrays.asList(new Object[][]{
        {"app/plugin.js", true},
        {"app/plugin.css", true},
        {"app/asset.js", false},
        {"../..", false},
        {"../../annotations-api.jar", false},
    });
  }

  @MethodSource("getAssets")
  @ParameterizedTest(name = "Test instance: {index}. Asset: {0}, Allowed: {1}")
  public void shouldGetAssetIfAllowed(String assetName, boolean assetAllowed) {
    startContainer();
    initPluginsRootResourceIT(assetName, assetAllowed);
    // when
    HttpResponse<String> response = Unirest.get(APP_BASE_PATH + "api/admin/plugin/adminPlugins/static/" + assetName).asString();

    // then
    assertResponse(assetName, response);
  }

  protected void assertResponse(String asset, HttpResponse<String> response) {
    if (assetAllowed) {
      assertEquals(200, response.getStatus());
    } else {
      assertEquals(403, response.getStatus());
      assertTrue(response.getHeaders().getFirst("Content-Type").startsWith("application/json"));
      String responseEntity = response.getBody();
      assertTrue(responseEntity.contains("\"type\":\"RestException\""));
      assertTrue(responseEntity.contains("\"message\":\"Not allowed to load the following file '" + asset + "'.\""));
    }
  }

  public void initPluginsRootResourceIT(String assetName, boolean assetAllowed) {
    this.assetName = assetName;
    this.assetAllowed = assetAllowed;
  }

}
