<#macro dto_macro docsUrl="">
<#-- Generated From File: fluxnova-docs-manual/public/reference/rest/execution/post-signal/index.html -->
    <@lib.dto desc = "">

        <@lib.property
        name = "variables"
        type = "object"
        additionalProperties = true
        dto = "VariableValueDto"
        desc = "A JSON object containing variable key-value pairs. Each key is a variable name and
                each value a JSON variable value object."
        />

        <@lib.property
        name = "taskId"
        type = "string"
        desc = "The task ids for which task update needs to be done." />

        <@lib.property
        name = "status"
        type = "string"
        desc = "The status of the update operation." />

        <@lib.property
        name = "errorMessage"
        type = "string"
        last =  true
        desc = "The error details related to update operation failure." />


    </@lib.dto>
</#macro>