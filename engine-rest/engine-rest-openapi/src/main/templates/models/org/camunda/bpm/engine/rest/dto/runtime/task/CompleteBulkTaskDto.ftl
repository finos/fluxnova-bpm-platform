<#macro dto_macro docsUrl="">
    <@lib.dto>

        <@lib.property
        name = "taskId"
        type = "string"
        desc = "The task id." />

        <@lib.property
        name = "variables"
        type = "object"
        dto = "VariableValueDto"
        last =  true
        desc = "A JSON object containing variable key-value pairs." />

    </@lib.dto>

</#macro>