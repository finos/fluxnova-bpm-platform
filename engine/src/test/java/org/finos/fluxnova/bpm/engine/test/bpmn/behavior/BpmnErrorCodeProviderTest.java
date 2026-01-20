package org.finos.fluxnova.bpm.engine.test.bpmn.behavior;

import org.finos.fluxnova.bpm.engine.delegate.BpmnErrorCodeProvider;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BpmnErrorCodeProviderTest {
    static class CustomBpmnException extends Exception implements BpmnErrorCodeProvider {
        @Override
        public String getErrorCode() {
            return "CUSTOM_ERROR_CODE";
        }
    }

    @Test
    public void shouldReturnCustomErrorCode() {
        CustomBpmnException exception = new CustomBpmnException();
        assertThat(exception.getErrorCode()).isEqualTo("CUSTOM_ERROR_CODE");
    }
}
