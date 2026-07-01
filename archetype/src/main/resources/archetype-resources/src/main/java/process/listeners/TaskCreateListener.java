package ${package}.process.listeners;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.finos.fluxnova.bpm.engine.delegate.DelegateTask;
import org.finos.fluxnova.bpm.engine.delegate.TaskListener;
import org.springframework.stereotype.Component;

/**
 * Task listener that executes when a user task is created.
 * <p>
 * This listener is triggered at the <strong>create event</strong> of a user task
 * (configured in the BPMN as a task listener on the user task element).
 * It executes when the task instance is created, before it becomes available to users.
 * </p>
 *
 * <p><strong>Use Case:</strong></p>
 * <p>
 * <strong>This is the place where you can synchronize process data with your domain model.</strong>
 * When a task is created, you can capture process-specific information and persist it
 * to your business database for tracking, reporting, or integration purposes.
 * </p>
 *
 * <p><strong>Process Data You Can Synchronize:</strong></p>
 * <ul>
 *   <li><strong>Task ID:</strong> Unique identifier for the task instance</li>
 *   <li><strong>Process Instance ID:</strong> Link to the running workflow</li>
 *   <li><strong>Process Status:</strong> Current state of the workflow</li>
 *   <li><strong>Task Name:</strong> Human-readable task description</li>
 *   <li><strong>Task Creation Time:</strong> When the task was created</li>
 *   <li><strong>Process Variables:</strong> Business context from the workflow</li>
 * </ul>
 *
 * <p><strong>Benefits of This Approach:</strong></p>
 * <ul>
 *   <li>Your domain model always reflects current workflow state</li>
 *   <li>Business queries don't need to join with Fluxnova tables</li>
 *   <li>Clear separation between process data and business data</li>
 *   <li>Maintain a complete audit trail in your domain database</li>
 *   <li>Easier to build custom UIs and reports</li>
 * </ul>
 *
 * <p><strong>Important Notes:</strong></p>
 * <ul>
 *   <li>Keep processing lightweight - this runs synchronously during task creation</li>
 *   <li>Avoid long-running operations or complex business logic</li>
 *   <li>Task is not yet visible to users at this point</li>
 * </ul>
 *
 * @see DelegateTask
 * @see TaskListener
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TaskCreateListener {
    /**
     * Executes when a user task is created.
     * <p>
     * <strong>Now you can synchronize process data with your domain model:</strong>
     * </p>
     * <ul>
     *   <li>Capture the task ID and store it in your business entity</li>
     *   <li>Update process status in your domain database</li>
     *   <li>Link workflow instance to your business records</li>
     *   <li>Record task creation timestamp for SLA tracking</li>
     *   <li>Extract process variables for business reporting</li>
     * </ul>
     *
     * @param delegateTask the task context containing process metadata and variables
     * @throws Exception if process data synchronization fails
     */
    public void notify(DelegateTask delegateTask) throws Exception {
        // Only execute if we have a valid task instance
        if (delegateTask.getId() != null) {
            String taskId = delegateTask.getId();
            String processInstanceId = delegateTask.getProcessInstanceId();
            String taskName = delegateTask.getName();

            log.debug("Task created - ID: {}, Name: {}, Process: {}",
                    taskId, taskName, processInstanceId);

            // TODO: Implement your process data synchronization logic here
            // Example:
            // 1. Extract task ID, process instance ID, businessKey and other process metadata
            // 2. Call external service and update your domain model with process data (taskId, status, timestamps)
            // 4. Persist changes to your business database

            log.debug("Synchronized task {} ({}) with the application", taskName, taskId);
        }
    }
}
