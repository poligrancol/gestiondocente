/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
define([
    'jquery',
    'underscore',
    'backbone',
    'text!templates/ImportarNecesidad/ErrorNecesidadViewTemplate.html'
], function ($, _, Backbone, ErrorNecesidadViewTemplate) {

    var ErrorNecesidadView = Backbone.View.extend({
        render: function (accion,id) {
            var data = {};
            var template = _.template(ErrorNecesidadViewTemplate);
            var compiledTemplate = template(data);
            $("#intro").html(compiledTemplate);  
        }
    });
    return ErrorNecesidadView;
});



