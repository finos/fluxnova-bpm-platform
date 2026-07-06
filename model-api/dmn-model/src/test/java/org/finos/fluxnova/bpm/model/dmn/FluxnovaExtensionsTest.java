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
package org.finos.fluxnova.bpm.model.dmn;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.finos.fluxnova.bpm.model.dmn.instance.Decision;
import org.finos.fluxnova.bpm.model.dmn.instance.Input;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FluxnovaExtensionsTest {

  private DmnModelInstance originalModelInstance;
  private DmnModelInstance modelInstance;

   public static Collection<Object[]> parameters(){
     return Arrays.asList(new Object[][]{
         {Dmn.readModelFromStream(FluxnovaExtensionsTest.class.getResourceAsStream("CamundaExtensionsTest.dmn"))},
         // for compatibility reasons we gotta check the old namespace, too
         {Dmn.readModelFromStream(FluxnovaExtensionsTest.class.getResourceAsStream("CamundaExtensionsCompatibilityTest.dmn"))}
     });
   }

  public void initFluxnovaExtensionsTest(DmnModelInstance originalModelInstance) {
    this.originalModelInstance = originalModelInstance;
    modelInstance = originalModelInstance.clone();
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaClauseOutput(DmnModelInstance originalModelInstance) {
    initFluxnovaExtensionsTest(originalModelInstance);
    Input input = modelInstance.getModelElementById("input");
    assertThat(input.getFluxnovaInputVariable()).isEqualTo("myVariable");
    input.setFluxnovaInputVariable("foo");
    assertThat(input.getFluxnovaInputVariable()).isEqualTo("foo");
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaHistoryTimeToLive(DmnModelInstance originalModelInstance) {
    initFluxnovaExtensionsTest(originalModelInstance);
    Decision decision = modelInstance.getModelElementById("decision");
    assertThat(decision.getFluxnovaHistoryTimeToLive()).isEqualTo(5);
    decision.setFluxnovaHistoryTimeToLive(6);
    assertThat(decision.getFluxnovaHistoryTimeToLive()).isEqualTo(6);
  }

  @MethodSource("parameters")
  @ParameterizedTest(name = "Namespace: {0}")
  public void testFluxnovaVersionTag(DmnModelInstance originalModelInstance) {
    initFluxnovaExtensionsTest(originalModelInstance);
    Decision decision = modelInstance.getModelElementById("decision");
    assertThat(decision.getVersionTag()).isEqualTo("1.0.0");
    decision.setVersionTag("1.1.0");
    assertThat(decision.getVersionTag()).isEqualTo("1.1.0");
  }

  @AfterEach
  public void validateModel() {
    Dmn.validateModel(modelInstance);
  }

}
