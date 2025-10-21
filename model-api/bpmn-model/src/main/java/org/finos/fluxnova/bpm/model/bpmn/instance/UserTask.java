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

import java.util.Collection;
import java.util.List;

import org.finos.fluxnova.bpm.model.bpmn.builder.UserTaskBuilder;

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

  String getFluxnovaAssignee();

  void setFluxnovaAssignee(String camundaAssignee);

  String getFluxnovaCandidateGroups();

  void setFluxnovaCandidateGroups(String camundaCandidateGroups);

  List<String> getFluxnovaCandidateGroupsList();

  void setFluxnovaCandidateGroupsList(List<String> camundaCandidateGroupsList);

  String getFluxnovaCandidateUsers();

  void setFluxnovaCandidateUsers(String camundaCandidateUsers);

  List<String> getFluxnovaCandidateUsersList();

  void setFluxnovaCandidateUsersList(List<String> camundaCandidateUsersList);

  String getFluxnovaDueDate();

  void setFluxnovaDueDate(String camundaDueDate);

  String getFluxnovaFollowUpDate();

  void setFluxnovaFollowUpDate(String camundaFollowUpDate);

  String getFluxnovaFormHandlerClass();

  void setFluxnovaFormHandlerClass(String camundaFormHandlerClass);

  String getFluxnovaFormKey();

  void setFluxnovaFormKey(String camundaFormKey);

  String getFluxnovaFormRef();

  void setFluxnovaFormRef(String fluxnovaFormRef);

  String getFluxnovaFormRefBinding();

  void setFluxnovaFormRefBinding(String fluxnovaFormRefBinding);

  String getFluxnovaFormRefVersion();

  void setFluxnovaFormRefVersion(String fluxnovaFormRefVersion);

  String getFluxnovaPriority();

  void setFluxnovaPriority(String camundaPriority);
}
