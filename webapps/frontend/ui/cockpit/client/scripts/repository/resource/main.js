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
  /* controllers */
  fwResourceDetailsCtrl = require('./controllers/fw-cockpit-resource-details-ctrl'),
  /* directives */
  fwCockpitResourceWrapper = require('./directives/fw-cockpit-resource-wrapper'),
  fwCockpitResourceMeta = require('./directives/fw-cockpit-resource-meta'),
  fwCockpitResourceContent = require('./directives/fw-cockpit-resource-content'),
  fwCockpitHtmlSource = require('./directives/fw-cockpit-html-source'),
  fwCockpitSource = require('./directives/fw-cockpit-source'),
  fwCockpitForm = require('./directives/fw-cockpit-form'),
  /* plugins */
  fwCockpitDefinitionsPlugin = require('./plugins/details/definitions/fw-cockpit-definitions-plugin'),
  fwCockpitResourceDownloadPlugin = require('./plugins/actions/download/fw-cockpit-resource-action-download-plugin');

var resourceModule = angular.module('cam.cockpit.repository.resource', []);

/* controllers */
resourceModule.controller('fwResourceDetailsCtrl', fwResourceDetailsCtrl);

/* directives */
resourceModule.directive('fwResourceWrapper', fwCockpitResourceWrapper);
resourceModule.directive('fwResourceMeta', fwCockpitResourceMeta);
resourceModule.directive('fwResourceContent', fwCockpitResourceContent);
resourceModule.directive('fwForm', fwCockpitForm);
resourceModule.directive('fwSource', fwCockpitSource);
resourceModule.directive('fwHtmlSource', fwCockpitHtmlSource);

/* plugins */
resourceModule.config(fwCockpitDefinitionsPlugin);
resourceModule.config(fwCockpitResourceDownloadPlugin);

module.exports = resourceModule;
