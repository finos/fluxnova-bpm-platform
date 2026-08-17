<#macro dto_macro docsUrl="">
    <@lib.dto>


        <@lib.property
        name = "processDefinitionId"
        type = "string"
        desc = "Process definition id" />


        <@lib.property
        name = "instanceCount"
        type = "number"
        last = true
        desc = "Active instance count of the process definition id" />


    </@lib.dto>
</#macro>