package org.finos.fluxnova.bpm.engine.rest.dto.runtime;

import java.util.Map;
import org.finos.fluxnova.bpm.engine.rest.dto.VariableValueDto;

/**
 * Request payload for manually completing an ad-hoc subprocess execution.
 */
public class AdHocSubProcessCompletionDto {

	private Map<String, VariableValueDto> variables;

	public Map<String, VariableValueDto> getVariables() {
		return variables;
	}

	public void setVariables(Map<String, VariableValueDto> variables) {
		this.variables = variables;
	}
}
