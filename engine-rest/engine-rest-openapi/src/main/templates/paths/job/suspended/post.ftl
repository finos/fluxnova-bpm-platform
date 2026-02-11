<#macro endpoint_macro docsUrl="">
  {
    <@lib.endpointInfo
    id = "updateSuspensionStateByJobIds"
    tag = "Job"
    summary = "Activate/Suspend Jobs by list of jobIds"
    desc = "Activates or suspends jobs by supplied list of jobIds
    and a boolean flag suspended."
    />

    <@lib.requestBody
    mediaType = "application/json"
    dto = "JobActivateSuspendDto"
    examples = [
    '"example-1": {
                     "summary": "Activates or suspends jobs with the given job ids. POST `/job/suspended`",
                     "value": {
                       "jobIds" : [
                         "aJobId",
                         "anotherJobId"
                      ],
                       "suspended": true
                     }
                   }'
    ]
    />

  "responses": {

    <@lib.response
    code = "200"
    desc = "Request successful."
    dto = "JobSuspensionResponse"
    array = true
    examples = ['"example-1": {
                       "summary": "Status 200 Response",
                       "value": [
                         {
                          "status": "SUCCESS",
                          "errorMessage": "null",
                          "jobId": "aJobId"
                          },
                          {
                          "status": "SUCCESS",
                          "errorMessage": "null",
                          "jobId": "anotherJobId"
                          }
                       ]
                     }'] />

    <@lib.response
    code = "207"
    desc = "Multi-Status: Indicates that at least one request has failed."
    dto = "JobSuspensionResponse"
    array = true
    examples = ['"example-1": {
                       "summary": "Status 200 Response",
                       "value": [
                         {
                          "status": "FAILURE",
                          "errorMessage": "Cannot find job with id 0eb066f5-7c34-11ef-b497-9e2dfee1: jobId is null",
                          "jobId": "aJobId"
                          },
                          {
                          "status": "SUCCESS",
                          "errorMessage": "null",
                          "jobId": "anotherJobId"
                          }
                       ]
                     }']/>

    <@lib.response
    code = "400"
    dto = "ExceptionDto"
    desc = "Returned if the request parameters are invalid, for example if an empty list is provided as input."
    last = true
    />

  }

  }
</#macro>