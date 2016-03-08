// Author: Thomas Davis <thomasalwyndavis@gmail.com>
// Filename: main.js

// Require.js allows us to configure shortcut alias
// Their usage will become more apparent futher along in the tutorial.
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
  'modules/docente/app'

], function(App){
  // The "app" dependency is passed in as "App"
  // Again, the other dependencies passed in are not "AMD" therefore don't pass a parameter to this function
  App.initialize();
});
