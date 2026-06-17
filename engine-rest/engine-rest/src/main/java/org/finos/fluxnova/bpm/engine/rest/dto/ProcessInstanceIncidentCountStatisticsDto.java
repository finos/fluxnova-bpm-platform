package org.finos.fluxnova.bpm.engine.rest.dto;

public class ProcessInstanceIncidentCountStatisticsDto {
    private String processInstanceId;
    private long incidentCount;

    public ProcessInstanceIncidentCountStatisticsDto(String processInstanceId, long incidentCount) {
        this.processInstanceId = processInstanceId;
        this.incidentCount = incidentCount;
    }

    public long getIncidentCount() {
        return incidentCount;
    }

    public void setIncidentCount(long incidentCount) {
        this.incidentCount = incidentCount;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }
}