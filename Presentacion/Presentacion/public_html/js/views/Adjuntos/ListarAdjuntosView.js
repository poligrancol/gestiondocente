define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/Adjuntos/ListarAdjuntosTemplate.html'
], function ($, _, Backbone, ListarAdjuntosTemplate) {

    var ListarAdjuntosView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(ListarAdjuntosTemplate);
            var compiledTemplate = template(data);
            $("#adjuntos").html(compiledTemplate);  
        }
    });
    return ListarAdjuntosView;
});
