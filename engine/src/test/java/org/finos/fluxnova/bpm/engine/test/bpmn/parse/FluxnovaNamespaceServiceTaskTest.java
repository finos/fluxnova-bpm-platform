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

  @Test
  @Deployment(resources = "org/finos/fluxnova/bpm/engine/test/bpmn/parse/FluxnovaNamespaceServiceTaskTest.testFluxnovaComprehensive.bpmn20.xml")
  public void testFluxnovaComprehensiveNamespaceAttributesAreRecognized() {
    CommandExecutor commandExecutor = processEngineConfiguration.getCommandExecutorTxRequired();
    ProcessDefinitionEntity processDefinitionEntity = commandExecutor.execute(new Command<ProcessDefinitionEntity>() {
      @Override
      public ProcessDefinitionEntity execute(CommandContext commandContext) {
        return Context.getProcessEngineConfiguration().getDeploymentCache()
            .findDeployedLatestProcessDefinitionByKey("fluxnovaComprehensiveTest");
      }
    });

    assertThat(processDefinitionEntity).isNotNull();

    assertThat(processDefinitionEntity.getHistoryTimeToLive()).isEqualTo(180);

    ActivityImpl classActivity = processDefinitionEntity.findActivity("javaServiceClass");
    assertThat(classActivity).isNotNull();
    assertThat(classActivity.getActivityBehavior()).isInstanceOf(ClassDelegateActivityBehavior.class);
    assertThat(classActivity.isAsyncBefore()).isTrue();
    ClassDelegateActivityBehavior classBehavior = (ClassDelegateActivityBehavior) classActivity.getActivityBehavior();
    assertThat(classBehavior.getClassName()).isEqualTo("org.finos.fluxnova.bpm.engine.test.bpmn.servicetask.util.ToUppercase");

    ActivityImpl delegateExpressionActivity = processDefinitionEntity.findActivity("javaServiceDelegateExpression");
    assertThat(delegateExpressionActivity).isNotNull();
    assertThat(delegateExpressionActivity.getActivityBehavior()).isInstanceOf(ServiceTaskDelegateExpressionActivityBehavior.class);
    ServiceTaskDelegateExpressionActivityBehavior delegateExpressionBehavior =
        (ServiceTaskDelegateExpressionActivityBehavior) delegateExpressionActivity.getActivityBehavior();
    assertThat(delegateExpressionBehavior.getExpressionText()).isEqualTo("${toUppercaseBean}");

    ActivityImpl expressionActivity = processDefinitionEntity.findActivity("javaServiceExpression");
    assertThat(expressionActivity).isNotNull();
    assertThat(expressionActivity.getActivityBehavior()).isInstanceOf(ServiceTaskExpressionActivityBehavior.class);
    ServiceTaskExpressionActivityBehavior expressionBehavior =
        (ServiceTaskExpressionActivityBehavior) expressionActivity.getActivityBehavior();
    assertThat(expressionBehavior.getExpressionText()).isEqualTo("${execution.setVariable('myVar', 'test')}");

    ActivityImpl externalActivity = processDefinitionEntity.findActivity("externalService");
    assertThat(externalActivity).isNotNull();
    assertThat(externalActivity.getActivityBehavior()).isInstanceOf(ExternalTaskActivityBehavior.class);
  }
}
