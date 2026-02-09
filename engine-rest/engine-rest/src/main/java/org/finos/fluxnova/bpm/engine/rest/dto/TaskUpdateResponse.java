package org.finos.fluxnova.bpm.engine.rest.dto;

public class TaskUpdateResponse {

  private ResponseStatus status;
  private String taskId;
  private String errorMessage;

  public TaskUpdateResponse(String taskId, ResponseStatus status, String errorMessage) {
    this.taskId = taskId;
    this.status = status;
    this.errorMessage = errorMessage;
  }

  public TaskUpdateResponse() {
  }

  public String getTaskId() {
    return taskId;
  }

  public void setTaskId(String taskId) {
    this.taskId = taskId;
  }

  public ResponseStatus getStatus() {
    return status;
  }

  public void setStatus(ResponseStatus status) {
    this.status = status;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

}
