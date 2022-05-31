CREATE DATABASE dbsellart;

USE dbsellart;

CREATE TABLE funcionario (
  id      		int 			AUTO_INCREMENT,
  nome 			varchar(100) 	NOT NULL,
  CPF       	int     (11) 	NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE prodarte (
        id_obra            int             AUTO_INCREMENT,
        obra              varchar(100)     NOT NULL,
        material          varchar(200)    NOT NULL,
        artista           varchar(300)    NOT NULL,
        ano               int             NOT NULL,
        valor             float           NOT NULL,
        PRIMARY KEY (id_obra)

);