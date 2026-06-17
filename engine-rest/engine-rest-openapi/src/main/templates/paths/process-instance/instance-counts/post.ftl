<#macro endpoint_macro docsUrl="">
  {
    <@lib.endpointInfo
    id = "getProcessInstanceStatistics"
    tag = "Process Instance"
    summary = "Get List Count (POST) by process definition ids"
    desc = "Queries for the number of process instances by given process definition ids and status provided in the
    request." />

    <@lib.requestBody
    mediaType = "application/json"
    dto = "ProcessInstanceCountRequestDto"
    examples = [
    '"example-1": {
                     "summary": "POST `/process-instance/instance-counts` Request Body 1",
                     "value": {
                      "processDefinitionIds" :[
                         "aProcessDefnId",
                         "anotherProcessDefnId"
                      ],
                      "active": true

                     }
                 }',
    '"example-2": {
                     "summary": "POST `/process-instance/instance-counts` Request Body 1",
                     "value": {
                      "processDefinitionIds" :[
                         "aProcessDefnId",
                         "anotherProcessDefnId"
                      ],
                      "active": false

                     }
                 }'
    ] />

  "responses" : {

    <@lib.response
    code = "200"
    dto = "ProcessInstanceCountStatisticsDto"
    array = true
    desc = "Request successful."
    examples = ['"example-1": {
                       "summary": "Status 200 Response 1",
                       "value": [
                            {
                              "processDefinitionId": "aProcessDefnId",
                              "instanceCount": "1"
                            },
                            {
                              "processDefinitionId": "anotherProcessDefnId",
                              "instanceCount": "0"
                            }
                       ]
                     }'] />

    <@lib.response
    code = "400"
    dto = "ExceptionDto"
    last = true
    desc = "Bad Request
                Returned if the request body is invalid."/>

  }
  }
</#macro>