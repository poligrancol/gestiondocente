
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
    'models/ExperienciaRealModel',
    'models/ExperienciaDocenteModel'

], function ($, _, Backbone, ExperienciaLaboralTemplate, MostrarExperienciaRealTemplate, MostrarExperienciaDocenteTemplate, AgregarExperienciaDocenteTemplate, AgregarExperienciaRealTemplate, ExperienciaModel, ExperienciaRealModel, ExperienciaDocenteModel) {
    var idGlobal;
    var ExperienciaGlobal;
    var countExperienciaDocente;
    var countExperienciaReal;
    var ExperienciaLabView = Backbone.View.extend({
        el:"#experiencia",
        experienciaModel : new ExperienciaModel(),
        render: function (options) {
            if(options.id){
                idGlobal = options;
                this.experienciaModel.set({idProfesor:options.id});
                this.experienciaModel.sync('experienciaProfesor',this.experienciaModel,{success:function(obj){
                ExperienciaGlobal = obj[0];
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
            "click #editarexperienciareal":"editarExperienciaReal",
            "click #crearexperienciadocente":"crearExperienciaDocente",
            "click #crearexperienciareal":"crearExperienciaReal"
        },
        experienciaRealModel : new ExperienciaRealModel(),
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
        experienciaDocenteModel: new ExperienciaDocenteModel(),
        mostrarExperienciaDocente: function(){
            this.experienciaDocenteModel.set({idExperiencia:idGlobal.id});
            this.experienciaDocenteModel.sync('experienciadocente',this.experienciaRealModel,{success:function(obj){
            var arreglo = _.toArray(obj);
            var data = {docente:arreglo};
            var template = _.template(MostrarExperienciaDocenteTemplate);
            var compiledTemplate = template(data);
            $("#experienciacontenido").html(compiledTemplate);
            }},idGlobal.id);
        },
        nuevaExperienciaDocente: new ExperienciaDocenteModel(),
        agregarExperienciaDocente: function(){
            this.nuevaExperienciaDocente.sync('countexperienciadocente',this.experienciaRealModel,{success:function(obj){
            countExperienciaDocente = obj;
            var data = {};
            var template = _.template(AgregarExperienciaDocenteTemplate);
            var compiledTemplate = template(data);
            $("#experienciacontenido").html(compiledTemplate);
            }},idGlobal.id);
        },
        crearExperienciaDocente: function(){
            //var entero = Number(idGlobal.id);
            var experienciaDocenteNew = new ExperienciaDocenteModel();
            experienciaDocenteNew.set({tipoDocente:$('#inputTipoDocente').val(), universidad:$('#inputUniversidad').val(), ciudad:$('#inputCiudad').val(), idExperiencia:ExperienciaGlobal.idExperiencia});
            experienciaDocenteNew.save(experienciaDocenteNew,{
                    success : function(){
                        console.log("Guardo");
                    },
                    error: function(error){
                        console.log(error);
                    }
                   });
        },
        nuevaExperienciaReal: new ExperienciaRealModel,
        agregarExperienciaReal: function(){
            this.nuevaExperienciaReal.sync('countexperienciareal',this.experienciaRealModel,{success:function(obj){
            countExperienciaReal = obj;
            var data = {};
            var template = _.template(AgregarExperienciaRealTemplate);
            var compiledTemplate = template(data);
            $("#experienciacontenido").html(compiledTemplate);
            }},idGlobal.id);
        },
        crearExperienciaReal: function(){
            var entero = parseInt(idGlobal.id);
            this.nuevaExperienciaReal.set({idExperiencia: entero, 
            area: $('#inputArea').val(),
            cargo: $('#inputCargo').val(),
            ciudad: $('#inputCiudad').val(),
            fechaInicio: $('#inputFechaInicio').val(),
            fechaFin: $('#inputFechaFin').val(),
            nombreEmpresa: $('#inputNombreEmpresa').val()
            });
            this.nuevaExperienciaReal.save(this.nuevaExperienciaReal, {
                    success : function(){
                        this.render(idGlobal);
                    },
                    error: function(error){
                        console.log(error);
                    }
                   });
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
