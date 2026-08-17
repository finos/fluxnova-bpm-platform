package org.finos.fluxnova.bpm.engine.impl.pvm.delegate;

/**
 * Composite behavior of an ad-hoc scope which may complete eagerly while child
 * executions are still active, e.g. when a completion condition is satisfied.
 */
public interface AdHocCompositeActivityBehavior extends CompositeActivityBehavior {

  /**
   * Invoked before a direct child execution of the ad-hoc scope leaves its
   * current activity via an outgoing transition. If this returns {@code true},
   * the child execution is ended instead of taking the transition, which in
   * turn completes the ad-hoc scope and cancels its remaining children.
   *
   * @param scopeExecution scope execution for the activity which defined the behavior
   * @return {@code true} if the ad-hoc scope should complete instead of
   *         propagating the child execution along the transition
   */
  boolean shouldCompleteOnChildTransition(ActivityExecution scopeExecution);
}
