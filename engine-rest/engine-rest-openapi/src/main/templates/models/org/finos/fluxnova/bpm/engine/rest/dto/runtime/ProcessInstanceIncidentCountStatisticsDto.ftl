<#macro dto_macro docsUrl="">
    <@lib.dto>


        <@lib.property
        name = "processInstanceId"
        type = "string"
        desc = "Process instance id" />


        <@lib.property
        name = "incidentCount"
        type = "number"
        last = true
        desc = "Incident count of the process instance id" />


    </@lib.dto>
</#macro>