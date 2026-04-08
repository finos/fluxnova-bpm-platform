<#macro endpoint_macro docsUrl="">
{
  <@lib.endpointInfo
      id = "getProcessEngines"
      tag = "Engine"
      summary = "Get List"
      desc = "Retrieves the names of all process engines available on your platform.
              If the engine is configured with them the entry also includes
              `description`, `groupName`, and `groupDescription`.
              **Note**: You cannot prepend `/engine/{name}` to this method." />

  "parameters" : [],
  "responses" : {
    <@lib.response
        code = "200"
        dto = "ProcessEngineDto"
        array = true
        last=true
        desc = "Request successful."
        examples = ['"example-1": {
                       "summary": "Default response (name only) without extra configuration",
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
                       "summary": "Response with new configuration",
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