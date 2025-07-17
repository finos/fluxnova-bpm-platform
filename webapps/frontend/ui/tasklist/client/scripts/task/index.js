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
  taskDirective = require('./directives/fw-tasklist-task'),
  taskMetaDirective = require('./directives/fw-tasklist-task-meta'),
  fwTaskActionCtrl = require('./controller/fw-tasklist-task-action-ctrl'),
  fwTaskGroupsCtrl = require('./controller/fw-tasklist-task-groups-ctrl'),
  /* detail plugins */
  fwTaskDetailFormPlugin = require('./plugins/detail/fw-tasklist-task-detail-form-plugin'),
  fwTaskDetailHistoryPlugin = require('./plugins/detail/fw-tasklist-task-detail-history-plugin'),
  fwTaskDetailDiagramPlugin = require('./plugins/detail/fw-tasklist-task-detail-diagram-plugin'),
  fwTaskDetailDescriptionPlugin = require('./plugins/detail/fw-tasklist-task-detail-description-plugin'),
  /* action plugins */
  fwTaskActionCommentPlugin = require('./plugins/action/fw-tasklist-task-action-comment-plugin'),
  /* action plugin controller */
  fwCommentCreateModalCtrl = require('./plugins/action/modals/fw-tasklist-comment-form'),
  /* modals */
  fwGroupEditModalCtrl = require('./modals/fw-tasklist-groups-modal'),
  /* API */
  apiClient = require('../api/index');

require('angular-ui-bootstrap');
require('angular-moment');

var taskModule = angular.module('cam.tasklist.task', [
  apiClient.name,
  'ui.bootstrap',
  'cam.tasklist.form',
  'angularMoment'
]);

/**
 * @module cam.tasklist.task
 */

/**
 * @memberof cam.tasklist
 */

taskModule.directive('fwTasklistTask', taskDirective);

taskModule.directive('fwTasklistTaskMeta', taskMetaDirective);

taskModule.controller('fwTaskActionCtrl', fwTaskActionCtrl);
taskModule.controller('fwTaskGroupsCtrl', fwTaskGroupsCtrl);

/* detail plugins */
taskModule.config(fwTaskDetailFormPlugin);
taskModule.config(fwTaskDetailHistoryPlugin);
taskModule.config(fwTaskDetailDiagramPlugin);
taskModule.config(fwTaskDetailDescriptionPlugin);

/* action plugins */
taskModule.config(fwTaskActionCommentPlugin);

/* action plugin controller */
taskModule.controller('fwCommentCreateModalCtrl', fwCommentCreateModalCtrl);

taskModule.controller('fwGroupEditModalCtrl', fwGroupEditModalCtrl);

module.exports = taskModule;
