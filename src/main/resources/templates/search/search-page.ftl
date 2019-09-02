<#import "/spring.ftl" as spring/>
<#import "../partials/table/horizontal_table.ftl" as tableMacro/>
<#import "../layout/main.ftl" as main/>
<#import '../partials/form.ftl' as form>


<#assign arr = {"/result" : 'search'} />

<@main.render arr arr>

    <@form.searchInput query!"" />
    <#if shows??>
        <@tableMacro.render shows "" false true true/>
    </#if>

</@main.render>