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
package org.finos.fluxnova.bpm.engine.impl.cmmn.handler;

import java.util.List;

import org.finos.fluxnova.bpm.engine.impl.cmmn.behavior.ProcessOrCaseTaskActivityBehavior;
import org.finos.fluxnova.bpm.engine.impl.cmmn.model.CmmnActivity;
import org.finos.fluxnova.bpm.engine.impl.core.model.CallableElement;
import org.finos.fluxnova.bpm.engine.impl.core.model.CallableElementParameter;
import org.finos.fluxnova.bpm.engine.impl.core.variable.mapping.value.ParameterValueProvider;
import org.finos.fluxnova.bpm.engine.impl.el.ExpressionManager;
import org.finos.fluxnova.bpm.model.cmmn.instance.CmmnElement;
import org.finos.fluxnova.bpm.model.cmmn.instance.PlanItemDefinition;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaIn;
import org.finos.fluxnova.bpm.model.cmmn.instance.fluxnova.FluxnovaOut;

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

    List<FluxnovaIn> inputs = getInputs(element);

    for (FluxnovaIn input : inputs) {

      // businessKey
      String businessKey = input.getFluxnovaBusinessKey();
      if (businessKey != null && !businessKey.isEmpty()) {
        ParameterValueProvider businessKeyValueProvider = createParameterValueProvider(businessKey, expressionManager);
        callableElement.setBusinessKeyValueProvider(businessKeyValueProvider);

      } else {
        // create new parameter
        CallableElementParameter parameter = new CallableElementParameter();
        callableElement.addInput(parameter);

        if (input.getFluxnovaLocal()) {
          parameter.setReadLocal(true);
        }

        // all variables
        String variables = input.getFluxnovaVariables();
        if ("all".equals(variables)) {
          parameter.setAllVariables(true);
          continue;
        }

        // source/sourceExpression
        String source = input.getFluxnovaSource();
        if (source == null || source.isEmpty()) {
          source = input.getFluxnovaSourceExpression();
        }

        ParameterValueProvider sourceValueProvider = createParameterValueProvider(source, expressionManager);
        parameter.setSourceValueProvider(sourceValueProvider);

        // target
        String target = input.getFluxnovaTarget();
        parameter.setTarget(target);
      }
    }
  }

  protected void initializeOutputParameter(CmmnElement element, CmmnActivity activity, CmmnHandlerContext context, CallableElement callableElement) {
    ExpressionManager expressionManager = context.getExpressionManager();

    List<FluxnovaOut> outputs = getOutputs(element);

    for (FluxnovaOut output : outputs) {

      // create new parameter
      CallableElementParameter parameter = new CallableElementParameter();
      callableElement.addOutput(parameter);

      // all variables
      String variables = output.getFluxnovaVariables();
      if ("all".equals(variables)) {
        parameter.setAllVariables(true);
        continue;
      }

      // source/sourceExpression
      String source = output.getFluxnovaSource();
      if (source == null || source.isEmpty()) {
        source = output.getFluxnovaSourceExpression();
      }

      ParameterValueProvider sourceValueProvider = createParameterValueProvider(source, expressionManager);
      parameter.setSourceValueProvider(sourceValueProvider);

      // target
      String target = output.getFluxnovaTarget();
      parameter.setTarget(target);

    }
  }

  protected List<FluxnovaIn> getInputs(CmmnElement element) {
    PlanItemDefinition definition = getDefinition(element);
    return queryExtensionElementsByClass(definition, FluxnovaIn.class);
  }

  protected List<FluxnovaOut> getOutputs(CmmnElement element) {
    PlanItemDefinition definition = getDefinition(element);
    return queryExtensionElementsByClass(definition, FluxnovaOut.class);
  }
}
