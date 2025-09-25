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

var BaseClass = require('../../base-class');
var $ = require('./../dom-lib');

function noop() {}

/**
 * An abstract class for the form field controls
 *
 * @class AbstractFormField
 * @abstract
 * @memberof FxnSDK.form
 *
 */
function AbstractFormField(element, variableManager, fxnForm) {
  this.element = $(element);
  this.variableManager = variableManager;
  this.form = fxnForm;

  this.variableName = null;

  this.initialize();
}

/**
 * @memberof FxnSDK.form.AbstractFormField
 * @abstract
 * @name selector
 * @type {String}
 */
AbstractFormField.selector = null;

/**
 * @memberof FxnSDK.form.AbstractFormField
 * @borrows FxnSDK.BaseClass.extend as extend
 * @name extend
 * @type {Function}
 */
AbstractFormField.extend = BaseClass.extend;

/**
 * @memberof FxnSDK.form.AbstractFormField.prototype
 * @abstract
 * @method initialize
 */
AbstractFormField.prototype.initialize = noop;

/**
 * Applies the stored value to a field element.
 *
 * @memberof FxnSDK.form.AbstractFormField.prototype
 * @abstract
 * @method applyValue
 *
 * @return {FxnSDK.form.AbstractFormField} Chainable method
 */
AbstractFormField.prototype.applyValue = noop;

/**
 * @memberof FxnSDK.form.AbstractFormField.prototype
 * @abstract
 * @method getValue
 */
AbstractFormField.prototype.getValue = noop;

module.exports = AbstractFormField;
