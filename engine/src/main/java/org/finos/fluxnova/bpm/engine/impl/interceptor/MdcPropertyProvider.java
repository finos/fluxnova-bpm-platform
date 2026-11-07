package org.finos.fluxnova.bpm.engine.impl.interceptor;

import org.finos.fluxnova.bpm.engine.impl.persistence.entity.ExecutionEntity;

@FunctionalInterface
public interface MdcPropertyProvider {

    /**
     * Computes the MDC property value for the given execution context.
     *
     * @param execution the current execution entity, may be null
     * @return the computed property value, or null if the property cannot be determined
     */
    String getPropertyValue(ExecutionEntity execution);
}

