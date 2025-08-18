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

import org.finos.flowave.bpm.model.bpmn.builder.CallActivityBuilder;

/**
 * The BPMN callActivity element
 *
 * @author Sebastian Menski
 */
public interface CallActivity extends Activity {

  CallActivityBuilder builder();

  String getCalledElement();

  void setCalledElement(String calledElement);

  /** camunda extensions */

  /**
   * @deprecated use isCamundaAsyncBefore() instead.
   */
  @Deprecated
  boolean isFlowaveAsync();

  /**
   * @deprecated use setCamundaAsyncBefore(isCamundaAsyncBefore) instead.
   */
  @Deprecated
  void setFlowaveAsync(boolean isCamundaAsync);

  String getFlowaveCalledElementBinding();

  void setFlowaveCalledElementBinding(String camundaCalledElementBinding);

  String getFlowaveCalledElementVersion();

  void setFlowaveCalledElementVersion(String camundaCalledElementVersion);

  String getFlowaveCalledElementVersionTag();

  void setFlowaveCalledElementVersionTag(String camundaCalledElementVersionTag);

  String getFlowaveCaseRef();

  void setFlowaveCaseRef(String camundaCaseRef);

  String getFlowaveCaseBinding();

  void setFlowaveCaseBinding(String camundaCaseBinding);

  String getFlowaveCaseVersion();

  void setFlowaveCaseVersion(String camundaCaseVersion);

  String getFlowaveCalledElementTenantId();

  void setFlowaveCalledElementTenantId(String tenantId);

  String getFlowaveCaseTenantId();

  void setFlowaveCaseTenantId(String tenantId);

  String getFlowaveVariableMappingClass();

  void setFlowaveVariableMappingClass(String camundaClass);

  String getFlowaveVariableMappingDelegateExpression();

  void setFlowaveVariableMappingDelegateExpression(String camundaExpression);

}
