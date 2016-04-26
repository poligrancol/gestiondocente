define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ListarDocente/ListarDocenteViewTemplate.html'
], function($, _, Backbone, ListarDocenteViewTemplate) {

    var Profesor = Backbone.Model.extend({
        urlRoot: '/models'

    });
    var ListarDocenteView = Backbone.View.extend({
        el: $("#table-user"),
        render: function() {
                var data = {};
                var template = _.template(ListarDocenteViewTemplate);
                var compiledTemplate = template(data);
                $("#table-user").html(compiledTemplate);
        },


        events: {
            "click #editarTrajetaProfesional": "Editar",
            "click #guardarCambios": "Guardar",
            "click #agregarTarjeta": "Agregar"
        },

        Editar: function() {
            console.log("entro a la funcion Editar...");
            this.render("edit");
        },
        Guardar: function() {
            this.render("view");
            var tarjetaProfesional = new TarjetaProfesional();
            tarjetaProfesional.set({ numDocProfesional: "inputNumDoc", lugardeExpedicion: "inputLugarExpedicion", documentoProfesional: "tipoDocumento" });
            tarjetaProfesional.save({
                succes: function(tarjetaProfrsional) {
                    console.log(tarjetaProfrsional)
                }
            });
        },
        Agregar: function() {

            console.log("entro a la funcion Agregar...");
        }
    });
    return ListarDocenteView;
});
