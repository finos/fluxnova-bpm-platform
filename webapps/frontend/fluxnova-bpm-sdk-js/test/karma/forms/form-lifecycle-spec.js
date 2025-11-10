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

var FxnSDK = require('../../../lib/index-browser.js');

var request = require('superagent');
var mockConfig = require('../../superagent-mock-config');

describe('The form', function() {
  /* global jQuery: false */

  var $ = jQuery;
  var $simpleFormDoc;
  var fxnClient, procDef;

  var superagentMock;
  before(function() {
    superagentMock = require('superagent-mock')(request, mockConfig);
  });

  after(function() {
    superagentMock.unset();
  });

  before(function(done) {
    jQuery.ajax('/base/test/karma/forms/form-lifecycle.html', {
      success: function(data) {
        $simpleFormDoc = jQuery('<div id="test-form">' + data + '</div>');
        // the following lines allow to see the form in the browser
        var _$top = $(top.document);
        _$top.find('#test-form').remove();
        _$top.find('#browsers').after($simpleFormDoc);

        fxnClient = new FxnSDK.Client({
          apiUri: 'engine-rest/engine'
        });

        done();
      },

      error: done
    });
  });

  it('prepares the testing environemnt', function() {
    expect(FxnSDK).to.be.an('object');

    expect(fxnClient).to.be.ok;
  });

  it('needs a process definition', function(done) {
    fxnClient.resource('process-definition').list({}, function(err, result) {
      if (err) {
        return done(err);
      }

      procDef = result.items.pop();

      expect(procDef.id).to.be.ok;

      done();
    });
  });

  it('gets the process definition with a promise', function() {
    return fxnClient
      .resource('process-definition')
      .list({})
      .then(function(result) {
        procDef = result.items.pop();
        expect(procDef.id).to.be.ok;
      });
  });

  it('initialize', function(done) {
    function ready(err) {
      if (err) {
        return done(err);
      }

      // expect variable created by script to be present
      var customVar = fxnForm.variableManager.variable('customVar');
      expect(customVar.name).to.eql('customVar');
      expect(customVar.type).to.eql('String');

      // expect form field to be populated
      expect($('#customField', fxnForm.formElement).val()).to.eql('someValue');

      // given that we do not change the value of the custom field
      fxnForm.submit();

      // we expect the submit callback to prevent the submit of the form
      expect(fxnForm.submitPrevented).to.be.ok;

      // if we change the value of the form field
      $('#customField', fxnForm.formElement).val('updated');

      // and re-attempt submit
      fxnForm.submit();

      // we expect the submit to pass
      expect(fxnForm.submitPrevented).to.not.be.ok;

      done();
    }

    var fxnForm = new FxnSDK.Form({
      client: fxnClient,
      processDefinitionId: procDef.id,
      formElement: $simpleFormDoc.find('form[fxn-form]'),
      done: function() {
        window.setTimeout(ready);
      }
    });
  });
});
