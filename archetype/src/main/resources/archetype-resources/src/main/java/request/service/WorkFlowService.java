package ${package}.request.service;

import ${package}.domain.TaskDto;
import ${package}.domain.constants.BPMConstants;
import ${package}.domain.exception.InvalidClaimException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.TaskService;
import org.finos.fluxnova.bpm.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Service layer that encapsulates Fluxnova workflow operations.
 * <p>
 * This service wraps Fluxnova's RuntimeService and TaskService to provide:
 * </p>
 * <ul>
 *   <li>Simplified API for common workflow operations</li>
 *   <li>Centralized error handling and logging</li>
 *   <li>Easier unit testing through service abstraction</li>
 *   <li>Consistent business logic across the application</li>
 * </ul>
 *
 * @see RuntimeService
 * @see TaskService
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class WorkFlowService {

    private final RuntimeService runtimeService;
    private final TaskService taskService;

    /**
     * Starts a new process instance.
     * <p>
     * This method wraps Fluxnova's RuntimeService to start a process with
     * a unique business key (UUID) and initial variables.
     * </p>
     *
     * <p><strong>Business Key:</strong></p>
     * <p>
     * A UUID is automatically generated as the business key. This allows you to
     * correlate the process instance with your business entities.
     * In production, you might want to use your own business identifier
     * (e.g., loan application number, customer ID).
     * </p>
     *
     * @param processDefinitionKey the unique identifier of the process definition
     *                            (from BPMN file's {@code <bpmn:process id="...">} attribute)
     * @param processVariablesMap  initial process variables as key-value pairs
     * @return the unique process instance ID
     * @throws org.finos.fluxnova.bpm.engine.exception.NotFoundException
     *         if process definition not found
     */
    public String startProcess(String processDefinitionKey, Map<String, Object> processVariablesMap) {
        return runtimeService.startProcessInstanceByKey(
                processDefinitionKey,
                UUID.randomUUID().toString(),
                processVariablesMap
        ).getProcessInstanceId();
    }

    /**
     * Retrieves all tasks for a specific process instance.
     * <p>
     * <strong>Why This Method Is Needed:</strong>
     * </p>
     * <ul>
     *   <li>Allows users to see all pending tasks in a process instance</li>
     *   <li>Useful for process monitoring and task management UIs</li>
     *   <li>Enables tracking of process progress</li>
     *   <li>Required for displaying task lists to users</li>
     * </ul>
     *
     * <p><strong>Use Cases:</strong></p>
     * <ul>
     *   <li>Display all tasks in a process to a supervisor</li>
     *   <li>Show task progress in a workflow dashboard</li>
     *   <li>Enable task reassignment workflows</li>
     * </ul>
     *
     * @param processInstanceId the unique identifier of the process instance
     * @return list of TaskDto objects representing all tasks in the process
     */
    public List<TaskDto> listTasksByProcessInstanceId(String processInstanceId) {
        List<Task> tasks = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .initializeFormKeys()
                .list();

        return tasks.stream().map(TaskDto::new).collect(Collectors.toList());
    }

    /**
     * Completes a task by taskId without setting additional variables.
     * <p>
     * This is a convenience method that delegates to {@link #completeTask(String, Map)}
     * with null variables.
     * </p>
     *
     * @param taskId the unique identifier of the task to complete
     */
    public void completeTask(String taskId) {
        completeTask(taskId, null);
    }

    /**
     * Completes a task and optionally sets process variables.
     * <p>
     * When a task is completed, the process execution continues to the next step.
     * Any variables provided will be merged into the process instance scope.
     * </p>
     *
     * <p><strong>Variable Scope:</strong></p>
     * <p>
     * Variables set here are available throughout the entire process instance
     * and can be used in:
     * </p>
     * <ul>
     *   <li>Gateway conditions (e.g., approval decisions)</li>
     *   <li>Service task expressions</li>
     *   <li>Subsequent user task forms</li>
     *   <li>Process listeners and delegates</li>
     * </ul>
     *
     * @param taskId    the unique identifier of the task to complete
     * @param variables variables to set/update in the process instance (can be null)
     */
    public void completeTask(String taskId, Map<String, Object> variables) {
        taskService.complete(taskId, variables);
    }

    /**
     * Assigns a task to a specific user (claims the task).
     * <p>
     * In Fluxnova, "assigning" or "claiming" a task means associating it with
     * a specific user who will work on it. This prevents multiple users from
     * working on the same task simultaneously.
     * </p>
     *
     * <p><strong>Requirements to Link a User:</strong></p>
     * <ul>
     *   <li><strong>User Identifier:</strong> A valid username/user ID (string)</li>
     *   <li><strong>Task Must Exist:</strong> The task must be active and not completed</li>
     *   <li><strong>Task Must Be Unassigned:</strong> Or assigned to the same user (re-claim)</li>
     *   <li><strong>User Must Have Permissions:</strong> In production, verify user has rights to claim this task</li>
     * </ul>
     *
     * <p>
     * Currently this method prevents task "stealing" by throwing an exception if the task
     * is already assigned to a different user. This ensures task ownership integrity.
     * </p>
     *
     * <p><strong>Production Considerations:</strong></p>
     * <ul>
     *   <li>Validate user exists in your user management system</li>
     *   <li>Check user has permission to claim this task type</li>
     *   <li>Consider candidate groups (tasks assigned to groups, not individuals)</li>
     *   <li>Add audit logging for compliance</li>
     *   <li>Implement task timeout/auto-reassignment logic</li>
     * </ul>
     *
     * <p><strong>Task States:</strong></p>
     * <pre>
     * Unassigned → setAssignee("user1") → Assigned to user1
     * Assigned to user1 → setAssignee("user1") → Still assigned to user1 (re-claim)
     * Assigned to user1 → setAssignee("user2") → Throws InvalidClaimException
     * Assigned to user1 → setAssignee(null) → Unassigned (release task)
     * </pre>
     *
     * @param assignee the username/user ID to assign the task to (null to unassign)
     * @param taskId   the unique identifier of the task
     * @return the task ID (for method chaining)
     * @throws InvalidClaimException if task is already claimed by a different user
     * @throws org.finos.fluxnova.bpm.engine.exception.NotFoundException
     *         if task not found
     */
    public String setAssignee(String assignee, String taskId) throws InvalidClaimException {
        log.debug("Attempting to assign task {} to user: {}", taskId, assignee);

        // Fetch current task state with form keys
        Task task = taskService.createTaskQuery()
                .taskId(taskId)
                .initializeFormKeys()
                .singleResult();

        String currentAssignee = task.getAssignee();

        // Prevent task stealing: check if already assigned to someone else
        if (assignee!= null &&
                currentAssignee != null &&
                !currentAssignee.isEmpty() &&
                !assignee.equals(currentAssignee)) {
            log.error("Task {} is already claimed by {}, cannot assign to {}",
                    taskId, currentAssignee, assignee);
            throw new InvalidClaimException(
                    currentAssignee + " has already claimed this task"
            );
        }

        // Assign the task
        taskService.setAssignee(taskId, assignee);

        // Store assignee in process variables for audit trail
        taskService.setVariable(taskId, BPMConstants.VAR_ASSIGNEE, assignee);

        log.info("Successfully assigned task {} to user: {}", taskId, assignee);
        return taskId;
    }
}
