package org.finos.fluxnova.bpm.engine.impl.bpmn.behavior;

import static org.assertj.core.api.Assertions.assertThat;

import org.finos.fluxnova.bpm.engine.ActivityTypes;
import org.junit.Test;

public class AdHocSubProcessValidationHelperTest {

  @Test
  public void shouldAcceptTaskLikeAndCallableTypes() {
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.TASK)).isTrue();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.TASK_SCRIPT)).isTrue();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.TASK_SERVICE)).isTrue();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.TASK_BUSINESS_RULE)).isTrue();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.TASK_MANUAL_TASK)).isTrue();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.TASK_USER_TASK)).isTrue();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.TASK_SEND_TASK)).isTrue();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.TASK_RECEIVE_TASK)).isTrue();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.CALL_ACTIVITY)).isTrue();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.SUB_PROCESS)).isTrue();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.TRANSACTION)).isTrue();
  }

  @Test
  public void shouldRejectIntermediateEvents() {
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_CATCH)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_MESSAGE)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_TIMER)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_LINK)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_SIGNAL)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_CONDITIONAL)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_THROW)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_SIGNAL_THROW)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_COMPENSATION_THROW)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_MESSAGE_THROW)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_NONE_THROW)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.INTERMEDIATE_EVENT_ESCALATION_THROW)).isFalse();
  }

  @Test
  public void shouldRejectGatewaysAndBoundaryEvents() {
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.GATEWAY_EXCLUSIVE)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.GATEWAY_INCLUSIVE)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.GATEWAY_PARALLEL)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.GATEWAY_COMPLEX)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.GATEWAY_EVENT_BASED)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.BOUNDARY_TIMER)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.BOUNDARY_MESSAGE)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.BOUNDARY_SIGNAL)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.BOUNDARY_COMPENSATION)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.BOUNDARY_ERROR)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.BOUNDARY_ESCALATION)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.BOUNDARY_CANCEL)).isFalse();
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(ActivityTypes.BOUNDARY_CONDITIONAL)).isFalse();
  }

  @Test
  public void shouldRejectNullType() {
    assertThat(AdHocSubProcessValidationHelper.isStartableActivityType(null)).isFalse();
  }
}
