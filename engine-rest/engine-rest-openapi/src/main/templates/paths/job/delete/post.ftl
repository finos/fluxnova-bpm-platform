<#macro endpoint_macro docsUrl="">
  {
    <@lib.endpointInfo
    id = "deleteByJobIds"
    tag = "Job"
    summary = "Delete Jobs by list of jobIds"
    desc = "Delete jobs by supplied list of jobIds."
    />

    <@lib.requestBody
    mediaType = "application/json"
    dto = "JobDeletionDto"
    examples = [
    '"example-1": {
                     "summary": "Delete jobs with the given job ids. POST `/job/delete`",
                     "value": {
                       "jobIds" :[
                         "aJobId",
                         "anotherJobId"
                      ]
                     }
                   }'
    ]
    />

  "responses": {

    <@lib.response
    code = "200"
    desc = "Request successful."  />

    <@lib.response
    code = "207"
    desc = "Multi-Status: Indicates that at least one request has failed."  />

    <@lib.response
    code = "400"
    dto = "ExceptionDto"
    desc = "Returned if the request parameters are invalid, for example if an empty list is provided as input."
    last = true
    />

  }

  }
</#macro>