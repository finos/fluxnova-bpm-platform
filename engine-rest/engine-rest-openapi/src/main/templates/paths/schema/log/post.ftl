<#macro endpoint_macro docsUrl="">
{
  <@lib.endpointInfo
      id = "querySchemaLog"
      tag = "Schema Log"
      summary = "Get List (POST)"
      desc = "Queries for schema log entries that fulfill given parameters." />

  "parameters" : [
    <#assign last = true >
    <#include "/lib/commons/pagination-params.ftl" >
  ],
  
  <@lib.requestBody
      mediaType = "application/json"
      dto = "SchemaLogQueryDto"
      examples = ['"example-1": {
                         "summary": "POST /schema/log",
                         "description": "The content of the Request Body",
                         "value": {
                           "version": "1.0.0",
                           "sortBy": "timestamp",
                           "sortOrder": "asc"
                         }
                   }'] />

  "responses" : {
    <@lib.response
        code = "200"
        dto = "SchemaLogEntryDto"
        array = true
        last = true
        desc = "Request successful.
                **Note**: In order to get any results a user of group fluxnova-admin must be
                authenticated."
        examples = ['"example-1": {
                       "summary": "Status 200 Response",
                       "description": "The Response content of a status 200",
                       "value": [
                         {
                           "id": "0",
                           "version": "1.0.0",
                           "timestamp": "2025-09-19T19:22:35.751+0200"
                         }
                       ]
                     }'] />
  }
}

</#macro>