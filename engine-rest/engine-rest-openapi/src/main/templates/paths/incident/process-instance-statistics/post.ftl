<#macro endpoint_macro docsUrl="">
    {
        <@lib.endpointInfo
        id = "getProcessInstanceIncidentStatistics"
        tag = "Incident"
        summary = "Get Incident Count (POST) by process instance ids"
        desc = "Queries for the number of incidents for each process instance by given process instance ids." />

        <@lib.requestBody
        mediaType = "application/json"
        dto = "ProcessInstanceIncidentCountRequestDto"
        examples = [
        '"example-1": {
                         "summary": "POST `/incident/process-instance-statistics` Request Body 1",
                         "value": {
                          "processInstanceIds" :[
                             "aProcessInstId",
                             "anotherProcessInstId"
                          ]

                         }
                     }'
        ] />

        "responses" : {

            <@lib.response
            code = "200"
            dto = "ProcessInstanceIncidentCountStatisticsDto"
            array = true
            desc = "Request successful."
            examples = ['"example-1": {
                               "summary": "Status 200 Response 1",
                               "value": [
                                    {
                                      "processInstanceId": "aProcessInstId",
                                      "incidentCount": "1"
                                    },
                                    {
                                      "processInstanceId": "anotherProcessDefnId",
                                      "incidentCount": "0"
                                    }
                               ]
                             }'] />

            <@lib.response
            code = "400"
            dto = "ExceptionDto"
            last = true
            desc = "Bad Request
                        Returned if the request body is invalid."/>

        }
    }
</#macro>