package ${package}.process;

import ${package}.domain.constants.BPMConstants;
import lombok.extern.slf4j.Slf4j;
import org.finos.fluxnova.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * Service for evaluating loan approval decisions in BPMN process flows.
 * <p>
 * This service is invoked from the BPMN exclusive gateway to determine which path
 * the process should take based on the loan approval status.
 * </p>
 *
 * <p><strong>BPMN Usage:</strong></p>
 * <p>
 * This service is called from the exclusive gateway "Gateway_IsLoanRequestApproved"
 * in the loan_application.bpmn process. It's used in the condition expression of the
 * "Flow_LoanRequestApproved" sequence flow.
 * </p>
 *
 * <p><strong>Process Flow:</strong></p>
 * <ol>
 *   <li>User completes "Review Loan" task and sets the 'isApproved' variable</li>
 *   <li>Process reaches exclusive gateway "Gateway_IsLoanRequestApproved"</li>
 *   <li>This service evaluates the condition on the "Yes" flow</li>
 *   <li>If true → proceeds to "Create Loan Account"</li>
 *   <li>If false → takes default flow to "Send Notification" (rejection)</li>
 * </ol>
 *
 * @see DelegateExecution
 */
@Slf4j
@Service("loanReviewService")
public class LoanReviewService {
    /**
     * Determines if a loan application has been approved.
     * <p>
     * This method is called from the BPMN exclusive gateway condition expression.
     * It checks the 'isApproved' process variable that was set during the
     * "Review Loan" user task.
     * </p>
     *
     * <p><strong>Note:</strong></p>
     * <ul>
     *   <li>Keep this method lightweight - it's called during process execution</li>
     *   <li>Avoid external API calls or database operations here</li>
     *   <li>For complex approval logic, consider delegating to a separate service</li>
     * </ul>
     *
     *
     * @param delegateExecution the execution context containing process variables,
     *                          specifically expects 'isApproved' boolean variable
     * @return true if the loan is approved, false otherwise (including when variable is not set)
     */
    public boolean isApproved(DelegateExecution delegateExecution){
        // Check if approval variable exists
        if (Objects.nonNull(delegateExecution.getVariable(BPMConstants.VAR_IS_APPROVED))) {
            boolean isRequestApproved = (boolean) delegateExecution.getVariable(BPMConstants.VAR_IS_APPROVED);

            log.debug("WORKFLOW - Loan approval decision: {}", isRequestApproved);
            return isRequestApproved;
        }

        // Default to false if variable not set (defensive programming)
        log.warn("WORKFLOW - isApproved variable not found, defaulting to false");
        return false;
    }
}
