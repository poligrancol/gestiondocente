define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/Busqueda/BuscarDocenteViewTemplate.html'
], function ($, _, Backbone, BuscarDocenteViewTemplate) {

    var BuscarDocenteView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(BuscarDocenteViewTemplate);
            var compiledTemplate = template(data);
            $("#intro").html(compiledTemplate);  
        }
    });
    return BuscarDocenteView;
});
