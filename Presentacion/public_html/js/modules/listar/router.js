//
//  Main application file, here is where all the routes for the application
//  are defined.
//
//  To learn more about Backbone routes head over to:
//  http://codebeerstartups.com/2013/01/routers-in-backbone-js-learning-backbone-js/
//
define([
    'jquery',
    'underscore',
    'backbone',
    '../views/ListarDocente/ListarDocenteView'
], function ($, _, Backbone, ListarDocenteView) {

    // Main application router.
    var AppRouter = Backbone.Router.extend({
        routes: {
        }
    });
    var elv = new ListarDocenteView();
    elv.render();
    var app_router = new AppRouter();
    // Backbone.history.start();

    var initialize = function () {};
    return {
        initialize: initialize
    };
});