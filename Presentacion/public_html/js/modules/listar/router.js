// //
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
    'views/Buscar/BuscarDocente',
], function ($, _, Backbone, BuscarDocenteView) {

    // Main application router.
    var AppRouter = Backbone.Router.extend({
        routes: {
            '': 'renderIndex',
        }
    });

    //
    // This function is called when app is run, make sure
    // to add your routes here.
    //
    var initialize = function () {
        var app_router = new AppRouter();

        // Renders the table to search for teachers.
        //
        //      "/"
        //
        app_router.on('route:renderIndex', function (name) {

            // Renders the view.
            var findTeacherView = new BuscarDocenteView();
            findTeacherView.render();
        });

        // Have bookmarkable URLs.
        Backbone.history.start();
    };

    return {
        initialize: initialize
    };
});
