package org.finos.fluxnova.bpm.engine.impl.cmd;

import static org.finos.fluxnova.bpm.engine.impl.util.EnsureUtil.ensureNotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.impl.bpmn.behavior.AdHocSubProcessActivityBehavior;
import org.finos.fluxnova.bpm.engine.impl.bpmn.parser.BpmnParse;
import org.finos.fluxnova.bpm.engine.impl.cfg.CommandChecker;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.finos.fluxnova.bpm.engine.impl.pvm.delegate.ActivityExecution;
import org.finos.fluxnova.bpm.engine.impl.pvm.process.ActivityImpl;
import org.finos.fluxnova.bpm.model.bpmn.instance.AdHocSubProcess;
import org.finos.fluxnova.bpm.model.bpmn.instance.FlowElement;

/**
 * Completes an active ad-hoc subprocess execution.
 */
public class CompleteAdHocSubProcessCmd implements Command<Void>, Serializable {

  private static final long serialVersionUID = 1L;

  protected final String executionId;
  protected final Map<String, Object> variables;

  public CompleteAdHocSubProcessCmd(String executionId) {
    this(executionId, null);
  }

  public CompleteAdHocSubProcessCmd(String executionId, Map<String, Object> variables) {
    this.executionId = executionId;
    this.variables = variables;
  }

  @Override
  public Void execute(CommandContext commandContext) {
    ensureNotNull(BadUserRequestException.class, "executionId is null", "executionId", executionId);

    ExecutionEntity execution = commandContext.getExecutionManager().findExecutionById(executionId);
    ensureNotNull(BadUserRequestException.class, "execution " + executionId + " doesn't exist", "execution", execution);

    for (CommandChecker checker : commandContext.getProcessEngineConfiguration().getCommandCheckers()) {
      checker.checkUpdateProcessInstance(execution);
    }

    ActivityImpl adHocActivity = execution.getActivity();
    ensureNotNull(BadUserRequestException.class, "execution " + executionId + " has no current activity", "activity", adHocActivity);

    if (!(adHocActivity.getActivityBehavior() instanceof AdHocSubProcessActivityBehavior)) {
      throw new BadUserRequestException("execution " + executionId + " is not waiting in an adHocSubProcess");
    }

    boolean cancelRemainingInstances = resolveCancelRemainingInstances(execution, adHocActivity);

    boolean hasActiveChildren = execution.getExecutions().stream().anyMatch(ActivityExecution::isActive);
    if (hasActiveChildren && !cancelRemainingInstances) {
      throw new BadUserRequestException(
          "adHocSubProcess " + adHocActivity.getId() + " has active child activities and cannot be completed");
    }

    if (variables != null && !variables.isEmpty()) {
      execution.setVariables(variables);
    }

    AdHocSubProcessActivityBehavior behavior =
      (AdHocSubProcessActivityBehavior) adHocActivity.getActivityBehavior();

    if (hasActiveChildren) {
      for (ActivityExecution child : new ArrayList<>(execution.getExecutions())) {
        if (child.isActive()) {
          child.interrupt("adHocSubProcessManuallyCompleted");
        }
      }

      for (ActivityExecution child : new ArrayList<>(execution.getExecutions())) {
        child.remove();
      }

      execution.forceUpdate();
    }

    behavior.leave(execution);

    return null;
  }

  protected boolean resolveCancelRemainingInstances(ExecutionEntity execution, ActivityImpl adHocActivity) {
    FlowElement flowElement = execution.getBpmnModelElementInstance();
    if (flowElement instanceof AdHocSubProcess) {
      return ((AdHocSubProcess) flowElement).isCancelRemainingInstances();
    }

    Object cancelRemainingProperty = adHocActivity.getProperty(BpmnParse.PROPERTYNAME_AD_HOC_CANCEL_REMAINING);
    if (cancelRemainingProperty instanceof Boolean) {
      return (Boolean) cancelRemainingProperty;
    }

    if (cancelRemainingProperty instanceof String) {
      return Boolean.parseBoolean((String) cancelRemainingProperty);
    }

    return true;
  }
}
