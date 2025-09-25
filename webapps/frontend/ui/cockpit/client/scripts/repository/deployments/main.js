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

var angular = require('fluxnova-commons-ui/vendor/angular'),
  /* controller */
  fxnCockpitDeploymentsCtrl = require('./controllers/fxn-cockpit-deployments-ctrl'),
  /* directives */
  fxnCockpitDeployments = require('./directives/fxn-cockpit-deployments'),
  fxnCockpitDeployment = require('./directives/fxn-cockpit-deployment'),
  fxnCockpitDeploymentsSortingChoices = require('./directives/fxn-cockpit-deployments-sorting-choices'),
  /* plugins */
  fxnCockpitDeleteDeploymentPlugin = require('./plugins/actions/delete/fxn-cockpit-delete-deployment-plugin'),
  /* modals */
  fxnCockpitDeleteDeploymentModalCtrl = require('./plugins/actions/delete/modals/fxn-cockpit-delete-deployment-modal-ctrl');

var deploymentsModule = angular.module('fxn.cockpit.repository.deployments', [
  'ui.bootstrap'
]);

/* controllers */
deploymentsModule.controller('fxnDeploymentsCtrl', fxnCockpitDeploymentsCtrl);

/* directives */
deploymentsModule.directive('fxnDeployments', fxnCockpitDeployments);
deploymentsModule.directive('fxnDeployment', fxnCockpitDeployment);
deploymentsModule.directive(
  'fxnDeploymentsSortingChoices',
  fxnCockpitDeploymentsSortingChoices
);

/* plugins */
deploymentsModule.config(fxnCockpitDeleteDeploymentPlugin);

/* modals */
deploymentsModule.controller(
  'fxnDeleteDeploymentModalCtrl',
  fxnCockpitDeleteDeploymentModalCtrl
);

module.exports = deploymentsModule;
