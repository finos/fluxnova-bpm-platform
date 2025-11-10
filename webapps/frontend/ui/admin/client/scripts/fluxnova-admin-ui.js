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

if (process.env.NODE_ENV === 'development') {
  require('../../../common/scripts/util/dev-setup').setupDev();
}

// DOM Polyfills
require('dom4');

var $ = (window.jQuery = window.$ = require('jquery')),
  pagesModule = require('./pages/main'),
  directivesModule = require('./directives/main'),
  filtersModule = require('./filters/main'),
  servicesModule = require('./services/main'),
  resourcesModule = require('./resources/main'),
  fxnCommonsUi = require('fluxnova-commons-ui/lib'),
  sdk = require('fluxnova-bpm-sdk-js/lib/angularjs/index'),
  angular = require('fluxnova-commons-ui/vendor/angular'),
  fxnCommon = require('../../../common/scripts/module'),
  lodash = require('fluxnova-commons-ui/vendor/lodash'),
  moment = require('fluxnova-commons-ui/vendor/moment');
const translatePaginationCtrls = require('../../../common/scripts/util/translate-pagination-ctrls');

var APP_NAME = 'fxn.admin';

export function init(pluginDependencies) {
  var ngDependencies = [
    'ng',
    'ngResource',
    'pascalprecht.translate',
    fxnCommonsUi.name,
    directivesModule.name,
    filtersModule.name,
    pagesModule.name,
    resourcesModule.name,
    servicesModule.name
  ].concat(
    pluginDependencies.map(function(el) {
      return el.ngModuleName;
    })
  );

  var appNgModule = angular.module(APP_NAME, ngDependencies);

  function getUri(id) {
    var uri = $('base').attr(id);
    if (!id) {
      throw new Error('Uri base for ' + id + ' could not be resolved');
    }

    return uri;
  }

  var ModuleConfig = [
    '$routeProvider',
    'UriProvider',
    '$uibModalProvider',
    '$uibTooltipProvider',
    '$locationProvider',
    '$animateProvider',
    '$qProvider',
    '$provide',
    function(
      $routeProvider,
      UriProvider,
      $modalProvider,
      $tooltipProvider,
      $locationProvider,
      $animateProvider,
      $qProvider,
      $provide
    ) {
      translatePaginationCtrls($provide);
      $routeProvider.otherwise({redirectTo: '/'});

      UriProvider.replace(':appRoot', getUri('app-root'));
      UriProvider.replace(':appName', 'admin');
      UriProvider.replace('app://', getUri('href'));
      UriProvider.replace(
        'monitoringbase://',
        getUri('app-root') + '/app/monitoring/'
      );
      UriProvider.replace('admin://', getUri('admin-api'));
      UriProvider.replace('plugin://', getUri('admin-api') + 'plugin/');
      UriProvider.replace('engine://', getUri('engine-api'));

      UriProvider.replace(':engine', [
        '$window',
        function($window) {
          var uri = $window.location.href;

          var match = uri.match(/\/app\/admin\/([\w-]+)(|\/)/);
          if (match) {
            return match[1];
          } else {
            throw new Error('no process engine selected');
          }
        }
      ]);

      $modalProvider.options = {
        animation: true,
        backdrop: true,
        keyboard: true
      };

      $tooltipProvider.options({
        animation: true,
        popupDelay: 100,
        appendToBody: true
      });

      $locationProvider.hashPrefix('');

      $animateProvider.classNameFilter(/angular-animate/);

      $qProvider.errorOnUnhandledRejections(DEV_MODE); // eslint-disable-line
    }
  ];

  appNgModule.provider(
    'configuration',
    require('./../../../common/scripts/services/fxn-configuration')(
      window.fxnAdminConf,
      'Admin'
    )
  );

  appNgModule.config(ModuleConfig);

  require('./../../../common/scripts/services/locales')(
    appNgModule,
    getUri('app-root'),
    'admin'
  );

  appNgModule.controller('fxnAdminAppCtrl', [
    '$scope',
    '$route',
    'fxnAPI',
    function($scope, $route, fxnAPI) {
      var userService = fxnAPI.resource('user');

      function getUserProfile(auth) {
        if (!auth || !auth.name) {
          $scope.userFullName = null;
          return;
        }

        userService.profile(auth.name, function(err, info) {
          if (!err) {
            $scope.userFullName = info.firstName + ' ' + info.lastName;
          }
        });
      }

      $scope.$on('authentication.changed', function(ev, auth) {
        if (auth) {
          getUserProfile(auth);
        } else {
          $route.reload();
        }
      });

      getUserProfile($scope.authentication);
    }
  ]);

  require('../../../common/scripts/services/plugins/addPlugins')(
    window.fxnAdminConf,
    appNgModule,
    'admin'
  ).then(() => {
    $(document).ready(function() {
      angular.bootstrap(document.documentElement, [
        appNgModule.name,
        'fxn.admin.custom'
      ]);

      if (top !== window) {
        window.parent.postMessage({type: 'loadamd'}, '*');
      }
    });
  });
}

export function exposePackages(requirePackages) {
  requirePackages.angular = angular;
  requirePackages.jquery = $;
  requirePackages['fluxnova-commons-ui'] = fxnCommonsUi;
  requirePackages['fluxnova-bpm-sdk-js'] = sdk;
  requirePackages['fxn-common'] = fxnCommon;
  requirePackages['lodash'] = lodash;
  requirePackages['moment'] = moment;
}
