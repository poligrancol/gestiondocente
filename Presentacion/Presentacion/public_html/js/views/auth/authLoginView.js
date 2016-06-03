define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/auth/authLoginTemplate.html'
], function($, _, Backbone, authLoginTemplate){

  var AuthLoginView = Backbone.View.extend({
    el: $("#container"),
    render: function(){

        var that = this;
        //..
        var data = {};
        var compiledTemplate = _.template( authLoginTemplate, data );
        $("#container").html(compiledTemplate);
    }

  });

  return AuthLoginView;
  
});
