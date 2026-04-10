<#macro dto_macro docsUrl="">
<@lib.dto>

  <@lib.property
      name = "name"
      type = "string"
      desc = "The name of the process engine." />

  <@lib.property
      name = "displayName"
      type = "string"
      desc = "The display name of the process engine. Only present when set in engine." />

  <@lib.property
      name = "group"
      type = "string"
      desc = "The group name of the process engine. Only present when set in engine." />

  <@lib.property
      name = "groupDisplayName"
      type = "string"
      desc = "The group display name of the process engine. Only present when set in engine."
      last=true />

</@lib.dto>
</#macro>