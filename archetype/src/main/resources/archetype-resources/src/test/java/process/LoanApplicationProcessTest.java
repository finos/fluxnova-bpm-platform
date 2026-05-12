package ${package}.process;

import ${package}.process.externaltask.CreateLoanAccountTaskHandler;
import ${package}.process.delegates.SendNotificationDelegate;
import ${package}.process.listeners.ProcessCreateListener;
import org.finos.fluxnova.bpm.engine.externaltask.ExternalTask;
import org.finos.fluxnova.bpm.engine.externaltask.LockedExternalTask;
import org.finos.fluxnova.bpm.engine.runtime.ProcessInstance;
import org.finos.fluxnova.bpm.engine.test.mock.Mocks;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.finos.fluxnova.bpm.engine.task.Task;

import org.finos.fluxnova.bpm.engine.test.assertions.bpmn.BpmnAwareTests;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.finos.fluxnova.bpm.engine.test.assertions.bpmn.BpmnAwareTests.*;
import static org.finos.fluxnova.bpm.engine.test.assertions.bpmn.BpmnAwareTests.externalTaskService;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
public class LoanApplicationProcessTest {
    @Spy
    private ProcessCreateListener processCreateListener;
    @Spy
    private LoanReviewService loanReviewService;
    @Spy
    private CreateLoanAccountTaskHandler createLoanAccountTaskHandler;
    @Spy
    private SendNotificationDelegate sendNotificationDelegate;

    @BeforeEach
    public void setup() {
        Mocks.register("processCreateListener", processCreateListener);
        Mocks.register("createLoanAccountDelegate", createLoanAccountTaskHandler);
        Mocks.register("sendNotificationDelegate", sendNotificationDelegate);
        Mocks.register("loanReviewService", loanReviewService);
    }

    @Test
    public void testLoanApplicationApproved() {
        // Step 1: Start process with initial variables
        Map<String, Object> variables = new HashMap<>();
        variables.put("customerName", "John Doe");
        variables.put("birthDate", "1985-05-10");
        variables.put("occupation", "Bank Employee");
        variables.put("salary", 50000);
        variables.put("expectedAmount", 200000);

        ProcessInstance processInstance = runtimeService()
                .startProcessInstanceByKey("LoanApplicationProcess", variables);

        BpmnAwareTests.assertThat(processInstance).isStarted().isWaitingAt("Task_ReviewLoan");

        // Step 2: Verify age calculation by Start Event listener
        Integer age = (Integer) runtimeService().getVariable(processInstance.getId(), "age");
        assertThat(age).isNotNull().isGreaterThan(18);

        // Step 3: Verify eligible amount from Rule Task listener
        Integer eligibleAmount = (Integer) runtimeService().getVariable(processInstance.getId(), "eligibleAmount");
        assertThat(eligibleAmount).isNotNull().isGreaterThan(0);

        // Step 4: Complete User Task with isApproved = true
        Task userTask = taskService().createTaskQuery()
                .taskDefinitionKey("Task_ReviewLoan")
                .singleResult();
        BpmnAwareTests.assertThat(userTask).isNotNull();

        Map<String, Object> approvalVars = new HashMap<>();
        approvalVars.put("isApproved", true);
        taskService().complete(userTask.getId(), approvalVars);

        // Step 5: Query external task and complete with engine's externalTaskService (not client's externalTaskService)
        ExternalTask createLoanAccountTask = externalTaskService().createExternalTaskQuery()
                .processInstanceId(processInstance.getId())
                .topicName("createLoanAccount")
                .singleResult();
        assertThat(createLoanAccountTask).isNotNull();
        assertThat(createLoanAccountTask.getTopicName()).isEqualTo("createLoanAccount");
        List<LockedExternalTask> externalTaskList = externalTaskService().fetchAndLock(1, "testWorker")
                .topic("createLoanAccount", 12000)
                .execute();
        externalTaskService().complete(externalTaskList.get(0).getId(), "testWorker");

        // Step 6: Assert conditional flow for approval
        BpmnAwareTests.assertThat(processInstance).hasPassed("Task_CreateLoanAccount", "Task_SendNotification");
        BpmnAwareTests.assertThat(processInstance).isEnded();
    }

    @Test
    public void testLoanApplicationRejected() {
        // Start process
        Map<String, Object> variables = new HashMap<>();
        variables.put("customerName", "Jane Smith");
        variables.put("birthDate", "1990-02-15");
        variables.put("occupation", "Bank Employee");
        variables.put("salary", 30000);
        variables.put("expectedAmount", 150000);

        ProcessInstance processInstance = runtimeService()
                .startProcessInstanceByKey("LoanApplicationProcess", variables);

        BpmnAwareTests.assertThat(processInstance).isStarted().isWaitingAt("Task_ReviewLoan");

        // Complete User Task with isApproved = false
        Task userTask = taskService().createTaskQuery()
                .taskDefinitionKey("Task_ReviewLoan")
                .singleResult();
        BpmnAwareTests.assertThat(userTask).isNotNull();

        Map<String, Object> approvalVars = new HashMap<>();
        approvalVars.put("isApproved", false);
        taskService().complete(userTask.getId(), approvalVars);

        // Assert conditional flow for rejection
        BpmnAwareTests.assertThat(processInstance).hasPassed("Task_SendNotification");
        BpmnAwareTests.assertThat(processInstance).hasNotPassed("Task_CreateLoanAccount");
        BpmnAwareTests.assertThat(processInstance).isEnded();
    }
}