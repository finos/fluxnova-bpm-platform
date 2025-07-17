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
  FwSDK = require('flowave-bpm-sdk-js/lib/angularjs/index');

var apiModule = angular.module('cam.tasklist.client', []);

apiModule.value('HttpClient', FwSDK.Client);

apiModule.value('FwForm', FwSDK.Form);

apiModule.factory('fwAPI', [
  'fwAPIHttpClient',
  '$window',
  'Uri',
  function(fwAPIHttpClient, $window, Uri) {
    var conf = {
      apiUri: 'engine-rest/api/engine',
      HttpClient: fwAPIHttpClient,
      engine: Uri.appUri(':engine')
    };
    if ($window.tasklistConf) {
      for (var c in $window.tasklistConf) {
        conf[c] = $window.tasklistConf[c];
      }
    }

    return new FwSDK.Client(conf);
  }
]);

module.exports = apiModule;
