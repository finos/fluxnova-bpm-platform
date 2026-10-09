<#macro endpoint_macro docsUrl="">
{
  <@lib.endpointInfo
      id = "deleteConfiguration"
      tag = "Configuration"
      summary = "Delete Configuration"
      desc = "Soft-deletes an active configuration by marking it `INACTIVE`.

              The entry is retained and can still be retrieved by id or by listing
              configurations with `includeInactive=true`."
  />

  "parameters": [
    <@lib.parameter
        name = "id"
        location = "path"
        type = "string"
        required = true
        last = true
        desc = "The id of the active configuration to delete." />
  ],

  "responses": {

    <@lib.response
        code = "204"
        desc = "Request successful. This method returns no content."
    />

    <@lib.response
        code = "404"
        dto = "ExceptionDto"
        desc = "Configuration with the given id does not exist."
    />

    <@lib.response
        code = "409"
        dto = "ExceptionDto"
        desc = "Returned if the configuration is not active."
        last = true
    />
  }
}
</#macro>
