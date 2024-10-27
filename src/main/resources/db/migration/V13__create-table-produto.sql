CREATE TABLE produto
(
  id SERIAL PRIMARY KEY,
  nome varchar(50) not null,
  descricao varchar(50) not null,
  preco int not null
);

