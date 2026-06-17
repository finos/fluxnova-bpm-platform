<#macro endpoint_macro docsUrl="">
  {

    <@lib.endpointInfo
    id = "createTaskComments"
    tag = "Task Comment"
    deprecated = true
    summary = "Create task comments"
    desc = "**Deprecated!** Use `POST /bulk/task/comment/create` instead. This endpoint is no longer supported.

    Create a list of task comments." />

    <@lib.requestBody
    mediaType = "application/json"
    dto = "CommentDto"
    requestDesc = "**Note:** Only the `taskId`, `message`, `processInstanceId` properties will be used. Every
             other property passed to this endpoint will be ignored."
    examples = ['"example-1": {
                             "summary": "POST `/task/create/comments`",
                             "value": [
                               {
                                  "taskId": "1f7e5f43-3e3c-11ef-ab08-3606d2560f62",
                                  "message": "Comment process instance"
                               },
                               {

                                  "taskId": "1f7e5f43-3e3c-11ef-ab08-3606d2560f62",
                                  "processInstanceId": "2f7e5f43-3e3c-11ef-ab08-3606d2560f62",
                                  "message": "Comment process instance"

                               }]

            }']
    />

  "responses" : {
    <@lib.response
    code = "200"
    desc = "Request successful."  />

    <@lib.response
    code = "207"
    desc = "Multi-Status: Indicates that at least one request has failed."  />

    <@lib.response
    code = "400"
    dto = "ExceptionDto"
    last = true
    desc = "Returned if some query parameters are invalid, the number of commentDtos exceeds 100.
                     See the [Introduction](${docsUrl}/reference/rest/overview/#error-handling) for the error
                     response format." />
  }
  }

</#macro>