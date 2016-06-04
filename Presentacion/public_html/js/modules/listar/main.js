
// Author: Thomas Davis <thomasalwyndavis@gmail.com>
// Filename: main.js

// Require.js allows us to configure shortcut alias
// Their usage will become more apparent futher along in the tutorial.
requirejs.config({
  baseUrl: "../../js/libs/",
  shim : {
    'bootstrap' : { 'deps' :['jquery'] },
    'datatable' : { 'deps' :['jquery'] },
    'datatableBootstrap' : { 'deps' :['jquery', 'datatable'] }
  },
  paths: {
    jquery: 'jquery/jquery-2.1.3.min',
    bootstrap: 'bootstrap/bootstrap.min',
    underscore: 'underscore/underscore-min',
    backbone: 'backbone/backbone-min',
    templates: '../templates/',
    collections: '../collections/',
    models: '../models/',
    text: '../text',
    datatable: 'dataTables/datatables.min.js',
    datatableBootstrap: 'dataTables/dataTables.bootstrap.min.js'
  }

});

require([
  // Load our app module and pass it to our definition function
  'jquery',
  '../modules/listar/app'

], function($,App){
  // The "app" dependency is passed in as "App"
  // Again, the other dependencies passed in are not "AMD" therefore don't pass a parameter to this function
  App.initialize();
});
