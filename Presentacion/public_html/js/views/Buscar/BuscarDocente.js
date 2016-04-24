define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/Busqueda/BuscarDocenteViewTemplate.html',
    'text!conf/URLServer.html'
], function ($, _, Backbone, BuscarDocenteViewTemplate, URLServer) {

    // Buscar docente view definition.
    var BuscarDocenteView = Backbone.View.extend({

        // Define element the view is bound to.
        el: '.intro-section',

        initialize: function() {
            console.log('Initialized: /public_html/js/views/Buscar/BuscarDocente.js');
        },

        events: {
            'submit .js-search-teacher-form': 'searchTeacher'
        },

        // Renders the view.
        render: function (filters) {

            // Get teacher list.
            var url = URLServer;
            if (filters) {
                url += filters;
            }

            $.get(url, function(data) {
                var template = _.template(BuscarDocenteViewTemplate);
                var context = {
                    'teacher_list': data
                };

                var compiledTemplate = template(context);
                $("#intro").html(compiledTemplate);
            });
        },

        // Repaint the table with a list of teachers.
        searchTeacher: function(e) {
            var target = e.currentTarget;
            var filters = $(target).serialize();
            return false;
        }

    });


    return BuscarDocenteView;
});
