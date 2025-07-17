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

var angular = require('flowave-bpm-sdk-js/vendor/angular'),
  annotationEdit = require('./annotation/fw-annotation-edit'),
  inlineField = require('./inline-field/fw-widget-inline-field'),
  searchPill = require('./search-pill/fw-widget-search-pill'),
  fwQueryComponent = require('./search-pill/fw-query-component'),
  header = require('./header/fw-widget-header'),
  footer = require('./footer/fw-widget-footer'),
  loader = require('./loader/fw-widget-loader'),
  chartLine = require('./chart-line/fw-widget-chart-line'),
  debug = require('./debug/fw-widget-debug'),
  clipboard = require('./clipboard/fw-widget-clipboard'),
  variable = require('./variable/fw-widget-variable'),
  variablesTable = require('./variables-table/fw-widget-variables-table'),
  fwRenderVarTemplate = require('./variables-table/fw-render-var-template'),
  search = require('./search/fw-widget-search'),
  bpmnViewer = require('./bpmn-viewer/fw-widget-bpmn-viewer'),
  cmmnViewer = require('./cmmn-viewer/fw-widget-cmmn-viewer'),
  dmnViewer = require('./dmn-viewer/fw-widget-dmn-viewer'),
  filtersModule = require('../filter/date/index'),
  directivesModule = require('../directives/index'),
  searchModule = require('../search/index'),
  variableValidator = require('./variable/fw-variable-validator'),
  localConf = require('./../services/fw-local-configuration'),
  fwShareLink = require('./fw-share-link/fw-share-link'),
  password = require('./password/fw-widget-password'),
  selectionType = require('./selection-type/fw-widget-selection-type');

require('angular-ui-bootstrap');

var widgetModule = angular.module('camunda.common.widgets', [
  filtersModule.name,
  directivesModule.name,
  searchModule.name,
  'ui.bootstrap'
]);

widgetModule.factory('widgetLocalConf', localConf);
widgetModule.directive('fwWidgetInlineField', inlineField);
widgetModule.directive('fwWidgetSearchPill', searchPill);
widgetModule.directive('fwWidgetHeader', header);
widgetModule.directive('fwWidgetFooter', footer);
widgetModule.directive('fwWidgetLoader', loader);
widgetModule.directive('fwWidgetChartLine', chartLine);
widgetModule.directive('fwWidgetDebug', debug);
widgetModule.directive('fwWidgetClipboard', clipboard);
widgetModule.directive('fwWidgetVariable', variable);
widgetModule.directive('fwWidgetVariablesTable', variablesTable);
widgetModule.directive('fwRenderVarTemplate', fwRenderVarTemplate);
widgetModule.directive('fwWidgetSearch', search);
widgetModule.directive('fwWidgetBpmnViewer', bpmnViewer);
widgetModule.directive('fwWidgetCmmnViewer', cmmnViewer);
widgetModule.directive('fwWidgetDmnViewer', dmnViewer);
widgetModule.directive('fwShareLink', fwShareLink);
widgetModule.directive('fwWidgetPassword', password);

widgetModule.directive('fwVariableValidator', variableValidator);
widgetModule.directive('fwAnnotationEdit', annotationEdit);

widgetModule.directive('fwWidgetSelectionType', selectionType);

widgetModule.filter('fwQueryComponent', fwQueryComponent);

module.exports = widgetModule;
