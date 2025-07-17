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

'use strict';

var angular = require('flowave-commons-ui/vendor/angular'),
  /* controller */
  fwCockpitDeploymentsCtrl = require('./controllers/fw-cockpit-deployments-ctrl'),
  /* directives */
  fwCockpitDeployments = require('./directives/fw-cockpit-deployments'),
  fwCockpitDeployment = require('./directives/fw-cockpit-deployment'),
  fwCockpitDeploymentsSortingChoices = require('./directives/fw-cockpit-deployments-sorting-choices'),
  /* plugins */
  fwCockpitDeleteDeploymentPlugin = require('./plugins/actions/delete/fw-cockpit-delete-deployment-plugin'),
  /* modals */
  fwCockpitDeleteDeploymentModalCtrl = require('./plugins/actions/delete/modals/fw-cockpit-delete-deployment-modal-ctrl');

var deploymentsModule = angular.module('cam.cockpit.repository.deployments', [
  'ui.bootstrap'
]);

/* controllers */
deploymentsModule.controller('fwDeploymentsCtrl', fwCockpitDeploymentsCtrl);

/* directives */
deploymentsModule.directive('fwDeployments', fwCockpitDeployments);
deploymentsModule.directive('fwDeployment', fwCockpitDeployment);
deploymentsModule.directive(
  'fwDeploymentsSortingChoices',
  fwCockpitDeploymentsSortingChoices
);

/* plugins */
deploymentsModule.config(fwCockpitDeleteDeploymentPlugin);

/* modals */
deploymentsModule.controller(
  'fwDeleteDeploymentModalCtrl',
  fwCockpitDeleteDeploymentModalCtrl
);

module.exports = deploymentsModule;
