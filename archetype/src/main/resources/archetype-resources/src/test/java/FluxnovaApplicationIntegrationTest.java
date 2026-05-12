package ${package};

import com.jayway.jsonpath.JsonPath;
import ${package}.domain.TaskDto;
import org.finos.fluxnova.bpm.engine.HistoryService;
import org.finos.fluxnova.bpm.engine.RuntimeService;
import org.finos.fluxnova.bpm.engine.history.HistoricVariableInstance;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.http.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
class FluxnovaApplicationIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;

    @Test
    void startProcess_andCompleteFlow() {
        // Step 1: Start process
        Map<String, Object> startVars = Map.of(
                "customerName", "John Doe",
                "birthDate", "1985-05-10",
                "occupation", "Bank Employee",
                "salary", 50000,
                "expectedAmount", 200000
        );

        ResponseEntity<Map> startResponse = restTemplate.postForEntity(
                "/api/workflow/v1.0/start/LoanApplicationProcess",
                startVars,
                Map.class
        );

        assertThat(startResponse.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Map<String, String> responseBody = startResponse.getBody();
        assertThat(responseBody).isNotNull();
        String processInstanceId = responseBody.get("processInstanceId");
        assertThat(processInstanceId).isNotBlank();

        // Step 2: Fetch tasks
        ResponseEntity<TaskDto[]> tasksResponse = restTemplate.getForEntity(
                "/api/workflow/v1.0/tasks/" + processInstanceId,
                TaskDto[].class
        );

        assertThat(tasksResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        TaskDto[] tasks = tasksResponse.getBody();
        assertThat(tasks).isNotEmpty();
        String taskId = tasks[0].getTaskId();

        // Step 3: Assign task
        ResponseEntity<Void> assignResponse = restTemplate.exchange(
                "/api/workflow/v1.0/tasks/" + taskId + "/assign/admin",
                HttpMethod.PATCH,
                null,
                Void.class
        );
        assertThat(assignResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Step 4: Complete task with approval
        Map<String, Object> completeVars = Map.of("isApproved", true);
        HttpEntity<Map<String, Object>> completeEntity = new HttpEntity<>(completeVars);
        ResponseEntity<Void> completeResponse = restTemplate.exchange(
                "/api/workflow/v1.0/tasks/" + taskId + "/complete",
                HttpMethod.PATCH,
                completeEntity,
                Void.class
        );
        assertThat(completeResponse.getStatusCode()).isEqualTo(HttpStatus.OK);

        // Step 5: Complete external task
        completeExternalTask();

        // Step 6: Verify process ended using RuntimeService
        boolean isRunning = runtimeService.createProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .singleResult() != null;
        assertThat(isRunning).isFalse();

        // Step 7: Verify process finished in history
        boolean isEnded = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(processInstanceId)
                .finished()
                .singleResult() != null;
        assertThat(isEnded).isTrue();

        // Step 8: Verify historic variables
        HistoricVariableInstance eligibleAmountVar = historyService.createHistoricVariableInstanceQuery()
                .processInstanceId(processInstanceId)
                .variableName("eligibleAmount")
                .singleResult();
        assertThat(eligibleAmountVar).isNotNull();
        assertThat((Integer) eligibleAmountVar.getValue()).isGreaterThan(0);

        HistoricVariableInstance isApprovedVar = historyService.createHistoricVariableInstanceQuery()
                .processInstanceId(processInstanceId)
                .variableName("isApproved")
                .singleResult();
        assertThat(isApprovedVar).isNotNull();
        assertThat((Boolean) isApprovedVar.getValue()).isTrue();
    }

    /**
     * Assuming the ExternalTaskHandler (CreateLoanAccountTaskHandler) resides in a separate project that uses an External Task Client,
     * here we are manually completing the external task using Fluxnova's native REST APIs
     */
    private void completeExternalTask() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Step 1: Fetch and lock external task
        String fetchBody = "{ \"workerId\": \"testWorker\", \"maxTasks\": 1, \"usePriority\": true, \"topics\": [{ \"topicName\": \"createLoanAccount\", \"lockDuration\": 60000 }] }";
        HttpEntity<String> fetchAndLockRequest = new HttpEntity<>(fetchBody, headers);
        ResponseEntity<String> fetchResponse = restTemplate.postForEntity("/engine-rest/external-task/fetchAndLock", fetchAndLockRequest, String.class);

        // Extract externalTaskId from fetchResponse JSON
        String externalTaskId = JsonPath.read(fetchResponse.getBody(), "$[0].id");

        // Step 2: Complete external task
        String completeBody = "{ \"workerId\": \"testWorker\"}";
        HttpEntity<String> completeRequest = new HttpEntity<>(completeBody, headers);
        restTemplate.postForEntity("/engine-rest/external-task/" + externalTaskId + "/complete", completeRequest, String.class);
    }
}