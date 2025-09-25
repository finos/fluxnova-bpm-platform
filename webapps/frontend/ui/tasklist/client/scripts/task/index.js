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
  taskDirective = require('./directives/fxn-tasklist-task'),
  taskMetaDirective = require('./directives/fxn-tasklist-task-meta'),
  fxnTaskActionCtrl = require('./controller/fxn-tasklist-task-action-ctrl'),
  fxnTaskGroupsCtrl = require('./controller/fxn-tasklist-task-groups-ctrl'),
  /* detail plugins */
  fxnTaskDetailFormPlugin = require('./plugins/detail/fxn-tasklist-task-detail-form-plugin'),
  fxnTaskDetailHistoryPlugin = require('./plugins/detail/fxn-tasklist-task-detail-history-plugin'),
  fxnTaskDetailDiagramPlugin = require('./plugins/detail/fxn-tasklist-task-detail-diagram-plugin'),
  fxnTaskDetailDescriptionPlugin = require('./plugins/detail/fxn-tasklist-task-detail-description-plugin'),
  /* action plugins */
  fxnTaskActionCommentPlugin = require('./plugins/action/fxn-tasklist-task-action-comment-plugin'),
  /* action plugin controller */
  fxnCommentCreateModalCtrl = require('./plugins/action/modals/fxn-tasklist-comment-form'),
  /* modals */
  fxnGroupEditModalCtrl = require('./modals/fxn-tasklist-groups-modal'),
  /* API */
  apiClient = require('../api/index');

require('angular-ui-bootstrap');
require('angular-moment');

var taskModule = angular.module('fxn.tasklist.task', [
  apiClient.name,
  'ui.bootstrap',
  'fxn.tasklist.form',
  'angularMoment'
]);

/**
 * @module cam.tasklist.task
 */

/**
 * @memberof cam.tasklist
 */

taskModule.directive('fxnTasklistTask', taskDirective);

taskModule.directive('fxnTasklistTaskMeta', taskMetaDirective);

taskModule.controller('fxnTaskActionCtrl', fxnTaskActionCtrl);
taskModule.controller('fxnTaskGroupsCtrl', fxnTaskGroupsCtrl);

/* detail plugins */
taskModule.config(fxnTaskDetailFormPlugin);
taskModule.config(fxnTaskDetailHistoryPlugin);
taskModule.config(fxnTaskDetailDiagramPlugin);
taskModule.config(fxnTaskDetailDescriptionPlugin);

/* action plugins */
taskModule.config(fxnTaskActionCommentPlugin);

/* action plugin controller */
taskModule.controller('fxnCommentCreateModalCtrl', fxnCommentCreateModalCtrl);

taskModule.controller('fxnGroupEditModalCtrl', fxnGroupEditModalCtrl);

module.exports = taskModule;
