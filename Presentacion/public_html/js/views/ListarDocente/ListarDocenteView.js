define([
    'jquery',
    'underscore',
    'backbone',
    '../../text!../../../../templates/ListarDocente/ListarDocenteViewTemplate.html',
    'collections/ProfesorCollection'

], function($, _, Backbone, ListarDocenteViewTemplate, ProfesorCollection) {

    var ListarDocenteView = Backbone.View.extend({
        el: '#intro',
        events: {
            'click .buscar-pr': 'filtroNombre'
                //   'click #btn-guardar': 'guardar'
        },
        render: function() {
            var that = this;
            var profesores = new ProfesorCollection();
            profesores.traerPagina(1, 4);
            profesores.fetch({
                success: function(profesores) {
                    var template = _.template(ListarDocenteViewTemplate, {
                        datas: profesores.models
                    });
                    // var compiledTemplate = template(data);
                    $("#intro").html(template);
                    $('#listar-docente-table').DataTable();
                }
            })
        },
        // guardar:function(){
        // console.log('Prueba');
        // },
        filtroNombre: function() {
            var ProfeModelo = Backbone.Model.extend({
                urlRoot: 'http://localhost:8080/Logica/webresources/profesor/buscar/',
                idAttribute: 'id',
                defaults: {
                    id: ""
                }
            });
            var ProfesorFiltrado = Backbone.Collection.extend({
                model: ProfeModelo,
                url:'http://localhost:8080/Logica/webresources/profesor/buscar',
                filrarProfe: function (param) {
                                  this.url += '/' + param;
                             }
            });


            var depto = $('#inp-busc').val();
            $('#intro').html('');
            if (depto != '') {
                console.log('Ingreso: ' + depto);
                var profes = new ProfesorFiltrado()
                profes.filrarProfe(depto)
                profes.fetch({
                        success: function(profes) {
                            var template = _.template(ListarDocenteViewTemplate, {
                                datas: profes.models
                            });
                            // var compiledTemplate = template(data);
                            $("#intro").html(template);
                            $('#listar-docente-table').DataTable();
                        }
                    });
                    // }
            }else{
            console.log('Ingreso: Parametro null');
                var profes = new ProfesorFiltrado()
                profes.filrarProfe('vacio')
                profes.fetch({
                        success: function(profes) {
                            var template = _.template(ListarDocenteViewTemplate, {
                                datas: profes.models
                            });
                            // var compiledTemplate = template(data);
                            $("#intro").html(template);
                            $('#listar-docente-table').DataTable();
                        }
                    });
            }
        }
    });
    return ListarDocenteView;
});
