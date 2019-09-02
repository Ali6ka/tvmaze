<#import "/spring.ftl" as spring/>
<#import "layout/main.ftl" as main/>

<#assign arr = {"/dashboard" : 'dashboard'} />

<@main.render arr arr>
<div class="row">
    <div class="col-lg-6">

        <!-- Traffic sources -->
        <div class="panel panel-flat">
            <div class="panel-heading">
                <h6 class="panel-title">Домашняя страница</h6>
                <div class="heading-elements">
                </div>
            </div>
        </div>
    </div>
</div>
</@main.render>