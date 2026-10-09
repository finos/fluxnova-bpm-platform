<#macro dto_macro docsUrl="">
<@lib.dto
    required = ['"configValue"']>

    <@lib.property
        name = "configValue"
        type = "string"
        nullable = false
        last = true
        desc = "The new configuration value." />

</@lib.dto>
</#macro>
