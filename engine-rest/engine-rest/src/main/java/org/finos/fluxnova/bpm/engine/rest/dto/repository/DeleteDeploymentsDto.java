package org.finos.fluxnova.bpm.engine.rest.dto.repository;

import java.util.List;

public class DeleteDeploymentsDto {

  private List<String> deploymentIds;
  private boolean skipCustomListeners;
  private boolean cascade;
  private boolean skipIoMappings;

  public List<String> getDeploymentIds() {
    return deploymentIds;
  }

  public void setDeploymentIds(List<String> deploymentIds) {
    this.deploymentIds = deploymentIds;
  }

  public boolean isSkipCustomListeners() {
    return skipCustomListeners;
  }

  public void setSkipCustomListeners(boolean skipCustomListeners) {
    this.skipCustomListeners = skipCustomListeners;
  }

  public boolean isCascade() {
    return cascade;
  }

  public void setCascade(boolean cascade) {
    this.cascade = cascade;
  }

  public boolean isSkipIoMappings() {
    return skipIoMappings;
  }

  public void setSkipIoMappings(boolean skipIoMappings) {
    this.skipIoMappings = skipIoMappings;
  }
}
