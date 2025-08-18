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

import org.finos.flowave.bpm.model.bpmn.ProcessType;
import org.finos.flowave.bpm.model.bpmn.builder.ProcessBuilder;

import java.util.Collection;
import java.util.List;


/**
 * The BPMN process element
 *
 * @author Daniel Meyer
 * @author Sebastian Menski
 */
public interface Process extends CallableElement {

  ProcessBuilder builder();

  ProcessType getProcessType();

  void setProcessType(ProcessType processType);

  boolean isClosed();

  void setClosed(boolean closed);

  boolean isExecutable();

  void setExecutable(boolean executable);

  // TODO: collaboration ref

  Auditing getAuditing();

  void setAuditing(Auditing auditing);

  Monitoring getMonitoring();

  void setMonitoring(Monitoring monitoring);

  Collection<Property> getProperties();

  Collection<LaneSet> getLaneSets();

  Collection<FlowElement> getFlowElements();

  Collection<Artifact> getArtifacts();

  Collection<CorrelationSubscription> getCorrelationSubscriptions();

  Collection<ResourceRole> getResourceRoles();

  Collection<Process> getSupports();

  /** camunda extensions */

  String getFlowaveCandidateStarterGroups();

  void setFlowaveCandidateStarterGroups(String camundaCandidateStarterGroups);

  List<String> getFlowaveCandidateStarterGroupsList();

  void setFlowaveCandidateStarterGroupsList(List<String> camundaCandidateStarterGroupsList);

  String getFlowaveCandidateStarterUsers();

  void setFlowaveCandidateStarterUsers(String camundaCandidateStarterUsers);

  List<String> getFlowaveCandidateStarterUsersList();

  void setFlowaveCandidateStarterUsersList(List<String> camundaCandidateStarterUsersList);

  String getFlowaveJobPriority();

  void setFlowaveJobPriority(String jobPriority);

  String getFlowaveTaskPriority();

  void setFlowaveTaskPriority(String taskPriority);

  @Deprecated
  Integer getFlowaveHistoryTimeToLive();

  @Deprecated
  void setFlowaveHistoryTimeToLive(Integer historyTimeToLive);

  String getFlowaveHistoryTimeToLiveString();

  void setFlowaveHistoryTimeToLiveString(String historyTimeToLive);

  Boolean isFlowaveStartableInTasklist();

  void setFlowaveIsStartableInTasklist(Boolean isStartableInTasklist);

  String getFlowaveVersionTag();

  void setFlowaveVersionTag(String versionTag);
}
