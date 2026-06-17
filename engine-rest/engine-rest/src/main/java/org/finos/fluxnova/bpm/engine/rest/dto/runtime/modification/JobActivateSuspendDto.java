package org.finos.fluxnova.bpm.engine.rest.dto.runtime.modification;

import java.util.List;

public class JobActivateSuspendDto {
  private List<String> jobIds;
  private boolean suspended;

  public List<String> getJobIds() {
    return jobIds;
  }

  public void setJobIds(List<String> jobIds) {
    this.jobIds = jobIds;
  }

  public boolean isSuspended() {
    return suspended;
  }

  public void setSuspended(boolean suspended) {
    this.suspended = suspended;
  }
}
