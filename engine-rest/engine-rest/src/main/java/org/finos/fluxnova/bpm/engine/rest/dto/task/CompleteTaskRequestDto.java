package org.finos.fluxnova.bpm.engine.rest.dto.task;

import java.util.List;

public class CompleteTaskRequestDto {

  private List<CompleteTasksDto> completeTasksInfo;
  private boolean withVariablesInReturn;

  public boolean isWithVariablesInReturn() {
    return withVariablesInReturn;
  }

  public void setWithVariablesInReturn(boolean withVariablesInReturn) {
    this.withVariablesInReturn = withVariablesInReturn;
  }

  public List<CompleteTasksDto> getCompleteTasksInfo() {
    return completeTasksInfo;
  }

  public void setCompleteTasksInfo(List<CompleteTasksDto> completeTasksInfo) {
    this.completeTasksInfo = completeTasksInfo;
  }
}
