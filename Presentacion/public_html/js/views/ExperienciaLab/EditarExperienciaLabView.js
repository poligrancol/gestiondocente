define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ExperienciaLab/EditarExperienceLabTemplate.html'
], function ($, _, Backbone, EditarExperienceLabTemplate) {

    var EditarExperienciaLabView = Backbone.View.extend({
        render: function (accion, id) {
            $("#editar").next().hide();
            var template = _.template(EditarExperienceLabTemplate);
            var compiledTemplate = template();
            $("#editar").html(compiledTemplate);
            $(document).on('click', '#cancelar', function () {
                $("#editar").html("");
                $("#editar").next().show();
            });
        }
    });
    return EditarExperienciaLabView;
});
