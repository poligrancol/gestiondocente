// //
//  Main file for each module. Here is where all the routes for the module
//  are defined.
//
//  To learn more about Backbone routes head over to:
//  http://codebeerstartups.com/2013/01/routers-in-backbone-js-learning-backbone-js/
//
define([
  'jquery',
  'underscore',
  'backbone',

  //
  // This line requests router.js which contains
  // the routes for this module.
  'modules/buscar/router'
], function($, _, Backbone, Router) {
  var initialize = function() {

    // Pass in our Router module and call it's initialize function.
    Router.initialize();
  };

  return {
    initialize: initialize
  };

});
