package org.finos.fluxnova.bpm.engine.impl.cmd;

import static org.finos.fluxnova.bpm.engine.impl.util.EnsureUtil.ensureNotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.finos.fluxnova.bpm.engine.BadUserRequestException;
import org.finos.fluxnova.bpm.engine.impl.bpmn.behavior.AdHocSubProcessActivityBehavior;
import org.finos.fluxnova.bpm.engine.impl.bpmn.behavior.AdHocSubProcessValidationHelper;
import org.finos.fluxnova.bpm.engine.impl.cfg.CommandChecker;
import org.finos.fluxnova.bpm.engine.impl.interceptor.Command;
import org.finos.fluxnova.bpm.engine.impl.interceptor.CommandContext;
import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ExecutionEntity;
import org.finos.fluxnova.bpm.engine.impl.pvm.delegate.ActivityExecution;
import org.finos.fluxnova.bpm.engine.impl.pvm.process.ActivityImpl;

/**
 * Triggers starter activities inside an active ad-hoc subprocess execution.
 */
public class TriggerAdHocActivitiesCmd implements Command<Void>, Serializable {

  private static final long serialVersionUID = 1L;

  protected final String executionId;
  protected final Collection<String> activityIds;
  protected final Map<String, Map<String, Object>> activityVariables;

  public TriggerAdHocActivitiesCmd(String executionId,
                                   Collection<String> activityIds,
                                   Map<String, Map<String, Object>> activityVariables) {
    this.executionId = executionId;
    this.activityIds = activityIds;
    this.activityVariables = activityVariables;
  }

  @Override
  public Void execute(CommandContext commandContext) {
    ensureNotNull(BadUserRequestException.class, "executionId is null", "executionId", executionId);
    ensureNotNull(BadUserRequestException.class, "activityIds is null", "activityIds", activityIds);

    if (activityIds.isEmpty()) {
      throw new BadUserRequestException("activityIds is empty");
    }

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

    Set<String> uniqueActivityIds = new HashSet<>();
    List<String> normalizedActivityIds = new ArrayList<>();
    for (String activityId : activityIds) {
      ensureNotNull(BadUserRequestException.class, "activityId is null", "activityId", activityId);
      if (!uniqueActivityIds.add(activityId)) {
        throw new BadUserRequestException("duplicate adHoc activity '" + activityId + "' in request");
      }
      normalizedActivityIds.add(activityId);
    }

    if (activityVariables != null) {
      for (String keyedActivityId : activityVariables.keySet()) {
        if (!uniqueActivityIds.contains(keyedActivityId)) {
          throw new BadUserRequestException("variables provided for non-requested adHoc activity '" + keyedActivityId + "'");
        }
      }
    }

    List<ActivityImpl> targetActivities = new ArrayList<>(normalizedActivityIds.size());
    for (String activityId : normalizedActivityIds) {
      ActivityImpl targetActivity = adHocActivity.findActivity(activityId);
      ensureNotNull(BadUserRequestException.class,
          "adHoc activity '" + activityId + "' does not exist in adHocSubProcess " + adHocActivity.getId(),
          "targetActivity",
          targetActivity);

      if (!isStartableInAdHocScope(adHocActivity, targetActivity)) {
        throw new BadUserRequestException(
            "adHoc activity '" + activityId + "' is not startable in adHocSubProcess " + adHocActivity.getId());
      }

      boolean alreadyActive = execution.getExecutions().stream()
        .anyMatch(child -> child.getActivity() != null
          && activityId.equals(child.getActivity().getId())
          && child.isActive());

      if (alreadyActive) {
        throw new BadUserRequestException("adHoc activity '" + activityId + "' is already active in adHocSubProcess " + adHocActivity.getId());
      }

      targetActivities.add(targetActivity);
    }

    for (ActivityImpl targetActivity : targetActivities) {
      ((AdHocSubProcessActivityBehavior) adHocActivity.getActivityBehavior()).markAdHocActivityStarted(execution);
      ActivityExecution childExecution = execution.createExecution();
      ((ExecutionEntity) execution).forceUpdate();
      childExecution.setConcurrent(true);
      childExecution.setScope(false);
      if (activityVariables != null) {
        Map<String, Object> localVariables = activityVariables.get(targetActivity.getId());
        if (localVariables != null && !localVariables.isEmpty()) {
          childExecution.setVariablesLocal(localVariables);
        }
      }
      childExecution.executeActivity(targetActivity);
    }

    return null;
  }

  protected boolean isStartableInAdHocScope(ActivityImpl adHocScope, ActivityImpl activity) {
    return AdHocSubProcessValidationHelper.isStartableActivityInAdHocScope(adHocScope, activity);
  }
}
