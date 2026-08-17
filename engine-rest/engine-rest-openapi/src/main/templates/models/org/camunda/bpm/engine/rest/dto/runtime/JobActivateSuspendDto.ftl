<#macro dto_macro docsUrl="">
    <@lib.dto
    desc = "List of job ids." >

        <@lib.property
        name = "jobIds"
        type = "array"
        itemType = "string"
        desc = "List of job ids."/>

        <@lib.property
        name = "suspended"
        type = "boolean"
        last = true
        desc = "Supply true for suspending and false for activating."/>

    </@lib.dto>

</#macro>