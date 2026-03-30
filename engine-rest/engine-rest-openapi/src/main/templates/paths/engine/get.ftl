<#macro endpoint_macro docsUrl="">
{
  <@lib.endpointInfo
      id = "getProcessEngines"
      tag = "Engine"
      summary = "Get List"
      desc = "Retrieves the names of all process engines available on your platform.
              If the query parameter `allNamingDetails` is set to `true`, each engine entry also includes
              `description`, `groupName`, and `groupDescription`.
              **Note**: You cannot prepend `/engine/{name}` to this method." />

  "parameters" : [
    <@lib.parameter
        name = "allNamingDetails"
        location = "query"
        type = "boolean"
        required = false
        last = true
        desc = "Set to `true` to include `description`, `groupName`, and `groupDescription`.
                Defaults to `false` (name-only response)."/>
  ],

  "responses" : {
    <@lib.response
        code = "200"
        dto = "ProcessEngineDto"
        array = true
        last=true
        desc = "Request successful."
        examples = ['"example-1": {
                       "summary": "Default response (name only)",
                       "value": [
                         {
                           "name": "default"
                         },
                         {
                           "name": "anotherEngineName"
                         }
                       ]
                     },
                     "example-2": {
                       "summary": "Response with allNamingDetails=true",
                       "value": [
                         {
                           "name": "default",
                           "description": "default",
                           "groupName": "default",
                           "groupDescription": "default"
                         },
                         {
                           "name": "anotherEngineName",
                           "description": "anotherEngineDescription",
                           "groupName": "anotherEngineGroupName",
                           "groupDescription": "anotherEngineGroupDescription"
                         }
                       ]
                     }'] />
  }
}

</#macro>