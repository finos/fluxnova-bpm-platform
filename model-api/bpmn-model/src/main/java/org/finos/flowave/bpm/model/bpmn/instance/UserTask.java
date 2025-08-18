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

import java.util.Collection;
import java.util.List;

import org.finos.flowave.bpm.model.bpmn.builder.UserTaskBuilder;

/**
 * The BPMN userTask element
 *
 * @author Sebastian Menski
 */
public interface UserTask extends Task {

  UserTaskBuilder builder();

  String getImplementation();

  void setImplementation(String implementation);

  Collection<Rendering> getRenderings();

  /** camunda extensions */

  String getFlowaveAssignee();

  void setFlowaveAssignee(String camundaAssignee);

  String getFlowaveCandidateGroups();

  void setFlowaveCandidateGroups(String camundaCandidateGroups);

  List<String> getFlowaveCandidateGroupsList();

  void setFlowaveCandidateGroupsList(List<String> camundaCandidateGroupsList);

  String getFlowaveCandidateUsers();

  void setFlowaveCandidateUsers(String camundaCandidateUsers);

  List<String> getFlowaveCandidateUsersList();

  void setFlowaveCandidateUsersList(List<String> camundaCandidateUsersList);

  String getFlowaveDueDate();

  void setFlowaveDueDate(String camundaDueDate);

  String getFlowaveFollowUpDate();

  void setFlowaveFollowUpDate(String camundaFollowUpDate);

  String getFlowaveFormHandlerClass();

  void setFlowaveFormHandlerClass(String camundaFormHandlerClass);

  String getFlowaveFormKey();

  void setFlowaveFormKey(String camundaFormKey);

  String getFlowaveFormRef();

  void setFlowaveFormRef(String camundaFormRef);

  String getFlowaveFormRefBinding();

  void setFlowaveFormRefBinding(String camundaFormRefBinding);

  String getFlowaveFormRefVersion();

  void setFlowaveFormRefVersion(String camundaFormRefVersion);

  String getFlowavePriority();

  void setFlowavePriority(String camundaPriority);
}
