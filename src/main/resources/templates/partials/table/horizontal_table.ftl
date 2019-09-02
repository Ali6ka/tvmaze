<#import "/spring.ftl" as spring>
<#import "../form.ftl" as form>
<#macro render data addUrl="" collapse=false rowNo=true fastview=false>
<style>
    .dataTable tbody > tr.selected, .dataTable tbody > tr {
        cursor: pointer;
    }

    .dataTable tbody > tr.selected, .dataTable tbody > tr:hover {
        background-color: #d2d2d2;
    }

    .table-hover > tbody > tr.selected > td {
        background-color: #bfbfbf !important;
    }

    .dt-button-collection > .disabled {
        cursor: default;
    }
</style>
<div class="row">
    <div class="<#if fastview>col-sm-9<#else>col-sm-12</#if>">
        <div id="panel" class="panel panel-default">
            <div class="panel-heading">
                <h5 class="panel-title" id="table-title"><@spring.message "tvmaze.shows" /></h5>
            </div>
            <div class="panel-body">
            <div class="table-responsive table-scrolling">
                <table class="table table-responsive table-hover table-striped table-xxs" id="example">
                    <thead>
                    <tr>
                        <th>№</th>
                        <th><@spring.message "show.name" /></th>
                        <th><@spring.message "show.language" /></th>
                        <th><@spring.message "show.score" /></th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list data as item>
                    <tr>
                        <td>${item.show.id}</td>
                        <td>${item.show.name}</td>
                        <td>${item.show.language}</td>
                        <td>${item.score}</td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
            </div>
        </div>
    </div>
    <#if fastview>
        <div class="col-sm-3">
            <div id="cast-view">
                <fastview id="fastview" ref="castview"></fastview>
            </div>
        </div>
    </#if>
</div>
<script>
    var table = $("#example").DataTable({
        pagingType: "full_numbers",
        select: {
            style: 'single'
        },
        language: {
            search:"",
            lengthMenu: "<@spring.message 'table.showRowsStart'/> _MENU_ <@spring.message 'table.showRowsEnd'/>",
            zeroRecords: "<@spring.message 'table.nothingToShow'/>",
            info: "<@spring.message 'table.showingPageBegin'/> _START_  <@spring.message 'table.showingPageMiddle'/> _END_ <@spring.message 'table.showingPageEnd'/> _TOTAL_",
            paginate: {
                first:      "<@spring.message 'table.firstPage'/>",
                previous:   "<@spring.message 'table.previousPage'/>",
                next:       "<@spring.message 'table.nextPage'/>",
                last:       "<@spring.message 'table.lastPage'/>"
            }
        },
        colReorder: true
    });

    var castViewComponent = new Vue({el: '#cast-view'});

    $('#example tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        castViewComponent.$refs.castview.onRowClick(data[0].replace(/&nbsp;/gi,''), data[1]);
    } );
</script>
</#macro>