package org.finos.fluxnova.bpm.engine.rest.dto.task;

import java.util.List;

public class TasksAssignDto {

    private List<String> taskIds;
    private String userId;

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
