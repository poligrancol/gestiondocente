define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/Adjuntos/AdjuntosTemplate.html'
], function ($, _, Backbone, AdjuntosTemplate) {

    var AdjuntosView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(AdjuntosTemplate);
            var compiledTemplate = template(data);
            $("#intro").html(compiledTemplate);  
        }
    });
    return AdjuntosView;
});
