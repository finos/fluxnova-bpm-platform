package org.finos.fluxnova.bpm.engine.rest.dto;

public class JobSuspensionResponse {

  private String jobId;
  private ResponseStatus status;
  private String errorMessage;

  public JobSuspensionResponse() {
  }

  public JobSuspensionResponse(String jobId, ResponseStatus status, String errorMessage) {
    this.jobId = jobId;
    this.status = status;
    this.errorMessage = errorMessage;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
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
