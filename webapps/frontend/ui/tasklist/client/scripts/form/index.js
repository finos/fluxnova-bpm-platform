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
  fwTasklistForm = require('./directives/fw-tasklist-form'),
  fwTasklistFormGeneric = require('./directives/fw-tasklist-form-generic'),
  fwTasklistFormGenericVariables = require('./directives/fw-tasklist-form-generic-variables'),
  fwTasklistFormEmbedded = require('./directives/fw-tasklist-form-embedded'),
  fwTasklistFormExternal = require('./directives/fw-tasklist-form-external'),
  fwTasklistFormCamunda = require('./directives/fw-tasklist-form-flowave'),
  fwTasklistUniqueValue = require('./directives/fw-tasklist-unique-value');

var formModule = angular.module('cam.tasklist.form', ['ui.bootstrap']);

formModule.directive('fwTasklistForm', fwTasklistForm);
formModule.directive('fwTasklistFormGeneric', fwTasklistFormGeneric);
formModule.directive(
  'fwTasklistFormGenericVariables',
  fwTasklistFormGenericVariables
);
formModule.directive('fwTasklistFormEmbedded', fwTasklistFormEmbedded);
formModule.directive('fwTasklistFormExternal', fwTasklistFormExternal);
formModule.directive('fwTasklistFormCamunda', fwTasklistFormCamunda);

formModule.directive('fwUniqueValue', fwTasklistUniqueValue);

module.exports = formModule;
