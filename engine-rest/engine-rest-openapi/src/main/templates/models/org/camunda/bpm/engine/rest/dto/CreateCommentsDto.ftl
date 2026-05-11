<#macro dto_macro docsUrl="">
    <@lib.dto>

        <@lib.property
        name = "commentDto"
        type = "array"
        dto = "CommentDto"
        last = true />

    </@lib.dto>
</#macro>