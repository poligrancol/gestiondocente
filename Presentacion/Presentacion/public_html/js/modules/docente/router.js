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
    'views/DatosBasicos/DatosBasicosView',
    'views/Escolaridad/EscolaridadView',
    'views/Buscar/BuscarDocente',
    // 'views/ExperienciaLab/ExperienciaLabView',
    // 'views/ExperienciaLab/EditarExperienciaLabView',
    // 'views/ExperienciaLab/CrearExperienciaLabView',
    // 'views/docente/lessonEndView',
    // 'views/editor/editorView',
], function ($, _, Backbone, DatosBasicosView, EscolaridadView, BuscarDocenteView) {

    // Main application router.
    var AppRouter = Backbone.Router.extend({
        routes: {
        }
    });

    //
    // This function is called when app is run, make sure
    // to add your routes here.
    //
    var initialize = function () {
        var app_router = new AppRouter();

        // Have bookmarkable URLs.
        Backbone.history.start();
    };

    return {
        initialize: initialize
    };
});
