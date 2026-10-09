<#macro endpoint_macro docsUrl="">
{
  <@lib.endpointInfo
      id = "getConfigurations"
      tag = "Configuration"
      summary = "Get Configurations"
      desc = "Retrieves the configurations applicable to a tenant.

              If `tenantId` is omitted or blank, global default configurations are returned.
              If `tenantId` is set, active global configurations are returned, and the tenant's
              active entry replaces the global entry for the same `configKey`.

              By default, only configurations with status `ACTIVE` are returned. Set
              `includeInactive` to `true` to return all entries of every status without
              merging: the global entries and, if `tenantId` is set, the tenant's entries.
              Results are ordered by `configKey`, then global before tenant, then `version`."
  />

  "parameters": [

    <@lib.parameter
        name = "tenantId"
        location = "query"
        type = "string"
        desc = "The tenant whose applicable configurations to retrieve. Tenant entries override global entries with the same key. If omitted or blank, retrieves global defaults only." />

    <@lib.parameter
        name = "includeInactive"
        location = "query"
        type = "boolean"
        defaultValue = "false"
        last = true
        desc = "Whether to return all entries of every status for the global scope and the tenant, without merging. By default, only the applicable active configurations are returned." />
  ],

  "responses": {

    <@lib.response
        code = "200"
        dto = "ConfigurationDto"
        array = true
        last = true
        desc = "Request successful."
        examples = ['"global-configurations": {
                       "summary": "GET `/configurations`",
                       "value": [
                         {
                           "id": "8a6cf4aa-6db5-4b95-9871-1f0f9ef8b2f5",
                           "configKey": "mail.from",
                           "configValue": "noreply@example.org",
                           "version": 1,
                           "status": "ACTIVE",
                           "createdBy": "demo",
                           "createdAt": "2026-08-20T14:00:00.000+0000",
                           "updatedBy": "demo",
                           "updatedAt": "2026-08-20T14:00:00.000+0000"
                         }
                       ]
                     }',
                    '"tenant-configurations": {
                       "summary": "GET `/configurations?tenantId=tenant-a`",
                       "value": [
                         {
                           "id": "8a6cf4aa-6db5-4b95-9871-1f0f9ef8b2f5",
                           "configKey": "mail.from",
                           "tenantId": "tenant-a",
                           "configValue": "noreply@tenant-a.example.org",
                           "version": 1,
                           "status": "ACTIVE",
                           "createdBy": "demo",
                           "createdAt": "2026-08-20T14:00:00.000+0000",
                           "updatedBy": "demo",
                           "updatedAt": "2026-08-20T14:00:00.000+0000"
                         },
                         {
                           "id": "bf77b760-4b6e-40a7-a3ad-0c8d026270c8",
                           "configKey": "mail.replyTo",
                           "configValue": "support@example.org",
                           "version": 1,
                           "status": "ACTIVE",
                           "createdBy": "demo",
                           "createdAt": "2026-08-19T14:00:00.000+0000",
                           "updatedBy": "demo",
                           "updatedAt": "2026-08-19T14:00:00.000+0000"
                         }
                       ]
                     }']
    />

  }
}
</#macro>
