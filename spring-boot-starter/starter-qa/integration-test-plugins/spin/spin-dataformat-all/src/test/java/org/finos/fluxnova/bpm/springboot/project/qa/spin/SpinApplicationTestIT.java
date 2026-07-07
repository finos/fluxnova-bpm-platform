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
package org.finos.fluxnova.bpm.springboot.project.qa.spin;

import static org.hamcrest.CoreMatchers.containsString;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.finos.fluxnova.bpm.engine.HistoryService;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = { SpinApplication.class },
                webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SpinApplicationTestIT {

  @Autowired
  RuntimeService runtimeService;

  @Autowired
  HistoryService historyService;

  @Test
  public void shouldDeserializeSuccessfully() {
    // when
    runtimeService.startProcessInstanceByKey("spinServiceProcess");

    // then
    long variableCount = historyService.createHistoricVariableInstanceQuery().count();
    assertThat(variableCount).isOne();
  }

  @Test
  public void shouldFailWithSpinException() {
    Throwable exception = assertThrows(Exception.class, () ->

      // when
      runtimeService.startProcessInstanceByKey("spinJava8ServiceProcess"));
    // given
    org.hamcrest.MatcherAssert.assertThat(exception.getMessage(), containsString("SPIN/JACKSON-JSON-01006 Cannot deserialize"));
  }
}
