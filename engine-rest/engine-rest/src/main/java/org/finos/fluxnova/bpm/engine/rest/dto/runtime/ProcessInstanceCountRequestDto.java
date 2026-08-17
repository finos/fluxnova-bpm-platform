package org.finos.fluxnova.bpm.engine.rest.dto.runtime;

import java.util.List;

public class ProcessInstanceCountRequestDto {
  private List<String> processDefinitionIds;
  private boolean active;

  public List<String> getProcessDefinitionIds() {
    return processDefinitionIds;
  }

  public void setProcessDefinitionIds(List<String> processDefinitionIds) {
    this.processDefinitionIds = processDefinitionIds;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}