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
package org.finos.flowave.bpm.engine.impl.cmmn.handler;

import java.util.List;

import org.finos.flowave.bpm.engine.impl.cmmn.behavior.ProcessOrCaseTaskActivityBehavior;
import org.finos.flowave.bpm.engine.impl.cmmn.model.CmmnActivity;
import org.finos.flowave.bpm.engine.impl.core.model.CallableElement;
import org.finos.flowave.bpm.engine.impl.core.model.CallableElementParameter;
import org.finos.flowave.bpm.engine.impl.core.variable.mapping.value.ParameterValueProvider;
import org.finos.flowave.bpm.engine.impl.el.ExpressionManager;
import org.finos.flowave.bpm.model.cmmn.instance.CmmnElement;
import org.finos.flowave.bpm.model.cmmn.instance.PlanItemDefinition;
import org.finos.flowave.bpm.model.cmmn.instance.flowave.FlowaveIn;
import org.finos.flowave.bpm.model.cmmn.instance.flowave.FlowaveOut;

/**
 * @author Roman Smirnov
 *
 */
public abstract class ProcessOrCaseTaskItemHandler extends CallingTaskItemHandler {

  protected CallableElement createCallableElement() {
    return new CallableElement();
  }

  protected void initializeCallableElement(CmmnElement element, CmmnActivity activity, CmmnHandlerContext context) {
    super.initializeCallableElement(element, activity, context);

    ProcessOrCaseTaskActivityBehavior behavior = (ProcessOrCaseTaskActivityBehavior) activity.getActivityBehavior();
    CallableElement callableElement = behavior.getCallableElement();

    // inputs
    initializeInputParameter(element, activity, context, callableElement);

    // outputs
    initializeOutputParameter(element, activity, context, callableElement);
  }

  protected void initializeInputParameter(CmmnElement element, CmmnActivity activity, CmmnHandlerContext context, CallableElement callableElement) {
    ExpressionManager expressionManager = context.getExpressionManager();

    List<FlowaveIn> inputs = getInputs(element);

    for (FlowaveIn input : inputs) {

      // businessKey
      String businessKey = input.getFlowaveBusinessKey();
      if (businessKey != null && !businessKey.isEmpty()) {
        ParameterValueProvider businessKeyValueProvider = createParameterValueProvider(businessKey, expressionManager);
        callableElement.setBusinessKeyValueProvider(businessKeyValueProvider);

      } else {
        // create new parameter
        CallableElementParameter parameter = new CallableElementParameter();
        callableElement.addInput(parameter);

        if (input.getFlowaveLocal()) {
          parameter.setReadLocal(true);
        }

        // all variables
        String variables = input.getFlowaveVariables();
        if ("all".equals(variables)) {
          parameter.setAllVariables(true);
          continue;
        }

        // source/sourceExpression
        String source = input.getFlowaveSource();
        if (source == null || source.isEmpty()) {
          source = input.getFlowaveSourceExpression();
        }

        ParameterValueProvider sourceValueProvider = createParameterValueProvider(source, expressionManager);
        parameter.setSourceValueProvider(sourceValueProvider);

        // target
        String target = input.getFlowaveTarget();
        parameter.setTarget(target);
      }
    }
  }

  protected void initializeOutputParameter(CmmnElement element, CmmnActivity activity, CmmnHandlerContext context, CallableElement callableElement) {
    ExpressionManager expressionManager = context.getExpressionManager();

    List<FlowaveOut> outputs = getOutputs(element);

    for (FlowaveOut output : outputs) {

      // create new parameter
      CallableElementParameter parameter = new CallableElementParameter();
      callableElement.addOutput(parameter);

      // all variables
      String variables = output.getFlowaveVariables();
      if ("all".equals(variables)) {
        parameter.setAllVariables(true);
        continue;
      }

      // source/sourceExpression
      String source = output.getFlowaveSource();
      if (source == null || source.isEmpty()) {
        source = output.getFlowaveSourceExpression();
      }

      ParameterValueProvider sourceValueProvider = createParameterValueProvider(source, expressionManager);
      parameter.setSourceValueProvider(sourceValueProvider);

      // target
      String target = output.getFlowaveTarget();
      parameter.setTarget(target);

    }
  }

  protected List<FlowaveIn> getInputs(CmmnElement element) {
    PlanItemDefinition definition = getDefinition(element);
    return queryExtensionElementsByClass(definition, FlowaveIn.class);
  }

  protected List<FlowaveOut> getOutputs(CmmnElement element) {
    PlanItemDefinition definition = getDefinition(element);
    return queryExtensionElementsByClass(definition, FlowaveOut.class);
  }
}
