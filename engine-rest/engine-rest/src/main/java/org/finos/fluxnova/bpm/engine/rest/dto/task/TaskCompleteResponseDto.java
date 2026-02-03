package org.finos.fluxnova.bpm.engine.rest.dto.task;

import org.finos.fluxnova.bpm.engine.rest.dto.ResponseStatus;
import org.finos.fluxnova.bpm.engine.rest.dto.VariableValueDto;

import java.util.Map;

public class TaskCompleteResponseDto {

  private Map<String, VariableValueDto> variables;
  private ResponseStatus status;
  private String taskId;
  private String errorMessage;

  public TaskCompleteResponseDto(String taskId,
                                 ResponseStatus status,
                                 String errorMessage,
                                 Map<String, VariableValueDto> variables) {
    this.variables = variables;
    this.setTaskId(taskId);
    this.setStatus(status);
    this.setErrorMessage(errorMessage);
  }

  public TaskCompleteResponseDto() {
  }

  public Map<String, VariableValueDto> getVariables() {
    return variables;
  }

  public void setVariables(Map<String, VariableValueDto> variables) {
    this.variables = variables;
  }

  public ResponseStatus getStatus() {
    return status;
  }

  public void setStatus(ResponseStatus status) {
    this.status = status;
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
