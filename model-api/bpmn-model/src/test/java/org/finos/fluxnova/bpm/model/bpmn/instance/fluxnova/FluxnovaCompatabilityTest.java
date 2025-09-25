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
package org.finos.fluxnova.bpm.model.bpmn.instance.fluxnova;

import org.finos.fluxnova.bpm.model.bpmn.Bpmn;
import org.finos.fluxnova.bpm.model.bpmn.BpmnModelInstance;
import org.finos.fluxnova.bpm.model.bpmn.FluxnovaExtensionsTest;
import org.finos.fluxnova.bpm.model.bpmn.impl.BpmnModelConstants;
import org.finos.fluxnova.bpm.model.bpmn.impl.instance.ProcessImpl;
import org.finos.fluxnova.bpm.model.bpmn.instance.ExtensionElements;
import org.junit.Test;

import java.util.Collection;

import static org.finos.fluxnova.bpm.model.bpmn.BpmnTestConstants.PROCESS_ID;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Test to check the interoperability when changing elements and attributes with
 * the {@link BpmnModelConstants#FLUXNOVA_NS}. In contrast to
 * {@link FluxnovaExtensionsTest} this test uses directly the get*Ns() methods to
 * check the expected value.
 */
public class FluxnovaCompatabilityTest {


  @Test
  public void modifyingElementWithFluxnovaNsKeepsIt() {
    BpmnModelInstance modelInstance = Bpmn.readModelFromStream(FluxnovaExtensionsTest.class.getResourceAsStream("CamundaExtensionsFluxnovaCompatabilityTest.xml"));
    ProcessImpl process = modelInstance.getModelElementById(PROCESS_ID);
    ExtensionElements extensionElements = process.getExtensionElements();
    Collection<FluxnovaExecutionListener> listeners = extensionElements.getChildElementsByType(FluxnovaExecutionListener.class);
    String listenerClass = "org.foo.Bar";
    for (FluxnovaExecutionListener listener : listeners) {
      listener.setFluxnovaClass(listenerClass);
    }
    for (FluxnovaExecutionListener listener : listeners) {
      assertThat(listener.getAttributeValueNs(BpmnModelConstants.FLUXNOVA_NS, "class"), is(listenerClass));
    }
  }

  @Test
  public void modifyingAttributeWithFluxnovaNsKeepsIt() {
    BpmnModelInstance modelInstance = Bpmn.readModelFromStream(FluxnovaExtensionsTest.class.getResourceAsStream("CamundaExtensionsFluxnovaCompatabilityTest.xml"));
    ProcessImpl process = modelInstance.getModelElementById(PROCESS_ID);
    String priority = "9000";
    process.setFluxnovaJobPriority(priority);
    process.setFluxnovaTaskPriority(priority);
    Integer historyTimeToLive = 10;
    process.setFluxnovaHistoryTimeToLive(historyTimeToLive);
    process.setFluxnovaIsStartableInTasklist(false);
    process.setFluxnovaVersionTag("v1.0.0");
    assertThat(process.getAttributeValueNs(BpmnModelConstants.FLUXNOVA_NS, "jobPriority"), is(priority));
    assertThat(process.getAttributeValueNs(BpmnModelConstants.FLUXNOVA_NS, "taskPriority"), is(priority));
    assertThat(process.getAttributeValueNs(BpmnModelConstants.FLUXNOVA_NS, "historyTimeToLive"), is(historyTimeToLive.toString()));
    assertThat(process.isFluxnovaStartableInTasklist(), is(false));
    assertThat(process.getFluxnovaVersionTag(), is("v1.0.0"));
  }

}
