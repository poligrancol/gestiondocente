// Filename: app.js
define([
  'jquery',
  'underscore',
  'backbone',
  'bootstrap',
  '../../listar/router'
], function($, _, Backbone, Bootstrap, Router){
  var initialize = function(){
    // Pass in our Router module and call it's initialize function
    Router.initialize();
  };

  return {
    initialize: initialize
  };
});