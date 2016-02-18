define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/Adjuntos/CrearAdjuntosTemplate.html'
], function ($, _, Backbone, CrearAdjuntosTemplate) {

    var CrearAdjuntosView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(CrearAdjuntosTemplate);
            var compiledTemplate = template(data);
            $("#adjuntos").html(compiledTemplate);  
        }
    });
    return CrearAdjuntosView;
});
