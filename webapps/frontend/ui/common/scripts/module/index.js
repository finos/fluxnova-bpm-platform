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

var angular = require('flowave-commons-ui/vendor/angular');

// Services
var isModuleAvailable = require('./services/is-module-available');
var exposeScopeProperties = require('./services/expose-scope-properties');
var loaders = require('./services/loaders');
var integrateActivityInstanceFilter = require('./services/integrate-activity-instance-filter');
var params = require('./services/params');
var createListQueryFunction = require('./services/create-list-query-function');
var createIsSearchQueryChangedFunction = require('./services/create-is-search-query-changed-function');
var readFiles = require('./services/read-files');
var upload = require('./services/upload');
var getDeploymentUrl = require('./services/get-deployment-url');
var isFileUploadSupported = require('./services/is-file-upload-supported');
var get = require('./services/get');
var pluginApi = require('../services/plugins/getApiAttributes');

// Components
var fwToolbar = require('./components/fw-toolbar');
var fwPagination = require('./components/fw-pagination');
var fwSearchableArea = require('./components/fw-searchable-area');
var fwTabs = require('./components/fw-tabs');

// Directives
var fwHoverArea = require('./directives/fw-hover-area');
var fwHoverTrigger = require('./directives/fw-hover-trigger');
var fwHoverableTitle = require('./directives/fw-hoverable-title');
var fwFile = require('./directives/fw-file');
var fwSortableTableHeader = require('./directives/fw-sortable-table-header');
var fwSortableTableColumn = require('./directives/fw-sortable-table-column');

// Controllers
var HoverAreaController = require('./controllers/hover-area');
var FwPaginationController = require('./controllers/fw-pagination');
var FwTabsController = require('./controllers/fw-tabs');
var FwPaginationSearchIntegrationController = require('./controllers/fw-pagination-search-integration');

// Values
var routeUtil = require('../util/routeUtil');
var paginationUtils = require('../util/pagination-utils');
var searchWidgetUtils = require('../util/search-widget-utils');

// Optional Modules
var externalTasksCommon = require('./external-tasks-common');

var ngModule = angular.module('fw-common', [externalTasksCommon.name]);

// Services
ngModule.factory('isModuleAvailable', isModuleAvailable);
ngModule.factory('exposeScopeProperties', exposeScopeProperties);
ngModule.factory('Loaders', loaders);
ngModule.factory(
  'integrateActivityInstanceFilter',
  integrateActivityInstanceFilter
);
ngModule.factory('params', params);
ngModule.factory('createListQueryFunction', createListQueryFunction);
ngModule.factory(
  'createIsSearchQueryChangedFunction',
  createIsSearchQueryChangedFunction
);
ngModule.factory('readFiles', readFiles);
ngModule.factory('upload', upload);
ngModule.factory('getDeploymentUrl', getDeploymentUrl);
ngModule.factory('isFileUploadSupported', isFileUploadSupported);
ngModule.factory('get', get);
ngModule.factory('getPluginApiAttributes', () => pluginApi);

// Components
ngModule.directive('fwToolbar', fwToolbar);
ngModule.directive('fwPagination', fwPagination);
ngModule.directive('fwSearchableArea', fwSearchableArea);
ngModule.directive('fwTabs', fwTabs);

// Directives
ngModule.directive('fwHoverArea', fwHoverArea);
ngModule.directive('fwHoverTrigger', fwHoverTrigger);
ngModule.directive('fwHoverableTitle', fwHoverableTitle);
ngModule.directive('fwFile', fwFile);
ngModule.directive('fwSortableTableHeader', fwSortableTableHeader);
ngModule.directive('fwSortableTableColumn', fwSortableTableColumn);

// Controllers
ngModule.controller('HoverAreaController', HoverAreaController);
ngModule.controller('FwPaginationController', FwPaginationController);
ngModule.controller('FwTabsController', FwTabsController);
ngModule.controller(
  'FwPaginationSearchIntegrationController',
  FwPaginationSearchIntegrationController
);

// Values
ngModule.value('routeUtil', routeUtil);
ngModule.value('paginationUtils', paginationUtils);
ngModule.value('searchWidgetUtils', searchWidgetUtils);

module.exports = ngModule;
