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

var angular = require('fluxnova-bpm-sdk-js/vendor/angular'),
  annotationEdit = require('./annotation/fxn-annotation-edit'),
  inlineField = require('./inline-field/fxn-widget-inline-field'),
  searchPill = require('./search-pill/fxn-widget-search-pill'),
  fxnQueryComponent = require('./search-pill/fxn-query-component'),
  header = require('./header/fxn-widget-header'),
  footer = require('./footer/fxn-widget-footer'),
  loader = require('./loader/fxn-widget-loader'),
  chartLine = require('./chart-line/fxn-widget-chart-line'),
  debug = require('./debug/fxn-widget-debug'),
  clipboard = require('./clipboard/fxn-widget-clipboard'),
  variable = require('./variable/fxn-widget-variable'),
  variablesTable = require('./variables-table/fxn-widget-variables-table'),
  fxnRenderVarTemplate = require('./variables-table/fxn-render-var-template'),
  search = require('./search/fxn-widget-search'),
  bpmnViewer = require('./bpmn-viewer/fxn-widget-bpmn-viewer'),
  cmmnViewer = require('./cmmn-viewer/fxn-widget-cmmn-viewer'),
  dmnViewer = require('./dmn-viewer/fxn-widget-dmn-viewer'),
  filtersModule = require('../filter/date/index'),
  directivesModule = require('../directives/index'),
  searchModule = require('../search/index'),
  variableValidator = require('./variable/fxn-variable-validator'),
  localConf = require('./../services/fxn-local-configuration'),
  fxnShareLink = require('./fxn-share-link/fxn-share-link'),
  password = require('./password/fxn-widget-password'),
  selectionType = require('./selection-type/fxn-widget-selection-type');

require('angular-ui-bootstrap');

var widgetModule = angular.module('fluxnova.common.widgets', [
  filtersModule.name,
  directivesModule.name,
  searchModule.name,
  'ui.bootstrap'
]);

widgetModule.factory('widgetLocalConf', localConf);
widgetModule.directive('fxnWidgetInlineField', inlineField);
widgetModule.directive('fxnWidgetSearchPill', searchPill);
widgetModule.directive('fxnWidgetHeader', header);
widgetModule.directive('fxnWidgetFooter', footer);
widgetModule.directive('fxnWidgetLoader', loader);
widgetModule.directive('fxnWidgetChartLine', chartLine);
widgetModule.directive('fxnWidgetDebug', debug);
widgetModule.directive('fxnWidgetClipboard', clipboard);
widgetModule.directive('fxnWidgetVariable', variable);
widgetModule.directive('fxnWidgetVariablesTable', variablesTable);
widgetModule.directive('fxnRenderVarTemplate', fxnRenderVarTemplate);
widgetModule.directive('fxnWidgetSearch', search);
widgetModule.directive('fxnWidgetBpmnViewer', bpmnViewer);
widgetModule.directive('fxnWidgetCmmnViewer', cmmnViewer);
widgetModule.directive('fxnWidgetDmnViewer', dmnViewer);
widgetModule.directive('fxnShareLink', fxnShareLink);
widgetModule.directive('fxnWidgetPassword', password);

widgetModule.directive('fxnVariableValidator', variableValidator);
widgetModule.directive('fxnAnnotationEdit', annotationEdit);

widgetModule.directive('fxnWidgetSelectionType', selectionType);

widgetModule.filter('fxnQueryComponent', fxnQueryComponent);

module.exports = widgetModule;
