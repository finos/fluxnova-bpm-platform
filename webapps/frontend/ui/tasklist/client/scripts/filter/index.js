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

/**
 * @module  cam.tasklist.filter
 * @belongsto cam.tasklist
 *
 * Filters are predefined filters for tasks.
 */

'use strict';

var angular = require('flowave-commons-ui/vendor/angular'),
  /* directives */
  fwTasklistFilters = require('./directives/fw-tasklist-filters'),
  fwTasklistFilterModalForm = require('./directives/fw-tasklist-filter-modal-form'),
  fwTasklistFilterModalFormGeneral = require('./directives/fw-tasklist-filter-modal-form-general'),
  fwTasklistFilterModalFormCriteria = require('./directives/fw-tasklist-filter-modal-form-criteria'),
  fwTasklistFilterModalFormVariable = require('./directives/fw-tasklist-filter-modal-form-variable'),
  fwTasklistFilterModalFormPermission = require('./directives/fw-tasklist-filter-modal-form-permission'),
  /* controllers */
  fwTasklistFiltersCtrl = require('./controllers/fw-tasklist-filters-ctrl'),
  /* modals */
  fwTasklistFilterModal = require('./modals/fw-tasklist-filter-modal');

var filterModule = angular.module('cam.tasklist.filter', ['ui.bootstrap']);

/* directives */
filterModule.directive('fwTasklistFilters', fwTasklistFilters);
filterModule.directive('fwTasklistFilterModalForm', fwTasklistFilterModalForm);
filterModule.directive(
  'fwTasklistFilterModalFormGeneral',
  fwTasklistFilterModalFormGeneral
);
filterModule.directive(
  'fwTasklistFilterModalFormCriteria',
  fwTasklistFilterModalFormCriteria
);
filterModule.directive(
  'fwTasklistFilterModalFormVariable',
  fwTasklistFilterModalFormVariable
);
filterModule.directive(
  'fwTasklistFilterModalFormPermission',
  fwTasklistFilterModalFormPermission
);

/* controllers */
filterModule.controller('fwFiltersCtrl', fwTasklistFiltersCtrl);

/* modals */
filterModule.controller('fwFilterModalCtrl', fwTasklistFilterModal);

module.exports = filterModule;
