<#macro endpoint_macro docsUrl="">
{
  <@lib.endpointInfo
      id = "getConfiguration"
      tag = "Configuration"
      summary = "Get Configuration"
      desc = "Retrieves a configuration by id. Both active and inactive configurations can be retrieved."
  />

  "parameters": [
    <@lib.parameter
        name = "id"
        location = "path"
        type = "string"
        required = true
        last = true
        desc = "The id of the configuration to retrieve." />
  ],

  "responses": {
    <@lib.response
        code = "200"
        dto = "ConfigurationDto"
        desc = "Request successful."
        examples = ['"configuration": {
                       "summary": "GET `/configurations/8a6cf4aa-6db5-4b95-9871-1f0f9ef8b2f5`",
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
        code = "404"
        dto = "ExceptionDto"
        last = true
        desc = "Configuration with the given id does not exist."
    />
  }
}
</#macro>
