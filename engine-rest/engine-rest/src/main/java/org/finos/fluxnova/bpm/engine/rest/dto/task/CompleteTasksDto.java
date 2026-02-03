package org.finos.fluxnova.bpm.engine.rest.dto.task;

import org.finos.fluxnova.bpm.engine.rest.dto.VariableValueDto;

import java.util.Map;

public class CompleteTasksDto {

  public CompleteTasksDto() {

  }

  private Map<String, VariableValueDto> variables;
  private String taskId;

  public Map<String, VariableValueDto> getVariables() {
    return variables;
  }

  public void setVariables(Map<String, VariableValueDto> variables) {
    this.variables = variables;
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }
}
