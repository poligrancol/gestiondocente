define([
    'jquery',
    'underscore',
    'backbone',
    'text!conf/URLServer.html'
], function ($, _, Backbone, URLServer) {

    var ProfesorModel = Backbone.Model.extend({
        urlRoot: URLServer,
        idAttribute: 'idProfesor',
        defaults: {
            apellido: "",
            direccion: "",
            emailPersonal: "",
            estadoCivil: "",
            numeroDocumento: "",
            lugarDeExpedicion: "",
            rh: "",
            telefonoFijo: "",
            nombre: "",
            genero: "",
            tipoDocumento: "",
            emailInstitucional: "",
            celular: ""
        },
        toViewJson: function () {
            var result = this.toJSON(); // displayName property is used to render item in the list
            result.displayName = this.get('idProfesor');
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
                    console.log('Unable to fulfil the request ' + textStatus);
                }}
            
                if (method == 'create') {
                    options.url = URLServer;
                }
                var result = Backbone.sync(method, model, _.extend(options, errorHandler));
                return result;
            }    
         });
    return ProfesorModel;
 });
   