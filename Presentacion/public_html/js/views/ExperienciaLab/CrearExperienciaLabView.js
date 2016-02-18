define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ExperienciaLab/CrearExperienceLabTemplate.html'
], function ($, _, Backbone, CrearExperienceLabTemplate) {

    var CrearExperienceLabTemplate = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            $("#editar").next().hide();
            var template = _.template(CrearExperienceLabTemplate);
            var compiledTemplate = template(data);
            $("#editar").html(compiledTemplate); 
            $(document).on('click', '#cancelar', function () {
                $("#editar").html("");
                $("#editar").next().show();
            });
        }
    });
    return CrearExperienceLabTemplate;
});
