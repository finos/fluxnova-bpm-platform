package ${package}.request.controller;

import ${package}.domain.TaskDto;
import ${package}.domain.exception.InvalidClaimException;
import ${package}.request.service.WorkFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * REST Controller providing simplified workflow operations for demonstration purposes.
 * <p>
 * This controller uses WorkflowService which wraps Fluxnova's native services (RuntimeService, TaskService) to provide:
 * </p>
 * <ul>
 *   <li><strong>Educational Examples:</strong> Demonstrates how to use Fluxnova services in a Spring Boot application</li>
 *   <li><strong>Simplified API:</strong> Provides a cleaner, domain-specific REST API compared to Fluxnova's generic REST API</li>
 *   <li><strong>Business Context:</strong> Adds business meaning to generic workflow operations</li>
 *   <li><strong>Customization Point:</strong> Allows adding validation, security, and business logic before calling Fluxnova</li>
 *   <li><strong>Abstraction Layer:</strong> Decouples client applications from direct Fluxnova API dependencies</li>
 * </ul>
 *
 * <p>
 * <strong>Production Considerations:</strong>
 * </p>
 * <ul>
 *   <li>Add proper authentication and authorization (e.g., Spring Security, JWT)</li>
 *   <li>Implement input validation and error handling</li>
 *   <li>Add rate limiting and request throttling</li>
 *   <li>Include audit logging for compliance</li>
 *   <li>Consider using DTOs instead of exposing internal domain models</li>
 *   <li>Add API versioning for backward compatibility</li>
 * </ul>
 *
 * <p>
 * <strong>Alternative Approach:</strong>
 * </p>
 * <p>
 * You could use Fluxnova's native REST API directly at:
 * {@code http://localhost:8080/engine-rest}
 * </p>
 * <p>
 * However, this controller demonstrates best practices for enterprise applications
 * where you want control over your API contract and business logic.
 * </p>
 *
 * @see WorkFlowService
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/workflow/v1.0")
public class WorkflowController {
    private final WorkFlowService workFlowService;

    /**
     * Starts a new process instance.
     * <p>
     * This endpoint demonstrates how to start a Fluxnova process instance programmatically
     * through the WorkflowService, which wraps the RuntimeService.
     * </p>
     *
     * <p><strong>How to Find the Process Definition Key:</strong></p>
     * <ol>
     *   <li>Open your BPMN file (e.g., loan_application.bpmn)</li>
     *   <li>Look for the {@code <bpmn:process>} element</li>
     *   <li>The {@code id} attribute is your processDefinitionKey</li>
     *   <li>Example: {@code <bpmn:process id="LoanApplicationProcess">}</li>
     *   <li>In this case, processDefinitionKey = "LoanApplicationProcess"</li>
     * </ol>
     *
     * <p><strong>Alternative Methods to Find Process Definition Key:</strong></p>
     * <ul>
     *   <li>In Fluxnova Modeler: Check the "General" tab of the process properties</li>
     * </ul>
     *
     * <p><strong>Example Request:</strong></p>
     * <pre>
     * POST /api/workflow/v1.0/start/LoanApplicationProcess
     * Content-Type: application/json
     *
     * {
     *   "customerName": "John Doe",
     *   "birthDate": "1985-05-10",
     *   "occupation": "Bank Employee",
     *   "salary": 50000,
     *   "requestedAmount": 200000
     * }
     * </pre>
     *
     * <p><strong>Example Response:</strong></p>
     * <pre>
     * {
     *   "processInstanceId": "a1b2c3d4-e5f6-7890-abcd-ef1234567890"
     * }
     * </pre>
     *
     * @param processDefinitionKey the unique identifier of the process definition (from BPMN file's process id attribute)
     * @param processVariablesMap  initial process variables as key-value pairs
     * @return ResponseEntity containing the created processInstanceId
     */
    @PostMapping("start/{processDefinitionKey}")
    public ResponseEntity<Map> startProcess(@PathVariable("processDefinitionKey") String processDefinitionKey,
                                            @RequestBody Map<String, Object> processVariablesMap) {
        String processInstanceId = workFlowService.startProcess(processDefinitionKey, processVariablesMap);
        return new ResponseEntity<>(Collections.singletonMap("processInstanceId", processInstanceId), HttpStatus.CREATED);
    }

    /**
     * Retrieves all tasks for a specific process instance.
     * <p>
     * This endpoint demonstrates how to query tasks through the WorkflowService, which wraps the TaskService.
     * Useful for displaying pending tasks to users or monitoring process progress.
     * </p>
     *
     * <p><strong>Example Request:</strong></p>
     * <pre>
     * GET /api/workflow/v1.0/tasks/a1b2c3d4-e5f6-7890-abcd-ef1234567890
     * </pre>
     *
     * <p><strong>Example Response:</strong></p>
     * <pre>
     * [
     *   {
     *     "taskId": "task-123",
     *     "name": "Review Loan",
     *     "assignee": null,
     *     "formKey": "loanRequestReviewForm"
     *   }
     * ]
     * </pre>
     *
     * @param processInstanceId the unique identifier of the process instance
     * @return ResponseEntity containing a list of TaskDto objects
     */
    @GetMapping("tasks/{processInstanceId}")
    public ResponseEntity<List<TaskDto>> listTasks(@PathVariable("processInstanceId") String processInstanceId) {
        List<TaskDto> taskList = workFlowService.listTasksByProcessInstanceId(processInstanceId);
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }

    /**
     * Assigns a task to a specific user.
     * <p>
     * This endpoint demonstrates task claiming functionality.
     * In a production system, the assignee would typically come from the authenticated
     * user's JWT token or session, not from the request path.
     * </p>
     *
     * <p><strong>Security Note:</strong></p>
     * <p>
     * The current implementation accepts assignee as a path parameter for demonstration.
     * In production, replace this with:
     * </p>
     * <pre>
     * String assignee = SecurityContextHolder.getContext().getAuthentication().getName();
     * // or extract from JWT token
     * </pre>
     *
     * <p><strong>Example Request:</strong></p>
     * <pre>
     * PATCH /api/workflow/v1.0/tasks/task-123/assign/admin
     * </pre>
     *
     * @param taskId   the unique identifier of the task
     * @param assignee the username to assign the task to (in production, get from security context)
     * @return ResponseEntity with HTTP 200 if successful
     * @throws InvalidClaimException if the task is already claimed by another user
     */
    @PatchMapping("tasks/{taskId}/assign/{assignee}")
    public ResponseEntity<List<TaskDto>> assignTask(@PathVariable("taskId") String taskId,
                                                    @PathVariable("assignee") String assignee) throws InvalidClaimException {
        // TODO: In production, replace assignee parameter with authenticated user from JWT/Security Context
        // Example: String assignee = SecurityContextHolder.getContext().getAuthentication().getName();
        workFlowService.setAssignee(assignee, taskId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Completes a task and optionally sets process variables.
     * <p>
     * This endpoint demonstrates how to complete user tasks and update process variables.
     * The variables provided in the request body will be merged into the process instance.
     * </p>
     *
     * <p><strong>Example Request:</strong></p>
     * <pre>
     * PATCH /api/workflow/v1.0/tasks/task-123/complete
     * Content-Type: application/json
     *
     * {
     *   "isApproved": true,
     *   "reviewerComments": "Application looks good"
     * }
     * </pre>
     *
     * <p><strong>What Happens:</strong></p>
     * <ol>
     *   <li>Task is marked as completed</li>
     *   <li>Process variables are updated with provided values</li>
     *   <li>Process execution continues to the next step</li>
     *   <li>Any gateway conditions are evaluated with updated variables</li>
     * </ol>
     *
     * @param taskId                    the unique identifier of the task to complete
     * @param processInstanceVariables  variables to set/update in the process instance
     * @return ResponseEntity with HTTP 200 if successful
     */
    @PatchMapping("tasks/{taskId}/complete")
    public ResponseEntity completeTask(@PathVariable("taskId") String taskId,
                                       @RequestBody Map<String, Object> processInstanceVariables) {
        workFlowService.completeTask(taskId, processInstanceVariables);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
