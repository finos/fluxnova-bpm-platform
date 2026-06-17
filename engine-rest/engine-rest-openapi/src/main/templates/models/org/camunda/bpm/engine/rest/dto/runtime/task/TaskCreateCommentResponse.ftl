<#macro dto_macro docsUrl="">
<#-- Generated From File: fluxnova-docs-manual/public/reference/rest/execution/post-signal/index.html -->
    <@lib.dto desc = "">

        <@lib.property
        name = "commentInfo"
        type = "ref"
        dto = "CommentDto"
        desc = "The comment info object containing all the comment related details." />

        <@lib.property
        name = "status"
        type = "string"
        desc = "The status of the update operation." />

        <@lib.property
        name = "errorMessage"
        type = "string"
        last =  true
        desc = "The error details related to update operation failure." />


    </@lib.dto>
</#macro>