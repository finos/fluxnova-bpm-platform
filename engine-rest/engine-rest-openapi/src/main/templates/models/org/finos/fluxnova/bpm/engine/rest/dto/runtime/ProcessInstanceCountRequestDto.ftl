<#macro dto_macro docsUrl="">
    <@lib.dto
    desc = "List of process definition ids." >

        <@lib.property
        name = "processDefinitionIds"
        type = "array"
        itemType = "string"
        desc = "List of process definition ids."/>

        <@lib.property
        name = "active"
        type = "boolean"
        last = true
        desc = "Only include active process instances. Value may only be true,
              as false is the default behavior."/>

    </@lib.dto>

</#macro>