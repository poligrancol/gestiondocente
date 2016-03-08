//
// Main.js
//
require.config({
  baseUrl: "../../js",
  shim : {
    'bootstrap' : { 'deps' :['jquery'] }
  },
  paths: {
    bootstrap: 'libs/lesson/bootstrap.min.js',
    jquery: 'libs/jquery/jquery-2.1.3.min',
    underscore: 'libs/underscore/underscore-min',
    backbone: 'libs/backbone/backbone-min',
    templates: '../templates'
  }

});

require([
  // Load our app module and pass it to our definition function
  'modules/buscar/app'

], function(App) {

  // Call initialize method from `app.js`.
  App.initialize();

});
