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
  fxnTasklistForm = require('./directives/fxn-tasklist-form'),
  fxnTasklistFormGeneric = require('./directives/fxn-tasklist-form-generic'),
  fxnTasklistFormGenericVariables = require('./directives/fxn-tasklist-form-generic-variables'),
  fxnTasklistFormEmbedded = require('./directives/fxn-tasklist-form-embedded'),
  fxnTasklistFormExternal = require('./directives/fxn-tasklist-form-external'),
  fxnTasklistFormFluxnova = require('./directives/fxn-tasklist-form-fluxnova'),
  fxnTasklistUniqueValue = require('./directives/fxn-tasklist-unique-value');

var formModule = angular.module('fxn.tasklist.form', ['ui.bootstrap']);

formModule.directive('fxnTasklistForm', fxnTasklistForm);
formModule.directive('fxnTasklistFormGeneric', fxnTasklistFormGeneric);
formModule.directive(
  'fxnTasklistFormGenericVariables',
  fxnTasklistFormGenericVariables
);
formModule.directive('fxnTasklistFormEmbedded', fxnTasklistFormEmbedded);
formModule.directive('fxnTasklistFormExternal', fxnTasklistFormExternal);
formModule.directive('fxnTasklistFormFluxnova', fxnTasklistFormFluxnova);

formModule.directive('fxnUniqueValue', fxnTasklistUniqueValue);

module.exports = formModule;
