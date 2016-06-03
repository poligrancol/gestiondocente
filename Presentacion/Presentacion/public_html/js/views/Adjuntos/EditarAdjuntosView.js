define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/Adjuntos/EditarAdjuntosTemplate.html'
], function ($, _, Backbone, EditarAdjuntosTemplate) {

    var EditarAdjuntosView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(EditarAdjuntosTemplate);
            var compiledTemplate = template(data);
            $("#adjuntos").html(compiledTemplate);  
        }
    });
    return EditarAdjuntosView;
});