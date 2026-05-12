package ${package}.process.externaltask;

import lombok.extern.slf4j.Slf4j;
import org.finos.fluxnova.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.finos.fluxnova.bpm.client.task.ExternalTask;
import org.finos.fluxnova.bpm.client.task.ExternalTaskHandler;
import org.finos.fluxnova.bpm.client.task.ExternalTaskService;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.UUID;

/**
 * External Task handler for creating loan accounts.
 * <p>
 * <strong>NOTE:</strong> This is an External Task handler. This pattern is used to offload
 * resource-intensive or domain-specific processing to another microservice and is key to
 * Service Orchestration capabilities.
 * </p>
 *
 * <p><strong>Production Architecture:</strong></p>
 * <p>
 * In a real-world example, this service (and its associated pom dependencies) will be
 * implemented in another microservice. This handler is currently implemented within the
 * same project for demo purposes. Doing so will decouple the process engine from the
 * worker implementation, improving scalability and maintainability.
 * </p>
 *
 * <p><strong>Benefits of External Task Pattern:</strong></p>
 * <ul>
 *   <li><strong>Decoupling:</strong> Separates workflow orchestration from business logic execution</li>
 *   <li><strong>Scalability:</strong> Workers can be scaled independently from the process engine</li>
 *   <li><strong>Technology Freedom:</strong> Workers possibly be written in any language/framework</li>
 *   <li><strong>Resilience:</strong> Failures in workers don't crash the process engine</li>
 *   <li><strong>Flexibility:</strong> Easy to add/remove workers without redeploying the engine</li>
 * </ul>
 *
 * <p><strong>How External Tasks Work:</strong></p>
 * <ol>
 *   <li>Process reaches an External Task service task in BPMN</li>
 *   <li>Task is created with a specific topic name (e.g., "createLoanAccount")</li>
 *   <li>External worker polls for tasks on that topic using REST APIs</li>
 *   <li>Worker locks the task, executes business logic, and completes it</li>
 *   <li>Process continues to the next step</li>
 * </ol>
 *
 * <p><strong>Configuration:</strong></p>
 * <p>
 * This handler is supported by:
 * </p>
 * <ul>
 *   <li>Properties under <code># Fluxnova external task configuration</code> in application.properties</li>
 *   <li><code>fluxnova-bpm-spring-boot-starter-external-task-client</code> dependency in pom.xml</li>
 *   <li><code>fluxnova-bpm-spring-boot-starter-rest</code> dependency in pom.xml</li>
 * </ul>
 *
 * <p><strong>Moving to Production:</strong></p>
 * <p>
 * To deploy this as a separate microservice:
 * </p>
 * <ol>
 *   <li>Create a new Spring Boot project with External Task Client dependencies and properties</li>
 *   <li>Move this handler class to the new project</li>
 *   <li>Configure the client to connect to the Fluxnova REST API</li>
 *   <li>Deploy and scale the worker independently</li>
 * </ol>
 *
 * @see ExternalTaskHandler
 * @see ExternalTaskSubscription
 * @see <a href="https://docs.fluxnova.finos.org/user-guide/process-engine/external-tasks/">Fluxnova External Task Documentation</a>
 */

@Slf4j
@Component
@ExternalTaskSubscription("createLoanAccount")
public class CreateLoanAccountTaskHandler implements ExternalTaskHandler {
    /**
     * Executes the external task to create a loan account.
     * <p>
     * This method is automatically invoked when an external task with topic
     * "createLoanAccount" is available and locked by this worker.
     * </p>
     *
     * <p><strong>Current Implementation (Demo):</strong></p>
     * <p>
     * Generates a random UUID as a loan account number for demonstration purposes.
     * </p>
     *
     *
     * <p><strong>Error Handling:</strong></p>
     * <p>
     * If this method throws an exception, the task will be retried according to
     * the retry configuration.
     * </p>
     *
     * @param externalTask the external task containing process variables and metadata
     * @param externalTaskService service to complete, fail, or extend lock on the task
     */
    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {
        // Demo implementation - generate random account number
        String loanAccountNumber = UUID.randomUUID().toString();
        log.info("Created new loan account with loan account number: {}", loanAccountNumber);

        // Complete the task and return the account number to the process
        externalTaskService.complete(
                externalTask,
                Collections.singletonMap("loanAccountNumber", loanAccountNumber)
        );
    }
}
