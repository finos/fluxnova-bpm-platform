package ${package}.process.listeners;

import ${package}.domain.constants.BPMConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.finos.fluxnova.bpm.engine.delegate.DelegateExecution;
import org.finos.fluxnova.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Execution listener that calculates the customer's age from their birth date.
 * <p>
 * This listener is triggered at the <strong>start event</strong> of the loan application process
 * (configured in the BPMN as an execution listener on the "Loan Request Received" start event).
 * It executes when the process instance is created, before any user tasks are reached.
 * </p>
 *
 * @see DelegateExecution
 * @see ExecutionListener
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ProcessCreateListener {
    /**
     * Calculates and sets the customer's age based on their birth date,
     * where age is used as one of the deciding factors to calculate eligible amount
     * by the following Calculate Eligible Amount Rule Task in the process.
     *
     * <p>
     * <strong>Note:</strong>
     * This method should remain lightweight - it performs a simple calculation and sets a variable.
     * For more complex operations, consider delegating to a separate microservice.
     * </p>
     *
     * @param delegateExecution the execution context containing process variables
     *                          including the required 'birthDate' variable
     * @throws IllegalArgumentException if birthDate is null or invalid format
     */
    public void notify(DelegateExecution delegateExecution) throws IllegalArgumentException {
        // Only execute if we have a valid activity instance (process is actually running)
        if (delegateExecution.getActivityInstanceId() != null) {
            // Retrieve birth date from process variables
            LocalDate birthDate = LocalDate.parse(
                    (String) delegateExecution.getVariable(BPMConstants.VAR_BIRTHDATE)
            );
            // Calculate age - keep processing lightweight
            Integer age = birthDate.until(LocalDate.now()).getYears();

            // Set age as process variable for use in DMN decision table
            delegateExecution.setVariable(BPMConstants.VAR_AGE, age);
            log.debug("Calculated age {} for customer with birth date {}", age, birthDate);
        }
    }
}
