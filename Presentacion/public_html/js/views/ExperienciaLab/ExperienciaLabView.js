define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ExperienciaLab/ExperienciaLaboralTemplate.html',
    'text!templates/ExperienciaLab/MostrarExperienciaRealTemplate.html',
    'text!templates/ExperienciaLab/MostrarExperienciaDocenteTemplate.html',
    'text!templates/ExperienciaLab/AgregarExperienciaDocenteTemplate.html',
    'text!templates/ExperienciaLab/AgregarExperienciaRealTemplate.html'

], function ($, _, Backbone, ExperienciaLaboralTemplate, MostrarExperienciaRealTemplate, MostrarExperienciaDocenteTemplate, AgregarExperienciaDocenteTemplate, AgregarExperienciaRealTemplate) {

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
            "click #mostrarExperienciaDocente":"mostrarExperienciaDocente",
            "click #agregarexperienciadocente":"agregarExperienciaDocente",
            "click #agregarexperienciareal":"agregarExperienciaReal",
            "click #editarexperienciareal":"editarExperienciaReal"
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
        },
        agregarExperienciaDocente: function(){
            var data = {};
            var template = _.template(AgregarExperienciaDocenteTemplate);
            var compiledTemplate = template(data);
            $("#experienciacontenido").html(compiledTemplate);
        },
        agregarExperienciaReal: function(){
            var data = {};
            var template = _.template(AgregarExperienciaRealTemplate);
            var compiledTemplate = template(data);
            $("#experienciacontenido").html(compiledTemplate);
        },
        editarExperienciaReal: function(){
            var data = {};
            var template = _.template(AgregarExperienciaRealTemplate);
            var compiledTemplate = template(data);
            $("#experienciarealcontenido").html(compiledTemplate);
        }

    });
    return ExperienciaLabView;
});
