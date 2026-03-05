<#macro endpoint_macro docsUrl="">
 {

    <@lib.endpointInfo
        id = "bulkCreateTaskComments"
        tag = "Bulk Task"
        summary = "Create list of task comments"
        desc = "Create a list of task comments." />

    <@lib.requestBody
            mediaType = "application/json"
            dto = "CreateCommentsDto"
            requestDesc = "**Note:** Only the `taskId`, `message`, `processInstanceId` properties will be used. Every
             other property passed to this endpoint will be ignored."
            examples = ['"example-1": {
                             "summary": "POST `/bulk/task/comment/create`",
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
              dto = "TaskCreateCommentResponse"
              array = true
              desc = "Request successful."
              examples = ['"example-1": {
                       "summary": "Status 200 Response",
                       "value": [
                         {
                          "status": "SUCCESS",
                          "errorMessage": "null",
                          "commentInfo":{
                              "id": "commentId",
                              "userId": "userId",
                              "taskId": "aTaskId",
                              "processInstanceId": "aProcessInstanceId",
                              "time": "2013-01-02T21:37:03.764+0200",
                              "message": "message",
                              "removalTime": "2018-02-10T14:33:19.000+0200",
                              "rootProcessInstanceId": "aRootProcessInstanceId"
                            }
                          },
                          {
                          "status": "SUCCESS",
                          "errorMessage": "null",
                          "commentInfo":{
                              "id": "anotherCommentId",
                              "userId": "anotherUserId",
                              "taskId": "aTaskId",
                              "processInstanceId": "aProcessInstanceId",
                              "time": "2013-02-23T20:37:43.975+0200",
                              "message": "anotherMessage",
                              "removalTime": "2018-02-10T14:33:19.000+0200",
                              "rootProcessInstanceId": "aRootProcessInstanceId"
                            }
                          }
                       ]
                     }']/>

          <@lib.response
              code = "207"
              dto = "TaskCreateCommentResponse"
              array = true
              desc = "Multi-Status: Indicates that at least one request has failed."
              examples = ['"example-1": {
                       "summary": "Status 207 Response",
                       "value": [
                         {
                          "status": "FAILURE",
                          "errorMessage": "Cannot find task with id 0eb066f5-7c34-11ef-b497-9e2bc863dfee1: task is null",
                          "commentInfo":{
                              "id": "commentId",
                              "userId": "userId",
                              "taskId": "aTaskId",
                              "processInstanceId": "aProcessInstanceId",
                              "time": "2013-01-02T21:37:03.764+0200",
                              "message": "message",
                              "removalTime": "2018-02-10T14:33:19.000+0200",
                              "rootProcessInstanceId": "aRootProcessInstanceId"
                            }
                          },
                          {
                          "status": "SUCCESS",
                          "errorMessage": "null",
                          "commentInfo":{
                              "id": "anotherCommentId",
                              "userId": "anotherUserId",
                              "taskId": "aTaskId",
                              "processInstanceId": "aProcessInstanceId",
                              "time": "2013-02-23T20:37:43.975+0200",
                              "message": "anotherMessage",
                              "removalTime": "2018-02-10T14:33:19.000+0200",
                              "rootProcessInstanceId": "aRootProcessInstanceId"
                            }
                          }
                       ]
                     }']/>

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