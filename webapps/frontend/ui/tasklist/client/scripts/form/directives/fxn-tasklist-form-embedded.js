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

var template = require('./fxn-tasklist-form-embedded.html?raw');

var angular = require('fluxnova-commons-ui/vendor/angular');
var $ = require('jquery');

module.exports = [
  'FxnForm',
  'fxnAPI',
  '$timeout',
  'Uri',
  function(FxnForm, fxnAPI, $timeout, Uri) {
    return {
      restrict: 'A',

      require: '^fxnTasklistForm',

      scope: true,

      template: template,

      link: function($scope, $element, attrs, formController) {
        var container = $($element[0]).find('.form-container');
        var fxnForm = null;
        var initialVariables = null;
        var form = ($scope.form = {
          $valid: false,
          $invalid: true
        });

        function clearVariableManager() {
          var variables = fxnForm.variableManager.variables;
          for (var v in variables) {
            fxnForm.variableManager.destroyVariable(v);
          }
          // reset initial form variables
          fxnForm.variableManager.variables = angular.copy(initialVariables);
        }

        function handleAsynchronousFormKey(formInfo) {
          // asynchronousFormKey = formInfo;
          if (formInfo && formInfo.loaded) {
            showForm(container, formInfo, formController.getParams());
          }
          if (formInfo && formInfo.failure) {
            formController.notifyFormInitializationFailed(formInfo.error);
          }
        }

        $scope.$watch('asynchronousFormKey', handleAsynchronousFormKey, true);

        $scope.$watch(
          function() {
            return form && form.$valid;
          },
          function(value) {
            formController.notifyFormValidated(!value);
          }
        );

        // watch for changes in the form
        $scope.$watch(
          function() {
            return form && form.$dirty;
          },
          function(value) {
            formController.notifyFormDirty(value);
          }
        );

        function showForm(container, tasklistForm, params) {
          var formUrl = tasklistForm.key;

          params = angular.copy(params);

          delete params.processDefinitionKey;

          angular.extend(params, {
            urlParams: {
              userId: $scope.$root.authentication.name,
              engineName: Uri.appUri(':engine')
            },
            containerElement: container,
            client: fxnAPI,
            formUrl: formUrl,
            done: done
          });

          if (params.taskId) {
            // Only add URL Params if they have a value
            params.urlParams.taskId = params.taskId;
          }

          fxnForm = new FxnForm(params);
        }

        var done = function(err, _fxnForm) {
          if (err) {
            return formController.notifyFormInitializationFailed(err);
          }
          fxnForm = _fxnForm;
          initialVariables = angular.copy(fxnForm.variableManager.variables);

          var formName = _fxnForm.formElement.attr('name');
          var fxnFormScope = _fxnForm.formElement.scope();

          if (!fxnFormScope) {
            return;
          }

          form = fxnFormScope[formName];
          form.$setPristine();
          formController.notifyFormInitialized();

          $scope.$root.$broadcast('embedded.form.rendered');
        };

        $scope.$on('shortcut:focusForm', function() {
          if (fxnForm) {
            var focusElement = fxnForm.formElement[0].querySelectorAll(
              'input'
            )[0];
            if (focusElement) {
              focusElement.focus();
            }
          }
        });

        $scope.formKeyPressed = function formKeyPressed(e) {
          if (e.ctrlKey && (e.keyCode === 13 || e.keyCode === 10)) {
            return formController.attemptComplete();
          }
        };

        var localCallback = function(callback) {
          return function(err, result) {
            if (err) {
              clearVariableManager();
            }

            return callback(err, result);
          };
        };
        var complete = function(callback) {
          fxnForm.submit(localCallback(callback));
        };

        var save = function(evt) {
          form.$setPristine();
          fxnForm.store();

          // manually trigger a mouseleave event to make the tooltip disappear
          evt &&
            $timeout(function() {
              angular.element(evt.target).triggerHandler($.Event('mouseleave'));
            });
        };

        formController.registerCompletionHandler(complete);
        formController.registerSaveHandler(save);

        $scope.$on('authentication.login.required', function() {
          save();
        });
      }
    };
  }
];
