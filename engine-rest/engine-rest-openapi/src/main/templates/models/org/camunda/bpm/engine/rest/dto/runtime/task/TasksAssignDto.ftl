<#macro dto_macro docsUrl="">
    <@lib.dto>

        <@lib.property
            name = "taskIds"
            type = "array"
            desc = "The list of task ids for which task assignment needs to be done." />

        <@lib.property
            name = "userIdDto"
            type = "object"
            dto = "UserIdDto"
            last =  true
            desc = "The id of the user to which the task will be assigned." />

    </@lib.dto>
</#macro>