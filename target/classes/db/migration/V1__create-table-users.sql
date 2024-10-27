CREATE TABLE users
(
  id SERIAL PRIMARY KEY,
  nome varchar(50) not null,
  email varchar(50) not null UNIQUE,
  senha varchar(50) not null,
  telefone varchar(50) not null,
  endereco varchar(50) not null
);
