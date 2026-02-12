<#macro endpoint_macro docsUrl="">
{
  <@lib.endpointInfo
      id = "deleteDeployments"
      tag = "Deployment"
      summary = "Delete Deployments"
      desc = "Deletes a list of deployments by given ids." />

   <@lib.requestBody
      mediaType = "application/json"
      dto = "DeleteDeploymentsDto"
      examples = [
      '"example-1": {
            "summary": "POST /delete",
            "value": {
                      	"deploymentIds": [
                          "deploymentId1",
                          "deploymentId2"
                        ],
                      	"skipCustomListeners": true,
                      	"skipIoMappings": true,
                        "cascade": true
                      }
        }']
  />

  "responses" : {

    <@lib.response
        code = "200"
        desc = "Request successful."
        dto = "DeleteDeploymentResponse"
        array = true
        examples = ['"example-1": {
                       "summary": "Status 200 Response",
                       "value": [
                         {
                          "status": "SUCCESS",
                          "errorMessage": "null",
                          "deploymentId": "aDeploymentId"
                          },
                          {
                          "status": "SUCCESS",
                          "errorMessage": "null",
                          "deploymentId": "aDeploymentId"
                          }
                       ]
                     }']  />

    <@lib.response
        code = "207"
        desc = "Multi-Status: Indicates that at least one request has failed."
        dto = "DeleteDeploymentResponse"
        array = true
        examples = ['"example-1": {
                       "summary": "Status 200 Response",
                       "value": [
                         {
                          "status": "FAILURE",
                          "errorMessage": "Cannot find job with id 0eb066f5-7c34-11ef-b497-9e2dfee1: jobId is null",
                          "deploymentId": "aDeploymentId"
                          },
                          {
                          "status": "SUCCESS",
                          "errorMessage": "null",
                          "deploymentId": "aDeploymentId"
                          }
                       ]
                     }']  />

    <@lib.response
        code = "400"
        dto = "ExceptionDto"
        last = true
        desc = "Returned if some query parameters are invalid or invalid request. See the
        [Introduction](${docsUrl}/reference/rest/overview/#error-handling) for the error response format." />
   }
}

</#macro>