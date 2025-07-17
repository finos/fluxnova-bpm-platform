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

var template = require('./fw-tasklist-form-generic.html?raw');

var angular = require('flowave-commons-ui/vendor/angular');
var $ = require('jquery');

module.exports = [
  'FwForm',
  'fwAPI',
  '$timeout',
  function(FwForm, fwAPI, $timeout) {
    return {
      restrict: 'A',

      require: '^fwTasklistForm',

      scope: true,

      template: template,

      link: function($scope, $element, attrs, formController) {
        var formElement = $($element[0]).find('form');
        var fwForm = ($scope.fwForm = null);
        var form = {
          $valid: false,
          $invalid: true
        };

        var $update = false;

        $scope.$watch(
          function() {
            return $update;
          },
          function(value) {
            if (value) {
              showForm(value, formController.getParams());
              $update = false;
            }
          }
        );

        $scope.$watch(
          function() {
            return formController.getTasklistForm();
          },
          function(value) {
            if (value) {
              $update = true;
              $scope.variables = [];
            }
          }
        );

        $scope.$watch(
          function() {
            return form && form.$valid;
          },
          function(value) {
            formController.notifyFormValidated(!value);
          }
        );

        function showForm(tasklistForm, params) {
          params = angular.copy(params);

          delete params.processDefinitionKey;

          angular.extend(params, {
            client: fwAPI,
            formElement: formElement,
            done: done
          });

          $scope.fwForm = fwForm = new FwForm(params);
        }

        var done = function(err, _fwForm) {
          if (err) {
            return formController.notifyFormInitializationFailed(err);
          }
          fwForm = _fwForm;

          var formName = _fwForm.formElement.attr('name');
          var fwFormScope = _fwForm.formElement.scope();

          if (!fwFormScope) {
            return;
          }

          form = fwFormScope[formName];
          formController.notifyFormInitialized();

          if ($scope.options.autoFocus) {
            $timeout(function() {
              var focusElement = _fwForm.formElement[0].querySelectorAll(
                'input'
              )[0];
              if (focusElement) {
                focusElement.focus();
              }
            });
          }
        };

        function clearVariableManager() {
          var variables = fwForm.variableManager.variables;
          for (var v in variables) {
            fwForm.variableManager.destroyVariable(v);
          }
        }

        function clearFields() {
          fwForm.fields = [];
        }

        var complete = function(callback) {
          function localCallback(error, result) {
            clearVariableManager();
            clearFields();
            return callback(error, result);
          }

          try {
            fwForm.initializeFieldHandlers();
          } catch (error) {
            return localCallback(error);
          }

          var variables = fwForm.variableManager.variables;
          for (var v in variables) {
            variables[v].value = null;
          }

          $scope.variables
            .filter(el => el.type === 'Object')
            .forEach(el => {
              fwForm.variableManager.createVariable({
                name: el.name,
                type: 'Object',
                value: el.value,
                valueInfo: el.valueInfo
              });
            });

          fwForm.submit(localCallback);
        };

        formController.registerCompletionHandler(complete);
      }
    };
  }
];
