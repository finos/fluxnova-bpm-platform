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

import org.finos.flowave.bpm.model.bpmn.instance.BpmnModelElementInstance;

import java.util.Collection;

/**
 * The BPMN formProperty camunda extension element
 *
 * @author Sebastian Menski
 */
public interface FlowaveFormProperty extends BpmnModelElementInstance {

  String getFlowaveId();

  void setFlowaveId(String camundaId);

  String getFlowaveName();

  void setFlowaveName(String camundaName);

  String getFlowaveType();

  void setFlowaveType(String camundaType);

  boolean isFlowaveRequired();

  void setFlowaveRequired(boolean isCamundaRequired);

  boolean isFlowaveReadable();

  void setFlowaveReadable(boolean isCamundaReadable);

  boolean isFlowaveWriteable();

  void setFlowaveWriteable(boolean isCamundaWriteable);

  String getFlowaveVariable();

  void setFlowaveVariable(String camundaVariable);

  String getFlowaveExpression();

  void setFlowaveExpression(String camundaExpression);

  String getFlowaveDatePattern();

  void setFlowaveDatePattern(String camundaDatePattern);

  String getFlowaveDefault();

  void setFlowaveDefault(String camundaDefault);

  Collection<FlowaveValue> getFlowaveValues();

}
