/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ImportarNecesidad/ConfirmarNecesidadViewTemplate.html'
], function ($, _, Backbone, ConfirmarNecesidadViewTemplate) {

    var ConfirmarNecesidadView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(ConfirmarNecesidadViewTemplate);
            var compiledTemplate = template(data);
            $("#intro").html(compiledTemplate);  
        }
    });
    return ConfirmarNecesidadView;
});



