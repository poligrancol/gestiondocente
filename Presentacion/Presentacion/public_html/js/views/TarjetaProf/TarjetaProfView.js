define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/TarjetaProf/TarjetaProfTemplate.html'
], function ($, _, Backbone, TarjetaProfTemplate) {

    var TarjetaProfView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(TarjetaProfTemplate);
            var compiledTemplate = template(data);
            $("#intro").html(compiledTemplate);  
        }
    });
    return TarjetaProfView;
});
