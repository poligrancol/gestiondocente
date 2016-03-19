# Gestion Docente

Repositorio para almacenar el código fuente del proyecto de práctica aplicada del 20161, Politécnico Grancolombiano. El objetivo del proyecto es la construcción de un software que permita la administración de docentes.

## Recursos

*  [¿Cómo obtener parametros GET de la URL?](http://www.concretepage.com/webservices/resteasy-3/jax-rs-defaultvalue-annotation-example-with-resteasy-3)
*  [¿Cómo crear un recurso RESTFull?](https://docs.oracle.com/cd/E19776-01/820-4867/6nga7f5n6/index.html)
*  [¿Cómo crear y recibir formas?](http://www.mastertheboss.com/jboss-frameworks/resteasy/resteasy-tutorial-part-two-web-parameters)
*  [Queries a la base de datos y persistencia](https://glassfish.java.net/javaee5/persistence/persistence-example.html)


## ¿Cómo descargar este repositorio?

Para correr este proyecto localmente debes **[clonarlo](https://help.github.com/desktop/guides/contributing/cloning-a-repository-from-github-desktop/#cloning-repositories)** y configurarlo.

1. Instalar cliente Git https://desktop.github.com/ ó usar Git desde la consola https://git-scm.com/
2. Clonar este repositorio usando [GitHub Desltop](https://desktop.github.com/) ó desde la consola.

## Creación de la base de datos

Para tener una copia de la base de datos, debes correr este comando en el terminal:

```bash
sqlcmd -S .\SQLExpress -i BaseDeDatosV0.1.sql
```

## ¿Como establecer tu nombre de usuario en Git?

GitHub ofrece muchas opciones de colaboración a los miembros de cada repositorio, es por esto que es importante que establezcas tu nombre y correo en Git de tal manera que los commits que hagas se relacionen con tu usuario en GitHub.

Para establecer tu nombre y correo en Git, abre la termanial y escribe:

```bash
git config --global user.name "Tu nombre"
git config --global user.email tu-correo-en-github@mail.com
```

Despues de esto, tus commits se relacionarán con tu usuario en GitHub.


## Mensajes de commit

* Si es necesario, puedes añadir el ID de la historia de usuario en el commit. E.G:
`MA-1 Added something...` or the Sentry issue number `#123 Fixes bug...`

* También puedes usar Emojis para iniciar los mensajes de commit.
    * :lollipop: `:lollipop:` cuando se mejora la estructura del código.
    * :art: `:art:` cuando se realizan cambios visuales.
    * :bug: `:bug:` cuando se corrigen errores.
    * :memo: `:memo:` cuando se escribe documentación.
    * :fire: `:fire:` cuando se elimina codigo que no se usa.
    * :sunny: `:sunny:` cuando se realiza una mejora en general.
    * :white_check_mark: `:white_check_mark:` cuando se trabaja con pruebas unitarias.


## Flujo de trabajo

En este proyecto usamos dos tipos de ramas (branches):

* **Branch de producción**: `master`, representa el entorno de producción, la aplicación en vivo.
* **Branches de historias de usuarios**: E.G: `experiencia-empleado`, `exportacion-profesores`, `diseno-lista-usuarios` etc. Estos branchs representan una funcionalidad especifica relacionada con historias de usuario.


Para empezar a trabajar en una nueva historia de usuario debes:

1. Crear un branch E.G: `experiencia-empleado`
2. Realizar funcionalidad y hacer commit
3. Hacer push de tu branch a GitHub
4. Crear un [Pull Request](https://help.github.com/articles/using-pull-requests/)
5. Esperar a que revise y se mezcle.


## API URLs / Backend / Aplicación GlassFish

Para hacer llamados al API localmente es necesario usar el esquema `http://localhost:8080/Logica/webresources/` y adicionar la URL de la clase fachada que queremos llamar, E.J: si hacemos un llamado a `http://localhost:8080/Logica/webresources/archivosadjuntos/` estaremos conectando con la clase `ArchivosAdjuntosFacadeREST.java`.

| URL                | Clase                                              |
| ------------------ |:--------------------------------------------------:|
| archivosadjuntos   | `gd/data/service/ArchivosAdjuntosFacadeREST.java`  |
| departamento       | `gd/data/service/DepartamentoFacadeREST.java`      |
| detalleexperiencia | `gd/data/service/DetalleExperienciaFacadeRest.java`|
| escolaridad        | `gd/data/service/EscolaridadFacadeREST.java`       |
| experiencia        | `gd/data/service/DetalleExperienciaFacadeREST.java`|
| materias           | `gd/data/service/MateriasFacadeREST.java`          |
| pais               | `gd/data/service/PaisFacadeREST.java`              |
| profesor           | `gd/data/service/ProfesorFacadeREST.java`          |
| tarjetaprofesional | `gd/data/service/TarjetaProfesionalFacadeREST.java`|
| titulo             | `gd/data/service/TituloFacadeREST.java`            |

