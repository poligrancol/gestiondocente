// Filename: router.js
define([
    'jquery',
    'underscore',
    'backbone',
    'views/DatosBasicos/DatosBasicosView',
    'views/Escolaridad/EscolaridadView',
    /*'views/Buscar/BuscarDocente',
    'views/ExperienciaLab/ExperienciaLabView',
    'views/ExperienciaLab/EditarExperienciaLabView',
    'views/ExperienciaLab/CrearExperienciaLabView'
            /*'views/docente/lessonEndView'*/
            // 'views/editor/editorView'
], function ($, _, Backbone, DatosBasicosView, EscolaridadView) {

    var AppRouter = Backbone.Router.extend({
        routes: {
            // Define some URL routes
            //':id': 'show',
            //'': 'default'
        }
    });

    var initialize = function () {
        var app_router = new AppRouter;
        var id = 1;
        //var id = #sacar de la sesion
        var datosBasicosView = new DatosBasicosView();
        datosBasicosView.render(id);
        
        var escolaridadView = new EscolaridadView();
        escolaridadView.render();
        
//
        //
//var buscarDocenteView = new BuscarDocenteView();
        //buscarDocenteView.render();
        /*
         * 
         var experienciaView = new ExperienciaView();
         experienciaView.render();
         */
        //app_router.on('route:show', function (id) {
        //    datosBasicosView.render(id);
        //});
    }

    return {
        initialize: initialize
    };
});
