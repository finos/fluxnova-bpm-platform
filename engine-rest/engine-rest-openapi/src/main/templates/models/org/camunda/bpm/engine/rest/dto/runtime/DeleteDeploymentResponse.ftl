<#macro dto_macro docsUrl="">

    <@lib.dto desc = "">

        <@lib.property
        name = "deploymentId"
        type = "string"
        desc = "The id of the deployment." />

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