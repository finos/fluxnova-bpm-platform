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
package org.finos.flowave.spin.plugin.el;

import java.util.HashMap;
import java.util.Map;

import org.finos.flowave.bpm.engine.delegate.Expression;
import org.finos.flowave.bpm.engine.impl.test.PluggableProcessEngineTestCase;
import org.finos.flowave.bpm.engine.repository.Deployment;
import org.finos.flowave.bpm.engine.runtime.ProcessInstance;
import org.finos.flowave.bpm.model.bpmn.Bpmn;
import org.finos.flowave.bpm.model.bpmn.BpmnModelInstance;
import org.finos.flowave.spin.json.SpinJsonNode;
import org.finos.flowave.spin.plugin.script.TestVariableScope;
import org.finos.flowave.spin.xml.SpinXmlElement;

/**
 * <p>Testcase ensuring integration of camunda Spin into Process Engine expression language.</p>
 *
 * @author Daniel Meyer
 *
 */
public class SpinFunctionsTest extends PluggableProcessEngineTestCase {

  String xmlString = "<elementName attrName=\"attrValue\" />";
  String jsonString = "{\"foo\": \"bar\"}";

  @SuppressWarnings("unchecked")
  protected <T> T executeExpression(String expression) {

    final TestVariableScope varScope = new TestVariableScope();

    final Expression compiledExpression = processEngineConfiguration.getExpressionManager()
      .createExpression(expression);

    return (T) processEngineConfiguration.getCommandExecutorTxRequired()
      .execute(commandContext -> compiledExpression.getValue(varScope));
  }

  public void testSpin_S_Available() {

    SpinXmlElement spinXmlEl = executeExpression("${ S('" + xmlString + "') }");
    assertNotNull(spinXmlEl);
    assertEquals("elementName", spinXmlEl.name());
  }

  public void testSpin_XML_Available() {

    SpinXmlElement spinXmlEl = executeExpression("${ XML('" + xmlString + "') }");
    assertNotNull(spinXmlEl);
    assertEquals("elementName", spinXmlEl.name());
  }

  public void testSpin_JSON_Available() {

    SpinJsonNode spinJsonEl = executeExpression("${ JSON('" + jsonString + "') }");
    assertNotNull(spinJsonEl);
    assertEquals("bar", spinJsonEl.prop("foo").stringValue());
  }

  public void testSpin_XPath_Available() {

    String elName = executeExpression("${ S('" + xmlString + "').xPath('/elementName').element().name() }");
    assertNotNull(elName);
    assertEquals("elementName", elName);
  }

  public void testSpin_JsonPath_Available() {

    String property = executeExpression("${ S('" + jsonString + "').jsonPath('$.foo').stringValue() }");
    assertNotNull(property);
    assertEquals("bar", property);
  }

  public void testSpinAvailableInBpmn() {

    BpmnModelInstance bpmnModelInstance = Bpmn.createExecutableProcess("testProcess")
      .startEvent()
      .serviceTask()
        .flowaveExpression("${ execution.setVariable('customer', "
                                + "S(xmlVar).xPath('/customers/customer').element().toString()"
                             +")}")
      .receiveTask("wait")
      .endEvent()
    .done();

    Deployment deployment = repositoryService.createDeployment()
      .addModelInstance("process.bpmn", bpmnModelInstance)
      .deploy();

    Map<String, Object> variables = new HashMap<String, Object>();
    variables.put("xmlVar", "<customers><customer /></customers>");
    ProcessInstance pi = runtimeService.startProcessInstanceByKey("testProcess", variables);

    String customerXml = (String) runtimeService.getVariable(pi.getId(), "customer");
    assertNotNull(customerXml);
    assertTrue(customerXml.contains("customer"));
    assertFalse(customerXml.contains("customers"));

    runtimeService.signal(pi.getId());

    repositoryService.deleteDeployment(deployment.getId(), true);

  }
}
