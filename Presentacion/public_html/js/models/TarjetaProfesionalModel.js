/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


define([
    'jquery',
    'underscore',
    'backbone',
], function ($, _, Backbone) {

    var TarjetaProfesionalModel = Backbone.Model.extend({
        urlRoot: "http://localhost:8080/Logica/webresources/entities.tarjetaprofesional/",
        idAttribute: 'numDocProfesional',
        defaults: {
            lugardeExpedicion: "",
            documentoProfesional: ""
        },
        toViewJson: function () {
            var result = this.toJSON(); // displayName property is used to render item in the list
            result.displayName = this.get('numDocProfesional');
            return result;
        },
        sync: function (method, model, options) {
            options || (options = {});
            var errorHandler = {
                error: function (jqXHR, textStatus, errorThrown) {
                    // TODO: put your error handling code here
                    // If you use the JS client from the different domain
                    // (f.e. locally) then Cross-origin resource sharing 
                    // headers has to be set on the REST server side.
                    // Otherwise the JS client has to be copied into the
                    // some (f.e. the same) Web project on the same domain
                    alert('Unable to fulfil the request');
                }}
            
            if (method == 'create') {
                options.url = 'http://localhost:8080/Logica/webresources/entities.tarjetaprofesional/';
            }
            var result = Backbone.sync(method, model, _.extend(options, errorHandler));
            return result;
        }
    });
    return TarjetaProfesionalModel;
 });

