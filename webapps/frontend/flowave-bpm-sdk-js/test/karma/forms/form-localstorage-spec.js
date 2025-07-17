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

var FwSDK = require('../../../lib/index-browser.js');

var request = require('superagent');
var mockConfig = require('../../superagent-mock-config');

describe('The local storage', function() {
  /* global jQuery: false */

  var $ = jQuery;
  var $simpleFormDoc;
  var fwClient;
  var testProcessId = '__test__';

  var superagentMock;
  before(function() {
    superagentMock = require('superagent-mock')(request, mockConfig);
  });

  after(function() {
    superagentMock.unset();
  });

  before(function(done) {
    jQuery.ajax('/base/test/karma/forms/form-localstorage.html', {
      success: function(data) {
        $simpleFormDoc = jQuery('<div id="test-form">'+ data +'</div>');
        // the following lines allow to see the form in the browser
        var _$top = $(top.document);
        _$top.find('#test-form').remove();
        _$top.find('#browsers').after($simpleFormDoc);

        fwClient = new FwSDK.Client({
          apiUri: 'engine-rest/engine'
        });

        done();
      },

      error: done
    });
  });



  it('stores', function(done) {
    var fwForm;

    localStorage.removeItem('fwForm:'+ testProcessId);

    function ready(err) {
      if (err) { return done(err); }

      expect(fwForm.isRestorable()).not.to.be.ok;

      $('#stringVar', fwForm.formElement).val('stringValue');

      fwForm.store();

      var storedVars;
      try {
        storedVars = JSON.parse(localStorage.getItem('fwForm:'+ testProcessId)).vars;
      }
      catch (e) {
        return done(e);
      }

      expect(storedVars.stringVar).to.eql('stringValue');

      expect(fwForm.isRestorable()).to.be.ok;

      done();
    }

    fwForm = new FwSDK.Form({
      client: fwClient,
      processDefinitionId: testProcessId,
      formElement: $simpleFormDoc.find('form[fw-form]'),
      done: function() {window.setTimeout(ready);}
    });
  });


  it('restores', function(done) {
    var fwForm;

    localStorage.setItem('fwForm:'+ testProcessId, JSON.stringify({
      vars: {
        stringVar: 'fromStorage'
      }
    }));

    function ready(err) {
      if (err) { return done(err); }

      expect(fwForm.isRestorable()).to.be.ok;

      fwForm.restore();

      expect(fwForm.variableManager.variables.stringVar).to.be.ok;

      fwForm.applyVariables();

      expect($('#stringVar', fwForm.formElement).val()).to.eql('fromStorage');

      done();
    }

    fwForm = new FwSDK.Form({
      client: fwClient,
      processDefinitionId: testProcessId,
      formElement: $simpleFormDoc.find('form[fw-form]'),
      done: function() {window.setTimeout(ready);}
    });
  });


  describe('handling on submission', function() {
    it('is kept upon failed response from server', function(done) {
      var fwForm;

      function ready(err) {
        if (err) { return done(err); }

        fwForm.submitVariables = function(cb) {
          cb(new Error('Murphy inna di place'), {});
        };

        // given a failed form submission
        fwForm.submit(function(_err) {
          expect(_err).to.be.ok;

          expect(localStorage.getItem('fwForm:'+ testProcessId)).to.be.ok;

          done();
        });
      }

      localStorage.setItem('fwForm:'+ testProcessId, JSON.stringify({
        date: 1467107571159,
        vars: {
          stringVar: 'fromStorage'
        }
      }));

      fwForm = new FwSDK.Form({
        client: fwClient,
        processDefinitionId: testProcessId,
        formElement: $simpleFormDoc.find('form[fw-form]'),
        done: function() {window.setTimeout(ready);}
      });
    });


    it('is wiped upon successful response from server', function(done) {
      var fwForm;

      function ready(err) {
        if (err) { return done(err); }

        fwForm.submitVariables = function(cb) {
          cb();
        };


        // given a successful form submission
        fwForm.submit(function(_err) {
          expect(_err).not.to.be.ok;

          expect(localStorage.getItem('fwForm:'+ testProcessId)).not.to.be.ok;

          done();
        });
      }

      localStorage.setItem('fwForm:'+ testProcessId, JSON.stringify({
        date: 1467107571159,
        vars: {
          stringVar: 'fromStorage'
        }
      }));

      fwForm = new FwSDK.Form({
        client: fwClient,
        processDefinitionId: testProcessId,
        formElement: $simpleFormDoc.find('form[fw-form]'),
        done: function() {window.setTimeout(ready);}
      });
    });
  });
});
