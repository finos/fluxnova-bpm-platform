<#macro dto_macro docsUrl="">
    <@lib.dto>

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