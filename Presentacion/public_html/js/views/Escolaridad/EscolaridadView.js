define([
    'jquery',
    'underscore',
    'backbone',
    'models/EscolaridadModel',
    'collections/EscolaridadCollection',
    'text!templates/Escolaridad/ListarEscolaridadTemplate.html',
    'text!templates/Escolaridad/EditarEscolaridadTemplate.html',
    'text!templates/Escolaridad/AdjuntarDiplomaTemplate.html',
    'text!templates/Escolaridad/NuevaEscolaridadTemplate.html'      
], 

function ($, _, Backbone, EscolaridadModel, EscolaridadCollection, ListarEscolaridadTemplate, EditarEscolaridadTemplate, AdjuntarDiplomaTemplate, NuevaEscolaridadTemplate) {

    var EscolaridadView = Backbone.View.extend({
        className: "escolaridad-section",
        el: $("#escolaridad"),
        model: new EscolaridadModel(),
        collection: new EscolaridadCollection(),
        render: function (idDocente) {
            if (idDocente) {
                //this.model.set({idProfesor: id});
            }
            var options = {
                success: this.cargarDatos,
                error: this.errorConsulta
            };
            //this.model.sync("read",this.model,options);
            this.cargarDatos(this.model);
        },
          
           
        cargarTemplate: function (data, template) {
            var t = _.template(template);
            var compiledTemplate = t(data);
            this.$el.html(compiledTemplate);
        },
        
        cargarDatos: function (pmo) {
            this.cargarTemplate({model: pmo}, ListarEscolaridadTemplate);
        },
        
        cargarEditar: function () {
            this.cargarTemplate({model: this.model}, EditarEscolaridadTemplate);
        },   
        
        cargarAdjuntarDip: function () {
            this.cargarTemplate({model: this.model}, AdjuntarDiplomaTemplate);
        },
             
        cargarNuevaEsco: function () {
            this.cargarTemplate({model: this.model}, NuevaEscolaridadTemplate);
        },
                
                
        errorConsulta: function (e) {
            console.log(e);
        },   
        
        editarEscolaridad : function(){
            console.log('cargar editar datos');
            this.cargarEditar();
        },
        adjuntarDiploma : function(){
            console.log('adjuntar diploma');
            this.cargarAdjuntarDip();
        },
        nuevaEscolaridad : function(){
            console.log('cargar nueva escolaridad');
            this.cargarNuevaEsco();
        },
        
        
        events: {
            "click #dbeditarEcolaridad": "editarEscolaridad",
            "click #dbnuevaEscolaridad": "adjuntarDiploma",
            "click #adjuntarDiploma": "nuevaEscolaridad"
        },
        
        guardarEscolaridad: function(){
            
            var escolaridad = new EscolaridadModel;
            escolaridad.set(("titulo").value,
            ("institucion").value,
            ("nivel").value,      
            ("facultad").value,
            ("anos").value,
            ("fechaDeInicio").value,
            ("fechaGrado").value,
            ("convalidado").value,
            ("estadoEstudio").value);
            escolaridad.sync();
                
        }
        
    });
    return EscolaridadView;
});
