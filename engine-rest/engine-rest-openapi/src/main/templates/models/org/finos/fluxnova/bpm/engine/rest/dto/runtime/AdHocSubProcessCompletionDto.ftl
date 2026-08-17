<#macro dto_macro docsUrl="">
<@lib.dto desc = "Request payload for completing an ad-hoc subprocess execution.">

	<@lib.property
		name = "variables"
		type = "object"
		additionalProperties = true
		dto = "VariableValueDto"
		desc = "Optional variables to set on the ad hoc subprocess execution before completion."
		last = true
	/>

</@lib.dto>
</#macro>
