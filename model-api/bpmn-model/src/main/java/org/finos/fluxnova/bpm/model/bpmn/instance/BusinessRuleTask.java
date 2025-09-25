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
package org.finos.fluxnova.bpm.model.bpmn.instance;

import org.finos.fluxnova.bpm.model.bpmn.builder.BusinessRuleTaskBuilder;

/**
 * The BPMN businessRuleTask element
 *
 * @author Sebastian Menski
 */
public interface BusinessRuleTask extends Task {

  BusinessRuleTaskBuilder builder();

  String getImplementation();

  void setImplementation(String implementation);

  /** camunda extensions */

  String getFluxnovaClass();

  void setFluxnovaClass(String camundaClass);

  String getFluxnovaDelegateExpression();

  void setFluxnovaDelegateExpression(String camundaExpression);

  String getFluxnovaExpression();

  void setFluxnovaExpression(String camundaExpression);

  String getFluxnovaResultVariable();

  void setFluxnovaResultVariable(String camundaResultVariable);

  String getFluxnovaType();

  void setFluxnovaType(String camundaType);

  String getFluxnovaTopic();

  void setFluxnovaTopic(String camundaTopic);

  String getFluxnovaDecisionRef();

  void setFluxnovaDecisionRef(String camundaDecisionRef);

  String getFluxnovaDecisionRefBinding();

  void setFluxnovaDecisionRefBinding(String camundaDecisionRefBinding);

  String getFluxnovaDecisionRefVersion();

  void setFluxnovaDecisionRefVersion(String camundaDecisionRefVersion);

  String getFluxnovaDecisionRefVersionTag();

  void setFluxnovaDecisionRefVersionTag(String camundaDecisionRefVersionTag);

  String getFluxnovaDecisionRefTenantId();

  void setFluxnovaDecisionRefTenantId(String tenantId);

  String getFluxnovaMapDecisionResult();

  void setFluxnovaMapDecisionResult(String camundaMapDecisionResult);

  String getFluxnovaTaskPriority();

  void setFluxnovaTaskPriority(String taskPriority);

}
