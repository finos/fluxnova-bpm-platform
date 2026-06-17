package org.finos.fluxnova.bpm.engine.rest.dto.repository;

import org.finos.fluxnova.bpm.engine.rest.dto.ResponseStatus;

public class DeleteDeploymentResponse {

  private ResponseStatus status;
  private String deploymentId;
  private String errorMessage;

  public DeleteDeploymentResponse(String deploymentId, ResponseStatus status, String errorMessage) {
    this.deploymentId = deploymentId;
    this.status = status;
    this.errorMessage = errorMessage;
  }

  public DeleteDeploymentResponse() {
  }

  public String getDeploymentId() {
    return deploymentId;
  }

  public void setDeploymentId(String deploymentId) {
    this.deploymentId = deploymentId;
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
