<#macro endpoint_macro docsUrl="">
{
  <@lib.endpointInfo
      id = "createConfiguration"
      tag = "Configuration"
      summary = "Create Configuration"
      desc = "Creates a new process configuration entry.

              If `tenantId` is omitted or blank, the entry is created as a global configuration.
              A duplicate active `(configKey, tenantId)` scope returns `409 Conflict`."
  />

  <@lib.requestBody
      mediaType = "application/json"
      dto = "CreateConfigurationDto"
      examples = ['"example-1": {
                     "summary": "POST `/configurations`",
                     "value": {
                       "configKey": "mail.from",
                       "configValue": "noreply@example.org",
                       "tenantId": "tenant-a"
                     }
                   }',
                  '"example-2": {
                     "summary": "POST `/configurations` (global)",
                     "value": {
                       "configKey": "mail.from",
                       "configValue": "noreply-global@example.org"
                     }
                   }']
  />

  "responses": {

    <@lib.response
        code = "201"
        dto = "ConfigurationDto"
        desc = "Request successful."
        examples = ['"example-1": {
                       "summary": "Status 201.",
                       "value": {
                         "id": "8a6cf4aa-6db5-4b95-9871-1f0f9ef8b2f5",
                         "configKey": "mail.from",
                         "tenantId": "tenant-a",
                         "configValue": "noreply@example.org",
                         "version": 1,
                         "status": "ACTIVE",
                         "createdBy": "demo",
                         "createdAt": "2026-08-20T14:00:00.000+0000",
                         "updatedBy": "demo",
                         "updatedAt": "2026-08-20T14:00:00.000+0000"
                       }
                     }']
    />

    <@lib.response
        code = "400"
        dto = "ExceptionDto"
        desc = "Returned if `configKey` or `configValue` is missing or blank."
    />

    <@lib.response
        code = "409"
        dto = "ExceptionDto"
        desc = "Returned if an active configuration with the same `(configKey, tenantId)` already exists."
    />

    <@lib.response
        code = "500"
        dto = "ExceptionDto"
        desc = "The configuration could not be created due to an internal server error."
        last = true
    />
  }
}
</#macro>
