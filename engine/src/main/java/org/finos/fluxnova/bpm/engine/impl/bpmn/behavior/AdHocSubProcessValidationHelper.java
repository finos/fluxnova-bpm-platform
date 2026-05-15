package org.finos.fluxnova.bpm.engine.impl.bpmn.behavior;

import org.finos.fluxnova.bpm.engine.ActivityTypes;
import org.finos.fluxnova.bpm.engine.impl.bpmn.helper.BpmnProperties;
import org.finos.fluxnova.bpm.engine.impl.pvm.PvmTransition;
import org.finos.fluxnova.bpm.engine.impl.pvm.process.ActivityImpl;

/**
 * Shared validation utilities for ad-hoc subprocess activity filtering and authorization.
 * Centralizes activity type blacklist and scope boundary checks used by both
 * {@link AdHocSubProcessActivityBehavior} and the trigger command.
 */
public class AdHocSubProcessValidationHelper {

  private AdHocSubProcessValidationHelper() {
    // Static utility class
  }

  /**
   * Checks if an activity type should be excluded from ad-hoc startup.
   * Returns true for gateways, events, and boundary events that cannot be started.
   *
   * @param type the BPMN activity type
   * @return true if the type is non-startable in ad-hoc scope
   */
  public static boolean isNonStartableActivityType(String type) {
    if (type == null) {
      return false;
    }

    return ActivityTypes.GATEWAY_EXCLUSIVE.equals(type)
        || ActivityTypes.GATEWAY_INCLUSIVE.equals(type)
        || ActivityTypes.GATEWAY_PARALLEL.equals(type)
        || ActivityTypes.GATEWAY_COMPLEX.equals(type)
        || ActivityTypes.GATEWAY_EVENT_BASED.equals(type)
        || ActivityTypes.START_EVENT.equals(type)
        || ActivityTypes.START_EVENT_TIMER.equals(type)
        || ActivityTypes.START_EVENT_MESSAGE.equals(type)
        || ActivityTypes.START_EVENT_SIGNAL.equals(type)
        || ActivityTypes.START_EVENT_ESCALATION.equals(type)
        || ActivityTypes.START_EVENT_COMPENSATION.equals(type)
        || ActivityTypes.START_EVENT_ERROR.equals(type)
        || ActivityTypes.START_EVENT_CONDITIONAL.equals(type)
        || ActivityTypes.END_EVENT_NONE.equals(type)
        || ActivityTypes.END_EVENT_ERROR.equals(type)
        || ActivityTypes.END_EVENT_CANCEL.equals(type)
        || ActivityTypes.END_EVENT_TERMINATE.equals(type)
        || ActivityTypes.END_EVENT_MESSAGE.equals(type)
        || ActivityTypes.END_EVENT_SIGNAL.equals(type)
        || ActivityTypes.END_EVENT_COMPENSATION.equals(type)
        || ActivityTypes.END_EVENT_ESCALATION.equals(type)
        || ActivityTypes.BOUNDARY_TIMER.equals(type)
        || ActivityTypes.BOUNDARY_MESSAGE.equals(type)
        || ActivityTypes.BOUNDARY_SIGNAL.equals(type)
        || ActivityTypes.BOUNDARY_COMPENSATION.equals(type)
        || ActivityTypes.BOUNDARY_ERROR.equals(type)
        || ActivityTypes.BOUNDARY_ESCALATION.equals(type)
        || ActivityTypes.BOUNDARY_CANCEL.equals(type)
        || ActivityTypes.BOUNDARY_CONDITIONAL.equals(type);
  }

  /**
   * Checks if an activity has an incoming transition from within the ad-hoc scope.
   * Activities with such transitions are downstream-only and cannot be starter activities.
   *
   * @param adHocScope the ad-hoc subprocess scope
   * @param activity the activity to check
   * @return true if activity has incoming transition from within scope
   */
  public static boolean hasIncomingTransitionFromAdHocScope(ActivityImpl adHocScope, ActivityImpl activity) {
    for (PvmTransition incomingTransition : activity.getIncomingTransitions()) {
      if (incomingTransition.getSource() instanceof ActivityImpl) {
        ActivityImpl source = (ActivityImpl) incomingTransition.getSource();
        if (adHocScope.findActivity(source.getId()) != null) {
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Determines if an activity can be started within an ad-hoc scope.
   * Rejects compensation handlers, non-startable activity types, and activities
   * with incoming transitions from within the scope.
   *
   * @param adHocScope the ad-hoc subprocess scope
   * @param activity the activity to validate
   * @return true if activity is startable in ad-hoc scope
   */
  public static boolean isStartableActivityInAdHocScope(ActivityImpl adHocScope, ActivityImpl activity) {
    if (activity.isCompensationHandler()) {
      return false;
    }

    String type = (String) activity.getProperty(BpmnProperties.TYPE.getName());
    if (isNonStartableActivityType(type)) {
      return false;
    }

    return !hasIncomingTransitionFromAdHocScope(adHocScope, activity);
  }
}
