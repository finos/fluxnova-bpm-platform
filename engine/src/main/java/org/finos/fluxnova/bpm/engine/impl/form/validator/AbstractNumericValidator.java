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
package org.finos.fluxnova.bpm.engine.impl.form.validator;

/**
 * @author Daniel Meyer
 *
 */
public abstract class AbstractNumericValidator implements FormFieldValidator {

  @Override
  public boolean validate(Object submittedValue, FormFieldValidatorContext validatorContext) {

    if (submittedValue == null) {
      return isNullValid();
    }

    String configurationString = validatorContext.getConfiguration();

    // Double

    if (submittedValue instanceof Double double1) {
      Double configuration = null;
      try {
        configuration = Double.parseDouble(configurationString);
      } catch( NumberFormatException e) {
        throw new FormFieldConfigurationException(configurationString, "Cannot validate Double value "+submittedValue +": configuration "+configurationString+" cannot be parsed as Double.");
      }
      return validate(double1, configuration);
    }

    // Float

    if (submittedValue instanceof Float float1) {
      Float configuration = null;
      try {
        configuration = Float.parseFloat(configurationString);
      } catch( NumberFormatException e) {
        throw new FormFieldConfigurationException(configurationString, "Cannot validate Float value "+submittedValue +": configuration "+configurationString+" cannot be parsed as Float.");
      }
      return validate(float1, configuration);
    }

    // Long

    if (submittedValue instanceof Long long1) {
      Long configuration = null;
      try {
        configuration = Long.parseLong(configurationString);
      } catch(NumberFormatException e) {
        throw new FormFieldConfigurationException(configurationString, "Cannot validate Long value "+submittedValue +": configuration "+configurationString+" cannot be parsed as Long.");
      }
      return validate(long1, configuration);
    }

    // Integer

    if (submittedValue instanceof Integer integer) {
      Integer configuration = null;
      try {
        configuration = Integer.parseInt(configurationString);
      } catch( NumberFormatException e) {
        throw new FormFieldConfigurationException(configurationString, "Cannot validate Integer value "+submittedValue +": configuration "+configurationString+" cannot be parsed as Integer.");
      }
      return validate(integer, configuration);
    }

    // Short

    if (submittedValue instanceof Short short1) {
      Short configuration = null;
      try {
        configuration = Short.parseShort(configurationString);
      } catch( NumberFormatException e) {
        throw new FormFieldConfigurationException(configurationString, "Cannot validate Short value "+submittedValue +": configuration "+configurationString+" cannot be parsed as Short.");
      }
      return validate(short1, configuration);
    }

    throw new FormFieldValidationException("Numeric validator "+getClass().getSimpleName()+" cannot be used on non-numeric value "+submittedValue);
  }

  protected boolean isNullValid() {
    return true;
  }

  protected abstract boolean validate(Integer submittedValue, Integer configuration);

  protected abstract boolean validate(Long submittedValue, Long configuration);

  protected abstract boolean validate(Double submittedValue, Double configuration);

  protected abstract boolean validate(Float submittedValue, Float configuration);

  protected abstract boolean validate(Short submittedValue, Short configuration);

}
