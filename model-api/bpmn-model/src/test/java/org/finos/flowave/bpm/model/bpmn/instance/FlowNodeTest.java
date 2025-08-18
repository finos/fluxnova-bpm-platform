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
package org.finos.flowave.bpm.model.bpmn.instance;

import org.finos.flowave.bpm.model.bpmn.Bpmn;
import org.finos.flowave.bpm.model.bpmn.BpmnModelInstance;
import org.finos.flowave.bpm.model.bpmn.impl.instance.Incoming;
import org.finos.flowave.bpm.model.bpmn.impl.instance.Outgoing;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants.CAMUNDA_NS;

/**
 * @author Sebastian Menski
 */
public class FlowNodeTest extends BpmnModelElementInstanceTest {

  public TypeAssumption getTypeAssumption() {
    return new TypeAssumption(FlowElement.class, true);
  }

  public Collection<ChildElementAssumption> getChildElementAssumptions() {
    return Arrays.asList(
      new ChildElementAssumption(Incoming.class),
      new ChildElementAssumption(Outgoing.class)
    );
  }

  public Collection<AttributeAssumption> getAttributesAssumptions() {
    return Arrays.asList(
      new AttributeAssumption(CAMUNDA_NS, "asyncAfter", false, false, false),
      new AttributeAssumption(CAMUNDA_NS, "asyncBefore", false, false, false),
      new AttributeAssumption(CAMUNDA_NS, "exclusive", false, false, true),
      new AttributeAssumption(CAMUNDA_NS, "jobPriority")
    );
  }

  @Test
  public void testUpdateIncomingOutgoingChildElements() {
    BpmnModelInstance modelInstance = Bpmn.createProcess()
      .startEvent()
      .userTask("test")
      .endEvent()
      .done();

    // save current incoming and outgoing sequence flows
    UserTask userTask = modelInstance.getModelElementById("test");
    Collection<SequenceFlow> incoming = userTask.getIncoming();
    Collection<SequenceFlow> outgoing = userTask.getOutgoing();

    // create a new service task
    ServiceTask serviceTask = modelInstance.newInstance(ServiceTask.class);
    serviceTask.setId("new");

    // replace the user task with the new service task
    userTask.replaceWithElement(serviceTask);

    // assert that the new service task has the same incoming and outgoing sequence flows
    assertThat(serviceTask.getIncoming()).containsExactlyElementsOf(incoming);
    assertThat(serviceTask.getOutgoing()).containsExactlyElementsOf(outgoing);
  }

  @Test
    public void testFlowaveAsyncBefore() {
    Task task = modelInstance.newInstance(Task.class);
    assertThat(task.isFlowaveAsyncBefore()).isFalse();

    task.setFlowaveAsyncBefore(true);
    assertThat(task.isFlowaveAsyncBefore()).isTrue();
  }

  @Test
  public void testFlowaveAsyncAfter() {
    Task task = modelInstance.newInstance(Task.class);
    assertThat(task.isFlowaveAsyncAfter()).isFalse();

    task.setFlowaveAsyncAfter(true);
    assertThat(task.isFlowaveAsyncAfter()).isTrue();
  }

  @Test
  public void testFlowaveAsyncAfterAndBefore() {
    Task task = modelInstance.newInstance(Task.class);

    assertThat(task.isFlowaveAsyncAfter()).isFalse();
    assertThat(task.isFlowaveAsyncBefore()).isFalse();

    task.setFlowaveAsyncBefore(true);

    assertThat(task.isFlowaveAsyncAfter()).isFalse();
    assertThat(task.isFlowaveAsyncBefore()).isTrue();

    task.setFlowaveAsyncAfter(true);

    assertThat(task.isFlowaveAsyncAfter()).isTrue();
    assertThat(task.isFlowaveAsyncBefore()).isTrue();

    task.setFlowaveAsyncBefore(false);

    assertThat(task.isFlowaveAsyncAfter()).isTrue();
    assertThat(task.isFlowaveAsyncBefore()).isFalse();
  }

  @Test
  public void testFlowaveExclusive() {
    Task task = modelInstance.newInstance(Task.class);

    assertThat(task.isFlowaveExclusive()).isTrue();

    task.setFlowaveExclusive(false);

    assertThat(task.isFlowaveExclusive()).isFalse();
  }

  @Test
  public void testFlowaveJobPriority() {
    Task task = modelInstance.newInstance(Task.class);
    assertThat(task.getFlowaveJobPriority()).isNull();

    task.setFlowaveJobPriority("15");

    assertThat(task.getFlowaveJobPriority()).isEqualTo("15");
  }
}
