--Creacion del Rol
--password=123456
CREATE ROLE gestiondocente LOGIN ENCRYPTED PASSWORD 'md5b408f1d39791937bdf4e67befcab82fc'
  SUPERUSER CREATEDB CREATEROLE REPLICATION
   VALID UNTIL 'infinity';

-- Creacion de la base de datos
CREATE DATABASE gestiondocente
  WITH OWNER = postgres

