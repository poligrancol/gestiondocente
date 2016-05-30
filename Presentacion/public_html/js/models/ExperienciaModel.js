define([
    'jquery',
    'underscore',
    'backbone',
    'text!conf/URLServer.html'
], function ($, _, Backbone, URLServer) {

    var ExperienciaModel = Backbone.Model.extend({
        urlRoot: URLServer+"edu.poli.prap.gd.data.experiencia",
        idAttribute: 'idExperiencia',
        defaults: {
            idProfesor: "",
            totalExperienciaDocente: "",
            totalExperienciaReal: ""
        },
        toViewJson: function () {
            var result = this.toJSON(); // displayName property is used to render item in the list
            result.displayName = this.get('idExperiencia');
            return result;
        },
        sync: function (method, model, options,id) {
            options || (options = {});
            var errorHandler = {
                error: function (jqXHR, textStatus, errorThrown) {
                    // TODO: put your error handling code here
                    // If you use the JS client from the different domain
                    // (f.e. locally) then Cross-origin resource sharing 
                    // headers has to be set on the REST server side.
                    // Otherwise the JS client has to be copied into the
                    // some (f.e. the same) Web project on the same domain
                    console.log('Unable to fulfil the request ' + textStatus);
                }}
            
                if (method == 'create') {
                    options.url = URLServer+"edu.poli.prap.gd.data.experiencia";
                }method
                if(method == 'experienciaProfesor'){
                    options.url = URLServer+"edu.poli.prap.gd.data.experiencia/prof/"+id;
                    method="read";
                }
                var result = Backbone.sync(method, model, _.extend(options, errorHandler));
                return result;
            }    
         });
    return ExperienciaModel
 });
   