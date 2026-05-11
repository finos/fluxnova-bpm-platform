<#macro dto_macro docsUrl="">
    <@lib.dto
    desc = "List of process instance ids." >

        <@lib.property
        name="processInstanceIds"
        type = "array"
        itemType = "string"
        last = true
        desc = "List of process instance ids."/>

    </@lib.dto>

</#macro>