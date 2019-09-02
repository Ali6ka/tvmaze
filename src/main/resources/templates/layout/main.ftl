••••••<#import "/spring.ftl" as spring/>

<#macro head title>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>
    TVMaze
    <#list title as k,v>
        | <@spring.message v/>
    </#list>
</title>

<!-- Global stylesheets -->
<link href="https://fonts.googleapis.com/css?family=Roboto:400,300,100,500,700,900" type="text/css">
<link href="/assets/css/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
<link href="/assets/css/icons/fontawesome/styles.min.css" rel="stylesheet" type="text/css">
<link href="/assets/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="/assets/css/core.css" rel="stylesheet" type="text/css">
<link href="/assets/css/components.css" rel="stylesheet" type="text/css">
<link href="/assets/css/colors.css" rel="stylesheet" type="text/css">
<link href="/assets/css/app.css" rel="stylesheet" type="text/css">
<!-- /global stylesheets -->

<!-- Core JS files -->
<script type="text/javascript" src="/assets/js/core/libraries/jquery.min.js"></script>
<script type="text/javascript" src="/assets/js/core/libraries/bootstrap.min.js"></script>
<script type="text/javascript" src="/assets/js/core/libraries/jspdf.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/loaders/blockui.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/loaders/pace.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/ui/nicescroll.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/ui/drilldown.js"></script>
<!-- /core JS files -->

<!-- /core JS files -->
<script type="text/javascript" src="/assets/js/core/libraries/jquery_ui/core.min.js"></script>
<script type="text/javascript" src="/assets/js/core/libraries/jquery_ui/effects.min.js"></script>
<script type="text/javascript" src="/assets/js/core/libraries/jquery_ui/interactions.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/notifications/sweet_alert.min.js"></script>
<!-- /core JS files -->


<#--Datatable-->
<script type="text/javascript" src="/assets/js/plugins/tables/datatables/datatables.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/tables/datatables/extensions/select.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/tables/datatables/extensions/buttons.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/tables/datatables/extensions/col_reorder.min.js"></script>
<#--Datatable-->

<#--Time and pickers-->
<script type="text/javascript" src="/assets/js/plugins/pickers/anytime.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/ui/moment/moment.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/pickers/daterangepicker.js"></script>
<script type="text/javascript" src="/assets/js/plugins/pickers/color/spectrum.js"></script>
<#--Time and pickers-->

<#--Forms-->
<script type="text/javascript" src="/assets/js/plugins/forms/selects/select2.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/forms/styling/uniform.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/forms/styling/switch.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/forms/validation/validate.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/forms/validation/additional_methods.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/notifications/pnotify.min.js"></script>
<script type="text/javascript" src="/assets/js/plugins/forms/wizards/stepy.min.js"></script>
<#--Forms-->

<#--VUEJS -->
<script type="text/javascript" src="/assets/js/core/vue-components/vue.js"></script>
<script type="text/javascript" src="/assets/js/core/vue-components/axios.min.js"></script>
<script type="text/javascript" src="/assets/js/core/vue-components/timer.js"></script>
<script type="text/javascript" src="/assets/js/core/vue-components/document/fast-view.js"></script>

<script type="text/javascript" src="/webjars/jquery-mask-plugin/1.14.10/dist/jquery.mask.min.js"></script>
<script type="text/javascript" src="/assets/js/core/app.js"></script>
</#macro>

<#macro userbar>
<div class="navbar navbar-inverse">
    <div class="navbar-header">
        <ul class="nav navbar-nav pull-right visible-xs-block">
            <li><a data-toggle="collapse" data-target="#navbar-mobile"><i class="icon-tree5"></i></a></li>
        </ul>
    </div>
    <li class="navbar-collapse collapse" id="navbar-mobile">
        <p class="navbar-text"><span class="label bg-success-400"><@spring.message 'tvmaze.title'/></span></p>
    </li>
</div>
</#macro>

<#macro pageHeader arr>
<div class="page-header">
    <div class="page-header-content">
        <div class="page-title">
            <#list arr as k,v>
                <#assign pageTitle = v/>
            </#list>
            <h4 style="padding-left: 25px">
                <i class="icon-arrow-left52 position-left" style="cursor: pointer" onclick="history.back()"></i>
                <@spring.message pageTitle/>
            </h4>

            <ul class="breadcrumb breadcrumb-caret position-right">
                <#list arr as k,v>
                    <li>
                        <a href="${k}">
                            <@spring.message v/>
                        </a>
                    </li>
                </#list>
            </ul>
        </div>
    </div>
</#macro>

<#macro content>
    <#if error?? && error?has_content>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="alert bg-danger text-center">
                    <button type="button" class="close" data-dismiss="alert"><span>×</span><span
                            class="sr-only">Close</span>
                    </button>
                    <span class="text-semibold">Внимание!</span>
                    ${error}
                </div>
            </div>
        </div>
    </div>
    </#if>

    <div class="page-container">
        <div class="page-content">
            <div class="content-wrapper">
                <#nested />
            </div>
        </div>
    </div>
</#macro>

<#macro footer>
<div class="footer text-muted">
© 2019. <a href="#">TVMaze</a>
by Alibek
</div>
</#macro>

<#macro render breadcrumb={} title={}>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <@head title/>
    </head>
    <body>
        <@userbar/>
        <@pageHeader breadcrumb/>
        <@content>
            <#nested/>
        </@content>
        <@footer/>
    </body>
    </html>
</#macro>