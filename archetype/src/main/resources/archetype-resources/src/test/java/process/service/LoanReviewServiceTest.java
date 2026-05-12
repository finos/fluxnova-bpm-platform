package ${package}.process.service;

import ${package}.domain.constants.BPMConstants;
import ${package}.process.LoanReviewService;
import org.finos.fluxnova.bpm.engine.delegate.DelegateExecution;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class LoanReviewServiceTest {
    private LoanReviewService loanReviewService = new LoanReviewService();
    @Test
    public void testIsApproved_WhenVariableIsTrue() {
        DelegateExecution execution = mock(DelegateExecution.class);
        when(execution.getVariable(BPMConstants.VAR_IS_APPROVED)).thenReturn(true);

        boolean result = loanReviewService.isApproved(execution);

        assertThat(result).isTrue();
    }

    @Test
    public void testIsApproved_WhenVariableIsFalse() {
        DelegateExecution execution = mock(DelegateExecution.class);
        when(execution.getVariable(BPMConstants.VAR_IS_APPROVED)).thenReturn(false);

        boolean result = loanReviewService.isApproved(execution);

        assertThat(result).isFalse();
    }

    @Test
    public void testIsApproved_WhenVariableIsNull() {
        DelegateExecution execution = mock(DelegateExecution.class);
        when(execution.getVariable(BPMConstants.VAR_IS_APPROVED)).thenReturn(null);

        boolean result = loanReviewService.isApproved(execution);

        assertThat(result).isFalse(); // Should default to false
    }
}
