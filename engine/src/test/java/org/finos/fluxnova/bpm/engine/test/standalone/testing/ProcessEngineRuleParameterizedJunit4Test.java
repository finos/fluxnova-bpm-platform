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
package org.finos.fluxnova.bpm.engine.test.standalone.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.TaskService;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.ProcessEngineRule;
import org.finos.fluxnova.bpm.engine.test.util.ProvidedProcessEngineRule;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


/**
 * @author Thorben Lindhauer
 */
public class ProcessEngineRuleParameterizedJunit4Test {

  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
      { 1 }, { 2 }
    });
  }

  @RegisterExtension
  public ProcessEngineRule engineRule = new ProvidedProcessEngineRule();

  public void initProcessEngineRuleParameterizedJunit4Test(int parameter) {

  }

  /**
   * Unnamed @Deployment annotations don't work with parameterized Unit tests
   */
  @Disabled
  @MethodSource("data")
  @ParameterizedTest
  @Deployment
  public void ruleUsageExample(int parameter) {
    initProcessEngineRuleParameterizedJunit4Test(parameter);
    RuntimeService runtimeService = engineRule.getRuntimeService();
    runtimeService.startProcessInstanceByKey("ruleUsage");

    TaskService taskService = engineRule.getTaskService();
    Task task = taskService.createTaskQuery().singleResult();
    assertEquals("My Task", task.getName());

    taskService.complete(task.getId());
    assertEquals(0, runtimeService.createProcessInstanceQuery().count());
  }

  @ParameterizedTest
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/standalone/testing/ProcessEngineRuleParameterizedJunit4Test.ruleUsageExample.bpmn20.xml")
  @MethodSource("data")
  public void ruleUsageExampleWithNamedAnnotation(int parameter) {
    initProcessEngineRuleParameterizedJunit4Test(parameter);
    RuntimeService runtimeService = engineRule.getRuntimeService();
    runtimeService.startProcessInstanceByKey("ruleUsage");

    TaskService taskService = engineRule.getTaskService();
    Task task = taskService.createTaskQuery().singleResult();
    assertEquals("My Task", task.getName());

    taskService.complete(task.getId());
    assertEquals(0, runtimeService.createProcessInstanceQuery().count());
  }

  /**
   * The rule should work with tests that have no deployment annotation
   */
  @MethodSource("data")
  @ParameterizedTest
  public void testWithoutDeploymentAnnotation(int parameter) {
    initProcessEngineRuleParameterizedJunit4Test(parameter);
    assertEquals("aString", "aString");
  }

}
