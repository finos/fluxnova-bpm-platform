<#macro dto_macro docsUrl="">
<@lib.dto desc = "A single ad hoc activity trigger instruction specifying which activity to trigger and optional variables.">
    
    <@lib.property
        name = "activityId"
        type = "string"
        desc = "The id of the ad hoc activity to trigger within the ad hoc scope."
    />

    <@lib.property
        name = "variables"
        type = "object"
        additionalProperties = true
        dto = "VariableValueDto"
        desc = "An optional JSON object containing variable key-value pairs to set in the triggered activity.
                Each key is a variable name and each value a JSON variable value object."
        last = true
    />


</@lib.dto>
</#macro>
