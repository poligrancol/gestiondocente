/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ImportarNecesidad/NecesidadViewTemplate.html'
], function ($, _, Backbone, NecesidadViewTemplate) {

    var NecesidadView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(NecesidadViewTemplate);
            var compiledTemplate = template(data);
            $("#intro").html(compiledTemplate);  
        }
    });
    return NecesidadView;
});


