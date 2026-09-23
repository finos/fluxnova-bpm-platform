<#macro dto_macro docsUrl="">
<@lib.dto>

    <@lib.property
        name = "id"
        type = "string"
        desc = "The unique id of the configuration entry." />

    <@lib.property
        name = "configKey"
        type = "string"
        desc = "The configuration key." />

    <@lib.property
        name = "tenantId"
        type = "string"
        desc = "The tenant scope of the configuration. `null` means global scope." />

    <@lib.property
        name = "configValue"
        type = "string"
        desc = "The configuration value." />

    <@lib.property
        name = "version"
        type = "integer"
        format = "int32"
        nullable = false
        desc = "The optimistic lock version of the configuration entry." />

    <@lib.property
        name = "status"
        type = "string"
        enumValues = ['"ACTIVE"', '"DELETED"']
        desc = "The status of the configuration entry." />

    <@lib.property
        name = "createdBy"
        type = "string"
        desc = "The user that created the configuration entry." />

    <@lib.property
        name = "createdAt"
        type = "string"
        format = "date-time"
        desc = "The timestamp when the configuration entry was created." />

    <@lib.property
        name = "updatedBy"
        type = "string"
        desc = "The user that last updated the configuration entry." />

    <@lib.property
        name = "updatedAt"
        type = "string"
        format = "date-time"
        last = true
        desc = "The timestamp when the configuration entry was last updated." />

</@lib.dto>
</#macro>
