<#macro endpoint_macro docsUrl="">
{

  <@lib.endpointInfo
      id = "bulkCompleteTasks"
      tag = "Bulk Task"
      summary = "Complete Tasks"
      desc = "Completes a list of tasks." />

    <@lib.requestBody
      mediaType = "application/json"
      dto = "CompleteTaskRequestDto"
      examples = ['"example-1": {
                     "summary": "Completing list of tasks with withVariablesInReturn flag set to true",
                     "value": {
                       "completeTasksInfo":  [  {
			                    "taskId": "f010bd64-96c4-11ef-8966-0205857feb80",
			                    "variables": {
				                     "aVariable": {
					                       "value": "aStringValue",
					                       "type": "String"
			                     	},
				                  "anotherVariable": {
				                      	"value": true,
				                      	"type": "Boolean"
				                    }
			                    }
		                    },
			                  {
		                    	"taskId": "ea7d6ebc-96c4-11ef-8966-0205857feb80",
			                    "variables": {
				                     "aVariable": {
					                       "value": "aStringValue",
					                       "type": "String"
				                     },
				                     "anotherVariable": {
					                       "value": true,
					                       "type": "Boolean"
				                     }
			                    }
		                    }
	                     ],
                       "withVariablesInReturn" : true
                     }
                   }',
                   '"example-2": {
                     "summary": "Completing list of tasks with withVariablesInReturn flag set to false",
                     "value": {
                       "completeTasksInfo":  [  {
			                    "taskId": "f010bd64-96c4-11ef-8966-0205857feb80",
			                    "variables": {
				                     "aVariable": {
					                       "value": "aStringValue",
					                       "type": "String"
			                     	},
				                  "anotherVariable": {
				                      	"value": true,
				                      	"type": "Boolean"
				                    }
			                    }
		                    },
			                  {
		                    	"taskId": "ea7d6ebc-96c4-11ef-8966-0205857feb80",
			                    "variables": {
				                     "aVariable": {
					                       "value": "aStringValue",
					                       "type": "String"
				                     },
				                     "anotherVariable": {
					                       "value": true,
					                       "type": "Boolean"
				                     }
			                    }
		                    }
	                     ],
                       "withVariablesInReturn" : false
                     }
                   }'
                 ] />

  "responses" : {

	 <@lib.response
        code = "200"
        desc = "Request successful."
        dto = "TaskCompleteResponseDto"
        array = true
        examples = ['"example-1": {
                       "value": [ {
            						  "variables": {
                							"aVariable": {
                					 			"value": "aStringValue",
                					 			"type": "String"
                							},
                							"anotherVariable": {
                								"value": true,
                								"type": "Boolean"
                							}
            						  },
                          "status": "SUCCESS",
                          "taskId": "0eb066f5-7c34-11ef-b497-9e2bc863dfee",
                          "errorMessage": null
                        },
                        {
          						  "variables": {
          							"aVariable": {
          					 			"value": "aStringValue",
          					 			"type": "String"
          							},
          							"anotherVariable": {
          								"value": true,
          								"type": "Boolean"
          							}
						         },
                          "status": "SUCCESS",
                          "taskId": "0eab5dde-7c34-11ef-b497-9e2bc863dfee",
                          "errorMessage": null
                        }
                    ] }',

					'"example-2": {
                       "value": [ {
						              "variables": null,
                          "status": "SUCCESS",
                          "taskId": "0eb066f5-7c34-11ef-b497-9e2bc863dfee",
                          "errorMessage": null
                        },
                        {
						              "variables": null,
                          "status": "SUCCESS",
                          "taskId": "0eab5dde-7c34-11ef-b497-9e2bc863dfee",
                          "errorMessage": null
                        }
                    ] }'


					] />


   <@lib.response
        code = "207"
        desc = "Multi-Status: Indicates that at least one request has failed."
        dto = "TaskCompleteResponseDto"
        array = true
        examples = ['"example-3": {
                        "value":
                           [
                             {
      													"variables": null,
                                "status": "FAILURE",
                                "taskId": "0eb066f5-7c34-11ef-b497-9e2bc863dfee1",
                                "errorMessage": "Cannot find task with id 0eb066f5-7c34-11ef-b497-9e2bc863dfee1: task is null"
                              },
                              {
													      "variables": null,
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
