define([
    'jquery',
    'underscore',
    'backbone',
    'models/ProfesorModel',
    'text!templates/docente/ListarDatosBasicosTemplate.html',
    'text!templates/docente/EditarDatosBasicosTemplate.html',
], function ($, _, Backbone,  ProfesorModel, ListarDatosBasicosTemplate, EditarDatosBasicosTemplate) {

    var DatosBasicosView = Backbone.View.extend({
        className: "intro-section",
        el: $("#intro"),
        model: new ProfesorModel(),
        render: function (id) {
            //id = id || require("id");
            if(id){
                this.model.set({idProfesor:id});
            }
            var that = this;
            var options = {
                success: function(pmo){
                    that.cargarTemplate({model: pmo}, ListarDatosBasicosTemplate);
                },
                error:this.errorConsulta
            };
            this.model.sync("read",this.model,options);

        },
        cargarEditar: function(){
            this.cargarTemplate({model: this.model}, EditarDatosBasicosTemplate);
        },
        cargarTemplate: function(data, template){
            var t = _.template(template);
            var compiledTemplate = t(data);
            this.$el.html(compiledTemplate);
        },
        errorConsulta: function(e){
            console.log(e);
        },
        events: {
            "click #dbeditarimagen"  : "editarImagen",
            "click #dbguardarimagen" : "almacenarImagen",
            "click #dbeditardatos"   : "editarDatosBasicos",
            "click #dbguardardatos"  : "almacenarDatosBasicos",
        },
        editarImagen : function(){
            console.log('cargar editar imagen');
        },
        almacenarImagen : function(){
            alert('Imagen almacenada.');
        },
        editarDatosBasicos : function(){
            console.log('cargar editar datos');
            this.cargarEditar();
        },
        almacenarDatosBasicos : function(){
            //this.model.sync("save",this.model,options);
            alert('Datos almacenados.');
        }
    });
    return DatosBasicosView;
});
