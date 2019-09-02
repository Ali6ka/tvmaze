<#import "/spring.ftl" as spring>

<#macro noSubmitPrintFile action="" method="GET">
<form class="form-horizontal form "
      action=${action}
      method=${method}
      role="form"
      enctype="multipart/form-data">
    <#nested />
</form>
</#macro>

<#macro inputSubmit text="action.find" class="primary" id="">
<button <#if (id?has_content)>id="${id}"</#if> type="submit" class="btn btn-${class}"><@spring.message text /></button>
</#macro>

<#macro searchInput query="">
<@noSubmitPrintFile "/search">
    <div class="panel-custom">
        <div class="panel-body" style="padding: 10px;">
            <div class="form-group mb-3">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="<@spring.message "search.inputName"/>" name="query" value="${query}">
                    <div class="input-group-btn">
                        <@inputSubmit />
                    </div>
                </div>
            </div>
        </div>
    </div>
</@noSubmitPrintFile>
</#macro>