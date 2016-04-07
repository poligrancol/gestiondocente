define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ExperienciaLab/ExperienciaLaboralTemplate.html',
    'text!templates/ExperienciaLab/MostrarExperienciaRealTemplate.html',
    'text!templates/ExperienciaLab/MostrarExperienciaDocenteTemplate.html'

], function ($, _, Backbone, ExperienciaLaboralTemplate, MostrarExperienciaRealTemplate, MostrarExperienciaDocenteTemplate) {

    var ExperienciaLabView = Backbone.View.extend({
        el:"#experiencia",
        render: function (accion,id) {
            var data = {};
            var template = _.template(ExperienciaLaboralTemplate);
            var compiledTemplate = template(data);
            $("#experiencia").html(compiledTemplate);  
        },
        events: {
            "click #mostrarExperienciaReal":"mostrarExperienciaReal",
            "click #mostrarExperienciaDocente":"mostrarExperienciaDocente"
        },
        mostrarExperienciaReal: function(){
            var data = {};
            var template = _.template(MostrarExperienciaRealTemplate);
            var compiledTemplate = template(data);
            $("#experienciacontenido").html(compiledTemplate);  
        },
        mostrarExperienciaDocente: function(){
            var data = {};
            var template = _.template(MostrarExperienciaDocenteTemplate);
            var compiledTemplate = template(data);
            $("#experienciacontenido").html(compiledTemplate);
        }

    });
    return ExperienciaLabView;
});
