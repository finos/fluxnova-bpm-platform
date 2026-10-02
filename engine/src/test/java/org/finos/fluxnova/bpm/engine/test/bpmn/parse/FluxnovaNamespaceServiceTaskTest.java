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
package org.finos.fluxnova.bpm.engine.test.bpmn.parse;

import static org.assertj.core.api.Assertions.assertThat;

import org.finos.fluxnova.bpm.engine.RepositoryService;
import org.finos.fluxnova.bpm.engine.impl.bpmn.behavior.ClassDelegateActivityBehavior;
import org.finos.fluxnova.bpm.engine.impl.bpmn.behavior.ExternalTaskActivityBehavior;
import org.finos.fluxnova.bpm.engine.impl.bpmn.behavior.ServiceTaskDelegateExpressionActivityBehavior;
import org.finos.fluxnova.bpm.engine.impl.bpmn.behavior.ServiceTaskExpressionActivityBehavior;
import org.finos.fluxnova.bpm.engine.impl.context.Context;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandExecutor;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ProcessDefinitionEntity;
import org.finos.fluxnova.bpm.engine.impl.pvm.process.ActivityImpl;
import org.finos.fluxnova.bpm.engine.test.Deployment;
import org.finos.fluxnova.bpm.engine.test.util.PluggableProcessEngineTest;
import org.junit.jupiter.api.Test;

/**
 * Tests to verify that the BPMN parser recognizes fluxnova: namespace attributes
 * for service task implementation (class, delegateExpression, type, expression)
 * in addition to the legacy camunda: namespace.
 *
 * This ensures backward compatibility while supporting the Fluxnova namespace.
 */
public class FluxnovaNamespaceServiceTaskTest extends PluggableProcessEngineTest {


  @Test
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/parse/FluxnovaNamespaceServiceTaskTest.testFluxnovaClass.bpmn20.xml")
  public void testFluxnovaClassAttributeIsRecognized() {
    CommandExecutor commandExecutor = processEngineConfiguration.getCommandExecutorTxRequired();
    ProcessDefinitionEntity processDefinitionEntity = commandExecutor.execute(new Command<ProcessDefinitionEntity>() {
      @Override
      public ProcessDefinitionEntity execute(CommandContext commandContext) {
        return Context.getProcessEngineConfiguration().getDeploymentCache()
            .findDeployedLatestProcessDefinitionByKey("fluxnovaClassDelegation");
      }
    });
    
    assertThat(processDefinitionEntity).isNotNull();
    ActivityImpl activity = processDefinitionEntity.findActivity("javaService");
    assertThat(activity).isNotNull();
    assertThat(activity.getActivityBehavior()).isInstanceOf(ClassDelegateActivityBehavior.class);
    ClassDelegateActivityBehavior behavior = (ClassDelegateActivityBehavior) activity.getActivityBehavior();
    assertThat(behavior.getClassName()).isEqualTo("org.finos.fluxnova.bpm.engine.test.bpmn.servicetask.util.ToUppercase");
  }

  @Test
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/parse/FluxnovaNamespaceServiceTaskTest.testFluxnovaDelegateExpression.bpmn20.xml")
  public void testFluxnovaDelegateExpressionAttributeIsRecognized() {
    CommandExecutor commandExecutor = processEngineConfiguration.getCommandExecutorTxRequired();
    ProcessDefinitionEntity processDefinitionEntity = commandExecutor.execute(new Command<ProcessDefinitionEntity>() {
      @Override
      public ProcessDefinitionEntity execute(CommandContext commandContext) {
        return Context.getProcessEngineConfiguration().getDeploymentCache()
            .findDeployedLatestProcessDefinitionByKey("fluxnovaDelegateExpressionTest");
      }
    });

    assertThat(processDefinitionEntity).isNotNull();
    ActivityImpl activity = processDefinitionEntity.findActivity("javaService");

    assertThat(activity).isNotNull();
    assertThat(activity.getActivityBehavior()).isInstanceOf(ServiceTaskDelegateExpressionActivityBehavior.class);

    ServiceTaskDelegateExpressionActivityBehavior behavior =
            (ServiceTaskDelegateExpressionActivityBehavior) activity.getActivityBehavior();
    assertThat(behavior.getExpressionText()).isEqualTo("${toUppercaseBean}");
  }

  @Test
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/parse/FluxnovaNamespaceServiceTaskTest.testFluxnovaExpression.bpmn20.xml")
  public void testFluxnovaExpressionAttributeIsRecognized() {
    CommandExecutor commandExecutor = processEngineConfiguration.getCommandExecutorTxRequired();
    ProcessDefinitionEntity processDefinitionEntity = commandExecutor.execute(new Command<ProcessDefinitionEntity>() {
      @Override
      public ProcessDefinitionEntity execute(CommandContext commandContext) {
        return Context.getProcessEngineConfiguration().getDeploymentCache()
            .findDeployedLatestProcessDefinitionByKey("fluxnovaExpressionTest");
      }
    });

    assertThat(processDefinitionEntity).isNotNull();
    ActivityImpl activity = processDefinitionEntity.findActivity("javaService");

    assertThat(activity).isNotNull();
    assertThat(activity.getActivityBehavior()).isInstanceOf(ServiceTaskExpressionActivityBehavior.class);

    ServiceTaskExpressionActivityBehavior behavior =
            (ServiceTaskExpressionActivityBehavior) activity.getActivityBehavior();
    assertThat(behavior.getExpressionText()).isEqualTo("${execution.setVariable('myVar', 'test')}");
  }

  @Test
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/parse/FluxnovaNamespaceServiceTaskTest.testFluxnovaType.bpmn20.xml")
  public void testFluxnovaTypeAttributeIsRecognized() {
    CommandExecutor commandExecutor = processEngineConfiguration.getCommandExecutorTxRequired();
    ProcessDefinitionEntity processDefinitionEntity = commandExecutor.execute(new Command<ProcessDefinitionEntity>() {
      @Override
      public ProcessDefinitionEntity execute(CommandContext commandContext) {
        return Context.getProcessEngineConfiguration().getDeploymentCache()
            .findDeployedLatestProcessDefinitionByKey("fluxnovaTypeTest");
      }
    });

    assertThat(processDefinitionEntity).isNotNull();
    ActivityImpl activity = processDefinitionEntity.findActivity("externalService");

    assertThat(activity).isNotNull();
    assertThat(activity.getActivityBehavior()).isInstanceOf(ExternalTaskActivityBehavior.class);
  }
}
