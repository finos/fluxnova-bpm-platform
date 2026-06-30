package org.finos.fluxnova.bpm.model.bpmn.instance;

/**
 * The BPMN 2.0 adHocSubProcess element.
 *
 * <p>An Ad-Hoc Sub-Process is a specialized type of Sub-Process that has a set
 * of Activities that can be performed in any order, and some of which may not
 * be performed at all. It is intended to be used in cases where the sequence
 * and number of performances are determined by the performers of the Activities.
 *
 */
public interface AdHocSubProcess extends SubProcess {

  /**
    * Returns the BPMN {@code ordering} attribute of the ad-hoc activities.
    * Typical values are "Parallel" (default) and "Sequential".
    *
    * <p>This is model metadata. In the current engine implementation,
    * ad-hoc runtime activation is parallel-only and "Sequential" is not
    * enforced as execution behavior.
   */
  String getOrdering();

  void setOrdering(String ordering);

  /**
   * If true (default), when the completionCondition is met, any remaining
   * running Activity instances within the Ad-Hoc Sub-Process will be cancelled.
   */
  boolean isCancelRemainingInstances();

  void setCancelRemainingInstances(boolean cancelRemainingInstances);

  /**
   * The Expression that, when evaluated to true, signals that the Ad-Hoc
   * Sub-Process should complete.
   */
  CompletionCondition getCompletionCondition();

  void setCompletionCondition(CompletionCondition completionCondition);

}
