<#macro dto_macro docsUrl="">
<@lib.dto>

  <@lib.property
      name = "name"
      type = "string"
      desc = "The name of the process engine." />

  <@lib.property
      name = "description"
      type = "string"
      desc = "The description of the process engine. Only present when set in engine." />

  <@lib.property
      name = "groupName"
      type = "string"
      desc = "The group name of the process engine. Only present when set in engine." />

  <@lib.property
      name = "groupDescription"
      type = "string"
      desc = "The group description of the process engine. Only present when set in engine."
      last=true />

</@lib.dto>
</#macro>