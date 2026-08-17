<#macro dto_macro docsUrl="">
<@lib.dto desc = "Trigger instructions for one or more ad hoc activities within an ad hoc scope.">
    
    <@lib.property
        name = "activities"
        type = "array"
        dto = "AdHocActivityTriggerInstructionDto"
        desc = "A collection of ad hoc activities to trigger. Each entry specifies an activity id
                and optional variables to set in that activity."
        last = true
    />


</@lib.dto>
</#macro>
