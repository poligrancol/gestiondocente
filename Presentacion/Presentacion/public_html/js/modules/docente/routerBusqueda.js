define([
  'jquery',
  'underscore',
  'backbone',
  'views/Buscar/BuscarDocente'

 // 'views/editor/editorView'
], function($, _, Backbone, BuscarDocenteView ) {
  
  var AppRouter = Backbone.Router.extend({
    routes: {
      // Define some URL routes
      ':seccion/:accion/:id'   : 'show',
      '' : 'default'
    }
  });
  
  var initialize = function(){
    var app_router = new AppRouter;
  
        var buscarDocenteView = new BuscarDocenteView();
    buscarDocenteView.render();
    
    app_router.on('route:show', function(seccion,accion,id){
        //else if
        //view.render(idCategory,idLesson);
            if (seccion === "buscardocente")
            {
                buscarDocenteView.render(accion,id);
            }            
    });
    Backbone.history.start();
  };
  return { 
    initialize: initialize
  };  
});        
