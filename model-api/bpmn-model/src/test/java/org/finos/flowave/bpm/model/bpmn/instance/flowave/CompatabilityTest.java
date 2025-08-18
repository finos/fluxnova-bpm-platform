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
package org.finos.flowave.bpm.model.bpmn.instance.flowave;

import static org.finos.flowave.bpm.model.bpmn.BpmnTestConstants.PROCESS_ID;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.finos.flowave.bpm.model.bpmn.Bpmn;
import org.finos.flowave.bpm.model.bpmn.BpmnModelInstance;
import org.finos.flowave.bpm.model.bpmn.FlowaveExtensionsTest;
import org.finos.flowave.bpm.model.bpmn.impl.BpmnModelConstants;
import org.finos.flowave.bpm.model.bpmn.impl.instance.ProcessImpl;
import org.finos.flowave.bpm.model.bpmn.instance.ExtensionElements;
import org.junit.Test;

/**
 * Test to check the interoperability when changing elements and attributes with
 * the {@link BpmnModelConstants#ACTIVITI_NS}. In contrast to
 * {@link FlowaveExtensionsTest} this test uses directly the get*Ns() methods to
 * check the expected value.
 *
 * @author Ronny Bräunlich
 *
 */
public class CompatabilityTest {

  @Test
  public void modifyingElementWithActivitiNsKeepsIt() {
    BpmnModelInstance modelInstance = Bpmn.readModelFromStream(FlowaveExtensionsTest.class.getResourceAsStream("CamundaExtensionsCompatabilityTest.xml"));
    ProcessImpl process = modelInstance.getModelElementById(PROCESS_ID);
    ExtensionElements extensionElements = process.getExtensionElements();
    Collection<FlowaveExecutionListener> listeners = extensionElements.getChildElementsByType(FlowaveExecutionListener.class);
    String listenerClass = "org.foo.Bar";
    for (FlowaveExecutionListener listener : listeners) {
      listener.setFlowaveClass(listenerClass);
    }
    for (FlowaveExecutionListener listener : listeners) {
      assertThat(listener.getAttributeValueNs(BpmnModelConstants.ACTIVITI_NS, "class"), is(listenerClass));
    }
  }

  @Test
  public void modifyingAttributeWithActivitiNsKeepsIt() {
    BpmnModelInstance modelInstance = Bpmn.readModelFromStream(FlowaveExtensionsTest.class.getResourceAsStream("CamundaExtensionsCompatabilityTest.xml"));
    ProcessImpl process = modelInstance.getModelElementById(PROCESS_ID);
    String priority = "9000";
    process.setFlowaveJobPriority(priority);
    process.setFlowaveTaskPriority(priority);
    Integer historyTimeToLive = 10;
    process.setFlowaveHistoryTimeToLive(historyTimeToLive);
    process.setFlowaveIsStartableInTasklist(false);
    process.setFlowaveVersionTag("v1.0.0");
    assertThat(process.getAttributeValueNs(BpmnModelConstants.ACTIVITI_NS, "jobPriority"), is(priority));
    assertThat(process.getAttributeValueNs(BpmnModelConstants.ACTIVITI_NS, "taskPriority"), is(priority));
    assertThat(process.getAttributeValueNs(BpmnModelConstants.ACTIVITI_NS, "historyTimeToLive"), is(historyTimeToLive.toString()));
    assertThat(process.isFlowaveStartableInTasklist(), is(false));
    assertThat(process.getFlowaveVersionTag(), is("v1.0.0"));
  }

}
