define([
    'jquery',
    'underscore',
    'backbone',
    'bootstrap',
    'models/EscolaridadModel',
    'collections/EscolaridadCollection',
    'text!templates/Escolaridad/ListarEscolaridadTemplate.html',
      'text!templates/Escolaridad/EditarEscolaridadTemplate.html',
        //'text!templates/Escolaridad/ListarTecnicosTemplate.html',
        'text!templates/Escolaridad/ListarTecnologoTemplate.html'
        //'text!templates/Escolaridad/ListarProfesionalTemplate.html',
        //'text!templates/Escolaridad/ListarEspecialTemplate.html',
        //'text!templates/Escolaridad/ListarMaestriaTemplate.html',
        //'text!templates/Escolaridad/ListarDoctoradoTemplate.html'

], function ($, _, Backbone, b, EscolaridadModel, EscolaridadCollection, ListarEscolaridadTemplate, 
            EditarEscolaridadTemplate, ListarTecnologoTemplate) {

            //url: '/EscolaridadCollection '
            //DEBO USAR : "EscolaridadCollection" acá??
            
    var EscolaridadView = Backbone.View.extend({
        className: "escolaridad-section",
        //el:"#escolaridad",  NUEVA - SE PUEDE DE LAS DOS FORMAS??
        el: $("#escolaridad"),
        model: new EscolaridadModel(),
        collection: new EscolaridadCollection(),
        render: function (idDocente) {
                 if (idDocente) {
               
                this.model.set({idProfesor: idDocente});
                var that = this;
                this.collection.fetch({
                       success:function(escolaridades){
                           var arra = [];
                        _.each(escolaridades, function (usuario){
                            var template = _.template(ListarTecnologoTemplate, {model:usuario});
                            
                            arra.push(template);
                            //that.$el.html({model:escolaridades.ListarTecnologoTemplate});

                        }) 
                           
                           
                        var  comp = _.template(ListarEscolaridadTemplate);
                        //that.$el.html(comp({usuarios:'PRUEBA'}));
                        that.$el.html(comp({escolaridades:arra}));
                       } 
                    }); 
            }
            var options = {
                success: this.cargarDatos,
                error: this.errorConsulta
            };
            var  compiledTemplate = _.template(ListarEscolaridadTemplate);
                  $("#escolaridad").html(compiledTemplate);
                this.model.sync("read",this.model,options);
            this.model.set({codigoEscolaridad:1});
            this.model.fetch();
            this.cargarDatos(this.model);
        },
        events: {
            "click #dbeditarEscolaridad":"dbeditarEscolaridad"
        },
        listarEscolaridad: function (){
            var data ={};
            var template = _.template(ListarEscolaridadTemplate);
            var compiledTemplate = template(data);
            $("#escolaridadcontenido").html(compiledTemplate);
        },
        
        cargarTemplate: function (data, template) {
            var t = _.template(template);
            var compiledTemplate = t(data);
            this.$el.html(compiledTemplate);
        },
        cargarDatos: function (pmo) {
            this.cargarTemplate({model: pmo       }, ListarEscolaridadTemplate);
        },
        cargarEditar: function () {
            this.cargarTemplate({model: this.model}, EditarEscolaridadTemplate);
        },
        errorConsulta: function (e) {
            console.log(e);
        },
        events: {
            "click #dbeditarEcolaridad": "editarEscolaridad"
        },
        editarEscolaridad : function(){
            console.log('cargar editar datos');
            this.cargarEditar();
        }, 
    });
    return EscolaridadView;
});
