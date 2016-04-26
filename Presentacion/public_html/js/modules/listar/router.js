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
    'views/ListarDocente/ListarDocenteView',
], function ($, _, Backbone, ListarDocenteView) {

    // Main application router.
    var AppRouter = Backbone.Router.extend({
        routes: {
            'buscar-docente': 'findTeacher',
        }
    });

    //
    // This function is called when app is run, make sure
    // to add your routes here.
    //
    var initialize = function () {
        var app_router = new AppRouter();

        // Find a teacher and renders the results template.
        //
        //      /#buscar-docente/
        //
        app_router.on('route:findTeacher', function (name) {

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
