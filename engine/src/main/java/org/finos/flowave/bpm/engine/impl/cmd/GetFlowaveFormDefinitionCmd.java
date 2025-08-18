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
package org.finos.flowave.bpm.engine.impl.cmd;

import org.finos.flowave.bpm.engine.BadUserRequestException;
import org.finos.flowave.bpm.engine.form.FlowaveFormRef;
import org.finos.flowave.bpm.engine.impl.form.entity.FlowaveFormDefinitionManager;
import org.finos.flowave.bpm.engine.impl.form.handler.DefaultFormHandler;
import org.finos.flowave.bpm.engine.impl.interceptor.Command;
import org.finos.flowave.bpm.engine.impl.interceptor.CommandContext;
import org.finos.flowave.bpm.engine.impl.persistence.entity.CamundaFormDefinitionEntity;
import org.finos.flowave.bpm.engine.repository.FlowaveFormDefinition;

public class GetFlowaveFormDefinitionCmd implements Command<FlowaveFormDefinition> {

  protected FlowaveFormRef camundaFormRef;
  protected String deploymentId;

  public GetFlowaveFormDefinitionCmd(FlowaveFormRef camundaFormRef, String deploymentId) {
    this.camundaFormRef = camundaFormRef;
    this.deploymentId = deploymentId;
  }

  @Override
  public FlowaveFormDefinition execute(CommandContext commandContext) {
    String binding = camundaFormRef.getBinding();
    String key = camundaFormRef.getKey();
    CamundaFormDefinitionEntity definition = null;
    FlowaveFormDefinitionManager manager = commandContext.getFlowaveFormDefinitionManager();
    if (binding.equals(DefaultFormHandler.FORM_REF_BINDING_DEPLOYMENT)) {
      definition = manager.findDefinitionByDeploymentAndKey(deploymentId, key);
    } else if (binding.equals(DefaultFormHandler.FORM_REF_BINDING_LATEST)) {
      definition = manager.findLatestDefinitionByKey(key);
    } else if (binding.equals(DefaultFormHandler.FORM_REF_BINDING_VERSION)) {
      definition = manager.findDefinitionByKeyVersionAndTenantId(key, camundaFormRef.getVersion(), null);
    } else {
      throw new BadUserRequestException("Unsupported binding type for camundaFormRef. Expected to be one of "
          + DefaultFormHandler.ALLOWED_FORM_REF_BINDINGS + " but was:" + binding);
    }

    return definition;
  }

}
