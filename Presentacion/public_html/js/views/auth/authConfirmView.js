define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/auth/authConfirmTemplate.html'
], function($, _, Backbone, authConfirmTemplate){

  var AuthConfirmView = Backbone.View.extend({
    el: $("#container"),
    render: function(t){

        var that = this;
        //..
        var data = {};
        var compiledTemplate = _.template( authConfirmTemplate, data );
        $("#container").html(compiledTemplate);
    }

  });

  return AuthConfirmView;
  
});
