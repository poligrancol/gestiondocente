define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ExperienciaLab/ExperienciaLaboralTemplate.html',
    'text!templates/ExperienciaLab/MostrarExperienciaRealTemplate.html',
    'text!templates/ExperienciaLab/MostrarExperienciaDocenteTemplate.html',
    'text!templates/ExperienciaLab/AgregarExperienciaDocenteTemplate.html',
    'text!templates/ExperienciaLab/AgregarExperienciaRealTemplate.html',
    'models/ExperienciaModel',
    'models/ExperienciaRealModel'

], function ($, _, Backbone, ExperienciaLaboralTemplate, MostrarExperienciaRealTemplate, MostrarExperienciaDocenteTemplate, AgregarExperienciaDocenteTemplate, AgregarExperienciaRealTemplate, ExperienciaModel, ExperienciaRealModel) {
    var idGlobal;
    var ExperienciaLabView = Backbone.View.extend({
        el:"#experiencia",
        experienciaModel : new ExperienciaModel(),
        render: function (options) {
            if(options.id){
                idGlobal = options;
                this.experienciaModel.set({idProfesor:options.id});
                this.experienciaModel.sync('experienciaProfesor',this.experienciaModel,{success:function(obj){
                var data = {exper:obj[0]};
                var template = _.template(ExperienciaLaboralTemplate);
                var compiledTemplate = template(data);
                $("#experiencia").html(compiledTemplate);
            
            }},options.id);
            };
        },
        events: {
            "click #mostrarExperienciaReal":"mostrarExperienciaReal",
            "click #mostrarExperienciaDocente":"mostrarExperienciaDocente",
            "click #agregarexperienciadocente":"agregarExperienciaDocente",
            "click #agregarexperienciareal":"agregarExperienciaReal",
            "click #editarexperienciareal":"editarExperienciaReal"
        },
        experienciaRealModel : new ExperienciaRealModel,
        mostrarExperienciaReal: function(){
            this.experienciaRealModel.set({idExperiencia:idGlobal.id});
            this.experienciaRealModel.sync('experienciareal',this.experienciaRealModel,{success:function(obj){
            var arreglo = _.toArray(obj);
            //_.each(prueba, function(name,i){
                //if(i+1 < prueba.length){
                //console.log(prueba[i+1].fechaFin);
            //}
            //});
            var data = {real:arreglo};
                var template = _.template(MostrarExperienciaRealTemplate);
                var compiledTemplate = template(data);
                $("#experienciacontenido").html(compiledTemplate); 
            }},idGlobal.id);
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
