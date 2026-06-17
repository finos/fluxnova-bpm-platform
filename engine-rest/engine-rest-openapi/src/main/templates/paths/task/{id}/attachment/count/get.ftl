<#macro endpoint_macro docsUrl="">
{

  <@lib.endpointInfo
      id = "getAttachmentsCount"
      tag = "Task Attachment"
      summary = "Get List Count"
      desc = "Retrieves the number of task attachments by task id." />

  "parameters" : [

    <@lib.parameter
        name = "id"
        location = "path"
        type = "string"
        required = true
        last = true
        desc = "The id of the task."/>

    ],

    "responses" : {

  <@lib.response
      code = "200"
      dto = "CountResultDto"
      desc = "Request successful."
      examples = ['"example-1": {
                     "summary": "GET /task/aTaskId/attachment/count",
                     "description": "GET ``",
                     "value": {
                     "count": 2
                     }
                  }'] />

    <@lib.response
        code = "404"
        dto = "ExceptionDto"
        last = true
        desc = "No task exists for the given task id. See the [Introduction](/reference/rest/overview/#error-handling)
                    for the error response format." />

    }
}

</#macro>