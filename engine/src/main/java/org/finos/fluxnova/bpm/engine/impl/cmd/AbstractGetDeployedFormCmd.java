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
package org.finos.fluxnova.bpm.engine.impl.cmd;

import java.io.InputStream;
import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.exception.DeploymentResourceNotFoundException;
import org.finos.fluxnova.bpm.engine.exception.NotFoundException;
import org.finos.fluxnova.bpm.engine.form.FluxnovaFormRef;
import org.finos.fluxnova.bpm.engine.form.FormData;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;
import org.finos.fluxnova.bpm.engine.repository.FluxnovaFormDefinition;

/**
 *
 * @author Anna Pazola
 *
 */
public abstract class AbstractGetDeployedFormCmd implements Command<InputStream> {

  protected static String EMBEDDED_KEY = "embedded:";
  protected static String FLUXNOVA_FORMS_KEY = "fluxnova-forms:";
  protected static int EMBEDDED_KEY_LENGTH = EMBEDDED_KEY.length();
  protected static int FLUXNOVA_FORMS_KEY_LENGTH = FLUXNOVA_FORMS_KEY.length();

  protected static String DEPLOYMENT_KEY = "deployment:";
  protected static int DEPLOYMENT_KEY_LENGTH = DEPLOYMENT_KEY.length();

  protected CommandContext commandContext;

  public InputStream execute(final CommandContext commandContext) {
    this.commandContext = commandContext;
    checkAuthorization();

    final FormData formData = getFormData();
    String formKey = formData.getFormKey();
    FluxnovaFormRef fluxnovaFormRef = formData.getFluxnovaFormRef();

    if (formKey != null) {
      return getResourceForFormKey(formData, formKey);
    } else if(fluxnovaFormRef != null && fluxnovaFormRef.getKey() != null) {
      return getResourceForFluxnovaFormRef(fluxnovaFormRef, formData.getDeploymentId());
    } else {
      throw new BadUserRequestException("One of the attributes 'formKey' and 'camunda:formRef' must be supplied but none were set.");
    }
  }

  protected InputStream getResourceForFormKey(FormData formData, String formKey) {
    String resourceName = formKey;

    if (resourceName.startsWith(EMBEDDED_KEY)) {
      resourceName = resourceName.substring(EMBEDDED_KEY_LENGTH, resourceName.length());
    } else if (resourceName.startsWith(FLUXNOVA_FORMS_KEY)) {
      resourceName = resourceName.substring(FLUXNOVA_FORMS_KEY_LENGTH, resourceName.length());
    }

    if (!resourceName.startsWith(DEPLOYMENT_KEY)) {
      throw new BadUserRequestException("The form key '" + formKey + "' does not reference a deployed form.");
    }

    resourceName = resourceName.substring(DEPLOYMENT_KEY_LENGTH, resourceName.length());

    return getDeploymentResource(formData.getDeploymentId(), resourceName);
  }

  protected InputStream getResourceForFluxnovaFormRef(FluxnovaFormRef fluxnovaFormRef,
      String deploymentId) {
    FluxnovaFormDefinition definition = commandContext.runWithoutAuthorization(
        new GetFluxnovaFormDefinitionCmd(fluxnovaFormRef, deploymentId));

    if (definition == null) {
      throw new NotFoundException("No Fluxnova Form Definition was found for Fluxnova Form Ref: " + fluxnovaFormRef);
    }

    return getDeploymentResource(definition.getDeploymentId(), definition.getResourceName());
  }

  protected InputStream getDeploymentResource(String deploymentId, String resourceName) {
    GetDeploymentResourceCmd getDeploymentResourceCmd = new GetDeploymentResourceCmd(deploymentId, resourceName);
    try {
      return commandContext.runWithoutAuthorization(getDeploymentResourceCmd);
    } catch (DeploymentResourceNotFoundException e) {
      throw new NotFoundException("The form with the resource name '" + resourceName + "' cannot be found in deployment with id " + deploymentId, e);
    }
  }

  protected abstract FormData getFormData();

  protected abstract void checkAuthorization();

}
