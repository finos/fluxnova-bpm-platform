<#macro endpoint_macro docsUrl="">
{
  <@lib.endpointInfo
      id = "completeAdHocSubProcess"
      tag = "Execution"
      summary = "Complete Ad-Hoc Subprocess"
      desc = "Completes an active ad-hoc subprocess execution by id. The request fails if any inner activity is currently active. Optional variables can be set before completion."
  />

  "parameters" : [

      <@lib.parameter
          name = "id"
          location = "path"
          type = "string"
          required = true
          desc = "The id of the ad-hoc subprocess execution to complete."
          last = true
      />

  ],

  <@lib.requestBody
      mediaType = "application/json"
      dto = "AdHocSubProcessCompletionDto"
            examples = ['"empty-payload": {
                     "summary": "POST `/execution/{id}/ad-hoc-activities/complete`",
                     "value": {}
                                     }',
                                    '"with-variables": {
                                         "summary": "POST `/execution/{id}/ad-hoc-activities/complete` with variables",
                                         "value": {
                                             "variables": {
                                                 "completionReason": {
                                                     "value": "manual",
                                                     "type": "String"
                                                 }
                                             }
                                         }
                   }']
  />

  "responses": {

    <@lib.response
        code = "204"
        desc = "Request successful. This method returns no content."
    />

    <@lib.response
        code = "400"
        dto = "ExceptionDto"
        desc = "The execution id is invalid, the execution is not an ad-hoc subprocess, or active child activities exist."
    />

    <@lib.response
        code = "500"
        dto = "ExceptionDto"
        desc = "An internal server error occurred while completing the ad-hoc subprocess."
        last = true
    />

  }

}
</#macro>
