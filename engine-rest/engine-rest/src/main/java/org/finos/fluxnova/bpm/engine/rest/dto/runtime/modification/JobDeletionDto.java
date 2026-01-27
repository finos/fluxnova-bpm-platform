package org.finos.fluxnova.bpm.engine.rest.dto.runtime.modification;

import java.util.List;

public class JobDeletionDto {
  private List<String> jobIds;

  public List<String> getJobIds() {
    return jobIds;
  }

  public void setJobIds(List<String> jobIds) {
    this.jobIds = jobIds;
  }
}
