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
package org.finos.fluxnova.bpm.engine.impl.form;

import org.finos.fluxnova.bpm.engine.delegate.Expression;

public class FormDefinition {

  protected Expression formKey;
  // camunda form definition
  protected Expression camundaFormDefinitionKey;
  protected String camundaFormDefinitionBinding;
  protected Expression camundaFormDefinitionVersion;

  public Expression getFormKey() {
    return formKey;
  }
  public void setFormKey(Expression formKey) {
    this.formKey = formKey;
  }
  public Expression getFluxnovaFormDefinitionKey() {
    return camundaFormDefinitionKey;
  }
  public void setFluxnovaFormDefinitionKey(Expression camundaFormDefinitionKey) {
    this.camundaFormDefinitionKey = camundaFormDefinitionKey;
  }
  public String getFluxnovaFormDefinitionBinding() {
    return camundaFormDefinitionBinding;
  }
  public void setFluxnovaFormDefinitionBinding(String camundaFormDefinitionBinding) {
    this.camundaFormDefinitionBinding = camundaFormDefinitionBinding;
  }
  public Expression getFluxnovaFormDefinitionVersion() {
    return camundaFormDefinitionVersion;
  }
  public void setFluxnovaFormDefinitionVersion(Expression camundaFormDefinitionVersion) {
    this.camundaFormDefinitionVersion = camundaFormDefinitionVersion;
  }
}
