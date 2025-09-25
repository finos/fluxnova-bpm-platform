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
  FxnSDK = require('fluxnova-bpm-sdk-js/lib/angularjs/index');

var apiModule = angular.module('fxn.tasklist.client', []);

apiModule.value('HttpClient', FxnSDK.Client);

apiModule.value('FxnForm', FxnSDK.Form);

apiModule.factory('fxnAPI', [
  'fxnAPIHttpClient',
  '$window',
  'Uri',
  function(fxnAPIHttpClient, $window, Uri) {
    var conf = {
      apiUri: 'engine-rest/api/engine',
      HttpClient: fxnAPIHttpClient,
      engine: Uri.appUri(':engine')
    };
    if ($window.tasklistConf) {
      for (var c in $window.tasklistConf) {
        conf[c] = $window.tasklistConf[c];
      }
    }

    return new FxnSDK.Client(conf);
  }
]);

module.exports = apiModule;
