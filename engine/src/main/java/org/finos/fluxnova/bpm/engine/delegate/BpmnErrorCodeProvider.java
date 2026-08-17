package org.finos.fluxnova.bpm.engine.delegate;

/**
 * Interface to be implemented by exceptions that are intended to provide a BPMN error code.
 * <p>
 * Implement this interface in custom exception classes when you want to propagate a specific
 * BPMN error code to the process engine. The {@link #getErrorCode()} method should return
 * the BPMN error code associated with the exception.
 */

public interface BpmnErrorCodeProvider {
    String getErrorCode();
}
