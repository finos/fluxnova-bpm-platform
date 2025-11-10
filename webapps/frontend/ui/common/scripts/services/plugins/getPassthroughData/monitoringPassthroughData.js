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

module.exports = function(pluginPoint, scope) {
  let result = {};

  switch (pluginPoint) {
    case 'monitoring.processDefinition.runtime.tab':
    case 'monitoring.processDefinition.runtime.action':
    case 'monitoring.processDefinition.history.action':
    case 'monitoring.processDefinition.history.tab':
      result.processDefinitionId = scope.processDefinition.id;
      break;

    case 'monitoring.processInstance.runtime.tab':
    case 'monitoring.processInstance.runtime.action':
    case 'monitoring.processInstance.history.tab':
    case 'monitoring.processInstance.history.action':
      result.processInstanceId = scope.processInstance.id;
      break;

    case 'monitoring.processDefinition.diagram.plugin':
    case 'monitoring.processDefinition.history.diagram.plugin':
      result.processDefinitionId = scope.key;
      break;

    case 'monitoring.processInstance.diagram.plugin':
    case 'monitoring.processInstance.history.diagram.plugin':
      result.processInstanceId = window.location.hash.split('/')[2];
      break;

    case 'monitoring.jobDefinition.action':
      result.jobDefinitionId = scope.jobDefinition.id;
      break;

    case 'monitoring.decisionDefinition.tab':
    case 'monitoring.decisionDefinition.action':
      result.decisionDefinitionId = scope.decisionDefinition.id;
      break;

    case 'monitoring.decisionInstance.tab':
    case 'monitoring.decisionInstance.action':
      result.decisionInstanceId = scope.decisionInstance.id;
      break;

    case 'monitoring.caseDefinition.tab':
    case 'monitoring.caseDefinition.action':
      result.caseDefinitionId = scope.definition.id;
      break;

    case 'monitoring.caseInstance.tab':
    case 'monitoring.caseInstance.action':
      result.caseInstanceId = scope.instance.id;
      break;

    case 'monitoring.repository.resource.action':
      result.deploymentId = scope.deployment.id;
      result.resourceId = scope.resource.id;
      break;

    case 'monitoring.incident.action':
      result.incidentId = scope.incident.id;
      break;

    case 'monitoring.drd.definition.tab':
      result.drdDefinitionId = scope.tabsApi.getDefinition().id;
      break;

    case 'monitoring.drd.instance.tab':
      result.rootDecisionInstanceId = scope.tabsApi.processParams(
        {}
      ).rootDecisionInstanceId;
      break;

    case 'monitoring.processDefinition.diagram.action':
    case 'monitoring.processDefinition.history.diagram.action':
      result.viewer = scope.viewer;
      result.processDefinitionId = window.location.hash.split('/')[2];
      break;

    case 'monitoring.processes.action':
      result.processDefinitionId = scope.pd.id;
      break;

    case 'monitoring.repository.deployment.action':
      result.deploymentId = scope.deployment.id;
      break;

    default:
      result = {};
      break;
  }

  return result;
};
