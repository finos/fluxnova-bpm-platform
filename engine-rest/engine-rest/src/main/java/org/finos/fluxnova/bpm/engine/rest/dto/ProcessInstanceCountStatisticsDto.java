package org.finos.fluxnova.bpm.engine.rest.dto;

public class ProcessInstanceCountStatisticsDto {
  private String processDefinitionId;
  private long instanceCount;

  public ProcessInstanceCountStatisticsDto(String processDefinitionId, long instanceCount) {
    this.processDefinitionId = processDefinitionId;
    this.instanceCount = instanceCount;
  }

  public long getInstanceCount() {
    return instanceCount;
  }

  public void setInstanceCount(long instanceCount) {
    this.instanceCount = instanceCount;
  }

  public String getProcessDefinitionId() {
    return processDefinitionId;
  }

  public void setProcessDefinitionId(String processDefinitionId) {
    this.processDefinitionId = processDefinitionId;
  }
}
