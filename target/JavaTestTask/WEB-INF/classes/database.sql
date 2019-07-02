-- Database: TestJavaProject

CREATE DATABASE TestJavaProject
  WITH OWNER = "user";

-- Create tables

CREATE TABLE characters
(
  id serial NOT NULL,
  name character varying(255),
  status character varying(255),
  species character varying(255),
  gender character varying(255),
  image character varying(255),
  url character varying(255),
    CONSTRAINT "charactersPK" PRIMARY KEY (id)
);




