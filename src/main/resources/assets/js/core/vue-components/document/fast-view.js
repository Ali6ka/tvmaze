Vue.component('fastview', {
    template: `
    <div class="panel panel-default border-left-info panel-collapsed">
        <div class="panel-heading">
            <h6 class="panel-title">Состав {{title}}</h6>
            <div class="heading-elements panel-nav"></div>
            <div class="heading-elements">
                <ul class="icons-list hidden">
                    <li><a class="fast-view-collapse" data-action="collapse"></a></li>
                </ul>
            </div>
        </div>
        <div class="panel-body">
            <p class="content-group">
                <li v-if="!data.length">Исполнителей не найдено</li>
                <li v-for="(item, index) in data">
                    {{ item.person.name }} - {{item.character.name}}
                </li>
            </p>
        </div>
    </div>
  `,
    data: function () {
        return {
            data: {},
            title: ""
        };
    },
    methods: {
        collapse: function () {
            if ($(this.$el).hasClass("panel-collapsed"))
                $(".fast-view-collapse").trigger('click');
        },
        block: function () {
            $(this.$el).block({
                message: '<i class="icon-spinner2 spinner"></i>',
                overlayCSS: {
                    backgroundColor: '#fff',
                    opacity: 0.8,
                    cursor: 'wait',
                    'box-shadow': '0 0 0 1px #ddd'
                },
                css: {
                    border: 0,
                    padding: 0,
                    backgroundColor: 'none'
                }
            });
        },
        unblock: function () {
            $(this.$el).unblock();
        },

        onRowClick: function (id, title) {
            let self = this;
            self.title = title;
            self.collapse();
            self.block();
            let url = "/api/show/" + id + "/cast" ;
            axios
                .get(url)
                .then(response => {
                    self.data = response.data;
                    self.unblock();
                })
                .catch(error => console.log(error));
        }
    }
});