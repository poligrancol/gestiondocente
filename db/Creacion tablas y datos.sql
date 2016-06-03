-----------------------------------------------------------------------------
--Tabla Profesores
CREATE TABLE public.profesor (
	id SERIAL					PRIMARY KEY,
	id_profesor					integer NOT NULL,
	tipo_documento				text NULL,
	numero_documento			number NOT NULL,
	nombre						text NOT NULL,
	apellido					text NOT NULL,
	fecha_de_expedicion			date NULL,
	lugar_de_expedicion			text NULL,
	rh							text NULL,
	id_pais_nacionalidad		integer NULL,
	genero						text NULL,
	id_pais_lugar_nacimiento 	integer NULL,
	fecha_de_nacimiento 		date NULL,
	id_pais_de_origen 			integer NULL,
	estado_civil 				text NULL,
	id_departamento 			integer NULL,
	email_personal 				text NULL,
	email_institucional 		text NOT NULL,
	telefono_fijo 				text NULL,
	celular						number NULL,
	direccion					text NULL
) WITH (OIDS = FALSE);

ALTER TABLE public.profesor OWNER TO gestiondocente;

-----------------------------------------------------------------------------
--Tabla departamentos.

CREATE TABLE public.departamento (
	id SERIAL	 		PRIMARY KEY,
	id_departamento		INTEGER NOT NULL,
	descripcion 		TEXT NULL
) WITH (OIDS = FALSE);

ALTER TABLE public.departamento OWNER TO gestiondocente;

-----------------------------------------------------------------------------
--Datos profesor

INSERT INTO profesor("id_profesor", "tipo_documento", "numero_documento", "nombre", "apellido", "fecha_de_expedicion", "lugar_de_expedicion", "rh", "id_pais_nacionalidad", "genero", "id_pais_lugar_nacimiento", "fecha_de_nacimiento", "id_pais_de_origen", "estado_civil", "id_departamento", "email_personal", "email_institucional", "telefono_fijo", "celular", "direccion")
     VALUES		(1, 'CC', 40683395,  'David', 'Wiltse',   null, 'Bogota D.C.', 'A+', 1, 'Hombre', 1, null, 1, 'Casado',  25, 'DavidSWiltse@armyspy.com', 'dawiltse@poligran.edu.co',   '7584169', 3159387633, 'Av. Carrera 45  108-27'),
				(2, 'CC', 103628969, 'Amy',   'Martinez', null, 'Bogota D.C.', 'O',  1, 'Mujer',  1, null, 1, 'Soltera', 25, 'AmyMMartinez@dayrep.com',  'ammartinez@poligran.edu.co', '9841773', 9331586422, 'Calle Santo del Sane o. 461'),
				(3, 'CC', 1032453788,'Diego', 'Rodriguez',null, 'Bogota D.C.', 'A-', 1, 'Hombre', 1, null, 1, 'Soltero', 25, 'bnedmundob13@yopmail.com', 'dirodriguez@poligran.edu.co','2334315', 3152334315, 'Avenida Chiapas o. 555'),
				(4, 'CC', 56752025,  'Clara', 'Alvarez',  null, 'Bogota D.C.', 'A+', 1, 'Mujer',  1, null, 1, 'Casada',  25, 'ghiftode7@yopmail.com',    'clalverez@poligran.edu.co',  '4552570', 3154552570, 'Bulevar Renilla o. 693'),
				(5, 'CC', 104488309, 'Noel',  'Sequedo',  null, 'Bogota D.C.', 'AB', 1, 'Hombre', 1, null, 1, 'Soltero', 25, 'gmnoeli12@yopmail.com',    'nosequedo@poligran.edu.co',  '0997645', 3150997645, 'Avenida Baleares o. 870')

-----------------------------------------------------------------------------
--Datos departamento

INSERT INTO departamento("id_departamento", "descripcion")
     VALUES		(5, 'Antioquia'),
				(8, 'Atlantico'),
				(11, 'BogotaDC'),
				(13, 'Bolivar'),
				(15, 'Boyaca'),
				(17, 'Caldas'),
				(18, 'Caqueta'),
				(19, 'Cauca'),
				(20, 'Cesar'),
				(23, 'Cordoba'),
				(25, 'Cundinamarca'),
				(27, 'Choco'),
				(41, 'Huila'),
				(44, 'La_Guajira'),
				(47, 'Magdalena'),
				(50, 'Meta'),
				(52, 'Narino'),
				(54, 'Norte_de_Santander'),
				(63, 'Quindio'),
				(66, 'Risaralda'),
				(68, 'Santander'),
				(70, 'Sucre'),
				(73, 'Tolima'),
				(76, 'Valle_del_Cauca'),
				(81, 'Arauca'),
				(85, 'Casanare'),
				(86, 'Putumayo'),
				(88, 'San_Andres'),
				(91, 'Amazonas'),
				(94, 'Guainia'),
				(95, 'Guaviare'),
				(97, 'Vaupes'),
				(99, 'Vichada')
