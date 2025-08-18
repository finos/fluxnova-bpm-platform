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
package org.finos.flowave.bpm.engine.impl.form.handler;

import org.finos.flowave.bpm.engine.delegate.Expression;
import org.finos.flowave.bpm.engine.form.TaskFormData;
import org.finos.flowave.bpm.engine.impl.form.FlowaveFormRefImpl;
import org.finos.flowave.bpm.engine.impl.form.FormDefinition;
import org.finos.flowave.bpm.engine.impl.form.TaskFormDataImpl;
import org.finos.flowave.bpm.engine.impl.persistence.entity.TaskEntity;
import org.finos.flowave.bpm.engine.impl.task.TaskDefinition;


/**
 * @author Tom Baeyens
 */
public class DefaultTaskFormHandler extends DefaultFormHandler implements TaskFormHandler {

  public TaskFormData createTaskForm(TaskEntity task) {
    TaskFormDataImpl taskFormData = new TaskFormDataImpl();

    TaskDefinition taskDefinition = task.getTaskDefinition();

    FormDefinition formDefinition = taskDefinition.getFormDefinition();
    Expression formKey = formDefinition.getFormKey();
    Expression camundaFormDefinitionKey = formDefinition.getFlowaveFormDefinitionKey();
    String camundaFormDefinitionBinding = formDefinition.getFlowaveFormDefinitionBinding();
    Expression camundaFormDefinitionVersion = formDefinition.getFlowaveFormDefinitionVersion();

    if (formKey != null) {
      Object formValue = formKey.getValue(task);
      if (formValue != null) {
        taskFormData.setFormKey(formValue.toString());
      }
    } else if (camundaFormDefinitionKey != null && camundaFormDefinitionBinding != null) {
      Object formRefKeyValue = camundaFormDefinitionKey.getValue(task);
      if(formRefKeyValue != null) {
        FlowaveFormRefImpl ref = new FlowaveFormRefImpl(formRefKeyValue.toString(), camundaFormDefinitionBinding);
        if(camundaFormDefinitionBinding.equals(FORM_REF_BINDING_VERSION) && camundaFormDefinitionVersion != null) {
          Object formRefVersionValue = camundaFormDefinitionVersion.getValue(task);
          if(formRefVersionValue != null) {
            ref.setVersion(Integer.parseInt((String)formRefVersionValue));
          }
        }
        taskFormData.setFlowaveFormRef(ref);
      }
    }

    taskFormData.setDeploymentId(deploymentId);
    taskFormData.setTask(task);
    initializeFormProperties(taskFormData, task.getExecution());
    initializeFormFields(taskFormData, task.getExecution());
    return taskFormData;
  }

}
