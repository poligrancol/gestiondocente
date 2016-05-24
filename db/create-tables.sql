-----------------------------------------------------------------------------
CREATE TABLE public.profesor ( --Tabla Profesores
  id SERIAL PRIMARY KEY,
  id_profesor integer NOT NULL,
  tipo_documento text NULL,
  numero_documento integer NOT NULL,
  nombre text NOT NULL,
  apellido text NOT NULL,
  fecha_de_expedicion date NULL,
  lugar_de_expedicion text NULL,
  rh text NULL,
  id_pais_nacionalidad integer NULL,
  genero text NULL,
  id_pais_lugar_nacimiento integer NULL,
  fecha_de_nacimiento date NULL,
  id_pais_de_origen integer NULL,
  estado_civil text NULL,
  id_departamento integer NULL,
  email_personal text NULL,
  email_institucional text NOT NULL,
  telefono_fijo text NULL,
  celular integer NULL,
  direccion text NULL,
) WITH (OIDS=FALSE);

ALTER TABLE public.profesor OWNER TO gestiondocente;

-----------------------------------------------------------------------------
CREATE TABLE public.departamento ( --Tabla departamentos.
  id SERIAL PRIMARY KEY,
  id_departamento integer NOT NULL,
  descripcion text(50) NULL,
) WITH (OIDS=FALSE);

ALTER TABLE public.departamento OWNER TO gestiondocente;
