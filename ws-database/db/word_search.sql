
--izvršavati jedan po jedan query

CREATE USER ws_user WITH
  PASSWORD 'ws_user'
  LOGIN
  NOSUPERUSER
  INHERIT
  CREATEDB
  NOCREATEROLE
  NOREPLICATION;
  
CREATE DATABASE word_search
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
	
--\connect word_search;
-- spojiti se na bazu word_search prije kreiranja scheme
CREATE SCHEMA ws_schema
    AUTHORIZATION postgres;

GRANT ALL ON DATABASE word_search TO ws_user;
GRANT ALL ON SCHEMA ws_schema TO ws_user;