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
package org.finos.fluxnova.bpm.engine.test.cmmn.handler.specification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.finos.fluxnova.bpm.engine.delegate.Expression;
import org.finos.fluxnova.bpm.engine.impl.bpmn.parser.FieldDeclaration;
import org.finos.fluxnova.bpm.model.cmmn.CmmnModelInstance;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaCaseExecutionListener;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaExpression;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaField;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaString;

public class FieldSpec {

  protected String fieldName;
  protected String expression;
  protected String childExpression;
  protected String stringValue;
  protected String childStringValue;

  public FieldSpec(String fieldName, String expression, String childExpression,
      String stringValue, String childStringValue) {
    this.fieldName = fieldName;
    this.expression = expression;
    this.childExpression = childExpression;
    this.stringValue = stringValue;
    this.childStringValue = childStringValue;
  }

  public void verify(FieldDeclaration field) {
    assertEquals(fieldName, field.getName());

    Object fieldValue = field.getValue();
    assertNotNull(fieldValue);

    assertTrue(fieldValue instanceof Expression);
    Expression expressionValue = (Expression) fieldValue;
    assertEquals(getExpectedExpression(), expressionValue.getExpressionText());
  }

  public void addFieldToListenerElement(CmmnModelInstance modelInstance, FluxnovaCaseExecutionListener listenerElement) {
    FluxnovaField field = SpecUtil.createElement(modelInstance, listenerElement, null, FluxnovaField.class);
    field.setFluxnovaName(fieldName);

    if (expression != null) {
      field.setFluxnovaExpression(expression);

    } else if (childExpression != null) {
      FluxnovaExpression fieldExpressionChild = SpecUtil.createElement(modelInstance, field, null, FluxnovaExpression.class);
      fieldExpressionChild.setTextContent(childExpression);

    } else if (stringValue != null) {
      field.setFluxnovaStringValue(stringValue);

    } else if (childStringValue != null) {
      FluxnovaString fieldExpressionChild = SpecUtil.createElement(modelInstance, field, null, FluxnovaString.class);
      fieldExpressionChild.setTextContent(childStringValue);
    }
  }

  protected String getExpectedExpression() {
    if (expression != null) {
      return expression;
    } else if (childExpression != null) {
      return childExpression;
    } else if (stringValue != null) {
      return stringValue;
    } else {
      return childStringValue;
    }
  }

}
