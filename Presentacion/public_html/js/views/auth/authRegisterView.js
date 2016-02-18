define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/auth/authRegisterTemplate.html'
], function($, _, Backbone, authRegisterTemplate){

  var AuthRegisterView = Backbone.View.extend({
    el: $("#container"),
    render: function(){

        var that = this;
        //..
        var data = {};
        var compiledTemplate = _.template( authRegisterTemplate, data );
        $("#container").html(compiledTemplate);
    }

  });

  return AuthRegisterView;
  
});
