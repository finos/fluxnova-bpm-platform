package ${package}.process.delegates;

import ${package}.domain.constants.BPMConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.finos.fluxnova.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Delegate responsible for sending notifications based on loan application approval status.
 * <p>
 * As part of the LoanApplicationProcess, this delegate is invoked by Send Notification service task,
 * to notify relevant parties about the approval or rejection of a loan request.
 * </p>
 *
 * @see DelegateExecution
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SendNotificationDelegate {
    /**
     * Executes the notification logic based on the approval status.
     * <p>
     * Processing here should be lightweight - ideally delegating to a service call
     * for actual notification delivery (email, SMS, etc.).
     * </p>
     *  <p><strong>Production Architecture:</strong></p>
     *  <p>
     *  Note that any inline processing using this pattern will have an impact on performance, so keep it lightweight.
     * @param delegateExecution the execution context containing process variables
     * @throws Exception if notification processing fails
     */
    public void execute(DelegateExecution delegateExecution) throws Exception {
        if (Objects.nonNull(delegateExecution.getVariable(BPMConstants.VAR_IS_APPROVED))) {
            boolean isReviewApproved = (boolean) delegateExecution.getVariable(BPMConstants.VAR_IS_APPROVED);
            if (isReviewApproved) {
                log.info("Sending APPROVED notification");
                // TODO: Delegate to notification service for actual delivery
            } else {
                log.info("Sending REJECTED notification");
                // TODO: Delegate to notification service for actual delivery
            }
        } else {
            log.info("Loan processing timed out. Sending CANCELLED notification");
            // TODO: Delegate to notification service for actual delivery
        }
    }
}
