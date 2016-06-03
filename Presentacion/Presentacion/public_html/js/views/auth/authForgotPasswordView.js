define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/auth/authForgotPasswordTemplate.html'
], function($, _, Backbone, authForgotPasswordTemplate){

  var AuthForgotPasswordView = Backbone.View.extend({
    el: $("#container"),
    render: function(){

        var that = this;
        //..
        var data = {};
        var compiledTemplate = _.template( authForgotPasswordTemplate, data );
        $("#container").html(compiledTemplate);
    }

  });

  return AuthForgotPasswordView;
  
});
