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
package org.finos.fluxnova.bpm.engine.test.cmmn.handler;

import org.finos.fluxnova.bpm.engine.impl.cmmn.handler.TaskItemHandler;
import org.finos.fluxnova.bpm.engine.impl.cmmn.model.CmmnActivity;
import org.finos.fluxnova.bpm.engine.test.cmmn.handler.specification.AbstractExecutionListenerSpec;
import org.finos.fluxnova.bpm.model.cmmn.instance.PlanItem;
import org.finos.fluxnova.bpm.model.cmmn.instance.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Thorben Lindhauer
 *
 */
public class TaskPlanItemExecutionListenerHandlerTest extends CmmnElementHandlerTest {

  public static Iterable<Object[]> data() {
    return ExecutionListenerCases.TASK_OR_STAGE_CASES;
  }

  protected Task task;
  protected PlanItem planItem;
  protected TaskItemHandler handler = new TaskItemHandler();

  protected AbstractExecutionListenerSpec testSpecification;

  public void initTaskPlanItemExecutionListenerHandlerTest(AbstractExecutionListenerSpec testSpecification) {
    this.testSpecification = testSpecification;
  }

  @BeforeEach
  public void setUp() {
    task = createElement(casePlanModel, "aTask", Task.class);

    planItem = createElement(casePlanModel, "PI_aTask", PlanItem.class);
    planItem.setDefinition(task);
  }

  @MethodSource("data")
  @ParameterizedTest(name = "testListener: {0}")
  public void testCaseExecutionListener(AbstractExecutionListenerSpec testSpecification) {
    initTaskPlanItemExecutionListenerHandlerTest(testSpecification);
    // given:
    testSpecification.addListenerToElement(modelInstance, task);

    // when
    CmmnActivity activity = handler.handleElement(planItem, context);

    // then
    testSpecification.verify(activity);
  }

}
