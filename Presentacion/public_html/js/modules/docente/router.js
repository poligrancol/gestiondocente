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
    //'views/DatosBasicos/DatosBasicosView',
    //'views/Escolaridad/EscolaridadView',
    //'views/Buscar/BuscarDocente',
    'views/ExperienciaLab/ExperienciaLabView'

    // 'views/docente/lessonEndView',
    // 'views/editor/editorView',
], function ($, _, Backbone, ExperienciaLabView) {

    // Main application router.
    var AppRouter = Backbone.Router.extend({
        routes: {
            'prof/:id':'ExperienciaLaboral'
        }
    });
    var elv = new ExperienciaLabView();
    var app_router = new AppRouter();
    app_router.on ('route:ExperienciaLaboral', function(id){
        elv.render({id:id});
     });
    //elv.render();
    Backbone.history.start();
    
    var initialize = function () {};
    return {
        initialize: initialize
    };
});
