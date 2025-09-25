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
  fxnNavbarActionStartProcessPlugin = require('./plugins/action/fxn-tasklist-navbar-action-start-process-plugin'),
  fxnProcessStartModalCtrl = require('./plugins/action/modals/fxn-tasklist-process-start-modal');

var processModule = angular.module('fxn.tasklist.process', [
  'fxn.tasklist.client',
  'fxn.tasklist.form',
  'ui.bootstrap'
]);

/* action plugins */
processModule.config(fxnNavbarActionStartProcessPlugin);

/* action plugin controller */
processModule.controller('fxnProcessStartModalCtrl', fxnProcessStartModalCtrl);

module.exports = processModule;
