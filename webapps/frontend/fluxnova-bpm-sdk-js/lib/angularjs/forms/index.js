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

var angular = require('angular'),
  FluxnovaFormAngular = require('./fluxnova-form-angular'),
  isType = require('./../../forms/type-util').isType;

// define embedded forms angular module
var ngModule = angular.module('fxn.embedded.forms', []);

/**
 * Exposes 'fxn-variable-name' as angular directive making sure
 * that updates to a HTML Control made through the camunda form
 * infrastructure are propagated over ngModel bindings.
 */
ngModule.directive('fxnVariableName', [
  '$rootScope',
  function($rootScope) {
    return {
      require: 'ngModel',
      link: function(scope, elm, attrs, ctrl) {
        elm.on('fxnFormVariableApplied', function(evt, value) {
          var phase = $rootScope.$$phase;
          // only apply if not already in digest / apply
          if (phase !== '$apply' && phase !== '$digest') {
            scope.$apply(function() {
              ctrl.$setViewValue(value);
            });
          } else {
            ctrl.$setViewValue(value);
          }
        });
      }
    };
  }
]);

ngModule.directive('fxnVariableType', [
  function() {
    return {
      require: 'ngModel',
      link: function($scope, $element, $attrs, ctrl) {
        var validate = function(viewValue) {
          var type = $attrs.fxnVariableType;

          ctrl.$setValidity('fxnVariableType', true);

          if (viewValue || viewValue === false || type === 'Bytes') {
            if (
              ['Boolean', 'String', 'Bytes'].indexOf(type) === -1 &&
              !isType(viewValue, type)
            ) {
              ctrl.$setValidity('fxnVariableType', false);
            }

            if (
              $attrs.type === 'file' &&
              type === 'Bytes' &&
              $element[0].files &&
              $element[0].files[0] &&
              $element[0].files[0].size > ($attrs.fxnMaxFilesize || 5000000)
            ) {
              ctrl.$setValidity('fxnVariableType', false);
            }
          }

          return viewValue;
        };

        ctrl.$parsers.unshift(validate);
        ctrl.$formatters.push(validate);

        $attrs.$observe('fxnVariableType', function() {
          return validate(ctrl.$viewValue);
        });

        $element.bind('change', function() {
          validate(ctrl.$viewValue);
          $scope.$apply();
        });
      }
    };
  }
]);

module.exports = FluxnovaFormAngular;
