<#macro dto_macro docsUrl="">
<@lib.dto
    required = ['"configKey"', '"configValue"']>

    <@lib.property
        name = "configKey"
        type = "string"
        nullable = false
        desc = "The configuration key." />

    <@lib.property
        name = "configValue"
        type = "string"
        nullable = false
        desc = "The configuration value." />

    <@lib.property
        name = "tenantId"
        type = "string"
        last = true
        desc = "Optional tenant scope. If omitted or blank, the configuration is created as global." />

</@lib.dto>
</#macro>
