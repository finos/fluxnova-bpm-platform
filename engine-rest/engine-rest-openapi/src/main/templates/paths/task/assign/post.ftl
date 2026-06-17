<#macro endpoint_macro docsUrl="">
    {

    <@lib.endpointInfo
    id = "assignTasks"
    tag = "Task"
    deprecated = true
    summary = "Assign tasks"
    desc = "**Deprecated!** Use `POST /bulk/task/assign` instead. This endpoint is no longer supported.

    Assign all tasks to specific user" />

    <@lib.requestBody
    mediaType = "application/json"
    dto = "TasksAssignDto"
    examples = [
    '"example-1": {
            "summary": "POST /task/assign",
            "value": {
                      	"taskIds": [
                          "0eb066f5-7c34-11ef-b497-9e2bc863dfee",
                          "0eab5dde-7c34-11ef-b497-9e2bc863dfee"
                        ],
                      	"userIdDto" : {"userId":"demo"}

                      }
        }']
    />

    "responses" : {

    <@lib.response
    code = "200"
    desc = "Request successful."
    examples = ['"example-1": {
                       "value":

                                 		[
                                    	{
                                    		"status": "SUCCESS",
                                    		"taskId": "0eb066f5-7c34-11ef-b497-9e2bc863dfee",
                                    		"errorMessage": null
                                    	},
                                    	{
                                    		"status": "SUCCESS",
                                    		"taskId": "0eab5dde-7c34-11ef-b497-9e2bc863dfee",
                                    		"errorMessage": null
                                    	}
                                    ]



        }'] />


    <@lib.response
    code = "207"
    desc = "Multi-Status: Indicates that at least one request has failed."
    examples = ['"example-1": {
                               "value":

                                         		[
                                            	{
                                            		"status": "FAILURE",
                                            		"taskId": "0eb066f5-7c34-11ef-b497-9e2bc863dfee1",
                                            		"errorMessage": "Cannot find task with id 0eb066f5-7c34-11ef-b497-9e2bc863dfee1: task is null"
                                            	},
                                            	{
                                            		"status": "SUCCESS",
                                            		"taskId": "0eab5dde-7c34-11ef-b497-9e2bc863dfee",
                                            		"errorMessage": null
                                            	}
                                            ]



                }']/>

    <@lib.response
    code = "400"
    dto = "ExceptionDto"
    last = true
    desc = "Returned if some query parameters are invalid. See the
        [Introduction](${docsUrl}/reference/rest/overview/#error-handling) for the error response format." />
    }
    }

</#macro>