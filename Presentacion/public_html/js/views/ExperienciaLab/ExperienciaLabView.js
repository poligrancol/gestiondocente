define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ExperienciaLab/ExperienciaLaboralTemplate.html'
], function ($, _, Backbone, ExperienciaLaboralTemplate) {

    var ExperienciaLabView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(ExperienciaLaboralTemplate);
            var compiledTemplate = template(data);
            $("#experiencia").html(compiledTemplate);  
        }
    });
    return ExperienciaLabView;
});
