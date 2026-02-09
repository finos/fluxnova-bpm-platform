<#macro dto_macro docsUrl="">
<@lib.dto>

    <@lib.property
        name = "completeTasksDto"
        type = "array"
        dto = "CompleteTasksDto"
        desc = "A list that contains task ID's and its associated variables"/>

    <@lib.property
        name = "withVariablesInReturn"
        type = "boolean"
        defaultValue = "false"
        last =  true
        desc = "Indicates whether the response should contain the process variables or not. The
                default is `false` with a response code of `204`. If set to `true` the response
                contains the process variables and has a response code of `200`. If the task is not
                associated with a process instance (e.g. if it's part of a case instance) no
                variables will be returned." />

</@lib.dto>

</#macro>
