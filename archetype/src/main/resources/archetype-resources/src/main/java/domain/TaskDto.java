package ${package}.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.finos.fluxnova.bpm.engine.task.Task;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {
    private String taskId;
    private String name;
    private String assignee;
    private String formKey;

    public TaskDto(Task task) {
        this.taskId = task.getId();
        this.name = task.getName();
        this.assignee = task.getAssignee();
        this.formKey = task.getFormKey();
    }
}
