package org.finos.fluxnova.bpm.engine.rest.dto.runtime;

import java.util.Map;
import org.finos.fluxnova.bpm.engine.rest.dto.VariableValueDto;

public class AdHocActivityTriggerInstructionDto {

  private String activityId;
  private Map<String, VariableValueDto> variables;

  public String getActivityId() {
    return activityId;
  }

  public void setActivityId(String activityId) {
    this.activityId = activityId;
  }

  public Map<String, VariableValueDto> getVariables() {
    return variables;
  }

  public void setVariables(Map<String, VariableValueDto> variables) {
    this.variables = variables;
  }
}
