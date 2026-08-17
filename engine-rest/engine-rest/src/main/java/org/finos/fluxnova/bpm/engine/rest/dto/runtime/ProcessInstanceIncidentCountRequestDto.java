package org.finos.fluxnova.bpm.engine.rest.dto.runtime;

import java.util.List;

public class ProcessInstanceIncidentCountRequestDto {
    private List<String> processInstanceIds;
    public List<String> getProcessInstanceIds() {
        return processInstanceIds;
    }
    public void setProcessInstanceIds(List<String> processInstanceIds) {
        this.processInstanceIds = processInstanceIds;
    }
}