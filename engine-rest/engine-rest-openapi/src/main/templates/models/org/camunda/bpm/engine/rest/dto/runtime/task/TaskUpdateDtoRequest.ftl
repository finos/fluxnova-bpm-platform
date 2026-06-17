<#macro dto_macro docsUrl="">
    <@lib.dto>

        <@lib.property
        name = "taskDto"
        type = "array"
        dto = "TaskDto"
        last = true />

    </@lib.dto>
</#macro>