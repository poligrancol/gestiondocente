define([
    'jquery',
    'underscore',
    'backbone',
    'models/EscolaridadModel',
    'collections/EscolaridadCollection',
    'text!templates/Escolaridad/ListarEscolaridadTemplate.html',
    'text!templates/Escolaridad/EditarEscolaridadTemplate.html',
], function ($, _, Backbone, EscolaridadModel, EscolaridadCollection, ListarEscolaridadTemplate, EditarEscolaridadTemplate) {

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
            this.model.set({codigoEscolaridad:1});
            this.model.fetch();
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
