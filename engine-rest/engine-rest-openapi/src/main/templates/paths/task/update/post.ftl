<#macro endpoint_macro docsUrl="">
  {

    <@lib.endpointInfo
    id = "updateTasks"
    tag = "Task"
    deprecated = true
    summary = "Update tasks"
    desc = "**Deprecated!** Use `POST /bulk/task/update` instead. This endpoint is no longer supported.

    Updates a list of tasks." />

    <@lib.requestBody
    mediaType = "application/json"
    dto = "TaskDto"
    examples = [
    '"example-1": {
            "summary": "POST /task/update",
            "value": [{
                "id": "taskId1",
                "name": "Task 1",
                "description": "This task needs to be done urgently",
                "priority": 30,
                "assignee": "peter",
                "owner": "mary",
                "delegationState": "PENDING",
                "due": "2014-08-30T10:00:00.000+0200",
                "followUp": "2014-08-25T10:00:00.000+0200",
                "parentTaskId": "parentTaskId1",
                "caseInstanceId": "caseInstanceId1",
                "tenantId": null
            },
            {
                "id": "taskId2",
                "name": "Task 2",
                "description": "This task is of medium priority",
                "priority": 20,
                "assignee": "john",
                "owner": "jane",
                "delegationState": "RESOLVED",
                "due": "2014-09-15T10:00:00.000+0200",
                "followUp": "2014-09-10T10:00:00.000+0200",
                "parentTaskId": "parentTaskId2",
                "caseInstanceId": "caseInstanceId2",
                "tenantId": null
           }]
        }'
    ]
    />

  "responses" : {

    <@lib.response
    code = "200"
    desc = "Request successful." />


    <@lib.response
    code = "207"
    desc = "Multi-Status: Indicates that at least one request has failed." />

    <@lib.response
    code = "400"
    dto = "ExceptionDto"
    last = true
    desc = "Returned if some query parameters are invalid, the number of taskDtos exceeds 100,
        or there are duplicate task IDs. See the
        [Introduction](${docsUrl}/reference/rest/overview/#error-handling) for the error response format." />
  }
  }

</#macro>