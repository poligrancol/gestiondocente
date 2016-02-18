define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ExperienciaLab/ListarExperienceLabTemplate.html'
], function ($, _, Backbone, ListarExperienceLabTemplate) {

    var ListarExperienciaLabView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(ListarExperienceLabTemplate);
            var compiledTemplate = template(data);
            $("#services").html(compiledTemplate);  
        }
    });
    return ListarExperienciaLabView;
});
