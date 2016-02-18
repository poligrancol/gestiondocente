// Filename: router.js
define([
  'jquery',
  'underscore',
  'backbone',
  'views/auth/authLoginView',
  'views/auth/authChangePasswordView',
  'views/auth/authRegisterView',
  'views/auth/authForgotPasswordView',
  'views/auth/authConfirmView'
], function($, _, Backbone, AuthLoginView, AuthChangePasswordView, AuthRegisterView, AuthForgotPasswordView, AuthConfirmView) {
  
  var AppRouter = Backbone.Router.extend({
    routes: {
      // Define some URL routes
      '/login' : 'showLogin',
      '/change/:t' : 'showChangePassword',
      '/register' : 'showRegister',
      '/forgot' : 'showForgotPassword',
      '/confirm/:t' : 'showConfirm',
      
      // Default
      '*actions': 'defaultAction'
    }
  });
  
  var initialize = function(){

    var app_router = new AppRouter;

    app_router.on('route:showLogin', function () {
        var view = new AuthLoginView();
        view.render();
    });

    app_router.on('route:showChangePassword', function (t) {
        var t = t || "";
        var view = new AuthChangePasswordView();
        view.render(t);
    });

    app_router.on('route:showRegister', function () {
        var view = new AuthRegisterView();
        view.render();
    });

    app_router.on('route:showForgotPassword', function () {
        var view = new AuthForgotPasswordView();
        view.render();
    });

    app_router.on('route:showConfirm', function (t) {
        var t = t || "";
        var view = new AuthConfirmView();
        view.render(t);
    });
    
    app_router.on('route:defaultAction', function (actions) {
     
       // We have no matching route, lets display the home page 
        var homeView = new HomeView();
        homeView.render();
    });
    
    // Unlike the above, we don't call render on this view as it will handle
    // the render call internally after it loads data. Further more we load it
    // outside of an on-route function to have it loaded no matter which page is
    // loaded initially.
    var footerView = new FooterView();

    Backbone.history.start();
  };
  return { 
    initialize: initialize
  };
});
