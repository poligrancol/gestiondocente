define([
    'jquery',
    'underscore',
    'backbone',
    'models/ProfesorModel'
], function ($, _, Backbone, ProfesorModel) {

    var ProfesorCollection = Backbone.Collection.extend({
        model: ProfesorModel,
        url:'http://localhost:8080/Logica/webresources/profesor',
        traerPagina: function (pagina, count) {
                          this.url += '/' + pagina + '/' + count;
                     }
    });
    return ProfesorCollection;
});
