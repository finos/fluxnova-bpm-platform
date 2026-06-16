package org.finos.fluxnova.bpm.engine.rest.dto.runtime;

import java.util.List;

public class AdHocActivitiesTriggerDto {

  private List<AdHocActivityTriggerInstructionDto> activities;

  public List<AdHocActivityTriggerInstructionDto> getActivities() {
    return activities;
  }

  public void setActivities(List<AdHocActivityTriggerInstructionDto> activities) {
    this.activities = activities;
  }
}
