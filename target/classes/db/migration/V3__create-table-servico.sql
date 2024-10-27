CREATE TABLE servico
(
  id SERIAL PRIMARY KEY,
  nome varchar(50) not null,
  descricao varchar(50) not null,
  preco int not null
);
