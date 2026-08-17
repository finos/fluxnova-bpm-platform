<#macro dto_macro docsUrl="">
<#-- Generated From File: camunda-docs-manual/public/reference/rest/execution/post-signal/index.html -->
    <@lib.dto desc = "">

        <@lib.property
        name = "jobId"
        type = "string"
        desc = "The id of the job." />

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