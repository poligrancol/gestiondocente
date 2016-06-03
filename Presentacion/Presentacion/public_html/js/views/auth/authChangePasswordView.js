define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/auth/authChangePasswordTemplate.html'
], function($, _, Backbone, authChangePasswordTemplate){

  var AuthChangePasswordView = Backbone.View.extend({
    el: $("#container"),
    render: function(t){

        var that = this;
        //..
        var data = {};
        var compiledTemplate = _.template( authChangePasswordTemplate, data );
        $("#container").html(compiledTemplate);
    }

  });

  return AuthChangePasswordView;
  
});
