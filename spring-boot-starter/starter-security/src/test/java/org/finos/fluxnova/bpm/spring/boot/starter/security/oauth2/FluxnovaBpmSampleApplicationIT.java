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
package org.finos.fluxnova.bpm.spring.boot.starter.security.oauth2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.context.WebApplicationContext;
import reactor.netty.http.client.HttpClient;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;

import static org.assertj.core.api.Assertions.assertThat;

public class FluxnovaBpmSampleApplicationIT extends AbstractSpringSecurityIT {

  @Autowired
  private WebApplicationContext webApplicationContext;

  private WebTestClient webTestClient;

  @BeforeEach
  @Override
  public void setup() throws Exception {
    super.setup();
    webTestClient = WebTestClient.bindToServer(
            new ReactorClientHttpConnector(HttpClient.create().followRedirect(true)))
        .baseUrl(baseUrl)
        .build();
  }

  @Test
  public void testSpringSecurityAutoConfigurationCorrectlySet() {
    // given oauth2 client not configured
    // when retrieving config beans then only SpringSecurityDisabledAutoConfiguration is present
    assertThat(getBeanForClass(FluxnovaSpringSecurityOAuth2AutoConfiguration.class, webApplicationContext)).isNull();
    assertThat(getBeanForClass(FluxnovaBpmSpringSecurityDisableAutoConfiguration.class, webApplicationContext)).isNotNull();
  }

  @Test
  public void testWebappApiIsAvailableAndRequiresAuthorization() {
    // given oauth2 client disabled
    // when calling the webapp api
    webTestClient.get().uri("/fluxnova/api/engine/engine/default/user")
        .exchange()
        .expectStatus().isEqualTo(HttpStatus.UNAUTHORIZED);
  }

  @Test
  public void testRestApiIsAvailable() {
    // given oauth2 client disabled
    // when calling the rest api
    webTestClient.get().uri("/engine-rest/engine/")
        .exchange()
        .expectStatus().isOk()
        .expectBody(String.class).isEqualTo(EXPECTED_NAME_DEFAULT);
  }
}
