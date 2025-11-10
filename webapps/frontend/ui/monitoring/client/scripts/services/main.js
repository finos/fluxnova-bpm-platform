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
  transform = require('./transform'),
  variables = require('./variables'),
  breadcrumbTrails = require('./breadcrumbTrails'),
  queryMaxResults = require('./query-max-results'),
  variableUtils = require('./variable-utils'),
  routeUtil = require('./../../../../common/scripts/services/routeUtil'),
  page = require('./../../../../common/scripts/services/page'),
  fxnAPI = require('./../../../../common/scripts/services/fxn-api'),
  hasPlugin = require('./../../../../common/scripts/services/has-plugin'),
  localConf = require('fluxnova-commons-ui/lib/services/fxn-local-configuration'),
  typeUtils = require('./../../../../common/scripts/services/typeUtils'),
  escapeHtml = require('./escapeHtml');

var servicesModule = angular.module('fxn.monitoring.services', []);

servicesModule.factory('Transform', transform);
servicesModule.factory('Variables', variables);
servicesModule.service('page', page);
servicesModule.factory('breadcrumbTrails', breadcrumbTrails);
servicesModule.factory('queryMaxResults', queryMaxResults);
servicesModule.factory('varUtils', variableUtils);
servicesModule.factory('routeUtil', routeUtil);
servicesModule.factory('fxnAPI', fxnAPI);
servicesModule.factory('hasPlugin', hasPlugin);
servicesModule.factory('localConf', localConf);
servicesModule.factory('typeUtils', typeUtils);
servicesModule.factory('escapeHtml', escapeHtml);

module.exports = servicesModule;
