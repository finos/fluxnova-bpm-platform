<#macro endpoint_macro docsUrl="">
{
  <@lib.endpointInfo
      id = "updateConfiguration"
      tag = "Configuration"
      summary = "Update Configuration"
      desc = "Updates an active configuration by creating a new version.

              The existing entry is marked `INACTIVE` and a new `ACTIVE` entry with the same
              `configKey` and `tenantId` is created. The new entry receives a new `id` and a
              `version` one greater than the highest existing version for that key and scope."
  />

  "parameters": [
    <@lib.parameter
        name = "id"
        location = "path"
        type = "string"
        required = true
        last = true
        desc = "The id of the active configuration to update." />
  ],

  <@lib.requestBody
      mediaType = "application/json"
      dto = "UpdateConfigurationDto"
      examples = ['"example-1": {
                     "summary": "PUT `/configurations/8a6cf4aa-6db5-4b95-9871-1f0f9ef8b2f5`",
                     "value": {
                       "configValue": "notifications@example.org"
                     }
                   }']
  />

  "responses": {

    <@lib.response
        code = "200"
        dto = "ConfigurationDto"
        desc = "Request successful. Returns the newly created active version."
        examples = ['"example-1": {
                       "summary": "Status 200.",
                       "value": {
                         "id": "3d9b1c22-8f0e-4a7c-9b61-2f4e5c7a1d90",
                         "configKey": "mail.from",
                         "tenantId": "tenant-a",
                         "configValue": "notifications@example.org",
                         "version": 2,
                         "status": "ACTIVE",
                         "createdBy": "demo",
                         "createdAt": "2026-09-29T14:00:00.000+0000",
                         "updatedBy": "demo",
                         "updatedAt": "2026-09-29T14:00:00.000+0000"
                       }
                     }']
    />

    <@lib.response
        code = "400"
        dto = "ExceptionDto"
        desc = "Returned if the request body is missing or `configValue` is missing or blank."
    />

    <@lib.response
        code = "404"
        dto = "ExceptionDto"
        desc = "Configuration with the given id does not exist."
    />

    <@lib.response
        code = "409"
        dto = "ExceptionDto"
        desc = "Returned if the configuration is not active or was modified concurrently."
        last = true
    />
  }
}
</#macro>
